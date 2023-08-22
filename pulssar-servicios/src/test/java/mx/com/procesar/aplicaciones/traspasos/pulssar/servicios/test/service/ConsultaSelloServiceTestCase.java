package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultaSelloServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloVirtualEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultaSelloServiceTestCase {

	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private ConsultaSelloService serviceSello = new ConsultaSelloServiceImpl();
	
	
	/**
	 * Inyeccion de ValidadorUtils
	 */
	@Mock
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion de RestTemplate
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
	 * service obtener sello trabajador
	 */
	@Test(expected=BusinessException.class)
	public void testObtenerSelloTrabajador() {
		VerificacionSello sello = new VerificacionSello();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		serviceSello.obtenerSelloTrabajador("curpEmpl", "curpTr", "556");
		
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		serviceSello.obtenerSelloTrabajador("curpEmpl", "curpTr", "556");
	}
	
	/**
	 * Service obtener sello empleado
	 */
	@Test(expected=BusinessException.class)
	public void testObtenerSelloEmpleado() {
		VerificacionSello sello = new VerificacionSello();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		serviceSello.obtenerSelloEmpleado("curpEmpl", "556");
		
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		serviceSello.obtenerSelloEmpleado("curpEmpl", "556");
	}
	
	/**
	 * test guardar sello
	 */
	@Test
	public void testGuardarSello() {
		ResponseEntity<SelloProceso> respuestaNotificacion = new ResponseEntity<>(new SelloProceso() , HttpStatus.ACCEPTED);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(new ParameterizedTypeReference<SelloProceso>() {}))).thenReturn(respuestaNotificacion);
		serviceSello.guardarSello(1L, "56");
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(new ParameterizedTypeReference<SelloProceso>() {}))).thenThrow(new RuntimeException());
		serviceSello.guardarSello(1L, "56");
	}
	
	
	/**
	 * test consultar sello flujo modiicacion
	 */
	@Test
	public void testConsultarSelloFlujoModificacion() {
		VerificacionSello sello = new VerificacionSello();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenReturn(sello);
		serviceSello.consultarSelloFlujoModificacion("curpEmpl","curpTr", "556");
		
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(VerificacionSello.class))).thenThrow(new RuntimeException());
		serviceSello.consultarSelloFlujoModificacion("curpEmpl","curpTr", "556");
	}
	
	/**
	 * Test genera sello virtual
	 */
	@Test
	public void testGenerarSelloVirtual() {
		SelloVirtualEntrada entrada = new SelloVirtualEntrada();
		ResponseEntity<SalidaGenerica> respuestaNotificacion = new ResponseEntity<>(new SalidaGenerica(), HttpStatus.ACCEPTED);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaGenerica.class))).thenReturn(respuestaNotificacion);
		serviceSello.generarSelloVirtual(entrada);
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaGenerica.class))).thenThrow(new RuntimeException());
		serviceSello.generarSelloVirtual(entrada);
	}

}
