/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * Se encarga de la inserción de los elementos que irán a la replica en BD, en cada afore
 * @author MALOPEZT
 * @since 2022/02/08
 */
public interface NipReplicaService {

	/**
	 * Persiste el objeto a replicar a la afore correspondiente. 
	 * Lo cual ocurre vía TEL desde un proceso de BD
	 * @param respuestaServicio
	 * @param datosEntradaNip
	 * @param fechahoraSoliciutd
	 * @param usuarioModificador
	 * @param folio
	 * @param sucursal
	 * @throws BusinessException
	 */
	public void guardarReplicaNip(RespuestaServicioNip respuestaServicio, GeneraNIP datosEntradaNip,
			Date fechahoraSoliciutd, String usuarioModificador, String folio, String sucursal) throws BusinessException; 
}
