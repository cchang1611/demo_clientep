/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contiene la información para la <b>Disponibilidad de Turno</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class DisponibilidadTurno extends TurnoBase {
	
	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = -6648480557744855456L;
	
	/**
	 * Determina el color registro en hojas de estilo;
	 */
	private String colorRegistroCss;

	/**
	 * Color que se mostrara que le corresponde.
	 */
	private String colorCss;
	
	/**
	 * Hora de la cita.
	 */
	private String horaCita;
	
	/**
	 * Curp del Cliente.
	 */
	private String curp;
	
	/**
	 * Folio de servicio.
	 */
	private String folioServicio;
	
	/**
	 * Clave para el estatus.
	 */
	private String claveEstatus;
	
	/**
	 * @return the colorRegistroCss
	 */
	public String getColorRegistroCss() {
		return colorRegistroCss;
	}

	/**
	 * @param colorRegistroCss the colorRegistroCss to set
	 */
	public void setColorRegistroCss(String colorRegistroCss) {
		this.colorRegistroCss = colorRegistroCss;
	}

	/**
	 * @return the colorCss
	 */
	public String getColorCss() {
		return colorCss;
	}

	/**
	 * @param colorCss the colorCss to set
	 */
	public void setColorCss(String colorCss) {
		this.colorCss = colorCss;
	}

	/**
	 * @return the horaCita
	 */
	public String getHoraCita() {
		return horaCita;
	}

	/**
	 * @param horaCita the horaCita to set
	 */
	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the folioServicio
	 */
	public String getFolioServicio() {
		return folioServicio;
	}

	/**
	 * @param folioServicio the folioServicio to set
	 */
	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}
	
	/**
	 * @return the claveEstatus
	 */
	public String getClaveEstatus() {
		return claveEstatus;
	}

	/**
	 * @param claveEstatus the claveEstatus to set
	 */
	public void setClaveEstatus(String claveEstatus) {
		this.claveEstatus = claveEstatus;
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
