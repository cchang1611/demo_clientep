package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 */
public class NotificacionCalculoTipoRetiro implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2914905470465858512L;

	/**
	 * idNotifTipoRetiro
	 */
	private Long idNotifCalcTipoRetiro;
	/**
	 * folio
	 */
	private String folio;
	
	/**
	 * salBaseCotizacion
	 */
	private BigDecimal salBaseCotizacion;
	
	/**
	 * sbc75
	 */
	private BigDecimal sbc75;
	
	/**
	 * rcv
	 */
	private BigDecimal rcv;
	
	/**
	 * montoRcv10
	 */
	private BigDecimal montoRcv10;
	
	/**
	 * montoSarIssste
	 */
	private BigDecimal montoSarIssste;
	
	/**
	 * montoSarIssste10
	 */
	private BigDecimal montoSarIssste10;
	
	/**
	 * montoEstimadoPag
	 */
	private BigDecimal montoEstimadoPag;
	
	/**
	 * afore
	 */
	private String afore;
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * numeroCuenta
	 */
	private String numeroCuenta;
	/**
	 * cuentaClabe
	 */
	private String cuentaClabe;
	/**
	 * claveBanco
	 */
	private String claveBanco;
	
	/**
	 * tipoRetiroSeleccion
	 */
	private String tipoRetiroSeleccion;
	
	/**
	 * fechaProcesamiento
	 */
	private Date fechaProcesamiento;
	
	/**
	 * diagnosticoRecepcion
	 */
	private String diagnosticoRecepcion;
	
	/**
	 * notificado
	 */
	private Long notificado;
	
	/**
	 * fechaNotificado
	 */
	private Date fechaNotificado;
	
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 *  inicializador bigdecimals
	 */
	public NotificacionCalculoTipoRetiro() {

		this.salBaseCotizacion = BigDecimal.ZERO;
		this.sbc75 = BigDecimal.ZERO;
		this.rcv = BigDecimal.ZERO;
		this.montoRcv10 = BigDecimal.ZERO;
		this.montoSarIssste = BigDecimal.ZERO;
		this.montoSarIssste10 = BigDecimal.ZERO;
		this.montoEstimadoPag = BigDecimal.ZERO;
	}
	
	/**
	 * @return el atributo idNotifCalcTipoRetiro
	 */
	public Long getIdNotifCalcTipoRetiro() {
		return idNotifCalcTipoRetiro;
	}

	/**
	 * @param idNotifCalcTipoRetiro parametro idNotifCalcTipoRetiro a actualizar
	 */
	public void setIdNotifCalcTipoRetiro(Long idNotifCalcTipoRetiro) {
		this.idNotifCalcTipoRetiro = idNotifCalcTipoRetiro;
	}

	/**
	 * @return el atributo folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio parametro folio a actualizar
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return el atributo salBaseCotizacion
	 */
	public BigDecimal getSalBaseCotizacion() {
		return salBaseCotizacion;
	}

	/**
	 * @param salBaseCotizacion parametro salBaseCotizacion a actualizar
	 */
	public void setSalBaseCotizacion(BigDecimal salBaseCotizacion) {
		this.salBaseCotizacion = salBaseCotizacion;
	}

	/**
	 * @return el atributo sbc75
	 */
	public BigDecimal getSbc75() {
		return sbc75;
	}

	/**
	 * @param sbc75 parametro sbc75 a actualizar
	 */
	public void setSbc75(BigDecimal sbc75) {
		this.sbc75 = sbc75;
	}

	/**
	 * @return el atributo rcv
	 */
	public BigDecimal getRcv() {
		return rcv;
	}

	/**
	 * @param rcv parametro rcv a actualizar
	 */
	public void setRcv(BigDecimal rcv) {
		this.rcv = rcv;
	}

	/**
	 * @return el atributo montoRcv10
	 */
	public BigDecimal getMontoRcv10() {
		return montoRcv10;
	}

	/**
	 * @param montoRcv10 parametro montoRcv10 a actualizar
	 */
	public void setMontoRcv10(BigDecimal montoRcv10) {
		this.montoRcv10 = montoRcv10;
	}

	/**
	 * @return el atributo montoSarIssste
	 */
	public BigDecimal getMontoSarIssste() {
		return montoSarIssste;
	}

	/**
	 * @param montoSarIssste parametro montoSarIssste a actualizar
	 */
	public void setMontoSarIssste(BigDecimal montoSarIssste) {
		this.montoSarIssste = montoSarIssste;
	}

	/**
	 * @return el atributo montoSarIssste10
	 */
	public BigDecimal getMontoSarIssste10() {
		return montoSarIssste10;
	}

	/**
	 * @param montoSarIssste10 parametro montoSarIssste10 a actualizar
	 */
	public void setMontoSarIssste10(BigDecimal montoSarIssste10) {
		this.montoSarIssste10 = montoSarIssste10;
	}

	/**
	 * @return el atributo montoEstimadoPag
	 */
	public BigDecimal getMontoEstimadoPag() {
		return montoEstimadoPag;
	}

	/**
	 * @param montoEstimadoPag parametro montoEstimadoPag a actualizar
	 */
	public void setMontoEstimadoPag(BigDecimal montoEstimadoPag) {
		this.montoEstimadoPag = montoEstimadoPag;
	}

	/**
	 * @return el atributo afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore parametro afore a actualizar
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return el atributo numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta parametro numeroCuenta a actualizar
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return el atributo cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe parametro cuentaClabe a actualizar
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/**
	 * @return el atributo claveBanco
	 */
	public String getClaveBanco() {
		return claveBanco;
	}

	/**
	 * @param claveBanco parametro claveBanco a actualizar
	 */
	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}

	/**
	 * @return el atributo tipoRetiroSeleccion
	 */
	public String getTipoRetiroSeleccion() {
		return tipoRetiroSeleccion;
	}

	/**
	 * @param tipoRetiroSeleccion parametro tipoRetiroSeleccion a actualizar
	 */
	public void setTipoRetiroSeleccion(String tipoRetiroSeleccion) {
		this.tipoRetiroSeleccion = tipoRetiroSeleccion;
	}

	/**
	 * @return el atributo fechaProcesamiento
	 */
	public Date getFechaProcesamiento() {
		return fechaProcesamiento;
	}

	/**
	 * @param fechaProcesamiento parametro fechaProcesamiento a actualizar
	 */
	public void setFechaProcesamiento(Date fechaProcesamiento) {
		this.fechaProcesamiento = fechaProcesamiento;
	}

	/**
	 * @return el atributo diagnosticoRecepcion
	 */
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}

	/**
	 * @param diagnosticoRecepcion parametro diagnosticoRecepcion a actualizar
	 */
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
	}

	/**
	 * @return el atributo notificado
	 */
	public Long getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado parametro notificado a actualizar
	 */
	public void setNotificado(Long notificado) {
		this.notificado = notificado;
	}

	/**
	 * @return el atributo fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * @param fechaNotificado parametro fechaNotificado a actualizar
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionCalculoTipoRetiro [idNotifCalcTipoRetiro=");
		builder.append(idNotifCalcTipoRetiro);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", salBaseCotizacion=");
		builder.append(salBaseCotizacion);
		builder.append(", sbc75=");
		builder.append(sbc75);
		builder.append(", rcv=");
		builder.append(rcv);
		builder.append(", montoRcv10=");
		builder.append(montoRcv10);
		builder.append(", montoSarIssste=");
		builder.append(montoSarIssste);
		builder.append(", montoSarIssste10=");
		builder.append(montoSarIssste10);
		builder.append(", montoEstimadoPag=");
		builder.append(montoEstimadoPag);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", numeroCuenta=");
		builder.append(numeroCuenta);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", claveBanco=");
		builder.append(claveBanco);
		builder.append(", tipoRetiroSeleccion=");
		builder.append(tipoRetiroSeleccion);
		builder.append(", fechaProcesamiento=");
		builder.append(fechaProcesamiento);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", notificado=");
		builder.append(notificado);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}