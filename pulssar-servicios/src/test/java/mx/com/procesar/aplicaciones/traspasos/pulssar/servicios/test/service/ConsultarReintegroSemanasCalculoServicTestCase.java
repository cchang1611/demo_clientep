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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarReintegroSemanasCalculoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * TestCase para Reintegro Calculo
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarReintegroSemanasCalculoServicTestCase {

	/**
	 * Servicio
	 */
	@Autowired
	@InjectMocks
	private ConsultarReintegroSemanasCalculoService calculoService =new ConsultarReintegroSemanasCalculoServiceImpl();
	
	/**
	 * Inyeccion Mock restService
	 */
	@Mock 
	private RestTemplate restService;
	
	/**
	 * Inyeccion Mock restService
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
 	 MockitoAnnotations.initMocks(this);
	}
		
	
	/**
	 * Test Calculo reintegro
	 */
	@Test
	public void testRealizarCalculoReintegro() {
		ReflectionTestUtils.setField(calculoService, "urlrealizaCalcularReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/calculo");

		ConsultaHistoricoSalida consultaHistorico=new ConsultaHistoricoSalida();
		CalculoReintegroSalida datosSalida= new CalculoReintegroSalida(); 
		ResponseEntity<CalculoReintegroSalida> respuestaSalida = new ResponseEntity<CalculoReintegroSalida>(datosSalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(CalculoReintegroSalida.class))).thenReturn(respuestaSalida);
			datosSalida = calculoService.realizarCalculoReintegro(consultaHistorico);
			assertNotNull(datosSalida);
		}catch (Exception e) {
			assertNotNull(e);
		}
		
	}
	
    /***
     *  Test CalculoReintegro nulo
     */
	@Test
	public void testRealizarCalculoReintegroNulo() {
		ReflectionTestUtils.setField(calculoService, "urlrealizaCalcularReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/calculo");

		ConsultaHistoricoSalida consultaHistorico=new ConsultaHistoricoSalida();
		CalculoReintegroSalida datosSalida= new CalculoReintegroSalida();
		ResponseEntity<CalculoReintegroSalida> respuestaSalida = new ResponseEntity<CalculoReintegroSalida>(datosSalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(CalculoReintegroSalida.class))).thenReturn(respuestaSalida);
			Mockito.when(utileriaValidador.isEmpty(Mockito.any(CalculoReintegroSalida.class))).thenReturn(Boolean.TRUE);
			datosSalida = calculoService.realizarCalculoReintegro(consultaHistorico);
			assertNotNull(datosSalida);
		}catch (Exception e) {
			assertNotNull(e);
		}
	}

}
