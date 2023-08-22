package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo;

import java.io.Serializable;

/**
 * Pojo para el manejo de informacion de usaurio en ajax
 * 
 * @author DBARBOSA
 */
public class UsuarioControlador implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -1639502253399744852L;
	
	/**
	 * Usuario de Portal.
	 */
	private String id;
	
	/**
	 * Usuario de Portal.
	 */
	private String usuario;
	
	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno usuario.
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno usuario.
	 */
	private String apellidoMaterno;
	
	/**
	 * Correo Electrónico.
	 */
	private String email;
	
	/**
	 * Celular del usuario.
	 */
	private String celular;
	
	/**
	 * Descripcion de rol
	 */
	private String descripcionRol;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioControlador [usuario=");
		builder.append(usuario);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", email=");
		builder.append(email);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", descripcionRol=");
		builder.append(descripcionRol);
		builder.append("]");
		return builder.toString();
	}
}
