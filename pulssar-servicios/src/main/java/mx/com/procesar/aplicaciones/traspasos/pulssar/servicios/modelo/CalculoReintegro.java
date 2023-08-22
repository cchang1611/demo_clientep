package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * entidad CalculoReintegro
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jan 10, 2020
 */
public class CalculoReintegro implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * idCalculoReintegro
	 */
	private Long idCalculoReintegro;

	/**
	 * afore
	 */
	private String afore;

	/**
	 * numeroResolucion
	 */
	private String numeroResolucion;

	/**
	 * tipoPrestacion
	 */
	private String tipoPrestacion;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * fechaControl
	 */
	private Timestamp fechaControl;

	/**
	 * fechaSolicitud
	 */
	private Timestamp fechaSolicitud;

	/**
	 * idConsultaHistorico
	 */
	private BigDecimal idConsultaHistorico;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * diasCotizacionRecuperados
	 */
	private BigDecimal diasCotizacionRecuperados;

	/**
	 * diasDescontadosRetiro
	 */
	private BigDecimal diasDescontadosRetiro;

	/**
	 * importePesosReintegrar
	 */
	private BigDecimal importePesosReintegrar;

	/**
	 * maxSemanasReintegrar
	 */
	private BigDecimal maxSemanasReintegrar;

	/**
	 * montoMaxReintegrar
	 */
	private BigDecimal montoMaxReintegrar;

	/**
	 * origen
	 */
	private BigDecimal origen;

	/**
	 * semanasCalculadas
	 */
	private BigDecimal semanasCalculadas;

	/**
	 * valorDiaReintegrar
	 */
	private BigDecimal valorDiaReintegrar;


	/**
	 * diagnostico
	 */
	private Diagnostico diagnostico;

	/**
	 * @return el atributo idCalculoReintegro
	 */
	public Long getIdCalculoReintegro() {
		return idCalculoReintegro;
	}

	/**
	 * @param idCalculoReintegro parametro idCalculoReintegro a actualizar
	 */
	public void setIdCalculoReintegro(Long idCalculoReintegro) {
		this.idCalculoReintegro = idCalculoReintegro;
	}

	/**
	 * @return el atributo afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore parametro afore a actualizar
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return el atributo tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion parametro tipoPrestacion a actualizar
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
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
	 * @return el atributo fechaControl
	 */
	public Timestamp getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Timestamp fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo fechaSolicitud
	 */
	public Timestamp getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud parametro fechaSolicitud a actualizar
	 */
	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return el atributo idConsultaHistorico
	 */
	public BigDecimal getIdConsultaHistorico() {
		return idConsultaHistorico;
	}

	/**
	 * @param idConsultaHistorico parametro idConsultaHistorico a actualizar
	 */
	public void setIdConsultaHistorico(BigDecimal idConsultaHistorico) {
		this.idConsultaHistorico = idConsultaHistorico;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo diasCotizacionRecuperados
	 */
	public BigDecimal getDiasCotizacionRecuperados() {
		return diasCotizacionRecuperados;
	}

	/**
	 * @param diasCotizacionRecuperados parametro diasCotizacionRecuperados a actualizar
	 */
	public void setDiasCotizacionRecuperados(BigDecimal diasCotizacionRecuperados) {
		this.diasCotizacionRecuperados = diasCotizacionRecuperados;
	}

	/**
	 * @return el atributo diasDescontadosRetiro
	 */
	public BigDecimal getDiasDescontadosRetiro() {
		return diasDescontadosRetiro;
	}

	/**
	 * @param diasDescontadosRetiro parametro diasDescontadosRetiro a actualizar
	 */
	public void setDiasDescontadosRetiro(BigDecimal diasDescontadosRetiro) {
		this.diasDescontadosRetiro = diasDescontadosRetiro;
	}

	/**
	 * @return el atributo importePesosReintegrar
	 */
	public BigDecimal getImportePesosReintegrar() {
		return importePesosReintegrar;
	}

	/**
	 * @param importePesosReintegrar parametro importePesosReintegrar a actualizar
	 */
	public void setImportePesosReintegrar(BigDecimal importePesosReintegrar) {
		this.importePesosReintegrar = importePesosReintegrar;
	}

	/**
	 * @return el atributo maxSemanasReintegrar
	 */
	public BigDecimal getMaxSemanasReintegrar() {
		return maxSemanasReintegrar;
	}

	/**
	 * @param maxSemanasReintegrar parametro maxSemanasReintegrar a actualizar
	 */
	public void setMaxSemanasReintegrar(BigDecimal maxSemanasReintegrar) {
		this.maxSemanasReintegrar = maxSemanasReintegrar;
	}

	/**
	 * @return el atributo montoMaxReintegrar
	 */
	public BigDecimal getMontoMaxReintegrar() {
		return montoMaxReintegrar;
	}

	/**
	 * @param montoMaxReintegrar parametro montoMaxReintegrar a actualizar
	 */
	public void setMontoMaxReintegrar(BigDecimal montoMaxReintegrar) {
		this.montoMaxReintegrar = montoMaxReintegrar;
	}

	/**
	 * @return el atributo origen
	 */
	public BigDecimal getOrigen() {
		return origen;
	}

	/**
	 * @param origen parametro origen a actualizar
	 */
	public void setOrigen(BigDecimal origen) {
		this.origen = origen;
	}

	/**
	 * @return el atributo semanasCalculadas
	 */
	public BigDecimal getSemanasCalculadas() {
		return semanasCalculadas;
	}

	/**
	 * @param semanasCalculadas parametro semanasCalculadas a actualizar
	 */
	public void setSemanasCalculadas(BigDecimal semanasCalculadas) {
		this.semanasCalculadas = semanasCalculadas;
	}

	/**
	 * @return el atributo valorDiaReintegrar
	 */
	public BigDecimal getValorDiaReintegrar() {
		return valorDiaReintegrar;
	}

	/**
	 * @param valorDiaReintegrar parametro valorDiaReintegrar a actualizar
	 */
	public void setValorDiaReintegrar(BigDecimal valorDiaReintegrar) {
		this.valorDiaReintegrar = valorDiaReintegrar;
	}

	/**
	 * @return el atributo retiTcDiagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param retiTcDiagnostico parametro retiTcDiagnostico a actualizar
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return el atributo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculoReintegro [idCalculoReintegro=");
		builder.append(idCalculoReintegro);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", idConsultaHistorico=");
		builder.append(idConsultaHistorico);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", diasCotizacionRecuperados=");
		builder.append(diasCotizacionRecuperados);
		builder.append(", diasDescontadosRetiro=");
		builder.append(diasDescontadosRetiro);
		builder.append(", importePesosReintegrar=");
		builder.append(importePesosReintegrar);
		builder.append(", maxSemanasReintegrar=");
		builder.append(maxSemanasReintegrar);
		builder.append(", montoMaxReintegrar=");
		builder.append(montoMaxReintegrar);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", semanasCalculadas=");
		builder.append(semanasCalculadas);
		builder.append(", valorDiaReintegrar=");
		builder.append(valorDiaReintegrar);
		builder.append(", retiTcDiagnostico=");
		builder.append(diagnostico);
		builder.append("]");
		return builder.toString();
	}

	
}