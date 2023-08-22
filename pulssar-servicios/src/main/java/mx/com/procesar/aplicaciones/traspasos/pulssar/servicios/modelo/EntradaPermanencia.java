package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * @author medoming
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EntradaPermanencia implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7489955452187278090L;

	
	/**
	 * entidadOrigen
	 */
	private String entidadOrigen;
    
	/**
	 * curpTrabajador
	 */
	private String curpTrabajador;
	
	/**
	 * nssTrabajador
	 */
	private String nssTrabajador;
	
	/**
	 * rfc
	 */
	private String rfc;
    
	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;
   
	/**
	 * nombreTrabajador
	 */
	private String nombreTrabajador;
   
	/**
	 * fechaDeNacimiento
	 */
	private String fechaDeNacimiento;
    
	/**
	 * genero
	 */
	private BigInteger genero;
   
	/**
	 * entidadFederativaDeNacimiento
	 */
	private String entidadFederativaDeNacimiento;
	
	/**
	 * nacionalidad
	 */
	private String nacionalidad;
	
	/**
	 * ocupacionOProfesionTrabajador
	 */
	private String ocupacionOProfesionTrabajador;
	
	/**
	 * actividadOGiroNegocioTrabajador
	 */
	private String actividadOGiroNegocioTrabajador;
	
	/**
	 * nivelDeEstudioTrabajador
	 */
	private String nivelDeEstudioTrabajador;
	
	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;
    
	/**
	 * tipoSolicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * datosParticulares
	 */
	private DatosParticulares datosParticulares;
	
	/**
	 * domicilioLaboral
	 */
	private DomicilioLaboral domicilioLaboral;
	
	/**
	 * referencias
	 */
	private Referencias referencias;
	
	/**
	 * beneficiarios
	 */
	private Beneficiarios beneficiarios;
	
	/**
	 * @return entidadOrigen
	 */
	public String getEntidadOrigen() {
		return entidadOrigen;
	}
	/**
	 * @param entidadOrigen the entidadOrigen to set
	 */
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}
	
	/**
	 * @return curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}
	
	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}
	
	/**
	 * @return nssTrabajador
	 */
	public String getNssTrabajador() {
		return nssTrabajador;
	}
	
	/**
	 * @param nssTrabajador the nssTrabajador to set
	 */
	public void setNssTrabajador(String nssTrabajador) {
		this.nssTrabajador = nssTrabajador;
	}
	
	/**
	 * @return rfc
	 */
	public String getRfc() {
		return rfc;
	}
	
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	/**
	 * @return apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	/**
	 * @return apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	/**
	 * @return nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}
	
	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	
	/**
	 * @return fechaDeNacimiento
	 */
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	/**
	 * @return genero
	 */
	public BigInteger getGenero() {
		return genero;
	}
	
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(BigInteger genero) {
		this.genero = genero;
	}
	
	/**
	 * @return entidadFederativaDeNacimiento
	 */
	public String getEntidadFederativaDeNacimiento() {
		return entidadFederativaDeNacimiento;
	}
	
	/**
	 * @param entidadFederativaDeNacimiento the entidadFederativaDeNacimiento to set
	 */
	public void setEntidadFederativaDeNacimiento(String entidadFederativaDeNacimiento) {
		this.entidadFederativaDeNacimiento = entidadFederativaDeNacimiento;
	}
	
	/**
	 * @return nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/**
	 * @return ocupacionOProfesionTrabajador
	 */
	public String getOcupacionOProfesionTrabajador() {
		return ocupacionOProfesionTrabajador;
	}
	
	/**
	 * @param ocupacionOProfesionTrabajador the ocupacionOProfesionTrabajador to set
	 */
	public void setOcupacionOProfesionTrabajador(String ocupacionOProfesionTrabajador) {
		this.ocupacionOProfesionTrabajador = ocupacionOProfesionTrabajador;
	}
	
	/**
	 * @return actividadOGiroNegocioTrabajador
	 */
	public String getActividadOGiroNegocioTrabajador() {
		return actividadOGiroNegocioTrabajador;
	}
	
	/**
	 * @param actividadOGiroNegocioTrabajador the actividadOGiroNegocioTrabajador to set
	 */
	public void setActividadOGiroNegocioTrabajador(String actividadOGiroNegocioTrabajador) {
		this.actividadOGiroNegocioTrabajador = actividadOGiroNegocioTrabajador;
	}
	
	/**
	 * @return nivelDeEstudioTrabajador
	 */
	public String getNivelDeEstudioTrabajador() {
		return nivelDeEstudioTrabajador;
	}
	
	/**
	 * @param nivelDeEstudioTrabajador the nivelDeEstudioTrabajador to set
	 */
	public void setNivelDeEstudioTrabajador(String nivelDeEstudioTrabajador) {
		this.nivelDeEstudioTrabajador = nivelDeEstudioTrabajador;
	}
	
	/**
	 * @return curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}
	
	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}
	
	/**
	 * @return tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}
	
	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}
	
	/**
	 * @return datosParticulares
	 */
	public DatosParticulares getDatosParticulares() {
		return datosParticulares;
	}
	
	/**
	 * @param datosParticulares the datosParticulares to set
	 */
	public void setDatosParticulares(DatosParticulares datosParticulares) {
		this.datosParticulares = datosParticulares;
	}
	
	/**
	 * @return domicilioLaboral
	 */
	public DomicilioLaboral getDomicilioLaboral() {
		return domicilioLaboral;
	}
	
	/**
	 * @param domicilioLaboral the domicilioLaboral to set
	 */
	public void setDomicilioLaboral(DomicilioLaboral domicilioLaboral) {
		this.domicilioLaboral = domicilioLaboral;
	}
	
	/**
	 * @return referencias
	 */
	public Referencias getReferencias() {
		return referencias;
	}
	
	/**
	 * @param referencias the referencias to set
	 */
	public void setReferencias(Referencias referencias) {
		this.referencias = referencias;
	}
	
	/**
	 * @return beneficiarios
	 */
	public Beneficiarios getBeneficiarios() {
		return beneficiarios;
	}
	
	/**
	 * @param beneficiarios the beneficiarios to set
	 */
	public void setBeneficiarios(Beneficiarios beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaPermanencia [entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", nssTrabajador=");
		builder.append(nssTrabajador);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", fechaDeNacimiento=");
		builder.append(fechaDeNacimiento);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", entidadFederativaDeNacimiento=");
		builder.append(entidadFederativaDeNacimiento);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", ocupacionOProfesionTrabajador=");
		builder.append(ocupacionOProfesionTrabajador);
		builder.append(", actividadOGiroNegocioTrabajador=");
		builder.append(actividadOGiroNegocioTrabajador);
		builder.append(", nivelDeEstudioTrabajador=");
		builder.append(nivelDeEstudioTrabajador);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", datosParticulares=");
		builder.append(datosParticulares);
		builder.append(", domicilioLaboral=");
		builder.append(domicilioLaboral);
		builder.append(", referencias=");
		builder.append(referencias);
		builder.append(", beneficiarios=");
		builder.append(beneficiarios);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
