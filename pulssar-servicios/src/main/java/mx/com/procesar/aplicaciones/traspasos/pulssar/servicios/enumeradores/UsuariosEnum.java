package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum UsuariosEnum {
	
	/**
	 * Rol usuarios
	 */
	USUARIOS("USUARIOS"),
	
	/**
	 * Rol Administradores
	 */
	ADMINISTRADORES("ADMINISTRADORES");
	
	/**
	 * Cadena Rol
	 */
	private String rol;
	
	/**
	 * Constructor
	 * 
	 * @param rol
	 */
	UsuariosEnum(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
}