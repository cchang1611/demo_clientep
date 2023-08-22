/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTiempoTramiteMod;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;

/**
 * Service para las notificaciones
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 20/04/2020
 */
public interface NotificacionService {
	
	/**
	 *  Notificacion de la seleccion del tipo de retiro
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param entrada
	 *  @param salida
	 *  @param nss
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	void notificarTipoRetiro(ParametrosRetiroParcialCalculoImss entrada, RespuestaServicioRetiroParcialCalculo salida, String nss, String curp, String afore);
	
	/**
	 *  Notificacion operacion 52
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param entrada
	 *  @param salida
	 *  @param folioJ
	 *  @return
	 */
	void notificarPeracion52(SolicitudDisposicionParcialEntrada entrada, SolicitudDisposicionParcialSalida salida, String folio);
	
	/**
	 * Metodo que notifica tiempo de tramite
	 * @param notificacionTiempo
	 */
	void notificarTiempoTramite(NotificacionTiempoTramiteMod notificacionTiempo);
	
	/**
	 * Metodo que notifica la cus
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param cus
	 *  @param afore
	 *  @param folio
	 *  @param extra
	 */
	void notificarCus(RespuestaGeneraCusSalida cus, String afore, String folio, String extra);

}
