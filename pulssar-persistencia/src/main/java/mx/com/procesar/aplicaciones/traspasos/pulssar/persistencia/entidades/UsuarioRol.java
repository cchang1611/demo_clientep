package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa la entidad de Relacion Usuario y Roles, mapeado a la tabla PSER_TR_USER_ROL_PULSSAR
 * 
 * @author DBARBOSA
 */
@Entity
@Table(name = "PSER_TR_USER_ROL_PULSSAR")
@SequenceGenerator(name = "SEQ_USER_ROL_PULSSAR", sequenceName = "PSER_SEQ_USER_ROL_PULSSAR", allocationSize = 1)
public class UsuarioRol implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1828981790695825993L;
	
	/**
	 * Identidficador rol de usuario
	 */
	@Id
	@Column(name="ID_USER_ROL_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ROL_PULSSAR")
	private Long identificadorUsuarioRol;
	
	/**
	 * Identificador de usuario.
	 */
	@Column(name = "ID_USUARIO_PULSSAR")
	private Long identificadorUsuario;
	
	/**
	 * Estatus de Relacion.
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
	 * Indicador de activo/inactivo
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * Identificador de usuario.
	 */
	@OneToOne
	@JoinColumn(name="ID_ROL_PULSSAR")
	private RolesCatalogo rolUsuario;
	
	/**
	 * @return the identificadorUsuarioRol
	 */
	public Long getIdentificadorUsuarioRol() {
		return identificadorUsuarioRol;
	}

	/**
	 * @param identificadorUsuarioRol the identificadorUsuarioRol to set
	 */
	public void setIdentificadorUsuarioRol(Long identificadorUsuarioRol) {
		this.identificadorUsuarioRol = identificadorUsuarioRol;
	}

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
	
	/**
	 * @return el atributo identificadorRolUsuario
	 */
	public RolesCatalogo getRolUsuario() {
		return rolUsuario;
	}

	/**
	 * @param identificadorRolUsuario parametro identificadorRolUsuario a actualizar
	 */
	public void setRolUsuario(RolesCatalogo rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioRol [identificadorUsuario=");
		builder.append(identificadorUsuario);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append("fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", rolUsuario=");
		builder.append(rolUsuario);
		builder.append("]");
		return builder.toString();
	}
}