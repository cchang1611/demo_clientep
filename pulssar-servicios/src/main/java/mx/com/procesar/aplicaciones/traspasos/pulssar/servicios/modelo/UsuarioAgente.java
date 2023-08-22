package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objecto para los usuarios de la carga masiva
 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
 * May 6, 2022
 */
public class UsuarioAgente implements Serializable {
	
	/**
	 * 
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 6, 2022 
	 */
	private static final long serialVersionUID = -3944210762737115535L;


	/**
	 * Identificador único de registro.
	 */
	private String numeroAgente;
	
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
	private String correo;
	
	/**
	 * Celular del usuario.
	 */
	
	private String celular;
	
	/**
	 * Identificador de la Organización.
	 */

	private String claveAfore;
	
	/**
	 * constructor
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 6, 2022
	 * @param nuAgente
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param email
	 * @param celular
	 * @param afore
	 */
	public UsuarioAgente(String nuAgente, String nombre, String apellidoPaterno, String apellidoMaterno, String celular,String email,
			 String afore) {
		super();
		this.numeroAgente = nuAgente;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = email;
		this.celular = celular;
		this.claveAfore = afore;
	}

	/**
	 * @return the nuAgente
	 */
	public String getNumeroAgente() {
		return numeroAgente;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @return the email
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @return the afore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/* (non-Javadoc)
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 6, 2022
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioAgente [nuAgente=");
		builder.append(numeroAgente);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", email=");
		builder.append(correo);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", afore=");
		builder.append(claveAfore);
		builder.append("]");
		return builder.toString();
	}
	


}