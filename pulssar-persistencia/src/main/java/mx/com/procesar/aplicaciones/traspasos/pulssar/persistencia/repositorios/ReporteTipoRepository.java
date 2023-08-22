package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;

/**
 * Repositorio para consulta de tipo reporte
 * @author DGSANCHE
 *
 */
public interface ReporteTipoRepository  extends JpaRepository<RolReporte, Long> {
	
	/**
     * Metodo encargado de obtener los id de Tipo
     * 
     * @param claveRol
     * @param idSubProceso
     * @param banderaActivo
     * @return List<RolReporteTipo>
     */
	 @Query(name = "consultaTipoReportePorIdRolYidSubProceso", nativeQuery = true)
    Set<RolReporteTipo> findByIdRolAndSubproceso(String claveRol, Long idSubProceso, int banderaActivo);
}
