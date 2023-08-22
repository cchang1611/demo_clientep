package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Definicion de metodos de operaciones en catalogo de Proceso
 * @author EMARTINEZ
 * @version 1.0
 */
public interface ReporteProcesoService {

    /**
     * Metodo que obtiene la lista de Procesos correspondientes al identificador de Modulo y id
     * ReporteGenerico
     * @author EMARTINEZ
     * @param idRoles
     * @param idModulo
     * @param modulosAsignados
     * @return
     * @throws PlataformaServiciosOperativaServiceException List<RolReporteProceso>
     */
    List<RolReporteProceso> recuperaIdProcesoNegocios(String idRoles, Long idModulo, String modulosAsignados)
        throws PlataformaServiciosOperativaServiceException;

}
