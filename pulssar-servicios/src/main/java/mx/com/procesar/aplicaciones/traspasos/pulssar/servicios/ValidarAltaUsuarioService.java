package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * interfaz servicio para el alta de usuaios
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface ValidarAltaUsuarioService {
	
	/**
	 * Metodo encargado de validar y obtener el usuario para el Portla de Servicios Accesar 
	 * 
	 * @param datosRegistro
	 * @return
	 */
	String obtenerUsuarioAcceSAR(DatosRegistro datosRegistro, boolean isConfirmaCel);
	
	/**
	 * Metodo encargado de validar el Alta de usuarios AcceSAR
	 * 
	 * @param usuario
	 * @param correo
	 * @param celular
	 * @param claveAfore
	 * @param password
	 * @return
	 */
	String validarAltaUsuariosAcceSAR(String usuario, String correo, String celular, String claveAfore, String password, boolean isUsuarioNick);
	
	/**
	 * Metodo encargado de validar el usuario en el OUD y asignacion de Rol
	 * 
	 * @param datosRegistro
	 * @param usuario
	 * @param roles
	 */
	void validarUsuarioOUD_Roles(DatosRegistro datosRegistro, String usuario, String password, List<UsuariosEnum> roles, boolean isActivo);
	
	/**
	 * Metodo encargado de validar el envio del codigo por correo o sms
	 * 
	 * @param userName
	 * @param registro
	 * @param user
	 * @return
	 */
	CodigoUsuario validarAltaEmail_Codigo(String userName, DatosRegistro registro, UsuarioLogin user);
	
	/**
	 * Metodo encargado de validar si existe un administrador de afore
	 * 
	 * @param datosUsuario
	 */
	void validarAdministradorAfore(DatosRegistro datosUsuario);
	
	/**
	 * Metodo encargado de validar y enviar los correos a los administradores
	 * 
	 * @param username
	 * @param afore
	 */
	void validarCorreoAdministrador(String username, String afore);
	
	/**
	 * Metodo encargado de obtener la url de la afor para su correcta recuperacion de password
	 * @param afore
	 * @return
	 */
	String obtenerUrlPaginaPlataforma(String afore);
	
	/**
	 * Metodo encargado de validar la lista de usuarios y sus codigos
	 * 
	 * @param cadena
	 * @param valor
	 * @param listaUsuarios
	 * @param tipoCodigo
	 * @param error
	 */
	void validarListaUsuariosCodigo(String cadena, String valor, List<UsuarioPulssar> listaUsuarios, String tipoCodigo, BusinessErrorEnum error);
	
	/**
	 * Metodo encargado de validar el celular y correo
	 * 
	 * @param cadena
	 * @param error
	 * @param tipo
	 */
	void validarCelularEmail(String cadena, BusinessErrorEnum error, Integer tipo);
}