package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosNoCertificables implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3247864687660958859L;

	/**
	 * RFC del trabajador
	 */
	private String rfc;
	
	
	/**
	 * clave nacionalidad
	 */
	private Long claveNacionalidad;
	
	/**
	 * Clave tipo documento probatorio
	 */
	private Long claveTipoDocProbatorio;
	
	/**
	 * Folio Solicitud
	 */
	private String folioSolicitud;
	
	/**
	 * Documento Probatorio
	 */
	private String documentoProbatorio;

	/**
	 * Folio documento Probatorio
	 */
	private String folioDocumentoProbatorio;
	
	/**
	 * Ocupacion
	 */
	private String claveOcupacion;
	
	/**
	 * Giro
	 */
	private String claveGiro;

	/**
	 * nivel de estudios
	 */
	private String estudios;
	
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}

	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	/**
	 * @return the documentoProbatorio
	 */
	public String getDocumentoProbatorio() {
		return documentoProbatorio;
	}

	/**
	 * @param documentoProbatorio the documentoProbatorio to set
	 */
	public void setDocumentoProbatorio(String documentoProbatorio) {
		this.documentoProbatorio = documentoProbatorio;
	}

	/**
	 * @return the folioDocumentoProbatorio
	 */
	public String getFolioDocumentoProbatorio() {
		return folioDocumentoProbatorio;
	}

	/**
	 * @param folioDocumentoProbatorio the folioDocumentoProbatorio to set
	 */
	public void setFolioDocumentoProbatorio(String folioDocumentoProbatorio) {
		this.folioDocumentoProbatorio = folioDocumentoProbatorio;
	}

	/**
	 * @return the estudios
	 */
	public String getEstudios() {
		return estudios;
	}

	/**
	 * @param estudios the estudios to set
	 */
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	/**
	 * @return the claveOcupacion
	 */
	public String getClaveOcupacion() {
		return claveOcupacion;
	}

	/**
	 * @param claveocupacion the claveOcupacion to set
	 */
	public void setClaveOcupacion(String claveOcupacion) {
		this.claveOcupacion = claveOcupacion;
	}

	/**
	 * @return the claveGiro
	 */
	public String getClaveGiro() {
		return claveGiro;
	}

	/**
	 * @param claveGiro the claveGiro to set
	 */
	public void setClaveGiro(String claveGiro) {
		this.claveGiro = claveGiro;
	}



	/**
	 * @return the claveNacionalidad
	 */
	public Long getClaveNacionalidad() {
		return claveNacionalidad;
	}

	/**
	 * @param claveNacionalidad the claveNacionalidad to set
	 */
	public void setClaveNacionalidad(Long claveNacionalidad) {
		this.claveNacionalidad = claveNacionalidad;
	}

	/**
	 * @return the claveTipoDocProbatorio
	 */
	public Long getClaveTipoDocProbatorio() {
		return claveTipoDocProbatorio;
	}

	/**
	 * @param claveTipoDocProbatorio the claveTipoDocProbatorio to set
	 */
	public void setClaveTipoDocProbatorio(Long claveTipoDocProbatorio) {
		this.claveTipoDocProbatorio = claveTipoDocProbatorio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosNoCertificables [rfc=");
		builder.append(rfc);
		builder.append(", claveNacionalidad=");
		builder.append(claveNacionalidad);
		builder.append(", claveTipoDocProbatorio=");
		builder.append(claveTipoDocProbatorio);
		builder.append(", folioSolicitud=");
		builder.append(folioSolicitud);
		builder.append(", documentoProbatorio=");
		builder.append(documentoProbatorio);
		builder.append(", folioDocumentoProbatorio=");
		builder.append(folioDocumentoProbatorio);
		builder.append(", claveOcupacion=");
		builder.append(claveOcupacion);
		builder.append(", claveGiro=");
		builder.append(claveGiro);
		builder.append(", estudios=");
		builder.append(estudios);
		builder.append("]");
		return builder.toString();
	}
}