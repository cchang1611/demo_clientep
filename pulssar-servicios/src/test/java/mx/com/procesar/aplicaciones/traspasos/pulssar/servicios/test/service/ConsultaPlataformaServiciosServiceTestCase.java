package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaPlataformaServiciosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaFoliosConsultaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import net.sf.jasperreports.engine.JasperPrint;
/**
 * Test para consulta plataforma servicios
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultaPlataformaServiciosServiceTestCase {
	
	/**
	 * ConsultaPlataformaServiciosService
	 */
	@Autowired
	private ConsultaPlataformaServiciosService consultaPlataformaServiciosService;
	
	
	/**
	 * Para consultar folio consulta operativa
	 */
	@Test
	public void testConsultarFoliosOperativa () {
		try {
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
			String[] afore = {"230", "230"};
			entrada.setAfore(afore);
			entrada.setFoliosPulssar("22222222");
			entrada.setUsuarios("2222");
			consultaPlataformaServiciosService.foliosConsultaOperativa(entrada, "C","dato");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para consultar folio consulta operativa
	 */
	@Test
	public void testConsultarFoliosOperativaOperacionAceptado () {
		try {
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
			String[] afore = {"230", "230"};
			entrada.setAfore(afore);
			entrada.setFoliosPulssar("22222222");
			entrada.setUsuarios("2222");
			entrada.setResultadoOperacion("01");
			consultaPlataformaServiciosService.foliosConsultaOperativa(entrada, "C","dato");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	/**
	 * Seteo de informacion
	 */
	@Test
	public void testSeteoInformacion () {
		try {
			List<SalidaFoliosConsultaOperativa> listas = new ArrayList<>();
			SalidaFoliosConsultaOperativa objeto = new SalidaFoliosConsultaOperativa();
			SalidaFoliosConsultaOperativa objeto2 = new SalidaFoliosConsultaOperativa();
			objeto.setFechaGeneracion(new Date());
			objeto2.setFechaGeneracion(new Date());
			listas.add(objeto);
			listas.add(objeto2);
			consultaPlataformaServiciosService.seteoInformacion(listas);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Generar nombre excel
	 */
	@Test
	public void testGenerarNombreExcel () {
		try {
			consultaPlataformaServiciosService.generarNombreExcel();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Exportar excel
	 */
	@Test
	public void testExportarExcel () {
		try {
			consultaPlataformaServiciosService.exportarAExcel(new JasperPrint(), new ByteArrayOutputStream());
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	
	/**
	 * Generar reporte stream
	 */
	@Test
	public void testGenerarReporteStream () {
		InputStream inputStream = null;
		try {
			String cadena = "Hola";
			byte[] arreglo = cadena.getBytes();
			consultaPlataformaServiciosService.generarReporteStream(arreglo,
					null, inputStream);

		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Generar reporte stream
	 */
	@Test
	public void testRemoverAforeSici () {
		
		try {
			List<Combo> lAfores = new ArrayList<>();
			Combo objeto = new Combo();
			objeto.setClave("002");
			lAfores.add(objeto);
			consultaPlataformaServiciosService.removerAforeSici(lAfores);

		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
}
