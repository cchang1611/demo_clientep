package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.objetoscomunes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMotivos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMotivos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="motivo" type="{http://www.procesar.com.mx/ARQSOA/comunes/objetosComunes/}Motivo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMotivos", propOrder = {
    "motivo"
})
public class ArrayOfMotivos {

    protected List<Motivo> motivo;

    /**
     * Gets the value of the motivo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the motivo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMotivo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Motivo }
     * 
     * 
     */
    public List<Motivo> getMotivo() {
        if (motivo == null) {
            motivo = new ArrayList<>();
        }
        return this.motivo;
    }

}
