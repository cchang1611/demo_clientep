package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.DisposicionTotalIsssteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AportacionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSubcuentasDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuentaIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteCancelacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IrecTcSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretMatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.LineaCapturaPago;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * Disposicion total
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class DisposicionTotalIsssteMockServiceTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private DisposicionTotalIsssteService disposicionTotalIsssteService =new DisposicionTotalIsssteServiceImpl();

	/**
	 * dependencia clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	
	/**
	 * fechaUtils
	 */
	@Mock
	private FechaUtils fechaUtils;
	
	
	/**
	 * uriIsssteRegimenOrdinario
	 */
	@Value("#{propiedades['disposicionIssste.regimenOrdinario']}")
	private String uriIsssteRegimenOrdinario;
	
	
	/**
	 * uriDisposicionIsssteTotal
	 */
	@Value("#{propiedades['disposicionIssste.total']}")
	private String uriDisposicionIsssteTotal;
	
	
	/**
	 * uriCancelacion
	 */
	@Value("#{propiedades['cancelacion.disposicionTotal']}")
	private String uriCancelacion;
	
	/**
	 * cusService
	 */
	@Mock
	private CusService cusService;
	
	/**
	 * Inyeccion dependencia FolioService
	 */
	@Mock
	private FolioService folioService;
	

	
	
	/**
	 * Variable consulta Recepcion arcvhios
	 */
	@Value("#{propiedades['url.consulta.archivo.recepcion']}")
	private String consultaRecepcionArchivo;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(disposicionTotalIsssteService,"uriComunes","http://lbint-devl.procesar.net/comunesPulssar/");
		ReflectionTestUtils.setField(disposicionTotalIsssteService,"uriDisposicionIsssteTotal","http://172.21.66.90/retirosint/v1/822/issste/disposiciontotal/solicitud");
		ReflectionTestUtils.setField(disposicionTotalIsssteService,"uriIsssteRegimenOrdinario","http://172.21.66.90/retirosint/v1/825/issste/disposiciontotal/regimenordinario/solicitud");
		ReflectionTestUtils.setField(disposicionTotalIsssteService,"uriCancelacion","http://172.21.66.90/retirosint/v1/830/issste/disposiciontotal/cancelacion");
		ReflectionTestUtils.setField(disposicionTotalIsssteService,"consultaRecepcionArchivo","http://lbint-devl.procesar.net/comunesPulssar/archivorecibido/consultar/{foliopulssar}/{tipoArchivo}");

	}
	
	/**
	 * Para consultar cus
	 */
	@Test
	public void testConsultarCus () {
		try {
			DatosCertificables datosCer = new DatosCertificables();
			DatosNoCertificables datosNoCer = new DatosNoCertificables();
			DatosComplementarios com = new DatosComplementarios();
			Telefono tel = new Telefono();
			datosCer.setFechaNacimiento("03/03/2021");
			DatosTrabajador trabajador = new DatosTrabajador();
			trabajador.setDatosCertificables(datosCer);
			trabajador.setDatosNoCertificables(datosNoCer);
			com.setTelefonos(tel);
			trabajador.setDatosComplementarios(com);
			UsuarioLogin user =new UsuarioLogin();
			RespuestaGeneraCusSalida salida = new RespuestaGeneraCusSalida();
			salida.setResultadoOperacion("01");
			Mockito.when(
					fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(new Date());
			Mockito.when(
					cusService.generarCus(Mockito.any(EntradaCus.class)))
					.thenReturn(salida);
			disposicionTotalIsssteService.generarCus(trabajador, user, "ISSSTE", 01L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para consultar cus
	 */
	@Test
	public void testConsultarCusDos () {
		try {
			DatosCertificables datosCer = new DatosCertificables();
			DatosNoCertificables datosNoCer = new DatosNoCertificables();
			DatosComplementarios com = new DatosComplementarios();
			Telefono tel = new Telefono();
			datosCer.setFechaNacimiento("03/03/2021");
			DatosTrabajador trabajador = new DatosTrabajador();
			trabajador.setDatosCertificables(datosCer);
			trabajador.setDatosNoCertificables(datosNoCer);
			com.setTelefonos(tel);
			trabajador.setDatosComplementarios(com);
			UsuarioLogin user =new UsuarioLogin();
			RespuestaGeneraCusSalida salida = new RespuestaGeneraCusSalida();
			salida.setResultadoOperacion("02");
			Mockito.when(
					fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(new Date());
			Mockito.when(
					cusService.generarCus(Mockito.any(EntradaCus.class)))
					.thenReturn(salida);
			disposicionTotalIsssteService.generarCus(trabajador, user, "IMSS", 01L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarNoCargadoIssste () {
		try {
			
			ResponseEntity<String> respuesta = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			DisposicionIsssteEntrada entrada = new DisposicionIsssteEntrada();
			disposicionTotalIsssteService.consultarNoCargadoIssste(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteRetiroC () {
		try {
			DisposicionIsssteEntrada entrada = new DisposicionIsssteEntrada();
			ResponseEntity<String> respuesta = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			disposicionTotalIsssteService.consultarIsssteRetiroC(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarMatrizDerecho () {
		try {
			IretMatrizDerecho iretMatrizDerecho = new IretMatrizDerecho();
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),  Mockito.eq(IretMatrizDerecho.class)))
					.thenReturn(iretMatrizDerecho);
			disposicionTotalIsssteService.consultarMatrizDerecho("01", "01", "01", "01", "01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarMatrizDerechoExcepcion () {
		try {
			disposicionTotalIsssteService.consultarMatrizDerecho("01", "01", "01", "01", "01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerDerechoSubcuentaPorIdMatrizDerecho () {
		try {
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),  Mockito.eq(String.class)))
					.thenReturn("01");
			disposicionTotalIsssteService.obtenerDerechoSubcuentaPorIdMatrizDerecho(123L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteRegimenOrdinario() {
		try {
			SalidaDisposicionTotalIssste objeto = new SalidaDisposicionTotalIssste();
			ResponseEntity<SalidaDisposicionTotalIssste> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaDisposicionTotalIssste.class)))
					.thenReturn(respuesta);
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			List<DatosSubcuentasDispIssste> lista = new ArrayList<>();
			DatosSubcuentasDispIssste obj = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj2 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj3 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj4 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj5 = new DatosSubcuentasDispIssste();
			DatosSaldos datosSaldos = new DatosSaldos();
			datosSaldos.setSaldoVivienda92AIVS("1222");
			datosSaldos.setSaldoFI08AIVS("44");
			entradaParams.setSaldos(datosSaldos);
			obj.setCampoSar92("1");
			obj.setAcciones("333");
			obj.setMonto("333");
			obj.setClaveSubcuenta("22");
			obj.setSiefore("02");
			lista.add(obj);
			
			obj2.setCampoSar92("0");
			obj2.setAcciones("333");
			obj2.setMonto("333");
			obj2.setClaveSubcuenta("27");
			obj2.setSiefore("02");
			lista.add(obj2);
			
			obj3.setCampoSar92("0");
			obj3.setAcciones("333");
			obj3.setMonto("333");
			obj3.setClaveSubcuenta("28");
			obj3.setSiefore("02");
			lista.add(obj3);
			
			
			obj4.setCampoSar92("0");
			obj4.setAcciones("333");
			obj4.setMonto("333");
			obj4.setClaveSubcuenta("15");
			obj4.setSiefore("02");
			lista.add(obj4);
			
			
			obj5.setCampoSar92("0");
			obj5.setAcciones("333");
			obj5.setMonto("333");
			obj5.setClaveSubcuenta("25");
			obj5.setSiefore("02");
			lista.add(obj5);
			List<Siefore> sieforesLista = new ArrayList<>();
			Siefore obj7 = new Siefore();
			obj7.setClave("02");
			obj7.setClaveGrupoTrabajador("02");
			sieforesLista.add(obj7);
			entradaParams.setSieforesLista(sieforesLista);
			entradaParams.setNumeroSemanasCotizadas("33");
			entradaParams.setSubcuentasRcv(lista);
			disposicionTotalIsssteService.consultarIsssteRegimenOrdinario(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteRegimenOrdinarioError() {
		try {
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			List<DatosSubcuentasDispIssste> lista = new ArrayList<>();
			DatosSubcuentasDispIssste obj = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj2 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj3 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj4 = new DatosSubcuentasDispIssste();
			DatosSubcuentasDispIssste obj5 = new DatosSubcuentasDispIssste();
			DatosSaldos datosSaldos = new DatosSaldos();
			datosSaldos.setSaldoVivienda92AIVS("1222");
			datosSaldos.setSaldoFI08AIVS("44");
			entradaParams.setSaldos(datosSaldos);
			obj.setCampoSar92("1");
			obj.setAcciones("333");
			obj.setMonto("333");
			obj.setClaveSubcuenta("22");
			obj.setSiefore("02");
			lista.add(obj);
			
			obj2.setCampoSar92("0");
			obj2.setAcciones("333");
			obj2.setMonto("333");
			obj2.setClaveSubcuenta("27");
			obj2.setSiefore("02");
			lista.add(obj2);
			
			obj3.setCampoSar92("0");
			obj3.setAcciones("333");
			obj3.setMonto("333");
			obj3.setClaveSubcuenta("28");
			obj3.setSiefore("02");
			lista.add(obj3);
			
			
			obj4.setCampoSar92("0");
			obj4.setAcciones("333");
			obj4.setMonto("333");
			obj4.setClaveSubcuenta("15");
			obj4.setSiefore("02");
			lista.add(obj4);
			
			
			obj5.setCampoSar92("0");
			obj5.setAcciones("333");
			obj5.setMonto("333");
			obj5.setClaveSubcuenta("25");
			obj5.setSiefore("02");
			lista.add(obj5);
			List<Siefore> sieforesLista = new ArrayList<>();
			Siefore obj7 = new Siefore();
			obj7.setClave("02");
			obj7.setClaveGrupoTrabajador("02");
			sieforesLista.add(obj7);
			entradaParams.setSieforesLista(sieforesLista);
			entradaParams.setNumeroSemanasCotizadas("33");
			entradaParams.setSubcuentasRcv(lista);
			disposicionTotalIsssteService.consultarIsssteRegimenOrdinario(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteDisposicionTotal() {
		try {
			SalidaDisposicionTotalIssste objeto = new SalidaDisposicionTotalIssste();
			ResponseEntity<SalidaDisposicionTotalIssste> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaDisposicionTotalIssste.class)))
					.thenReturn(respuesta);
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			List<DatosSubcuentasDispIssste> lista = new ArrayList<>();
			DatosSubcuentasDispIssste obj = new DatosSubcuentasDispIssste();
			DatosSaldos datosSaldos = new DatosSaldos();
			datosSaldos.setSaldoVivienda92AIVS("1222");
			datosSaldos.setSaldoFI08AIVS("44");
			entradaParams.setSaldos(datosSaldos);
			obj.setCampoSar92("1");
			obj.setAcciones("333");
			obj.setMonto("333");
			obj.setClaveSubcuenta("22");
			lista.add(obj);
			
			
			entradaParams.setSubcuentasRcv(lista);
			entradaParams.setNumeroSemanasCotizadas("33");
			disposicionTotalIsssteService.consultarIsssteDisposicionTotal(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteDisposicionTotalError() {
		try {
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaDisposicionTotalIssste.class)))
					.thenReturn(null);
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			List<DatosSubcuentasDispIssste> lista = new ArrayList<>();
			DatosSubcuentasDispIssste obj = new DatosSubcuentasDispIssste();
			DatosSaldos datosSaldos = new DatosSaldos();
			datosSaldos.setSaldoVivienda92AIVS("1222");
			datosSaldos.setSaldoFI08AIVS("44");
			entradaParams.setSaldos(datosSaldos);
			entradaParams.setClaveRegimenPlan("33");
			obj.setCampoSar92("1");
			obj.setAcciones("333");
			obj.setMonto("333");
			obj.setClaveSubcuenta("22");
			lista.add(obj);
			
			
			entradaParams.setSubcuentasRcv(lista);
			entradaParams.setNumeroSemanasCotizadas("33");
			disposicionTotalIsssteService.consultarIsssteDisposicionTotal(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarExistenciaCurp() {
		try {
			BaseRespuesta<AportacionIssste> resp  = new BaseRespuesta<AportacionIssste>();
			ResponseEntity<BaseRespuesta<AportacionIssste>> respuesta = new ResponseEntity<>(resp , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(),  Mockito.eq(HttpMethod.GET), Mockito.any(HttpEntity.class),  Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<AportacionIssste>>() {
					})))
					.thenReturn(respuesta);
			disposicionTotalIsssteService.validarCurpExiste("GUHC590806MVZTRR02");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerEstatusViviendaIssste () {
		try {
			List<String> lista = new ArrayList<>();
			ResponseEntity<String> respuesta = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			disposicionTotalIsssteService.obtenerEstatusViviendaIssste(lista);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}

	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerPrecioAccion () {
		try {
			
			String var = "";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerPrecioAccion("01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerPrecioAccionError () {
		try {
			
			disposicionTotalIsssteService.obtenerPrecioAccion("01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerFactorConversion () {
		try {
			
			String var = "";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerFactorConversion("01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerFactorConversionError () {
		try {
		
			disposicionTotalIsssteService.obtenerFactorConversion("01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	

	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerSiefores () {
		try {
			String var = "";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerSiefores(1L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerSieforesError () {
		try {
			disposicionTotalIsssteService.obtenerSiefores(1L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosVivienda () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("16");
			cvSubCuenta2.setCvSubCuenta("24");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("345.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456.77");
			saldo.setSaldoViviendaFI92("54.2");
			saldo.setSaldoFI08("876.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			String var = "[{\"cvTipoFactor\":\"06\",\"fechaValorFactor\":1622005200000,\"nuValorFactor\":1.57665832154117,\"fechaControl\":null,\"usuarioModificacion\":\"***\"}]";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, saldo,  "sief");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosViviendaRangoMayor () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("16");
			cvSubCuenta2.setCvSubCuenta("24");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("34555454545455454.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456535355454.77");
			saldo.setSaldoViviendaFI92("54545435545454.2");
			saldo.setSaldoFI08("8765543455455455.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			String var = "[{\"cvTipoFactor\":\"06\",\"fechaValorFactor\":1622005200000,\"nuValorFactor\":1656555556666565566556.57665832154117,\"fechaControl\":null,\"usuarioModificacion\":\"***\"}]";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, saldo,  "sief");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosViviendaSinPRecioAccion () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("16");
			cvSubCuenta2.setCvSubCuenta("24");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("34555454545455454.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456535355454.77");
			saldo.setSaldoViviendaFI92("54545435545454.2");
			saldo.setSaldoFI08("8765543455455455.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			String var = "[{\"cvTipoFactor\":\"06\",\"fechaValorFactor\":1622005200000,\"nuValorFactor\":3443,\"fechaControl\":null,\"usuarioModificacion\":\"***\"}]";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, saldo,  "sief");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosViviendaVacia () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("16");
			cvSubCuenta2.setCvSubCuenta("24");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("345.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456.77");
			saldo.setSaldoViviendaFI92("54.2");
			saldo.setSaldoFI08("876.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			String var = "[]";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, saldo,  "sief");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosViviendaVaciaNulo () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("16");
			cvSubCuenta2.setCvSubCuenta("24");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("345.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456.77");
			saldo.setSaldoViviendaFI92("54.2");
			saldo.setSaldoFI08("876.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			String var = "";
			Mockito.when(
					clienteServicio.getForObject(Mockito.anyString(),   Mockito.eq(String.class)))
					.thenReturn(var);
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosVivienda(lista, saldo,  "sief");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarCancelacion() {
		try {
			CancelacionSalida objeto = new CancelacionSalida();
			ResponseEntity<CancelacionSalida> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(CancelacionSalida.class)))
					.thenReturn(respuesta);
			DatosGeneralesDispIssste entrada = new DatosGeneralesDispIssste();
			entrada.setCurp("4444");
			entrada.setAforeTrabajador("3233");
			entrada.setFolioSol("9876XXXXXXESS ");
			entrada.setNss("23434");
			entrada.setSecuenciaPension("345");
			disposicionTotalIsssteService.consultarCancelacion(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarCancelacionError() {
		try {
			DatosGeneralesDispIssste entrada = new DatosGeneralesDispIssste();
			entrada.setCurp("4444");
			entrada.setAforeTrabajador("3233");
			entrada.setFolioSol("9876XXXXXXESS ");
			entrada.setNss("23434");
			entrada.setSecuenciaPension("345");
			disposicionTotalIsssteService.consultarCancelacion(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarExpedienteServicio () {
		try {
			ArchivoRecibido objeto = new ArchivoRecibido();
			objeto.setDiagnostico("500");
			objeto.setResultadoOperacion("01");
			ResponseEntity<ArchivoRecibido> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(ArchivoRecibido.class)))
					.thenReturn(respuesta);
			DatosTrabajador datos = new DatosTrabajador();
			UsuarioLogin usuarioLogin = new UsuarioLogin();
			disposicionTotalIsssteService.validarExpedienteServicio("5356", datos, usuarioLogin);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarExpedienteServicioDos () {
		try {
			ArchivoRecibido objeto = new ArchivoRecibido();
			objeto.setDiagnostico("030");
			objeto.setResultadoOperacion("02");
			ResponseEntity<ArchivoRecibido> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(ArchivoRecibido.class)))
					.thenReturn(respuesta);
			DatosTrabajador datos = new DatosTrabajador();
			UsuarioLogin usuarioLogin = new UsuarioLogin();
			disposicionTotalIsssteService.validarExpedienteServicio("5356", datos, usuarioLogin);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarExpedienteServicioTres () {
		try {
			ArchivoRecibido objeto = new ArchivoRecibido();
			objeto.setResultadoOperacion("02");
			ResponseEntity<ArchivoRecibido> respuesta = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(ArchivoRecibido.class)))
					.thenReturn(respuesta);
			DatosTrabajador datos = new DatosTrabajador();
			UsuarioLogin usuarioLogin = new UsuarioLogin();
			disposicionTotalIsssteService.validarExpedienteServicio("5356", datos, usuarioLogin);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarCancelacion () {
		try {
			List<FolioSalida> folios = new ArrayList<>();
			List<FolioDetalle> folisoDetalle = new ArrayList<>();
			FolioDetalle obj1 = new FolioDetalle();
			DatosCertificables datosCertificables = new DatosCertificables();
			obj1.setIdProceso(365L);
			folisoDetalle.add(obj1);
			datosCertificables.setCurp("24424");
			FolioSalida obj = new FolioSalida();
			obj.setFolioDetalles(folisoDetalle);
			obj.setChFolio("34324344343");
			obj.setIdFolioPulssar(123L);
			folios.add(obj);
			String var = "[{\"fechaOperacion\":\"07/06/2021\",\"folioIssste\":\"S0000053202105310010\",\"secuenciaPension\":\"01\",\"curp\":\"GUHC590806MVZTRR02\",\"nss\":null,\"cvProceso\":\"0005\"}]";
			
			ResponseEntity<String> respuesta = new ResponseEntity<>(var , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			DatosTrabajador trabajador = new DatosTrabajador();
			trabajador.setDatosCertificables(datosCertificables);
			disposicionTotalIsssteService.validarCancelacion(folios, trabajador, folios, "123");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarDatosCancelacion () {
		try {
			List<DisposicionIsssteCancelacion> listas =new ArrayList<>();
			DisposicionIsssteCancelacion obj = new DisposicionIsssteCancelacion();
			obj.setCurp("343443");
			listas.add(obj);
			disposicionTotalIsssteService.validarDatosCancel(listas);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarDatosCancelacionVacia () {
		try {
			List<DisposicionIsssteCancelacion> listas =new ArrayList<>();
			
			disposicionTotalIsssteService.validarDatosCancel(listas);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}


}
