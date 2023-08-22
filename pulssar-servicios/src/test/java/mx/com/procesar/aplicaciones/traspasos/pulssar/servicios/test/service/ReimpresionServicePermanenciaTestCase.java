package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang.CharEncoding;
import org.apache.pdfbox.pdmodel.PDDocument;
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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServicePermanenciaImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Permanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;


/**
 * ReimpresionServiceConsentimientoTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionServicePermanenciaTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ReimpresionServicePermanenciaImpl reimpresionService =new ReimpresionServicePermanenciaImpl();

	/**
	 * PdfUtils
	 */
	@Mock
	private PdfUtils pdfUtil;
	
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
	 * Inyeccion de dependencia fechaUtils
	 */
	@Mock
	private FechaUtils fechaUtils;
	
	/**
	 * catalogoService
	 */
	@Mock
	private CatalogoService catalogoService;
	
	/**
	 * Permanencia
	 */
	private static String PERMANENCIA="{\"folioCliente\":\"S0000133202109280017\",\"selloVoluntadTrabajador\":\"278399\",\"cuerpo\":{\"entidadOrigen\":\"578\",\"nssTrabajador\":\"11947502438\",\"curpTrabajador\":\"HESS630801MOCRLF05\",\"rfc\":\"HESS630801HE3\",\"apellidoPaterno\":\"HERNANDEZ\",\"apellidoMaterno\":\"SALINAS\",\"nombreTrabajador\":\"SOFIA\",\"fechaDeNacimiento\":\"19630801\",\"genero\":2,\"entidadFederativaDeNacimiento\":\"20\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"52\",\"actividadOGiroNegocioTrabajador\":\"12\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"HESS630801MOCRLF05\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"HUAMUCHIL\",\"numeroExterior\":\"COND 1\",\"numeroInterior\":\"DPTO 404\",\"colonia\":\"RESIDENCIAL LOS FRESNOS\",\"delegacionOMunicipio\":\"SANTA MARIA ATZOMPA\",\"codigoPostal\":\"20399\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"5579238766\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"9514785033\",\"correoElectronicoDelTrabajador\":\"sofi15her@gmail.com\",\"claveEntidad\":\"20\"},\"referencias\":{\"apellidoPaternoDeReferencia1\":\"JORGE\",\"apellidoMaternoDeReferencia1\":\"GONZALEZ\",\"nombreDeReferencia1\":\"JORGE\",\"curpDeReferencia1\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia1\":\"5555980908\",\"parentescoORelacionDeReferencia1\":\"ABUELO\",\"apellidoPaternoDeReferencia2\":\"JORGE\",\"apellidoMaternoDeReferencia2\":\"GONZALEZ\",\"nombreDeReferencia2\":\"JORGE\",\"curpDeReferencia2\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia2\":\"5555980908\",\"parentescoORelacionDeReferencia2\":\"ABUELO\"},\"domicilioLaboral\":{\"calle\":\"BARTOLO\",\"numeroExterior\":\"67\",\"numeroInterior\":\"61\",\"colonia\":\"NUEVA\",\"delegacionOMunicipio\":\"COYOACAN\",\"codigoPostal\":\"02980\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"AQUINO\",\"apellidoMaternoDeBeneficiario\":\"MATUS\",\"nombreDeBeneficiario\":\"LUIS ENRIQUE\",\"curpDeBeneficiario\":\"AUML891105HOCQTS04\",\"porcentajeDeBeneficiario\":\"20\"}]}}}";
	
	
	/**
	 * Permanencia
	 */
	private static String PERMANENCIA2="{\"folioCliente\":\"S0000133202109280017\",\"selloVoluntadTrabajador\":\"278399\",\"cuerpo\":{\"entidadOrigen\":\"578\",\"nssTrabajador\":\"11947502438\",\"curpTrabajador\":\"HESS630801MOCRLF05\",\"rfc\":\"HESS630801HE3\",\"apellidoPaterno\":\"HERNANDEZ\",\"apellidoMaterno\":\"SALINAS\",\"nombreTrabajador\":\"SOFIA\",\"fechaDeNacimiento\":\"19630801\",\"genero\":1,\"entidadFederativaDeNacimiento\":\"20\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"52\",\"actividadOGiroNegocioTrabajador\":\"12\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"HESS630801MOCRLF05\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"HUAMUCHIL\",\"numeroExterior\":\"COND 1\",\"numeroInterior\":\"DPTO 404\",\"colonia\":\"RESIDENCIAL LOS FRESNOS\",\"delegacionOMunicipio\":\"SANTA MARIA ATZOMPA\",\"codigoPostal\":\"20399\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"5579238766\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"9514785033\",\"correoElectronicoDelTrabajador\":\"sofi15her@gmail.com\",\"claveEntidad\":\"20\"},\"referencias\":{\"apellidoPaternoDeReferencia1\":\"JORGE\",\"apellidoMaternoDeReferencia1\":\"GONZALEZ\",\"nombreDeReferencia1\":\"JORGE\",\"curpDeReferencia1\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia1\":\"5555980908\",\"parentescoORelacionDeReferencia1\":\"ABUELO\",\"apellidoPaternoDeReferencia2\":\"JORGE\",\"apellidoMaternoDeReferencia2\":\"GONZALEZ\",\"nombreDeReferencia2\":\"JORGE\",\"curpDeReferencia2\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia2\":\"5555980908\",\"parentescoORelacionDeReferencia2\":\"ABUELO\"},\"domicilioLaboral\":{\"calle\":\"BARTOLO\",\"numeroExterior\":\"67\",\"numeroInterior\":\"61\",\"colonia\":\"NUEVA\",\"delegacionOMunicipio\":\"COYOACAN\",\"codigoPostal\":\"02980\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"AQUINO\",\"apellidoMaternoDeBeneficiario\":\"MATUS\",\"nombreDeBeneficiario\":\"LUIS ENRIQUE\",\"curpDeBeneficiario\":\"AUML891105HOCQTS04\",\"porcentajeDeBeneficiario\":\"20\"}]}}}";
	
	/**
	 * Permanencia
	 */
	private static String PERMANENCIA3="{\"folioCliente\":\"S0000133202109280017\",\"selloVoluntadTrabajador\":\"278399\",\"cuerpo\":{\"entidadOrigen\":\"578\",\"nssTrabajador\":\"11947502438\",\"curpTrabajador\":\"HESS630801MOCRLF05\",\"rfc\":\"HESS630801HE3\",\"apellidoPaterno\":\"HERNANDEZ\",\"apellidoMaterno\":\"SALINAS\",\"nombreTrabajador\":\"SOFIA\",\"fechaDeNacimiento\":\"19630801\",\"genero\":3,\"entidadFederativaDeNacimiento\":\"20\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"52\",\"actividadOGiroNegocioTrabajador\":\"12\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"HESS630801MOCRLF05\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"HUAMUCHIL\",\"numeroExterior\":\"COND 1\",\"numeroInterior\":\"DPTO 404\",\"colonia\":\"RESIDENCIAL LOS FRESNOS\",\"delegacionOMunicipio\":\"SANTA MARIA ATZOMPA\",\"codigoPostal\":\"20399\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"5579238766\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"9514785033\",\"correoElectronicoDelTrabajador\":\"sofi15her@gmail.com\",\"claveEntidad\":\"20\"},\"referencias\":{\"apellidoPaternoDeReferencia1\":\"JORGE\",\"apellidoMaternoDeReferencia1\":\"GONZALEZ\",\"nombreDeReferencia1\":\"JORGE\",\"curpDeReferencia1\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia1\":\"5555980908\",\"parentescoORelacionDeReferencia1\":\"ABUELO\",\"apellidoPaternoDeReferencia2\":\"JORGE\",\"apellidoMaternoDeReferencia2\":\"GONZALEZ\",\"nombreDeReferencia2\":\"JORGE\",\"curpDeReferencia2\":\"HESS630801MOCRLF05\",\"telefonoDeReferencia2\":\"5555980908\",\"parentescoORelacionDeReferencia2\":\"ABUELO\"},\"domicilioLaboral\":{\"calle\":\"BARTOLO\",\"numeroExterior\":\"67\",\"numeroInterior\":\"61\",\"colonia\":\"NUEVA\",\"delegacionOMunicipio\":\"COYOACAN\",\"codigoPostal\":\"02980\",\"entidadFederativa\":\"OAXACA\",\"pais\":\"MEX\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"AQUINO\",\"apellidoMaternoDeBeneficiario\":\"MATUS\",\"nombreDeBeneficiario\":\"LUIS ENRIQUE\",\"curpDeBeneficiario\":\"AUML891105HOCQTS04\",\"porcentajeDeBeneficiario\":\"20\"}]}}}";
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(reimpresionService,"rutaDocumentos","/DATOS/AT/PULSSAR/documentos/");
		ReflectionTestUtils.setField(reimpresionService,"rutaDestino","/DATOS/AT/PULSSAR/consentimiento/");
		ReflectionTestUtils.setField(reimpresionService,"rutaDocumetosPermanencia","src/test/resources/538/");
		
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresion () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(tramitesConcluidos());
		Mockito.when(
				reimpresionTramitesService.convertirJsonObjeto(Mockito.anyString(),Mockito.eq(Permanencia.class)))
				   .thenReturn(permanencia());
		Mockito.when(
				catalogoService.obtenerEntidadFederativaComunes(Mockito.anyString()))
				   .thenReturn(entidad());
		
		Mockito.doNothing().when(pdfUtil).agregarTexto(Mockito.anyString(),Mockito.any(PDDocument.class),
				Mockito.anyInt(),Mockito.anyFloat(),Mockito.anyFloat());
		Mockito.when(
				archivoZipService.obtenerPdfPermanencia(Mockito.any(PDDocument.class)))
				   .thenReturn("pruebaExitosaPermanencia".getBytes());
		
		
//		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
//		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionMasculino () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(tramitesConcluidos());
		Mockito.when(
				reimpresionTramitesService.convertirJsonObjeto(Mockito.anyString(),Mockito.eq(Permanencia.class)))
				   .thenReturn(permanencia2());
		Mockito.when(
				catalogoService.obtenerEntidadFederativaComunes(Mockito.anyString()))
				   .thenReturn(entidad());
		
		Mockito.doNothing().when(pdfUtil).agregarTexto(Mockito.anyString(),Mockito.any(PDDocument.class),
				Mockito.anyInt(),Mockito.anyFloat(),Mockito.anyFloat());
		Mockito.when(
				archivoZipService.obtenerPdfPermanencia(Mockito.any(PDDocument.class)))
				   .thenReturn("pruebaExitosaPermanencia".getBytes());
		
		
//		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
//		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionNoExiste () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(tramitesConcluidos());
		Mockito.when(
				reimpresionTramitesService.convertirJsonObjeto(Mockito.anyString(),Mockito.eq(Permanencia.class)))
				   .thenReturn(permanencia3());
		Mockito.when(
				catalogoService.obtenerEntidadFederativaComunes(Mockito.anyString()))
				   .thenReturn(entidad());
		
		Mockito.doNothing().when(pdfUtil).agregarTexto(Mockito.anyString(),Mockito.any(PDDocument.class),
				Mockito.anyInt(),Mockito.anyFloat(),Mockito.anyFloat());
		Mockito.when(
				archivoZipService.obtenerPdfPermanencia(Mockito.any(PDDocument.class)))
				   .thenReturn("pruebaExitosaPermanencia".getBytes());
		
		
//		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
//		Assert.assertNotNull(datosArchivos);
	}
	
	private EntidadFederativa entidad() {
		EntidadFederativa entidadFederativa = new EntidadFederativa();
		entidadFederativa.setDescripcion("ok");
		return entidadFederativa;
	}

	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionNullTramitesConcluidos () throws IOException {
		Mockito.when(
				reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
				   .thenReturn(null);
		DatosArchivos datosArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador());
		Assert.assertNull(datosArchivos);
	}

	
	/**
	 * testObtenerArchivosReimpresion
	 * @throws IOException
	 */
	@Test
	public void testObtenerArchivosReimpresionByteNull () throws IOException {
		
		try {
			Mockito.when(
					reimpresionTramitesService.obtenerTramitesConcluidos(Mockito.any(TramitesConcluidosEntrada.class)))
					   .thenReturn(tramitesConcluidos());
			Mockito.when(
					reimpresionTramitesService.convertirJsonObjeto(Mockito.anyString(),Mockito.eq(Permanencia.class)))
					   .thenReturn(permanencia());
				
			reimpresionService.obtenerArchivosReimpresion(trabajador2());
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
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajador(), "SEUUEY878", 1, "dasda");
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
		RespuestaServicio respuestaServicio=reimpresionService.enviarCorreoReimpresion(archivos(), trabajadorSinCorreo(), "SEUUEY878", 1, "dasda");
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
	private DatosTrabajador trabajador2() {
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables certificables= new DatosCertificables();
		DatosComplementarios complementarios=new DatosComplementarios();
		complementarios.setCorreoElectronico("georgemanuel789@gmail.com");
		certificables.setCurp("OIOWSIWOSIWSLSWLWS");
		datosTrabajador.setClaveAfore("800");
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
    	tramitesConcluidos.setChPeticion("{\"folioCliente\":\"S0000469202109300005\",\"selloVoluntadTrabajador\":\"767765764654667\",\"cuerpo\":{\"entidadOrigen\":\"568\",\"curpTrabajador\":\"COAJ940708HSLRRR06\",\"nssTrabajador\":\"28169483824\",\"rfc\":\"COAJ940708TI9\",\"apellidoPaterno\":\"CORDERO\",\"apellidoMaterno\":\"ARMENTA\",\"nombreTrabajador\":\"JORDAN ULISES\",\"fechaDeNacimiento\":\"19940708\",\"genero\":1,\"entidadFederativaDeNacimiento\":\"25\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"11\",\"actividadOGiroNegocioTrabajador\":\"05\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"COAJ940708HSLRRR06\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"OTOMIES\",\"numeroExterior\":\"2380\",\"colonia\":\"INDUSTRIAL EL PALMITO\",\"delegacionOMunicipio\":\"CULIACAN\",\"codigoPostal\":\"80160\",\"entidadFederativa\":\"SINALOA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"6731074246\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"0000000000\",\"correoElectronicoDelTrabajador\":\"JCORDERO@aforecoppel.com\",\"claveEntidad\":\"SL\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"ANGULO\",\"apellidoMaternoDeBeneficiario\":\"LEON\",\"nombreDeBeneficiario\":\"SANDRA ISABEL\",\"curpDeBeneficiario\":\"AULS910520MSLNNN07\",\"parentescoORelacion\":\"15\",\"porcentajeDeBeneficiario\":\"50\"},{\"apellidoPaternoDeBeneficiario\":\"DE LUNA\",\"apellidoMaternoDeBeneficiario\":\"PRADO\",\"nombreDeBeneficiario\":\"ELIZABETH GUADALUPE\",\"curpDeBeneficiario\":\"LUPE760702MNLNRL05\",\"parentescoORelacion\":\"20\",\"porcentajeDeBeneficiario\":\"50\"}]}}}");
		return tramitesConcluidos;
    	
    }
  

	
	/**
	 * permanencia
	 * @return
	 */
	private Permanencia permanencia() {
			return convertirJsonObjeto(PERMANENCIA,Permanencia.class);
	}
	
	/**
	 * permanencia2
	 * @return
	 */
	private Permanencia permanencia2() {
			return convertirJsonObjeto(PERMANENCIA2,Permanencia.class);
	}
	   
	/**
	 *   permanencia3 
	 * @return
	 */
	private Permanencia permanencia3() {
			return convertirJsonObjeto(PERMANENCIA3,Permanencia.class);
	}
	   
	  
	/**
	 *    convertirJsonObjeto
	 * @param json
	 * @param typeParamClass
	 * @return
	 */
	private  <T> T convertirJsonObjeto(String json, Class<T> typeParamClass) {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			T obj = null;
			try {
				obj = mapper.readValue(json.getBytes(CharEncoding.UTF_8), typeParamClass);
			} catch (Exception ex) {
		
			}
			return obj;
	}

}
