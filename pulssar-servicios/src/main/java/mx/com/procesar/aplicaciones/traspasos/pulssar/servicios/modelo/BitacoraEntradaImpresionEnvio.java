package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Bitacora Entrada Impresion Envio
 * @author jmordone
 *
 */
public class BitacoraEntradaImpresionEnvio implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8742654698137055727L;

	/**
	 * Usuario Modificador
	 */
	private Long idSeguimiento;
	
	/**
	 * Usuario Modificador
	 */
	private String tipoSolicitud;

	/**
	 * id Solicitud
	 */
	private String indicativo;
	
	/**
	 * Curp
	 */
	private String resultadoOperacion;

	/**
	 * id Solicitud
	 */
	private String diagnostico;
	
	/**
	 * id Solicitud
	 */
	private String usuarioModificador;

	/**
	 * Fc control
	 */
	private Date fcControl;
	
	/**
	 * id Solicitud
	 */
	private String tramiteSeguimiento;
	
	/**
	 * id Solicitud
	 */
	private String claveAgente;

	/**
	 * @return the idSeguimiento
	 */
	public Long getIdSeguimiento() {
		return idSeguimiento;
	}

	/**
	 * @param idSeguimiento the idSeguimiento to set
	 */
	public void setIdSeguimiento(Long idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	/**
	 * @return the tipoSolicitud
	 */
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	/**
	 * @param tipoSolicitud the tipoSolicitud to set
	 */
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	/**
	 * @return the indicativo
	 */
	public String getIndicativo() {
		return indicativo;
	}

	/**
	 * @param indicativo the indicativo to set
	 */
	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
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
	 * @return the tramiteSeguimiento
	 */
	public String getTramiteSeguimiento() {
		return tramiteSeguimiento;
	}

	/**
	 * @param tramiteSeguimiento the tramiteSeguimiento to set
	 */
	public void setTramiteSeguimiento(String tramiteSeguimiento) {
		this.tramiteSeguimiento = tramiteSeguimiento;
	}

	
	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}

	/**
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitacoraEntradaImpresionEnvio [idSeguimiento=");
		builder.append(idSeguimiento);
		builder.append(", tipoSolicitud=");
		builder.append(tipoSolicitud);
		builder.append(", indicativo=");
		builder.append(indicativo);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", tramiteSeguimiento=");
		builder.append(tramiteSeguimiento);
		builder.append(", claveAgente=");
		builder.append(claveAgente);
		builder.append("]");
		return builder.toString();
	}

	


	
}
