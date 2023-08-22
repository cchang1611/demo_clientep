package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum ArchivosEnum {
	
	/**
	 * Archivo jasper para acuse de enrolamiento
	 */
	ACUSE_ENROLAMIENTO("{afore}/enrolamiento.jasper"),
	
	/**
	 * Archivo jasper para acuse de enrolamiento
	 */
	EXCEPCION_ENROLAMIENTO_JASPER("{afore}/enrolamientoExcepcion.jasper"),
	
	/**
	 * Archivo jasper para acuse de enrolamiento
	 */
	HUELLAS_PDF("manos.jasper"),
	
	/**
	 * Archivo pdf para acuse de enrolamiento con excepcion
	 */
	ACUSE_ENROLAMIENTO_EXCEPCION("{afore}/enrolamientoExcepcion.pdf"),
	
	/**
	 * Tipo Archivo enrolamiento
	 */
	ENROLAMIENTO_TRABAJADOR("01"),
	
	/**
	 * Tipo de expediente biometrico
	 */
	EXPEDIENTE_BIOMETRICO("67"),
	
	/**
	 * Tipo de expediente biometrico BATCH
	 */
	EXPEDIENTE_BIOMETRICO_BATCH("68"),
	
	/**
	 * Tipo de verificacion empleado
	 */
	VERIFICACION_EMPLEADO("03"),
	
	/**
	 * Tipo de verificacion trabajador 4 huellas
	 */
	VERIFICACION_TRABAJADOR_4_HUELLAS("04");
	
	/**
	 * Nombre del archivo
	 */
	private final String nombreArchivo;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private ArchivosEnum(final String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
}