/**
 * EntradaAutenticacionINE.java
 * Fecha de creación: May 25, 2021 11:21:30 AM
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
 * Clase EntradaAutenticacionINE
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class EntradaAutenticacionIne implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -5771009442872056287L;

	/**
	 * Atributo nombre
	 */
	private String nombre;

	/**
	 * Atributo apellidoPaterno
	 */
	private String apellidoPaterno;

	/**
	 * Atributo apellidoMaterno
	 */
	private String apellidoMaterno;

	/**
	 * Curp del solicitante
	 */
	private String curp;

	/**
	 * Firma del solicitante base64
	 */
	private String firma;

	/**
	 * Atributo avisoPrivacidad
	 */
	private boolean avisoPrivacidad;

	/**
	 * Obtener nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setear nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Setear apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtener apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Setear apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Obtener firma
	 */
	public String getFirma() {
		return firma;
	}

	/**
	 * Setear firma
	 */
	public void setFirma(String firma) {
		this.firma = firma;
	}

	/**
	 * Obtener avisoPrivacidad
	 */
	public boolean getAvisoPrivacidad() {
		return avisoPrivacidad;
	}

	/**
	 * Setear avisoPrivacidad
	 */
	public void setAvisoPrivacidad(boolean avisoPrivacidad) {
		this.avisoPrivacidad = avisoPrivacidad;
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
		builder.append("EntradaAutenticacionIne [nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", firma=");
		builder.append(firma);
		builder.append(", avisoPrivacidad=");
		builder.append(avisoPrivacidad);
		builder.append("]");
		return builder.toString();
	}

}
