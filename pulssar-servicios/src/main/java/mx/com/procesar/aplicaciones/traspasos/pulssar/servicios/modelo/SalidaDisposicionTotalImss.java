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
public class SalidaDisposicionTotalImss implements Serializable{

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
	 *  diagnostico solicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String diagnosticoSolicitud;
	
	/**
	 * Descripcion diagnostico
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String diagnosticoVivienda;
	
	/**
	 * Fecha valor transferencia
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaTransferencia;
	
	
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
	 * @return el atributo folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}
	/**
	 * @param folioSolicitud parametro folioSolicitud a actualizar
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}
	/**
	 * @return el atributo diagnosticoSolicitud
	 */
	public String getDiagnosticoSolicitud() {
		return diagnosticoSolicitud;
	}
	/**
	 * @param diagnosticoSolicitud parametro diagnosticoSolicitud a actualizar
	 */
	public void setDiagnosticoSolicitud(String diagnosticoSolicitud) {
		this.diagnosticoSolicitud = diagnosticoSolicitud;
	}
	/**
	 * @return el atributo diagnosticoVivienda
	 */
	public String getDiagnosticoVivienda() {
		return diagnosticoVivienda;
	}
	/**
	 * @param diagnosticoVivienda parametro diagnosticoVivienda a actualizar
	 */
	public void setDiagnosticoVivienda(String diagnosticoVivienda) {
		this.diagnosticoVivienda = diagnosticoVivienda;
	}
	/**
	 * @return el atributo fechaTransferencia
	 */
	public String getFechaTransferencia() {
		return fechaTransferencia;
	}
	/**
	 * @param fechaTransferencia parametro fechaTransferencia a actualizar
	 */
	public void setFechaTransferencia(String fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}
	/**
	 * @return el atributo estatusVivienda
	 */
	public String getEstatusVivienda() {
		return estatusVivienda;
	}
	/**
	 * @param estatusVivienda parametro estatusVivienda a actualizar
	 */
	public void setEstatusVivienda(String estatusVivienda) {
		this.estatusVivienda = estatusVivienda;
	}
	/**
	 * @return el atributo resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}
	/**
	 * @param resultadoOperacion parametro resultadoOperacion a actualizar
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
