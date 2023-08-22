package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;

/**
 * Repositorio para tabla de tipo reporte
 * @author
 *
 */
public interface ReportesSubprocesosRespository extends JpaRepository<RolReporte, Long> {

    /**
     * Metodo encargado de obtener los id de Tipo de reporte
     * @param claveRol
     * @param idSubProceso
     * @param banderaActivo
     * @return List<RolReporteTipo>
     */
    @Query(name = "consultaSubProcesoPorIdRolYidProceso", nativeQuery = true)
    Set<RolReporteSubProceso> findByIdRolAndProceso(String claveRol, Long idSubProceso, int banderaActivo);

}
