package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase para obtener la informacion de la aportacion de
 * un trabajador imss
 * 
 * @author dbarbosa
 * @version 1.0
 */
public class RetiroHistoricoAportacion implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 7703936421136733022L;
	
	/**
	 * Nss
	 */
	private String nss;
	
	/**
	 * cveEntidadReguladora
	 */
	private String cveEntidadReguladora;
	
	/**
	 * fechaValor
	 */
	private Date fechaValor;
	
	/**
	 * nssPatron
	 */
	private String nssPatron;
	
	/**
	 * periodoPago
	 */
	private String periodoPago;
	
	/**
	 * folioPago
	 */
	private String folioPago;
	
	/**
	 * fechaDispersionRCV
	 */
	private Date fechaDispersionRCV;
	
	/**
	 * fechaPago
	 */
	private Date fechaPago;
	
	/**
	 * FechaValorInst
	 */
	private Date fechaValorInst;
	/**
	 * rfc
	 */
	private String rfc;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * nombreImss
	 */
	private String nombreImss;
	
	/**
	 * folioSolicitud
	 */
	private String folioSolicitud;
	
	/**
	 * salarioIntegrado
	 */
	private Double salarioIntegrado;
	
	/**
	 * rfcPatronal
	 */
	private String rfcPatronal;
	
	/**
	 * diasCotizadosBim
	 */
	private Integer diasCotizadosBim;
	
	/**
	 * diasIncapacidadBim
	 */
	private Integer diasIncapacidadBim;
	
	/**
	 * diasAusentismoBIM
	 */
	private Integer diasAusentismoBIM;
	
	/**
	 * importeRetiro
	 */
	private Long importeRetiro;
	
	/**
	 * importeActRecRetiro
	 */
	private Long importeActRecRetiro;
	
	/**
	 * importeCvPatron
	 */
	private Long importeCvPatron;
	
	/**
	 * importeCvTrabajador
	 */
	private Long importeCvTrabajador;
	
	/**
	 * importeArCv
	 */
	private Long importeArCv;
	
	/**
	 * importeAportaVoluntarias
	 */
	private Long importeAportaVoluntarias;
	
	/**
	 * importeComplRetiro
	 */
	private Long importeComplRetiro;
	
	/**
	 * importeViviendaPatronal
	 */
	private Long importeViviendaPatronal;
	
	/**
	 * importeViviendaAr
	 */
	private Long importeViviendaAr;
	
	/**
	 * importeCuotaSocial
	 */
	private Long importeCuotaSocial;
	
	/**
	 * importeAportaEstatal
	 */
	private Long importeAportaEstatal;
	
	/**
	 * importeAportaEspecial
	 */
	private Long importeAportaEspecial;
	
	/**
	 * cveCuentaTesofe
	 */
	private String cveCuentaTesofe;
	
	/**
	 * dispersionTesofe
	 */
	private Date dispersionTesofe;
	
	/**
	 * aforeDispersionRcv
	 */
	private String aforeDispersionRcv;
	
	/**
	 * aforeDispersionTesofe
	 */
	private String aforeDispersionTesofe;
	
	/**
	 * fcControl
	 */
	private Date fcControl;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * nuActivo
	 */
	private Integer nuActivo;

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
	 * @return the cveEntidadReguladora
	 */
	public String getCveEntidadReguladora() {
		return cveEntidadReguladora;
	}

	/**
	 * @param cveEntidadReguladora the cveEntidadReguladora to set
	 */
	public void setCveEntidadReguladora(String cveEntidadReguladora) {
		this.cveEntidadReguladora = cveEntidadReguladora;
	}

	/**
	 * @return the fechaValor
	 */
	public Date getFechaValor() {
		return fechaValor;
	}

	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(Date fechaValor) {
		this.fechaValor = fechaValor;
	}

	/**
	 * @return the nssPatron
	 */
	public String getNssPatron() {
		return nssPatron;
	}

	/**
	 * @param nssPatron the nssPatron to set
	 */
	public void setNssPatron(String nssPatron) {
		this.nssPatron = nssPatron;
	}

	/**
	 * @return the periodoPago
	 */
	public String getPeriodoPago() {
		return periodoPago;
	}

	/**
	 * @param periodoPago the periodoPago to set
	 */
	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
	}

	/**
	 * @return the folioPago
	 */
	public String getFolioPago() {
		return folioPago;
	}

	/**
	 * @param folioPago the folioPago to set
	 */
	public void setFolioPago(String folioPago) {
		this.folioPago = folioPago;
	}

	/**
	 * @return the fechaDispersionRCV
	 */
	public Date getFechaDispersionRCV() {
		return fechaDispersionRCV;
	}

	/**
	 * @param fechaDispersionRCV the fechaDispersionRCV to set
	 */
	public void setFechaDispersionRCV(Date fechaDispersionRCV) {
		this.fechaDispersionRCV = fechaDispersionRCV;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the fechaValorInst
	 */
	public Date getFechaValorInst() {
		return fechaValorInst;
	}

	/**
	 * @param fechaValorInst the fechaValorInst to set
	 */
	public void setFechaValorInst(Date fechaValorInst) {
		this.fechaValorInst = fechaValorInst;
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
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}

	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	/**
	 * @return the salarioIntegrado
	 */
	public Double getSalarioIntegrado() {
		return salarioIntegrado;
	}

	/**
	 * @param salarioIntegrado the salarioIntegrado to set
	 */
	public void setSalarioIntegrado(Double salarioIntegrado) {
		this.salarioIntegrado = salarioIntegrado;
	}

	/**
	 * @return the rfcPatronal
	 */
	public String getRfcPatronal() {
		return rfcPatronal;
	}

	/**
	 * @param rfcPatronal the rfcPatronal to set
	 */
	public void setRfcPatronal(String rfcPatronal) {
		this.rfcPatronal = rfcPatronal;
	}

	/**
	 * @return the diasCotizadosBim
	 */
	public Integer getDiasCotizadosBim() {
		return diasCotizadosBim;
	}

	/**
	 * @param diasCotizadosBim the diasCotizadosBim to set
	 */
	public void setDiasCotizadosBim(Integer diasCotizadosBim) {
		this.diasCotizadosBim = diasCotizadosBim;
	}

	/**
	 * @return the diasIncapacidadBim
	 */
	public Integer getDiasIncapacidadBim() {
		return diasIncapacidadBim;
	}

	/**
	 * @param diasIncapacidadBim the diasIncapacidadBim to set
	 */
	public void setDiasIncapacidadBim(Integer diasIncapacidadBim) {
		this.diasIncapacidadBim = diasIncapacidadBim;
	}

	/**
	 * @return the diasAusentismoBIM
	 */
	public Integer getDiasAusentismoBIM() {
		return diasAusentismoBIM;
	}

	/**
	 * @param diasAusentismoBIM the diasAusentismoBIM to set
	 */
	public void setDiasAusentismoBIM(Integer diasAusentismoBIM) {
		this.diasAusentismoBIM = diasAusentismoBIM;
	}

	/**
	 * @return the importeRetiro
	 */
	public Long getImporteRetiro() {
		return importeRetiro;
	}

	/**
	 * @param importeRetiro the importeRetiro to set
	 */
	public void setImporteRetiro(Long importeRetiro) {
		this.importeRetiro = importeRetiro;
	}

	/**
	 * @return the importeActRecRetiro
	 */
	public Long getImporteActRecRetiro() {
		return importeActRecRetiro;
	}

	/**
	 * @param importeActRecRetiro the importeActRecRetiro to set
	 */
	public void setImporteActRecRetiro(Long importeActRecRetiro) {
		this.importeActRecRetiro = importeActRecRetiro;
	}

	/**
	 * @return the importeCvPatron
	 */
	public Long getImporteCvPatron() {
		return importeCvPatron;
	}

	/**
	 * @param importeCvPatron the importeCvPatron to set
	 */
	public void setImporteCvPatron(Long importeCvPatron) {
		this.importeCvPatron = importeCvPatron;
	}

	/**
	 * @return the importeCvTrabajador
	 */
	public Long getImporteCvTrabajador() {
		return importeCvTrabajador;
	}

	/**
	 * @param importeCvTrabajador the importeCvTrabajador to set
	 */
	public void setImporteCvTrabajador(Long importeCvTrabajador) {
		this.importeCvTrabajador = importeCvTrabajador;
	}

	/**
	 * @return the importeArCv
	 */
	public Long getImporteArCv() {
		return importeArCv;
	}

	/**
	 * @param importeArCv the importeArCv to set
	 */
	public void setImporteArCv(Long importeArCv) {
		this.importeArCv = importeArCv;
	}

	/**
	 * @return the importeAportaVoluntarias
	 */
	public Long getImporteAportaVoluntarias() {
		return importeAportaVoluntarias;
	}

	/**
	 * @param importeAportaVoluntarias the importeAportaVoluntarias to set
	 */
	public void setImporteAportaVoluntarias(Long importeAportaVoluntarias) {
		this.importeAportaVoluntarias = importeAportaVoluntarias;
	}

	/**
	 * @return the importeComplRetiro
	 */
	public Long getImporteComplRetiro() {
		return importeComplRetiro;
	}

	/**
	 * @param importeComplRetiro the importeComplRetiro to set
	 */
	public void setImporteComplRetiro(Long importeComplRetiro) {
		this.importeComplRetiro = importeComplRetiro;
	}

	/**
	 * @return the importeViviendaPatronal
	 */
	public Long getImporteViviendaPatronal() {
		return importeViviendaPatronal;
	}

	/**
	 * @param importeViviendaPatronal the importeViviendaPatronal to set
	 */
	public void setImporteViviendaPatronal(Long importeViviendaPatronal) {
		this.importeViviendaPatronal = importeViviendaPatronal;
	}

	/**
	 * @return the importeViviendaAr
	 */
	public Long getImporteViviendaAr() {
		return importeViviendaAr;
	}

	/**
	 * @param importeViviendaAr the importeViviendaAr to set
	 */
	public void setImporteViviendaAr(Long importeViviendaAr) {
		this.importeViviendaAr = importeViviendaAr;
	}

	/**
	 * @return the importeCuotaSocial
	 */
	public Long getImporteCuotaSocial() {
		return importeCuotaSocial;
	}

	/**
	 * @param importeCuotaSocial the importeCuotaSocial to set
	 */
	public void setImporteCuotaSocial(Long importeCuotaSocial) {
		this.importeCuotaSocial = importeCuotaSocial;
	}

	/**
	 * @return the importeAportaEstatal
	 */
	public Long getImporteAportaEstatal() {
		return importeAportaEstatal;
	}

	/**
	 * @param importeAportaEstatal the importeAportaEstatal to set
	 */
	public void setImporteAportaEstatal(Long importeAportaEstatal) {
		this.importeAportaEstatal = importeAportaEstatal;
	}

	/**
	 * @return the importeAportaEspecial
	 */
	public Long getImporteAportaEspecial() {
		return importeAportaEspecial;
	}

	/**
	 * @param importeAportaEspecial the importeAportaEspecial to set
	 */
	public void setImporteAportaEspecial(Long importeAportaEspecial) {
		this.importeAportaEspecial = importeAportaEspecial;
	}

	/**
	 * @return the cveCuentaTesofe
	 */
	public String getCveCuentaTesofe() {
		return cveCuentaTesofe;
	}

	/**
	 * @param cveCuentaTesofe the cveCuentaTesofe to set
	 */
	public void setCveCuentaTesofe(String cveCuentaTesofe) {
		this.cveCuentaTesofe = cveCuentaTesofe;
	}

	/**
	 * @return the dispersionTesofe
	 */
	public Date getDispersionTesofe() {
		return dispersionTesofe;
	}

	/**
	 * @param dispersionTesofe the dispersionTesofe to set
	 */
	public void setDispersionTesofe(Date dispersionTesofe) {
		this.dispersionTesofe = dispersionTesofe;
	}

	/**
	 * @return the aforeDispersionRcv
	 */
	public String getAforeDispersionRcv() {
		return aforeDispersionRcv;
	}

	/**
	 * @param aforeDispersionRcv the aforeDispersionRcv to set
	 */
	public void setAforeDispersionRcv(String aforeDispersionRcv) {
		this.aforeDispersionRcv = aforeDispersionRcv;
	}

	/**
	 * @return the aforeDispersionTesofe
	 */
	public String getAforeDispersionTesofe() {
		return aforeDispersionTesofe;
	}

	/**
	 * @param aforeDispersionTesofe the aforeDispersionTesofe to set
	 */
	public void setAforeDispersionTesofe(String aforeDispersionTesofe) {
		this.aforeDispersionTesofe = aforeDispersionTesofe;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
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
	 * @return the nuActivo
	 */
	public Integer getNuActivo() {
		return nuActivo;
	}

	/**
	 * @param nuActivo the nuActivo to set
	 */
	public void setNuActivo(Integer nuActivo) {
		this.nuActivo = nuActivo;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroHistoricoAportacion [nss=");
		builder.append(nss);
		builder.append(", cveEntidadReguladora=");
		builder.append(cveEntidadReguladora);
		builder.append(", fechaValor=");
		builder.append(fechaValor);
		builder.append(", nssPatron=");
		builder.append(nssPatron);
		builder.append(", periodoPago=");
		builder.append(periodoPago);
		builder.append(", folioPago=");
		builder.append(folioPago);
		builder.append(", fechaDispersionRCV=");
		builder.append(fechaDispersionRCV);
		builder.append(", fechaPago=");
		builder.append(fechaPago);
		builder.append(", fechaValorInst=");
		builder.append(fechaValorInst);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nombreImss=");
		builder.append(nombreImss);
		builder.append(", folioSolicitud=");
		builder.append(folioSolicitud);
		builder.append(", salarioIntegrado=");
		builder.append(salarioIntegrado);
		builder.append(", rfcPatronal=");
		builder.append(rfcPatronal);
		builder.append(", diasCotizadosBim=");
		builder.append(diasCotizadosBim);
		builder.append(", diasIncapacidadBim=");
		builder.append(diasIncapacidadBim);
		builder.append(", diasAusentismoBIM=");
		builder.append(diasAusentismoBIM);
		builder.append(", importeRetiro=");
		builder.append(importeRetiro);
		builder.append(", importeActRecRetiro=");
		builder.append(importeActRecRetiro);
		builder.append(", importeCvPatron=");
		builder.append(importeCvPatron);
		builder.append(", importeCvTrabajador=");
		builder.append(importeCvTrabajador);
		builder.append(", importeArCv=");
		builder.append(importeArCv);
		builder.append(", importeAportaVoluntarias=");
		builder.append(importeAportaVoluntarias);
		builder.append(", importeComplRetiro=");
		builder.append(importeComplRetiro);
		builder.append(", importeViviendaPatronal=");
		builder.append(importeViviendaPatronal);
		builder.append(", importeViviendaAr=");
		builder.append(importeViviendaAr);
		builder.append(", importeCuotaSocial=");
		builder.append(importeCuotaSocial);
		builder.append(", importeAportaEstatal=");
		builder.append(importeAportaEstatal);
		builder.append(", importeAportaEspecial=");
		builder.append(importeAportaEspecial);
		builder.append(", cveCuentaTesofe=");
		builder.append(cveCuentaTesofe);
		builder.append(", dispersionTesofe=");
		builder.append(dispersionTesofe);
		builder.append(", aforeDispersionRcv=");
		builder.append(aforeDispersionRcv);
		builder.append(", aforeDispersionTesofe=");
		builder.append(aforeDispersionTesofe);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append("]");
		return builder.toString();
	}
}