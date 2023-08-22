package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ConsultaCusEntrada {

	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * estatus
	 */
	private String estatus;
	
	/**
	 * tipoServicio
	 */
	private String tipoServicio;
	/**
	 * cus
	 */
	private Long cus;

	/**
	 *  getCurp
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 *  setCurp
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 *  getEstatus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 *  setEstatus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 *  getTipoServicio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}

	/**
	 *  setTipoServicio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param tipoServicio
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	/**
	 * @return the cus
	 */
	public Long getCus() {
		return cus;
	}

	/**
	 * @param cus the cus to set
	 */
	public void setCus(Long cus) {
		this.cus = cus;
	}
	
}
