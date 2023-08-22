/**
 * PropertiesApplicationContext.java
 * Fecha de creaci�n: 23/05/2016, 18:19:08
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * <p>Java class for solicitarCertificacionMatrimonioSalida complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitarCertificacionMatrimonioSalida"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="folioDeRecepcion" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_50"/&gt;
 *         &lt;element name="diagnosticoRecepcion" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitarCertificacionMatrimonioSalida", namespace = "http://www.procesar.com.mx/Retiros/DisposicionesParciales/CertificacionMatrimonio/solicitarCertificacionMatrimonio/", propOrder = {
    "resultadoOperacion",
    "motivoRechazo",
    "entidadOrigen",
    "tipoTramite",
    "nss",
    "nombreTrabajadorImss",
    "nombreTrabajadorProcanase",
    "nombreTrabajador",
    "apellidoPaterno",
    "apellidoMaterno",
    "tipoPrestacion",
    "fechaMatrimonioDesempleo",
    "fechaNotificacionImss",
    "fechaConclusionVigencia",
    "resolucion",
    "diagnosticoCuentaIndividual",
    "tipoTrabajadorAportacionCS",
    "pagoComplementario",
    "sbcTipoA",
    "sbcTipoB",
    "montoPagadoRetiroOriginal",
    "saldoAnteriorPagoRetiroOriginal",
    "numeroConsecutivoProcesar",
    "totalResolucionesProcesar",
    "montoDisposicion"
})
public class SolicitarCertificacionMatrimonioSalida {
	@XmlElement(required = true)
	protected String resultadoOperacion;
	@XmlElement(required = true)
	protected String motivoRechazo;
    @XmlElement(required = true)
    protected String entidadOrigen;
    @XmlElement(required = true)
    protected String tipoTramite;
    @XmlElement(required = true)
    protected String nss;
    @XmlElement(required = true)
    protected String nombreTrabajadorImss;
    @XmlElement(required = true)
    protected String nombreTrabajadorProcanase;
    @XmlElement(required = true)
    protected String nombreTrabajador;
    @XmlElement(required = true)
    protected String apellidoPaterno;
    @XmlElement(required = true)
    protected String apellidoMaterno;
    @XmlElement(required = true)
    protected String tipoPrestacion;
    @XmlElement(required = true)
    protected String fechaMatrimonioDesempleo;
    @XmlElement(required = true)
    protected String fechaNotificacionImss;
    @XmlElement(required = true)
    protected String fechaConclusionVigencia;
    @XmlElement(required = true)
    protected String resolucion;
    @XmlElement(required = true)
    protected String diagnosticoCuentaIndividual;
    @XmlElement(required = true)
    protected String tipoTrabajadorAportacionCS;
    @XmlElement(required = true)
    protected BigDecimal sBCTipoA;
    @XmlElement(required = true)
    protected BigDecimal sBCTipoB;
    @XmlElement(required = true)
    protected String pagoComplementario;
    @XmlElement(required = true)
    protected BigDecimal montoPagadoRetiroOriginal;
    @XmlElement(required = true)
    protected BigDecimal saldoAnteriorPagoRetiroOriginal;
    @XmlElement(required = true)
    protected BigInteger numeroConsecutivoProcesar;
    @XmlElement(required = true)
    protected BigInteger totalResolucionesProcesar;
    @XmlElement(required = true)
    protected String montoDisposicion;
    @XmlElement(required = true)
	private String selloTrabajador;

	/**
	 *  getMontoDisposicion
	 *  @return
	 */
	public String getMontoDisposicion() {
		return montoDisposicion;
	}

	/**
	 *  setMontoDisposicion
	 *  @param montoDisposicion
	 */
	public void setMontoDisposicion(String montoDisposicion) {
		this.montoDisposicion = montoDisposicion;
	}

	/**
	 * @return the entidadOrigen
	 */
	public String getEntidadOrigen() {
		return entidadOrigen;
	}

	/**
	 * @param entidadOrigen the entidadOrigen to set
	 */
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
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
	 * @return the nombreTrabajadorImss
	 */
	public String getNombreTrabajadorImss() {
		return nombreTrabajadorImss;
	}

	/**
	 * @param nombreTrabajadorImss the nombreTrabajadorImss to set
	 */
	public void setNombreTrabajadorImss(String nombreTrabajadorImss) {
		this.nombreTrabajadorImss = nombreTrabajadorImss;
	}

	/**
	 * @return the nombreTrabajadorProcanase
	 */
	public String getNombreTrabajadorProcanase() {
		return nombreTrabajadorProcanase;
	}

	/**
	 * @param nombreTrabajadorProcanase the nombreTrabajadorProcanase to set
	 */
	public void setNombreTrabajadorProcanase(String nombreTrabajadorProcanase) {
		this.nombreTrabajadorProcanase = nombreTrabajadorProcanase;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion the tipoPrestacion to set
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return the fechaMatrimonioDesempleo
	 */
	public String getFechaMatrimonioDesempleo() {
		return fechaMatrimonioDesempleo;
	}

	/**
	 * @param fechaMatrimonioDesempleo the fechaMatrimonioDesempleo to set
	 */
	public void setFechaMatrimonioDesempleo(String fechaMatrimonioDesempleo) {
		this.fechaMatrimonioDesempleo = fechaMatrimonioDesempleo;
	}

	/**
	 * @return the fechaNotificacionImss
	 */
	public String getFechaNotificacionImss() {
		return fechaNotificacionImss;
	}

	/**
	 * @param fechaNotificacionImss the fechaNotificacionImss to set
	 */
	public void setFechaNotificacionImss(String fechaNotificacionImss) {
		this.fechaNotificacionImss = fechaNotificacionImss;
	}

	/**
	 * @return the fechaConclusionVigencia
	 */
	public String getFechaConclusionVigencia() {
		return fechaConclusionVigencia;
	}

	/**
	 * @param fechaConclusionVigencia the fechaConclusionVigencia to set
	 */
	public void setFechaConclusionVigencia(String fechaConclusionVigencia) {
		this.fechaConclusionVigencia = fechaConclusionVigencia;
	}

	

	/**
	 * @return the diagnosticoCuentaIndividual
	 */
	public String getDiagnosticoCuentaIndividual() {
		return diagnosticoCuentaIndividual;
	}

	/**
	 * @param diagnosticoCuentaIndividual the diagnosticoCuentaIndividual to set
	 */
	public void setDiagnosticoCuentaIndividual(String diagnosticoCuentaIndividual) {
		this.diagnosticoCuentaIndividual = diagnosticoCuentaIndividual;
	}


	

	/**
	 * @return the montoPagadoRetiroOriginal
	 */
	public BigDecimal getMontoPagadoRetiroOriginal() {
		return montoPagadoRetiroOriginal;
	}

	/**
	 * @param montoPagadoRetiroOriginal the montoPagadoRetiroOriginal to set
	 */
	public void setMontoPagadoRetiroOriginal(BigDecimal montoPagadoRetiroOriginal) {
		this.montoPagadoRetiroOriginal = montoPagadoRetiroOriginal;
	}

	/**
	 * @return the saldoAnteriorPagoRetiroOriginal
	 */
	public BigDecimal getSaldoAnteriorPagoRetiroOriginal() {
		return saldoAnteriorPagoRetiroOriginal;
	}

	/**
	 * @param saldoAnteriorPagoRetiroOriginal the saldoAnteriorPagoRetiroOriginal to set
	 */
	public void setSaldoAnteriorPagoRetiroOriginal(BigDecimal saldoAnteriorPagoRetiroOriginal) {
		this.saldoAnteriorPagoRetiroOriginal = saldoAnteriorPagoRetiroOriginal;
	}

	/**
	 * @return the numeroConsecutivoProcesar
	 */
	public BigInteger getNumeroConsecutivoProcesar() {
		return numeroConsecutivoProcesar;
	}

	/**
	 * @param numeroConsecutivoProcesar the numeroConsecutivoProcesar to set
	 */
	public void setNumeroConsecutivoProcesar(BigInteger numeroConsecutivoProcesar) {
		this.numeroConsecutivoProcesar = numeroConsecutivoProcesar;
	}

	/**
	 * @return the totalResolucionesProcesar
	 */
	public BigInteger getTotalResolucionesProcesar() {
		return totalResolucionesProcesar;
	}

	/**
	 * @param totalResolucionesProcesar the totalResolucionesProcesar to set
	 */
	public void setTotalResolucionesProcesar(BigInteger totalResolucionesProcesar) {
		this.totalResolucionesProcesar = totalResolucionesProcesar;
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
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the tipoTramite
	 */
	public String getTipoTramite() {
		return tipoTramite;
	}

	/**
	 * @param tipoTramite the tipoTramite to set
	 */
	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	/**
	 * @return the tipoTrabajadorAportacionCS
	 */
	public String getTipoTrabajadorAportacionCS() {
		return tipoTrabajadorAportacionCS;
	}

	/**
	 * @param tipoTrabajadorAportacionCS the tipoTrabajadorAportacionCS to set
	 */
	public void setTipoTrabajadorAportacionCS(String tipoTrabajadorAportacionCS) {
		this.tipoTrabajadorAportacionCS = tipoTrabajadorAportacionCS;
	}

	public BigDecimal getsBCTipoA() {
		return sBCTipoA;
	}

	public void setsBCTipoA(BigDecimal sBCTipoA) {
		this.sBCTipoA = sBCTipoA;
	}

	public BigDecimal getsBCTipoB() {
		return sBCTipoB;
	}

	public void setsBCTipoB(BigDecimal sBCTipoB) {
		this.sBCTipoB = sBCTipoB;
	}

	/**
	 * @return the pagoComplementario
	 */
	public String getPagoComplementario() {
		return pagoComplementario;
	}

	/**
	 * @param pagoComplementario the pagoComplementario to set
	 */
	public void setPagoComplementario(String pagoComplementario) {
		this.pagoComplementario = pagoComplementario;
	}

	/**
	 * @return the resolucion
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * @param resolucion the resolucion to set
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getSelloTrabajador() {
		return selloTrabajador;
	}

	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SolicitarCertificacionMatrimonioSalida [resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", tipoTramite=");
		builder.append(tipoTramite);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", nombreTrabajadorImss=");
		builder.append(nombreTrabajadorImss);
		builder.append(", nombreTrabajadorProcanase=");
		builder.append(nombreTrabajadorProcanase);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", fechaMatrimonioDesempleo=");
		builder.append(fechaMatrimonioDesempleo);
		builder.append(", fechaNotificacionImss=");
		builder.append(fechaNotificacionImss);
		builder.append(", fechaConclusionVigencia=");
		builder.append(fechaConclusionVigencia);
		builder.append(", resolucion=");
		builder.append(resolucion);
		builder.append(", diagnosticoCuentaIndividual=");
		builder.append(diagnosticoCuentaIndividual);
		builder.append(", tipoTrabajadorAportacionCS=");
		builder.append(tipoTrabajadorAportacionCS);
		builder.append(", sBCTipoA=");
		builder.append(sBCTipoA);
		builder.append(", sBCTipoB=");
		builder.append(sBCTipoB);
		builder.append(", pagoComplementario=");
		builder.append(pagoComplementario);
		builder.append(", montoPagadoRetiroOriginal=");
		builder.append(montoPagadoRetiroOriginal);
		builder.append(", saldoAnteriorPagoRetiroOriginal=");
		builder.append(saldoAnteriorPagoRetiroOriginal);
		builder.append(", numeroConsecutivoProcesar=");
		builder.append(numeroConsecutivoProcesar);
		builder.append(", totalResolucionesProcesar=");
		builder.append(totalResolucionesProcesar);
		builder.append("]");
		return builder.toString();
	}

	
	

}
