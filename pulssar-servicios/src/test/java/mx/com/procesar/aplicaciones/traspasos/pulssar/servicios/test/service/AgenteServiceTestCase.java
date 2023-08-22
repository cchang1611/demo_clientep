package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import org.jfree.util.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AgenteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.AgenteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Test Case Agente Promotor
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class AgenteServiceTestCase {

	/**
	 * Inyeccion Servicio
	 */
	@Autowired
	@InjectMocks
	private AgenteService agenteService = new AgenteServiceImpl();
	
	/**
	 * Inyecccion Mock utileriaValidador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Test Agente Promotor
	 */
	@Test
	public void testValidarAgentePromotor() {
		DatosRegistro registro = new DatosRegistro();
	try {	
	
		AgentePromotor promotor= agenteService.validarAgentePromotor(registro, Boolean.TRUE);
	   assertNotNull(promotor);
	}catch (BusinessException e) {
		Log.error("Error.{}",e);
	}
}
	
}
