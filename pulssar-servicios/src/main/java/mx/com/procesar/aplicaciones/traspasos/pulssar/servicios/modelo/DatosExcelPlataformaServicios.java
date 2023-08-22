package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Datos excel 
 * @author RARREOLA
 *
 */
public class DatosExcelPlataformaServicios implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fecha generacion folio
	 */
	private String fechaGeneracionFolio;
	
	/**
	 * clave afore
	 */
	private String claveAfore;
	
	/**
	 * Usuario
	 */
	private String usuario;
	
	/**
	 * folio pulssar
	 */
	private String folioPulssar;
	
	/**
	 * Resultado operacion
	 */
	private String resultadoOperacion;
	
	/**
	 * Diagnostico
	 */
	private String diagnostico;
	
	/**
	 * Color que le toca
	 */
	private String color;
	
	
	/**
	 * @return the fechaGeneracionFolio
	 */
	public String getFechaGeneracionFolio() {
		return fechaGeneracionFolio;
	}




	/**
	 * @param fechaGeneracionFolio the fechaGeneracionFolio to set
	 */
	public void setFechaGeneracionFolio(String fechaGeneracionFolio) {
		this.fechaGeneracionFolio = fechaGeneracionFolio;
	}




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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}




	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	/**
	 * @return the folioPulssar
	 */
	public String getFolioPulssar() {
		return folioPulssar;
	}




	/**
	 * @param folioPulssar the folioPulssar to set
	 */
	public void setFolioPulssar(String folioPulssar) {
		this.folioPulssar = folioPulssar;
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
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}




	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}




	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}




	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
