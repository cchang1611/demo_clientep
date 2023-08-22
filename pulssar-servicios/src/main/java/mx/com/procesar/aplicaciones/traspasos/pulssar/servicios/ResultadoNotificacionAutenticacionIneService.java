package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AutenticacionIne;

/**
 * Interfaz para la administracion de Agentes
 * @author DBARBOSA
 *
 */
public interface ResultadoNotificacionAutenticacionIneService {
	
	/**
	 * Valida la respuesta de la autenticacion por ine
	 * 
	 * @param curp
	 * @return
	 */
	AutenticacionIne validarResultadoAutenticacionIne(String curp);
	
	/**
	 * Metodo encargado de guardar la informacion adicional de
	 * la notificacion
	 * 
	 * @param idUsuario
	 * @param afore
	 * @param curp
	 */
	void guardarDetalleAdicionalAutenticacionIne(Long idUsuario, String afore, String curp);
}
