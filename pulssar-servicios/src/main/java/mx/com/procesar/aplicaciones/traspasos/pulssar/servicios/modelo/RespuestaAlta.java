package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos para la respuesta de un alta
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class RespuestaAlta implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3514469321447933190L;
	
	/**
	 * identificador usuario
	 */
	private String resultadoOperacion;
	
	/**
	 * Numero de agente
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("RespuestaAlta [resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append("]");

		return builder.toString();
	}

}