package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarMatrizDerechoProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Test Valida Procesos 402,403 Ventanilla Afore
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 20, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ValidarMatrizDerechoProcesoServiceTestCase {

	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	private ValidarMatrizDerechoProcesoService validarMatrizDerechoProcesoService;
	
	/**
	 * Inyeccion Mock utileriaValidador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Test valida Procesos para ventanilla Afore
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testValidarMatrizDerecho() {
		List<String> claves = new ArrayList<>();
		claves.add("402");
		claves.add("403");
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.any(List.class))).thenReturn(Boolean.FALSE);
	    claves = validarMatrizDerechoProcesoService.validarMatrizDerecho(claves);
	    assertNotNull(claves);
	}
	
	/**
	 * 
	 * Test valida Procesos para ventanilla Afore nulos
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testValidarMatrizDerechoVacio() {
		List<String> claves = new ArrayList<>();
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.any(List.class))).thenReturn(Boolean.FALSE);
	    claves = validarMatrizDerechoProcesoService.validarMatrizDerecho(claves);
	    assertNotNull(claves);
	}
}
