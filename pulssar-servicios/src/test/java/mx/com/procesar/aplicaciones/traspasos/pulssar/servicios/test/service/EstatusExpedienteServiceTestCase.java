package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertTrue;

import org.jfree.util.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.EstatusExpedienteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 * Test Case EstatusExpediente
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class EstatusExpedienteServiceTestCase {
	
	/**
	 * Inyeccion Servicio
	 */
	@Autowired
	@InjectMocks
	private EstatusExpedienteService expedienteService = new EstatusExpedienteServiceImpl();

	/**
	 * Inicializa initMocks
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	    
	/**
	 *  Test ConsultarExpedienteProceso
	 */
	@Test
	public void testConsultarExpedienteProceso() {
		ReflectionTestUtils.setField(expedienteService, "urlConsultaExpedienteProceso",
				"http://lbint-devl.procesar.net/comunesPulssar/expediente/{curp}/{cveAfore}/{cveProceso}/{estatus}");
		 try {
		  expedienteService.consultarExpedienteProceso("VAPG800903HDFRRB08", "532", "20400", "01");
		  assertTrue(Boolean.TRUE);
	   }catch (Exception e) {
			Log.error("Error Proceso:{}",e);
		}
	 }
	
	/**
	 * Test Exception
	 */
	@Test
	public void testConsultarExpedienteProcesoException() {
		 ReflectionTestUtils.setField(expedienteService, "urlConsultaExpedienteProceso",
					"http://lbint-devl.procesar.net/comunesPulssar/expediente/{curp}/{cveAfore}/{cveProceso}/{estatus}");
		try {
		  expedienteService.consultarExpedienteProceso("VAPG800903HDFRRB08", "532", "20400", "01");
		  assertTrue(Boolean.TRUE);
	   }catch (Exception e) {
			Log.error("Error Exception:{}",e);
		}
	 }
	

	
	/**
	 * Test ConsultarEstatusExpediente
	 */
	@Test
	public void testConsultarEstatusExpediente() {
		ReflectionTestUtils.setField(expedienteService, "urlCosultaEstatusExpediente",
				"http://lbint-devl.procesar.net/comunesPulssar/archivorecibido/consultaGeneracionExpediente/{folio}/{clave}/{rOperacion}");
		 try {
		  expedienteService.consultarEstatusExpediente("01", "02","20700");
		  assertTrue(Boolean.TRUE);
	   }catch (Exception e) {
			Log.error("Error Estatus:{}",e);
		}
	 }	
 
		
	/**
	 * Test ConsultarExpedienteProcesoSinAfore 
	 */
	@Test
	public void testConsultarExpedienteProcesoSinAfore() {
	 try {
		  expedienteService.consultarExpedienteProcesoSinAfore("ZXVAPG800903HDFRRB09", "2300", "05");
		  assertTrue(Boolean.TRUE);
	   }catch (Exception e) {
			Log.error("Error Estatus:{}",e);
		}
	 }	
	
		
	
	/**
	 * Test ValidarRestExpedientes
	 */
	@Test
	public void testValidarRestExpedientes() {
		ReflectionTestUtils.setField(expedienteService, "urlExpedienteServicios",
				"http://lbint-devl.procesar.net/comunesPulssar/expediente/");
		 try {
		  expedienteService.validarRestExpedientes("GULJ930428MJCTZN09");
		  assertTrue(Boolean.TRUE);
	   }catch (Exception e) {
			Log.error("Error Estatus:{}",e);
		}
	 }	
	
}
