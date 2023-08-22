package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Cancelacion salida
 * @author RARREOLA
 *
 */
public class CancelacionSalida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * folioSolicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioSolicitud;
	
	/**
	 * diagnosticoOperacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
     private String	diagnosticoOperacion;
     
    /**
     *  descripcionDiagnostico
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String descripcionDiagnostico;
	
	/**
	 * resultadoOperacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String resultadoOperacion;
	
	
	
	/**
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}



	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}



	/**
	 * @return the diagnosticoOperacion
	 */
	public String getDiagnosticoOperacion() {
		return diagnosticoOperacion;
	}



	/**
	 * @param diagnosticoOperacion the diagnosticoOperacion to set
	 */
	public void setDiagnosticoOperacion(String diagnosticoOperacion) {
		this.diagnosticoOperacion = diagnosticoOperacion;
	}



	/**
	 * @return the descripcionDiagnostico
	 */
	public String getDescripcionDiagnostico() {
		return descripcionDiagnostico;
	}



	/**
	 * @param descripcionDiagnostico the descripcionDiagnostico to set
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



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}


}
