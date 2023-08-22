package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAdministracionTurno;

/**
 * Construye una instancia de {@link RespuestaAdministracionTurno} para la <b>Administración
 * de Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public class RespuestaAdministracionTurnoBuilder implements Serializable {

	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = 5628549713282186786L;

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
	 * Constructor de la clase.
	 */
	public RespuestaAdministracionTurnoBuilder() {
		super();

		turnosConCita = new ArrayList<>();
		turnosSinCita = new ArrayList<>();
	}

	/**
	 * Construye una instancia de {@link RespuestaAdministracionTurno}.
	 * 
	 * @return Un objeto {@link RespuestaAdministracionTurno}.
	 */
	public RespuestaAdministracionTurno build() {
		return new RespuestaAdministracionTurno(this);
	}

	/**
	 * Minutos de espera para clientes con cita.
	 */
	public RespuestaAdministracionTurnoBuilder limiteEnMinutosDeTurnoConCita(String limiteEnMinutosDeTurnoConCita) {

		this.limiteEnMinutosDeTurnoConCita = limiteEnMinutosDeTurnoConCita;
		return this;
	}

	/**
	 * Minutos de espera para clientes sin cita.
	 */
	public RespuestaAdministracionTurnoBuilder limiteEnMinutosDeTurnoSinCita(String limiteEnMinutosDeTurnoSinCita) {

		this.limiteEnMinutosDeTurnoSinCita = limiteEnMinutosDeTurnoSinCita;
		return this;
	}
	
	/**
	 * Minutos de espera para clientes con cita.
	 */
	public RespuestaAdministracionTurnoBuilder indicadorEnMinutosPreavisoTurnoConCita(String indicadorEnMinutosPreavisoTurnoConCita) {

		this.indicadorEnMinutosPreavisoTurnoConCita = indicadorEnMinutosPreavisoTurnoConCita;
		return this;
	}

	/**
	 * Minutos de espera para clientes sin cita.
	 */
	public RespuestaAdministracionTurnoBuilder indicadorEnMinutosPreavisoTurnoSinCita(String indicadorEnMinutosPreavisoTurnoSinCita) {

		this.indicadorEnMinutosPreavisoTurnoSinCita = indicadorEnMinutosPreavisoTurnoSinCita;
		return this;
	}

	/**
	 * Turnos de clientes con cita.
	 */
	public RespuestaAdministracionTurnoBuilder turnosConCita(List<TurnoRegistrado> turnosConCita) {

		this.turnosConCita.addAll(turnosConCita);
		return this;
	}

	/**
	 * Turnos de clientes sin cita.
	 */
	public RespuestaAdministracionTurnoBuilder turnosSinCita(List<TurnoRegistrado> turnosSinCita) {

		this.turnosSinCita.addAll(turnosSinCita);
		return this;
	}

	/**
	 * @return the minutosDeEsperaConCita
	 */
	public String getLimiteEnMinutosDeTurnoConCita() {
		return limiteEnMinutosDeTurnoConCita;
	}

	/**
	 * @return the minutosDeEsperaSinCita
	 */
	public String getLimiteEnMinutosDeTurnoSinCita() {
		return limiteEnMinutosDeTurnoSinCita;
	}

	/**
	 * @return the turnosConCita
	 */
	public List<TurnoRegistrado> getTurnosConCita() {
		return turnosConCita;
	}

	/**
	 * @return the turnosSinCita
	 */
	public List<TurnoRegistrado> getTurnosSinCita() {
		return turnosSinCita;
	}
	
	/**
	 * @return the minutosDeOlguraEnEsperaConCita
	 */
	public String getIndicadorEnMinutosPreavisoTurnoConCita() {
		return indicadorEnMinutosPreavisoTurnoConCita;
	}

	/**
	 * @return the minutosDeOlguraEnEsperaSinCita
	 */
	public String getIndicadorEnMinutosPreavisoTurnoSinCita() {
		return indicadorEnMinutosPreavisoTurnoSinCita;
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
