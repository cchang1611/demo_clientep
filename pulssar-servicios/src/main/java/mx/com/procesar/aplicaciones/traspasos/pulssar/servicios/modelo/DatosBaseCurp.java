package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DatosBaseCurp implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String curpNueva;
	private String rfc;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String apellidoPaterno;
	private String apellidoMaterno;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String nombreTrabajador;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String fechaDeNacimiento;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String sexo;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String entidadFederativaDeNacimiento;
	private String nacionalidad;
	private String claveDeTipoDeDocumentoProbatorio;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String folioDeLaSolicitud;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String documentoProbatorio;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String folioDeDocumentoProbatorio;
	private String ocupacionOProfesionTrabajador;
	private String actividadOGiroNegocioTrabajador;
	private String nivelDeEstudioTrabajador;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String flujoDeValidacion;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String selloVerificacionBiometrica;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String selloVoluntadTramite;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String indicadorDeDuplicidad;//
	
	private String indicadorEnrolamiento;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String indicadorDeServicioBiometrico;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String curpSolicitante;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String tipoSolicitante;//
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
    private String movimientoBeneficiario;

	/**
	 * @return the curpNueva
	 */
	public String getCurpNueva() {
		return curpNueva;
	}

	/**
	 * @param curpNueva the curpNueva to set
	 */
	public void setCurpNueva(String curpNueva) {
		this.curpNueva = curpNueva;
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
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	 * @return the claveDeTipoDeDocumentoProbatorio
	 */
	public String getClaveDeTipoDeDocumentoProbatorio() {
		return claveDeTipoDeDocumentoProbatorio;
	}

	/**
	 * @param claveDeTipoDeDocumentoProbatorio the claveDeTipoDeDocumentoProbatorio to set
	 */
	public void setClaveDeTipoDeDocumentoProbatorio(String claveDeTipoDeDocumentoProbatorio) {
		this.claveDeTipoDeDocumentoProbatorio = claveDeTipoDeDocumentoProbatorio;
	}

	/**
	 * @return the folioDeLaSolicitud
	 */
	public String getFolioDeLaSolicitud() {
		return folioDeLaSolicitud;
	}

	/**
	 * @param folioDeLaSolicitud the folioDeLaSolicitud to set
	 */
	public void setFolioDeLaSolicitud(String folioDeLaSolicitud) {
		this.folioDeLaSolicitud = folioDeLaSolicitud;
	}

	/**
	 * @return the documentoProbatorio
	 */
	public String getDocumentoProbatorio() {
		return documentoProbatorio;
	}

	/**
	 * @param documentoProbatorio the documentoProbatorio to set
	 */
	public void setDocumentoProbatorio(String documentoProbatorio) {
		this.documentoProbatorio = documentoProbatorio;
	}

	/**
	 * @return the folioDeDocumentoProbatorio
	 */
	public String getFolioDeDocumentoProbatorio() {
		return folioDeDocumentoProbatorio;
	}

	/**
	 * @param folioDeDocumentoProbatorio the folioDeDocumentoProbatorio to set
	 */
	public void setFolioDeDocumentoProbatorio(String folioDeDocumentoProbatorio) {
		this.folioDeDocumentoProbatorio = folioDeDocumentoProbatorio;
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
	 * @return the flujoDeValidacion
	 */
	public String getFlujoDeValidacion() {
		return flujoDeValidacion;
	}

	/**
	 * @param flujoDeValidacion the flujoDeValidacion to set
	 */
	public void setFlujoDeValidacion(String flujoDeValidacion) {
		this.flujoDeValidacion = flujoDeValidacion;
	}

	/**
	 * @return the selloVerificacionBiometrica
	 */
	public String getSelloVerificacionBiometrica() {
		return selloVerificacionBiometrica;
	}

	/**
	 * @param selloVerificacionBiometrica the selloVerificacionBiometrica to set
	 */
	public void setSelloVerificacionBiometrica(String selloVerificacionBiometrica) {
		this.selloVerificacionBiometrica = selloVerificacionBiometrica;
	}

	/**
	 * @return the selloVoluntadTramite
	 */
	public String getSelloVoluntadTramite() {
		return selloVoluntadTramite;
	}

	/**
	 * @param selloVoluntadTramite the selloVoluntadTramite to set
	 */
	public void setSelloVoluntadTramite(String selloVoluntadTramite) {
		this.selloVoluntadTramite = selloVoluntadTramite;
	}

	/**
	 * @return the indicadorDeDuplicidad
	 */
	public String getIndicadorDeDuplicidad() {
		return indicadorDeDuplicidad;
	}

	/**
	 * @param indicadorDeDuplicidad the indicadorDeDuplicidad to set
	 */
	public void setIndicadorDeDuplicidad(String indicadorDeDuplicidad) {
		this.indicadorDeDuplicidad = indicadorDeDuplicidad;
	}

	/**
	 * @return the indicadorEnrolamiento
	 */
	public String getIndicadorEnrolamiento() {
		return indicadorEnrolamiento;
	}

	/**
	 * @param indicadorEnrolamiento the indicadorEnrolamiento to set
	 */
	public void setIndicadorEnrolamiento(String indicadorEnrolamiento) {
		this.indicadorEnrolamiento = indicadorEnrolamiento;
	}

	/**
	 * @return the indicadorDeServicioBiometrico
	 */
	public String getIndicadorDeServicioBiometrico() {
		return indicadorDeServicioBiometrico;
	}

	/**
	 * @param indicadorDeServicioBiometrico the indicadorDeServicioBiometrico to set
	 */
	public void setIndicadorDeServicioBiometrico(String indicadorDeServicioBiometrico) {
		this.indicadorDeServicioBiometrico = indicadorDeServicioBiometrico;
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
	 * @return the movimientoBeneficiario
	 */
	public String getMovimientoBeneficiario() {
		return movimientoBeneficiario;
	}

	/**
	 * @param movimientoBeneficiario the movimientoBeneficiario to set
	 */
	public void setMovimientoBeneficiario(String movimientoBeneficiario) {
		this.movimientoBeneficiario = movimientoBeneficiario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBaseCurp [curpNueva=");
		builder.append(curpNueva);
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
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", entidadFederativaDeNacimiento=");
		builder.append(entidadFederativaDeNacimiento);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", claveDeTipoDeDocumentoProbatorio=");
		builder.append(claveDeTipoDeDocumentoProbatorio);
		builder.append(", folioDeLaSolicitud=");
		builder.append(folioDeLaSolicitud);
		builder.append(", documentoProbatorio=");
		builder.append(documentoProbatorio);
		builder.append(", folioDeDocumentoProbatorio=");
		builder.append(folioDeDocumentoProbatorio);
		builder.append(", ocupacionOProfesionTrabajador=");
		builder.append(ocupacionOProfesionTrabajador);
		builder.append(", actividadOGiroNegocioTrabajador=");
		builder.append(actividadOGiroNegocioTrabajador);
		builder.append(", nivelDeEstudioTrabajador=");
		builder.append(nivelDeEstudioTrabajador);
		builder.append(", flujoDeValidacion=");
		builder.append(flujoDeValidacion);
		builder.append(", selloVerificacionBiometrica=");
		builder.append(selloVerificacionBiometrica);
		builder.append(", selloVoluntadTramite=");
		builder.append(selloVoluntadTramite);
		builder.append(", indicadorDeDuplicidad=");
		builder.append(indicadorDeDuplicidad);
		builder.append(", indicadorEnrolamiento=");
		builder.append(indicadorEnrolamiento);
		builder.append(", indicadorDeServicioBiometrico=");
		builder.append(indicadorDeServicioBiometrico);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", movimientoBeneficiario=");
		builder.append(movimientoBeneficiario);
		builder.append("]");
		return builder.toString();
	}
	
	

	
	
	

	
}
