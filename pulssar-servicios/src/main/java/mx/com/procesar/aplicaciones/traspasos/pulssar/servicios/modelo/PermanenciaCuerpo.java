package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Clase permanencia
 *
 */
public class PermanenciaCuerpo implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 6241006179043146637L;

	/**
	 * entidad origen
	 */
	private String entidadOrigen;

	/**
	 * curp trabajador
	 */
	private String curpTrabajador;

	/**
	 * nss trabajador
	 */
	private String nssTrabajador;

	/**
	 * rfc
	 */
	private String rfc;

	/**
	 * appeliido paterno
	 */
	private String apellidoPaterno;

	/**
	 * apellido materno
	 */
	private String apellidoMaterno;

	/**
	 * nombre trabajador
	 */
	private String nombreTrabajador;

	/**
	 * fecha nacimiento
	 */
	private Date fechaDeNacimiento;

	/**
	 * genero
	 */
	private Integer genero;

	/**
	 * entidad federativa nacimiento
	 */
	private String entidadFederativaDeNacimiento;

	/**
	 * nacionalidad
	 */
	private String nacionalidad;

	/**
	 * ocpacion o profesion trabajador
	 */
	private String ocupacionOProfesionTrabajador;

	/**
	 * actividad o giro negocio trabajador
	 */
	private String actividadOGiroNegocioTrabajador;

	/**
	 * nivel de estudio trabajador
	 */
	private String nivelDeEstudioTrabajador;

	/**
	 * curp solicitante
	 */
	private String curpSolicitante;

	/**
	 * tipo solicitante
	 */
	private String tipoSolicitante;

	/**
	 * datos particulares
	 */
	private DatosParticulares datosParticulares;

	/**
	 * domicilio laboral
	 */
	private DomicilioLaboral domicilioLaboral;

	/**
	 * referencia
	 */
	private Referencias referencias;

	/**
	 * beneficiarios
	 */
    private Beneficiarios beneficiarios;

	/**
	 * @return the entidadOrigen
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
	 * @return the curpTrabajador
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
	 * @return the nssTrabajador
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
	 * @return the rfc
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
	 * @return the apellidoPaterno
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
	 * @return the apellidoMaterno
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
	 * @return the nombreTrabajador
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
	 * @return the fechaDeNacimiento
	 */
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	/**
	 * @return the genero
	 */
	public Integer getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	/**
	 * @return the entidadFederativaDeNacimiento
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
	 * @return the nacionalidad
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
	 * @return the ocupacionOProfesionTrabajador
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
	 * @return the actividadOGiroNegocioTrabajador
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
	 * @return the nivelDeEstudioTrabajador
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
	 * @return the curpSolicitante
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
	 * @return the tipoSolicitante
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
	 * @return the datosParticulares
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
	 * @return the domicilioLaboral
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
	 * @return the referencias
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
	 * @return the beneficiarios
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
		builder.append("PermanenciaCuerpo [entidadOrigen=");
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
