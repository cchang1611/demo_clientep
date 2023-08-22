/**
 * CoordenadasPdf.java
 * Fecha de creación: May 25, 2021 3:56:21 PM
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
 * Clase CoordenadasPdf
 * 
 * (Esquina inferior izquierda) Inicio de una hoja PDF CARTA x -> 0 y -> 0
 * 
 * (Esquia inferior derecha) Fin de una hoja PDF CARTA x -> 400 y -> 0
 * 
 * (Esquia superior derecha) Fin de una hoja PDF CARTA x -> 600 y -> 800
 * 
 * (Esquia superior izquierda) Fin de una hoja PDF CARTA x -> 0 y -> 800
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class CoordenadasPdf implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 2995911919779596570L;

	/**
	 * Eje x
	 */
	private Float x;

	/**
	 * Eje y
	 */
	private Float y;

	/**
	 * @param x
	 * @param y
	 */
	public CoordenadasPdf(Float x, Float y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Obtener x
	 */
	public Float getX() {
		return x;
	}

	/**
	 * Setear x
	 */
	public void setX(Float x) {
		this.x = x;
	}

	/**
	 * Obtener y
	 */
	public Float getY() {
		return y;
	}

	/**
	 * Setear y
	 */
	public void setY(Float y) {
		this.y = y;
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
		builder.append("CoordenasPdf [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
}
