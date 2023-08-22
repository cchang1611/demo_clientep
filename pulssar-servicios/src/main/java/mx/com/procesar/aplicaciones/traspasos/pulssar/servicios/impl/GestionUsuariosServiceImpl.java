package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GestionUsuariosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosUsuariosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccesoVIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * Implementacion del guardado de administracion de usuarios
 * 
 * @author DBARBOSA
 */
@Service
public class GestionUsuariosServiceImpl extends BaseServiceImpl implements GestionUsuariosService {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio guardarUsuario(DatosRegistro usuario, String usuarioModificador) {
		logger.info("Se realiza el guardo del usuario: {} por {}", usuario, usuarioModificador);
		String url = String.format(ServiciosUsuariosConstants.GUARDADO_USUARIO, usuarioModificador);
		return restServiceClientUtils.ejecutarServicioPost(uriUsuariosPulssar, url, usuario, RespuestaServicio.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AccesoVIP> consultarIpsAforePlataforma(String claveAfore, String plataforma) {
		logger.info("Se realiza la consulta de Ips por afore y plataforma >>> {} :: {}", claveAfore, plataforma);
		String url = String.format(ServiciosUsuariosConstants.CONSULTA_IPS, claveAfore, plataforma);
		return restServiceClientUtils.ejecutarServicioGetObjetos(uriComunes, url, AccesoVIP.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> validarIps(List<String> ips, String afore, String plataforma) {
		logger.info("Se valida las ips a insertar >> {}", ips);
		String url = String.format(ServiciosUsuariosConstants.VALIDAR_IPS, afore, plataforma);
		return restServiceClientUtils.ejecutarServicioPostParaObjetos(uriComunes, url, ips, String.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio guardarIps(List<String> ips, String afore, String plataforma, String usuario) {
		String url = String.format(ServiciosUsuariosConstants.GUARDAR_IPS, afore, plataforma, usuario);
		return restServiceClientUtils.ejecutarServicioPost(uriComunesTransaccional, url, ips, RespuestaServicio.class);
	}
}