/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoUsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioEncriptadoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CodigoUsuarioRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RechazoUsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioEncriptadoPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioRolRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarInformacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion del guardado de informacion de usuarios
 * 
 * @author DBARBOSA
 */
@Service
public class GuardarInformacionServiceImpl implements GuardarInformacionService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GuardarInformacionServiceImpl.class);
	
	/**
	 * Inyeccion de persistencia usuario
	 */
	@Autowired
	private UsuarioPulssarRepository persistenciaUsuario;
	
	/**
	 * Inyeccion de persistencia nickusuario
	 */
	@Autowired
	private UsuarioNickPulssarRepository persistenciaUsuarioNick;
	
	/**
	 * Inyeccion de persistencia usuario rol
	 */
	@Autowired
	private UsuarioRolRepository persistenciaUsuarioRol;
	
	/**
	 * Inyeccion de repositorio usaurio
	 */
	@Autowired
	private RechazoUsuarioPulssarRepository persistenciaRechazoUsuario;
	
	/**
	 * Inyeccion de repositorio rechazo
	 */
	@Autowired
	private CodigoUsuarioRepository persistenciaCodigo;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de service roles
	 */
	@Autowired
	private RolesService servicioRoles;

	/**
	 * Inyeccion de servicio de rechazo
	 */
	@Autowired
	private RechazoService rechazoService;
	
	/**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;
	
	/**
	 * Inyeccion de servicio de rechazo
	 */
	@Autowired
	private EncriptacionUtils utileriaEncriptado;
	
	/**
	 * Inyeccion de repositorio usaurio
	 */
	@Autowired
	private UsuarioEncriptadoPulssarRepository persistenciaUsuarioEncriptado;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void guardarUsuarioAcceSAR(String usuarioAcceSAR, DatosRegistro registro, String status, String userMod, CodigoUsuario codigo, List<String> roles, String password, boolean servicioRest) {
		logger.info("Se guarda el usuario del Portal AcceSAR {} >> {} ", usuarioAcceSAR, registro.toString());
		Date fechaAlta = new Date();
		UsuarioPulssar usuario = new UsuarioPulssar();
		usuario.setUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNumeroAgente(), ExpresionesConstants.VACIO));
		usuario.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNombre(), ExpresionesConstants.VACIO));
		usuario.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoPaterno(), ExpresionesConstants.VACIO));
		usuario.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoMaterno(), null));
		usuario.setEmail(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCorreo(), null));
		usuario.setCelular(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), null));
		usuario.setClaveOrganizacion(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getClaveAfore(), ExpresionesConstants.VACIO));
		usuario.setChSucursal(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getClaveSucursal(), null));
		usuario.setEstatus(status);
		usuario.setFecha(fechaAlta);
		usuario.setUsuarioModificador(userMod);
		usuario.setChOficina(registro.getClaveOficina());
		usuario.setZona(utileriaValidador.validarVacio(registro.getNombreZona()) ? null : Long.parseLong(registro.getNombreZona()));
		usuario = persistenciaUsuario.saveAndFlush(usuario);
		
		if(!utileriaValidador.validarListaVacia(roles)) {
			UsuarioRol usuarioRol;
			for(String rol : roles) {
				usuarioRol = new UsuarioRol();
				usuarioRol.setIdentificadorUsuario(usuario.getIdentificador());			
				usuarioRol.setEstatus(NumerosConstants.INT_UNO);
				usuarioRol.setFecha(fechaAlta);
				usuarioRol.setUsuarioModificador(userMod);
				RolesCatalogo rolAfore = servicioRoles.buscarRolPorRolClaveAfore(rol, registro.getClaveAfore());
				usuarioRol.setRolUsuario(rolAfore);
				persistenciaUsuarioRol.save(usuarioRol);
			}
		}
		
		if(!utileriaValidador.validarVacio(registro.getNickUsuario())) {
			UsuarioNickPulssar usuarioNick = new UsuarioNickPulssar();
			usuarioNick.setIdentificadorUsuario(usuario.getIdentificador());
			usuarioNick.setNickUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNickUsuario(), ExpresionesConstants.VACIO));
			usuarioNick.setEstatus(NumerosConstants.INT_UNO);
			usuarioNick.setFecha(fechaAlta);
			usuarioNick.setUsuarioModificador(userMod);
			persistenciaUsuarioNick.save(usuarioNick);
		}
		
		if(!utileriaValidador.validarObjetoNulo(codigo)) {
			codigo.setIdentificadorUsuario(usuario.getIdentificador());
			persistenciaCodigo.saveAndFlush(codigo);
		}
		
		logger.info("Se guardo de forma correcta el usuario del Portal AcceSAR {} >> {} ", usuarioAcceSAR);
		logger.info("Se valida si el usuario es de Coppel ::: {} >> {} >> {}", registro.getClaveAfore(), usuario, usuario.getIdentificador());
		if(PdfConstants.COPPEL.equals(registro.getClaveAfore()) && servicioRest) {
			UsuarioEncriptadoPulssar usuarioEncriptado = new UsuarioEncriptadoPulssar();
			usuarioEncriptado.setIdUsuarioPulssar(usuario.getIdentificador());
			usuarioEncriptado.setPassword(utileriaEncriptado.obtieneEncriptacion(password, keySeguridadEncriptacion));
			usuarioEncriptado.setEstatus(NumerosConstants.INT_UNO);
			usuarioEncriptado.setFecha(fechaAlta);
			usuarioEncriptado.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_REGISTRO);
			persistenciaUsuarioEncriptado.saveAndFlush(usuarioEncriptado);
		}
	}
	
	/**
	 * Metodo encargado de guardar rechazo
	 * @param registro
	 * @param idRechazo
	 */
	@Transactional
	@Override
	public void guardarRechazoUsuario(DatosRegistro registro, Long idRechazo) {
		if(!utileriaValidador.validarObjetoNulo(registro)) {
			RechazoUsuarioPulssar usuario = new RechazoUsuarioPulssar();
			usuario.setUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNumeroAgente(), ExpresionesConstants.VACIO));
			usuario.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNombre(), ExpresionesConstants.VACIO));
			usuario.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoPaterno(), ExpresionesConstants.VACIO));
			usuario.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoMaterno(), null));
			usuario.setEmail(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCorreo(), null));
			usuario.setCelular(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), ExpresionesConstants.ESPACIO));
			usuario.setClaveOrganizacion(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getClaveAfore(), null));
			usuario.setNickUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNickUsuario(), null));
			usuario.setIdentificadorRechazo(idRechazo);
			usuario.setFecha(new Date());
			usuario.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_RECHAZO);
			persistenciaRechazoUsuario.save(usuario);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
//	@Override
	@Transactional
	public void guardarUsuario(DatosRegistro registro, String user) {
		Date fechaRegistro = new Date();
		UsuarioPulssar usuario = new UsuarioPulssar();
		usuario.setUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNumeroAgente(), ExpresionesConstants.VACIO));
		usuario.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNombre(), ExpresionesConstants.VACIO));
		usuario.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoPaterno(), ExpresionesConstants.VACIO));
		usuario.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoMaterno(), null));
		usuario.setEmail(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCorreo(), null));
		usuario.setCelular(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), ExpresionesConstants.VACIO));
		usuario.setClaveOrganizacion(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getClaveAfore(), ExpresionesConstants.VACIO));
		usuario.setEstatus(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario());
		usuario.setFecha(fechaRegistro);
		usuario.setUsuarioModificador(user);
		usuario.setChSucursal(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getClaveSucursal(), null));
		
		usuario = persistenciaUsuario.saveAndFlush(usuario);
		
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio guardarRechazoUsuario(DatosRegistro registro, String codigo, String claveAfore, Integer flujo ,String minutos) {
		RespuestaServicio respuesta = new RespuestaServicio();
		RechazoPulssar rechazo = rechazoService.obtenerRechazo(codigo, claveAfore);
		String mensaje = rechazo.getMensaje();
		this.guardarRechazoUsuario(registro, rechazo.getIdentificadorRechazo());
		if(BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE.getClave().equals(codigo)){
			mensaje = StringUtils.replace(mensaje, "{tiempo}", minutos);
		}
		respuesta.setTitulo(rechazo.getTituloMensaje());
		respuesta.setMensaje(mensaje);
		respuesta.setFlujo(flujo);
		return respuesta;
	}
}