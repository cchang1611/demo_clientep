/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Generación de NIPs
 * RFC: WB00288
 */
public interface NipGeneracionService {

	/**
	 * Realiza en envio de solicitud al servicio de Generación NIPs 
	 * @param datosEntradaNip
	 * @return RespuestaServicioNip
	 * @throws BusinessException
	 */
	public RespuestaServicioNip generarNIP(GeneraNIP datosEntradaNip) throws BusinessException;
}
