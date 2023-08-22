package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RechazoPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class RechazoPulssarTestCase {
	
	
	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private RechazoPulssarRepository rechazo;
	
	/**
	 * Prueba exito
	 * codigo de rechazo
	 */
	@Test
	public void testFindByClaveRechazoAndClaveOrganizacionAndEstatus() {
		RechazoPulssar resultado = rechazo.findByClaveRechazoAndClaveOrganizacionAndEstatus("OK05", "556", 1);
		assertNotNull(resultado);
	}
	
	/**
	 * prueba error
	 * codigo de rechazo
	 */
	@Test
	public void testFindByClaveRechazoAndClaveOrganizacionAndEstatusError() {
		RechazoPulssar resultado = rechazo.findByClaveRechazoAndClaveOrganizacionAndEstatus(null, "556", 1);
		assertNull(resultado);
	}

}
