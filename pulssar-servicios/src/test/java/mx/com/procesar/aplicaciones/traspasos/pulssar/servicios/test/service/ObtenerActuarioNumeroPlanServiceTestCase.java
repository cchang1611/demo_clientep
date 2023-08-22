package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerActuarioNumeroPlanService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ObtenerActuarioNumeroPlanServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado97;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 *  Test Case ObtenerActuarioNumeroPlan
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 10, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ObtenerActuarioNumeroPlanServiceTestCase {

	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	private ObtenerActuarioNumeroPlanService actuarioService = new ObtenerActuarioNumeroPlanServiceImpl();
	
		/**
	 * Inyeccion Mock restService
	 */
	@Mock 
	private RestTemplate restService;
	
	
	/**
	 * Inyeccion Mock utileriaValidador
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
	 *   Test ObtenerPlanPrivadoPorActuarioYNumeroPlan
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testObtenerPlanPrivadoPorActuarioYNumeroPlan() {
		RetiroPlanPrivado97 retiroPlan= new RetiroPlanPrivado97();
		Mockito.when(restService.getForObject(Mockito.anyString(),Mockito.eq(RetiroPlanPrivado97.class))).thenReturn(retiroPlan);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(RetiroPlanPrivado97.class))).thenReturn(Boolean.FALSE);
		retiroPlan = actuarioService.obtenerPlanPrivadoPorActuarioYNumeroPlan("D", "C456"); 	
		assertNotNull(retiroPlan);
	}
	
	/**
	 *  Test BusinessException
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test(expected=BusinessException.class)
	public void testObtenerPlanPrivadoPorActuarioYNumeroPlanBusiness() {
		RetiroPlanPrivado97 retiroPlan= new RetiroPlanPrivado97();
		Mockito.when(restService.getForObject(Mockito.anyString(),Mockito.eq(RetiroPlanPrivado97.class))).thenReturn(retiroPlan);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(RetiroPlanPrivado97.class))).thenReturn(Boolean.TRUE);
		retiroPlan = actuarioService.obtenerPlanPrivadoPorActuarioYNumeroPlan("D", "C456"); 	
		assertNull(retiroPlan);
	}
	
	
}
