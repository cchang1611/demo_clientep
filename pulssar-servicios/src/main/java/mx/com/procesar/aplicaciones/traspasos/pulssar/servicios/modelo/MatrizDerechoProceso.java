/**
 * MatrizDerechoProceso.java
 * Fecha de creación: Aug 12, 2020 11:01:28 PM
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
import java.util.Date;

/**
 * Clase para 
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class MatrizDerechoProceso implements Serializable {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -6559058222186793982L;

	/**
	 * Clave de proceso
	 */
	private String claveProceso;

	/**
	 * Matriz de derecho
	 */
	private Long idMatrizDerecho;

	/**
	 * Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * Obtener claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * Setear claveProceso
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * Obtener idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * Setear idMatrizDerecho
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	/**
	 * Obtener fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * Setear fechaControl
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * Obtener usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * Setear usuarioModificador
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatrizDerechoProceso [claveProceso=");
		builder.append(claveProceso);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
}
