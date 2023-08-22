/**
 * NotificacionReintegroServiceTestCase.java
 * Fecha de creación: Sep 8, 2020 8:22:14 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NotificacionReintegroServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class NotificacionReintegroServiceTestCase extends TestCase {

	/**
	 * Atributo notificacionReintegroService
	 */
	@InjectMocks
	private NotificacionReintegroService notificacionReintegroService = new NotificacionReintegroServiceImpl();

	/**
	 * RestTemplate para los servicios
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Notificacion solicitud reintegro
	 */
	@Test
	public void testNotificarReintegro() {
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		Renapo renapo = new Renapo();
		renapo.setApellidoMaterno("apellidoMaterno");
		renapo.setApellidoPaterno("apellidoPaterno");
		renapo.setCurp("curp");
		renapo.setNombre("nombre");
		trabajador.setRenapo(renapo);
		trabajador.setNss("nss");
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		trabajador.setFolio(folio);
		entrada.setTrabajador(trabajador);
		RespuestaMontoReintegrar montoReintegrar = new RespuestaMontoReintegrar();
		montoReintegrar.setFechaRetiro(new Date());
		montoReintegrar.setMontoReintegrar(new Double(10));
		montoReintegrar.setNumeroResolucion("15");
		montoReintegrar.setNumeroSemanasReintegrar("10");
		entrada.setMontoReintegrar(montoReintegrar);
		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("15");
		respuestaHistorico.setValorDiaReintegrar("456");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);
		notificacionReintegroService.notificarReintegro(entrada);
	}

	/**
	 * Notificacion solicitud reintegro
	 */
	@Test
	public void testNotificarReintegroNotificar() {
		notificacionReintegroService.notificarReintegro(new NotificacionReintegro());
	}

	/**
	 * Busca notificaciones por numero de reintegro y numero de resolucion
	 */
	@Test
	public void testBuscarNotificacion() {
		ReflectionTestUtils.setField(notificacionReintegroService, "urlBuscarNotificacioneReintegroResolucion",
				"http://localhost:7007/comunesPulssar-exposicion-notificacion/notificacionReintegro/buscarNotificaciones/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseRespuesta<NotificacionReintegro> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<NotificacionReintegro>> value = new ResponseEntity<BaseRespuesta<NotificacionReintegro>>(
				body, HttpStatus.OK);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<NotificacionReintegro>>() {
				}))).thenReturn(value);

		notificacionReintegroService.buscarNotificacion("", "");
	}

	/**
	 * Busca notificaciones por numero de reintegro y numero de resolucion
	 */
	@Test
	public void testBuscarNotificacionError() {
		ReflectionTestUtils.setField(notificacionReintegroService, "urlBuscarNotificacioneReintegroResolucion",
				"http://localhost:7007/comunesPulssar-exposicion-notificacion/notificacionReintegro/buscarNotificaciones/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		ResponseEntity<BaseRespuesta<NotificacionReintegro>> value = new ResponseEntity<BaseRespuesta<NotificacionReintegro>>(
				HttpStatus.OK);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<NotificacionReintegro>>() {
				}))).thenReturn(value);

		notificacionReintegroService.buscarNotificacion("", "");
	}

}
