/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.CovierteJSONStringEnObjeto;

import org.junit.Test;

/**
 * @author MALOPEZT
 *
 */
public class CovierteJSONStringEnObjetoTestCase {

	/**
	 * Valida la recuperación de un objeto a través del Json recibido en una cadena
	 */
	@Test
	public void testValidaRecuperacion_ServicioResponse() {
		// Inicio
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		String jsonString = "{\"confirmacionTransaccion\":\"02\",\"motivoRechazo\":\"015\"}";

		// Ejecución
		try {
			respuestaServicio = (RespuestaServicioNip) CovierteJSONStringEnObjeto.devulveObjeto(jsonString, respuestaServicio);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
		
		// Validación
		assertNotNull(respuestaServicio.getConfirmacionTransaccion());
		assertTrue(respuestaServicio.getConfirmacionTransaccion().equals("02"));
		assertNotNull(respuestaServicio.getMotivoRechazo());
		assertTrue(respuestaServicio.getMotivoRechazo().equals("015"));

	}

	/**
	 * Valida la recuperación de un objeto a través del Json recibido en una cadena
	 */
	@Test
	public void testValidaRecuperacion_ServicioRegistro01Response_rechazo() {
		// Inicio
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		String jsonString = "{}";

		// Ejecución
		try {
			respuestaServicio = (RespuestaServicioNip) CovierteJSONStringEnObjeto.devulveObjeto(jsonString, respuestaServicio);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
		
		// Validación
		assertNotNull(respuestaServicio);
	}
	
	/**
	 * Vrifica la generación de excepción de la forma deseada
	 */
	@Test
	public void testValidaRecuperacion_IOExcepcion (){
		// Inicio
		RespuestaServicioNip respuestaServicio = new RespuestaServicioNip();
		String jsonStringMalFormado = "{\"entidadOrigen\" # \"538\",\"idNegocio\" : \"52018207606\",\"claveDeAforeConNSSAsociado\" : \"552\",\"identificadorDeTipoDeTrabajador\" : \"1\",\"numeroDeRegistroPatronal\" : \"A4819975103\",\"curpOficial\" : \"CACN821130MCMHRD08\",\"rfc\" : \"CACN821130MCM\",\"apellidoPaterno\" : \"CHAVIRA\",\"nombreTrabajador\" : \"NADIA CRISTAL\",\"fechaDeNacimiento\" : \"19821130\",\"claveDelPromotor\" : \"1502078106\",\"sexo\" : \"2\",\"entidadFederativaDeNacimiento\" : \"06\",\"fechaFirmaDeSolicitud\" : \"20210120\",\"folioDeLaSolicitud\" : \"1234567800\",\"fechaDePrimerRegistro\" : \"20210121\",\"indicadorDeUnificacionAutorizada\" : \"1\",\"nacionalidad\" : \"MEX\",\"claveDeTipoDeDocumentoProbatorio\" : \"5\",\"documentoProbatorio\" : \"CACN821130MCMHRD\",\"folioDeDocumentoProbatorio\" : \"0020954777\",\"indicadorDeCreditoInfonavit\" : \"0\",\"fechaAltaEnAfore\" : \"20210121\",\"periodoDePago\" : \"201601\",\"salarioDiarioIntegrado\" : \"271.46\",\"resultadoDeLaOperacion\" : \"01\",\"diagnosticoDeRecepcion\" : \"000\"}";
		
		// Ejecución
		try {
			respuestaServicio = (RespuestaServicioNip) CovierteJSONStringEnObjeto.devulveObjeto(jsonStringMalFormado, respuestaServicio);
			fail(" Se esperaba una excepción");
		} catch (Exception e) {
			assertTrue(e instanceof BusinessException);
			assertTrue("Json devuelto no reconocido".equals(e.getMessage())); 
		}
	}
	
	/** Test constructor :( */
	@Test
	public void test_ConstructorPrivado() throws Exception {
		Constructor<CovierteJSONStringEnObjeto> cec;
		try {
			cec = CovierteJSONStringEnObjeto.class.getDeclaredConstructor();
			cec.setAccessible(true);
			cec.newInstance();
		} catch(InvocationTargetException e) {
			assertTrue(e.getTargetException().toString().contains("Clase no instanciable"));
		}
	}
	
}
