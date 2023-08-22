package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes;

/**
 * Clase de constantes para mensajes de Errores
 * @author ralcanra
 *
 */
public final class MensajeConstants {

	
	/**
	 * Perfiles actualizar datos
	 */
	public static final String ERROR_MINIMO_REGISTRO = "El archivo no cumple con el número mínimo de registros";
	
	/**
	 * Perfiles actualizar datos
	 */
	public static final String ERROR_MAXIMO_REGISTRO = "El archivo no cumple con el número máximo de registros";
	
	/**
	 * titulo para el proceso del archivo
	 */
	public static final String TITULO_CARGA_USUARIOS = "Procesando...";
	/**
	 * titulo de error para la carga de usuarios
	 */
	public static final String TITULO_ERROR_CARGA_USUARIOS = "Archivo no procesado";

	/**
	 * MENSJA DE PROCESO DE ARCHIVO
	 */
	public static final String MENSAJE_PROCESO_ARCHIVO = "Se empezo a procesar su archivo, en cuanto finalice, se le notificara con un correo electronico.";

	/**
	 * MENSAJE DE ERROR DE PROCESO ARCHIVO
	 */
	public static final String MENSAJE_ERROR_PROCESO_ARCHIVO = "El archivo contiene los siguientes errores:";

	/**
	 * mensaje de error de no registros en el archivo
	 */
	public static final String ERROR_USUARIOS_NO_REGISTROS = "No cuenta con registros el archivo";

	/**
	 * TITULO GENERICO DE ERROR
	 */
	public static final String ERROR_TITULO_GENERICO = "Ocurrio un error";

	/**
	 * 
	 */
	public static final String ERROR_AFORE_NO_PERMITIDAS = "El archivo no contiene la misma clave o no esta permitida, favor de validar.";

	MensajeConstants() {
		super();
	}
	

}