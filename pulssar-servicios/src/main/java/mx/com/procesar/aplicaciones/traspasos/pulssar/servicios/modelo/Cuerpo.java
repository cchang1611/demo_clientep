package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto cuerpo para el envio de mensaje
 * 
 * @author DBARBOSA
 */
public class Cuerpo implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 3875152454211837337L;

	/**
	 * mensaje
	 */
	private String mensaje;
	
	/**
	 * telefono
	 */
	private String telefono;
	
	/**
	 * pais
	 */
	private String pais;
	
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuerpo [mensaje=");
		builder.append(mensaje);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", pais=");
		builder.append(pais);
		builder.append("]");
		return builder.toString();
	}
}