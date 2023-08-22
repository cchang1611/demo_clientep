/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarMockitoServiceApplicationContextTest;

/**
 * Clase de Prueba base. El objetivo de la presente clase es concentrar la
 * configuración correspondientes a cada prueba para que sólo ésta se encuentra
 * en un solo punto.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PulssarPropertiesApplicationContextTest.class,
		PulssarMockitoServiceApplicationContextTest.class, 
		PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class
	}
)
public class BaseTestCase extends TestCase {

	/**
	 * Prueba base para probar la configuraión de los tests.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	public void test() {
		assertTrue(Boolean.TRUE);
	}

}
