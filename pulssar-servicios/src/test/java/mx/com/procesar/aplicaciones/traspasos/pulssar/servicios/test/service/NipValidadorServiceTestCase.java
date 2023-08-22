/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipValidadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipValidadorServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Elemento a validar : NipValidadorService
 * @author malopezt
 * @since 2022/03/02
 */
public class NipValidadorServiceTestCase {

	/** Elemento a validar */
	private NipValidadorService nipValidadorService;
	
	/** Utileria de validacion*/
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/** Inicio */
	@Before
	public void inicio() {
		nipValidadorService = new NipValidadorServiceImpl();
		utileriaValidador = new ValidadorUtilsImpl();
		ReflectionTestUtils.setField(nipValidadorService, "utileriaValidador", utileriaValidador);
	}
	
	/** Escenario Rosa */
	@Test
	public void test_escenarioRosa() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajadorOk();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_Ok();
		// Ejecución
		RespuestaServicio salida = null;
		try {
			salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		} catch (BusinessException e) {
			// Validación
			fail("Not yet implemented");
		}
		assertTrue(salida.getFlujo() == 1);
	}
	
	/** Escenario  */
	@Test
	public void test_CurpDuplicada() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajador_CurpDuplicados();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_Ok();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("CURP duplicada en BD".equals(salida.getMensaje()));
	}

	/** Escenario  */
	@Test
	public void test_SinExpIndetificacionPermanente() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajador_SinExpIdentificacionPermanente();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_Ok();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("El usuario no cuenta con expediente de identificación permanente".equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_SinExpEnrolamientoPermanente() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajador_SinExpEnrolamientoPermanente();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_Ok();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("El usuario no cuenta con enrolamiento permanente".equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_cuentaConNIpActivo() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajadorOk();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_ProblemaNipActivo();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("No puede generarse un NIP ya que el trabajador cuenta con un NIP activo /vigente".equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_problemaComunicacionBUU() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajadorOk();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_ProblemaComunicacion();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("No se ha obtenido respuesta del servicio de Validación BUU".equals(salida.getMensaje()));
	}
	
	/** Escenario  */
	@Test
	public void test_sinInformacionEnLaBUU_AplicacionMovil() {
		
		//Inicio
		DatosTrabajador trabajador = objetoInicialDatosTrabajadorOk();
		NipConsultaBUU consultaBUU = obtenerDatosBUU_Problema_sinInfoEnBUU();
		// Ejecución
		RespuestaServicio salida = nipValidadorService.validarInformacion(trabajador, consultaBUU);
		// Validación
		assertTrue(salida.getFlujo() == 2);  // Constante error
		assertTrue("El trabajador no cuenta con información asociada a una APP o AFORE Web, por lo que no puede solicitar el NIP para uso de dichos aplicativos".equals(salida.getMensaje()));
	}
	
	
	/** Datos de entrada - Trabajador */
	private DatosTrabajador objetoInicialDatosTrabajadorOk(){
		List<String> aforesDuplicadas = new ArrayList<String>();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setAforesDuplicadas(aforesDuplicadas);
		DatosExpediente expediente = new DatosExpediente();
		expediente.setBanderaEnrolamiento(1);
		expediente.setEstatusEnrolamiento("5");
		expediente.setBanderaExpedienteIdentifiacion(1);
		expediente.setEstatusExpedienteIdentificacion("5");
		trabajador.setDatosExpediente(expediente);
		return trabajador;
	}
	
	/** Datos de entrada - Trabajador */
	private DatosTrabajador objetoInicialDatosTrabajador_SinExpIdentificacionPermanente(){
		List<String> aforesDuplicadas = new ArrayList<String>();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setAforesDuplicadas(aforesDuplicadas);
		DatosExpediente expediente = new DatosExpediente();
		expediente.setBanderaEnrolamiento(1);
		expediente.setEstatusEnrolamiento("5");
		expediente.setBanderaExpedienteIdentifiacion(0);
		expediente.setEstatusExpedienteIdentificacion("5");
		trabajador.setDatosExpediente(expediente);
		return trabajador;
	}
	
	/** Datos de entrada - Trabajador */
	private DatosTrabajador objetoInicialDatosTrabajador_SinExpEnrolamientoPermanente(){
		List<String> aforesDuplicadas = new ArrayList<String>();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setAforesDuplicadas(aforesDuplicadas);
		DatosExpediente expediente = new DatosExpediente();
		expediente.setBanderaEnrolamiento(0);
		expediente.setEstatusEnrolamiento("5");
		expediente.setBanderaExpedienteIdentifiacion(1);
		expediente.setEstatusExpedienteIdentificacion("5");
		trabajador.setDatosExpediente(expediente);
		return trabajador;
	}
	
	/** Datos de entrada - Trabajador */
	private DatosTrabajador objetoInicialDatosTrabajador_CurpDuplicados(){
		List<String> aforesDuplicadas = new ArrayList<String>();
		aforesDuplicadas.add("OTRA_CURP_IGUAL");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setAforesDuplicadas(aforesDuplicadas);
		DatosExpediente expediente = new DatosExpediente();
		expediente.setBanderaEnrolamiento(1);
		expediente.setEstatusEnrolamiento("5");
		expediente.setBanderaExpedienteIdentifiacion(1);
		expediente.setEstatusExpedienteIdentificacion("5");
		trabajador.setDatosExpediente(expediente);
		return trabajador;
	}
	
	/** Datos de respuesta del servicio BUU */
	private NipConsultaBUU obtenerDatosBUU_Ok() {
		NipConsultaBUU datosBUU = new NipConsultaBUU();
		datosBUU.setConfirmacionTransaccion("01");
		datosBUU.setCorreoElectronico("correoDesa@procesar.com");
		datosBUU.setTelefono("7894561230");
		return datosBUU;
	}
	
	/** Datos de respuesta del servicio BUU */
	private NipConsultaBUU obtenerDatosBUU_ProblemaComunicacion() {
		NipConsultaBUU datosBUU = new NipConsultaBUU();
		datosBUU.setConfirmacionTransaccion("02");
		datosBUU.setMotivoRechazo("0000");
		return datosBUU;
	}
	
	/** Datos de respuesta del servicio BUU */
	private NipConsultaBUU obtenerDatosBUU_ProblemaNipActivo() {
		NipConsultaBUU datosBUU = new NipConsultaBUU();
		datosBUU.setConfirmacionTransaccion("02");
		datosBUU.setMotivoRechazo("102");
		return datosBUU;
	}
	
	/** Datos de respuesta del servicio BUU
	 * Sin datos de Correo y telefono activo en la BUU - Aplicación Movil 
	 */ 
	private NipConsultaBUU obtenerDatosBUU_Problema_sinInfoEnBUU() {
		NipConsultaBUU datosBUU = new NipConsultaBUU();
		datosBUU.setConfirmacionTransaccion("02");
		datosBUU.setMotivoRechazo("101");
		return datosBUU;
	}
}
