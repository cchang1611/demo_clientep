/**
 * NotificacionReintegro.java
 * Fecha de creación: Mar 24, 2020 12:32:44 PM
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
 * Clase modelo para notificacion de reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class NotificacionReintegro implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9012737683021768494L;

	/**
	 * Apellido materno
	 */
	private String apellidoMaterno;

	/**
	 * Apellido paterno
	 */
	private String apellidoPaterno;

	/**
	 * CURP
	 */
	private String curp;

	/**
	 * Descripcion diagnostico
	 */
	private String descripcionDiagnostico;

	/**
	 * Diagnostico recepcion
	 */
	private String diagnosticoRecepcion;

	/**
	 * Estatus reintegro
	 */
	private String estatusReintegro;

	/**
	 * Fecha notificado
	 */
	private Date fechaNotificado;

	/**
	 * Fecha retiro
	 */
	private Date fechaRetiro;

	/**
	 * Fecha solicitud reintegro
	 */
	private Date fechaSolicitudReintegro;

	/**
	 * Mascara archivo
	 */
	private String mascaraArchivo;

	/**
	 * Monto total reintegrar
	 */
	private Double montoTotalReintegrar;

	/**
	 * Nombre
	 */
	private String nombre;

	/**
	 * NSS
	 */
	private String nss;

	/**
	 * Numero notificado
	 */
	private Integer numeroNotificado;

	/**
	 * Numero reintegro
	 */
	private Integer numeroReintegro;

	/**
	 * Numero resolucion
	 */
	private String numeroResolucion;

	/**
	 * Resultado operacion
	 */
	private String resultadoOperacion;

	/**
	 * Semanas reintegrar
	 */
	private Integer semanasReintegrar;

	/**
	 * Valor a integrar
	 */
	private Double valorIntegrar;

	/**
	 * Usuario Modificador
	 */
	private String usuarioModificador;

	/**
	 * Folio trabajador
	 */
	private String folioTramPlataforma;
	
	/**
	 * Obtener apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Setear apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtener apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Setear apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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
	 * Obtener descripcionDiagnostico
	 */
	public String getDescripcionDiagnostico() {
		return descripcionDiagnostico;
	}

	/**
	 * Setear descripcionDiagnostico
	 */
	public void setDescripcionDiagnostico(String descripcionDiagnostico) {
		this.descripcionDiagnostico = descripcionDiagnostico;
	}

	/**
	 * Obtener diagnosticoRecepcion
	 */
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}

	/**
	 * Setear diagnosticoRecepcion
	 */
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
	}

	/**
	 * Obtener estatusReintegro
	 */
	public String getEstatusReintegro() {
		return estatusReintegro;
	}

	/**
	 * Setear estatusReintegro
	 */
	public void setEstatusReintegro(String estatusReintegro) {
		this.estatusReintegro = estatusReintegro;
	}

	/**
	 * Obtener fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * Setear fechaNotificado
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
	}

	/**
	 * Obtener fechaRetiro
	 */
	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	/**
	 * Setear fechaRetiro
	 */
	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	/**
	 * Obtener fechaSolicitudReintegro
	 */
	public Date getFechaSolicitudReintegro() {
		return fechaSolicitudReintegro;
	}

	/**
	 * Setear fechaSolicitudReintegro
	 */
	public void setFechaSolicitudReintegro(Date fechaSolicitudReintegro) {
		this.fechaSolicitudReintegro = fechaSolicitudReintegro;
	}

	/**
	 * Obtener mascaraArchivo
	 */
	public String getMascaraArchivo() {
		return mascaraArchivo;
	}

	/**
	 * Setear mascaraArchivo
	 */
	public void setMascaraArchivo(String mascaraArchivo) {
		this.mascaraArchivo = mascaraArchivo;
	}

	/**
	 * Obtener montoTotalReintegrar
	 */
	public Double getMontoTotalReintegrar() {
		return montoTotalReintegrar;
	}

	/**
	 * Setear montoTotalReintegrar
	 */
	public void setMontoTotalReintegrar(Double montoTotalReintegrar) {
		this.montoTotalReintegrar = montoTotalReintegrar;
	}

	/**
	 * Obtener nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setear nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * Setear nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * Obtener numeroNotificado
	 */
	public Integer getNumeroNotificado() {
		return numeroNotificado;
	}

	/**
	 * Setear numeroNotificado
	 */
	public void setNumeroNotificado(Integer numeroNotificado) {
		this.numeroNotificado = numeroNotificado;
	}

	/**
	 * Obtener numeroReintegro
	 */
	public Integer getNumeroReintegro() {
		return numeroReintegro;
	}

	/**
	 * Setear numeroReintegro
	 */
	public void setNumeroReintegro(Integer numeroReintegro) {
		this.numeroReintegro = numeroReintegro;
	}

	/**
	 * Obtener numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * Setear numeroResolucion
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * Obtener resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * Setear resultadoOperacion
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * Obtener semanasReintegrar
	 */
	public Integer getSemanasReintegrar() {
		return semanasReintegrar;
	}

	/**
	 * Setear semanasReintegrar
	 */
	public void setSemanasReintegrar(Integer semanasReintegrar) {
		this.semanasReintegrar = semanasReintegrar;
	}

	/**
	 * Obtener valorIntegrar
	 */
	public Double getValorIntegrar() {
		return valorIntegrar;
	}

	/**
	 * Setear valorIntegrar
	 */
	public void setValorIntegrar(Double valorIntegrar) {
		this.valorIntegrar = valorIntegrar;
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
	 * Obtener folioTramPlataforma
	 */
	public String getFolioTramPlataforma() {
		return folioTramPlataforma;
	}

	/**
	 * Setear folioTramPlataforma
	 */
	public void setFolioTramPlataforma(String folioTramPlataforma) {
		this.folioTramPlataforma = folioTramPlataforma;
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
		builder.append("NotificacionReintegro [apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", descripcionDiagnostico=");
		builder.append(descripcionDiagnostico);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", estatusReintegro=");
		builder.append(estatusReintegro);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", fechaRetiro=");
		builder.append(fechaRetiro);
		builder.append(", fechaSolicitudReintegro=");
		builder.append(fechaSolicitudReintegro);
		builder.append(", mascaraArchivo=");
		builder.append(mascaraArchivo);
		builder.append(", montoTotalReintegrar=");
		builder.append(montoTotalReintegrar);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", numeroNotificado=");
		builder.append(numeroNotificado);
		builder.append(", numeroReintegro=");
		builder.append(numeroReintegro);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", semanasReintegrar=");
		builder.append(semanasReintegrar);
		builder.append(", valorIntegrar=");
		builder.append(valorIntegrar);
		builder.append("]");
		return builder.toString();
	}
}
