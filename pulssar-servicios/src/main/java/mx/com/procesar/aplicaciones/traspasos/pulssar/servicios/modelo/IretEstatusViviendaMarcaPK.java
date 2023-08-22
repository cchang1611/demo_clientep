package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * MAtriz derecho proceso
 * @author RARREOLA
 *
 */
public class IretEstatusViviendaMarcaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * idTipoProceso
	 */
	private Long idTipoProceso;
	
	/**
	 * cvEstatusVivienda
	 */
	private String cvEstatusVivienda;
	




	/**
	 * @return the idTipoProceso
	 */
	public Long getIdTipoProceso() {
		return idTipoProceso;
	}









	/**
	 * @param idTipoProceso the idTipoProceso to set
	 */
	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}









	/**
	 * @return the cvEstatusVivienda
	 */
	public String getCvEstatusVivienda() {
		return cvEstatusVivienda;
	}









	/**
	 * @param cvEstatusVivienda the cvEstatusVivienda to set
	 */
	public void setCvEstatusVivienda(String cvEstatusVivienda) {
		this.cvEstatusVivienda = cvEstatusVivienda;
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
