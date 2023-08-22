package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPDF;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaBase;

/**
 * Clase de servicio para biometricos
 * @author dbarbosa
 *
 */
public interface BiometricoService {

	/**
	 * Metodo encargado de validar la excepcion de la pantalla de biometrico
	 * 
	 * @param curp
	 * @param codigo
	 * @param tipo
	 * @param afore
	 * @return
	 */
	RespuestaBase validarExcepcionPantalla(String curp, String codigo, String tipo, String afore);
	
	/**
	 * Metodo encargado de obtener el acuse del Biometrico
	 * 
	 * @param acuse
	 * @return
	 */
	String generarAcuseBiometrico(EntradaPDF acuse);
	
	/**
	 * Metodo encargado de obtener la firma del trabajador del acuse
	 * 
	 * @param recepcionImagenes
	 * @return
	 * @throws IOException
	 */
	DatosSolicitud recuperarFirmasProceso(RecepcionImagenes recepcionImagenes) throws IOException;
	
}
