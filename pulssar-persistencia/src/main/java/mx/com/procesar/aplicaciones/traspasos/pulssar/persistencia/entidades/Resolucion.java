package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entidad resolucion
 * @author REARREOL
 *
 */
@Entity
@Table(name="IRET_TR_RESOLUCION")
public class Resolucion implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3162051977127444555L;
	
	/**
	 * Id resolucion
	 */
	@Id
	@Column(name = "ID_RESOLUCION")
	private Long idResolucion;
	
	/**
	 * Id procesar
	 */
	@Column(name = "ID_PROCESAR")
	private Long idProcesar;
	
	/**
	 * Id recep resolucion
	 */
	@Column(name = "ID_RECEP_RESOLUCION")
	private Long idRecepResolucion;
	
	/**
	 * Id generacion
	 */
	@Column(name = "ID_GENERACION")
	private Long idGeneracion;
	
	
	
	/**
	 * id procesar afore
	 */
	@Column(name = "ID_PROCESAR_AFORE")
	private Long idProcesarAfore;
	
	/**
	 * id procesar banco
	 */
	@Column(name = "ID_PROCESAR_BANCO")
	private Long idProcesarBanco;
	
	/**
	 * id diagnostico
	 */
	@Column(name = "ID_DIAGNOSTICO")
	private Long idDiagnostico;
	
	/**
	 * id estatus
	 */
	@Column(name = "ID_ESTATUS")
	private Long idEstatus;
	
	/**
	 * Cv tipo liquidacion
	 */
	@Column(name = "CV_TIPO_LIQUIDACION")
	private String cvTipoLiquidacion;
	
	/**
	 * cv proceso
	 */
	@Column(name = "CV_PROCESO")
	private String cvProceso;
	
	/**
	 * Clave proceso
	 */
	@Column(name = "CV_TIPO_OPERACION")
	private String cvTipoOperacion;
	
	/**
	 * Aseguradora
	 */
	@Column(name = "CV_ASEGURADORA")
	private String cvAseguradora;
	
	/**
	 * Estatus vivienda
	 */
	@Column(name = "CV_ESTATUS_VIVIENDA")
	private String cvEstatusVivienda;
	
	/**
	 * Numero concesion
	 */
	@Column(name = "CH_NUMERO_CONCESION")
	private String numeroConcesion;
	
	/***
	 * Clabe
	 */
	@Column(name = "CLABE")
	private String clabe;
	
	/**
	 * Numero issste
	 */
	@Column(name = "NU_NUMERO_ISSSTE")
	private String numeroIssste;
	
	/**
	 * Numero pension
	 */
	@Column(name = "NU_NUMERO_PENSION")
	private String numeroPension;
	
	/**
	 * Secuencia pension
	 */
	@Column(name = "CH_SECUENCIA_PENSION")
	private String secuenciaPension;
	
	/**
	 * Fecha emision resolucion
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_EMISION_RESOLUCION")
	private Date fechaEmision;
	
	/**
	 * Fecha inicion pension
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_INICIO_PENSION")
	private Date fechaInicioPension;
	
	/**
	 * semanas cotizadas
	 */
	@Column(name = "NU_SEMANAS_COTIZADAS")
	private Integer semanasCotizadas;
	
	/**
	 * Años cotizados
	 */
	@Column(name = "NU_ANIOS_COTIZADOS")
	private Integer aniosCotizados;
	
	/**
	 * Fecha carga datamart
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CARGA_DATAMART")
	private Date fechaCargaDatamart;
	
	/**
	 * Monto constitutivo
	 */
	@Column(name = "NU_MONTO_CONSTITUTIVO")
	private Double montoConstitutivo;
	
	/**
	 * Delegacion control
	 */
	@Column(name = "CH_DELEGACION_CONTROL")
	private String delegacionControl;
	
	/**
	 * Fecha actualizacion procesar
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_ACTUALIZACION_PROCESAR")
	private Date fechaActualizacionProcesar;
	
	/**
	 * Folio issste
	 */
	@Column(name = "CH_FOLIO_ISSSTE")
	private String folioIssste;
	
	/**
	 * Fecha actualizacion procesar
	 */
	@Column(name = "CH_CUENTA_BANCARIA")
	private String cuentaBancaria;
	
	/**
	 * Fecha actualizacion procesar
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fechaControl;
	
	/**
	 * Usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * Movimiento
	 */
	@Column(name = "CV_MOVIMIENTO")
	private String movimiento;
	
	/**
	 * Diagnostico rcv
	 */
	@Column(name = "ID_DIAGNOSTICO_RCV")
	private Long idDiagnosticoRcv;
	
	/**
	 * Diagnostico viv
	 */
	@Column(name = "ID_DIAGNOSTICO_VIV")
	private Long idDiagnosticoViv;
	
	
	/**
	 * Fecha operacion
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_OPERACION")
	private Date fechaOperacion;
	
	/**
	 * Fecha confirmacion
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONFIRMACION")
	private Date fechaConfirmacion;
	
	
	/**
	 * Fecha valor vivienda
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_VALOR_VIVIENDA")
	private Date fechaValorVivienda;
	
	/**
	 * Centro pago sar
	 */
	@Column(name = "CH_CENTRO_PAGO_SAR")
	private String centroPagoSar;
	
	/**
	 * Ind complementaria
	 */
	@Column(name = "CV_IND_COMPLEMENTARIA")
	private String indComplementaria;
	
	
	/**
	 * matriz de derecho
	 */
	@ManyToOne
	@JoinColumn(name = "ID_MATRIZ_DERECHO")
	private IretMatrizDerecho iretMatrizDerecho;

	/**
	 *  Metodo default
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 */
	public Resolucion() {
		//Metodo default
	}

	/**
	 * @return the idResolucion
	 */
	public Long getIdResolucion() {
		return idResolucion;
	}

	/**
	 * @param idResolucion the idResolucion to set
	 */
	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the idRecepResolucion
	 */
	public Long getIdRecepResolucion() {
		return idRecepResolucion;
	}

	/**
	 * @param idRecepResolucion the idRecepResolucion to set
	 */
	public void setIdRecepResolucion(Long idRecepResolucion) {
		this.idRecepResolucion = idRecepResolucion;
	}

	/**
	 * @return the idGeneracion
	 */
	public Long getIdGeneracion() {
		return idGeneracion;
	}

	/**
	 * @param idGeneracion the idGeneracion to set
	 */
	public void setIdGeneracion(Long idGeneracion) {
		this.idGeneracion = idGeneracion;
	}


	/**
	 * @return the idProcesarAfore
	 */
	public Long getIdProcesarAfore() {
		return idProcesarAfore;
	}

	/**
	 * @param idProcesarAfore the idProcesarAfore to set
	 */
	public void setIdProcesarAfore(Long idProcesarAfore) {
		this.idProcesarAfore = idProcesarAfore;
	}

	/**
	 * @return the idProcesarBanco
	 */
	public Long getIdProcesarBanco() {
		return idProcesarBanco;
	}

	/**
	 * @param idProcesarBanco the idProcesarBanco to set
	 */
	public void setIdProcesarBanco(Long idProcesarBanco) {
		this.idProcesarBanco = idProcesarBanco;
	}

	/**
	 * @return the idDiagnostico
	 */
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	/**
	 * @param idDiagnostico the idDiagnostico to set
	 */
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	/**
	 * @return the idEstatus
	 */
	public Long getIdEstatus() {
		return idEstatus;
	}

	/**
	 * @param idEstatus the idEstatus to set
	 */
	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * @return the cvTipoLiquidacion
	 */
	public String getCvTipoLiquidacion() {
		return cvTipoLiquidacion;
	}

	/**
	 * @param cvTipoLiquidacion the cvTipoLiquidacion to set
	 */
	public void setCvTipoLiquidacion(String cvTipoLiquidacion) {
		this.cvTipoLiquidacion = cvTipoLiquidacion;
	}

	/**
	 * @return the cvProceso
	 */
	public String getCvProceso() {
		return cvProceso;
	}

	/**
	 * @param cvProceso the cvProceso to set
	 */
	public void setCvProceso(String cvProceso) {
		this.cvProceso = cvProceso;
	}

	/**
	 * @return the cvTipoOperacion
	 */
	public String getCvTipoOperacion() {
		return cvTipoOperacion;
	}

	/**
	 * @param cvTipoOperacion the cvTipoOperacion to set
	 */
	public void setCvTipoOperacion(String cvTipoOperacion) {
		this.cvTipoOperacion = cvTipoOperacion;
	}

	/**
	 * @return the cvAseguradora
	 */
	public String getCvAseguradora() {
		return cvAseguradora;
	}

	/**
	 * @param cvAseguradora the cvAseguradora to set
	 */
	public void setCvAseguradora(String cvAseguradora) {
		this.cvAseguradora = cvAseguradora;
	}

	/**
	 * @return the cvEstatusVivienda
	 */
	public String getCvEstatusVivienda() {
		return cvEstatusVivienda;
	}

	/**
	 * @param cvEstatusVivienda the cvEstatusVivienda to set
	 */
	public void setCvEstatusVivienda(String cvEstatusVivienda) {
		this.cvEstatusVivienda = cvEstatusVivienda;
	}

	/**
	 * @return the numeroConcesion
	 */
	public String getNumeroConcesion() {
		return numeroConcesion;
	}

	/**
	 * @param numeroConcesion the numeroConcesion to set
	 */
	public void setNumeroConcesion(String numeroConcesion) {
		this.numeroConcesion = numeroConcesion;
	}

	/**
	 * @return the clabe
	 */
	public String getClabe() {
		return clabe;
	}

	/**
	 * @param clabe the clabe to set
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	/**
	 * @return the numeroIssste
	 */
	public String getNumeroIssste() {
		return numeroIssste;
	}

	/**
	 * @param numeroIssste the numeroIssste to set
	 */
	public void setNumeroIssste(String numeroIssste) {
		this.numeroIssste = numeroIssste;
	}

	/**
	 * @return the numeroPension
	 */
	public String getNumeroPension() {
		return numeroPension;
	}

	/**
	 * @param numeroPension the numeroPension to set
	 */
	public void setNumeroPension(String numeroPension) {
		this.numeroPension = numeroPension;
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
	 * @return the fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the fechaInicioPension
	 */
	public Date getFechaInicioPension() {
		return fechaInicioPension;
	}

	/**
	 * @param fechaInicioPension the fechaInicioPension to set
	 */
	public void setFechaInicioPension(Date fechaInicioPension) {
		this.fechaInicioPension = fechaInicioPension;
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
	 * @return the aniosCotizados
	 */
	public Integer getAniosCotizados() {
		return aniosCotizados;
	}

	/**
	 * @param aniosCotizados the aniosCotizados to set
	 */
	public void setAniosCotizados(Integer aniosCotizados) {
		this.aniosCotizados = aniosCotizados;
	}

	/**
	 * @return the fechaCargaDatamart
	 */
	public Date getFechaCargaDatamart() {
		return fechaCargaDatamart;
	}

	/**
	 * @param fechaCargaDatamart the fechaCargaDatamart to set
	 */
	public void setFechaCargaDatamart(Date fechaCargaDatamart) {
		this.fechaCargaDatamart = fechaCargaDatamart;
	}

	/**
	 * @return the montoConstitutivo
	 */
	public Double getMontoConstitutivo() {
		return montoConstitutivo;
	}

	/**
	 * @param montoConstitutivo the montoConstitutivo to set
	 */
	public void setMontoConstitutivo(Double montoConstitutivo) {
		this.montoConstitutivo = montoConstitutivo;
	}

	/**
	 * @return the delegacionControl
	 */
	public String getDelegacionControl() {
		return delegacionControl;
	}

	/**
	 * @param delegacionControl the delegacionControl to set
	 */
	public void setDelegacionControl(String delegacionControl) {
		this.delegacionControl = delegacionControl;
	}

	/**
	 * @return the fechaActualizacionProcesar
	 */
	public Date getFechaActualizacionProcesar() {
		return fechaActualizacionProcesar;
	}

	/**
	 * @param fechaActualizacionProcesar the fechaActualizacionProcesar to set
	 */
	public void setFechaActualizacionProcesar(Date fechaActualizacionProcesar) {
		this.fechaActualizacionProcesar = fechaActualizacionProcesar;
	}

	/**
	 * @return the folioIssste
	 */
	public String getFolioIssste() {
		return folioIssste;
	}

	/**
	 * @param folioIssste the folioIssste to set
	 */
	public void setFolioIssste(String folioIssste) {
		this.folioIssste = folioIssste;
	}

	/**
	 * @return the cuentaBancaria
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	/**
	 * @param cuentaBancaria the cuentaBancaria to set
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
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
	 * @return the movimiento
	 */
	public String getMovimiento() {
		return movimiento;
	}

	/**
	 * @param movimiento the movimiento to set
	 */
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	/**
	 * @return the idDiagnosticoRcv
	 */
	public Long getIdDiagnosticoRcv() {
		return idDiagnosticoRcv;
	}

	/**
	 * @param idDiagnosticoRcv the idDiagnosticoRcv to set
	 */
	public void setIdDiagnosticoRcv(Long idDiagnosticoRcv) {
		this.idDiagnosticoRcv = idDiagnosticoRcv;
	}

	/**
	 * @return the idDiagnosticoViv
	 */
	public Long getIdDiagnosticoViv() {
		return idDiagnosticoViv;
	}

	/**
	 * @param idDiagnosticoViv the idDiagnosticoViv to set
	 */
	public void setIdDiagnosticoViv(Long idDiagnosticoViv) {
		this.idDiagnosticoViv = idDiagnosticoViv;
	}

	/**
	 * @return the fechaOperacion
	 */
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	/**
	 * @return the fechaConfirmacion
	 */
	public Date getFechaConfirmacion() {
		return fechaConfirmacion;
	}

	/**
	 * @param fechaConfirmacion the fechaConfirmacion to set
	 */
	public void setFechaConfirmacion(Date fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	/**
	 * @return the fechaValorVivienda
	 */
	public Date getFechaValorVivienda() {
		return fechaValorVivienda;
	}

	/**
	 * @param fechaValorVivienda the fechaValorVivienda to set
	 */
	public void setFechaValorVivienda(Date fechaValorVivienda) {
		this.fechaValorVivienda = fechaValorVivienda;
	}

	/**
	 * @return the centroPagoSar
	 */
	public String getCentroPagoSar() {
		return centroPagoSar;
	}

	/**
	 * @param centroPagoSar the centroPagoSar to set
	 */
	public void setCentroPagoSar(String centroPagoSar) {
		this.centroPagoSar = centroPagoSar;
	}

	/**
	 * @return the indComplementaria
	 */
	public String getIndComplementaria() {
		return indComplementaria;
	}

	/**
	 * @param indComplementaria the indComplementaria to set
	 */
	public void setIndComplementaria(String indComplementaria) {
		this.indComplementaria = indComplementaria;
	}
	
	
	
	/**
	 * @return the iretMatrizDerecho
	 */
	public IretMatrizDerecho getIretMatrizDerecho() {
		return iretMatrizDerecho;
	}

	/**
	 * @param iretMatrizDerecho the iretMatrizDerecho to set
	 */
	public void setIretMatrizDerecho(IretMatrizDerecho iretMatrizDerecho) {
		this.iretMatrizDerecho = iretMatrizDerecho;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resolucion [idResolucion=");
		builder.append(idResolucion);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idRecepResolucion=");
		builder.append(idRecepResolucion);
		builder.append(", idGeneracion=");
		builder.append(idGeneracion);
		builder.append(", idProcesarAfore=");
		builder.append(idProcesarAfore);
		builder.append(", idProcesarBanco=");
		builder.append(idProcesarBanco);
		builder.append(", idDiagnostico=");
		builder.append(idDiagnostico);
		builder.append(", idEstatus=");
		builder.append(idEstatus);
		builder.append(", cvTipoLiquidacion=");
		builder.append(cvTipoLiquidacion);
		builder.append(", cvProceso=");
		builder.append(cvProceso);
		builder.append(", cvTipoOperacion=");
		builder.append(cvTipoOperacion);
		builder.append(", cvAseguradora=");
		builder.append(cvAseguradora);
		builder.append(", cvEstatusVivienda=");
		builder.append(cvEstatusVivienda);
		builder.append(", numeroConcesion=");
		builder.append(numeroConcesion);
		builder.append(", clabe=");
		builder.append(clabe);
		builder.append(", numeroIssste=");
		builder.append(numeroIssste);
		builder.append(", numeroPension=");
		builder.append(numeroPension);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", fechaEmision=");
		builder.append(fechaEmision);
		builder.append(", fechaInicioPension=");
		builder.append(fechaInicioPension);
		builder.append(", semanasCotizadas=");
		builder.append(semanasCotizadas);
		builder.append(", aniosCotizados=");
		builder.append(aniosCotizados);
		builder.append(", fechaCargaDatamart=");
		builder.append(fechaCargaDatamart);
		builder.append(", montoConstitutivo=");
		builder.append(montoConstitutivo);
		builder.append(", delegacionControl=");
		builder.append(delegacionControl);
		builder.append(", fechaActualizacionProcesar=");
		builder.append(fechaActualizacionProcesar);
		builder.append(", folioIssste=");
		builder.append(folioIssste);
		builder.append(", cuentaBancaria=");
		builder.append(cuentaBancaria);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", movimiento=");
		builder.append(movimiento);
		builder.append(", idDiagnosticoRcv=");
		builder.append(idDiagnosticoRcv);
		builder.append(", idDiagnosticoViv=");
		builder.append(idDiagnosticoViv);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", fechaConfirmacion=");
		builder.append(fechaConfirmacion);
		builder.append(", fechaValorVivienda=");
		builder.append(fechaValorVivienda);
		builder.append(", centroPagoSar=");
		builder.append(centroPagoSar);
		builder.append(", indComplementaria=");
		builder.append(indComplementaria);
		builder.append(", iretMatrizDerecho=");
		builder.append(iretMatrizDerecho);
		builder.append("]");
		return builder.toString();
	}

}
