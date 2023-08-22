package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * Reimpresion service
 * @author jmordone
 *
 */
public interface ReimpresionService {
     
	/**
	 * obtenerArchivosServicio
	 * @param folioProcesar
	 * @return
	 * @throws IOException
	 */
	DatosArchivos obtenerArchivosReimpresion(DatosTrabajador trabajador) throws IOException;
	
	
	/**
	 * enviarCorreoReimpresion
	 * @return
	 */
	RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador,String folioProcesar,Integer modulo,String claveAgente);
	
	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador);

	
}
