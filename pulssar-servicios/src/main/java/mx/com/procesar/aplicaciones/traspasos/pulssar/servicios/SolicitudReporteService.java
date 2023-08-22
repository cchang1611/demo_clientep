package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;



/**
 * Servicio de administacion de solicitudes de reportes masivos
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:30:46
 */
public interface SolicitudReporteService {

	/**
	 * Metodo que registra una nueva solicitud de reporte masivo
	 * 
	 * @author hjramire
	 * @param idReporteGenerico
	 * @param nombreArchivoSolicitud
	 * @param rutaArchivoSolicitud
	 * @return SolicitudReporte
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:30:58
	 */
	SolicitudReporte generarSolicitudReporte(Long idReporteGenerico, String nombreArchivoSolicitud,
			String rutaArchivoSolicitud) throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo que realiza la actualizacion del estatus de registro de solicitud
	 * 
	 * @author hjramire
	 * @param solicitudReporte
	 * @param estatus
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:31:13
	 */
	void actualizarEstatusSolicitud(SolicitudReporte solicitudReporte, Long estatus)
			throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo para realizar la actualizacion del registro de solicitud
	 * 
	 * @author hjramire
	 * @param solicitudReporte
	 * @return SolicitudReporte
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:31:37
	 */
	SolicitudReporte actualizarRegistroSolicitud(SolicitudReporte solicitudReporte)
			throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo que realiza la recuperacion de la lista de Solicitudes de Reportes
	 * Masivos
	 * 
	 * @author hjramire
	 * @param areauUsario
	 * @return List<SolicitudReporte>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:31:52
	 */
	List<SolicitudReporte> recuperarSolicitudes(String areauUsario) throws PlataformaServiciosOperativaServiceException;

	/**
	 * Metodo que realiza la recuperacion de la Solicitud de Reportes Masivos por ID
	 * 
	 * @author hjramire
	 * @param id
	 * @return SolicitudReporte
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:32:07
	 */
	SolicitudReporte recuperarSolicitudPorId(Long id) throws PlataformaServiciosOperativaServiceException;

}
