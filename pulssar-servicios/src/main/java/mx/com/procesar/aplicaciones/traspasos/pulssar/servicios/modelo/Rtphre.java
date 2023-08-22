/**
 * Rtphre.java
 * Fecha de creación: Jul 2, 2019, 5:35:52 PM
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
import java.sql.Timestamp;
import java.util.Date;

/**
 * mapeo de la tabla RTPHRE
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jul 2, 2019
 */
public class Rtphre implements Serializable {
	/**
	 * serializado
	 */
	private static final long serialVersionUID = -1640308442759337320L;

	/**
	 * llave primaria de la tabla
	 */
	private RtphrePK id;

	/**
	 * columna C_CIZIMSS
	 */
	private String cizimss;

	/**
	 * Codigo Resultado De La Operacion
	 */
	private String codigoResultado;

	/**
	 * Clave de AFORE
	 */
	private String claveAfore;

	/**
	 * Codigo Del Motivo De Rechazo
	 */
	private String motivoRechazo;

	/**
	 * NSS asociado
	 */
	private String nssAsociado;

	/**
	 * Numero de Resolución entregado por el IMSS
	 */
	private String numeroResolucion;

	/**
	 * Clave Del Programa
	 */
	private String programa;

	/**
	 * Regimen
	 */
	private String regimen;

	/**
	 * tipo de prestacion
	 */
	private String tipoPrestacion;

	/**
	 * Clave De Usuario
	 */
	private String usuario;

	/**
	 * Fecha en que se registra un retiro en el IMSS
	 */
	private Date fechaRetiroImss;

	/**
	 * Dias Descontados Por El Retiro
	 */
	private BigDecimal diasDescontados;

	/**
	 * Estatus De Reintegro
	 */
	private BigDecimal estatusReintegro;

	/**
	 * Saldo De La Cuenta Antes Del Retiro
	 */
	private BigDecimal importeRcv;

	/**
	 * Monto Del Retiro Pagado
	 */
	private BigDecimal montoRetiro;

	/**
	 * Semanas Descontadas Por El Retiro
	 */
	private BigDecimal semanasDescontadas;

	/**
	 * Semanas Recuperadas
	 */
	private BigDecimal semanasRecuperadas;

	/**
	 * Valor De Un Dia De Reintegro Umr
	 */
	private BigDecimal valorDiaReintegro;

	/**
	 * Fecha De Ultima Actualizacion
	 */
	private Timestamp fechaUltimaActualizacion;

	/**
	 * Nombre del Trabajador
	 */
	private String nombreTrabajador;

	/**
	 * @return el atributo id
	 */
	public RtphrePK getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(RtphrePK id) {
		this.id = id;
	}

	/**
	 * @return el atributo cizimss
	 */
	public String getCizimss() {
		return cizimss;
	}

	/**
	 * @param cizimss parametro cizimss a actualizar
	 */
	public void setCizimss(String cizimss) {
		this.cizimss = cizimss;
	}

	/**
	 * @return el atributo codigoResultado
	 */
	public String getCodigoResultado() {
		return codigoResultado;
	}

	/**
	 * @param codigoResultado parametro codigoResultado a actualizar
	 */
	public void setCodigoResultado(String codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	/**
	 * @return el atributo cveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param cveAfore parametro cveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return el atributo motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo parametro motivoRechazo a actualizar
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return el atributo nssAsociado
	 */
	public String getNssAsociado() {
		return nssAsociado;
	}

	/**
	 * @param nssAsociado parametro nssAsociado a actualizar
	 */
	public void setNssAsociado(String nssAsociado) {
		this.nssAsociado = nssAsociado;
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
	 * @return el atributo programa
	 */
	public String getPrograma() {
		return programa;
	}

	/**
	 * @param programa parametro programa a actualizar
	 */
	public void setPrograma(String programa) {
		this.programa = programa;
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
	 * @return el atributo usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario parametro usuario a actualizar
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el atributo fechaRetiroImss
	 */
	public Date getFechaRetiroImss() {
		return fechaRetiroImss;
	}

	/**
	 * @param fechaRetiroImss parametro fechaRetiroImss a actualizar
	 */
	public void setFechaRetiroImss(Date fechaRetiroImss) {
		this.fechaRetiroImss = fechaRetiroImss;
	}

	/**
	 * @return el atributo diasDescontados
	 */
	public BigDecimal getDiasDescontados() {
		return diasDescontados;
	}

	/**
	 * @param diasDescontados parametro diasDescontados a actualizar
	 */
	public void setDiasDescontados(BigDecimal diasDescontados) {
		this.diasDescontados = diasDescontados;
	}

	/**
	 * @return el atributo estatusReintegro
	 */
	public BigDecimal getEstatusReintegro() {
		return estatusReintegro;
	}

	/**
	 * @param estatusReintegro parametro estatusReintegro a actualizar
	 */
	public void setEstatusReintegro(BigDecimal estatusReintegro) {
		this.estatusReintegro = estatusReintegro;
	}

	/**
	 * @return el atributo importeRcv
	 */
	public BigDecimal getImporteRcv() {
		return importeRcv;
	}

	/**
	 * @param importeRcv parametro importeRcv a actualizar
	 */
	public void setImporteRcv(BigDecimal importeRcv) {
		this.importeRcv = importeRcv;
	}

	/**
	 * @return el atributo montoRetiro
	 */
	public BigDecimal getMontoRetiro() {
		return montoRetiro;
	}

	/**
	 * @param montoRetiro parametro montoRetiro a actualizar
	 */
	public void setMontoRetiro(BigDecimal montoRetiro) {
		this.montoRetiro = montoRetiro;
	}

	/**
	 * @return el atributo semanasDescontadas
	 */
	public BigDecimal getSemanasDescontadas() {
		return semanasDescontadas;
	}

	/**
	 * @param semamasDescontadas parametro semamasDescontadas a actualizar
	 */
	public void setSemanasDescontadas(BigDecimal semanasDescontadas) {
		this.semanasDescontadas = semanasDescontadas;
	}

	/**
	 * @return el atributo semanasRecuperadas
	 */
	public BigDecimal getSemanasRecuperadas() {
		return semanasRecuperadas;
	}

	/**
	 * @param semanasRecuperadas parametro semanasRecuperadas a actualizar
	 */
	public void setSemanasRecuperadas(BigDecimal semanasRecuperadas) {
		this.semanasRecuperadas = semanasRecuperadas;
	}

	/**
	 * @return el atributo valorDiaReintegro
	 */
	public BigDecimal getValorDiaReintegro() {
		return valorDiaReintegro;
	}

	/**
	 * @param valorDiaReintegro parametro valorDiaReintegro a actualizar
	 */
	public void setValorDiaReintegro(BigDecimal valorDiaReintegro) {
		this.valorDiaReintegro = valorDiaReintegro;
	}

	/**
	 * @return el atributo fechaUltimaActualizacion
	 */
	public Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	/**
	 * @param fechaUltimaActualizacion parametro fechaUltimaActualizacion a actualizar
	 */
	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	/**
	 * @return el atributo nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador parametro nombreTrabajador a actualizar
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder("Rtphre [");
		cadena.append("id=").append(id);
		cadena.append(", cizimss=").append(cizimss);
		cadena.append(", codigoResultado=").append(codigoResultado);
		cadena.append(", claveAfore=").append(claveAfore);
		cadena.append(", motivoRechazo=").append(motivoRechazo);
		cadena.append(", nssAsociado=").append(nssAsociado);
		cadena.append(", numeroResolucion=").append(numeroResolucion);
		cadena.append(", programa=").append(programa);
		cadena.append(", regimen=").append(regimen);
		cadena.append(", tipoPrestacion=").append(tipoPrestacion);
		cadena.append(", usuario=").append(usuario);
		cadena.append(", fechaRetiroImss=").append(fechaRetiroImss);
		cadena.append(", diasDescontados=").append(diasDescontados);
		cadena.append(", estatusReintegro=").append(estatusReintegro);
		cadena.append(", importeRcv=").append(importeRcv);
		cadena.append(", montoRetiro=").append(montoRetiro);
		cadena.append(", semanasDescontadas=").append(semanasDescontadas);
		cadena.append(", semanasRecuperadas=").append(semanasRecuperadas);
		cadena.append(", valorDiaReintegro=").append(valorDiaReintegro);
		cadena.append(", fechaUltimaActualizacion=").append(fechaUltimaActualizacion);
		cadena.append(", nombreTrabajador=").append(nombreTrabajador);
		cadena.append("]");
		
		return cadena.toString();
	}
	
	
	
}
