package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoRetiroIretService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoTipoRetiroImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CatalogoTipoRetiroIretServiceTestCase {

	/**
	 * Inyeccion de Servicio
	 */
	@Autowired CatalogoTipoRetiroIretService retiroService = new CatalogoTipoRetiroImpl();
	
	/**
	 * Test consulta retiro
	 */
	@Test
	public void testConsultaTipoRetiro() {
		List<CatalogoIret> listaRetiro =retiroService.consultaTipoRetiro();
		assertNotNull(listaRetiro);
	}
}
