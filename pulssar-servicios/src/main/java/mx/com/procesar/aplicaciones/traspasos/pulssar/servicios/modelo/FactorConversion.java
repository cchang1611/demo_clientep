package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * MAtriz derecho proceso
 * @author RARREOLA
 *
 */

public class FactorConversion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * idTipoProceso
	 */
	private String cvTipoFactor;
	
	/**
	 * cvEstatusVivienda
	 */
	private Date fechaValorFactor;
	
	/**
	 * nu valor factor
	 */
	private Double nuValorFactor;
	
	/**
	 * fechaControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
		
	/**
	 * usuarioModificacion
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificacion;
	

	



	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}






	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}






	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}






	



	/**
	 * @return the cvTipoFactor
	 */
	public String getCvTipoFactor() {
		return cvTipoFactor;
	}






	/**
	 * @param cvTipoFactor the cvTipoFactor to set
	 */
	public void setCvTipoFactor(String cvTipoFactor) {
		this.cvTipoFactor = cvTipoFactor;
	}






	/**
	 * @return the fechaValorFactor
	 */
	public Date getFechaValorFactor() {
		return fechaValorFactor;
	}






	/**
	 * @param fechaValorFactor the fechaValorFactor to set
	 */
	public void setFechaValorFactor(Date fechaValorFactor) {
		this.fechaValorFactor = fechaValorFactor;
	}






	/**
	 * @return the nuValorFactor
	 */
	public Double getNuValorFactor() {
		return nuValorFactor;
	}



	/**
	 * @param nuValorFactor the nuValorFactor to set
	 */
	public void setNuValorFactor(Double nuValorFactor) {
		this.nuValorFactor = nuValorFactor;
	}



	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
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
