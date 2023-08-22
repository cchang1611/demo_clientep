package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase que contiene los atributos de Entrada del servicio de autenticacion INE
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class DatosAutenticacionIne implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 3619590679223807985L;

	/**
	 * Resultado de la validacion INE
	 */
	private String resultadoValidacionINE;
	
	/**
	 * Curp trabajador consulta
	 */
	private String curpTrabajadorConsultar;
	
	/**
	 * Tipo Solicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * Curp solicitante
	 */
	private String curpSolicitante;
	
	/**
	 * Afore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String cvAfore;
	
	/**
	 * Usuario logueado
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long usuario;

	/**
	 * @return the resultadoValidacionINE
	 */
	public String getResultadoValidacionINE() {
		return resultadoValidacionINE;
	}

	/**
	 * @return the curpTrabajadorConsultar
	 */
	public String getCurpTrabajadorConsultar() {
		return curpTrabajadorConsultar;
	}

	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @return the curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param resultadoValidacionINE the resultadoValidacionINE to set
	 */
	public void setResultadoValidacionINE(String resultadoValidacionINE) {
		this.resultadoValidacionINE = resultadoValidacionINE;
	}

	/**
	 * @param curpTrabajadorConsultar the curpTrabajadorConsultar to set
	 */
	public void setCurpTrabajadorConsultar(String curpTrabajadorConsultar) {
		this.curpTrabajadorConsultar = curpTrabajadorConsultar;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaAutenticacionIne [resultadoValidacionINE=");
		builder.append(resultadoValidacionINE);
		builder.append(", curpTrabajadorConsultar=");
		builder.append(curpTrabajadorConsultar);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append("]");
		return builder.toString();
	}
}

