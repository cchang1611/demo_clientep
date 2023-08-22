package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosOrganizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * interfaz servicio AdministracionUsuario para la administracion de usuarios
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface AdministracionUsuarioService {
	
	/**
	 * Metodo encargado de recuperar password
	 * 
	 * @param usuario
	 */
	RespuestaServicio recuperarContrasenia(DatosRegistro usuario);
	
	/**
	 * Metodo encargado de reenviar correo para recuperacion de contrasenia
	 * @param usuario
	 * @return
	 */
	RespuestaServicio reenviarCorreoPassword(String usuario);
	
	/**
	 * Metodo encargado de cambiar la contrasenia
	 * 
	 * @param usuario
	 */
	void cambiarContrasenia(DatosRegistro usuario);
	
	/**
	 * Metodo encargado de activar usuario
	 * 
	 * @param llave
	 * @param codigo
	 */
	RespuestaServicio activarUsuario(DatosRegistro datosEntrada, String urlKey);
	
	/**
	 * Metodo encargado de validar si existe el usuario registrado
	 * 
	 * @param usuario
	 * @return
	 */
	RespuestaServicio validarUsuarioLogin(String usuario, String contexto);
	
	/**
	 * Metodo encargado de obtener el rol para la pantall
	 * 
	 * @param usuario
	 * @return
	 */
	UsuarioLogin obtenerRolUsuario(String usuario);
	
	/**
	 * prueba de metodo para consultar usuarios por organizacion
	 * @param claveOrganizacion
	 * @return
	 */
	List<UsuarioPulssar> consultarBajaUsuario(String claveOrganizacion,List<String> estatus);
	
	/**
	 *  metodo para consulta de usuarios
	 * @return
	 */
	List<Usuarios> consultarUsuarioSinRol(String claveOrganizacion,String usuarioLogueado, List<String> estatus, boolean isActivo, boolean isAdmin);
	
	/**
	 * metodo encargado de actualizar el estatus del rol de usuario
	 * @param usuario
	 * @param claveAfore
	 */
	RespuestaServicio bajaUsuarios(List<String> usuario,String claveAfore, String usuarioBaja);
	/**
	 * Asigna perfil ausuarios inactivos
	 * 
	 * @param cadenaUsuario
	 * @param cadenaRol
	 * @param claveAfore
	 * @param usuarioAsigna
	 */
	RespuestaServicio asignarPerfil(List<String> cadenaUsuario, List<String> cadenaRol, List<UsuariosEnum> listaRoles, String claveAfore, String usuarioAsigna);
	/**
	 * consulta usuarios activos con roles
	 * @param claveOrganizacion
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	List<UsuariosModificar> consultarUsuariosRoles(String claveOrganizacion, String usuarioLogueado, Integer estatusRol, List<String> estatus);
	
	/**
	 * Metodo encargado de realizar ajustes al usuarios
	 * 
	 * @param usuarioVista
	 * @param usuarioBD
	 * @param roles
	 */
	RespuestaServicio modificarDatosUsuario(DatosRegistro usuarioVista, UsuariosModificar usuarioBD, List<String> roles, String claveAfore, String userModifica, String[] modulos);
	
	/**
	 * Metodo encargado de activar usuario
	 * @param urlServicio
	 * @return
	 */
	RespuestaServicio validarActivacionUsuario(String urlServicio, DatosRegistro registro, boolean isValidarUsuario);
	
	/**
	 * Obtiene la foto del agente
	 * @param usuario
	 * @param afore
	 * @return
	 */
	AgentePromotor obtenerDatosAgente(String usuario, String afore, List<UsuarioRol> listaRoles);
	
	/**
	 * obtener lista de correos corporativos
	 * @param claveAfore
	 * @return
	 */
	List<CorreoCorporativo> obtenerCorreosCorporativos(String claveAfore);
	
	/**
	 * verifica existencia de correo corporativo
	 * @param claveAfore
	 * @param email
	 * @return
	 */
	List<CorreoCorporativo> obtenerCorreosExistentes(String claveAfore,String email);
	
	/**
	 * 
	 * @return
	 */
	RespuestaServicio guardarCorreos(DatosOrganizacion correo,UsuarioLogin usuario,String claveAfore);
	
	/**
	 * 
	 * @param clave
	 * @return
	 */
	List<CorreoCorporativo> listaCorreos(String clave);
	
	/**
	 * editar estatus de correo
	 * @param correo
	 * @param usuario
	 * @param correos
	 * @param resultadoLista
	 * @return
	 */
	RespuestaServicio editarCorreos(DatosOrganizacion correo,UsuarioLogin usuario,String[] correos,List<CorreoCorporativo> resultadoLista);
	
	/**
	 * busqueda agente
	 * @param claveAfore
	 * @param usuario
	 * @return
	 */
	AgentePromotor buscarUsuarioNick(String claveAfore,String usuario);
	
	/**
	 * Metodo encargado de actualizar estatus de usuario
	 * @param usuario
	 */
	void modificarEstatus(UsuarioLogin usuario);
	
	/**
	 * Metodo encargado de verificar bloqueo de usuario
	 * @param usuario
	 */
	RespuestaServicio buscarBloqueoUsuario(String salidaSpring);
	
	/**
	 * Metodo encargado de reactivar usuarios bloqueados
	 * @param cadenaUsuario
	 * @param claveAfore
	 * @param usuarioAsigna
	 * @return
	 */
	RespuestaServicio reactivarUsuarios(List<String> cadenaUsuario, String claveAfore, String usuarioAsigna);
	
	/**
	 * 
	 * @param organizacion
	 * @param usuarioLogueado
	 * @param estatus
	 * @param estatusCodigo
	 * @param tipoCodigo
	 * @param isActivo
	 * @return
	 */
	List<Usuarios> consultarUsuariosCodigoVencido(String organizacion, String estatus, Integer estatusCodigo, String  tipoCodigo);
	
	/**
	 * Metodo encargado de reenviar credenciales a usuario 
	 * @param registro
	 * @param user
	 */
	RespuestaServicio reenviarAltaUsuario(List<String> usuarios,DatosRegistro registro, UsuarioLogin user);
	
	/**
	 * Metodo encargado de reenviar codigo por sms
	 * @param datosUsuario
	 * @return
	 */
	RespuestaServicio reenviarCodigo(DatosRegistro datosUsuario, String urlKey);
	
	/**
	 * Metodo encargado de redireccionar al menu correcto dependiendo el rol y la afore del usuario
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	List<MenuPagina> redireccionarPagina(String claveRol, String claveAfore);
	
	/**
	 * Metodo encargado de redireccionar al menu correcto dependiendo el rol y la afore del usuario
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	List<MenuPagina> obtenerMenus(String claveRol, String claveAfore);
	
	
	/**
	 * Metodo encargado de redireccionar al menu correcto dependiendo el rol y la afore del usuario
	 * @param claveRol
	 * @param claveAfore
	 * @param menu menu basico ,menu principal
	 * @return
	 */
	List<MenuPagina> obtenerMenus(String claveRol, String claveAfore,Long menu);
	
	/**
	 * Metodo encargado de consultar usaurio a modificar
	 * 
	 * @param claveOrganizacion
	 * @param usuario
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	List<UsuariosModificar> consultarUsuarioModificar(String claveOrganizacion, String usuario, Integer estatusRol, List<String> estatus);

	/**
	 * MEtodo para recuperar solo el menu con la afore
	 * @author Ricardo Alcantara Ramirez (ralcanra@procesar.com)
	 * Jun 8, 2021
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	List<MenuPagina> obtenerMenuRol(String claveAfore);

	/**
	 * MEtodo que obtiene el menu por el rol y afore
	 * @author Ricardo Alcantara Ramirez (ralcanra@procesar.com)
	 * Jun 10, 2021
	 * @param claveRol
	 * @param claveAfore
	 * @return
	 */
	List<MenuPagina> obtenerMenuRol(String claveRol, String claveAfore);
	
	/**
	 * menuReimpresion
	 * @param aforeSesion
	 * @return
	 */
	Boolean menuReimpresion(String aforeSesion);
	
	/**
	 * menuExpedienteUnicoCoopel
	 * @param aforeSesion
	 * @return
	 */
	Boolean menuExpedienteUnicoCoopel(String aforeSesion,String rolPulssar);
	
	/**
	 * Metodo encargado de obtener los menus para la consulta de prospectos
	 * 
	 * @param parametros
	 * @return
	 */
	List<MenuPagina> obtenerMenuId(List<Parametro> parametros);
}