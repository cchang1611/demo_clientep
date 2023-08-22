package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionRecursosImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.SolicitudDisposicionRecursosImssServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBenefDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;

/**
 *
 *Solicitud disposicion issste
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class SolicitudDisposicionRecursosImssServiceTestCase {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudDisposicionRecursosImssServiceTestCase.class);  
	
	
	/**
	 * SolicitudDisposicionRecursosImssServiceImpl
	 */
	@Autowired
	@InjectMocks
	private SolicitudDisposicionRecursosImssService solicitudDisposicionRecursosImssService = new SolicitudDisposicionRecursosImssServiceImpl();
	
	
	/**
	 * utilerias codigoUtils
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
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 */
	@Test
	public void testGeneraSolicitudPdf() throws InvalidPasswordException, IOException {
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		List<DatosBenefDispIssste> beneficiariosDatos = new ArrayList<>();
		DatosBenefDispIssste ob = new DatosBenefDispIssste();
		ob.setApellidoMaterno("prueba");
		ob.setApellidoPaterno("prueba");
		ob.setBanco("2444");
		ob.setCuentaClabe("3333");
		ob.setCurp("prueba");
		ob.setNombre("prueba");
		ob.setPorcentaje("10");
		ob.setRfc("prueba");
		beneficiariosDatos.add(ob);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setApellidoMaterno("prueba");
		entradaParams.setApellidoPaterno("prueba");
		entradaParams.setCalle("444");
		entradaParams.setCelular("4334");
		entradaParams.setClaveAforeCombo("433454");
		entradaParams.setClaveDocProbatorio("44");
		entradaParams.setClavePension("343");
		entradaParams.setClaveMov("323");
		entradaParams.setClavePension("01");
		entradaParams.setClaveRegimen("01");
		entradaParams.setClaveRetiro("01");
		entradaParams.setClaveSeguro("01");
		entradaParams.setClaveTipoPension("01");
		entradaParams.setClaveTipoPrestacion("01");
		entradaParams.setCodigoPostal("011");
		entradaParams.setCurp("rr43");
		entradaParams.setDelegacionMunicipio("rerwewr");
		entradaParams.setDescClavePension("er");
		entradaParams.setDescDocProbatorio("rr");
		entradaParams.setDescMov("ee");
		entradaParams.setDescRegimen("des");
		entradaParams.setDescRetiro("rrr");
		entradaParams.setDescripcionSolicitante("dess");
		entradaParams.setDescSeguro("eee");
		entradaParams.setDescTipoPension("rrr");
		entradaParams.setDescTipoPrestacion("dess");
		entradaParams.setBeneficiariosDatos(beneficiariosDatos);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setMontoTotalRcv("$555");
		entradaParams.setMontoTotalViv("$555");
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		RespuestaTramite disposicionTotal = new  RespuestaTramite();
		DatosTrabajador trabajador = new DatosTrabajador();
		ProcesoDerechoCargadoEntrada entradaSol = new ProcesoDerechoCargadoEntrada();
		DatosCertificables datosCertificables = new DatosCertificables();
		DatosNoCertificables datosNoCertificables = new DatosNoCertificables();
		entradaSol.setOrigenTramite("01");
		datosCertificables.setApellidoMaterno("reer");
		datosCertificables.setApellidoPaterno("rr");
		datosCertificables.setNombre("rrttr");
		datosCertificables.setCurp("rrrr");
		datosNoCertificables.setRfc("rerre");
		entradaSol.setAseguradora("530");
		trabajador.setClaveAfore("345");
		entradaSol.setCveDocProbatorio("1");
		entradaSol.setConsecutivoTrabajador("0");
		entradaSol.setCurp("CURP005217MDFRSL47");
		entradaSol.setCurpAgenteServicio("CURP005217MDFRSL47");
		entradaSol.setFcEmisionResolucion("01/03/2020");
		entradaSol.setFcInicioPension("01/03/2020");
		entradaSol.setFechaPeriodoPagoReingreso("000000");
		entradaSol.setFechaNacimiento("01/03/1970");
		entradaSol.setFechaSolicitud("01/03/2020");
		entradaSol.setIdSolcitante("01");
		entradaSol.setNumPlanPrivadoPensiones("1");
		entradaSol.setSelloUnico("00000000000000");
		entradaSol.setSemanasCotizadas(10L);
		entradaSol.setCvTipoPension("RE");
		entradaSol.setCvTipoRetiro("73");
		entradaSol.setCvTipoPrestacion("08");
		entradaSol.setCvTipoSeguro("TJ");
		entradaSol.setSecuenciaPension("48");
		entradaSol.setCvTipoRetiro("G");
		entradaSol.setCurpSolicitante("CURP005217MDFRSL47");
		trabajador.setNss("14674912879");
		entradaSol.setActuarioAutorizado("0");
		entradaSol.setApPaternoBeneficiario("Flores");
		entradaSol.setApMaternoBeneficiario("Lopez");
		entradaSol.setNombreBeneficiario("Maria");
		entradaSol.setClabePago("1226733GGGG5487000");
		entradaSol.setCurpPago("CURP005217MDFRSL47");
		entradaSol.setRfcPago("BEMF4812173H5");
		entradaSol.setGrupo("01");
		entradaSol.setFolioInfonavit("51226733GGGG54");
		entradaSol.setTipoVentanilla("5453");
		entradaSol.setMontoTotalRcv("$344");
		entradaSol.setMontoTotalViv("$34");
		entradaSol.setIdBeneficiario("1");
		entradaSol.setPorcentajeValuacion(123L);
		entradaSol.setDescTipoPension("4334");
		entradaSol.setDescTipoPrestacion("rrtt");
		entradaSol.setDescTipoRegimen("erer");
		entradaSol.setDescTipoRetiro("44343");
		entradaSol.setDescTipoSeguro("ererer");
		entradaSol.setDesDocProbatorio("eewewr");
		entradaSol.setNumeroResolucion("444");
		List<DatosBenefDispIssste> ben = new ArrayList<>();
		DatosBenefDispIssste obj = new DatosBenefDispIssste();
		DatosComplementarios obf = new DatosComplementarios();
		Telefono telefonos = new Telefono();
		telefonos.setCelular("433434");
		telefonos.setExtension("34");
		telefonos.setTelefonoFijo("4334");
		telefonos.setTelefonoLaboral("34334");
		obj.setApellidoMaterno("ere");
		obj.setApellidoPaterno("re");
		obj.setCuentaClabe("344343");
		obj.setNombre("erer");
		ben.add(obj);
		entradaSol.setBeneficiarios(ben);
		disposicionTotal.setCalle("44");
		disposicionTotal.setNumeroExterior("trr");
		disposicionTotal.setNumeroInterior("3434");
		disposicionTotal.setProcesoNocargado(entradaSol);
		disposicionTotal.setPais("re");
		disposicionTotal.setCodigoPostal("reer");
		disposicionTotal.setColonia("eerre");
		disposicionTotal.setEntidadFederativa("ereer");
		disposicionTotal.setDelegacionMunicipio("rr");
		trabajador.setDatosCertificables(datosCertificables);
		trabajador.setDatosNoCertificables(datosNoCertificables);
		obf.setTelefonos(telefonos);
		trabajador.setDatosComplementarios(obf);
		try {
			solicitudDisposicionRecursosImssService.agregarSolicitudImss(disposicionTotal, trabajador, pdfDocument);
		}catch (Exception e) {
			logger.error("Error:{}",e);
		}
	}
	
	
	/**
	 * Test que genera el Pdf
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 */
	@Test
	public void testGeneraSolicitudPdfTextosLargos() throws InvalidPasswordException, IOException {
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		List<DatosBenefDispIssste> beneficiariosDatos = new ArrayList<>();
		DatosBenefDispIssste ob = new DatosBenefDispIssste();
		ob.setApellidoMaterno("prueba");
		ob.setApellidoPaterno("prueba");
		ob.setBanco("2444");
		ob.setCuentaClabe("3333");
		ob.setCurp("prueba");
		ob.setNombre("prueba");
		ob.setPorcentaje("10");
		ob.setRfc("prueba");
		beneficiariosDatos.add(ob);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setApellidoMaterno("prueba");
		entradaParams.setApellidoPaterno("prueba");
		entradaParams.setCalle("444");
		entradaParams.setCelular("4334");
		entradaParams.setClaveAforeCombo("433454");
		entradaParams.setClaveDocProbatorio("44");
		entradaParams.setClavePension("343");
		entradaParams.setClaveMov("323");
		entradaParams.setClavePension("01");
		entradaParams.setClaveRegimen("01");
		entradaParams.setClaveRetiro("01");
		entradaParams.setClaveSeguro("01");
		entradaParams.setClaveTipoPension("01");
		entradaParams.setClaveTipoPrestacion("01");
		entradaParams.setCodigoPostal("011");
		entradaParams.setCurp("rr43");
		entradaParams.setDelegacionMunicipio("rerwewr");
		entradaParams.setDescClavePension("er");
		entradaParams.setDescDocProbatorio("rr");
		entradaParams.setDescMov("ee");
		entradaParams.setDescRegimen("des");
		entradaParams.setDescRetiro("rrr");
		entradaParams.setDescripcionSolicitante("dess");
		entradaParams.setDescSeguro("eee");
		entradaParams.setDescTipoPension("rrr");
		entradaParams.setDescTipoPrestacion("dess");
		entradaParams.setBeneficiariosDatos(beneficiariosDatos);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setMontoTotalRcv("$555");
		entradaParams.setMontoTotalViv("$555");
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		RespuestaTramite disposicionTotal = new  RespuestaTramite();
		DatosTrabajador trabajador = new DatosTrabajador();
		ProcesoDerechoCargadoEntrada entradaSol = new ProcesoDerechoCargadoEntrada();
		DatosCertificables datosCertificables = new DatosCertificables();
		entradaSol.setOrigenTramite("01");
		datosCertificables.setApellidoMaterno("reer");
		datosCertificables.setApellidoPaterno("rr");
		datosCertificables.setNombre("rrttr");
		entradaSol.setAseguradora("530");
		trabajador.setClaveAfore("345");
		entradaSol.setCveDocProbatorio("1");
		entradaSol.setConsecutivoTrabajador("0");
		entradaSol.setCurp("CURP005217MDFRSL47");
		entradaSol.setCurpAgenteServicio("CURP005217MDFRSL47");
		entradaSol.setFcEmisionResolucion("01/03/2020");
		entradaSol.setFcInicioPension("01/03/2020");
		entradaSol.setFechaPeriodoPagoReingreso("000000");
		entradaSol.setFechaNacimiento("01/03/1970");
		entradaSol.setFechaSolicitud("01/03/2020");
		entradaSol.setIdSolcitante("01");
		entradaSol.setNumPlanPrivadoPensiones("1");
		entradaSol.setSelloUnico("00000000000000");
		entradaSol.setSemanasCotizadas(10L);
		entradaSol.setCvTipoPension("RE");
		entradaSol.setCvTipoRetiro("73");
		entradaSol.setCvTipoPrestacion("08");
		entradaSol.setCvTipoSeguro("TJ");
		entradaSol.setSecuenciaPension("48");
		entradaSol.setCvTipoRetiro("G");
		entradaSol.setCurpSolicitante("CURP005217MDFRSL47");
		trabajador.setNss("14674912879");
		entradaSol.setActuarioAutorizado("0");
		entradaSol.setApPaternoBeneficiario("Flores");
		entradaSol.setApMaternoBeneficiario("Lopez");
		entradaSol.setNombreBeneficiario("Maria");
		entradaSol.setClabePago("1226733GGGG5487000");
		entradaSol.setCurpPago("CURP005217MDFRSL47");
		entradaSol.setRfcPago("BEMF4812173H5");
		entradaSol.setGrupo("01");
		entradaSol.setFolioInfonavit("51226733GGGG54");
		entradaSol.setTipoVentanilla("5453");
		entradaSol.setMontoTotalRcv("$344");
		entradaSol.setMontoTotalViv("$34");
		entradaSol.setIdBeneficiario("1");
		entradaSol.setPorcentajeValuacion(123L);
		entradaSol.setDescTipoPension("rewrwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		entradaSol.setDescTipoPrestacion("rewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		entradaSol.setDescTipoRegimen("erer");
		entradaSol.setDescTipoRetiro("44343greeeeetttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrre");
		entradaSol.setDescTipoSeguro("erererreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeg");
		entradaSol.setDesDocProbatorio("eewewrtrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		List<DatosBenefDispIssste> ben = new ArrayList<>();
		DatosBenefDispIssste obj = new DatosBenefDispIssste();
		obj.setApellidoMaterno("ere");
		obj.setApellidoPaterno("re");
		obj.setCuentaClabe("344343");
		obj.setNombre("erer");
		obj.setCurp("err");
		obj.setRfc("ere");
		obj.setPorcentaje("33");
		ben.add(obj);
		entradaSol.setBeneficiarios(ben);
		disposicionTotal.setProcesoNocargado(entradaSol);
		trabajador.setDatosCertificables(datosCertificables);
		try {
			solicitudDisposicionRecursosImssService.agregarSolicitudImss(disposicionTotal, trabajador, pdfDocument);
		}catch (Exception e) {
			logger.error("Error:{}",e);
		}
	}
	
	
	
	/**
	 * Test que genera el Pdf
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 */
	@Test
	public void testGeneraSolicitudPdfVacios() throws InvalidPasswordException, IOException {
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		RespuestaTramite disposicionTotal = new  RespuestaTramite();
		DatosTrabajador trabajador = new DatosTrabajador();
		ProcesoDerechoCargadoEntrada entradaSol = new ProcesoDerechoCargadoEntrada();
		DatosCertificables datosCertificables = new DatosCertificables();
		
		List<DatosBenefDispIssste> ben = new ArrayList<>();
		DatosBenefDispIssste obj = new DatosBenefDispIssste();
		ben.add(obj);
		entradaSol.setBeneficiarios(ben);
		entradaSol.setDescTipoPension("4334");
		entradaSol.setDescTipoPrestacion("rrtt");
		entradaSol.setDescTipoRegimen("erer");
		entradaSol.setDescTipoRetiro("44343");
		entradaSol.setDescTipoSeguro("ererer");
		entradaSol.setMontoTotalRcv("$344");
		entradaSol.setMontoTotalViv("$34");
		disposicionTotal.setProcesoNocargado(entradaSol);
		trabajador.setDatosCertificables(datosCertificables);
		try {
			solicitudDisposicionRecursosImssService.agregarSolicitudImss(disposicionTotal, trabajador, pdfDocument);
		}catch (Exception e) {
			logger.error("Error:{}",e);
		}
	}
	
	
}
