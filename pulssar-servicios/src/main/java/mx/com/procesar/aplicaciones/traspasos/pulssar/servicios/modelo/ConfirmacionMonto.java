package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * Clase modelo de la confirmacion de reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class ConfirmacionMonto implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -5499409970327155825L;

	/**
	 * idConfirmacionMonto
	 */
	private Long idConfirmacionMonto;

	/**
	 * afore
	 */
	private String afore;

	/**
	 * aforeRetiro
	 */
	private String aforeRetiro;

	/**
	 * centroInformatico
	 */
	private String centroInformatico;

	/**
	 * identificadorOperacion
	 */
	private String identificadorOperacion;

	/**
	 * nombreTrabajador
	 */
	private String nombreTrabajador;

	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;

	/**
	 * regimen
	 */
	private String regimen;

	/**
	 * tipoPrestacion
	 */
	private String tipoPrestacion;

	private String usuarioModificador;

	/**
	 * xmlRespConfirmaMonto
	 */
	private String xmlRespConfirmaMonto;

	/**
	 * fechaControl
	 */
	private Timestamp fechaControl;

	/**
	 * fechaEventoRetiro
	 */
	private Date fechaEventoRetiro;

	/**
	 * fechaEventoRetiroImss
	 */
	private Date fechaEventoRetiroImss;

	private Date fechaPagoReintegro;

	/**
	 * fechaPagoReintegroImss
	 */
	private Date fechaPagoReintegroImss;

	/**
	 * fechaSolicitud
	 */
	private Timestamp fechaSolicitud;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * nssImss
	 */
	private String nssImss;

	/**
	 * diasCotizaRecuperadoImss
	 */
	private BigDecimal diasCotizaRecuperadoImss;

	/**
	 * diasCotizacionRecuperados
	 */
	private BigDecimal diasCotizacionRecuperados;

	/**
	 * diasDescontadosRetiro
	 */
	private BigDecimal diasDescontadosRetiro;

	/**
	 * impPesosReintegrarImss
	 */
	private BigDecimal importePesosReintegrarImss;

	/**
	 * importePesosReintegrar
	 */
	private BigDecimal importePesosReintegrar;

	/**
	 * importeRcv
	 */
	private BigDecimal importeRcv;

	/**
	 * maxSemanasReintegrar
	 */
	private BigDecimal maxSemanasReintegrar;

	/**
	 * montoMaxReintegrar
	 */
	private BigDecimal montoMaxReintegrar;

	/**
	 * origen
	 */
	private BigDecimal origen;

	/**
	 * semanasCalculadas
	 */
	private BigDecimal semanasCalculadas;

	/**
	 * valorDiaReintegrar
	 */
	private BigDecimal valorDiaReintegrar;

	/**
	 * calculoReintegro
	 */
	private CalculoReintegro calculoReintegro;

	/**
	 * diagnostico
	 */
	private Diagnostico diagnostico;

	/**
	 * @return el atributo idConfirmacionMonto
	 */
	public Long getIdConfirmacionMonto() {
		return idConfirmacionMonto;
	}

	/**
	 * @param idConfirmacionMonto
	 *            parametro idConfirmacionMonto a actualizar
	 */
	public void setIdConfirmacionMonto(Long idConfirmacionMonto) {
		this.idConfirmacionMonto = idConfirmacionMonto;
	}

	/**
	 * @return el atributo afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore
	 *            parametro afore a actualizar
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return el atributo aforeRetiro
	 */
	public String getAforeRetiro() {
		return aforeRetiro;
	}

	/**
	 * @param aforeRetiro
	 *            parametro aforeRetiro a actualizar
	 */
	public void setAforeRetiro(String aforeRetiro) {
		this.aforeRetiro = aforeRetiro;
	}

	/**
	 * @return el atributo centroInformatico
	 */
	public String getCentroInformatico() {
		return centroInformatico;
	}

	/**
	 * @param centroInformatico
	 *            parametro centroInformatico a actualizar
	 */
	public void setCentroInformatico(String centroInformatico) {
		this.centroInformatico = centroInformatico;
	}

	/**
	 * @return el atributo identificadorOperacion
	 */
	public String getIdentificadorOperacion() {
		return identificadorOperacion;
	}

	/**
	 * @param identificadorOperacion
	 *            parametro identificadorOperacion a actualizar
	 */
	public void setIdentificadorOperacion(String identificadorOperacion) {
		this.identificadorOperacion = identificadorOperacion;
	}

	/**
	 * @return el atributo nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador
	 *            parametro nombreTrabajador a actualizar
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion
	 *            parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return el atributo regimen
	 */
	public String getRegimen() {
		return regimen;
	}

	/**
	 * @param regimen
	 *            parametro regimen a actualizar
	 */
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion
	 *            parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo xmlRespConfirmaMonto
	 */
	public String getXmlRespConfirmaMonto() {
		return xmlRespConfirmaMonto;
	}

	/**
	 * @param xmlRespConfirmaMonto
	 *            parametro xmlRespConfirmaMonto a actualizar
	 */
	public void setXmlRespConfirmaMonto(String xmlRespConfirmaMonto) {
		this.xmlRespConfirmaMonto = xmlRespConfirmaMonto;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Timestamp getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Timestamp fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo fechaEventoRetiro
	 */
	public Date getFechaEventoRetiro() {
		return fechaEventoRetiro;
	}

	/**
	 * @param fechaEventoRetiro
	 *            parametro fechaEventoRetiro a actualizar
	 */
	public void setFechaEventoRetiro(Date fechaEventoRetiro) {
		this.fechaEventoRetiro = fechaEventoRetiro;
	}

	/**
	 * @return el atributo fechaEventoRetiroImss
	 */
	public Date getFechaEventoRetiroImss() {
		return fechaEventoRetiroImss;
	}

	/**
	 * @param fechaEventoRetiroImss
	 *            parametro fechaEventoRetiroImss a actualizar
	 */
	public void setFechaEventoRetiroImss(Date fechaEventoRetiroImss) {
		this.fechaEventoRetiroImss = fechaEventoRetiroImss;
	}

	/**
	 * @return el atributo fechaPagoReintegro
	 */
	public Date getFechaPagoReintegro() {
		return fechaPagoReintegro;
	}

	/**
	 * @param fechaPagoReintegro
	 *            parametro fechaPagoReintegro a actualizar
	 */
	public void setFechaPagoReintegro(Date fechaPagoReintegro) {
		this.fechaPagoReintegro = fechaPagoReintegro;
	}

	/**
	 * @return el atributo fechaPagoReintegroImss
	 */
	public Date getFechaPagoReintegroImss() {
		return fechaPagoReintegroImss;
	}

	/**
	 * @param fechaPagoReintegroImss
	 *            parametro fechaPagoReintegroImss a actualizar
	 */
	public void setFechaPagoReintegroImss(Date fechaPagoReintegroImss) {
		this.fechaPagoReintegroImss = fechaPagoReintegroImss;
	}

	/**
	 * @return el atributo fechaSolicitud
	 */
	public Timestamp getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud
	 *            parametro fechaSolicitud a actualizar
	 */
	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 *            parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo nssImss
	 */
	public String getNssImss() {
		return nssImss;
	}

	/**
	 * @param nssImss
	 *            parametro nssImss a actualizar
	 */
	public void setNssImss(String nssImss) {
		this.nssImss = nssImss;
	}

	/**
	 * @return el atributo diasCotizaRecuperadoImss
	 */
	public BigDecimal getDiasCotizaRecuperadoImss() {
		return diasCotizaRecuperadoImss;
	}

	/**
	 * @param diasCotizaRecuperadoImss
	 *            parametro diasCotizaRecuperadoImss a actualizar
	 */
	public void setDiasCotizaRecuperadoImss(BigDecimal diasCotizaRecuperadoImss) {
		this.diasCotizaRecuperadoImss = diasCotizaRecuperadoImss;
	}

	/**
	 * @return el atributo diasCotizacionRecuperados
	 */
	public BigDecimal getDiasCotizacionRecuperados() {
		return diasCotizacionRecuperados;
	}

	/**
	 * @param diasCotizacionRecuperados
	 *            parametro diasCotizacionRecuperados a actualizar
	 */
	public void setDiasCotizacionRecuperados(BigDecimal diasCotizacionRecuperados) {
		this.diasCotizacionRecuperados = diasCotizacionRecuperados;
	}

	/**
	 * @return el atributo diasDescontadosRetiro
	 */
	public BigDecimal getDiasDescontadosRetiro() {
		return diasDescontadosRetiro;
	}

	/**
	 * @param diasDescontadosRetiro
	 *            parametro diasDescontadosRetiro a actualizar
	 */
	public void setDiasDescontadosRetiro(BigDecimal diasDescontadosRetiro) {
		this.diasDescontadosRetiro = diasDescontadosRetiro;
	}

	/**
	 * @return el atributo importePesosReintegrarImss
	 */
	public BigDecimal getImportePesosReintegrarImss() {
		return importePesosReintegrarImss;
	}

	/**
	 * @param importePesosReintegrarImss
	 *            parametro importePesosReintegrarImss a actualizar
	 */
	public void setImportePesosReintegrarImss(BigDecimal importePesosReintegrarImss) {
		this.importePesosReintegrarImss = importePesosReintegrarImss;
	}

	/**
	 * @return el atributo importePesosReintegrar
	 */
	public BigDecimal getImportePesosReintegrar() {
		return importePesosReintegrar;
	}

	/**
	 * @param importePesosReintegrar
	 *            parametro importePesosReintegrar a actualizar
	 */
	public void setImportePesosReintegrar(BigDecimal importePesosReintegrar) {
		this.importePesosReintegrar = importePesosReintegrar;
	}

	/**
	 * @return el atributo importeRcv
	 */
	public BigDecimal getImporteRcv() {
		return importeRcv;
	}

	/**
	 * @param importeRcv
	 *            parametro importeRcv a actualizar
	 */
	public void setImporteRcv(BigDecimal importeRcv) {
		this.importeRcv = importeRcv;
	}

	/**
	 * @return el atributo maxSemanasReintegrar
	 */
	public BigDecimal getMaxSemanasReintegrar() {
		return maxSemanasReintegrar;
	}

	/**
	 * @param maxSemanasReintegrar
	 *            parametro maxSemanasReintegrar a actualizar
	 */
	public void setMaxSemanasReintegrar(BigDecimal maxSemanasReintegrar) {
		this.maxSemanasReintegrar = maxSemanasReintegrar;
	}

	/**
	 * @return el atributo montoMaxReintegrar
	 */
	public BigDecimal getMontoMaxReintegrar() {
		return montoMaxReintegrar;
	}

	/**
	 * @param montoMaxReintegrar
	 *            parametro montoMaxReintegrar a actualizar
	 */
	public void setMontoMaxReintegrar(BigDecimal montoMaxReintegrar) {
		this.montoMaxReintegrar = montoMaxReintegrar;
	}

	/**
	 * @return el atributo origen
	 */
	public BigDecimal getOrigen() {
		return origen;
	}

	/**
	 * @param origen
	 *            parametro origen a actualizar
	 */
	public void setOrigen(BigDecimal origen) {
		this.origen = origen;
	}

	/**
	 * @return el atributo semanasCalculadas
	 */
	public BigDecimal getSemanasCalculadas() {
		return semanasCalculadas;
	}

	/**
	 * @param semanasCalculadas
	 *            parametro semanasCalculadas a actualizar
	 */
	public void setSemanasCalculadas(BigDecimal semanasCalculadas) {
		this.semanasCalculadas = semanasCalculadas;
	}

	/**
	 * @return el atributo valorDiaReintegrar
	 */
	public BigDecimal getValorDiaReintegrar() {
		return valorDiaReintegrar;
	}

	/**
	 * @param valorDiaReintegrar
	 *            parametro valorDiaReintegrar a actualizar
	 */
	public void setValorDiaReintegrar(BigDecimal valorDiaReintegrar) {
		this.valorDiaReintegrar = valorDiaReintegrar;
	}

	/**
	 * @return el atributo calculoReintegro
	 */
	public CalculoReintegro getCalculoReintegro() {
		return calculoReintegro;
	}

	/**
	 * @param calculoReintegro
	 *            parametro calculoReintegro a actualizar
	 */
	public void setCalculoReintegro(CalculoReintegro calculoReintegro) {
		this.calculoReintegro = calculoReintegro;
	}

	/**
	 * @return el atributo diagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico
	 *            parametro diagnostico a actualizar
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return el atributo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfirmacionMonto [idConfirmacionMonto=");
		builder.append(idConfirmacionMonto);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", aforeRetiro=");
		builder.append(aforeRetiro);
		builder.append(", centroInformatico=");
		builder.append(centroInformatico);
		builder.append(", identificadorOperacion=");
		builder.append(identificadorOperacion);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", regimen=");
		builder.append(regimen);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", xmlRespConfirmaMonto=");
		builder.append(xmlRespConfirmaMonto);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaEventoRetiro=");
		builder.append(fechaEventoRetiro);
		builder.append(", fechaEventoRetiroImss=");
		builder.append(fechaEventoRetiroImss);
		builder.append(", fechaPagoReintegro=");
		builder.append(fechaPagoReintegro);
		builder.append(", fechaPagoReintegroImss=");
		builder.append(fechaPagoReintegroImss);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", nssImss=");
		builder.append(nssImss);
		builder.append(", diasCotizaRecuperadoImss=");
		builder.append(diasCotizaRecuperadoImss);
		builder.append(", diasCotizacionRecuperados=");
		builder.append(diasCotizacionRecuperados);
		builder.append(", diasDescontadosRetiro=");
		builder.append(diasDescontadosRetiro);
		builder.append(", importePesosReintegrarImss=");
		builder.append(importePesosReintegrarImss);
		builder.append(", importePesosReintegrar=");
		builder.append(importePesosReintegrar);
		builder.append(", importeRcv=");
		builder.append(importeRcv);
		builder.append(", maxSemanasReintegrar=");
		builder.append(maxSemanasReintegrar);
		builder.append(", montoMaxReintegrar=");
		builder.append(montoMaxReintegrar);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", semanasCalculadas=");
		builder.append(semanasCalculadas);
		builder.append(", valorDiaReintegrar=");
		builder.append(valorDiaReintegrar);
		builder.append(", calculoReintegro=");
		builder.append(calculoReintegro);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append("]");
		return builder.toString();
	}

}