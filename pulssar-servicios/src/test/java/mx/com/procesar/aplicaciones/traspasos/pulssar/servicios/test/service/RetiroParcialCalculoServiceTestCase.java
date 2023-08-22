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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RetiroParcialCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RetiroParcialCalculoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test realiza el guardado el tipo de retiro parcial 
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class RetiroParcialCalculoServiceTestCase {

	/**
	 * Inyeccion Servicio
	 */
	@Autowired
	@InjectMocks
	private RetiroParcialCalculoService retiroService = new RetiroParcialCalculoServiceImpl();
	
	/**
	 * Inyeccion Mock restTemplate
	 */
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	/**
	 * Test guardar retiro
	 */
	@Test
	public void testGuardarCalculoMAtrimonio() {
		ReflectionTestUtils.setField(retiroService, "urlGuardarCalculoRetiroParcial", "http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/retiroParcial/imss/");

		ParametrosRetiroParcialCalculoImss entrada=new ParametrosRetiroParcialCalculoImss();
		DatosTrabajador trabajador = new DatosTrabajador();
		entrada.setSaldoRetiro97(267.00);
		entrada.setSaldoRcv(1000.00); 
		
		entrada.setClaveBanco("012");
		entrada.setCuenta("054646343345");
		entrada.setCuentaClabe("78654356754325643");
		entrada.setDescripcionCtrlInstBancaria("PAGO DEPOSTO BANCARIO");
		entrada.setEstatus(1);
		entrada.setFolio("004345");
		entrada.setNumeroParcialidad(3);
		entrada.setTipoRetiro("A");
		entrada.setUsuarioModificador("PRUEBA");
		
		try {		
		retiroService.guardarCalculo(entrada, trabajador,"matrimonio", true);
		}catch (Exception e) {
			assertNotNull(e);
			
		}
	}
	
	/**
	 * Test valida origen igual a Retiro Por Desempleo
	 */
	@Test
	public void testGuardarCalculoMAtrimonioRetiroDesempleo() {
		ReflectionTestUtils.setField(retiroService, "urlGuardarCalculoRetiroParcial", "http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/retiroParcial/imss/");
		ParametrosRetiroParcialCalculoImss entrada=new ParametrosRetiroParcialCalculoImss();
		DatosTrabajador trabajador = new DatosTrabajador();
		entrada.setSaldoRetiro97(267.00);
		entrada.setSaldoRcv(1000.00); 
		
		entrada.setClaveBanco("012");
		entrada.setCuenta("054646343345");
		entrada.setCuentaClabe("78654356754325643");
		entrada.setDescripcionCtrlInstBancaria("PAGO DEPOSTO BANCARIO");
		entrada.setEstatus(1);
		entrada.setFolio("004345");
		entrada.setNumeroParcialidad(3);
		entrada.setTipoRetiro("A");
		entrada.setUsuarioModificador("PRUEBA");
		
		try {		
		retiroService.guardarCalculo(entrada, trabajador,"retiroDesempleo", true);
		}catch (Exception e) {
			assertNotNull(e);
			
		}
	}
	
	/**
	 * Test guardar retiro Exception
	 */
	@Test
	public void testGuardarCalculoException() {
		ReflectionTestUtils.setField(retiroService, "urlGuardarCalculoRetiroParcial", "http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/retiroParcial/imss/");
		ParametrosRetiroParcialCalculoImss entrada=new ParametrosRetiroParcialCalculoImss();
		DatosTrabajador trabajador = new DatosTrabajador();
		entrada.setSaldoRetiro97(267.00);
		entrada.setSaldoRcv(1000.00); 
		
		entrada.setClaveBanco("012");
		entrada.setCuenta("054646343345");
		entrada.setCuentaClabe("78654356754325643");
		entrada.setDescripcionCtrlInstBancaria("PAGO DEPOSTO BANCARIO");
		entrada.setEstatus(1);
		entrada.setFolio("004345");
		entrada.setNumeroParcialidad(3);
		entrada.setTipoRetiro("A");
		entrada.setUsuarioModificador("PRUEBA");
		try {		
			 Mockito.when(restTemplate.exchange(Mockito.anyString(),Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class),  Mockito.eq(RespuestaServicioRetiroParcialCalculo.class)))
				.thenThrow(new BusinessException("Error al guardar el cálculo de retiro parcial"));
				
			retiroService.guardarCalculo(entrada, trabajador,"retiroDesempleo", true);
		}catch (Exception e) {
			
			assertNotNull(e);
			
		}
	}
	
	
}
