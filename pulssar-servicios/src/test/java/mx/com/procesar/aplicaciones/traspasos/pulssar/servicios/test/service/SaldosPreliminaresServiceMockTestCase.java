package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import javax.xml.ws.WebServiceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.SaldosPreliminaresServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Metodo encargado de validar las exceptiones del Folio
 * 
 * @author DBARBOSA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class SaldosPreliminaresServiceMockTestCase {
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private SaldosPreliminaresService servicioSaldos = new SaldosPreliminaresServiceImpl();
	
	/**
	 * dependencia utilidad validador
	 */
	@Mock 
	private ValidadorUtils utileriaValidador;
	
	/**
	 * dependencia utilidad validador
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

	/**
	 * Test para obtener los saldos exception en la condicion 1
	 */
	@Test
	public void testObtenerSaldosPreliminaresMockExceptionCondicion1() {
		Mockito.when(utileriaValidador.validarObjetoNulo(ArgumentMatchers.any())).thenReturn(true, false);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn("");
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("", "", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos exception en la condicion 2
	 */
	@Test
	public void testObtenerSaldosPreliminaresMockExceptionCondicion2() {
		Mockito.when(utileriaValidador.validarObjetoNulo(ArgumentMatchers.any())).thenReturn(false, true);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn("");
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("", "", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos exception en la condicion 3
	 */
	@Test
	public void testObtenerSaldosPreliminaresMockExceptionCondicion3() {
		Mockito.when(utileriaValidador.validarObjetoNulo(ArgumentMatchers.any())).thenReturn(false, false);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("BA", null)).thenReturn("");
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("12", null)).thenReturn("");
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(null, "")).thenReturn("Servicio de la administradora no disponible");
		
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("BA", "12", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos exception WebServiceException
	 */
	@Test
	public void testObtenerSaldosPreliminaresMockException1() {
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("BA", null)).thenThrow(new WebServiceException("Controlado"));
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("BA", "12", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos exception Exception
	 */
	@Test
	public void testObtenerSaldosPreliminaresMockException2() {
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("BA", null)).thenThrow(new RuntimeException("Controlado"));
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("BA", "12", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos rechazo
	 */
	@Test
	public void testObtenerSaldosPreliminaresRechazo() {
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("BA", "12", "556");
		Assert.assertNotNull(datos);
	}
	
	/**
	 * Test para obtener los saldos rechazo
	 */
	@Test
	public void testObtenerSaldosPreliminaresOK() {
		Mockito.when(utileriaValidador.validarVacio(ArgumentMatchers.anyString())).thenReturn(false, true);
		DatosSaldos datos = servicioSaldos.obtenerSaldosPreliminares("CU", "nss", "clave");
		Assert.assertNotNull(datos);
	}
}