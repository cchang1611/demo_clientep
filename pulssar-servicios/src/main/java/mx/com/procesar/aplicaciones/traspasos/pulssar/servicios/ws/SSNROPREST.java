
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SSNROPREST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SSNROPREST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codoper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codRespuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codRespuestaOpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descRespuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motivos" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}ArrayOfMotivosRest" minOccurs="0"/>
 *         &lt;element name="codoperCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tiempoRespuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SSNROPREST", propOrder = {
    "codoper",
    "codRespuesta",
    "codRespuestaOpr",
    "descRespuesta",
    "motivos",
    "codoperCliente",
    "tiempoRespuesta",
    "fecha"
})
public class SSNROPREST {

    @XmlElement(required = true)
    protected String codoper;
    @XmlElement(required = true)
    protected String codRespuesta;
    @XmlElement(required = true)
    protected String codRespuestaOpr;
    @XmlElement(required = true)
    protected String descRespuesta;
    protected ArrayOfMotivosRest motivos;
    @XmlElement(required = true)
    protected String codoperCliente;
    @XmlElement(required = true)
    protected String tiempoRespuesta;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;

    /**
     * Gets the value of the codoper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodoper() {
        return codoper;
    }

    /**
     * Sets the value of the codoper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodoper(String value) {
        this.codoper = value;
    }

    /**
     * Gets the value of the codRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRespuesta() {
        return codRespuesta;
    }

    /**
     * Sets the value of the codRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRespuesta(String value) {
        this.codRespuesta = value;
    }

    /**
     * Gets the value of the codRespuestaOpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRespuestaOpr() {
        return codRespuestaOpr;
    }

    /**
     * Sets the value of the codRespuestaOpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRespuestaOpr(String value) {
        this.codRespuestaOpr = value;
    }

    /**
     * Gets the value of the descRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRespuesta() {
        return descRespuesta;
    }

    /**
     * Sets the value of the descRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRespuesta(String value) {
        this.descRespuesta = value;
    }

    /**
     * Gets the value of the motivos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMotivosRest }
     *     
     */
    public ArrayOfMotivosRest getMotivos() {
        return motivos;
    }

    /**
     * Sets the value of the motivos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMotivosRest }
     *     
     */
    public void setMotivos(ArrayOfMotivosRest value) {
        this.motivos = value;
    }

    /**
     * Gets the value of the codoperCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodoperCliente() {
        return codoperCliente;
    }

    /**
     * Sets the value of the codoperCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodoperCliente(String value) {
        this.codoperCliente = value;
    }

    /**
     * Gets the value of the tiempoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    /**
     * Sets the value of the tiempoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiempoRespuesta(String value) {
        this.tiempoRespuesta = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

}
