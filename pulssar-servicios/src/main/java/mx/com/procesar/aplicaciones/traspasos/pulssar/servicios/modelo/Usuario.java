package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase Usuario para servicios de seguridad
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class Usuario implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2833047960891198043L;

	/**
	 * username
	 */
	private String username;

	/**
	 * password
	 */
	private String password;

	/**
	 * nombre
	 */
	private String nombre;

	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;

	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;

	/**
	 * preguntaSecreta
	 */
	private String preguntaSecreta;

	/**
	 * descripcionPuesto
	 */
	private String descripcionPuesto;

	/**
	 * respuestaSecreta
	 */
	private String respuestaSecreta;

	/**
	 * activo
	 */
	private Boolean activo;

	/**
	 * primeraVez
	 */
	private String primeraVez;

	/**
	 * claseUsuario
	 */
	private String claseUsuario;
	
	/**
	 * failedLoginAttempsCount
	 */
	private String failedLoginAttempsCount;
	
	/**
	 * claveSucursal
	 */
	private String claveSucursal;	

	/**
	 * atributos
	 */
	private Map<String,Object> atributos;
	
	/**
	 * contructor
	 */
	public Usuario() {
	
	}
	
	/**
	 * 
	 * @param claseUsuario
	 */
	public Usuario(String claseUsuario) {
		this.claseUsuario = claseUsuario;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
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
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
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
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the preguntaSecreta
	 */
	public String getPreguntaSecreta() {
		return preguntaSecreta;
	}

	/**
	 * @param preguntaSecreta
	 *            the preguntaSecreta to set
	 */
	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	/**
	 * @return the descripcionPuesto
	 */
	public String getDescripcionPuesto() {
		return descripcionPuesto;
	}

	/**
	 * @param descripcionPuesto
	 *            the descripcionPuesto to set
	 */
	public void setDescripcionPuesto(String descripcionPuesto) {
		this.descripcionPuesto = descripcionPuesto;
	}

	/**
	 * @return the respuestaSecreta
	 */
	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	/**
	 * @param respuestaSecreta
	 *            the respuestaSecreta to set
	 */
	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo
	 *            the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the primeraVez
	 */
	public String getPrimeraVez() {
		return primeraVez;
	}

	/**
	 * @param primeraVez
	 *            the primeraVez to set
	 */
	public void setPrimeraVez(String primeraVez) {
		this.primeraVez = primeraVez;
	}

	/**
	 * @return the claseUsuario
	 */
	public String getClaseUsuario() {
		return claseUsuario;
	}

	/**
	 * @param claseUsuario
	 *            the claseUsuario to set
	 */
	public void setClaseUsuario(String claseUsuario) {
		this.claseUsuario = claseUsuario;
	}

	/**
	 * @return the failedLoginAttempsCount
	 */
	public String getFailedLoginAttempsCount() {
		return failedLoginAttempsCount;
	}

	/**
	 * @param failedLoginAttempsCount
	 *            the failedLoginAttempsCount to set
	 */
	public void setFailedLoginAttempsCount(String failedLoginAttempsCount) {
		this.failedLoginAttempsCount = failedLoginAttempsCount;
	}

	/**
	 * @return the atributos
	 */
	public Map<String,Object> getAtributos() {
		return atributos;
	}

	/**
	 * @param atributos
	 *            the atributos to set
	 */
	public void setAtributos(Map<String,Object> atributos) {
		this.atributos = atributos;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [username=");
		builder.append(username);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", preguntaSecreta=");
		builder.append(preguntaSecreta);
		builder.append(", descripcionPuesto=");
		builder.append(descripcionPuesto);
		builder.append(", respuestaSecreta=");
		builder.append(respuestaSecreta);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", primeraVez=");
		builder.append(primeraVez);
		builder.append(", claseUsuario=");
		builder.append(claseUsuario);
		builder.append(", failedLoginAttempsCount=");
		builder.append(failedLoginAttempsCount);
		builder.append(", atributos=");
		builder.append(atributos);
		builder.append("]");
		return builder.toString();
	}
}