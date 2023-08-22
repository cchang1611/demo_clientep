package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Datos de salida para roles url
 * @author RARREOLA
 *
 */
public class DatosSalidaRolesUrl implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Descripcion del error
	 */
	private String descripcionError;
	
	/**
	 * Estatus de la respuesta
	 */
	private boolean estatusRespuesta;

	/**
	 * @return the descripcionError
	 */
	public String getDescripcionError() {
		return descripcionError;
	}

	/**
	 * @param descripcionError the descripcionError to set
	 */
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	/**
	 * @return the estatusRespuesta
	 */
	public boolean isEstatusRespuesta() {
		return estatusRespuesta;
	}

	/**
	 * @param estatusRespuesta the estatusRespuesta to set
	 */
	public void setEstatusRespuesta(boolean estatusRespuesta) {
		this.estatusRespuesta = estatusRespuesta;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("DatosSalidaRolesUrl [descripcionError=");
		builder.append(descripcionError);
		builder.append(", estatusRespuesta=");
		builder.append(estatusRespuesta);
		builder.append("]");

		return builder.toString();
	}

}
