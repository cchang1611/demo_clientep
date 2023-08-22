package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SessionUsuario;

/**
 * Servicio de control de sesiones
 * 
 * @author dbarbosa
 *
 */
public interface SessionUsuarioService {
	
	/**
	 * Metodo encargado de validar las sesiones
	 * 
	 * @param usuario
	 * @return
	 */
	SessionUsuario obtenerUsuarioSesion(String usuario);
	
	/**
	 * Metodo encargado de validar las sesiones
	 * 
	 * @param usuario
	 * @return
	 */
	Integer validarSesionActivaUsuario(String usuario);
	
	/**
	 * Metodo encargado de guardar la informacion de sesiones
	 * 
	 * @param flujo
	 * @param usuario
	 * @param sesionId
	 * @return
	 */
	Long guardarInformacionSesion(int flujo, String usuario, String sesionId);
	
	/**
	 * Metodo encargado de cerrar la sesion 
	 * 
	 * @param usuario
	 * @return
	 */
	Long guardarCierreSesion(SessionUsuario usuario);
}
