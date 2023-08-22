package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Datos de entrada para la Confirmacion Reintegro Semanas
 * @author ANOSORIO
 *
 */
public class ConfirmacionMontoSalida implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -2532734876154864443L;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * Nombre Completo del trabajador
	 */
	private String nombre;

	/**
	 * Regimen
	 */
	private String regimen;

	/**
	 * Número de resolución
	 */
	private String numeroResolucion;

	/**
	 * Centro Informático
	 */
	private String centroInformatico;

	/**
	 * Clave Afore Retiro
	 */
	private String claveAforeRetiro;

	/**
	 * Importe RCV
	 */
	private BigDecimal importeRCV;

	/**
	 * Fecha de Evento de Retiro
	 */
	private Date fechaEventoRetiro;

	/**
	 * Clave Afore Reintegro
	 */
	private String claveAfore;

	/**
	 * Dias Descontados
	 */
	private int diasDescontados;

	/**
	 * Valor dia a Reintegrar
	 */
	private BigDecimal valorDiaReintegrar;

	/**
	 * Fecha de Pago del Reintegro
	 */
	private Date fechaPagoReintegro;

	/**
	 * Importe en Pesos a Reintegrar
	 */
	private BigDecimal montoReintegro;

	/**
	 * Dias de cotizacion
	 */
	private int diasCotizacionRecuperados;

	/**
	 * Clave del Tipo Prestacion
	 */
	private String tipoPrestacion;

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
	 * Identificador de la Operacion
	 */
	private String identificadorOperacion;

	/**
	 * diagnostico
	 */
	private String diagnostico;

	/**
	 * Número para origen
	 */
	private int origen;
	
	/**
	 * Importe en Pesos a Reintegrar
	 */
	private BigDecimal importePesosReintegrar;

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
	 * @return el atributo regimen
	 */
	public String getRegimen() {
		return regimen;
	}

	/**
	 * @param regimen parametro regimen a actualizar
	 */
	public void setRegimen(String regimen) {
		this.regimen = regimen;
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
	 * @return el atributo centroInformatico
	 */
	public String getCentroInformatico() {
		return centroInformatico;
	}

	/**
	 * @param centroInformatico parametro centroInformatico a actualizar
	 */
	public void setCentroInformatico(String centroInformatico) {
		this.centroInformatico = centroInformatico;
	}

	/**
	 * @return el atributo claveAforeRetiro
	 */
	public String getClaveAforeRetiro() {
		return claveAforeRetiro;
	}

	/**
	 * @param claveAforeRetiro parametro claveAforeRetiro a actualizar
	 */
	public void setClaveAforeRetiro(String claveAforeRetiro) {
		this.claveAforeRetiro = claveAforeRetiro;
	}

	/**
	 * @return el atributo importeRCV
	 */
	public BigDecimal getImporteRCV() {
		return importeRCV;
	}

	/**
	 * @param importeRCV parametro importeRCV a actualizar
	 */
	public void setImporteRCV(BigDecimal importeRCV) {
		this.importeRCV = importeRCV;
	}

	/**
	 * @return el atributo fechaEventoRetiro
	 */
	public Date getFechaEventoRetiro() {
		return fechaEventoRetiro;
	}

	/**
	 * @param fechaEventoRetiro parametro fechaEventoRetiro a actualizar
	 */
	public void setFechaEventoRetiro(Date fechaEventoRetiro) {
		this.fechaEventoRetiro = fechaEventoRetiro;
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
	 * @return el atributo fechaPagoReintegro
	 */
	public Date getFechaPagoReintegro() {
		return fechaPagoReintegro;
	}

	/**
	 * @param fechaPagoReintegro parametro fechaPagoReintegro a actualizar
	 */
	public void setFechaPagoReintegro(Date fechaPagoReintegro) {
		this.fechaPagoReintegro = fechaPagoReintegro;
	}

	/**
	 * @return el atributo montoReintegro
	 */
	public BigDecimal getMontoReintegro() {
		return montoReintegro;
	}

	/**
	 * @param montoReintegro parametro montoReintegro a actualizar
	 */
	public void setMontoReintegro(BigDecimal montoReintegro) {
		this.montoReintegro = montoReintegro;
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
	 * @return el atributo identificadorOperacion
	 */
	public String getIdentificadorOperacion() {
		return identificadorOperacion;
	}

	/**
	 * @param identificadorOperacion parametro identificadorOperacion a actualizar
	 */
	public void setIdentificadorOperacion(String identificadorOperacion) {
		this.identificadorOperacion = identificadorOperacion;
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
	 * @return the importePesosReintegrar
	 */
	public BigDecimal getImportePesosReintegrar() {
		return importePesosReintegrar;
	}

	/**
	 * @param importePesosReintegrar the importePesosReintegrar to set
	 */
	public void setImportePesosReintegrar(BigDecimal importePesosReintegrar) {
		this.importePesosReintegrar = importePesosReintegrar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfirmacionMontoSalida [nss=");
		builder.append(nss);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", regimen=");
		builder.append(regimen);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", centroInformatico=");
		builder.append(centroInformatico);
		builder.append(", claveAforeRetiro=");
		builder.append(claveAforeRetiro);
		builder.append(", importeRCV=");
		builder.append(importeRCV);
		builder.append(", fechaEventoRetiro=");
		builder.append(fechaEventoRetiro);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", diasDescontados=");
		builder.append(diasDescontados);
		builder.append(", valorDiaReintegrar=");
		builder.append(valorDiaReintegrar);
		builder.append(", fechaPagoReintegro=");
		builder.append(fechaPagoReintegro);
		builder.append(", montoReintegro=");
		builder.append(montoReintegro);
		builder.append(", diasCotizacionRecuperados=");
		builder.append(diasCotizacionRecuperados);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", montoMaximoReintegrar=");
		builder.append(montoMaximoReintegrar);
		builder.append(", numeroMaximoSemanas=");
		builder.append(numeroMaximoSemanas);
		builder.append(", numeroSemanasCalculadas=");
		builder.append(numeroSemanasCalculadas);
		builder.append(", identificadorOperacion=");
		builder.append(identificadorOperacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", importePesosReintegrar=");
		builder.append(importePesosReintegrar);
		builder.append("]");
		return builder.toString();
	}

}
