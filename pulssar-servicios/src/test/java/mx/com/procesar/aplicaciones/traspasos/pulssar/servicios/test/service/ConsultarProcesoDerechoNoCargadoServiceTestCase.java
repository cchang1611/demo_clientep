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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargadoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoNoCargadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarProcesoDerechoNoCargadoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * 
 * Test Case Servicio ConsultarProcesoDerechoNoCargado
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 10, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarServiceApplicationContextTest.class,
									PulssarPersistenceApplicationContextTest.class,
									PulssarCorreoAplicationContextTest.class})
public class ConsultarProcesoDerechoNoCargadoServiceTestCase {

	@Autowired
	@InjectMocks
	private ConsultarProcesoDerechoNoCargadoService noCargadoService = new ConsultarProcesoDerechoNoCargadoServiceImpl();

	/**
	 * Inyeccion Mock restService
	 */
	@Mock 
	private RestTemplate restService;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * 
	 *  Test ConsultarDerechoNoCargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarDerechoNoCargado() {
		List<ProcesoDerechoCargadoSalida> listaCargado = new ArrayList<>();
		ProcesoDerechoNoCargado entradaDatos = new ProcesoDerechoNoCargado();
		entradaDatos.setPrimerTipoRetiro("1");
		try {
			Mockito.when(restService.postForObject(Mockito.anyString(),Mockito.any(ProcesoDerechoNoCargado.class), Mockito.eq(List.class))).thenReturn(listaCargado);
			List<ProcesoDerechoCargadoSalida> respuesta = noCargadoService.consultarDerechoNoCargado(entradaDatos);
			assertNotNull(respuesta);
		}catch (Exception e) {
			assertNotNull(e);
		}
	}
	
}
