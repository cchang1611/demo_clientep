/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipBUUService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsumeServicioNipServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipBUUServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Validación de elemento: NipBUUServiceImpl
 * @author malopezt
 * @since 2022/03/01
 */
public class NipBUUServiceTestCase {

	/** Elemento a validar */
	private NipBUUService nipBUUService;
	
	/** Validador general */
	private ValidadorUtils utileriaValidador;
	
	/** Consumidor servicio Rest */
	private ConsumeServicioRestService consumeServicioNipService;
	
	/** endPoint - Configuración de servicio invocado */
	private String endPoint = "UNA_URL_AL_ENDPOINT";
	
	/** Inicio */
	@Before
	public void inicio(){
		nipBUUService = new NipBUUServiceImpl();
		utileriaValidador = new ValidadorUtilsImpl();
		consumeServicioNipService = Mockito.mock(ConsumeServicioNipServiceImpl.class);
		ReflectionTestUtils.setField(nipBUUService, "utileriaValidador", utileriaValidador);
		ReflectionTestUtils.setField(nipBUUService, "consumeServicioNipService", consumeServicioNipService);
		ReflectionTestUtils.setField(nipBUUService, "endPoint", endPoint);
	}
	
	/** Escenario Rosa
	 * Interpretación de strJson Recibido:
	 * + Existe correo electrónio y Telefono Celular (recordar que uno de los objetivos es validar su existencia otro obtener los valores
	 * + El resultado es 01, lo cual nos dice que la curp no tien un Nip asociado en estado activo.
	 */
	@Test
	public void test_escenarioRosa() {
		// Inicio
		String curp = "UNA_CURP";
		String jsonResponse = "{\"correoElectronico\": \"admonCuentaDesa@procesar.com\", \"telefono\": \"7412589630\", \"confirmacionTransaccion\": \"01\"}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		NipConsultaBUU salida = null;
		try {
			salida = nipBUUService.consultarDatosBUU(curp);
		} catch(Exception e) {
			// Validaciones
			fail("Not yet implemented");
		}
		
		assertNotNull(salida);
		assertTrue("01".equals(salida.getConfirmacionTransaccion()));
		assertTrue("7412589630".equals(salida.getTelefono()));
		assertTrue("admonCuentaDesa@procesar.com".equals(salida.getCorreoElectronico()));
		assertNull(salida.getMotivoRechazo());
	}

	/** Escenario Rosa
	 * Interpretación de strJson Recibido:
	 * + Existe correo electrónio y Telefono Celular (recordar que uno de los objetivos es validar su existencia otro obtener los valores
	 * + El resultado es 01, lo cual nos dice que la curp no tien un Nip asociado en estado activo.
	 */
	@Test
	public void test_ExisteNipActivo() {
		// Inicio
		String curp = "UNA_CURP";
		String jsonResponse = "{ \"motivoRechazo\": \"A56\", \"confirmacionTransaccion\": \"02\" }";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		NipConsultaBUU salida = null;
		try {
			salida = nipBUUService.consultarDatosBUU(curp);
		} catch(Exception e) {
			// Validaciones
			fail("Not yet implemented");
		}
		
		assertNotNull(salida);
		assertTrue("02".equals(salida.getConfirmacionTransaccion()));
		assertNull(salida.getTelefono());
		assertNull(salida.getCorreoElectronico());
		assertTrue("A56".equals(salida.getMotivoRechazo()));
	}
	
	/** Escenario Rosa
	 * Interpretación de strJson Recibido:
	 * + Existe correo electrónio y Telefono Celular (recordar que uno de los objetivos es validar su existencia otro obtener los valores
	 * + El resultado es 01, lo cual nos dice que la curp no tien un Nip asociado en estado activo.
	 */
	@Test
	public void test_NoHay_Correo_Telefono_asociadoACurp() {
		// Inicio
		String curp = "UNA_CURP";
		String jsonResponse = "{\"motivoRechazo\": \"101\", \"confirmacionTransaccion\": \"02\"}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		NipConsultaBUU salida = null;
		try {
			salida = nipBUUService.consultarDatosBUU(curp);
		} catch(Exception e) {
			// Validaciones
			fail("Not yet implemented");
		}
		
		assertNotNull(salida);
		assertTrue("02".equals(salida.getConfirmacionTransaccion()));
		assertNull(salida.getTelefono());
		assertNull(salida.getCorreoElectronico());
		assertTrue("101".equals(salida.getMotivoRechazo()));
	}
	
	/** Excepción respuesta vacia del servicio de consulta
	 */
	@Test
	public void test_Excepcion_RespuestaVacia() {
		// Inicio
		String curp = "UNA_CURP";
		String jsonResponse = "";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		NipConsultaBUU salida = null;
		try {
			salida = nipBUUService.consultarDatosBUU(curp);
		} catch(Exception e) {
			// Validaciones
			fail("Not yet implemented");
		}
		assertNotNull(salida);
		assertTrue("02".equals(salida.getConfirmacionTransaccion()));
		assertNull(salida.getTelefono());
		assertNull(salida.getCorreoElectronico());
		assertTrue("0000".equals(salida.getMotivoRechazo()));
	}
	
	/** Excepción respuesta vacia del servicio de consulta
	 */
	@Test
	public void test_Excepcion_RespuestaNoEsperada() {
		// Inicio
		String curp = "UNA_CURP";
		String jsonResponse = "{\"error\": { \"codigo\": \"HTTP - 500\", \"descripcion\": \"Error en invocacion de BS\" }}";
		
		Mockito.when(consumeServicioNipService.enviarToServicioInterno(Mockito.anyString(), Mockito.anyString())).thenReturn(jsonResponse);
		
		// Ejecución
		NipConsultaBUU salida = null;
		try {
			salida = nipBUUService.consultarDatosBUU(curp);
		} catch(Exception e) {
			// Validaciones
			fail("Not yet implemented");
		}
		assertNotNull(salida);
		assertTrue("02".equals(salida.getConfirmacionTransaccion()));
		assertNull(salida.getTelefono());
		assertNull(salida.getCorreoElectronico());
		assertTrue("0000".equals(salida.getMotivoRechazo()));
	}
}
