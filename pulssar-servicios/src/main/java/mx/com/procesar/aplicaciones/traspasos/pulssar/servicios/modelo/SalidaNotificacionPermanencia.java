package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de Salida de notificaciones
 * 
 * @author jajimene
 * @version 1.0
 * @since Ago 26, 2019
 */
public class SalidaNotificacionPermanencia implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2668954427134768394L;

	/**
	 * motivoRechazo
	 */
	private String motivoRechazo;
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	public SalidaNotificacionPermanencia() {
		super();
	}

	public SalidaNotificacionPermanencia(String motivoRechazo, String resultadoOperacion) {
		super();
		this.motivoRechazo = motivoRechazo;
		this.resultadoOperacion = resultadoOperacion;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalidaNotificacionPermanencia [motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append("]");
		return builder.toString();
	}

}
