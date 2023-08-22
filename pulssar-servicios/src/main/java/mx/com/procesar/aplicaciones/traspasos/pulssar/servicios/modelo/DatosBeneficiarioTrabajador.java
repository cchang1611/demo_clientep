package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DatosBeneficiarioTrabajador implements Serializable{

    
    /**
	 * Serializacion
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Apellido paterno
	 */
	private String apellidoPaternoDeBeneficiario;
	
	/**
	 * Apellido Materno
	 */
	private String apellidoMaternoDeBeneficiario;
	
	/**
	 * Nombre
	 */
	private String nombreDeBeneficiario;
	
	/**
	 * Curp
	 */
	private String curpDeBeneficiario;
	
	/**
	 * Parentesco
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String parentescoORelacion;
	
	/**
	 * Porcentaje
	 */
	private String porcentajeDeBeneficiario;

    /**
     * Gets the value of the apellidoPaternoDeBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaternoDeBeneficiario() {
        return apellidoPaternoDeBeneficiario;
    }

    /**
     * Sets the value of the apellidoPaternoDeBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaternoDeBeneficiario(String value) {
        this.apellidoPaternoDeBeneficiario = value;
    }

    /**
     * Gets the value of the apellidoMaternoDeBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaternoDeBeneficiario() {
        return apellidoMaternoDeBeneficiario;
    }

    /**
     * Sets the value of the apellidoMaternoDeBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaternoDeBeneficiario(String value) {
        this.apellidoMaternoDeBeneficiario = value;
    }

    /**
     * Gets the value of the nombreDeBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDeBeneficiario() {
        return nombreDeBeneficiario;
    }

    /**
     * Sets the value of the nombreDeBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDeBeneficiario(String value) {
        this.nombreDeBeneficiario = value;
    }

    /**
     * Gets the value of the curpDeBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpDeBeneficiario() {
        return curpDeBeneficiario;
    }

    /**
     * Sets the value of the curpDeBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpDeBeneficiario(String value) {
        this.curpDeBeneficiario = value;
    }

    /**
     * Gets the value of the parentescoORelacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentescoORelacion() {
        return parentescoORelacion;
    }

    /**
     * Sets the value of the parentescoORelacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentescoORelacion(String value) {
        this.parentescoORelacion = value;
    }

    /**
     * Gets the value of the porcentajeDeBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPorcentajeDeBeneficiario() {
        return porcentajeDeBeneficiario;
    }

    /**
     * Sets the value of the porcentajeDeBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPorcentajeDeBeneficiario(String value) {
        this.porcentajeDeBeneficiario = value;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBeneficiarioTrabajador [apellidoPaternoDeBeneficiario=");
		builder.append(apellidoPaternoDeBeneficiario);
		builder.append(", apellidoMaternoDeBeneficiario=");
		builder.append(apellidoMaternoDeBeneficiario);
		builder.append(", nombreDeBeneficiario=");
		builder.append(nombreDeBeneficiario);
		builder.append(", curpDeBeneficiario=");
		builder.append(curpDeBeneficiario);
		builder.append(", parentescoORelacion=");
		builder.append(parentescoORelacion);
		builder.append(", porcentajeDeBeneficiario=");
		builder.append(porcentajeDeBeneficiario);
		builder.append("]");
		return builder.toString();
	}
}
