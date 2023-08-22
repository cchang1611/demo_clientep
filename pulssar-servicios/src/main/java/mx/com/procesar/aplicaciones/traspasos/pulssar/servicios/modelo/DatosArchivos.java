
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * DatosArchivos
 * @author jmordone
 *
 */
public class DatosArchivos implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -5112047347961452327L;
	/**
	 * 	nombre del archivos
	 */
	private String nombreArchivo;
	/**
	 * byte del archivo 
	 */
	private String byteArchivo;
	
	/** 
	 * obtener el tipo de archivo
	 */
	private String formato;
	
	/**
	 * folioProcesar
	 */
	private String folioProcesar;
	
	/**
	 * errorArchivo
	 */
	private Boolean errorArchivo=Boolean.FALSE;
	
	/**
	 * mensajeError
	 */
	private String mensajeError;
	
	/**
	 * claveError
	 */
	private String claveError;

	/**
	 * idSegTramite
	 */
	private String idSegTramite;

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return the byteArchivo
	 */
	public String getByteArchivo() {
		return byteArchivo;
	}

	/**
	 * @param byteArchivo the byteArchivo to set
	 */
	public void setByteArchivo(String byteArchivo) {
		this.byteArchivo = byteArchivo;
	}

	/**
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * @param formato the formato to set
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar the folioProcesar to set
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * @return the errorArchivo
	 */
	public Boolean getErrorArchivo() {
		return errorArchivo;
	}

	/**
	 * @param errorArchivo the errorArchivo to set
	 */
	public void setErrorArchivo(Boolean errorArchivo) {
		this.errorArchivo = errorArchivo;
	}

	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	/**
	 * @return the claveError
	 */
	public String getClaveError() {
		return claveError;
	}

	/**
	 * @param claveError the claveError to set
	 */
	public void setClaveError(String claveError) {
		this.claveError = claveError;
	}

	/**
	 * @return the idSegTramite
	 */
	public String getIdSegTramite() {
		return idSegTramite;
	}

	/**
	 * @param idSegTramite the idSegTramite to set
	 */
	public void setIdSegTramite(String idSegTramite) {
		this.idSegTramite = idSegTramite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosArchivos [nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append(", byteArchivo=");
		builder.append(byteArchivo);
		builder.append(", formato=");
		builder.append(formato);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", errorArchivo=");
		builder.append(errorArchivo);
		builder.append(", mensajeError=");
		builder.append(mensajeError);
		builder.append(", claveError=");
		builder.append(claveError);
		builder.append(", idSegTramite=");
		builder.append(idSegTramite);
		builder.append("]");
		return builder.toString();
	}
	
	
}

