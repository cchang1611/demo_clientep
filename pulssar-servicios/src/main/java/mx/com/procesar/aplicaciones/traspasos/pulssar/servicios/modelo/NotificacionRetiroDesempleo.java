package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa la entidad NotificacionRetiroDesempleo
 * @author MGONZALE
 *
 */
public class NotificacionRetiroDesempleo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9141503349908760400L;
	
	/**
	 * idNotifRetDesempleo
	 */
	private Long idNotifRetDesempleo;

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
	 * curpFuncionarioAut
	 */
	private String curpFuncionarioAut;

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
	 * folioAdministradora
	 */
	private String folioAdministradora;

	/**
	 * idSolicitante
	 */
	private String idSolicitante;

	/**
	 * nombre
	 */
	private String nombre;

	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;

	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;

	/**
	 * selloFuncionarioAut
	 */
	private String selloFuncionarioAut;

	/**
	 * selloTrabajador
	 */
	private String selloTrabajador;

	/**
	 * tipoPrestacion
	 */
	private String tipoPrestacion;

	/**
	 * tipoRetiro
	 */
	private String tipoRetiro;

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
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * fechaNotificado
	 */
	private Date fechaNotificado;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * notificado
	 */
	private BigDecimal notificado;

	/**
	 * @return the idNotifRetDesempleo
	 */
	public Long getIdNotifRetDesempleo() {
		return idNotifRetDesempleo;
	}

	/**
	 * @param idNotifRetDesempleo the idNotifRetDesempleo to set
	 */
	public void setIdNotifRetDesempleo(Long idNotifRetDesempleo) {
		this.idNotifRetDesempleo = idNotifRetDesempleo;
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
	 * @return the curpFuncionarioAut
	 */
	public String getCurpFuncionarioAut() {
		return curpFuncionarioAut;
	}

	/**
	 * @param curpFuncionarioAut the curpFuncionarioAut to set
	 */
	public void setCurpFuncionarioAut(String curpFuncionarioAut) {
		this.curpFuncionarioAut = curpFuncionarioAut;
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
	 * @return the selloFuncionarioAut
	 */
	public String getSelloFuncionarioAut() {
		return selloFuncionarioAut;
	}

	/**
	 * @param selloFuncionarioAut the selloFuncionarioAut to set
	 */
	public void setSelloFuncionarioAut(String selloFuncionarioAut) {
		this.selloFuncionarioAut = selloFuncionarioAut;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionRetiroDesempleo [idNotifRetDesempleo=");
		builder.append(idNotifRetDesempleo);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", curpAgenteServ=");
		builder.append(curpAgenteServ);
		builder.append(", curpFuncionarioAut=");
		builder.append(curpFuncionarioAut);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", descDiagnosticoRecepcion=");
		builder.append(descDiagnosticoRecepcion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", folioAdministradora=");
		builder.append(folioAdministradora);
		builder.append(", idSolicitante=");
		builder.append(idSolicitante);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", selloFuncionarioAut=");
		builder.append(selloFuncionarioAut);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", tipoRetiro=");
		builder.append(tipoRetiro);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", claveAdminAct=");
		builder.append(claveAdminAct);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", notificado=");
		builder.append(notificado);
		builder.append("]");
		return builder.toString();
	}

}
