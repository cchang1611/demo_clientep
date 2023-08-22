package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ValidarExpedienteServicioImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test Case ValidarExpedienteService
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ValidarExpedienteServiceTestCase {

	/**
	  * Inyeccion service
	  */
    @Autowired
    @InjectMocks
	private ValidarExpedienteServicio validaService = new ValidarExpedienteServicioImpl();
    
       
    /**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
//	/**
//	 * Test ValidarExpedienteServicio
//	 */
//	@Test 
//	public void testValidarExpedienteServicio() {
//		
//		 DatosTrabajador datos = Mockito.mock(DatosTrabajador.class);
//		 UsuarioLogin user = Mockito.mock(UsuarioLogin.class);
//		 SolicitudDisposicionParcial sol = Mockito.any(SolicitudDisposicionParcial.class);
//		
//		validaService.validarExpedienteServicio("01", datos, user, sol,true);
//		assertTrue(Boolean.TRUE);
//	}
    
	
    
}
