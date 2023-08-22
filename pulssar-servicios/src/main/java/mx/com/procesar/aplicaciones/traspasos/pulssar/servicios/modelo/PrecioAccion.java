package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * PRecio accion
 * @author RARREOLA
 *
 */

public class PrecioAccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * claveAfore
	 */
	private String claveAfore;
	
	
	
	
	/**
	 * claveSiefore
	 */
	private String claveSiefore;
	
	
	
	/**
	 * fechaValorTitulo
	 */
	private Date fechaValorTitulo;
	
	/**
	 * fechaLiquidacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaLiquidacion;
	
	/**
	 * nuValtitFhValor
	 */
	@Column(name="NU_VALTIT_FHVALOR")
	private Double nuValtitFhValor;
	
	
	/**
	 * nuValtitFhLiquida
	 */
	@Column(name="NU_VALTIT_FHLIQUIDA")
	private Double nuValtitFhLiquida;
	
	
	/**
	 * periodo
	 */
	private String periodo;
	
	/**
	 * fechaControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
		
	/**
	 * usuarioModificacion
	 */
	
	private String usuarioModificacion;
	
	
	
	
	




	




	




	




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
	 * @return the claveSiefore
	 */
	public String getClaveSiefore() {
		return claveSiefore;
	}




	/**
	 * @param claveSiefore the claveSiefore to set
	 */
	public void setClaveSiefore(String claveSiefore) {
		this.claveSiefore = claveSiefore;
	}




	/**
	 * @return the fechaValorTitulo
	 */
	public Date getFechaValorTitulo() {
		return fechaValorTitulo;
	}




	/**
	 * @param fechaValorTitulo the fechaValorTitulo to set
	 */
	public void setFechaValorTitulo(Date fechaValorTitulo) {
		this.fechaValorTitulo = fechaValorTitulo;
	}




	/**
	 * @return the nuValtitFhValor
	 */
	public Double getNuValtitFhValor() {
		return nuValtitFhValor;
	}




	/**
	 * @param nuValtitFhValor the nuValtitFhValor to set
	 */
	public void setNuValtitFhValor(Double nuValtitFhValor) {
		this.nuValtitFhValor = nuValtitFhValor;
	}




	/**
	 * @return the nuValtitFhLiquida
	 */
	public Double getNuValtitFhLiquida() {
		return nuValtitFhLiquida;
	}




	/**
	 * @param nuValtitFhLiquida the nuValtitFhLiquida to set
	 */
	public void setNuValtitFhLiquida(Double nuValtitFhLiquida) {
		this.nuValtitFhLiquida = nuValtitFhLiquida;
	}




	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}




	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}





	/**
	 * @return the fechaLiquidacion
	 */
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}




	/**
	 * @param fechaLiquidacion the fechaLiquidacion to set
	 */
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}




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
