package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_HORA_MINUTOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_HORA_MIN_SEG;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.RELACION_COLOR_DISPONIBILIDAD;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.RELACION_COLOR_REGISTRO_DISPONIBILIDAD;
import static org.apache.commons.lang3.StringUtils.trim;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Turno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TurnoEstatus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TurnoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.DisponibilidadTurnoService;

/**
 * Implementa los servicios para la <b>Disponibilidad de Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Service
public class DisponibilidadTurnoServiceImpl implements DisponibilidadTurnoService {
	
	/**
	 * Logger para el controlador <b>Administración de Filas y Citas - Citibanamex</b> 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DisponibilidadTurnoServiceImpl.class);
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Servicio para las operaciones cocn la Cita Agendada.
	 */
	@Autowired
	private CitaAgendaService citaAgendaService;
	
	/**
	 * Repositorio para las operaciones sobre <b>Administración de Turnos</b>.
	 */
	@Autowired
	private TurnoRepository turnoRepository;
	/**
	 * inyeccion de cadena utileria
	 */
	@Autowired
	private CadenasUtils cadenaUtils;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Respuesta obtenerDiponilidad(String sucursal) {
		
		// Valida los datos Requeridos.
		String sucursalLocal = checkNotNull(emptyToNull(sucursal), "El parametro sucursal es requerido");
		
		Respuesta respuesta = new Respuesta();
			
		// Obtner los turnos por citas agendadas.
		final List<DisponibilidadTurno> disponibilidadTurnoAgendado = citaAgendaService
				.obtenerDatosCitaDisponibilidad(sucursalLocal);
		sucursalLocal = cadenaUtils.armarAforeSucursalInvert(sucursalLocal, null, false);
		
		// Se obtienen los turnos registrados con folio atención asignado.
		final List<Turno> turnos = consultarTurnos(sucursalLocal);
		final List<DisponibilidadTurno> disponibilidadTurnoRegistrada = contruirRespuestaTurno(turnos);
		
		List<DisponibilidadTurno> disponibilidadTurnoUnificada = unificarDisponibilidadTurnos(
				disponibilidadTurnoAgendado, disponibilidadTurnoRegistrada);
		
		List<DisponibilidadTurno> disponibilidadTurnoOrdenada = odernarDisponibilidadTurnos(
				disponibilidadTurnoUnificada);
		
		List<DisponibilidadTurno> disponibilidadTurno = asignarMetaInformacionRespuestaTurno(disponibilidadTurnoOrdenada);
		
		LOG.debug("Turnos encontrados: {}", disponibilidadTurno.size());
		respuesta.setObjetoRespuesta(disponibilidadTurno);
		
		return respuesta;
	}
	
	/**
	 * Consulta los turnos registrados en la entidad PSER_TR_TURNO
	 * 
	 * @param sucursal Numero de Sucursal.
	 * 
	 * @return Regresa los Turnos.
	 * 
	 *  @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private List<Turno> consultarTurnos(String sucursal) {
		
		checkNotNull(sucursal, "La sucursal es un parametro requerido");
		
		Calendar hoy = GregorianCalendar.getInstance();
		Date diaConHoraInicial = fechaUtils.actualizarHoraInicio(hoy.getTime());
		
		List<Turno> turnos = turnoRepository.buscarUltimoTurnoRegistrado(sucursal, diaConHoraInicial);
		
		LOG.info("Disponibilidad turnos - Turnos registrados");
		
		return turnos; 
	}
	
	/**
	 * Construye la respuesta para el turno.
	 * 
	 * @param turnos Turnos encontrados en BBDD.
	 * @return Regirsa una listade {@link DisponibilidadTurno}
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private List<DisponibilidadTurno> contruirRespuestaTurno(List<Turno> turnos) {
		
		return Lists.newArrayList(Collections2.transform(turnos, new Function<Turno, DisponibilidadTurno>() {
			
			@Override
			public DisponibilidadTurno apply(Turno turno) {
				
				final TurnoEstatus estatus = turno.getClaveEstatus();
				final String claveEstatus = estatus.getId();
				
				final Date diaRegistro = turno.getFechaRegistro();
				final String horaRegistro = fechaUtils.convertirFechaACadena(diaRegistro, FORMATO_HORA_MIN_SEG);
				
				DisponibilidadTurno disponibilidadTurno = new DisponibilidadTurno();
				disponibilidadTurno.setCurp(turno.getCurp());
				disponibilidadTurno.setFolioServicio(turno.getFolioServicio());
				disponibilidadTurno.setHoraCita(horaRegistro);
				disponibilidadTurno.setClaveEstatus(claveEstatus);
				
				return disponibilidadTurno;
			}
		}));
	}
	
	/**
	 * Unicica las Disponibilidades para los turnos tomando tanto los agndados
	 * como los registrados.
	 * 
	 * @param disponibilidadTurnoAgendado Disponibilidad de Turnos Agendados.
	 * @param disponibilidadTurnoRegistrado Disponibilidad de Turnos Registrados.
	 * 
	 * @return Una lista de {@link DisponibilidadTurno} de turnos unificados.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private List<DisponibilidadTurno> unificarDisponibilidadTurnos(
			final List<DisponibilidadTurno> disponibilidadTurnoAgendado,
			final List<DisponibilidadTurno> disponibilidadTurnoRegistrado) {
		
		List<DisponibilidadTurno> disponibilidadTurnoUnificada = Lists.newArrayList();
		List<String> curpsEnDisponibilidadTurnoRegistrados = obtenerCurpsEnDisponibilidadTurnoRegistrados(
				disponibilidadTurnoRegistrado);
		
		for(DisponibilidadTurno agendada: disponibilidadTurnoAgendado) {
			
			// Aqui es necesario quitar los turnos agendados que se encuentre con un 
			// turno asignado en el portal. Ésto con el fin no duplicar las citas.
			final String curpTunoAgendado = trim(agendada.getCurp());
			if(!curpsEnDisponibilidadTurnoRegistrados.contains(curpTunoAgendado)) {
				
				disponibilidadTurnoUnificada.add(agendada);
			}
		}
		
		// Añadimos los turnos registrados en el portal
		disponibilidadTurnoUnificada.addAll(disponibilidadTurnoRegistrado);

		return disponibilidadTurnoUnificada;
	}
	
	/**
	 * Obtiene un listado de Curps contenidas en La disponibilidad de Turno
	 * registrados.
	 * 
	 * @param disponibilidadTurnoRegistrado Disponibilidad de Turnos Registrados.
	 * @return Una lista de Curps asociados al Turno registrado.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * 
	 */
	private List<String> obtenerCurpsEnDisponibilidadTurnoRegistrados(
			final List<DisponibilidadTurno> disponibilidadTurnoRegistrado) {

		return Lists
				.newArrayList(Collections2.transform(disponibilidadTurnoRegistrado, new Function<DisponibilidadTurno, String>() {

					@Override
					public String apply(DisponibilidadTurno turno) {
						return trim(turno.getCurp());
					}
				}));
	}
	
	/**
	 * Ordenar las disponibilidad de turno por la hora de la cita.
	 * 
	 * @param disponibilidadTurno Diponibilida de turnos a ordenar.
	 * 
	 * @return Una lista de {@link DisponibilidadTurno} ordenada.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private List<DisponibilidadTurno> odernarDisponibilidadTurnos(final List<DisponibilidadTurno> disponibilidadTurno) {

		List<DisponibilidadTurno> disponibilidadTurnosOrdenado = new ArrayList<>(disponibilidadTurno);

		Collections.sort(disponibilidadTurnosOrdenado, new Ordering<DisponibilidadTurno>() {

			@Override
			public int compare(DisponibilidadTurno turnoA, DisponibilidadTurno turnoB) {
				
				Date horaCitaA = fechaUtils.convertirCadenaAFecha(turnoA.getHoraCita(), FORMATO_HORA_MIN_SEG);
				Date horaCitaB = fechaUtils.convertirCadenaAFecha(turnoB.getHoraCita(), FORMATO_HORA_MIN_SEG);
				
				return horaCitaA.compareTo(horaCitaB);
			}
		});

		return disponibilidadTurnosOrdenado;
	}
	
	/**
	 * Construye la respuesta para el turno.
	 * 
	 * @param turnos Turnos encontrados en BBDD.
	 * @return Regirsa una listade {@link DisponibilidadTurno}
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private List<DisponibilidadTurno> asignarMetaInformacionRespuestaTurno(List<DisponibilidadTurno> turnos) {
		
		return Lists.newArrayList(Collections2.transform(turnos, new Function<DisponibilidadTurno, DisponibilidadTurno>() {
			
			private int contador = 1;

			@Override
			public DisponibilidadTurno apply(DisponibilidadTurno turno) {
				
				DisponibilidadTurno disponibilidadTurno = new DisponibilidadTurno();
				
				final String claveEstatus = turno.getClaveEstatus();
				
				disponibilidadTurno.setCurp(turno.getCurp());
				disponibilidadTurno.setClaveEstatus(claveEstatus);
				disponibilidadTurno.setFolioServicio(turno.getFolioServicio());
				Date fechaHora = fechaUtils.convertirCadenaAFecha(turno.getHoraCita(), FORMATO_HORA_MINUTOS);
				disponibilidadTurno.setHoraCita(fechaUtils.convertirFechaACadena(fechaHora, FORMATO_HORA_MINUTOS));
				
				// Esta disponibilidad se encuentra en un mapa dentro de constantes.
				// Se coloca dentro de una lista de constantes para evitar if por cada
				// una de las condiciones.
				disponibilidadTurno.setColorCss(RELACION_COLOR_DISPONIBILIDAD.get(claveEstatus));
				disponibilidadTurno.setColorRegistroCss(RELACION_COLOR_REGISTRO_DISPONIBILIDAD.get(contador++ % 2));
				
				return disponibilidadTurno;
			}
		}));
	}
	
}
