/**
 * Genero.java
 * Fecha de creación: Aug 19, 2020 1:14:34 PM
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
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class Genero implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -6669449704533483838L;

	/**
	 * Atributo claveGenero
	 */
	private String claveGenero;

	/**
	 * Atributo idGenero
	 */
	private String idGenero;

	/**
	 * Atributo descripcionGenero
	 */
	private String descripcionGenero;

	/**
	 * Obtener claveGenero
	 */
	public String getClaveGenero() {
		return claveGenero;
	}

	/**
	 * Setear claveGenero
	 */
	public void setClaveGenero(String claveGenero) {
		this.claveGenero = claveGenero;
	}

	/**
	 * Obtener idGenero
	 */
	public String getIdGenero() {
		return idGenero;
	}

	/**
	 * Setear idGenero
	 */
	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	/**
	 * Obtener descripcionGenero
	 */
	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	/**
	 * Setear descripcionGenero
	 */
	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
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
		builder.append("Genero [claveGenero=");
		builder.append(claveGenero);
		builder.append(", idGenero=");
		builder.append(idGenero);
		builder.append(", descripcionGenero=");
		builder.append(descripcionGenero);
		builder.append("]");
		return builder.toString();
	}
}
