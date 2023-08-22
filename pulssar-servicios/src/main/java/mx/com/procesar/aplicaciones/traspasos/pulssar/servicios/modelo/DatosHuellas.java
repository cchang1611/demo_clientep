package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.PosicionDedoEnum;

/**
 * Objeto de Entrada, Datos de la huellas
 * @author dbarbosa
 * @version 1.0
 */
public class DatosHuellas implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -4063273312103688790L;
	
	/**
	 * Posicion de huella
	 */
	private Integer posicionDedo;
	
	/**
	 * calidad de huella
	 */
	private Integer calidadHuella;
	
	/**
	 * motivo error
	 */
	private String motivo;
	
	/**
	 * descripcion motivo
	 */
	private String descripcionMotivo;
	
	/**
	 * calidad de huella
	 */
	private String descripcionDedo;
	
	/**
	 * codigo falta dedo
	 */
	private String codigoFaltaDedo;

	/**
	 * @return the posicionDedo
	 */
	public Integer getPosicionDedo() {
		return posicionDedo;
	}

	/**
	 * @param posicionDedo the posicionDedo to set
	 */
	public void setPosicionDedo(Integer posicionDedo) {
		this.posicionDedo = posicionDedo;
	}

	/**
	 * @return the calidadHuella
	 */
	public Integer getCalidadHuella() {
		return calidadHuella;
	}

	/**
	 * @param calidadHuella the calidadHuella to set
	 */
	public void setCalidadHuella(Integer calidadHuella) {
		this.calidadHuella = calidadHuella;
	}

	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the descripcionMotivo
	 */
	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}

	/**
	 * @param descripcionMotivo the descripcionMotivo to set
	 */
	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	/**
	 * @return the descripcionDedo
	 */
	public String getDescripcionDedo() {
		PosicionDedoEnum posicion = PosicionDedoEnum.obtenerDedo(posicionDedo);
		return posicion.getDescripcion();
	}

	/**
	 * @param descripcionDedo the descripcionDedo to set
	 */
	public void setDescripcionDedo(String descripcionDedo) {
		this.descripcionDedo = descripcionDedo;
	}

	/**
	 * @return the codigoFaltaDedo
	 */
	public String getCodigoFaltaDedo() {
		return codigoFaltaDedo;
	}

	/**
	 * @param codigoFaltaDedo the codigoFaltaDedo to set
	 */
	public void setCodigoFaltaDedo(String codigoFaltaDedo) {
		this.codigoFaltaDedo = codigoFaltaDedo;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosHuellas [posicionDedo=");
		builder.append(posicionDedo);
		builder.append(", calidadHuella=");
		builder.append(calidadHuella);
		builder.append(", motivo=");
		builder.append(motivo);
		builder.append(", descripcionMotivo=");
		builder.append(descripcionMotivo);
		builder.append(", descripcionDedo=");
		builder.append(descripcionDedo);
		builder.append(", codigoFaltaDedo=");
		builder.append(codigoFaltaDedo);
		builder.append("]");
		return builder.toString();
	}
}