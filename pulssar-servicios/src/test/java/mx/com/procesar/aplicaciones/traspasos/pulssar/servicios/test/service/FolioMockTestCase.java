package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.FolioServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Metodo encargado de validar las exceptiones del Folio
 * 
 * @author DBARBOSA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class FolioMockTestCase {
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private FolioService folioServicio = new FolioServiceImpl();
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private CatalogoService catalogoService = new CatalogoServiceImpl();
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion repositorio Organizacion
	 */
	@Mock
	private OrganizacionRepository repositorioOrganizacion;
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test de envio de mensaje
	 */
	@Test
	public void testGenerarFolio() {
		try {
			FolioEntrada entrada = new FolioEntrada();
			Mockito.when(utileriaValidador.validarObjetoNulo(ArgumentMatchers.anyString())).thenReturn(true);
			folioServicio.generarFolio(entrada);
		} catch(GenericException e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Test de envio de mensaje
	 */
	@Test
	public void testCerrarFolio() {
		try {
			Mockito.when(utileriaValidador.validarObjetoNulo(ArgumentMatchers.anyString())).thenReturn(true);
			FolioEntrada folio = new FolioEntrada();
			folio.setIdFolio(1L);
//			folioServicio.cerrarFolio(folio);
		} catch(GenericException e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Test de envio de mensaje
	 */
	@Test
	public void testobtenerOrganizacionesExceptiones() {
		try {
			Mockito.when(repositorioOrganizacion.findAll()).thenThrow(new RuntimeException("Obtener Organizaciones"));
			catalogoService.obtenerOrganizaciones();
		} catch(GenericException e) {
			Assert.assertNotNull(e);
		}
	}
}