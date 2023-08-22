package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.InicializarHeadersServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test Para Iniciliar cabeceras
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class InicializarHeadersServiceTestCase {
	
	/**
	   * Servicio	
	   */
	  @Autowired
	  private InicializarHeadersService inicializaService= new InicializarHeadersServiceImpl();
	  
	  /**
	   * Inicializa Cabece
	   */
	  @Test
	  public void testInicializarCabeceras() {
		  inicializaService.inicializarCabeceras(); 
	  }

}
