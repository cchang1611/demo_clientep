/**
 * LineaCapturaPago.java
 * Fecha de creación: Feb 25, 2021 5:49:29 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Clase LineaCapturaPago.java
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class LineaCapturaPago implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 2920929140524337280L;

	/**
	 * Atributo idLinCapPago
	 */
	private Long idLinCapPago;

	/**
	 * Atributo chBimestrePago
	 */
	private String chBimestrePago;

	/**
	 * Atributo chLieaCaptura
	 */
	private String chLieaCaptura;

	/**
	 * Atributo nuTipoLinea
	 */
	private Integer nuTipoLinea;

	/**
	 * Atributo nuConsecutivoLinea
	 */
	private Integer nuConsecutivoLinea;

	/**
	 * Atributo fcPago
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcPago;

	/**
	 * Atributo fcValor
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcValor;

	/**
	 * Atributo chTipoPago
	 */
	private String chTipoPago;

	/**
	 * Atributo nuDigitoVerificador
	 */
	private Integer nuDigitoVerificador;

	/**
	 * Atributo fcCaducidad
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcCaducidad;

	/**
	 * Atributo cvEstadoLc
	 */
	private String cvEstadoLc;

	/**
	 * Atributo fcIndividualizacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcIndividualizacion;

	/**
	 * Atributo fcRecepcion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcRecepcion;

	/**
	 * Atributo nuMontoPago
	 */
	private BigDecimal nuMontoPago;

	/**
	 * Atributo idArchivo
	 */
	private Long idArchivo;

	/**
	 * Atributo cvEntidadRecaudadora
	 */
	private String cvEntidadRecaudadora;

	/**
	 * Atributo nuTrabajadores
	 */
	private Integer nuTrabajadores;

	/**
	 * Atributo cvCentroPago
	 */
	private String cvCentroPago;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chTipoInversion
	 */
	private String chTipoInversion;

	/**
	 * Atributo idPagoLc
	 */
	private Long idPagoLc;

	/**
	 * Obtener idLinCapPago
	 */
	public Long getIdLinCapPago() {
		return idLinCapPago;
	}

	/**
	 * Setear idLinCapPago
	 */
	public void setIdLinCapPago(Long idLinCapPago) {
		this.idLinCapPago = idLinCapPago;
	}

	/**
	 * Obtener chBimestrePago
	 */
	public String getChBimestrePago() {
		return chBimestrePago;
	}

	/**
	 * Setear chBimestrePago
	 */
	public void setChBimestrePago(String chBimestrePago) {
		this.chBimestrePago = chBimestrePago;
	}

	/**
	 * Obtener chLieaCaptura
	 */
	public String getChLieaCaptura() {
		return chLieaCaptura;
	}

	/**
	 * Setear chLieaCaptura
	 */
	public void setChLieaCaptura(String chLieaCaptura) {
		this.chLieaCaptura = chLieaCaptura;
	}

	/**
	 * Obtener nuTipoLinea
	 */
	public Integer getNuTipoLinea() {
		return nuTipoLinea;
	}

	/**
	 * Setear nuTipoLinea
	 */
	public void setNuTipoLinea(Integer nuTipoLinea) {
		this.nuTipoLinea = nuTipoLinea;
	}

	/**
	 * Obtener nuConsecutivoLinea
	 */
	public Integer getNuConsecutivoLinea() {
		return nuConsecutivoLinea;
	}

	/**
	 * Setear nuConsecutivoLinea
	 */
	public void setNuConsecutivoLinea(Integer nuConsecutivoLinea) {
		this.nuConsecutivoLinea = nuConsecutivoLinea;
	}

	/**
	 * Obtener fcPago
	 */
	public Date getFcPago() {
		return fcPago;
	}

	/**
	 * Setear fcPago
	 */
	public void setFcPago(Date fcPago) {
		this.fcPago = fcPago;
	}

	/**
	 * Obtener fcValor
	 */
	public Date getFcValor() {
		return fcValor;
	}

	/**
	 * Setear fcValor
	 */
	public void setFcValor(Date fcValor) {
		this.fcValor = fcValor;
	}

	/**
	 * Obtener chTipoPago
	 */
	public String getChTipoPago() {
		return chTipoPago;
	}

	/**
	 * Setear chTipoPago
	 */
	public void setChTipoPago(String chTipoPago) {
		this.chTipoPago = chTipoPago;
	}

	/**
	 * Obtener nuDigitoVerificador
	 */
	public Integer getNuDigitoVerificador() {
		return nuDigitoVerificador;
	}

	/**
	 * Setear nuDigitoVerificador
	 */
	public void setNuDigitoVerificador(Integer nuDigitoVerificador) {
		this.nuDigitoVerificador = nuDigitoVerificador;
	}

	/**
	 * Obtener fcCaducidad
	 */
	public Date getFcCaducidad() {
		return fcCaducidad;
	}

	/**
	 * Setear fcCaducidad
	 */
	public void setFcCaducidad(Date fcCaducidad) {
		this.fcCaducidad = fcCaducidad;
	}

	/**
	 * Obtener cvEstadoLc
	 */
	public String getCvEstadoLc() {
		return cvEstadoLc;
	}

	/**
	 * Setear cvEstadoLc
	 */
	public void setCvEstadoLc(String cvEstadoLc) {
		this.cvEstadoLc = cvEstadoLc;
	}

	/**
	 * Obtener fcIndividualizacion
	 */
	public Date getFcIndividualizacion() {
		return fcIndividualizacion;
	}

	/**
	 * Setear fcIndividualizacion
	 */
	public void setFcIndividualizacion(Date fcIndividualizacion) {
		this.fcIndividualizacion = fcIndividualizacion;
	}

	/**
	 * Obtener fcRecepcion
	 */
	public Date getFcRecepcion() {
		return fcRecepcion;
	}

	/**
	 * Setear fcRecepcion
	 */
	public void setFcRecepcion(Date fcRecepcion) {
		this.fcRecepcion = fcRecepcion;
	}

	/**
	 * Obtener nuMontoPago
	 */
	public BigDecimal getNuMontoPago() {
		return nuMontoPago;
	}

	/**
	 * Setear nuMontoPago
	 */
	public void setNuMontoPago(BigDecimal nuMontoPago) {
		this.nuMontoPago = nuMontoPago;
	}

	/**
	 * Obtener idArchivo
	 */
	public Long getIdArchivo() {
		return idArchivo;
	}

	/**
	 * Setear idArchivo
	 */
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	/**
	 * Obtener cvEntidadRecaudadora
	 */
	public String getCvEntidadRecaudadora() {
		return cvEntidadRecaudadora;
	}

	/**
	 * Setear cvEntidadRecaudadora
	 */
	public void setCvEntidadRecaudadora(String cvEntidadRecaudadora) {
		this.cvEntidadRecaudadora = cvEntidadRecaudadora;
	}

	/**
	 * Obtener nuTrabajadores
	 */
	public Integer getNuTrabajadores() {
		return nuTrabajadores;
	}

	/**
	 * Setear nuTrabajadores
	 */
	public void setNuTrabajadores(Integer nuTrabajadores) {
		this.nuTrabajadores = nuTrabajadores;
	}

	/**
	 * Obtener cvCentroPago
	 */
	public String getCvCentroPago() {
		return cvCentroPago;
	}

	/**
	 * Setear cvCentroPago
	 */
	public void setCvCentroPago(String cvCentroPago) {
		this.cvCentroPago = cvCentroPago;
	}

	/**
	 * Obtener chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * Setear chUsuarioModificador
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * Obtener fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * Setear fcControl
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * Obtener chTipoInversion
	 */
	public String getChTipoInversion() {
		return chTipoInversion;
	}

	/**
	 * Setear chTipoInversion
	 */
	public void setChTipoInversion(String chTipoInversion) {
		this.chTipoInversion = chTipoInversion;
	}

	/**
	 * Obtener idPagoLc
	 */
	public Long getIdPagoLc() {
		return idPagoLc;
	}

	/**
	 * Setear idPagoLc
	 */
	public void setIdPagoLc(Long idPagoLc) {
		this.idPagoLc = idPagoLc;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineaCapturaPago [idLinCapPago=");
		builder.append(idLinCapPago);
		builder.append(", chBimestrePago=");
		builder.append(chBimestrePago);
		builder.append(", chLieaCaptura=");
		builder.append(chLieaCaptura);
		builder.append(", nuTipoLinea=");
		builder.append(nuTipoLinea);
		builder.append(", nuConsecutivoLinea=");
		builder.append(nuConsecutivoLinea);
		builder.append(", fcPago=");
		builder.append(fcPago);
		builder.append(", fcValor=");
		builder.append(fcValor);
		builder.append(", chTipoPago=");
		builder.append(chTipoPago);
		builder.append(", nuDigitoVerificador=");
		builder.append(nuDigitoVerificador);
		builder.append(", fcCaducidad=");
		builder.append(fcCaducidad);
		builder.append(", cvEstadoLc=");
		builder.append(cvEstadoLc);
		builder.append(", fcIndividualizacion=");
		builder.append(fcIndividualizacion);
		builder.append(", fcRecepcion=");
		builder.append(fcRecepcion);
		builder.append(", nuMontoPago=");
		builder.append(nuMontoPago);
		builder.append(", idArchivo=");
		builder.append(idArchivo);
		builder.append(", cvEntidadRecaudadora=");
		builder.append(cvEntidadRecaudadora);
		builder.append(", nuTrabajadores=");
		builder.append(nuTrabajadores);
		builder.append(", cvCentroPago=");
		builder.append(cvCentroPago);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chTipoInversion=");
		builder.append(chTipoInversion);
		builder.append(", idPagoLc=");
		builder.append(idPagoLc);
		builder.append("]");
		return builder.toString();
	}

}
