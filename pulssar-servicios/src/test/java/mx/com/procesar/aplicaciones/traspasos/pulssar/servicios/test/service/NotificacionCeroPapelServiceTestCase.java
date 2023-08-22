package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionCeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class NotificacionCeroPapelServiceTestCase {
	
	/**
	 * NotificacionCeroPapelService
	 */
	@Autowired
	private NotificacionCeroPapelService notificacionCeroPapelService;
	
	
	/**
	 * Para guardar los datos
	 */
	@Test
	public void testGuardarDatosNotificacion () {
		try {
			EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			DatosTrabajador trabajador = new DatosTrabajador();
			DatosComplementarios datosComplementarios = new DatosComplementarios();
			trabajador.setDatosComplementarios(datosComplementarios);
			notificacionCeroPapelService.guardarDatosNotificacionCeroPapel(entradaCeroPapel,"2");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	

}
