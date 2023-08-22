package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Datos generales de disposicion issste
 * @author RARREOLA
 *
 */
public class DatosGeneralesDispIssste implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129922942388139349L;
	
	/**
	 * numeroIssste
	 */
	private String numeroIssste;
	
	/**
	 * Telefono laboral
	 */
	private String telefonoLaboral;

	
	
	/**
	 * Descripcion solicitante
	 */
	private String descripcionSolicitante;
	
	/**
	 * Clave doc probatorio
	 */
	private String claveDocProbatorio;
	
	/**
	 * Descripcion doc probatorio
	 */
	private String descDocProbatorio;
	
	
	/**
	 * Tipo recursos a disponer
	 */
	private String claveTipoRecursosDisponer;
	
	/**
	 * TipoRecursosDisponer
	 */
	private String descTipoRecursosDisponer;
	
	/**
	 * clave regimen
	 */
	private String claveRegimen;
	
	/**
	 * Desc regimen
	 */
	private String descRegimen;
	
	/**
	 * Clave retiro
	 */
	private String claveRetiro;
	
	/**
	 * Desc retiro
	 */
	private String descRetiro;
	
	/**
	 * Clave seguro
	 */
	private String claveSeguro;
	
	
	/**
	 * Desc seguro
	 */
	private String descSeguro;
	
	/**
	 * Clave tipo pension
	 */
	private String claveTipoPension;
	
	/**
	 * Desc tipo pension
	 */
	private String descTipoPension;
	
	/**
	 * Clave tipo prestacion
	 */
	private String claveTipoPrestacion;
	
	/**
	 * Desc tipo prestacion
	 */
	private String descTipoPrestacion;
	
	/**
	 * Clave pension
	 */
	private String clavePension;
	
	/**
	 * Desc clave pension
	 */
	private String descClavePension;
	
	/**
	 * Clave mov
	 */
	private String claveMov;
	
	/**
	 * Desc mov
	 */
	private String descMov;
	
	
	
	/**
	 * Numero resolucion
	 */
	private String numeroResolucion;
	
	/**
	 * Secuencia pension
	 */
	private String secuenciaPension;
	
	/**
	 * Fecha inicio pension
	 */
	private String fechaInicioPension;
	
	/**
	 * Fecha emision pension
	 */
	private String fechaEmisionPension;
	
	/**
	 * Numero semanas cotizadas
	 */
	private String numeroSemanasCotizadas;
	
	/**
	 * Fecha solicitud
	 */
	private String fechaSolicitud;
	
	/**
	 * Fecha nacimiento
	 */
	private String fechaNacimiento;
	
	
	/**
	 * id resolucion
	 */
	private String idResolucion;
	
	/**
	 * cus
	 */
	private String cus;
	
	
	/**
	 * clave regimen
	 */
	private String claveRegimenPlan;
	
	/**
	 * Desc regimen
	 */
	private String descRegimenPlan;
	
	/**
	 * numero de folio
	 */
	private String numeroFolio;

	/**
	 * numero de unidad
	 */
	private String numeroUnidad;

	/**
	 * nombre del trabajador
	 */
	private String nombre;

	

	/**
	 * nss del trabajador
	 */
	private String nss;

	/**
	 * rfc del trabajador
	 */
	private String rfc;

	/**
	 * apellido paterno del trabajador
	 */
	private String apellidoPaterno;

	/**
	 * apellido materno del trabajador
	 */
	private String apellidoMaterno;



	/**
	 * genero masculino p femenino
	 */
	private String genero;

	/**
	 * curp del trabajador
	 */
	private String curp;

	/**
	 * lada del telefono
	 */
	private String lada;

	/**
	 * telefono del trabajador
	 */
	private String telefono;

	/**
	 * extension del telefono
	 */
	private String extension;

	/**
	 * clave del celular
	 */
	private String claveCelular;

	/**
	 * lada del celular
	 */
	private String ladaCelular;

	/**
	 * celular del trabajdor
	 */
	private String celular;

	/**
	 * compañia del celular
	 */
	private String companiaCelular;

	/**
	 * correo electronico del trabajador
	 */
	private String email;

	/**
	 * calle
	 */
	private String calle;

	/**
	 * colonia
	 */
	private String colonia;

	/**
	 * numero exterior
	 */
	private String numeroExterior;

	/**
	 * número interior
	 */
	private String numeroInterior;

	/**
	 * código postal
	 */
	private String codigoPostal;

	/**
	 * país
	 */
	private String pais;

	/**
	 * poblacion
	 */
	private String poblacion;

	/**
	 * entidad federativa
	 */
	private String entidadFederativa;

	/**
	 * delegacion o municipio
	 */
	private String delegacionMunicipio;

	
	/**
	 * forma de entrega para la modalidad B
	 */
	private String formaEntrega;

	/**
	 * indicador de que fue asesorado
	 */
	boolean asesorado;

	/**
	 * nombre del asesor
	 */
	private String nombreAsesor;

	/**
	 * curp del asesor
	 */
	private String curpAsesor;
	
	/**
	 * firma del empleado
	 */
	private String firmaEmpleado;

	/**
	 * firma del agente
	 */
	private String firmaAgente;
	
	/**
	 * nombre del archivo PDF
	 */
	private String nombreArchivo;

	
	/**
	 * lista cargado
	 */
	private List<ResolucionDisposicionIsssteVis> listaCargado;
	
	/**
	 * Tipo solicitante
	 */
	private String tipoSolicitante;
	
	
	/**
	 * Actuario
	 */
	private String actuario;
	
	/**
	 * Clave afore
	 */
	private String claveAforeCombo;
	
	/**
	 * Descripcion clave afore
	 */
	private String descripcionAforeCombo;
	
	/**
	 * Tipo recurso
	 */
	private String tipoRecursoClave;
	
	/**
	 * Tipo descripcion
	 */
	private String tipoRecursoDescripcion;
	
	/**
	 * subcuentasRcv
	 */
	private List<DatosSubcuentasDispIssste> subcuentasRcv;
	
	/**
	 * subcuentasViv
	 */
	private List<DatosSubcuentasDispIssste> subcuentasViv;
	
	/**
	 * Beneficiarios
	 */
	private List<DatosBenefDispIssste> beneficiariosDatos;

	/**
	 * montoTotalRcv
	 */
	private String montoTotalRcv;
	
	/**
	 * montoTotalViv
	 */
	private String montoTotalViv;
	
	/**
	 * montoTotalBen
	 */
	private String montoTotalBen;
	
	/**
	 * Afore trabajador
	 */
	private String aforeTrabajador;

	
	/**
	 * Siefores
	 */
	List<Siefore> sieforesLista;
	
	
	/**
	 * Folio solicitud
	 */
	private String folioSol;
	
	/**
	 * numero plan de pensiones
	 */
	private String numeroPlanPensiones;
	
	/**
	 * Sello trabajador
	 */
	private String selloTrabajador;
	
	/**
	 * Numero consecutivo
	 */
	private String numeroConsecutivo;
	
	/**
	 * Curp solicitante
	 */
	private String curpSolicitante;
	
	/**
	 * Clave afore del trabajador
	 */
	private String claveAforeTrabajador;
	
	
	/**
	 * Saldos
	 */
	private DatosSaldos saldos;
	
	/**
	 * Fecha periodo pago
	 */
	private String fechaPeriodoPago;
	
	
	
	
	
	
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
	 * @return the saldos
	 */
	public DatosSaldos getSaldos() {
		return saldos;
	}





	/**
	 * @param saldos the saldos to set
	 */
	public void setSaldos(DatosSaldos saldos) {
		this.saldos = saldos;
	}





	/**
	 * @return the claveAforeTrabajador
	 */
	public String getClaveAforeTrabajador() {
		return claveAforeTrabajador;
	}





	/**
	 * @param claveAforeTrabajador the claveAforeTrabajador to set
	 */
	public void setClaveAforeTrabajador(String claveAforeTrabajador) {
		this.claveAforeTrabajador = claveAforeTrabajador;
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
	 * @return the folioSol
	 */
	public String getFolioSol() {
		return folioSol;
	}





	/**
	 * @param folioSol the folioSol to set
	 */
	public void setFolioSol(String folioSol) {
		this.folioSol = folioSol;
	}





	/**
	 * @return the numeroPlanPensiones
	 */
	public String getNumeroPlanPensiones() {
		return numeroPlanPensiones;
	}





	/**
	 * @param numeroPlanPensiones the numeroPlanPensiones to set
	 */
	public void setNumeroPlanPensiones(String numeroPlanPensiones) {
		this.numeroPlanPensiones = numeroPlanPensiones;
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
	 * @return the numeroConsecutivo
	 */
	public String getNumeroConsecutivo() {
		return numeroConsecutivo;
	}





	/**
	 * @param numeroConsecutivo the numeroConsecutivo to set
	 */
	public void setNumeroConsecutivo(String numeroConsecutivo) {
		this.numeroConsecutivo = numeroConsecutivo;
	}





	/**
	 * @return the sieforesLista
	 */
	public List<Siefore> getSieforesLista() {
		return sieforesLista;
	}





	/**
	 * @param sieforesLista the sieforesLista to set
	 */
	public void setSieforesLista(List<Siefore> sieforesLista) {
		this.sieforesLista = sieforesLista;
	}





	




	





	/**
	 * @return the aforeTrabajador
	 */
	public String getAforeTrabajador() {
		return aforeTrabajador;
	}





	/**
	 * @param aforeTrabajador the aforeTrabajador to set
	 */
	public void setAforeTrabajador(String aforeTrabajador) {
		this.aforeTrabajador = aforeTrabajador;
	}





	/**
	 * @return the actuario
	 */
	public String getActuario() {
		return actuario;
	}





	/**
	 * @param actuario the actuario to set
	 */
	public void setActuario(String actuario) {
		this.actuario = actuario;
	}





	/**
	 * @return the montoTotalRcv
	 */
	public String getMontoTotalRcv() {
		return montoTotalRcv;
	}





	/**
	 * @param montoTotalRcv the montoTotalRcv to set
	 */
	public void setMontoTotalRcv(String montoTotalRcv) {
		this.montoTotalRcv = montoTotalRcv;
	}





	/**
	 * @return the montoTotalViv
	 */
	public String getMontoTotalViv() {
		return montoTotalViv;
	}





	/**
	 * @param montoTotalViv the montoTotalViv to set
	 */
	public void setMontoTotalViv(String montoTotalViv) {
		this.montoTotalViv = montoTotalViv;
	}





	/**
	 * @return the montoTotalBen
	 */
	public String getMontoTotalBen() {
		return montoTotalBen;
	}





	/**
	 * @param montoTotalBen the montoTotalBen to set
	 */
	public void setMontoTotalBen(String montoTotalBen) {
		this.montoTotalBen = montoTotalBen;
	}





	/**
	 * @return the beneficiariosDatos
	 */
	public List<DatosBenefDispIssste> getBeneficiariosDatos() {
		return beneficiariosDatos;
	}





	/**
	 * @param beneficiariosDatos the beneficiariosDatos to set
	 */
	public void setBeneficiariosDatos(List<DatosBenefDispIssste> beneficiariosDatos) {
		this.beneficiariosDatos = beneficiariosDatos;
	}





	/**
	 * @return the subcuentasRcv
	 */
	public List<DatosSubcuentasDispIssste> getSubcuentasRcv() {
		return subcuentasRcv;
	}





	/**
	 * @param subcuentasRcv the subcuentasRcv to set
	 */
	public void setSubcuentasRcv(List<DatosSubcuentasDispIssste> subcuentasRcv) {
		this.subcuentasRcv = subcuentasRcv;
	}





	/**
	 * @return the subcuentasViv
	 */
	public List<DatosSubcuentasDispIssste> getSubcuentasViv() {
		return subcuentasViv;
	}





	/**
	 * @param subcuentasViv the subcuentasViv to set
	 */
	public void setSubcuentasViv(List<DatosSubcuentasDispIssste> subcuentasViv) {
		this.subcuentasViv = subcuentasViv;
	}





	/**
	 * @return the tipoRecursoClave
	 */
	public String getTipoRecursoClave() {
		return tipoRecursoClave;
	}





	/**
	 * @param tipoRecursoClave the tipoRecursoClave to set
	 */
	public void setTipoRecursoClave(String tipoRecursoClave) {
		this.tipoRecursoClave = tipoRecursoClave;
	}





	/**
	 * @return the tipoRecursoDescripcion
	 */
	public String getTipoRecursoDescripcion() {
		return tipoRecursoDescripcion;
	}





	/**
	 * @param tipoRecursoDescripcion the tipoRecursoDescripcion to set
	 */
	public void setTipoRecursoDescripcion(String tipoRecursoDescripcion) {
		this.tipoRecursoDescripcion = tipoRecursoDescripcion;
	}










	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}





	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}





	/**
	 * @return the claveRegimenPlan
	 */
	public String getClaveRegimenPlan() {
		return claveRegimenPlan;
	}





	/**
	 * @param claveRegimenPlan the claveRegimenPlan to set
	 */
	public void setClaveRegimenPlan(String claveRegimenPlan) {
		this.claveRegimenPlan = claveRegimenPlan;
	}





	/**
	 * @return the descRegimenPlan
	 */
	public String getDescRegimenPlan() {
		return descRegimenPlan;
	}





	/**
	 * @param descRegimenPlan the descRegimenPlan to set
	 */
	public void setDescRegimenPlan(String descRegimenPlan) {
		this.descRegimenPlan = descRegimenPlan;
	}





	




	



	/**
	 * @return the cus
	 */
	public String getCus() {
		return cus;
	}





	/**
	 * @param cus the cus to set
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}





	/**
	 * @return the idResolucion
	 */
	public String getIdResolucion() {
		return idResolucion;
	}





	/**
	 * @param idResolucion the idResolucion to set
	 */
	public void setIdResolucion(String idResolucion) {
		this.idResolucion = idResolucion;
	}


	/**
	 * @return the descripcionSolicitante
	 */
	public String getDescripcionSolicitante() {
		return descripcionSolicitante;
	}





	/**
	 * @param descripcionSolicitante the descripcionSolicitante to set
	 */
	public void setDescripcionSolicitante(String descripcionSolicitante) {
		this.descripcionSolicitante = descripcionSolicitante;
	}





	/**
	 * @return the claveDocProbatorio
	 */
	public String getClaveDocProbatorio() {
		return claveDocProbatorio;
	}





	/**
	 * @param claveDocProbatorio the claveDocProbatorio to set
	 */
	public void setClaveDocProbatorio(String claveDocProbatorio) {
		this.claveDocProbatorio = claveDocProbatorio;
	}





	/**
	 * @return the descDocProbatorio
	 */
	public String getDescDocProbatorio() {
		return descDocProbatorio;
	}





	/**
	 * @param descDocProbatorio the descDocProbatorio to set
	 */
	public void setDescDocProbatorio(String descDocProbatorio) {
		this.descDocProbatorio = descDocProbatorio;
	}





	/**
	 * @return the claveTipoRecursosDisponer
	 */
	public String getClaveTipoRecursosDisponer() {
		return claveTipoRecursosDisponer;
	}





	/**
	 * @param claveTipoRecursosDisponer the claveTipoRecursosDisponer to set
	 */
	public void setClaveTipoRecursosDisponer(String claveTipoRecursosDisponer) {
		this.claveTipoRecursosDisponer = claveTipoRecursosDisponer;
	}





	/**
	 * @return the descTipoRecursosDisponer
	 */
	public String getDescTipoRecursosDisponer() {
		return descTipoRecursosDisponer;
	}





	/**
	 * @param descTipoRecursosDisponer the descTipoRecursosDisponer to set
	 */
	public void setDescTipoRecursosDisponer(String descTipoRecursosDisponer) {
		this.descTipoRecursosDisponer = descTipoRecursosDisponer;
	}





	/**
	 * @return the claveRegimen
	 */
	public String getClaveRegimen() {
		return claveRegimen;
	}





	/**
	 * @param claveRegimen the claveRegimen to set
	 */
	public void setClaveRegimen(String claveRegimen) {
		this.claveRegimen = claveRegimen;
	}





	/**
	 * @return the descRegimen
	 */
	public String getDescRegimen() {
		return descRegimen;
	}





	/**
	 * @param descRegimen the descRegimen to set
	 */
	public void setDescRegimen(String descRegimen) {
		this.descRegimen = descRegimen;
	}





	/**
	 * @return the claveRetiro
	 */
	public String getClaveRetiro() {
		return claveRetiro;
	}





	/**
	 * @param claveRetiro the claveRetiro to set
	 */
	public void setClaveRetiro(String claveRetiro) {
		this.claveRetiro = claveRetiro;
	}





	/**
	 * @return the descRetiro
	 */
	public String getDescRetiro() {
		return descRetiro;
	}





	/**
	 * @param descRetiro the descRetiro to set
	 */
	public void setDescRetiro(String descRetiro) {
		this.descRetiro = descRetiro;
	}





	/**
	 * @return the claveSeguro
	 */
	public String getClaveSeguro() {
		return claveSeguro;
	}





	/**
	 * @param claveSeguro the claveSeguro to set
	 */
	public void setClaveSeguro(String claveSeguro) {
		this.claveSeguro = claveSeguro;
	}





	/**
	 * @return the descSeguro
	 */
	public String getDescSeguro() {
		return descSeguro;
	}





	/**
	 * @param descSeguro the descSeguro to set
	 */
	public void setDescSeguro(String descSeguro) {
		this.descSeguro = descSeguro;
	}





	/**
	 * @return the claveTipoPension
	 */
	public String getClaveTipoPension() {
		return claveTipoPension;
	}





	/**
	 * @param claveTipoPension the claveTipoPension to set
	 */
	public void setClaveTipoPension(String claveTipoPension) {
		this.claveTipoPension = claveTipoPension;
	}





	/**
	 * @return the descTipoPension
	 */
	public String getDescTipoPension() {
		return descTipoPension;
	}





	/**
	 * @param descTipoPension the descTipoPension to set
	 */
	public void setDescTipoPension(String descTipoPension) {
		this.descTipoPension = descTipoPension;
	}





	/**
	 * @return the claveTipoPrestacion
	 */
	public String getClaveTipoPrestacion() {
		return claveTipoPrestacion;
	}





	/**
	 * @param claveTipoPrestacion the claveTipoPrestacion to set
	 */
	public void setClaveTipoPrestacion(String claveTipoPrestacion) {
		this.claveTipoPrestacion = claveTipoPrestacion;
	}





	/**
	 * @return the descTipoPrestacion
	 */
	public String getDescTipoPrestacion() {
		return descTipoPrestacion;
	}





	/**
	 * @param descTipoPrestacion the descTipoPrestacion to set
	 */
	public void setDescTipoPrestacion(String descTipoPrestacion) {
		this.descTipoPrestacion = descTipoPrestacion;
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
	 * @return the descClavePension
	 */
	public String getDescClavePension() {
		return descClavePension;
	}





	/**
	 * @param descClavePension the descClavePension to set
	 */
	public void setDescClavePension(String descClavePension) {
		this.descClavePension = descClavePension;
	}





	/**
	 * @return the claveMov
	 */
	public String getClaveMov() {
		return claveMov;
	}





	/**
	 * @param claveMov the claveMov to set
	 */
	public void setClaveMov(String claveMov) {
		this.claveMov = claveMov;
	}





	/**
	 * @return the descMov
	 */
	public String getDescMov() {
		return descMov;
	}





	/**
	 * @param descMov the descMov to set
	 */
	public void setDescMov(String descMov) {
		this.descMov = descMov;
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
	 * @return the fechaEmisionPension
	 */
	public String getFechaEmisionPension() {
		return fechaEmisionPension;
	}





	/**
	 * @param fechaEmisionPension the fechaEmisionPension to set
	 */
	public void setFechaEmisionPension(String fechaEmisionPension) {
		this.fechaEmisionPension = fechaEmisionPension;
	}





	/**
	 * @return the numeroSemanasCotizadas
	 */
	public String getNumeroSemanasCotizadas() {
		return numeroSemanasCotizadas;
	}





	/**
	 * @param numeroSemanasCotizadas the numeroSemanasCotizadas to set
	 */
	public void setNumeroSemanasCotizadas(String numeroSemanasCotizadas) {
		this.numeroSemanasCotizadas = numeroSemanasCotizadas;
	}





	/**
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}





	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
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
	 * @return the numeroFolio
	 */
	public String getNumeroFolio() {
		return numeroFolio;
	}





	/**
	 * @param numeroFolio the numeroFolio to set
	 */
	public void setNumeroFolio(String numeroFolio) {
		this.numeroFolio = numeroFolio;
	}





	/**
	 * @return the numeroUnidad
	 */
	public String getNumeroUnidad() {
		return numeroUnidad;
	}





	/**
	 * @param numeroUnidad the numeroUnidad to set
	 */
	public void setNumeroUnidad(String numeroUnidad) {
		this.numeroUnidad = numeroUnidad;
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
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}





	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
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
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}





	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
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
	 * @return the lada
	 */
	public String getLada() {
		return lada;
	}





	/**
	 * @param lada the lada to set
	 */
	public void setLada(String lada) {
		this.lada = lada;
	}





	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}





	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}





	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}





	/**
	 * @return the claveCelular
	 */
	public String getClaveCelular() {
		return claveCelular;
	}





	/**
	 * @param claveCelular the claveCelular to set
	 */
	public void setClaveCelular(String claveCelular) {
		this.claveCelular = claveCelular;
	}





	/**
	 * @return the ladaCelular
	 */
	public String getLadaCelular() {
		return ladaCelular;
	}





	/**
	 * @param ladaCelular the ladaCelular to set
	 */
	public void setLadaCelular(String ladaCelular) {
		this.ladaCelular = ladaCelular;
	}





	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}





	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}





	/**
	 * @return the companiaCelular
	 */
	public String getCompaniaCelular() {
		return companiaCelular;
	}





	/**
	 * @param companiaCelular the companiaCelular to set
	 */
	public void setCompaniaCelular(String companiaCelular) {
		this.companiaCelular = companiaCelular;
	}





	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}





	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}





	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}





	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}





	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}





	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}





	/**
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}





	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}





	/**
	 * @return the numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}





	/**
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}





	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}





	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}





	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}





	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}





	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}





	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}





	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}





	/**
	 * @param entidadFederativa the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}





	/**
	 * @return the delegacionMunicipio
	 */
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}





	/**
	 * @param delegacionMunicipio the delegacionMunicipio to set
	 */
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}





	/**
	 * @return the formaEntrega
	 */
	public String getFormaEntrega() {
		return formaEntrega;
	}





	/**
	 * @param formaEntrega the formaEntrega to set
	 */
	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}





	/**
	 * @return the asesorado
	 */
	public boolean isAsesorado() {
		return asesorado;
	}





	/**
	 * @param asesorado the asesorado to set
	 */
	public void setAsesorado(boolean asesorado) {
		this.asesorado = asesorado;
	}





	/**
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}





	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}





	/**
	 * @return the curpAsesor
	 */
	public String getCurpAsesor() {
		return curpAsesor;
	}





	/**
	 * @param curpAsesor the curpAsesor to set
	 */
	public void setCurpAsesor(String curpAsesor) {
		this.curpAsesor = curpAsesor;
	}





	/**
	 * @return the firmaEmpleado
	 */
	public String getFirmaEmpleado() {
		return firmaEmpleado;
	}





	/**
	 * @param firmaEmpleado the firmaEmpleado to set
	 */
	public void setFirmaEmpleado(String firmaEmpleado) {
		this.firmaEmpleado = firmaEmpleado;
	}





	/**
	 * @return the firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}





	/**
	 * @param firmaAgente the firmaAgente to set
	 */
	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}





	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}





	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}



	/**
	 * @return the listaCargado
	 */
	public List<ResolucionDisposicionIsssteVis> getListaCargado() {
		return listaCargado;
	}





	/**
	 * @param listaCargado the listaCargado to set
	 */
	public void setListaCargado(List<ResolucionDisposicionIsssteVis> listaCargado) {
		this.listaCargado = listaCargado;
	}



	/**
	 * @return the claveAforeCombo
	 */
	public String getClaveAforeCombo() {
		return claveAforeCombo;
	}





	/**
	 * @param claveAforeCombo the claveAforeCombo to set
	 */
	public void setClaveAforeCombo(String claveAforeCombo) {
		this.claveAforeCombo = claveAforeCombo;
	}





	/**
	 * @return the descripcionAforeCombo
	 */
	public String getDescripcionAforeCombo() {
		return descripcionAforeCombo;
	}





	/**
	 * @param descripcionAforeCombo the descripcionAforeCombo to set
	 */
	public void setDescripcionAforeCombo(String descripcionAforeCombo) {
		this.descripcionAforeCombo = descripcionAforeCombo;
	}





	/**
	 * @return the telefonoLaboral
	 */
	public String getTelefonoLaboral() {
		return telefonoLaboral;
	}





	/**
	 * @param telefonoLaboral the telefonoLaboral to set
	 */
	public void setTelefonoLaboral(String telefonoLaboral) {
		this.telefonoLaboral = telefonoLaboral;
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
