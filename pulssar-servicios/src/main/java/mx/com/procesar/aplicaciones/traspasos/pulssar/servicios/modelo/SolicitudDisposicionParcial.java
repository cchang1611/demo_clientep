package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase que contiene los atributos de Entrada del servicio solicitud
 * disposicion parcial
 * 
 * @author OJBALBUE
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitudDisposicionParcial implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * atributo folio del cliente
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String folioCliente;

    /**
     * atributo folioDeTramiteProcesar
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String folioTramiteProcesar;

    /**
     * atributo nss
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nss;

    /**
     * atributo nombreTrabajador
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nombreTrabajador;

    /**
     * atributo apellidoPaterno
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String apellidoPaterno;

    /**
     * atributo apellidoMaterno
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String apellidoMaterno;

    /**
     * atributo tipoDeRetiro
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tipoRetiro;

    /**
     * atributo tipoDePrestacion
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tipoPrestacion;

    /**
     * atributo numeroResolucion
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String numeroResolucion;

    /**
     * atributo claveAdminActual
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String claveAdminActual;

    /**
     * atributo curpTrabajador
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String curpTrabajador;

    /**
     * atributo selloTrabajador
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String selloTrabajador;

    /**
     * atributo curpAgenteServicio
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String curpAgenteServicio;

    /**
     * atributo curpFuncionarioAutorizado
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String curpFuncionarioAutorizado;

    /**
     * atributo selloFuncionarioAutorizado
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String selloFuncionarioAutorizado;
    /**
     * atributo idSolicitante
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String idSolicitante;

    /**
     * atributo curpSolicitante
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String curpSolicitante;
	
	/**
	 * indicador Origen Tramite
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String indicadorOrigenTramite;

    /**
     * @return the folioCliente
     */
    public String getFolioCliente() {
	return folioCliente;
    }

    /**
     * @param folioCliente
     *            the folioCliente to set
     */
    public void setFolioCliente(String folioCliente) {
	this.folioCliente = folioCliente;
    }

    /**
     * @return the folioDeTramiteProcesar
     */
    public String getFolioTramiteProcesar() {
	return folioTramiteProcesar;
    }

    /**
     * @param folioDeTramiteProcesar
     *            the folioDeTramiteProcesar to set
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
     * @param nss
     *            the nss to set
     */
    public void setNss(String nss) {
	this.nss = nss;
    }

    /**
     * @return the nombreTrabajador
     */
    public String getNombreTrabajador() {
	return nombreTrabajador;
    }

    /**
     * @param nombreTrabajador
     *            the nombreTrabajador to set
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
     * @param apellidoPaterno
     *            the apellidoPaterno to set
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
     * @param apellidoMaterno
     *            the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
	this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the tipoDeRetiro
     */
    public String getTipoRetiro() {
	return tipoRetiro;
    }

    /**
     * @param tipoDeRetiro
     *            the tipoDeRetiro to set
     */
    public void setTipoRetiro(String tipoRetiro) {
	this.tipoRetiro = tipoRetiro;
    }

    /**
     * @return the tipoDePrestacion
     */
    public String getTipoPrestacion() {
	return tipoPrestacion;
    }

    /**
     * @param tipoDePrestacion
     *            the tipoDePrestacion to set
     */
    public void setTipoPrestacion(String tipoPrestacion) {
	this.tipoPrestacion = tipoPrestacion;
    }

    /**
     * @return the numeroResolucion
     */
    public String getNumeroResolucion() {
	return numeroResolucion;
    }

    /**
     * @param numeroResolucion
     *            the numeroResolucion to set
     */
    public void setNumeroResolucion(String numeroResolucion) {
	this.numeroResolucion = numeroResolucion;
    }

    /**
     * @return the claveAdminActual
     */
    public String getClaveAdminActual() {
	return claveAdminActual;
    }

    /**
     * @param claveAdminActual
     *            the claveAdminActual to set
     */
    public void setClaveAdminActual(String claveAdminActual) {
	this.claveAdminActual = claveAdminActual;
    }

    /**
     * @return the curpTrabajador
     */
    public String getCurpTrabajador() {
	return curpTrabajador;
    }

    /**
     * @param curpTrabajador
     *            the curpTrabajador to set
     */
    public void setCurpTrabajador(String curpTrabajador) {
	this.curpTrabajador = curpTrabajador;
    }

    /**
     * @return the selloTrabajador
     */
    public String getSelloTrabajador() {
	return selloTrabajador;
    }

    /**
     * @param selloTrabajador
     *            the selloTrabajador to set
     */
    public void setSelloTrabajador(String selloTrabajador) {
	this.selloTrabajador = selloTrabajador;
    }

    /**
     * @return the curpAgenteServicio
     */
    public String getCurpAgenteServicio() {
	return curpAgenteServicio;
    }

    /**
     * @param curpAgenteServicio
     *            the curpAgenteServicio to set
     */
    public void setCurpAgenteServicio(String curpAgenteServicio) {
	this.curpAgenteServicio = curpAgenteServicio;
    }

    /**
     * @return the curpFuncionarioAutorizado
     */
    public String getCurpFuncionarioAutorizado() {
	return curpFuncionarioAutorizado;
    }

    /**
     * @param curpFuncionarioAutorizado
     *            the curpFuncionarioAutorizado to set
     */
    public void setCurpFuncionarioAutorizado(String curpFuncionarioAutorizado) {
	this.curpFuncionarioAutorizado = curpFuncionarioAutorizado;
    }

    /**
     * @return the selloFuncionarioAutorizado
     */
    public String getSelloFuncionarioAutorizado() {
	return selloFuncionarioAutorizado;
    }

    /**
     * @param selloFuncionarioAutorizado
     *            the selloFuncionarioAutorizado to set
     */
    public void setSelloFuncionarioAutorizado(String selloFuncionarioAutorizado) {
	this.selloFuncionarioAutorizado = selloFuncionarioAutorizado;
    }
    /**
     * @return the idSolicitante
     */
    public String getIdSolicitante() {
	return idSolicitante;
    }

    /**
     * @param idSolicitante
     *            the idSolicitante to set
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
     * @param curpSolicitante
     *            the curpSolicitante to set
     */
    public void setCurpSolicitante(String curpSolicitante) {
	this.curpSolicitante = curpSolicitante;
    }
    /**
	 * @return el atributo indicadorOrigenTramite
	 */
	public String getIndicadorOrigenTramite() {
		return indicadorOrigenTramite;
	}

	/**
	 * @param indicadorOrigenTramite parametro indicadorOrigenTramite a actualizar
	 */
	public void setIndicadorOrigenTramite(String indicadorOrigenTramite) {
		this.indicadorOrigenTramite = indicadorOrigenTramite;
	}

	/*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("SolicitudDisposicionParcial [folioCliente=");
	builder.append(folioCliente);
	builder.append(", folioTramiteProcesar=");
	builder.append(folioTramiteProcesar);
	builder.append(", nss=");
	builder.append(nss);
	builder.append(", nombreTrabajador=");
	builder.append(nombreTrabajador);
	builder.append(", apellidoPaterno=");
	builder.append(apellidoPaterno);
	builder.append(", apellidoMaterno=");
	builder.append(apellidoMaterno);
	builder.append(", tipoRetiro=");
	builder.append(tipoRetiro);
	builder.append(", tipoPrestacion=");
	builder.append(tipoPrestacion);
	builder.append(", numeroResolucion=");
	builder.append(numeroResolucion);
	builder.append(", claveAdminActual=");
	builder.append(claveAdminActual);
	builder.append(", curpTrabajador=");
	builder.append(curpTrabajador);
	builder.append(", selloTrabajador=");
	builder.append(selloTrabajador);
	builder.append(", curpAgenteServicio=");
	builder.append(curpAgenteServicio);
	builder.append(", curpFuncionarioAutorizado=");
	builder.append(curpFuncionarioAutorizado);
	builder.append(", selloFuncionarioAutorizado=");
	builder.append(selloFuncionarioAutorizado);
	builder.append(", idSolicitante=");
	builder.append(idSolicitante);
	builder.append(", curpSolicitante=");
	builder.append(curpSolicitante);
	builder.append(", indicadorOrigenTramite=");
	builder.append(indicadorOrigenTramite);
	builder.append("]");
	return builder.toString();
    }

}
