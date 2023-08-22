package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;


/**
 * Repositorio para consultar el catalogo de Subprocesos
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 13:12:30
 */
public interface SubProcesoRepository extends JpaRepository<SubProcesoNegocio, Long> {

	/**
	 * Metodo que recupera lista de SubProcesos a partir del id Proceso
	 * 
	 * @author hjramire
	 * @param idProceso
	 * @return List<SubProcesoNegocio>
	 * @since 20/12/2019, 13:12:43
	 */
	List<SubProcesoNegocio> getByIdProcesoNegocioAndActivo(Long idProceso, int activo);

}
