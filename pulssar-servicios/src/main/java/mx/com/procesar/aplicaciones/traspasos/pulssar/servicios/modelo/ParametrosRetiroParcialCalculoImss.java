package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase datos de entrada
 * 
 * @author ANOSORIO
 *
 */
public class ParametrosRetiroParcialCalculoImss implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -1110068950501009828L;

	/**
	 * idProcesar
	 */
	private Long idProcesar;

	/**
	 * claveProceso
	 */
	private String claveProceso;

	/**
	 * tipoOperacion
	 */
	private String tipoOperacion;

	/**
	 * proceso de referencia
	 */
	private String procesoReferencia;

	/**
	 * folio de proceso del expediente
	 */
	private String folio;

	/**
	 * CV_TIPO_RETIRO_DESEMPLEO
	 */
	private String clave;

	/**
	 * cuenta
	 */
	private String cuenta;

	/**
	 * cuentaClabe
	 */
	private String cuentaClabe;

	/**
	 * formaPago
	 */
	private String formaPago;

	/**
	 * claveBanco
	 */
	private String claveBanco;

	/**
	 * estatus
	 */
	private Integer estatus;

	/**
	 * id
	 */
	private Long id;// ResolucionParcial

	/**
	 * saldoCuotaSocial
	 */
	private Double saldoCuotaSocial;

	/**
	 * saldoRetiro92I
	 */
	private Double saldoRetiro97;

	/**
	 * saldoRcv
	 */
	private Double saldoRcv;

	/**
	 * totalSaldos
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
	 * montoParcialidad
	 */
	private String tipoRetiro;

	/**
	 * mensualidad
	 */
	private List<Mensualidad> mensualidad;

	/**
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * descripcionCtrlInstBancaria
	 */
	private String descripcionCtrlInstBancaria;

	/**
	 * numeroParcialidad
	 */
	private Integer numeroParcialidad;

	/**
	 * Folio Hijo
	 */
	private String folioHijo;

	/**
	 * id folio
	 */
	private Long idFolio;

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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso the claveProceso to set
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * @return the procesoReferencia
	 */
	public String getProcesoReferencia() {
		return procesoReferencia;
	}

	/**
	 * @param procesoReferencia the procesoReferencia to set
	 */
	public void setProcesoReferencia(String procesoReferencia) {
		this.procesoReferencia = procesoReferencia;
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
	 * @return the saldoCuotaSocial
	 */
	public Double getSaldoCuotaSocial() {
		return saldoCuotaSocial;
	}

	/**
	 * @param saldoSar92 the saldoSar92 to set
	 */
	public void setSaldoCuotaSocial(Double saldoCuotaSocial) {
		this.saldoCuotaSocial = saldoCuotaSocial;
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
	 * @return the mensualidad
	 */
	public List<Mensualidad> getMensualidad() {
		return mensualidad;
	}

	/**
	 * @param mensualidad the mensualidad to set
	 */
	public void setMensualidad(List<Mensualidad> mensualidad) {
		this.mensualidad = mensualidad;
	}

	/**
	 * @return the descripcionCtrlInstBancaria
	 */
	public String getDescripcionCtrlInstBancaria() {
		return descripcionCtrlInstBancaria;
	}

	/**
	 * @param descripcionCtrlInstBancaria the descripcionCtrlInstBancaria to set
	 */
	public void setDescripcionCtrlInstBancaria(String descripcionCtrlInstBancaria) {
		this.descripcionCtrlInstBancaria = descripcionCtrlInstBancaria;
	}

	/**
	 * @return the numeroParcialidad
	 */
	public Integer getNumeroParcialidad() {
		return numeroParcialidad;
	}

	/**
	 * @param numeroParcialidad the numeroParcialidad to set
	 */
	public void setNumeroParcialidad(Integer numeroParcialidad) {
		this.numeroParcialidad = numeroParcialidad;
	}

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * Constructor
	 */
	public ParametrosRetiroParcialCalculoImss() {

	}

	/**
	 * @return el atributo folioHijo
	 */
	public String getFolioHijo() {
		return folioHijo;
	}

	/**
	 * @param folioHijo parametro folioHijo a actualizar
	 */
	public void setFolioHijo(String folioHijo) {
		this.folioHijo = folioHijo;
	}

	/**
	 * @return el atributo idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}

	/**
	 * @param idFolio parametro idFolio a actualizar
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
