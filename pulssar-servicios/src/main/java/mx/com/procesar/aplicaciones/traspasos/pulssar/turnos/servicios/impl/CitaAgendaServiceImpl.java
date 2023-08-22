package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_HORA_MIN_SEG;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DISPONIBILIDAD_TURNO_ESTATUS_CITA_CON_CUS;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoValidaCitaEsar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaNotificacionCita;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService;

/**
 * <p>
 * Implementa los servicios para la consulta  de las <b>Citas Agendadas</b>.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Service
public class CitaAgendaServiceImpl implements CitaAgendaService {
	
	/**
	 * Logger para el servicio para la <b>Administración de Turnos</b>. 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(CitaAgendaServiceImpl.class);
	
	/**
	 * Url Servicio Expuesto de servicio de Citas
	 */
	@Value("${url.citas.notificaciones}")
	private String urlServicioCita;
	
	/**
	 * Cliente Servicio Rest
	 */
	@Autowired
	private RestTemplate servicioRest;
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	/**
	 * Url del servicio expuesto para los datos del codigo cita
	 */
	@Value("${url.consultar.codigo.cita}")
	private String urlServicioCodigoCita;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CitaNotificacion> obtenerDatosCita(String idSucursal) {
		
		CitaNotificacion cita = new CitaNotificacion();
		cita.setIdentificadorSucursal(idSucursal);
		StringBuilder url = new StringBuilder(urlServicioCita).append("consultarListaCitas");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CitaNotificacion> entity = new HttpEntity<>(cita, headers);
		LOG.error("\nLog-obtenerDatosCita:: url: {}, cita: {}",url, cita);
		HttpEntity<RespuestaNotificacionCita> respuestaCita = servicioRest.exchange(url.toString(), HttpMethod.POST, entity, RespuestaNotificacionCita.class);
		
		JsonUtilsImpl<CitaNotificacion> json = new JsonUtilsImpl<>();
		List<CitaNotificacion> lstCitaRespuesta = json.parseListObjectToListPojo((List<CitaNotificacion>) respuestaCita.getBody().getListaRespuesta(), CitaNotificacion.class);
		LOG.error("Log-Los datos de la respuesta son: {}",lstCitaRespuesta);
		return lstCitaRespuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DisponibilidadTurno> obtenerDatosCitaDisponibilidad(String idSucursal) {
		
		List<CitaNotificacion> notificaciones = obtenerDatosCita(idSucursal);
		
		return Lists.newArrayList(Collections2.transform(notificaciones, new Function<CitaNotificacion, DisponibilidadTurno>() {

			@Override
			public DisponibilidadTurno apply(CitaNotificacion notificacion) {
				
				final Date diaCita = notificacion.getFechaInicio();
				final String horaCitaAgendada = fechaUtils.convertirFechaACadena(diaCita, FORMATO_HORA_MIN_SEG);
				
				DisponibilidadTurno disponibilidadTurno = new DisponibilidadTurno();
				disponibilidadTurno.setCurp(notificacion.getCurp());
				disponibilidadTurno.setHoraCita(horaCitaAgendada);
				disponibilidadTurno.setClaveEstatus(DISPONIBILIDAD_TURNO_ESTATUS_CITA_CON_CUS);
				
				return disponibilidadTurno;
			}
		}));
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService#obtenerDatosCodigoCita()
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 11, 2019
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CodigoValidaCitaEsar> obtenerDatosCodigoCita(String curp, Integer estado) {

		StringBuilder url = new StringBuilder(urlServicioCodigoCita).append(curp);
			url.append(TurnoConstants.CARACTER_DIAGONAL).append(estado);
			LOG.error("Log- la url para obtener los datos de codigo citas es: {}", url);
			List<CodigoValidaCitaEsar> respuestaCita = servicioRest.getForObject(url.toString(), List.class);
			LOG.error("Log-Los datos de la Consulta de codigo cita son: {}", respuestaCita);
			JsonUtilsImpl<CodigoValidaCitaEsar> json = new JsonUtilsImpl<>();
			List<CodigoValidaCitaEsar> lstCitaRespuesta = json.parseListObjectToListPojo((List<CodigoValidaCitaEsar>) respuestaCita, CodigoValidaCitaEsar.class);
			
		return lstCitaRespuesta;
	}

}
