package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoRetiroDesempleo;

/**
 * Datos salida pagos Parcialidad
 * @author ANOSORIO
 *
 */
public class RetiroParcialCalculoImssSalida implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2047055042118460857L;

   private Long idRetiroParcialCalculo;
	
	
	/**
	 * Clave Tipo Retiro Desempleo
	 */
	
	private TipoRetiroDesempleo tipoRetiroDesempleo;
	
	/**
	 * Cuenta
	 */
	private String cuenta;
	
	/**
	 * Cuenta Clabe
	 */
	private String cuentaClabe;
	
	/**
	 * Forma de pago
	 */
	private String formaPago;
	
	/**
	 * Clave Banco
	 */
	private String claveBanco;
	
	/**
	 * Estatus
	 */
	private Integer estatus;
	
	/**
	 * Id resolucion parcial
	 */
	private ResolucionParcial idResolucionParcial;
	
	/**
	 * Saldo sar 92
	 */
	private Double saldoSar92;
	
	/**
	 * Saldo retiro 97
	 */
	private Double saldoRetiro97;

	/**
	 * saldoRcv
	 */
	private Double saldoRcv;
	
	/**
	 * Total Saldos
	 */
	private Double totalSaldos;
	
	
	/**
	 * Monto Calculo A
	 */
	private Double montoCalculoA;
	
	/**
	 * Monto Calculo B
	 */
	private Double montoCalculoB;
	
	/**
	 * Tipo Retiro
	 */
	private String tipoRetiro; 
	
	/**
	 * Parcialidad
	 */
	private Integer parcialidad;
	
	/**
	 * Monto Parcialidad
	 */
	private Double montoParcialidad;
	
	/**
	 * Fecha Pago
	 */
	private String fechaPago;

	
	/**
	 * Derecho pago
	 */
	private Integer derechoPago;
	
	/**
	 * Fecha Control
	 */
	private Date fechaControl;
	
	/**
	 * Usuario modificador
	 */
	
	private String usuarioModificador;

	/**
	 * descripcionEstatus
	 */
	private String descripcionEstatus;
	
	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;
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
	 * @return the tipoRetiroDesempleo
	 */
	public TipoRetiroDesempleo getTipoRetiroDesempleo() {
		return tipoRetiroDesempleo;
	}

	/**
	 * @param tipoRetiroDesempleo the tipoRetiroDesempleo to set
	 */
	public void setTipoRetiroDesempleo(TipoRetiroDesempleo tipoRetiroDesempleo) {
		this.tipoRetiroDesempleo = tipoRetiroDesempleo;
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
	 * @return the idResolucionParcial
	 */
	public ResolucionParcial getIdResolucionParcial() {
		return idResolucionParcial;
	}

	/**
	 * @param idResolucionParcial the idResolucionParcial to set
	 */
	public void setIdResolucionParcial(ResolucionParcial idResolucionParcial) {
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
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
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
	 * @return the descripcionEstatus
	 */
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}

	/**
	 * @param descripcionEstatus the descripcionEstatus to set
	 */
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
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
	 * Constructor
	 */
	public RetiroParcialCalculoImssSalida() {
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroParcialCalculoImssSalida [idRetiroParcialCalculo=");
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
		builder.append(", descripcionEstatus=");
		builder.append(descripcionEstatus);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append("]");
		return builder.toString();
	}

	
}
