package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.excepciones;

/**
 * Clase para el manejo de las excepciones para la parte web de Plataforma de Servicios Operativa
 * 
 * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com.mx)
 * @version 1.0
 * @since 2017
 */
public class PlataformaOperativaWebException extends Exception {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8943847691390373143L;

	/**
	 * Atributo para mostrar la causa
	 */
	private static final String CAUSED_BY = "\nCaused by: ";

	/**
	 * Variable que guarda la excepcion
	 */
	private final Throwable cause;

	/**
	 * Constuctor con mensaje como argumento
	 * 
	 * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com.mx)
	 * @param message
	 */
	public PlataformaOperativaWebException(String message) {
		super(message);
		this.cause = null;
	}

	/**
	 * Constructor con la excepci&oacute;n como argumento
	 * 
	 * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com.mx)
	 * @param cause
	 */
	public PlataformaOperativaWebException(Throwable cause) {
		super();
		this.cause = cause;
	}

	/**
	 * Constructor con la excepci&oacute;n y el mensaje como argumentos
	 * 
	 * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com.mx)
	 * @param message
	 *            - El mensaje de error
	 * @param cause
	 *            - La excepci&oacute;n origen
	 */

	public PlataformaOperativaWebException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

	/**
	 * Sobreescritura del metododo toString().
	 */
	@Override
	public String toString() {
		StringBuilder builder;
		if (cause == null) {
			return super.toString();
		} else {
			builder = new StringBuilder();
			builder.append(super.toString()).append(CAUSED_BY).append(cause.toString());
			return builder.toString();
		}
	}
}