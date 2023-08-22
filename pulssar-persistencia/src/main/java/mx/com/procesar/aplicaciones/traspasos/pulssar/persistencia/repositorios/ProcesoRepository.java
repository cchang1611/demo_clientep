package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;



/**
 * Reporsitorio de catalogo de Proceso de Negocio
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
public interface ProcesoRepository extends JpaRepository<ProcesoNegocio, Long> {

	/**
	 * Consuylta de lista de procesos por idModulo
	 * 
	 * @author hjramire
	 * @param idModulo
	 * @return List<ProcesoNegocio>
	 * @since 03/01/2020, 10:28:38
	 */
	List<ProcesoNegocio> getByIdModuloAndActivo(Long idModulo, int banderaActivo );

}
