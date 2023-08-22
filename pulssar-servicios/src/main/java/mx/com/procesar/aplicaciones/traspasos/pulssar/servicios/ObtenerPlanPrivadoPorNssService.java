package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado73;

/**
 * Interfaz ObtenerPlanPrivadoPorNss
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
public interface ObtenerPlanPrivadoPorNssService {

	/**
	 *  Metodo  obtenerPlanPrivadoPorNss
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param nss
	 *  @return
	 */
	RetiroPlanPrivado73 obtenerPlanPrivadoPorNss(String nss);
}
