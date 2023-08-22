package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum RolesEnum {
	
	/**
	 * Rol super administrador
	 */
	SUPER_ADMINISTRADOR("01"),
	
	/**
	 * Rol Operativo Procesar
	 */
	OPERATIVO_PROCESAR("02"),
	
	/**
	 * Rol Administrador Afore
	 */
	ADMINISTRADOR_AFORE("03"),
	
	/**
	 * Rol Operativo Afore
	 */
	OPERATIVO_AFORE("04"),
	
	/**
	 * Rol agente Ventanilla
	 */
	AGENTE_VENTANILLA("05"),
	
	/**
	 * Ejecutivo unitario
	 */
	EJECUTIVO_UNITARIO("07"),
	
	/**
	 * Rol Call Center
	 */
	EJECUTIVO_RECEPCION("08"),
	
	/**
	 * Rol Call Center
	 */
	EJECUTIVO_DE_ATENCION("09");
	
	/**
	 * Atributo rol
	 */
	private String rol;
	
	/**
	 * Contructor
	 * @param codigoError
	 */
	private RolesEnum(final String rol) {
		this.rol = rol;

	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
}