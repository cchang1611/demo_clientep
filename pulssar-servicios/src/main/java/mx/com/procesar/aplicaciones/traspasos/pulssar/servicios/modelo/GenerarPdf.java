/**
 * GenerarPdf.java
 * Fecha de creación: May 25, 2021 3:54:21 PM
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
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class GenerarPdf implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -43103161565385910L;

	/**
	 * Atributo entrada
	 */
	private List<EntradaGenerarPdf> entrada;

	/**
	 * Atributo rutaPdf
	 */
	private String rutaPdf;

	/**
	 * Obtener entrada
	 */
	public List<EntradaGenerarPdf> getEntrada() {
		return entrada;
	}

	/**
	 * Setear entrada
	 */
	public void setEntrada(List<EntradaGenerarPdf> entrada) {
		this.entrada = entrada;
	}

	/**
	 * Obtener rutaPdf
	 */
	public String getRutaPdf() {
		return rutaPdf;
	}

	/**
	 * Setear rutaPdf
	 */
	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
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
		builder.append("GenerarPdf [entrada=");
		builder.append(entrada);
		builder.append(", rutaPdf=");
		builder.append(rutaPdf);
		builder.append("]");
		return builder.toString();
	}
}
