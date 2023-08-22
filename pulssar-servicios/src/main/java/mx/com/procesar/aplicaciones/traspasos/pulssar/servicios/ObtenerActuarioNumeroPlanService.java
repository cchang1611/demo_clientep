package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado97;

/**
 * Servicio ObtenerActuarioNumeroPlan
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 5, 2021
 */
public interface ObtenerActuarioNumeroPlanService {
    
	RetiroPlanPrivado97 obtenerPlanPrivadoPorActuarioYNumeroPlan(String cvActuario,String numeroPlan);
}
