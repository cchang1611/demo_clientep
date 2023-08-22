/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Usuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de la administracion del directorio de usuarios
 * 
 * @author DBARBOSA
 */
@Service
public class DirectorioUsuarioServiceImpl implements DirectorioUsuarioService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DirectorioUsuarioServiceImpl.class);
	
	/**
	 * Inyeccion de utileria validadro
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion Rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Valor del token
	 */
	@Value("${autorizacion.oauth2.token.valor}")
	private String valorTokenAutorizacion;
	
	/**
	 * Nombre del token
	 */
	@Value("${autorizacion.oauth2.token.nombre}")
	private String nombreTokenAutorizacion;

	/**
	 * Tipo del token
	 */
	@Value("${autorizacion.oauth2.token.tipo}")
	private String tipoTokenAutorizacion;

	/**
	 * auth
	 */
	@Value("${servicio.oauth2.administracion.usuarios.url}")
	private String urlServicioAdministracionUsuarios;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registrarUsuario(DatosRegistro registro, String usuario, String password, boolean isActivo) {
		try {
			Usuario nuevoUsuario = this.validaUsuarioRegistro(registro, usuario, password, isActivo);
			if (!utileriaValidador.validarObjetoNulo(nuevoUsuario)) {
				HttpEntity<Usuario> entidadRegistro = new HttpEntity<>(nuevoUsuario, this.obtenerHttpEntityToken());
				
				ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioAdministracionUsuarios, HttpMethod.POST, entidadRegistro, String.class);
				logger.info("Respuesta de Registro usuario {} {}", nuevoUsuario.getUsername(), respuesta.getBody());
			}
		} catch (Exception e) {
			logger.error("Exception al momento de registrar el usuario", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void recuperaContrasenia(String userName, String contrasenia) {
		try {
			logger.info("Recuperacion de contrasenia {}", userName);
			
			String urlRecupera = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ServiciosConstants.RECUPERA_CONTRASENIA_USUARIO, userName, 
					ServiciosConstants.RECUPERA_CONTRASENIA_PASSWORD, utileriaCadena.conversionCaracteresAscii(contrasenia));
			HttpEntity<String> entidadRegistro = new HttpEntity<>(this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlRecupera, HttpMethod.PUT, entidadRegistro, String.class);
			logger.info("Respuesta de recuperacion usuario {} {}", userName, respuesta.getBody());
		} catch (Exception e) {
			logger.error("Error al recuperar contrasenia", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cambioContrasenia(DatosRegistro registro, BusinessErrorEnum error) {
		try {
			String urlCambio = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ExpresionesConstants.DIAGONAL, registro.getNumeroAgente(), 
					ServiciosConstants.CAMBIO_PASSWORD_ACTUAL, utileriaCadena.conversionCaracteresAscii(registro.getPasswordActual()), 
					ServiciosConstants.CAMBIO_PASSWORD_NUEVO, utileriaCadena.conversionCaracteresAscii(registro.getPassword()));
			HttpEntity<String> entidadCambio = new HttpEntity<>(this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlCambio, HttpMethod.PUT, entidadCambio, String.class);
			logger.info("Respuesta de cambio de contrasenia {} {}", registro.getNumeroAgente(), respuesta.getBody());
		} catch (HttpClientErrorException httpException) {
			logger.info("HttpClientErrorException al momento de actualizar el contrasenia ... {}", httpException.getResponseBodyAsString(), httpException); 
			if (httpException.getResponseBodyAsString().contains(RegistroUsuarioConstants.ERROR_HTTP_CLIENT)) {
				throw new BusinessException(error);
			}
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		} catch (Exception e) {
			logger.error("Exception no controlada", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Usuario activaDesactivaUsuario(String userName, boolean activo) {
		Usuario usuario = this.consultarUsuario(userName);

		if (!utileriaValidador.validarObjetoNulo(usuario) && usuario.getActivo() != activo) {
			logger.info("Realiza el ajuste de usuario para su actualizacion");
			usuario.setActivo(activo);
			logger.info("Se realiza Metodo activar o desactivar {} {} ", userName, activo);
			
			HttpEntity<Usuario> entidadActualizaEstatus = new HttpEntity<>(usuario, this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioAdministracionUsuarios, HttpMethod.PUT, entidadActualizaEstatus, String.class);
			logger.info("Actualizacion del usuario correctamente {} {}", userName, respuesta.getBody());
		}
		
		return usuario;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reiniciarIntentos(String userName) {
		Usuario usuario = this.consultarUsuario(userName);

		if (!utileriaValidador.validarObjetoNulo(usuario)) {
			logger.info("Realiza el ajuste de usuario para reinicio de failedLogin");
			usuario.setFailedLoginAttempsCount(NumerosConstants.INT_CERO.toString());
			usuario.setActivo(true);
			logger.info("Se realiza Metodo reiniciar intentos{} ", userName);
			
			HttpEntity<Usuario> entidadActualizaEstatus = new HttpEntity<>(usuario, this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioAdministracionUsuarios, HttpMethod.PUT, entidadActualizaEstatus, String.class);
			logger.info("Actualizacion de intentos correctamente {} {}", userName, respuesta.getBody());
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void asignarRoles(String userName, List<UsuariosEnum> roles) {
		if(!utileriaValidador.validarListaVacia(roles)) {
			String respuestaRoles = consultarRolesOID(userName);
			String cadenaRol = utileriaValidador.validarVacio(respuestaRoles) ? ExpresionesConstants.VACIO : respuestaRoles;
			logger.info("Se asigna los roles al usuario {} {}", roles, userName);
			for(UsuariosEnum rol : roles) {
				if(!cadenaRol.contains(rol.getRol())) {
					String urlAsignarRol = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ExpresionesConstants.DIAGONAL, userName, ServiciosConstants.DIAGONAL_ROLES, ExpresionesConstants.DIAGONAL, rol.getRol());
					HttpEntity<String> entidadAsignar = new HttpEntity<>(this.obtenerHttpEntityToken());
					
					ResponseEntity<String> respuestaRol = servicioCliente.exchange(urlAsignarRol, HttpMethod.PUT, entidadAsignar, String.class);
					logger.info("Asignacion del rol correctamente {} {}", userName, respuestaRol.getBody());
				}
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminarRoles(String userName, List<UsuariosEnum> roles) {
		String respuestaRoles = consultarRolesOID(userName);
		String cadenaRol = utileriaValidador.validarVacio(respuestaRoles) ? ExpresionesConstants.VACIO : respuestaRoles;
		logger.info("Se desasigna los roles al usuario {} {}", roles, userName);
		for(UsuariosEnum rol : roles) {
			if(cadenaRol.contains(rol.getRol())) {
				String urlAsignarRol = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ExpresionesConstants.DIAGONAL, userName, ServiciosConstants.DIAGONAL_ROLES, ExpresionesConstants.DIAGONAL, rol.getRol());
				HttpEntity<String> entidadAsignar = new HttpEntity<>(this.obtenerHttpEntityToken());
				
				ResponseEntity<String> respuestaRol = servicioCliente.exchange(urlAsignarRol, HttpMethod.DELETE, entidadAsignar, String.class);
				logger.info("Eliminar rol correctamente {} {}", userName, respuestaRol.getBody());
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizarCelularCorreoPerfil(String userName, String correo, String celular, List<String> perfil, boolean isActualiza) {
		if(isActualiza) {
			Usuario usuario = this.consultarUsuario(userName);
			if (!utileriaValidador.validarObjetoNulo(usuario)) {
				logger.info("Realiza el ajuste de celular y correo del usuario {} {} {}", userName, correo, celular);
				Map<String, Object> atributos = new HashMap<>();
				atributos.put(RegistroUsuarioConstants.CORREO, utileriaCadena.obtenerContenidoCadenaSinEspacios(correo, null));
				atributos.put(RegistroUsuarioConstants.TELEFONO, utileriaCadena.obtenerContenidoCadenaSinEspacios(celular, null));
				atributos.put(RegistroUsuarioConstants.EMPLEADO_TYPE_SICI, utileriaCadena.obtenerContenidoCadenaSinEspacios(obtenerCadenaFromLista(perfil), null));
				usuario.setAtributos(atributos);
				HttpEntity<Usuario> entidadActualizaEstatus = new HttpEntity<>(usuario, this.obtenerHttpEntityToken());
				
				ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioAdministracionUsuarios, HttpMethod.PUT, entidadActualizaEstatus, String.class);
				logger.info("Actualizaron los datos de celular y correo del usuario {} {} {} {}", userName, correo, celular, respuesta.getBody());
			}
		}
	}
	
	/**
	 * Metodo encargado de consultar los roles asignados
	 * 
	 * @param userName
	 * @return
	 */
	public String consultarRolesOID(String userName) {
		logger.info("Metodo consultaUsuarioRol {}", userName);
		String rolesRespuesta = null;
		try {
			String urlConsulta = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ExpresionesConstants.DIAGONAL, userName, ServiciosConstants.DIAGONAL_ROLES);
			HttpEntity<String> entidadConsulta = new HttpEntity<>(this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlConsulta, HttpMethod.GET, entidadConsulta, String.class);
			rolesRespuesta = respuesta.getBody();
			logger.info("Se recupero informacion {} {}", userName, respuesta.getBody());
		} catch (Exception e) {
			logger.error("Se presento problema al consultar los roles del usuario {}", userName, e);
		}
		return rolesRespuesta;
	}
	
	/**
	 * Metodo encargado de realizar la consulta de un usuario en el OID
	 * 
	 * @param userName
	 * @return
	 */
	public Usuario consultarUsuario(String userName) {
		logger.info("Metodo consultaUsuario {}", userName);
		Usuario usuario = null;
		try {
			String urlConsulta = utileriaCadena.obtenerCadenaConcatenada(true, urlServicioAdministracionUsuarios, ExpresionesConstants.DIAGONAL, userName, ExpresionesConstants.DIAGONAL);
			HttpEntity<String> entidadConsulta = new HttpEntity<>(this.obtenerHttpEntityToken());
			
			ResponseEntity<Usuario> respuesta = servicioCliente.exchange(urlConsulta, HttpMethod.GET, entidadConsulta, Usuario.class);
			usuario = respuesta.getBody();
			logger.info("Se recupero informacion {}", usuario);
		} catch (Exception e) {
			logger.error("Se presento problema al consultar el usuario", e);
			usuario = null;
		}
		return usuario;
	}
	
	/**
	 * Metodo encargado de validar las condiciones para un nuevo registro de
	 * usuario en la capa de seguridad
	 * 
	 * @param usuario
	 * @param isActivo
	 * @return
	 */
	private Usuario validaUsuarioRegistro(DatosRegistro registro, String usuario, String password, boolean isActivo) {
		Usuario usuarioOID = this.consultarUsuario(usuario);
		Usuario usuarioNuevo = null;
		if (utileriaValidador.validarObjetoNulo(usuarioOID)) {
			usuarioNuevo = this.obtieneUsuarioNuevo(registro, usuario, password, isActivo);
			logger.info("Se realiza el alta de un usuario nuevo {}", usuario);
		} else {
			this.activaDesactivaUsuario(usuario, true);
			Usuario auxiliarUsuario = this.mapeoDatEntradaRegistro(registro, usuarioOID, password, isActivo);
			
			logger.info("Se realiza el alta de un usuario {}", usuario);
			HttpEntity<Usuario> entidadActualizaUsuario = new HttpEntity<>(auxiliarUsuario, this.obtenerHttpEntityToken());
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioAdministracionUsuarios, HttpMethod.PUT, entidadActualizaUsuario, String.class);
			logger.info("Respuesta de alta de usuario {} {}", auxiliarUsuario.getUsername(), respuesta.getBody());
			this.recuperaContrasenia(usuario, password);
		}
		return usuarioNuevo;
	}
	
	/**
	 * Metodo encargado de generar un usuario nuevo
	 * 
	 * @param dat
	 */
	private Usuario obtieneUsuarioNuevo(DatosRegistro registro, String usuario, String pass, boolean isActivo) {
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setClaseUsuario(RegistroUsuarioConstants.CLASE_USUARIO);
		usuarioNuevo.setUsername(usuario);
		return this.mapeoDatEntradaRegistro(registro, usuarioNuevo, pass, isActivo);
	}
	
	/**
	 * Metodo encargado de setear los valores de un usuario
	 * 
	 * @param dat
	 * @param us
	 */
	private Usuario mapeoDatEntradaRegistro(DatosRegistro registro, Usuario usuarioNuevo, String pass, boolean isActivo) {
		Map<String, Object> atributos = new HashMap<>();
		usuarioNuevo.setPassword(utileriaCadena.conversionCaracteresAscii(pass));
		usuarioNuevo.setActivo(isActivo);
		usuarioNuevo.setNombre(registro.getNombre());
		usuarioNuevo.setApellidoPaterno(registro.getApellidoPaterno());
		usuarioNuevo.setApellidoMaterno(registro.getApellidoMaterno());
		atributos.put(RegistroUsuarioConstants.CORREO, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCorreo(), null));
		atributos.put(RegistroUsuarioConstants.TELEFONO, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), null));
		String perfilesSICI = "";
		if(!utileriaValidador.validarListaVacia(registro.getPerfilSici())) {
			perfilesSICI = this.obtenerCadenaFromLista(registro.getPerfilSici());
		}
		atributos.put(RegistroUsuarioConstants.EMPLEADO_TYPE_SICI, perfilesSICI);
		usuarioNuevo.setAtributos(atributos);

		return usuarioNuevo;
	}
	
	/**
	 * Metodo encargado de obtener de una lista de string a una cadena string separados por coma
	 * @param arreglo
	 * @return
	 */
	private String obtenerCadenaFromLista(List<String> arreglo) {
		String cadena = "";
		if(!utileriaValidador.validarListaVacia(arreglo)) {
			for(int i = 0; i < arreglo.size(); i++) {
				if(i > 0) {
					cadena = utileriaCadena.obtenerCadenaConcatenada(true, cadena, ExpresionesConstants.COMA);
				}
				cadena = utileriaCadena.obtenerCadenaConcatenada(true, cadena, arreglo.get(i));
			}
		}
		return cadena;
	}
	
	/**
	 * Metodo encargado de generar el encabezado del token
	 * 
	 * @return
	 */
	private HttpHeaders obtenerHttpEntityToken() {
		StringBuilder tokenAutorizacion = new StringBuilder();
		tokenAutorizacion.append(tipoTokenAutorizacion);
		tokenAutorizacion.append(ExpresionesConstants.ESPACIO);
		tokenAutorizacion.append(valorTokenAutorizacion);
		HttpHeaders headerAutorizacionUsuarios = new HttpHeaders();
		headerAutorizacionUsuarios.setContentType(MediaType.APPLICATION_JSON);
		headerAutorizacionUsuarios.set(nombreTokenAutorizacion, tokenAutorizacion.toString());
		
		return headerAutorizacionUsuarios;
	}
	
	@Override
	public String obtenerEmployeeType(String usuario) {
		String employeeType = "";
		try {
			Usuario user = consultarUsuario(usuario);
			logger.info("usuario: {}", user);
			Map<String, Object> atributos = user.getAtributos();
			logger.info("atributos: {}", atributos);
			employeeType = (String) atributos.get("employeeType");
			logger.info("usuario.employeeType: {}", employeeType);
		} catch (Exception e) {
			logger.error("Error al obtener atributos de OID: ", e);
			employeeType = "";
		}
		return employeeType;
	}
}