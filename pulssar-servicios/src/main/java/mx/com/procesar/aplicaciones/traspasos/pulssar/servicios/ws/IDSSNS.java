
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDSSNS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDSSNS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idEbusiness">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *               &lt;pattern value="(0|([1-9][0-9]*))"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idServicio">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *               &lt;pattern value="(0|([1-9][0-9]*))"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idCliente">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *               &lt;pattern value="(0|([1-9][0-9]*))"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDSSNS", propOrder = {
    "idEbusiness",
    "idServicio",
    "idCliente"
})
public class IDSSNS {

    protected int idEbusiness;
    protected int idServicio;
    protected int idCliente;

    /**
     * Gets the value of the idEbusiness property.
     * 
     */
    public int getIdEbusiness() {
        return idEbusiness;
    }

    /**
     * Sets the value of the idEbusiness property.
     * 
     */
    public void setIdEbusiness(int value) {
        this.idEbusiness = value;
    }

    /**
     * Gets the value of the idServicio property.
     * 
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Sets the value of the idServicio property.
     * 
     */
    public void setIdServicio(int value) {
        this.idServicio = value;
    }

    /**
     * Gets the value of the idCliente property.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
    }

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IDSSNS [idEbusiness=");
		builder.append(idEbusiness);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", idCliente=");
		builder.append(idCliente);
		builder.append("]");
		return builder.toString();
	}

}
