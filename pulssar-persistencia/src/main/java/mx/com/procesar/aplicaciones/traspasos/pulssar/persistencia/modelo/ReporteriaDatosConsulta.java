package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 
 * Representa los datos para la consulta de reporteria
 * 
 * @author EHLUNARA
 *
 */
public class ReporteriaDatosConsulta {
	
	/**
	 * Fecha inicio de la busqueda
	 */
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaInicio;
	
	/**
	 * Fecha fin de la busqueda
	 */
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaFin;
	
	/**
	 * Tipo de cliente
	 */
	private String indicadorCita;
	
	/**
	 * Tipo de servicio solicitado
	 */
	private Integer servicio;
	
	
	/**
	 * numeroSucursal
	 */
	private String numeroSucursal;
	
	
	/**
	 * Tipo de reporte si es web o xls
	 */
	private Integer tipoReporte;
	
	
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	
	/**
	 * @return the indicadorCita
	 */
	public String getIndicadorCita() {
		return indicadorCita;
	}


	/**
	 * @param indicadorCita the indicadorCita to set
	 */
	public void setIndicadorCita(String indicadorCita) {
		this.indicadorCita = indicadorCita;
	}


	/**
	 * @return the servicio
	 */
	public Integer getServicio() {
		return servicio;
	}
	
	
	/**
	 * @param servcio the servicio to set
	 */
	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}


	/**
	 * @return the numeroSucursal
	 */
	public String getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * @param numeroSucursal the numeroSucursal to set
	 */
	public void setNumeroSucursal(String numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechafin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the tipoReporte
	 */
	public Integer getTipoReporte() {
		return tipoReporte;
	}


	/**
	 * @param tipoReporte the tipoReporte to set
	 */
	public void setTipoReporte(Integer tipoReporte) {
		this.tipoReporte = tipoReporte;
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
