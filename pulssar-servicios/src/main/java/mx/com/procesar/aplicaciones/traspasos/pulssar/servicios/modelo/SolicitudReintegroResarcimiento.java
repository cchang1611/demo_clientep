/**
 * SolicitudReintegroResarcimiento.java
 * Fecha de creación: Mar 12, 2020 10:00:08 AM
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
import java.util.List;

/**
 * Clase para manejar la solicitud de reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class SolicitudReintegroResarcimiento implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8937036190824122253L;

	/**
	 * Atributo trabajador
	 */
	private DatosTrabajador trabajador;

	/**
	 * Atributo usuarioLogin
	 */
	private UsuarioLogin usuarioLogin;

	/**
	 * Atributo lstHistoricos
	 */
	private List<RespuestaHistoricoRetiros> lstHistoricos;

	/**
	 * Atributo lstConfirmacion
	 */
	private List<SolicitudReintegroEntrada> lstConfirmacion;

	/**
	 * Calculo de monto reintegrar
	 */
	private RespuestaMontoReintegrar montoReintegrar;

	/**
	 * Solicitud selecionada
	 */
	private String resolucion;

	/**
	 * Atributo noParcialiad
	 */
	private String numeroReintegro;

	/**
	 * Atributo comboNoObligatorios
	 */
	private List<Combo> comboNoObligatorios;

	/**
	 * Atributo comboObligatorios
	 */
	private List<Combo> comboObligatorios;

	/**
	 * Codigo de respuest
	 */
	private RespuestaServicio respuesta;
	
	/**
	 * Semanas por reintegrar
	 */
	private Integer semanasReintegrar;
	
	/**
	 * Monto total a reintegrar
	 */
	private Double montoTotalReintegrar;

	/**
	 * Obtener trabajador
	 */
	public DatosTrabajador getTrabajador() {
		return trabajador;
	}

	/**
	 * Setear trabajador
	 */
	public void setTrabajador(DatosTrabajador trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * Obtener usuarioLogin
	 */
	public UsuarioLogin getUsuarioLogin() {
		return usuarioLogin;
	}

	/**
	 * Setear usuarioLogin
	 */
	public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	/**
	 * Obtener lstHistoricos
	 */
	public List<RespuestaHistoricoRetiros> getLstHistoricos() {
		return lstHistoricos;
	}

	/**
	 * Setear lstHistoricos
	 */
	public void setLstHistoricos(List<RespuestaHistoricoRetiros> lstHistoricos) {
		this.lstHistoricos = lstHistoricos;
	}

	/**
	 * Obtener lstConfirmacion
	 */
	public List<SolicitudReintegroEntrada> getLstConfirmacion() {
		return lstConfirmacion;
	}

	/**
	 * Setear lstConfirmacion
	 */
	public void setLstConfirmacion(List<SolicitudReintegroEntrada> lstConfirmacion) {
		this.lstConfirmacion = lstConfirmacion;
	}

	/**
	 * Obtener montoReintegrar
	 */
	public RespuestaMontoReintegrar getMontoReintegrar() {
		return montoReintegrar;
	}

	/**
	 * Setear montoReintegrar
	 */
	public void setMontoReintegrar(RespuestaMontoReintegrar montoReintegrar) {
		this.montoReintegrar = montoReintegrar;
	}

	/**
	 * Obtener solicitud
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * Setear solicitud
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * Obtener comboNoObligatorios
	 */
	public List<Combo> getComboNoObligatorios() {
		return comboNoObligatorios;
	}

	/**
	 * Setear comboNoObligatorios
	 */
	public void setComboNoObligatorios(List<Combo> comboNoObligatorios) {
		this.comboNoObligatorios = comboNoObligatorios;
	}

	/**
	 * Obtener comboObligatorios
	 */
	public List<Combo> getComboObligatorios() {
		return comboObligatorios;
	}

	/**
	 * Setear comboObligatorios
	 */
	public void setComboObligatorios(List<Combo> comboObligatorios) {
		this.comboObligatorios = comboObligatorios;
	}

	/**
	 * Obtener respuesta
	 */
	public RespuestaServicio getRespuesta() {
		return respuesta;
	}

	/**
	 * Setear respuesta
	 */
	public void setRespuesta(RespuestaServicio respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Obtener numeroReintegro
	 */
	public String getNumeroReintegro() {
		return numeroReintegro;
	}

	/**
	 * Setear numeroReintegro
	 */
	public void setNumeroReintegro(String numeroReintegro) {
		this.numeroReintegro = numeroReintegro;
	}
	
	/**
	 * Obtener semanasReintegrar
	 */
	public Integer getSemanasReintegrar() {
		return semanasReintegrar;
	}

	/**
	 * Setear semanasReintegrar
	 */
	public void setSemanasReintegrar(Integer semanasReintegrar) {
		this.semanasReintegrar = semanasReintegrar;
	}

	/**
	 * Obtener montoTotalReintegrar
	 */
	public Double getMontoTotalReintegrar() {
		return montoTotalReintegrar;
	}

	/**
	 * Setear montoTotalReintegrar
	 */
	public void setMontoTotalReintegrar(Double montoTotalReintegrar) {
		this.montoTotalReintegrar = montoTotalReintegrar;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SolicitudReintegroResarcimiento [trabajador=");
		builder.append(trabajador);
		builder.append(", usuarioLogin=");
		builder.append(usuarioLogin);
		builder.append(", lstHistoricos=");
		builder.append(lstHistoricos);
		builder.append(", lstConfirmacion=");
		builder.append(lstConfirmacion);
		builder.append(", montoReintegrar=");
		builder.append(montoReintegrar);
		builder.append(", resolucion=");
		builder.append(resolucion);
		builder.append(", comboNoObligatorios=");
		builder.append(comboNoObligatorios);
		builder.append(", comboObligatorios=");
		builder.append(comboObligatorios);
		builder.append("]");
		return builder.toString();
	}

}
