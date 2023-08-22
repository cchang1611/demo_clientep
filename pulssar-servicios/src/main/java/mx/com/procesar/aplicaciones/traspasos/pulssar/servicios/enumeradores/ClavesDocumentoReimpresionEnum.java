package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * ClavesDocumentoReimpresionEnum
 * @author jmordone
 *
 */
public enum ClavesDocumentoReimpresionEnum {
	
	/**
	 * Consentimiento enrolamiento
	 */
	CONSENTIMENTO_ENROLAMIENTO("96","Documento Consentimiento Enrolamiento"),
	
	/**
	 * Solciitud modificacion de datos
	 */
	SOLICITUD_MODIFICACION_DATOS("69","Documento Solicitud Modificación de Datos");
	
	
	/**
	 * claveDocumento
	 */
	private final String claveDocumento;
	
	/**
	 * Descripcion
	 */
	private final String descripcion;
	

	/**
	 * Constructor
	 * 
	 * @param claveDocumento
	 * @param descripcion
	 */
	private ClavesDocumentoReimpresionEnum(final String claveDocumento,final String descripcion) {
		this.claveDocumento = claveDocumento;
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the claveDocumento
	 */
	public String getClaveDocumento() {
		return claveDocumento;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	

	/**
	 * @param clave
	 */
	public static ClavesDocumentoReimpresionEnum obtenerDescripcion(final String claveDocumento) {
		ClavesDocumentoReimpresionEnum regreso = null;
		for (final ClavesDocumentoReimpresionEnum e : ClavesDocumentoReimpresionEnum.values()) {
			if (e.getClaveDocumento().equals(claveDocumento)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}