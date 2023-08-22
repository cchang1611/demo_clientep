/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad que representa la entidad NotificacionTipoRetiro
 * @author MGONZALE
 *
 */
public class NotificacionTipoRetiro implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4696138856963267709L;
	
	/**
	 * idNotifTipoRetiro
	 */
	private Long idNotifTipoRetiro;

	/**
	 * afore
	 */
	private String afore;

	/**
	 * claveBanco
	 */
	private String claveBanco;

	/**
	 * cuentaClabe
	 */
	private String cuentaClabe;

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
	 * numeroCuenta
	 */
	private String numeroCuenta;

	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;

	/**
	 * tipoRetiroSeleccion
	 */
	private String tipoRetiroSeleccion;

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
	 * fechaNotificado
	 */
	private Date fechaNotificado;

	/**
	 * fechaProcesamiento
	 */
	private Date fechaProcesamiento;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * numNotificado
	 */
	private BigDecimal numNotificado;

	/**
	 * numParcialidades
	 */
	private Integer numParcialidades;

	/**
	 * CH_TIPO_PAGO
	 */
	private String tipoPago;

	/**
	 * CH_TIPO_PAGO
	 */
	private Double importeAutorizado;

	/**
	 * NU_MONTO_A
	 */
	private Double montoA;

	/**
	 * NU_MONTO_B
	 */
	private Double montoB;

	/**
	 * NU_IMPTE_RET_97
	 */
	private Double importeRet97;

	/**
	 * NU_IMPTE_CES_VEJ
	 */
	private Double importeCesVej;

	/**
	 * NU_IMPTE_CUOTA_SOCIAL
	 */
	private Double importeCuotaSocial;

	/**
	 * @return the idNotifTipoRetiro
	 */
	public Long getIdNotifTipoRetiro() {
		return idNotifTipoRetiro;
	}

	/**
	 * @param idNotifTipoRetiro the idNotifTipoRetiro to set
	 */
	public void setIdNotifTipoRetiro(Long idNotifTipoRetiro) {
		this.idNotifTipoRetiro = idNotifTipoRetiro;
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
	 * @return the claveBanco
	 */
	public String getClaveBanco() {
		return claveBanco;
	}

	/**
	 * @param claveBanco the claveBanco to set
	 */
	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}

	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
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
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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
	 * @return the tipoRetiroSeleccion
	 */
	public String getTipoRetiroSeleccion() {
		return tipoRetiroSeleccion;
	}

	/**
	 * @param tipoRetiroSeleccion the tipoRetiroSeleccion to set
	 */
	public void setTipoRetiroSeleccion(String tipoRetiroSeleccion) {
		this.tipoRetiroSeleccion = tipoRetiroSeleccion;
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
	 * @return the fechaProcesamiento
	 */
	public Date getFechaProcesamiento() {
		return fechaProcesamiento;
	}

	/**
	 * @param fechaProcesamiento the fechaProcesamiento to set
	 */
	public void setFechaProcesamiento(Date fechaProcesamiento) {
		this.fechaProcesamiento = fechaProcesamiento;
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
	 * @return the numNotificado
	 */
	public BigDecimal getNumNotificado() {
		return numNotificado;
	}

	/**
	 * @param numNotificado the numNotificado to set
	 */
	public void setNumNotificado(BigDecimal numNotificado) {
		this.numNotificado = numNotificado;
	}

	/**
	 * @return the numParcialidades
	 */
	public Integer getNumParcialidades() {
		return numParcialidades;
	}

	/**
	 * @param numParcialidades the numParcialidades to set
	 */
	public void setNumParcialidades(Integer numParcialidades) {
		this.numParcialidades = numParcialidades;
	}

	/**
	 * @return the tipoPago
	 */
	public String getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago the tipoPago to set
	 */
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the importeAutorizado
	 */
	public Double getImporteAutorizado() {
		return importeAutorizado;
	}

	/**
	 * @param importeAutorizado the importeAutorizado to set
	 */
	public void setImporteAutorizado(Double importeAutorizado) {
		this.importeAutorizado = importeAutorizado;
	}

	/**
	 * @return the montoA
	 */
	public Double getMontoA() {
		return montoA;
	}

	/**
	 * @param montoA the montoA to set
	 */
	public void setMontoA(Double montoA) {
		this.montoA = montoA;
	}

	/**
	 * @return the montoB
	 */
	public Double getMontoB() {
		return montoB;
	}

	/**
	 * @param montoB the montoB to set
	 */
	public void setMontoB(Double montoB) {
		this.montoB = montoB;
	}

	/**
	 * @return the importeRet97
	 */
	public Double getImporteRet97() {
		return importeRet97;
	}

	/**
	 * @param importeRet97 the importeRet97 to set
	 */
	public void setImporteRet97(Double importeRet97) {
		this.importeRet97 = importeRet97;
	}

	/**
	 * @return the importeCesVej
	 */
	public Double getImporteCesVej() {
		return importeCesVej;
	}

	/**
	 * @param importeCesVej the importeCesVej to set
	 */
	public void setImporteCesVej(Double importeCesVej) {
		this.importeCesVej = importeCesVej;
	}

	/**
	 * @return the importeCuotaSocial
	 */
	public Double getImporteCuotaSocial() {
		return importeCuotaSocial;
	}

	/**
	 * @param importeCuotaSocial the importeCuotaSocial to set
	 */
	public void setImporteCuotaSocial(Double importeCuotaSocial) {
		this.importeCuotaSocial = importeCuotaSocial;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionTipoRetiro [idNotifTipoRetiro=");
		builder.append(idNotifTipoRetiro);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", claveBanco=");
		builder.append(claveBanco);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", descDiagnosticoRecepcion=");
		builder.append(descDiagnosticoRecepcion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", folioAdministradora=");
		builder.append(folioAdministradora);
		builder.append(", numeroCuenta=");
		builder.append(numeroCuenta);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", tipoRetiroSeleccion=");
		builder.append(tipoRetiroSeleccion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", fechaProcesamiento=");
		builder.append(fechaProcesamiento);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", numNotificado=");
		builder.append(numNotificado);
		builder.append(", numParcialidades=");
		builder.append(numParcialidades);
		builder.append(", tipoPago=");
		builder.append(tipoPago);
		builder.append(", importeAutorizado=");
		builder.append(importeAutorizado);
		builder.append(", montoA=");
		builder.append(montoA);
		builder.append(", montoB=");
		builder.append(montoB);
		builder.append(", importeRet97=");
		builder.append(importeRet97);
		builder.append(", importeCesVej=");
		builder.append(importeCesVej);
		builder.append(", importeCuotaSocial=");
		builder.append(importeCuotaSocial);
		builder.append("]");
		return builder.toString();
	}
	
}
