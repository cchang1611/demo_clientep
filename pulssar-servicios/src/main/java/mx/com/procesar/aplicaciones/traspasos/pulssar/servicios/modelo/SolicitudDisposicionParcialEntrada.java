package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Clase que contiene los datos de entrada layout 
 * Solicitud Disposicion Parcial</b>.
 * 
 * @author rarreola
 * @version 1.0
 */
@JsonInclude(value =Include.NON_EMPTY)
public class SolicitudDisposicionParcialEntrada implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -8520036141993091369L;

	/**
	 * folio Rastreo
	 */
	private String 	folioRastreo;
	
	/**
	 * Clave de la Afore.
	 */
	private String 	claveAfore;
	
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 *  Nss
	 */
	private String nss;
	
	/**
	 * Secuencia pension
	 */
	private String secuenciaPension;
	

	/**
	 * Nombre
	 */
	private String nombreTrabajador;
	
	/**
	 * Apellido Paterno
	 */
	private String apellidoPaternoTrabajador ;
	

	/**
	 * Apellido Materno
	 */
	private String apellidoMaternoTrabajador;

	
	/**
	 * Tipo de prestacion
	 */
	private String tipoPrestacion;
	

	/**
 	 * Regimen
 	 */
	private String tipoRegimen;

	/**
 	 * Tipo de retiro
 	 */
	private String tipoRetiro;

	/**
 	 * Numero de concesion 
 	 */
	private String numeroConcesion;

	/**
 	 * Sello trabajo
 	 */
	private String selloTrabajador;
	

	/**
 	 * Curp del agente
 	 */
	private String curpAgente;
		

	/**
 	 * Curp del solicitante
 	 */
	private String curpSolicitante;

	/**
 	 * Tipo de solicitate
 	 */
	private String tipoSolicitante;
	
	

	/**
 	 * Numero Issste
 	 */
	private String numeroIssste;
	
	
	/**
	 * Origen Solicitud
	 */
	private String origenSolicitud;
	
	/**
	 * ID del trámite indicado por la Administradora:
01 Trámite de Cuenta Individual
02 Trámite por Décimo Transitorio
	 */
	private String idTramite;
	/**
	 * @return el atributo folioRastreo
	 */
	public String getFolioRastreo() {
		return folioRastreo;
	}
	/**
	 * @param folioRastreo parametro folioRastreo a actualizar
	 */
	public void setFolioRastreo(String folioRastreo) {
		this.folioRastreo = folioRastreo;
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
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
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
	 * @return el atributo secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}
	/**
	 * @param secuenciaPension parametro secuenciaPension a actualizar
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
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
	/**
	 * @return el atributo apellidoPaternoTrabajador
	 */
	public String getApellidoPaternoTrabajador() {
		return apellidoPaternoTrabajador;
	}
	/**
	 * @param apellidoPaternoTrabajador parametro apellidoPaternoTrabajador a actualizar
	 */
	public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
		this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
	}
	/**
	 * @return el atributo apellidoMaternoTrabajador
	 */
	public String getApellidoMaternoTrabajador() {
		return apellidoMaternoTrabajador;
	}
	/**
	 * @param apellidoMaternoTrabajador parametro apellidoMaternoTrabajador a actualizar
	 */
	public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
		this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
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
	 * @return el atributo tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}
	/**
	 * @param tipoRegimen parametro tipoRegimen a actualizar
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	/**
	 * @return el atributo tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}
	/**
	 * @param tipoRetiro parametro tipoRetiro a actualizar
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}
	/**
	 * @return el atributo numeroConcesion
	 */
	public String getNumeroConcesion() {
		return numeroConcesion;
	}
	/**
	 * @param numeroConcesion parametro numeroConcesion a actualizar
	 */
	public void setNumeroConcesion(String numeroConcesion) {
		this.numeroConcesion = numeroConcesion;
	}
	/**
	 * @return el atributo selloTrabajador
	 */
	public String getSelloTrabajador() {
		return selloTrabajador;
	}
	/**
	 * @param selloTrabajador parametro selloTrabajador a actualizar
	 */
	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}
	/**
	 * @return el atributo curpAgente
	 */
	public String getCurpAgente() {
		return curpAgente;
	}
	/**
	 * @param curpAgente parametro curpAgente a actualizar
	 */
	public void setCurpAgente(String curpAgente) {
		this.curpAgente = curpAgente;
	}
	/**
	 * @return el atributo curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}
	/**
	 * @param curpSolicitante parametro curpSolicitante a actualizar
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}
	/**
	 * @return el atributo tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}
	/**
	 * @param tipoSolicitante parametro tipoSolicitante a actualizar
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}
	/**
	 * @return el atributo numeroIssste
	 */
	public String getNumeroIssste() {
		return numeroIssste;
	}
	/**
	 * @param numeroIssste parametro numeroIssste a actualizar
	 */
	public void setNumeroIssste(String numeroIssste) {
		this.numeroIssste = numeroIssste;
	}
	/**
	 * @return el atributo origenSolicitud
	 */
	public String getOrigenSolicitud() {
		return origenSolicitud;
	}
	/**
	 * @param origenSolicitud parametro origenSolicitud a actualizar
	 */
	public void setOrigenSolicitud(String origenSolicitud) {
		this.origenSolicitud = origenSolicitud;
	}
	/**
	 * @return el atributo idTramite
	 */
	public String getIdTramite() {
		return idTramite;
	}
	/**
	 * @param idTramite parametro idTramite a actualizar
	 */
	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
