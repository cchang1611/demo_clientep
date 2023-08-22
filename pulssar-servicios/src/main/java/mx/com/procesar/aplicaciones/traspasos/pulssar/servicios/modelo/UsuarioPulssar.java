package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa la entidad de Usuario, mapeado a la tabla TRAN_TR_USUARIO_PULSSAR
 * 
 * @author DBARBOSA
 */

public class UsuarioPulssar implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4447895641778525686L;

	/**
	 * Identificador único de registro.
	 */

	private Long identificador;
	
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
	 * Identificador de la Organización.
	 */
	private String claveOrganizacion;
	
	/**
	 * Estatus de usuario (00 Inactivo, 01 Activo, 02 Cambio Password.
	 */
	private String estatus;
	
	/**
	 * Fecha de ultima modificación.
	 */
	private Date fecha;
	
	/**
	 * Usuario de ultima modificación.
	 */
	private String usuarioModificador;
	/**
	 * checkbox seleccion
	 */
	private boolean seleccion = false;
	/**
	 * Constructor por defecto
	 */
	public UsuarioPulssar() {
		super();
	}

	/**
	 * Contructor con parametros
	 * 
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param email
	 */
	public UsuarioPulssar(String nombre, String apellidoPaterno, String apellidoMaterno, String email) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
	}

	/**
	 * @return the identificador
	 */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [identificador=");
		builder.append(identificador);
		builder.append(", usuario=");
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
		builder.append(", claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append("[fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}