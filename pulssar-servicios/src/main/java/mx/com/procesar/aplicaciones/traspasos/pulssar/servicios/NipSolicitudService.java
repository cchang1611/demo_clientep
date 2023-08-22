/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaGeneraNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Proceso de solicitud de Generación de NIPs
 * RFC: WB00288
 */
public interface NipSolicitudService {

	/**
	 * Realizar proceso completo de generación de NIP 
	 * @param datosEntradaNip
	 * @param usuarioModificador
	 * @param folio
	 * @param sucursar
	 * @return RespuestaGeneraNip
	 * @throws BusinessException
	 */
	public RespuestaGeneraNip solicitarNIP(GeneraNIP datosEntradaNip, String usuarioModificador, String folio, String sucursal) throws BusinessException;
}
