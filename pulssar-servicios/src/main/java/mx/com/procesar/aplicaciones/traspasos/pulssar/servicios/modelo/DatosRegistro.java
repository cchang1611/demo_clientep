package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que contiene los atributos de Entrada del registro de un usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class DatosRegistro extends DatosUsuario implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6921601524189409698L;

	/**
	 * Confirmación del número de celular
	 */
	private String confirmarCelular;

	/**
	 * Confirmación del correo
	 */
	private String confirmarCorreo;
	
	/**
	 * Contrasenia actual
	 */
	private String passwordActual;
	
	/**
	 * Contrasenia
	 */
	private String password;
	
	/**
	 * CConfima contrasenia
	 */
	private String confirmarPassword;
	
	/**
	 * Roles
	 */
	private List<String> roles;
	
	/**
	 * Codigo de activacion
	 */
	private String codigo;
	
	/**
	 * Clave Zona
	 */
	private String claveZona;
	
	/**
	 * Nombre de la zona
	 */
	private String nombreZona;
	
	/**
	 * Clave de Oficina
	 */
	private String claveOficina;
	
	/**
	 * Perfil Sici
	 */
	private List<String> perfilSici;
	
	/**
	 * Clave afore sici
	 */
	private String cvAfore;
	
	/**
	 * Clave afore sici
	 */
	private String idPlataforma;
	
	/**
	 * Clave afore sici
	 */
	private String ipAccesoUsuario;
	
	/**
	 * Constructor super
	 */
	public DatosRegistro() {
		super();
	}

	/**
	 * Constructor super
	 */
	public DatosRegistro(DatosUsuario usuario) {
		super(usuario.getNickUsuario(), usuario.getNumeroAgente(), usuario.getNombre(), usuario.getApellidoPaterno(),
				usuario.getApellidoMaterno(), usuario.getCelular(), usuario.getCorreo(), usuario.getClaveAfore(), usuario.getClaveSucursal());
	}

	/**
	 * @return the confirmarCelular
	 */
	public String getConfirmarCelular() {
		return confirmarCelular;
	}

	/**
	 * @param confirmarCelular the confirmarCelular to set
	 */
	public void setConfirmarCelular(String confirmarCelular) {
		this.confirmarCelular = confirmarCelular;
	}

	/**
	 * @return the confirmarCorreo
	 */
	public String getConfirmarCorreo() {
		return confirmarCorreo;
	}

	/**
	 * @param confirmarCorreo the confirmarCorreo to set
	 */
	public void setConfirmarCorreo(String confirmarCorreo) {
		this.confirmarCorreo = confirmarCorreo;
	}

	/**
	 * @return the passwordActual
	 */
	public String getPasswordActual() {
		return passwordActual;
	}

	/**
	 * @param passwordActual the passwordActual to set
	 */
	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmarPassword
	 */
	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	/**
	 * @param confirmarPassword the confirmarPassword to set
	 */
	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the claveZona
	 */
	public String getClaveZona() {
		return claveZona;
	}

	/**
	 * @param claveZona the claveZona to set
	 */
	public void setClaveZona(String claveZona) {
		this.claveZona = claveZona;
	}

	/**
	 * @return the nombreZona
	 */
	public String getNombreZona() {
		return nombreZona;
	}

	/**
	 * @param nombreZona the nombreZona to set
	 */
	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	/**
	 * @return the claveOficina
	 */
	public String getClaveOficina() {
		return claveOficina;
	}

	/**
	 * @param claveOficina the claveOficina to set
	 */
	public void setClaveOficina(String claveOficina) {
		this.claveOficina = claveOficina;
	}

	/**
	 * @return the perfilSici
	 */
	public List<String> getPerfilSici() {
		return perfilSici;
	}

	/**
	 * @param perfilSici the perfilSici to set
	 */
	public void setPerfilSici(List<String> perfilSici) {
		this.perfilSici = perfilSici;
	}

	/**
	 * @return the cvAfore
	 */
	public String getCvAfore() {
		return cvAfore;
	}

	/**
	 * @param cvAfore the cvAfore to set
	 */
	public void setCvAfore(String cvAfore) {
		this.cvAfore = cvAfore;
	}

	/**
	 * @return the idPlataforma
	 */
	public String getIdPlataforma() {
		return idPlataforma;
	}

	/**
	 * @param idPlataforma the idPlataforma to set
	 */
	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	/**
	 * @return the ipAccesoUsuario
	 */
	public String getIpAccesoUsuario() {
		return ipAccesoUsuario;
	}

	/**
	 * @param ipAccesoUsuario the ipAccesoUsuario to set
	 */
	public void setIpAccesoUsuario(String ipAccesoUsuario) {
		this.ipAccesoUsuario = ipAccesoUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosRegistro [confirmarCelular=");
		builder.append(confirmarCelular);
		builder.append(", confirmarCorreo=");
		builder.append(confirmarCorreo);
		builder.append(", passwordActual=");
		builder.append(passwordActual);
		builder.append(", password=");
		builder.append(password);
		builder.append(", confirmarPassword=");
		builder.append(confirmarPassword);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", claveZona=");
		builder.append(claveZona);
		builder.append(", nombreZona=");
		builder.append(nombreZona);
		builder.append(", claveOficina=");
		builder.append(claveOficina);
		builder.append(", perfilSici=");
		builder.append(perfilSici);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", idPlataforma=");
		builder.append(idPlataforma);
		builder.append(", ipAccesoUsuario=");
		builder.append(ipAccesoUsuario);
		builder.append("]");

		return builder.toString();
	}

}