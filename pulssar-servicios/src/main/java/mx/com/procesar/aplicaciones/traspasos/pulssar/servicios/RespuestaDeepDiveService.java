package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionDomicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionIdentificacion;

/**
 * interfaz servicio para la validación del sello
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface RespuestaDeepDiveService {
	
	/**
	 * Metodo encargado de obtener los valores de ocr con similitudes
	 * 
	 * @param afore
	 * @param curp
	 * @param tipoArchivo
	 * @param tipoExpediente
	 * @return
	 */
	ValidacionDomicilio consultarRespuestaDeepDiveDomicilio(String afore, String curp, String tipoArchivo, String tipoExpediente);
	
	/**
	 * Metodo encargado de obtener los valores de ocr con similitudes
	 * 
	 * @param afore
	 * @param curp
	 * @param tipoArchivo
	 * @param tipoExpediente
	 * @return
	 */
	ValidacionIdentificacion consultarRespuestaDeepDiveIdentificacion(String afore, String curp, String tipoArchivo, String tipoExpediente);
}