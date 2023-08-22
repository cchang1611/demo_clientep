/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaGeneraNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipGeneracionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipReplicaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipSolicitudServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Validaci�n de elemento: NipSolicitudService
 * @author malopezt
 * @since 2022/03/01
 */
public class NipSolicitudServiceTestCase {

	/** Elemento a validar*/
	private NipSolicitudService nipSolicitudService; 
	
	/** Servicio de generaci�n de Nip*/
	@Mock
	private NipGeneracionService nipGeneracionService;
	
	/** Servicio de replica*/
	@Mock
	private NipReplicaService nipReplicaService;
	
	
	/** Inicializaci�n*/
	@Before
	public void inicio() {
		nipSolicitudService = new NipSolicitudServiceImpl();
		nipGeneracionService = Mockito.mock(NipGeneracionService.class);
		nipReplicaService = Mockito.mock(NipReplicaService.class);
		ReflectionTestUtils.setField(nipSolicitudService, "nipGeneracionService", nipGeneracionService);
		ReflectionTestUtils.setField(nipSolicitudService, "nipReplicaService", nipReplicaService);
	}
	
	/** Escenario Rosa */
	@Test
	public void test_escenarioRosa() {
		// Inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		String usuarioModificador = "USR_DESA";
		String folio = "FOLIO_PULSSAR";
		String sucursal = "X";
		Mockito.when(nipGeneracionService.generarNIP(datosEntradaNip)).thenReturn(respuestaServicioGeneracionNip_OK());
		
		// Ejecuci�n
		RespuestaGeneraNip salida = null;
		try {
			salida = nipSolicitudService.solicitarNIP(datosEntradaNip, usuarioModificador, folio, sucursal);
		}catch(BusinessException e) {
			// Validaci�n
			fail("Not yet implemented");
		}
		assertNotNull(salida);
		Mockito.verify(nipReplicaService, Mockito.times(1)).guardarReplicaNip((RespuestaServicioNip)Mockito.any(), 
				(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
					Mockito.anyString(), Mockito.anyString());
		assertTrue(salida.getFlujo() == 1);
	}
	
	/** Escenario  */
	@Test
	public void test_escenario_respuestaServicioGeneraNip_02() {
		// Inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		String usuarioModificador = "USR_DESA";
		String folio = "FOLIO_PULSSAR";
		String sucursal = "X";
		Mockito.when(nipGeneracionService.generarNIP(datosEntradaNip)).thenReturn(respuestaServicioGeneracionNip_02());
		
		// Ejecuci�n
		RespuestaGeneraNip salida = null;
		try {
			salida = nipSolicitudService.solicitarNIP(datosEntradaNip, usuarioModificador, folio, sucursal);
		}catch(BusinessException e) {
			// Validaci�n
			fail("Not yet implemented");
		}
		Mockito.verify(nipReplicaService, Mockito.times(1)).guardarReplicaNip((RespuestaServicioNip)Mockito.any(), 
				(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
					Mockito.anyString(), Mockito.anyString());
		assertTrue(salida.getFlujo() == 0);
		assertTrue(("La solicitud de generaci�n de NIP no se pudo realizar, derivado de lo siguiente: ".concat("La CURP del Ahorrador cuenta con un NIP relacionado")).equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_escenario_excepcionAlInvocarServicioGenracionNip() {
		// Inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		String usuarioModificador = "USR_DESA";
		String folio = "FOLIO_PULSSAR";
		String sucursal = "X";
		Mockito.doThrow(new BusinessException("Trono el rest")).when(nipGeneracionService).generarNIP(datosEntradaNip);
		
		// Ejecuci�n
		RespuestaGeneraNip salida = null;
		try {
			salida = nipSolicitudService.solicitarNIP(datosEntradaNip, usuarioModificador, folio, sucursal);
		}catch(BusinessException e) {
			// Validaci�n
			fail("Not yet implemented");
		}
		assertNotNull(salida);
		System.out.println(salida);
		Mockito.verify(nipReplicaService, Mockito.times(0)).guardarReplicaNip((RespuestaServicioNip)Mockito.any(), 
				(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
					Mockito.anyString(), Mockito.anyString());
		assertTrue(salida.getFlujo() == 0);
		assertTrue("Trono el rest".equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_escenario_respuestaServicioGeneraNip_02_NotificacionFalla() {
		// Inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		String usuarioModificador = "USR_DESA";
		String folio = "FOLIO_PULSSAR";
		String sucursal = "X";
		Mockito.when(nipGeneracionService.generarNIP(datosEntradaNip)).thenReturn(respuestaServicioGeneracionNip_02());
		Mockito.doThrow(new BusinessException("Error al Notificar nip")).
			when(nipReplicaService).guardarReplicaNip(	(RespuestaServicioNip)Mockito.any(), 
					(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
						Mockito.anyString(), Mockito.anyString());
		// Ejecuci�n
		RespuestaGeneraNip salida = null;
		try {
			salida = nipSolicitudService.solicitarNIP(datosEntradaNip, usuarioModificador, folio, sucursal);
		}catch(BusinessException e) {
			// Validaci�n
			fail("Not yet implemented");
		}
		Mockito.verify(nipReplicaService, Mockito.times(1)).guardarReplicaNip((RespuestaServicioNip)Mockito.any(), 
				(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
					Mockito.anyString(), Mockito.anyString());
		assertTrue(salida.getFlujo() == 0);
		assertTrue(("La solicitud de generaci�n de NIP no se pudo realizar, derivado de lo siguiente: ".concat("La CURP del Ahorrador cuenta con un NIP relacionado")).equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_escenario_respuestaServicioGeneraNip_ni02_ni01() {
		// Inicio
		GeneraNIP datosEntradaNip = objetoInicialGeneraNip();
		String usuarioModificador = "USR_DESA";
		String folio = "FOLIO_PULSSAR";
		String sucursal = "X";
		Mockito.when(nipGeneracionService.generarNIP(datosEntradaNip)).thenReturn(respuestaServicioGeneracionNip_NOesperada_Ni01_ni02());
		
		// Ejecuci�n
		RespuestaGeneraNip salida = null;
		try {
			salida = nipSolicitudService.solicitarNIP(datosEntradaNip, usuarioModificador, folio, sucursal);
		}catch(BusinessException e) {
			// Validaci�n
			fail("Not yet implemented");
		}
		Mockito.verify(nipReplicaService, Mockito.times(0)).guardarReplicaNip((RespuestaServicioNip)Mockito.any(), 
				(GeneraNIP)Mockito.any(), (Date)Mockito.any(), Mockito.anyString(), 
					Mockito.anyString(), Mockito.anyString());
		assertTrue(salida.getFlujo() == 0);
		assertTrue("Servicio de generaci�n de NIP con respuesta no esperada".equals(salida.getMensaje()));
	}
	
	/** Datos de entrada - Servicio de generaci�n de Nip */
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
	
	/** Respuesta servico generacion de Nip */
	private RespuestaServicioNip respuestaServicioGeneracionNip_OK() {
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		respuestaServicio.setConfirmacionTransaccion("01");
		respuestaServicio.setMotivoRechazo("000");
		return respuestaServicio;
	}
	
	/** Respuesta servico generacion de Nip */
	private RespuestaServicioNip respuestaServicioGeneracionNip_02() {
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		respuestaServicio.setConfirmacionTransaccion("02");
		respuestaServicio.setMotivoRechazo("A56");
		respuestaServicio.setDescripcionRechazo("La CURP del Ahorrador cuenta con un NIP relacionado");
		return respuestaServicio;
	}
	
	/** Respuesta servico generacion de Nip */
	private RespuestaServicioNip respuestaServicioGeneracionNip_NOesperada_Ni01_ni02() {
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		respuestaServicio.setConfirmacionTransaccion("03");
		return respuestaServicio;
	}
}
