/**
 * SolicitudReintegroEntrada.java
 * Fecha de creación: Mar 27, 2020 12:18:36 PM
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase modelo para la solicitud de reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class SolicitudReintegroEntrada implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 8674797130799745754L;

	/**
	 * Id solicitud
	 */
	private Long idSolicitudReintegro;

	/**
	 * Apellido Materno
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
	 * Estatus reintegro
	 */
	private String estatusReintegro;

	/**
	 * Fecha retiro
	 */
	private Date fechaRetiro;
	
	/**
	 * Fecha retiro
	 */
	@JsonIgnore
	private String fechaRetiroVista;

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
	 * Nss
	 */
	private String nss;

	/**
	 * Numero reintegro
	 */
	private Integer numeroReintegro;

	/**
	 * Numero resolucion
	 */
	private String numeroResolucion;

	/**
	 * Semanas reintegrar
	 */
	private Integer semanasReintegrar;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * Valor del dia a integrar
	 */
	private Double valorIntegrar;
	
	/**
	 * Folio Solicitud reintegro solicitud
	 */
	private String folioTramSolReint;

	/**
	 * Folio Solicitud reintegro confirmacion
	 */
	private String folioTramConfReint;

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
	 * Obtener idSolicitudReintegro
	 */
	public Long getIdSolicitudReintegro() {
		return idSolicitudReintegro;
	}

	/**
	 * Setear idSolicitudReintegro
	 */
	public void setIdSolicitudReintegro(Long idSolicitudReintegro) {
		this.idSolicitudReintegro = idSolicitudReintegro;
	}
	
	/**
	 * Obtener folioTramSolReint
	 */
	public String getFolioTramSolReint() {
		return folioTramSolReint;
	}

	/**
	 * Setear folioTramSolReint
	 */
	public void setFolioTramSolReint(String folioTramSolReint) {
		this.folioTramSolReint = folioTramSolReint;
	}

	/**
	 * Obtener folioTramConfReint
	 */
	public String getFolioTramConfReint() {
		return folioTramConfReint;
	}

	/**
	 * Setear folioTramConfReint
	 */
	public void setFolioTramConfReint(String folioTramConfReint) {
		this.folioTramConfReint = folioTramConfReint;
	}
	
	/**
	 * Obtener fechaRetiroVista
	 */
	public String getFechaRetiroVista() {
		return fechaRetiroVista;
	}

	/**
	 * Setear fechaRetiroVista
	 */
	public void setFechaRetiroVista(String fechaRetiroVista) {
		this.fechaRetiroVista = fechaRetiroVista;
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
		builder.append("SolicitudReintegroEntrada [apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", estatusReintegro=");
		builder.append(estatusReintegro);
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
		builder.append(", numeroReintegro=");
		builder.append(numeroReintegro);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", semanasReintegrar=");
		builder.append(semanasReintegrar);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", valorIntegrar=");
		builder.append(valorIntegrar);
		builder.append("]");
		return builder.toString();
	}
}
