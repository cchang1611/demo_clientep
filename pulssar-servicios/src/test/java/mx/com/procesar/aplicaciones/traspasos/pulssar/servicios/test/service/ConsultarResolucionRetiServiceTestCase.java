package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarResolucionRetiService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarResolucionRetiServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * TestCase Consulta Resolucion Reti
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Jun 30, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarResolucionRetiServiceTestCase {

	/**
	 * Servicio
	 */
	@Autowired
	@InjectMocks
	private ConsultarResolucionRetiService serviceConsulta = new ConsultarResolucionRetiServiceImpl();
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Test Consulta resolucion reti
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarResolucionReti() {
		ReflectionTestUtils.setField(serviceConsulta, "urlConsultaResolucionReti", "http://lbint-devl.procesar.net/comunesPulssar/resolucionReti/consultarResolucionReti/?");
		serviceConsulta.consultarResolucionReti(1l, "02", "201");
		
	}
	
	/**
	 *  Test consulta datos nulos 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarResolucionRetiNulos() {
		ReflectionTestUtils.setField(serviceConsulta, "urlConsultaResolucionReti", "http://lbint-devl.procesar.net/comunesPulssar/resolucionReti/consultarResolucionReti/?");
		serviceConsulta.consultarResolucionReti(0l, null, null);
		
	}
}
