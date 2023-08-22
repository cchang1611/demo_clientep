/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Proceos de validaci�n de datos en solicitud de Generaci�n de NIPs
 * RFC: WB00288
 */
public interface NipValidadorService {

	/**
	 * Realiza Validaciones de negocio sobre la informaci�n entrante para la generaci�n de NIP.
	 * @param trabajador
	 * @param consultaBUU
	 * @return RespuestaServicio
	 */
	public RespuestaServicio validarInformacion(DatosTrabajador trabajador, NipConsultaBUU consultaBUU);
}
