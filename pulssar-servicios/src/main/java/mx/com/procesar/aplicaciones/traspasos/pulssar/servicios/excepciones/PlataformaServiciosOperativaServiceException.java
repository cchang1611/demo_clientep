package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones;

/**
 * Clase para el tratamiento de excepciones a nivel de capa de negocio para
 * Plataforma de Servicios Operativa
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 22/07/2020
 */
public class PlataformaServiciosOperativaServiceException extends Exception {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = -3935703845393668948L;

	/**
	 * atributo para mostrar la causa
	 */
	private static final String CAUSED_BY = "\nCaused by: ";

	/**
	 * variable que guarda la excepcion
	 */
	private final Throwable cause;

	/**
	 * constructor con el mensaje por argumento
	 * 
	 * @author Arturo Eduardo de la Cruz Perez
	 * @param message
	 */
	public PlataformaServiciosOperativaServiceException(String message) {
		super(message);
		this.cause = null;
	}

	/**
	 * Constructor con la excepcion por argumento
	 * 
	 * @author Arturo Eduardo de la Cruz Perez
	 * @param cause
	 */

	public PlataformaServiciosOperativaServiceException(Throwable cause) {
		super();
		this.cause = cause;
	}

	/**
	 * Constructor paso de argumentos
	 * 
	 * @author Arturo Eduardo de la Cruz Perez
	 * @param message
	 * @param cause
	 */
	public PlataformaServiciosOperativaServiceException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

	/**
	 * Metodo que recupera la Excepcion
	 * 
	 * @author Arturo Eduardo de la Cruz Perez
	 * @return {@link Throwable}
	 */
	@Override
	public synchronized Throwable getCause() {
		return cause;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (cause == null) {
			return super.toString();
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(super.toString()).append(CAUSED_BY).append(cause.toString());
			return sb.toString();
		}
	}
}
