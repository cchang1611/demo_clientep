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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.EstatusExpedienteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExpedienteDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Mock para servicio de EstatusExpedienteService
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class EstatusExpeServiceMockTestCase {

	
	/**
	 * Inyeccion Servicio
	 */
	@Autowired
	@InjectMocks
	private EstatusExpedienteService expedienteService = new EstatusExpedienteServiceImpl();

	
	/**
	 * Rest Template
	 */
	@Autowired
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inicializa initMocks
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test encargado de validar expediente tipo solicitante
	 */
	@Test
	public void testValidarRestExpedienteTipoSolicitante() {
		ExpedienteSalida salidaExp = new ExpedienteSalida();
		SalidaGenerica salidaGenerica = new SalidaGenerica();
		salidaGenerica.setResponse(salidaExp);
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(SalidaGenerica.class))).thenReturn(salidaGenerica);
		expedienteService.validarRestExpedienteTipoSolicitante("curp", "tiposolicitante");
	}
	
	/**
	 * test consulta expediente solicitud
	 */
	@Test
	public void testConsultaExpedienteSolicitud() {
		ExpedienteDetail expedienteDetalle = new ExpedienteDetail();
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ExpedienteDetail.class))).thenReturn(expedienteDetalle);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		expedienteService.consultaExpedienteSolicitud("cvTipoProceso", "cvServicio", "cvAfore", "curpTrabajador", "cvEstatusExpe");
		
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ExpedienteDetail.class))).thenReturn(null);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.consultaExpedienteSolicitud("cvTipoProceso", "cvServicio", "cvAfore", "curpTrabajador", "cvEstatusExpe");
		
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ExpedienteDetail.class))).thenThrow(new RuntimeException());
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.consultaExpedienteSolicitud("cvTipoProceso", "cvServicio", "cvAfore", "curpTrabajador", "cvEstatusExpe");
	}
	
	/**
	 * Metodo encargado de buscar expedeinte serv
	 */
	@Test
	public void testBuscarExpendienteServ(){
		RespuestaExpedienteDetalle expedienteDetalle = new RespuestaExpedienteDetalle();
		List<RespuestaExpedienteDetalle> listaExpeDetalle = new ArrayList<>();
		listaExpeDetalle.add(expedienteDetalle);
		ResponseEntity<List<RespuestaExpedienteDetalle>> respuestaNotificacion = new ResponseEntity<>(listaExpeDetalle, HttpStatus.ACCEPTED);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<RespuestaExpedienteDetalle>>() {}))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		expedienteService.buscarExpendienteServ(1L);
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<RespuestaExpedienteDetalle>>() {}))).thenReturn(null);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.buscarExpendienteServ(1L);
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<RespuestaExpedienteDetalle>>() {}))).thenThrow(new RuntimeException());
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.buscarExpendienteServ(1L);		
	}
	
	/**
	 * test para servicio que busca expediente
	 */
	@Test
	public void testBuscarExpediente() {
		ExpedienteDetail expedienteDetalle = new ExpedienteDetail();
		
		List<ExpedienteDetail> listaExpeDetalle = new ArrayList<>();
		listaExpeDetalle.add(expedienteDetalle);
		ResponseEntity<List<ExpedienteDetail>> respuestaNotificacion = new ResponseEntity<>(listaExpeDetalle, HttpStatus.ACCEPTED);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<ExpedienteDetail>>() {}))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		expedienteService.buscarExpediente("curp", "chFolio", "chAfore", "nuEstatus", "cvTipoProceso");
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<ExpedienteDetail>>() {}))).thenReturn(null);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.buscarExpediente("curp", "chFolio", "chAfore", "nuEstatus", "cvTipoProceso");
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class) ,Mockito.eq(new ParameterizedTypeReference<List<ExpedienteDetail>>() {}))).thenThrow(new RuntimeException());
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		expedienteService.buscarExpediente("curp", "chFolio", "chAfore", "nuEstatus", "cvTipoProceso");
	}

}
