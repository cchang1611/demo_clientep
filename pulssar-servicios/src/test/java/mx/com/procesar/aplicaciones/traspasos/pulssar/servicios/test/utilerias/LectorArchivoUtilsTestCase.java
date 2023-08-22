package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;

/**
 * test lector archivo
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, 
		PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class LectorArchivoUtilsTestCase {
	
	/**
	 * inyeccion utilidad
	 */
	@Autowired
	private LectorArchivoUtils lectorUtils;

	/**
	 * test obtener contenido archivo 
	 * @throws IOException 
	 */
	@Test
	public void testObtenerContenidoArchivo() throws IOException {
		lectorUtils.obtenerContenidoArchivo("src/test/resources/538/INEFRONT.txt");
	}

}
