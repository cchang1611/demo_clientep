package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarInformacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RegistroUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAltaUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * implementacion servicio RegistroUsuario para registrar un usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
@Service
public class RegistroUsuarioServiceImpl implements RegistroUsuarioService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RegistroUsuarioServiceImpl.class);
	
	/**
	 * Inyeccion utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion servicio catalogo 
	 */
	@Autowired 
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion Servicio Admin usuarios
	 */
	@Autowired
	private ValidarAltaUsuarioService servicioAlta;
	
	/**
	 * Inyeccion de servicio Guardar
	 */
	@Autowired
	private GuardarInformacionService servicioGuardar;
	
	/**
	 * Inyeccion de servicio Mensaje
	 */
	@Autowired
	private MensajeService servicioMensaje;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de utileria encriptar
	 */
	@Autowired
	private EncriptacionUtils utileriaEncriptar;
	
	/**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio registrarAltaUsuario(DatosRegistro datosRegistro, UsuarioLogin user, String clave, String statusUsuario, boolean isActivo, boolean isRegistro) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			String usuario = servicioAlta.obtenerUsuarioAcceSAR(datosRegistro, true);
			String password = servicioAlta.validarAltaUsuariosAcceSAR(usuario, datosRegistro.getCorreo(), datosRegistro.getCelular(), 
					datosRegistro.getClaveAfore(), datosRegistro.getPassword(), true);
			servicioAlta.validarUsuarioOUD_Roles(datosRegistro, usuario, password, this.obtenerOUDUsuarios(datosRegistro.getRoles()), isActivo);
			CodigoUsuario codigo = null;
			if(isRegistro) {
				codigo = servicioAlta.validarAltaEmail_Codigo(usuario, datosRegistro, user);
			} else {
				servicioAlta.validarCorreoAdministrador(usuario, datosRegistro.getClaveAfore());
			}
			servicioGuardar.guardarUsuarioAcceSAR(usuario, datosRegistro, statusUsuario, user.getUsuario(), codigo, datosRegistro.getRoles(), null, false);
			respuesta = servicioCatalogo.obtenerRespuesta(null, clave, user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
		} catch(BusinessException be) {
			logger.error("BusinessException en registrarAltaUsuario", be);
			respuesta = servicioCatalogo.obtenerRespuesta(datosRegistro, be.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		} catch(GenericException ge) {
			logger.error("GenericException en registrarAltaUsuario", ge);
			respuesta = servicioCatalogo.obtenerRespuesta(datosRegistro, ge.getCodigo(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuariosEnum> obtenerOUDUsuarios(List<String> cadenaRoles) {
		List<UsuariosEnum> listaRoles = null;
		
		if(!utileriaValidador.validarListaVacia(cadenaRoles)) {
			listaRoles = new ArrayList<>();
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ROLES, "");
			String rolesLista = utileriaValidador.obtenerValorParametro(listaParametro, RolesConstants.PARAM_PERFILES_ADMIN, RolesConstants.PERFILES_ADMIN);
			UsuariosEnum usuario;
			
			for(String roles : cadenaRoles) {
				if(rolesLista.contains(roles)) {
					usuario = UsuariosEnum.ADMINISTRADORES;
				} else {
					usuario = UsuariosEnum.USUARIOS;
				}
				
				if (!listaRoles.contains(usuario)) {
					listaRoles.add(usuario);
				}
			}
		}
		
		return listaRoles;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaAlta registrarUsuarioRest(String datosUsuario, boolean registroRest) {
		RespuestaAlta respuesta = new RespuestaAlta();
		DatosRegistro registro = null;
		try {
			DatosUsuario datosRegistro = limpiarCadena(datosUsuario);
			registro = new DatosRegistro(datosRegistro);
			String usuario = servicioAlta.obtenerUsuarioAcceSAR(registro, false);
			String password = servicioAlta.validarAltaUsuariosAcceSAR(usuario, registro.getCorreo(), registro.getCelular(), 
					registro.getClaveAfore(), registro.getPassword(), true);
			servicioAlta.validarAltaUsuariosAcceSAR(registro.getNumeroAgente(), registro.getCorreo(), registro.getCelular(), 
					registro.getClaveAfore(), registro.getPassword(), true);
			servicioAlta.validarUsuarioOUD_Roles(registro, usuario, password, this.obtenerOUDUsuarios(Arrays.asList(RolesEnum.AGENTE_VENTANILLA.getRol())), true);
			
			String status = EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario();
			if(!PdfConstants.COPPEL.equals(datosRegistro.getClaveAfore())) {
				List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_MENSAJE, "");
				String parametroMensaje = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_RECUPERACION, RegistroUsuarioConstants.MENSAJE_SMS_USUARIO_PASSWORD);
				String mensajeSms = parametroMensaje.replace(RegistroUsuarioConstants.SMS_USUARIO, usuario);
				mensajeSms = mensajeSms.replace(RegistroUsuarioConstants.SMS_PASSWORD, password);
				servicioMensaje.enviarMensaje(mensajeSms, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), ExpresionesConstants.VACIO));
			} else {
				status = EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario();
			}
			
			
			servicioGuardar.guardarUsuarioAcceSAR(usuario, registro, status, RegistroUsuarioConstants.USUARIO_REGISTRO, null, Arrays.asList(RolesEnum.AGENTE_VENTANILLA.getRol()), password, registroRest);
			respuesta.setResultadoOperacion(ServiciosConstants.RESULTADO_OK);
		} catch(BusinessException be) {
			logger.error("BusinessException en registrarUsuarioRest", be);
			respuesta = this.obtenerRespuestaRechazo(be.getCodigo(), registro);
		} catch(GenericException ge) {
			logger.error("GenericException en registrarUsuarioRest", ge);
			respuesta = this.obtenerRespuestaRechazo(ge.getCodigo(), registro);
		} catch(Exception e) {
			logger.error("Exception no controlada en registrarUsuarioRest", e);
			respuesta = this.obtenerRespuestaRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), registro);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String cifrarDescifrarCadena(String password, boolean cipher) {
		String resultado;
		if(cipher) {
			resultado = utileriaEncriptar.obtieneEncriptacion(password, keySeguridadEncriptacion);
		} else {
			resultado = utileriaEncriptar.obtieneDesencriptacion(password, keySeguridadEncriptacion);
		}
		return resultado;
	}
	
	/**
	 * Metodo encargado de limpiar la cadena de entrada de
	 * Alta de usuario Rest
	 * 
	 * @param cadenaJson
	 * @return
	 */
	private DatosUsuario limpiarCadena(String cadenaJson) {
		String auxiliarCadena = StringUtils.replace(cadenaJson, ExpresionesConstants.KEY_APERTURA, ExpresionesConstants.VACIO);
		auxiliarCadena = StringUtils.replace(auxiliarCadena, ExpresionesConstants.KEY_CERRAR, ExpresionesConstants.VACIO);
		auxiliarCadena = StringUtils.replace(auxiliarCadena, ExpresionesConstants.SALTO, ExpresionesConstants.VACIO);
		auxiliarCadena = StringUtils.replace(auxiliarCadena, ExpresionesConstants.TABULADOR, ExpresionesConstants.VACIO);
		
		String[] eliminarComas = auxiliarCadena.split(ExpresionesConstants.COMA);
		
		DatosUsuario usuario = new DatosUsuario();
		HashMap<String, String> mapaValores = new HashMap<>();
		String auxiliarFor;
		String[] eliminarDPuntos;
		for(int i = 0 ; i < eliminarComas.length; i++) {
			auxiliarFor = StringUtils.replace(eliminarComas[i], ExpresionesConstants.COMILLA, ExpresionesConstants.VACIO);
			eliminarDPuntos = auxiliarFor.split(ExpresionesConstants.DOS_PUNTOS);
			mapaValores.put(utileriaCadenas.obtenerContenidoCadenaSinEspacios(eliminarDPuntos[NumerosConstants.INT_CERO], ExpresionesConstants.VACIO), utileriaCadenas.obtenerContenidoCadenaSinEspacios(eliminarDPuntos[NumerosConstants.INT_UNO], ExpresionesConstants.VACIO));
		}
		
		usuario.setNickUsuario(mapaValores.get("nickUsuario"));
		usuario.setNumeroAgente(mapaValores.get("numeroAgente"));
		usuario.setNombre(mapaValores.get("nombre"));
		usuario.setApellidoPaterno(mapaValores.get("apellidoPaterno"));
		usuario.setApellidoMaterno(mapaValores.get("apellidoMaterno"));
		usuario.setCelular(mapaValores.get("celular"));
		usuario.setCorreo(mapaValores.get("correo"));
		usuario.setClaveAfore(mapaValores.get("claveAfore"));
		
		return usuario;
	}
	
	/**
	 * Metodo encargado de regresar el motivo de rechazo
	 * 
	 * @param codigo
	 * @return
	 */
	protected RespuestaAlta obtenerRespuestaRechazo(String codigo, DatosRegistro registro) {
		RespuestaAlta respuesta = new RespuestaAlta();
		String resultadoCodigo = codigo;
		respuesta.setResultadoOperacion(ServiciosConstants.RESULTADO_NOK);
		servicioCatalogo.obtenerRespuesta(registro, codigo, registro.getClaveAfore(), NumerosConstants.INT_DOS, null);
		if(codigo.length() > NumerosConstants.INT_TRES){
			resultadoCodigo = codigo.substring(NumerosConstants.INT_UNO, codigo.length());
		}
		respuesta.setMotivoRechazo(resultadoCodigo);
		return respuesta;
	}
}