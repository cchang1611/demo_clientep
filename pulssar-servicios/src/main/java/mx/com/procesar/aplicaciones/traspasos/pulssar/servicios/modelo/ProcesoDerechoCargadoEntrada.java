package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * Datos Entrada
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 24, 2021
 */
public class ProcesoDerechoCargadoEntrada implements Serializable{

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -2859775524452393642L;

	/**
	 * Curp
	 */
	private String curp;
	
	
	/**
	 * origenTramite
	 */
    private String origenTramite;
	
	/**
	 * ch_numero_resolucion
	 */
	private String numeroResolucion;
	
	/**
	 * secuenciaPension
	 */
	private String secuenciaPension;
	
	/**
	 * fcInicioPension
	 */
	
	private String fcInicioPension;
	
	/**
	 * fcEmisionResolucion
	 */
	private String fcEmisionResolucion;
	
	/**
	 * porcentajeValuacion
	 */
	private Long porcentajeValuacion;
	
	
	/**
	 * semanasCotizadas
	 */
	private Long  semanasCotizadas;
	
	/**
	 * fechaSolicitud
	 */
	private String fechaSolicitud;
	
	/**
	 * fechaNacimiento
	 */
	private String fechaNacimiento;
	
	/**
	 * cveDocProbatorio
	 */
	private String cveDocProbatorio;
	
	/**
	 * desDocProbatorio
	 */
	private String desDocProbatorio;
	/**
	 * aseguradora
	 */
	private String aseguradora;
	
	/**
	 * actuarioAutorizado
	 */
	private String actuarioAutorizado;
	
	/**
	 * numPlanPrivadoPensiones
	 */
	private String numPlanPrivadoPensiones;
	
	/**
	 * fechaPeriodoPagoReingreso
	 */
	private String fechaPeriodoPagoReingreso;
	
	/**
	 * consecutivoTrabajador
	 */
	private String consecutivoTrabajador;
	
	/**
	 * idSolcitante
	 */
	private String idSolcitante;
	
	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;
	
	
	private String claveSiafore;
	
	/**
	 * selloUnico
	 */
	private String selloUnico;
	
	/**
	 * curpAgenteServicio
	 */
	private String curpAgenteServicio;
	
	/**
	 * idBeneficiario
	 */
	private String idBeneficiario;
	
	/**
	 * descBeneficiario
	 */
	private String descBeneficiario;
	
	
	//Datos Ventanilla Afore
	
	private String tipoVentanilla;
	
	/**
	 * nombreBeneficiario
	 */
	private String nombreBeneficiario;
	
	/**
	 * apPaternoBeneficiario
	 */
	private String apPaternoBeneficiario;
	
	/**
	 * apMaternoBeneficiario
	 */
	private String apMaternoBeneficiario;
	
	/**
	 * clabePago
	 */
	private String clabePago;
	
	/**
	 * curpPago
	 */
	private String curpPago;
	
	/**
	 * rfcPago
	 */
	private String rfcPago;
	
	/**
	 * folioInfonavit
	 */
	private String folioInfonavit;
	
	/**
	 * grupoTrabajador
	 */
	private String grupo;
	
	
	
	/**
	 * descTipoRetiro
	 */
	private String descTipoRetiro;
	
	/**
	 * ch_desc_tipo_seguro
	 */
	private String descTipoSeguro;
	
	/**
	 * cvTipoSeguro
	 */
	private String cvTipoSeguro;
	
	/**
	 * ch_desc_tipo_pension
	 */
	private String descTipoPension;
	
	/**
	 * cvTipoPrestacion
	 */
	private String cvTipoPrestacion;
	

	/**
	 * descTipoPrestacion
	 */
	private String descTipoPrestacion;
	
	
	/**
	 * cvTipoPension
	 */
	private String cvTipoPension;
	
	/**
	 * ch_desc_tipo_regimen
	 */
	private String descTipoRegimen;

	/**
	 * cvTipoRegimen
	 */
	private String cvTipoRegimen;
	
	/**
	 * cvTipoRetiro
	 */
	private String cvTipoRetiro;
	
	/**
	 * primerTipoRetiro
	 */
	private String primerTipoRetiro;
	
	/**
	 * radioCargado
	 */
	private String radioCargado;

	
	
	/**
	 * subcuentasRcv
	 */
	private List<DatosSubcuentasDispIssste> subcuentasRcv;
	
	/**
	 * subcuentasViv
	 */
	private List<DatosSubcuentasDispIssste> subcuentasViv;
		
	/**
	 * Beneficiarios
	 */
	private List<DatosBenefDispIssste> beneficiarios;
	
	/**
	 * Siefores
	 */
	List<Siefore> sieforesLista;
	
	
	/**
	 * montoTotalRcv
	 */
	private String montoTotalRcv;
	
	/**
	 * montoTotalViv
	 */
	private String montoTotalViv;
	
	/**
	 * montoTotalBen
	 */
	private String montoTotalBen;
	
	
	
	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return el atributo secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}

	/**
	 * @param secuenciaPension parametro secuenciaPension a actualizar
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}

	/**
	 * @return el atributo fcInicioPension
	 */
	public String getFcInicioPension() {
		return fcInicioPension;
	}

	/**
	 * @param fcInicioPension parametro fcInicioPension a actualizar
	 */
	public void setFcInicioPension(String fcInicioPension) {
		this.fcInicioPension = fcInicioPension;
	}

	/**
	 * @return el atributo fcEmisionResolucion
	 */
	public String getFcEmisionResolucion() {
		return fcEmisionResolucion;
	}

	/**
	 * @param fcEmisionResolucion parametro fcEmisionResolucion a actualizar
	 */
	public void setFcEmisionResolucion(String fcEmisionResolucion) {
		this.fcEmisionResolucion = fcEmisionResolucion;
	}

	/**
	 * @return el atributo porcentajeValuacion
	 */
	public Long getPorcentajeValuacion() {
		return porcentajeValuacion;
	}

	/**
	 * @param porcentajeValuacion parametro porcentajeValuacion a actualizar
	 */
	public void setPorcentajeValuacion(Long porcentajeValuacion) {
		this.porcentajeValuacion = porcentajeValuacion;
	}

	/**
	 * @return el atributo semanasCotizadas
	 */
	public Long getSemanasCotizadas() {
		return semanasCotizadas;
	}

	/**
	 * @param semanasCotizadas parametro semanasCotizadas a actualizar
	 */
	public void setSemanasCotizadas(Long semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}

	/**
	 * @return el atributo descTipoRetiro
	 */
	public String getDescTipoRetiro() {
		return descTipoRetiro;
	}

	/**
	 * @param descTipoRetiro parametro descTipoRetiro a actualizar
	 */
	public void setDescTipoRetiro(String descTipoRetiro) {
		this.descTipoRetiro = descTipoRetiro;
	}

	/**
	 * @return el atributo descTipoSeguro
	 */
	public String getDescTipoSeguro() {
		return descTipoSeguro;
	}

	/**
	 * @param descTipoSeguro parametro descTipoSeguro a actualizar
	 */
	public void setDescTipoSeguro(String descTipoSeguro) {
		this.descTipoSeguro = descTipoSeguro;
	}

	/**
	 * @return el atributo cvTipoSeguro
	 */
	public String getCvTipoSeguro() {
		return cvTipoSeguro;
	}

	/**
	 * @param cvTipoSeguro parametro cvTipoSeguro a actualizar
	 */
	public void setCvTipoSeguro(String cvTipoSeguro) {
		this.cvTipoSeguro = cvTipoSeguro;
	}

	/**
	 * @return el atributo descTipoPension
	 */
	public String getDescTipoPension() {
		return descTipoPension;
	}

	/**
	 * @param descTipoPension parametro descTipoPension a actualizar
	 */
	public void setDescTipoPension(String descTipoPension) {
		this.descTipoPension = descTipoPension;
	}

	/**
	 * @return el atributo cvTipoPrestacion
	 */
	public String getCvTipoPrestacion() {
		return cvTipoPrestacion;
	}

	/**
	 * @param cvTipoPrestacion parametro cvTipoPrestacion a actualizar
	 */
	public void setCvTipoPrestacion(String cvTipoPrestacion) {
		this.cvTipoPrestacion = cvTipoPrestacion;
	}

	/**
	 * @return el atributo descTipoPrestacion
	 */
	public String getDescTipoPrestacion() {
		return descTipoPrestacion;
	}

	/**
	 * @param descTipoPrestacion parametro descTipoPrestacion a actualizar
	 */
	public void setDescTipoPrestacion(String descTipoPrestacion) {
		this.descTipoPrestacion = descTipoPrestacion;
	}

	/**
	 * @return el atributo cvTipoPension
	 */
	public String getCvTipoPension() {
		return cvTipoPension;
	}

	/**
	 * @param cvTipoPension parametro cvTipoPension a actualizar
	 */
	public void setCvTipoPension(String cvTipoPension) {
		this.cvTipoPension = cvTipoPension;
	}

	/**
	 * @return el atributo descTipoRegimen
	 */
	public String getDescTipoRegimen() {
		return descTipoRegimen;
	}

	/**
	 * @param descTipoRegimen parametro descTipoRegimen a actualizar
	 */
	public void setDescTipoRegimen(String descTipoRegimen) {
		this.descTipoRegimen = descTipoRegimen;
	}

	/**
	 * @return el atributo cvTipoRegimen
	 */
	public String getCvTipoRegimen() {
		return cvTipoRegimen;
	}

	/**
	 * @param cvTipoRegimen parametro cvTipoRegimen a actualizar
	 */
	public void setCvTipoRegimen(String cvTipoRegimen) {
		this.cvTipoRegimen = cvTipoRegimen;
	}

	/**
	 * @return el atributo cvTipoRetiro
	 */
	public String getCvTipoRetiro() {
		return cvTipoRetiro;
	}

	/**
	 * @param cvTipoRetiro parametro cvTipoRetiro a actualizar
	 */
	public void setCvTipoRetiro(String cvTipoRetiro) {
		this.cvTipoRetiro = cvTipoRetiro;
	}

	/**
	 * @return el atributo primerTipoRetiro
	 */
	public String getPrimerTipoRetiro() {
		return primerTipoRetiro;
	}

	/**
	 * @param primerTipoRetiro parametro primerTipoRetiro a actualizar
	 */
	public void setPrimerTipoRetiro(String primerTipoRetiro) {
		this.primerTipoRetiro = primerTipoRetiro;
	}

	/**
	 * @return el atributo radioCargado
	 */
	public String getRadioCargado() {
		return radioCargado;
	}

	/**
	 * @param radioCargado parametro radioCargado a actualizar
	 */
	public void setRadioCargado(String radioCargado) {
		this.radioCargado = radioCargado;
	}

		
	

	/**
	 * @return el atributo montoTotalRcv
	 */
	public String getMontoTotalRcv() {
		return montoTotalRcv;
	}

	/**
	 * @param montoTotalRcv parametro montoTotalRcv a actualizar
	 */
	public void setMontoTotalRcv(String montoTotalRcv) {
		this.montoTotalRcv = montoTotalRcv;
	}

	/**
	 * @return el atributo montoTotalViv
	 */
	public String getMontoTotalViv() {
		return montoTotalViv;
	}

	/**
	 * @param montoTotalViv parametro montoTotalViv a actualizar
	 */
	public void setMontoTotalViv(String montoTotalViv) {
		this.montoTotalViv = montoTotalViv;
	}

	/**
	 * @return el atributo montoTotalBen
	 */
	public String getMontoTotalBen() {
		return montoTotalBen;
	}

	/**
	 * @param montoTotalBen parametro montoTotalBen a actualizar
	 */
	public void setMontoTotalBen(String montoTotalBen) {
		this.montoTotalBen = montoTotalBen;
	}

	/**
	 * @return el atributo fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud parametro fechaSolicitud a actualizar
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return el atributo cveDocProbatorio
	 */
	public String getCveDocProbatorio() {
		return cveDocProbatorio;
	}

	/**
	 * @param cveDocProbatorio parametro cveDocProbatorio a actualizar
	 */
	public void setCveDocProbatorio(String cveDocProbatorio) {
		this.cveDocProbatorio = cveDocProbatorio;
	}

	/**
	 * @return el atributo aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}

	/**
	 * @param aseguradora parametro aseguradora a actualizar
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	/**
	 * @return el atributo actuarioAutorizado
	 */
	public String getActuarioAutorizado() {
		return actuarioAutorizado;
	}

	/**
	 * @param actuarioAutorizado parametro actuarioAutorizado a actualizar
	 */
	public void setActuarioAutorizado(String actuarioAutorizado) {
		this.actuarioAutorizado = actuarioAutorizado;
	}

	/**
	 * @return el atributo numPlanPrivadoPensiones
	 */
	public String getNumPlanPrivadoPensiones() {
		return numPlanPrivadoPensiones;
	}

	/**
	 * @param numPlanPrivadoPensiones parametro numPlanPrivadoPensiones a actualizar
	 */
	public void setNumPlanPrivadoPensiones(String numPlanPrivadoPensiones) {
		this.numPlanPrivadoPensiones = numPlanPrivadoPensiones;
	}

	/**
	 * @return el atributo fechaPeriodoPagoReingreso
	 */
	public String getFechaPeriodoPagoReingreso() {
		return fechaPeriodoPagoReingreso;
	}

	/**
	 * @param fechaPeriodoPagoReingreso parametro fechaPeriodoPagoReingreso a actualizar
	 */
	public void setFechaPeriodoPagoReingreso(String fechaPeriodoPagoReingreso) {
		this.fechaPeriodoPagoReingreso = fechaPeriodoPagoReingreso;
	}

	/**
	 * @return el atributo consecutivoTrabajador
	 */
	public String getConsecutivoTrabajador() {
		return consecutivoTrabajador;
	}

	/**
	 * @param consecutivoTrabajador parametro consecutivoTrabajador a actualizar
	 */
	public void setConsecutivoTrabajador(String consecutivoTrabajador) {
		this.consecutivoTrabajador = consecutivoTrabajador;
	}

	/**
	 * @return el atributo idSolcitante
	 */
	public String getIdSolcitante() {
		return idSolcitante;
	}

	/**
	 * @param idSolcitante parametro idSolcitante a actualizar
	 */
	public void setIdSolcitante(String idSolcitante) {
		this.idSolcitante = idSolcitante;
	}

	/**
	 * @return el atributo curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante parametro curpSolicitante a actualizar
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return el atributo selloUnico
	 */
	public String getSelloUnico() {
		return selloUnico;
	}

	/**
	 * @param selloUnico parametro selloUnico a actualizar
	 */
	public void setSelloUnico(String selloUnico) {
		this.selloUnico = selloUnico;
	}

	/**
	 * @return el atributo curpAgenteServicio
	 */
	public String getCurpAgenteServicio() {
		return curpAgenteServicio;
	}

	/**
	 * @param curpAgenteServicio parametro curpAgenteServicio a actualizar
	 */
	public void setCurpAgenteServicio(String curpAgenteServicio) {
		this.curpAgenteServicio = curpAgenteServicio;
	}

	/**
	 * @return el atributo idBeneficiario
	 */
	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	/**
	 * @param idBeneficiario parametro idBeneficiario a actualizar
	 */
	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	/**
	 * @return el atributo nombreBeneficiario
	 */
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	/**
	 * @param nombreBeneficiario parametro nombreBeneficiario a actualizar
	 */
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	/**
	 * @return el atributo apPaternoBeneficiario
	 */
	public String getApPaternoBeneficiario() {
		return apPaternoBeneficiario;
	}

	/**
	 * @param apPaternoBeneficiario parametro apPaternoBeneficiario a actualizar
	 */
	public void setApPaternoBeneficiario(String apPaternoBeneficiario) {
		this.apPaternoBeneficiario = apPaternoBeneficiario;
	}

	/**
	 * @return el atributo apMaternoBeneficiario
	 */
	public String getApMaternoBeneficiario() {
		return apMaternoBeneficiario;
	}

	/**
	 * @param apMaternoBeneficiario parametro apMaternoBeneficiario a actualizar
	 */
	public void setApMaternoBeneficiario(String apMaternoBeneficiario) {
		this.apMaternoBeneficiario = apMaternoBeneficiario;
	}

	/**
	 * @return el atributo clabePago
	 */
	public String getClabePago() {
		return clabePago;
	}

	/**
	 * @param clabePago parametro clabePago a actualizar
	 */
	public void setClabePago(String clabePago) {
		this.clabePago = clabePago;
	}

	/**
	 * @return el atributo curpPago
	 */
	public String getCurpPago() {
		return curpPago;
	}

	/**
	 * @param curpPago parametro curpPago a actualizar
	 */
	public void setCurpPago(String curpPago) {
		this.curpPago = curpPago;
	}

	/**
	 * @return el atributo rfcPago
	 */
	public String getRfcPago() {
		return rfcPago;
	}

	/**
	 * @param rfcPago parametro rfcPago a actualizar
	 */
	public void setRfcPago(String rfcPago) {
		this.rfcPago = rfcPago;
	}

	/**
	 * @return el atributo folioInfonavit
	 */
	public String getFolioInfonavit() {
		return folioInfonavit;
	}

	/**
	 * @param folioInfonavit parametro folioInfonavit a actualizar
	 */
	public void setFolioInfonavit(String folioInfonavit) {
		this.folioInfonavit = folioInfonavit;
	}

	/**
	 * @return el atributo grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo parametro grupo a actualizar
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return el atributo origenTramite
	 */
	public String getOrigenTramite() {
		return origenTramite;
	}

	/**
	 * @param origenTramite parametro origenTramite a actualizar
	 */
	public void setOrigenTramite(String origenTramite) {
		this.origenTramite = origenTramite;
	}

	/**
	 * @return el atributo fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento parametro fechaNacimiento a actualizar
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return el atributo claveSiafore
	 */
	public String getClaveSiafore() {
		return claveSiafore;
	}

	/**
	 * @param claveSiafore parametro claveSiafore a actualizar
	 */
	public void setClaveSiafore(String claveSiafore) {
		this.claveSiafore = claveSiafore;
	}

	/**
	 * @return el atributo sieforesLista
	 */
	public List<Siefore> getSieforesLista() {
		return sieforesLista;
	}

	/**
	 * @param sieforesLista parametro sieforesLista a actualizar
	 */
	public void setSieforesLista(List<Siefore> sieforesLista) {
		this.sieforesLista = sieforesLista;
	}

	
	
	/**
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	
	
	/**
	 * @return el atributo tipoVentanilla
	 */
	public String getTipoVentanilla() {
		return tipoVentanilla;
	}

	/**
	 * @param tipoVentanilla parametro tipoVentanilla a actualizar
	 */
	public void setTipoVentanilla(String tipoVentanilla) {
		this.tipoVentanilla = tipoVentanilla;
	}

	/**
	 * @return el atributo subcuentasRcv
	 */
	public List<DatosSubcuentasDispIssste> getSubcuentasRcv() {
		return subcuentasRcv;
	}

	/**
	 * @param subcuentasRcv parametro subcuentasRcv a actualizar
	 */
	public void setSubcuentasRcv(List<DatosSubcuentasDispIssste> subcuentasRcv) {
		this.subcuentasRcv = subcuentasRcv;
	}

	/**
	 * @return el atributo subcuentasViv
	 */
	public List<DatosSubcuentasDispIssste> getSubcuentasViv() {
		return subcuentasViv;
	}

	/**
	 * @param subcuentasViv parametro subcuentasViv a actualizar
	 */
	public void setSubcuentasViv(List<DatosSubcuentasDispIssste> subcuentasViv) {
		this.subcuentasViv = subcuentasViv;
	}

	/**
	 * @return el atributo beneficiarios
	 */
	public List<DatosBenefDispIssste> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * @param beneficiarios parametro beneficiarios a actualizar
	 */
	public void setBeneficiarios(List<DatosBenefDispIssste> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	/**
	 * @return el atributo desDocProbatorio
	 */
	public String getDesDocProbatorio() {
		return desDocProbatorio;
	}

	/**
	 * @param desDocProbatorio parametro desDocProbatorio a actualizar
	 */
	public void setDesDocProbatorio(String desDocProbatorio) {
		this.desDocProbatorio = desDocProbatorio;
	}

	/**
	 * @return el atributo descBeneficiario
	 */
	public String getDescBeneficiario() {
		return descBeneficiario;
	}

	/**
	 * @param descBeneficiario parametro descBeneficiario a actualizar
	 */
	public void setDescBeneficiario(String descBeneficiario) {
		this.descBeneficiario = descBeneficiario;
	}

	/**
	 *   Constructor
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param curp
	 *  @param origenTramite
	 *  @param numeroResolucion
	 *  @param secuenciaPension
	 *  @param fcInicioPension
	 *  @param fcEmisionResolucion
	 *  @param porcentajeValuacion
	 *  @param semanasCotizadas
	 *  @param fechaSolicitud
	 *  @param fechaNacimiento
	 *  @param cveDocProbatorio
	 *  @param desDocProbatorio
	 *  @param aseguradora
	 *  @param actuarioAutorizado
	 *  @param numPlanPrivadoPensiones
	 *  @param fechaPeriodoPagoReingreso
	 *  @param consecutivoTrabajador
	 *  @param idSolcitante
	 *  @param curpSolicitante
	 *  @param claveSiafore
	 *  @param selloUnico
	 *  @param curpAgenteServicio
	 *  @param idBeneficiario
	 *  @param descBeneficiario
	 *  @param tipoVentanilla
	 *  @param nombreBeneficiario
	 *  @param apPaternoBeneficiario
	 *  @param apMaternoBeneficiario
	 *  @param clabePago
	 *  @param curpPago
	 *  @param rfcPago
	 *  @param folioInfonavit
	 *  @param grupo
	 *  @param descTipoRetiro
	 *  @param descTipoSeguro
	 *  @param cvTipoSeguro
	 *  @param descTipoPension
	 *  @param cvTipoPrestacion
	 *  @param descTipoPrestacion
	 *  @param cvTipoPension
	 *  @param descTipoRegimen
	 *  @param cvTipoRegimen
	 *  @param cvTipoRetiro
	 *  @param primerTipoRetiro
	 *  @param radioCargado
	 *  @param subcuentasRcv
	 *  @param subcuentasViv
	 *  @param beneficiarios
	 *  @param sieforesLista
	 *  @param montoTotalRcv
	 *  @param montoTotalViv
	 *  @param montoTotalBen
	 */
	
	public ProcesoDerechoCargadoEntrada(String curp, String origenTramite, String numeroResolucion,
			String secuenciaPension, String fcInicioPension, String fcEmisionResolucion, Long porcentajeValuacion,
			Long semanasCotizadas, String fechaSolicitud, String fechaNacimiento, String cveDocProbatorio,
			String desDocProbatorio, String aseguradora, String actuarioAutorizado, String numPlanPrivadoPensiones,
			String fechaPeriodoPagoReingreso, String consecutivoTrabajador, String idSolcitante, String curpSolicitante,
			String claveSiafore, String selloUnico, String curpAgenteServicio, String idBeneficiario,
			String descBeneficiario, String tipoVentanilla, String nombreBeneficiario, String apPaternoBeneficiario,
			String apMaternoBeneficiario, String clabePago, String curpPago, String rfcPago, String folioInfonavit,
			String grupo, String descTipoRetiro, String descTipoSeguro, String cvTipoSeguro, String descTipoPension,
			String cvTipoPrestacion, String descTipoPrestacion, String cvTipoPension, String descTipoRegimen,
			String cvTipoRegimen, String cvTipoRetiro, String primerTipoRetiro, String radioCargado,
			List<DatosSubcuentasDispIssste> subcuentasRcv, List<DatosSubcuentasDispIssste> subcuentasViv,
			List<DatosBenefDispIssste> beneficiarios, List<Siefore> sieforesLista, String montoTotalRcv,
			String montoTotalViv, String montoTotalBen) {
		
		this.curp = curp;
		this.origenTramite = origenTramite;
		this.numeroResolucion = numeroResolucion;
		this.secuenciaPension = secuenciaPension;
		this.fcInicioPension = fcInicioPension;
		this.fcEmisionResolucion = fcEmisionResolucion;
		this.porcentajeValuacion = porcentajeValuacion;
		this.semanasCotizadas = semanasCotizadas;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaNacimiento = fechaNacimiento;
		this.cveDocProbatorio = cveDocProbatorio;
		this.desDocProbatorio = desDocProbatorio;
		this.aseguradora = aseguradora;
		this.actuarioAutorizado = actuarioAutorizado;
		this.numPlanPrivadoPensiones = numPlanPrivadoPensiones;
		this.fechaPeriodoPagoReingreso = fechaPeriodoPagoReingreso;
		this.consecutivoTrabajador = consecutivoTrabajador;
		this.idSolcitante = idSolcitante;
		this.curpSolicitante = curpSolicitante;
		this.claveSiafore = claveSiafore;
		this.selloUnico = selloUnico;
		this.curpAgenteServicio = curpAgenteServicio;
		this.idBeneficiario = idBeneficiario;
		this.descBeneficiario = descBeneficiario;
		this.tipoVentanilla = tipoVentanilla;
		this.nombreBeneficiario = nombreBeneficiario;
		this.apPaternoBeneficiario = apPaternoBeneficiario;
		this.apMaternoBeneficiario = apMaternoBeneficiario;
		this.clabePago = clabePago;
		this.curpPago = curpPago;
		this.rfcPago = rfcPago;
		this.folioInfonavit = folioInfonavit;
		this.grupo = grupo;
		this.descTipoRetiro = descTipoRetiro;
		this.descTipoSeguro = descTipoSeguro;
		this.cvTipoSeguro = cvTipoSeguro;
		this.descTipoPension = descTipoPension;
		this.cvTipoPrestacion = cvTipoPrestacion;
		this.descTipoPrestacion = descTipoPrestacion;
		this.cvTipoPension = cvTipoPension;
		this.descTipoRegimen = descTipoRegimen;
		this.cvTipoRegimen = cvTipoRegimen;
		this.cvTipoRetiro = cvTipoRetiro;
		this.primerTipoRetiro = primerTipoRetiro;
		this.radioCargado = radioCargado;
		this.subcuentasRcv = subcuentasRcv;
		this.subcuentasViv = subcuentasViv;
		this.beneficiarios = beneficiarios;
		this.sieforesLista = sieforesLista;
		this.montoTotalRcv = montoTotalRcv;
		this.montoTotalViv = montoTotalViv;
		this.montoTotalBen = montoTotalBen;
	}

	/**
	 *  Constructor
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	
	public ProcesoDerechoCargadoEntrada() {
		
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoDerechoCargadoEntrada [curp=");
		builder.append(curp);
		builder.append(", origenTramite=");
		builder.append(origenTramite);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", fcInicioPension=");
		builder.append(fcInicioPension);
		builder.append(", fcEmisionResolucion=");
		builder.append(fcEmisionResolucion);
		builder.append(", porcentajeValuacion=");
		builder.append(porcentajeValuacion);
		builder.append(", semanasCotizadas=");
		builder.append(semanasCotizadas);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", cveDocProbatorio=");
		builder.append(cveDocProbatorio);
		builder.append(", desDocProbatorio=");
		builder.append(desDocProbatorio);
		builder.append(", aseguradora=");
		builder.append(aseguradora);
		builder.append(", actuarioAutorizado=");
		builder.append(actuarioAutorizado);
		builder.append(", numPlanPrivadoPensiones=");
		builder.append(numPlanPrivadoPensiones);
		builder.append(", fechaPeriodoPagoReingreso=");
		builder.append(fechaPeriodoPagoReingreso);
		builder.append(", consecutivoTrabajador=");
		builder.append(consecutivoTrabajador);
		builder.append(", idSolcitante=");
		builder.append(idSolcitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", claveSiafore=");
		builder.append(claveSiafore);
		builder.append(", selloUnico=");
		builder.append(selloUnico);
		builder.append(", curpAgenteServicio=");
		builder.append(curpAgenteServicio);
		builder.append(", idBeneficiario=");
		builder.append(idBeneficiario);
		builder.append(", descBeneficiario=");
		builder.append(descBeneficiario);
		builder.append(", tipoVentanilla=");
		builder.append(tipoVentanilla);
		builder.append(", nombreBeneficiario=");
		builder.append(nombreBeneficiario);
		builder.append(", apPaternoBeneficiario=");
		builder.append(apPaternoBeneficiario);
		builder.append(", apMaternoBeneficiario=");
		builder.append(apMaternoBeneficiario);
		builder.append(", clabePago=");
		builder.append(clabePago);
		builder.append(", curpPago=");
		builder.append(curpPago);
		builder.append(", rfcPago=");
		builder.append(rfcPago);
		builder.append(", folioInfonavit=");
		builder.append(folioInfonavit);
		builder.append(", grupo=");
		builder.append(grupo);
		builder.append(", descTipoRetiro=");
		builder.append(descTipoRetiro);
		builder.append(", descTipoSeguro=");
		builder.append(descTipoSeguro);
		builder.append(", cvTipoSeguro=");
		builder.append(cvTipoSeguro);
		builder.append(", descTipoPension=");
		builder.append(descTipoPension);
		builder.append(", cvTipoPrestacion=");
		builder.append(cvTipoPrestacion);
		builder.append(", descTipoPrestacion=");
		builder.append(descTipoPrestacion);
		builder.append(", cvTipoPension=");
		builder.append(cvTipoPension);
		builder.append(", descTipoRegimen=");
		builder.append(descTipoRegimen);
		builder.append(", cvTipoRegimen=");
		builder.append(cvTipoRegimen);
		builder.append(", cvTipoRetiro=");
		builder.append(cvTipoRetiro);
		builder.append(", primerTipoRetiro=");
		builder.append(primerTipoRetiro);
		builder.append(", radioCargado=");
		builder.append(radioCargado);
		builder.append(", subcuentasRcv=");
		builder.append(subcuentasRcv);
		builder.append(", subcuentasViv=");
		builder.append(subcuentasViv);
		builder.append(", beneficiarios=");
		builder.append(beneficiarios);
		builder.append(", sieforesLista=");
		builder.append(sieforesLista);
		builder.append(", montoTotalRcv=");
		builder.append(montoTotalRcv);
		builder.append(", montoTotalViv=");
		builder.append(montoTotalViv);
		builder.append(", montoTotalBen=");
		builder.append(montoTotalBen);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
