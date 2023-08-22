package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class DatosBaseCurpSalida {

    protected String curpOficial;
    protected String curpNueva;
    protected String rfc;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombreTrabajador;
    protected String nombreEnFormatoImss;
    protected String nombreEnProcanase;
    protected String fechaDeNacimiento;
    protected String sexo;
    protected String entidadFederativaDeNacimiento;
    protected String nacionalidad;
    protected String folioDeLaSolicitud;
    protected String claveDeTipoDeDocumentoProbatorio;
    protected String documentoProbatorio;
    protected String folioDeDocumentoProbatorio;
    protected String ocupacionOProfesionTrabajador;
    protected String actividadOGiroNegocioTrabajador;
    protected String nivelDeEstudioTrabajador;
    protected String flujoDeValidacion;
    protected String selloVerificacionBiometrica;
    protected String selloVoluntadTramite;
    protected String indicadorDeDuplicidad;
    protected String indicadorEnrolamiento;
    protected String indicadorDeServicioBiometrico;
    protected String curpSolicitante;
    protected String tipoSolicitante;
    protected String movimientoBeneficiario;
    protected BigInteger claveDeAgentePromotor;
    protected String fechaDePrimerRegistro;
    protected String fechaAltaEnAforeActual;
    protected String claveDeAforeDeRegistro;
    protected String claveDeAforeConNssAsociado;
    protected String identificadorDeTipoDeTrabajador;
    protected String nssAsociado;
    protected String indicadorDeCreditoInfonavit;
    protected BigInteger periodoDePago;
    protected BigInteger salarioDiarioIntegrado;
    protected String numeroFolioEdoCta;
    protected String expedienteCompleto;
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
     * Gets the value of the curpOficial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpOficial() {
        return curpOficial;
    }

    /**
     * Sets the value of the curpOficial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpOficial(String value) {
        this.curpOficial = value;
    }

    /**
     * Gets the value of the curpNueva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpNueva() {
        return curpNueva;
    }

    /**
     * Sets the value of the curpNueva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpNueva(String value) {
        this.curpNueva = value;
    }

    /**
     * Gets the value of the rfc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the apellidoPaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Sets the value of the apellidoPaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Gets the value of the apellidoMaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Sets the value of the apellidoMaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Gets the value of the nombreTrabajador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    /**
     * Sets the value of the nombreTrabajador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTrabajador(String value) {
        this.nombreTrabajador = value;
    }

    /**
     * Gets the value of the nombreEnFormatoImss property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEnFormatoImss() {
        return nombreEnFormatoImss;
    }

    /**
     * Sets the value of the nombreEnFormatoImss property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEnFormatoImss(String value) {
        this.nombreEnFormatoImss = value;
    }

    /**
     * Gets the value of the nombreEnProcanase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEnProcanase() {
        return nombreEnProcanase;
    }

    /**
     * Sets the value of the nombreEnProcanase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEnProcanase(String value) {
        this.nombreEnProcanase = value;
    }

    /**
     * Gets the value of the fechaDeNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * Sets the value of the fechaDeNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDeNacimiento(String value) {
        this.fechaDeNacimiento = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Gets the value of the entidadFederativaDeNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidadFederativaDeNacimiento() {
        return entidadFederativaDeNacimiento;
    }

    /**
     * Sets the value of the entidadFederativaDeNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidadFederativaDeNacimiento(String value) {
        this.entidadFederativaDeNacimiento = value;
    }

    /**
     * Gets the value of the nacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Sets the value of the nacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Gets the value of the folioDeLaSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolioDeLaSolicitud() {
        return folioDeLaSolicitud;
    }

    /**
     * Sets the value of the folioDeLaSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolioDeLaSolicitud(String value) {
        this.folioDeLaSolicitud = value;
    }

    /**
     * Gets the value of the claveDeTipoDeDocumentoProbatorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveDeTipoDeDocumentoProbatorio() {
        return claveDeTipoDeDocumentoProbatorio;
    }

    /**
     * Sets the value of the claveDeTipoDeDocumentoProbatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveDeTipoDeDocumentoProbatorio(String value) {
        this.claveDeTipoDeDocumentoProbatorio = value;
    }

    /**
     * Gets the value of the documentoProbatorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoProbatorio() {
        return documentoProbatorio;
    }

    /**
     * Sets the value of the documentoProbatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoProbatorio(String value) {
        this.documentoProbatorio = value;
    }

    /**
     * Gets the value of the folioDeDocumentoProbatorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolioDeDocumentoProbatorio() {
        return folioDeDocumentoProbatorio;
    }

    /**
     * Sets the value of the folioDeDocumentoProbatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolioDeDocumentoProbatorio(String value) {
        this.folioDeDocumentoProbatorio = value;
    }

    /**
     * Gets the value of the ocupacionOProfesionTrabajador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcupacionOProfesionTrabajador() {
        return ocupacionOProfesionTrabajador;
    }

    /**
     * Sets the value of the ocupacionOProfesionTrabajador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcupacionOProfesionTrabajador(String value) {
        this.ocupacionOProfesionTrabajador = value;
    }

    /**
     * Gets the value of the actividadOGiroNegocioTrabajador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividadOGiroNegocioTrabajador() {
        return actividadOGiroNegocioTrabajador;
    }

    /**
     * Sets the value of the actividadOGiroNegocioTrabajador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividadOGiroNegocioTrabajador(String value) {
        this.actividadOGiroNegocioTrabajador = value;
    }

    /**
     * Gets the value of the nivelDeEstudioTrabajador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivelDeEstudioTrabajador() {
        return nivelDeEstudioTrabajador;
    }

    /**
     * Sets the value of the nivelDeEstudioTrabajador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivelDeEstudioTrabajador(String value) {
        this.nivelDeEstudioTrabajador = value;
    }

    /**
     * Gets the value of the flujoDeValidacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlujoDeValidacion() {
        return flujoDeValidacion;
    }

    /**
     * Sets the value of the flujoDeValidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlujoDeValidacion(String value) {
        this.flujoDeValidacion = value;
    }

    /**
     * Gets the value of the selloVerificacionBiometrica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloVerificacionBiometrica() {
        return selloVerificacionBiometrica;
    }

    /**
     * Sets the value of the selloVerificacionBiometrica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloVerificacionBiometrica(String value) {
        this.selloVerificacionBiometrica = value;
    }

    /**
     * Gets the value of the selloVoluntadTramite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloVoluntadTramite() {
        return selloVoluntadTramite;
    }

    /**
     * Sets the value of the selloVoluntadTramite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloVoluntadTramite(String value) {
        this.selloVoluntadTramite = value;
    }

    /**
     * Gets the value of the indicadorDeDuplicidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorDeDuplicidad() {
        return indicadorDeDuplicidad;
    }

    /**
     * Sets the value of the indicadorDeDuplicidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorDeDuplicidad(String value) {
        this.indicadorDeDuplicidad = value;
    }

    /**
     * Gets the value of the indicadorDeServicioBiometrico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorDeServicioBiometrico() {
        return indicadorDeServicioBiometrico;
    }

    /**
     * Sets the value of the indicadorDeServicioBiometrico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorDeServicioBiometrico(String value) {
        this.indicadorDeServicioBiometrico = value;
    }

    /**
     * Gets the value of the curpSolicitante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpSolicitante() {
        return curpSolicitante;
    }

    /**
     * Sets the value of the curpSolicitante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpSolicitante(String value) {
        this.curpSolicitante = value;
    }

    /**
     * Gets the value of the tipoSolicitante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSolicitante() {
        return tipoSolicitante;
    }

    /**
     * Sets the value of the tipoSolicitante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSolicitante(String value) {
        this.tipoSolicitante = value;
    }

    /**
     * Gets the value of the claveDeAgentePromotor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClaveDeAgentePromotor() {
        return claveDeAgentePromotor;
    }

    /**
     * Sets the value of the claveDeAgentePromotor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClaveDeAgentePromotor(BigInteger value) {
        this.claveDeAgentePromotor = value;
    }

    /**
     * Gets the value of the fechaDePrimerRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDePrimerRegistro() {
        return fechaDePrimerRegistro;
    }

    /**
     * Sets the value of the fechaDePrimerRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDePrimerRegistro(String value) {
        this.fechaDePrimerRegistro = value;
    }

    /**
     * Gets the value of the fechaAltaEnAforeActual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAltaEnAforeActual() {
        return fechaAltaEnAforeActual;
    }

    /**
     * Sets the value of the fechaAltaEnAforeActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAltaEnAforeActual(String value) {
        this.fechaAltaEnAforeActual = value;
    }

    /**
     * Gets the value of the claveDeAforeDeRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveDeAforeDeRegistro() {
        return claveDeAforeDeRegistro;
    }

    /**
     * Sets the value of the claveDeAforeDeRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveDeAforeDeRegistro(String value) {
        this.claveDeAforeDeRegistro = value;
    }

    /**
     * Gets the value of the claveDeAforeConNssAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveDeAforeConNssAsociado() {
        return claveDeAforeConNssAsociado;
    }

    /**
     * Sets the value of the claveDeAforeConNssAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveDeAforeConNssAsociado(String value) {
        this.claveDeAforeConNssAsociado = value;
    }

    /**
     * Gets the value of the identificadorDeTipoDeTrabajador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorDeTipoDeTrabajador() {
        return identificadorDeTipoDeTrabajador;
    }

    /**
     * Sets the value of the identificadorDeTipoDeTrabajador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorDeTipoDeTrabajador(String value) {
        this.identificadorDeTipoDeTrabajador = value;
    }

    /**
     * Gets the value of the nssAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNssAsociado() {
        return nssAsociado;
    }

    /**
     * Sets the value of the nssAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNssAsociado(String value) {
        this.nssAsociado = value;
    }

    /**
     * Gets the value of the indicadorDeCreditoInfonavit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorDeCreditoInfonavit() {
        return indicadorDeCreditoInfonavit;
    }

    /**
     * Sets the value of the indicadorDeCreditoInfonavit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorDeCreditoInfonavit(String value) {
        this.indicadorDeCreditoInfonavit = value;
    }

    /**
     * Gets the value of the periodoDePago property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodoDePago() {
        return periodoDePago;
    }

    /**
     * Sets the value of the periodoDePago property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodoDePago(BigInteger value) {
        this.periodoDePago = value;
    }

    /**
     * Gets the value of the salarioDiarioIntegrado property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSalarioDiarioIntegrado() {
        return salarioDiarioIntegrado;
    }

    /**
     * Sets the value of the salarioDiarioIntegrado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSalarioDiarioIntegrado(BigInteger value) {
        this.salarioDiarioIntegrado = value;
    }

    /**
     * Gets the value of the numeroFolioEdoCta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFolioEdoCta() {
        return numeroFolioEdoCta;
    }

    /**
     * Sets the value of the numeroFolioEdoCta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFolioEdoCta(String value) {
        this.numeroFolioEdoCta = value;
    }

    /**
     * Gets the value of the expedienteCompleto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpedienteCompleto() {
        return expedienteCompleto;
    }

    /**
     * Sets the value of the expedienteCompleto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpedienteCompleto(String value) {
        this.expedienteCompleto = value;
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
		builder.append("DatosBaseCurpSalida [curpOficial=");
		builder.append(curpOficial);
		builder.append(", curpNueva=");
		builder.append(curpNueva);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", nombreEnFormatoImss=");
		builder.append(nombreEnFormatoImss);
		builder.append(", nombreEnProcanase=");
		builder.append(nombreEnProcanase);
		builder.append(", fechaDeNacimiento=");
		builder.append(fechaDeNacimiento);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", entidadFederativaDeNacimiento=");
		builder.append(entidadFederativaDeNacimiento);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", folioDeLaSolicitud=");
		builder.append(folioDeLaSolicitud);
		builder.append(", claveDeTipoDeDocumentoProbatorio=");
		builder.append(claveDeTipoDeDocumentoProbatorio);
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
		builder.append(", claveDeAgentePromotor=");
		builder.append(claveDeAgentePromotor);
		builder.append(", fechaDePrimerRegistro=");
		builder.append(fechaDePrimerRegistro);
		builder.append(", fechaAltaEnAforeActual=");
		builder.append(fechaAltaEnAforeActual);
		builder.append(", claveDeAforeDeRegistro=");
		builder.append(claveDeAforeDeRegistro);
		builder.append(", claveDeAforeConNssAsociado=");
		builder.append(claveDeAforeConNssAsociado);
		builder.append(", identificadorDeTipoDeTrabajador=");
		builder.append(identificadorDeTipoDeTrabajador);
		builder.append(", nssAsociado=");
		builder.append(nssAsociado);
		builder.append(", indicadorDeCreditoInfonavit=");
		builder.append(indicadorDeCreditoInfonavit);
		builder.append(", periodoDePago=");
		builder.append(periodoDePago);
		builder.append(", salarioDiarioIntegrado=");
		builder.append(salarioDiarioIntegrado);
		builder.append(", numeroFolioEdoCta=");
		builder.append(numeroFolioEdoCta);
		builder.append(", expedienteCompleto=");
		builder.append(expedienteCompleto);
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
