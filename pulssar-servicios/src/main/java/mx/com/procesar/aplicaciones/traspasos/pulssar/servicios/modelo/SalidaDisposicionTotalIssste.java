package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Salida disposicion total issste
 * @author RARREOLA
 *
 */
public class SalidaDisposicionTotalIssste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Folio solicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioSolicitud;
	
	/**
	 * Fecha valor transferencia
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaValorTransferencia;
	/**
	 *  diagnostico solicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String diagnosticoOperacion;
	
	/**
	 * Descripcion diagnostico
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String descripcionDiagnostico;
	
	/**
	 * Estatus vivienda
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String estatusVivienda;
	
	
	/**
	 * Resultado operacion
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
	 * @return the fechaValorTransferencia
	 */
	public String getFechaValorTransferencia() {
		return fechaValorTransferencia;
	}


	/**
	 * @param fechaValorTransferencia the fechaValorTransferencia to set
	 */
	public void setFechaValorTransferencia(String fechaValorTransferencia) {
		this.fechaValorTransferencia = fechaValorTransferencia;
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
	 * @return the estatusVivienda
	 */
	public String getEstatusVivienda() {
		return estatusVivienda;
	}


	/**
	 * @param estatusVivienda the estatusVivienda to set
	 */
	public void setEstatusVivienda(String estatusVivienda) {
		this.estatusVivienda = estatusVivienda;
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
