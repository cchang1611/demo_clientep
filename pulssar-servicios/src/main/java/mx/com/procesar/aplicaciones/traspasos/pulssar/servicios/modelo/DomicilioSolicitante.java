package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DomicilioSolicitante implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -9123912729498370087L;

	/**
	 * calle
	 */
	private String calle;
	
	/**
	 * numero exterior
	 */
	private String numeroExterior;
	
	/**
	 * numero interior
	 */
	private String numeroInterior;
	
	/**
	 * colonia
	 */
	private String colonia;
	
	/**
	 * delegacion o municipio
	 */
	private String delegacionOMunicipio;
	
	/**
	 * codigo postal
	 */
	private String codigoPostal;
	
	/**
	 * entidad federativa
	 */
	private String entidadFederativa;
	
	/**
	 * pais
	 */
	private String pais;
	
	/**
	 * clave entidad
	 */
    private String claveEntidad;

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

	/**
	 * @return the claveEntidad
	 */
	public String getClaveEntidad() {
		return claveEntidad;
	}

	/**
	 * @param claveEntidad the claveEntidad to set
	 */
	public void setClaveEntidad(String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DomicilioSolicitante [calle=");
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
		builder.append(", claveEntidad=");
		builder.append(claveEntidad);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
