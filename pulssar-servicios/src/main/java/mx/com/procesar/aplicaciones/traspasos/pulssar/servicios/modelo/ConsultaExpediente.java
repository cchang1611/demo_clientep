/**
 * ConsultaExpediente.java
 * Fecha de creación: Jan 11, 2021 3:46:43 PM
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

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class ConsultaExpediente implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -531543522748445605L;

	/**
	 * Atributo afore
	 */
	private String afore;

	/**
	 * Atributo curp
	 */
	private String curp;

	/**
	 * Atributo tipoExpediente
	 */
	private String tipoExpediente;

	/**
	 * Obtener afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * Setear afore
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * Obtener curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * Setear curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * Obtener tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}

	/**
	 * Setear tipoExpediente
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
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
		builder.append("ConsultaExpediente [afore=");
		builder.append(afore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append("]");
		return builder.toString();
	}

}
