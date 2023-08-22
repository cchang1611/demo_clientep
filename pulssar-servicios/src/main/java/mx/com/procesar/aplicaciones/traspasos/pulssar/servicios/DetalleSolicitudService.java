package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.Date;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.DetalleSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;



/**
 * Definicion de servicios para detalles de solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:33:17
 */
public interface DetalleSolicitudService {

	/**
	 * Metodo que recupera lista de Detalles de Solicitud
	 * 
	 * @author hjramire
	 * @param areaUsuario
	 * @param numSolicitud
	 * @param idEstado
	 * @param fechaInicio
	 * @param fechaFin
	 * @return List<DetalleSolicitud>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:33:28
	 */
	List<DetalleSolicitud> recuperarListaDetalleSolicitudPorParams(String areaUsuario, Long numSolicitud, Long idEstado,
			Date fechaInicio, Date fechaFin) throws PlataformaServiciosOperativaServiceException;

}
