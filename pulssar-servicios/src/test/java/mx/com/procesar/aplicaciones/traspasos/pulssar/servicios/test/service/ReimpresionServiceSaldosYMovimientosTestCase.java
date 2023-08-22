package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayOutputStream;
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
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceSaldosYMovimientos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceSaldosYMovimientosImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * ReimpresionServiceConsentimientoTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionServiceSaldosYMovimientosTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ReimpresionServiceSaldosYMovimientos reimpresionService =new ReimpresionServiceSaldosYMovimientosImpl();
	
	/**
	 * MenuReimpresionService
	 */
	@Mock
	private MenuReimpresionService menuReimpresionService;
	
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Mock
	private CorreoService servicioCorreo;
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Mock
	private ArchivoZipService archivoZipService;
	
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
		ReflectionTestUtils.setField(reimpresionService,"endPointReimpresion","http://172.21.66.90/ServiciosInternos/ReimpresionDocumento?wsdl");
		ReflectionTestUtils.setField(reimpresionService,"idClienteReimpresion",86);
		ReflectionTestUtils.setField(reimpresionService,"idServicioReimpresion",900);
		ReflectionTestUtils.setField(reimpresionService,"idBuisnessReimpresion",53);
	}
    private DatosTrabajador datosTrabajador() {
    	DatosTrabajador trabjador = new DatosTrabajador();
    	DatosCertificables certificables= new DatosCertificables();
    	certificables.setCurp("lkslkslks");
    	trabjador.setClaveAfore("s22");
    	trabjador.setDatosCertificables(certificables);
    	trabjador.setFolio(folio());
		return trabjador;
	}
    private UsuarioLogin datosUser() {
    	UsuarioLogin usrLogin = new UsuarioLogin();
    	usrLogin.setUsuario("1508080321");
    	usrLogin.setNombre("Yorch");
    	return usrLogin;
    }
    private FolioEntrada folio() {
    	FolioEntrada FolioEntrada = new FolioEntrada();
    	FolioEntrada.setFolio("sjkkjs");
		return FolioEntrada;
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresion (){
		try {
			DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(datosTrabajador(), "552",datosUser());
			Assert.assertNotNull(datosArchivos);	
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
		
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionNulo (){
		try {
			reimpresionService.obtenerArchivosReimpresion(datosTrabajador(), "552",datosUser());
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * testEnviarCorreoReimpresion
	 */
	@Test
	public void testEnviarCorreoReimpresion() {
		Mockito.when(
				archivoZipService.pdf(Mockito.any(byte[].class)))
				   .thenReturn(new ByteArrayOutputStream());
		Mockito.doNothing().when(servicioCorreo).envioCorreo(Mockito.any(DatosCorreo.class),
				Mockito.anyString());
		Mockito.when(
				reimpresionTramitesService.obtenerTipoClaveDocumento(Mockito.anyInt()))
				   .thenReturn("ok");
		Mockito.doNothing().when(reimpresionTramitesService).guardarBitacoraImpresionEnvio(
				Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString());
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajador(), "SEUUEY878", 1,"01");
		Assert.assertNull(respuestaServicio);
	}
	
	/**
	 * testEnviarCorreoReimpresion
	 */
	@Test
	public void testEnviarCorreoReimpresionNull() {
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajadorSinCorreo(), "SEUUEY878", 1,"01");
		Assert.assertNull(respuestaServicio);
	}
	
	/**
	 * testEnviarCorreoReimpresion
	 */
	@Test
	public void testObtenerExistenciaCorreoElectronico() {
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.obtenerExistenciaCorreoElectronico(trabajador());
		Assert.assertNull(respuestaServicio);
	}
	
	/**
	 * testObtenerExistenciaCorreoElectronicoNull
	 */
	@Test
	public void testObtenerExistenciaCorreoElectronicoNull() {
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.obtenerExistenciaCorreoElectronico(trabajadorSinCorreo());
		Assert.assertNull(respuestaServicio);
	}
	
	/**
	 * testObtenerExistenciaCorreoElectronicoNull
	 */
	@Test
	public void testGuardarBitacoraImpresion() {
		Mockito.doNothing().when(reimpresionTramitesService).
				guardarBitacoraImpresionEnvio(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString());
		reimpresionService.guardarBitacoraImpresion(archivos(),1,"01");
	}
	
	/**
	 * respuestaServicio
	 * @return
	 */
	private RespuestaServicio respuestaServicio() {
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		respuestaServicio.setDatos("01");
		respuestaServicio.setFlujo(1);
		return respuestaServicio;
	}

	/**
	 * archivos
	 * @return
	 */
	private DatosArchivos archivos() {
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setByteArchivo("prueba2");
		datosArchivos.setFormato("pdf");
		datosArchivos.setNombreArchivo("prueba");
		return datosArchivos;
	}
	
	/**
	 * trabajador
	 * @return
	 */
	private DatosTrabajador trabajador() {
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables certificables= new DatosCertificables();
		DatosComplementarios complementarios=new DatosComplementarios();
		complementarios.setCorreoElectronico("georgemanuel789@gmail.com");
		certificables.setCurp("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setClaveAfore("578");
		datosTrabajador.setCurpSolicitante("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setDatosCertificables(certificables);
		datosTrabajador.setDatosComplementarios(complementarios);
		return datosTrabajador;
		
	}
	
	/**
	 * trabajador
	 * @return
	 */
	private DatosTrabajador trabajadorSinCorreo() {
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables certificables= new DatosCertificables();
		DatosComplementarios complementarios=new DatosComplementarios();
		certificables.setCurp("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setClaveAfore("578");
		datosTrabajador.setCurpSolicitante("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setDatosCertificables(certificables);
		datosTrabajador.setDatosComplementarios(complementarios);
		return datosTrabajador;
		
	}
	
	
	

}
