package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.AforeZonaOficina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.AforeZonaOficinaPK;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Oficina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Zona;

/**
 * Repositorio para tabla de afore zona oficina
 * @author dbarbosa
 *
 */
public interface AforeZonaOficinaRepository extends JpaRepository<AforeZonaOficina, AforeZonaOficinaPK> {
	
	/**
	 * Metodo encargado de obtener las zonas
	 * 
	 * @param cveAfore
	 * @param nuActivo
	 * @return
	 */
	@Query("SELECT DISTINCT(zonafore.zona.clave) FROM AforeZonaOficina zonafore WHERE zonafore.cveAfore = :cveAfore AND zonafore.nuActivo in :estatus ORDER BY zonafore.idZona ASC")
	List<String> findByZonasPorAfore(@Param("cveAfore") String cveAfore, @Param("estatus") List<Integer> nuActivo);
	
	/**
	 * Metodo encargado de obtener las descripciones
	 * 
	 * @param cveAfore
	 * @param nuActivo
	 * @return
	 */
	@Query("SELECT DISTINCT(zonafore.zona) FROM AforeZonaOficina zonafore WHERE zonafore.cveAfore = :cveAfore AND zonafore.zona.clave = :cveZona AND zonafore.nuActivo in :estatus ORDER BY zonafore.idZona ASC")
	List<Zona> findByDescripcionZona(@Param("cveAfore") String cveAfore, @Param("cveZona") String cveZona, @Param("estatus") List<Integer> nuActivo);
	
	/**
	 * Metodo encargado de traer todas las oficinas
	 * 
	 * @param cveAfore
	 * @param idZona
	 * @param nuActivo
	 * @return
	 */
	@Query("SELECT zonafore.oficina FROM AforeZonaOficina zonafore WHERE zonafore.cveAfore = :cveAfore AND zonafore.idZona= :idZona AND zonafore.nuActivo in :estatus ORDER BY zonafore.idZona ASC")
	List<Oficina> findByOficinasPorAforeyZona(@Param("cveAfore") String cveAfore, @Param("idZona") Long idZona, @Param("estatus") List<Integer> nuActivo);
}