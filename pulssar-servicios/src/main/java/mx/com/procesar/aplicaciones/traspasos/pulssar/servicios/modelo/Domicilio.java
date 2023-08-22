package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class Domicilio implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3247864687660958859L;

	/**
	 * Calle
	 */
	private String calle;
	
	/**
	 * Numero Exterior 
	 */
	private String noExterior;
	
	/**
	 * Numero Interior 
	 */
	private String noInterior;
	
	/**
	 * Colonia 
	 */
	private String colonia;
	
	/**
	 * clave municipio
	 */
	private String claveMunicipio;
	
	/**
	 * Municipio 
	 */
	private String municipio;
	
	/**
	 * Codigo Postal 
	 */
	private String codigoPostal;
	
	/**
	 * clave corta entidad federativa
	 */
	private String claveEntidadFed;
	
	/**
	 * Entidad Federativa 
	 */
	private String entidadFederativa;
	
	/**
	 * clave pais
	 */
	private String clavePais;
	
	/**
	 * Pais 
	 */
	private String pais;
	
	/**
	 * fechacontrol
	 */
	private String fechaControl;

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
	 * @return the noExterior
	 */
	public String getNoExterior() {
		return noExterior;
	}

	/**
	 * @param noExterior the noExterior to set
	 */
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}

	/**
	 * @return the noInterior
	 */
	public String getNoInterior() {
		return noInterior;
	}

	/**
	 * @param noInterior the noInterior to set
	 */
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
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
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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
	 * @return the claveEntidadFed
	 */
	public String getClaveEntidadFed() {
		return claveEntidadFed;
	}

	/**
	 * @param claveEntidadFed the claveEntidadFed to set
	 */
	public void setClaveEntidadFed(String claveEntidadFed) {
		this.claveEntidadFed = claveEntidadFed;
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
	 * @return the claveMunicipio
	 */
	public String getClaveMunicipio() {
		return claveMunicipio;
	}

	/**
	 * @param claveMunicipio the claveMunicipio to set
	 */
	public void setClaveMunicipio(String claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	/**
	 * @return the clavePais
	 */
	public String getClavePais() {
		return clavePais;
	}

	/**
	 * @param clavePais the clavePais to set
	 */
	public void setClavePais(String clavePais) {
		this.clavePais = clavePais;
	}

	
	/**
	 * @return the fechacontrol
	 */
	public String getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechacontrol the fechacontrol to set
	 */
	public void setFechacontrol(String fechaControl) {
		this.fechaControl = fechaControl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Domicilio [calle=");
		builder.append(calle);
		builder.append(", noExterior=");
		builder.append(noExterior);
		builder.append(", noInterior=");
		builder.append(noInterior);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", claveMunicipio=");
		builder.append(claveMunicipio);
		builder.append(", municipio=");
		builder.append(municipio);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", claveEntidadFed=");
		builder.append(claveEntidadFed);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", clavePais=");
		builder.append(clavePais);
		builder.append(", pais=");
		builder.append(pais);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}

	
}