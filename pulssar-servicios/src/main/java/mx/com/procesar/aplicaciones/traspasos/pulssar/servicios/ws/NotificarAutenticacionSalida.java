
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificarAutenticacionSalida complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificarAutenticacionSalida">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoRespuesta" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_10"/>
 *         &lt;element name="anioRegistro" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="claveElector" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="apellidoPaterno" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="apellidoMaterno" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="anioEmision" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="numeroEmisionCredencial" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="curp" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="ocr" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_6" minOccurs="0"/>
 *         &lt;element name="similitud2" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_50" minOccurs="0"/>
 *         &lt;element name="similitud7" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_50" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificarAutenticacionSalida", namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", propOrder = {
    "codigoRespuesta",
    "anioRegistro",
    "claveElector",
    "apellidoPaterno",
    "apellidoMaterno",
    "nombre",
    "anioEmision",
    "numeroEmisionCredencial",
    "curp",
    "ocr",
    "similitud2",
    "similitud7"
})
public class NotificarAutenticacionSalida {

    @XmlElement(required = true)
    protected String codigoRespuesta;
    protected String anioRegistro;
    protected String claveElector;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombre;
    protected String anioEmision;
    protected String numeroEmisionCredencial;
    protected String curp;
    protected String ocr;
    protected String similitud2;
    protected String similitud7;

    /**
     * Gets the value of the codigoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    /**
     * Sets the value of the codigoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRespuesta(String value) {
        this.codigoRespuesta = value;
    }

    /**
     * Gets the value of the anioRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnioRegistro() {
        return anioRegistro;
    }

    /**
     * Sets the value of the anioRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnioRegistro(String value) {
        this.anioRegistro = value;
    }

    /**
     * Gets the value of the claveElector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveElector() {
        return claveElector;
    }

    /**
     * Sets the value of the claveElector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveElector(String value) {
        this.claveElector = value;
    }

    /**
     * Gets the value of the apellidoPaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Sets the value of the apellidoPaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Gets the value of the apellidoMaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Sets the value of the apellidoMaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the anioEmision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnioEmision() {
        return anioEmision;
    }

    /**
     * Sets the value of the anioEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnioEmision(String value) {
        this.anioEmision = value;
    }

    /**
     * Gets the value of the numeroEmisionCredencial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEmisionCredencial() {
        return numeroEmisionCredencial;
    }

    /**
     * Sets the value of the numeroEmisionCredencial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEmisionCredencial(String value) {
        this.numeroEmisionCredencial = value;
    }

    /**
     * Gets the value of the curp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Sets the value of the curp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Gets the value of the ocr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcr() {
        return ocr;
    }

    /**
     * Sets the value of the ocr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcr(String value) {
        this.ocr = value;
    }

    /**
     * Gets the value of the similitud2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimilitud2() {
        return similitud2;
    }

    /**
     * Sets the value of the similitud2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimilitud2(String value) {
        this.similitud2 = value;
    }

    /**
     * Gets the value of the similitud7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimilitud7() {
        return similitud7;
    }

    /**
     * Sets the value of the similitud7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimilitud7(String value) {
        this.similitud7 = value;
    }

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarAutenticacionSalida [codigoRespuesta=");
		builder.append(codigoRespuesta);
		builder.append(", anioRegistro=");
		builder.append(anioRegistro);
		builder.append(", claveElector=");
		builder.append(claveElector);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", anioEmision=");
		builder.append(anioEmision);
		builder.append(", numeroEmisionCredencial=");
		builder.append(numeroEmisionCredencial);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", ocr=");
		builder.append(ocr);
		builder.append(", similitud2=");
		builder.append(similitud2);
		builder.append(", similitud7=");
		builder.append(similitud7);
		builder.append("]");
		return builder.toString();
	}

}
