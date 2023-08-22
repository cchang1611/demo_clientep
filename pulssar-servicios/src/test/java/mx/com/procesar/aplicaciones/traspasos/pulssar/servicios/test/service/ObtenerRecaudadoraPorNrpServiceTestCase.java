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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerRecaudadoraPorNrpService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ObtenerRecaudadoraPorNrpServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecaudadoraTV;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Test Case ObtenerRecaudadoraPorNrp
 * TODO [Agregar documentacion de la clase]
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 10, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ObtenerRecaudadoraPorNrpServiceTestCase {

	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	private ObtenerRecaudadoraPorNrpService nrpService = new ObtenerRecaudadoraPorNrpServiceImpl();

	/**
	 * Inyeccion Mock restService
	 */
	@Mock 
	private RestTemplate restService;
	
	/**
	 * 
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
	 *  Test ObtenerRecaudadoraPorNrp
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testObtenerRecaudadoraPorNrp() {
		RecaudadoraTV npr = new RecaudadoraTV();
		Mockito.when(restService.getForObject(Mockito.anyString(),Mockito.eq(RecaudadoraTV.class))).thenReturn(npr);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(RecaudadoraTV.class))).thenReturn(Boolean.FALSE);
		npr=nrpService.obtenerRecaudadoraPorNrp("Cr5675");
		assertNotNull(npr);
	}

	/**
	 *  Test BusinessException
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test(expected=BusinessException.class)
	public void testObtenerRecaudadoraPorNrpBusiness() {
		RecaudadoraTV npr = new RecaudadoraTV();
		Mockito.when(restService.getForObject(Mockito.anyString(),Mockito.eq(RecaudadoraTV.class))).thenReturn(npr);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(RecaudadoraTV.class))).thenReturn(Boolean.TRUE);  		
		npr=nrpService.obtenerRecaudadoraPorNrp("CF5");
		assertNull(npr);
	}
}
