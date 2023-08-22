package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Datos de Salida
 * @author ANOSORIO
 *
 */
public class NotificarParcialidadPagoSalida implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -467311297758669756L;

	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	/**
	 * motivoRechazo
	 */
	private String motivoRechazo;

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * Constructor
	 */
	public NotificarParcialidadPagoSalida() {
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarParcialidadPagoSalida [resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
