package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Representa una Afore, mapeado a la tabla PSER_TR_FOLIO_PULSSAR
 * 
 * @author jmcabrer
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioFechas implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -3861947866338064750L;
	
	/**
	 * Identificador
	 */
	private Long idFolioPulssar;
	
	/**
	 * Folio
	 */
	private String chFolio;

	/**
	 * Fecha de generacion
	*/
	private Date fechaGeneracionSn;
   
	/**
	 * Fecha de control
	 */
	private Date fechaControlSn;

	/**
	 * Fecha de llegada
	 */
	private Date fechaLlegadaSn;
	/**
	 * Fecha de llegada
	 */
	private Date fechaCierreSn;	
	
	/**
	 *  Constructor default
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param chFolio
	 *  @param nss
	 *  @param curp
	 */
	public FolioFechas() {
	}

	/**
	 * @return the idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}

	/**
	 * @param idFolioPulssar the idFolioPulssar to set
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
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
	 * @return the fechaGeneracionSn
	 */
	public Date getFechaGeneracionSn() {
		return fechaGeneracionSn;
	}

	/**
	 * @param fechaGeneracionSn the fechaGeneracionSn to set
	 */
	public void setFechaGeneracionSn(Date fechaGeneracionSn) {
		this.fechaGeneracionSn = fechaGeneracionSn;
	}

	/**
	 * @return the fechaControlSn
	 */
	public Date getFechaControlSn() {
		return fechaControlSn;
	}

	/**
	 * @param fechaControlSn the fechaControlSn to set
	 */
	public void setFechaControlSn(Date fechaControlSn) {
		this.fechaControlSn = fechaControlSn;
	}

	/**
	 * @return the fechaLlegadaSn
	 */
	public Date getFechaLlegadaSn() {
		return fechaLlegadaSn;
	}

	/**
	 * @param fechaLlegadaSn the fechaLlegadaSn to set
	 */
	public void setFechaLlegadaSn(Date fechaLlegadaSn) {
		this.fechaLlegadaSn = fechaLlegadaSn;
	}

	/**
	 * @return the fechaCierreSn
	 */
	public Date getFechaCierreSn() {
		return fechaCierreSn;
	}

	/**
	 * @param fechaCierreSn the fechaCierreSn to set
	 */
	public void setFechaCierreSn(Date fechaCierreSn) {
		this.fechaCierreSn = fechaCierreSn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolioFechas [idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", fechaGeneracionSn=");
		builder.append(fechaGeneracionSn);
		builder.append(", fechaControlSn=");
		builder.append(fechaControlSn);
		builder.append(", fechaLlegadaSn=");
		builder.append(fechaLlegadaSn);
		builder.append(", fechaCierreSn=");
		builder.append(fechaCierreSn);
		builder.append("]");
		return builder.toString();
	}

	
}
