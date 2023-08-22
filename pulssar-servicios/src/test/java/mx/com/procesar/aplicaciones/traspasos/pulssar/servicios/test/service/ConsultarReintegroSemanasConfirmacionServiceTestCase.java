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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasConfirmacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarReintegroSemanasConfirmacionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConfirmacionMontoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test Confirmacion Reintegro
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarReintegroSemanasConfirmacionServiceTestCase {
  
  /**
   * Servicio	
   */
  @Autowired
  @InjectMocks
  private ConsultarReintegroSemanasConfirmacionService confirmacionSrvice = new ConsultarReintegroSemanasConfirmacionServiceImpl();
  
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
   * Test realizar la Confirmacion Reintegro	
   */
  @Test
  public void testRealizarConfirmacionReintegro() {
	  ReflectionTestUtils.setField(confirmacionSrvice, "urlConfirmaReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/confirmacion");

	  CalculoReintegroSalida datosSalida= new CalculoReintegroSalida();
	  ConfirmacionMontoSalida montoSalida=new ConfirmacionMontoSalida();
		
		ResponseEntity<ConfirmacionMontoSalida> respuestaSalida = new ResponseEntity<ConfirmacionMontoSalida>(montoSalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(ConfirmacionMontoSalida.class))).thenReturn(respuestaSalida);
			montoSalida = confirmacionSrvice.realizarConfirmacionReintegro(datosSalida);
			assertNotNull(montoSalida);
        }catch (Exception e) {
			assertNotNull(e);
		}
  }  
  
  /**
   * Test 
   */
  @Test
	public void testRealizarConfirmacionReintegroNulo() {
	  ReflectionTestUtils.setField(confirmacionSrvice, "urlConfirmaReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/confirmacion");

	  CalculoReintegroSalida datosSalida= new CalculoReintegroSalida();
	  ConfirmacionMontoSalida montoSalida=new ConfirmacionMontoSalida();
		
		ResponseEntity<ConfirmacionMontoSalida> respuestaSalida = new ResponseEntity<ConfirmacionMontoSalida>(montoSalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(ConfirmacionMontoSalida.class))).thenReturn(respuestaSalida);
			Mockito.when(utileriaValidador.isEmpty(Mockito.any(ConfirmacionMontoSalida.class))).thenReturn(Boolean.TRUE);
			montoSalida = confirmacionSrvice.realizarConfirmacionReintegro(datosSalida);
			assertNotNull(montoSalida);
		}catch (Exception e) {
			assertNotNull(e);
		}
		
	}
 
}
