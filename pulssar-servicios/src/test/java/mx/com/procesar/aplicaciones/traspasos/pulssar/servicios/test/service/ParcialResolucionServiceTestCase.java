package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ResolucionParcialServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test Case Consulta Resolucion Parcial
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ParcialResolucionServiceTestCase {

	/**
	 *  Inyeccion service
	 */
	@Autowired
	@InjectMocks
	 private ResolucionParcialService resolucionService = new ResolucionParcialServiceImpl();
	
	 /**
		 * Inicializa los elementos para la prueba.
		 */
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}
		
		/**
		 * Test ObtenerResolucionParcial
		 */
		@Test
		public void testObtenerResolucionParcial() {
		String resol=resolucionService.obtenerResolucionParcial(1l, "01");
		assertNull(resol);
		}
	
		/**
		 * Test ObtenerDisposicion
		 */
		@Test
		public void testObtenerDisposicion() {
		String resol=resolucionService.obtenerDisposicion(1l, "2100", "20400");
		assertNull(resol);
		}
		
}
