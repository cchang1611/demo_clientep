/**
 * ConsultarBancoAforeServiceTestCase.java
 * Fecha de creaci�n: Dec 4, 2020 7:25:13 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarBancoAforeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarBancoAforeServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BancoAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;

/**
 * Clase para
 *
 * @author Williams Alejandro Mart�nez (walejand)
 * @version 1.0
 */
public class ConsultarBancoAforeServiceTestCase {

	/**
	 * Atributo consultarBancoAforeService
	 */
	@InjectMocks
	private ConsultarBancoAforeService consultarBancoAforeService = new ConsultarBancoAforeServiceImpl();

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
	 * testConsultaClaveAfore
	 */
	@Test
	public void testConsultaClaveAfore() {
		ReflectionTestUtils.setField(consultarBancoAforeService, "urlConsultaBancoAfore",
				"http://lbint-devl.procesar.net/comunesPulssar/obtenerBanco/{0}");
		BaseRespuesta<BancoAfore> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<BancoAfore>> value = new ResponseEntity<BaseRespuesta<BancoAfore>>(body,
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.any(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<BancoAfore>>() {
				}))).thenReturn(value);
		consultarBancoAforeService.consultaClaveAfore("cvAfore");
	}
	
	/**
	 * testConsultaClaveAfore
	 */
	@Test
	public void testConsultaClaveAforeError() {
		ReflectionTestUtils.setField(consultarBancoAforeService, "urlConsultaBancoAfore",
				"http://lbint-devl.procesar.net/comunesPulssar/obtenerBanco/{0}");
		ResponseEntity<BaseRespuesta<BancoAfore>> value = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.any(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<BancoAfore>>() {
				}))).thenReturn(value);
		consultarBancoAforeService.consultaClaveAfore("cvAfore");
	}
}
