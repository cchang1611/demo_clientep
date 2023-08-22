/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ZipUtils;

/**
 * Test de la clase ZipUtils
 * @author dhernand
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, 
		PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ZipUtilsTestCase extends TestCase {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ZipUtilsTestCase.class);
	
	
	/**
	 * Utileria de xml
	 */
	@Autowired
	private ZipUtils zipUtils;
	
	
	/**
	 * Test de conversion de un objeto a xml
	 */
	@Test
	public void testGeneraZipEntry() {
		try {
			byte[] bytes =  zipUtils.generaZipEntry("Informacion", "CURPP.xml");
			assertNotNull(bytes);
		} catch (IOException e) {
			logger.error("Error:",e);
			fail();
		}
		
	}

}
