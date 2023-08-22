/**
 * SolicitudReintegroServiceTestCase.java
 * Fecha de creación: Sep 11, 2020 5:59:59 PM
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarBancoAforeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarBancoAforeServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.SolicitudReintegroServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BancoAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GenerarLineaCapturaPdf;
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
public class SolicitudReintegroServiceTestCase {

	/**
	 * Atributo solicitudReintegroService
	 */
	@InjectMocks
	private SolicitudReintegroService solicitudReintegroService = new SolicitudReintegroServiceImpl();

	/**
	 * Atributo consultarBancoAforeService
	 */
	@InjectMocks
	private ConsultarBancoAforeService consultarBancoAforeService;

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
		consultarBancoAforeService = Mockito.spy(new ConsultarBancoAforeServiceImpl());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Generar solicitud de reintegro
	 */
	@Test
	public void testGuardarSolicitud() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlGuardarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseRespuesta<SolicitudReintegroEntrada> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				body, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<SolicitudReintegroEntrada>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		SolicitudReintegroEntrada entrada = new SolicitudReintegroEntrada();
		solicitudReintegroService.guardarSolicitud(entrada);
	}

	/**
	 * Generar solicitud de reintegro
	 */
	@Test
	public void testGuardarSolicitudError() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlGuardarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<SolicitudReintegroEntrada>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		SolicitudReintegroEntrada entrada = new SolicitudReintegroEntrada();
		solicitudReintegroService.guardarSolicitud(entrada);
	}

	/**
	 * Generar solicitud de reintegro
	 */
	@Test
	public void testGuardarSolicitudResarcimiento() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlGuardarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseRespuesta<SolicitudReintegroEntrada> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				body, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<SolicitudReintegroEntrada>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		RespuestaMontoReintegrar montoReintegrar = new RespuestaMontoReintegrar();
		montoReintegrar.setMontoReintegrar(new Double(1));
		montoReintegrar.setNumeroResolucion("value");
		montoReintegrar.setFechaRetiro(new Date());
		montoReintegrar.setNumeroSemanasReintegrar("456");
		entrada.setMontoReintegrar(montoReintegrar);
		DatosTrabajador trabajador = new DatosTrabajador();
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		trabajador.setFolio(folio);
		trabajador.setNss("nss");
		Renapo renapo = new Renapo();
		renapo.setApellidoMaterno("apellidoMaterno");
		renapo.setApellidoPaterno("apellidoPaterno");
		renapo.setCurp("curp");
		renapo.setNombre("nombre");
		trabajador.setRenapo(renapo);
		entrada.setTrabajador(trabajador);

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);

		solicitudReintegroService.guardarSolicitud(entrada);
	}

	/**
	 * Generar solicitud de reintegro
	 */
	@Test
	public void testGuardarSolicitudResarcimientoError() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlGuardarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<SolicitudReintegroEntrada>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		RespuestaMontoReintegrar montoReintegrar = new RespuestaMontoReintegrar();
		montoReintegrar.setMontoReintegrar(new Double(1));
		montoReintegrar.setNumeroResolucion("value");
		montoReintegrar.setFechaRetiro(new Date());
		montoReintegrar.setNumeroSemanasReintegrar("456");
		entrada.setMontoReintegrar(montoReintegrar);
		DatosTrabajador trabajador = new DatosTrabajador();
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		trabajador.setFolio(folio);
		trabajador.setNss("nss");
		Renapo renapo = new Renapo();
		renapo.setApellidoMaterno("apellidoMaterno");
		renapo.setApellidoPaterno("apellidoPaterno");
		renapo.setCurp("curp");
		renapo.setNombre("nombre");
		trabajador.setRenapo(renapo);
		entrada.setTrabajador(trabajador);

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);

		solicitudReintegroService.guardarSolicitud(entrada);
	}

	/**
	 * Generar pdf en base a la informacion capturada
	 */
	@Test
	public void testGenerarDatosReferencia() {
		ReflectionTestUtils.setField(consultarBancoAforeService, "urlConsultaBancoAfore",
				"http://localhost:7002/comunesPulssar/obtenerBanco/{0}");
		BancoAfore objetoRespuesta = new BancoAfore();
		objetoRespuesta.setClabe("clabe");
		objetoRespuesta.setCuentaBancaria("cuentaBancaria");
		objetoRespuesta.setNombreBanco("nombreBanco");
		BaseRespuesta<BancoAfore> bodyCatalogo = new BaseRespuesta<BancoAfore>("diagnosticoDeRecepcion",
				"resultadoDeLaOperacion", objetoRespuesta);
		ResponseEntity<BaseRespuesta<BancoAfore>> valueCatalogo = new ResponseEntity<BaseRespuesta<BancoAfore>>(
				bodyCatalogo, HttpStatus.OK);
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.<HttpEntity<Void>>any(),
						Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<BancoAfore>>() {
						})))
				.thenReturn(valueCatalogo);

		ReflectionTestUtils.setField(solicitudReintegroService, "urlGenerarLineaCaptura",
				"http://localhost:7002/comunesPulssar/obtenerBanco/{0}");
		BaseRespuesta<String> body = new BaseRespuesta<>();
		body.setObjetoRespuesta("123456");
		ResponseEntity<BaseRespuesta<String>> value = new ResponseEntity<BaseRespuesta<String>>(body, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<GenerarLineaCapturaPdf>>any(), Mockito.eq(new BaseRespuesta<String>().getType())))
				.thenReturn(value);

		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		RespuestaMontoReintegrar montoReintegrar = new RespuestaMontoReintegrar();
		montoReintegrar.setMontoReintegrar(new Double(1));
		montoReintegrar.setNumeroResolucion("value");
		montoReintegrar.setFechaRetiro(new Date());
		montoReintegrar.setNumeroSemanasReintegrar("456");
		entrada.setMontoReintegrar(montoReintegrar);
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setClaveAfore("518");
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		trabajador.setFolio(folio);
		trabajador.setNss("nss");
		Renapo renapo = new Renapo();
		renapo.setApellidoMaterno("apellidoMaterno");
		renapo.setApellidoPaterno("apellidoPaterno");
		renapo.setCurp("curp");
		renapo.setNombre("nombre");
		trabajador.setRenapo(renapo);
		entrada.setTrabajador(trabajador);

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);
		solicitudReintegroService.generarDatosReferencia(entrada);
	}

	/**
	 * Generar pdf en base a la informacion capturada
	 */
	@Test
	public void testGenerarDatosReferenciaError() {
		ReflectionTestUtils.setField(consultarBancoAforeService, "urlConsultaBancoAfore",
				"http://localhost:7002/comunesPulssar/obtenerBanco/{0}");
		BancoAfore objetoRespuesta = new BancoAfore();
		objetoRespuesta.setClabe("clabe");
		objetoRespuesta.setCuentaBancaria("cuentaBancaria");
		objetoRespuesta.setNombreBanco("nombreBanco");
		BaseRespuesta<BancoAfore> bodyCatalogo = new BaseRespuesta<BancoAfore>("diagnosticoDeRecepcion",
				"resultadoDeLaOperacion", objetoRespuesta);
		ResponseEntity<BaseRespuesta<BancoAfore>> valueCatalogo = new ResponseEntity<BaseRespuesta<BancoAfore>>(
				bodyCatalogo, HttpStatus.OK);
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.<HttpEntity<Void>>any(),
						Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<BancoAfore>>() {
						})))
				.thenReturn(valueCatalogo);

		ReflectionTestUtils.setField(solicitudReintegroService, "urlGenerarLineaCaptura",
				"http://localhost:7002/comunesPulssar/obtenerBanco/{0}");
		BaseRespuesta<String> body = new BaseRespuesta<>();
		body.setObjetoRespuesta("123456");
		ResponseEntity<BaseRespuesta<String>> value = new ResponseEntity<BaseRespuesta<String>>(HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
				Mockito.<HttpEntity<GenerarLineaCapturaPdf>>any(), Mockito.eq(new BaseRespuesta<String>().getType())))
				.thenReturn(value);

		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		RespuestaMontoReintegrar montoReintegrar = new RespuestaMontoReintegrar();
		montoReintegrar.setMontoReintegrar(new Double(1));
		montoReintegrar.setNumeroResolucion("value");
		montoReintegrar.setFechaRetiro(new Date());
		montoReintegrar.setNumeroSemanasReintegrar("456");
		entrada.setMontoReintegrar(montoReintegrar);
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setClaveAfore("518");
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		trabajador.setFolio(folio);
		trabajador.setNss("nss");
		Renapo renapo = new Renapo();
		renapo.setApellidoMaterno("apellidoMaterno");
		renapo.setApellidoPaterno("apellidoPaterno");
		renapo.setCurp("curp");
		renapo.setNombre("nombre");
		trabajador.setRenapo(renapo);
		entrada.setTrabajador(trabajador);

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);
		solicitudReintegroService.generarDatosReferencia(entrada);
	}

	/**
	 * Buscar solicitudes reintegro
	 */
	@Test
	public void testBuscarSolicitudes() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlBuscarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseRespuesta<List<SolicitudReintegroEntrada>> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>> value = new ResponseEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>>(
				body, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<List<SolicitudReintegroEntrada>>>() {
				}))).thenReturn(value);

		solicitudReintegroService.buscarSolicitudes("entrada");
	}

	/**
	 * Buscar solicitudes por numero de resolucion y reintegro
	 */
	@Test
	public void testBuscarSolicitudesReintegro() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlBuscarSolicitudReintegroResolucion",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		BaseRespuesta<SolicitudReintegroEntrada> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				body, HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		solicitudReintegroService.buscarSolicitudes("numeroReintegro", "numeroResolucion");
	}

	/**
	 * Buscar solicitudes reintegro
	 */
	@Test(expected = NullPointerException.class)
	public void testBuscarSolicitudesError() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlBuscarSolicitud",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		ResponseEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>> value = new ResponseEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>>(
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<List<SolicitudReintegroEntrada>>>() {
				}))).thenReturn(value);

		solicitudReintegroService.buscarSolicitudes("entrada");
	}

	/**
	 * Buscar solicitudes por numero de resolucion y reintegro
	 */
	@Test(expected = NullPointerException.class)
	public void testBuscarSolicitudesReintegroError() {
		ReflectionTestUtils.setField(solicitudReintegroService, "urlBuscarSolicitudReintegroResolucion",
				"http://localhost:7002/comunesPulssar/reintegro/buscarSolicitudes/numeroReintegro/{numeroReintegro}/numeroResolucion/{numeroResolucion}");

		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> value = new ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>>(
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
				Mockito.<HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>>>any(),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				}))).thenReturn(value);

		solicitudReintegroService.buscarSolicitudes("numeroReintegro", "numeroResolucion");
	}
}
