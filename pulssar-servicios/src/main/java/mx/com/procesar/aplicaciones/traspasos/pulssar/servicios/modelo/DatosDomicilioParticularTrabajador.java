package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DatosDomicilioParticularTrabajador implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.ALWAYS)
	private String calle;
    private String numeroExterior;
    private String numeroInterior;
    
    @JsonInclude(Include.ALWAYS)
    private String colonia;
    
    @JsonInclude(Include.ALWAYS)
    private String delegacionOMunicipio;
    
    @JsonInclude(Include.ALWAYS)
    private String codigoPostal;
    
    @JsonInclude(Include.ALWAYS)
    private String entidadFederativa;
    
    @JsonInclude(Include.ALWAYS)
    private String pais;
    
    @JsonInclude(Include.ALWAYS)
    private String indicadorDeTelefono1;
    
    @JsonInclude(Include.ALWAYS)
    private String telefono1;
    
    private String extension1;
    
    @JsonInclude(Include.ALWAYS)
    private String indicadorDeTelefono2;
    
    @JsonInclude(Include.ALWAYS)
    private String telefono2;
    private String extension2;
    private String correoElectronicoDelTrabajador;  
    private String claveEntidad;
    
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDelegacionOMunicipio() {
		return delegacionOMunicipio;
	}
	public void setDelegacionOMunicipio(String delegacionOMunicipio) {
		this.delegacionOMunicipio = delegacionOMunicipio;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getEntidadFederativa() {
		return entidadFederativa;
	}
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIndicadorDeTelefono1() {
		return indicadorDeTelefono1;
	}
	public void setIndicadorDeTelefono1(String indicadorDeTelefono1) {
		this.indicadorDeTelefono1 = indicadorDeTelefono1;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getExtension1() {
		return extension1;
	}
	public void setExtension1(String extension1) {
		this.extension1 = extension1;
	}
	public String getIndicadorDeTelefono2() {
		return indicadorDeTelefono2;
	}
	public void setIndicadorDeTelefono2(String indicadorDeTelefono2) {
		this.indicadorDeTelefono2 = indicadorDeTelefono2;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getExtension2() {
		return extension2;
	}
	public void setExtension2(String extension2) {
		this.extension2 = extension2;
	}
	public String getCorreoElectronicoDelTrabajador() {
		return correoElectronicoDelTrabajador;
	}
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDomicilioParticularTrabajador [calle=");
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
