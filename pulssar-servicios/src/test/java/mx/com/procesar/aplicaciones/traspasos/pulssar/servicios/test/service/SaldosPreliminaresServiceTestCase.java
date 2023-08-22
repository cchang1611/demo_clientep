package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
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
public class SaldosPreliminaresServiceTestCase {

	/**
	 * Dependecia servicioRegistroUsuario
	 */
	@Autowired
	private SaldosPreliminaresService servicioSaldos;
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	public void testObtenerSaldosPreliminares() {
		servicioSaldos.obtenerSaldosPreliminares("BACG620329MPLRRD01", "12345678958", "530");
	}
}