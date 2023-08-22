package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Interfaz para la administracion de Tipos de reporte
 * @author EMARTINEZ
 */
public interface ReporteTipoService {

    /**
     * Metodo que recupera la lista de tipo de reporte correspondientes al
     * subproceso
     * 
     * @author EMARTINEZ
     * @param idSubProceso
     * @param idRoles
     * @return ArrayList<RolReporteTipo>
     * @throws PlataformaServiciosOperativaServiceException
     * 
     */
    List<RolReporteTipo> recuperarTipoDeReporteIdSubproceso(String idRoles, Long idSubProceso)
        throws PlataformaServiciosOperativaServiceException;
}
