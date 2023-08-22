package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que contiene los atributos que tendran como respuesta el servicio de
 * curp duplicada
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class CurpDuplicada implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 3890750157115447955L;

	/**
	 * Flujo del mensaje
	 */
	private String codigoOperacion;

	/*
	 * Afores Duplicadas
	 */
	List<String> claveAfore;

	/**
	 * @return the codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	/**
	 * @param codigoOperacion
	 *            the codigoOperacion to set
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	/**
	 * @return the claveAfore
	 */
	public List<String> getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore
	 *            the claveAfore to set
	 */
	public void setClaveAfore(List<String> claveAfore) {
		this.claveAfore = claveAfore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strRespuesta = new StringBuilder();
		strRespuesta.append("CurpDuplicada [");

		if (codigoOperacion != null) {
			strRespuesta.append("codigoOperacion=");
			strRespuesta.append(codigoOperacion);
		}

		if (claveAfore != null) {
			strRespuesta.append(", ");
			strRespuesta.append("claveAfore=");
			strRespuesta.append(claveAfore);
		}
		
		strRespuesta.append("]");
		return strRespuesta.toString();

	}

}
