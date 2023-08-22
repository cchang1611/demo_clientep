package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class Telefono implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -1177409299050069607L;
	
	/**
	 * Telefono Fijo
	 */
	private String telefonoFijo;
	
	/**
	 * Telefono Celular
	 */
	private String celular;
	
	/**
	 * Telefono Laboral
	 */
	private String telefonoLaboral;
	
	/**
	 * Extension
	 */
	private String extension;
	
	/**
	 * indicadorDeTelefono1
	 */
	private String indicadorDeTelefono1;
	
	/**
	 * indicadorDeTelefono2
	 */
	private String indicadorDeTelefono2;
	
	/**
	 * extension2
	 */
	private String extension2;
	
	/**
	 * @return the telefonoFijo
	 */
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	/**
	 * @param telefonoFijo the telefonoFijo to set
	 */
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the telefonoLaboral
	 */
	public String getTelefonoLaboral() {
		return telefonoLaboral;
	}

	/**
	 * @param telefonoLaboral the telefonoLaboral to set
	 */
	public void setTelefonoLaboral(String telefonoLaboral) {
		this.telefonoLaboral = telefonoLaboral;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return indicadorDeTelefono1
	 */
	public String getIndicadorDeTelefono1() {
		return indicadorDeTelefono1;
	}

	/**
	 * @param indicadorDeTelefono1 the indicadorDeTelefono1 to set
	 */
	public void setIndicadorDeTelefono1(String indicadorDeTelefono1) {
		this.indicadorDeTelefono1 = indicadorDeTelefono1;
	}

	/**
	 * @return indicadorDeTelefono2
	 */
	public String getIndicadorDeTelefono2() {
		return indicadorDeTelefono2;
	}

	/**
	 * @param indicadorDeTelefono2 theindicadorDeTelefono2 to set 
	 */
	public void setIndicadorDeTelefono2(String indicadorDeTelefono2) {
		this.indicadorDeTelefono2 = indicadorDeTelefono2;
	}

	/**
	 * @return extension2
	 */
	public String getExtension2() {
		return extension2;
	}

	/**
	 * @param extension2 the extension2 to set
	 */
	public void setExtension2(String extension2) {
		this.extension2 = extension2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefono [telefonoFijo=");
		builder.append(telefonoFijo);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", telefonoLaboral=");
		builder.append(telefonoLaboral);
		builder.append(", extension=");
		builder.append(extension);
		builder.append("]");
		return builder.toString();
	}
}