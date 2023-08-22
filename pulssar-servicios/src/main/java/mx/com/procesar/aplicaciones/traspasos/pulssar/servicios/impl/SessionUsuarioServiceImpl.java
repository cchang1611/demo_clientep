package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SessionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SessionUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de Sesion Usuario
 * 
 * @author dbarbosa
 *
 */
@Service
public class SessionUsuarioServiceImpl implements SessionUsuarioService {
	
	/**
	 * Logger
	 */
	protected static final Logger logger = LoggerFactory.getLogger(SessionUsuarioServiceImpl.class);
	
	/**
	 * uriComunes
	 */
	@Value("${uri.comunes}")
	protected String uriComunes;
	
	/**
	 * url comunes transaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String urlComunesTransaccional;
	
	/**
	 * utileria
	 * 
	 * @param peticion
	 */
	@Autowired
	protected RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * Utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Utileria
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SessionUsuario obtenerUsuarioSesion(String usuario) {
		SessionUsuario sesionActual = null;
		try {
			String uri = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, ServiciosConstants.URL_CONSULTA_SESION_USUARIO);
			logger.error("La ruta de la peticion es: {}", uri);
			
			SessionUsuario usuarioLogueado = new SessionUsuario();
			usuarioLogueado.setUsuario(usuario);
			SessionUsuario sesion = restServiceClientUtils.ejecutarServicioPost(uri, usuarioLogueado, SessionUsuario.class);
			if (!utileriaValidador.validarObjetoNulo(sesion) && !utileriaValidador.validarObjetoNulo(sesion.getIdentificadorUserComparador())){
				sesionActual = sesion;
			}
		} catch (Exception e) {
			logger.error("Error al obtener Usuario Session ", e);
		}
		return sesionActual;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer validarSesionActivaUsuario(String usuario) {
		Integer flujoNuevo = ActivacionConstants.UNO;
		try {
			String uri = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, ServiciosConstants.URL_CONSULTA_SESION_USUARIO);
			logger.error("La ruta de la peticion es: {}", uri);
			SessionUsuario usuarioLogueado = new SessionUsuario();
			usuarioLogueado.setUsuario(usuario);
			SessionUsuario sesion = restServiceClientUtils.ejecutarServicioPost(uri, usuarioLogueado, SessionUsuario.class);
			if (!utileriaValidador.validarObjetoNulo(sesion) && !utileriaValidador.validarObjetoNulo(sesion.getIdentificadorUserComparador())){
				Date fecha = Calendar.getInstance().getTime();
				String diferencia = utileriaFecha.diferenciaMinutos(sesion.getFechaSesionActiva(), fecha);
				Integer minutos = Integer.parseInt(diferencia);
				if(minutos.intValue() >= ActivacionConstants.CERO) {
					flujoNuevo = ActivacionConstants.DOS;
				} else {
					flujoNuevo = ActivacionConstants.TRES;
				}
			}
		} catch (Exception e) {
			logger.error("Error al invocar el servicio de sesion ", e);
		}
		return flujoNuevo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long guardarInformacionSesion(int flujo, String usuario, String sesionId) {
		SessionUsuario id = null;
		try {
			String uriSave = utileriaCadena.obtenerCadenaConcatenada(true, urlComunesTransaccional, ServiciosConstants.URL_GUARDAR_SESION_USUARIO);
			if(flujo == ActivacionConstants.DOS) {
				String uri = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, ServiciosConstants.URL_CONSULTA_SESION_USUARIO);
				SessionUsuario usuarioSesion = new SessionUsuario();
				usuarioSesion.setUsuario(usuario);
				SessionUsuario sesion = restServiceClientUtils.ejecutarServicioPost(uri, usuarioSesion, SessionUsuario.class);
				logger.error("Se actualiza sesion a inactiva por tiempo vencido {}", sesion.toString());
				
				sesion.setNuActivo(ActivacionConstants.CERO);
				sesion.setUsuarioModificador(ActivacionConstants.USUARIO_ACTUALIZA_SESION);
				sesion.setFechaCierreSesion(Calendar.getInstance().getTime());
				SessionUsuario idActualizar = restServiceClientUtils.ejecutarServicioPost(uriSave, sesion, SessionUsuario.class);
				logger.error("Ejecucion de la actualizacion de sesion {}", idActualizar);
			}
			
			SessionUsuario sesionNueva = new SessionUsuario();
			sesionNueva.setUsuario(usuario);
			sesionNueva.setIdentificadorSession(sesionId);
			Date fechaNueva = Calendar.getInstance().getTime();
			sesionNueva.setFechaInicioSesion(fechaNueva);
			sesionNueva.setFechaSesionActiva(utileriaFecha.sumaMinutos(fechaNueva, ActivacionConstants.SEIS));
			restServiceClientUtils.ejecutarServicioPost(urlComunesTransaccional, ServiciosConstants.URL_GUARDAR_SESION_USUARIO, sesionNueva, SessionUsuario.class);
			logger.error("Ejecucion de nueva sesion {}", id);
		} catch (Exception e) {
			logger.error("Error al guardar informacion de session ", e);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long guardarCierreSesion(SessionUsuario usuario) {
		SessionUsuario id = null;
		try {
			usuario.setNuActivo(ActivacionConstants.CERO);
			usuario.setUsuarioModificador(ActivacionConstants.USUARIO_CIERRE_SESION);
			usuario.setFechaCierreSesion(Calendar.getInstance().getTime());
			id = restServiceClientUtils.ejecutarServicioPost(urlComunesTransaccional, ServiciosConstants.URL_GUARDAR_SESION_USUARIO, usuario, SessionUsuario.class);
			logger.error("Ejecucion de la actualizacion de sesion {}", id);
		} catch (Exception e) {
			logger.error("Error en el cierre de session ", e);
		}
		return null;
	}
}
