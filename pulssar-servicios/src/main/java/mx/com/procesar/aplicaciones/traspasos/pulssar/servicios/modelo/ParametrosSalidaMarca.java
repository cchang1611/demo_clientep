package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase que agrupa los parametros para la salida de una Marca
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class ParametrosSalidaMarca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Clave del Proceso
	 */
	private String claveProceso;

	/**
	 * Descripción del Proceso
	 */
	private String descripcionProceso;

	/**
	 * @return the claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso
	 *            the claveProceso to set
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return the descripcionProceso
	 */
	public String getDescripcionProceso() {
		return descripcionProceso;
	}

	/**
	 * @param descripcionProceso
	 *            the descripcionProceso to set
	 */
	public void setDescripcionProceso(String descripcionProceso) {
		this.descripcionProceso = descripcionProceso;
	}

	/**
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParametrosSalidaMarca [claveProceso=");
		builder.append(claveProceso);
		builder.append(", descripcionProceso=");
		builder.append(descripcionProceso);
		builder.append("]");
		return builder.toString();
	}

}
