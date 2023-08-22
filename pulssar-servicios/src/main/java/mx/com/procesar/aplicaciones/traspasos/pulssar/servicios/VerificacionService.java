/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PeticionTomaHuellaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Interface de verificacion de 
 * @author dhernand
 *
 */

public interface VerificacionService {

	
	/**
	 * Genera la petcion de Una huella para empleado coppel
	 */
	PeticionTomaHuellaCoppel generarPeticionUnaHuella(UsuarioLogin user,Folio folio);

	/**
	 * Genera el folio Hijo
	 * @param user
	 * @return
	 */
	Folio obtenerFolioHijo(UsuarioLogin user);

	/**
	 * Genera la peticion de huellas
	 * @param folioHijo
	 * @param user
	 * @param expediente
	 * @return
	 */
	RespuestaServicio validaEmpleadoVistaJson(Folio folioHijo, UsuarioLogin user, Expediente expediente) throws Exception;
}
