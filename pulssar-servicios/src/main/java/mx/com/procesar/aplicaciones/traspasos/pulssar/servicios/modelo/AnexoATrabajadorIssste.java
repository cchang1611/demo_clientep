package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * entidad trabajador anexo a
 * @author JMGUTIEG
 *
 */
public class AnexoATrabajadorIssste implements Serializable{

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -4792685856755391242L;

	/**
	 * id trabajador anexo a
	 */
	private Long idTrabajadorAnexoA;	

	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * apellido paterno
	 */
	private String chApellidoPaterno;
	
	/**
	 * apellido materno
	 */
	private String chApellidoMaterno;
	
	/**
	 * nombreS
	 */
	private String chNombre;
	
	/**
	 * clave icefa
	 */
	private String chClaveIcefa;

	/**
	 * codigo postal
	 */
	private String chCodigoPostal;

	/**
	 * colonia
	 */
	private String chColonia;

	/**
	 * credito foviste
	 */
	private String chCreditoFovissste;

	/**
	 * domicilio
	 */
	private String chDomicilio;

	/**
	 * entidad federativa
	 */
	private String chEntidadFederativa;

	/**
	 * entidad federativa domicilio
	 */
	private String chEntidadFederativaDom;

	/**
	 * estado civil
	 */
	private String chEstadoCivil;
	
	/**
	 * indicador ahorro solidario
	 */
	private String chIndicadorAhorroSolidario;
	
	/**
	 * indicador trab afore
	 */
	private String chIndicadorTrabAfore;

	/**
	 * marca baja
	 */
	private String chMarcaBaja;

	/**
	 * nombramiento
	 */
	private String chNombramiento;

	/**
	 * no transmision
	 */
	private String chNotransmision;

	/**
	 * num empleado
	 */
	private String chNumEmpleado;

	/**
	 * pagaduria
	 */
	private String chPagaduria;

	/**
	 * pob del num
	 */
	private String chPobDelMun;

	/**
	 * reparto
	 */
	private String chReparto;

	/**
	 * sexo
	 */
	private String chSexo;

	/**
	 * usuario modificador 
	 */
	private String chUsuarioModificador;

	/**
	 * curp valida renapo
	 */
	private String curpValidaRenapo;

	/**
	 * causa baja
	 */
	private String cvCausaBaja;

	/**
	 * centro pago
	 */
	private String cvCentroPago;

	/**
	 * fecha baja
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcBaja;

	/**
	 * fecha control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * fecha ingreso
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcIngreso;

	/**
	 * fecha inicio cotizacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcInicioCotizacion;

	/**
	 * fecha nacimiento
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcNacimiento;

	/**
	 * fecha transmicion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcTransmision;

	/**
	 * nss issste
	 */
	private String nssIssste;

	/**
	 * nu ahorro solidario
	 */
	private BigDecimal nuAhorroSolidario;

	/**
	 * nu dias ausentismo bimestre
	 */
	private BigDecimal nuDiasAusentismoBimestre;

	/**
	 * nu dias cotizados
	 */
	private BigDecimal nuDiasCotizados;

	/**
	 * nu dias incapacidad bimestre
	 */
	private BigDecimal nuDiasIncapacidadBimestre;

	/**
	 * nu salario integrado
	 */
	private BigDecimal nuSalarioIntegrado;

	/**
	 * nu sdo credito viv
	 */
	private BigDecimal nuSdoCreditoViv;

	/**
	 * nu sueldo issste
	 */
	private BigDecimal nuSueldoIssste;

	/**
	 * nu sueldo sar
	 */
	private BigDecimal nuSueldoSar;

	/**
	 * rfc
	 */
	private String rfc;

	/**
	 * @return the idTrabajadorAnexoA
	 */
	public Long getIdTrabajadorAnexoA() {
		return idTrabajadorAnexoA;
	}

	/**
	 * @param idTrabajadorAnexoA the idTrabajadorAnexoA to set
	 */
	public void setIdTrabajadorAnexoA(Long idTrabajadorAnexoA) {
		this.idTrabajadorAnexoA = idTrabajadorAnexoA;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the chApellidoPaterno
	 */
	public String getChApellidoPaterno() {
		return chApellidoPaterno;
	}

	/**
	 * @param chApellidoPaterno the chApellidoPaterno to set
	 */
	public void setChApellidoPaterno(String chApellidoPaterno) {
		this.chApellidoPaterno = chApellidoPaterno;
	}

	/**
	 * @return the chApellidoMaterno
	 */
	public String getChApellidoMaterno() {
		return chApellidoMaterno;
	}

	/**
	 * @param chApellidoMaterno the chApellidoMaterno to set
	 */
	public void setChApellidoMaterno(String chApellidoMaterno) {
		this.chApellidoMaterno = chApellidoMaterno;
	}

	/**
	 * @return the chNombre
	 */
	public String getChNombre() {
		return chNombre;
	}

	/**
	 * @param chNombre the chNombre to set
	 */
	public void setChNombre(String chNombre) {
		this.chNombre = chNombre;
	}

	/**
	 * @return the chClaveIcefa
	 */
	public String getChClaveIcefa() {
		return chClaveIcefa;
	}

	/**
	 * @param chClaveIcefa the chClaveIcefa to set
	 */
	public void setChClaveIcefa(String chClaveIcefa) {
		this.chClaveIcefa = chClaveIcefa;
	}

	/**
	 * @return the chCodigoPostal
	 */
	public String getChCodigoPostal() {
		return chCodigoPostal;
	}

	/**
	 * @param chCodigoPostal the chCodigoPostal to set
	 */
	public void setChCodigoPostal(String chCodigoPostal) {
		this.chCodigoPostal = chCodigoPostal;
	}

	/**
	 * @return the chColonia
	 */
	public String getChColonia() {
		return chColonia;
	}

	/**
	 * @param chColonia the chColonia to set
	 */
	public void setChColonia(String chColonia) {
		this.chColonia = chColonia;
	}

	/**
	 * @return the chCreditoFovissste
	 */
	public String getChCreditoFovissste() {
		return chCreditoFovissste;
	}

	/**
	 * @param chCreditoFovissste the chCreditoFovissste to set
	 */
	public void setChCreditoFovissste(String chCreditoFovissste) {
		this.chCreditoFovissste = chCreditoFovissste;
	}

	/**
	 * @return the chDomicilio
	 */
	public String getChDomicilio() {
		return chDomicilio;
	}

	/**
	 * @param chDomicilio the chDomicilio to set
	 */
	public void setChDomicilio(String chDomicilio) {
		this.chDomicilio = chDomicilio;
	}

	/**
	 * @return the chEntidadFederativa
	 */
	public String getChEntidadFederativa() {
		return chEntidadFederativa;
	}

	/**
	 * @param chEntidadFederativa the chEntidadFederativa to set
	 */
	public void setChEntidadFederativa(String chEntidadFederativa) {
		this.chEntidadFederativa = chEntidadFederativa;
	}

	/**
	 * @return the chEntidadFederativaDom
	 */
	public String getChEntidadFederativaDom() {
		return chEntidadFederativaDom;
	}

	/**
	 * @param chEntidadFederativaDom the chEntidadFederativaDom to set
	 */
	public void setChEntidadFederativaDom(String chEntidadFederativaDom) {
		this.chEntidadFederativaDom = chEntidadFederativaDom;
	}

	/**
	 * @return the chEstadoCivil
	 */
	public String getChEstadoCivil() {
		return chEstadoCivil;
	}

	/**
	 * @param chEstadoCivil the chEstadoCivil to set
	 */
	public void setChEstadoCivil(String chEstadoCivil) {
		this.chEstadoCivil = chEstadoCivil;
	}

	/**
	 * @return the chIndicadorAhorroSolidario
	 */
	public String getChIndicadorAhorroSolidario() {
		return chIndicadorAhorroSolidario;
	}

	/**
	 * @param chIndicadorAhorroSolidario the chIndicadorAhorroSolidario to set
	 */
	public void setChIndicadorAhorroSolidario(String chIndicadorAhorroSolidario) {
		this.chIndicadorAhorroSolidario = chIndicadorAhorroSolidario;
	}

	/**
	 * @return the chIndicadorTrabAfore
	 */
	public String getChIndicadorTrabAfore() {
		return chIndicadorTrabAfore;
	}

	/**
	 * @param chIndicadorTrabAfore the chIndicadorTrabAfore to set
	 */
	public void setChIndicadorTrabAfore(String chIndicadorTrabAfore) {
		this.chIndicadorTrabAfore = chIndicadorTrabAfore;
	}

	/**
	 * @return the chMarcaBaja
	 */
	public String getChMarcaBaja() {
		return chMarcaBaja;
	}

	/**
	 * @param chMarcaBaja the chMarcaBaja to set
	 */
	public void setChMarcaBaja(String chMarcaBaja) {
		this.chMarcaBaja = chMarcaBaja;
	}

	/**
	 * @return the chNombramiento
	 */
	public String getChNombramiento() {
		return chNombramiento;
	}

	/**
	 * @param chNombramiento the chNombramiento to set
	 */
	public void setChNombramiento(String chNombramiento) {
		this.chNombramiento = chNombramiento;
	}

	/**
	 * @return the chNotransmision
	 */
	public String getChNotransmision() {
		return chNotransmision;
	}

	/**
	 * @param chNotransmision the chNotransmision to set
	 */
	public void setChNotransmision(String chNotransmision) {
		this.chNotransmision = chNotransmision;
	}

	/**
	 * @return the chNumEmpleado
	 */
	public String getChNumEmpleado() {
		return chNumEmpleado;
	}

	/**
	 * @param chNumEmpleado the chNumEmpleado to set
	 */
	public void setChNumEmpleado(String chNumEmpleado) {
		this.chNumEmpleado = chNumEmpleado;
	}

	/**
	 * @return the chPagaduria
	 */
	public String getChPagaduria() {
		return chPagaduria;
	}

	/**
	 * @param chPagaduria the chPagaduria to set
	 */
	public void setChPagaduria(String chPagaduria) {
		this.chPagaduria = chPagaduria;
	}

	/**
	 * @return the chPobDelMun
	 */
	public String getChPobDelMun() {
		return chPobDelMun;
	}

	/**
	 * @param chPobDelMun the chPobDelMun to set
	 */
	public void setChPobDelMun(String chPobDelMun) {
		this.chPobDelMun = chPobDelMun;
	}

	/**
	 * @return the chReparto
	 */
	public String getChReparto() {
		return chReparto;
	}

	/**
	 * @param chReparto the chReparto to set
	 */
	public void setChReparto(String chReparto) {
		this.chReparto = chReparto;
	}

	/**
	 * @return the chSexo
	 */
	public String getChSexo() {
		return chSexo;
	}

	/**
	 * @param chSexo the chSexo to set
	 */
	public void setChSexo(String chSexo) {
		this.chSexo = chSexo;
	}

	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * @return the curpValidaRenapo
	 */
	public String getCurpValidaRenapo() {
		return curpValidaRenapo;
	}

	/**
	 * @param curpValidaRenapo the curpValidaRenapo to set
	 */
	public void setCurpValidaRenapo(String curpValidaRenapo) {
		this.curpValidaRenapo = curpValidaRenapo;
	}

	/**
	 * @return the cvCausaBaja
	 */
	public String getCvCausaBaja() {
		return cvCausaBaja;
	}

	/**
	 * @param cvCausaBaja the cvCausaBaja to set
	 */
	public void setCvCausaBaja(String cvCausaBaja) {
		this.cvCausaBaja = cvCausaBaja;
	}

	/**
	 * @return the cvCentroPago
	 */
	public String getCvCentroPago() {
		return cvCentroPago;
	}

	/**
	 * @param cvCentroPago the cvCentroPago to set
	 */
	public void setCvCentroPago(String cvCentroPago) {
		this.cvCentroPago = cvCentroPago;
	}

	/**
	 * @return the fcBaja
	 */
	public Date getFcBaja() {
		return fcBaja;
	}

	/**
	 * @param fcBaja the fcBaja to set
	 */
	public void setFcBaja(Date fcBaja) {
		this.fcBaja = fcBaja;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return the fcIngreso
	 */
	public Date getFcIngreso() {
		return fcIngreso;
	}

	/**
	 * @param fcIngreso the fcIngreso to set
	 */
	public void setFcIngreso(Date fcIngreso) {
		this.fcIngreso = fcIngreso;
	}

	/**
	 * @return the fcInicioCotizacion
	 */
	public Date getFcInicioCotizacion() {
		return fcInicioCotizacion;
	}

	/**
	 * @param fcInicioCotizacion the fcInicioCotizacion to set
	 */
	public void setFcInicioCotizacion(Date fcInicioCotizacion) {
		this.fcInicioCotizacion = fcInicioCotizacion;
	}

	/**
	 * @return the fcNacimiento
	 */
	public Date getFcNacimiento() {
		return fcNacimiento;
	}

	/**
	 * @param fcNacimiento the fcNacimiento to set
	 */
	public void setFcNacimiento(Date fcNacimiento) {
		this.fcNacimiento = fcNacimiento;
	}

	/**
	 * @return the fcTransmision
	 */
	public Date getFcTransmision() {
		return fcTransmision;
	}

	/**
	 * @param fcTransmision the fcTransmision to set
	 */
	public void setFcTransmision(Date fcTransmision) {
		this.fcTransmision = fcTransmision;
	}

	/**
	 * @return the nssIssste
	 */
	public String getNssIssste() {
		return nssIssste;
	}

	/**
	 * @param nssIssste the nssIssste to set
	 */
	public void setNssIssste(String nssIssste) {
		this.nssIssste = nssIssste;
	}

	/**
	 * @return the nuAhorroSolidario
	 */
	public BigDecimal getNuAhorroSolidario() {
		return nuAhorroSolidario;
	}

	/**
	 * @param nuAhorroSolidario the nuAhorroSolidario to set
	 */
	public void setNuAhorroSolidario(BigDecimal nuAhorroSolidario) {
		this.nuAhorroSolidario = nuAhorroSolidario;
	}

	/**
	 * @return the nuDiasAusentismoBimestre
	 */
	public BigDecimal getNuDiasAusentismoBimestre() {
		return nuDiasAusentismoBimestre;
	}

	/**
	 * @param nuDiasAusentismoBimestre the nuDiasAusentismoBimestre to set
	 */
	public void setNuDiasAusentismoBimestre(BigDecimal nuDiasAusentismoBimestre) {
		this.nuDiasAusentismoBimestre = nuDiasAusentismoBimestre;
	}

	/**
	 * @return the nuDiasCotizados
	 */
	public BigDecimal getNuDiasCotizados() {
		return nuDiasCotizados;
	}

	/**
	 * @param nuDiasCotizados the nuDiasCotizados to set
	 */
	public void setNuDiasCotizados(BigDecimal nuDiasCotizados) {
		this.nuDiasCotizados = nuDiasCotizados;
	}

	/**
	 * @return the nuDiasIncapacidadBimestre
	 */
	public BigDecimal getNuDiasIncapacidadBimestre() {
		return nuDiasIncapacidadBimestre;
	}

	/**
	 * @param nuDiasIncapacidadBimestre the nuDiasIncapacidadBimestre to set
	 */
	public void setNuDiasIncapacidadBimestre(BigDecimal nuDiasIncapacidadBimestre) {
		this.nuDiasIncapacidadBimestre = nuDiasIncapacidadBimestre;
	}

	/**
	 * @return the nuSalarioIntegrado
	 */
	public BigDecimal getNuSalarioIntegrado() {
		return nuSalarioIntegrado;
	}

	/**
	 * @param nuSalarioIntegrado the nuSalarioIntegrado to set
	 */
	public void setNuSalarioIntegrado(BigDecimal nuSalarioIntegrado) {
		this.nuSalarioIntegrado = nuSalarioIntegrado;
	}

	/**
	 * @return the nuSdoCreditoViv
	 */
	public BigDecimal getNuSdoCreditoViv() {
		return nuSdoCreditoViv;
	}

	/**
	 * @param nuSdoCreditoViv the nuSdoCreditoViv to set
	 */
	public void setNuSdoCreditoViv(BigDecimal nuSdoCreditoViv) {
		this.nuSdoCreditoViv = nuSdoCreditoViv;
	}

	/**
	 * @return the nuSueldoIssste
	 */
	public BigDecimal getNuSueldoIssste() {
		return nuSueldoIssste;
	}

	/**
	 * @param nuSueldoIssste the nuSueldoIssste to set
	 */
	public void setNuSueldoIssste(BigDecimal nuSueldoIssste) {
		this.nuSueldoIssste = nuSueldoIssste;
	}

	/**
	 * @return the nuSueldoSar
	 */
	public BigDecimal getNuSueldoSar() {
		return nuSueldoSar;
	}

	/**
	 * @param nuSueldoSar the nuSueldoSar to set
	 */
	public void setNuSueldoSar(BigDecimal nuSueldoSar) {
		this.nuSueldoSar = nuSueldoSar;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnexoATrabajadorIssste [idTrabajadorAnexoA=");
		builder.append(idTrabajadorAnexoA);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", chApellidoPaterno=");
		builder.append(chApellidoPaterno);
		builder.append(", chApellidoMaterno=");
		builder.append(chApellidoMaterno);
		builder.append(", chNombre=");
		builder.append(chNombre);
		builder.append(", chClaveIcefa=");
		builder.append(chClaveIcefa);
		builder.append(", chCodigoPostal=");
		builder.append(chCodigoPostal);
		builder.append(", chColonia=");
		builder.append(chColonia);
		builder.append(", chCreditoFovissste=");
		builder.append(chCreditoFovissste);
		builder.append(", chDomicilio=");
		builder.append(chDomicilio);
		builder.append(", chEntidadFederativa=");
		builder.append(chEntidadFederativa);
		builder.append(", chEntidadFederativaDom=");
		builder.append(chEntidadFederativaDom);
		builder.append(", chEstadoCivil=");
		builder.append(chEstadoCivil);
		builder.append(", chIndicadorAhorroSolidario=");
		builder.append(chIndicadorAhorroSolidario);
		builder.append(", chIndicadorTrabAfore=");
		builder.append(chIndicadorTrabAfore);
		builder.append(", chMarcaBaja=");
		builder.append(chMarcaBaja);
		builder.append(", chNombramiento=");
		builder.append(chNombramiento);
		builder.append(", chNotransmision=");
		builder.append(chNotransmision);
		builder.append(", chNumEmpleado=");
		builder.append(chNumEmpleado);
		builder.append(", chPagaduria=");
		builder.append(chPagaduria);
		builder.append(", chPobDelMun=");
		builder.append(chPobDelMun);
		builder.append(", chReparto=");
		builder.append(chReparto);
		builder.append(", chSexo=");
		builder.append(chSexo);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", curpValidaRenapo=");
		builder.append(curpValidaRenapo);
		builder.append(", cvCausaBaja=");
		builder.append(cvCausaBaja);
		builder.append(", cvCentroPago=");
		builder.append(cvCentroPago);
		builder.append(", fcBaja=");
		builder.append(fcBaja);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", fcIngreso=");
		builder.append(fcIngreso);
		builder.append(", fcInicioCotizacion=");
		builder.append(fcInicioCotizacion);
		builder.append(", fcNacimiento=");
		builder.append(fcNacimiento);
		builder.append(", fcTransmision=");
		builder.append(fcTransmision);
		builder.append(", nssIssste=");
		builder.append(nssIssste);
		builder.append(", nuAhorroSolidario=");
		builder.append(nuAhorroSolidario);
		builder.append(", nuDiasAusentismoBimestre=");
		builder.append(nuDiasAusentismoBimestre);
		builder.append(", nuDiasCotizados=");
		builder.append(nuDiasCotizados);
		builder.append(", nuDiasIncapacidadBimestre=");
		builder.append(nuDiasIncapacidadBimestre);
		builder.append(", nuSalarioIntegrado=");
		builder.append(nuSalarioIntegrado);
		builder.append(", nuSdoCreditoViv=");
		builder.append(nuSdoCreditoViv);
		builder.append(", nuSueldoIssste=");
		builder.append(nuSueldoIssste);
		builder.append(", nuSueldoSar=");
		builder.append(nuSueldoSar);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append("]");
		return builder.toString();
	}
	
	
}
