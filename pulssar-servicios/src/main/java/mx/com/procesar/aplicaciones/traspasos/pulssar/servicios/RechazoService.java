package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;

/**
 * interfaz servicio para obtener un rechazo
 *  
 * @author mahernan
 * @version 1.0
 */
public interface RechazoService {

	/**
	 * Metodo encargado de obtener el rechazo a partir del codigo
	 * 
	 * @param codigo
	 * @return
	 */
	RechazoPulssar obtenerRechazo(String codigo, String claveAfore);
}
