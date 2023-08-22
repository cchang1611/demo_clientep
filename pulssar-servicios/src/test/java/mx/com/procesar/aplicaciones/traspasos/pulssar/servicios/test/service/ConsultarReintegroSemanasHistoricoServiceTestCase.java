package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasHistoricoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarReintegroSemanasHistoricoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * TestCase Consulta Historico
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarReintegroSemanasHistoricoServiceTestCase {
    
	/**
	 * Servicio
	 */
	@Autowired
	@InjectMocks
	private ConsultarReintegroSemanasHistoricoService historicoService = new ConsultarReintegroSemanasHistoricoServiceImpl();
	
	
	/**
	 * Inyeccion Mock restService
	 */
	@Mock 
	private RestTemplate restService;
	
	/**
	 * Inyeccion Mock restService
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test Consultaa Historico
	 */
	@Test
	public void testConsultarHistorico() {
		ReflectionTestUtils.setField(historicoService, "urlConsultaReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/historico");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setOrigen(new BigInteger("1"));
		ConsultaHistoricoSalida histosalida =new ConsultaHistoricoSalida();
		ResponseEntity<ConsultaHistoricoSalida> respuestaSalida = new ResponseEntity<ConsultaHistoricoSalida>(histosalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(ConsultaHistoricoSalida.class))).thenReturn(respuestaSalida);
			histosalida = historicoService.consultarHistorico(trabajador);
			assertNotNull(histosalida);
		}catch (Exception e) {
			assertNotNull(e);
		}
		
	}
	
	/**
	 * Test ConsultarHistorico Nulo 
	 */
	@Test
	public void testConsultarHistoricoNulo() {
		ReflectionTestUtils.setField(historicoService, "urlConsultaReintegroRecursos", "http://172.21.66.90/retirosint/v1/786/reintegrosemanasimss/historico");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setOrigen(new BigInteger("1"));
		ConsultaHistoricoSalida histosalida =new ConsultaHistoricoSalida();
		ResponseEntity<ConsultaHistoricoSalida> respuestaSalida = new ResponseEntity<ConsultaHistoricoSalida>(histosalida, HttpStatus.ACCEPTED);
		try {
			Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.eq(ConsultaHistoricoSalida.class))).thenReturn(respuestaSalida);
			Mockito.when(utileriaValidador.isEmpty(Mockito.any(ConsultaHistoricoSalida.class))).thenReturn(Boolean.TRUE);
			histosalida = historicoService.consultarHistorico(trabajador);
			assertNotNull(histosalida);
		}catch (Exception e) {
			assertNotNull(e);
		}
		
	}
	
	
}
