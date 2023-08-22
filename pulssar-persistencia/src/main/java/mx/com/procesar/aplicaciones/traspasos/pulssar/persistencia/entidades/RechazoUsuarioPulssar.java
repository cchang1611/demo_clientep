package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PSER_TR_RECHAZO_USER_PULSSAR")
@SequenceGenerator(name = "SEQ_RECHAZO_USER_PULSSAR", sequenceName = "PSER_SEQ_RECHAZO_USER_PULSSAR", allocationSize = 1)
public class RechazoUsuarioPulssar implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7763774073687586524L;
	
	/**
	 * identificador
	 */
	@Id
	@Column(name = "ID_RECHAZO_USER_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_RECHAZO_USER_PULSSAR")
	private Long identificadorRechazoUsuario;
	
	/**
	 * usuario
	 */
	@Column(name = "CH_USUARIO")
	private String usuario;
	
	/**
	 * nombre
	 */
	@Column(name = "CH_NOMBRE")
	private String nombre;
	
	/**
	 * apellido paterno
	 */
	@Column(name = "CH_APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	/**
	 * apellido materno
	 */
	@Column(name = "CH_APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	/**
	 * email
	 */
	@Column(name = "CH_EMAIL")
	private String email;
	
	/**
	 * celular
	 */
	@Column(name = "CH_CELULAR")
	private String celular;
	
	/**
	 * clave organizacion
	 */
	@Column(name = "CV_ORGANIZACION")
	private String claveOrganizacion;
	
	/**
	 * nick usuario
	 */
	@Column(name = "CH_NICK_USER")
	private String nickUsuario;
	
	/**
	 * identificador rechazo
	 */
	@Column(name = "ID_RECHAZO_PULSSAR")
	private Long identificadorRechazo;
	
	/**
	 * fecha
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * @return the identificadorRechazoUsuario
	 */
	public Long getIdentificadorRechazoUsuario() {
		return identificadorRechazoUsuario;
	}

	/**
	 * @param identificadorRechazoUsuario the identificadorRechazoUsuario to set
	 */
	public void setIdentificadorRechazoUsuario(Long identificadorRechazoUsuario) {
		this.identificadorRechazoUsuario = identificadorRechazoUsuario;
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
	 * @return the identificadorRechazo
	 */
	public Long getIdentificadorRechazo() {
		return identificadorRechazo;
	}

	/**
	 * @param identificadorRechazo the identificadorRechazo to set
	 */
	public void setIdentificadorRechazo(Long identificadorRechazo) {
		this.identificadorRechazo = identificadorRechazo;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RechazoUsuarioPulssar [identificadorRechazoUsuario=");
		builder.append(identificadorRechazoUsuario);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("nombre=");
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
		builder.append(", nickUsuario=");
		builder.append(nickUsuario);
		builder.append(", identificadorRechazo=");
		builder.append(identificadorRechazo);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}