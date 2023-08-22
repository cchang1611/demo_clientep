package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.jfree.util.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDigitoVerificadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarDigitoVerificadorServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaValidarDigitoVerificador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Valida digito verificador
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarDigitoVerificadorServiceTestCase {

	/**
	  * Inyeccion service
	  */
  @Autowired
  private ConsultarDigitoVerificadorService digitoService = new ConsultarDigitoVerificadorServiceImpl();
	

	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * digito verificador exitoso
	 */
	@Test
	public void testValidarDigitoVerificador() {
		try {
		RespuestaValidarDigitoVerificador digito = digitoService.validarDigitoVerificador("002352789012345678");
		assertNotNull(digito);
		}catch (Exception e) {
			Log.error("Error");
		}
	}
	
	/**
	 * digito verificador exception
	 */
	@Test
	public void testValidarDigitoVerificadorException() {
		try {
			RespuestaValidarDigitoVerificador digito = digitoService.validarDigitoVerificador("002456789632541870");	
			assertNull(digito);
		}catch (Exception e) {
			Log.error("Error");
		}
	}
}
