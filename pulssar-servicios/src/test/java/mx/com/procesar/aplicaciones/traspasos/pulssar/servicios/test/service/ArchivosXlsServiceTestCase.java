package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivosXlsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test consulta catalogo tipo Pension
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ArchivosXlsServiceTestCase {

	/**
	 * Inyecccion tipoPensionService
	 */
	@Autowired
	private ArchivosXlsService archivo;
	
	/**
	 * Ruta donde se encuentra el archivo zip a validar.
	 */
	protected java.lang.String RUTA = new StringBuilder(
			"src/test/resources/archivos/").toString();

	/**
	 * Test tipo pension
	 * @throws IOException 
	 */
	@Test
	public void testFile() {
		
		try {
//		"D:\\2_DATOS\\DATOS\\Carga_Masiva.csv");
		File arch = new File(RUTA.concat("568_cargaMasivaAgente_22062022.csv"));
		
		CommonsMultipartFile chooseFile = null;
		FileInputStream input;
			input = new FileInputStream(arch);
			
			UsuarioLogin user = new UsuarioLogin();
			user.setNombre("Ricardo");
			user.setApellidoPaterno("alcnatra");
			user.setApellidoMaterno("Ramirez");
			user.setAforeUsuario("568");
			user.setUsuario("josorio@procesar.com");
			
			Map<String, Object> resp = archivo.obtenerDatosExcel(arch.getName(), input, user);
			assertNotNull(resp);
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}
	
	/**
	 * Test valida el minimo de registros
	 * @throws IOException 
	 */
	@Test
	public void testFile_registrosMinimos() {
		
		try {
		File arch = new File(RUTA.concat("568_cargaMasivaAgente_22062022.csv"));
		
		CommonsMultipartFile chooseFile = null;
		FileInputStream input;
			input = new FileInputStream(arch);
			
			UsuarioLogin user = new UsuarioLogin();
			user.setNombre("Ricardo");
			user.setApellidoPaterno("alcnatra");
			user.setApellidoMaterno("Ramirez");
			user.setAforeUsuario("568");
			user.setUsuario("josorio@procesar.com");
			
			Map<String, Object> resp = archivo.obtenerDatosExcel(arch.getName(), input, user);
			assertNotNull(resp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Test carga masiva error numero maximo de registros 
	 * @throws IOException 
	 */
	@Test
	public void testFile_registro_maximo() {
		
		try {
		File arch = new File(RUTA.concat("Carga_Masiva_mas.csv"));
		
		CommonsMultipartFile chooseFile = null;
		FileInputStream input;
			input = new FileInputStream(arch);
			
			UsuarioLogin user = new UsuarioLogin();
			user.setNombre("Ricardo");
			user.setApellidoPaterno("alcnatra");
			user.setApellidoMaterno("Ramirez");
			user.setAforeUsuario("568");
			user.setUsuario("josorio@procesar.com");
			
			Map<String, Object> resp = archivo.obtenerDatosExcel(arch.getName(), input, user);
			assertNotNull(resp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void testObtenerFile() {
		UsuarioLogin user = new UsuarioLogin();
		user.setNombre("Ricardo");
		user.setApellidoPaterno("alcnatra");
		user.setApellidoMaterno("Ramirez");
		user.setAforeUsuario("568");
		user.setUsuario("josorio@procesar.com");
		
		archivo.obtenerArchivoUsuarios("01/06/2022", user);
	}
	
	
	
	
	
	
}
