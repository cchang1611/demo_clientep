/**
 * DocumentosRequerido.java
 * Fecha de creación: Apr 22, 2020 3:32:11 PM
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
 * Clase modelo para el servicio documentos requeridos
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class DocumentosRequerido implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -7475260417812162702L;

	/**
	 * Atributo chDescDocDigital
	 */
	private String chDescDocDigital;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Atributo cvAfore
	 */
	private String cvAfore;

	/**
	 * Atributo cvTipoDocDigital
	 */
	private String cvTipoDocDigital;

	/**
	 * Atributo cvTipoProceso
	 */
	private String cvTipoProceso;

	/**
	 * Atributo fcControl
	 */
	private Date fcControl;

	/**
	 * Atributo nuObligatorio
	 */
	private Integer nuObligatorio;

	/**
	 * Consecutivo de documento digital.
	 */
	private Integer nuConsecutivo;

	/**
	 * Obtener chDescDocDigital
	 */
	public String getChDescDocDigital() {
		return chDescDocDigital;
	}

	/**
	 * Setear chDescDocDigital
	 */
	public void setChDescDocDigital(String chDescDocDigital) {
		this.chDescDocDigital = chDescDocDigital;
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
	 * Obtener cvAfore
	 */
	public String getCvAfore() {
		return cvAfore;
	}

	/**
	 * Setear cvAfore
	 */
	public void setCvAfore(String cvAfore) {
		this.cvAfore = cvAfore;
	}

	/**
	 * Obtener cvTipoDocDigital
	 */
	public String getCvTipoDocDigital() {
		return cvTipoDocDigital;
	}

	/**
	 * Setear cvTipoDocDigital
	 */
	public void setCvTipoDocDigital(String cvTipoDocDigital) {
		this.cvTipoDocDigital = cvTipoDocDigital;
	}

	/**
	 * Obtener cvTipoProceso
	 */
	public String getCvTipoProceso() {
		return cvTipoProceso;
	}

	/**
	 * Setear cvTipoProceso
	 */
	public void setCvTipoProceso(String cvTipoProceso) {
		this.cvTipoProceso = cvTipoProceso;
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
	 * Obtener nuObligatorio
	 */
	public Integer getNuObligatorio() {
		return nuObligatorio;
	}

	/**
	 * Setear nuObligatorio
	 */
	public void setNuObligatorio(Integer nuObligatorio) {
		this.nuObligatorio = nuObligatorio;
	}

	/**
	 * Obtener nuConsecutivo
	 */
	public Integer getNuConsecutivo() {
		return nuConsecutivo;
	}

	/**
	 * Setear nuConsecutivo
	 */
	public void setNuConsecutivo(Integer nuConsecutivo) {
		this.nuConsecutivo = nuConsecutivo;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentosRequerido [chDescDocDigital=");
		builder.append(chDescDocDigital);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", cvTipoDocDigital=");
		builder.append(cvTipoDocDigital);
		builder.append(", cvTipoProceso=");
		builder.append(cvTipoProceso);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", nuObligatorio=");
		builder.append(nuObligatorio);
		builder.append("]");
		return builder.toString();
	}
}
