package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Solicitar disposicion entrada
 * @author RARREOLA
 *
 */
public class SolicitarDisposicionEntrada  implements Serializable{
	

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
	 * Clave administradora
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveAfore;
	
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
	private String apellidoPaternoTrabajador;
	
	/**
	 * Apellido materno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apellidoMaternoTrabajador;
	
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
	private String tipoRegimen;
	
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
	 * Clave pension
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String clavePension;
	
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
	 * Semanas cotizadas
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Integer semanasCotizadas;
	
	/**
	 * Fecha solicitud trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaSolicitudTrabajador;
	
	/**
	 * Clave documento probatorio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveDoctoProbatorio;
	
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
	private String noPlanPrivado;
	
	/**
	 * Fecha periodo pago ingreso
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaPeriodoPago;
	
	/**
	 * Consecutivo trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Integer consecutivoTrabajador;
	
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
	private String selloUnicoVerificacion;
	
	/**
	 * Curp agente servicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpAgenteServicio;
	
	/**
	 * Monto sar 92
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double montoSar92;
	
	/**
	 * montoAivs2008
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double montoAivs2008;
	
	/**
	 * montoAivs1992
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Double montoAivs1992;
	
	
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
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}



	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
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
	 * @return the apellidoPaternoTrabajador
	 */
	public String getApellidoPaternoTrabajador() {
		return apellidoPaternoTrabajador;
	}



	/**
	 * @param apellidoPaternoTrabajador the apellidoPaternoTrabajador to set
	 */
	public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
		this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
	}



	/**
	 * @return the apellidoMaternoTrabajador
	 */
	public String getApellidoMaternoTrabajador() {
		return apellidoMaternoTrabajador;
	}



	/**
	 * @param apellidoMaternoTrabajador the apellidoMaternoTrabajador to set
	 */
	public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
		this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
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
	 * @return the tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}



	/**
	 * @param tipoRegimen the tipoRegimen to set
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
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
	 * @return the clavePension
	 */
	public String getClavePension() {
		return clavePension;
	}



	/**
	 * @param clavePension the clavePension to set
	 */
	public void setClavePension(String clavePension) {
		this.clavePension = clavePension;
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
	public Integer getSemanasCotizadas() {
		return semanasCotizadas;
	}



	/**
	 * @param semanasCotizadas the semanasCotizadas to set
	 */
	public void setSemanasCotizadas(Integer semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}



	/**
	 * @return the fechaSolicitudTrabajador
	 */
	public String getFechaSolicitudTrabajador() {
		return fechaSolicitudTrabajador;
	}



	/**
	 * @param fechaSolicitudTrabajador the fechaSolicitudTrabajador to set
	 */
	public void setFechaSolicitudTrabajador(String fechaSolicitudTrabajador) {
		this.fechaSolicitudTrabajador = fechaSolicitudTrabajador;
	}



	/**
	 * @return the claveDoctoProbatorio
	 */
	public String getClaveDoctoProbatorio() {
		return claveDoctoProbatorio;
	}



	/**
	 * @param claveDoctoProbatorio the claveDoctoProbatorio to set
	 */
	public void setClaveDoctoProbatorio(String claveDoctoProbatorio) {
		this.claveDoctoProbatorio = claveDoctoProbatorio;
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
	 * @return the noPlanPrivado
	 */
	public String getNoPlanPrivado() {
		return noPlanPrivado;
	}



	/**
	 * @param noPlanPrivado the noPlanPrivado to set
	 */
	public void setNoPlanPrivado(String noPlanPrivado) {
		this.noPlanPrivado = noPlanPrivado;
	}



	/**
	 * @return the fechaPeriodoPago
	 */
	public String getFechaPeriodoPago() {
		return fechaPeriodoPago;
	}



	/**
	 * @param fechaPeriodoPago the fechaPeriodoPago to set
	 */
	public void setFechaPeriodoPago(String fechaPeriodoPago) {
		this.fechaPeriodoPago = fechaPeriodoPago;
	}



	/**
	 * @return the consecutivoTrabajador
	 */
	public Integer getConsecutivoTrabajador() {
		return consecutivoTrabajador;
	}



	/**
	 * @param consecutivoTrabajador the consecutivoTrabajador to set
	 */
	public void setConsecutivoTrabajador(Integer consecutivoTrabajador) {
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
	 * @return the selloUnicoVerificacion
	 */
	public String getSelloUnicoVerificacion() {
		return selloUnicoVerificacion;
	}



	/**
	 * @param selloUnicoVerificacion the selloUnicoVerificacion to set
	 */
	public void setSelloUnicoVerificacion(String selloUnicoVerificacion) {
		this.selloUnicoVerificacion = selloUnicoVerificacion;
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
	 * @return the montoSar92
	 */
	public Double getMontoSar92() {
		return montoSar92;
	}



	/**
	 * @param montoSar92 the montoSar92 to set
	 */
	public void setMontoSar92(Double montoSar92) {
		this.montoSar92 = montoSar92;
	}



	/**
	 * @return the montoAivs2008
	 */
	public Double getMontoAivs2008() {
		return montoAivs2008;
	}



	/**
	 * @param montoAivs2008 the montoAivs2008 to set
	 */
	public void setMontoAivs2008(Double montoAivs2008) {
		this.montoAivs2008 = montoAivs2008;
	}



	/**
	 * @return the montoAivs1992
	 */
	public Double getMontoAivs1992() {
		return montoAivs1992;
	}



	/**
	 * @param montoAivs1992 the montoAivs1992 to set
	 */
	public void setMontoAivs1992(Double montoAivs1992) {
		this.montoAivs1992 = montoAivs1992;
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
