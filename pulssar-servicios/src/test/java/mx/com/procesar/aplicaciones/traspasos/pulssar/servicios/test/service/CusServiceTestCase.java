package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CusServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CusServiceTestCase {
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private CusService cusService = new CusServiceImpl();
	
	/**
	 * servicio
	 */
	@Mock
	private RestTemplate rest;
	/**
	 * uri Solicitud Cus
	 */
	@Value("${solicitud.cus.uri}")
	private String uriSolicitudCus;	
	
	/**
	 * uri Genera Cus
	 */
	@Value("${generar.cus.mismo.dia.uri}")
	private String uriGeneracionCus;	
	
	/**
	 * inyeccion de utilerias
	 */
	@Mock
	private ValidadorUtils validadorUtils;
		
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test de solicitud consulta cus
	 */
	@Test
	public void solicitarConsultaCusTest() {
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadConsulta = new HttpEntity<String>("", headerMedia);
		
		ConsultaCusSalida respuesta = new ConsultaCusSalida();
		ResponseEntity<ConsultaCusSalida> respuestaEntity = new ResponseEntity<ConsultaCusSalida>(respuesta , HttpStatus.ACCEPTED);
		Mockito.when(rest.exchange(uriSolicitudCus, HttpMethod.POST,entidadConsulta,ConsultaCusSalida.class)).thenReturn(respuestaEntity);
		try{
			ConsultaCusSalida cus = cusService.solicitarConsultaCus("", "", "", null);
			assertNotNull(cus);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test para generar la cus
	 */
	@Test
	public void generarCusTest() {
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadConsulta = new HttpEntity<String>("", headerMedia);
		RespuestaGeneraCusSalida respuesta = new RespuestaGeneraCusSalida();
		ResponseEntity<RespuestaGeneraCusSalida> respuestaEntity = new ResponseEntity<RespuestaGeneraCusSalida>(respuesta , HttpStatus.ACCEPTED);
		Mockito.when(rest.exchange(uriGeneracionCus, HttpMethod.POST,entidadConsulta,RespuestaGeneraCusSalida.class)).thenReturn(respuestaEntity);
		try{
			EntradaCus entrada = new EntradaCus();
			RespuestaGeneraCusSalida cus = cusService.generarCus(entrada);
			assertNotNull(cus);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test error mensaje
	 */
	@Test
	public void consultaCusTest() {
		HttpHeaders headerMedia = new HttpHeaders();
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entidadConsulta = new HttpEntity<String>("", headerMedia);
		ConsultaCusSalida respuesta = new ConsultaCusSalida();
		ResponseEntity<ConsultaCusSalida> respuestaEntity = new ResponseEntity<ConsultaCusSalida>(respuesta , HttpStatus.ACCEPTED);
		Mockito.when(rest.exchange(uriSolicitudCus, HttpMethod.POST,entidadConsulta,ConsultaCusSalida.class)).thenReturn(respuestaEntity);
		try{
			ConsultaCusSalida cus = cusService.consultaCus("",1L,"");
			assertNotNull(cus);
		}catch(Exception e){
			assertNotNull(e);
		}
	}

}
