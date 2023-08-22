package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaPlataformaServiciosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultaPlataformaServiciosServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test mock consulta plataforma servicios
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultaPlataformaServiciosServiceMockTestCase {
	
	
	/**
	 * Inyeccion de servicio
	 */
	@InjectMocks
	private ConsultaPlataformaServiciosService consultaPlataformaServiciosService = new ConsultaPlataformaServiciosServiceImpl();
	
	
	/**
	 * dependencia clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	/**
	 * uriConsultaFoliosOperativa
	 */
	@Value("${comunes.folios.consultaOperativa}")
	private String uriConsultaFoliosOperativa;
	
	
	
	/**
	 * Inyeccion de utileria
	 */
	@Mock
	private CatalogoService servicioCatalogo;

	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(consultaPlataformaServiciosService,"uriConsultaFoliosOperativa","http://lbint-devl.procesar.net/comunesPulssar/foliosConsulta/operativa");
	
	}
	
	/**
	 * Para consultar folio consulta operativa
	 */
	@Test
	public void testConsultarFoliosOperativa () {
		try {
			Parametro objeto = new Parametro();
			List<Parametro> lparametro = new ArrayList<>();
			objeto.setChParametro("22");
			objeto.setChValorParametro("22");
			lparametro.add(objeto);
			String[] afore = {"230", "230"};
			
			Mockito.when(
					servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(lparametro);
			String lista = "[{\"claveOrganizacion\": \"530\",\"fechaGeneracion\": 1609740000000,\"claveServicio\": \"C\",\"total\": 3}]";
			ResponseEntity<String> respuesta = new ResponseEntity<>(lista , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
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
	public void testConsultarFoliosOperativaResultadoOperacionCero () {
		try {
			Parametro objeto = new Parametro();
			List<Parametro> lparametro = new ArrayList<>();
			objeto.setChParametro("22");
			objeto.setChValorParametro("22");
			lparametro.add(objeto);
			String[] afore = {"230", "230"};
			
			Mockito.when(
					servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(lparametro);
			String lista = "[{\"claveOrganizacion\": \"530\",\"fechaGeneracion\": 1609740000000,\"claveServicio\": \"C\",\"total\": 3}]";
			ResponseEntity<String> respuesta = new ResponseEntity<>(lista , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
			entrada.setAfore(afore);
			entrada.setFoliosPulssar("22222222");
			entrada.setUsuarios("2222");
			entrada.setResultadoOperacion("0");
			consultaPlataformaServiciosService.foliosConsultaOperativa(entrada, "C","dato");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para consultar folio consulta operativa
	 */
	@Test
	public void testConsultarFoliosOperativaDiagnostico () {
		try {
			Parametro objeto = new Parametro();
			List<Parametro> lparametro = new ArrayList<>();
			objeto.setChParametro("22");
			objeto.setChValorParametro("22");
			lparametro.add(objeto);
			String[] afore = {"230", "230"};
			
			Mockito.when(
					servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(lparametro);
			String lista = "[{\"claveOrganizacion\": \"530\",\"fechaGeneracion\": 1609740000000,\"claveServicio\": \"C\",\"total\": 3, \"claveAgente\": \"404\", \"chFolio\": \"404\", \"resultadoOperacion\": \"404\", \"diagnostico\": \"404\"}]";
			ResponseEntity<String> respuesta = new ResponseEntity<>(lista , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenReturn(respuesta);
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
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
	 * Para consultar folio consulta operativa
	 */
	@Test
	public void testConsultarFoliosOperativaExcepcion () {
		try {
			Parametro objeto = new Parametro();
			List<Parametro> lparametro = new ArrayList<>();
			objeto.setChParametro("22");
			objeto.setChValorParametro("22");
			lparametro.add(objeto);
			String[] afore = {"230", "230"};
			
			Mockito.when(
					servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(lparametro);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class)))
					.thenThrow(new NullPointerException());
			EntradaPlataformaServicios entrada = new EntradaPlataformaServicios();
			entrada.setAfore(afore);
			entrada.setFoliosPulssar("22222222");
			entrada.setUsuarios("2222");
			entrada.setResultadoOperacion("01");
			consultaPlataformaServiciosService.foliosConsultaOperativa(entrada, "C","dato");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
}
