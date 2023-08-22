/**
 * AutenticacionIne.java
 * Fecha de creación: Jun 29, 2021 4:13:39 PM
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
import java.util.Date;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Entidad donde se registra las notificacion de ine
 * @author dbarbosa
 *
 */
public class AutenticacionIne implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 943440855027586683L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * Resultado de la validación INE
	 */
	private String resultadoIne;
	
	/**
	 * CURP del trabajador a consultar
	 */
	private String curpTrabajador;
	
	/**
	 * Tipo de solicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * CURP del solicitante
	 */
	private String curpSolicitante;
	
	/**
	 * valores 0 registro no consultado y 1 registro consultado
	 */
	private Integer nuActivo;
	
	/**
	 * Clave de rechazo de la solicitud
	 */
	private String rechazo;
	
	/**
	 * afore que lo solicito
	 */
	private String cvAfore;
	
	/**
	 * usuario pulssar
	 */
	private Long usuario;
	
	/**
	 * Fecha control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	
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
	 * @return the resultadoIne
	 */
	public String getResultadoIne() {
		return resultadoIne;
	}

	/**
	 * @param resultadoIne the resultadoIne to set
	 */
	public void setResultadoIne(String resultadoIne) {
		this.resultadoIne = resultadoIne;
	}

	/**
	 * @return the curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return the curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return the nuActivo
	 */
	public Integer getNuActivo() {
		return nuActivo;
	}

	/**
	 * @param nuActivo the nuActivo to set
	 */
	public void setNuActivo(Integer nuActivo) {
		this.nuActivo = nuActivo;
	}

	/**
	 * @return the rechazo
	 */
	public String getRechazo() {
		return rechazo;
	}

	/**
	 * @param rechazo the rechazo to set
	 */
	public void setRechazo(String rechazo) {
		this.rechazo = rechazo;
	}

	/**
	 * @return the cvAfore
	 */
	public String getCvAfore() {
		return cvAfore;
	}

	/**
	 * @param cvAfore the cvAfore to set
	 */
	public void setCvAfore(String cvAfore) {
		this.cvAfore = cvAfore;
	}

	/**
	 * @return the usuario
	 */
	public Long getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutenticacionIne [id=");
		builder.append(id);
		builder.append(", resultadoIne=");
		builder.append(resultadoIne);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", rechazo=");
		builder.append(rechazo);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
