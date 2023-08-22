/**
 * ReintegroSemanasResarcimientoServiceTestCase.java
 * Fecha de creación: Sep 7, 2020 1:51:04 PM
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
import org.springframework.web.multipart.MultipartFile;

import junit.framework.TestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarArchivosReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReintegroSemanasResarcimientoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class ReintegroSemanasResarcimientoServiceTestCase extends TestCase {

	/**
	 * Atributo reintegroSemanasResarcimientoService
	 */
	@InjectMocks
	private ReintegroSemanasResarcimientoService reintegroSemanasResarcimientoService = new ReintegroSemanasResarcimientoServiceImpl();

	/**
	 * Resarcimiento
	 */
	@Mock
	private ResarcimientoService resarcimientoService;

	/**
	 * Solicitud
	 */
	@Mock
	private SolicitudReintegroService solicitudReintegroService;

	/**
	 * utilidades de fechas
	 */
	@Spy
	private FechaUtils fechaUtils;

	/**
	 * Notificacion
	 */
	@Mock
	private NotificacionReintegroService notificacionReintegroService;

	/**
	 * Service de archivos
	 */
	@Mock
	private GuardarArchivosReintegroService guardarArchivosReintegroService;

	/**
	 * Service archivos reintegro
	 */
	@Spy
	private GuardarArchivosReintegroService archivosReintegroService;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test de servicio de la consulta de historico de retiros
	 */
	@Test
	public void testConsultarHistoricoRetiros() {
		// Mocks
		List<RespuestaHistoricoRetiros> value = new ArrayList<>();
		RespuestaHistoricoRetiros respuesta = new RespuestaHistoricoRetiros();
		value.add(respuesta);
		Mockito.when(resarcimientoService.obtenerResarcimiento(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(value);

		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		trabajador.setClaveAfore("123123");
		entrada.setTrabajador(trabajador);
		reintegroSemanasResarcimientoService.consultarHistoricoRetiros(entrada);
	}

	/**
	 * Test de consultar historico de confirmaciones para reintegros
	 */
	@Test
	public void testConsultarHistoricoConfirmacion() {
		// Mocks
		List<SolicitudReintegroEntrada> value = new ArrayList<>();
		SolicitudReintegroEntrada solicitud = new SolicitudReintegroEntrada();
		solicitud.setFechaRetiro(new Date());
		value.add(solicitud);
		Mockito.when(solicitudReintegroService.buscarSolicitudes(Mockito.anyString())).thenReturn(value);

		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		entrada.setTrabajador(trabajador);
		reintegroSemanasResarcimientoService.consultarHistoricoConfirmacion(entrada);
	}

	/**
	 * Test de generar archivo PDF y linea de captura
	 */
	@Test
	public void testGenerarLineaCaptura() {
		Mockito.when(solicitudReintegroService.generarDatosReferencia(Mockito.<SolicitudReintegroResarcimiento>any()))
				.thenReturn(new BaseRespuesta<byte[]>());

		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		entrada.setTrabajador(trabajador);
		reintegroSemanasResarcimientoService.generarLineaCaptura(entrada);
	}

	/**
	 * Test de generar la primera notificacion del flujo de historico
	 */
	@Test
	public void testGenerarNotificacionHistorico() {
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		entrada.setTrabajador(trabajador);
		reintegroSemanasResarcimientoService.generarNotificacionHistorico(entrada);
	}

	/**
	 * 
	 * Test de el calculo del monto a reintegrar
	 */
	@Test
	public void testObtenerCalculoMontoReintegrar() {
		Mockito.when(resarcimientoService.obtenerCalculoMontoReintegrar(Mockito.<CalculoMontoReintegrar>any()))
				.thenReturn(new BaseRespuesta<RespuestaMontoReintegrar>());

		// Prueba
		CalculoMontoReintegrar entrada = new CalculoMontoReintegrar();
		entrada.setNumeroResolucion("123");
		entrada.setNumeroSemanasReintegrar("9");
		SolicitudReintegroResarcimiento solicitud = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		solicitud.setTrabajador(trabajador);
		List<RespuestaHistoricoRetiros> lstHistoricos = new ArrayList<>();
		RespuestaHistoricoRetiros respuestaHistorico = new RespuestaHistoricoRetiros();
		respuestaHistorico.setNumeroResolucion("123");
		respuestaHistorico.setSemanasRestantes("10");
		lstHistoricos.add(respuestaHistorico);
		solicitud.setLstHistoricos(lstHistoricos);
		reintegroSemanasResarcimientoService.obtenerCalculoMontoReintegrar(entrada, solicitud);
	}

	/**
	 * Test de consulta documentos requeridos
	 */
	@Test
	public void testConsultarDocumentosRequeridos() {
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		entrada.setTrabajador(trabajador);
		List<SolicitudReintegroEntrada> lstConfirmacion = new ArrayList<>();
		SolicitudReintegroEntrada solicitudReintegro = new SolicitudReintegroEntrada();
		solicitudReintegro.setNumeroResolucion("123");
		solicitudReintegro.setNumeroReintegro(45);
		lstConfirmacion.add(solicitudReintegro);
		entrada.setLstConfirmacion(lstConfirmacion);
		entrada.setResolucion("123");
		entrada.setNumeroReintegro("45");
		reintegroSemanasResarcimientoService.consultarDocumentosRequeridos(entrada);
	}

	/**
	 * Se encarga de validar los archivos adjuntos en el flujo de confirmacion
	 */
	@Test
	public void testObtenerArchivos() {
		RespuestaServicio value = new RespuestaServicio();
		value.setFlujo(0);
		Mockito.when(guardarArchivosReintegroService.obtenerArchivos(Mockito.<String, MultipartFile>anyMap(),
				Mockito.<SolicitudReintegroResarcimiento>any())).thenReturn(value);

		Mockito.when(solicitudReintegroService.buscarSolicitudes(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(new SolicitudReintegroEntrada());

		Mockito.when(notificacionReintegroService.buscarNotificacion(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(new NotificacionReintegro());

		// Prueba
		Map<String, MultipartFile> archivos = new HashMap<>();
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		entrada.setTrabajador(trabajador);
		entrada.setNumeroReintegro("123");
		entrada.setResolucion("456");
		reintegroSemanasResarcimientoService.obtenerArchivos(archivos, entrada);
	}
}
