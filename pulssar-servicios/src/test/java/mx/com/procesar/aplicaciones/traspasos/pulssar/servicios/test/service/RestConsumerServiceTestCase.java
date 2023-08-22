/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsumeServicioNipServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RestConsumerServiceImpl;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author MALOPEZT
 *
 */
public class RestConsumerServiceTestCase {

	/** Servicio a testear */
	private RestConsumerServiceImpl restConsumerService;
	
	/** Mock de consumidor de servicios */
	@Mock
	private RestTemplate restTemplate;
	
	/** Escenario rosa - Verificamos flujo de ejecución Rest Template*/
	@Test
	public void test_EscenarioRosa() {
		// Inicio
		restConsumerService = new RestConsumerServiceImpl();
		restTemplate = Mockito.mock(RestTemplate.class);
		ReflectionTestUtils.setField(restConsumerService, "restTemplate", restTemplate);
		
		String url = "URL_TEST";
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
		HttpEntity<String> entidadHTTP = 
				ReflectionTestUtils.invokeMethod(consumeRestSService, "obtenEntidadHttp", strJson);
		
		// Ejecución
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicio("URL_TEST", entidadHTTP);
		
		//Validación -> 6 ejecuciones (# arbitrario)... por lo tanto 6 solicitudes al MOCK
		Mockito.verify(restTemplate, Mockito.times(6)).
			exchange(url, HttpMethod.POST, entidadHTTP, String.class);
		
	}

	/** Escenario rosa - Verificamos flujo de ejecución Rest Template*/
	@Test
	public void test_EscenarioRosa_consumirServicioConsulta() {
		// Inicio
		restConsumerService = new RestConsumerServiceImpl();
		restTemplate = Mockito.mock(RestTemplate.class);
		ReflectionTestUtils.setField(restConsumerService, "restTemplate", restTemplate);
		
		String url = "URL_TEST";
		String strJson = "{'a':'b'}";
		ConsumeServicioNipServiceImpl consumeRestSService 
				= new ConsumeServicioNipServiceImpl();
		ReflectionTestUtils.setField(consumeRestSService, "restConsumerService", restConsumerService);
		HttpEntity<String> entidadHTTP = 
				ReflectionTestUtils.invokeMethod(consumeRestSService, "obtenEntidadHttp", strJson);
		
		// Ejecución
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		restConsumerService.consumirServicioConsulta("URL_TEST", entidadHTTP);
		
		//Validación -> 6 ejecuciones (# arbitrario)... por lo tanto 6 solicitudes al MOCK
		Mockito.verify(restTemplate, Mockito.times(6)).
			exchange(url, HttpMethod.GET, entidadHTTP, String.class);
		
	}
}
