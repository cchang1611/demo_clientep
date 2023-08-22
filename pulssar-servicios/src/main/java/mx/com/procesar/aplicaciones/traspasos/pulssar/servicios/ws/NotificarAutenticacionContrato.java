
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificarAutenticacionContrato complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificarAutenticacionContrato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idssn" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}IDSSNS"/>
 *         &lt;element name="cuerpo" type="{http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/}notificarAutenticacionEntrada"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificarAutenticacionContrato", namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", propOrder = {
    "idssn",
    "cuerpo"
})
public class NotificarAutenticacionContrato {

    @XmlElement(required = true)
    protected IDSSNS idssn;
    @XmlElement(required = true)
    protected NotificarAutenticacionEntrada cuerpo;

    /**
     * Gets the value of the idssn property.
     * 
     * @return
     *     possible object is
     *     {@link IDSSNS }
     *     
     */
    public IDSSNS getIdssn() {
        return idssn;
    }

    /**
     * Sets the value of the idssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDSSNS }
     *     
     */
    public void setIdssn(IDSSNS value) {
        this.idssn = value;
    }

    /**
     * Gets the value of the cuerpo property.
     * 
     * @return
     *     possible object is
     *     {@link NotificarAutenticacionEntrada }
     *     
     */
    public NotificarAutenticacionEntrada getCuerpo() {
        return cuerpo;
    }

    /**
     * Sets the value of the cuerpo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificarAutenticacionEntrada }
     *     
     */
    public void setCuerpo(NotificarAutenticacionEntrada value) {
        this.cuerpo = value;
    }

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarAutenticacionContrato [idssn=");
		builder.append(idssn);
		builder.append(", cuerpo=");
		builder.append(cuerpo);
		builder.append("]");
		return builder.toString();
	}

}
