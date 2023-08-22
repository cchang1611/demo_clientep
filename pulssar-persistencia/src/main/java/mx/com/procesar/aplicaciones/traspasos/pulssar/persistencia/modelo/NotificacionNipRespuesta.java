/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Transporte de salida - Servicio de Notificación de generación de Nip
 * @author malopezt
 * @since 2022/02/23
 */
public class NotificacionNipRespuesta implements Serializable {

	/**Serial Id */
	private static final long serialVersionUID = -20220223090900L;
	
	/** Indica si se ha aplicado la solicitud de replica en la tabla conrrespondiente */
	private String notificacionAplicada;
	
	/** Motivo por el que fue rechazada la operación*/
	private String motivoRechazo;
	
	/** Folio al que se le genera la solicitud Replica */
	private String folioPulssar;
	
	/** Simple sobrecarga genérica*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{NotificacionNipSalida: [folioPulssar:").append(folioPulssar).append(", ");
		sb.append("notificacionAplicada:").append(notificacionAplicada).append(", ");
		sb.append("motivoRechazo: ").append(motivoRechazo).append("]}");
		return sb.toString();
	}

	/**
	 * @return the notificacionAplicada
	 */
	public String getNotificacionAplicada() {
		return notificacionAplicada;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @return the folioPulssar
	 */
	public String getFolioPulssar() {
		return folioPulssar;
	}

	/**
	 * @param notificacionAplicada the notificacionAplicada to set
	 */
	public void setNotificacionAplicada(String notificacionAplicada) {
		this.notificacionAplicada = notificacionAplicada;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @param folioPulssar the folioPulssar to set
	 */
	public void setFolioPulssar(String folioPulssar) {
		this.folioPulssar = folioPulssar;
	}
	
}
