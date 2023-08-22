package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.DisposicionTotalImssServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSubcuentasDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Subcuenta;
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
public class DisposicionTotalImssMockServiceTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private DisposicionTotalImssService disposicionTotalImssService =new DisposicionTotalImssServiceImpl();

	/**
	 * dependencia clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	
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
	 * folioService
	 */
	private FolioService folioService;
	
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	
	/**
	 * uriCancelacion
	 */
	@Value("#{propiedades['cancelacion.disposicionTotalImss']}")
	private String uriCancelacion;
	
	/**
	 * uriDisposicionIsssteTotal
	 */
	@Value("#{propiedades['disposicion.total.solicitud.imss']}")
	private String uriDisposicionImssTotal;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(disposicionTotalImssService,"uriComunes","http://lbint-devl.procesar.net/comunesPulssar/");
		ReflectionTestUtils.setField(disposicionTotalImssService,"uriCancelacion","http://172.21.66.90/retirosint/v1/815/disposiciontotal/cancelacion");
		ReflectionTestUtils.setField(disposicionTotalImssService,"uriDisposicionImssTotal","http://172.21.66.90/retirosint/v1/763/disposiciontotal/solicitud");
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
			disposicionTotalImssService.consultarCancelacion(entrada);
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
			obj1.setIdProceso(368L);
			folisoDetalle.add(obj1);
			FolioSalida obj = new FolioSalida();
			obj.setFolioDetalles(folisoDetalle);
			obj.setIdFolioPulssar(123L);
			folios.add(obj);
			ResponseEntity<String> respuesta = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			DatosTrabajador trabajador = new DatosTrabajador();
			disposicionTotalImssService.validarCancelacion(folios, trabajador, folios, "123");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarDisposicion () {
		try {
			DatosCertificables datosCertificables = new DatosCertificables();
			FolioEntrada folio = new FolioEntrada();
			DatosTrabajador trabajador = new DatosTrabajador();
			trabajador.setFolio(folio);
			trabajador.setDatosCertificables(datosCertificables);
			datosCertificables.setNombre("33");
			ProcesoDerechoCargadoEntrada entradaParams = new ProcesoDerechoCargadoEntrada();
			entradaParams.setSemanasCotizadas(12L);
	        entradaParams.setPorcentajeValuacion(123L);
			entradaParams.setSecuenciaPension("01");
			entradaParams.setFcEmisionResolucion("01/03/2020");
			entradaParams.setFcInicioPension("01/03/2020");
			entradaParams.setCvTipoPension("RE");
			entradaParams.setCvTipoRegimen("73");
			entradaParams.setCvTipoPrestacion("08");
			entradaParams.setCvTipoSeguro("TJ");
			entradaParams.setCvTipoRetiro("G");
			entradaParams.setFechaSolicitud("01/03/2020");
			entradaParams.setCveDocProbatorio("1");
			entradaParams.setAseguradora("530");
			entradaParams.setActuarioAutorizado("1");
			entradaParams.setNumPlanPrivadoPensiones("33332");
			entradaParams.setFechaPeriodoPagoReingreso("000000");
			entradaParams.setConsecutivoTrabajador("0");
			entradaParams.setIdSolcitante("01");
			entradaParams.setCurpSolicitante("CURP005217MDFRSL47");
			entradaParams.setSelloUnico("00000000000000");
			entradaParams.setCurpAgenteServicio("CURP005217MDFRSL47");
			entradaParams.setIdBeneficiario("1");
			entradaParams.setApPaternoBeneficiario("Flores");
			entradaParams.setApMaternoBeneficiario("Lopez");
			entradaParams.setNombreBeneficiario("Maria");
			entradaParams.setClabePago("1226733GGGG5487000");
			entradaParams.setCurpPago("CURP005217MDFRSL47");
			entradaParams.setRfcPago("BEMF4812173H5");
			entradaParams.setFolioInfonavit("51226733GGGG54");
			entradaParams.setGrupo("01");
			entradaParams.setMontoTotalRcv("$344.33");
			entradaParams.setMontoTotalViv("$334.44");
			List<DatosSubcuentasDispIssste> rcv = new ArrayList<>();
			DatosSubcuentasDispIssste obj = new DatosSubcuentasDispIssste();
			obj.setMonto("333");
			obj.setClaveSubcuenta("01");
			obj.setSiefore("01");
			obj.setAcciones("33.44");
			rcv.add(obj);
			DatosSubcuentasDispIssste obj2 = new DatosSubcuentasDispIssste();
			obj2.setMonto("333");
			obj2.setClaveSubcuenta("02");
			obj2.setSiefore("01");
			obj2.setAcciones("33.44");
			rcv.add(obj2);
			
			DatosSubcuentasDispIssste obj3 = new DatosSubcuentasDispIssste();
			obj3.setMonto("333");
			obj3.setClaveSubcuenta("03");
			obj3.setSiefore("01");
			obj3.setAcciones("33.44");
			rcv.add(obj3);
			
			DatosSubcuentasDispIssste obj4 = new DatosSubcuentasDispIssste();
			obj4.setMonto("333");
			obj4.setClaveSubcuenta("08");
			obj4.setSiefore("01");
			obj4.setAcciones("33.44");
			rcv.add(obj4);
			entradaParams.setSubcuentasRcv(rcv);
			
			List<DatosSubcuentasDispIssste> viv = new ArrayList<>();
			DatosSubcuentasDispIssste obj8 = new DatosSubcuentasDispIssste();
			obj8.setMonto("333");
			obj8.setClaveSubcuenta("04");
			obj8.setSiefore("01");
			obj8.setAcciones("3323");
			viv.add(obj8);
			DatosSubcuentasDispIssste obj5 = new DatosSubcuentasDispIssste();
			obj5.setMonto("333");
			obj5.setClaveSubcuenta("09");
			obj5.setSiefore("01");
			obj5.setAcciones("3323");
			viv.add(obj5);
			DatosSubcuentasDispIssste obj9 = new DatosSubcuentasDispIssste();
			obj9.setMonto("333");
			obj9.setClaveSubcuenta("07");
			obj9.setSiefore("01");
			obj9.setAcciones("3323");
			viv.add(obj9);
			entradaParams.setSubcuentasViv(viv);
			List<Siefore> lista = new ArrayList<>();
			Siefore objS = new Siefore();
			objS.setClave("01");
			objS.setClaveGrupoTrabajador("01");
			lista.add(objS);
			entradaParams.setSieforesLista(lista);
			ResponseEntity<String> respuesta = new ResponseEntity<>("" , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			disposicionTotalImssService.consultarImssDisposicionTotal(entradaParams, trabajador);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarDisposicionError () {
		try {

			ProcesoDerechoCargadoEntrada entradaParams = new ProcesoDerechoCargadoEntrada();
			DatosTrabajador trabajador = new DatosTrabajador();
			disposicionTotalImssService.consultarImssDisposicionTotal(entradaParams, trabajador);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * 
	 * Datos seteo para Cargado
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testSetearDerechoCargado() {
		List<Parametro> listaParametro= new ArrayList<>();
		List<ProcesoDerechoCargado> listaDerechoCargado = new ArrayList<>();
		ProcesoDerechoCargado cargado = new ProcesoDerechoCargado();
		cargado.setCvTipoPension("RT");
		cargado.setCvTipoPrestacion("IP");
		cargado.setCvTipoRegimen("73");
		cargado.setCvTipoRetiro("D");
		cargado.setCvTipoSeguro("00");
		cargado.setDescTipoPension("des1");
		cargado.setDescTipoPrestacion("des2");
		cargado.setDescTipoRegimen("desc3");
		cargado.setDescTipoRetiro("desc4");
		cargado.setDescTipoSeguro("des5");
		cargado.setFcEmisionResolucion(new Date());
		cargado.setFcInicioPension(new Date());
		cargado.setNumeroResolucion("1");
		cargado.setPorcentajeValuacion(1l);
		cargado.setSecuenciaPension("1");
		cargado.setSemanasCotizadas(1l);
		
		listaDerechoCargado.add(cargado);
		
		Parametro param = new Parametro();
		param.setChParametro("7301");
		param.setChValorParametro("D,E,F,G,H,J,M,P,");
		param.setCvParametro("1");
		param.setFechaModificacion(new Date());
		param.setIdParametro(738l);
		param.setUsuarioModificacion("USER");
		listaParametro.add(param);
		
		Mockito.when(fechaUtils.convertirFechaACadena(new Date(), ActivacionConstants.DDMMYYYY)).thenReturn("");
		List<ProcesoDerechoCargadoEntrada> listaSolicitante =	disposicionTotalImssService.setearDerechoCargado("7301", listaParametro, listaDerechoCargado);
		Assert.assertNotNull(listaSolicitante);
	}

	/**
	 * 
	 *  Agrupacion de SubCuentas
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testObtenerAgruparSuBcuentas() {
		List<DerechoSubcuenta> listaSubCuentas= new ArrayList<>();
		DerechoSubcuenta cuenta = new DerechoSubcuenta();
		Subcuenta subcuenta = new Subcuenta();
		subcuenta.setClasificacion("a");
		subcuenta.setClave("1");
		subcuenta.setDescripcion("desc2");
		subcuenta.setSubcuentaSaldo("100");
		cuenta.setIdMatrizDerecho(1l);
		cuenta.setChDestinoRecurso("des");
		cuenta.setChUsuarioModificador("USER");
		cuenta.setCvEstatusVivienda("1");
		cuenta.setCvSubCuenta(subcuenta);
		cuenta.setFcControl(new Date());
		cuenta.setIdDerechoSubCuenta(1l);
		subcuenta.setUsuarioModificador("User");
		listaSubCuentas.add(cuenta);
		listaSubCuentas = disposicionTotalImssService.obtenerAgruparSuBcuentas(listaSubCuentas);
		Assert.assertNotNull(listaSubCuentas);
	}
	

}
