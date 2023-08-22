/**
 * MatrimonioLineaServiceTestCase.java
 * Fecha de creación: Sep 15, 2020 10:55:26 AM
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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.MatrimonioLineaServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrimonioLinea;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class MatrimonioLineaServiceTestCase {

	/**
	 * Atributo matrimonioLineaService
	 */
	@InjectMocks
	private MatrimonioLineaService matrimonioLineaService = new MatrimonioLineaServiceImpl();

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
	 * Buscar Tramites de Matrimonio
	 */
	@Test
	public void testBuscarTramitesMatrimonio() {
		ReflectionTestUtils.setField(matrimonioLineaService, "url",
				"http://localhost:7002/comunesPulssar/catalogo/consultarDocumentosRequeridos/{0}");
		
		MatrimonioLinea value = new MatrimonioLinea();
		Mockito.when(
				restTemplate.getForObject(Mockito.anyString(), Mockito.eq(MatrimonioLinea.class), Mockito.anyString()))
				.thenReturn(value);
		matrimonioLineaService.buscarTramitesMatrimonio("nss");
	}
}
