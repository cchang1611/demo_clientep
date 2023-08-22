package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Solicitar disposicion entrada
 * @author RARREOLA
 *
 */
public class SolicitarDisposicionImssEntrada  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * Folio solicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioSolicitud;
	
	/**
	 * Origen
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String origenTramite;
	
	/**
	 * Clave administradora
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String cveAfore;
	
	/**
	 * Nss trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	
	/**
	 * Curp trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	
	/**
	 * Nombre trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajador;
	
	/**
	 * Apellido paterno
	 */

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apPaternoTrabajador;
	
	/**
	 * Apellido materno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apMaternoTrabajador;
	
	/**
	 * Secuencia pension
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String secuenciaPension;


	/**
	 * Tipo retiro
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoRetiro;
	
	
	/**
	 * Regimen
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String regimen;
	
	/**
	 * Tipo seguro
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoSeguro;
	
	/**
	 * Tipo pension
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoPension;
	

	
	/**
	 * Tipo prestacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoPrestacion;
	
	/**
	 * Fecha inicio pension
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaInicioPension;
	
	/**
	 * Fecha emision resolucion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaEmisionResolucion;
	
	/**
	 * porcentajeValuacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double porcentajeValuacion;
	
	/**
	 * Semanas cotizadas
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String semanasCotizadas;
	
	/**
	 * Fecha solicitud trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaSolicitud;
	
	/**
	 * Clave documento probatorio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String cveDocProbatorio;
	
	/**
	 * Fecha nacimiento
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaNacimiento;
	
	/**
	 * Aseguradora
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String aseguradora;
	
	/**
	 * Actuario autorizado
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String actuarioAutorizado;
	
	/**
	 * Numero registro plan privado pensiones
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String numPlanPrivadoPensiones;
	
	/**
	 * Fecha periodo pago ingreso
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaPeriodoPagoReingreso;
	
	/**
	 * Consecutivo trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String consecutivoTrabajador;
	
	/**
	 * Id solicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idSolicitante;
	
	/**
	 * Curp solicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpSolicitante;
	
	/**
	 * Sello verificacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String selloUnico;
	
	/**
	 * Curp agente servicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpAgenteServicio;
	
	/**
	 *idBeneficiario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idBeneficiario;
	
	
	/**
	 *nombreBeneficiario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreBeneficiario;
	
	
	/**
	 *apPaternoBeneficiario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apPaternoBeneficiario;
	
	
	/**
	 *apMaternoBeneficiario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apMaternoBeneficiario;
	
	/**
	 *clabePago
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String clabePago;
	
	/**
	 *curpPago
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpPago;

	
	
	
	/**
	 *rfcPago
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String rfcPago;
	
	
	/**
	 *folioInfonavit
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioInfonavit;
	
	/**
	 *tipoVentanilla
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoVentanilla;
	
	/**
	 *grupo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String grupo;
	
	
	/**
	 * accionesSiefore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<AccionSieforeImss> montosRCV;
	
	/**
	 * aplicacionInteresViv97
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double aplicacionInteresViv97;
	
	
	/**
	 * aplicacionInteresViv92
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double aplicacionInteresViv92;
	
	
	/**
	 * fondoAhorroViv72
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double fondoAhorroViv72;
	
	
	
	
	

	
	


	


	/**
	 * @return the origenTramite
	 */
	public String getOrigenTramite() {
		return origenTramite;
	}



	/**
	 * @param origenTramite the origenTramite to set
	 */
	public void setOrigenTramite(String origenTramite) {
		this.origenTramite = origenTramite;
	}



	/**
	 * @return the aplicacionInteresViv97
	 */
	public Double getAplicacionInteresViv97() {
		return aplicacionInteresViv97;
	}



	/**
	 * @param aplicacionInteresViv97 the aplicacionInteresViv97 to set
	 */
	public void setAplicacionInteresViv97(Double aplicacionInteresViv97) {
		this.aplicacionInteresViv97 = aplicacionInteresViv97;
	}



	/**
	 * @return the aplicacionInteresViv92
	 */
	public Double getAplicacionInteresViv92() {
		return aplicacionInteresViv92;
	}



	/**
	 * @param aplicacionInteresViv92 the aplicacionInteresViv92 to set
	 */
	public void setAplicacionInteresViv92(Double aplicacionInteresViv92) {
		this.aplicacionInteresViv92 = aplicacionInteresViv92;
	}



	/**
	 * @return the fondoAhorroViv72
	 */
	public Double getFondoAhorroViv72() {
		return fondoAhorroViv72;
	}



	/**
	 * @param fondoAhorroViv72 the fondoAhorroViv72 to set
	 */
	public void setFondoAhorroViv72(Double fondoAhorroViv72) {
		this.fondoAhorroViv72 = fondoAhorroViv72;
	}



	/**
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}



	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}



	


	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}



	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
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
	 * @return the secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}



	/**
	 * @param secuenciaPension the secuenciaPension to set
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}



	/**
	 * @return the tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}



	/**
	 * @param tipoRetiro the tipoRetiro to set
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}



	



	/**
	 * @return the tipoSeguro
	 */
	public String getTipoSeguro() {
		return tipoSeguro;
	}



	/**
	 * @param tipoSeguro the tipoSeguro to set
	 */
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}



	/**
	 * @return the tipoPension
	 */
	public String getTipoPension() {
		return tipoPension;
	}



	/**
	 * @param tipoPension the tipoPension to set
	 */
	public void setTipoPension(String tipoPension) {
		this.tipoPension = tipoPension;
	}






	/**
	 * @return the tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}



	/**
	 * @param tipoPrestacion the tipoPrestacion to set
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}



	/**
	 * @return the fechaInicioPension
	 */
	public String getFechaInicioPension() {
		return fechaInicioPension;
	}



	/**
	 * @param fechaInicioPension the fechaInicioPension to set
	 */
	public void setFechaInicioPension(String fechaInicioPension) {
		this.fechaInicioPension = fechaInicioPension;
	}



	/**
	 * @return the fechaEmisionResolucion
	 */
	public String getFechaEmisionResolucion() {
		return fechaEmisionResolucion;
	}



	/**
	 * @param fechaEmisionResolucion the fechaEmisionResolucion to set
	 */
	public void setFechaEmisionResolucion(String fechaEmisionResolucion) {
		this.fechaEmisionResolucion = fechaEmisionResolucion;
	}





	
	/**
	 * @return the semanasCotizadas
	 */
	public String getSemanasCotizadas() {
		return semanasCotizadas;
	}



	/**
	 * @param semanasCotizadas the semanasCotizadas to set
	 */
	public void setSemanasCotizadas(String semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}



	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}



	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	/**
	 * @return the aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}



	/**
	 * @param aseguradora the aseguradora to set
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}



	/**
	 * @return the actuarioAutorizado
	 */
	public String getActuarioAutorizado() {
		return actuarioAutorizado;
	}



	/**
	 * @param actuarioAutorizado the actuarioAutorizado to set
	 */
	public void setActuarioAutorizado(String actuarioAutorizado) {
		this.actuarioAutorizado = actuarioAutorizado;
	}



	/**
	 * @return the consecutivoTrabajador
	 */
	public String getConsecutivoTrabajador() {
		return consecutivoTrabajador;
	}



	/**
	 * @param consecutivoTrabajador the consecutivoTrabajador to set
	 */
	public void setConsecutivoTrabajador(String consecutivoTrabajador) {
		this.consecutivoTrabajador = consecutivoTrabajador;
	}



	/**
	 * @return the idSolicitante
	 */
	public String getIdSolicitante() {
		return idSolicitante;
	}



	/**
	 * @param idSolicitante the idSolicitante to set
	 */
	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
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
	 * @return the curpAgenteServicio
	 */
	public String getCurpAgenteServicio() {
		return curpAgenteServicio;
	}



	/**
	 * @param curpAgenteServicio the curpAgenteServicio to set
	 */
	public void setCurpAgenteServicio(String curpAgenteServicio) {
		this.curpAgenteServicio = curpAgenteServicio;
	}



	

	



	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}



	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}



	/**
	 * @return the apPaternoTrabajador
	 */
	public String getApPaternoTrabajador() {
		return apPaternoTrabajador;
	}



	/**
	 * @param apPaternoTrabajador the apPaternoTrabajador to set
	 */
	public void setApPaternoTrabajador(String apPaternoTrabajador) {
		this.apPaternoTrabajador = apPaternoTrabajador;
	}



	/**
	 * @return the apMaternoTrabajador
	 */
	public String getApMaternoTrabajador() {
		return apMaternoTrabajador;
	}



	/**
	 * @param apMaternoTrabajador the apMaternoTrabajador to set
	 */
	public void setApMaternoTrabajador(String apMaternoTrabajador) {
		this.apMaternoTrabajador = apMaternoTrabajador;
	}



	/**
	 * @return the regimen
	 */
	public String getRegimen() {
		return regimen;
	}



	/**
	 * @param regimen the regimen to set
	 */
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}



	/**
	 * @return the porcentajeValuacion
	 */
	public Double getPorcentajeValuacion() {
		return porcentajeValuacion;
	}



	/**
	 * @param porcentajeValuacion the porcentajeValuacion to set
	 */
	public void setPorcentajeValuacion(Double porcentajeValuacion) {
		this.porcentajeValuacion = porcentajeValuacion;
	}



	/**
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}



	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}



	/**
	 * @return the cveDocProbatorio
	 */
	public String getCveDocProbatorio() {
		return cveDocProbatorio;
	}



	/**
	 * @param cveDocProbatorio the cveDocProbatorio to set
	 */
	public void setCveDocProbatorio(String cveDocProbatorio) {
		this.cveDocProbatorio = cveDocProbatorio;
	}



	/**
	 * @return the numPlanPrivadoPensiones
	 */
	public String getNumPlanPrivadoPensiones() {
		return numPlanPrivadoPensiones;
	}



	/**
	 * @param numPlanPrivadoPensiones the numPlanPrivadoPensiones to set
	 */
	public void setNumPlanPrivadoPensiones(String numPlanPrivadoPensiones) {
		this.numPlanPrivadoPensiones = numPlanPrivadoPensiones;
	}



	/**
	 * @return the fechaPeriodoPagoReingreso
	 */
	public String getFechaPeriodoPagoReingreso() {
		return fechaPeriodoPagoReingreso;
	}



	/**
	 * @param fechaPeriodoPagoReingreso the fechaPeriodoPagoReingreso to set
	 */
	public void setFechaPeriodoPagoReingreso(String fechaPeriodoPagoReingreso) {
		this.fechaPeriodoPagoReingreso = fechaPeriodoPagoReingreso;
	}



	/**
	 * @return the selloUnico
	 */
	public String getSelloUnico() {
		return selloUnico;
	}



	/**
	 * @param selloUnico the selloUnico to set
	 */
	public void setSelloUnico(String selloUnico) {
		this.selloUnico = selloUnico;
	}



	/**
	 * @return the idBeneficiario
	 */
	public String getIdBeneficiario() {
		return idBeneficiario;
	}



	/**
	 * @param idBeneficiario the idBeneficiario to set
	 */
	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}



	/**
	 * @return the clabePago
	 */
	public String getClabePago() {
		return clabePago;
	}



	/**
	 * @param clabePago the clabePago to set
	 */
	public void setClabePago(String clabePago) {
		this.clabePago = clabePago;
	}



	/**
	 * @return the curpPago
	 */
	public String getCurpPago() {
		return curpPago;
	}



	/**
	 * @param curpPago the curpPago to set
	 */
	public void setCurpPago(String curpPago) {
		this.curpPago = curpPago;
	}



	/**
	 * @return the apPaternoBeneficiario
	 */
	public String getApPaternoBeneficiario() {
		return apPaternoBeneficiario;
	}



	/**
	 * @param apPaternoBeneficiario the apPaternoBeneficiario to set
	 */
	public void setApPaternoBeneficiario(String apPaternoBeneficiario) {
		this.apPaternoBeneficiario = apPaternoBeneficiario;
	}



	/**
	 * @return the apMaternoBeneficiario
	 */
	public String getApMaternoBeneficiario() {
		return apMaternoBeneficiario;
	}



	/**
	 * @param apMaternoBeneficiario the apMaternoBeneficiario to set
	 */
	public void setApMaternoBeneficiario(String apMaternoBeneficiario) {
		this.apMaternoBeneficiario = apMaternoBeneficiario;
	}



	/**
	 * @return the nombreBeneficiario
	 */
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}



	/**
	 * @param nombreBeneficiario the nombreBeneficiario to set
	 */
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}



	/**
	 * @return the rfcPago
	 */
	public String getRfcPago() {
		return rfcPago;
	}



	/**
	 * @param rfcPago the rfcPago to set
	 */
	public void setRfcPago(String rfcPago) {
		this.rfcPago = rfcPago;
	}



	/**
	 * @return the folioInfonavit
	 */
	public String getFolioInfonavit() {
		return folioInfonavit;
	}



	/**
	 * @param folioInfonavit the folioInfonavit to set
	 */
	public void setFolioInfonavit(String folioInfonavit) {
		this.folioInfonavit = folioInfonavit;
	}



	/**
	 * @return the tipoVentanilla
	 */
	public String getTipoVentanilla() {
		return tipoVentanilla;
	}



	/**
	 * @param tipoVentanilla the tipoVentanilla to set
	 */
	public void setTipoVentanilla(String tipoVentanilla) {
		this.tipoVentanilla = tipoVentanilla;
	}



	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}



	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	/**
	 * @return the montosRCV
	 */
	public List<AccionSieforeImss> getMontosRCV() {
		return montosRCV;
	}



	/**
	 * @param montosRCV the montosRCV to set
	 */
	public void setMontosRCV(List<AccionSieforeImss> montosRCV) {
		this.montosRCV = montosRCV;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
