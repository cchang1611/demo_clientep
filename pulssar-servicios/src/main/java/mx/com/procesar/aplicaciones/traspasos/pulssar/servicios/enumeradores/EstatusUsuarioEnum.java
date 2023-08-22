package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum EstatusUsuarioEnum {
	
	/**
	 * Estatus usuario inactivo
	 */
	USUARIO_INACTIVO("00"),
	
	/**
	 * Estatus usuario activo
	 */
	USUARIO_ACTIVO("01"),
	
	/**
	 * Estatus usuario activo requiere cambio de password
	 */
	USUARIO_ACTIVO_CAMBIO_PASSWORD("02"),
	
	/**
	 * Estatus usuario dado de baja
	 */
	USUARIO_BAJA("03"),
	
	/**
	 * Estatus usuario bloqueado
	 */
	USUARIO_BLOQUEADO("04"),
	
	/**
	 * Estatus usuario reactivado
	 */
	USUARIO_REACTIVADO("05");
	
	/**
	 * Atributo estatus
	 */
	private String estatusUsuario;
	
	/**
	 * Contructor
	 * @param codigoError
	 */
	private EstatusUsuarioEnum(final String estatusUsuario) {
		this.estatusUsuario = estatusUsuario;

	}

	/**
	 * @return the estatusUsuario
	 */
	public String getEstatusUsuario() {
		return estatusUsuario;
	}
}