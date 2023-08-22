package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigInteger;

public class EntradaNotificacionPermanencia implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5970921155358225697L;

	/**
	 * afore
	 */
	private String afore;
	
	/**
	 * folioCliente
	 */
	private String folioCliente;
	
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
	 * respuestaServicio
	 */
	private DatosSalidaPermanencia respuestaServicio;
	
	/**
	 * folio origen de servicio
	 */
	private String folioOrigen;

	public EntradaNotificacionPermanencia() {
		super();
	}

	public String getAfore() {
		return afore;
	}

	public void setAfore(String afore) {
		this.afore = afore;
	}

	public String getFolioCliente() {
		return folioCliente;
	}

	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	public String getEntidadOrigen() {
		return entidadOrigen;
	}

	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}

	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	public String getNssTrabajador() {
		return nssTrabajador;
	}

	public void setNssTrabajador(String nssTrabajador) {
		this.nssTrabajador = nssTrabajador;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public BigInteger getGenero() {
		return genero;
	}

	public void setGenero(BigInteger genero) {
		this.genero = genero;
	}

	public String getEntidadFederativaDeNacimiento() {
		return entidadFederativaDeNacimiento;
	}

	public void setEntidadFederativaDeNacimiento(String entidadFederativaDeNacimiento) {
		this.entidadFederativaDeNacimiento = entidadFederativaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getOcupacionOProfesionTrabajador() {
		return ocupacionOProfesionTrabajador;
	}

	public void setOcupacionOProfesionTrabajador(String ocupacionOProfesionTrabajador) {
		this.ocupacionOProfesionTrabajador = ocupacionOProfesionTrabajador;
	}

	public String getActividadOGiroNegocioTrabajador() {
		return actividadOGiroNegocioTrabajador;
	}

	public void setActividadOGiroNegocioTrabajador(String actividadOGiroNegocioTrabajador) {
		this.actividadOGiroNegocioTrabajador = actividadOGiroNegocioTrabajador;
	}

	public String getNivelDeEstudioTrabajador() {
		return nivelDeEstudioTrabajador;
	}

	public void setNivelDeEstudioTrabajador(String nivelDeEstudioTrabajador) {
		this.nivelDeEstudioTrabajador = nivelDeEstudioTrabajador;
	}

	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public DatosParticulares getDatosParticulares() {
		return datosParticulares;
	}

	public void setDatosParticulares(DatosParticulares datosParticulares) {
		this.datosParticulares = datosParticulares;
	}

	public DomicilioLaboral getDomicilioLaboral() {
		return domicilioLaboral;
	}

	public void setDomicilioLaboral(DomicilioLaboral domicilioLaboral) {
		this.domicilioLaboral = domicilioLaboral;
	}

	public Referencias getReferencias() {
		return referencias;
	}

	public void setReferencias(Referencias referencias) {
		this.referencias = referencias;
	}

	public Beneficiarios getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Beneficiarios beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public DatosSalidaPermanencia getRespuestaServicio() {
		return respuestaServicio;
	}

	public void setRespuestaServicio(DatosSalidaPermanencia respuestaServicio) {
		this.respuestaServicio = respuestaServicio;
	}

	/**
	 * @return the folioOrigen
	 */
	public String getFolioOrigen() {
		return folioOrigen;
	}

	/**
	 * @param folioOrigen the folioOrigen to set
	 */
	public void setFolioOrigen(String folioOrigen) {
		this.folioOrigen = folioOrigen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaNotificacionPermanencia [afore=");
		builder.append(afore);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", entidadOrigen=");
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
		builder.append(", respuestaServicio=");
		builder.append(respuestaServicio);
		builder.append(", folioOrigen=");
		builder.append(folioOrigen);
		builder.append("]");
		return builder.toString();
	}

	
	
}
