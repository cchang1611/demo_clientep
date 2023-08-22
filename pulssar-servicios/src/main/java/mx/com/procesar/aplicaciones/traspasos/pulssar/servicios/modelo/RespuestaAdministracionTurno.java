package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.builder.RespuestaAdministracionTurnoBuilder;

/**
 * <p>
 * Contiene la información la respuesta de turnos registrados <b>Administraión
 * de Turnos</b>.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public class RespuestaAdministracionTurno implements Serializable {

	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = -5531286790717110113L;

	/**
	 * Minutos de espera para clientes con cita.
	 */
	private String limiteEnMinutosDeTurnoConCita;

	/**
	 * Minutos de espera para clientes sin cita.
	 */
	private String limiteEnMinutosDeTurnoSinCita;
	
	/**
	 * Minutos de espera para clientes con cita.
	 */
	private String indicadorEnMinutosPreavisoTurnoConCita;

	/**
	 * Minutos de espera para clientes sin cita.
	 */
	private String indicadorEnMinutosPreavisoTurnoSinCita;

	/**
	 * Turnos de clientes con cita.
	 */
	private List<TurnoRegistrado> turnosConCita;

	/**
	 * Turnos de clientes sin cita.
	 */
	private List<TurnoRegistrado> turnosSinCita;

	/**
	 * Constructor por defeto.
	 */
	public RespuestaAdministracionTurno() {

	}

	/**
	 * Constructor a partir de un builder {@link RespuestaAdministracionTurnoBuilder}.
	 * 
	 * @param builder
	 *            Un bilder {@link RespuestaAdministracionTurnoBuilder}.
	 */
	public RespuestaAdministracionTurno(RespuestaAdministracionTurnoBuilder builder) {
		
		checkNotNull(builder, "El bilder es obligatorio");

		this.limiteEnMinutosDeTurnoConCita = builder.getLimiteEnMinutosDeTurnoConCita();
		this.limiteEnMinutosDeTurnoSinCita = builder.getLimiteEnMinutosDeTurnoSinCita();
		this.turnosConCita = builder.getTurnosConCita();
		this.turnosSinCita = builder.getTurnosSinCita();
		this.indicadorEnMinutosPreavisoTurnoConCita = builder.getIndicadorEnMinutosPreavisoTurnoConCita();
		this.indicadorEnMinutosPreavisoTurnoSinCita = builder.getIndicadorEnMinutosPreavisoTurnoSinCita();
		
	}

	/**
	 * @return the minutosDeEsperaConCita
	 */
	public String getLimiteEnMinutosDeTurnoConCita() {
		return limiteEnMinutosDeTurnoConCita;
	}

	/**
	 * @param limiteEnMinutosDeTurnoConCita
	 *            the minutosDeEsperaConCita to set
	 */
	public void setlimiteEnMinutosDeTurnoConCita(String limiteEnMinutosDeTurnoConCita) {
		this.limiteEnMinutosDeTurnoConCita = limiteEnMinutosDeTurnoConCita;
	}

	/**
	 * @return the minutosDeEsperaSinCita
	 */
	public String getLimiteEnMinutosDeTurnoSinCita() {
		return limiteEnMinutosDeTurnoSinCita;
	}

	/**
	 * @param limiteEnMinutosDeTurnoSinCita
	 *            the minutosDeEsperaSinCita to set
	 */
	public void setLimiteEnMinutosDeTurnoSinCita(String limiteEnMinutosDeTurnoSinCita) {
		this.limiteEnMinutosDeTurnoSinCita = limiteEnMinutosDeTurnoSinCita;
	}

	/**
	 * @return the turnosConCita
	 */
	public List<TurnoRegistrado> getTurnosConCita() {
		return turnosConCita;
	}

	/**
	 * @param turnosConCita
	 *            the turnosConCita to set
	 */
	public void setTurnosConCita(List<TurnoRegistrado> turnosConCita) {
		this.turnosConCita = turnosConCita;
	}

	/**
	 * @return the turnosSinCita
	 */
	public List<TurnoRegistrado> getTurnosSinCita() {
		return turnosSinCita;
	}

	/**
	 * @param turnosSinCita
	 *            the turnosSinCita to set
	 */
	public void setTurnosSinCita(List<TurnoRegistrado> turnosSinCita) {
		this.turnosSinCita = turnosSinCita;
	}
	
	/**
	 * @return the minutosDeOlguraEnEsperaConCita
	 */
	public String getIndicadorEnMinutosPreavisoTurnoConCita() {
		return indicadorEnMinutosPreavisoTurnoConCita;
	}

	/**
	 * @param indicadorEnMinutosPreavisoTurnoConCita the minutosDeOlguraEnEsperaConCita to set
	 */
	public void setIndicadorEnMinutosPreavisoTurnoConCita(String indicadorEnMinutosPreavisoTurnoConCita) {
		this.indicadorEnMinutosPreavisoTurnoConCita = indicadorEnMinutosPreavisoTurnoConCita;
	}

	/**
	 * @return the minutosDeOlguraEnEsperaSinCita
	 */
	public String getIndicadorEnMinutosPreavisoTurnoSinCita() {
		return indicadorEnMinutosPreavisoTurnoSinCita;
	}

	/**
	 * @param indicadorEnMinutosPreavisoTurnoSinCita the minutosDeOlguraEnEsperaSinCita to set
	 */
	public void setIndicadorEnMinutosPreavisoTurnoSinCita(String indicadorEnMinutosPreavisoTurnoSinCita) {
		this.indicadorEnMinutosPreavisoTurnoSinCita = indicadorEnMinutosPreavisoTurnoSinCita;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
