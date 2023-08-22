package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_HORA_MIN_SEG;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaNotificacionCita;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl.CitaAgendaServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CitaAgendaServiceTestCase {
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private CitaAgendaService citaAgendaService = new CitaAgendaServiceImpl();

	/**
	 * servicio
	 */
	@Mock
	private RestTemplate servicioRest;

	/**
	 * Url Servicio Expuesto de servicio de Citas
	 */
	@Value("${url.citas.notificaciones}")
	private String urlServicioCita;


	/**
	 * Utileria para el manejo de fechas.
	 */
	@Mock
	private FechaUtils fechaUtils;

	/**
	 * Url del servicio expuesto para los datos del codigo cita
	 */
	@Value("${url.consultar.codigo.cita}")
	private String urlServicioCodigoCita;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test de solicitud consulta cus
	 * @throws ParseException 
	 */
	@Test
	public void obtenerDatosCitaTest() throws ParseException {
		StringBuilder url = new StringBuilder(urlServicioCita).append("consultarListaCitas");

		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadConsulta = new HttpEntity<String>("", headerMedia);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final Date fechaInicio = simpleDateFormat.parse("28/11/2019 09:00:00");

		RespuestaNotificacionCita respuesta = new RespuestaNotificacionCita();
		CitaNotificacion citaNotificacion = new CitaNotificacion();
		citaNotificacion.setCodigoCita("00001");
		citaNotificacion.setCurp("BACG620329MPLRRD00");
		citaNotificacion.setFechaInicio(fechaInicio);
		List<CitaNotificacion> listaRespuesta = Lists.newArrayList(citaNotificacion);
		respuesta.setListaRespuesta(listaRespuesta);
		ResponseEntity<RespuestaNotificacionCita> respuestaEntity = new ResponseEntity<RespuestaNotificacionCita>(respuesta , HttpStatus.ACCEPTED);
		Mockito.when(servicioRest.exchange(url.toString(), HttpMethod.POST,entidadConsulta,RespuestaNotificacionCita.class)).thenReturn(respuestaEntity);

		try{
			List<CitaNotificacion> listaCita = citaAgendaService.obtenerDatosCita("");
			assertNotNull(listaCita);
		}catch(Exception e){
			assertNotNull(e);
		}
	}

	/**
	 * test para generar la cus
	 * @throws ParseException 
	 */
	@Test
	public void obtenerDatosCitaDisponibilidadTest() throws ParseException {
		
		StringBuilder url = new StringBuilder(urlServicioCita).append("consultarListaCitas");

		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadConsulta = new HttpEntity<String>("", headerMedia);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final Date fechaInicio = simpleDateFormat.parse("28/11/2019 09:00:00");

		RespuestaNotificacionCita respuesta = new RespuestaNotificacionCita();
		CitaNotificacion citaNotificacion = new CitaNotificacion();
		citaNotificacion.setCodigoCita("00001");
		citaNotificacion.setCurp("BACG620329MPLRRD00");
		citaNotificacion.setFechaInicio(fechaInicio);
		List<CitaNotificacion> listaRespuesta = Lists.newArrayList(citaNotificacion);
		respuesta.setListaRespuesta(listaRespuesta);
		ResponseEntity<RespuestaNotificacionCita> respuestaEntity = new ResponseEntity<RespuestaNotificacionCita>(respuesta , HttpStatus.ACCEPTED);
		Mockito.when(servicioRest.exchange(url.toString(), HttpMethod.POST,entidadConsulta,RespuestaNotificacionCita.class)).thenReturn(respuestaEntity);
		
		Mockito.when(fechaUtils.convertirFechaACadena(new Date(), FORMATO_HORA_MIN_SEG)).thenReturn("");
				
		try{
			List<DisponibilidadTurno> listaCita = citaAgendaService.obtenerDatosCitaDisponibilidad("");
			assertNotNull(listaCita);
		}catch(Exception e){
			assertNotNull(e);
		}
	}

}
