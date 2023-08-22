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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPensionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoTipoPensionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
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
public class CatalogoTipoPensionServiceTestCase {

	/**
	 * Inyecccion tipoPensionService
	 */
	@Autowired
	private CatalogoTipoPensionService tipoPensionService = new CatalogoTipoPensionServiceImpl();

	/**
	 * Test tipo pension
	 */
	@Test
	public void testConsultaTipoPension() {
		List<CatalogoIret> listaSPension =tipoPensionService.consultaTipoPension();
		assertNotNull(listaSPension);
	}
}
