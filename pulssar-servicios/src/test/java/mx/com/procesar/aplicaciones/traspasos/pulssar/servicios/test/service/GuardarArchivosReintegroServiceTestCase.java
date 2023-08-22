/**
 * GuardarArchivosReintegroServiceTestCase.java
 * Fecha de creación: Sep 14, 2020 12:17:15 PM
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarArchivosReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.GuardarArchivosReintegroServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentosRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class GuardarArchivosReintegroServiceTestCase {

	/**
	 * Atributo guardarArchivosReintegroService
	 */
	@InjectMocks
	private GuardarArchivosReintegroService guardarArchivosReintegroService = new GuardarArchivosReintegroServiceImpl();

	/**
	 * RestTemplate para los servicios
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * Atributo compresorUtils
	 */
	@Spy
	private CompresorUtils compresorUtils;

	/**
	 * Catalogo service
	 */
	@InjectMocks
	private CatalogoService catalogoService;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		catalogoService = Mockito.spy(new CatalogoServiceImpl());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Consulta documentos requeridos
	 */
	@Test
	public void testConsultarDocumentosRequeridos() {
		ReflectionTestUtils.setField(catalogoService, "consultaDocumentosRequeridos",
				"http://localhost:7002/comunesPulssar/catalogo/consultarDocumentosRequeridos/{0}");

		BaseRespuesta<List<DocumentosRequerido>> body = new BaseRespuesta<>();
		List<DocumentosRequerido> objetoRespuesta = new ArrayList<>();
		DocumentosRequerido e = new DocumentosRequerido();
		e.setNuObligatorio(1);
		objetoRespuesta.add(e);
		DocumentosRequerido a = new DocumentosRequerido();
		a.setNuObligatorio(0);
		objetoRespuesta.add(a );
		body.setObjetoRespuesta(objetoRespuesta);
		ResponseEntity<BaseRespuesta<List<DocumentosRequerido>>> value = new ResponseEntity<BaseRespuesta<List<DocumentosRequerido>>>(
				body, HttpStatus.OK);
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.<HttpEntity<Void>>any(),
						Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<List<DocumentosRequerido>>>() {
						})))
				.thenReturn(value);

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
		guardarArchivosReintegroService.consultarDocumentosRequeridos(entrada);
	}

	/**
	 * Se encarga de guardar y validar los archivos
	 */
	@Test
	public void testObtenerArchivos() {
		ReflectionTestUtils.setField(guardarArchivosReintegroService, "rutaDestino",
				"M:/Users/procesar/documentos/{0}");

		Map<String, MultipartFile> archivos = new HashMap<>();
		byte[] bytes = new byte[] { 1, 2, 3, 4 };
		MultipartFile value = new MockMultipartFile("nameFile", bytes);
		archivos.put("ABC", value);
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		List<Combo> comboObligatorios = new ArrayList<>();
		Combo e = new Combo();
		e.setClave("ABC");
		comboObligatorios.add(e);
		entrada.setComboObligatorios(comboObligatorios);

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
		trabajador.setClaveAfore("519");

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);
		guardarArchivosReintegroService.obtenerArchivos(archivos, entrada);
	}

	/**
	 * Genera mascar de archivo zip
	 */
	@Test
	public void testGenerarMascaraArchivo() {
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		List<Combo> comboObligatorios = new ArrayList<>();
		Combo e = new Combo();
		e.setClave("ABC");
		comboObligatorios.add(e);
		entrada.setComboObligatorios(comboObligatorios);

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
		trabajador.setClaveAfore("519");

		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		entrada.setLstHistoricos(lstHistoricos);
		guardarArchivosReintegroService.generarMascaraArchivo(entrada);
	}
}