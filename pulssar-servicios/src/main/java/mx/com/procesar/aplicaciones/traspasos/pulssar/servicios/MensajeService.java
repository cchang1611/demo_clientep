package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

/**
 * interfaz servicio de mensajeria para la administracion por sms
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface MensajeService {
	
	/**
	 * Metodo encargado de enviar el sms a los trabajadores
	 * 
	 * @param mensaje
	 * @param celular
	 * @return 
	 */
	public void enviarMensaje(String mensaje, String celular);
}
