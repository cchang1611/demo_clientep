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
@Table(name = "PSER_TR_CODIGO_CONFIMA_PULSSAR")
@SequenceGenerator(name = "SEQ_COD_CONFIMA_PULSSAR", sequenceName = "PSER_SEQ_COD_CONFIMA_PULSSAR", allocationSize = 1)
public class CodigoUsuario implements Serializable {
		
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2131491617283774031L;

	/**
	 * Identificador unico de registro.
	 */
	@Id
	@Column(name = "ID_CODIGO_CONFIMA_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_COD_CONFIMA_PULSSAR")
	private Long identificador;
	
	/**
	 * Identificador de usuario.
	 */
	@Column(name = "ID_USUARIO_PULSSAR")
	private Long identificadorUsuario;
	
	/**
	 * Folio de Solicitud.
	 */
	@Column(name = "CH_FOLIO")
	private String folio;
	
	/**
	 * Codigo SMS.
	 */
	@Column(name = "CH_CODIGO_CONFIRMACION")
	private String codigo;
	
	/**
	 * Estatus del Codigo (0 inactivo, 1 usado, 2 bloqueado).
	 */
	@Column(name = "NU_ESTATUS")
	private Integer estatus;
	
	/**
	 * Tipo de Solicitud de Codigo.
	 */
	@Column(name = "CH_TIPO_CODIGO")
	private String tipoCodigo;
	
	/**
	 * Fecha de Vigencia del Codigo.
	 */
	@Column(name = "FC_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVigencia;
	
	/**
	 * Fecha en que se uso el codigo.
	 */
	@Column(name = "FC_USO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUso;
	
	/**
	 * Fecha de ultima modificacion.
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * Usuario de ultima modificación.
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuario;
	
	/**
	 * Contador de número de intentos de uso
	 */
	@Column(name = "NU_INTENTOS")
	private Integer intentos;

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
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
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
	 * @return the tipoCodigo
	 */
	public String getTipoCodigo() {
		return tipoCodigo;
	}

	/**
	 * @param tipoCodigo the tipoCodigo to set
	 */
	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

	/**
	 * @return the fechaVigencia
	 */
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * @param fechaVigencia the fechaVigencia to set
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * @return the fechaUso
	 */
	public Date getFechaUso() {
		return fechaUso;
	}

	/**
	 * @param fechaUso the fechaUso to set
	 */
	public void setFechaUso(Date fechaUso) {
		this.fechaUso = fechaUso;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodigoUsuario [identificador=");
		builder.append(identificador);
		builder.append(", identificadorUsuario=");
		builder.append(identificadorUsuario);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", tipoCodigo=");
		builder.append(tipoCodigo);
		builder.append(", fechaVigencia=");
		builder.append(fechaVigencia);
		builder.append(", fechaUso=");
		builder.append(fechaUso);
		builder.append("[fecha=");
		builder.append(fecha);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", intentos=");
		builder.append(intentos);
		builder.append("]");
		return builder.toString();
	}
}