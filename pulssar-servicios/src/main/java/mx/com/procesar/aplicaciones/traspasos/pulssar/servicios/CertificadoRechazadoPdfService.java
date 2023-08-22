package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Oct 10, 2019
 */
public interface CertificadoRechazadoPdfService {

	/**
	 *  generaReporte
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param trabajador
	 *  @return
	 */
	public byte[] generaReporte(DatosTrabajador trabajador, UsuarioLogin usuarioLogin);
	
}
