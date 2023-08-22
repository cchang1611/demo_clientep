package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de Salida de notificaciones
 * 
 * @author jajimene
 * @version 1.0
 * @since Ago 26, 2019
 */
public class SalidaNotificacionActualiza implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1045996531269290292L;

	/**
	 * fechaNotificacion
	 */
	private String fechaNotificacion;
	
	/**
	 * motivoRechazo
	 */
	private String motivoRechazo;
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	public SalidaNotificacionActualiza() {
		super();
	}

	public SalidaNotificacionActualiza(String fechaNotificacion, String motivoRechazo, String resultadoOperacion) {
		super();
		this.fechaNotificacion = fechaNotificacion;
		this.motivoRechazo = motivoRechazo;
		this.resultadoOperacion = resultadoOperacion;
	}

	public String getFechaNotificacion() {
		return fechaNotificacion;
	}

	public void setFechaNotificacion(String fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalidaNotificacionActualiza [fechaNotificacion=");
		builder.append(fechaNotificacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append("]");
		return builder.toString();
	}

}
