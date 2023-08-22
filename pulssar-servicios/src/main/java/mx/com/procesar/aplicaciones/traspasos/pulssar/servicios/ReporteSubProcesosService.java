package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Definicion de metodos de operacion en repositorio de Subproceso
 * 
 * @author DESANCHEZ
 * @version 1.0
 */
public interface ReporteSubProcesosService {

	/**
	 * Metodo que recupera la lista de subprocesos catalogados correspondientes al
	 * proceso
	 * 
	 * @author DGSANCHEZ
	 * @param idProceso
	 * @param idRoles
	 * @return
	 * @throws PlataformaServiciosOperativaServiceException
	 *             List<RolReporteProceso>
	 */
    List<RolReporteSubProceso> recuperarSubprocesosPorIdProceso(String idRoles, Long idProceso)
        throws PlataformaServiciosOperativaServiceException;

}
