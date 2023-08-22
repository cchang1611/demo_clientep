/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author jmcabrer
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValidarSolicitudCertificacionAforeSalida implements Serializable {

	/**
	 * serial id
	 */
	private static final long serialVersionUID = -4662711272227864100L;
	
	/**
	 * resultado Operacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String resultadoOperacion;
	/**
	 * diagnostico Cuenta Individual
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String diagnosticoProcesar;
	/**
	 * entidad Origen 
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String entidadOrigen;
	/**
	 * tipo De Tramite
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoTramite;
	/**
	 * nss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	/**
	 * curp
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	/**
	 * nombre Trabajador Imss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajadorImss;
	/**
	 * nombre Trabajador Procanase
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajadorProcanase;
	/**
	 * nombre Trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajador;
	/**
	 * apellido Paterno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apellidoPaterno;
	/**
	 * apellido Materno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apellidoMaterno;
	/**
	 * tipo De Prestacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoPrestacion;
	/**
	 * fecha Matrimonio Desempleo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaMatrimonioDesempleo;
	/**
	 * fecha Notificacion Imss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaNotificacionImss;
	/**
	 * fecha Conclusion Vigencia
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaConclusionVigencia;
	/**
	 * numero Resolucion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String numeroResolucion;
	/**
	 * diagnostico Cuenta Individual
	 */
//	private String descDiagnosticoCuentaIndividual;
	/**
	 * tipo Trabajador Aportacion Cuota Social
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoTrabAportacionCuotaSocial;
	/**
	 * sbc TipoA
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String sbcTipoA;
	/**
	 * sbcT ipoB
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String sbcTipoB;
	/**
	 * idPago Complementario
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idPagoComplementario;
	/**
	 * monto Pagado Retiro Original
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String montoPagadoRetiroOriginal;
	/**
	 * saldo Anterior Pago Retir oOriginal
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String saldoAnteriorPagoRetiroOriginal;
	/**
	 * folio Operacion IMSS
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioOperacionIMSS;
	/**
	 * delegacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String delegacion;
	/**
	 * subdelegacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String subdelegacion;
	/**
	 * umf
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String umf;
	/**
	 * fecha Prest Tramite
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaPrestTramite;
	/**
	 * fecha Baja Trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaBajaTrabajador;
	/**
	 * numero Consecutivo Procesar
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String numeroConsecutivoProcesar;
	/**
	 * total Resoluciones Procesar
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String totalResolucionesProcesar;
	/**
	 * clave Admin Actual
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveAdminActual;
	/**
	 * origen
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String origen;
	/**
	 * idSolicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idSolicitante;
	/**
	 * curp Solicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpSolicitante;
	/**
	 * sello Trabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String selloTrabajador;
	/**
	 * curp Agente Servicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpAgenteServicio;
	/**
	 * @return el atributo resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}
	/**
	 * @param resultadoOperacion parametro resultadoOperacion a actualizar
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	/**
	 * @return el atributo diagnosticoProcesar
	 */
	public String getDiagnosticoProcesar() {
		return diagnosticoProcesar;
	}
	/**
	 * @param diagnosticoProcesar parametro diagnosticoProcesar a actualizar
	 */
	public void setDiagnosticoProcesar(String diagnosticoProcesar) {
		this.diagnosticoProcesar = diagnosticoProcesar;
	}
	/**
	 * @return el atributo entidadOrigen
	 */
	public String getEntidadOrigen() {
		return entidadOrigen;
	}
	/**
	 * @param entidadOrigen parametro entidadOrigen a actualizar
	 */
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}
	/**
	 * @return el atributo tipoTramite
	 */
	public String getTipoTramite() {
		return tipoTramite;
	}
	/**
	 * @param tipoTramite parametro tipoTramite a actualizar
	 */
	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}
	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}
	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
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
	 * @return el atributo nombreTrabajadorImss
	 */
	public String getNombreTrabajadorImss() {
		return nombreTrabajadorImss;
	}
	/**
	 * @param nombreTrabajadorImss parametro nombreTrabajadorImss a actualizar
	 */
	public void setNombreTrabajadorImss(String nombreTrabajadorImss) {
		this.nombreTrabajadorImss = nombreTrabajadorImss;
	}
	/**
	 * @return el atributo nombreTrabajadorProcanase
	 */
	public String getNombreTrabajadorProcanase() {
		return nombreTrabajadorProcanase;
	}
	/**
	 * @param nombreTrabajadorProcanase parametro nombreTrabajadorProcanase a actualizar
	 */
	public void setNombreTrabajadorProcanase(String nombreTrabajadorProcanase) {
		this.nombreTrabajadorProcanase = nombreTrabajadorProcanase;
	}
	/**
	 * @return el atributo nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}
	/**
	 * @param nombreTrabajador parametro nombreTrabajador a actualizar
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * @return el atributo apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}
	/**
	 * @param tipoPrestacion parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}
	/**
	 * @return el atributo fechaMatrimonioDesempleo
	 */
	public String getFechaMatrimonioDesempleo() {
		return fechaMatrimonioDesempleo;
	}
	/**
	 * @param fechaMatrimonioDesempleo parametro fechaMatrimonioDesempleo a actualizar
	 */
	public void setFechaMatrimonioDesempleo(String fechaMatrimonioDesempleo) {
		this.fechaMatrimonioDesempleo = fechaMatrimonioDesempleo;
	}
	/**
	 * @return el atributo fechaNotificacionImss
	 */
	public String getFechaNotificacionImss() {
		return fechaNotificacionImss;
	}
	/**
	 * @param fechaNotificacionImss parametro fechaNotificacionImss a actualizar
	 */
	public void setFechaNotificacionImss(String fechaNotificacionImss) {
		this.fechaNotificacionImss = fechaNotificacionImss;
	}
	/**
	 * @return el atributo fechaConclusionVigencia
	 */
	public String getFechaConclusionVigencia() {
		return fechaConclusionVigencia;
	}
	/**
	 * @param fechaConclusionVigencia parametro fechaConclusionVigencia a actualizar
	 */
	public void setFechaConclusionVigencia(String fechaConclusionVigencia) {
		this.fechaConclusionVigencia = fechaConclusionVigencia;
	}
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
	 * @return el atributo tipoTrabAportacionCuotaSocial
	 */
	public String getTipoTrabAportacionCuotaSocial() {
		return tipoTrabAportacionCuotaSocial;
	}
	/**
	 * @param tipoTrabAportacionCuotaSocial parametro tipoTrabAportacionCuotaSocial a actualizar
	 */
	public void setTipoTrabAportacionCuotaSocial(String tipoTrabAportacionCuotaSocial) {
		this.tipoTrabAportacionCuotaSocial = tipoTrabAportacionCuotaSocial;
	}
	/**
	 * @return el atributo sbcTipoA
	 */
	public String getSbcTipoA() {
		return sbcTipoA;
	}
	/**
	 * @param sbcTipoA parametro sbcTipoA a actualizar
	 */
	public void setSbcTipoA(String sbcTipoA) {
		this.sbcTipoA = sbcTipoA;
	}
	/**
	 * @return el atributo sbcTipoB
	 */
	public String getSbcTipoB() {
		return sbcTipoB;
	}
	/**
	 * @param sbcTipoB parametro sbcTipoB a actualizar
	 */
	public void setSbcTipoB(String sbcTipoB) {
		this.sbcTipoB = sbcTipoB;
	}
	/**
	 * @return el atributo idPagoComplementario
	 */
	public String getIdPagoComplementario() {
		return idPagoComplementario;
	}
	/**
	 * @param idPagoComplementario parametro idPagoComplementario a actualizar
	 */
	public void setIdPagoComplementario(String idPagoComplementario) {
		this.idPagoComplementario = idPagoComplementario;
	}
	/**
	 * @return el atributo montoPagadoRetiroOriginal
	 */
	public String getMontoPagadoRetiroOriginal() {
		return montoPagadoRetiroOriginal;
	}
	/**
	 * @param montoPagadoRetiroOriginal parametro montoPagadoRetiroOriginal a actualizar
	 */
	public void setMontoPagadoRetiroOriginal(String montoPagadoRetiroOriginal) {
		this.montoPagadoRetiroOriginal = montoPagadoRetiroOriginal;
	}
	/**
	 * @return el atributo saldoAnteriorPagoRetiroOriginal
	 */
	public String getSaldoAnteriorPagoRetiroOriginal() {
		return saldoAnteriorPagoRetiroOriginal;
	}
	/**
	 * @param saldoAnteriorPagoRetiroOriginal parametro saldoAnteriorPagoRetiroOriginal a actualizar
	 */
	public void setSaldoAnteriorPagoRetiroOriginal(String saldoAnteriorPagoRetiroOriginal) {
		this.saldoAnteriorPagoRetiroOriginal = saldoAnteriorPagoRetiroOriginal;
	}
	/**
	 * @return el atributo folioOperacionIMSS
	 */
	public String getFolioOperacionIMSS() {
		return folioOperacionIMSS;
	}
	/**
	 * @param folioOperacionIMSS parametro folioOperacionIMSS a actualizar
	 */
	public void setFolioOperacionIMSS(String folioOperacionIMSS) {
		this.folioOperacionIMSS = folioOperacionIMSS;
	}
	/**
	 * @return el atributo delegacion
	 */
	public String getDelegacion() {
		return delegacion;
	}
	/**
	 * @param delegacion parametro delegacion a actualizar
	 */
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	/**
	 * @return el atributo subdelegacion
	 */
	public String getSubdelegacion() {
		return subdelegacion;
	}
	/**
	 * @param subdelegacion parametro subdelegacion a actualizar
	 */
	public void setSubdelegacion(String subdelegacion) {
		this.subdelegacion = subdelegacion;
	}
	/**
	 * @return el atributo umf
	 */
	public String getUmf() {
		return umf;
	}
	/**
	 * @param umf parametro umf a actualizar
	 */
	public void setUmf(String umf) {
		this.umf = umf;
	}
	/**
	 * @return el atributo fechaPrestTramite
	 */
	public String getFechaPrestTramite() {
		return fechaPrestTramite;
	}
	/**
	 * @param fechaPrestTramite parametro fechaPrestTramite a actualizar
	 */
	public void setFechaPrestTramite(String fechaPrestTramite) {
		this.fechaPrestTramite = fechaPrestTramite;
	}
	/**
	 * @return el atributo fechaBajaTrabajador
	 */
	public String getFechaBajaTrabajador() {
		return fechaBajaTrabajador;
	}
	/**
	 * @param fechaBajaTrabajador parametro fechaBajaTrabajador a actualizar
	 */
	public void setFechaBajaTrabajador(String fechaBajaTrabajador) {
		this.fechaBajaTrabajador = fechaBajaTrabajador;
	}
	/**
	 * @return el atributo numeroConsecutivoProcesar
	 */
	public String getNumeroConsecutivoProcesar() {
		return numeroConsecutivoProcesar;
	}
	/**
	 * @param numeroConsecutivoProcesar parametro numeroConsecutivoProcesar a actualizar
	 */
	public void setNumeroConsecutivoProcesar(String numeroConsecutivoProcesar) {
		this.numeroConsecutivoProcesar = numeroConsecutivoProcesar;
	}
	/**
	 * @return el atributo totalResolucionesProcesar
	 */
	public String getTotalResolucionesProcesar() {
		return totalResolucionesProcesar;
	}
	/**
	 * @param totalResolucionesProcesar parametro totalResolucionesProcesar a actualizar
	 */
	public void setTotalResolucionesProcesar(String totalResolucionesProcesar) {
		this.totalResolucionesProcesar = totalResolucionesProcesar;
	}
	/**
	 * @return el atributo claveAdminActual
	 */
	public String getClaveAdminActual() {
		return claveAdminActual;
	}
	/**
	 * @param claveAdminActual parametro claveAdminActual a actualizar
	 */
	public void setClaveAdminActual(String claveAdminActual) {
		this.claveAdminActual = claveAdminActual;
	}
	/**
	 * @return el atributo origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen parametro origen a actualizar
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return el atributo idSolicitante
	 */
	public String getIdSolicitante() {
		return idSolicitante;
	}
	/**
	 * @param idSolicitante parametro idSolicitante a actualizar
	 */
	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
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
	 * @return el atributo selloTrabajador
	 */
	public String getSelloTrabajador() {
		return selloTrabajador;
	}
	/**
	 * @param selloTrabajador parametro selloTrabajador a actualizar
	 */
	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
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
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidarSolicitudCertificacionAforeSalida [resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnosticoProcesar=");
		builder.append(diagnosticoProcesar);
		builder.append(", entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", tipoTramite=");
		builder.append(tipoTramite);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nombreTrabajadorImss=");
		builder.append(nombreTrabajadorImss);
		builder.append(", nombreTrabajadorProcanase=");
		builder.append(nombreTrabajadorProcanase);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", fechaMatrimonioDesempleo=");
		builder.append(fechaMatrimonioDesempleo);
		builder.append(", fechaNotificacionImss=");
		builder.append(fechaNotificacionImss);
		builder.append(", fechaConclusionVigencia=");
		builder.append(fechaConclusionVigencia);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", tipoTrabAportacionCuotaSocial=");
		builder.append(tipoTrabAportacionCuotaSocial);
		builder.append(", sbcTipoA=");
		builder.append(sbcTipoA);
		builder.append(", sbcTipoB=");
		builder.append(sbcTipoB);
		builder.append(", idPagoComplementario=");
		builder.append(idPagoComplementario);
		builder.append(", montoPagadoRetiroOriginal=");
		builder.append(montoPagadoRetiroOriginal);
		builder.append(", saldoAnteriorPagoRetiroOriginal=");
		builder.append(saldoAnteriorPagoRetiroOriginal);
		builder.append(", folioOperacionIMSS=");
		builder.append(folioOperacionIMSS);
		builder.append(", delegacion=");
		builder.append(delegacion);
		builder.append(", subdelegacion=");
		builder.append(subdelegacion);
		builder.append(", umf=");
		builder.append(umf);
		builder.append(", fechaPrestTramite=");
		builder.append(fechaPrestTramite);
		builder.append(", fechaBajaTrabajador=");
		builder.append(fechaBajaTrabajador);
		builder.append(", numeroConsecutivoProcesar=");
		builder.append(numeroConsecutivoProcesar);
		builder.append(", totalResolucionesProcesar=");
		builder.append(totalResolucionesProcesar);
		builder.append(", claveAdminActual=");
		builder.append(claveAdminActual);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", idSolicitante=");
		builder.append(idSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", curpAgenteServicio=");
		builder.append(curpAgenteServicio);
		builder.append("]");
		return builder.toString();
	}
}
