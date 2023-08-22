package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * entidad Rtpseg
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jan 10, 2020
 */
public class Rtpseg implements Serializable {
	private static final long serialVersionUID = 1L;

	private RtpsegPK id;

	private String claveAfore;

	private String codRes;

	private String diagnosticoProc;

	private String nss;

	private String programa;

	private String tipoSolicitud;

	private String usuario;

	private Date eventoRetiro;

	private Date pagoReintegro;

	private BigDecimal maxSemReint;

	private BigDecimal montoReintRes;

	private BigDecimal montoReintegrar;

	private BigDecimal semanasReintegrar;

	private String numeroResolucion;

	/**
	 * @return el atributo id
	 */
	public RtpsegPK getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(RtpsegPK id) {
		this.id = id;
	}

	/**
	 * @return el atributo claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore parametro claveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return el atributo codRes
	 */
	public String getCodRes() {
		return codRes;
	}

	/**
	 * @param codRes parametro codRes a actualizar
	 */
	public void setCodRes(String codRes) {
		this.codRes = codRes;
	}

	/**
	 * @return el atributo diagnosticoProc
	 */
	public String getDiagnosticoProc() {
		return diagnosticoProc;
	}

	/**
	 * @param diagnosticoProc parametro diagnosticoProc a actualizar
	 */
	public void setDiagnosticoProc(String diagnosticoProc) {
		this.diagnosticoProc = diagnosticoProc;
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
	 * @return el atributo programa
	 */
	public String getPrograma() {
		return programa;
	}

	/**
	 * @param programa parametro programa a actualizar
	 */
	public void setPrograma(String programa) {
		this.programa = programa;
	}

	/**
	 * @return el atributo tipoSolicitud
	 */
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	/**
	 * @param tipoSolicitud parametro tipoSolicitud a actualizar
	 */
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	/**
	 * @return el atributo usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario parametro usuario a actualizar
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el atributo eventoRetiro
	 */
	public Date getEventoRetiro() {
		return eventoRetiro;
	}

	/**
	 * @param eventoRetiro parametro eventoRetiro a actualizar
	 */
	public void setEventoRetiro(Date eventoRetiro) {
		this.eventoRetiro = eventoRetiro;
	}

	/**
	 * @return el atributo pagoReintegro
	 */
	public Date getPagoReintegro() {
		return pagoReintegro;
	}

	/**
	 * @param pagoReintegro parametro pagoReintegro a actualizar
	 */
	public void setPagoReintegro(Date pagoReintegro) {
		this.pagoReintegro = pagoReintegro;
	}

	/**
	 * @return el atributo maxSemReint
	 */
	public BigDecimal getMaxSemReint() {
		return maxSemReint;
	}

	/**
	 * @param maxSemReint parametro maxSemReint a actualizar
	 */
	public void setMaxSemReint(BigDecimal maxSemReint) {
		this.maxSemReint = maxSemReint;
	}

	/**
	 * @return el atributo montoReintRes
	 */
	public BigDecimal getMontoReintRes() {
		return montoReintRes;
	}

	/**
	 * @param montoReintRes parametro montoReintRes a actualizar
	 */
	public void setMontoReintRes(BigDecimal montoReintRes) {
		this.montoReintRes = montoReintRes;
	}

	/**
	 * @return el atributo montoReintegrar
	 */
	public BigDecimal getMontoReintegrar() {
		return montoReintegrar;
	}

	/**
	 * @param montoReintegrar parametro montoReintegrar a actualizar
	 */
	public void setMontoReintegrar(BigDecimal montoReintegrar) {
		this.montoReintegrar = montoReintegrar;
	}

	/**
	 * @return el atributo semanasReintegrar
	 */
	public BigDecimal getSemanasReintegrar() {
		return semanasReintegrar;
	}

	/**
	 * @param semanasReintegrar parametro semanasReintegrar a actualizar
	 */
	public void setSemanasReintegrar(BigDecimal semanasReintegrar) {
		this.semanasReintegrar = semanasReintegrar;
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
		builder.append("Rtpseg [id=");
		builder.append(id);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", codRes=");
		builder.append(codRes);
		builder.append(", diagnosticoProc=");
		builder.append(diagnosticoProc);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", programa=");
		builder.append(programa);
		builder.append(", tipoSolicitud=");
		builder.append(tipoSolicitud);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", eventoRetiro=");
		builder.append(eventoRetiro);
		builder.append(", pagoReintegro=");
		builder.append(pagoReintegro);
		builder.append(", maxSemReint=");
		builder.append(maxSemReint);
		builder.append(", montoReintRes=");
		builder.append(montoReintRes);
		builder.append(", montoReintegrar=");
		builder.append(montoReintegrar);
		builder.append(", semanasReintegrar=");
		builder.append(semanasReintegrar);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append("]");
		return builder.toString();
	}

	

}