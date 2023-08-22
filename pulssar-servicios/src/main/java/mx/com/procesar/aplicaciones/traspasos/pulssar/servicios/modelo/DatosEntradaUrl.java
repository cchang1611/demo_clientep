package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Datos entrada  url
 * @author RARREOLA
 *
 */
public class DatosEntradaUrl implements Serializable{
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1581690847418161636L;
	
	/**
	 * url
	 */
	private String url;


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosEntradaUrl [url=");
		builder.append(url);
		builder.append("]");

		return builder.toString();
	}

}
