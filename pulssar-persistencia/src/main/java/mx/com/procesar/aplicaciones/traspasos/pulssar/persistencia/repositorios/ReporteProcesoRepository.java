package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;

/**
 * Repositorio para consulta de Proceos
 * @author DGSANCHE
 */
public interface ReporteProcesoRepository extends JpaRepository<RolReporte, Long> {

	/**
	 * Metodo encargado de obtener los id de Proceso
	 * @param idRolesLista
	 * @param idModulo
	 * @return List <RolReporteProceso>
	 */
	@Query(name = "consultaProcesoPorIdReporteYidModulo", nativeQuery = true)
	Set<RolReporteProceso> encontrarProcesoPorIdReporteYIdModulo(String claveRol, Long idModulo, int banderaActivo);
}
