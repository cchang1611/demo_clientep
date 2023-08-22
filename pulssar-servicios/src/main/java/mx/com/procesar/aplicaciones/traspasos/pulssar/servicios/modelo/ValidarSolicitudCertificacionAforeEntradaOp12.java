package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Datos Entrada Op 12
 * @author ANOSORIO
 *
 */
public class ValidarSolicitudCertificacionAforeEntradaOp12 implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 5272414207893873649L;

	/**
	 * folioDeTramiteProcesar
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioTramiteProcesar;
	/**
	 * nss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	/**
	 * curp
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	/**
	 * nombreTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajador;
	/**
	 * apellidoPaterno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apellidoPaterno;
	/**
	 * apellidoMaterno
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String apellidoMaterno;
	/**
	 * tipoDePrestacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tipoPrestacion;
	/**
	 * claveAdminActual
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String claveAdminActual;
	/**
	 * origen
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private BigInteger origen;
	/**
	 * idSolicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idSolicitante;
	/**
	 * curpSolicitante
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpSolicitante;
	/**
	 * selloTrabajador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long selloTrabajador;
	/**
	 * curpAgenteServicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpAgenteServicio;

	/**
	 * Nombre Trabajador Imss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabajadorImss;
	
	/**
	 * Nombre Trabajador Procanase
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreTrabProcanase;
	/**
	 * clave de la operacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String operacion;
	
	/**
	 * folio Operacion IMSS
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioOperacionIMSS;

	/**
	 * @return the folioTramiteProcesar
	 */
	public String getFolioTramiteProcesar() {
		return folioTramiteProcesar;
	}

	/**
	 * @param folioTramiteProcesar the folioTramiteProcesar to set
	 */
	public void setFolioTramiteProcesar(String folioTramiteProcesar) {
		this.folioTramiteProcesar = folioTramiteProcesar;
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
	 * @return the claveAdminActual
	 */
	public String getClaveAdminActual() {
		return claveAdminActual;
	}

	/**
	 * @param claveAdminActual the claveAdminActual to set
	 */
	public void setClaveAdminActual(String claveAdminActual) {
		this.claveAdminActual = claveAdminActual;
	}

	/**
	 * @return the origen
	 */
	public BigInteger getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(BigInteger origen) {
		this.origen = origen;
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
	 * @return the selloTrabajador
	 */
	public Long getSelloTrabajador() {
		return selloTrabajador;
	}

	/**
	 * @param selloTrabajador the selloTrabajador to set
	 */
	public void setSelloTrabajador(Long selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}

	/**
	 * @return the curpAgenteServicio
	 */
	public String getCurpAgenteServicio() {
		return curpAgenteServicio;
	}

	/**
	 * @param curpAgenteServicio the curpAgenteServicio to set
	 */
	public void setCurpAgenteServicio(String curpAgenteServicio) {
		this.curpAgenteServicio = curpAgenteServicio;
	}

	/**
	 * @return the nombreTrabajadorImss
	 */
	public String getNombreTrabajadorImss() {
		return nombreTrabajadorImss;
	}

	/**
	 * @param nombreTrabajadorImss the nombreTrabajadorImss to set
	 */
	public void setNombreTrabajadorImss(String nombreTrabajadorImss) {
		this.nombreTrabajadorImss = nombreTrabajadorImss;
	}

	/**
	 * @return the nombreTrabProcanase
	 */
	public String getNombreTrabProcanase() {
		return nombreTrabProcanase;
	}

	/**
	 * @param nombreTrabProcanase the nombreTrabProcanase to set
	 */
	public void setNombreTrabProcanase(String nombreTrabProcanase) {
		this.nombreTrabProcanase = nombreTrabProcanase;
	}

	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return the folioOperacionIMSS
	 */
	public String getFolioOperacionIMSS() {
		return folioOperacionIMSS;
	}

	/**
	 * @param folioOperacionIMSS the folioOperacionIMSS to set
	 */
	public void setFolioOperacionIMSS(String folioOperacionIMSS) {
		this.folioOperacionIMSS = folioOperacionIMSS;
	}

	/**
	 * Constructor
	 */
	public ValidarSolicitudCertificacionAforeEntradaOp12() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidarSolicitudCertificacionAforeEntradaOp12 [folioTramiteProcesar=");
		builder.append(folioTramiteProcesar);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", claveAdminActual=");
		builder.append(claveAdminActual);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", idSolicitante=");
		builder.append(idSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", curpAgenteServicio=");
		builder.append(curpAgenteServicio);
		builder.append(", nombreTrabajadorImss=");
		builder.append(nombreTrabajadorImss);
		builder.append(", nombreTrabProcanase=");
		builder.append(nombreTrabProcanase);
		builder.append(", operacion=");
		builder.append(operacion);
		builder.append(", folioOperacionIMSS=");
		builder.append(folioOperacionIMSS);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
