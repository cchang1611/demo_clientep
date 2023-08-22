package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * interfaz servicio RegistroUsuario para registrar un usuario
 *  
 * @author OJBALBUE
 * @version 1.0
 */
public interface RegistroUsuarioService {
	
	/**
	 * Metodo para registrar un usuario para el Portal AcceSAR
	 * 
	 * @param datosRegistro
	 * @param user
	 * @param clave
	 * @param statusUsuario
	 * @param isActivo
	 * @return
	 */
	RespuestaServicio registrarAltaUsuario(DatosRegistro datosRegistro, UsuarioLogin user, String clave, String statusUsuario, boolean isActivo, boolean isRegistro);
	
	/**
	 * Alta de usuario desde un servicio rest
	 * 
	 * @param datosUsuario
	 * @return
	 */
	RespuestaAlta registrarUsuarioRest(String datosUsuario, boolean registroRest);
	
	/**
	 * Metodo encargado de obtener los Roles del OUD
	 * 
	 * @param cadenaRoles
	 * @return
	 */
	List<UsuariosEnum> obtenerOUDUsuarios(List<String> cadenaRoles);
	
	/**
	 * Metodo encargado de cifrar o descifrar cadena
	 * 
	 * @param password
	 * @param cipher
	 * @return
	 */
	String cifrarDescifrarCadena(String password, boolean cipher);
}
