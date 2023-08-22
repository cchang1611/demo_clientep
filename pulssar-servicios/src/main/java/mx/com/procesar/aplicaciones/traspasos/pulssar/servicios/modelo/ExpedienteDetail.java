package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author ANOSORIO
 *
 */
public class ExpedienteDetail implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -6908193729920646764L;
	
	/**
	 * ID_EXPEDIENTE
	 */
	private Long idExpediente;
	/**
	 * CH_FECHA_OPERACION
	 */
	private String chFechaOperacion;
	/**
	 * CH_FOLIO_OPERACION
	 */
	private String chFolioOperacion;
	/**
	 * CH_USUARIO_MODIFICADOR
	 */
	private String chUsuarioModificador;
	/**
	 * CURP
	 */
	private String curp;

	/**
	 * identificador de procesar afore
	 */
	private Afore afore;

	/**
	 * CV_ESTATUS_EXPE
	 */
	private String cvEstatusExpe;
	/**
	 * CV_LUGAR_FIRMA
	 */
	private String cvLugarFirma;
	/**
	 * CV_TIPO_PROCESO
	 */
	private String cvTipoProceso;
	/**
	 * FC_CONTROL
	 */
	private Date fcControl;
	/**
	 * FC_LUGAR_FIRMA
	 */
	private Date fcLugarFirma;
	/**
	 * ID_ENTIDAD_FEDERATIVA
	 */
	private BigDecimal idEntidadFederativa;
	/**
	 * ID_PROCESAR
	 */
	private BigDecimal idProcesar;
	/**
	 * ID_PROCESAR_AGENTE
	 */
	private BigDecimal idProcesarAgente;
	/**
	 * ID_SOLICITUD
	 */
	private BigDecimal idSolicitud;
	/**
	 * NU_REGISTRADO_POR
	 */
	private BigDecimal nuRegistradoPor;
	/**
	 * NU_TIENE_ARCHIVO_VOZ
	 */
	private BigDecimal nuTieneArchivoVoz;
	/**
	 * NU_TIENE_DATOS_COMPLEMENT
	 */
	private BigDecimal nuTieneDatosComplement;
	/**
	 * NU_TIENE_EXCEPCION
	 */
	private BigDecimal nuTieneExcepcion;
	/**
	 * NU_TIENE_IMAGENES
	 */
	private BigDecimal nuTieneImagenes;

	/**
	 * @return the idExpediente
	 */
	public Long getIdExpediente() {
		return idExpediente;
	}

	/**
	 * @param idExpediente
	 *            the idExpediente to set
	 */
	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	/**
	 * @return the chFechaOperacion
	 */
	public String getChFechaOperacion() {
		return chFechaOperacion;
	}

	/**
	 * @param chFechaOperacion
	 *            the chFechaOperacion to set
	 */
	public void setChFechaOperacion(String chFechaOperacion) {
		this.chFechaOperacion = chFechaOperacion;
	}

	/**
	 * @return the chFolioOperacion
	 */
	public String getChFolioOperacion() {
		return chFolioOperacion;
	}

	/**
	 * @param chFolioOperacion
	 *            the chFolioOperacion to set
	 */
	public void setChFolioOperacion(String chFolioOperacion) {
		this.chFolioOperacion = chFolioOperacion;
	}

	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador
	 *            the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the cvEstatusExpe
	 */
	public String getCvEstatusExpe() {
		return cvEstatusExpe;
	}

	/**
	 * @param cvEstatusExpe
	 *            the cvEstatusExpe to set
	 */
	public void setCvEstatusExpe(String cvEstatusExpe) {
		this.cvEstatusExpe = cvEstatusExpe;
	}

	/**
	 * @return the cvLugarFirma
	 */
	public String getCvLugarFirma() {
		return cvLugarFirma;
	}

	/**
	 * @param cvLugarFirma
	 *            the cvLugarFirma to set
	 */
	public void setCvLugarFirma(String cvLugarFirma) {
		this.cvLugarFirma = cvLugarFirma;
	}

	/**
	 * @return the cvTipoProceso
	 */
	public String getCvTipoProceso() {
		return cvTipoProceso;
	}

	/**
	 * @param cvTipoProceso
	 *            the cvTipoProceso to set
	 */
	public void setCvTipoProceso(String cvTipoProceso) {
		this.cvTipoProceso = cvTipoProceso;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl
	 *            the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return the fcLugarFirma
	 */
	public Date getFcLugarFirma() {
		return fcLugarFirma;
	}

	/**
	 * @param fcLugarFirma
	 *            the fcLugarFirma to set
	 */
	public void setFcLugarFirma(Date fcLugarFirma) {
		this.fcLugarFirma = fcLugarFirma;
	}

	/**
	 * @return the idEntidadFederativa
	 */
	public BigDecimal getIdEntidadFederativa() {
		return idEntidadFederativa;
	}

	/**
	 * @param idEntidadFederativa
	 *            the idEntidadFederativa to set
	 */
	public void setIdEntidadFederativa(BigDecimal idEntidadFederativa) {
		this.idEntidadFederativa = idEntidadFederativa;
	}

	/**
	 * @return the idProcesar
	 */
	public BigDecimal getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar
	 *            the idProcesar to set
	 */
	public void setIdProcesar(BigDecimal idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the idProcesarAgente
	 */
	public BigDecimal getIdProcesarAgente() {
		return idProcesarAgente;
	}

	/**
	 * @param idProcesarAgente
	 *            the idProcesarAgente to set
	 */
	public void setIdProcesarAgente(BigDecimal idProcesarAgente) {
		this.idProcesarAgente = idProcesarAgente;
	}

	/**
	 * @return the idSolicitud
	 */
	public BigDecimal getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud
	 *            the idSolicitud to set
	 */
	public void setIdSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	/**
	 * @return the nuRegistradoPor
	 */
	public BigDecimal getNuRegistradoPor() {
		return nuRegistradoPor;
	}

	/**
	 * @param nuRegistradoPor
	 *            the nuRegistradoPor to set
	 */
	public void setNuRegistradoPor(BigDecimal nuRegistradoPor) {
		this.nuRegistradoPor = nuRegistradoPor;
	}

	/**
	 * @return the nuTieneArchivoVoz
	 */
	public BigDecimal getNuTieneArchivoVoz() {
		return nuTieneArchivoVoz;
	}

	/**
	 * @param nuTieneArchivoVoz
	 *            the nuTieneArchivoVoz to set
	 */
	public void setNuTieneArchivoVoz(BigDecimal nuTieneArchivoVoz) {
		this.nuTieneArchivoVoz = nuTieneArchivoVoz;
	}

	/**
	 * @return the nuTieneDatosComplement
	 */
	public BigDecimal getNuTieneDatosComplement() {
		return nuTieneDatosComplement;
	}

	/**
	 * @param nuTieneDatosComplement
	 *            the nuTieneDatosComplement to set
	 */
	public void setNuTieneDatosComplement(BigDecimal nuTieneDatosComplement) {
		this.nuTieneDatosComplement = nuTieneDatosComplement;
	}

	/**
	 * @return the nuTieneExcepcion
	 */
	public BigDecimal getNuTieneExcepcion() {
		return nuTieneExcepcion;
	}

	/**
	 * @param nuTieneExcepcion
	 *            the nuTieneExcepcion to set
	 */
	public void setNuTieneExcepcion(BigDecimal nuTieneExcepcion) {
		this.nuTieneExcepcion = nuTieneExcepcion;
	}

	/**
	 * @return the nuTieneImagenes
	 */
	public BigDecimal getNuTieneImagenes() {
		return nuTieneImagenes;
	}

	/**
	 * @param nuTieneImagenes
	 *            the nuTieneImagenes to set
	 */
	public void setNuTieneImagenes(BigDecimal nuTieneImagenes) {
		this.nuTieneImagenes = nuTieneImagenes;
	}

	/**
	 * @return el atributo afore
	 */
	public Afore getAfore() {
		return afore;
	}

	/**
	 * @param afore
	 *            parametro afore a actualizar
	 */
	public void setAfore(Afore afore) {
		this.afore = afore;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpedienteDetail [idExpediente=");
		builder.append(idExpediente);
		builder.append(", chFechaOperacion=");
		builder.append(chFechaOperacion);
		builder.append(", chFolioOperacion=");
		builder.append(chFolioOperacion);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", cvEstatusExpe=");
		builder.append(cvEstatusExpe);
		builder.append(", cvLugarFirma=");
		builder.append(cvLugarFirma);
		builder.append(", cvTipoProceso=");
		builder.append(cvTipoProceso);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", fcLugarFirma=");
		builder.append(fcLugarFirma);
		builder.append(", idEntidadFederativa=");
		builder.append(idEntidadFederativa);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idProcesarAgente=");
		builder.append(idProcesarAgente);
		builder.append(", idSolicitud=");
		builder.append(idSolicitud);
		builder.append(", nuRegistradoPor=");
		builder.append(nuRegistradoPor);
		builder.append(", nuTieneArchivoVoz=");
		builder.append(nuTieneArchivoVoz);
		builder.append(", nuTieneDatosComplement=");
		builder.append(nuTieneDatosComplement);
		builder.append(", nuTieneExcepcion=");
		builder.append(nuTieneExcepcion);
		builder.append(", nuTieneImagenes=");
		builder.append(nuTieneImagenes);
		builder.append("]");
		return builder.toString();
	}
	

}
