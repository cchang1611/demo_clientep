package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Oct 10, 2019
 */
public interface CertificadoAceptadoPdfService {

	/**
	 *  generaReporte
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param trabajador
	 *  @return
	 */
	public byte[] generaReporte(DatosTrabajador trabajador, UsuarioLogin login, String fechaInicio, String fechaFin, String inciso, String numResolucion);
	
}
