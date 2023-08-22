package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceConsentimientoImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;


/**
 * ReimpresionServiceConsentimientoTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionServiceConsentimientoTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ReimpresionServiceConsentimientoImpl reimpresionService =new ReimpresionServiceConsentimientoImpl();

	/**
	 * restServiceClientUtils
	 */
	@Mock
	private RestServiceClientUtils restServiceClientUtils;
	
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
		ReflectionTestUtils.setField(reimpresionService,"urlComunes","http://lbint-devl.procesar.net/comunesPulssar/");
		ReflectionTestUtils.setField(reimpresionService,"rutaArchivosConsentimiento","/");
		
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testObtenerArchivosReimpresion () throws IOException {
		Mockito.when(
				restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(),Mockito.anyString(), Mockito.eq(String.class)))
				   .thenReturn(respuesta());
		Mockito.when(
				archivoZipService.listar(Mockito.any(ZipInputStream.class)))
				   .thenReturn(salida());
		Mockito.when(
				reimpresionTramitesService.obtenerPdfPorClave(Mockito.anyListOf(DatosArchivos.class),Mockito.anyInt()))
				   .thenReturn(archivos());
		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
		Assert.assertNull(datosArchivos);
	}
	
	/**
	 * testObtenerArchivosReimpresionNull
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionNull () throws IOException {
		Mockito.when(
				restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(),Mockito.anyString(), Mockito.eq(String.class)))
				   .thenReturn(null);
		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
		Assert.assertNull(datosArchivos);
	}

	/**
	 * testObtenerArchivosReimpresionByteNull
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testObtenerArchivosReimpresionByteNull () throws IOException {
		Mockito.when(
				restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(),Mockito.anyString(), Mockito.eq(String.class)))
				   .thenReturn(respuesta());
		Mockito.when(
				archivoZipService.listar(Mockito.any(ZipInputStream.class)))
				   .thenReturn(salida());
		Mockito.when(
				reimpresionTramitesService.obtenerPdfPorClave(Mockito.anyListOf(DatosArchivos.class),Mockito.anyInt()))
				   .thenReturn(new DatosArchivos());
		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
		Assert.assertNull(datosArchivos);
	}
	

	/**
	 * testObtenerArchivosReimpresionByteNull
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionServicioException () throws IOException {
		try {
			Mockito.when(
					restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(),Mockito.anyString(), Mockito.eq(String.class)))
					   .thenThrow(NullPointerException.class);
			reimpresionService.obtenerArchivosReimpresion(trabajador());
		}catch(Exception e){
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
				Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyString());
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajador(), "SEUUEY878", 1, Mockito.anyString());
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
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajadorSinCorreo(), "SEUUEY878", 1, Mockito.anyString());
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
	 * salida
	 * @return
	 */
	private List<DatosArchivos> salida() {
		List<DatosArchivos> lista= new ArrayList<>();
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setNombreArchivo("prueba2");
		datosArchivos.setByteArchivo("prueba3");
		lista.add(datosArchivos);
		return lista;
	}

	/**
	 * respuesta
	 * @return
	 */
	private String respuesta() {
		return "[{\"chNombreArchivo\":\"consentimiento\"}]";
		
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
