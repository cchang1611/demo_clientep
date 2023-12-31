/**
 * ResolucionParcial.java
 * Fecha de creaci�n: Apr 1, 2019, 4:40:22 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * mapeo de la tabla RETI_TR_RESOLUCION_PARCIAL
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 1, 2019
 */
public class ResolucionParcial implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -1278096667586091113L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * consecutivo del proceso parcial
	 */
	private String consecutivoProcesar;

	/**
	 * folio procesar
	 */
	private String folioProcesar;

	/**
	 * numero de resolucion
	 */
	private String numeroResolucion;

	/**
	 * retiro complementario
	 */
	private String retiroComplementario;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * fecha de desempleo
	 */
	private Date fechaDesempleo;

	/**
	 * fecha conclucion de vigencia
	 */
	private Date fechaFinVigencia;

	/**
	 * fecha de matrimonio
	 */
	private Date fechaMatrimonio;

	/**
	 * fecha de notificacion
	 */
	private Date fechaNotificacion;

	/**
	 * fecha de recepcion
	 */
	private Date fechaRecepcion;

	/**
	 * estatus
	 */
	private BigDecimal idEstatus;

	/**
	 * id de procesar
	 */
	private BigDecimal idProcesar;

	/**
	 * total de resoluciones
	 */
	private BigDecimal totalResoluciones;

	/**
	 * afore
	 */
	private Long afore;

	/**
	 * centro informatico
	 */
	private Long centroInformatico;

	/**
	 * diagnostico
	 */
	private Long diagnostico;

	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el atributo consecutivoProcesar
	 */
	public String getConsecutivoProcesar() {
		return consecutivoProcesar;
	}

	/**
	 * @param consecutivoProcesar
	 *            parametro consecutivoProcesar a actualizar
	 */
	public void setConsecutivoProcesar(String consecutivoProcesar) {
		this.consecutivoProcesar = consecutivoProcesar;
	}

	/**
	 * @return el atributo folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar
	 *            parametro folioProcesar a actualizar
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
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
	 * @return el atributo retiroComplementario
	 */
	public String getRetiroComplementario() {
		return retiroComplementario;
	}

	/**
	 * @param retiroComplementario
	 *            parametro retiroComplementario a actualizar
	 */
	public void setRetiroComplementario(String retiroComplementario) {
		this.retiroComplementario = retiroComplementario;
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
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo fechaDesempleo
	 */
	public Date getFechaDesempleo() {
		return fechaDesempleo;
	}

	/**
	 * @param fechaDesempleo
	 *            parametro fechaDesempleo a actualizar
	 */
	public void setFechaDesempleo(Date fechaDesempleo) {
		this.fechaDesempleo = fechaDesempleo;
	}

	/**
	 * @return el atributo fechaFinVigencia
	 */
	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * @param fechaFinVigencia
	 *            parametro fechaFinVigencia a actualizar
	 */
	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * @return el atributo fechaMatrimonio
	 */
	public Date getFechaMatrimonio() {
		return fechaMatrimonio;
	}

	/**
	 * @param fechaMatrimonio
	 *            parametro fechaMatrimonio a actualizar
	 */
	public void setFechaMatrimonio(Date fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
	}

	/**
	 * @return el atributo fechaNotificacion
	 */
	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}

	/**
	 * @param fechaNotificacion
	 *            parametro fechaNotificacion a actualizar
	 */
	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	/**
	 * @return el atributo fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion
	 *            parametro fechaRecepcion a actualizar
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return el atributo idEstatus
	 */
	public BigDecimal getIdEstatus() {
		return idEstatus;
	}

	/**
	 * @param idEstatus
	 *            parametro idEstatus a actualizar
	 */
	public void setIdEstatus(BigDecimal idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * @return el atributo idProcesar
	 */
	public BigDecimal getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar
	 *            parametro idProcesar a actualizar
	 */
	public void setIdProcesar(BigDecimal idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return el atributo totalResoluciones
	 */
	public BigDecimal getTotalResoluciones() {
		return totalResoluciones;
	}

	/**
	 * @param totalResoluciones
	 *            parametro totalResoluciones a actualizar
	 */
	public void setTotalResoluciones(BigDecimal totalResoluciones) {
		this.totalResoluciones = totalResoluciones;
	}

	/**
	 * @return el atributo afore
	 */
	public Long getAfore() {
		return afore;
	}

	/**
	 * @param afore
	 *            parametro afore a actualizar
	 */
	public void setAfore(Long afore) {
		this.afore = afore;
	}

	/**
	 * @return el atributo centroInformatico
	 */
	public Long getCentroInformatico() {
		return centroInformatico;
	}

	/**
	 * @param centroInformatico
	 *            parametro centroInformatico a actualizar
	 */
	public void setCentroInformatico(Long centroInformatico) {
		this.centroInformatico = centroInformatico;
	}

	/**
	 * @return el atributo diagnostico
	 */
	public Long getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico
	 *            parametro diagnostico a actualizar
	 */
	public void setDiagnostico(Long diagnostico) {
		this.diagnostico = diagnostico;
	}
	/*
	 * La documentaci�n de este m�todo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("ResolucionParcial [id=");
		cadena.append(id);
		cadena.append(", consecutivoProcesar=");
		cadena.append(consecutivoProcesar);
		cadena.append(", folioProcesar=");
		cadena.append(folioProcesar);
		cadena.append(", numeroResolucion=");
		cadena.append(numeroResolucion);
		cadena.append(", retiroComplementario=");
		cadena.append(retiroComplementario);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", fechaDesempleo=");
		cadena.append(fechaDesempleo);
		cadena.append(", fechaFinVigencia=");
		cadena.append(fechaFinVigencia);
		cadena.append(", fechaMatrimonio=");
		cadena.append(fechaMatrimonio);
		cadena.append(", fechaNotificacion=");
		cadena.append(fechaNotificacion);
		cadena.append(", fechaRecepcion=");
		cadena.append(fechaRecepcion);
		cadena.append(", idEstatus=");
		cadena.append(idEstatus);
		cadena.append(", idProcesar=");
		cadena.append(idProcesar);
		cadena.append(", totalResoluciones=");
		cadena.append(totalResoluciones);
		cadena.append(", afore=");
		cadena.append(afore);
		cadena.append(", centroInformatico=");
		cadena.append(centroInformatico);
		cadena.append(", diagnostico=");
		cadena.append(diagnostico);
		cadena.append("]");

		return cadena.toString();
	}

}
