
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.StringUtils;


/**
 * <p>Java class for notificarAutenticacionEntrada complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notificarAutenticacionEntrada">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cic" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_9" minOccurs="0"/>
 *         &lt;element name="ocr" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_13"/>
 *         &lt;element name="anioRegistro" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_4"/>
 *         &lt;element name="anioEmision" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_4"/>
 *         &lt;element name="claveElector" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_18"/>
 *         &lt;element name="curp" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_18"/>
 *         &lt;element name="emision" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_2"/>
 *         &lt;element name="apellidoPaterno" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_0_32"/>
 *         &lt;element name="apellidoMaterno" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_0_32"/>
 *         &lt;element name="nombre" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_0_32"/>
 *         &lt;element name="fechaFirma" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}fecha_DDMMYYYY_guion"/>
 *         &lt;element name="origen" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}numericoString_1"/>
 *         &lt;element name="tipoProceso" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}numericoString_1"/>
 *         &lt;element name="fechaConsulta" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}fecha_DDMMYYYY_guion"/>
 *         &lt;element name="minucia2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minucia7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="curpReferenciaTitular" type="{http://www.procesar.com.mx/ArquitecturaSW/DataTypes/tiposComunesProcesar/}alfaNumerico_18" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificarAutenticacionEntrada", namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", propOrder = {
    "cic",
    "ocr",
    "anioRegistro",
    "anioEmision",
    "claveElector",
    "curp",
    "emision",
    "apellidoPaterno",
    "apellidoMaterno",
    "nombre",
    "fechaFirma",
    "origen",
    "tipoProceso",
    "fechaConsulta",
    "minucia2",
    "minucia7",
    "curpReferenciaTitular"
})
public class NotificarAutenticacionEntrada {

    protected String cic;
    @XmlElement(required = true)
    protected String ocr;
    @XmlElement(required = true)
    protected String anioRegistro;
    @XmlElement(required = true)
    protected String anioEmision;
    @XmlElement(required = true)
    protected String claveElector;
    @XmlElement(required = true)
    protected String curp;
    @XmlElement(required = true)
    protected String emision;
    @XmlElement(required = true)
    protected String apellidoPaterno;
    @XmlElement(required = true)
    protected String apellidoMaterno;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String fechaFirma;
    @XmlElement(required = true)
    protected String origen;
    @XmlElement(required = true)
    protected String tipoProceso;
    @XmlElement(required = true)
    protected String fechaConsulta;
    protected String minucia2;
    protected String minucia7;
    protected String curpReferenciaTitular;

    /**
     * Gets the value of the cic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCic() {
        return cic;
    }

    /**
     * Sets the value of the cic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCic(String value) {
        this.cic = StringUtils.isBlank(value) ? null : value;
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
        this.ocr = StringUtils.isBlank(value) ? null : value;
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
        this.anioRegistro = StringUtils.isBlank(value) ? null : value;
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
        this.anioEmision = StringUtils.isBlank(value) ? null : value;
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
        this.claveElector = StringUtils.isBlank(value) ? null : value;
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
        this.curp = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the emision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmision() {
        return emision;
    }

    /**
     * Sets the value of the emision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmision(String value) {
        this.emision = StringUtils.isBlank(value) ? null : value;
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
        this.apellidoPaterno = StringUtils.isBlank(value) ? null : value;
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
        this.apellidoMaterno = StringUtils.isBlank(value) ? null : value;
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
        this.nombre = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the fechaFirma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFirma() {
        return fechaFirma;
    }

    /**
     * Sets the value of the fechaFirma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFirma(String value) {
        this.fechaFirma = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the origen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Sets the value of the origen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the tipoProceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProceso() {
        return tipoProceso;
    }

    /**
     * Sets the value of the tipoProceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProceso(String value) {
        this.tipoProceso = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the fechaConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * Sets the value of the fechaConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaConsulta(String value) {
        this.fechaConsulta = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the minucia2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinucia2() {
        return minucia2;
    }

    /**
     * Sets the value of the minucia2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinucia2(String value) {
        this.minucia2 = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the minucia7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinucia7() {
        return minucia7;
    }

    /**
     * Sets the value of the minucia7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinucia7(String value) {
        this.minucia7 = StringUtils.isBlank(value) ? null : value;
    }

    /**
     * Gets the value of the curpReferenciaTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpReferenciaTitular() {
        return curpReferenciaTitular;
    }

    /**
     * Sets the value of the curpReferenciaTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpReferenciaTitular(String value) {
        this.curpReferenciaTitular = StringUtils.isBlank(value) ? null : value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarAutenticacionEntrada [cic=");
		builder.append(cic);
		builder.append(", ocr=");
		builder.append(ocr);
		builder.append(", anioRegistro=");
		builder.append(anioRegistro);
		builder.append(", anioEmision=");
		builder.append(anioEmision);
		builder.append(", claveElector=");
		builder.append(claveElector);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", emision=");
		builder.append(emision);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", fechaFirma=");
		builder.append(fechaFirma);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", fechaConsulta=");
		builder.append(fechaConsulta);
		builder.append(", minucia2=");
		builder.append(minucia2);
		builder.append(", minucia7=");
		builder.append(minucia7);
		builder.append(", curpReferenciaTitular=");
		builder.append(curpReferenciaTitular);
		builder.append("]");
		return builder.toString();
	}

}
