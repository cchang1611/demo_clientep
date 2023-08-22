package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de salida del servicio de documentos digitales del afore
 * 
 * @author dbarbosa
 * @version 1.0
 */
public class DocumentoDigitalAforeSalida implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 6622081154937009974L;

	/**
	 * claveTipoDocDigitalAfore
	 */
	private String claveTipoDocDigitalAfore;

	/**
	 * claveAfore
	 */
	private String claveAfore;

	/**
	 * descripcionDocDigital
	 */
	private String descripcionDocDigital;
	
	/**
	 * Lista de subdocumentos 
	 */
	private List<SubDocDigitalAforeSalida> subDocumentos;

	/**
	 * @return el atributo claveTipoDocDigitalAfore
	 */
	public String getClaveTipoDocDigitalAfore() {
		return claveTipoDocDigitalAfore;
	}

	/**
	 * @param claveTipoDocDigitalAfore
	 *            parametro claveTipoDocDigitalAfore a actualizar
	 */
	public void setClaveTipoDocDigitalAfore(String claveTipoDocDigitalAfore) {
		this.claveTipoDocDigitalAfore = claveTipoDocDigitalAfore;
	}

	/**
	 * @return el atributo claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore
	 *            parametro claveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return el atributo descripcionDocDigital
	 */
	public String getDescripcionDocDigital() {
		return descripcionDocDigital;
	}

	/**
	 * @param descripcionDocDigital
	 *            parametro descripcionDocDigital a actualizar
	 */
	public void setDescripcionDocDigital(String descripcionDocDigital) {
		this.descripcionDocDigital = descripcionDocDigital;
	}
	
	/**
	 * Lista de suboducmentos
	 * @return
	 */
	public List<SubDocDigitalAforeSalida> getSubDocumentos()
	  {
	    if (null == subDocumentos) {
	      this.subDocumentos = new ArrayList<>();
	    }

	    return subDocumentos;
	  }

	  /**
	   * Subdocumentos
	   * @param subDocumentos
	   */
	  public void setSubDocumentos(List<SubDocDigitalAforeSalida> subDocumentos)
	  {
	    this.subDocumentos = subDocumentos;
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
		builder.append("DocumentoDigitalAforeSalida [claveTipoDocDigitalAfore=");
		builder.append(claveTipoDocDigitalAfore);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", descripcionDocDigital=");
		builder.append(descripcionDocDigital);
		builder.append("]");
		return builder.toString();
	}

}
