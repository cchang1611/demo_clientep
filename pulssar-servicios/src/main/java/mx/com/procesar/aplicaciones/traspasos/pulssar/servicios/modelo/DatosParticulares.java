package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase Datos particulares
 * @author medoming
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DatosParticulares implements Serializable{

    
    /**
	 * Serializacion
	 */
	private static final long serialVersionUID = -8328966914907058258L;
	
	/**
	 * Calle
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
     * Indicador de telefono 1
     */
    private String indicadorDeTelefono1;
    
    /**
     * Telefono 1
     */
    private String telefono1;
    
    /**
     * Extension 1
     */
    private String extension1;
    
    /**
     * Indicador telefono 2
     */
    private String indicadorDeTelefono2;
    
    /**
     * Telefono 2
     */
    private String telefono2;
    
    /**
     * Extension 2
     */
    private String extension2;
    
    /**
     * Correo electronico
     */
    private String correoElectronicoDelTrabajador;
    
    /**
     * Calve entidad
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
	 * @return the indicadorDeTelefono1
	 */
	public String getIndicadorDeTelefono1() {
		return indicadorDeTelefono1;
	}

	/**
	 * @param indicadorDeTelefono1 the indicadorDeTelefono1 to set
	 */
	public void setIndicadorDeTelefono1(String indicadorDeTelefono1) {
		this.indicadorDeTelefono1 = indicadorDeTelefono1;
	}

	/**
	 * @return the telefono1
	 */
	public String getTelefono1() {
		return telefono1;
	}

	/**
	 * @param telefono1 the telefono1 to set
	 */
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	/**
	 * @return the extension1
	 */
	public String getExtension1() {
		return extension1;
	}

	/**
	 * @param extension1 the extension1 to set
	 */
	public void setExtension1(String extension1) {
		this.extension1 = extension1;
	}

	/**
	 * @return the indicadorDeTelefono2
	 */
	public String getIndicadorDeTelefono2() {
		return indicadorDeTelefono2;
	}

	/**
	 * @param indicadorDeTelefono2 the indicadorDeTelefono2 to set
	 */
	public void setIndicadorDeTelefono2(String indicadorDeTelefono2) {
		this.indicadorDeTelefono2 = indicadorDeTelefono2;
	}

	/**
	 * @return the telefono2
	 */
	public String getTelefono2() {
		return telefono2;
	}

	/**
	 * @param telefono2 the telefono2 to set
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	/**
	 * @return the extension2
	 */
	public String getExtension2() {
		return extension2;
	}

	/**
	 * @param extension2 the extension2 to set
	 */
	public void setExtension2(String extension2) {
		this.extension2 = extension2;
	}

	/**
	 * @return the correoElectronicoDelTrabajador
	 */
	public String getCorreoElectronicoDelTrabajador() {
		return correoElectronicoDelTrabajador;
	}

	/**
	 * @param correoElectronicoDelTrabajador the correoElectronicoDelTrabajador to set
	 */
	public void setCorreoElectronicoDelTrabajador(String correoElectronicoDelTrabajador) {
		this.correoElectronicoDelTrabajador = correoElectronicoDelTrabajador;
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
		builder.append("DatosParticulares [calle=");
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
		builder.append(", indicadorDeTelefono1=");
		builder.append(indicadorDeTelefono1);
		builder.append(", telefono1=");
		builder.append(telefono1);
		builder.append(", extension1=");
		builder.append(extension1);
		builder.append(", indicadorDeTelefono2=");
		builder.append(indicadorDeTelefono2);
		builder.append(", telefono2=");
		builder.append(telefono2);
		builder.append(", extension2=");
		builder.append(extension2);
		builder.append(", correoElectronicoDelTrabajador=");
		builder.append(correoElectronicoDelTrabajador);
		builder.append(", claveEntidad=");
		builder.append(claveEntidad);
		builder.append("]");
		return builder.toString();
	}
	
	
	
    
}
