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
 * Mapeo tabla RETI_TR_RETIRO_PARCIAL_CALCULO IMSS
 * @author ANOSORIO
 *
 */
@Entity
@Table(name = "RETI_TR_RETIRO_PARCIAL_CALCULO")
public class RetiroParcialCalculoImss implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 9037945267156565239L;

	/**
	 * idRetiroParcialCalculo
	 */
	@Id
	@SequenceGenerator(name = "RETI_SEQ_RETIRO_PARCIAL_CALC", sequenceName = "RETI_SEQ_RETIRO_PARCIAL_CALC", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RETI_SEQ_RETIRO_PARCIAL_CALC")
	@Column(name="ID_RETIRO_PARCIAL_CALCULO")
	private Long idRetiroParcialCalculo;
	
	
	/**
	 * Clave Tipo Retiro Desempleo
	 */
	@Column(name = "CV_TIPO_RETIRO_DESEMPLEO")
	private String tipoRetiroDesempleo;
	
	/**
	 * Cuenta
	 */
	@Column(name = "CH_CUENTA")
	private String cuenta;
	
	/**
	 * Cuenta Clabe
	 */
	@Column(name = "CH_CUENTA_CLABE")
	private String cuentaClabe;
	
	/**
	 * Forma de pago
	 */
	@Column(name = "CH_FORMA_PAGO")
	private String formaPago;
	
	/**
	 * Clave Banco
	 */
	@Column(name = "CH_CLAVE_BANCO")
	private String claveBanco;
	
	/**
	 * Estatus
	 */
	@Column(name = "NU_ESTATUS")
	private Integer estatus;
	
	/**
	 * Id resolucion parcial
	 */
	@Column(name = "ID_RESOLUCION_PARCIAL")
	private Long idResolucionParcial;
	
	/**
	 * Saldo sar 92
	 */
	@Column(name = "NU_SALDO_SAR92")
	private Double saldoSar92;
	
	/**
	 * Saldo retiro 97
	 */
	@Column(name = "NU_SALDO_RETIRO97")
	private Double saldoRetiro97;

	/**
	 * saldoRcv
	 */
	@Column(name = "NU_SALDO_RCV")
	private Double saldoRcv;
	
	/**
	 * Total Saldos
	 */
	@Column(name = "NU_TOTAL_SALDOS")
	private Double totalSaldos;
	
	
	/**
	 * Monto Calculo A
	 */
	@Column(name = "NU_MONTO_CALCULOA")
	private Double montoCalculoA;
	
	/**
	 * Monto Calculo B
	 */
	@Column(name = "NU_MONTO_CALCULOB")
	private Double montoCalculoB;
	
	/**
	 * Tipo Retiro
	 */
	@Column(name = "CH_TIPO_RETIRO")
	private String tipoRetiro; 
	
	/**
	 * Parcialidad
	 */
	@Column(name = "NU_PARCIALIDAD")
	private Integer parcialidad;
	
	/**
	 * Monto Parcialidad
	 */
	@Column(name = "NU_MONTO_PARCIALIDAD")
	private Double montoParcialidad;
	
	/**
	 * Fecha Pago
	 */
	@Column(name = "FC_PAGO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;

	
	/**
	 * Derecho pago
	 */
	@Column(name = "NU_DERECHO_PAGO")
	private Integer derechoPago;
	
	/**
	 * Fecha Control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaControl;
	
	/**
	 * Usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * idRetiroPortalServ
	 */
	@Column(name = "ID_RETIRO_PORTAL_SERV",insertable=false, updatable = false)
	private Long idRetiroPortalServ;
	
	

	/**
	 * Constructor
	 */
	public RetiroParcialCalculoImss() {
		//Constructor RetiroParcialCalculoImss
		
	}
	/**
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the idRetiroParcialCalculo
	 */
	public Long getIdRetiroParcialCalculo() {
		return idRetiroParcialCalculo;
	}

	/**
	 * @param idRetiroParcialCalculo the idRetiroParcialCalculo to set
	 */
	public void setIdRetiroParcialCalculo(Long idRetiroParcialCalculo) {
		this.idRetiroParcialCalculo = idRetiroParcialCalculo;
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
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
	 * @return the saldoRcv
	 */
	public Double getSaldoRcv() {
		return saldoRcv;
	}

	/**
	 * @param saldoRcv the saldoRcv to set
	 */
	public void setSaldoRcv(Double saldoRcv) {
		this.saldoRcv = saldoRcv;
	}

	/**
	 * @return the totalSaldos
	 */
	public Double getTotalSaldos() {
		return totalSaldos;
	}

	/**
	 * @param totalSaldos the totalSaldos to set
	 */
	public void setTotalSaldos(Double totalSaldos) {
		this.totalSaldos = totalSaldos;
	}

	/**
	 * @return the parcialidad
	 */
	public Integer getParcialidad() {
		return parcialidad;
	}

	/**
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(Integer parcialidad) {
		this.parcialidad = parcialidad;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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
	 * @return the tipoRetiroDesempleo
	 */
	public String getTipoRetiroDesempleo() {
		return tipoRetiroDesempleo;
	}

	/**
	 * @param tipoRetiroDesempleo the tipoRetiroDesempleo to set
	 */
	public void setTipoRetiroDesempleo(String tipoRetiroDesempleo) {
		this.tipoRetiroDesempleo = tipoRetiroDesempleo;
	}

	/**
	 * @return the idResolucionParcial
	 */
	public Long getIdResolucionParcial() {
		return idResolucionParcial;
	}

	/**
	 * @param idResolucionParcial the idResolucionParcial to set
	 */
	public void setIdResolucionParcial(Long idResolucionParcial) {
		this.idResolucionParcial = idResolucionParcial;
	}

	
	
	/**
	 * @return the saldoSar92
	 */
	public Double getSaldoSar92() {
		return saldoSar92;
	}

	/**
	 * @param saldoSar92 the saldoSar92 to set
	 */
	public void setSaldoSar92(Double saldoSar92) {
		this.saldoSar92 = saldoSar92;
	}

	/**
	 * @return the saldoRetiro97
	 */
	public Double getSaldoRetiro97() {
		return saldoRetiro97;
	}

	/**
	 * @param saldoRetiro97 the saldoRetiro97 to set
	 */
	public void setSaldoRetiro97(Double saldoRetiro97) {
		this.saldoRetiro97 = saldoRetiro97;
	}

	/**
	 * @return the montoCalculoA
	 */
	public Double getMontoCalculoA() {
		return montoCalculoA;
	}

	/**
	 * @param montoCalculoA the montoCalculoA to set
	 */
	public void setMontoCalculoA(Double montoCalculoA) {
		this.montoCalculoA = montoCalculoA;
	}

	/**
	 * @return the montoCalculoB
	 */
	public Double getMontoCalculoB() {
		return montoCalculoB;
	}

	/**
	 * @param montoCalculoB the montoCalculoB to set
	 */
	public void setMontoCalculoB(Double montoCalculoB) {
		this.montoCalculoB = montoCalculoB;
	}

	/**
	 * @return the tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}

	/**
	 * @param tipoRetiro the tipoRetiro to set
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}

	/**
	 * @return the montoParcialidad
	 */
	public Double getMontoParcialidad() {
		return montoParcialidad;
	}

	/**
	 * @param montoParcialidad the montoParcialidad to set
	 */
	public void setMontoParcialidad(Double montoParcialidad) {
		this.montoParcialidad = montoParcialidad;
	}

	/**
	 * @return the derechoPago
	 */
	public Integer getDerechoPago() {
		return derechoPago;
	}

	/**
	 * @param derechoPago the derechoPago to set
	 */
	public void setDerechoPago(Integer derechoPago) {
		this.derechoPago = derechoPago;
	}
	
	

	/**
	 * @return the idRetiroPortalServ
	 */
	public Long getIdRetiroPortalServ() {
		return idRetiroPortalServ;
	}
	/**
	 * @param idRetiroPortalServ the idRetiroPortalServ to set
	 */
	public void setIdRetiroPortalServ(Long idRetiroPortalServ) {
		this.idRetiroPortalServ = idRetiroPortalServ;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroParcialCalculoImss [idRetiroParcialCalculo=");
		builder.append(idRetiroParcialCalculo);
		builder.append(", tipoRetiroDesempleo=");
		builder.append(tipoRetiroDesempleo);
		builder.append(", cuenta=");
		builder.append(cuenta);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", formaPago=");
		builder.append(formaPago);
		builder.append(", claveBanco=");
		builder.append(claveBanco);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", idResolucionParcial=");
		builder.append(idResolucionParcial);
		builder.append(", saldoSar92=");
		builder.append(saldoSar92);
		builder.append(", saldoRetiro97=");
		builder.append(saldoRetiro97);
		builder.append(", saldoRcv=");
		builder.append(saldoRcv);
		builder.append(", totalSaldos=");
		builder.append(totalSaldos);
		builder.append(", montoCalculoA=");
		builder.append(montoCalculoA);
		builder.append(", montoCalculoB=");
		builder.append(montoCalculoB);
		builder.append(", tipoRetiro=");
		builder.append(tipoRetiro);
		builder.append(", parcialidad=");
		builder.append(parcialidad);
		builder.append(", montoParcialidad=");
		builder.append(montoParcialidad);
		builder.append(", fechaPago=");
		builder.append(fechaPago);
		builder.append(", derechoPago=");
		builder.append(derechoPago);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", idRetiroPortalServ=");
		builder.append(idRetiroPortalServ);
		builder.append("]");
		return builder.toString();
	}
	
	

		
}
