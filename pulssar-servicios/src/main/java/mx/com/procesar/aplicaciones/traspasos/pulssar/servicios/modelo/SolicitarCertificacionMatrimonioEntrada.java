/**
 * PropertiesApplicationContext.java
 * Fecha de creaciï¿½n: 23/05/2016, 18:19:08
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaciï¿½n confidencial, propiedad del
 * Procesar S A de C V. Esta informaciï¿½n confidencial
 * no deberï¿½ ser divulgada y solo se podrï¿½ utilizar de acuerdo
 * a los tï¿½rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitarCertificacionMatrimonioEntrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7252014175520139585L;

	/**
	 * folioTramiteProcesar
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String folioTramiteProcesar;

	/**
	 * folioCliente
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String folioCliente;

	/**
	 * origenTramite
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String origenTramite;

	/**
	 * nss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String nss;

	/**
	 * curpTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String curpTrabajador;

	/**
	 * nombreTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String nombreTrabajador;

	/**
	 * apellidoPaternoTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String apellidoPaternoTrabajador;

	/**
	 * apellidoMaternoTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String apellidoMaternoTrabajador;

	/**
	 * nombreConyuge
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String nombreConyuge;

	/**
	 * apellidoPaternoConyuge
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String apellidoPaternoConyuge;

	/**
	 * apellidoMaternoConyuge
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String apellidoMaternoConyuge;

	/**
	 * sexoConyuge
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected BigInteger sexoConyuge;

	/**
	 * afore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String afore;

	/**
	 * fechaMatrimonio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@DateTimeFormat(pattern= "dd/MM/yyyy")
	protected String fechaMatrimonio;

	/**
	 * entidadEmisionActa
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String entidadEmisionActa;

	/**
	 * descEntidadEmisionActa
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String descEntidadEmisionActa;
	
	
	/**
	 * descEntidadEmisionActa
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String descSexo;
	
	
	/**
	 * tipoPrestacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String tipoPrestacion;

	/**
	 * tipoSolicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String tipoSolicitante;

	/**
	 * curpSolicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String curpSolicitante;

	/**
	 * selloTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String selloTrabajador;

	/**
	 * curpAgenteServicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String curpAgenteServicio;

	/**
	 * XML de Notificacion.
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String xmlNotificacion;

	/**
	 * mensaje
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mensaje;
	/**
	 * operacion1
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private boolean operacion1;
	/**
	 * operacion1
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private boolean operacion2;
	/**
	 * nombreTrabajadorImss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajadorImss;
	/**
	 * nombreTrabProcanase
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabProcanase;
	/**
	 * clave Diagnostico
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveDiagnostico;
	/**
	 * MatrizDerecho
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private MatrizDerecho matrizDerecho;
	/**
	 * descripcion Diagnostico
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String descDiagnostico;
	/**
	 * id Matriz Derecho
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long idMatrizDerecho;
	/**
	 * resolucion Parcial
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ResolucionParcial resolucionParcial;

	/**
	 * Estatus de la operacion 20600
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String estatus;
	/**
	 * fecha Vigencia
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaVigencia;
	/**
	 * nombre del archivo
	 */
	@JsonIgnore
	private String nombreArchivo;

	/**
	 * firmaEmpleado
	 */
	@JsonIgnore
	private String firmaEmpleado;

	/**
	 * firmaTrabajador
	 */
	@JsonIgnore
	private String firmaTrabajador;
	/**
	 * Id Folio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long idFolio;

	/**
	 * @return
	 */
	public String getFolioTramiteProcesar() {
		return folioTramiteProcesar;
	}

	/**
	 * @param folioTramiteProcesar
	 */
	public void setFolioTramiteProcesar(String folioTramiteProcesar) {
		this.folioTramiteProcesar = folioTramiteProcesar;
	}

	/**
	 * @return
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	/**
	 * @return
	 */
	public String getOrigenTramite() {
		return origenTramite;
	}

	/**
	 * @param origenTramite
	 */
	public void setOrigenTramite(String origenTramite) {
		this.origenTramite = origenTramite;
	}

	/**
	 * @return
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return
	 */
	public String getApellidoPaternoTrabajador() {
		return apellidoPaternoTrabajador;
	}

	/**
	 * @param apellidoPaternoTrabajador
	 */
	public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
		this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
	}

	/**
	 * @return
	 */
	public String getApellidoMaternoTrabajador() {
		return apellidoMaternoTrabajador;
	}

	/**
	 * @param apellidoMaternoTrabajador
	 */
	public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
		this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
	}

	/**
	 * @return
	 */
	public String getNombreConyuge() {
		return nombreConyuge;
	}

	/**
	 * @param nombreConyuge
	 */
	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}

	/**
	 * @return
	 */
	public String getApellidoPaternoConyuge() {
		return apellidoPaternoConyuge;
	}

	/**
	 * @param apellidoPaternoConyuge
	 */
	public void setApellidoPaternoConyuge(String apellidoPaternoConyuge) {
		this.apellidoPaternoConyuge = apellidoPaternoConyuge;
	}

	/**
	 * @return
	 */
	public String getApellidoMaternoConyuge() {
		return apellidoMaternoConyuge;
	}

	/**
	 * @param apellidoMaternoConyuge
	 */
	public void setApellidoMaternoConyuge(String apellidoMaternoConyuge) {
		this.apellidoMaternoConyuge = apellidoMaternoConyuge;
	}

	/**
	 * @return
	 */
	public BigInteger getSexoConyuge() {
		return sexoConyuge;
	}

	/**
	 * @param sexoConyuge
	 */
	public void setSexoConyuge(BigInteger sexoConyuge) {
		this.sexoConyuge = sexoConyuge;
	}

	/**
	 * @return
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return
	 */
	public String getFechaMatrimonio() {
		return fechaMatrimonio;
	}

	/**
	 * @param fechaMatrimonio
	 */
	public void setFechaMatrimonio(String fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
	}

	/**
	 * @return
	 */
	public String getEntidadEmisionActa() {
		return entidadEmisionActa;
	}

	/**
	 * @param entidadEmisionActa
	 */
	public void setEntidadEmisionActa(String entidadEmisionActa) {
		this.entidadEmisionActa = entidadEmisionActa;
	}

	/**
	 * @return
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return
	 */
	public String getSelloTrabajador() {
		return selloTrabajador;
	}

	/**
	 * @param selloTrabajador
	 */
	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}

	/**
	 * @return
	 */
	public String getCurpAgenteServicio() {
		return curpAgenteServicio;
	}

	/**
	 * @param curpAgenteServicio
	 */
	public void setCurpAgenteServicio(String curpAgenteServicio) {
		this.curpAgenteServicio = curpAgenteServicio;
	}

	/**
	 * @return
	 */
	public String getXmlNotificacion() {
		return xmlNotificacion;
	}

	/**
	 * @param xmlNotificacion
	 */
	public void setXmlNotificacion(String xmlNotificacion) {
		this.xmlNotificacion = xmlNotificacion;
	}

	/**
	 * @return
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return
	 */
	public boolean isOperacion1() {
		return operacion1;
	}

	/**
	 * @param operacion1
	 */
	public void setOperacion1(boolean operacion1) {
		this.operacion1 = operacion1;
	}

	/**
	 * @return
	 */
	public boolean isOperacion2() {
		return operacion2;
	}

	/**
	 * @param operacion2
	 */
	public void setOperacion2(boolean operacion2) {
		this.operacion2 = operacion2;
	}

	/**
	 * @return
	 */
	public String getNombreTrabajadorImss() {
		return nombreTrabajadorImss;
	}

	/**
	 * @param nombreTrabajadorImss
	 */
	public void setNombreTrabajadorImss(String nombreTrabajadorImss) {
		this.nombreTrabajadorImss = nombreTrabajadorImss;
	}

	/**
	 * @return
	 */
	public String getNombreTrabProcanase() {
		return nombreTrabProcanase;
	}

	/**
	 * @param nombreTrabProcanase
	 */
	public void setNombreTrabProcanase(String nombreTrabProcanase) {
		this.nombreTrabProcanase = nombreTrabProcanase;
	}

	/**
	 * @return
	 */
	public String getClaveDiagnostico() {
		return claveDiagnostico;
	}

	/**
	 * @param claveDiagnostico
	 */
	public void setClaveDiagnostico(String claveDiagnostico) {
		this.claveDiagnostico = claveDiagnostico;
	}

	/**
	 * @return
	 */
	public MatrizDerecho getMatrizDerecho() {
		return matrizDerecho;
	}

	/**
	 * @param matrizDerecho
	 */
	public void setMatrizDerecho(MatrizDerecho matrizDerecho) {
		this.matrizDerecho = matrizDerecho;
	}

	/**
	 * @return
	 */
	public String getDescDiagnostico() {
		return descDiagnostico;
	}

	/**
	 * @param descDiagnostico
	 */
	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}

	/**
	 * @return
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	/**
	 * @return
	 */
	public ResolucionParcial getResolucionParcial() {
		return resolucionParcial;
	}

	/**
	 * @param resolucionParcial
	 */
	public void setResolucionParcial(ResolucionParcial resolucionParcial) {
		this.resolucionParcial = resolucionParcial;
	}

	/**
	 * @return
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return
	 */
	public String getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * @param fechaVigencia
	 */
	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * @return
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return
	 */
	public String getFirmaEmpleado() {
		return firmaEmpleado;
	}

	/**
	 * @param firmaEmpleado
	 */
	public void setFirmaEmpleado(String firmaEmpleado) {
		this.firmaEmpleado = firmaEmpleado;
	}

	/**
	 * @return
	 */
	public String getFirmaTrabajador() {
		return firmaTrabajador;
	}

	/**
	 * @param firmaTrabajador
	 */
	public void setFirmaTrabajador(String firmaTrabajador) {
		this.firmaTrabajador = firmaTrabajador;
	}

	/**
	 * @return el atributo idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}

	/**
	 * @param idFolio parametro idFolio a actualizar
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}

	public String getDescEntidadEmisionActa() {
		return descEntidadEmisionActa;
	}

	public void setDescEntidadEmisionActa(String descEntidadEmisionActa) {
		this.descEntidadEmisionActa = descEntidadEmisionActa;
	}

	
	
	public String getDescSexo() {
		return descSexo;
	}

	public void setDescSexo(String descSexo) {
		this.descSexo = descSexo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
