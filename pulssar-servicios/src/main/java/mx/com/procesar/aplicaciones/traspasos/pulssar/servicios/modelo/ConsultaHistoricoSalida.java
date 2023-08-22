/**
 * ConsultaHistoricoSalida.java
 * Fecha de creación: 08/08/2019, 13:17:08
 *
 * Copyright (c) 2019 Procesar S A de C V. 
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

//import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Objeto de respuesta del servicio de reintegro de semanas
 * @author Carlos Baltazar Ricardo (cbaltaza@procesar.com)
 * @version 1.0
 * @since
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConsultaHistoricoSalida implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7699145939730862062L;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * Clave Afore
	 */
	private String claveAfore;

	/**
	 * Tipo Prestacion
	 */
	private String tipoPrestacion;

	/**
	 * Importe en Pesos a Reintegrar
	 */
	private BigDecimal importePesosReintegrar;

	/**
	 * Número de resolución
	 */
	private String numeroResolucion;

	/**
	 * Nombre Completo del trabajador
	 */
	private String nombre;

	/**
	 * Fecha de Evento de Retiro
	 */
	private String fechaEventoRetiro;

	/**
	 * Dias Descontados
	 */
	private int diasDescontados;

	/**
	 * Valor dia a Reintegrar
	 */
	private BigDecimal valorDiaReintegrar;

	/**
	 * Número Máximo de Semanas
	 */
	private int numeroMaximoSemanas;

	/**
	 * diagnostico
	 */
	private String diagnostico;

	/**
	 * Número para origen
	 */
	private int origen;

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore parametro claveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return el atributo importePesosReintegrar
	 */
	public BigDecimal getImportePesosReintegrar() {
		return importePesosReintegrar;
	}

	/**
	 * @param importePesosReintegrar parametro importePesosReintegrar a actualizar
	 */
	public void setImportePesosReintegrar(BigDecimal importePesosReintegrar) {
		this.importePesosReintegrar = importePesosReintegrar;
	}

	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo fechaEventoRetiro
	 */
	public String getFechaEventoRetiro() {
		return fechaEventoRetiro;
	}

	/**
	 * @param fechaEventoRetiro parametro fechaEventoRetiro a actualizar
	 */
	public void setFechaEventoRetiro(String fechaEventoRetiro) {
		this.fechaEventoRetiro = fechaEventoRetiro;
	}

	/**
	 * @return el atributo diasDescontados
	 */
	public int getDiasDescontados() {
		return diasDescontados;
	}

	/**
	 * @param diasDescontados parametro diasDescontados a actualizar
	 */
	public void setDiasDescontados(int diasDescontados) {
		this.diasDescontados = diasDescontados;
	}

	/**
	 * @return el atributo valorDiaReintegrar
	 */
	public BigDecimal getValorDiaReintegrar() {
		return valorDiaReintegrar;
	}

	/**
	 * @param valorDiaReintegrar parametro valorDiaReintegrar a actualizar
	 */
	public void setValorDiaReintegrar(BigDecimal valorDiaReintegrar) {
		this.valorDiaReintegrar = valorDiaReintegrar;
	}

	/**
	 * @return el atributo numeroMaximoSemanas
	 */
	public int getNumeroMaximoSemanas() {
		return numeroMaximoSemanas;
	}

	/**
	 * @param numeroMaximoSemanas parametro numeroMaximoSemanas a actualizar
	 */
	public void setNumeroMaximoSemanas(int numeroMaximoSemanas) {
		this.numeroMaximoSemanas = numeroMaximoSemanas;
	}

	/**
	 * @return el atributo diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico parametro diagnostico a actualizar
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return el atributo origen
	 */
	public int getOrigen() {
		return origen;
	}

	/**
	 * @param origen parametro origen a actualizar
	 */
	public void setOrigen(int origen) {
		this.origen = origen;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsultaHistoricoSalida [getNss()=");
		builder.append(getNss());
		builder.append(", getClaveAfore()=");
		builder.append(getClaveAfore());
		builder.append(", getTipoPrestacion()=");
		builder.append(getTipoPrestacion());
		builder.append(", getImportePesosReintegrar()=");
		builder.append(getImportePesosReintegrar());
		builder.append(", getNumeroResolucion()=");
		builder.append(getNumeroResolucion());
		builder.append(", getNombre()=");
		builder.append(getNombre());
		builder.append(", getFechaEventoRetiro()=");
		builder.append(getFechaEventoRetiro());
		builder.append(", getDiasDescontados()=");
		builder.append(getDiasDescontados());
		builder.append(", getValorDiaReintegrar()=");
		builder.append(getValorDiaReintegrar());
		builder.append(", getNumeroMaximoSemanas()=");
		builder.append(getNumeroMaximoSemanas());
		builder.append(", getDiagnostico()=");
		builder.append(getDiagnostico());
		builder.append(", getOrigen()=");
		builder.append(getOrigen());
		builder.append("]");
		return builder.toString();
	}

}
