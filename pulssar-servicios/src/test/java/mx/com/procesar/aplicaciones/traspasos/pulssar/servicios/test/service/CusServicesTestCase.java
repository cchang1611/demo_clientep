package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarServiceApplicationContextTest.class,
									PulssarPersistenceApplicationContextTest.class,
									PulssarCorreoAplicationContextTest.class})
public class CusServicesTestCase {
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CusService servicioCus;
	
	/**
	 * Test Para consulta cus excepcion
	 */
	@Test
	public void testConsultarCusExcepcion() {
		try {
			servicioCus.consultaCus("BACG620329MPLRR000", 22040620064095l, "01");
			
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	/**
	 * Test Para consulta cus exito
	 */
	@Test
	public void testConsultarCus() {
		try {
			assertNotNull(servicioCus.consultaCus("BACG620329MPLRRD01", 22040620064095l, "01"));
			
		} catch (Exception e) {
			fail();
		}
	}


}