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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisponibilidadTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaNotificacionCita;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.DisponibilidadTurnoService;

/**
 * Clase de prueba para el servicio que obtiene la disponibilidad de Turnos.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public class DisponibilidadTurnoServiceTestCase extends BaseTestCase {
	
	/**
	 * Servicio a probar
	 */
	@Autowired
	private DisponibilidadTurnoService disponibilidadTurnoService;
	
	/**
	 * Cliente rest adminisrdo por mockito.
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * Permite probar el happy path para obtener la disponibilidad.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * @throws ParseException 
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testObtenerDiponilidad() throws ParseException {
		
		// Parametros requeridos por el servicio.
		final String sucursalParam = "552-1000000000000001";
		
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
		
		Respuesta respuesta = disponibilidadTurnoService.obtenerDiponilidad(sucursalParam );
		
		assertNotNull(respuesta);
		assertNotNull(respuesta.getObjetoRespuesta());
		assertEquals(3, ((List<DisponibilidadTurno>)respuesta.getObjetoRespuesta()).size());

	}
	

	
	
	
	

}
