package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.BitacoraMovimientoModificacionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Test para validar guardado de flujo bitacora
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class BitacoraMovimientoModificacionServiceTestCase {

	@Autowired
	@InjectMocks
	BitacoraMovimientoModificacionService bitacoraService = new BitacoraMovimientoModificacionServiceImpl();
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	@Mock
	private RestTemplate clienteServicio;
	
	/**
	 * Utileria Cadena
	 */
	@Mock
	private CadenasUtils utileriaCadena;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGuardarFlujoBitacora() {
		bitacoraService.generaObjetoModificacion("01", "descripcion", "diagnostico", "flujo", "nss", "curp", "folioPAdre", "foliohijo", "resultado");
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenThrow(new NullPointerException());
		bitacoraService.generaObjetoModificacion("01", "descripcion", "diagnostico", "flujo", "nss", "curp", "folioPAdre", "foliohijo", "resultado");

	}

}
