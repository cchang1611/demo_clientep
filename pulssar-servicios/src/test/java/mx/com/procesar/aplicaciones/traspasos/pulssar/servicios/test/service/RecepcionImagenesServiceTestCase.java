package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionImagenesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RecepcionImagenesServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test case para servicios de rececpion de imagenes
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class RecepcionImagenesServiceTestCase {

	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private RecepcionImagenesService recepcionImagenes = new RecepcionImagenesServiceImpl();
	
	/**
	 * Inyeccion servicio de catalogos
	 */
	@Mock
	private CatalogoService catalogoService;

	/**
	 * Inyeccion de servicio
	 */
	@Mock
	private CadenasUtils utileriaCadena;

	/**
	 * dependencia utilidad validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;

	/**
	 * Inyeccion de utileria LectorArchivoUtils
	 */
	@Mock
	private LectorArchivoUtils lectorArchivoUtils;
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	@Mock
	private RestTemplate servicioCliente;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test para servicio consultar recepcion imagenes
	 */
	@Test
	public void testConsultarRecepcionImagenes() {
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("url");
		Mockito.when(servicioCliente.getForObject(Mockito.anyString(), Mockito.eq(RecepcionImagenes.class))).thenReturn(new RecepcionImagenes());
		recepcionImagenes.consultarRecepcionImagenes("folio", "clave", "estatus");	
	}
	
	/**
	 * Test para servicio obtener documentos
	 * @throws IOException
	 */
	@Test
	public void testObtenerDocumentos() throws IOException {
		DetalleRecepcionImagenes recepcion1 = new DetalleRecepcionImagenes();
		recepcion1.setTipoImagen(1);
		recepcion1.setRuta("ruta");
		recepcion1.setMascara("texto.pdf");
		DetalleRecepcionImagenes recepcion2 = new DetalleRecepcionImagenes();
		recepcion2.setTipoImagen(1);
		recepcion2.setRuta("ruta");
		recepcion2.setMascara("texto.pdf");


		List<DetalleRecepcionImagenes> listaRecepcion = new ArrayList<>();
		listaRecepcion.add(recepcion1);
		listaRecepcion.add(recepcion2);
		RecepcionImagenes imagenRecibida = new RecepcionImagenes();
		imagenRecibida.setDetalleRecepcionImagen(listaRecepcion);
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("18");
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		try {
			Mockito.when(catalogoService.obtenerParametroDdbpose(Mockito.anyString(),Mockito.anyString())).thenReturn(listaParametro);
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
			Mockito.when(lectorArchivoUtils.obtenerContenidoArchivo(Mockito.anyString())).thenReturn("contenido");
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("contenido");
			Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
			recepcionImagenes.obtenerDocumentos(imagenRecibida, "556");
			
			recepcion1.setTipoDocumentoDigital("18");
			Mockito.when(catalogoService.obtenerParametroDdbpose(Mockito.anyString(),Mockito.anyString())).thenReturn(listaParametro);
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
			Mockito.when(lectorArchivoUtils.obtenerContenidoArchivo(Mockito.anyString())).thenReturn(" ");
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
			Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE);
			recepcionImagenes.obtenerDocumentos(imagenRecibida, "556");
			
			Mockito.when(catalogoService.obtenerParametroDdbpose(Mockito.anyString(),Mockito.anyString())).thenReturn(listaParametro);
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
			Mockito.when(lectorArchivoUtils.obtenerContenidoArchivo(Mockito.anyString())).thenThrow(new IOException());
			Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
			Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE);
			recepcionImagenes.obtenerDocumentos(imagenRecibida, "556");
		}catch (BusinessException e) {
			assertNotNull(e);
		}catch (GenericException ex) {
			assertNotNull(ex);
		}
	}
	/**
	 * Test de excepcion obtener documentos
	 * @throws IOException
	 */
	@Test(expected=GenericException.class)
	public void testObtenerDocumentosException() throws IOException {
		RecepcionImagenes imagenRecibida = new RecepcionImagenes();
		imagenRecibida.setClaveTipoProceso("01");
		Mockito.when(catalogoService.obtenerParametroDdbpose(Mockito.anyString(),Mockito.anyString())).thenThrow(new RuntimeException());
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
		Mockito.when(lectorArchivoUtils.obtenerContenidoArchivo(Mockito.anyString())).thenReturn("contenido");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("contenido");
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE);
		recepcionImagenes.obtenerDocumentos(imagenRecibida, "556");
	}

}
