package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;


import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Reimpresion service
 * @author jmordone
 *
 */
public interface ReimpresionServiceSaldosYMovimientos {
     
	/**
	 * obtenerArchivosServicio
	 * @param folioProcesar
	 * @return
	 * @throws IOException
	 */
	DatosArchivos obtenerArchivosReimpresion(DatosTrabajador trabajador,String tipoDoumento,UsuarioLogin user);
	
	
	/**
	 * enviarCorreoReimpresion
	 * @return
	 */
	RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajado, String folioProcesar,Integer modulo,String claveAgente);
	
	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador);
	
	/**
	 * guardarBitacoraImpresion
	 * @param trabajador
	 * @param user
	 * @param folioPadre
	 * @param modulo
	 */
	void guardarBitacoraImpresion(DatosArchivos datos,Integer modulo,String claveAgente);
	
}
