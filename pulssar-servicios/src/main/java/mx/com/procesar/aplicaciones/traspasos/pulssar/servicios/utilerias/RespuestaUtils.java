package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;

/**
 * interfaz de la utileria de respuesta
 * 
 * @author mahernan
 * @version 1.0
 */
public interface RespuestaUtils {
	
	/**
	 * Metodo encargado de agregar el detalle de la respuesta
	 * @param flujo
	 * @param titulo
	 * @param mensaje
	 * @return
	 */
	Respuesta obtenerRespuesta(Integer flujo, String titulo, String mensaje);
}