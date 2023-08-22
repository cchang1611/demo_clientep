package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;

/**
 * interfaz servicio Correo para la administracion de envio de correo electronico
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface CorreoService {
	
	/**
	 * Proceso encargado de construir y enviar el correo a los destinatarios
	 * 
	 * @param datosCorreo
	 * @param afore
	 */
	public void envioCorreo(DatosCorreo datosCorreo, String afore);
}
