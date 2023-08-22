package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;



/**
 * Contiene la información de los campos de la pantalla de reporteria. 
 * 
 * @author ERICK HECTOR LUNA RAMIREZ <EHLUNARA@inet.procesar.com.mx>
 *
 */
public class ReporteriaForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8941992089486366905L;

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
	private String tipoCliente;
	
	/**
	 * Tipo de servicio solicitado
	 */
	private Integer servicio;
	
	/**
	 * Ejecutivo de atención
	 */
	private String ejecutivoAtencion;
	
	
	/**
	 * numeroSucursal
	 */
	private String numeroSucursal;
	
	
	/**
	 * tipo de reporte(web o xls)
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
	 * @return the tipoCliente
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
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
	 * @return the ejecucionAtencion
	 */
	public String getEjecutivoAtencion() {
		return ejecutivoAtencion;
	}

	/**
	 * @param ejecucionAtencion the ejecucionAtencion to set
	 */
	public void setEjecutivoAtencion(String ejecutivoAtencion) {
		this.ejecutivoAtencion = ejecutivoAtencion;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
}
