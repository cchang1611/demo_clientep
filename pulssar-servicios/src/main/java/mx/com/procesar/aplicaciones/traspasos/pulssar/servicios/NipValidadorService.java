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
 * Proceos de validación de datos en solicitud de Generación de NIPs
 * RFC: WB00288
 */
public interface NipValidadorService {

	/**
	 * Realiza Validaciones de negocio sobre la información entrante para la generación de NIP.
	 * @param trabajador
	 * @param consultaBUU
	 * @return RespuestaServicio
	 */
	public RespuestaServicio validarInformacion(DatosTrabajador trabajador, NipConsultaBUU consultaBUU);
}
