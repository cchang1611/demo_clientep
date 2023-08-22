package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum TelefonoEnum {
	
	/**
	 * Telefono Personal
	 */
	PERSONAL("01"),
	
	/**
	 * Telefono Casa
	 */
	CASA("02"),
	
	/**
	 * Telefono Laboral
	 */
	LABORAL("03");
	
	/**
	 * Atributo rol
	 */
	private String clave;
	
	/**
	 * Contructor
	 * @param codigoError
	 */
	private TelefonoEnum(final String clave) {
		this.clave = clave;

	}

	/**
	 * @return the rol
	 */
	public String getClave() {
		return clave;
	}
}