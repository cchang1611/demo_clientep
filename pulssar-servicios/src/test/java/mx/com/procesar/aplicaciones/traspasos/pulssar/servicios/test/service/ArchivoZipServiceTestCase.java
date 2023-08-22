package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ArchivoZipServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivosDescargados;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;


/**
 * ArchivoZipServiceTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ArchivoZipServiceTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ArchivoZipService archivoZipService =new ArchivoZipServiceImpl();

	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	/**
	 * testLlenarDatosZip
	 * @throws FileNotFoundException
	 */
	@Test
	public void testLlenarDatosZip() throws FileNotFoundException {
		InputStream input= new FileInputStream("src\\test\\resources\\538\\5302015120902010000015672.zip");
		List<DatosArchivosDescargados> lista=archivoZipService.llenarDatosZip(input);
		Assert.assertNotNull(lista);
	}
	
	/**
	 * testLlenarDatosZipNull
	 */
	@Test
	public void testLlenarDatosZipNull()  {
		try {
			archivoZipService.llenarDatosZip(null);	
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
		
		
	}
	
	/**
	 * testAbrirObjecto
	 */
	@Test
	public void testAbrirObjecto() {
		 ZipInputStream zipInputStream=archivoZipService.abrirObjecto("src\\test\\resources\\538\\5302015120902010000015672.zip");	
		 Assert.assertNotNull(zipInputStream);			
	}
	
	/**
	 * testAbrirObjectoNull
	 */
	@Test
	public void testAbrirObjectoNull(){
	    try {
	    	archivoZipService.abrirObjecto("test\\resources\\538\\5302015120902010000015672.zip");
	    }catch(Exception e){
	    	Assert.assertNotNull(e);
	    }
		
	}
	
	/**
	 * testListar
	 * @throws IOException
	 */
	@Test
	public void testListar() throws IOException {
		InputStream input= new FileInputStream("src\\test\\resources\\538\\5302015120902010000015672.zip");
		ZipInputStream zipInputStream = new ZipInputStream(input);
		List<DatosArchivos> listar=archivoZipService.listar(zipInputStream);	
		Assert.assertNotNull(listar);			
	}
	
	/**
	 * testPdf
	 */
	@Test
	public void testPdf() {
		byte [] pdfCadena="JVBERi0xLjcNCiW1tbW1DQoxID".getBytes();
		ByteArrayOutputStream pdf=archivoZipService.pdf(pdfCadena);	
		Assert.assertNotNull(pdf);			
	}
	
	/**
	 * testPdfNull
	 */
	@Test
	public void testPdfNull() {
	    try {
	    	archivoZipService.pdf(null);	
	    }catch(Exception e){
	    	Assert.assertNotNull(e);
	    }			
	}
	
	/**
	 * testObtenerPdfPermanencia
	 * @throws IOException
	 */
	@Test
	public void testObtenerPdfPermanencia() throws IOException {
		PDDocument pdDoc= new PDDocument();
		byte [] pdf=archivoZipService.obtenerPdfPermanencia(pdDoc);	
		Assert.assertNotNull(pdf);
	}
	
}
