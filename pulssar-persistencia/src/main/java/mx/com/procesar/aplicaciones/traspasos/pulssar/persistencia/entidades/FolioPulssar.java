package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Entidad asociada a la tabla <b>PSER_TR_FOLIO_PULSSAR</b>.
 * 
 * @author INTORRES
 *
 */
@Entity
@Table(name = "PSER_TR_FOLIO_PULSSAR")
public class FolioPulssar implements Serializable {
	
	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = -8537991770963797317L;

	/**
	 * Identificador unico de bitacora de folios PULSSAR.
	 */
	@Id
	@Column(name = "ID_FOLIO_PULSSAR")
	private Long id;
	
	/**
	 * Clave de la sucursal.
	 */
	@Column(name = "CH_SUCURSAL")
	private String sucursal;

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
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
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
