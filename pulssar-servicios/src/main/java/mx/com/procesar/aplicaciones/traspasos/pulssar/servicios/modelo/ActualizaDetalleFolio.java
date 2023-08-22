/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author EDELGADO
 * Datos de entrada para el servicio de actualizacion de detalle de folio padre
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActualizaDetalleFolio implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8246807424349959567L;
	
	/**
	 * Identificador de folio
	 */
	private String idFolio;

	/**
	 * Clave de servicio
	 */
	private String claveServicio;
	
	/**
	 * Descripcion
	 */
	private String descripcion;

	/**
	 * @return the idFolio
	 */
	public String getIdFolio() {
		return idFolio;
	}


	/**
	 * @param idFolio the idFolio to set
	 */
	public void setIdFolio(String idFolio) {
		this.idFolio = idFolio;
	}


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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActualizaDetalleFolio [idFolio=");
		builder.append(idFolio);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
