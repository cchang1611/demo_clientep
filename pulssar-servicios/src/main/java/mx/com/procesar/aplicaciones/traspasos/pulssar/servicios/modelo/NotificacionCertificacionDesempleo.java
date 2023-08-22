/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa la entidad NotificacionCertificacionDesempleo
 * @author MGONZALE
 *
 */
public class NotificacionCertificacionDesempleo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3282219093411440167L;

	/**
	 * idNotifCertDesempleo
	 */
	private Long idNotifCertDesempleo;

	/**
	 * afore
	 */
	private String afore;

	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;

	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;

	/**
	 * consecutivoProcesar
	 */
	private String consecutivoProcesar;

	/**
	 * curpAgenteServ
	 */
	private String curpAgenteServ;

	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;

	/**
	 * delegacion
	 */
	private String delegacion;

	/**
	 * descDiagnosticoRecepcion
	 */
	private String descDiagnosticoRecepcion;

	/**
	 * diagnosticoRecepcion
	 */
	private String diagnosticoRecepcion;

	/**
	 * folio
	 */
	private String folio;

	/**
	 * folioAdministradora
	 */
	private String folioAdministradora;

	/**
	 * folioOperacionImss
	 */
	private String folioOperacionImss;

	/**
	 * idSolicitante
	 */
	private String idSolicitante;

	/**
	 * nombre
	 */
	private String nombre;

	/**
	 * nombreImss
	 */
	private String nombreImss;

	/**
	 * nombreProcanase
	 */
	private String nombreProcanase;

	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;

	/**
	 * origen
	 */
	private String origen;

	/**
	 * pagoComplementario
	 */
	private String pagoComplementario;

	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	/**
	 * selloTrabajador
	 */
	private String selloTrabajador;

	/**
	 * subdelegacion
	 */
	private String subdelegacion;

	/**
	 * tipoPrestacion
	 */
	private String tipoPrestacion;

	/**
	 * tipoTrabApCs
	 */
	private String tipoTrabApCs;

	/**
	 * tipoTramite
	 */
	private String tipoTramite;

	/**
	 * totResolucionesProc
	 */
	private String totResolucionesProc;

	/**
	 * umf
	 */
	private String umf;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * claveAdminAct
	 */
	private String claveAdminAct;

	/**
	 * fechaBajaTrabajador
	 */
	private Date fechaBajaTrabajador;

	/**
	 * fechaConclusionVigencia
	 */
	private Date fechaConclusionVigencia;

	/**
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * fechaMatrimonioDesemp
	 */
	private Date fechaMatrimonioDesemp;

	/**
	 * fechaNotificacionImss
	 */
	private Date fechaNotificacionImss;

	/**
	 * fechaNotificado
	 */
	private Date fechaNotificado;

	/**
	 * fechaPrestacionTramite
	 */
	private Date fechaPrestacionTramite;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * montoAntRetiroOriginal
	 */
	private BigDecimal montoAntRetiroOriginal;

	/**
	 * montoPagRetiroOriginal
	 */
	private BigDecimal montoPagRetiroOriginal;

	/**
	 * notificado
	 */
	private BigDecimal notificado;

	/**
	 * sbcTipoa
	 */
	private BigDecimal sbcTipoa;

	/**
	 * sbcTipob
	 */
	private BigDecimal sbcTipob;

	/**
	 * @return the idNotifCertDesempleo
	 */
	public Long getIdNotifCertDesempleo() {
		return idNotifCertDesempleo;
	}

	/**
	 * @param idNotifCertDesempleo the idNotifCertDesempleo to set
	 */
	public void setIdNotifCertDesempleo(Long idNotifCertDesempleo) {
		this.idNotifCertDesempleo = idNotifCertDesempleo;
	}

	/**
	 * @return the afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore the afore to set
	 */
	public void setAfore(String afore) {
		this.afore = afore;
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
	 * @return the consecutivoProcesar
	 */
	public String getConsecutivoProcesar() {
		return consecutivoProcesar;
	}

	/**
	 * @param consecutivoProcesar the consecutivoProcesar to set
	 */
	public void setConsecutivoProcesar(String consecutivoProcesar) {
		this.consecutivoProcesar = consecutivoProcesar;
	}

	/**
	 * @return the curpAgenteServ
	 */
	public String getCurpAgenteServ() {
		return curpAgenteServ;
	}

	/**
	 * @param curpAgenteServ the curpAgenteServ to set
	 */
	public void setCurpAgenteServ(String curpAgenteServ) {
		this.curpAgenteServ = curpAgenteServ;
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
	 * @return the delegacion
	 */
	public String getDelegacion() {
		return delegacion;
	}

	/**
	 * @param delegacion the delegacion to set
	 */
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	/**
	 * @return the descDiagnosticoRecepcion
	 */
	public String getDescDiagnosticoRecepcion() {
		return descDiagnosticoRecepcion;
	}

	/**
	 * @param descDiagnosticoRecepcion the descDiagnosticoRecepcion to set
	 */
	public void setDescDiagnosticoRecepcion(String descDiagnosticoRecepcion) {
		this.descDiagnosticoRecepcion = descDiagnosticoRecepcion;
	}

	/**
	 * @return the diagnosticoRecepcion
	 */
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}

	/**
	 * @param diagnosticoRecepcion the diagnosticoRecepcion to set
	 */
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the folioAdministradora
	 */
	public String getFolioAdministradora() {
		return folioAdministradora;
	}

	/**
	 * @param folioAdministradora the folioAdministradora to set
	 */
	public void setFolioAdministradora(String folioAdministradora) {
		this.folioAdministradora = folioAdministradora;
	}

	/**
	 * @return the folioOperacionImss
	 */
	public String getFolioOperacionImss() {
		return folioOperacionImss;
	}

	/**
	 * @param folioOperacionImss the folioOperacionImss to set
	 */
	public void setFolioOperacionImss(String folioOperacionImss) {
		this.folioOperacionImss = folioOperacionImss;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombreImss
	 */
	public String getNombreImss() {
		return nombreImss;
	}

	/**
	 * @param nombreImss the nombreImss to set
	 */
	public void setNombreImss(String nombreImss) {
		this.nombreImss = nombreImss;
	}

	/**
	 * @return the nombreProcanase
	 */
	public String getNombreProcanase() {
		return nombreProcanase;
	}

	/**
	 * @param nombreProcanase the nombreProcanase to set
	 */
	public void setNombreProcanase(String nombreProcanase) {
		this.nombreProcanase = nombreProcanase;
	}

	/**
	 * @return the numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion the numeroResolucion to set
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the pagoComplementario
	 */
	public String getPagoComplementario() {
		return pagoComplementario;
	}

	/**
	 * @param pagoComplementario the pagoComplementario to set
	 */
	public void setPagoComplementario(String pagoComplementario) {
		this.pagoComplementario = pagoComplementario;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the selloTrabajador
	 */
	public String getSelloTrabajador() {
		return selloTrabajador;
	}

	/**
	 * @param selloTrabajador the selloTrabajador to set
	 */
	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}

	/**
	 * @return the subdelegacion
	 */
	public String getSubdelegacion() {
		return subdelegacion;
	}

	/**
	 * @param subdelegacion the subdelegacion to set
	 */
	public void setSubdelegacion(String subdelegacion) {
		this.subdelegacion = subdelegacion;
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
	 * @return the tipoTrabApCs
	 */
	public String getTipoTrabApCs() {
		return tipoTrabApCs;
	}

	/**
	 * @param tipoTrabApCs the tipoTrabApCs to set
	 */
	public void setTipoTrabApCs(String tipoTrabApCs) {
		this.tipoTrabApCs = tipoTrabApCs;
	}

	/**
	 * @return the tipoTramite
	 */
	public String getTipoTramite() {
		return tipoTramite;
	}

	/**
	 * @param tipoTramite the tipoTramite to set
	 */
	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	/**
	 * @return the totResolucionesProc
	 */
	public String getTotResolucionesProc() {
		return totResolucionesProc;
	}

	/**
	 * @param totResolucionesProc the totResolucionesProc to set
	 */
	public void setTotResolucionesProc(String totResolucionesProc) {
		this.totResolucionesProc = totResolucionesProc;
	}

	/**
	 * @return the umf
	 */
	public String getUmf() {
		return umf;
	}

	/**
	 * @param umf the umf to set
	 */
	public void setUmf(String umf) {
		this.umf = umf;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
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
	 * @return the claveAdminAct
	 */
	public String getClaveAdminAct() {
		return claveAdminAct;
	}

	/**
	 * @param claveAdminAct the claveAdminAct to set
	 */
	public void setClaveAdminAct(String claveAdminAct) {
		this.claveAdminAct = claveAdminAct;
	}

	/**
	 * @return the fechaBajaTrabajador
	 */
	public Date getFechaBajaTrabajador() {
		return fechaBajaTrabajador;
	}

	/**
	 * @param fechaBajaTrabajador the fechaBajaTrabajador to set
	 */
	public void setFechaBajaTrabajador(Date fechaBajaTrabajador) {
		this.fechaBajaTrabajador = fechaBajaTrabajador;
	}

	/**
	 * @return the fechaConclusionVigencia
	 */
	public Date getFechaConclusionVigencia() {
		return fechaConclusionVigencia;
	}

	/**
	 * @param fechaConclusionVigencia the fechaConclusionVigencia to set
	 */
	public void setFechaConclusionVigencia(Date fechaConclusionVigencia) {
		this.fechaConclusionVigencia = fechaConclusionVigencia;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the fechaMatrimonioDesemp
	 */
	public Date getFechaMatrimonioDesemp() {
		return fechaMatrimonioDesemp;
	}

	/**
	 * @param fechaMatrimonioDesemp the fechaMatrimonioDesemp to set
	 */
	public void setFechaMatrimonioDesemp(Date fechaMatrimonioDesemp) {
		this.fechaMatrimonioDesemp = fechaMatrimonioDesemp;
	}

	/**
	 * @return the fechaNotificacionImss
	 */
	public Date getFechaNotificacionImss() {
		return fechaNotificacionImss;
	}

	/**
	 * @param fechaNotificacionImss the fechaNotificacionImss to set
	 */
	public void setFechaNotificacionImss(Date fechaNotificacionImss) {
		this.fechaNotificacionImss = fechaNotificacionImss;
	}

	/**
	 * @return the fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * @param fechaNotificado the fechaNotificado to set
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
	}

	/**
	 * @return the fechaPrestacionTramite
	 */
	public Date getFechaPrestacionTramite() {
		return fechaPrestacionTramite;
	}

	/**
	 * @param fechaPrestacionTramite the fechaPrestacionTramite to set
	 */
	public void setFechaPrestacionTramite(Date fechaPrestacionTramite) {
		this.fechaPrestacionTramite = fechaPrestacionTramite;
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
	 * @return the montoAntRetiroOriginal
	 */
	public BigDecimal getMontoAntRetiroOriginal() {
		return montoAntRetiroOriginal;
	}

	/**
	 * @param montoAntRetiroOriginal the montoAntRetiroOriginal to set
	 */
	public void setMontoAntRetiroOriginal(BigDecimal montoAntRetiroOriginal) {
		this.montoAntRetiroOriginal = montoAntRetiroOriginal;
	}

	/**
	 * @return the montoPagRetiroOriginal
	 */
	public BigDecimal getMontoPagRetiroOriginal() {
		return montoPagRetiroOriginal;
	}

	/**
	 * @param montoPagRetiroOriginal the montoPagRetiroOriginal to set
	 */
	public void setMontoPagRetiroOriginal(BigDecimal montoPagRetiroOriginal) {
		this.montoPagRetiroOriginal = montoPagRetiroOriginal;
	}

	/**
	 * @return the notificado
	 */
	public BigDecimal getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(BigDecimal notificado) {
		this.notificado = notificado;
	}

	/**
	 * @return the sbcTipoa
	 */
	public BigDecimal getSbcTipoa() {
		return sbcTipoa;
	}

	/**
	 * @param sbcTipoa the sbcTipoa to set
	 */
	public void setSbcTipoa(BigDecimal sbcTipoa) {
		this.sbcTipoa = sbcTipoa;
	}

	/**
	 * @return the sbcTipob
	 */
	public BigDecimal getSbcTipob() {
		return sbcTipob;
	}

	/**
	 * @param sbcTipob the sbcTipob to set
	 */
	public void setSbcTipob(BigDecimal sbcTipob) {
		this.sbcTipob = sbcTipob;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionCertificacionDesempleo [idNotifCertDesempleo=");
		builder.append(idNotifCertDesempleo);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", consecutivoProcesar=");
		builder.append(consecutivoProcesar);
		builder.append(", curpAgenteServ=");
		builder.append(curpAgenteServ);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", delegacion=");
		builder.append(delegacion);
		builder.append(", descDiagnosticoRecepcion=");
		builder.append(descDiagnosticoRecepcion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", folioAdministradora=");
		builder.append(folioAdministradora);
		builder.append(", folioOperacionImss=");
		builder.append(folioOperacionImss);
		builder.append(", idSolicitante=");
		builder.append(idSolicitante);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", nombreImss=");
		builder.append(nombreImss);
		builder.append(", nombreProcanase=");
		builder.append(nombreProcanase);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", pagoComplementario=");
		builder.append(pagoComplementario);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", subdelegacion=");
		builder.append(subdelegacion);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", tipoTrabApCs=");
		builder.append(tipoTrabApCs);
		builder.append(", tipoTramite=");
		builder.append(tipoTramite);
		builder.append(", totResolucionesProc=");
		builder.append(totResolucionesProc);
		builder.append(", umf=");
		builder.append(umf);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", claveAdminAct=");
		builder.append(claveAdminAct);
		builder.append(", fechaBajaTrabajador=");
		builder.append(fechaBajaTrabajador);
		builder.append(", fechaConclusionVigencia=");
		builder.append(fechaConclusionVigencia);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaMatrimonioDesemp=");
		builder.append(fechaMatrimonioDesemp);
		builder.append(", fechaNotificacionImss=");
		builder.append(fechaNotificacionImss);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", fechaPrestacionTramite=");
		builder.append(fechaPrestacionTramite);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", montoAntRetiroOriginal=");
		builder.append(montoAntRetiroOriginal);
		builder.append(", montoPagRetiroOriginal=");
		builder.append(montoPagRetiroOriginal);
		builder.append(", notificado=");
		builder.append(notificado);
		builder.append(", sbcTipoa=");
		builder.append(sbcTipoa);
		builder.append(", sbcTipob=");
		builder.append(sbcTipob);
		builder.append("]");
		return builder.toString();
	}

}
