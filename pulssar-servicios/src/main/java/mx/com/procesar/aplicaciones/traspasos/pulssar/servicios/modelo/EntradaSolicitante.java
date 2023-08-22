package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EntradaSolicitante implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -6187953745972640118L;
	
	/**
	 * tipo de solicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * 1 = modifcacion de datos , 2 = permanencia
	 */
	private String tipoProceso;
	
	/**
	 * datos generales solicitante
	 */
	private DatosSolicitante datosGeneralesSolicitante;
	
	/**
	 * datos domicilio solicitante
	 */
	private DomicilioSolicitante datosDomicilioSolicitante;

	/**
	 * @return the datosGeneralesSolicitante
	 */
	public DatosSolicitante getDatosGeneralesSolicitante() {
		return datosGeneralesSolicitante;
	}

	/**
	 * @param datosGeneralesSolicitante the datosGeneralesSolicitante to set
	 */
	public void setDatosGeneralesSolicitante(DatosSolicitante datosGeneralesSolicitante) {
		this.datosGeneralesSolicitante = datosGeneralesSolicitante;
	}

	/**
	 * @return the datosDomicilioSolicitante
	 */
	public DomicilioSolicitante getDatosDomicilioSolicitante() {
		return datosDomicilioSolicitante;
	}

	/**
	 * @param datosDomicilioSolicitante the datosDomicilioSolicitante to set
	 */
	public void setDatosDomicilioSolicitante(DomicilioSolicitante datosDomicilioSolicitante) {
		this.datosDomicilioSolicitante = datosDomicilioSolicitante;
	}

	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return the tipoProceso
	 */
	public String getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaSolicitante [tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", datosGeneralesSolicitante=");
		builder.append(datosGeneralesSolicitante);
		builder.append(", datosDomicilioSolicitante=");
		builder.append(datosDomicilioSolicitante);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	

}
