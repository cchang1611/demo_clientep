/**
 * ComboGenerico.java
 * Fecha de creacion: 04/09/2017
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informacion confidencial, propiedad del
 * Procesar S A de C V. Esta informacion confidencial
 * no deberia ser divulgada y solo se podria utilizar de acuerdo
 * a los terminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase para el manejo de las opciones del Combo en la pantalla
 * 
 * @author dbarbosa
 *
 */
public class Combo implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 2955921497737001803L;
	
	/**
	 * Identificador del combo
	 */
	private Long identificadorCombo;

	/**
	 * Clave del combo
	 */
	private String clave;

	/**
	 * Desripcion del combo
	 */
	private String descripcion;
	
	/**
	 * Desripcion del combo
	 */
	private int bandera;
	
	/**
	 * clave del documento
	 */
	private String claveDocumento;
	
	/**
	 * lista subdocumento
	 */
	private List<Combo> subDocumentos;

	
	/**
	 * @return the identificadorCombo
	 */
	public Long getIdentificadorCombo() {
		return identificadorCombo;
	}

	/**
	 * @param identificadorCombo the identificadorCombo to set
	 */
	public void setIdentificadorCombo(Long identificadorCombo) {
		this.identificadorCombo = identificadorCombo;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the bandera
	 */
	public int getBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(int bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the claveDocumento
	 */
	public String getClaveDocumento() {
		return claveDocumento;
	}

	/**
	 * @param claveDocumento the claveDocumento to set
	 */
	public void setClaveDocumento(String claveDocumento) {
		this.claveDocumento = claveDocumento;
	}

	/**
	 * @return the subDocumentos
	 */
	public List<Combo> getSubDocumentos() {
		return subDocumentos;
	}

	/**
	 * @param subDocumentos the subDocumentos to set
	 */
	public void setSubDocumentos(List<Combo> subDocumentos) {
		this.subDocumentos = subDocumentos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}