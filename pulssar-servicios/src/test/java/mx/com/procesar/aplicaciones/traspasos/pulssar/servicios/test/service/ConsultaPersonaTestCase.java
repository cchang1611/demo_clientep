package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.RequestMethod;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteRecertificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RespuestaDeepDiveService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
//		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
//		PulssarCorreoAplicationContextTest.class })
public class ConsultaPersonaTestCase extends BaseTestCase{
	@Autowired
	private ConsultarPersonaCertificablesService servicioConsulta;
	
	@Autowired
	private ConsultarPersonaCertificablesService consultarPersonaCertificablesService;
	
	@Autowired
	private FolioService folioService;
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private RespuestaDeepDiveService respuestaDeepDiveService;
	
	@Autowired
	private SaldosPreliminaresService saldosPreliminaresService;
	
	@Autowired
	private ExpedienteRecertificacionService expedienteRecertificacionService;
	
	@Autowired
	private ResolucionParcialService resolucionParcialService;
	
	@Autowired
	private CanaseService canaseService;

	
	

	
	
	
	
	
//	/**
//	 * Inyeccion de servicio
//	 */
//	@Autowired
//	@InjectMocks
//	private ConsultarPersonaCertificablesService servicioConsulta = new ConsultarPersonaCertificableServiceImpl();
//	/**
//	 * dependencia utilidad validador
//	 */
//	@Mock 
//	private ValidadorUtils validadorUtilidad;
//	
//	/**
//	 * dependencia cadena
//	 */
//	@Mock 
//	private CadenasUtils utileriaCadena;
//	
//	/**
//	 * dependencia clienteServicio
//	 */
//	@Autowired
//	@Mock
//	private RestTemplate clienteServicio;
//	
//	/**
//	 * servicio folio
//	 */
//	@Mock
//	private FolioService servicioFolio;
//	
//	/**
//	 * Inyeccion de servicio catalgoo
//	 */
//	@Mock
//	private CatalogoService servicioCatalogo;
//	
//	/**
//	 * Set up
//	 */
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
	
	/**
	 * servidor mock
	 */
	static WireMockServer wm ;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		if(wm == null) {
			wm = new WireMockServer(options().port(9999));
		}
		wm.start();
		
		// monioreo de capa de trasporte
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if(wm.isRunning()) {
			wm.stop();
			wm.shutdownServer();
		}
	}
	
  @Before	
	public void setUpBefore() {
	  cambioMock(consultarPersonaCertificablesService,"consultaPersonaNss");
	  cambioMock(consultarPersonaCertificablesService,"consultaPersonaCurp");
	  cambioMock(consultarPersonaCertificablesService,"consultaExpediente");	  
	  cambioMock(consultarPersonaCertificablesService,"consultaEstatusExpediente");	  
	  cambioMock(consultarPersonaCertificablesService,"uriIdProcesar");	  
	  cambioMock(consultarPersonaCertificablesService,"consultaMarcas");
	  cambioMock(consultarPersonaCertificablesService,"consultaCurpDuplicada");	  
	  cambioMock(consultarPersonaCertificablesService,"uriFotoPersona");
	  cambioMock(consultarPersonaCertificablesService,"kardexUri");	  
	  cambioMock(consultarPersonaCertificablesService,"uriComunes");
	  cambioMock(consultarPersonaCertificablesService,"uriRenapo");	  
	  cambioMock(consultarPersonaCertificablesService,"consultaAforeActivo");
	  cambioMock(consultarPersonaCertificablesService,"consultarEntidad");
	  cambioMock(saldosPreliminaresService,"servicioComunes");
	  cambioMock6690(folioService,"urlFolioServicio");
	  cambioMock(catalogoService,"servicioCatalogo");
	  cambioMock(catalogoService,"servicioParametro");
	  cambioMock(catalogoService,"servicioIcefa");
	  cambioMock(respuestaDeepDiveService,"urlValidaIdentificacionDomicilio");	
	  cambioMock(expedienteRecertificacionService,"uriRecertificacion");
	  cambioMock(resolucionParcialService,"uriComunes");
	  cambioMock(canaseService,"uriConsultaCanase");
	  
	  
	  
	  
	  
	}
	    
    @After
    public void setUpAfter() {
    	cambio(consultarPersonaCertificablesService,"consultaPersonaNss");	 
    	cambio(consultarPersonaCertificablesService,"consultaPersonaCurp");
    	cambio(consultarPersonaCertificablesService,"consultaExpediente");
    	cambio(consultarPersonaCertificablesService,"consultaEstatusExpediente");
    	cambio(consultarPersonaCertificablesService,"uriIdProcesar");
    	cambio(consultarPersonaCertificablesService,"consultaMarcas");
    	cambio(consultarPersonaCertificablesService,"consultaCurpDuplicada");
    	cambio(consultarPersonaCertificablesService,"uriFotoPersona");
    	cambio(consultarPersonaCertificablesService,"kardexUri");
    	cambio(consultarPersonaCertificablesService,"uriComunes");
    	cambio(consultarPersonaCertificablesService,"uriRenapo");	
    	cambio(consultarPersonaCertificablesService,"consultaAforeActivo");
    	cambioMock(consultarPersonaCertificablesService,"consultarEntidad");
    	cambio(saldosPreliminaresService,"servicioComunes");
    	cambio6690(folioService,"urlFolioServicio");
    	cambio(catalogoService,"servicioCatalogo");
    	cambio(catalogoService,"servicioParametro");
    	cambio(catalogoService,"servicioIcefa");
    	cambio(respuestaDeepDiveService,"urlValidaIdentificacionDomicilio");
    	cambio(expedienteRecertificacionService,"uriRecertificacion");
    	cambio(resolucionParcialService,"uriComunes");
    	cambio(canaseService,"uriConsultaCanase");
    }
		
	
	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testConsultarPersona() {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="[{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}]";
		super.crearStub(wm, "/comunesPulssar/trabajador/curp/MELN780703MDFNNN06", 200, persona, RequestMethod.GET);

		String folio="{\"idUsuario\":\"54\",\"sucursal\":\"SUC\",\"folio\":\"S0000054202108190019\",\"operacion\":\"S\",\"curp\":\"AAAA900909XXXXXX09\",\"nss\":\"12345678911\",\"descripcion\":\"Desempleo APP\",\"servicio\":\"S22\",\"proceso\":\"S22P1\",\"idFolio\":\"64369\",\"resultado\":\"01\",\"tiempoLlegada\":\"00:00\"}";
		super.crearStub(wm, "/portalservicios/v1/folio", 200, folio, RequestMethod.POST);
		
		String nacionalidad="{\"id\":1,\"cvNacionalidad\":\"1\",\"chDescripcion\":\"MEXICANA:MEXICO\",\"chValorDespliegue\":\"MEX\",\"fechaControl\":1499805520000,\"usuarioModificador\":\"LEDOTAD_OS\"}";
		super.crearStub(wm, "/comunesPulssar/catalogo/nacionalidad/clave/1", 200, nacionalidad, RequestMethod.GET);
		
		String expedientes="{\"codigoOperacion\":\"1\",\"codigoRechazo\":null,\"mensaje\":\"OK\",\"response\":{\"estatusExpedienteIdentificacion\":\"2\",\"claveExpedienteIdentificacion\":\"552\",\"tipoIDE\":\"0\",\"fechaIDE\":1420178400000,\"expedienteMovil\":\"0\",\"estatusEnrolamiento\":\"2\",\"calidadHuellas\":\"1\",\"fechaEnrolamiento\":1420178400000,\"listaHuellas\":[{\"posicionDedo\":1,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":2,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":3,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":4,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":5,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":6,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":7,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":8,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":9,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"},{\"posicionDedo\":10,\"calidadHuella\":1,\"dispositivo\":\"1304-00458\"}],\"claveAforeExpBiometrico\":\"552\",\"descAforeExpBiometrico\":\"CITIBANAMEX AFORE\",\"claveAforeExpIdentificacion\":\"552\",\"descAforeExpIdentificacion\":\"CITIBANAMEX AFORE\",\"claveTipoProcesoExpIdentificacion\":\"01\",\"curpHistoricaConsultada\":false,\"curpConsultada\":\"MELN780703MDFNNN06\",\"rol\":\"1\",\"rolCurp\":\"TRABAJADOR\"}}";
		super.crearStub(wm, "/comunesPulssar/expediente/MELN780703MDFNNN06", 200, expedientes, RequestMethod.GET);

		String estadosExp="{\"claveEstatusExp\":\"2\",\"chDescripcionExp\":\"TEMPORAL\",\"chUsuarioModificador\":\"MIGRACION\",\"fechaControl\":1455071745000}";
		super.crearStub(wm, "/comunesPulssar/catalogo/estatus/2", 200, estadosExp, RequestMethod.GET);

		String ocrDomicilio="[{\"archivoRecibido\":{\"id\":1714,\"claveAfore\":\"578\",\"folioCliente\":\"0000149202003100001\",\"folioPulsar\":{\"idFolioPulssar\":36049,\"idServicio\":110,\"idUsuarioPulssar\":187,\"chFolio\":\"S0000187202005080001\",\"descripcion\":\"Modificacion de Datos P\",\"sucursal\":\"SUC\",\"curp\":\"CEMA680702HSPDRN00\",\"estatus\":0,\"fechaGeneracion\":\"08/05/2020\",\"fechaControl\":\"08/05/2020\",\"usuarioModificador\":\"FOLIADOR_PULSSAR\",\"fechaLlegada\":\"08/05/2020\",\"folioDetalles\":[{\"idFolioPulssarDetalle\":14794,\"idFolioPulssar\":36049,\"idProceso\":217,\"estatus\":0,\"fechaControl\":1588972965000,\"usuarioModificador\":\"FOLIADOR_PULSSAR\"}],\"idFolioPulssarPadre\":32244,\"estatusPadre\":3},\"curpEmpleado\":\"ROGA671108HMCCTL00\",\"curpTrabajador\":\"CEMA680702HSPDRN00\",\"tipoArchivo\":{\"clave\":\"02\",\"descripcion\":\"Documentos digitalizados para conformar expediente\",\"usuarioModificador\":\"GOB_MODELADO\"},\"rutaArchivo\":\"D:/DATOS/AT/pulssar/EXPEDIENTE/expedienteOK.zip\",\"tipoProceso\":\"01\",\"resultadoOperacion\":\"02\",\"diagnostico\":\"030\",\"motivoRechazo\":null,\"etapa\":{\"clave\":\"11\",\"nombre\":\"Notificación tramite  de riesgo\",\"fechaControl\":[2019,11,19,19,40,30],\"usuarioModificador\":\"ARQ_DATOS\"},\"fechaOperacion\":[2020,3,10,11,39],\"folio\":\"578\",\"folioProcesarRecibido\":\"S0005187202005080001\",\"tipoArchivoRecibido\":\"02\",\"fechaControl\":[2020,3,10,11,44,41],\"usuarioModificador\":\"RECEPCION_ARCHIVOS_PULSSAR\"},\"fechaControl\":[2020,1,9,0,0],\"usuarioModificador\":\"USUARIO\",\"id\":47,\"codigoRespuesta\":\"100\",\"similitudDomicilio\":60,\"entidadFederativa\":\"MC\",\"cp\":\"789654\",\"municipio\":\"XXXX\",\"numeroExterior\":\"75\",\"calle\":\"calle num\",\"consistenciaProcesar\":\"false\",\"consistenciaComprobante\":\"true\"}]";
		super.crearStub(wm, "/comunesPulssar/ocr/domicilio/578/MELN780703MDFNNN06/02/01", 200, ocrDomicilio, RequestMethod.GET);

		String ocrIdentificacion="[{\"archivoRecibido\":{\"id\":1714,\"claveAfore\":\"578\",\"folioCliente\":\"0000149202003100001\",\"folioPulsar\":{\"idFolioPulssar\":36049,\"idServicio\":110,\"idUsuarioPulssar\":187,\"chFolio\":\"S0000187202005080001\",\"descripcion\":\"Modificacion de Datos P\",\"sucursal\":\"SUC\",\"curp\":\"CEMA680702HSPDRN00\",\"estatus\":0,\"fechaGeneracion\":\"08/05/2020\",\"fechaControl\":\"08/05/2020\",\"usuarioModificador\":\"FOLIADOR_PULSSAR\",\"fechaLlegada\":\"08/05/2020\",\"folioDetalles\":[{\"idFolioPulssarDetalle\":14794,\"idFolioPulssar\":36049,\"idProceso\":217,\"estatus\":0,\"fechaControl\":1588972965000,\"usuarioModificador\":\"FOLIADOR_PULSSAR\"}],\"idFolioPulssarPadre\":32244,\"estatusPadre\":3},\"curpEmpleado\":\"ROGA671108HMCCTL00\",\"curpTrabajador\":\"CEMA680702HSPDRN00\",\"tipoArchivo\":{\"clave\":\"02\",\"descripcion\":\"Documentos digitalizados para conformar expediente\",\"usuarioModificador\":\"GOB_MODELADO\"},\"rutaArchivo\":\"D:/DATOS/AT/pulssar/EXPEDIENTE/expedienteOK.zip\",\"tipoProceso\":\"01\",\"resultadoOperacion\":\"02\",\"diagnostico\":\"030\",\"motivoRechazo\":null,\"etapa\":{\"clave\":\"11\",\"nombre\":\"Notificación tramite  de riesgo\",\"fechaControl\":[2019,11,19,19,40,30],\"usuarioModificador\":\"ARQ_DATOS\"},\"fechaOperacion\":[2020,3,10,11,39],\"folio\":\"578\",\"folioProcesarRecibido\":\"S0005187202005080001\",\"tipoArchivoRecibido\":\"02\",\"fechaControl\":[2020,3,10,11,44,41],\"usuarioModificador\":\"RECEPCION_ARCHIVOS_PULSSAR\"},\"fechaControl\":[2020,1,9,0,0],\"usuarioModificador\":\"USUARIO\",\"id\":47,\"codigoRespuesta\":\"100\",\"similitudDomicilio\":60,\"entidadFederativa\":\"MC\",\"cp\":\"789654\",\"municipio\":\"XXXX\",\"numeroExterior\":\"75\",\"calle\":\"calle num\",\"consistenciaProcesar\":\"false\",\"consistenciaComprobante\":\"true\"}]";
		super.crearStub(wm, "/comunesPulssar/ocr/identificacion/578/MELN780703MDFNNN06/02/01", 200, ocrIdentificacion, RequestMethod.GET);

		
		DatosTrabajador trabajador = servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		assertNotNull(trabajador);
	}
	

	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testObtenerUrlConsulta_nss() {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		entrada.setNss("12345678901");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="[{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}]";
		super.crearStub(wm, "/comunesPulssar/trabajador/nss/12345678901/curp/MELN780703MDFNNN06", 200, persona, RequestMethod.GET);

		String folio="{\"idUsuario\":\"54\",\"sucursal\":\"SUC\",\"folio\":\"S0000054202108190019\",\"operacion\":\"S\",\"curp\":\"AAAA900909XXXXXX09\",\"nss\":\"12345678911\",\"descripcion\":\"Desempleo APP\",\"servicio\":\"S22\",\"proceso\":\"S22P1\",\"idFolio\":\"64369\",\"resultado\":\"01\",\"tiempoLlegada\":\"00:00\"}";
		super.crearStub(wm, "/portalservicios/v1/folio", 200, folio, RequestMethod.POST);
		
		String nacionalidad="{\"id\":1,\"cvNacionalidad\":\"1\",\"chDescripcion\":\"MEXICANA:MEXICO\",\"chValorDespliegue\":\"MEX\",\"fechaControl\":1499805520000,\"usuarioModificador\":\"LEDOTAD_OS\"}";
		super.crearStub(wm, "/comunesPulssar/catalogo/nacionalidad/clave/1", 200, nacionalidad, RequestMethod.GET);
		
		String expedientes="{\"codigoOperacion\":\"1\",\"codigoRechazo\":null,\"mensaje\":\"OK\",\"response\":{\"estatusExpedienteIdentificacion\":\"2\",\"claveExpedienteIdentificacion\":\"552\",\"tipoIDE\":\"0\",\"fechaIDE\":1420178400000,\"expedienteMovil\":\"0\",\"estatusEnrolamiento\":\"2\",\"calidadHuellas\":\"0\",\"fechaEnrolamiento\":1420178400000,\"claveAforeExpBiometrico\":\"552\",\"descAforeExpBiometrico\":\"CITIBANAMEX AFORE\",\"claveAforeExpIdentificacion\":\"552\",\"descAforeExpIdentificacion\":\"CITIBANAMEX AFORE\",\"claveTipoProcesoExpIdentificacion\":\"01\",\"curpHistoricaConsultada\":false,\"curpConsultada\":\"MELN780703MDFNNN06\",\"rol\":\"1\",\"rolCurp\":\"TRABAJADOR\"}}";
		super.crearStub(wm, "/comunesPulssar/expediente/MELN780703MDFNNN06", 200, expedientes, RequestMethod.GET);

		String estadosExp="{\"claveEstatusExp\":\"2\",\"chDescripcionExp\":\"TEMPORAL\",\"chUsuarioModificador\":\"MIGRACION\",\"fechaControl\":1455071745000}";
		super.crearStub(wm, "/comunesPulssar/catalogo/estatus/2", 200, estadosExp, RequestMethod.GET);

		String ocrDomicilio="[]";
		super.crearStub(wm, "/comunesPulssar/ocr/domicilio/MELN780703MDFNNN06/578/02/01", 200, ocrDomicilio, RequestMethod.GET);

		String ocrIdentificacion="[]";
		super.crearStub(wm, "/comunesPulssar/ocr/identificacion/MELN780703MDFNNN06/578/02/01", 200, ocrIdentificacion, RequestMethod.GET);

		
		DatosTrabajador trabajador = servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		assertNotNull(trabajador);
	}
	
	
	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testValidarDatosEntrada_nss_curp() {
		try {
			EntradaConsulta entrada = new EntradaConsulta();			
			entrada.setTimerPicker("18:08");
			entrada.setClaveAfore("578");
			servicioConsulta.consultarPersona(entrada, 2L, "122", "sucursal");
			fail();
		} catch (BusinessException e) {
			assertEquals(BusinessErrorEnum.DATOS_NO_CAPTURADOS.getClave(), e.getCodigo());
		}
	}
	
	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testValidarDatosEntrada_hora() {
		try {
			EntradaConsulta entrada = new EntradaConsulta();
			entrada.setCurp("MELN780703MDFNNN06");
			entrada.setClaveAfore("578");
			servicioConsulta.consultarPersona(entrada, 2L, "122", "sucursal");
			fail();
		} catch (BusinessException e) {
			assertEquals(BusinessErrorEnum.HORARIO_NO_CAPTURADO.getClave(), e.getCodigo());
		}
	}
	
	
	
	
	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testInvocarServicioConsultaPersona_idProcesar() {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		entrada.setIdProcesar("2715");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}";
		super.crearStub(wm, "/comunesPulssar/trabajador/idProcesar/2715", 200, persona, RequestMethod.GET);

		String folio="{\"idUsuario\":\"54\",\"sucursal\":\"SUC\",\"folio\":\"S0000054202108190019\",\"operacion\":\"S\",\"curp\":\"AAAA900909XXXXXX09\",\"nss\":\"12345678911\",\"descripcion\":\"Desempleo APP\",\"servicio\":\"S22\",\"proceso\":\"S22P1\",\"idFolio\":\"64369\",\"resultado\":\"01\",\"tiempoLlegada\":\"00:00\"}";
		super.crearStub(wm, "/portalservicios/v1/folio", 200, folio, RequestMethod.POST);
		
		String nacionalidad="{\"id\":1,\"cvNacionalidad\":\"1\",\"chDescripcion\":\"MEXICANA:MEXICO\",\"chValorDespliegue\":\"MEX\",\"fechaControl\":1499805520000,\"usuarioModificador\":\"LEDOTAD_OS\"}";
		super.crearStub(wm, "/comunesPulssar/catalogo/nacionalidad/clave/1", 200, nacionalidad, RequestMethod.GET);
		
		String expedientes="{\"codigoOperacion\":\"1\",\"codigoRechazo\":null,\"mensaje\":\"OK\",\"response\":{\"estatusExpedienteIdentificacion\":\"2\",\"claveExpedienteIdentificacion\":\"552\",\"tipoIDE\":\"0\",\"fechaIDE\":1420178400000,\"expedienteMovil\":\"0\",\"estatusEnrolamiento\":\"2\",\"calidadHuellas\":\"0\",\"fechaEnrolamiento\":1420178400000,\"claveAforeExpBiometrico\":\"552\",\"descAforeExpBiometrico\":\"CITIBANAMEX AFORE\",\"claveAforeExpIdentificacion\":\"552\",\"descAforeExpIdentificacion\":\"CITIBANAMEX AFORE\",\"claveTipoProcesoExpIdentificacion\":\"01\",\"curpHistoricaConsultada\":false,\"curpConsultada\":\"MELN780703MDFNNN06\",\"rol\":\"1\",\"rolCurp\":\"TRABAJADOR\"}}";
		super.crearStub(wm, "/comunesPulssar/expediente/MELN780703MDFNNN06", 200, expedientes, RequestMethod.GET);

		String estadosExp="{\"claveEstatusExp\":\"2\",\"chDescripcionExp\":\"TEMPORAL\",\"chUsuarioModificador\":\"MIGRACION\",\"fechaControl\":1455071745000}";
		super.crearStub(wm, "/comunesPulssar/catalogo/estatus/2", 200, estadosExp, RequestMethod.GET);

		String ocrDomicilio="[]";
		super.crearStub(wm, "/comunesPulssar/ocr/domicilio/MELN780703MDFNNN06/578/02/01", 200, ocrDomicilio, RequestMethod.GET);

		String ocrIdentificacion="[]";
		super.crearStub(wm, "/comunesPulssar/ocr/identificacion/MELN780703MDFNNN06/578/02/01", 200, ocrIdentificacion, RequestMethod.GET);

		
		DatosTrabajador trabajador = servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		assertNotNull(trabajador);
	}
	
	/**
	 * Test Para consulta de persona
	 */
	@Test
	public void testInvocarServicioConsultaPersona_error() {
		try {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		entrada.setIdProcesar("2715");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}";
		super.crearStub(wm, "/comunesPulssar/trabajador/idProcesar/2715", 404, persona, RequestMethod.GET);

		servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		fail();
		}catch(GenericException e) {
			assertEquals(BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), e.getCodigo());
		}

		
		
	}
	
	@Test
	public void testConsultarTrabajador_error() {
		try {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		//entrada.setNss("34947380688");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="[]";
		super.crearStub(wm, "/comunesPulssar/trabajador/curp/MELN780703MDFNNN06", 200, persona, RequestMethod.GET);

		String folio="{\"idUsuario\":\"54\",\"sucursal\":\"SUC\",\"folio\":\"S0000054202108190019\",\"operacion\":\"S\",\"curp\":\"AAAA900909XXXXXX09\",\"nss\":\"12345678911\",\"descripcion\":\"Desempleo APP\",\"servicio\":\"S22\",\"proceso\":\"S22P1\",\"idFolio\":\"64369\",\"resultado\":\"01\",\"tiempoLlegada\":\"00:00\"}";
		super.crearStub(wm, "/portalservicios/v1/folio", 200, folio, RequestMethod.POST);
		
		
		servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		fail();
		}catch(BusinessException e) {
			assertEquals(BusinessErrorEnum.TRABAJADOR_NO_ENCONTRADO.getClave(), e.getCodigo());
		}
	}
	
	@Test
	public void testObtenerPersonaValida_error() {
		try {
		EntradaConsulta entrada  = new EntradaConsulta();
		entrada.setCurp("MELN780703MDFNNN06");
		entrada.setTimerPicker("18:08");
		entrada.setClaveAfore("578");
		
		String persona="[{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"552\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}]";
		super.crearStub(wm, "/comunesPulssar/trabajador/curp/MELN780703MDFNNN06", 200, persona, RequestMethod.GET);

		
		servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
		fail();
		}catch(BusinessException e) {
			assertEquals(BusinessErrorEnum.TRABAJADOR_AFORE_DISTINTA.getClave(), e.getCodigo());
		}
		
		
		
		
	}
	
	
	/**
	 * Test para obtener datos adicionales
	 */
	@Test
	public void testObtenerDatosAdicionales() {
//		ParametrosSalidaMarca salidaMarca1 = new ParametrosSalidaMarca();
//		salidaMarca1.setClaveProceso("claveProceso");
//		salidaMarca1.setDescripcionProceso("descripcionProceso");
//		ParametrosSalidaMarca salidaMarca2 = new ParametrosSalidaMarca();
//		salidaMarca2.setClaveProceso("claveProceso");
//		salidaMarca2.setDescripcionProceso("descripcionProceso");
//		
//		List<ParametrosSalidaMarca> listaMarca = new ArrayList<>();
//		listaMarca.add(salidaMarca1);
//		listaMarca.add(salidaMarca2);
//		
//		JsonUtilsImpl<String> salidaJson = new JsonUtilsImpl<>();
//		String jsonMarca = salidaJson.parseListObjectToJson(listaMarca);
//		
//		List<String> listaAfore = new ArrayList<>();
//		listaAfore.add("556");
//		CurpDuplicada curpDuplicada = new CurpDuplicada();
//		curpDuplicada.setClaveAfore(listaAfore);
//		curpDuplicada.setCodigoOperacion("01");
//		
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("MELN780703MDFNNN06");
		datosCertificables.setGenero("FEMENINO");
		datosCertificables.setFechaNacimiento("03/julio/1978");
		datosCertificables.setEntidadNacimiento("CIUDAD DE MEXICO");
		
		DatosTrabajador auxiliarTrabajador = new DatosTrabajador();
		auxiliarTrabajador.setProcesar(2715L);
		auxiliarTrabajador.setNss("12345678965");
		auxiliarTrabajador.setTipoAfiliacion("2");
		auxiliarTrabajador.setClaveAfore("552");
		auxiliarTrabajador.setNombreTrabajador("NINEL MENDEZ LEON");
		auxiliarTrabajador.setDatosCertificables(datosCertificables);
		
		DatosExpediente datosExpediente= new DatosExpediente();
		datosExpediente.setAforeIdentificacion("552");
		auxiliarTrabajador.setDatosExpediente(datosExpediente);
		
		
//		List<String> icefas = new ArrayList<>();
//		icefas.add("1");
//		icefas.add("2");
//		ListaIcefasDisponiblesSaldo icefasDisponibles = new ListaIcefasDisponiblesSaldo();
//		icefasDisponibles.setIcefasDisponible(icefas);
//		ConsultarKardexSalida salidaKardex = new ConsultarKardexSalida();
//		salidaKardex.setNombreImss("nombre");
//		salidaKardex.setIndicadorRetiroDesempleo("01");
//		RetiroHistoricoAportacion retiroAportacion = new RetiroHistoricoAportacion();
//		ResponseEntity<RetiroHistoricoAportacion> respuestaEntity = new ResponseEntity<>(retiroAportacion,HttpStatus.ACCEPTED);
//		
//		Parametro parametro = new Parametro();
//		parametro.setChParametro("chParametro");
//		parametro.setChValorParametro("chValorParametro");
//		parametro.setCvParametro("cvParametro");
//		
//		List<Parametro> listaParametro = new ArrayList<>();
//		listaParametro.add(parametro);
//		
//		Icefa icefa1 = new Icefa();
//		icefa1.setClaveIcefa("claveIcefa");
//		icefa1.setDescripcionIcefa("descripcionIcefa");
//		Icefa icefa2 = new Icefa();
//		icefa2.setClaveIcefa("claveIcefa");
//		icefa2.setDescripcionIcefa("descripcionIcefa");
//		List<Icefa> listaIcefa = new ArrayList<>();
//		listaIcefa.add(icefa1);
//		listaIcefa.add(icefa2);
//		salidaKardex.setListaIcefasDisponiblesSaldo(icefasDisponibles);
		
		
//		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("curp", null)).thenReturn("curp");
//		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios("12345678965", null)).thenReturn("12345678965");
//		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("curp");
//		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("curp");
//		Mockito.when(clienteServicio.getForObject(Mockito.anyString(), Mockito.eq(String.class))).thenReturn(jsonMarca);
//		Mockito.when(validadorUtilidad.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
//		Mockito.when(clienteServicio.getForObject(Mockito.anyString(), Mockito.eq(CurpDuplicada.class))).thenReturn(curpDuplicada);
//		Mockito.when(validadorUtilidad.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
//		Mockito.when(clienteServicio.getForObject(Mockito.anyString(), Mockito.eq(ConsultarKardexSalida.class))).thenReturn(salidaKardex);
//		Mockito.when(clienteServicio.getForEntity(Mockito.anyString(), Mockito.eq(RetiroHistoricoAportacion.class))).thenReturn(respuestaEntity);
//		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
//		Mockito.when(servicioCatalogo.obtenerIcefa(Mockito.anyString())).thenReturn(listaIcefa);
		
		
		String marca="[{\"claveProceso\":\"9E00\",\"descripcionProceso\":\"CUENTA INDIVIDUAL NUEVO\"}]";
		super.crearStub(wm, "/comunesPulssar/validar/consultarMarcas/2715", 200, marca, RequestMethod.GET);

		String curpDuplicada="{\"codigoOperacion\":\"01\",\"claveAfore\":[\"578\"]}";
		super.crearStub(wm, "/comunesPulssar/trabajador/curpDuplicada/MELN780703MDFNNN06/2715", 200, curpDuplicada, RequestMethod.GET);

		String afore="{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"}";
		super.crearStub(wm, "/comunesPulssar/catalogo/afores/578", 200, afore, RequestMethod.GET);
		
		String imagen="";
		super.crearStub(wm, "/comunesPulssar/trabajador/fotoTrabajador/MELN780703MDFNNN06/552/01,02/", 200, imagen, RequestMethod.GET);
		
		String kardex="{\"nombreImss\":\"nombre\",\"indicadorRetiroDesempleo\":\"1\",\"listaIcefasDisponiblesSaldo\":{\"icefasDisponible\":[\"002\"]}}";
		super.crearStub(wm, "/comunesPulssar/kardex/consulta/552/MELN780703MDFNNN06/12345678965", 200, kardex, RequestMethod.GET);

		
		String parametro="[{\"idParametro\":8258,\"cvParametro\":\"P02556\",\"chParametro\":\"IMSS\",\"chValorParametro\":\"2,10\",\"fechaModificacion\":1562907600000,\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"},{\"idParametro\":8259,\"cvParametro\":\"P02556\",\"chParametro\":\"ISSSTE\",\"chValorParametro\":\"4,5\",\"fechaModificacion\":1562907600000,\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"}]";
		super.crearStub(wm, "/comunesPulssar/catalogo/parametro/P02556", 200, parametro, RequestMethod.GET);

		String factura="{\"salario\":91.75,\"periodo\":\"201501\",\"indicadorRetiroDesempleo\":1}";
		super.crearStub(wm, "/comunesPulssar/factura/consultarfacturaid/2715", 200, factura, RequestMethod.GET);
		
		String renapo="{\"CURP\":\"MELN780703MDFNNN06\",\"apellido1\":\"MENDEZ\",\"apellido2\":\"LEON\",\"nombres\":\"NINEL\",\"sexo\":\"M\",\"fechNac\":\"03/07/1978\",\"nacionalidad\":\"MEX\",\"docProbatorio\":\"1\",\"anioReg\":\"1978\",\"foja\":\"\",\"tomo\":\"\",\"libro\":\"\",\"numActa\":\"00150\",\"CRIP\":\"\",\"numEntidadReg\":\"09\",\"cveMunicipioReg\":\"011\",\"NumRegExtranjeros\":\"\",\"FolioCarta\":\"\",\"cveEntidadNac\":\"DF\",\"cveEntidadEmisora\":\"\",\"statusCurp\":\"RCN\",\"curpHistoricas\":[]}";
		super.crearStub(wm, "/comunesPulssar/renapo/curp/MELN780703MDFNNN06", 200, renapo, RequestMethod.GET);
		
		String entidadFederativa="{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9}";
		super.crearStub(wm, "/comunesPulssar/catalogo/entidadFederativa/claveCorta/DF", 200, entidadFederativa, RequestMethod.GET);
		
		String parametro1="[{\"idParametro\":6938,\"cvParametro\":\"P02100\",\"chParametro\":\"01\",\"chValorParametro\":\"!\",\"fechaModificacion\":1422338400000,\"usuarioModificacion\":\"retiro\"}]";
		super.crearStub(wm, "/comunesPulssar/catalogo/parametro/P02100", 200, parametro1, RequestMethod.GET);


		String tabla1="[{\"idParametro\":12622,\"cvParametro\":\"T02432\",\"chParametro\":\"556\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12623,\"cvParametro\":\"T02432\",\"chParametro\":\"530\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12624,\"cvParametro\":\"T02432\",\"chParametro\":\"534\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12625,\"cvParametro\":\"T02432\",\"chParametro\":\"538\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12626,\"cvParametro\":\"T02432\",\"chParametro\":\"544\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12627,\"cvParametro\":\"T02432\",\"chParametro\":\"550\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12628,\"cvParametro\":\"T02432\",\"chParametro\":\"552\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12629,\"cvParametro\":\"T02432\",\"chParametro\":\"562\",\"chValorParametro\":\"saldosPreliminares\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12630,\"cvParametro\":\"T02432\",\"chParametro\":\"568\",\"chValorParametro\":\"saldosPrevioImss\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"},{\"idParametro\":12631,\"cvParametro\":\"T02432\",\"chParametro\":\"578\",\"chValorParametro\":\"saldosPrevioIssste\",\"fechaModificacion\":1652188673000,\"usuarioModificacion\":\"SALDO_PRELIMINARES\"}]";
		super.crearStub(wm, "/comunesPulssar/catalogo/parametro/T02432", 200, tabla1, RequestMethod.GET);

		String saldosPreliminares="{\"afore\":\"552\",\"curp\":\"MELN780703MDFNNN06\",\"nss\":\"12345678965\"}";
		super.crearStub(wm, "/comunesPulssar/saldosPreliminares", 200, saldosPreliminares, RequestMethod.POST);
		
		String rechazos="{\"identificadorRechazo\":715,\"claveRechazo\":\"G001\",\"claveOrganizacion\":\"552\",\"tituloMensaje\":\"Tu solicitud no fue aceptada\",\"mensaje\":\"Por el momento no es posible validar tu solicitud. Por favor, inténtalo más tarde.\",\"estatus\":1,\"fecha\":1575417948000,\"usuarioModificador\":\"MIGRACION\"}";
		super.crearStub(wm, "/comunesPulssar/consultaRechazo/G001/552", 200, rechazos, RequestMethod.GET);
		
		String recertificacion="{\"id\":2793,\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1517205600000,\"fcFinRecertifiaccion\":1425189600000,\"fcInicioRecertificacion\":1420092000000,\"fcRegistro\":1420092000000,\"idProcesarAgente\":2,\"idProcesarPersona\":2715,\"idTipoContacto\":1,\"nuEstatusRecertificacion\":1,\"idProcesarAforeSolicitud\":378704580729,\"cvLugarFirma\":\"01\",\"fcVigenciaSolicitudRecertifi\":1421128800000,\"nuTipoTrabajador\":1,\"chFolioServicio\":null,\"curpTrabajador\":null,\"claveAfore\":\"516\"}";
		super.crearStub(wm, "/comunesPulssar/recertificacion/idprocesar/2715", 200, recertificacion, RequestMethod.GET);		

		String liquidacionDesempleo="";
		super.crearStub(wm, "/comunesPulssar/resolucionParcial/consultarLiquidacionHistorica/2715/20500,20560/06", 200, liquidacionDesempleo, RequestMethod.GET);
		
		String liquidacionMatrimonio="";
		super.crearStub(wm, "/comunesPulssar/resolucionParcial/consultarLiquidacionHistorica/2715/20500,20560/07", 200, liquidacionMatrimonio, RequestMethod.GET);

		String canase="{\"id\":674762833877,\"mesNacimiento\":\"01\",\"nombreImss\":\"GONZALEZ$$FELIPE DE JESUS\",\"sexo\":\"F\",\"usuarioModificador\":null,\"clasificacionNss\":null,\"curp\":\"GOXF610205HGTNXL10\",\"claveUltimaTransaccion\":null,\"fechaAlta\":null,\"fechaControl\":null,\"fechaUltimaTransaccion\":null,\"entidadNacimiento\":{\"id\":16,\"chCvEntidadFederativa\":\"15\",\"descripcion\":\"ESTADO DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"MC\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":15},\"nss\":\"01067802825\",\"registroPatronal\":null,\"periodoPago\":null,\"salarioDiarioIntegrado\":null,\"nssUnificador\":null,\"statusMarca\":null,\"rfc\":null}";
		super.crearStub(wm, "/comunesPulssar/canase/12345678965", 200, canase, RequestMethod.GET);

		String icefas="[{\"claveIcefa\":\"002\",\"descripcionIcefa\":\"BANAMEX\",\"fechaControl\":1429139135000,\"usuarioModificador\":\"MIGRACION\"}]";
		super.crearStub(wm, "/comunesPulssar/catalogo/listaIcefa/002", 200, icefas, RequestMethod.GET);

		
		
		
		
		
		servicioConsulta.obtenerDatosAdicionales(auxiliarTrabajador);
	}
	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaGenerarFolioActivo() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("ROSA831608MDFMMM06");
//		entrada.setNss("");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testconsultarPersonaGenerarFolioInactivo() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		FolioEntrada folio = new FolioEntrada();
//		folio.setIdFolio(1L);
//		entrada.setCurp("ROSA831608MDFMMM06");
//		entrada.setNss("12345678901");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	@Ignore
//	public void testConsultarPersonaException() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("BAI88");
//		entrada.setNss("");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(GenericException e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaSinPersona() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("BAID880119HDFRBV05");
//		entrada.setNss("");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaBusinessSinNssCurp() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("");
//		entrada.setNss("");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaBusinessSinTimer() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("");
//		entrada.setNss("11111222223");
//		entrada.setTimerPicker("");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaNacionalidad() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("BAID880119HDFRBV04");
//		entrada.setNss("");
//		entrada.setTimerPicker("01:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaRecertificacionException() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("BAID880119HDFRBV19");
//		entrada.setNss("");
//		entrada.setTimerPicker("01:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada, 2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test cerrar folio Generic
//	 */
//	@Test 
//	public void testCerrarFolioGeneric(){
//		try{
//			FolioEntrada folio = new FolioEntrada();
//			folio.setIdFolio(453L);
//			servicioConsulta.cerrarFolio(folio);
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona Error
//	 */
//	@Test
//	public void testConsultarPersonaGenerarError() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("PUBA831608MDFMMM06");
//		entrada.setNss("11111222223");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test consulta persona afore distinto
//	 */
//	@Test
//	public void testObtenerPersonaValidaError(){
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("PESO831608MDFMMM06");
//		entrada.setNss("1234567896");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("999");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	
//	/**
//	 * Test consulta persona afiliacion 1
//	 */
//	@Test
//	public void testObtenerPersonaValidaError2(){
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("QUES762309MDFMMM06");
//		entrada.setNss("1234567896");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaDatosFoliosDistintos1() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("ROSA831608MDFMMM19");
//		entrada.setNss("");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test Para consulta de persona
//	 */
//	@Test
//	public void testConsultarPersonaDatosFoliosDistintos2() {
//		EntradaConsulta entrada  = new EntradaConsulta();
//		entrada.setCurp("");
//		entrada.setNss("12344455567");
//		entrada.setTimerPicker("18:08");
//		entrada.setClaveAfore("556");
//		try{
//			servicioConsulta.consultarPersona(entrada,2L,"122","sucursal");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
}