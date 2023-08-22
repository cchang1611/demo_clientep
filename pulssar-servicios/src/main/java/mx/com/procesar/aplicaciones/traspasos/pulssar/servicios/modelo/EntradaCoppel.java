package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto que contiene el objeto para el envio de mensaje
 * 
 * @author DBARBOSA
 */
public class EntradaCoppel implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -3448141899209957864L;
	
	/**
	 * idsesion
	 */
	private String idSession;
	
	/**
	 * direccionUrl
	 */
	private String direccionUrl;
	
	/**
	 * numero tienda
	 */
	private String numeroTienda;

	/**
	 * @return the idSession
	 */
	public String getIdSession() {
		return idSession;
	}

	/**
	 * @param idSession the idSession to set
	 */
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	/**
	 * @return the direccionUrl
	 */
	public String getDireccionUrl() {
		return direccionUrl;
	}

	/**
	 * @param direccionUrl the direccionUrl to set
	 */
	public void setDireccionUrl(String direccionUrl) {
		this.direccionUrl = direccionUrl;
	}

	/**
	 * @return the numeroTienda
	 */
	public String getNumeroTienda() {
		return numeroTienda;
	}

	/**
	 * @param numeroTienda the numeroTienda to set
	 */
	public void setNumeroTienda(String numeroTienda) {
		this.numeroTienda = numeroTienda;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaConsulta [ idSession=");
		builder.append(idSession);
		builder.append(", direcionUrl=");
		builder.append(direccionUrl);
		builder.append(", numeroTienda=");
		builder.append(numeroTienda);
		builder.append("]");
		return builder.toString();
	}
}