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
 * Representa la entidad de Usuario, mapeado a la tabla PSER_TR_NICK_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TR_USR_ENCRIPTADO")
@SequenceGenerator(name = "SEQ_USR_ENCRIPTADO", sequenceName = "PSER_SEQ_USR_ENCRIPTADO", allocationSize = 1)
public class UsuarioEncriptadoPulssar implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8321644592849013488L;
	
	/**
	 * Identificador de usuario encriptado
	 */
	@Id
	@Column(name = "ID_USR_ENCRIPTADO")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_USR_ENCRIPTADO")
	private Long idUsuarioEncriptado;
	
	/**
	 * Identificador de usuario pulssar
	 */
	@Column(name = "ID_USUARIO_PULSSAR")
	private Long idUsuarioPulssar;
	
	/**
	 * Password encriptado
	 */
	@Column(name = "CH_PASSWORD_ENCRIPTADO")
	private String password;
	
	/**
	 * Estatus 1 Activo, 0 Inactivo.
	 */
	@Column(name = "NU_ACTIVO")
	private Integer estatus;
	
	/**
	 * Fecha de Inactivacion
	 */
	@Column(name = "FC_INACTIVACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInactivacion;
	
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
	 * @return the idUsuarioEncriptado
	 */
	public Long getIdUsuarioEncriptado() {
		return idUsuarioEncriptado;
	}

	/**
	 * @param idUsuarioEncriptado the idUsuarioEncriptado to set
	 */
	public void setIdUsuarioEncriptado(Long idUsuarioEncriptado) {
		this.idUsuarioEncriptado = idUsuarioEncriptado;
	}

	/**
	 * @return the idUsuarioPulssar
	 */
	public Long getIdUsuarioPulssar() {
		return idUsuarioPulssar;
	}

	/**
	 * @param idUsuarioPulssar the idUsuarioPulssar to set
	 */
	public void setIdUsuarioPulssar(Long idUsuarioPulssar) {
		this.idUsuarioPulssar = idUsuarioPulssar;
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
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the fechaInactivacion
	 */
	public Date getFechaInactivacion() {
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion the fechaInactivacion to set
	 */
	public void setFechaInactivacion(Date fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
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
		builder.append("UsuarioEncriptadoPulssar [idUsuarioEncriptado=");
		builder.append(idUsuarioEncriptado);
		builder.append(", idUsuarioPulssar=");
		builder.append(idUsuarioPulssar);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaInactivacion=");
		builder.append(fechaInactivacion);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}