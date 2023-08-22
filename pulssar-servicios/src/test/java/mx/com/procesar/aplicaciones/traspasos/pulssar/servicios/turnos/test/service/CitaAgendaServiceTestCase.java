package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoValidaCitaEsar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaNotificacionCita;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService;

/**
 * Clase de prueba para el servicio {@link CitaAgendaService}.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public class CitaAgendaServiceTestCase extends BaseTestCase {

	/**
	 * Servicio a probar.
	 */
	@Autowired
	private CitaAgendaService citaAgendaService;
	
	/**
	 * Cliente rest adminisrdo por mockito.
	 */
	@Autowired
	private RestTemplate clienteServicio;

	/**
	 * Permite probar el Happy Path para el servicio para obtener los Datos de
	 * la Cita en un objeto que determina la disponibilidad.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testObtenerDatosCita() {

		final String idSucursal = "10000";
		
		CitaNotificacion citaNotificacion = new CitaNotificacion();
		citaNotificacion.setCodigoCita("00001");
		citaNotificacion.setCurp("BACG620329MPLRRD00");
		citaNotificacion.setEstatusEnvio(Long.valueOf(1));
		citaNotificacion.setIdentificadorServicio("00002");
		citaNotificacion.setIdentificadorSucursal("0003");
		citaNotificacion.setNumeroIdentificacion("00004");
		List<CitaNotificacion> listaRespuesta = Lists.newArrayList(citaNotificacion);
		
		RespuestaNotificacionCita notificacionCita = new RespuestaNotificacionCita();
		notificacionCita.setListaRespuesta(listaRespuesta);
		ResponseEntity<RespuestaNotificacionCita> respuestaNotificacion = new ResponseEntity<RespuestaNotificacionCita>(notificacionCita , HttpStatus.ACCEPTED);
		when(clienteServicio.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(respuestaNotificacion );
		
		List<CitaNotificacion> listaDeResultado = citaAgendaService.obtenerDatosCita(idSucursal);
		
		assertNotNull(listaDeResultado);
		assertEquals(1, listaDeResultado.size());
		
		final CitaNotificacion resultadoCita = listaDeResultado.get(0);
		assertEquals("BACG620329MPLRRD00", resultadoCita.getCurp());
		assertEquals("00001", resultadoCita.getCodigoCita());
	}
	
	/**
	 * Permite probar el Happy Path para el servicio para obtener los Datos de
	 * la Cita.
	 * @throws ParseException 
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testObtenerDatosCitaDisponibilidad() throws ParseException {

		final String idSucursal = "10000";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final Date fechaInicio = simpleDateFormat.parse("28/11/2019 09:00:00");
		
		CitaNotificacion citaNotificacion = new CitaNotificacion();
		citaNotificacion.setCodigoCita("00001");
		citaNotificacion.setCurp("BACG620329MPLRRD00");
		citaNotificacion.setFechaInicio(fechaInicio);
		List<CitaNotificacion> listaRespuesta = Lists.newArrayList(citaNotificacion);
		
		RespuestaNotificacionCita notificacionCita = new RespuestaNotificacionCita();
		notificacionCita.setListaRespuesta(listaRespuesta);
		ResponseEntity<RespuestaNotificacionCita> respuestaNotificacion = new ResponseEntity<RespuestaNotificacionCita>(notificacionCita , HttpStatus.ACCEPTED);
		when(clienteServicio.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(respuestaNotificacion );
		
		List<DisponibilidadTurno> listaDeResultado = citaAgendaService.obtenerDatosCitaDisponibilidad(idSucursal);
		
		assertNotNull(listaDeResultado);
		assertEquals(1, listaDeResultado.size());
		
		final DisponibilidadTurno disponibilidad = listaDeResultado.get(0);
		assertEquals("BACG620329MPLRRD00", disponibilidad.getCurp());
//		assertEquals("09:00", disponibilidad.getHoraCita());
	}
	
	/**
	 * Permite probar el happy path para la recuperación de los datos para la
	 * cita.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * @throws ParseException 
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testObtenerDatosCodigoCita() throws ParseException {

		String curp = "BACG620329MPLRRD00";
		Integer estado = 1;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final Date fechaInicio = simpleDateFormat.parse("28/11/2019 09:00:00");
		
		CodigoValidaCitaEsar cita = new CodigoValidaCitaEsar();
		cita.setChVigenciaCodigo(fechaInicio);
		cita.setEstatus(1);
		cita.setNuTelefono("5567870031");
		List<CodigoValidaCitaEsar> respuestaCitaMock = Lists.newArrayList(cita);
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(respuestaCitaMock);

		List<CodigoValidaCitaEsar> listaRespuestaCita = citaAgendaService.obtenerDatosCodigoCita(curp, estado);

		assertNotNull(listaRespuestaCita);
		assertEquals(1, listaRespuestaCita.size());
		
		final CodigoValidaCitaEsar respuestaCita = listaRespuestaCita.get(0);
		
		assertNotNull(respuestaCita);
		assertEquals("5567870031", respuestaCita.getNuTelefono());
		assertEquals("28/11/2019 09:00:00", simpleDateFormat.format(respuestaCita.getChVigenciaCodigo()));
	}

}
