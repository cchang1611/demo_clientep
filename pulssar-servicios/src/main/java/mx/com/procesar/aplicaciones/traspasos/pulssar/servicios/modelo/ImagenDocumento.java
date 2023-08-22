/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Imagenes Recuperadas para Vosualizador
 * @author lvgonzal
 *
 */
public class ImagenDocumento implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 6267088526304867015L;
	
	/**
	 * clave tipo Documento
	 */
	private String claveTipoDocumento;
	
	/**
	 * tipo de imagen documento
	 */
	private String tipoImagenDocumento;
	
	/**
	 * nombre docuemnto
	 */
	private String nombreDocumento;
	
	/**
	 * contenido docuemnto
	 */
	private String contenidoDocumento;

	/**
	 * @return the claveTipoDocumento
	 */
	public String getClaveTipoDocumento() {
		return claveTipoDocumento;
	}

	/**
	 * @param claveTipoDocumento the claveTipoDocumento to set
	 */
	public void setClaveTipoDocumento(String claveTipoDocumento) {
		this.claveTipoDocumento = claveTipoDocumento;
	}

	/**
	 * @return the tipoImagenDocumento
	 */
	public String getTipoImagenDocumento() {
		return tipoImagenDocumento;
	}

	/**
	 * @param tipoImagenDocumento the tipoImagenDocumento to set
	 */
	public void setTipoImagenDocumento(String tipoImagenDocumento) {
		this.tipoImagenDocumento = tipoImagenDocumento;
	}

	/**
	 * @return the nombreDocumento
	 */
	public String getNombreDocumento() {
		return nombreDocumento;
	}

	/**
	 * @param nombreDocumento the nombreDocumento to set
	 */
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	/**
	 * @return the contenidoDocumento
	 */
	public String getContenidoDocumento() {
		return contenidoDocumento;
	}

	/**
	 * @param contenidoDocumento the contenidoDocumento to set
	 */
	public void setContenidoDocumento(String contenidoDocumento) {
		this.contenidoDocumento = contenidoDocumento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImagenDocumento [claveTipoDocumento=");
		builder.append(claveTipoDocumento);
		builder.append(", tipoImagenDocumento=");
		builder.append(tipoImagenDocumento);
		builder.append(", nombreDocumento=");
		builder.append(nombreDocumento);
		builder.append(", contenidoDocumento=");
		builder.append(contenidoDocumento);
		builder.append("]");
		return builder.toString();
	}
	
	

}
