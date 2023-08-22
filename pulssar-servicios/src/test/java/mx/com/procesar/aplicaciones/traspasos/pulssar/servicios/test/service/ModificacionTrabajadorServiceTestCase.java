package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AnexoATrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ModificacionTrabajadorServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AnexoATrabajadorIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CURPStruct;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Canase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurpSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseFormulario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioLaboralTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosReferenciasTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioFechas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Proceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExpedienteDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test para validar servicios de modificacion de datos
 * @author JMGUTIEG
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ModificacionTrabajadorServiceTestCase {

	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private ModificacionTrabajadorService modificacionService = new ModificacionTrabajadorServiceImpl();
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * dependencia utilidad validador
	 */ 
	@Mock
	private ValidadorUtils validadorUtils;
	
    /**
     * ConsultaSelloProxyService
     */
	@Mock
	private ConsultaSelloService consultaSelloService;
	
	/**
	 * Utileria Cadena
	 */
	@Mock
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de service expediente
	 */
	@Mock
	private EstatusExpedienteService expedienteService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Mock
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Service bitacora movimiento
	 */
	@Mock
	private BitacoraMovimientoModificacionService bitacoraMovimientoModificacionService;
	
	
	/**
	 * servicio folio
	 */
	@Mock
	private FolioService servicioFolio;
	
	/**
	 * dependencia utilidad fecha
	 */
	@Mock
	private FechaUtils utileriaFecha;
	
	/**
	 * Notificacio de actualizacion de datos
	 */
	@Mock
	private NotificacionService notificacionService;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Mock
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion notificacion expediente service
	 */
	@Mock
	private NotificacionExpedienteService notificacionExpedienteService;
	
	/**
	 * Inyeccion de dependencia fechaUtils
	 */
	@Mock
	private FechaUtils fechaUtils;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Mock
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion servicio proceso pendiente
	 */
	@Mock
	private ProcesoPendienteService serviceProcesoPendiente;
	
	/**
	 * Inyeccion canace service
	 */
	@Mock
	private CanaseService canaceService;
	
	/**
	 * Inyeccion anexo service
	 */
	@Mock
	private AnexoATrabajadorService anexoService;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test que valida obtencion de respuesta flujo
	 * @author JMGUTIEG
	 */
	@Test(expected=BusinessException.class)
	public void testObtenerRespuestaFlujo() {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"idProcesar\":2648,\"estatusBiometrico\":\"2\",\"estatusIdentificacion\":\"1\",\"curpNueva\":\"CEMA680702HSPDRN00\",\"flujoValidacion\":\"1B\",\"movimiento\":\"1\",\"curpSolicitante\":\"CEMA680702HSPDRN00\",\"tipoSolicitante\":\"01\"}" , HttpStatus.ACCEPTED);
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.obtenerRespuestaFlujo(entradaModificacion, new DatosTrabajador(), new ExpedienteSalida());
		
		ResponseEntity<String> respuestaNotificacion2 = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion2);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.isNull())).thenReturn(Boolean.TRUE);
		modificacionService.obtenerRespuestaFlujo(entradaModificacion, new DatosTrabajador(), new ExpedienteSalida());
	}
	
	/**
	 * Test que valida consulta de sellos 
	 * @author JMGUTIEG
	 */
	@Test
	public void testConsultarSellos() {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curp");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		entradaModificacion.setEntidadOrigen("afore");
		
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setCurpAgente("curp");
		usuario.setAforeUsuario("afore");
		
		Sello sello = new Sello();
		sello.setId(1L);
		sello.setClaveStatusSello("01");
		Mockito.when(consultaSelloService.obtenerSelloTrabajador(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(consultaSelloService.obtenerSelloEmpleado(Mockito.anyString(), Mockito.anyString())).thenReturn(sello);
		modificacionService.consultarSellos(entradaModificacion, usuario, "01");
		
		sello.setClaveStatusSello("02");
		Mockito.when(consultaSelloService.obtenerSelloTrabajador(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(sello);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(consultaSelloService.obtenerSelloEmpleado(Mockito.anyString(), Mockito.anyString())).thenReturn(sello);
		modificacionService.consultarSellos(entradaModificacion, usuario, "01");
		
		Mockito.when(consultaSelloService.obtenerSelloTrabajador(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.isNull())).thenReturn(Boolean.TRUE);
		Mockito.when(consultaSelloService.obtenerSelloEmpleado(Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		modificacionService.consultarSellos(entradaModificacion, usuario, "01");
		
		modificacionService.consultarSellos(entradaModificacion, usuario, "02");

	}
	
	/**
	 * Test que valida marca operativa
	 * @author JMGUTIEG
	 */
	@Test
	public void testValidarMarcasOperativasTrabajador() {
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("texto" , HttpStatus.ACCEPTED);
		Folio folio = new Folio();
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		modificacionService.validarMarcasOperativasTrabajador(1L, "clave", folio);
		
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		modificacionService.validarMarcasOperativasTrabajador(1L, "clave", folio);
	}
	
	/**
	 * Test que valida expedeinte biometrico
	 */
	@Test
	public void testValidarExpedienteBiometrico() {
		DatosCertificables datosCer = new DatosCertificables();
		datosCer.setCurp("CURPS");
		ExpedienteSalida expediente = new ExpedienteSalida();
		expediente.setClaveAforeExpBiometrico("556");
		expediente.setEstatusExpedienteIdentificacion("1");
		expediente.setEstatusEnrolamiento("2");
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("530");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(datosCer);
		trabajador.setTipoSolicitante("01");
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("CURP");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		
		FlujoModificacion flujoModificacion = new FlujoModificacion();
		
		Afore afore = new Afore();
		afore.setClaveAfore("552");
		ExpedienteDetail expedienteDetalle = new ExpedienteDetail();
		expedienteDetalle.setCvEstatusExpe("2");
		expedienteDetalle.setAfore(afore);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteBiometrico(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
		
		user.setAforeUsuario("556");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteBiometrico(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
		
		expediente.setEstatusEnrolamiento("0");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteBiometrico(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
		
		
		expediente.setEstatusEnrolamiento("0");
		trabajador.setTipoSolicitante("02");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE,Boolean.TRUE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		modificacionService.validarExpedienteBiometrico(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
	}
	
	/**
	 * Test que valida expediente de identificacion
	 */
	@Test
	public void testValidarExpedienteIdentificacion() {
		DatosCertificables datosCer = new DatosCertificables();
		datosCer.setCurp("CURPS");
		ExpedienteSalida expediente = new ExpedienteSalida();
		expediente.setClaveAforeExpIdentificacion("556");
		expediente.setEstatusExpedienteIdentificacion("1");
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("530");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(datosCer);
		trabajador.setTipoSolicitante("01");
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("CURP");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);

		FlujoModificacion flujoModificacion = new FlujoModificacion();

		
		Afore afore = new Afore();
		afore.setClaveAfore("552");
		ExpedienteDetail expedienteDetalle = new ExpedienteDetail();
		expedienteDetalle.setCvEstatusExpe("1");
		expedienteDetalle.setAfore(afore);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteIdentificacion(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
	
		user.setAforeUsuario("556");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteIdentificacion(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
		
		expediente.setEstatusExpedienteIdentificacion("0");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("CURPS");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetalle);
		modificacionService.validarExpedienteIdentificacion(expediente, user, trabajador, entradaModificacion,flujoModificacion,"1");
	}
	
	/**
	 * test consulta recepcion expe identificacion
	 */
	@Test
	public void testConsultarRecepcionExpeIdentificacion() {
		Folio folio = new Folio();
		ArchivoRecibido respuesta = new ArchivoRecibido();
		respuesta.setDiagnostico("030");
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(folio, "1")).thenReturn(respuesta);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.consultarRecepcionExpeIdentificacion(folio, "1");
		
		respuesta.setDiagnostico("031");
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(folio, "1")).thenReturn(respuesta);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.consultarRecepcionExpeIdentificacion(folio, "1");
		
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(folio, "1")).thenReturn(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.isNull())).thenReturn(Boolean.TRUE);
		modificacionService.consultarRecepcionExpeIdentificacion(folio, "1");
	}
	
	/**
	 * test valida sello permanencia
	 */
	@Test
	public void testValidaSelloPermanencia() {
		Mockito.when(consultaSelloService.consultarSelloFlujoModificacion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(new VerificacionSello());
		modificacionService.validaSelloPermanencia("curpE", "curpT", "afore", "01");
		
		modificacionService.validaSelloPermanencia("curpE", "curpT", "afore", "02");
	}
	
	/**
	 * Metodo test guardar flujo bitacora
	 */
	@Test
	public void testGuardarFlujoBitacora() {
		Folio folioPadre = new Folio();
		folioPadre.setChFolio("folio");
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curp");
		datosBase.setFlujoDeValidacion("1B");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setNss("nss");
		entradaModificacion.setDatosBaseCurp(datosBase);
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO, entradaModificacion, folioPadre, null, "1", " ");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION, entradaModificacion, folioPadre, null, "1", " ");

		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR, entradaModificacion, folioPadre, null, "1", " ");

		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		modificacionService.guardarFlujoBitacora("controlador", entradaModificacion, folioPadre, null, "1", " ");
		
		EntradaPermanencia entradaPermanencia = new EntradaPermanencia();
		entradaPermanencia.setNssTrabajador("nss");
		entradaPermanencia.setCurpTrabajador("curp");
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.CONTROLADOR_ENROLAMIENTO, null, folioPadre, entradaPermanencia, " ", "1");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.CONTROLADOR_IDENTIFICACION, null, folioPadre, entradaPermanencia, " ", "1");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		modificacionService.guardarFlujoBitacora(ModificacionTrabajadorConstants.VALIDAR_TRABAJADOR, null, folioPadre, entradaPermanencia, " ", "1");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		modificacionService.guardarFlujoBitacora("controlador", null, folioPadre, entradaPermanencia, " ", "1");
	
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		modificacionService.guardarFlujoBitacora("controlador", null, folioPadre, entradaPermanencia, " ", " ");
	}
	
	/**
	 * tes para obtener diagnostico corto
	 */
	@Test
	public void testObtenerDiagnosticoCorto() {
		modificacionService.obtenerDiagnosticoCorto("0000000000");
	}
	
	/**
	 * test notificar tiempo tramite
	 */
	@Test
	public void testNotificartiempoTramite() {
		FolioEntrada folioEntrada = new FolioEntrada();
		folioEntrada.setIdFolio(1L);
		Date date = Mockito.mock(Date.class);
		FolioFechas folioFechas = new FolioFechas();
		folioFechas.setFechaLlegadaSn(new Date());
		folioFechas.setFechaGeneracionSn(new Date());
		Mockito.when(servicioFolio.consultarFechasFolio(Mockito.anyLong())).thenReturn(folioFechas);
		Mockito.when(utileriaFecha.calcularTiempoTranscurrido(date, date)).thenReturn("tiempo");
		modificacionService.notificarTiempoTramite("folio", folioEntrada,"556");
		
		
		Mockito.when(servicioFolio.consultarFechasFolio(Mockito.anyLong())).thenThrow(new NullPointerException());
		modificacionService.notificarTiempoTramite("folio", folioEntrada,"556");
	}
	
	/**
	 * test valida pendiente persona
	 */
	@Test
	public void testValidaPendientePersona() {
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Long.class))).thenReturn(1L);
		modificacionService.validaPendientePersona("curp");
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Long.class))).thenReturn(0L);
		modificacionService.validaPendientePersona("curp");
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Long.class))).thenThrow(new RuntimeException());
		modificacionService.validaPendientePersona("curp");
	}
	
	/**
	 * test valida respuesta pendiente persona
	 */
	@Test(expected=BusinessException.class)
	public void testValidarRespuestaPendiente() {
		modificacionService.validarRespuestaPendiente(true);
		modificacionService.validarRespuestaPendiente(false);
	}
	
	/**
	 * test que valida bandera flujo
	 */
	@Test
	public void testValidarBanderaFlujo() {
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		modificacionService.validarBanderaFlujo("control", " ", "1");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		modificacionService.validarBanderaFlujo("control", "1", " ");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		modificacionService.validarBanderaFlujo("control", " ", " ");
	}
	
	/**
	 * test validar expediente no titular
	 */
	@Test
	public void testValidarExpedientesNoTitularInicio() {
		DatosCertificables datosCert = new DatosCertificables();
		datosCert.setCurp("curp");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(datosCert);
		trabajador.setTipoSolicitante("03");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(new ExpedienteDetail());
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.validarExpedientesNoTitularInicio(trabajador);
		
		Afore afore = new Afore();
		afore.setClaveAfore("556");
		ExpedienteDetail respuesta = new ExpedienteDetail();
		respuesta.setCvEstatusExpe("1");
		respuesta.setCvTipoProceso("01");
		respuesta.setAfore(afore);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("curp");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(respuesta);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.validarExpedientesNoTitularInicio(trabajador);
	}
	
	@Test
	public void testValidaDatosModificacionComparador() {
		DatosBaseCurp datosBase = new DatosBaseCurp();

		DatosDomicilioParticularTrabajador particular = new DatosDomicilioParticularTrabajador();
		
		DatosDomicilioLaboralTrabajador laboral = new DatosDomicilioLaboralTrabajador();
		
		DatosReferenciasTrabajador referencia = new DatosReferenciasTrabajador();
		
		DatosBeneficiarioTrabajador beneficiario = new DatosBeneficiarioTrabajador();
		List<DatosBeneficiarioTrabajador> listaBeneficiario = new ArrayList<>();
		listaBeneficiario.add(beneficiario);
		
		ListaBeneficiariosTrabajador oBenefi = new ListaBeneficiariosTrabajador();
		oBenefi.setBeneficiario(listaBeneficiario);
		EntradaModificacion objetoEntrada = new EntradaModificacion();
		objetoEntrada.setDatosDomicilioParticularTrabajador(particular);
		objetoEntrada.setDatosDomicilioLaboralTrabajador(laboral);
		objetoEntrada.setDatosReferenciasTrabajador(referencia);
		objetoEntrada.setListaBeneficiariosTrabajador(oBenefi);
		objetoEntrada.setDatosBaseCurp(datosBase);
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.validaDatosModificacionComparador(objetoEntrada);
		
		oBenefi.setBeneficiario(null);
		objetoEntrada.setDatosDomicilioParticularTrabajador(null);
		objetoEntrada.setDatosDomicilioLaboralTrabajador(null);
		objetoEntrada.setDatosReferenciasTrabajador(null);
		objetoEntrada.setListaBeneficiariosTrabajador(oBenefi);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		modificacionService.validaDatosModificacionComparador(objetoEntrada);
	}
	
	/**
	 * Test para acortar motivo rechazo 
	 */
	@Test
	public void testAcortarMotivoRechazo() {
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		modificacionService.acortarMotivoRechazo("M000");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		modificacionService.acortarMotivoRechazo("M00");
		
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE);
		modificacionService.acortarMotivoRechazo(" ");
	}
	
	/**
	 * test ejecutar permanencia
	 */
	@Test(expected=BusinessException.class)
	public void testEjecutarPermanencia() {
		EntradaPermanencia entradaPermanencia = new EntradaPermanencia();
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"ssnrop\":{\"codoper\":\"ca39d6dc-028e-4b4b-a555-90c8209e8260\",\"codRespuesta\":\"OK\",\"codRespuestaOpr\":\"\",\"descRespuesta\":\"Servicio de Negocio Ejecutado Correctamente!\",\"motivos\":null,\"codoperCliente\":\"8\",\"tiempoRespuesta\":\"1249 ms\",\"fecha\":1609433966000},\"objetoRespuesta\":{\"entidadOrigen\":\"530\",\"curpTrabajador\":\"AASF890711HDFLNR08\",\"nssTrabajador\":\"19201691242\",\"resultadoDeLaOperacion\":\"01\",\"diagnosticoDeRecepcion\":\"000000000000000\",\"claveActualizacion\":\"01\",\"listaDiagnosticos\":[]}}" , HttpStatus.ACCEPTED);

		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.ejecutarPermanencia(entradaPermanencia);
		
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_GATEWAY));
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.ejecutarPermanencia(entradaPermanencia);
		
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.ejecutarPermanencia(entradaPermanencia);
	}
	
	/**
	 * Test consultar folio activo
	 */
	@Test(expected=BusinessException.class)
	public void testConsultaFolioActivo() {
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("claveServicio");
		
		Parametro parametro2 = new Parametro();
		parametro2.setChValorParametro("clavePasoIdentificacion");
		
		FolioActivoDetalle activoDetalle = new FolioActivoDetalle();
		activoDetalle.setIdProceso(1L);
		activoDetalle.setIdFolioPulssar(1L);
		List<FolioActivoDetalle> listaFolioActivo = new ArrayList<>();
		listaFolioActivo.add(activoDetalle);
		
		FolioActivo folioActivo = new FolioActivo();
		folioActivo.setFoliosHijo(listaFolioActivo);
		
		Proceso proceso = new Proceso();
		proceso.setClaveProceso("clavePasoIdentificacion");
		
		ArchivoRecibido archivoRecibido = new ArchivoRecibido();
		archivoRecibido.setResultadoOperacion("01");
		archivoRecibido.setDiagnostico("020");
		
		Folio folio = new Folio();
		ProcesoPendiente procesoPendiente = new ProcesoPendiente();
		
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro,parametro2);
		Mockito.when(servicioFolio.consultarFolioActivo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(folioActivo);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE,Boolean.FALSE);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Proceso.class))).thenReturn(proceso);
		Mockito.when(servicioFolio.consultarFolioHijo(Mockito.anyLong())).thenReturn(folio);
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(any(Folio.class), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(serviceProcesoPendiente.consultaProcesoPendienteIdfolio(Mockito.anyString(), Mockito.anyString())).thenReturn(procesoPendiente);
		modificacionService.consultaFolioActivo("curp", "nss", "afore",false);
		
		parametro2.setChValorParametro("claveIdentificacion");
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro,parametro2);
		Mockito.when(servicioFolio.consultarFolioActivo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(folioActivo);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE,Boolean.FALSE);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Proceso.class))).thenReturn(proceso);
		Mockito.when(servicioFolio.consultarFolioHijo(Mockito.anyLong())).thenReturn(folio);
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(any(Folio.class), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(serviceProcesoPendiente.consultaProcesoPendienteIdfolio(Mockito.anyString(), Mockito.anyString())).thenReturn(procesoPendiente);
		modificacionService.consultaFolioActivo("curp", "nss", "afore",true);
		
		parametro2.setChValorParametro("clavePasoIdentificacion");
		archivoRecibido.setResultadoOperacion("02");
		archivoRecibido.setDiagnostico("030");
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro,parametro2);
		Mockito.when(servicioFolio.consultarFolioActivo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(folioActivo);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE,Boolean.FALSE);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Proceso.class))).thenReturn(proceso);
		Mockito.when(servicioFolio.consultarFolioHijo(Mockito.anyLong())).thenReturn(folio);
		Mockito.when(servicioArchivos.validarRecepcionArchivoModificacion(any(Folio.class), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(serviceProcesoPendiente.consultaProcesoPendienteIdfolio(Mockito.anyString(), Mockito.anyString())).thenReturn(procesoPendiente);
		modificacionService.consultaFolioActivo("curp", "nss", "afore",false);
	}
	
	/**
	 * Test obtener datos renapo
	 */
	@Test
	public void testObtenerDatosRenapo() {
		DatosCertificables certificables = new DatosCertificables();
		certificables.setCurp("curp");
		DatosNoCertificables noCertificable = new DatosNoCertificables();
		noCertificable.setClaveNacionalidad(1L);
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(certificables);
		trabajador.setDatosNoCertificables(noCertificable);
		
		String[] curpHistoricas = {"curp"};
		CURPStruct renapo = new CURPStruct();
		renapo.setNombres("nombres");
		renapo.setApellido1("apellido1");
		renapo.setApellido2("apellido2");
		renapo.setCurp("curp");
		renapo.setNacionalidad("nacionalidad");
		renapo.setFechNac("fecha");
		renapo.setSexo("M");
		renapo.setCurpHistoricas(curpHistoricas);
		renapo.setCveEntidadNac("clave");
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("valor");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setChValorDespliegue("1");
		
		EntidadFederativa entidad = new EntidadFederativa();
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(CURPStruct.class))).thenReturn(renapo);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(utileriaFecha.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(utileriaFecha.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(servicioCatalogo.obtenerEntidad(Mockito.anyString())).thenReturn(entidad);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor");
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		modificacionService.obtenerDatosRenapo(trabajador);	
		
		CURPStruct renapo2 = new CURPStruct();
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(CURPStruct.class))).thenReturn(renapo2);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(utileriaFecha.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(utileriaFecha.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(servicioCatalogo.obtenerEntidad(Mockito.anyString())).thenReturn(entidad);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor");
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		modificacionService.obtenerDatosRenapo(trabajador);	
	}
	
	/**
	 * test ejecutar modificacion de datos
	 */
	@Test
	public void testValidarRespuestaModificacion() {
		DatosSalidaModificacion salida = new DatosSalidaModificacion();
		DatosBaseCurpSalida datosBase = new DatosBaseCurpSalida();
		datosBase.setResultadoDeLaOperacion("01");
		datosBase.setDiagnosticoDeRecepcion("000000000000000");
		salida.setDatosBaseCurp(datosBase);
		SalidaActualizaDatos entradaRespuesta = new SalidaActualizaDatos();
		entradaRespuesta.setObjetoRespuesta(salida);
		EntradaModificacion entrada = new EntradaModificacion();	
		DatosTrabajador trabajador = new DatosTrabajador();
		Parametro parametro = new Parametro();
		parametro.setChParametro("3");
		parametro.setChValorParametro("904,905");
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametro);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		DatosCertificables certificables = new DatosCertificables();
		certificables.setCurp("curp");
		DatosBaseCurp datosBaseCurp = new DatosBaseCurp();
		datosBaseCurp.setNacionalidad("nacionalidad");
		datosBaseCurp.setSelloVoluntadTramite("23424324234");
		datosBase.setResultadoDeLaOperacion("02");
		datosBase.setDiagnosticoDeRecepcion("E83000000000000");
		entrada.setDatosBaseCurp(datosBaseCurp);
		trabajador.setTipoAfiliacion("4");
		trabajador.setTipoSolicitante("01");
		
		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setChValorDespliegue("valor");
		
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\r\n" + 
				"                \"ssnrop\": {\r\n" + 
				"                               \"codoper\": \"eb21da94-d9f6-4478-a7a6-b57f435bde69\",\r\n" + 
				"                               \"codRespuesta\": \"OK\",\r\n" + 
				"                               \"codRespuestaOpr\": \"\",\r\n" + 
				"                               \"descRespuesta\": \"Servicio de Negocio Ejecutado Correctamente!\",\r\n" + 
				"                               \"motivos\": {\r\n" + 
				"                                               \"motivo\": []\r\n" + 
				"                               },\r\n" + 
				"                               \"codoperCliente\": \"PLATAFORMA\",\r\n" + 
				"                                \"tiempoRespuesta\": \"3716 ms\",\r\n" + 
				"                               \"fecha\": 1603393861000\r\n" + 
				"                },\r\n" + 
				"                \"objetoRespuesta\": {\r\n" + 
				"                               \"entidadOrigen\": \"568\",\r\n" + 
				"                               \"nss\": \"23048809109\",\r\n" + 
				"                               \"curp\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                               \"datosBaseCurp\": {\r\n" + 
				"                                               \"curpOficial\": null,\r\n" + 
				"                                               \"curpNueva\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                                               \"rfc\": \"TOPM6904266W1\",\r\n" + 
				"                                               \"apellidoPaterno\": \"JIMENEZ\",\r\n" + 
				"                                               \"apellidoMaterno\": \"RODRIGUEZ\",\r\n" + 
				"                                               \"nombreTrabajador\": \"RAMON\",\r\n" + 
				"                                               \"nombreEnFormatoImss\": \"JIMENEZ$RODRIGUEZ$RAMON\",\r\n" + 
				"                                               \"nombreEnProcanase\": null,\r\n" + 
				"                                               \"fechaDeNacimiento\": \"19880621\",\r\n" + 
				"                                               \"sexo\": 1,\r\n" + 
				"                                               \"entidadFederativaDeNacimiento\": \"10\",\r\n" + 
				"                                               \"nacionalidad\": \"MEX\",\r\n" + 
				"                                               \"folioDeLaSolicitud\": 2010220004,\r\n" + 
				"                                               \"claveDeTipoDeDocumentoProbatorio\": null,\r\n" + 
				"                                               \"documentoProbatorio\": null,\r\n" + 
				"                                               \"folioDeDocumentoProbatorio\": null,\r\n" + 
				"                                               \"ocupacionOProfesionTrabajador\": \"52\",\r\n" + 
				"                                               \"actividadOGiroNegocioTrabajador\": \"01\",\r\n" + 
				"                                               \"nivelDeEstudioTrabajador\": \"03\",\r\n" + 
				"                                               \"flujoDeValidacion\": \"2A\",\r\n" + 
				"                                               \"selloVerificacionBiometrica\": 75000550662150,\r\n" + 
				"                                               \"selloVoluntadTramite\": 85000550662181,\r\n" + 
				"                                               \"indicadorDeDuplicidad\": \"0\",\r\n" + 
				"                                               \"indicadorDeServicioBiometrico\": \"0507\",\r\n" + 
				"                                               \"curpSolicitante\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                                               \"tipoSolicitante\": \"01\",\r\n" + 
				"                                               \"claveDeAgentePromotor\": null,\r\n" + 
				"                                               \"fechaDePrimerRegistro\": null,\r\n" + 
				"                                               \"fechaAltaEnAforeActual\": null,\r\n" + 
				"                                               \"claveDeAforeDeRegistro\": null,\r\n" + 
				"                                               \"claveDeAforeConNssAsociado\": null,\r\n" + 
				"                                               \"identificadorDeTipoDeTrabajador\": null,\r\n" + 
				"                                               \"nssAsociado\": null,\r\n" + 
				"                                               \"indicadorDeCreditoInfonavit\": null,\r\n" + 
				"                                               \"periodoDePago\": null,\r\n" + 
				"                                               \"salarioDiarioIntegrado\": null,\r\n" + 
				"                                               \"numeroFolioEdoCta\": null,\r\n" + 
				"                                               \"expedienteCompleto\": \"00\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"01\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosDomicilioParticularTrabajador\": {\r\n" + 
				"                                               \"calle\": \"FELIPE ANGELES\",\r\n" + 
				"                                               \"numeroExterior\": \"4638\",\r\n" + 
				"                                               \"numeroInterior\": null,\r\n" + 
				"                                               \"colonia\": \"JARDINES DEL VALLE\",\r\n" + 
				"                                               \"delegacionOMunicipio\": \"CULIACAN\",\r\n" + 
				"                                               \"codigoPostal\": \"80189\",\r\n" + 
				"                                               \"entidadFederativa\": \"SINALOA\",\r\n" + 
				"                                               \"pais\": \"MEX\",\r\n" + 
				"                                               \"indicadorDeTelefono1\": \"000\",\r\n" + 
				"                                               \"telefono1\": \"6674252676\",\r\n" + 
				"                                               \"extension1\": null,\r\n" + 
				"                                               \"indicadorDeTelefono2\": \"000\",\r\n" + 
				"                                               \"telefono2\": \"6677252676\",\r\n" + 
				"                                               \"extension2\": null,\r\n" + 
				"                                               \"correoElectronicoDelTrabajador\": \"rjimenez@aforecoppel.com\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosDomicilioLaboralTrabajador\": {\r\n" + 
				"                                               \"calle\": \"KIKI MURILLO\",\r\n" + 
				"                                               \"numeroExterior\": \"100\",\r\n" + 
				"                                               \"numeroInterior\": \"1\",\r\n" + 
				"                                               \"colonia\": \"LA PRIMAVERA\",\r\n" + 
				"                                               \"delegacionOMunicipio\": \"CULIACAN\",\r\n" + 
				"                                               \"codigoPostal\": \"80300\",\r\n" + 
				"                                               \"entidadFederativa\": \"SINALOA\",\r\n" + 
				"                                               \"pais\": \"MEX\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosReferenciasTrabajador\":{\r\n" + 
				"									  \"apellidoPaternoDeReferencia1\":\"OTHON\",\r\n" + 
				"									  \"apellidoMaternoDeReferencia1\":\"LARA\",\r\n" + 
				"									  \"nombreDeReferencia1\":\"RAMIRO\",\r\n" + 
				"									  \"curpDeReferencia1\":\"OOLR750203HSRTRM02\",\r\n" + 
				"									  \"telefonoDeReferencia1\":\"6621945573\",\r\n" + 
				"									  \"parentescoORelacionDeReferencia1\":\"19\",\r\n" + 
				"									  \"apellidoPaternoDeReferencia2\":\"GARCIA\",\r\n" + 
				"									  \"apellidoMaternoDeReferencia2\":\"CASANOVA\",\r\n" + 
				"									  \"nombreDeReferencia2\":\"GABRIELA\",\r\n" + 
				"									  \"curpDeReferencia2\":\"GACG690606MSRRSB03\",\r\n" + 
				"									  \"telefonoDeReferencia2\":\"6621949341\",\r\n" + 
				"									  \"parentescoORelacionDeReferencia2\":\"19\",\r\n" + 
				"									  \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                      \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                       \"listaDiagnosticos\": [\r\n" + 
				"                                                        {\r\n" + 
				"                                                                    \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                        }\r\n" + 
				"                                               ]\r\n" + 
				"								   },\r\n" + 
				"                               \"listaBeneficiariosTrabajador\": {\r\n" + 
				"                                               \"beneficiario\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"apellidoPaternoDeBeneficiario\": \"L!pez\",\r\n" + 
				"                                                                               \"apellidoMaternoDeBeneficiario\": \"Navarro\",\r\n" + 
				"                                                                               \"nombreDeBeneficiario\": \"Alejandra\",\r\n" + 
				"                                                                               \"curpDeBeneficiario\": \"LONA930223MSLPVL09\",\r\n" + 
				"                                                                               \"parentescoORelacion\": \"03\",\r\n" + 
				"                                                                               \"porcentajeDeBeneficiario\": \"50\",\r\n" + 
				"                                                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                                                              {\r\n" + 
				"                                                                                                              \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                                                              }\r\n" + 
				"                                                                               ]\r\n" + 
				"                                                               },\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"apellidoPaternoDeBeneficiario\": \"SAINZ\",\r\n" + 
				"                                                                               \"apellidoMaternoDeBeneficiario\": \"TORRES\",\r\n" + 
				"                                                                               \"nombreDeBeneficiario\": \"EUNICE ELIZABETH\",\r\n" + 
				"                                                                               \"curpDeBeneficiario\": \"SATE900918MSLNRN00\",\r\n" + 
				"                                                                               \"parentescoORelacion\": \"19\",\r\n" + 
				"                                                                               \"porcentajeDeBeneficiario\": \"50\",\r\n" + 
				"                                                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                                                              {\r\n" + 
				"                                                                                                              \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                                                              }\r\n" + 
				"                                                                               ]\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               }\r\n" + 
				"                }\r\n" + 
				"} \r\n" + 
				"", HttpStatus.ACCEPTED);
		
		
		ResponseEntity<String> respuestaNotificacion2 = new ResponseEntity<>("{\r\n" + 
				"                \"ssnrop\": {\r\n" + 
				"                               \"codoper\": \"eb21da94-d9f6-4478-a7a6-b57f435bde69\",\r\n" + 
				"                               \"codRespuesta\": \"NOOK\",\r\n" + 
				"                               \"codRespuestaOpr\": \"\",\r\n" + 
				"                               \"descRespuesta\": \"Servicio de Negocio Ejecutado Correctamente!\",\r\n" + 
				"                               \"motivos\": {\r\n" + 
				"                                               \"motivo\": []\r\n" + 
				"                               },\r\n" + 
				"                               \"codoperCliente\": \"PLATAFORMA\",\r\n" + 
				"                                \"tiempoRespuesta\": \"3716 ms\",\r\n" + 
				"                               \"fecha\": 1603393861000\r\n" + 
				"                },\r\n" + 
				"                \"objetoRespuesta\": {\r\n" + 
				"                               \"entidadOrigen\": \"568\",\r\n" + 
				"                               \"nss\": \"23048809109\",\r\n" + 
				"                               \"curp\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                               \"datosBaseCurp\": {\r\n" + 
				"                                               \"curpOficial\": null,\r\n" + 
				"                                               \"curpNueva\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                                               \"rfc\": \"TOPM6904266W1\",\r\n" + 
				"                                               \"apellidoPaterno\": \"JIMENEZ\",\r\n" + 
				"                                               \"apellidoMaterno\": \"RODRIGUEZ\",\r\n" + 
				"                                               \"nombreTrabajador\": \"RAMON\",\r\n" + 
				"                                               \"nombreEnFormatoImss\": \"JIMENEZ$RODRIGUEZ$RAMON\",\r\n" + 
				"                                               \"nombreEnProcanase\": null,\r\n" + 
				"                                               \"fechaDeNacimiento\": \"19880621\",\r\n" + 
				"                                               \"sexo\": 1,\r\n" + 
				"                                               \"entidadFederativaDeNacimiento\": \"10\",\r\n" + 
				"                                               \"nacionalidad\": \"MEX\",\r\n" + 
				"                                               \"folioDeLaSolicitud\": 2010220004,\r\n" + 
				"                                               \"claveDeTipoDeDocumentoProbatorio\": null,\r\n" + 
				"                                               \"documentoProbatorio\": null,\r\n" + 
				"                                               \"folioDeDocumentoProbatorio\": null,\r\n" + 
				"                                               \"ocupacionOProfesionTrabajador\": \"52\",\r\n" + 
				"                                               \"actividadOGiroNegocioTrabajador\": \"01\",\r\n" + 
				"                                               \"nivelDeEstudioTrabajador\": \"03\",\r\n" + 
				"                                               \"flujoDeValidacion\": \"2A\",\r\n" + 
				"                                               \"selloVerificacionBiometrica\": 75000550662150,\r\n" + 
				"                                               \"selloVoluntadTramite\": 85000550662181,\r\n" + 
				"                                               \"indicadorDeDuplicidad\": \"0\",\r\n" + 
				"                                               \"indicadorDeServicioBiometrico\": \"0507\",\r\n" + 
				"                                               \"curpSolicitante\": \"JIRR880621HDGMDM02\",\r\n" + 
				"                                               \"tipoSolicitante\": \"01\",\r\n" + 
				"                                               \"claveDeAgentePromotor\": null,\r\n" + 
				"                                               \"fechaDePrimerRegistro\": null,\r\n" + 
				"                                               \"fechaAltaEnAforeActual\": null,\r\n" + 
				"                                               \"claveDeAforeDeRegistro\": null,\r\n" + 
				"                                               \"claveDeAforeConNssAsociado\": null,\r\n" + 
				"                                               \"identificadorDeTipoDeTrabajador\": null,\r\n" + 
				"                                               \"nssAsociado\": null,\r\n" + 
				"                                               \"indicadorDeCreditoInfonavit\": null,\r\n" + 
				"                                               \"periodoDePago\": null,\r\n" + 
				"                                               \"salarioDiarioIntegrado\": null,\r\n" + 
				"                                               \"numeroFolioEdoCta\": null,\r\n" + 
				"                                               \"expedienteCompleto\": \"00\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosDomicilioParticularTrabajador\": {\r\n" + 
				"                                               \"calle\": \"FELIPE ANGELES\",\r\n" + 
				"                                               \"numeroExterior\": \"4638\",\r\n" + 
				"                                               \"numeroInterior\": null,\r\n" + 
				"                                               \"colonia\": \"JARDINES DEL VALLE\",\r\n" + 
				"                                               \"delegacionOMunicipio\": \"CULIACAN\",\r\n" + 
				"                                               \"codigoPostal\": \"80189\",\r\n" + 
				"                                               \"entidadFederativa\": \"SINALOA\",\r\n" + 
				"                                               \"pais\": \"MEX\",\r\n" + 
				"                                               \"indicadorDeTelefono1\": \"000\",\r\n" + 
				"                                               \"telefono1\": \"6674252676\",\r\n" + 
				"                                               \"extension1\": null,\r\n" + 
				"                                               \"indicadorDeTelefono2\": \"000\",\r\n" + 
				"                                               \"telefono2\": \"6677252676\",\r\n" + 
				"                                               \"extension2\": null,\r\n" + 
				"                                               \"correoElectronicoDelTrabajador\": \"rjimenez@aforecoppel.com\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosDomicilioLaboralTrabajador\": {\r\n" + 
				"                                               \"calle\": \"KIKI MURILLO\",\r\n" + 
				"                                               \"numeroExterior\": \"100\",\r\n" + 
				"                                               \"numeroInterior\": \"1\",\r\n" + 
				"                                               \"colonia\": \"LA PRIMAVERA\",\r\n" + 
				"                                               \"delegacionOMunicipio\": \"CULIACAN\",\r\n" + 
				"                                               \"codigoPostal\": \"80300\",\r\n" + 
				"                                               \"entidadFederativa\": \"SINALOA\",\r\n" + 
				"                                               \"pais\": \"MEX\",\r\n" + 
				"                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               },\r\n" + 
				"                               \"datosReferenciasTrabajador\":{\r\n" + 
				"									  \"apellidoPaternoDeReferencia1\":\"OTHON\",\r\n" + 
				"									  \"apellidoMaternoDeReferencia1\":\"LARA\",\r\n" + 
				"									  \"nombreDeReferencia1\":\"RAMIRO\",\r\n" + 
				"									  \"curpDeReferencia1\":\"OOLR750203HSRTRM02\",\r\n" + 
				"									  \"telefonoDeReferencia1\":\"6621945573\",\r\n" + 
				"									  \"parentescoORelacionDeReferencia1\":\"19\",\r\n" + 
				"									  \"apellidoPaternoDeReferencia2\":\"GARCIA\",\r\n" + 
				"									  \"apellidoMaternoDeReferencia2\":\"CASANOVA\",\r\n" + 
				"									  \"nombreDeReferencia2\":\"GABRIELA\",\r\n" + 
				"									  \"curpDeReferencia2\":\"GACG690606MSRRSB03\",\r\n" + 
				"									  \"telefonoDeReferencia2\":\"6621949341\",\r\n" + 
				"									  \"parentescoORelacionDeReferencia2\":\"19\",\r\n" + 
				"									  \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                      \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                       \"listaDiagnosticos\": [\r\n" + 
				"                                                        {\r\n" + 
				"                                                                    \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                        }\r\n" + 
				"                                               ]\r\n" + 
				"								   },\r\n" + 
				"                               \"listaBeneficiariosTrabajador\": {\r\n" + 
				"                                               \"beneficiario\": [\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"apellidoPaternoDeBeneficiario\": \"L!pez\",\r\n" + 
				"                                                                               \"apellidoMaternoDeBeneficiario\": \"Navarro\",\r\n" + 
				"                                                                               \"nombreDeBeneficiario\": \"Alejandra\",\r\n" + 
				"                                                                               \"curpDeBeneficiario\": \"LONA930223MSLPVL09\",\r\n" + 
				"                                                                               \"parentescoORelacion\": \"03\",\r\n" + 
				"                                                                               \"porcentajeDeBeneficiario\": \"50\",\r\n" + 
				"                                                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                                                              {\r\n" + 
				"                                                                                                              \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                                                              }\r\n" + 
				"                                                                               ]\r\n" + 
				"                                                               },\r\n" + 
				"                                                               {\r\n" + 
				"                                                                               \"apellidoPaternoDeBeneficiario\": \"SAINZ\",\r\n" + 
				"                                                                               \"apellidoMaternoDeBeneficiario\": \"TORRES\",\r\n" + 
				"                                                                               \"nombreDeBeneficiario\": \"EUNICE ELIZABETH\",\r\n" + 
				"                                                                               \"curpDeBeneficiario\": \"SATE900918MSLNRN00\",\r\n" + 
				"                                                                               \"parentescoORelacion\": \"19\",\r\n" + 
				"                                                                               \"porcentajeDeBeneficiario\": \"50\",\r\n" + 
				"                                                                               \"resultadoDeLaOperacion\": \"02\",\r\n" + 
				"                                                                               \"diagnosticoDeRecepcion\": \"786000000000000\",\r\n" + 
				"                                                                               \"listaDiagnosticos\": [\r\n" + 
				"                                                                                              {\r\n" + 
				"                                                                                                              \"786\": \"Trabajador ya se encuentra como pendiente de confronta\"\r\n" + 
				"                                                                                              }\r\n" + 
				"                                                                               ]\r\n" + 
				"                                                               }\r\n" + 
				"                                               ]\r\n" + 
				"                               }\r\n" + 
				"                }\r\n" + 
				"} \r\n" + 
				"", HttpStatus.ACCEPTED);
		trabajador.setDatosCertificables(certificables);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		doNothing().when(consultaSelloService).guardarSello(Mockito.anyLong(), Mockito.anyString());
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		trabajador.setTipoSolicitante("02");
		trabajador.setTipoAfiliacion("5");
		trabajador.setDatosCertificables(certificables);

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		trabajador.setTipoAfiliacion("9");
		trabajador.setDatosCertificables(certificables);

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(null);
		doNothing().when(consultaSelloService).guardarSello(Mockito.anyLong(), Mockito.anyString());
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		trabajador.setTipoAfiliacion("2");
		trabajador.setDatosCertificables(certificables);

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion2);
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		trabajador.setDatosCertificables(certificables);

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_GATEWAY));
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
		
		certificables.setCurp(null);
		trabajador.setDatosCertificables(certificables);

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("fecha");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		modificacionService.validarRespuestaModificacion(entradaRespuesta, entrada, trabajador);
	}
	
	/**
	 * test que valida respuesta actualiozacion modificacion
	 */
	@Test
	public void testValidaActualizacionModificacion() {
		modificacionService.validaActualizacionModificacion(true, false, false, false);
		modificacionService.validaActualizacionModificacion(false, true, false, false);
		modificacionService.validaActualizacionModificacion(false, false, true, false);
		modificacionService.validaActualizacionModificacion(false, false, false, true);
		modificacionService.validaActualizacionModificacion(true, true, true, true);
		modificacionService.validaActualizacionModificacion(false, false, false, false);
	}
	
	/**
	 * test para validar nombre bloque nombre completo
	 */
	@Test
	public void testValidarNombreCompletoModificacion() {
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("nombre");
		datosCertificables.setApellidoPaterno("apellidoPAterno");
		datosCertificables.setApellidoMaterno("apellidoMaterno");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setNombreTrabajador("nombreTrabajador");
		datosBase.setApellidoPaterno("apellidoPaterno");
		datosBase.setApellidoMaterno("apellidoMaterno");
		EntradaModificacion entradaProceso = new EntradaModificacion();
		entradaProceso.setDatosBaseCurp(datosBase);
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","valor","3","4","5","6","7","8","9","10","11","12");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6");

		modificacionService.validarNombreCompleto(datosTrabajador, entradaProceso);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");

		modificacionService.validarNombreCompleto(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test valida bloque nombre completo permanencia 
	 */
	@Test
	public void testValidarNombreCompletoPermanencia() {
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("nombre");
		datosCertificables.setApellidoPaterno("apellidoPAterno");
		datosCertificables.setApellidoMaterno("apellidoMaterno");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosCertificables(datosCertificables);	
		
		EntradaPermanencia entradaProceso = new EntradaPermanencia();
		entradaProceso.setNombreTrabajador("nombreTrabajador");
		entradaProceso.setApellidoPaterno("apellidoPaterno");
		entradaProceso.setApellidoMaterno("apellidoMaterno");
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","valor","3","4","5","6","7","8","9","10","11","12");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6");

		modificacionService.validarNombreCompleto(datosTrabajador, entradaProceso);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		modificacionService.validarNombreCompleto(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test para validar bloque datos base mas nacionalidad modificacion
	 */
	@Test
	public void testVarlidarDatosBaseMasNacionalidadModificacion() {
		DatosNoCertificables noCertificables = new DatosNoCertificables();
		noCertificables.setClaveNacionalidad(1L);
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("curp");
		datosCertificables.setClaveGenero("claveGenero");
		datosCertificables.setFechaNacimiento("23/junio/1996");
		datosCertificables.setEntidadNacimiento("entidadNacimiento");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosNoCertificables(noCertificables);
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curpNueva");
		datosBase.setSexo("1");
		datosBase.setFechaDeNacimiento("1996-02-01");
		datosBase.setEntidadFederativaDeNacimiento("entidadFederativaDeNacimiento");
		datosBase.setNacionalidad("1");
		EntradaModificacion entradaProceso = new EntradaModificacion();
		entradaProceso.setDatosBaseCurp(datosBase);

		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setCvNacionalidad("1");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("1996-02-01");
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("19960201");
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(servicioCatalogo.obtenerNacionalidadPorClave(Mockito.anyString())).thenReturn(nacionalidad);
		modificacionService.varlidarDatosBaseMasNacionalidad(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test para validar datos base mas nacionalidad permanencia
	 */
	@Test
	public void testVarlidarDatosBaseMasNacionalidadPermanencia() {
		DatosNoCertificables noCertificables = new DatosNoCertificables();
		noCertificables.setClaveNacionalidad(1L);
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("curp");
		datosCertificables.setClaveGenero("claveGenero");
		datosCertificables.setFechaNacimiento("23/junio/1996");
		datosCertificables.setEntidadNacimiento("entidadNacimiento");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosNoCertificables(noCertificables);
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		EntradaPermanencia entradaProceso = new EntradaPermanencia();
		entradaProceso.setNacionalidad("1");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","3","4","5","6");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("1996-02-01");
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("19960201");
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.varlidarDatosBaseMasNacionalidad(datosTrabajador, entradaProceso);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("1","1","1","1","1");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("1996-02-01");
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("19960201");
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.varlidarDatosBaseMasNacionalidad(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test valida domicilio modificacion
	 */
	@Test
	public void testValidaDomicilioModificacion() {
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle("calle");
		domicilio.setColonia("colonia");
		domicilio.setMunicipio("municipio");
		domicilio.setEntidadFederativa("entidadFederativa");
		domicilio.setNoExterior("noExterior");
		domicilio.setNoInterior("noInterior");
		
		DatosComplementarios datosComplementarios = new DatosComplementarios();
		datosComplementarios.setParticular(domicilio);
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosComplementarios(datosComplementarios);
		DatosDomicilioParticularTrabajador domicilioParticular = new DatosDomicilioParticularTrabajador();
		domicilioParticular.setCalle("calle");
		domicilioParticular.setColonia("colonia");
		domicilioParticular.setDelegacionOMunicipio("delegacionOMunicipio");
		domicilioParticular.setEntidadFederativa("entidadFederativa");
		domicilioParticular.setNumeroExterior("numeroExterior");
		domicilioParticular.setNumeroInterior("numeroInterior");
		domicilioParticular.setCodigoPostal("codigoPostal");
		domicilioParticular.setPais("pais");
		EntradaModificacion entradaProceso = new EntradaModificacion();
		entradaProceso.setDatosDomicilioParticularTrabajador(domicilioParticular);
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
		modificacionService.validaDomicilio(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test valida domicilio permanencia
	 */
	@Test
	public void testValidaDomicilioPermanencia() {
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle("calle");
		domicilio.setColonia("colonia");
		domicilio.setMunicipio("municipio");
		domicilio.setEntidadFederativa("entidadFederativa");
		domicilio.setNoExterior("noExterior");
		domicilio.setNoInterior("noInterior");
		
		DatosComplementarios datosComplementarios = new DatosComplementarios();
		datosComplementarios.setParticular(domicilio);
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosComplementarios(datosComplementarios);
		DatosParticulares domicilioParticular = new DatosParticulares();
		domicilioParticular.setCalle("calle");
		domicilioParticular.setColonia("colonia");
		domicilioParticular.setDelegacionOMunicipio("delegacionOMunicipio");
		domicilioParticular.setEntidadFederativa("entidadFederativa");
		domicilioParticular.setNumeroExterior("numeroExterior");
		domicilioParticular.setNumeroInterior("numeroInterior");
		domicilioParticular.setCodigoPostal("codigoPostal");
		domicilioParticular.setPais("pais");
		EntradaPermanencia entradaProceso = new EntradaPermanencia();
		entradaProceso.setDatosParticulares(domicilioParticular);
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
		
		modificacionService.validaDomicilio(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test valida rfc modificacion
	 */
	@Test
	public void testValidarCambiosRfcModificacion() {
		DatosNoCertificables noCertificables = new DatosNoCertificables();
		noCertificables.setRfc("rfc");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosNoCertificables(noCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setRfc("rfc");
		
		EntradaModificacion entradaProceso = new EntradaModificacion();
		entradaProceso.setDatosBaseCurp(datosBase);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto1","texto2");
		modificacionService.validarCambiosRfc(datosTrabajador, entradaProceso);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","texto");
		modificacionService.validarCambiosRfc(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test valida cambios rfc permanencia
	 */
	@Test
	public void testValidarCambiosRfcPermanencia() {
		DatosNoCertificables noCertificables = new DatosNoCertificables();
		noCertificables.setRfc("rfc");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosNoCertificables(noCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setRfc("rfc");
		
		EntradaPermanencia entradaProceso = new EntradaPermanencia();
		entradaProceso.setRfc("rfc");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto1","texto2");
		modificacionService.validarCambiosRfc(datosTrabajador, entradaProceso);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto","texto");
		modificacionService.validarCambiosRfc(datosTrabajador, entradaProceso);
	}
	
	/**
	 * test validar cambio cur coppel modificacion
	 */
	@Test
	public void testValidarCambioCurpCoppelModificacion() {
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("curp");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setTipoSolicitante("01");
		trabajador.setDatosCertificables(datosCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curpNueva");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		String bandera13 = "1";
		
		ExpedienteDetail expediente = new ExpedienteDetail();
		expediente.setCvEstatusExpe("1");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("5","curpActual","curpActual");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		modificacionService.validarCambioCurpCoppel("5", "568", trabajador, entradaModificacion, bandera13);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("1","curpActual","curpActual2");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expediente);
		modificacionService.validarCambioCurpCoppel("1", "568", trabajador, entradaModificacion, bandera13);
	}
	
	/**
	 * test valida datos base
	 */
	@Test
	public void testValidarDatosBase() {
		
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("curp");
		datosCertificables.setClaveGenero("claveGenero");
		datosCertificables.setFechaNacimiento("fechaNacimiento");
		datosCertificables.setClaveEntidadN("claveEntidadN");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curpNueva");
		datosBase.setFechaDeNacimiento("1998-02-01");
		datosBase.setSexo("2");
		datosBase.setEntidadFederativaDeNacimiento("entidadFederativaDeNacimiento");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("1","2","3");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), any(String.class))).thenReturn("1998-02-01");
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("00000000");
		Mockito.when(validadorUtils.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		modificacionService.varlidarDatosBase(datosTrabajador, entradaModificacion);
	}
	
	/**
	 * test regresa datos base modificacion
	 */
	@Test
	public void testRegresaDatosBaseModificacion() {
		DatosBaseFormulario datosBaseFormulario = new DatosBaseFormulario();
		datosBaseFormulario.setCurpNueva("curpNueva");
		datosBaseFormulario.setNombreNuevo("nombreNuevo");
		datosBaseFormulario.setApellidoPaternoNuevo("apellidoPaternoNuevo");
		datosBaseFormulario.setApellidoMaternoNuevo("apellidoMaternoNuevo");
		datosBaseFormulario.setFechaNacimientoNuevo("fechaNacimientoNuevo");
		datosBaseFormulario.setGeneroNuevo("generoNuevo");
		datosBaseFormulario.setEntidadNacimientoNuevo("entidadNacimientoNuevo");
		
		modificacionService.regresaDatosBaseModificacion(datosBaseFormulario);
	}
	
	/**
	 * test regresa respuesta validatos datos base
	 */
	@Test
	public void testRegresarRespuestaValidaDatosBase() {
		modificacionService.regresarRespuestaValidaDatosBase(true, true);
		modificacionService.regresarRespuestaValidaDatosBase(false, false);
		modificacionService.regresarRespuestaValidaDatosBase(false, true);
		modificacionService.regresarRespuestaValidaDatosBase(true, false);
	}
	
	/**
	 * test valida marcas proceso permanencia
	 */
	@Test(expected=BusinessException.class)
	public void testValidaMarcasProcesoPermanencia() {
		modificacionService.validaMarcasProcesoPermanencia(1);
		modificacionService.validaMarcasProcesoPermanencia(2);
	}
	
	/**
	 * Test para verificar que curp devolver
	 */
	@Test
	public void testRegresarCurpActualNueva() {
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor","valor");
		modificacionService.regresarCurpActualNueva("curp", "curp");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor","valor2");
		modificacionService.regresarCurpActualNueva("curp", "curp");
	}
	
	/**
	 * Test para recuperar folio padre origen
	 */
	@Test
	public void testRecuperaFolioPadreOrigen() {
		Folio folio = new Folio();
		folio.setEstatusPadre(2L);
		ArchivoRecibido archivoRecibido = new ArchivoRecibido();
		archivoRecibido.setFolioProcesarRecibido("folio");
		archivoRecibido.setId(1L);
		FlujoModificacion flujo = new FlujoModificacion();
		
		RespuestaExpedienteDetalle respuestaExpedienteDetalle = new RespuestaExpedienteDetalle();
		respuestaExpedienteDetalle.setFolioAfore("folioAfore");
		List<RespuestaExpedienteDetalle> listaExpeDetalle = new ArrayList<>();
		listaExpeDetalle.add(respuestaExpedienteDetalle);
		
		ExpedienteDetail expedienteDetail = new ExpedienteDetail();
		List<ExpedienteDetail> listaExpedienteDetail = new ArrayList<>();
		listaExpedienteDetail.add(expedienteDetail);
		
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		Mockito.when(expedienteService.consultaExpedienteSolicitud(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(expedienteDetail);
		modificacionService.recuperaFolioPadreOrigen("curp", "67", "claveAfore", "resultadoOperacion", flujo);
		
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		Mockito.when(expedienteService.buscarExpendienteServ(Mockito.anyLong())).thenReturn(listaExpeDetalle);
		Mockito.when(expedienteService.buscarExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listaExpedienteDetail);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		modificacionService.recuperaFolioPadreOrigen("curp", "01", "claveAfore", "resultadoOperacion", flujo);
		
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		Mockito.when(expedienteService.buscarExpendienteServ(Mockito.anyLong())).thenReturn(listaExpeDetalle);
		Mockito.when(expedienteService.buscarExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listaExpedienteDetail);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		modificacionService.recuperaFolioPadreOrigen("curp", "01", "claveAfore", "resultadoOperacion", flujo);
		
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		modificacionService.recuperaFolioPadreOrigen("curp", "proceso", "claveAfore", "resultadoOperacion", flujo);
	
		folio.setEstatusPadre(3L);
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		modificacionService.recuperaFolioPadreOrigen("curp", "proceso", "claveAfore", "resultadoOperacion", flujo);
	}
	
	/**
	 * Test que recupera folio origen proceso
	 */
	@Test
	public void testRecuperarFolioOrigenPorProceso() {
		ArchivoRecibido archivoRecibido = new ArchivoRecibido();
		archivoRecibido.setFolioProcesarRecibido("folio");
		Folio folio = new Folio();
		folio.setEstatusPadre(2L);
		DatosBaseCurp datosBaseCurp = new DatosBaseCurp();
		datosBaseCurp.setCurpNueva("curpNueva");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBaseCurp);
		EntradaPermanencia entradaPermanencia = new EntradaPermanencia();
		FlujoModificacion flujo = new FlujoModificacion();
		DatosCertificables certificables = new DatosCertificables();
		certificables.setCurp("curp");
		DatosTrabajador trabajador = new DatosTrabajador();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("aforeUsuario");
		trabajador.setTipoSolicitante("01");
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor","valor");
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		modificacionService.recuperarFolioOrigenPorProceso(user, trabajador, "bandera13", "banderaP", entradaModificacion, entradaPermanencia, flujo);
		
		entradaPermanencia.setCurpTrabajador("curpTrabajador");
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("valor","valor");
		Mockito.when(servicioArchivos.validaExistenciaRecepcionExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(archivoRecibido);
		Mockito.when(servicioFolio.consultarFolioPadrePorFolioHijo(Mockito.anyString())).thenReturn(folio);
		modificacionService.recuperarFolioOrigenPorProceso(user, trabajador, null, "banderaP", entradaModificacion, entradaPermanencia, flujo);
	}
	
	/**
	 * test para cerrar folio origen
	 */
	@Test
	public void testCerrarFolioOrigen() {
		FlujoModificacion flujoModificacion = new FlujoModificacion();
		flujoModificacion.setIdFolioHijoPulssarOrigen(1L);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.doNothing().when(servicioFolio).cerrarFolio(Mockito.anyLong(), Mockito.any(Integer.class));
		modificacionService.cerrarFolioOrigen(flujoModificacion);
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.doNothing().when(servicioFolio).cerrarFolio(Mockito.anyLong(), Mockito.any(Integer.class));
		modificacionService.cerrarFolioOrigen(flujoModificacion);
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.doNothing().when(servicioFolio).cerrarFolio(Mockito.anyLong(), Mockito.any(Integer.class));
		modificacionService.cerrarFolioOrigen(flujoModificacion);
	}
	
	/**
	 * Test para buscar expediente por tipo 
	 */
	@Test
	public void testBuscarExpedientePorTipo() {
		Mockito.when(expedienteService.consultaExpedienteSolicitud(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.buscarExpedientePorTipo("67", "556", "curpTrabajador", 1L);
		
		RespuestaExpedienteDetalle expedienteDetalle = new RespuestaExpedienteDetalle();
		expedienteDetalle.setFolioAfore("folio");
		List<RespuestaExpedienteDetalle> listaExpeDetalle = new ArrayList<>();
		listaExpeDetalle.add(expedienteDetalle);
		
		List<ExpedienteDetail> listaExpediente = new ArrayList<>();
		
		Mockito.when(expedienteService.buscarExpendienteServ(Mockito.anyLong())).thenReturn(listaExpeDetalle);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(expedienteService.buscarExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listaExpediente);
		modificacionService.buscarExpedientePorTipo("01", "556", "curpTrabajador", 1L);

		listaExpeDetalle.add(null);
		Mockito.when(expedienteService.buscarExpendienteServ(Mockito.anyLong())).thenReturn(listaExpeDetalle);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(expedienteService.buscarExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listaExpediente);
		modificacionService.buscarExpedientePorTipo("01", "556", "curpTrabajador", 1L);
	
		List<RespuestaExpedienteDetalle> listaExpeDetalleVacia = new ArrayList<>();
		Mockito.when(expedienteService.buscarExpendienteServ(Mockito.anyLong())).thenReturn(listaExpeDetalleVacia);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(expedienteService.buscarExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(listaExpediente);
		modificacionService.buscarExpedientePorTipo("01", "556", "curpTrabajador", 1L);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testValidaFlujo9B() {
		String[] curpHistoricas = {};
		CURPStruct respuestaRenapo = new CURPStruct();
		respuestaRenapo.setCurp("AALR910905HSLLNM03");
		respuestaRenapo.setNombres("nombre");
		respuestaRenapo.setCurpHistoricas(curpHistoricas);
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("AALR920905HSLLNM03");
		datosCertificables.setNombre("nombreActual");
		datosCertificables.setApellidoPaterno("apellidoPaternoActual");
		datosCertificables.setApellidoMaterno("apellidoMaternoActual");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosCertificables(datosCertificables);
		datosTrabajador.setTipoAfiliacion("2");
		datosTrabajador.setNss("45678903456");
		
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		
		Parametro parametroIssste = new Parametro();
		parametroIssste.setChParametro("ISSSTE");
		parametroIssste.setChValorParametro("4,5,9");
		List<Parametro> listaParametroIssste = new ArrayList<>();
		listaParametroIssste.add(parametroIssste);
		
		Canase canase = new Canase();
		canase.setNombreImss("apellidoPaterno$apellidoMaterno$nombre");
		
		List<String> listaString = new ArrayList<>();
		listaString.add("4");
		listaString.add("5");
		listaString.add("9");
		
		Parametro parametroAfores = new Parametro();
		parametroAfores.setChValorParametro("556");
		
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("AALR910905HSLLNM03","AALR920905HSLLNM03","nombreActual","apellidoPaternoActual","apellidoMaternoActual","nombre","apellidoPaterno","apellidoMaterno","apellidoPaterno","apellidoMaterno","nombre","apellidoPaterno$apellidoMaterno$nombre","apellidoPaterno","apellidoMaterno","nombre");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("urlRenapo");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(CURPStruct.class))).thenReturn(respuestaRenapo);
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","apellidoPaterno","apellidoMaterno","nombre");
		Mockito.when(servicioCatalogo.obtenerParametroDdbpose(Mockito.anyString())).thenReturn(listaParametroIssste);
		
		List<Parametro> p = new ArrayList<>();
		List<String> p2 = null;
		Mockito.when(validadorUtils.obtenerListaParametro(p, Mockito.anyString(), p2)).thenReturn(listaString);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(canaceService.consultarCanase(Mockito.anyString())).thenReturn(canase);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(expedienteServicio.obtenerValorParametro(Mockito.anyString())).thenReturn(parametroAfores);
		modificacionService.validaFlujo9B(datosTrabajador, "AALR910905HSLLNM03", "nombre", "apellidoPaterno", "apellidoMaterno","556");
	}
	
	/**
	 * test validar indicador enrolamiento
	 */
	@Test
	public void testValidarIndicadorEnrolamiento9B() {
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.validarIndicadorEnrolamiento9B("1", "2");
		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.validarIndicadorEnrolamiento9B("1", "5");

		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.validarIndicadorEnrolamiento9B(null, "5");
	}
	
	/**
	 * test asignar flujo 9b
	 */
	@Test
	public void testAsignarFlujoCaso9B() {
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		modificacionService.asignarFlujoCaso9B("1");
		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.asignarFlujoCaso9B(null);
	}
	
	/**
	 * Test para validar estatus expedientes
	 */
	@Test
	public void testValidarEstatusExpedientes() {
		FlujoModificacion flujoModificacion = new FlujoModificacion();
		flujoModificacion.setEstatusExpeIdentificacion("1");
		flujoModificacion.setEstatusExpeBiometrico("5");
		ExpedienteSalida expedienteSalida = new ExpedienteSalida();
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE);
		modificacionService.validarEstatusExpedientes(flujoModificacion, expedienteSalida);
		
		flujoModificacion.setEstatusExpeIdentificacion(null);
		flujoModificacion.setEstatusExpeBiometrico(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		modificacionService.validarEstatusExpedientes(flujoModificacion, expedienteSalida);
//		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		modificacionService.validarEstatusExpedientes(null, expedienteSalida);
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		modificacionService.validarEstatusExpedientes(flujoModificacion, null);
		
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		modificacionService.validarEstatusExpedientes(null, null);
	}
	
	/**
	 * test para validacion consulta anexo a
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testValidaConsultaAnexo() {
		AnexoATrabajadorIssste anexo = new AnexoATrabajadorIssste();
		anexo.setChApellidoPaterno("apellidoPaterno");
		anexo.setChApellidoMaterno("apellidoMaterno");
		anexo.setChNombre("nombre");
		anexo.setCurp("curp");
		List<AnexoATrabajadorIssste> listaAnexoVacia = new ArrayList<>();

		List<AnexoATrabajadorIssste> listaAnexo = new ArrayList<>();
		listaAnexo.add(anexo);
		Mockito.when(anexoService.consultaAnexoTrabajador(Mockito.anyString())).thenReturn(listaAnexoVacia,listaAnexo);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp","apellidoPaterno","apellidoPaterno","apellidoMaterno","apellidoMaterno","nombre","nombre");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp");
		modificacionService.validaConsultaAnexo("curp", "curp", "apellidoPaternoFormularioLimplio", "apellidoMaternoFormularioLimpio", "nombreFormularioLimpio", "0", "!");
		
		Mockito.when(anexoService.consultaAnexoTrabajador(Mockito.anyString())).thenReturn(listaAnexoVacia,listaAnexo);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp","apellidoPaterno","apellidoMaterno","apellidoMaterno","apellidoMaterno","nombre","nombre");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp");
		modificacionService.validaConsultaAnexo("curp", "curp", "apellidoPaternoFormularioLimplio", "apellidoMaternoFormularioLimpio", "nombreFormularioLimpio", "0", "!");
		
		Mockito.when(anexoService.consultaAnexoTrabajador(Mockito.anyString())).thenReturn(listaAnexoVacia,listaAnexo);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp","apellidoPaterno","apellidoMaterno","apellidoMaterno","apellidoMaterno","nombre","nombre");
		Mockito.when(notificacionExpedienteService.eliminarAcentos(Mockito.anyString(), Mockito.anyString())).thenReturn("apellidoPaterno","apellidoMaterno","nombre","curp");
		modificacionService.validaConsultaAnexo("curp", "curp", "apellidoPaternoFormularioLimplio", "apellidoMaternoFormularioLimpio", "nombreFormularioLimpio", "0", "!");
	}
	
	@Test
	public void testValidaExpedienteEnrolamientoNoTitular9Bl() {
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setCurp("curp");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosCertificables(datosCertificables);
		DatosBaseCurp datosBaseCurp = new DatosBaseCurp();
		datosBaseCurp.setCurpNueva("curpNueva");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBaseCurp);
		
		ExpedienteDetail expediente = new ExpedienteDetail();
		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.validaExpedienteEnrolamientoNoTitular9B(trabajador, entradaModificacion, "1");

		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null,null,expediente);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE,Boolean.FALSE);
		modificacionService.validaExpedienteEnrolamientoNoTitular9B(trabajador, entradaModificacion, "1");
		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(expedienteService.consultarExpedienteProcesoSinAfore(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null,expediente,null);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE,Boolean.TRUE);
		modificacionService.validaExpedienteEnrolamientoNoTitular9B(trabajador, entradaModificacion, "1");
		
		Mockito.when(validadorUtils.isEmpty(Mockito.any())).thenReturn(Boolean.TRUE);
		modificacionService.validaExpedienteEnrolamientoNoTitular9B(trabajador, entradaModificacion, "1");
	}

}
