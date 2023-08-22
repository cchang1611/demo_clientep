package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * caso de prueba para recepcion de archivos
 * @author JMGUTIER
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class RecepcionArchivosTestCase {
	
	/**
	 * Inyeccion de servicio recepcion de archivos
	 */
	@Autowired
	private RecepcionArchivosService servicioRecepcion;
	
	/**
	 * Test para generar zip 
	 */
	@Test
	public void testVerificarArchivos(){
		MockMultipartFile archivo1 = new MockMultipartFile("archivo02", "archivo2.txt","text/plain","archivo_02".getBytes());
		MockMultipartFile archivo2 = new MockMultipartFile("archivo03", "archivo3.txt","text/plain","archivo_03".getBytes());
		Map<String, Map<String, MultipartFile>> archivos = new HashMap<>();
		
		Map<String, MultipartFile> contenedor = new HashMap<>();
		contenedor.put("archivo1", archivo1);
		contenedor.put("archivo2", archivo2);
		
		archivos.put("archivos", contenedor);
				
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore("clave");
		datosRecepcion.setCurpEmpleado("CURPE");
		datosRecepcion.setCurpTrabajador("CURPT");
		datosRecepcion.setFolio("folio");
		datosRecepcion.setFolioIdentificacion("folio");
		datosRecepcion.setTipoArchivo("archivos");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setTipoTrabajador("tipo");
				
		List<Combo> comboObligatorios = new ArrayList<>();
		Combo combo = new Combo();
		combo.setClave("552");
		combo.setDescripcion("Pruebas");
		comboObligatorios.add(combo);
		
		try{
			//servicioRecepcion.verificarArchivos(null, archivos,datosRecepcion,comboObligatorios);
		}catch(Exception e){
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Test guardar folio complementario
	 */
	@Test
	public void testGuardarDatosFolioComplementario(){
		FolioComplemento folio = new FolioComplemento();
		
		folio.setId(1L);
		folio.setTipoTrabajador("1");
		folio.setAgentePromotor("agente");
		folio.setFechaControl(new Date());
		folio.setUsuarioModificador("agente");
		servicioRecepcion.guardarDatosFolioComplementario(folio);
	}
	
	/**
	 * Test guardar folio complementario Exception
	 */
	@Test
	public void testGuardarDatosFolioComplementarioException(){
		FolioComplemento folio = new FolioComplemento();
		folio.setId(1L);
		folio.setTipoTrabajador("1");
		folio.setAgentePromotor("Exception");
		folio.setFechaControl(new Date());
		folio.setUsuarioModificador("agente");
		servicioRecepcion.guardarDatosFolioComplementario(folio);
	}

}
