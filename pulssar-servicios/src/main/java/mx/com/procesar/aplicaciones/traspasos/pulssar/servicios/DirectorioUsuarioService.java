package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Usuario;

/**
 * interfaz para el manejo de alta de usuarios en el active directy
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface DirectorioUsuarioService {
	
	/**
	 * Registrar usuario en active directory
	 * 
	 * @param usuario
	 * @param isActivo
	 */
	void registrarUsuario(DatosRegistro registro, String usuario, String password, boolean isActivo);
	
	/**
	 * Realiza la recuperacion de Password
	 * 
	 * @param userName
	 * @param contrasenia
	 */
	void recuperaContrasenia(String userName, String contrasenia);
	
	/**
	 * Realiza el cambio de contrasenia tomando en cuenta el password actual y el nuevo password
	 * 
	 * @param entrada
	 * @param error
	 */
	void cambioContrasenia(DatosRegistro registro, BusinessErrorEnum error);
	
	/**
	 * Metodo encargado de activar o desactivar un usuario
	 * 
	 * @param userName
	 * @param activo
	 * @return
	 */
	Usuario activaDesactivaUsuario(String userName, boolean activo);
	
	/**
	 * Metodo encargado de asignar roles
	 * 
	 * @param userName
	 * @param roles
	 * @return
	 */
	void asignarRoles(String userName, List<UsuariosEnum> roles);
	
	/**
	 * 
	 * @param userName
	 * @param roles
	 * @param activo
	 */
	void eliminarRoles(String userName, List<UsuariosEnum> roles);
	
	/**
	 * Metodo encargado de actualizar el celular y el correo del trabajador
	 * 
	 * @param correo
	 * @param celular
	 * @param isActualiza
	 */
	void actualizarCelularCorreoPerfil(String usuario, String correo, String celular, List<String> perfil, boolean isActualiza);
	
	/**
	 * Metodo encargado de reiniciar intentos fallidos de login 
	 * @param userName
	 * @return
	 */
	void reiniciarIntentos(String userName);
	
	/**
	 * Metodo para consultar usuario
	 * @param userName
	 * @return
	 */
	Usuario consultarUsuario(String userName);
	
	/**
	 * Metodo para consultar Roles OID
	 * @param userName
	 * @return
	 */
	String consultarRolesOID(String userName);
	
	/**
	 * Metodo para obtener datos de variable Employee
	 * @param usuario
	 * @return
	 */
	String obtenerEmployeeType(String usuario);
}