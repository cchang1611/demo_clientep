//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.16 at 12:26:30 PM CST 
//


package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * <p>Java class for LayoutHistoricoRetiros complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayoutHistoricoRetiros"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nss" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="claveAfore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

public class HistoricoRetiros  implements Serializable{

	/**
	 * serial VersionUID
	 */
	private static final long serialVersionUID = 8904496825711903200L;
	protected String nss;
	protected String claveAfore;

	/**
	 * Gets the value of the nss property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * Sets the value of the nss property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setNss(String value) {
		this.nss = value;
	}

	/**
	 * Gets the value of the claveAfore property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * Sets the value of the claveAfore property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setClaveAfore(String value) {
		this.claveAfore = value;
	}

	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoricoRetiros [getNss()=");
		builder.append(getNss());
		builder.append(", getClaveAfore()=");
		builder.append(getClaveAfore());
		builder.append("]");
		return builder.toString();
	}

}
