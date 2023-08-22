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
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoImmsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerechoProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 *  Test Case Consulta Matriz Derecho
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 20, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarMatrizDerechoImmsServiceTestCase {

	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	private ConsultarMatrizDerechoImmsService consultarMatrizDerechoImmsService;
	
	/**
	 * RestTemplate para los servicios
	 */
	@Mock
	private RestTemplate restTemplate;

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
	 *  Test Consultar Matriz Derecho 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarMatrizDerecho() {
		MatrizDerecho respuesta =new MatrizDerecho();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(MatrizDerecho.class))).thenReturn(respuesta);
		respuesta = consultarMatrizDerechoImmsService.consultarMatrizDerecho("73", "AB", "IV", "CC", "CT");
		assertNotNull(respuesta);
	}
	
	
	/**
	 *  Tes consulta matriz derecho proceso 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarMatrizDerechoProceso(){
		List<MatrizDerechoProceso> respuesta =new ArrayList<>();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(List.class))).thenReturn(respuesta);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(List.class))).thenReturn(Boolean.FALSE);
		respuesta = consultarMatrizDerechoImmsService.consultarMatrizDerechoProceso(1l);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test consulta matriz derecho proceso Nulo
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test(expected=BusinessException.class)
	public void testConsultarMatrizDerechoProcesoNulo(){
		List<MatrizDerechoProceso> respuesta =new ArrayList<>();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(List.class))).thenReturn(respuesta);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(List.class))).thenReturn(Boolean.TRUE);
		consultarMatrizDerechoImmsService.consultarMatrizDerechoProceso(1l);
		
	}
}
