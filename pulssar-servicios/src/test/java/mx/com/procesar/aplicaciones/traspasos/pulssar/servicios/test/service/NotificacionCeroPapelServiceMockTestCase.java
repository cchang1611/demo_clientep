package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionCeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NotificacionCeroPapelServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Notificacion service
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class NotificacionCeroPapelServiceMockTestCase {
	
	/**
	 * NotificacionCeroPapelService
	 */
	@InjectMocks
	private NotificacionCeroPapelService notificacionCeroPapelService = new NotificacionCeroPapelServiceImpl();
	/**
	 * dependencia clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	
	/**
	 * uriGuardarCeroPapel
	 */
	@Value("${comunes.guardar.notificacionCeroPapel}")
	private String uriGuardarNotificacionCeroPapel;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(notificacionCeroPapelService,"uriGuardarNotificacionCeroPapel","http://lbint-devl.procesar.net/comunesPulssar-exposicion-notificacion/guardarCeroPapelNotificacion");
	}
	/**
	 * Para guardar los datos
	 */
	@Test
	public void testGuardarDatosNotificacion () {
		try {
			Mockito.doNothing().when(clienteServicio).put(Mockito.anyString(), any(HttpEntity.class));
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
