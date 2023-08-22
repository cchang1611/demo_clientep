/**
 * FlujoEntradaArchivo.java
 * Fecha de creación: May 14, 2020 1:28:30 PM
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

import java.io.InputStream;
import java.io.Serializable;

/**
 * Clase para controlar los input stream para el zip
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class FlujoEntradaArchivo implements Serializable {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -4989239488478643806L;
	private InputStream flujoEntrada;
	private String nombreArchivo;
	/**
	 * Obtener flujoEntrada
	 */
	public InputStream getFlujoEntrada() {
		return flujoEntrada;
	}
	/**
	 * Setear flujoEntrada
	 */
	public void setFlujoEntrada(InputStream flujoEntrada) {
		this.flujoEntrada = flujoEntrada;
	}
	/**
	 * Obtener nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * Setear nombreArchivo
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlujoEntradaArchivo [flujoEntrada=");
		builder.append(flujoEntrada);
		builder.append(", nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append("]");
		return builder.toString();
	}
}
