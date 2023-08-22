package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de trabajador con la información detallada
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosTrabajador implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8711827515084059741L;

	/**
	 * username
	 */
	private String nombreTrabajador;
	
	/**
	 * username
	 */
	private String nss;
	
	/**
	 * Clave Afore
	 */
	private String claveAfore;
	
	/**
	 * procesar
	 */
	private Long procesar;
	
	/**
	 * Datos Certificables
	 */
	private DatosCertificables datosCertificables;
	
	/**
	 * Datos no certificables
	 */
	private DatosNoCertificables datosNoCertificables;
	
	/**
	 * Datos no Complementarios
	 */
	private DatosComplementarios datosComplementarios;
	
	/**
	 * Datos no certificables
	 */
	private DatosExpediente datosExpediente;
	
	/**
	 * Lista de marcas del trabajador
	 */
	private List<String> marcas;
	
	/**
	 * Lista de afores duplicadas
	 */
	private List<String> aforesDuplicadas;
	
	/**
	 * Nombre Imss Procanase
	 */
	private String nombreImss;
	
	/**
	 * Imagen
	 */
	private String imagen;
	
	/**
	 * Renapo
	 */
	private Renapo renapo;
	
	/**
	 * Icefas
	 */
	private DatosSalariosIcefas salariosIcefas;
	
	/**
	 * Icefas
	 */
	private DatosSaldos saldos;
	
	/**
	 * Folio generado
	 */
	private FolioEntrada folio;
	
	/**
	 * Bandera de certificado
	 */
	private ExpedienteRecertificacion certificado;

	
	/**
	 * Nacionaklidad
	 */
	private String nacionalidad;

	/**
	 * origen
	 */
	private BigInteger origen;
	
	/**
	 * claveAdminActual
	 */
	private String claveAdminActual;
	
	/**
	 * tipoDePrestacion
	 */
	private String tipoDePrestacion;
	
	/**
	 * tipoAfiliacion
	 */
	private String tipoAfiliacion;
	
	/**
	 * tipoAfiliacion
	 */
	private String tipoSolicitante;
	
	/**
	 * Sello
	 */
	private Sello sello;
	
	/**
	 * canase
	 */
	private Canase canase;

	/**
	 * Fecha de retiro desempleo
	 */
	private String fechaDesempleo;
	
	/**
	 * Fecha de retiro matrimonio
	 */
	private String fechaMatrimonio;
	
	/**
	 * Curp solicitante
	 */
	private String curpSolicitante;
	
	
	/**
	 * existeTrabajador
	 */
	private Boolean existeTrabajador;
	
	/**
	 * Contructor
	 */
	public DatosTrabajador() {
		super();
		this.datosCertificables = new DatosCertificables();
		this.datosNoCertificables = new DatosNoCertificables();
		this.datosComplementarios = new DatosComplementarios();
		this.datosExpediente = new DatosExpediente();
		this.marcas = new ArrayList<>();
		this.aforesDuplicadas = new ArrayList<>();
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
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
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the procesar
	 */
	public Long getProcesar() {
		return procesar;
	}

	/**
	 * @param procesar the procesar to set
	 */
	public void setProcesar(Long procesar) {
		this.procesar = procesar;
	}

	/**
	 * @return the datosCertificables
	 */
	public DatosCertificables getDatosCertificables() {
		return datosCertificables;
	}

	/**
	 * @param datosCertificables the datosCertificables to set
	 */
	public void setDatosCertificables(DatosCertificables datosCertificables) {
		this.datosCertificables = datosCertificables;
	}

	/**
	 * @return the datosNoCertificables
	 */
	public DatosNoCertificables getDatosNoCertificables() {
		return datosNoCertificables;
	}

	/**
	 * @param datosNoCertificables the datosNoCertificables to set
	 */
	public void setDatosNoCertificables(DatosNoCertificables datosNoCertificables) {
		this.datosNoCertificables = datosNoCertificables;
	}

	/**
	 * @return the datosComplementarios
	 */
	public DatosComplementarios getDatosComplementarios() {
		return datosComplementarios;
	}

	/**
	 * @param datosComplementarios the datosComplementarios to set
	 */
	public void setDatosComplementarios(DatosComplementarios datosComplementarios) {
		this.datosComplementarios = datosComplementarios;
	}

	/**
	 * @return the datosExpediente
	 */
	public DatosExpediente getDatosExpediente() {
		return datosExpediente;
	}

	/**
	 * @param datosExpediente the datosExpediente to set
	 */
	public void setDatosExpediente(DatosExpediente datosExpediente) {
		this.datosExpediente = datosExpediente;
	}

	/**
	 * @return the marcas
	 */
	public List<String> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<String> marcas) {
		this.marcas = marcas;
	}

	/**
	 * @return the aforesDuplicadas
	 */
	public List<String> getAforesDuplicadas() {
		return aforesDuplicadas;
	}

	/**
	 * @param aforesDuplicadas the aforesDuplicadas to set
	 */
	public void setAforesDuplicadas(List<String> aforesDuplicadas) {
		this.aforesDuplicadas = aforesDuplicadas;
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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the renapo
	 */
	public Renapo getRenapo() {
		return renapo;
	}

	/**
	 * @param renapo the renapo to set
	 */
	public void setRenapo(Renapo renapo) {
		this.renapo = renapo;
	}

	/**
	 * @return the salariosIcefas
	 */
	public DatosSalariosIcefas getSalariosIcefas() {
		return salariosIcefas;
	}

	/**
	 * @param salariosIcefas the salariosIcefas to set
	 */
	public void setSalariosIcefas(DatosSalariosIcefas salariosIcefas) {
		this.salariosIcefas = salariosIcefas;
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
	 * @return the folio
	 */
	public FolioEntrada getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(FolioEntrada folio) {
		this.folio = folio;
	}

	/**
	 * @return the certificado
	 */
	public ExpedienteRecertificacion getCertificado() {
		return certificado;
	}

	/**
	 * @param certificado the certificado to set
	 */
	public void setCertificado(ExpedienteRecertificacion certificado) {
		this.certificado = certificado;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 *  getOrigen
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public BigInteger getOrigen() {
		return origen;
	}

	/**
	 *  setOrigen
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param origen
	 */
	public void setOrigen(BigInteger origen) {
		this.origen = origen;
	}

	/**
	 *  getClaveAdminActual
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getClaveAdminActual() {
		return claveAdminActual;
	}

	/**
	 *  setClaveAdminActual
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param claveAdminActual
	 */
	public void setClaveAdminActual(String claveAdminActual) {
		this.claveAdminActual = claveAdminActual;
	}

	/**
	 *  getTipoDePrestacion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getTipoDePrestacion() {
		return tipoDePrestacion;
	}

	/**
	 *  setTipoDePrestacion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param tipoDePrestacion
	 */
	public void setTipoDePrestacion(String tipoDePrestacion) {
		this.tipoDePrestacion = tipoDePrestacion;
	}


	/**
	 * @return the tipoAfiliacion
	 */
	public String getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	/**
	 * @param tipoAfiliacion the tipoAfiliacion to set
	 */
	public void setTipoAfiliacion(String tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
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
	 * @return el atributo sello
	 */
	public Sello getSello() {
		return sello;
	}

	/**
	 * @param sello parametro sello a actualizar
	 */
	public void setSello(Sello sello) {
		this.sello = sello;
	}

	/**
	 * @return el atributo canase
	 */
	public Canase getCanase() {
		return canase;
	}

	/**
	 * @param canase parametro canase a actualizar
	 */
	public void setCanase(Canase canase) {
		this.canase = canase;
	}

	/**
	 * @return el atributo fechaDesempleo
	 */
	public String getFechaDesempleo() {
		return fechaDesempleo;
	}

	/**
	 * @param fechaDesempleo parametro fechaDesempleo a actualizar
	 */
	public void setFechaDesempleo(String fechaDesempleo) {
		this.fechaDesempleo = fechaDesempleo;
	}

	/**
	 * @return el atributo fechaMatrimonio
	 */
	public String getFechaMatrimonio() {
		return fechaMatrimonio;
	}

	/**
	 * @param fechaMatrimonio parametro fechaMatrimonio a actualizar
	 */
	public void setFechaMatrimonio(String fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
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
	 * @return the existeTrabajador
	 */
	public Boolean getExisteTrabajador() {
		return existeTrabajador;
	}

	/**
	 * @param existeTrabajador the existeTrabajador to set
	 */
	public void setExisteTrabajador(Boolean existeTrabajador) {
		this.existeTrabajador = existeTrabajador;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosTrabajador [nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", procesar=");
		builder.append(procesar);
		builder.append(", datosCertificables=");
		builder.append(datosCertificables);
		builder.append(", datosNoCertificables=");
		builder.append(datosNoCertificables);
		builder.append(", datosComplementarios=");
		builder.append(datosComplementarios);
		builder.append(", datosExpediente=");
		builder.append(datosExpediente);
		builder.append(", marcas=");
		builder.append(marcas);
		builder.append(", aforesDuplicadas=");
		builder.append(aforesDuplicadas);
		builder.append(", nombreImss=");
		builder.append(nombreImss);
		builder.append(", imagen=");
		builder.append(imagen);
		builder.append(", renapo=");
		builder.append(renapo);
		builder.append(", salariosIcefas=");
		builder.append(salariosIcefas);
		builder.append(", saldos=");
		builder.append(saldos);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", certificado=");
		builder.append(certificado);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", claveAdminActual=");
		builder.append(claveAdminActual);
		builder.append(", tipoDePrestacion=");
		builder.append(tipoDePrestacion);
		builder.append(", tipoAfiliacion=");
		builder.append(tipoAfiliacion);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", sello=");
		builder.append(sello);
		builder.append(", canase=");
		builder.append(canase);
		builder.append(", fechaDesempleo=");
		builder.append(fechaDesempleo);
		builder.append(", fechaMatrimonio=");
		builder.append(fechaMatrimonio);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", existeTrabajador=");
		builder.append(existeTrabajador);
		builder.append("]");
		return builder.toString();
	}

	
}