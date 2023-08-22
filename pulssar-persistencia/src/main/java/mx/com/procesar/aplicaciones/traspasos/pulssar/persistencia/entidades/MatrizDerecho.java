/**
 * MatrizDerecho.java
 * Fecha de creación: Apr 1, 2019, 4:24:40 PM
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
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * mapeo de la tabla RETI_TR_MATRIZ_DERECHO
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 1, 2019
 */

@Entity
@Table(name = "RETI_TR_MATRIZ_DERECHO")
public class MatrizDerecho implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 8380973277254234924L;

	/**
	 * id
	 */
	@Id
	@Column(name = "ID_MATRIZ_DERECHO")
	private Long id;

	/**
	 * usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * fecha de control
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fechaControl;

	/**
	 * activo
	 */
	@Column(name = "NU_ACTIVO")
	private BigDecimal activo;

	/**
	 * tipo de regimen
	 */
	@Column(name = "CV_TIPO_REGIMEN")
	private String tipoRegimen;

	/**
	 * tipo de pension
	 */
	@Column(name = "CV_TIPO_PENSION")
	private String tipoPension;

	/**
	 * tipo de prestacion
	 */
	@Column(name = "CV_TIPO_PRESTACION")
	private String tipoPrestacion;

	/**
	 * tipo de retiro
	 */
	@Column(name = "CV_TIPO_RETIRO")
	private String tipoRetiro;

	/**
	 * tipo de seguro
	 */
	@Column(name = "CV_TIPO_SEGURO")
	private String tipoSeguro;

	@OneToOne(mappedBy = "matrizDerecho")
	private MatrizDerechoProceso matrizDerechoProceso;

	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo activo
	 */
	public BigDecimal getActivo() {
		return activo;
	}

	/**
	 * @param activo
	 *            parametro activo a actualizar
	 */
	public void setActivo(BigDecimal activo) {
		this.activo = activo;
	}

	/**
	 * @return el atributo tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * @param tipoRegimen
	 *            parametro tipoRegimen a actualizar
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * @return el atributo tipoPension
	 */
	public String getTipoPension() {
		return tipoPension;
	}

	/**
	 * @param tipoPension
	 *            parametro tipoPension a actualizar
	 */
	public void setTipoPension(String tipoPension) {
		this.tipoPension = tipoPension;
	}

	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion
	 *            parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return el atributo tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}

	/**
	 * @param tipoRetiro
	 *            parametro tipoRetiro a actualizar
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}

	/**
	 * @return el atributo tipoSeguro
	 */
	public String getTipoSeguro() {
		return tipoSeguro;
	}

	/**
	 * @param tipoSeguro
	 *            parametro tipoSeguro a actualizar
	 */
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	/**
	 * @return el atributo matrizDerechoProceso
	 */
	public MatrizDerechoProceso getMatrizDerechoProceso() {
		return matrizDerechoProceso;
	}

	/**
	 * @param matrizDerechoProceso
	 *            parametro matrizDerechoProceso a actualizar
	 */
	public void setMatrizDerechoProceso(MatrizDerechoProceso matrizDerechoProceso) {
		this.matrizDerechoProceso = matrizDerechoProceso;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("MatrizDerecho [id=");
		cadena.append(id);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", activo=");
		cadena.append(activo);
		cadena.append(", tipoRegimen=");
		cadena.append(tipoRegimen);
		cadena.append(", tipoPension=");
		cadena.append(tipoPension);
		cadena.append(", tipoPrestacion=");
		cadena.append(tipoPrestacion);
		cadena.append(", tipoRetiro=");
		cadena.append(tipoRetiro);
		cadena.append(", tipoSeguro=");
		cadena.append(tipoSeguro);
		cadena.append("]");

		return cadena.toString();
	}

}
