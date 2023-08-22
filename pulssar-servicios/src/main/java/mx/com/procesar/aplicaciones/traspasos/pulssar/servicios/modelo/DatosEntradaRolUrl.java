package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Datos entrada rol url
 * @author RARREOLA
 *
 */
public class DatosEntradaRolUrl implements Serializable{
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1581690847418161636L;

	/**
	 * Clave rol
	 */
	private String identificadorRol;
	
	/**
	 * url
	 */
	private String url;

	/**
	 * @return the claveRol
	 */
	public String getIdentificadorRol() {
		return identificadorRol;
	}

	/**
	 * @param claveRol the claveRol to set
	 */
	public void setIdentificadorRol(String identificadorRol) {
		this.identificadorRol = identificadorRol;
	}

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

		builder.append("DatosEntradaRolUrl [identificadorRol=");
		builder.append(identificadorRol);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");

		return builder.toString();
	}

}
