/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * Permite obtener el complemento de información necesario para la solicitud generación de NIP
 * @author MALOPEZT
 * @since 02/02/2022
 */
public interface NipBUUService {

	/**
	 * Consultar via Rest la BUU para obtener información referente a:
	 * Correo Electrónico
	 * Telefono celular
	 * Si la curp tiene un Nip Activo asociado.
	 * @param curp
	 * @return
	 * @throws BusinessException
	 */
	public NipConsultaBUU consultarDatosBUU(String curp);
}
