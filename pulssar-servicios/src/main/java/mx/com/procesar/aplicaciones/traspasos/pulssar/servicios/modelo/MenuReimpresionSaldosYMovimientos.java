package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Menu Reimpresion
 * @author jmordone
 *
 */
public class MenuReimpresionSaldosYMovimientos implements Serializable {

	/**
	 * consentimientoEnrolamiento
	 */
	private static final long serialVersionUID = -562734698828259161L;

	/**
	 * consentimientoEnrolamiento
	 */
	private Integer consentimientoEnrolamiento;
	
	/**
	 * solicitudModificacionDatos
	 */
	private Integer solicitudModificacionDatos;
	
	/**
	 * permanencia
	 */
	private Integer permanencia;
	
	/**
	 * saldosMovimientos
	 */
	private Integer saldosMovimientos;
	
	/**
	 * @return the consentimientoEnrolamiento
	 */
	public Integer getConsentimientoEnrolamiento() {
		return consentimientoEnrolamiento;
	}
	
	/**
	 * @param consentimientoEnrolamiento the consentimientoEnrolamiento to set
	 */
	public void setConsentimientoEnrolamiento(Integer consentimientoEnrolamiento) {
		this.consentimientoEnrolamiento = consentimientoEnrolamiento;
	}

	/**
	 * @return the solicitudModificacionDatos
	 */
	public Integer getSolicitudModificacionDatos() {
		return solicitudModificacionDatos;
	}

	/**
	 * @param solicitudModificacionDatos the solicitudModificacionDatos to set
	 */
	public void setSolicitudModificacionDatos(Integer solicitudModificacionDatos) {
		this.solicitudModificacionDatos = solicitudModificacionDatos;
	}

	/**
	 * @return the permanencia
	 */
	public Integer getPermanencia() {
		return permanencia;
	}

	/**
	 * @param permanencia the permanencia to set
	 */
	public void setPermanencia(Integer permanencia) {
		this.permanencia = permanencia;
	}

	/**
	 * @return the saldosMovimientos
	 */
	public Integer getSaldosMovimientos() {
		return saldosMovimientos;
	}

	/**
	 * @param saldosMovimientos the saldosMovimientos to set
	 */
	public void setSaldosMovimientos(Integer saldosMovimientos) {
		this.saldosMovimientos = saldosMovimientos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuReimpresion [consentimientoEnrolamiento=");
		builder.append(consentimientoEnrolamiento);
		builder.append(", solicitudModificacionDatos=");
		builder.append(solicitudModificacionDatos);
		builder.append(", permanencia=");
		builder.append(permanencia);
		builder.append(", saldosMovimientos=");
		builder.append(saldosMovimientos);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
