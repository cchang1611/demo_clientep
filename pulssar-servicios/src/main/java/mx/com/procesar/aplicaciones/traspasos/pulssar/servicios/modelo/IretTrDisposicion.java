/**
 * IretTrDisposicion.java
 * Fecha de creación: 10/06/2020, 14:58:33
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad IRET_TR_DISPOSICION
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 10/06/2020
 */
public class IretTrDisposicion implements Serializable {

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 1129405284326870881L;

	/**
	 * ID_DISPOSICION
	 */
	private Long idDisposicion;
	
	/**
	 * ID_RECEP_DISPOSICION
	 */
	private Long idRecepDisposicion;
	/**
	 * ID_PROCESAR
	 */
	private Long idProcesar;
	/**
	 * ID_MATRIZ_DERECHO
	 */
	private Long idMatrizDerecho;
	
	/**
	 * ID_RESOLUCION
	 */
	private Long idResolucion;
	/**
	 * ID_DIAGNOSTICO
	 */
	private Long idDiagnostico;
	/**
	 * ID_ESTATUS
	 */
	private Long idEstatus;
	/**
	 * ID_PROCESAR_AFORE
	 */
	private Long idProcesarAfore;
	/**
	 * ID_PROCESAR_BANCO
	 */
	private Long idProcesarBanco;
	/**
	 * ID_TIPO_DOCTO_PROBATORIO
	 */
	private Long idTipoDoctoProbatorio;
	/**
	 * CV_PROCESO
	 */
	private String proceso;
	/**
	 * CV_TIPO_OPERACION
	 */
	private String tipoOperacion;
	/**
	 * CV_ASEGURADORA
	 */
	private String aseguradora;
	/**
	 * CV_ACTUARIO
	 */
	private String actuario;
	
	/**
	 * CH_SECUENCIA_PENSION
	 */
	private String secuenciaPension;
	/**
	 * NU_NUMERO_ISSSTE
	 */
	private Long numeroIssste;
	
	/**
	 * NU_NUMERO_PENSION
	 */
	private Long numeroPension;
	/**
	 * NU_PLAN_PRIVADO
	 */
	private Long planPrivado;
	
	/**
	 * FC_INICIO_PENSION
	 */
	private Date fechaInicioPension;
	
	/**
	 * NU_MONTO_CONSTITUTIVO
	 */
	private Long montoConstitutivo;
	
	/**
	 * CH_DELEGACION_CONTROL
	 */
	private String delegacionControl;
	
	/**
	 * CH_FOLIO_ISSSTE
	 */
	private String folioIssste;
	
	/**
	 * CH_CUENTA_BANCO
	 */
	private String cuentaBanco;
	
	/**
	 * CLABE
	 */
	private String clabe;
	
	/**
	 * CH_CENTRO_PAGO_SAR
	 */
	private String centroPagoSar;
	
	/**
	 * FC_SOLICITUD
	 */
	private Date fechaSolicitud;
	
	/**
	 * FC_OPERACION
	 */
	private Date fechaOperacion;
	/**
	 * FC_CONTROL
	 */
	private Date fechaControl;
	
	/**
	 * CH_USUARIO_MODIFICADOR
	 */
	private String usuarioModificador;

	/**
	 * FC_RESOLUCION
	 */
	private Date fechaResolucion;
	
	/**
	 * CH_NUMERO_PLAN_PRIVADO
	 */
	private String numeroPlanPrivado;
	
	/**
	 * FC_PAGO_REINGRESO
	 */
	private Date fechaPagoReingreso;
	
	/**
	 * CH_CONSECUTIVO_TRABAJADOR
	 */
	private String consecutivoTrabajador;
	
	/**
	 * FC_VALOR_VIVIENDA
	 */
	private Date fechaValorVivienda;
	
	/**
	 * FC_DISPOSICION_RECURSOS
	 */
	private Date fechaDisposicionRecursos;
	
	/**
	 * CH_CLAVE_MOVIMIENTO
	 */
	private String claveMovimiento;
	
	/**
	 *  Constructor default
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 */
	public IretTrDisposicion() {
		 //Constructor default
	}

	/**
	 * @return el atributo idDisposicion
	 */
	public Long getIdDisposicion() {
		return idDisposicion;
	}

	/**
	 * @param idDisposicion parametro idDisposicion a actualizar
	 */
	public void setIdDisposicion(Long idDisposicion) {
		this.idDisposicion = idDisposicion;
	}

	/**
	 * @return el atributo idRecepDisposicion
	 */
	public Long getIdRecepDisposicion() {
		return idRecepDisposicion;
	}

	/**
	 * @param idRecepDisposicion parametro idRecepDisposicion a actualizar
	 */
	public void setIdRecepDisposicion(Long idRecepDisposicion) {
		this.idRecepDisposicion = idRecepDisposicion;
	}

	/**
	 * @return el atributo idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar parametro idProcesar a actualizar
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return el atributo idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho parametro idMatrizDerecho a actualizar
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	/**
	 * @return el atributo idResolucion
	 */
	public Long getIdResolucion() {
		return idResolucion;
	}

	/**
	 * @param idResolucion parametro idResolucion a actualizar
	 */
	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}

	/**
	 * @return el atributo idDiagnostico
	 */
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	/**
	 * @param idDiagnostico parametro idDiagnostico a actualizar
	 */
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	/**
	 * @return el atributo idEstatus
	 */
	public Long getIdEstatus() {
		return idEstatus;
	}

	/**
	 * @param idEstatus parametro idEstatus a actualizar
	 */
	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * @return el atributo idProcesarAfore
	 */
	public Long getIdProcesarAfore() {
		return idProcesarAfore;
	}

	/**
	 * @param idProcesarAfore parametro idProcesarAfore a actualizar
	 */
	public void setIdProcesarAfore(Long idProcesarAfore) {
		this.idProcesarAfore = idProcesarAfore;
	}

	/**
	 * @return el atributo idProcesarBanco
	 */
	public Long getIdProcesarBanco() {
		return idProcesarBanco;
	}

	/**
	 * @param idProcesarBanco parametro idProcesarBanco a actualizar
	 */
	public void setIdProcesarBanco(Long idProcesarBanco) {
		this.idProcesarBanco = idProcesarBanco;
	}

	/**
	 * @return el atributo idTipoDoctoProbatorio
	 */
	public Long getIdTipoDoctoProbatorio() {
		return idTipoDoctoProbatorio;
	}

	/**
	 * @param idTipoDoctoProbatorio parametro idTipoDoctoProbatorio a actualizar
	 */
	public void setIdTipoDoctoProbatorio(Long idTipoDoctoProbatorio) {
		this.idTipoDoctoProbatorio = idTipoDoctoProbatorio;
	}

	/**
	 * @return el atributo proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso parametro proceso a actualizar
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return el atributo tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion parametro tipoOperacion a actualizar
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
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
	 * @return el atributo actuario
	 */
	public String getActuario() {
		return actuario;
	}

	/**
	 * @param actuario parametro actuario a actualizar
	 */
	public void setActuario(String actuario) {
		this.actuario = actuario;
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
	 * @return el atributo numeroIssste
	 */
	public Long getNumeroIssste() {
		return numeroIssste;
	}

	/**
	 * @param numeroIssste parametro numeroIssste a actualizar
	 */
	public void setNumeroIssste(Long numeroIssste) {
		this.numeroIssste = numeroIssste;
	}

	/**
	 * @return el atributo numeroPension
	 */
	public Long getNumeroPension() {
		return numeroPension;
	}

	/**
	 * @param numeroPension parametro numeroPension a actualizar
	 */
	public void setNumeroPension(Long numeroPension) {
		this.numeroPension = numeroPension;
	}

	/**
	 * @return el atributo planPrivado
	 */
	public Long getPlanPrivado() {
		return planPrivado;
	}

	/**
	 * @param planPrivado parametro planPrivado a actualizar
	 */
	public void setPlanPrivado(Long planPrivado) {
		this.planPrivado = planPrivado;
	}

	/**
	 * @return el atributo fechaInicioPension
	 */
	public Date getFechaInicioPension() {
		return fechaInicioPension;
	}

	/**
	 * @param fechaInicioPension parametro fechaInicioPension a actualizar
	 */
	public void setFechaInicioPension(Date fechaInicioPension) {
		this.fechaInicioPension = fechaInicioPension;
	}

	/**
	 * @return el atributo montoConstitutivo
	 */
	public Long getMontoConstitutivo() {
		return montoConstitutivo;
	}

	/**
	 * @param montoConstitutivo parametro montoConstitutivo a actualizar
	 */
	public void setMontoConstitutivo(Long montoConstitutivo) {
		this.montoConstitutivo = montoConstitutivo;
	}

	/**
	 * @return el atributo delegacionControl
	 */
	public String getDelegacionControl() {
		return delegacionControl;
	}

	/**
	 * @param delegacionControl parametro delegacionControl a actualizar
	 */
	public void setDelegacionControl(String delegacionControl) {
		this.delegacionControl = delegacionControl;
	}

	/**
	 * @return el atributo folioIssste
	 */
	public String getFolioIssste() {
		return folioIssste;
	}

	/**
	 * @param folioIssste parametro folioIssste a actualizar
	 */
	public void setFolioIssste(String folioIssste) {
		this.folioIssste = folioIssste;
	}

	/**
	 * @return el atributo cuentaBanco
	 */
	public String getCuentaBanco() {
		return cuentaBanco;
	}

	/**
	 * @param cuentaBanco parametro cuentaBanco a actualizar
	 */
	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	/**
	 * @return el atributo clabe
	 */
	public String getClabe() {
		return clabe;
	}

	/**
	 * @param clabe parametro clabe a actualizar
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	/**
	 * @return el atributo centroPagoSar
	 */
	public String getCentroPagoSar() {
		return centroPagoSar;
	}

	/**
	 * @param centroPagoSar parametro centroPagoSar a actualizar
	 */
	public void setCentroPagoSar(String centroPagoSar) {
		this.centroPagoSar = centroPagoSar;
	}

	/**
	 * @return el atributo fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud parametro fechaSolicitud a actualizar
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return el atributo fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion parametro fechaOperacion a actualizar
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
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
	 * @return el atributo fechaResolucion
	 */
	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	/**
	 * @param fechaResolucion parametro fechaResolucion a actualizar
	 */
	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	/**
	 * @return el atributo numeroPlanPrivado
	 */
	public String getNumeroPlanPrivado() {
		return numeroPlanPrivado;
	}

	/**
	 * @param numeroPlanPrivado parametro numeroPlanPrivado a actualizar
	 */
	public void setNumeroPlanPrivado(String numeroPlanPrivado) {
		this.numeroPlanPrivado = numeroPlanPrivado;
	}

	/**
	 * @return el atributo fechaPagoReingreso
	 */
	public Date getFechaPagoReingreso() {
		return fechaPagoReingreso;
	}

	/**
	 * @param fechaPagoReingreso parametro fechaPagoReingreso a actualizar
	 */
	public void setFechaPagoReingreso(Date fechaPagoReingreso) {
		this.fechaPagoReingreso = fechaPagoReingreso;
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
	 * @return el atributo fechaValorVivienda
	 */
	public Date getFechaValorVivienda() {
		return fechaValorVivienda;
	}

	/**
	 * @param fechaValorVivienda parametro fechaValorVivienda a actualizar
	 */
	public void setFechaValorVivienda(Date fechaValorVivienda) {
		this.fechaValorVivienda = fechaValorVivienda;
	}

	/**
	 * @return el atributo fechaDisposicionRecursos
	 */
	public Date getFechaDisposicionRecursos() {
		return fechaDisposicionRecursos;
	}

	/**
	 * @param fechaDisposicionRecursos parametro fechaDisposicionRecursos a actualizar
	 */
	public void setFechaDisposicionRecursos(Date fechaDisposicionRecursos) {
		this.fechaDisposicionRecursos = fechaDisposicionRecursos;
	}

	/**
	 * @return el atributo claveMovimiento
	 */
	public String getClaveMovimiento() {
		return claveMovimiento;
	}

	/**
	 * @param claveMovimiento parametro claveMovimiento a actualizar
	 */
	public void setClaveMovimiento(String claveMovimiento) {
		this.claveMovimiento = claveMovimiento;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IretTrDisposicion [idDisposicion=");
		builder.append(idDisposicion);
		builder.append(", idRecepDisposicion=");
		builder.append(idRecepDisposicion);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", idResolucion=");
		builder.append(idResolucion);
		builder.append(", idDiagnostico=");
		builder.append(idDiagnostico);
		builder.append(", idEstatus=");
		builder.append(idEstatus);
		builder.append(", idProcesarAfore=");
		builder.append(idProcesarAfore);
		builder.append(", idProcesarBanco=");
		builder.append(idProcesarBanco);
		builder.append(", idTipoDoctoProbatorio=");
		builder.append(idTipoDoctoProbatorio);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", tipoOperacion=");
		builder.append(tipoOperacion);
		builder.append(", aseguradora=");
		builder.append(aseguradora);
		builder.append(", actuario=");
		builder.append(actuario);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", numeroIssste=");
		builder.append(numeroIssste);
		builder.append(", numeroPension=");
		builder.append(numeroPension);
		builder.append(", planPrivado=");
		builder.append(planPrivado);
		builder.append(", fechaInicioPension=");
		builder.append(fechaInicioPension);
		builder.append(", montoConstitutivo=");
		builder.append(montoConstitutivo);
		builder.append(", delegacionControl=");
		builder.append(delegacionControl);
		builder.append(", folioIssste=");
		builder.append(folioIssste);
		builder.append(", cuentaBanco=");
		builder.append(cuentaBanco);
		builder.append(", clabe=");
		builder.append(clabe);
		builder.append(", centroPagoSar=");
		builder.append(centroPagoSar);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaResolucion=");
		builder.append(fechaResolucion);
		builder.append(", numeroPlanPrivado=");
		builder.append(numeroPlanPrivado);
		builder.append(", fechaPagoReingreso=");
		builder.append(fechaPagoReingreso);
		builder.append(", consecutivoTrabajador=");
		builder.append(consecutivoTrabajador);
		builder.append(", fechaValorVivienda=");
		builder.append(fechaValorVivienda);
		builder.append(", fechaDisposicionRecursos=");
		builder.append(fechaDisposicionRecursos);
		builder.append(", claveMovimiento=");
		builder.append(claveMovimiento);
		builder.append("]");
		return builder.toString();
	}
	
}

