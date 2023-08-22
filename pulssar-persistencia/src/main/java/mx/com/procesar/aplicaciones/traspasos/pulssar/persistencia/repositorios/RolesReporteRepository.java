package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;

/**
 * Repositorio para tabla de PSER_TR_ROL_REPORTE
 * @author dbarbosa
 */
public interface RolesReporteRepository extends JpaRepository<RolReporte, Long> {

	/**
	 * Metodo encargado de obtener los id de reportes
	 * @param idRol
	 * @return
	 */
	@Query(name = "consultaModuloPorIdRol", nativeQuery = true)
	List<RolReporte> encontrarModulosPorIdRol(String idRol, int banderaActivo);
}