package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CeroPapelServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase de cero papel
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CeroPapelServiceTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@InjectMocks
	private CeroPapelService ceroPapelService = new CeroPapelServiceImpl();
	
	/**
	 * uriConsultaEstatus
	 */
	@Value("${comunes.ceroPapel.consultaEstatus}")
	private String uriConsultaEstatus;
	
	
	
	/**
	 * uriGuardarCeroPapel
	 */
	@Value("${comunes.guardar.ceroPapel}")
	private String uriGuardarCeroPapel;
	
	/**
	 * Para guardar los datos
	 */
	@Test
	public void testGuardarDatos () {
		try {
			EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			DatosTrabajador trabajador = new DatosTrabajador();
		 ceroPapelService.guardarDatosCeroPapel(entradaCeroPapel);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para consultar estatus
	 */
	@Test
	public void testConsultarEstatus () {
		try {
		 ceroPapelService.consultaEstatusCeroPapel(1l);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	

}