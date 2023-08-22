package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos que tendran como respuesta generica los
 * servicios
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class SalidaGenerica implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 5321946647112137884L;

	/**
	 * Codigo de respuesta
	 */
	private String codigoOperacion;

	/**
	 * Mensaje de respuesta
	 */
	private String mensaje;

	/**
	 * Objeto de respuesta
	 */
	private Object response;

	/**
	 * @return the codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	/**
	 * @param codigoOperacion
	 *            the codigoOperacion to set
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalidaGenerica [codigoOperacion=" + codigoOperacion + ", mensaje=" + mensaje + ", response=" + response
				+ "]";
	}

}
