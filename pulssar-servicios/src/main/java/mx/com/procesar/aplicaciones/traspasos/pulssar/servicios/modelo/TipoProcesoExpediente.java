/**
 * TipoProcesoExpediente.java
 * Fecha de creaci�n: Feb 15, 2021 3:24:02 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase para
 *
 * @author Williams Alejandro Mart�nez (walejand)
 * @version 1.0
 */
public class TipoProcesoExpediente implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 6272969826863496285L;

	/**
	 * Atributo claveTipoProceso
	 */
	private String claveTipoProceso;

	/**
	 * descripcionTipoProceso
	 */
	private String descripcionTipoProceso;

	/**
	 * modoBatch
	 */
	private Long modoBatch;

	/**
	 * grupoTipoProceso
	 */
	private String grupoTipoProceso;

	/**
	 * Obtener claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}

	/**
	 * Setear claveTipoProceso
	 */
	public void setClaveTipoProceso(String claveTipoProceso) {
		this.claveTipoProceso = claveTipoProceso;
	}

	/**
	 * Obtener descripcionTipoProceso
	 */
	public String getDescripcionTipoProceso() {
		return descripcionTipoProceso;
	}

	/**
	 * Setear descripcionTipoProceso
	 */
	public void setDescripcionTipoProceso(String descripcionTipoProceso) {
		this.descripcionTipoProceso = descripcionTipoProceso;
	}

	/**
	 * Obtener modoBatch
	 */
	public Long getModoBatch() {
		return modoBatch;
	}

	/**
	 * Setear modoBatch
	 */
	public void setModoBatch(Long modoBatch) {
		this.modoBatch = modoBatch;
	}

	/**
	 * Obtener grupoTipoProceso
	 */
	public String getGrupoTipoProceso() {
		return grupoTipoProceso;
	}

	/**
	 * Setear grupoTipoProceso
	 */
	public void setGrupoTipoProceso(String grupoTipoProceso) {
		this.grupoTipoProceso = grupoTipoProceso;
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
		builder.append("TipoProcesoExpediente [claveTipoProceso=");
		builder.append(claveTipoProceso);
		builder.append(", descripcionTipoProceso=");
		builder.append(descripcionTipoProceso);
		builder.append(", modoBatch=");
		builder.append(modoBatch);
		builder.append(", grupoTipoProceso=");
		builder.append(grupoTipoProceso);
		builder.append("]");
		return builder.toString();
	}

}
