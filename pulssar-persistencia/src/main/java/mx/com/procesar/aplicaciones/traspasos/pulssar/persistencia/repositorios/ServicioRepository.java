package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;

/**
 * Repositorio para las operaciones relaciondas con {@link Servicio}.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	/**
	 * Obtiene los servicio a través de su clave.
	 * 
	 * @param claveServicio Clave del Servicio.
	 * 
	 * @return Conjunto de Servicios.
	 */
	@Query("SELECT servicio FROM Servicio servicio WHERE servicio.claveServicio LIKE CONCAT('%',:claveServicio,'%') ORDER BY servicio.claveServicio" )
	Set<Servicio> findByClaveServicio(@Param("claveServicio") String claveServicio);
}
