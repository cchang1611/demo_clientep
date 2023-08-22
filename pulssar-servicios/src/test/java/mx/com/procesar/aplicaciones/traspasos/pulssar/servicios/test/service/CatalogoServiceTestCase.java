package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CatalogoServiceTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * catalogoMock
	 */
	@InjectMocks
	private CatalogoService catalogoMock = new CatalogoServiceImpl();
	
	
	/**
	 * restServiceClientUtils
	 */
	@Mock
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * Cliente
	 */
	@Mock
	private RestTemplate servicioCliente;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(catalogoMock,"uriComunes","http://lbint-devl.procesar.net/comunesPulssar/");
		
	}
	
	/**
	 * Para obtener las afores
	 */
	@Test
	public void testObtenerAforesOk () {
		try {
			servicioCatalogo.obtenerAfores();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener las afores vacio
	 */
	@Test
	public void testObtenerAforesVacio () {
		try {
			servicioCatalogo.obtenerAfores();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener las afores exception
	 */
	@Test
	public void testObtenerAfores () {
		try {
			servicioCatalogo.obtenerAfores();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener parametro
	 */
	@Test
	public void testObtenerParametroVacio() {
		try {
			servicioCatalogo.obtenerParametro("57894", null);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener parametro exception
	 */
	@Test
	public void testObtenerParametroException() {
		try {
			servicioCatalogo.obtenerParametro("57895", "S01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener parametro exception
	 */
	@Test
	public void testObtenerOrganizaciones() {
		try {
			servicioCatalogo.obtenerOrganizaciones();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para obtener icefa exception
	 */
	@Test
	public void testObtenerIcefaException() {
		try {
			servicioCatalogo.obtenerIcefa("65");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para obtener icefa vacio
	 */
	@Test
	public void testObtenerIcefaVacio() {
		try {
			servicioCatalogo.obtenerIcefa("5");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener TipoSolicitante
	 */
	@Test
	public void testObtenerTipoSolicitante () {
		try {
			servicioCatalogo.obtenerTipoSolicitante("02,03,04");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para obtener TipoSolicitante error
	 */
	@Test
	public void testObtenerTipoSolicitanteError () {
		try {
			servicioCatalogo.obtenerTipoSolicitante("");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener TipoSolicitante
	 */
	@Test
	public void testObtenerTipoSolicitanteRespuesException() {
		try {
			servicioCatalogo.obtenerTipoSolicitante("02");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener TipoSolicitante
	 */
	@Test
	public void testObtenerTipoSolicitanteRespuestaNull() {
		try {
			servicioCatalogo.obtenerTipoSolicitante("03");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener ObtenerTipoDocumento exito
	 */
	@Test
	public void testObtenerTipoDocumento() {
		try {
			servicioCatalogo.obtenerTipoDocumento("01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener ObtenerTipoDocumento Null
	 */
	@Test
	public void testObtenerTipoDocumentoNull() {
		try {
			servicioCatalogo.obtenerTipoDocumento("02");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para obtener ObtenerTipoDocumento Exception
	 */
	@Test
	public void testObtenerTipoDocumentoException() {
		try {
			servicioCatalogo.obtenerTipoDocumento("03");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta catalogo genero
	 */
	@Test
	public void testObtenerCatalogoGenero() {
		try {
			servicioCatalogo.obtenerCatalogoGenero();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta catalogo Entidad Federativa
	 */
	@Test
	public void testObtenerCatalogoEntidadFederativa() {
		try {
			servicioCatalogo.obtenerCatalogoEntidadFederativa();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}

	/**
	 * testConsultaValorParametro
	 */
	@Test
	public void testConsultaValorParametro() {
		Mockito.when(restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(), 
				Mockito.anyString(), Mockito.eq(String.class))).thenReturn("ok");
		String consultaValorParametro=catalogoMock.consultaValorParametro("TSKKS", "01");
		Assert.assertNotNull(consultaValorParametro);
	}
	
	/**
	 * testConsultaValorParametroNull
	 */
	@Test
	public void testConsultaValorParametroNull() {
		try {
			Mockito.when(restServiceClientUtils.ejecutarServicioGet(Mockito.anyString(), 
					Mockito.anyString(), Mockito.eq(String.class))).thenThrow(NullPointerException.class);
			catalogoMock.consultaValorParametro("TSKKS", "01");
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * testObtenerEntidadFederativaComunes
	 */
	@Test
	public void testObtenerEntidadFederativaComunes() {
		Mockito.when(servicioCliente.getForObject(Mockito.anyString(), 
				Mockito.eq(EntidadFederativa.class))).thenReturn(salida());
		EntidadFederativa consultaValorParametro=catalogoMock.obtenerEntidadFederativaComunes("TSKKS");
		Assert.assertNotNull(consultaValorParametro);
	}

	/**
	 * testObtenerEntidadFederativaComunesNull
	 */
	@Test
	public void testObtenerEntidadFederativaComunesNull() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), 
					Mockito.eq(EntidadFederativa.class))).thenThrow(NullPointerException.class);
			catalogoMock.obtenerEntidadFederativaComunes("TSKKS");
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * salida
	 * @return
	 */
	private EntidadFederativa salida() {
		EntidadFederativa entidadFederativa = new EntidadFederativa();
		entidadFederativa.setChCvEntidadFederativa("jksjks");
		return entidadFederativa;
	}
	

}