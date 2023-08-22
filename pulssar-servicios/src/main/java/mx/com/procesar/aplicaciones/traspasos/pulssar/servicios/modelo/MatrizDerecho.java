/**
 * MatrizDerecho.java
 * Fecha de creación: Aug 12, 2020 10:59:50 PM
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase para 
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class MatrizDerecho implements Serializable {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -7527452123198154696L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * activo
	 */
	private BigDecimal activo;

	/**
	 * tipo de regimen
	 */
	private String tipoRegimen;

	/**
	 * tipo de pension
	 */
	private String tipoPension;

	/**
	 * tipo de prestacion
	 */
	private String tipoPrestacion;

	/**
	 * tipo de retiro
	 */
	private String tipoRetiro;

	/**
	 * tipo de seguro
	 */
	private String tipoSeguro;

	/**
	 * Atributo matrizDerechoProceso
	 */
	private MatrizDerechoProceso matrizDerechoProceso;

	/**
	 * Obtener id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setear id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Obtener activo
	 */
	public BigDecimal getActivo() {
		return activo;
	}

	/**
	 * Setear activo
	 */
	public void setActivo(BigDecimal activo) {
		this.activo = activo;
	}

	/**
	 * Obtener tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * Setear tipoRegimen
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * Obtener tipoPension
	 */
	public String getTipoPension() {
		return tipoPension;
	}

	/**
	 * Setear tipoPension
	 */
	public void setTipoPension(String tipoPension) {
		this.tipoPension = tipoPension;
	}

	/**
	 * Obtener tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * Setear tipoPrestacion
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * Obtener tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}

	/**
	 * Setear tipoRetiro
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}

	/**
	 * Obtener tipoSeguro
	 */
	public String getTipoSeguro() {
		return tipoSeguro;
	}

	/**
	 * Setear tipoSeguro
	 */
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	/**
	 * Obtener matrizDerechoProceso
	 */
	public MatrizDerechoProceso getMatrizDerechoProceso() {
		return matrizDerechoProceso;
	}

	/**
	 * Setear matrizDerechoProceso
	 */
	public void setMatrizDerechoProceso(MatrizDerechoProceso matrizDerechoProceso) {
		this.matrizDerechoProceso = matrizDerechoProceso;
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
		builder.append("MatrizDerecho [id=");
		builder.append(id);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", tipoRegimen=");
		builder.append(tipoRegimen);
		builder.append(", tipoPension=");
		builder.append(tipoPension);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", tipoRetiro=");
		builder.append(tipoRetiro);
		builder.append(", tipoSeguro=");
		builder.append(tipoSeguro);
		builder.append(", matrizDerechoProceso=");
		builder.append(matrizDerechoProceso);
		builder.append("]");
		return builder.toString();
	}
	
}
