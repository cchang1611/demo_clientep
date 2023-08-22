/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * Consumir servicio Rest
 * @author MALOPEZT
 * @since 2022/02/03
 */
public interface ConsumeServicioRestService {

	/**
	 * Consume Servicio con la entrada Json
	 * @param strJson
	 * @return
	 * @throws BusinessException
	 */
	public String enviar(String endPoint, String strJson) throws BusinessException;
	
	
	/**
	 * Consume Servicio con la entrada Json - Sin agregar headers 
	 * @param strJson
	 * @return
	 * @throws BusinessException
	 */
	public String enviarToServicioInterno(String endPoint, String strJson) throws BusinessException;
	
	/**
	 * Consulta Servicio con la entrada Json - Sin agregar headers
	 * @param strJson
	 * @return
	 * @throws BusinessException
	 */
	public String consultarToServicioInterno(String endPoint, String strJson) throws BusinessException;
}
