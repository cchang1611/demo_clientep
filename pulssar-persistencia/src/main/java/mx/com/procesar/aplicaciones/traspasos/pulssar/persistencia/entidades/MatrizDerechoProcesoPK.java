/**
 * MatrizDerechoProcesoPK.java
 * Fecha de creación: 10/04/2019, 18:09:37
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * PK matriz de derecho proceso
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 10/04/2019
 */
@Embeddable
public class MatrizDerechoProcesoPK implements Serializable {

	/**
	 * Id serial
	 */
	private static final long serialVersionUID = 3674299342907653847L;

	/**
	 * Clave del proceso
	 */
	private String claveProceso;

	/**
	 * id matriz de derecho
	 */
	private Long idMatrizDerecho;

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso
	 *            parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return el atributo idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho
	 *            parametro idMatrizDerecho a actualizar
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatrizDerechoProcesoPK [claveProceso=");
		builder.append(claveProceso);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append("]");
		return builder.toString();
	}
}
