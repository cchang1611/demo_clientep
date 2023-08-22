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
@Table(name = "PSER_TR_BLOQUEO_USER_PULSSAR")
@SequenceGenerator(name = "SEQ_BLOQ_USER_PULSSAR", sequenceName = "PSER_SEQ_BLOQ_USER_PULSSAR", allocationSize = 1)
public class BloqueoUsuarioPulssar implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 5952503332982513107L;
	
	/**
	 * identificador de registro
	 */
	@Id
	@Column(name = "ID_BLOQUEO_USER_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_BLOQ_USER_PULSSAR")
	private Long identificadorBloqueo;
	
	/**
	 * identificador de usuario
	 */
	@Column(name = "ID_USUARIO_PULSSAR")
	private Long identificadorUsuario;
	
	/**
	 * fecha de vigencia
	 */
	@Column(name = "FC_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcVigencia;
	
	/**
	 * estatus
	 */
	@Column(name = "CH_ESATUS")
	private String estatus;
	
	/**
	 * numero de intentos
	 */
	@Column(name = "NU_INTENTOS")
	private Integer intentos;
	
	/**
	 * fecha de control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;
	
	/**
	 * usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * @return the identificadorBloqueo
	 */
	public Long getIdentificadorBloqueo() {
		return identificadorBloqueo;
	}

	/**
	 * @param identificadorBloqueo the identificadorBloqueo to set
	 */
	public void setIdentificadorBloqueo(Long identificadorBloqueo) {
		this.identificadorBloqueo = identificadorBloqueo;
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
	 * @return the fcVigencia
	 */
	public Date getFcVigencia() {
		return fcVigencia;
	}

	/**
	 * @param fcVigencia the fcVigencia to set
	 */
	public void setFcVigencia(Date fcVigencia) {
		this.fcVigencia = fcVigencia;
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
	 * @return the intentos
	 */
	public Integer getIntentos() {
		return intentos;
	}

	/**
	 * @param intentos the intentos to set
	 */
	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
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
	
	

	}
	
	
