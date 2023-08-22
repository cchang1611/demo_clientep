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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ProcesoPendienteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramiteComparadorInformacionGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test case para service procesos pendientes
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ProcesoPendienteServiceTestCase {

	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private ProcesoPendienteService serviceProceso = new ProcesoPendienteServiceImpl();
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	@Mock
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion de dependencia validadorUtils
	 */
	@Mock
	private ValidadorUtils validadorUtils;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * test insertar proceso pendiente
	 */
	@Test
	public void testInsertarProcesoPendiente() {
		
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("texto" , HttpStatus.ACCEPTED);
		
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		serviceProceso.insertarProcesoPendiente(new ProcesoPendienteEntrada<>());
		
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		serviceProceso.insertarProcesoPendiente(new ProcesoPendienteEntrada<>());
	}
	
	/**
	 * test insertar proceso pendiente comparador
	 */
	@Test
	public void testInsertarProcesoPendienteComparador() {
		
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("texto" , HttpStatus.ACCEPTED);
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		serviceProceso.insertarProcesoSolicitudComparador(new TramiteComparadorInformacionGenerico<>());
		
		ResponseEntity<String> respuestaNotificacion2 = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion2);
		serviceProceso.insertarProcesoSolicitudComparador(new TramiteComparadorInformacionGenerico<>());
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(null);
		serviceProceso.insertarProcesoSolicitudComparador(new TramiteComparadorInformacionGenerico<>());
	}
	
	/**
	 * test para consultar proceso pendiente por id folio
	 * @author JMGUTIEG
	 */
	@Test
	public void testConsultaProcesoPendienteIdfolio() {
		Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(ProcesoPendiente.class))).thenReturn(new ProcesoPendiente());
		serviceProceso.consultaProcesoPendienteIdfolio("1", "2");
		
		Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(ProcesoPendiente.class))).thenThrow(new RuntimeException());
		serviceProceso.consultaProcesoPendienteIdfolio("1", "2");
	}

}
