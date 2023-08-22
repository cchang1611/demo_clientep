package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the PSER_TR_NOTIF_PARC_ISSSTE database table.
 * @author ANOSORIO
 */
@Entity
@Table(name="PSER_TR_NOTIF_PARC_ISSSTE")
public class NotificacionParcialidadIssste implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8002939096612806435L;

	/**
	 * idNotifParcIssste
	 */
	@Id
	@SequenceGenerator(name = "PSER_SEQ_NOT_PARC_ISSSTE", sequenceName = "PSER_SEQ_NOT_PARC_ISSSTE", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PSER_SEQ_NOT_PARC_ISSSTE")
	@Column(name="ID_NOTIF_PARC_ISSSTE")
	private Long idNotifParcIssste;

	/**
	 * afore
	 */
	@Column(name="CH_AFORE")
	private String afore;

	/**
	 * claveBanco
	 */
	@Column(name="CH_CLAVE_BANCO")
	private String claveBanco;

	/**
	 * cuentaClabe
	 */
	@Column(name="CH_CUENTA_CLABE")
	private String cuentaClabe;

	/**
	 * descDiagnosticoRecepcion
	 */
	@Column(name="CH_DESC_DIAGNOSTICO_RECEPCION")
	private String descDiagnosticoRecepcion;

	/**
	 * diagnosticoRecepcion
	 */
	@Column(name="CH_DIAGNOSTICO_RECEPCION")
	private String diagnosticoRecepcion;

	/**
	 * folio
	 */
	@Column(name="CH_FOLIO")
	private String folio;

	/**
	 * folioAdministradora
	 */
	@Column(name="CH_FOLIO_ADMINISTRADORA")
	private String folioAdministradora;

	/**
	 * numeroCuenta
	 */
	@Column(name="CH_NUMERO_CUENTA")
	private String numeroCuenta;

	/**
	 * numeroResolucion
	 */
	@Column(name="CH_NUMERO_RESOLUCION")
	private String numeroResolucion;

	/**
	 * resultadoOperacion
	 */
	@Column(name="CH_RESULTADO_OPERACION")
	private String resultadoOperacion;

	/**
	 * usuarioModificador
	 */
	@Column(name="CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * fechaControl
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="FC_CONTROL")
	private Date fechaControl;

	/**
	 * fechaNotificado
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="FC_NOTIFICADO")
	private Date fechaNotificado;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * notificado
	 */
	@Column(name="NU_NOTIFICADO")
	private BigDecimal notificado;

	/**
	 * parcialidades
	 */
	@Column(name="NU_PARCIALIDADES")
	private BigDecimal numParcialidades;

	/**
	 * @return the idNotifParcIssste
	 */
	public Long getIdNotifParcIssste() {
		return idNotifParcIssste;
	}

	/**
	 * @param idNotifParcIssste the idNotifParcIssste to set
	 */
	public void setIdNotifParcIssste(Long idNotifParcIssste) {
		this.idNotifParcIssste = idNotifParcIssste;
	}

	/**
	 * @return the afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore the afore to set
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return the claveBanco
	 */
	public String getClaveBanco() {
		return claveBanco;
	}

	/**
	 * @param claveBanco the claveBanco to set
	 */
	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}

	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/**
	 * @return the descDiagnosticoRecepcion
	 */
	public String getDescDiagnosticoRecepcion() {
		return descDiagnosticoRecepcion;
	}

	/**
	 * @param descDiagnosticoRecepcion the descDiagnosticoRecepcion to set
	 */
	public void setDescDiagnosticoRecepcion(String descDiagnosticoRecepcion) {
		this.descDiagnosticoRecepcion = descDiagnosticoRecepcion;
	}

	/**
	 * @return the diagnosticoRecepcion
	 */
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}

	/**
	 * @param diagnosticoRecepcion the diagnosticoRecepcion to set
	 */
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
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
	 * @return the folioAdministradora
	 */
	public String getFolioAdministradora() {
		return folioAdministradora;
	}

	/**
	 * @param folioAdministradora the folioAdministradora to set
	 */
	public void setFolioAdministradora(String folioAdministradora) {
		this.folioAdministradora = folioAdministradora;
	}

	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion the numeroResolucion to set
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
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
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * @param fechaNotificado the fechaNotificado to set
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the notificado
	 */
	public BigDecimal getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(BigDecimal notificado) {
		this.notificado = notificado;
	}

	/**
	 * @return the numParcialidades
	 */
	public BigDecimal getNumParcialidades() {
		return numParcialidades;
	}

	/**
	 * @param numParcialidades the numParcialidades to set
	 */
	public void setNumParcialidades(BigDecimal numParcialidades) {
		this.numParcialidades = numParcialidades;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionParcialidadIssste [idNotifParcIssste=");
		builder.append(idNotifParcIssste);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", claveBanco=");
		builder.append(claveBanco);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", descDiagnosticoRecepcion=");
		builder.append(descDiagnosticoRecepcion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", folioAdministradora=");
		builder.append(folioAdministradora);
		builder.append(", numeroCuenta=");
		builder.append(numeroCuenta);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", notificado=");
		builder.append(notificado);
		builder.append(", numParcialidades=");
		builder.append(numParcialidades);
		builder.append("]");
		return builder.toString();
	}
	
}