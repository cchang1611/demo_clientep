package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author ANOSORIO
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CalculoReintegroSalida implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9146633711796059804L;

	/**
	 * nss
	 */
	private String nss;

	/**
	 *claveAfore 
	 */
	private String claveAfore;
	/**
	 * Número de resolución
	 */
	private String numeroResolucion;

	/**
	 * nombre
	 */
	private String nombre;
	/**
	 * Clave del Tipo Prestacion
	 */
	private String tipoPrestacion;

	/**
	 * Dias Descontados
	 */
	private int diasDescontados;

	/**
	 * Valor dia a Reintegrar
	 */
	private BigDecimal valorDiaReintegrar;

	/**
	 * Importe en Pesos a Reintegrar
	 */
	private BigDecimal importePesosReintegrar;

	/**
	 * Dias de cotizacion
	 */
	private int diasCotizacionRecuperados;

	/**
	 * Monto Máximo a Reintegrar
	 */
	private BigDecimal montoMaximoReintegrar;

	/**
	 * Número Máximo de Semanas
	 */
	private int numeroMaximoSemanas;

	/**
	 * Número de Semanas Calculadas
	 */
	private int numeroSemanasCalculadas;

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
	 * @return el atributo diasCotizacionRecuperados
	 */
	public int getDiasCotizacionRecuperados() {
		return diasCotizacionRecuperados;
	}

	/**
	 * @param diasCotizacionRecuperados parametro diasCotizacionRecuperados a actualizar
	 */
	public void setDiasCotizacionRecuperados(int diasCotizacionRecuperados) {
		this.diasCotizacionRecuperados = diasCotizacionRecuperados;
	}

	/**
	 * @return el atributo montoMaximoReintegrar
	 */
	public BigDecimal getMontoMaximoReintegrar() {
		return montoMaximoReintegrar;
	}

	/**
	 * @param montoMaximoReintegrar parametro montoMaximoReintegrar a actualizar
	 */
	public void setMontoMaximoReintegrar(BigDecimal montoMaximoReintegrar) {
		this.montoMaximoReintegrar = montoMaximoReintegrar;
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
	 * @return el atributo numeroSemanasCalculadas
	 */
	public int getNumeroSemanasCalculadas() {
		return numeroSemanasCalculadas;
	}

	/**
	 * @param numeroSemanasCalculadas parametro numeroSemanasCalculadas a actualizar
	 */
	public void setNumeroSemanasCalculadas(int numeroSemanasCalculadas) {
		this.numeroSemanasCalculadas = numeroSemanasCalculadas;
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

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculoReintegroSalida [nss=");
		builder.append(nss);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", diasDescontados=");
		builder.append(diasDescontados);
		builder.append(", valorDiaReintegrar=");
		builder.append(valorDiaReintegrar);
		builder.append(", importePesosReintegrar=");
		builder.append(importePesosReintegrar);
		builder.append(", diasCotizacionRecuperados=");
		builder.append(diasCotizacionRecuperados);
		builder.append(", montoMaximoReintegrar=");
		builder.append(montoMaximoReintegrar);
		builder.append(", numeroMaximoSemanas=");
		builder.append(numeroMaximoSemanas);
		builder.append(", numeroSemanasCalculadas=");
		builder.append(numeroSemanasCalculadas);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", origen=");
		builder.append(origen);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
