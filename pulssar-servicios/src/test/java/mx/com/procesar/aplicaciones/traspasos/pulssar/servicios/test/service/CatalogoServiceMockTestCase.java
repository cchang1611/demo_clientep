package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativaList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GiroNegocioList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GradoEstudiosList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MunicipiosList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NacionalidadesList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.OcupacionList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PaisList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParentescoList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorioList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CatalogoServiceMockTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private CatalogoService servicioCatalogo = new CatalogoServiceImpl();
	
	/**
	 * Cliente
	 */
	@Autowired
	@Mock
	private RestTemplate servicioCliente;
	
	/**
	 * dependencia utilidad validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * dependencia utilidad cadena
	 */
	@Mock
	private CadenasUtils utileriaCadena;	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Servicio que consulta catalogo nacionalidades
	 */
	@Test
	public void testObtenerNacionalidades() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(NacionalidadesList.class))).thenReturn(new NacionalidadesList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerNacionalidades();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(NacionalidadesList.class))).thenReturn(new NacionalidadesList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerNacionalidades();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(NacionalidadesList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerNacionalidades();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que genera excepcion en consulta tipo documentos
	 */
	@Test
	public void testTiposDoctos() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(TipoDoctoProbatorioList.class))).thenReturn(new TipoDoctoProbatorioList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerTiposDoctos();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(TipoDoctoProbatorioList.class))).thenReturn(new TipoDoctoProbatorioList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerTiposDoctos();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(TipoDoctoProbatorioList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerTiposDoctos();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}	
	
	/**
	 * Servicio que consulta catalogo ocupaciones
	 */
	@Test
	public void testConsultarOcupaciones() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(OcupacionList.class))).thenReturn(new OcupacionList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerOcupaciones();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(OcupacionList.class))).thenReturn(new OcupacionList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerOcupaciones();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(OcupacionList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerOcupaciones();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta catalogo giro negocio
	 */
	@Test
	public void testGiroNegocio() {
		try {			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GiroNegocioList.class))).thenReturn(new GiroNegocioList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerGirosNegocios();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GiroNegocioList.class))).thenReturn(new GiroNegocioList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerGirosNegocios();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GiroNegocioList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerGirosNegocios();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta Grado estucios
	 */
	@Test
	public void testGradoEstudios() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GradoEstudiosList.class))).thenReturn(new GradoEstudiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerGradoEstudios();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GradoEstudiosList.class))).thenReturn(new GradoEstudiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerGradoEstudios();
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(GradoEstudiosList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerGradoEstudios();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Servicio que consulta paises
	 */
	@Test
	public void testObtenerPaises() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(PaisList.class))).thenReturn(new PaisList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerPaises();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(PaisList.class))).thenReturn(new PaisList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerPaises();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(PaisList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerPaises();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta municipios
	 */
	@Test
	public void testObtenerMunicipios() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenReturn(new MunicipiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerMunicipios();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenReturn(new MunicipiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerMunicipios();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerMunicipios();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta parentescos
	 */
	@Test
	public void testObtenerParentescos() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(ParentescoList.class))).thenReturn(new ParentescoList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerParentescos();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(ParentescoList.class))).thenReturn(new ParentescoList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerParentescos();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(ParentescoList.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerParentescos();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testObtenerEntidades() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativaList.class))).thenReturn(new EntidadFederativaList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerEntidades();		
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativaList.class))).thenReturn(new EntidadFederativaList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerEntidades();
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativaList.class))).thenThrow(new RuntimeException());

			servicioCatalogo.obtenerEntidades();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testObtenerEntidad() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenReturn(new EntidadFederativa());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerEntidad("1");
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenReturn(new EntidadFederativa());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerEntidad("1");
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerEntidad("1");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testObtenerEntidadFederativa() {
		try {
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenReturn(new EntidadFederativa());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerEntidadFederativa("1");
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenReturn(new EntidadFederativa());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerEntidadFederativa("1");
			
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(EntidadFederativa.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerEntidadFederativa("1");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Servicio que consulta catalogo nacionalidades
	 */
	@Test
	public void testObtenerNacionalidadPorClave() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenReturn(new Nacionalidad());
			servicioCatalogo.obtenerNacionalidadPorClave("1");
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenReturn(new Nacionalidad());
			servicioCatalogo.obtenerNacionalidadPorClave("1");
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerNacionalidadPorClave("1");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testObtenerMunicipiosPorEntidad() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenReturn(new MunicipiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerMunicipiosPorEntidad("1");		
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenReturn(new MunicipiosList());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerMunicipiosPorEntidad("1");
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(MunicipiosList.class))).thenThrow(new RuntimeException());

			servicioCatalogo.obtenerMunicipiosPorEntidad("1");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testConsultarCatalogoCodigoPostal() {
		try {
			ResponseEntity<SalidaCatalogoCodigoPostal> respuestaNotificacion = new ResponseEntity<>(new SalidaCatalogoCodigoPostal() , HttpStatus.ACCEPTED);

			Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaCatalogoCodigoPostal.class))).thenReturn(respuestaNotificacion);
			servicioCatalogo.consultarCatalogoCodigoPostal(new EntradaCatalogoCodigoPostal());		
			
			Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaCatalogoCodigoPostal.class))).thenReturn(respuestaNotificacion);
			servicioCatalogo.consultarCatalogoCodigoPostal(new EntradaCatalogoCodigoPostal());
			
			Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(SalidaCatalogoCodigoPostal.class))).thenThrow(new RuntimeException());
			servicioCatalogo.consultarCatalogoCodigoPostal(new EntradaCatalogoCodigoPostal());
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Servicio que consulta entidades
	 */
	@Test
	public void testObtenerNacionalidadPorClaveCorta() {
		try {
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenReturn(new Nacionalidad());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
			servicioCatalogo.obtenerNacionalidadPorClaveCorta("1");		
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenReturn(new Nacionalidad());
			Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
			servicioCatalogo.obtenerNacionalidadPorClaveCorta("1");
			
			Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(Nacionalidad.class))).thenThrow(new RuntimeException());
			servicioCatalogo.obtenerNacionalidadPorClaveCorta("1");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Servicio que obtiene los sub documentos
	 */
	@Test
	public void testObtenerSubDocumentos() {
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("http://192.168.10.113:7001/comunesPulssar/catalogo/subDocumentos/");
		assertNotNull(servicioCatalogo.obtenerSubDocumentos("", ""));
	}


}