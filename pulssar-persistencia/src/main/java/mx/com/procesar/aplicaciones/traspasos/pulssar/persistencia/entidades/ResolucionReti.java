package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mapeo tabla RETI_TR_RESOLUCION
 * @author ANOSORIO
 *
 */
@Entity
@Table(name = "RETI_TR_RESOLUCION")
public class ResolucionReti implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 2833887452824130641L;

	/**
	 * idResolucion
	 */
	@Id
	@SequenceGenerator(name = "RETI_SEQ_RESOLUCION", sequenceName = "RETI_SEQ_RESOLUCION", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RETI_SEQ_RESOLUCION")
	@Column(name="ID_RESOLUCION")
	private Long idResolucion;
	
	/**
	 * idRecepResolucion
	 */
	@Column(name="ID_RECEP_RESOLUCION")
	private Long idRecepResolucion;
	
     /**
      * idSolicitudSaldo
      */
	@Column(name="ID_SOLICITUD_SALDO")
	private Long idSolicitudSaldo;
	
	/**
	 * idProcesar
	 */
	@Column(name="ID_PROCESAR")
	private Long idProcesar;
	
	/**
	 * idMatrizDerecho
	 */
	@Column(name="ID_MATRIZ_DERECHO")
	private Long idMatrizDerecho;
	
	/**
	 * idProcesarAfore
	 */
	@Column(name="ID_PROCESAR_AFORE")
	private Long idProcesarAfore;
	
	/**
	 * idDiagnostico
	 */
	@Column(name="ID_DIAGNOSTICO")
	private Long idDiagnostico;
	
	/**
	 * clavePmg
	 */
	@Column(name="CV_PMG")
	private String clavePmg;
	
	/**
	 * claveTipoLiquidacion
	 */
    @Column(name="CV_TIPO_LIQUIDACION")
	private String claveTipoLiquidacion;
    
    /**
     * claveAseguradora
     */
	@Column(name="CV_ASEGURADORA")
	private String claveAseguradora;
	
	/**
	 * claveTransferenciaPrevia
	 */
	@Column(name="CV_TRANSFERENCIA_PREVIA")
	private String claveTransferenciaPrevia;
	
	/**
	 * claveEstatusResolucion
	 */
	@Column(name="CV_ESTATUS_RESOLUCION")
	private String claveEstatusResolucion;
	
	/**
	 * claveTipoResolucion
	 */
	@Column(name="CV_TIPO_RESOLUCION")
	private String claveTipoResolucion;
	
	/**
	 * claveProceso
	 */
	@Column(name="CV_PROCESO")
	private String claveProceso;
	
	/**
	 * claveTipoOperacion
	 */
	@Column(name="CV_TIPO_OPERACION")
	private String claveTipoOperacion;
	
	/**
	 * articuloNegativa
	 */
    @Column(name="CH_ARTICULO_NEGATIVA")
	private String articuloNegativa;
    
    /**
     * secuenciaPension
     */
	@Column(name="CH_SECUENCIA_PENSION")
	private String secuenciaPension;
	
	/**
	 * fraccionNegativa
	 */
	@Column(name="CH_FRACCION_NEGATIVA")
	private String fraccionNegativa;
	
	/**
	 * considerandoNegativa
	 */
	@Column(name="CH_CONSIDERANDO_NEGATIVA")
	private String considerandoNegativa;
	
	/**
	 * fechaInicioPension
	 */
	@Column(name="FC_INICIO_PENSION")
	@Temporal(TemporalType.DATE)
	private Date fechaInicioPension;
	
	/**
	 * fechaInicioPago
	 */
	@Column(name="FC_INICIO_PAGO")
	@Temporal(TemporalType.DATE)
	private Date fechaInicioPago;
	
	/**
	 * numeroResolucion
	 */
	@Column(name="CH_NUMERO_RESOLUCION")
	private String numeroResolucion;
	
	/**
	 * fechaEmisionResolucion
	 */
	
    @Column(name="FC_EMISION_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaEmisionResolucion;
    
    /**
     * porcentajeValuacion
     */
	@Column(name="NU_PORCENTAJE_VALUACION")
	private Long porcentajeValuacion;
	
	/**
	 * semanasCotizacion
	 */
	@Column(name="NU_SEMANAS_COTIZACION")
	private Long semanasCotizacion; 
	
	/**
	 * claveMovimiento
	 */
	@Column(name="CV_MOVIMIENTO")
	private String claveMovimiento;
	
	/**
	 * fechaCargaDatamart
	 */
	@Column(name="FC_CARGA_DATAMART")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCargaDatamart;
	
	/**
	 * fechaActualizaProcesar
	 */
	@Column(name="FC_ACTUALIZA_PROCESAR")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizaProcesar;
	
	/**
	 * montoConstitutiva
	 */
	@Column(name="NU_MONTO_CONSTITUTIVO")
	private Double montoConstitutivo;
	
	/**
	 * montoCnstitutivoDerPropio
	 */
    @Column(name="NU_MONTO_CNSTITUTVO_DER_PROPIO")
	private Double montoCnstitutivoDerPropio;
    
    /**
     * umfControl
     */
	@Column(name="CH_UMF_CONTROL")
	private String umfControl;
	
	/**
	 * claveDelegacionControl
	 */
	@Column(name="CH_CLAVE_DELEGACION_CONTROL")
	private String claveDelegacionControl;
	
	/**
	 * centroInformatico
	 */
	@Column(name="CH_CENTRO_INFORMATICO")
	private String centroInformatico;
	
	/**
	 * identifEleccionRegimen
	 */
	@Column(name="CH_IDENTIF_ELECCION_REGIMEN")
	private String identifEleccionRegimen;
	
	/**
	 * fechaResolucion
	 */
	@Column(name="FC_RESOLUCION")
	@Temporal(TemporalType.DATE)
	private Date fechaResolucion;
	
	/**
	 * reImpactos
	 */
	
	@Column(name="CH_REIMPACTOS")
	private String reImpactos;
	
	/**
	 * montoAcumuladoRcv
	 */
    @Column(name="NU_MONTO_ACUMULADO_RCV")
	private Double montoAcumuladoRcv;
    
    /**
     * montoAcumuladoViv
     */
	@Column(name="NU_MONTO_ACUMULADO_VIV")
	private Double montoAcumuladoViv;
	
	/**
	 * fechaControl
	 */
	@Column(name="FC_CONTROL")
	@Temporal(TemporalType.DATE)
	private Date fechaControl;
	
	/**
	 * usuarioModificador
	 */
	@Column(name="CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

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
	 * @return the idSolicitudSaldo
	 */
	public Long getIdSolicitudSaldo() {
		return idSolicitudSaldo;
	}

	/**
	 * @param idSolicitudSaldo the idSolicitudSaldo to set
	 */
	public void setIdSolicitudSaldo(Long idSolicitudSaldo) {
		this.idSolicitudSaldo = idSolicitudSaldo;
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
	 * @return the idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho the idMatrizDerecho to set
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
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
	 * @return the clavePmg
	 */
	public String getClavePmg() {
		return clavePmg;
	}

	/**
	 * @param clavePmg the clavePmg to set
	 */
	public void setClavePmg(String clavePmg) {
		this.clavePmg = clavePmg;
	}

	/**
	 * @return the claveTipoLiquidacion
	 */
	public String getClaveTipoLiquidacion() {
		return claveTipoLiquidacion;
	}

	/**
	 * @param claveTipoLiquidacion the claveTipoLiquidacion to set
	 */
	public void setClaveTipoLiquidacion(String claveTipoLiquidacion) {
		this.claveTipoLiquidacion = claveTipoLiquidacion;
	}

	/**
	 * @return the claveAseguradora
	 */
	public String getClaveAseguradora() {
		return claveAseguradora;
	}

	/**
	 * @param claveAseguradora the claveAseguradora to set
	 */
	public void setClaveAseguradora(String claveAseguradora) {
		this.claveAseguradora = claveAseguradora;
	}

	/**
	 * @return the claveTransferenciaPrevia
	 */
	public String getClaveTransferenciaPrevia() {
		return claveTransferenciaPrevia;
	}

	/**
	 * @param claveTransferenciaPrevia the claveTransferenciaPrevia to set
	 */
	public void setClaveTransferenciaPrevia(String claveTransferenciaPrevia) {
		this.claveTransferenciaPrevia = claveTransferenciaPrevia;
	}

	/**
	 * @return the claveEstatusResolucion
	 */
	public String getClaveEstatusResolucion() {
		return claveEstatusResolucion;
	}

	/**
	 * @param claveEstatusResolucion the claveEstatusResolucion to set
	 */
	public void setClaveEstatusResolucion(String claveEstatusResolucion) {
		this.claveEstatusResolucion = claveEstatusResolucion;
	}

	/**
	 * @return the claveTipoResolucion
	 */
	public String getClaveTipoResolucion() {
		return claveTipoResolucion;
	}

	/**
	 * @param claveTipoResolucion the claveTipoResolucion to set
	 */
	public void setClaveTipoResolucion(String claveTipoResolucion) {
		this.claveTipoResolucion = claveTipoResolucion;
	}

	/**
	 * @return the claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso the claveProceso to set
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return the claveTipoOperacion
	 */
	public String getClaveTipoOperacion() {
		return claveTipoOperacion;
	}

	/**
	 * @param claveTipoOperacion the claveTipoOperacion to set
	 */
	public void setClaveTipoOperacion(String claveTipoOperacion) {
		this.claveTipoOperacion = claveTipoOperacion;
	}

	/**
	 * @return the articuloNegativa
	 */
	public String getArticuloNegativa() {
		return articuloNegativa;
	}

	/**
	 * @param articuloNegativa the articuloNegativa to set
	 */
	public void setArticuloNegativa(String articuloNegativa) {
		this.articuloNegativa = articuloNegativa;
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
	 * @return the fraccionNegativa
	 */
	public String getFraccionNegativa() {
		return fraccionNegativa;
	}

	/**
	 * @param fraccionNegativa the fraccionNegativa to set
	 */
	public void setFraccionNegativa(String fraccionNegativa) {
		this.fraccionNegativa = fraccionNegativa;
	}

	/**
	 * @return the considerandoNegativa
	 */
	public String getConsiderandoNegativa() {
		return considerandoNegativa;
	}

	/**
	 * @param considerandoNegativa the considerandoNegativa to set
	 */
	public void setConsiderandoNegativa(String considerandoNegativa) {
		this.considerandoNegativa = considerandoNegativa;
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
	 * @return the fechaInicioPago
	 */
	public Date getFechaInicioPago() {
		return fechaInicioPago;
	}

	/**
	 * @param fechaInicioPago the fechaInicioPago to set
	 */
	public void setFechaInicioPago(Date fechaInicioPago) {
		this.fechaInicioPago = fechaInicioPago;
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
	 * @return the fechaEmisionResolucion
	 */
	public Date getFechaEmisionResolucion() {
		return fechaEmisionResolucion;
	}

	/**
	 * @param fechaEmisionResolucion the fechaEmisionResolucion to set
	 */
	public void setFechaEmisionResolucion(Date fechaEmisionResolucion) {
		this.fechaEmisionResolucion = fechaEmisionResolucion;
	}

	/**
	 * @return the porcentajeValuacion
	 */
	public Long getPorcentajeValuacion() {
		return porcentajeValuacion;
	}

	/**
	 * @param porcentajeValuacion the porcentajeValuacion to set
	 */
	public void setPorcentajeValuacion(Long porcentajeValuacion) {
		this.porcentajeValuacion = porcentajeValuacion;
	}

	/**
	 * @return the semanasCotizacion
	 */
	public Long getSemanasCotizacion() {
		return semanasCotizacion;
	}

	/**
	 * @param semanasCotizacion the semanasCotizacion to set
	 */
	public void setSemanasCotizacion(Long semanasCotizacion) {
		this.semanasCotizacion = semanasCotizacion;
	}

	/**
	 * @return the claveMovimiento
	 */
	public String getClaveMovimiento() {
		return claveMovimiento;
	}

	/**
	 * @param claveMovimiento the claveMovimiento to set
	 */
	public void setClaveMovimiento(String claveMovimiento) {
		this.claveMovimiento = claveMovimiento;
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
	 * @return the fechaActualizaProcesar
	 */
	public Date getFechaActualizaProcesar() {
		return fechaActualizaProcesar;
	}

	/**
	 * @param fechaActualizaProcesar the fechaActualizaProcesar to set
	 */
	public void setFechaActualizaProcesar(Date fechaActualizaProcesar) {
		this.fechaActualizaProcesar = fechaActualizaProcesar;
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
	 * @return the montoCnstitutivoDerPropio
	 */
	public Double getMontoCnstitutivoDerPropio() {
		return montoCnstitutivoDerPropio;
	}

	/**
	 * @param montoCnstitutivoDerPropio the montoCnstitutivoDerPropio to set
	 */
	public void setMontoCnstitutivoDerPropio(Double montoCnstitutivoDerPropio) {
		this.montoCnstitutivoDerPropio = montoCnstitutivoDerPropio;
	}

	/**
	 * @return the umfControl
	 */
	public String getUmfControl() {
		return umfControl;
	}

	/**
	 * @param umfControl the umfControl to set
	 */
	public void setUmfControl(String umfControl) {
		this.umfControl = umfControl;
	}

	/**
	 * @return the claveDelegacionControl
	 */
	public String getClaveDelegacionControl() {
		return claveDelegacionControl;
	}

	/**
	 * @param claveDelegacionControl the claveDelegacionControl to set
	 */
	public void setClaveDelegacionControl(String claveDelegacionControl) {
		this.claveDelegacionControl = claveDelegacionControl;
	}

	/**
	 * @return the centroInformatico
	 */
	public String getCentroInformatico() {
		return centroInformatico;
	}

	/**
	 * @param centroInformatico the centroInformatico to set
	 */
	public void setCentroInformatico(String centroInformatico) {
		this.centroInformatico = centroInformatico;
	}

	/**
	 * @return the identifEleccionRegimen
	 */
	public String getIdentifEleccionRegimen() {
		return identifEleccionRegimen;
	}

	/**
	 * @param identifEleccionRegimen the identifEleccionRegimen to set
	 */
	public void setIdentifEleccionRegimen(String identifEleccionRegimen) {
		this.identifEleccionRegimen = identifEleccionRegimen;
	}

	/**
	 * @return the fechaResolucion
	 */
	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	/**
	 * @param fechaResolucion the fechaResolucion to set
	 */
	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	/**
	 * @return the reImpactos
	 */
	public String getReImpactos() {
		return reImpactos;
	}

	/**
	 * @param reImpactos the reImpactos to set
	 */
	public void setReImpactos(String reImpactos) {
		this.reImpactos = reImpactos;
	}

	/**
	 * @return the montoAcumuladoRcv
	 */
	public Double getMontoAcumuladoRcv() {
		return montoAcumuladoRcv;
	}

	/**
	 * @param montoAcumuladoRcv the montoAcumuladoRcv to set
	 */
	public void setMontoAcumuladoRcv(Double montoAcumuladoRcv) {
		this.montoAcumuladoRcv = montoAcumuladoRcv;
	}

	/**
	 * @return the montoAcumuladoViv
	 */
	public Double getMontoAcumuladoViv() {
		return montoAcumuladoViv;
	}

	/**
	 * @param montoAcumuladoViv the montoAcumuladoViv to set
	 */
	public void setMontoAcumuladoViv(Double montoAcumuladoViv) {
		this.montoAcumuladoViv = montoAcumuladoViv;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResolucionReti [idResolucion=");
		builder.append(idResolucion);
		builder.append(", idRecepResolucion=");
		builder.append(idRecepResolucion);
		builder.append(", idSolicitudSaldo=");
		builder.append(idSolicitudSaldo);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", idProcesarAfore=");
		builder.append(idProcesarAfore);
		builder.append(", idDiagnostico=");
		builder.append(idDiagnostico);
		builder.append(", clavePmg=");
		builder.append(clavePmg);
		builder.append(", claveTipoLiquidacion=");
		builder.append(claveTipoLiquidacion);
		builder.append(", claveAseguradora=");
		builder.append(claveAseguradora);
		builder.append(", claveTransferenciaPrevia=");
		builder.append(claveTransferenciaPrevia);
		builder.append(", claveEstatusResolucion=");
		builder.append(claveEstatusResolucion);
		builder.append(", claveTipoResolucion=");
		builder.append(claveTipoResolucion);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", claveTipoOperacion=");
		builder.append(claveTipoOperacion);
		builder.append(", articuloNegativa=");
		builder.append(articuloNegativa);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", fraccionNegativa=");
		builder.append(fraccionNegativa);
		builder.append(", considerandoNegativa=");
		builder.append(considerandoNegativa);
		builder.append(", fechaInicioPension=");
		builder.append(fechaInicioPension);
		builder.append(", fechaInicioPago=");
		builder.append(fechaInicioPago);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", fechaEmisionResolucion=");
		builder.append(fechaEmisionResolucion);
		builder.append(", porcentajeValuacion=");
		builder.append(porcentajeValuacion);
		builder.append(", semanasCotizacion=");
		builder.append(semanasCotizacion);
		builder.append(", claveMovimiento=");
		builder.append(claveMovimiento);
		builder.append(", fechaCargaDatamart=");
		builder.append(fechaCargaDatamart);
		builder.append(", fechaActualizaProcesar=");
		builder.append(fechaActualizaProcesar);
		builder.append(", montoConstitutivo=");
		builder.append(montoConstitutivo);
		builder.append(", montoCnstitutivoDerPropio=");
		builder.append(montoCnstitutivoDerPropio);
		builder.append(", umfControl=");
		builder.append(umfControl);
		builder.append(", claveDelegacionControl=");
		builder.append(claveDelegacionControl);
		builder.append(", centroInformatico=");
		builder.append(centroInformatico);
		builder.append(", identifEleccionRegimen=");
		builder.append(identifEleccionRegimen);
		builder.append(", fechaResolucion=");
		builder.append(fechaResolucion);
		builder.append(", reImpactos=");
		builder.append(reImpactos);
		builder.append(", montoAcumuladoRcv=");
		builder.append(montoAcumuladoRcv);
		builder.append(", montoAcumuladoViv=");
		builder.append(montoAcumuladoViv);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
