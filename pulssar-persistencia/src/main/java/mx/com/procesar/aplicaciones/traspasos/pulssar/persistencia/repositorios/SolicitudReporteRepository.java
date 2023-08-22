package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;



/**
 * Repositorio de solicitud de reporte Masivos
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 12:35:38
 */
public interface SolicitudReporteRepository extends JpaRepository<SolicitudReporte, Long> {

	/**
	 * Metodo que recupera los ultimos 10 registros de solicitud que se han creado
	 * 
	 * @author hjramire
	 * @param areaUsuario
	 * @return List<SolicitudReporte>
	 * @since 20/12/2019, 12:35:51
	 */
	@Query(name = "solicitudesReporteTopten", nativeQuery = true)
	List<SolicitudReporte> recuperarListaSolicitudReporteLimiteRegistros(String areaUsuario);
	
	/**
	 *  Metodo que recupera registro de solicitud por medio de su ID
	 *  @author hjramire
	 *  @param idSolicitud
	 *  @return SolicitudReporte
	 *  @since 28/01/2020, 13:33:47
	 */
	SolicitudReporte getByIdSolicitud(Long idSolicitud);

}
