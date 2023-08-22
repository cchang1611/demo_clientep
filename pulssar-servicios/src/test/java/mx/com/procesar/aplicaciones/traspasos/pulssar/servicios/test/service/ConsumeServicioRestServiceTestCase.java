/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsumeServicioNipServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RestConsumerServiceImpl;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Verifica: ConsumeServicioNipServiceImpl
 * @author MALOPEZT
 * @since 2022/02/04
 */
public class ConsumeServicioRestServiceTestCase {

	/** Servicio a testear */
	@Mock
	private RestConsumerServiceImpl restConsumerService;
	
	/** Mock de consumidor de servicios */
	@Mock
	private RestTemplate restTemplate;
	
	/** Escenario rosa */
	@Test
	public void test_EscenarioRosa_enviar() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String url = "URL_TEST";
		String strJson = "{'a':'b'}";
		String idServicio = "123";
		String idCliente = "456";
		String idEbusiness = "789";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);
		ReflectionTestUtils.setField(consumeRestSService, "idServicio", idServicio);
		ReflectionTestUtils.setField(consumeRestSService, "idCliente", idCliente);
		ReflectionTestUtils.setField(consumeRestSService, "idEbusiness", idEbusiness);

		String body =  "{'c':'d'}";
		HttpStatus estatus = HttpStatus.ACCEPTED;
		ResponseEntity<String> respuestaServicio =  new ResponseEntity<String>(body, estatus);
		Mockito.when(restConsumerService.consumirServicio(Mockito.anyString(), (HttpEntity<String>)Mockito.any())).
			thenReturn(respuestaServicio);
		
		// Ejecución 1. Valida flujo público de envío
		String salida = consumeRestSService.enviar(endPoint, strJson);
		
		//Validación 
		assertTrue(body.equals(salida));
	}
	
	/** Escenario rosa */
	@Test
	public void test_Excepcion_RestTemplate_enviar() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String url = "URL_TEST";
		String strJson = "{'a':'b'}";
		String idServicio = "123";
		String idCliente = "456";
		String idEbusiness = "789";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);
		ReflectionTestUtils.setField(consumeRestSService, "idServicio", idServicio);
		ReflectionTestUtils.setField(consumeRestSService, "idCliente", idCliente);
		ReflectionTestUtils.setField(consumeRestSService, "idEbusiness", idEbusiness);

		Mockito.doThrow(SQLException.class).
			when(restConsumerService).consumirServicio(Mockito.anyString(), (HttpEntity<String>)Mockito.any());
		
		// Ejecución 1. Valida flujo público de envío
		try {
			// Ejecución
			consumeRestSService.enviar(endPoint, strJson);
			fail("Se esperaba una excepción");
		} catch (BusinessException be) {
			//Validación
			assertTrue(be.getMessage().equals("Solicitud de NIP no procesada"));
		}
		
	}
	
	/** Escenario rosa - Cabeceras*/
	@Test
	public void test_EscenarioRosa_cabeceras() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String strJson = "{'a':'b'}";
		String idServicio = "123";
		String idCliente = "456";
		String idEbusiness = "789";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);
		ReflectionTestUtils.setField(consumeRestSService, "idServicio", idServicio);
		ReflectionTestUtils.setField(consumeRestSService, "idCliente", idCliente);
		ReflectionTestUtils.setField(consumeRestSService, "idEbusiness", idEbusiness);
		
		// Ejecución 1. Valida generacion de cabecera
		HttpEntity<String> entidadHTTP = 
		ReflectionTestUtils.invokeMethod(consumeRestSService, "obtenEntidadHttp", strJson);
		
		String contentTypeFields = entidadHTTP.getHeaders().keySet().toString(); 
		assertTrue(contentTypeFields.contains("idServicio"));
		assertTrue(contentTypeFields.contains("idCliente"));
		assertTrue(contentTypeFields.contains("idEbusiness"));
	}
	
	/** Escenario rosa */
	@Test
	public void test_EscenarioRosa_enviarToServicioInterno() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String url = "URL_TEST";
		String strJson = "{'a':'b'}";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);

		String body =  "{'c':'d'}";
		HttpStatus estatus = HttpStatus.ACCEPTED;
		ResponseEntity<String> respuestaServicio =  new ResponseEntity<String>(body, estatus);
		Mockito.when(restConsumerService.consumirServicio(Mockito.anyString(), (HttpEntity<String>)Mockito.any())).
			thenReturn(respuestaServicio);
		
		// Ejecución 1. Valida flujo público de envío
		String salida = consumeRestSService.enviarToServicioInterno(endPoint, strJson);
		
		//Validación 
		assertTrue(body.equals(salida));
	}
	
	/** Escenario rosa */
	@Test
	public void test_Excepcion_RestTemplate_enviarToServicioInterno() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String url = "URL_TEST";
		String strJson = "{'a':'b'}";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);

		Mockito.doThrow(SQLException.class).
			when(restConsumerService).consumirServicio(Mockito.anyString(), (HttpEntity<String>)Mockito.any());
		
		// Ejecución 1. Valida flujo público de envío
		try {
			// Ejecución
			consumeRestSService.enviarToServicioInterno(endPoint, strJson);
			fail("Se esperaba una excepción");
		} catch (BusinessException be) {
			//Validación
			assertTrue(be.getMessage().equals("Consumo de Servicio no completado"));
		}
		
	}
	
	/** Escenario rosa */
	@Test
	public void test_EscenarioRosa_consultarToServicioInterno() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String strJson = "{'a':'b'}";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);

		String body =  "{'c':'d'}";
		HttpStatus estatus = HttpStatus.ACCEPTED;
		ResponseEntity<String> respuestaServicio =  new ResponseEntity<String>(body, estatus);
		Mockito.when(restConsumerService.consumirServicioConsulta(Mockito.anyString(), (HttpEntity<String>)Mockito.any())).
			thenReturn(respuestaServicio);
		
		// Ejecución 1. Valida flujo público de envío
		String salida = consumeRestSService.consultarToServicioInterno(endPoint, strJson);
		
		//Validación 
		assertTrue(body.equals(salida));
	}
	
	/** Escenario rosa */
	@Test
	public void test_Excepcion_RestTemplate_consultarToServicioInterno() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String strJson = "{'a':'b'}";
		String endPoint = "http://test/generaNip";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);

		Mockito.doThrow(SQLException.class).
			when(restConsumerService).consumirServicioConsulta(Mockito.anyString(), (HttpEntity<String>)Mockito.any());
		
		// Ejecución 1. Valida flujo público de envío
		try {
			// Ejecución
			consumeRestSService.consultarToServicioInterno(endPoint, strJson);
			fail("Se esperaba una excepción");
		} catch (BusinessException be) {
			//Validación
			assertTrue(be.getMessage().equals("Consulta de Servicio no completada"));
		}
		
	}
	
	
	/** Escenario rosa - Cabeceras*/
	@Test
	public void test_EscenarioRosa_Sincabeceras() {
		// Inicio
		restConsumerService = Mockito.mock(RestConsumerServiceImpl.class);
		
		String strJson = "{'a':'b'}";
		String idServicio = "123";
		String idCliente = "456";
		String idEbusiness = "789";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);
		ReflectionTestUtils.setField(consumeRestSService, "idServicio", idServicio);
		ReflectionTestUtils.setField(consumeRestSService, "idCliente", idCliente);
		ReflectionTestUtils.setField(consumeRestSService, "idEbusiness", idEbusiness);
		
		// Ejecución 1. Valida generacion de cabecera
		HttpEntity<String> entidadHTTP = 
		ReflectionTestUtils.invokeMethod(consumeRestSService, "obtenEntidadHttpSinHeaders", strJson);
		
		String contentTypeFields = entidadHTTP.getHeaders().keySet().toString(); 
		assertTrue(!contentTypeFields.contains("idServicio"));
		assertTrue(!contentTypeFields.contains("idCliente"));
		assertTrue(!contentTypeFields.contains("idEbusiness"));
	}
}
