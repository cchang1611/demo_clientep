package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum CorreoEnum {
	
	/**
	 * Archivo html para el correo de alta de usuario
	 */
	ARCHIVO_ALTA_USUARIO("Portal de Servicios Alta de usuario", "altaUsuario.html"),
	
	/**
	 * Archivo html para el correo de recuperacion de password
	 */
	ARCHIVO_RECUPERA_PASSWORD("Portal de Servicios Recuperación de Contraseña", "recuperaPassword.html"),
	
	/**
	 * Archivo html para el correo de asignacion de perfil
	 */
	ARCHIVO_ASIGNACION_PERFIL("Portal de Servicios Asignación de perfil a usuario", "asignacionPerfil.html"),
	
	/**
	 * Archivo html para el correo de codigo
	 */
	ARCHIVO_RECUPERA_DATOS("Portal de Servicios Recuperación de Datos", "recuperaDatos.html"),
	
	/**
	 * Archivo html para el correo de codigo
	 */
	ARCHIVO_RECUPERA_CODIGO("Portal de Servicios Recuperación de Código", "recuperaCodigo.html"),
	
	/**
	 * Archivo reimpresión documentos
	 */
	ARCHIVO_REIMPRESION("Portal de servicios AcceSAR | Comprobante de trámite", "reimpresion.html"),
	
	/**
	 * Archivo reimpresión documentos
	 */
	ARCHIVO_REIMPRESION_SALDOS_MOVIMIENTOS("Portal de servicios AcceSAR | Información de la cuenta individual", "reimpresionSaldosYMovimientos.html");
	
	/**
	 * Asunto
	 */
	private final String asunto;
	
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
	private CorreoEnum(final String asunto, final String nombreArchivo) {
		this.asunto = asunto;
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
}