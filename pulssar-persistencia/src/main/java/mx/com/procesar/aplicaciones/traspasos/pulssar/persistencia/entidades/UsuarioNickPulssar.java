package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa la entidad de Usuario, mapeado a la tabla PSER_TR_NICK_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TR_NICK_PULSSAR")
@IdClass(UsuarioNickPulssarPK.class)
public class UsuarioNickPulssar implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2311630361655215367L;
	
	/**
	 * Identificador de usuario Pulssar.
	 */
	@Id
	@Column(name = "ID_USUARIO_PULSSAR")
	private Long identificadorUsuario;
	
	/**
	 * Nick usuario.
	 */
	@Id
	@Column(name = "CH_NICK_USUARIO")
	private String nickUsuario;
	
	/**
	 * Estatus 1 Activo, 0 Inactivo.
	 */
	@Column(name = "NU_ESTATUS")
	private Integer estatus;
	
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
	 * @return the identificadorUsuario
	 */
	public Long getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	/**
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Long identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
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
		builder.append("UsuarioNickPulssar [identificadorUsuario=");
		builder.append(identificadorUsuario);
		builder.append(", nickUsuario=");
		builder.append(nickUsuario);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}