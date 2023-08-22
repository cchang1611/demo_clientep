package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecaudadoraTV;

/**
 * Interfaz ObtenerRecaudadoraPorNrp
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
public interface ObtenerRecaudadoraPorNrpService {
      
	/**
	 *  Metodo obtener ObtenerRecaudadoraPorNrp
	 *  TODO [Agregar documentacion al método]
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param nrp
	 *  @return
	 */
	RecaudadoraTV obtenerRecaudadoraPorNrp(String nrp);
}
