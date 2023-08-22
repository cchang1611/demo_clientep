package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Representa la clave que contiene las llaves primarias de Usuario nick
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Embeddable
public class UsuarioNickPulssarPK implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 3211887154327514059L;
	
	/**
	 * Identificador de usuario Pulssar.
	 */
	private Long identificadorUsuario;
	
	/**
	 * Nick usuario.
	 */
	private String nickUsuario;
	
	/**
	 * @return the identificadorUsuario
	 */
	public Long getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	/**
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Long identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	/**
	 * @return the nickUsuario
	 */
	public String getNickUsuario() {
		return nickUsuario;
	}

	/**
	 * @param nickUsuario the nickUsuario to set
	 */
	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

	/**
	 * Sobrescritura del metodo toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("UsuarioNickPulssarPK [identificadorUsuario=");
		cadena.append(identificadorUsuario);
		cadena.append(", nickUsuario=");
		cadena.append(nickUsuario);
		cadena.append("]");
		return cadena.toString();
	}
}