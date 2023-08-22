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


/**
 * Representa la entidad de Usuario, mapeado a la tabla PSER_TR_USUARIO_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TR_USUARIO_PULSSAR")
@SequenceGenerator(name = "SEQ_USUARIO_PULSSAR", sequenceName = "PSER_SEQ_USUARIO_PULSSAR", allocationSize = 1)
public class UsuarioPulssar implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4447895641778525686L;

	/**
	 * Identificador unico de registro.
	 */
	@Id
	@Column(name = "ID_USUARIO_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_PULSSAR")
	private Long identificador;
	
	/**
	 * Usuario de Portal.
	 */
	@Column(name = "CH_USUARIO")
	private String usuario;
	
	/**
	 * Nombre del usuario.
	 */
	@Column(name = "CH_NOMBRE")
	private String nombre;
	
	/**
	 * Apellido Paterno usuario.
	 */
	@Column(name = "CH_APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno usuario.
	 */
	@Column(name = "CH_APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	/**
	 * Correo Electronico.
	 */
	@Column(name = "CH_EMAIL")
	private String email;
	
	/**
	 * Celular del usuario.
	 */
	@Column(name = "CH_CELULAR")
	private String celular;
	
	/**
	 * Identificador de la Organizacion.
	 */
	@Column(name = "CV_ORGANIZACION")
	private String claveOrganizacion;
	
	/**
	 * Estatus de usuario (00 Inactivo, 01 Activo, 02 Cambio Password.
	 */
	@Column(name = "CH_ESTATUS")
	private String estatus;
	
	/**
	 * Fecha de ultima modificacion.
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * Usuario de ultima modificacion.
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * Clave de la Sucursal.
	 */
	@Column(name = "CH_SUCURSAL")
	private String chSucursal;
	
	/**
	 * Clave de la oficina.
	 */
	@Column(name = "CH_CLAVE_OFICINA")
	private String chOficina;	
	
	/**
	 * Identificador de zona
	 */
	@Column(name = "NU_IDENTIFICADOR_ZONA")
	private Long zona ;	
	
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
	
	/**
	 * @return the chSucursal
	 */
	public String getChSucursal() {
		return chSucursal;
	}

	/**
	 * @param chSucursal the chSucursal to set
	 */
	public void setChSucursal(String chSucursal) {
		this.chSucursal = chSucursal;
	}

	/**
	 * @return the chOficina
	 */
	public String getChOficina() {
		return chOficina;
	}

	/**
	 * @param chOficina the chOficina to set
	 */
	public void setChOficina(String chOficina) {
		this.chOficina = chOficina;
	}

	/**
	 * @return the zona
	 */
	public Long getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(Long zona) {
		this.zona = zona;
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
		builder.append(", chSucursal=");
		builder.append(chSucursal);
		builder.append(", chOficina=");
		builder.append(chOficina);
		builder.append(", zona=");
		builder.append(zona);
		builder.append("]");
		return builder.toString();
	}
}