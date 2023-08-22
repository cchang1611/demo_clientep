package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo;

import java.io.Serializable;


/**
 * Clase de Usuario Banamex
 * @author hjramire
 * @version 1.0
 * @since Oct 18, 2021
 */
public class UsuarioBanamex implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = 168827363964672711L;

	/**
	 * Atributo de usuario
	 */
	private String usuario;

	/**
	 * Atributo de Rol
	 */
	private String rol;

	/**
	 * Clave de Rol del usuario
	 */
	private String claveRol;

	/**
	 * Atributo de Bandera para identificar si el rol es de perfil de Comparador
	 */
	private Boolean isRolValido;

	/**
	 * Intero que determina el tipo de Rol
	 */
	private Integer tipoRol;

	/**
	 * Constructor vacio por default
	 * @author hjramire
	 */
	public UsuarioBanamex() {
		// Vacio por default
	}

	/**
	 * Constructor por parametros
	 * @author hjramire
	 * @param usuario
	 * @param rol
	 * @param isComparador
	 */
	public UsuarioBanamex(String usuario, String rol, Boolean isRolValido) {
		super();
		this.usuario = usuario;
		this.rol = rol;
		this.isRolValido = isRolValido;
	}

	/**
	 * @return el atributo usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario parametro usuario a actualizar
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el atributo rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol parametro rol a actualizar
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return el atributo claveRol
	 */
	public String getClaveRol() {
		return claveRol;
	}

	/**
	 * @param claveRol parametro claveRol a actualizar
	 */
	public void setClaveRol(String claveRol) {
		this.claveRol = claveRol;
	}

	/**
	 * @param isRolValido parametro isRolValido a actualizar
	 */
	public void setIsRolValido(Boolean isRolValido) {
		this.isRolValido = isRolValido;
	}

	/**
	 * @return el atributo isRolValido
	 */
	public Boolean getIsRolValido() {
		return isRolValido;
	}

	/**
	 * @return el atributo tipoRol
	 */
	public Integer getTipoRol() {
		return tipoRol;
	}

	/**
	 * @param tipoRol parametro tipoRol a actualizar
	 */
	public void setTipoRol(Integer tipoRol) {
		this.tipoRol = tipoRol;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioBanamex [usuario=");
		builder.append(usuario);
		builder.append(", rol=");
		builder.append(rol);
		builder.append(", claveRol=");
		builder.append(claveRol);
		builder.append(", isRolValido=");
		builder.append(isRolValido);
		builder.append("]");
		return builder.toString();
	}

}
