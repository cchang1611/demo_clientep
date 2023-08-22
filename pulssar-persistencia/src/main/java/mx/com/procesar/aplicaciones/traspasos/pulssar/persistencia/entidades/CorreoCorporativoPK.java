package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Representa la clave primaria de Relacion Usuario y Roles, mapeado a la tabla PSER_TR_USER_ROL_PULSSAR
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Embeddable
public class CorreoCorporativoPK implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 3211887154327514059L;
	
	/**
	 * Identificador de la Organizacion.
	 */
	private String claveOrganizacion;
	
	/**
	 * Dominio de Correo Corporativo.
	 */
	private String email;
	
	/**
	 * @return the claveOrganizacion
	 */
	public String getClaveOrganizacion() {
		return claveOrganizacion;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(String claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sobrescritura del metodo toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("UsuarioRolPK [claveOrganizacion=");
		cadena.append(claveOrganizacion);
		cadena.append(", email=");
		cadena.append(email);
		cadena.append("]");
		return cadena.toString();
	}
}