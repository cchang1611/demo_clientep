package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;


import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Reimpresion service
 * @author jmordone
 *
 */
public interface ReimpresionServiceFabrica {
     
	/**
	 * obtenerArchivosServicio
	 * @param folioProcesar
	 * @return
	 * @throws IOException
	 */
	ReimpresionService obtenerServicioReimpresion(Integer tramite);
	
	/**
	 * obtenerArchivoPorTramiteSaldosMovimientos
	 * @param modulo
	 * @param trabajador
	 * @return
	 */
	DatosArchivos obtenerArchivoPorTramiteSaldosMovimientos(Integer modulo, DatosTrabajador trabajador,UsuarioLogin user);
	
	
	
}
