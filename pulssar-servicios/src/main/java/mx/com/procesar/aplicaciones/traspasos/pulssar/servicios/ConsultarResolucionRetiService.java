package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionReti;
/**
 * 
 * Consulta Resolucion
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * 
 */
public interface ConsultarResolucionRetiService {

	ResolucionReti consultarResolucionReti(Long idProcesar, String cvTipoOperacion, String cvProceso);
}
