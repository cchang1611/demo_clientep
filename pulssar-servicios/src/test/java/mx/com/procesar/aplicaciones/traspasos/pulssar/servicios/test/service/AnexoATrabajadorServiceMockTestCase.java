package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AnexoATrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.AnexoATrabajadorServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AnexoATrabajadorIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test para servicios de anexo a
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class AnexoATrabajadorServiceMockTestCase {
	
	/**
	 * Inyeccion service
	 */
	@Autowired
	@InjectMocks
	private AnexoATrabajadorService anexoService = new AnexoATrabajadorServiceImpl();

	
	/**
	 * Rest Template
	 */
	@Autowired
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * test para consulta servicio consulta anexo a
	 */
	@Test
	public void testConsultaAnexoTrabajador() {
		AnexoATrabajadorIssste anexo = new AnexoATrabajadorIssste();
		List<AnexoATrabajadorIssste> listaAnexo = new ArrayList<>();
		listaAnexo.add(anexo);
		ResponseEntity<List<AnexoATrabajadorIssste>> respuestaEntity = new ResponseEntity<>(listaAnexo,HttpStatus.ACCEPTED);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<List<AnexoATrabajadorIssste>>() {}))).thenReturn(respuestaEntity);
		anexoService.consultaAnexoTrabajador("curp");
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<List<AnexoATrabajadorIssste>>() {}))).thenReturn(null);
		anexoService.consultaAnexoTrabajador("curp");
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<List<AnexoATrabajadorIssste>>() {}))).thenThrow(new RuntimeException());
		anexoService.consultaAnexoTrabajador("curp");
	}

}
