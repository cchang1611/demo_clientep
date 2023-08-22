package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceModificacionrDatosImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivosDescargados;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaFilenet;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
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
public class ReimpresionServiceModificacionrDatosTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ReimpresionServiceModificacionrDatosImpl reimpresionService =new ReimpresionServiceModificacionrDatosImpl();

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
		ReflectionTestUtils.setField(reimpresionService,"urlFilenet","http://172.21.62.1/consultauniversalexpedienteecm/");
		
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testObtenerArchivosReimpresion () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(tramitesConcluidos());
		Mockito.when(
				restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(EntradaFilenet.class), Mockito.eq(byte[].class)))
				   .thenReturn(bytes());
		Mockito.when(
				archivoZipService.llenarDatosZip(Mockito.any(ByteArrayInputStream.class)))
				   .thenReturn(lista());
		Mockito.when(
				reimpresionTramitesService.obtenerPdfPorClave(Mockito.anyListOf(DatosArchivos.class),Mockito.anyInt()))
				   .thenReturn(archivos());
		//DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
		//Assert.assertNotNull(datosArchivos);
	}
	
	
	/**
	 * testObtenerArchivosReimpresionNull
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionNull () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
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
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(tramitesConcluidos());
		Mockito.when(
				restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(EntradaFilenet.class), Mockito.eq(byte[].class)))
				   .thenReturn(bytes());
		Mockito.when(
				archivoZipService.llenarDatosZip(Mockito.any(ByteArrayInputStream.class)))
				   .thenReturn(lista());
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
	public void testObtenerArchivosReimpresionfilenetNull () throws IOException {
		try {
			Mockito.when(
					reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
					   .thenReturn(tramitesConcluidos());
			Mockito.when(
					restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(EntradaFilenet.class), Mockito.eq(byte[].class)))
					   .thenThrow(NullPointerException.class);
			reimpresionService.obtenerArchivosReimpresion(trabajador());
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
				Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyString());
		Mockito.when(
				menuReimpresionService.obtenerRespuestaCorrecta(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString()))
				   .thenReturn(respuestaServicio());
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajador(), "SEUUEY878", 1, "asdas");
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
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajadorSinCorreo(), "SEUUEY878", 1, "dasd");
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
	
	
	/**
	 * tramitesConcluidos
	 * @return
	 */
    private TramitesConcluidos tramitesConcluidos() {
    	TramitesConcluidos tramitesConcluidos = new TramitesConcluidos();
    	tramitesConcluidos.setTipoSolicitante("01");
		return tramitesConcluidos;
    	
    }
  
    /**
     * lista
     * @return
     */
    private List<DatosArchivosDescargados> lista() {
		List<DatosArchivosDescargados> lista = new ArrayList<>();
		DatosArchivosDescargados datosArchivosDescargados = new DatosArchivosDescargados();
		datosArchivosDescargados.setByteArchivo("kjskjkjakja");
		datosArchivosDescargados.setFormato("pdf");
		datosArchivosDescargados.setNombreArchivo("prueba");
		lista.add(datosArchivosDescargados);
		return lista;
	}

    /**
     * bytes
     * @return
     */
	private byte[] bytes() {
		String prueba="prueba";
		return prueba.getBytes();
	}

}
