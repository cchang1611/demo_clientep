package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import org.jfree.util.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RetiroParcialCalculoImssList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarPagoParcialidadServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase testCase para consultar las parcialidades
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarPagoParcialidadServiceTestCase {

	/**
	 * Inyeccion de Servicio
	 */
	@Autowired
	private ConsultarPagoParcialidadService consultaParcialidades = new ConsultarPagoParcialidadServiceImpl();
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(consultaParcialidades, "urlConsultaPagoParcialidad", "http://lbint-devl.procesar.net/comunesPulssar/retiro/pagos/parcialRetiro/{idProcesar}");
		
	}
	
	/**
	 * Metodo tesCase que consulta las parcialidades
	 */
	@Test 
	public void testConsultarPagoParcialidades() {
		RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
		try {
			listaPagoParcialidades = consultaParcialidades.consultarPagoParcialidades("63");
			assertNotNull(listaPagoParcialidades);
		}catch (Exception e) {
			Log.error("Error Parcialidad:{}",e);
		}
	}
	
	/**
	 * Metodo tesCase que consulta las parcialidades excepcion
	 */
	@Test 
	public void testConsultarPagoParcialidadesExcepcion() {
		RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
	 		try {
			listaPagoParcialidades = consultaParcialidades.consultarPagoParcialidades("3");
			assertNotNull(listaPagoParcialidades);
		}catch (Exception e) {
			Log.error("Error Exception:{}",e);
		}
	}
	
	/**
	 * Test consulta Parcialidades: No existen pagos por Parcialidades
	 */
	@Test 
	public void testConsultarPagoParcialidadesNulo() {
		RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
	 		try {
			listaPagoParcialidades = consultaParcialidades.consultarPagoParcialidades("1");
			assertNotNull(listaPagoParcialidades);
		}catch (Exception e) {
			Log.error("Error Nulo:{}",e);
		}
	}
}
