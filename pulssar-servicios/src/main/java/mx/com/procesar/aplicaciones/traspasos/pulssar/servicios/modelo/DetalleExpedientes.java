package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DetalleExpedientes implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -2196489537446956765L;

	/**
	 * Atributo CV_TIPO_PROCESO
	 */

	@JsonProperty("CV_TIPO_PROCESO")
	private String cvTipoProceso;
	
	/**
	 * Atributo CH_FECHA_OPERACION
	 */
    @JsonProperty("CH_FECHA_OPERACION")
	private String chFechaOperacion;

    /**
     * descripcionExpediente
     */
    private String descripcionExpediente;
	/**
	 * Obtener cvTipoProceso
	 */
	
	public String getCvTipoProceso() {
		return cvTipoProceso;
	}

	/**
	 * Setear cvTipoProceso
	 */
	public void setCvTipoProceso(String cvTipoProceso) {
		this.cvTipoProceso = cvTipoProceso;
	}
	/**
	 * Obtener chFechaOperacion
	 */
	public String getChFechaOperacion() {
		return chFechaOperacion;
	}

	/**
	 * Setear chFechaOperacion
	 */
	public void setChFechaOperacion(String chFechaOperacion) {
		this.chFechaOperacion = chFechaOperacion;
	}

	/**
	 * @return the descripcionExpediente
	 */
	public String getDescripcionExpediente() {
		return descripcionExpediente;
	}

	/**
	 * @param descripcionExpediente the descripcionExpediente to set
	 */
	public void setDescripcionExpediente(String descripcionExpediente) {
		this.descripcionExpediente = descripcionExpediente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetalleExpedientes [cvTipoProceso=");
		builder.append(cvTipoProceso);
		builder.append(", chFechaOperacion=");
		builder.append(chFechaOperacion);
		builder.append(", descripcionExpediente=");
		builder.append(descripcionExpediente);
		builder.append("]");
		return builder.toString();
	}

	
	

}
