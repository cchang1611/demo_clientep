/**
 * CalidadHuellas.java
 * Fecha de creación: 15/04/2019, 18:03:11
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Mapeo de calidad de huellas
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 15/04/2019
 */
@JsonInclude(Include.NON_EMPTY)
public class CalidadHuellas implements Serializable {
	
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -8563456740280539530L;

	/**
	 * Posicion de dedo
	 */
	private Long posicionDedo;
	
	/**
	 * Calidad de huella
	 */
	@JsonInclude(Include.NON_NULL)
	private Long calidadHuella;
	
	/**
	 * motivo Excepcion
	 */
	@JsonInclude(Include.NON_NULL)
	private String motivoExcepcion;
	
	/**
	 * descripcion motivo Excepcion
	 */
	@JsonInclude(Include.NON_NULL)
	private String descripcionMotivo;
	
	/**
	 * dispositivo toma de huella
	 */
	@JsonInclude(Include.NON_NULL)
	private String dispositivo;
	
	/**
	 * codigo falta dedo
	 */
	@JsonInclude(Include.NON_NULL)
	private String codigoFaltaDedo;
	
	/**
	 * @return el atributo posicionDedo
	 */
	public Long getPosicionDedo() {
		return posicionDedo;
	}

	/**
	 * @param posicionDedo parametro posicionDedo a actualizar
	 */
	public void setPosicionDedo(Long posicionDedo) {
		this.posicionDedo = posicionDedo;
	}

	/**
	 * @return el atributo calidadHuella
	 */
	public Long getCalidadHuella() {
		return calidadHuella;
	}

	/**
	 * @param calidadHuella parametro calidadHuella a actualizar
	 */
	public void setCalidadHuella(Long calidadHuella) {
		this.calidadHuella = calidadHuella;
	}

	/**
	 * @return el atributo motivoExcepcion
	 */
	public String getMotivoExcepcion() {
		return motivoExcepcion;
	}

	/**
	 * @param motivoExcepcion parametro motivoExcepcion a actualizar
	 */
	public void setMotivoExcepcion(String motivoExcepcion) {
		this.motivoExcepcion = motivoExcepcion;
	}

	/**
	 * @return the descripcionMotivo
	 */
	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}

	/**
	 * @param descripcionMotivo the descripcionMotivo to set
	 */
	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	/**
	 * @return the dispositivo
	 */
	public String getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	/**
	 * @return the codigoFaltaDedo
	 */
	public String getCodigoFaltaDedo() {
		return codigoFaltaDedo;
	}

	/**
	 * @param codigoFaltaDedo the codigoFaltaDedo to set
	 */
	public void setCodigoFaltaDedo(String codigoFaltaDedo) {
		this.codigoFaltaDedo = codigoFaltaDedo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalidadHuellas [posicionDedo=");
		builder.append(posicionDedo);
		builder.append(", calidadHuella=");
		builder.append(calidadHuella);
		builder.append(", motivoExcepcion=");
		builder.append(motivoExcepcion);
		builder.append(", descripcionMotivo=");
		builder.append(descripcionMotivo);
		builder.append(", dispositivo=");
		builder.append(dispositivo);
		builder.append(", codigoFaltaDedo=");
		builder.append(codigoFaltaDedo);
		builder.append("]");
		return builder.toString();
	}

	

}
