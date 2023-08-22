package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteGenerico;

/**
 * Repositorio para tabla de PSER_TR_ROL_REPORTE
 * @author EMARTINEZ
 *
 */
public interface RolesReporteGenericoRepository extends JpaRepository<RolReporteGenerico, Long> {
	
	/**
	 * Metodo encargado de obtener los id de reportes generico
	 * 
	 * @param idRoles
	 * @return RolReporteGenerico
	 */
	@Query("SELECT r.idReporteGenerico FROM RolReporteGenerico r WHERE r.idRolPulssar IN :idRols ")
	List<RolReporteGenerico> findByIdRol(@Param("idRols")List<Long> idRols);
}