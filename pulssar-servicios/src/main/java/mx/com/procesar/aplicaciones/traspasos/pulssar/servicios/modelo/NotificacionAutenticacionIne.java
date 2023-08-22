/**
 * NotificacionAutenticacionIne.java
 * Fecha de creación: Jun 29, 2021 2:52:29 PM
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

import javax.persistence.Column;

/**
 * Clase NotificacionAutenticacionIne.java
 *
 * @author dbarbosa
 * @version 1.0
 */
public class NotificacionAutenticacionIne implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -1402528857261649276L;

	/**
	 * Atributo idNotifAutenticacionIne
	 */
	private Long idNotifAutenticacionIne;

	/**
	 * Atributo chUsuario
	 */
	private String chUsuario;

	/**
	 * Atributo chFolio
	 */
	private String chFolio;

	/**
	 * Atributo chAfore
	 */
	private String chAfore;

	/**
	 * Atributo idAutenticacionIne
	 */
	private Long idAutenticacionIne;

	/**
	 * Atributo chCurpTrabajador
	 */
	private String chCurpTrabajador;

	/**
	 * Atributo chTipoSolicitante
	 */
	private String chTipoSolicitante;

	/**
	 * Atributo idUsuarioPulssar
	 */
	private Long idUsuarioPulssar;

	/**
	 * Atributo chDiagnosticoProcesar
	 */
	private String chDiagnosticoProcesar;

	/**
	 * Atributo fcSolicitud
	 */
	private String[] fcSolicitud;

	/**
	 * Atributo nuNotificado
	 */
	private Integer nuNotificado;

	/**
	 * Atributo fcNotificado
	 */
	private String[] fcNotificado;

	/**
	 * Atributo fcControl
	 */
	@Column(name = "FC_CONTROL")
	private String[] fcControl;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Obtener idNotifAutenticacionIne
	 */
	public Long getIdNotifAutenticacionIne() {
		return idNotifAutenticacionIne;
	}

	/**
	 * Setear idNotifAutenticacionIne
	 */
	public void setIdNotifAutenticacionIne(Long idNotifAutenticacionIne) {
		this.idNotifAutenticacionIne = idNotifAutenticacionIne;
	}

	/**
	 * Obtener chUsuario
	 */
	public String getChUsuario() {
		return chUsuario;
	}

	/**
	 * Setear chUsuario
	 */
	public void setChUsuario(String chUsuario) {
		this.chUsuario = chUsuario;
	}

	/**
	 * Obtener chFolio
	 */
	public String getChFolio() {
		return chFolio;
	}

	/**
	 * Setear chFolio
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}

	/**
	 * Obtener chAfore
	 */
	public String getChAfore() {
		return chAfore;
	}

	/**
	 * Setear chAfore
	 */
	public void setChAfore(String chAfore) {
		this.chAfore = chAfore;
	}

	/**
	 * Obtener idAutenticacionIne
	 */
	public Long getIdAutenticacionIne() {
		return idAutenticacionIne;
	}

	/**
	 * Setear idAutenticacionIne
	 */
	public void setIdAutenticacionIne(Long idAutenticacionIne) {
		this.idAutenticacionIne = idAutenticacionIne;
	}

	/**
	 * Obtener chCurpTrabajador
	 */
	public String getChCurpTrabajador() {
		return chCurpTrabajador;
	}

	/**
	 * Setear chCurpTrabajador
	 */
	public void setChCurpTrabajador(String chCurpTrabajador) {
		this.chCurpTrabajador = chCurpTrabajador;
	}

	/**
	 * Obtener chTipoSolicitante
	 */
	public String getChTipoSolicitante() {
		return chTipoSolicitante;
	}

	/**
	 * Setear chTipoSolicitante
	 */
	public void setChTipoSolicitante(String chTipoSolicitante) {
		this.chTipoSolicitante = chTipoSolicitante;
	}

	/**
	 * Obtener idUsuarioPulssar
	 */
	public Long getIdUsuarioPulssar() {
		return idUsuarioPulssar;
	}

	/**
	 * Setear idUsuarioPulssar
	 */
	public void setIdUsuarioPulssar(Long idUsuarioPulssar) {
		this.idUsuarioPulssar = idUsuarioPulssar;
	}

	/**
	 * Obtener chDiagnosticoProcesar
	 */
	public String getChDiagnosticoProcesar() {
		return chDiagnosticoProcesar;
	}

	/**
	 * Setear chDiagnosticoProcesar
	 */
	public void setChDiagnosticoProcesar(String chDiagnosticoProcesar) {
		this.chDiagnosticoProcesar = chDiagnosticoProcesar;
	}

	/**
	 * Obtener fcSolicitud
	 */
	public String[] getFcSolicitud() {
		return fcSolicitud;
	}

	/**
	 * Setear fcSolicitud
	 */
	public void setFcSolicitud(String[] fcSolicitud) {
		this.fcSolicitud = fcSolicitud;
	}

	/**
	 * Obtener nuNotificado
	 */
	public Integer getNuNotificado() {
		return nuNotificado;
	}

	/**
	 * Setear nuNotificado
	 */
	public void setNuNotificado(Integer nuNotificado) {
		this.nuNotificado = nuNotificado;
	}

	/**
	 * Obtener fcNotificado
	 */
	public String[] getFcNotificado() {
		return fcNotificado;
	}

	/**
	 * Setear fcNotificado
	 */
	public void setFcNotificado(String[] fcNotificado) {
		this.fcNotificado = fcNotificado;
	}

	/**
	 * Obtener fcControl
	 */
	public String[] getFcControl() {
		return fcControl;
	}

	/**
	 * Setear fcControl
	 */
	public void setFcControl(String[] fcControl) {
		this.fcControl = fcControl;
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

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionAutenticacionIne [idNotifAutenticacionIne=");
		builder.append(idNotifAutenticacionIne);
		builder.append(", chUsuario=");
		builder.append(chUsuario);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", chAfore=");
		builder.append(chAfore);
		builder.append(", idAutenticacionIne=");
		builder.append(idAutenticacionIne);
		builder.append(", chCurpTrabajador=");
		builder.append(chCurpTrabajador);
		builder.append(", chTipoSolicitante=");
		builder.append(chTipoSolicitante);
		builder.append(", idUsuarioPulssar=");
		builder.append(idUsuarioPulssar);
		builder.append(", chDiagnosticoProcesar=");
		builder.append(chDiagnosticoProcesar);
		builder.append(", fcSolicitud=");
		builder.append(fcSolicitud);
		builder.append(", nuNotificado=");
		builder.append(nuNotificado);
		builder.append(", fcNotificado=");
		builder.append(fcNotificado);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
