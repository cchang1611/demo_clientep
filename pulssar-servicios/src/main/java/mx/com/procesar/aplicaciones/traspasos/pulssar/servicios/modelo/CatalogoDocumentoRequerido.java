/**
 * CatalogoDocumentoRequerido.java
 * Fecha de creación: Apr 22, 2020 10:45:55 AM
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
 * Entidad del Catalogo de documentos requeridos
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class CatalogoDocumentoRequerido implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8122298682188442189L;

	/**
	 * Clave de tipo proceso.
	 */

	private String cvTipoProceso;

	/**
	 * Tipo de Documento dihgital.
	 */
	private String cvTipoDocDigital;
	
	/**
	 * Clave de Afore.
	 */
	private String cvAfore;
	
	/**
	 * Consecutivo de documento digital.
	 */
	private String nuConsecutivo;

	/**
	 * Descripción de documento digital.
	 */
	private String chDescDocDigital;

	/**
	 * Obligatorio.
	 */
	private Integer nuObligatorio;

	/**
	 * Fecha de ultima modificación.
	 */
	private Date fcControl;

	/**
	 * Usuario de ultima modificación.
	 */
	private String chUsuarioModificador;
	
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
	 * Obtener nuConsecutivo
	 */
	public String getNuConsecutivo() {
		return nuConsecutivo;
	}

	/**
	 * Setear nuConsecutivo
	 */
	public void setNuConsecutivo(String nuConsecutivo) {
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
		builder.append("CatalogoDocumentoRequerido [cvTipoProceso=");
		builder.append(cvTipoProceso);
		builder.append(", cvTipoDocDigital=");
		builder.append(cvTipoDocDigital);
		builder.append(", chDescDocDigital=");
		builder.append(chDescDocDigital);
		builder.append(", nuObligatorio=");
		builder.append(nuObligatorio);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}
