package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * @author RARREOLA
 *
 */
public class AccionSieforeImss implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 

	
	/**
	 * Clave siefore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String cveSiefore;
	
	/**
	 * accionesRet97
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesRet97;
	

	/**
	 * accionesCesantiaVejez
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesCV;
	
	 
	  
	
	
	/**
	 * accionesCS
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesCS;
	
	/**
	 * accionesRet92
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double accionesRet92;
	
	
	
	
	

	/**
	 * @return the cveSiefore
	 */
	public String getCveSiefore() {
		return cveSiefore;
	}


	/**
	 * @param cveSiefore the cveSiefore to set
	 */
	public void setCveSiefore(String cveSiefore) {
		this.cveSiefore = cveSiefore;
	}


	/**
	 * @return the accionesRet97
	 */
	public Double getAccionesRet97() {
		return accionesRet97;
	}


	/**
	 * @param accionesRet97 the accionesRet97 to set
	 */
	public void setAccionesRet97(Double accionesRet97) {
		this.accionesRet97 = accionesRet97;
	}


	/**
	 * @return the accionesCV
	 */
	public Double getAccionesCV() {
		return accionesCV;
	}


	/**
	 * @param accionesCV the accionesCV to set
	 */
	public void setAccionesCV(Double accionesCV) {
		this.accionesCV = accionesCV;
	}


	/**
	 * @return the accionesCS
	 */
	public Double getAccionesCS() {
		return accionesCS;
	}


	/**
	 * @param accionesCS the accionesCS to set
	 */
	public void setAccionesCS(Double accionesCS) {
		this.accionesCS = accionesCS;
	}


	/**
	 * @return the accionesRet92
	 */
	public Double getAccionesRet92() {
		return accionesRet92;
	}


	/**
	 * @param accionesRet92 the accionesRet92 to set
	 */
	public void setAccionesRet92(Double accionesRet92) {
		this.accionesRet92 = accionesRet92;
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
