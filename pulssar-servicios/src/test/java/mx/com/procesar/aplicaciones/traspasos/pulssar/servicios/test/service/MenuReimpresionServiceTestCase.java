package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionSaldosYMovimientosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.MenuReimpresionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MenuReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * MenuReimpresionServiceTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class MenuReimpresionServiceTestCase {
	
	
	/**
	 * MenuReimpresionService
	 */
	@InjectMocks
	private MenuReimpresionService menuReimpresionService = new MenuReimpresionServiceImpl();
	
	
	
	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);	
	}
	
	/**
	 * testObtenerMenuReimpresion
	 */
	@Test
	public void testObtenerMenuReimpresion() {
		MenuReimpresion menu=menuReimpresionService.obtenerMenuReimpresion();
		Assert.assertNotNull(menu);
	}
	
	/**
	 * testObtenerMenuSaldsYMovimientos
	 */
	@Test
	public void testObtenerMenuSaldsYMovimientos() {
		List<MenuReimpresionSaldosYMovimientosEnum> lista=menuReimpresionService.obtenerMenuReimpresionSaldosYMovimientos();
		Assert.assertNotNull(lista);
	}
	
	/**
	 * testobtenerRespuestaCorrecta
	 */
	@Test
	public void testobtenerRespuestaCorrecta() {
		RespuestaServicio respuesta=menuReimpresionService.obtenerRespuestaCorrecta(1, "OK", "OK");
		Assert.assertNotNull(respuesta);
	}
	
}
