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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CoppelServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DigitalizacionCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test para servicios coppel
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CoppelServiceImplMockTestCase {
	
	/**
	 *Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private CoppelService coppelService = new CoppelServiceImpl();
	
	
	/**
	 * Utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Mock
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * test para generar peticion pad firma
	 */
	@Test
	public void testGenerarPeticionPadFirma() {
		coppelService.generarPeticionPadFirma();
	}
	
	/**
	 * test para generar peticion digitalizacion
	 */
	@Test
	public void testGenerarPeticionDigitalizacion() {
		DigitalizacionCoppel digitalizacionCoppel = new DigitalizacionCoppel();
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("1");
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro);
		coppelService.generarPeticionDigitalizacion(digitalizacionCoppel);
		
		parametro.setChValorParametro("0");
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro);
		coppelService.generarPeticionDigitalizacion(digitalizacionCoppel);
	}
	
	@Test
	public void testValidarDatosObligatoriosConsultaCorrecto() {
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.doNothing().when(utileriaValidador).validarFormato(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		coppelService.validarDatosObligatoriosConsulta("1234567890", "XXXX123456HXXXXX09", "12345678901", "01", "01:00");
	}
	
	@Test(expected=BusinessException.class)
	public void testValidarDatosObligatoriosConsultaExcepcionObligatorio() {
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		Mockito.doNothing().when(utileriaValidador).validarFormato(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		coppelService.validarDatosObligatoriosConsulta("1234567890", "XXXX123456HXXXXX09", "12345678901", "01", "01:00");
	}
	
	@Test(expected=BusinessException.class)
	public void testValidarDatosObligatoriosConsultaExcepcionCurpNss() {
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE,Boolean.TRUE);
		Mockito.doNothing().when(utileriaValidador).validarFormato(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		coppelService.validarDatosObligatoriosConsulta("1234567890", "XXXX123456HXXXXX09", "12345678901", "01", "01:00");
	}

}
