package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.EstadoSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;



/**
 * Servicios de Estado de Solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:32:48
 */
public interface EstadoSolicitudService {

	/**
	 * Metodo que recupera lista de Estados catalogados
	 * 
	 * @author hjramire
	 * @return List<EstadoSolicitud>
	 * @throws PlataformaServiciosOperativaServiceException
	 * @since 10/01/2020, 18:32:38
	 */
	List<EstadoSolicitud> recuperarListaEstadosSolicitud() throws PlataformaServiciosOperativaServiceException;

}
