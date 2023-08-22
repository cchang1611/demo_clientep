package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * 
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 * @param <A>
 */
public class BaseSalidaGenerica<A> implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 5321946647112137884L;

	/**
	 * Atributo codigoOperacion
	 */
	private String codigoOperacion;

	/**
	 * Atributo mensaje
	 */
	private String mensaje;

	/**
	 * Atributo response
	 */
	private A response;

	/**
	 * Obtener codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	/**
	 * Setear codigoOperacion
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	/**
	 * Obtener mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Setear mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtener response
	 */
	public A getResponse() {
		return response;
	}

	/**
	 * Setear response
	 */
	public void setResponse(A response) {
		this.response = response;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseSalidaGenerica [codigoOperacion=");
		builder.append(codigoOperacion);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", response=");
		builder.append(response);
		builder.append("]");
		return builder.toString();
	}
}
