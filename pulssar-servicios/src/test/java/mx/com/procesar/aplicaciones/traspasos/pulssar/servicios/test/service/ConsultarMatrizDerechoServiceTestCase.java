/**
 * ConsultarMatrizDerechoServiceTestCase.java
 * Fecha de creación: Sep 17, 2020 9:46:46 AM
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarMatrizDerechoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseSalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class ConsultarMatrizDerechoServiceTestCase {

	/**
	 * Atributo consultarMatrizDerechoService
	 */
	@InjectMocks
	private ConsultarMatrizDerechoService consultarMatrizDerechoService = new ConsultarMatrizDerechoServiceImpl();

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
	 * Valida que exista la matriz de derechos por tipo retiro y tipo de prestacion
	 */
	@Test
	public void testValidarMatrizDerechos() {
		ReflectionTestUtils.setField(consultarMatrizDerechoService, "url",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseSalidaGenerica<MatrizDerecho> body = new BaseSalidaGenerica<>();
		ResponseEntity<BaseSalidaGenerica<MatrizDerecho>> value = new ResponseEntity<BaseSalidaGenerica<MatrizDerecho>>(
				body, HttpStatus.OK);
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.eq(HttpEntity.EMPTY),
						Mockito.eq(new ParameterizedTypeReference<BaseSalidaGenerica<MatrizDerecho>>() {
						}), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(value);

		consultarMatrizDerechoService.validarMatrizDerechos("tipoRetiro", "tipoPrestacion");
	}
	
	
}
