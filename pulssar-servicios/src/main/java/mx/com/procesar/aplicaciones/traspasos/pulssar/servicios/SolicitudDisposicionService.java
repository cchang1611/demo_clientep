package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Jun 28, 2019
 */
public interface SolicitudDisposicionService {

	/**
	 *  Generacion de expedientes
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param trabajador
	 *  @param user
	 *  @param retiroDesempleoImss
	 *  @return
	 */
	public String generarExpedientes( DatosTrabajador trabajador, UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss);
	
	
	/**
	 *  solicitud Disposicion llena objeto para mostrar 
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param trabajador
	 *  @param curp
	 *  @param retiroDesempleoImss
	 *  @param user
	 *  @param folio
	 *  @param origen
	 *  @return
	 */
	public SolicitudDisposicionParcialRespuesta solicitudDisposicion( DatosTrabajador trabajador, String curp, RetiroDesempleoImss retiroDesempleoImss, UsuarioLogin user, String folio, String origen);

}