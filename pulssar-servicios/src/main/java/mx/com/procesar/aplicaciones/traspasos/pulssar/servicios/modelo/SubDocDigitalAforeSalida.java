package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de salida del servicio de documentos digitales del afore
 * 
 * @author dbarbosa
 * @version 1.0
 */
public class SubDocDigitalAforeSalida implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 8091785790538327758L;

	/**
	 * claveSubDocProcesar
	 */
	private String claveSubDocAfore;

	/**
	 * Descripción Subtipo Documento
	 */
	private String descSubtipoDocumento;

	/**
	 * @return el atributo claveSubDocAfore
	 */
	public String getClaveSubDocAfore() {
		return claveSubDocAfore;
	}

	/**
	 * @param claveSubDocAfore
	 *            parametro claveSubDocAfore a actualizar
	 */
	public void setClaveSubDocAfore(String claveSubDocAfore) {
		this.claveSubDocAfore = claveSubDocAfore;
	}

	/**
	 * @return el atributo descSubtipoDocumento
	 */
	public String getDescSubtipoDocumento() {
		return descSubtipoDocumento;
	}

	/**
	 * @param descSubtipoDocumento
	 *            parametro descSubtipoDocumento a actualizar
	 */
	public void setDescSubtipoDocumento(String descSubtipoDocumento) {
		this.descSubtipoDocumento = descSubtipoDocumento;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubDocDigitalAforeSalida [claveSubDocAfore=");
		builder.append(claveSubDocAfore);
		builder.append(", descSubtipoDocumento=");
		builder.append(descSubtipoDocumento);
		builder.append("]");
		return builder.toString();
	}

}
