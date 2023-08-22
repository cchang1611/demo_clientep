/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * respuesta de la solicitud
 * @author jcgarces
 *
 */
public class RespuestaSolicitud implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 4534873731108656629L;

	/**
	 * folio procesar
	 */
	private String folioProcesar;
	
	/**
	 * folio cliente
	 */
	private String folioServicio; 
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;
	
	/**
	 * motivoRechazo
	 */
	private String motivoRechazo;
	
	/**
	 * descripcionRechazo
	 */
	private String descripcionRechazo;

	/**
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar the folioProcesar to set
	 */
	public void setFolioProcesar(String folioPorcesar) {
		this.folioProcesar = folioPorcesar;
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
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the descripcionRechazo
	 */
	public String getDescripcionRechazo() {
		return descripcionRechazo;
	}

	/**
	 * @param descripcionRechazo the descripcionRechazo to set
	 */
	public void setDescripcionRechazo(String descripcionRechazo) {
		this.descripcionRechazo = descripcionRechazo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaSolicitud [folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", folioServicio=");
		builder.append(folioServicio);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", descripcionRechazo=");
		builder.append(descripcionRechazo);
		builder.append("]");
		return builder.toString();
	}
	
}
