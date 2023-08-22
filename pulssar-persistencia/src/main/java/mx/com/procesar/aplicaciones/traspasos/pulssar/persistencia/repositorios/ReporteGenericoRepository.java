package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;

/**
 * Repositorio para consulta de reportes
 * 
 * @author hjramire
 * @version 1.0
 * @since 09/01/2020, 18:35:17
 */
public interface ReporteGenericoRepository extends JpaRepository<ReporteGenerico, Long> {

    /**
     * Metodo que realiza la consulta de reportes por identificador
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param idReporteGenerico identificador del reporte
     * @return Datos del reporte consultado
     */
    ReporteGenerico getByIdReporteGenerico(Long idReporteGenerico);

    /**
     * Metodo que obtiene la lista de tipos de reporte permitidos para la generacion
     * de reportes genericos
     * 
     * @author hjramire
     * @return List<ReporteGenerico>
     * @since 09/01/2020, 18:35:36
     */
    @Query(name = "getTipoReporteGenerico", nativeQuery = true)
    List<ReporteGenerico> obtenerListaTipoReporteGenerico();

    /**
     * Metodo que obtiene la lista de reportes a partir de subproceso y tipo de
     * reporte
     * 
     * @author hjramire
     * @param idSubproceso
     * @param idTipoReporte
     * @param tipoProcesamiento
     * @param claveRol
     * @param banderaActivo
     * @return List<ReporteGenerico>
     * @since 09/01/2020, 18:35:52
     */
    @Query(name = "getListReporteBySubprocesoAndTipoReporte")
    Set<ReporteGenerico> obtenerListaReportesPorSubprocesoTipoReporte(Long idSubproceso, Long idTipoReporte, int tipoProcesamiento,
        String claveRol, int banderaActivo);

    /**
     * Metodo que obtiene la lista de reportes genericos catalogados a partir de
     * idSubproceso y idTipoReporte
     * 
     * @author hjramire
     * @param idSubProceso
     * @param idTipoReporte
     * @return List<ReporteGenerico>
     * @since 09/01/2020, 18:35:12
     */
    List<ReporteGenerico> getByIdSubprocesoAndIdTipoReporte(Long idSubProceso, Long idTipoReporte);

    /**
     * Metodo que obtiene la lista de reportes genericos catalogados a partir de
     * idSubproceso
     * 
     * @author hjramire
     * @param idSubProceso
     * @return List<ReporteGenerico>
     * @since 09/01/2020, 18:40:43
     */
    List<ReporteGenerico> getByIdSubproceso(Long idSubProceso);

    /**
     * Metodo que recupera subconsultas ordenadas por orden
     * @author hjramire
     * @param idReportePadre
     * @param sort
     * @return List<ReporteGenerico>
     * @since 14/01/2020, 20:40:07
     */
    List<ReporteGenerico> findByIdReportePadre(Long idReportePadre, Sort sort);

}
