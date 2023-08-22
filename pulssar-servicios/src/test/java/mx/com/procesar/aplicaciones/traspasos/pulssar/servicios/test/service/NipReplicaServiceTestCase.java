/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipReplicaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsumeServicioNipServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipReplicaServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.FechaUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Varifica a elemento: NipReplicaServiceImpl
 * @author malopezt
 * @since 2022/03/01
 */
public class NipReplicaServiceTestCase {

	/** Elemento a verificacar */
	private NipReplicaService nipReplicaService;
	
	/** Utileria para obtener la fecha */
	private FechaUtils utileriaFecha;
	
	/** Utileria de validacion*/
	private ValidadorUtils utileriaValidador;
	
	/** End point del servicio de réplica*/
	private String endPoint = "A_LA_URL_DE_NOTIFICACION";
	
	/** Consume Servicio Rest */
	private ConsumeServicioRestService consumeServicioNipService;
	
	/** Servicio, consulta Organización - Afore  en Pulssar*/
	private OrganizacionRepository repositorioOrganizacion;
	
	/** Inicio */
	@Before
	public void inicio() {
		nipReplicaService = new NipReplicaServiceImpl();
		utileriaValidador = new ValidadorUtilsImpl();
		utileriaFecha = new FechaUtilsImpl();
		consumeServicioNipService = Mockito.mock(ConsumeServicioNipServiceImpl.class);
		repositorioOrganizacion = Mockito.mock(OrganizacionRepository.class);
		ReflectionTestUtils.setField(nipReplicaService, "utileriaValidador", utileriaValidador);
		ReflectionTestUtils.setField(nipReplicaService, "consumeServicioNipService", consumeServicioNipService);
		ReflectionTestUtils.setField(nipReplicaService, "endPoint", endPoint);
		ReflectionTestUtils.setField(nipReplicaService, "utileriaFecha", utileriaFecha);
		ReflectionTestUtils.setField(nipReplicaService, "utileriaValidador", utileriaValidador);
		ReflectionTestUtils.setField(utileriaFecha, "utileriaValidador", utileriaValidador);
		ReflectionTestUtils.setField(nipReplicaService, "repositorioOrganizacion", repositorioOrganizacion);
	}
	
	/** Escenario rosa */
	@Test
	public void test_escenarioRosa() {
		// Inicio
		RespuestaServicioNip respuestaServicio = respuestaArbitraria();
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		Date fechahoraSoliciutd = new Date();
		String usuarioModificador = "UnUSuario"; 
		String folio = "UN_FOLIO_PULSSAR";
		String sucursal = "X";
		String jsonResponse = "{\"notificacionAplicada\": \"01\", \"folioPulssar\": \"C0000054202202280030\"}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), 
				Mockito.anyString())).thenReturn(jsonResponse);
		Mockito.when(repositorioOrganizacion.findOne(Mockito.anyString())).thenReturn(obtenOrganizacion());
		// Ejecución
		try {
			nipReplicaService.guardarReplicaNip(respuestaServicio, datosEntradaNip, 
					fechahoraSoliciutd, usuarioModificador, folio, sucursal);
		} catch (BusinessException e) {
			// Validación
			fail("Not yet implemented");
		}
		Mockito.verify(repositorioOrganizacion, Mockito.times(1)).findOne(Mockito.anyString());
		Mockito.verify(consumeServicioNipService, Mockito.times(1)).enviarToServicioInterno(
				Mockito.anyString(), Mockito.anyString());
	}
	
	/** Escenario: Excepción por Réplica no aplicada por el servicio correspondiente */
	@Test
	public void test_Excepción_por_ReplicaNoAplicada() {
		// Inicio
		RespuestaServicioNip respuestaServicio = respuestaArbitraria();
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		Date fechahoraSoliciutd = new Date();
		String usuarioModificador = "UnUsuario"; 
		String folio = "UN_FOLIO_PULSSAR";
		String sucursal = "X";
		String jsonResponse = "{\"notificacionAplicada\": \"02\", \"motivoRechazo\": \"No fue posible generar replica - FolioPulssar: C0000054202202280030\", \"folioPulssar\": \"C0000054202202280030\"}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		Mockito.when(repositorioOrganizacion.findOne(Mockito.anyString())).thenReturn(obtenOrganizacion());
		// Ejecución
		try {
			nipReplicaService.guardarReplicaNip(respuestaServicio, datosEntradaNip, fechahoraSoliciutd, 
					usuarioModificador, folio, sucursal);
			// Validación
			fail("Not yet implemented");
		} catch (BusinessException e) {
			assertTrue("No fue posible generar replica - FolioPulssar: C0000054202202280030".equals(e.getMessage()));
		}
	}
	
	/** Escenario: Excepción por que el servicio correspondiente devuelve una cadena vacía */
	@Test
	public void test_Excepción_por_RespeustaVacia() {
		// Inicio
		RespuestaServicioNip respuestaServicio = respuestaArbitraria();
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		Date fechahoraSoliciutd = new Date();
		String usuarioModificador = "UnUsuario"; 
		String folio = "UN_FOLIO_PULSSAR";
		String sucursal = "X";
		String jsonResponse = "";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		Mockito.when(repositorioOrganizacion.findOne(Mockito.anyString())).thenReturn(obtenOrganizacion());
		// Ejecución
		try {
			nipReplicaService.guardarReplicaNip(respuestaServicio, datosEntradaNip, fechahoraSoliciutd, 
					usuarioModificador, folio, sucursal);
			// Validación
			fail("Not yet implemented");
		} catch (BusinessException e) {
			assertTrue("Servicio de Notificación con respuesta no esperada".equals(e.getMessage()));
		}
	}
	
	/** Escenario: Excepción por que el servicio devuelve un json no reconocido o no esperado */
	@Test
	public void test_Excepción_por_RespuestaNoReconocida() {
		// Inicio
		RespuestaServicioNip respuestaServicio = respuestaArbitraria();
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		Date fechahoraSoliciutd = new Date();
		String usuarioModificador = "UnUsuario"; 
		String folio = "UN_FOLIO_PULSSAR";
		String sucursal = "X";
		String jsonResponse = "{\"error\": { \"codigo\": \"HTTP - 500\", \"descripcion\": \"Error en invocacion de BS\" }}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		Mockito.when(repositorioOrganizacion.findOne(Mockito.anyString())).thenReturn(obtenOrganizacion());
		// Ejecución
		try {
			nipReplicaService.guardarReplicaNip(respuestaServicio, datosEntradaNip, fechahoraSoliciutd, 
					usuarioModificador, folio, sucursal);
			// Validación
			fail("Not yet implemented");
		} catch (BusinessException e) {
			assertTrue("Servicio de Notificación con respuesta no esperada".equals(e.getMessage()));
		}
	}
	
	/** Datos de entrada - Servicio de generación de Nip */
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
	
	/** Respuesta arbitraria de servicio de generación de nip */
	private RespuestaServicioNip respuestaArbitraria() {
		RespuestaServicioNip respuesta = new RespuestaServicioNip();
		respuesta.setConfirmacionTransaccion("01");
		respuesta.setMotivoRechazo("000");
		return respuesta;
	}

	/**
	 * Obtiene una entidad organización
	 * @return
	 */
	private Organizacion obtenOrganizacion() {
		Organizacion org = new Organizacion();
		org.setDescripcionOrganizacion("MI_AFORE");
		return org;
	}
}
