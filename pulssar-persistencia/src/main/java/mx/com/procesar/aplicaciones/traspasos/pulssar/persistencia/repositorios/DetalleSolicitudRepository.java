package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.DetalleSolicitud;



/**
 * Repositorio para detalles de solicitud de reportes
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 12:16:26
 */
public interface DetalleSolicitudRepository extends JpaRepository<DetalleSolicitud, Long> {

	/**
	 * Metodo para obtener un detalle de solicitud de reporte masivo a partir de
	 * diferentes parametros  cuando se tienen fechas  nulas
	 * 
	 * @author hjramire
	 * @param idSolicitudReporte
	 * @param idEstado
	 * @param areaUsuario
	 * @return List<DetalleSolicitud>
	 * @since 20/12/2019, 12:16:39
	 */
	@Query(name = "recuperarDetalleSolicitudId")
	List<DetalleSolicitud> recuperarDetallesDeSolicitudEstado(Long idSolicitudReporte, Long idEstado, Long areaUsuario);
	
	/**
	 * Metodo para obtener un detalle de solicitud de reporte masivo a partir de
	 * diferentes parametros cuando se tienen fechas no nulas
	 * 
	 * @author hjramire
	 * @param idSolicitudReporte
	 * @param idEstado
	 * @param fechaIncial
	 * @param fechaFinal
	 * @param areaUsuario
	 * @return List<DetalleSolicitud>
	 * @since 20/12/2019, 12:16:39
	 */
	@Query(name = "recuperarDetalleSolicitudFechas")
	List<DetalleSolicitud> recuperarDetallesDeSolicitudFechas(Long idSolicitudReporte, Long idEstado, Date fechaIncial,
			Date fechaFinal, Long areaUsuario);

}
