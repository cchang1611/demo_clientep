/**
 * MatrimonioLinea.java
 * Fecha de creaci�n: Aug 12, 2020 5:02:35 PM
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
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Clase para
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public class MatrimonioLinea implements Serializable {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 3003552933028141188L;

	/**
	 * Atributo nss
	 */
	private String nss;

	/**
	 * Atributo curp
	 */
	private String curp;

	/**
	 * Atributo folioCliente
	 */
	private String folioCliente;

	/**
	 * Atributo idProcesar
	 */
	private Long idProcesar;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * Obtener nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * Setear nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
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
	 * Obtener folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * Setear folioCliente
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	/**
	 * Obtener idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * Setear idProcesar
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * Obtener fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * Setear fcControl
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
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

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatrimonioLinea [nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
