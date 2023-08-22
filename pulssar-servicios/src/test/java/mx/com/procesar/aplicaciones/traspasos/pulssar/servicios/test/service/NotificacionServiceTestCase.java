package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NotificacionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTiempoTramiteMod;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Test para notificacion service
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class NotificacionServiceTestCase {

	@Autowired
	@InjectMocks
	private NotificacionService notificacionService = new NotificacionServiceImpl();
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	@Mock
	private RestTemplate restTemplate; 
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Mock
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test notificar tiempo tramite
	 */
	@Test
	public void testNotificarTiempoTramite() {
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"idProcesar\":2648,\"estatusBiometrico\":\"2\",\"estatusIdentificacion\":\"1\",\"curpNueva\":\"CEMA680702HSPDRN00\",\"flujoValidacion\":\"1B\",\"movimiento\":\"1\",\"curpSolicitante\":\"CEMA680702HSPDRN00\",\"tipoSolicitante\":\"01\"}" , HttpStatus.ACCEPTED);	
		NotificacionTiempoTramiteMod notificacionTiempo = new NotificacionTiempoTramiteMod();
		Mockito.when(utileriaCadenas.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		notificacionService.notificarTiempoTramite(notificacionTiempo);
		
		
		Mockito.when(utileriaCadenas.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		notificacionService.notificarTiempoTramite(notificacionTiempo);
	}

}
