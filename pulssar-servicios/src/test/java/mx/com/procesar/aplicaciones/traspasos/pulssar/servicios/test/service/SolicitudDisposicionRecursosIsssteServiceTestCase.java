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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionRecursosIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.SolicitudDisposicionRecursosIsssteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBenefDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
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
public class SolicitudDisposicionRecursosIsssteServiceTestCase {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudDisposicionRecursosIsssteServiceTestCase.class);  
	
	
	/**
	 * SolicitudDisposicionRecursosIsssteService
	 */
	@Autowired
	@InjectMocks
	private SolicitudDisposicionRecursosIsssteService solicitudDisposicionRecursosIsssteService = new SolicitudDisposicionRecursosIsssteServiceImpl();
	
	
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
		try {
      	solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument);
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
	public void testGeneraSolicitudPdfError() throws InvalidPasswordException, IOException {
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
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		String path="src/test/resources/530/banorte.pdf";
		entradaParams.setActuario("rrrt");
		PDDocument pdfDocument = PDDocument.load(new File(path));
		try {
			solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument); 
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
	public void testGeneraSolicitudPdfDescLargos() throws InvalidPasswordException, IOException {
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
		entradaParams.setNumeroSemanasCotizadas("4343");
		entradaParams.setFechaInicioPension("ggerg");
		entradaParams.setFechaEmisionPension("tttg");
		entradaParams.setClavePension("gtgtg");
		entradaParams.setNumeroResolucion("rrtt");
		entradaParams.setNumeroIssste("rete");
		entradaParams.setSecuenciaPension("rrr");
		entradaParams.setColonia("rtrr");
		entradaParams.setPais("rrt");
		entradaParams.setEntidadFederativa("rr");
		entradaParams.setTelefonoLaboral("rtgtggt");
		entradaParams.setExtension("rrr");
		entradaParams.setTelefono("rrere");
		entradaParams.setFechaNacimiento("01/03/2021");
		entradaParams.setNombre("334");
		entradaParams.setRfc("rgegete");
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
		entradaParams.setClaveRegimenPlan("01");
		entradaParams.setClaveRetiro("01");
		entradaParams.setClaveSeguro("01");
		entradaParams.setClaveTipoPension("01");
		entradaParams.setClaveTipoPrestacion("01");
		entradaParams.setCodigoPostal("011");
		entradaParams.setCurp("rr43");
		entradaParams.setDelegacionMunicipio("rerwewr");
		entradaParams.setDescClavePension("er");
		entradaParams.setDescDocProbatorio("rrrtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttte");
		entradaParams.setDescMov("ee");
		entradaParams.setDescRegimen("desytttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescRetiro("rrrrtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescripcionSolicitante("dess");
		entradaParams.setDescSeguro("eeerttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescTipoPension("rrrreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeet");
		entradaParams.setDescTipoPrestacion("dessrtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttterte");
		entradaParams.setBeneficiariosDatos(beneficiariosDatos);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setMontoTotalRcv("$555");
		entradaParams.setMontoTotalViv("$555");
		entradaParams.setNumeroExterior("erer");
		entradaParams.setNumeroInterior("rre");
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		entradaParams.setNss("rerer");
		entradaParams.setNumeroPlanPensiones("rrgeg");
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		try {
      	solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument);
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
	public void testGeneraSolicitudPdfDescMEnosLArgos() throws InvalidPasswordException, IOException {
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
		entradaParams.setNumeroSemanasCotizadas("4343");
		entradaParams.setFechaInicioPension("ggerg");
		entradaParams.setFechaEmisionPension("tttg");
		entradaParams.setClavePension("gtgtg");
		entradaParams.setNumeroResolucion("rrtt");
		entradaParams.setNumeroIssste("rete");
		entradaParams.setSecuenciaPension("rrr");
		entradaParams.setColonia("rtrr");
		entradaParams.setPais("rrt");
		entradaParams.setEntidadFederativa("rr");
		entradaParams.setTelefonoLaboral("rtgtggt");
		entradaParams.setExtension("rrr");
		entradaParams.setTelefono("rrere");
		entradaParams.setFechaNacimiento("01/03/2021");
		entradaParams.setNombre("334");
		entradaParams.setRfc("rgegete");
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
		entradaParams.setClaveRegimenPlan("01");
		entradaParams.setClaveRetiro("01");
		entradaParams.setClaveSeguro("01");
		entradaParams.setClaveTipoPension("01");
		entradaParams.setClaveTipoPrestacion("01");
		entradaParams.setCodigoPostal("011");
		entradaParams.setCurp("rr43");
		entradaParams.setDelegacionMunicipio("rerwewr");
		entradaParams.setDescClavePension("er");
		entradaParams.setDescDocProbatorio("rrrtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttte");
		entradaParams.setDescMov("ee");
		entradaParams.setDescRegimen("desytttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescRetiro("rrrrttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescripcionSolicitante("dess");
		entradaParams.setDescSeguro("eeertttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescTipoPension("rrrreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeet");
		entradaParams.setDescTipoPrestacion("dessrttttttttttttttttt");
		entradaParams.setBeneficiariosDatos(beneficiariosDatos);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setMontoTotalRcv("$555");
		entradaParams.setMontoTotalViv("$555");
		entradaParams.setNumeroExterior("erer");
		entradaParams.setNumeroInterior("rre");
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		entradaParams.setNss("rerer");
		entradaParams.setActuario("rrrt");
		entradaParams.setNumeroPlanPensiones("rrgeg");
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		try {
      	solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument);
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
	public void testGeneraSolicitudPdfDescMEnosLArgosD() throws InvalidPasswordException, IOException {
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
		entradaParams.setNumeroSemanasCotizadas("4343");
		entradaParams.setFechaInicioPension("ggerg");
		entradaParams.setFechaEmisionPension("tttg");
		entradaParams.setClavePension("gtgtg");
		entradaParams.setNumeroResolucion("rrtt");
		entradaParams.setNumeroIssste("rete");
		entradaParams.setSecuenciaPension("rrr");
		entradaParams.setColonia("rtrr");
		entradaParams.setPais("rrt");
		entradaParams.setEntidadFederativa("rr");
		entradaParams.setTelefonoLaboral("rtgtggt");
		entradaParams.setExtension("rrr");
		entradaParams.setTelefono("rrere");
		entradaParams.setFechaNacimiento("01/03/2021");
		entradaParams.setNombre("334");
		entradaParams.setRfc("rgegete");
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
		entradaParams.setClaveRegimenPlan("01");
		entradaParams.setClaveRetiro("01");
		entradaParams.setClaveSeguro("01");
		entradaParams.setClaveTipoPension("01");
		entradaParams.setClaveTipoPrestacion("01");
		entradaParams.setCodigoPostal("011");
		entradaParams.setCurp("rr43");
		entradaParams.setDelegacionMunicipio("rerwewr");
		entradaParams.setDescClavePension("er");
		entradaParams.setDescDocProbatorio("rrrtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttte");
		entradaParams.setDescMov("ee");
		entradaParams.setDescRegimen("desytttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescRetiro("rrrrttttttttttttttttttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescripcionSolicitante("dess");
		entradaParams.setDescSeguro("eeertttttttttttttttttttttttttttttttttttt");
		entradaParams.setDescTipoPension("INCAPACIDAD PERMANENTE");
		entradaParams.setDescTipoPrestacion("dessrttttttttttttttttt");
		entradaParams.setBeneficiariosDatos(beneficiariosDatos);
		entradaParams.setAforeTrabajador("530");
		entradaParams.setMontoTotalRcv("$555");
		entradaParams.setMontoTotalViv("$555");
		entradaParams.setNumeroExterior("erer");
		entradaParams.setNumeroInterior("rre");
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		entradaParams.setNss("rerer");
		entradaParams.setActuario("rrrt");
		entradaParams.setNumeroPlanPensiones("rrgeg");
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		try {
      	solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument);
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
	public void testGeneraSolicitudCamposVacios() throws InvalidPasswordException, IOException {
		DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
		List<DatosBenefDispIssste> beneficiariosDatos = new ArrayList<>();
		DatosBenefDispIssste ob = new DatosBenefDispIssste();
		beneficiariosDatos.add(ob);
		entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
		String path="src/test/resources/530/banorte.pdf";
		PDDocument pdfDocument = PDDocument.load(new File(path));
		try {
      	solicitudDisposicionRecursosIsssteService.agregarSolicitudIssste(entradaParams, pdfDocument);
		}catch (Exception e) {
			logger.error("Error:{}",e);
		}
	}
}
