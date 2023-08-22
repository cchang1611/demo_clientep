package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class EntradaVisorExpedientesIdentificacionMovil implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 8996803854234675964L;
		
	/**
	 * clave de tipoServicio
	 */
	private String tipoServicio;
		
	/**
		* descripcion de claveAfore
	 */
	private String claveAfore;
		
	/**
		* descripcion de curp
	*/
	private String curp;
		
	/**
	 * descripcion de tipoExpediente
	*/
	private String tipoExpediente;
		
	/**
	 * descripcion de fechaOperacionExpe
	*/
	private String fechaOperacionExpe;

	/**
	 * @return the tipoServicio
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio the tipoServicio to set
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
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
	 * @return the tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}

	/**
	 * @param tipoExpediente the tipoExpediente to set
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

	/**
	 * @return the fechaOperacionExpe
	 */
	public String getFechaOperacionExpe() {
		return fechaOperacionExpe;
	}

	/**
	 * @param fechaOperacionExpe the fechaOperacionExpe to set
	 */
	public void setFechaOperacionExpe(String fechaOperacionExpe) {
		this.fechaOperacionExpe = fechaOperacionExpe;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaVisorExpedientesIdentificacionMovil [tipoServicio=");
		builder.append(tipoServicio);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append(", fechaOperacionExpe=");
		builder.append(fechaOperacionExpe);
		builder.append("]");
		return builder.toString();
	}
			

}

