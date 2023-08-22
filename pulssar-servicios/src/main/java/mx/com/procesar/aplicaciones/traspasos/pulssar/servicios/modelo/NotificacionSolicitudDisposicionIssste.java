package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class NotificacionSolicitudDisposicionIssste implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6930431133332072644L;

	/**
	 * idNotifSolDispIssste
	 */
	private Long idNotifSolDispIssste;

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
	 * curpAgenteServ
	 */
	private String curpAgenteServ;

	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;

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
	 * nombre
	 */
	private String nombre;

	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	/**
	 * secuenciaPension
	 */
	private String secuenciaPension;

	/**
	 * selloTrabajador
	 */
	private String selloTrabajador;

	/**
	 * tipoPrestacion
	 */
	private String tipoPrestacion;

	/**
	 * tipoRegimen
	 */
	private String tipoRegimen;

	/**
	 * tipoRetiro
	 */
	private String tipoRetiro;

	/**
	 * tipoSolicitante
	 */
	private String tipoSolicitante;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * numConcesion
	 */
	private String concesion;

	/**
	 * numIssste
	 */
	private String numIssste;

	/**
	 * numNotificado
	 */
	private BigDecimal numNotificado;

	/**
	 * numOrigenSolicitud
	 */
	private String origenSolicitud;

	/**
	 * imptRetiro92
	 */
	private BigDecimal impteRetiro92;
	
	/**
	 * tramite
	 */
	private String tramite; 	

	/**
	 * fechaNotificado
	 */
	private Date fechaNotificado;

	/**
	 * @return el atributo idNotifSolDispIssste
	 */
	public Long getIdNotifSolDispIssste() {
		return idNotifSolDispIssste;
	}

	/**
	 * @param idNotifSolDispIssste parametro idNotifSolDispIssste a actualizar
	 */
	public void setIdNotifSolDispIssste(Long idNotifSolDispIssste) {
		this.idNotifSolDispIssste = idNotifSolDispIssste;
	}

	/**
	 * @return el atributo afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore parametro afore a actualizar
	 */
	public void setAfore(String afore) {
		this.afore = afore;
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
	 * @return el atributo curpAgenteServ
	 */
	public String getCurpAgenteServ() {
		return curpAgenteServ;
	}

	/**
	 * @param curpAgenteServ parametro curpAgenteServ a actualizar
	 */
	public void setCurpAgenteServ(String curpAgenteServ) {
		this.curpAgenteServ = curpAgenteServ;
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
	 * @return el atributo descDiagnosticoRecepcion
	 */
	public String getDescDiagnosticoRecepcion() {
		return descDiagnosticoRecepcion;
	}

	/**
	 * @param descDiagnosticoRecepcion parametro descDiagnosticoRecepcion a actualizar
	 */
	public void setDescDiagnosticoRecepcion(String descDiagnosticoRecepcion) {
		this.descDiagnosticoRecepcion = descDiagnosticoRecepcion;
	}

	/**
	 * @return el atributo diagnosticoRecepcion
	 */
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}

	/**
	 * @param diagnosticoRecepcion parametro diagnosticoRecepcion a actualizar
	 */
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
	}

	/**
	 * @return el atributo folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio parametro folio a actualizar
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
	 * @return el atributo tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * @param tipoRegimen parametro tipoRegimen a actualizar
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * @return el atributo tipoRetiro
	 */
	public String getTipoRetiro() {
		return tipoRetiro;
	}

	/**
	 * @param tipoRetiro parametro tipoRetiro a actualizar
	 */
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}

	/**
	 * @return el atributo tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante parametro tipoSolicitante a actualizar
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
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
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
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
	 * @return el atributo concesion
	 */
	public String getConcesion() {
		return concesion;
	}

	/**
	 * @param concesion parametro concesion a actualizar
	 */
	public void setConcesion(String concesion) {
		this.concesion = concesion;
	}

	/**
	 * @return el atributo numIssste
	 */
	public String getNumIssste() {
		return numIssste;
	}

	/**
	 * @param numIssste parametro numIssste a actualizar
	 */
	public void setNumIssste(String numIssste) {
		this.numIssste = numIssste;
	}

	/**
	 * @return el atributo numNotificado
	 */
	public BigDecimal getNumNotificado() {
		return numNotificado;
	}

	/**
	 * @param numNotificado parametro numNotificado a actualizar
	 */
	public void setNumNotificado(BigDecimal numNotificado) {
		this.numNotificado = numNotificado;
	}

	/**
	 * @return el atributo origenSolicitud
	 */
	public String getOrigenSolicitud() {
		return origenSolicitud;
	}

	/**
	 * @param origenSolicitud parametro origenSolicitud a actualizar
	 */
	public void setOrigenSolicitud(String origenSolicitud) {
		this.origenSolicitud = origenSolicitud;
	}

	/**
	 * @return el atributo impteRetiro92
	 */
	public BigDecimal getImpteRetiro92() {
		return impteRetiro92;
	}

	/**
	 * @param impteRetiro92 parametro impteRetiro92 a actualizar
	 */
	public void setImpteRetiro92(BigDecimal impteRetiro92) {
		this.impteRetiro92 = impteRetiro92;
	}

	/**
	 * @return el atributo tramite
	 */
	public String getTramite() {
		return tramite;
	}

	/**
	 * @param tramite parametro tramite a actualizar
	 */
	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	/**
	 * @return el atributo fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * @param fechaNotificado parametro fechaNotificado a actualizar
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionSolicitudDisposicionIssste [idNotifSolDispIssste=");
		builder.append(idNotifSolDispIssste);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", curpAgenteServ=");
		builder.append(curpAgenteServ);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", descDiagnosticoRecepcion=");
		builder.append(descDiagnosticoRecepcion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", tipoRegimen=");
		builder.append(tipoRegimen);
		builder.append(", tipoRetiro=");
		builder.append(tipoRetiro);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", concesion=");
		builder.append(concesion);
		builder.append(", numIssste=");
		builder.append(numIssste);
		builder.append(", numNotificado=");
		builder.append(numNotificado);
		builder.append(", origenSolicitud=");
		builder.append(origenSolicitud);
		builder.append(", impteRetiro92=");
		builder.append(impteRetiro92);
		builder.append(", tramite=");
		builder.append(tramite);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append("]");
		return builder.toString();
	}
	
	
}