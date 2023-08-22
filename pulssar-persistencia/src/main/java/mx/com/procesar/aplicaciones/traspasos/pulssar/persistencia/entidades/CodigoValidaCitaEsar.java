package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entidad de la tabla TRAN_TR_CODIGO_VAL_CTA_ESAR
 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
 * Oct 30, 2019
 */
@Entity(name = "tranTrCodigoValCtaEsar")
@Table(name = "TRAN_TR_CODIGO_VAL_CTA_ESAR")
public class CodigoValidaCitaEsar implements Serializable {

	/**
	 * Serializacion
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 30, 2019
	 */
	private static final long serialVersionUID = 1126870873933375703L;
	
	@EmbeddedId
	@AttributeOverrides({
	    @AttributeOverride(name="curp", column=@Column(name="CURP")),
	    @AttributeOverride(name="codigo", column=@Column(name="NU_CODIGO_CONF"))
	})
	private CodigoValidaCitaEsarPK id;
	/**
	 * correo
	 */
	@Column(name = "CH_CORREO_ELECTRONICO")
	private String correo;

	/**
	 * nuTelefono
	 */
	@Column(name = "CH_TEL_CELULAR")
	private String nuTelefono;

	/**
	 * nuFolioConst
	 */
	@Column(name = "NU_FOLIO_SERVICIO")
	private BigDecimal nuFolioConst;

	/**
	 * Estatus activacion
	 */
	@Column(name = "NU_ESTATUS_ACTIVACION")
	private Integer estatus;

	/**
	 * Fecha de vigencia
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_SOLICITUD")
	private Date fcSolicitud;

	/**
	 * chVigenciaCodigo
	 */
	@Column(name = "FC_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chVigenciaCodigo;

	/**
	 * fechaCreacion
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_CONTROL")
	private Date fcControl;

	/**
	 * usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;

	/**
	 * Tipo de activacion
	 */
	@Column(name = "NU_TIPO_ACTIVACION")
	private Integer tipoActivacion;

	/**
	 * Fecha de activacion
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_ACTIVACION")
	private Date fcActivacion;

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the nuTelefono
	 */
	public String getNuTelefono() {
		return nuTelefono;
	}

	/**
	 * @param nuTelefono the nuTelefono to set
	 */
	public void setNuTelefono(String nuTelefono) {
		this.nuTelefono = nuTelefono;
	}

	/**
	 * @return the nuFolioConst
	 */
	public BigDecimal getNuFolioConst() {
		return nuFolioConst;
	}

	/**
	 * @param nuFolioConst the nuFolioConst to set
	 */
	public void setNuFolioConst(BigDecimal nuFolioConst) {
		this.nuFolioConst = nuFolioConst;
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
	 * @return the fcSolicitud
	 */
	public Date getFcSolicitud() {
		return fcSolicitud;
	}

	/**
	 * @param fcSolicitud the fcSolicitud to set
	 */
	public void setFcSolicitud(Date fcSolicitud) {
		this.fcSolicitud = fcSolicitud;
	}

	/**
	 * @return the chVigenciaCodigo
	 */
	public Date getChVigenciaCodigo() {
		return chVigenciaCodigo;
	}

	/**
	 * @param chVigenciaCodigo the chVigenciaCodigo to set
	 */
	public void setChVigenciaCodigo(Date chVigenciaCodigo) {
		this.chVigenciaCodigo = chVigenciaCodigo;
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
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * @return the tipoActivacion
	 */
	public Integer getTipoActivacion() {
		return tipoActivacion;
	}

	/**
	 * @param tipoActivacion the tipoActivacion to set
	 */
	public void setTipoActivacion(Integer tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	/**
	 * @return the fcActivacion
	 */
	public Date getFcActivacion() {
		return fcActivacion;
	}

	/**
	 * @param fcActivacion the fcActivacion to set
	 */
	public void setFcActivacion(Date fcActivacion) {
		this.fcActivacion = fcActivacion;
	}

	/**
	 * @return the id
	 */
	public CodigoValidaCitaEsarPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CodigoValidaCitaEsarPK id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodigoValidaCitaEsar [id=");
		builder.append(id);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", nuTelefono=");
		builder.append(nuTelefono);
		builder.append(", nuFolioConst=");
		builder.append(nuFolioConst);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fcSolicitud=");
		builder.append(fcSolicitud);
		builder.append(", chVigenciaCodigo=");
		builder.append(chVigenciaCodigo);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", tipoActivacion=");
		builder.append(tipoActivacion);
		builder.append(", fcActivacion=");
		builder.append(fcActivacion);
		builder.append("]");
		return builder.toString();
	}
}