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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoSeguroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoTipoSeguroServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test consulta Tipo Seguro
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CatalogoTipoSeguroServiceTestCase {

	/**
	 * Inyeccion de Servicio
	 */
	@Autowired
	private CatalogoTipoSeguroService tipoSeguroService = new CatalogoTipoSeguroServiceImpl();
	
	
	/**
	 * Test consulta catalogo tipo seguro
	 */
	@Test
	public void testConsultaTipoSeguro() {
		List<CatalogoIret> listaSeguro = tipoSeguroService.consultaTipoSeguro();
		assertNotNull(listaSeguro);
	}
	
		
	
}
