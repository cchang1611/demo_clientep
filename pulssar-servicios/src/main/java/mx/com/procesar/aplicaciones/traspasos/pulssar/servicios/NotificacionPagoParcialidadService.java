package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import org.springframework.http.HttpStatus;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.NotificacionParcialidadIssste;

/**
 * Interfaz para la invocar el Servicio de la Notificacion Parcialidad
 * @author ANOSORIO
 *
 */
public interface NotificacionPagoParcialidadService {

	/**
	 * Datos para la Notificacion Parcialidad
	 * @param notificaEntrada
	 * @return
	 */
	HttpStatus notificarPagoParcialidad(NotificacionParcialidadIssste notificaEntrada);

}
