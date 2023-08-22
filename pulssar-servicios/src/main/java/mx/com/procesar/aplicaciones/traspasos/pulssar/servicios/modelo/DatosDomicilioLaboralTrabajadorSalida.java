package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.HashMap;
import java.util.List;

public class DatosDomicilioLaboralTrabajadorSalida {

    protected String calle;
    protected String numeroExterior;
    protected String numeroInterior;
    protected String colonia;
    protected String delegacionOMunicipio;
    protected String codigoPostal;
    protected String entidadFederativa;
    protected String pais;
    protected String resultadoDeLaOperacion;
    protected String diagnosticoDeRecepcion;
    protected List<HashMap<String,String>> listaDiagnosticos;

    /**
     * 
     * @return the listaDiagnosticos
     */
    public List<HashMap<String, String>> getListaDiagnosticos() {
		return listaDiagnosticos;
	}

    /**
     * 
     * @param listaDiagnosticos the listaDiagnosticos to set
     */
	public void setListaDiagnosticos(List<HashMap<String, String>> listaDiagnosticos) {
		this.listaDiagnosticos = listaDiagnosticos;
	}

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Gets the value of the numeroExterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Sets the value of the numeroExterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroExterior(String value) {
        this.numeroExterior = value;
    }

    /**
     * Gets the value of the numeroInterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroInterior() {
        return numeroInterior;
    }

    /**
     * Sets the value of the numeroInterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroInterior(String value) {
        this.numeroInterior = value;
    }

    /**
     * Gets the value of the colonia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Sets the value of the colonia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColonia(String value) {
        this.colonia = value;
    }

    /**
     * Gets the value of the delegacionOMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegacionOMunicipio() {
        return delegacionOMunicipio;
    }

    /**
     * Sets the value of the delegacionOMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegacionOMunicipio(String value) {
        this.delegacionOMunicipio = value;
    }

    /**
     * Gets the value of the codigoPostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Sets the value of the codigoPostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPostal(String value) {
        this.codigoPostal = value;
    }

    /**
     * Gets the value of the entidadFederativa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    /**
     * Sets the value of the entidadFederativa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidadFederativa(String value) {
        this.entidadFederativa = value;
    }

    /**
     * Gets the value of the pais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Sets the value of the pais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Gets the value of the resultadoDeLaOperacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultadoDeLaOperacion() {
        return resultadoDeLaOperacion;
    }

    /**
     * Sets the value of the resultadoDeLaOperacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultadoDeLaOperacion(String value) {
        this.resultadoDeLaOperacion = value;
    }

    /**
     * Gets the value of the diagnosticoDeRecepcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosticoDeRecepcion() {
        return diagnosticoDeRecepcion;
    }

    /**
     * Sets the value of the diagnosticoDeRecepcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosticoDeRecepcion(String value) {
        this.diagnosticoDeRecepcion = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDomicilioLaboralTrabajadorSalida [calle=");
		builder.append(calle);
		builder.append(", numeroExterior=");
		builder.append(numeroExterior);
		builder.append(", numeroInterior=");
		builder.append(numeroInterior);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", delegacionOMunicipio=");
		builder.append(delegacionOMunicipio);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", pais=");
		builder.append(pais);
		builder.append(", resultadoDeLaOperacion=");
		builder.append(resultadoDeLaOperacion);
		builder.append(", diagnosticoDeRecepcion=");
		builder.append(diagnosticoDeRecepcion);
		builder.append(", listaDiagnosticos=");
		builder.append(listaDiagnosticos);
		builder.append("]");
		return builder.toString();
	}
    
    

}
