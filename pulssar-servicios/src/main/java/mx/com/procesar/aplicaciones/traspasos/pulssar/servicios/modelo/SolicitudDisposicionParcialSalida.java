package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Clase que contiene los datos de salida layout 
 * Solicitud Disposicion Parcial
 * 
 * @author rarreola
 * @version 1.0
 */
@JsonInclude(value =Include.NON_EMPTY)
public class SolicitudDisposicionParcialSalida implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -6224987534016027769L;


	/**
	 * Curp
	 */
	private String curp;
	
	
	/**
	 *  Nss
	 */
	private String nss;
	

	/**
	 * Secuencia Pension
	 */
	private String secuenciaPension;
	
	/**
	 * Diagnostico
	 */
	private String claveDiagnostico;
	
	/**
	 * Descripcion de diagnostico
	 */
	private String descripcionDiagnostico;
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;
	
	/**
	 * diagnosticoProcesar
	 */
	 private String diagnosticoProcesar;

	
	/**
	 * constructor default.
	 */
	public SolicitudDisposicionParcialSalida(){
		super();
	}
	
	/**
	 * constructor con parametros
	 */
	
	public SolicitudDisposicionParcialSalida(String curp , String nss, String secuenciaPension){
		super();
		
		this.curp = curp;
		this.nss = nss;
		this.secuenciaPension = secuenciaPension;

	}
	
	
	/**
	 * curp
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}
	
	
	/**
	 * curp
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
	/**
	 * nss
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}
	
	
	/**
	 * nss
	 * @param nss
	 *            the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	
	
	/**
	 * secuenciaPension
	 * @return the secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}
	
	/**
	 * secuenciaPension
	 * @param secuenciaPension
	 *            the secuenciaPension to set
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}
	
	
	/**
	 * claveDiagnostico
	 * @return the claveDiagnostico
	 */
	public String getClaveDiagnostico() {
		return claveDiagnostico;
	}
	
	/**
	 * claveDiagnostico
	 * @param claveDiagnostico
	 *            the claveDiagnostico to set
	 */
	public void setClaveDiagnostico(String claveDiagnostico) {
		this.claveDiagnostico = claveDiagnostico;
	}
	
	
	/**
	 * descripcionDiagnostico
	 * @return the descripcionDiagnostico
	 */
	public String getDescripcionDiagnostico() {
		return descripcionDiagnostico;
	}
	
	
	/**
	 * descripcionDiagnostico
	 * @param descripcionDiagnostico
	 *            the descripcionDiagnostico to set
	 */
	public void setDescripcionDiagnostico(String descripcionDiagnostico) {
		this.descripcionDiagnostico = descripcionDiagnostico;
	}
	
	
	
	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	
	
	
	
	/**
	 * @return the diagnosticoProcesar
	 */
	public String getDiagnosticoProcesar() {
		return diagnosticoProcesar;
	}

	/**
	 * @param diagnosticoProcesar the diagnosticoProcesar to set
	 */
	public void setDiagnosticoProcesar(String diagnosticoProcesar) {
		this.diagnosticoProcesar = diagnosticoProcesar;
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
