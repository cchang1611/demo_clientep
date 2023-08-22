package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceFabrica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceConsentimientoImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceTramiteImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;



/**
 * ReimpresionServiceTramiteTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionServiceTramiteTestCase {
	
	/**
	 * reimpresionServiceTramiteImpl
	 */
	@InjectMocks
	private ReimpresionServiceTramiteImpl reimpresionServiceTramiteImpl =new ReimpresionServiceTramiteImpl();

	/**
	 * reimpresionServiceFabrica
	 */
	@Mock
	private ReimpresionServiceFabrica reimpresionServiceFabrica;
	
	
	/**
	 * reimpresionTramitesService
	 */
	@Mock
	private ReimpresionTramitesService reimpresionTramitesService;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * testObtenerArchivos
	 * @throws IOException 
	 */
	@Test
	public void testObtenerArchivos() throws IOException {
		ReimpresionServiceConsentimientoImpl reimpresionService=Mockito.mock(ReimpresionServiceConsentimientoImpl.class);
		Mockito.when(reimpresionServiceFabrica.obtenerServicioReimpresion(Mockito.anyInt())).thenReturn(reimpresionService);
		Mockito.when(reimpresionService.obtenerArchivosReimpresion(Mockito.any(DatosTrabajador.class))).thenReturn(datos());
		DatosArchivos datos=reimpresionServiceTramiteImpl.obtenerArchivos(trabajador(), 1);
		Assert.assertNotNull(datos);
		
	}
	
	/**
	 * testObtenerArchivos
	 * @throws IOException 
	 */
	@Test
	public void testObtenerArchivosException() {
		try {
			ReimpresionServiceConsentimientoImpl reimpresionService=Mockito.mock(ReimpresionServiceConsentimientoImpl.class);
			Mockito.when(reimpresionServiceFabrica.obtenerServicioReimpresion(Mockito.anyInt())).thenReturn(reimpresionService);
			Mockito.when(reimpresionService.obtenerArchivosReimpresion(Mockito.any(DatosTrabajador.class))).thenThrow(NullPointerException.class);
			reimpresionServiceTramiteImpl.obtenerArchivos(trabajador(), 1);
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
		
		
	}

	
	/**
	 * testEnviarCorreoReimpresion
	 * @throws IOException 
	 */
	@Test
	public void testEnviarCorreoReimpresion() {
	
		ReimpresionServiceConsentimientoImpl reimpresionService=Mockito.mock(ReimpresionServiceConsentimientoImpl.class);
		Mockito.when(reimpresionServiceFabrica.obtenerServicioReimpresion(Mockito.anyInt())).thenReturn(reimpresionService);
		Mockito.when(reimpresionService.enviarCorreoReimpresion(Mockito.any(DatosArchivos.class), Mockito.any(DatosTrabajador.class),
					Mockito.anyString(),Mockito.anyInt(),Mockito.anyString())).thenReturn(new RespuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionServiceTramiteImpl.enviarCorreoReimpresion(datos(),trabajador(), 1, "prueba",1, "dasdasd");
		Assert.assertNotNull(respuestaServicio);
	}
	
	/**
	 * testObtenerExistenciaCorreoElectronico
	 * @throws IOException 
	 */
	@Test
	public void testObtenerExistenciaCorreoElectronico() {
	
		ReimpresionServiceConsentimientoImpl reimpresionService=Mockito.mock(ReimpresionServiceConsentimientoImpl.class);
		Mockito.when(reimpresionServiceFabrica.obtenerServicioReimpresion(Mockito.anyInt())).thenReturn(reimpresionService);
		Mockito.when(reimpresionService.obtenerExistenciaCorreoElectronico(Mockito.any(DatosTrabajador.class))).
			thenReturn(new RespuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionServiceTramiteImpl.obtenerExistenciaCorreoElectronico(trabajador(), 1);
		Assert.assertNotNull(respuestaServicio);
	}
	
	/**
	 * testGuardarBitacoraImpresion
	 * @throws IOException 
	 */
	@Test
	public void testGuardarBitacoraImpresion() {
	
		Mockito.when(reimpresionTramitesService.obtenerTipoClaveDocumento(Mockito.anyInt())).
		     thenReturn("1");
		Mockito.doNothing().when(reimpresionTramitesService).guardarBitacoraImpresionEnvio(
				Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString());
		
	    reimpresionServiceTramiteImpl.guardarBitacoraImpresion(datos(),1, "dasdas");
	}
	
	/**
	 * trabajador
	 * @return
	 */
	private DatosTrabajador trabajador() {
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables certificables= new DatosCertificables();
		certificables.setCurp("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setClaveAfore("578");
		datosTrabajador.setCurpSolicitante("OIOWSIWOSIWSLSWLWS");
		return datosTrabajador;
		
	}
	
	/**
	 * datos
	 * @return
	 */
	private DatosArchivos datos() {
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setByteArchivo("mjkjskwjskw");
		return datosArchivos;
		
	}

}
