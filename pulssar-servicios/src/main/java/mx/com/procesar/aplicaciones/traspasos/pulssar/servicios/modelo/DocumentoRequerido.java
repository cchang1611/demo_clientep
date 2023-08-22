package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Entidad que representa un documento requerido
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 15/05/2019
 */


public class DocumentoRequerido implements Serializable {

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -7443455654193838160L;

	/**
	 * claveTipoProceso
	 */
	private String claveTipoProceso;

	/**
	 * claveTipoDocDigital
	 */
	private String claveTipoDocDigital;

	/**
	 * biomTrSolicitud
	 */
	private TipoDocumentoDigital tipoDocumentoDigital;

	/**
	 * numeroObligatorio
	 */
	private Long numeroObligatorio;

	/**
	 * numeroMesesVigencia
	 */
	private Long numeroMesesVigencia;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * control del estatus agente
	 */
	private Date fechaControl;

	/**
	 * @return el atributo claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}

	/**
	 * @param claveTipoProceso
	 *            parametro claveTipoProceso a actualizar
	 */
	public void setClaveTipoProceso(String claveTipoProceso) {
		this.claveTipoProceso = claveTipoProceso;
	}

	/**
	 * @return el atributo claveTipoDocDigital
	 */
	public String getClaveTipoDocDigital() {
		return claveTipoDocDigital;
	}

	/**
	 * @param claveTipoDocDigital
	 *            parametro claveTipoDocDigital a actualizar
	 */
	public void setClaveTipoDocDigital(String claveTipoDocDigital) {
		this.claveTipoDocDigital = claveTipoDocDigital;
	}

	/**
	 * @return el atributo tipoDocumentoDigital
	 */
	public TipoDocumentoDigital getTipoDocumentoDigital() {
		return tipoDocumentoDigital;
	}

	/**
	 * @param tipoDocumentoDigital
	 *            parametro tipoDocumentoDigital a actualizar
	 */
	public void setTipoDocumentoDigital(TipoDocumentoDigital tipoDocumentoDigital) {
		this.tipoDocumentoDigital = tipoDocumentoDigital;
	}

	/**
	 * @return el atributo numeroObligatorio
	 */
	public Long getNumeroObligatorio() {
		return numeroObligatorio;
	}

	/**
	 * @param numeroObligatorio
	 *            parametro numeroObligatorio a actualizar
	 */
	public void setNumeroObligatorio(Long numeroObligatorio) {
		this.numeroObligatorio = numeroObligatorio;
	}

	/**
	 * @return el atributo numeroMesesVigencia
	 */
	public Long getNumeroMesesVigencia() {
		return numeroMesesVigencia;
	}

	/**
	 * @param numeroMesesVigencia
	 *            parametro numeroMesesVigencia a actualizar
	 */
	public void setNumeroMesesVigencia(Long numeroMesesVigencia) {
		this.numeroMesesVigencia = numeroMesesVigencia;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
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
		builder.append("DocumentoRequerido [claveTipoProceso=");
		builder.append(claveTipoProceso);
		builder.append(", claveTipoDocDigital=");
		builder.append(claveTipoDocDigital);
		builder.append(", tipoDocumentoDigital=");
		builder.append(tipoDocumentoDigital);
		builder.append(", numeroObligatorio=");
		builder.append(numeroObligatorio);
		builder.append(", numeroMesesVigencia=");
		builder.append(numeroMesesVigencia);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}

}
