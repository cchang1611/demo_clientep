package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudRetiroParcialMatrimonioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.SolicitudRetiroParcialMatrimonioServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
/**
 * Test para la Solcitud Retiro Mtrimonio Pdf
 * @author ANOSORIO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class SolicitudRetiroParcialMatrimonioTestCase {
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudRetiroParcialMatrimonioTestCase.class);  
	
	/**
	 * Inyeccon Servicio
	 */
	@Autowired
	@InjectMocks
	private SolicitudRetiroParcialMatrimonioService solicitudRetiroParcialService = new SolicitudRetiroParcialMatrimonioServiceImpl();
	
	/**
	 * Inyeccion Mock
	 */
	@Autowired
	@Mock
	private CodigoUtils codigoUtils;	
	     
	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test que genera el Pdf
	 */
	@Test
	public void testGeneraSolicitudPdf() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		DatosCertificables certificables = new DatosCertificables();
		entrada.setCurpAgenteServicio("CURP");
		entrada.setFechaMatrimonio("15/10/2000");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago("1");
		certificables.setFechaNacimiento("06/septiembre/1982");
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("CURP AGENTE");
		telefono.setTelefonoFijo("1111111");
		telefono.setCelular("222222222");
		particular.setCalle("PRIMERA SECCION");
		particular.setNoExterior("51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("0000");
		particular.setPais("MEXICO DF");
		particular.setColonia("COL. LACOSTA");
		particular.setEntidadFederativa("EDO MEXICO"); 
		particular.setMunicipio("SIERRA");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("PRUEBA@HOTMAIL");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		datosBanco.setNumeroFolio("1010101");
		datosBanco.setNumeroUnidad("0000001");
		datosBanco.setInstitucionBancaria("BANAMEX_1");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("2314567804");
		certificables.setGenero("MASCULINO1");
		entrada.setCurpAgenteServicio("FOGF85092WEFRREFR");
		entrada.setFechaMatrimonio("01-12-2010");
		entrada.setFirmaEmpleado("xxxxxxxxxxxxxxxxxxxxxxxxx ");
		entrada.setFirmaTrabajador("xxxxxxxxxxxxxxxxxxxxxxxxx");
		entrada.setNombreConyuge("NOMBRE ");
		entrada.setApellidoPaternoConyuge("APELLIDO");
		entrada.setApellidoMaternoConyuge("MATERNO");
		datosTrabajador.setDatosCertificables(certificables);
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {
      	byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida); 
		}catch (Exception e) {
			logger.error("Error:{}",e);
		}
	}
	 
	/**
	 * Error al generar el Pdf
	 */
	@Test
	public void testGeneraSolicitudPdfExcepcion() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {
		solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		}catch (Exception e) {
			logger.error("Error Exception:{}",e);
		}
	}
	  
	@Test
	public void testGeneraSolicitudPdfIOException() throws IOException {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
	}
	
	
	/**
	 * Test Forma de pago Orden pagoa, de Genero FEMENINO
	 */
	@Test
	public void testGeneraSolicitudPdfGeneroFemenino() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		entrada.setFechaMatrimonio("20/01/2010");
		datosBanco.setFormaPago("2");
		DatosCertificables datosCert = new DatosCertificables();
		datosCert.setGenero("FEMENINO");
		datosTrabajador.setDatosCertificables(datosCert);
		datosCert.setFechaNacimiento("10/septiembre/1968");
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("CURP AGENTE");
		telefono.setTelefonoFijo("5511111111");
		telefono.setCelular("556958785421");
		particular.setCalle("CALLE");
		particular.setNoExterior("NUM 51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("5555");
		particular.setPais("ARGENTINA");
		particular.setColonia("COL. FLORES");
		particular.setEntidadFederativa("BUENOS AIRES"); 
		particular.setMunicipio("CARRRANZA");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("MARCA@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("01008740");
		datosBanco.setNumeroUnidad("1547");
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("15487REGTRHTR");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		entrada.setCurpAgenteServicio("VERFEFEW34");
		entrada.setFechaMatrimonio("30/09/2010");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		entrada.setNombreConyuge("NOM CONYUGE");
		entrada.setApellidoPaternoConyuge("PAT CONYUGE");
		entrada.setApellidoMaternoConyuge("MAT CONYUGE");
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error Expection Genero:{}",e);	
		}
	}
	
	
	/**
	 * Test Forma de pago cheques,genero Masculino
	 */
	@Test
	public void testGeneraSolicitudPdfGeneroMasculino() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		entrada.setFechaMatrimonio("10/09/2019");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datosCert = new DatosCertificables();
		datosCert.setGenero("MASCULINO");
		datosCert.setFechaNacimiento("01/diciembre/1970");
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago("3");
		datosCert.setFechaNacimiento("12/octubre/1975");
		datosTrabajador.setDatosCertificables(datosCert);
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("CURP AGENTE 2");
    	telefono.setTelefonoFijo("55012934");
		telefono.setCelular("5510101547");
		particular.setCalle("NOGALES");
		particular.setNoExterior("NUM 54");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("569898");
		particular.setPais("EDO MEXICO2");
		particular.setColonia("COL. ALAMEDAS");
		particular.setEntidadFederativa("DURANGO"); 
		particular.setMunicipio("LAGOS");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("PRUEBA3@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("700000");
		datosBanco.setNumeroUnidad("05051054");
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("FGSDFHYTJTYHGS81");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		entrada.setCurpAgenteServicio("CURP 54187");
		entrada.setFechaMatrimonio("10/09/2019");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		entrada.setNombreConyuge("XXXXXXXX  XXXXXX");
		entrada.setApellidoPaternoConyuge("XXXXXX");
		entrada.setApellidoMaternoConyuge("XXXXXXXXXX");
        File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error Expection 2:{}",e);
		}
	}
	
	/**
	 * Forma de pago Otros
	 */
	@Test
	public void testGeneraSolicitudPdfFormaPago() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		entrada.setFechaMatrimonio("10/09/2019");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datosCert = new DatosCertificables();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago("4");
		datosCert.setFechaNacimiento("20/noviembre/1980");
		datosTrabajador.setDatosCertificables(datosCert);
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("BBGT4HTS4SEFSDF");
		telefono.setTelefonoFijo("550000104");
		telefono.setCelular("5533333333");
		particular.setCalle("CALLE GERANIS");
		particular.setNoExterior("51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("44100");
		particular.setPais("CDMX");
		particular.setColonia("COL.LIMON");
		particular.setEntidadFederativa("MILPA ALTA"); 
		particular.setMunicipio("DOLORES");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("DOLORERS@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("10000");
		datosBanco.setNumeroUnidad("12345");
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("DFGDLK4LJN5K3");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		entrada.setCurpAgenteServicio("CUPRSERT45643");
		entrada.setFechaMatrimonio("10/09/2019");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		entrada.setNombreConyuge("DORIS");
		entrada.setApellidoPaternoConyuge("CAMARGO");
		entrada.setApellidoMaternoConyuge("GILES");
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error Expection Forma:{}",e);
		}
	}
	
	/**
	 *  Test Forma de Pago nulo
	 */
	@Test
	public void testGeneraSolicitudPdfFormaPagonNulo() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		entrada.setFechaMatrimonio("10/09/2019");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datosCert = new DatosCertificables();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago(null);
		datosCert.setFechaNacimiento("20/noviembre/1980");
		datosTrabajador.setDatosCertificables(datosCert);
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("XXXWEW4343");
		telefono.setTelefonoFijo("5598326510");
		telefono.setCelular("26623013");
		particular.setCalle("PRIM DE LA ESTACION");
		particular.setNoExterior("51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("98607");
		particular.setPais("MEXICO");
		particular.setColonia("COL. BELLAVISTA");
		particular.setEntidadFederativa("ZACATECAS"); 
		particular.setMunicipio("GUADALUPE");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("marcem5@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("18729844");
		datosBanco.setNumeroUnidad("0000000049");
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("002934902069187712");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		entrada.setCurpAgenteServicio("MMMMURTYRTY546");
		entrada.setFechaMatrimonio("10/09/2019");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		entrada.setNombreConyuge("SALIH KORAL");
		entrada.setApellidoPaternoConyuge("SANTORY");
		entrada.setApellidoMaternoConyuge("BROWN");
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error Expection Forma:{}",e);
		}
	}
	
	/**
	 * Test Forma de pago default
	 */
	@Test
	public void testGeneraSolicitudPdfFormaPagonDefault() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		entrada.setFechaMatrimonio("10/09/2019");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datosCert = new DatosCertificables();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago("6");
		datosCert.setFechaNacimiento("20/noviembre/1980");
		datosTrabajador.setDatosCertificables(datosCert);
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("XXXWEW4343");
		telefono.setTelefonoFijo("5598326510");
		telefono.setCelular("26623013");
		particular.setCalle("PRIM DE LA ESTACION");
		particular.setNoExterior("51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("98607");
		particular.setPais("MEXICO");
		particular.setColonia("COL. BELLAVISTA");
		particular.setEntidadFederativa("ZACATECAS"); 
		particular.setMunicipio("GUADALUPE");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("marcem5@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("18729844");
		datosBanco.setNumeroUnidad("0000000049");
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		entrada.setCurpAgenteServicio("MMMMURTYRTY546");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		entrada.setNombreConyuge("SALIH KORAL");
		entrada.setApellidoPaternoConyuge("SANTORY");
		entrada.setApellidoMaternoConyuge("BROWN");
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error Expection Forma:{}",e);
		}
	}
	
	
	
	/**
	 * Error de parseo Fecha
	 */
	@Test
	public void testGeneraSolicitudErrorFecha() {
		SolicitarCertificacionMatrimonioEntrada entrada = new SolicitarCertificacionMatrimonioEntrada();
		entrada.setFechaMatrimonio("10/09/2019");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datosCert = new DatosCertificables();
		DatosSolicitudRetiroParcialDesempleo datosBanco = new DatosSolicitudRetiroParcialDesempleo();
		datosBanco.setFormaPago("4");
		datosCert.setFechaNacimiento("15-agosto-1965");
		datosTrabajador.setDatosCertificables(datosCert);
		
		Domicilio particular =new Domicilio();
		Telefono telefono = new Telefono(); 
	    DatosExpediente expediente = new DatosExpediente();
	    expediente.setCurpAgente("FOGF850927MZSLRR02");

		telefono.setTelefonoFijo("5598326510");
		telefono.setCelular("26623013");
		particular.setCalle("PRIM DE LA ESTACION");
		particular.setNoExterior("51");
		particular.setNoInterior("S/N");
		particular.setCodigoPostal("98607");
		particular.setPais("MEXICO");
		particular.setColonia("COL. BELLAVISTA");
		particular.setEntidadFederativa("ZACATECAS"); 
		particular.setMunicipio("GUADALUPE");
		DatosComplementarios datosComple = new DatosComplementarios();
		datosComple.setCorreoElectronico("marcem5@me.com");
		datosComple.setParticular(particular);
		datosComple.setTelefonos(telefono);
		datosTrabajador.setDatosComplementarios(datosComple);
		//Forma de Pago - Transferencia Bancaria 
		datosBanco.setNumeroFolio("18729844");
		datosBanco.setNumeroUnidad("0000000049");
		
		datosBanco.setInstitucionBancaria("BANAMEX");
		datosBanco.setNumeroSucursalBancaria("9020");
		datosBanco.setClabe("002934902069187712");
		DatosCertificables certificables = new DatosCertificables();
		certificables.setGenero("MASCULINO");
		
		entrada.setCurpAgenteServicio("FOGF850927MZSLRR02");
		entrada.setFechaMatrimonio("10/09/2019");
		entrada.setFirmaEmpleado(null);
		entrada.setFirmaTrabajador(null);
		
		entrada.setNombreConyuge("SALIH KORAL");
		entrada.setApellidoPaternoConyuge("SANTORY");
		entrada.setApellidoMaternoConyuge("BROWN");
		File rutaPdf = FileUtils.getFile("src", "test", "resources","538");
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDocs",rutaPdf.getPath());
		ReflectionTestUtils.setField(solicitudRetiroParcialService, "rutaDestino",
				"/DATOS/AT/PULSSAR/EXPEDIENTE/");
		try {

		byte[]salida= solicitudRetiroParcialService.generaSolicitudPdf(entrada, datosTrabajador, datosBanco);
		assertNotNull(salida);
        }catch (Exception e) {
        	logger.error("Error:{}",e);
		}
	}
}
