package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccesoVIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * Interfaz para el guardado de usaurios
 * @author DBARBOSA
 *
 */
public interface GestionUsuariosService {
	
	/**
	 * Alta de usuario
	 * @param usuario
	 * @param usuarioModificador
	 * @return
	 */
	RespuestaServicio guardarUsuario(DatosRegistro usuario, String usuarioModificador);
	
	/**
	 * Consulta de las IP de una afore
	 * @param claveAfore
	 * @param plataforma
	 * @return
	 */
	List<AccesoVIP> consultarIpsAforePlataforma(String claveAfore, String plataforma);
	
	/**
	 * Metodo encargado de validar las IPs
	 * @param ips
	 * @param afore
	 * @return
	 */
	List<String> validarIps(List<String> ips, String afore, String plataforma);
	
	/**
	 * Metodo encargado de validar las IPs
	 * 
	 * @param ips
	 * @param afore
	 * @return
	 */
	RespuestaServicio guardarIps(List<String> ips, String afore, String plataforma, String usuario);
}
