/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipGeneracionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RechazosGeneracionNipEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipGeneracionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Verifica: NipGeneracionServiceImpl
 * @author MALOPEZT
 * @ since 2022/03/01
 */
public class NipGeneracionImplServiceTestCase {

	/** Servicio a validar - Generación de NIP */
	private NipGeneracionService nipGeneracionService;
	
	/** Utileria de Fechas */
	@Mock
	private FechaUtils utileriaFecha;
	
	/** Consume Rest */
	@Mock
	private ConsumeServicioRestService consumeServicioNipService;
	
	/** End point */
	private String endPoint = "URL_AL_ENDPOINT";
	
	/** Validador general */
	private ValidadorUtils utileriaValidador;
	
	/** Inicio de variables */
	@Before
	public void inicio() {
		nipGeneracionService = new NipGeneracionServiceImpl();
		utileriaFecha = Mockito.mock(FechaUtils.class);
		consumeServicioNipService = Mockito.mock(ConsumeServicioRestService.class);
		utileriaValidador = new ValidadorUtilsImpl();
		ReflectionTestUtils.setField(nipGeneracionService, "consumeServicioNipService", consumeServicioNipService);
		ReflectionTestUtils.setField(nipGeneracionService, "utileriaFecha", utileriaFecha);
		ReflectionTestUtils.setField(nipGeneracionService, "endPoint", endPoint);
		ReflectionTestUtils.setField(nipGeneracionService, "utileriaValidador", utileriaValidador);
	}
	
	/** Escenario Rosa */
	@Test
	public void test_escenarioRosa_Respuesta_01() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "{\"confirmacionTransaccion\": \"01\", \"motivoRechazo\": \"F19\"}";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		RespuestaServicioNip respuesta = null;
		// Ejecución
		try {
			respuesta = nipGeneracionService.generarNIP(datosEntradaNip);
		} catch ( Exception e){
			fail("No se esperaba excepción ");
		}
		
		// Validaciones
		assertTrue("01".equals(respuesta.getConfirmacionTransaccion()));
		assertNull(respuesta.getDescripcionRechazo());
	}
	
	private GeneraNIP objetoInicialGeneraNip(){
		GeneraNIP datosEntradaNip = new GeneraNIP();
		datosEntradaNip.setApMaterno("AP_MATERNO");
		datosEntradaNip.setApPaterno("AP_PATERNO");
		datosEntradaNip.setCorreo("CORREO");
		datosEntradaNip.setCurp("CURP");
		datosEntradaNip.setCveAfore("999");
		datosEntradaNip.setNombre("NOMBRE");
		datosEntradaNip.setNss("012345780");
		datosEntradaNip.setNumeroCelular("5510009999");
		return datosEntradaNip;
	}
	
	/** Escenario Rosa */
	@Test
	public void test_escenarioRosa_Respuesta_02() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "{\"confirmacionTransaccion\": \"02\", \"motivoRechazo\": \"F19\"}";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		RespuestaServicioNip respuesta = null;
		// Ejecución
		try {
			respuesta = nipGeneracionService.generarNIP(datosEntradaNip);
		} catch ( Exception e){
			fail("No se esperaba excepción ");
		}
		
		// Validaciones
		assertTrue("02".equals(respuesta.getConfirmacionTransaccion()));
		assertTrue("F19".equals(respuesta.getMotivoRechazo()));
		assertNotNull(respuesta.getDescripcionRechazo());
		assertTrue(RechazosGeneracionNipEnum.obtenerMotivoEnum("F19").getDescripcion().equals(respuesta.getDescripcionRechazo()));
	}
	
	/** Escenario Rosa */
	@Test
	public void test_escenarioRosa_Respuesta_02_RechazoNoRegsitrado() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "{\"confirmacionTransaccion\": \"02\", \"motivoRechazo\": \"999\"}";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		RespuestaServicioNip respuesta = null;
		// Ejecución
		try {
			respuesta = nipGeneracionService.generarNIP(datosEntradaNip);
		} catch ( Exception e){
			fail("No se esperaba excepción ");
		}
		
		// Validaciones
		assertTrue("02".equals(respuesta.getConfirmacionTransaccion()));
		assertTrue("999".equals(respuesta.getMotivoRechazo()));
		assertNotNull(respuesta.getDescripcionRechazo());
		assertTrue("Motivo de rechazo no registrado".equals(respuesta.getDescripcionRechazo()));
	}
	
	/** Escenario Excepcion de engocio - No se devuelve resultado de la operación del servicio */
	@Test
	public void test_Excepcion_Respuesta_No_01_No_02() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "{\"motivoRechazo\": \"F19\"}";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		try {
			// Validaciones
			nipGeneracionService.generarNIP(datosEntradaNip);
			fail("Se esperaba excepción ");
		} catch ( BusinessException e){
			assertTrue("Servicio de generación de NIP - Confirmación llega vacia.".equals(e.getMessage()));
		}
		
	}

	/** Servicio de generaciónde NIP, devuelve un Json diferente dle esperado */
	@Test
	public void test_Respuesta_ConJsonDiferenteAlEsperado() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "{\"error\": { \"codigo\": \"HTTP - 500\", \"descripcion\": \"Error en invocacion de BS\" }}";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		try {
			nipGeneracionService.generarNIP(datosEntradaNip);
			fail("Se esperaba excepción ");
		} catch ( BusinessException e){
			// Validaciones
			assertTrue("Servicio de generación de NIP con respuesta no esperada".equals(e.getMessage()));
		}
		
	}
	
	/** Servicio de generaciónde NIP, devuelve una cadena vacía */
	@Test
	public void test_Respuesta_ConJsonEnBlanco() {
		
		// inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		
		String jsonResponse = "";
		
		Mockito.when(consumeServicioNipService.enviar(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		try {
			nipGeneracionService.generarNIP(datosEntradaNip);
			fail("Se esperaba excepción ");
		} catch ( BusinessException e){
			// Validaciones
			assertTrue("Servicio de generación de NIP con respuesta no esperada".equals(e.getMessage()));
		}
	}
}
