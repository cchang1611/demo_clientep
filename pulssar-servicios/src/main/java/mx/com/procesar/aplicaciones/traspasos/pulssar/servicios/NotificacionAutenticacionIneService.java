package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AutenticacionIne;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosAutenticacionIne;

/**
 * Notificacion service
 * @author dbarbosa
 *
 */
public interface NotificacionAutenticacionIneService {
	
	/**
	 * Metodo encargado de guardar la notificacion ine
	 * 
	 * @param datosautenticacion
	 */
	void guardarDatosNotificacionAutenticacionIne(AutenticacionIne autentica, String usuario, String folio);
	
}
