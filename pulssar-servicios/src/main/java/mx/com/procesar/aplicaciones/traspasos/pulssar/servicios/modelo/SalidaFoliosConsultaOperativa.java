package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;
/**
 * Salida folios consulta operativas
 * @author RARREOLA
 *
 */
public class SalidaFoliosConsultaOperativa implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Afore
	 */
	private String claveOrganizacion;
	
	/**
	 * Fecha control
	 */
	private Date fechaGeneracion;
	
	/**
	 * Clave servicio
	 */
	private String claveServicio;
	
	/**
	 * Total
	 */
	private Long total;
	
	/**
	 * Usuario
	 */
	private String claveAgente;
	
	/**
	 * Folio pulssar
	 */
	private String chFolio;
	
	/**
	 * Resultado operacion
	 */
	private String resultadoOperacion;
	
	/**
	 * Diagnostico
	 */
	private String diagnostico;
	
	

	/**
	 * @return the claveServicio
	 */
	public String getClaveServicio() {
		return claveServicio;
	}

	/**
	 * @param claveServicio the claveServicio to set
	 */
	public void setClaveServicio(String claveServicio) {
		this.claveServicio = claveServicio;
	}

	
	


	/**
	 * @return the claveOrganizacion
	 */
	public String getClaveOrganizacion() {
		return claveOrganizacion;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(String claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}

	/**
	 * @return the fechaGeneracion
	 */
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	


	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}

	/**
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	/**
	 * @return the chFolio
	 */
	public String getChFolio() {
		return chFolio;
	}

	/**
	 * @param chFolio the chFolio to set
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
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
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalidaFoliosConsultaOperativa [claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", fechaGeneracion=");
		builder.append(fechaGeneracion);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", total=");
		builder.append(total);
		builder.append(", claveAgente=");
		builder.append(claveAgente);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append("]");
		return builder.toString();
	}

}
