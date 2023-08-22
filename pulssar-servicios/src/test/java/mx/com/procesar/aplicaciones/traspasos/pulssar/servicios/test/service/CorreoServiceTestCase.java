package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * clase de pruebas de la validacion de un registro de usuario
 * 
 * @author dbarbosa
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CorreoServiceTestCase {

	/**
	 * Dependecia servicioRegistroUsuario
	 */
	@Autowired
	private CorreoService servicioCorreo;
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	@Ignore
	public void testEnvioCorreoException() {
		DatosCorreo datosCorreo = new DatosCorreo();
		datosCorreo.setContrasenia("123456789");
		datosCorreo.setCorreo("davidtol19@gmail.com");
		datosCorreo.setFecha("12/Abril/2019");
		datosCorreo.setDatosCorreo(CorreoEnum.ARCHIVO_ALTA_USUARIO);
		datosCorreo.setFolio("12345678901234567890");
		datosCorreo.setLigaServicio("hjgsadf5431");
		datosCorreo.setNombre("David b B");
		datosCorreo.setUsuario("123456789");
		servicioCorreo.envioCorreo(datosCorreo, "530");
	}
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	@Ignore
	public void testEnvioCorreoGenericException() {
		DatosCorreo datosCorreo = new DatosCorreo();
		datosCorreo.setContrasenia("123456789");
		datosCorreo.setCorreo("davidtol19@gmail.com");
		datosCorreo.setFecha("12/Abril/2019");
//		datosCorreo.setDatosCorreo(CorreoEnum.ARCHIVO_ACTIVACION_USUARIO);
		datosCorreo.setFolio("12345678901234567890");
		datosCorreo.setLigaServicio("hjgsadf5431");
		datosCorreo.setNombre("David b B");
		datosCorreo.setUsuario("123456789");
		servicioCorreo.envioCorreo(datosCorreo, "530");
	}
}