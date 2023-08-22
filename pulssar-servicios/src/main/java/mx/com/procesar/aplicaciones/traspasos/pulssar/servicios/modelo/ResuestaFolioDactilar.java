package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de respuesta ResuestaFolioDactilar
 * 
 * @author AJPORTIL
 *
 */
public class ResuestaFolioDactilar implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -5004383612168892222L;

	/**
	 * respuesta
	 */
	private Sello respuesta;

	/**
	 * resultado de la Operacion
	 */
	private String resultadoOperacion;

	/**
	 * Constructor 
	 */
	public ResuestaFolioDactilar() {
		super();
	}

	/**
	 * @return the respuesta
	 */
	public Sello getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(Sello respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion
	 *            the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResuestaFolioDactilar [respuesta=");
		builder.append(respuesta);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append("]");
		return builder.toString();
	}

}
