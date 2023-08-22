package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos de un usuario para
 * el servicio de alta de usuario
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class DatosUsuario implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7560621456233937542L;

	/**
	 * identificador usuario
	 */
	private String nickUsuario;

	/**
	 * Numero de agente
	 */
	private String numeroAgente;

	/**
	 * Nombre del usuario
	 */
	private String nombre;

	/**
	 * Apellido paterno del usuario
	 */
	private String apellidoPaterno;

	/**
	 * Apellido materno del usuario
	 */
	private String apellidoMaterno;

	/**
	 * Celular del usuario
	 */
	private String celular;

	/**
	 * Correo del usuario
	 */
	private String correo;

	/**
	 * Clave del afore del usuario
	 */
	private String claveAfore;
	
	/**
	 * Clave de la sucursal
	 */
	private String claveSucursal;
	
	/**
	 * Contructor por default
	 */
	public DatosUsuario() {
		super();
	}
	
	/**
	 * Contructor
	 * 
	 * @param nickUsuario
	 * @param numeroAgente
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param celular
	 * @param correo
	 * @param claveAfore
	 * * @param claveSucursal
	 */
	public DatosUsuario(String nickUsuario, String numeroAgente, String nombre, String apellidoPaterno,
			String apellidoMaterno, String celular, String correo, String claveAfore, String claveSucursal) {
		super();
		this.nickUsuario = nickUsuario;
		this.numeroAgente = numeroAgente;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.celular = celular;
		this.correo = correo;
		this.claveAfore = claveAfore;
		this.claveSucursal = claveSucursal;
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
	 * @return the numeroAgente
	 */
	public String getNumeroAgente() {
		return numeroAgente;
	}

	/**
	 * @param numeroAgente the numeroAgente to set
	 */
	public void setNumeroAgente(String numeroAgente) {
		this.numeroAgente = numeroAgente;
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

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}
	
	/**
	 * @return the claveSucursal
	 */
	public String getClaveSucursal() {
		return claveSucursal;
	}

	/**
	 * @param claveSucursal the claveSucursal to set
	 */
	public void setClaveSucursal(String claveSucursal) {
		this.claveSucursal = claveSucursal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosUsuario [nickUsuario=");
		builder.append(nickUsuario);
		builder.append(", numeroAgente=");
		builder.append(numeroAgente);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", claveSucursal=");
		builder.append(claveSucursal);
		builder.append("]");

		return builder.toString();
	}
}