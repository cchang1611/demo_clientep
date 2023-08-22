/**
 * ResarcimientoServiceTestCase.java
 * Fecha de creación: Sep 14, 2020 11:27:41 AM
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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ResarcimientoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArregloRespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.FechaUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class ResarcimientoServiceTestCase {

	/**
	 * Atributo resarcimientoService
	 */
	@InjectMocks
	private ResarcimientoService resarcimientoService = new ResarcimientoServiceImpl();

	/**
	 * utilidades de fechas
	 */
	@InjectMocks
	private FechaUtils fechaUtils;

	/**
	 * Inyeccion de Utileria
	 */
	@Spy
	private ValidadorUtils utileriaValidador = new ValidadorUtilsImpl();

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
		fechaUtils = Mockito.spy(new FechaUtilsImpl());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Consulta de historicos
	 */
	@Test
	public void testObtenerResarcimiento() {
		ReflectionTestUtils.setField(resarcimientoService, "urlHistoricosRetiro",
				"http://localhost:7002/comunesPulssar/resarcimiento/nss/{nss}/afore/{claveAfore}");

		ArregloRespuestaHistoricoRetiros value = new ArregloRespuestaHistoricoRetiros();
		RespuestaHistoricoRetiros arg0 = new RespuestaHistoricoRetiros();
		arg0.setFechaRetiroReintegro("2020149");
		value.getLayoutRespuestaHistoricoRetiros().add(arg0);
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ArregloRespuestaHistoricoRetiros.class)))
				.thenReturn(value);
		resarcimientoService.obtenerResarcimiento("nss", "claveAfore");
	}
	
	/**
	 * Consulta de historicos
	 */
	@Test
	public void testObtenerResarcimientoSinFecha() {
		ReflectionTestUtils.setField(resarcimientoService, "urlHistoricosRetiro",
				"http://localhost:7002/comunesPulssar/resarcimiento/nss/{nss}/afore/{claveAfore}");

		ArregloRespuestaHistoricoRetiros value = new ArregloRespuestaHistoricoRetiros();
		RespuestaHistoricoRetiros arg0 = new RespuestaHistoricoRetiros();
		arg0.setFechaRetiroReintegro(null);
		value.getLayoutRespuestaHistoricoRetiros().add(arg0);
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ArregloRespuestaHistoricoRetiros.class)))
				.thenReturn(value);
		resarcimientoService.obtenerResarcimiento("nss", "claveAfore");
	}

	/**
	 * obtiene el calculo del monto a reintegrar
	 */
	@Test
	public void testObtenerCalculoMontoReintegrar() {
		ReflectionTestUtils.setField(resarcimientoService, "urlCalculoMontoIntegrar",
				"http://localhost:7002/comunesPulssar/resarcimiento/nss/{nss}/afore/{claveAfore}");
		BaseRespuesta<RespuestaMontoReintegrar> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<RespuestaMontoReintegrar>> value = new ResponseEntity<BaseRespuesta<RespuestaMontoReintegrar>>(
				body, HttpStatus.OK);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<CalculoMontoReintegrar>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<RespuestaMontoReintegrar>>() {
				}))).thenReturn(value);
		CalculoMontoReintegrar entrada = new CalculoMontoReintegrar();
		resarcimientoService.obtenerCalculoMontoReintegrar(entrada);
	}

	/**
	 * obtiene el calculo del monto a reintegrar
	 */
	@Test
	public void testObtenerCalculoMontoReintegrarError() {
		ReflectionTestUtils.setField(resarcimientoService, "urlCalculoMontoIntegrar",
				"http://localhost:7002/comunesPulssar/resarcimiento/nss/{nss}/afore/{claveAfore}");
		ResponseEntity<BaseRespuesta<RespuestaMontoReintegrar>> value = new ResponseEntity<BaseRespuesta<RespuestaMontoReintegrar>>(
				HttpStatus.OK);

		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<CalculoMontoReintegrar>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<RespuestaMontoReintegrar>>() {
				}))).thenReturn(value);
		CalculoMontoReintegrar entrada = new CalculoMontoReintegrar();
		resarcimientoService.obtenerCalculoMontoReintegrar(entrada);
	}
}
