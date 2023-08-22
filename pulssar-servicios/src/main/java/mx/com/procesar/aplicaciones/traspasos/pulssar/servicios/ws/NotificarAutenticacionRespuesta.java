
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificarAutenticacionRespuesta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificarAutenticacionRespuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objetoRespuesta" type="{http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/}notificarAutenticacionSalida"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificarAutenticacionRespuesta", namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", propOrder = {
    "objetoRespuesta"
})
public class NotificarAutenticacionRespuesta {

    @XmlElement(required = true)
    protected NotificarAutenticacionSalida objetoRespuesta;

    /**
     * Gets the value of the objetoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link NotificarAutenticacionSalida }
     *     
     */
    public NotificarAutenticacionSalida getObjetoRespuesta() {
        return objetoRespuesta;
    }

    /**
     * Sets the value of the objetoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificarAutenticacionSalida }
     *     
     */
    public void setObjetoRespuesta(NotificarAutenticacionSalida value) {
        this.objetoRespuesta = value;
    }

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarAutenticacionRespuesta [objetoRespuesta=");
		builder.append(objetoRespuesta);
		builder.append("]");
		return builder.toString();
	}

}
