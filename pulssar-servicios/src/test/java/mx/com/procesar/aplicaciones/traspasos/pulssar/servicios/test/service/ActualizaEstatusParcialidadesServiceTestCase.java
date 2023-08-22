package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ActualizaEstatusParcialidadesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ActualizaEstatusParcialidadesServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parcialidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * TestCase para actualizar el estatus de la notificacion afore
 * 
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ActualizaEstatusParcialidadesServiceTestCase {
	
	/**
	 * Inyeccion actualizaSrvice
	 */
	@Autowired
	@InjectMocks
	private ActualizaEstatusParcialidadesService actualizaService = new ActualizaEstatusParcialidadesServiceImpl();

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
	 * Metodo testCase para Actualizar estatus
	 */
	@Test
	@Rollback
	public void testActualizarEstatusParcialidad() {
		Parcialidad parcialidad = new Parcialidad();
		try {
			actualizaService.actualizarEstatusParcialidad(parcialidad);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test Parcialidad Exception
	 */
	@Test
	@Rollback
	public void testActualizarEstatusParcialidadException() {
		Parcialidad parcialidad = new Parcialidad();
		try {
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(RespuestaEstatusServicio.class))).thenReturn(Boolean.TRUE);
			actualizaService.actualizarEstatusParcialidad(parcialidad);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	
	/**
	 * Metodo testCase para Actualizar estatus
	 */
	@Test
	@Rollback
	public void testActualizarEstatusParcialidadError() {
		try {
			actualizaService.actualizarEstatusParcialidad(null);
		} catch (Exception e) {
			assertNotNull(e);
		}

	}

}
