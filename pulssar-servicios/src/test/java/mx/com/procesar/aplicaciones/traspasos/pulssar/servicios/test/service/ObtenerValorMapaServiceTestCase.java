package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerValorMapaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ObtenerValorMapaServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * TestCase para validar archivos pdf
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ObtenerValorMapaServiceTestCase {

	/**
	 * Inyeccion Servicio
	 */
	@Autowired
	private ObtenerValorMapaService mapaService = new ObtenerValorMapaServiceImpl(); 

	
	/**
	 * Test para eliminar directorio
	 */
	@Test
	public void testRecorrerListadoMapa() {
		Map<String, String> nombreArchivo = new HashMap<>();
		nombreArchivo.put("61","53840ROCA650815MSPDRS08262120191104031.pdf");
		
		mapaService.recorrerListadoMapa(nombreArchivo);

	} 
	
	/**
	 * Test que borra los archivos y directorio
	 */
	@Test
	public void testBorrarDirectorio() { 
	
		String ruta= "C:\\Users\\anosorio\\Documents\\PDF3\\ARCHIVO";
		File dir = new File(ruta);
		mapaService.borrarDirectorio(dir); 
	}
	
	/**
	 * Test Error al borrar archivos
	 */
	@Test
	public void testBorrarDirectorioNoValido() {
		
		String ruta= "C:\\Users\\anosorio\\Documents\\PDF2\\ARCHIVO2";
		File dir = new File(ruta);
		mapaService.borrarDirectorio(dir);
	}
}
