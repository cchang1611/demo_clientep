package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.IretTcDiagnostico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDiagnostico;

/**
 * 
 * @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 29, 2020
 */

public interface ConsultaIretDiagnosticoService {

	/**
	 * Consultar diagnostico
	 * @param cveProceso
	 * @param cveTipoOperacion
	 * @param codigoDiagnostico
	 * @param activo
	 * @return
	 */
	IretTcDiagnostico consultarIretDiagnostico(String cveProceso, String cveTipoOperacion, String codigoDiagnostico,
			String activo);

	/**
	 *  Metodo Consulta diagnostico 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param datos
	 *  @return
	 */
	DatosDiagnostico consultarDiagnostico(DatosDiagnostico datos);
}
