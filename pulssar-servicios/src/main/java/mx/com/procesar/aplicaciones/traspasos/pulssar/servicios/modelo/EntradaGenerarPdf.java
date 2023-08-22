/**
 * EntradaGenerarPdf.java
 * Fecha de creación: May 25, 2021 3:55:06 PM
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

import com.lowagie.text.Element;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenerarPdfTipoEntradaEnum;

/**
 * Clase EntradaGenerarPdf
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class EntradaGenerarPdf implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -8936865379997386286L;

	/**
	 * Atributo generarPdfTipoEntrada
	 */
	private GenerarPdfTipoEntradaEnum generarPdfTipoEntrada;

	/**
	 * Atributo width para el tipo GenerarPdfTipoEntradaEnum.IMAGEN
	 */
	private Float width;

	/**
	 * Atributo height para el tipo GenerarPdfTipoEntradaEnum.IMAGEN
	 */
	private Float height;

	/**
	 * Valor a insertar
	 */
	private String valor;

	/**
	 * Coordenadas
	 */
	private CoordenadasPdf coordenadas;

	/**
	 * alineacion basedo al objecto Element
	 */
	private Integer elemento;

	
	
	/**
	 * @param valor
	 * @param coordenadas
	 */
	public EntradaGenerarPdf(String valor, CoordenadasPdf coordenadas) {
		super();
		this.elemento = Element.ALIGN_LEFT;
		this.valor = valor;
		this.coordenadas = coordenadas;
	}

	/**
	 * @param valor
	 * @param coordenadas
	 */
	public EntradaGenerarPdf(Integer elemento, String valor, CoordenadasPdf coordenadas) {
		super();
		this.elemento = elemento;
		this.valor = valor;
		this.coordenadas = coordenadas;
	}

	/**
	 * @param valor
	 * @param coordenadas
	 */
	public EntradaGenerarPdf() {
		super();
	}

	/**
	 * Obtener valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setear valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtener coordenadas
	 */
	public CoordenadasPdf getCoordenadas() {
		return coordenadas;
	}

	/**
	 * Setear coordenadas
	 */
	public void setCoordenadas(CoordenadasPdf coordenadas) {
		this.coordenadas = coordenadas;
	}

	/**
	 * Obtener elemento
	 */
	public Integer getElemento() {
		return elemento;
	}

	/**
	 * Setear elemento
	 */
	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}

	/**
	 * Obtener generarPdfTipoEntrada
	 */
	public GenerarPdfTipoEntradaEnum getGenerarPdfTipoEntrada() {
		return generarPdfTipoEntrada;
	}

	/**
	 * Setear generarPdfTipoEntrada
	 */
	public void setGenerarPdfTipoEntrada(GenerarPdfTipoEntradaEnum generarPdfTipoEntrada) {
		this.generarPdfTipoEntrada = generarPdfTipoEntrada;
	}

	/**
	 * Obtener width
	 */
	public Float getWidth() {
		return width;
	}

	/**
	 * Setear width
	 */
	public void setWidth(Float width) {
		this.width = width;
	}

	/**
	 * Obtener height
	 */
	public Float getHeight() {
		return height;
	}

	/**
	 * Setear height
	 */
	public void setHeight(Float height) {
		this.height = height;
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
		builder.append("EntradaGenerarPdf [generarPdfTipoEntrada=");
		builder.append(generarPdfTipoEntrada);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", coordenadas=");
		builder.append(coordenadas);
		builder.append(", elemento=");
		builder.append(elemento);
		builder.append("]");
		return builder.toString();
	}

}
