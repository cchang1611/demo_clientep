package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Entidad que representa la tabla <b>PSER_TC_SERVICIO</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Entity
@Table(name = "PSER_TC_SERVICIO")
public class Servicio implements Serializable {

	/**
	 * Serializacion de la clase.
	 */
	private static final long serialVersionUID = 4622507930380436867L;

	/**
	 * Identificador unico de la tabla
	 */
	@Id
	@Column(name = "ID_SERVICIO")
	private Long id;

	/**
	 * Calve del Servicio
	 */
	@Column(name = "CV_SERVICIO")
	private String claveServicio;

	/**
	 * Descripción del Servicio
	 */
	@Column(name = "CH_DESC_SERVICIO")
	private String descripcionServicio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param descripcionServicio the descripcionServicio to set
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
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
