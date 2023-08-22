/**
 * AportacionIssste.java
 * Fecha de creación: Mar 16, 2021 7:29:02 PM
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

import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Clase AportacionIssste.java
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class AportacionIssste implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -5742069714821786904L;

	/**
	 * Atributo idAportacion
	 */
	private Long idAportacion;

	/**
	 * Atributo idFactura
	 */
	private Long idFactura;

	/**
	 * Atributo cvAfore
	 */
	@Column(name = "CV_AFORE")
	private String cvAfore;

	/**
	 * Atributo idProcesarTrabajador
	 */
	@Column(name = "ID_PROCESAR_TRABAJADOR")
	private Long idProcesarTrabajador;

	/**
	 * Atributo fcConfirmacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcConfirmacion;

	/**
	 * Atributo fcDispension
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcDispension;

	/**
	 * Atributo cvTipoAportacion
	 */
	@Column(name = "CV_TIPO_APORTACION")
	private String cvTipoAportacion;

	/**
	 * Atributo cvEstadoAportacion
	 */
	@Column(name = "CV_ESTADO_APORTACION")
	private String cvEstadoAportacion;

	/**
	 * Atributo nuIndicadorBono
	 */
	@Column(name = "NU_INDICADOR_BONO")
	private Integer nuIndicadorBono;

	/**
	 * Atributo chUsuarioModificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo nuEstadoCalculoCs
	 */
	@Column(name = "NU_ESTADO_CALCULO_CS")
	private Integer nuEstadoCalculoCs;

	/**
	 * Atributo nuIndicadorTa
	 */
	@Column(name = "NU_INDICADOR_TA")
	private Integer nuIndicadorTa;

	/**
	 * Atributo fcLiquidacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcLiquidacion;

	/**
	 * Atributo cvModalidadDependencia
	 */
	@Column(name = "CV_MODALIDAD_DEPENDENCIA")
	private String cvModalidadDependencia;

	/**
	 * Atributo nuConregLote
	 */
	@Column(name = "NU_CONREG_LOTE")
	private Integer nuConregLote;

	/**
	 * Atributo chApellidoPaterno
	 */
	@Column(name = "CH_APELLIDO_PATERNO")
	private String chApellidoPaterno;

	/**
	 * Atributo chApellidoMaterno
	 */
	@Column(name = "CH_APELLIDO_MATERNO")
	private String chApellidoMaterno;

	/**
	 * Atributo chNombre
	 */
	@Column(name = "CH_NOMBRE")
	private String chNombre;

	/**
	 * Atributo fcNacimiento
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcNacimiento;

	/**
	 * Atributo chSexo
	 */
	private String chSexo;

	/**
	 * Atributo chEntidadFederativa
	 */
	private String chEntidadFederativa;

	/**
	 * Atributo curp
	 */
	private String curp;

	/**
	 * Atributo nssImss
	 */
	private String nssImss;

	/**
	 * Obtener idAportacion
	 */
	public Long getIdAportacion() {
		return idAportacion;
	}

	/**
	 * Setear idAportacion
	 */
	public void setIdAportacion(Long idAportacion) {
		this.idAportacion = idAportacion;
	}

	/**
	 * Obtener idFactura
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * Setear idFactura
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
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
	 * Obtener idProcesarTrabajador
	 */
	public Long getIdProcesarTrabajador() {
		return idProcesarTrabajador;
	}

	/**
	 * Setear idProcesarTrabajador
	 */
	public void setIdProcesarTrabajador(Long idProcesarTrabajador) {
		this.idProcesarTrabajador = idProcesarTrabajador;
	}

	

	/**
	 * Obtener cvTipoAportacion
	 */
	public String getCvTipoAportacion() {
		return cvTipoAportacion;
	}

	/**
	 * Setear cvTipoAportacion
	 */
	public void setCvTipoAportacion(String cvTipoAportacion) {
		this.cvTipoAportacion = cvTipoAportacion;
	}

	/**
	 * Obtener cvEstadoAportacion
	 */
	public String getCvEstadoAportacion() {
		return cvEstadoAportacion;
	}

	/**
	 * Setear cvEstadoAportacion
	 */
	public void setCvEstadoAportacion(String cvEstadoAportacion) {
		this.cvEstadoAportacion = cvEstadoAportacion;
	}

	/**
	 * Obtener nuIndicadorBono
	 */
	public Integer getNuIndicadorBono() {
		return nuIndicadorBono;
	}

	/**
	 * Setear nuIndicadorBono
	 */
	public void setNuIndicadorBono(Integer nuIndicadorBono) {
		this.nuIndicadorBono = nuIndicadorBono;
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
	 * Obtener nuEstadoCalculoCs
	 */
	public Integer getNuEstadoCalculoCs() {
		return nuEstadoCalculoCs;
	}

	/**
	 * Setear nuEstadoCalculoCs
	 */
	public void setNuEstadoCalculoCs(Integer nuEstadoCalculoCs) {
		this.nuEstadoCalculoCs = nuEstadoCalculoCs;
	}

	/**
	 * Obtener nuIndicadorTa
	 */
	public Integer getNuIndicadorTa() {
		return nuIndicadorTa;
	}

	/**
	 * Setear nuIndicadorTa
	 */
	public void setNuIndicadorTa(Integer nuIndicadorTa) {
		this.nuIndicadorTa = nuIndicadorTa;
	}

	

	/**
	 * Obtener cvModalidadDependencia
	 */
	public String getCvModalidadDependencia() {
		return cvModalidadDependencia;
	}

	/**
	 * Setear cvModalidadDependencia
	 */
	public void setCvModalidadDependencia(String cvModalidadDependencia) {
		this.cvModalidadDependencia = cvModalidadDependencia;
	}

	/**
	 * Obtener nuConregLote
	 */
	public Integer getNuConregLote() {
		return nuConregLote;
	}

	/**
	 * Setear nuConregLote
	 */
	public void setNuConregLote(Integer nuConregLote) {
		this.nuConregLote = nuConregLote;
	}

	/**
	 * Obtener chApellidoPaterno
	 */
	public String getChApellidoPaterno() {
		return chApellidoPaterno;
	}

	/**
	 * Setear chApellidoPaterno
	 */
	public void setChApellidoPaterno(String chApellidoPaterno) {
		this.chApellidoPaterno = chApellidoPaterno;
	}

	/**
	 * Obtener chApellidoMaterno
	 */
	public String getChApellidoMaterno() {
		return chApellidoMaterno;
	}

	/**
	 * Setear chApellidoMaterno
	 */
	public void setChApellidoMaterno(String chApellidoMaterno) {
		this.chApellidoMaterno = chApellidoMaterno;
	}

	/**
	 * Obtener chNombre
	 */
	public String getChNombre() {
		return chNombre;
	}

	/**
	 * Setear chNombre
	 */
	public void setChNombre(String chNombre) {
		this.chNombre = chNombre;
	}

	

	/**
	 * @return the fcConfirmacion
	 */
	public Date getFcConfirmacion() {
		return fcConfirmacion;
	}

	/**
	 * @param fcConfirmacion the fcConfirmacion to set
	 */
	public void setFcConfirmacion(Date fcConfirmacion) {
		this.fcConfirmacion = fcConfirmacion;
	}

	/**
	 * @return the fcDispension
	 */
	public Date getFcDispension() {
		return fcDispension;
	}

	/**
	 * @param fcDispension the fcDispension to set
	 */
	public void setFcDispension(Date fcDispension) {
		this.fcDispension = fcDispension;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return the fcLiquidacion
	 */
	public Date getFcLiquidacion() {
		return fcLiquidacion;
	}

	/**
	 * @param fcLiquidacion the fcLiquidacion to set
	 */
	public void setFcLiquidacion(Date fcLiquidacion) {
		this.fcLiquidacion = fcLiquidacion;
	}

	/**
	 * @return the fcNacimiento
	 */
	public Date getFcNacimiento() {
		return fcNacimiento;
	}

	/**
	 * @param fcNacimiento the fcNacimiento to set
	 */
	public void setFcNacimiento(Date fcNacimiento) {
		this.fcNacimiento = fcNacimiento;
	}

	/**
	 * Obtener chSexo
	 */
	public String getChSexo() {
		return chSexo;
	}

	/**
	 * Setear chSexo
	 */
	public void setChSexo(String chSexo) {
		this.chSexo = chSexo;
	}

	/**
	 * Obtener chEntidadFederativa
	 */
	public String getChEntidadFederativa() {
		return chEntidadFederativa;
	}

	/**
	 * Setear chEntidadFederativa
	 */
	public void setChEntidadFederativa(String chEntidadFederativa) {
		this.chEntidadFederativa = chEntidadFederativa;
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
	 * Obtener nssImss
	 */
	public String getNssImss() {
		return nssImss;
	}

	/**
	 * Setear nssImss
	 */
	public void setNssImss(String nssImss) {
		this.nssImss = nssImss;
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
		builder.append("Aportacion [idAportacion=");
		builder.append(idAportacion);
		builder.append(", idFactura=");
		builder.append(idFactura);
		builder.append(", cvAfore=");
		builder.append(cvAfore);
		builder.append(", idProcesarTrabajador=");
		builder.append(idProcesarTrabajador);
		builder.append(", fcConfirmacion=");
		builder.append(fcConfirmacion);
		builder.append(", fcDispension=");
		builder.append(fcDispension);
		builder.append(", cvTipoAportacion=");
		builder.append(cvTipoAportacion);
		builder.append(", cvEstadoAportacion=");
		builder.append(cvEstadoAportacion);
		builder.append(", nuIndicadorBono=");
		builder.append(nuIndicadorBono);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", nuEstadoCalculoCs=");
		builder.append(nuEstadoCalculoCs);
		builder.append(", nuIndicadorTa=");
		builder.append(nuIndicadorTa);
		builder.append(", fcLiquidacion=");
		builder.append(fcLiquidacion);
		builder.append(", cvModalidadDependencia=");
		builder.append(cvModalidadDependencia);
		builder.append(", nuConregLote=");
		builder.append(nuConregLote);
		builder.append(", chApellidoPaterno=");
		builder.append(chApellidoPaterno);
		builder.append(", chApellidoMaterno=");
		builder.append(chApellidoMaterno);
		builder.append(", chNombre=");
		builder.append(chNombre);
		builder.append(", fcNacimiento=");
		builder.append(fcNacimiento);
		builder.append(", chSexo=");
		builder.append(chSexo);
		builder.append(", chEntidadFederativa=");
		builder.append(chEntidadFederativa);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nssImss=");
		builder.append(nssImss);
		builder.append("]");
		return builder.toString();
	}

}
