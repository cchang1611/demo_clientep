package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Jan 2, 2020
 */
public class FolioActivoDetalle {

	/**
	 * idFolio
	 */
	private Long idFolioPulssar;
	/**
	 * estatus
	 */
	private Long nuEstatus;
	/**
	 * idProceso
	 */
	private Long idProceso;
	
	/**
	 * cveProceso
	 */
	private String cvProceso;
	/**
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idFolio
	 *  @param estatus
	 *  @param idProceso
	 */
	public FolioActivoDetalle(Long idFolioPulssar, Long nuEstatus, Long idProceso, String cvProceso) {
		this.idFolioPulssar = idFolioPulssar;
		this.nuEstatus = nuEstatus;
		this.idProceso = idProceso;
		this.cvProceso = cvProceso;
	}
	
	public FolioActivoDetalle() {
		
	}

	/**
	 * @return el atributo idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}


	/**
	 * @param idFolioPulssar parametro idFolioPulssar a actualizar
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}


	/**
	 * @return el atributo nuEstatus
	 */
	public Long getNuEstatus() {
		return nuEstatus;
	}


	/**
	 * @param nuEstatus parametro nuEstatus a actualizar
	 */
	public void setNuEstatus(Long nuEstatus) {
		this.nuEstatus = nuEstatus;
	}


	/**
	 * @return el atributo idProceso
	 */
	public Long getIdProceso() {
		return idProceso;
	}


	/**
	 * @param idProceso parametro idProceso a actualizar
	 */
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}


	/**
	 * @return el atributo cvProceso
	 */
	public String getCvProceso() {
		return cvProceso;
	}


	/**
	 * @param cvProceso parametro cvProceso a actualizar
	 */
	public void setCvProceso(String cvProceso) {
		this.cvProceso = cvProceso;
	}


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
