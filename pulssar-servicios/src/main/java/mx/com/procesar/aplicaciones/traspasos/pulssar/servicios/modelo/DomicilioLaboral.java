package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Domicilio laboral
 * @author medoming
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DomicilioLaboral implements Serializable{

    
    /**
	 * Serializacion
	 */
	private static final long serialVersionUID = 4506828309314123352L;
	
	/**
	 * calle
	 */
	private String calle;
	
	/**
	 * Numero exterior
	 */
	private String numeroExterior;
	
	/**
	 * Numero interior
	 */
	private String numeroInterior;
	
	/**
	 * Colonia
	 */
	private String colonia;
	
	/**
	 * Delegacion o municipio
	 */
	private String delegacionOMunicipio;
	
	/**
	 * Codigo postal
	 */
	private String codigoPostal;
	
	/**
	 * Entidad federativa
	 */
	private String entidadFederativa;
	
	/**
	 * Pais
	 */
	private String pais;

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}

	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	/**
	 * @return the numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}

	/**
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the delegacionOMunicipio
	 */
	public String getDelegacionOMunicipio() {
		return delegacionOMunicipio;
	}

	/**
	 * @param delegacionOMunicipio the delegacionOMunicipio to set
	 */
	public void setDelegacionOMunicipio(String delegacionOMunicipio) {
		this.delegacionOMunicipio = delegacionOMunicipio;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DomicilioLaboral [calle=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
}
