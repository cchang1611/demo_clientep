/**
 * DerechoSubcuentaIssste.java
 * Fecha de creación: Mar 1, 2021 3:11:26 PM
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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Clase DerechoSubcuentaIssste.java
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class DerechoSubcuentaIssste implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -6741138059066423579L;

	/**
	 * Atributo idDerechoSubCuenta
	 */
	private Long idDerechoSubCuenta;

	/**
	 * Atributo idMatrizDerecho
	 */
	private Long idMatrizDerecho;

	/**
	 * Atributo cvSubCuenta
	 */
	private IrecTcSubcuenta cvSubCuenta;

	/**
	 * Atributo chDestinoRecurso
	 */
	private String chDestinoRecurso;

	/**
	 * Atributo cvEstatusVivienda
	 */
	private String cvEstatusVivienda;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Obtener idDerechoSubCuenta
	 */
	public Long getIdDerechoSubCuenta() {
		return idDerechoSubCuenta;
	}

	/**
	 * Setear idDerechoSubCuenta
	 */
	public void setIdDerechoSubCuenta(Long idDerechoSubCuenta) {
		this.idDerechoSubCuenta = idDerechoSubCuenta;
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
	 * Obtener cvSubCuenta
	 */
	public IrecTcSubcuenta getCvSubCuenta() {
		return cvSubCuenta;
	}

	/**
	 * Setear cvSubCuenta
	 */
	public void setCvSubCuenta(IrecTcSubcuenta cvSubCuenta) {
		this.cvSubCuenta = cvSubCuenta;
	}

	/**
	 * Obtener chDestinoRecurso
	 */
	public String getChDestinoRecurso() {
		return chDestinoRecurso;
	}

	/**
	 * Setear chDestinoRecurso
	 */
	public void setChDestinoRecurso(String chDestinoRecurso) {
		this.chDestinoRecurso = chDestinoRecurso;
	}

	/**
	 * Obtener cvEstatusVivienda
	 */
	public String getCvEstatusVivienda() {
		return cvEstatusVivienda;
	}

	/**
	 * Setear cvEstatusVivienda
	 */
	public void setCvEstatusVivienda(String cvEstatusVivienda) {
		this.cvEstatusVivienda = cvEstatusVivienda;
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
	 * Obtener chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * Setear chUsuarioModificador
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
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
		builder.append("DerechoSubCuenta [idDerechoSubCuenta=");
		builder.append(idDerechoSubCuenta);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", cvSubCuenta=");
		builder.append(cvSubCuenta);
		builder.append(", chDestinoRecurso=");
		builder.append(chDestinoRecurso);
		builder.append(", cvEstatusVivienda=");
		builder.append(cvEstatusVivienda);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
