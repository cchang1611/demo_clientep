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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.MenuPaginaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarRolesMenusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarRolesMenusServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenu;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenuLista;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Tests para consultar roles menus
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ConsultarRolesMenusServiceMockTestCase {
	
	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	ConsultarRolesMenusService consultarRolesMenusService = new ConsultarRolesMenusServiceImpl();
	
	/**
	 * menuPaginaRepository;
	 */
	@Mock
	private MenuPaginaRepository menuPaginaRepository;
	
	/**
	 * validadorUtils
	 */
	@Mock
	private ValidadorUtils validadorUtils;

	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	/**
	 * test Para los menus url
	 */
	@Test
	public void testConsultarMenusIdentificadorRolUrl() {
		try {
			consultarRolesMenusService.consultarMenusIdentificadorRolUrl("12", "prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 *test Para los menus url
	 */
	@Test
	public void testConsultarMenusIdentificadorRolUrlParametrosNulos() {
		try {
			consultarRolesMenusService.consultarMenusIdentificadorRolUrl(null, null);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para los menus url
	 */
	@Test
	public void testConsultarMenusIdentificadorRolUrlValor() {
		try {
			Mockito.when(validadorUtils.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(true);
			consultarRolesMenusService.consultarMenusIdentificadorRolUrl("12", "prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para los menus url
	 */
	@Test
	public void testConsultarMenusIdentificadorRolUrlValorFalso() {
		try {
			Mockito.when(validadorUtils.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(false);
			consultarRolesMenusService.consultarMenusIdentificadorRolUrl("12", "prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para los menus url
	 */
	@Test
	public void testConsultarMenusIdentificadoresRoles() {
		try {
			DatosEntradaRolesMenu datosEntradaRolesMenu = new DatosEntradaRolesMenu();
			consultarRolesMenusService.consultarMenusIdentificadoresRoles(datosEntradaRolesMenu);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * test Para  urls
	 */
	@Test
	public void testConsultarUrl() {
		try {
			consultarRolesMenusService.consultarUrl("prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para  urls
	 */
	@Test
	public void testConsultarUrlNulos() {
		try {
			consultarRolesMenusService.consultarUrl(null);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para  urls
	 */
	@Test
	public void testConsultarUrlVerdadero() {
		try {
			Mockito.when(validadorUtils.validarObjetoNulo(ArgumentMatchers.any())).thenReturn(true);
			consultarRolesMenusService.consultarUrl("prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * test Para  urls
	 */
	@Test
	public void testConsultarUrlFalso() {
		try {
			Mockito.when(validadorUtils.validarObjetoNulo(ArgumentMatchers.any())).thenReturn(false);
			consultarRolesMenusService.consultarUrl("prueba");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * test Para los consultarMenusIdentificadoresRolesLista
	 */
	@Test
	public void testConsultarMenusIdentificadoresRolesLista() {
		try {
			DatosEntradaRolesMenuLista identificadoresRoles = new DatosEntradaRolesMenuLista();
			consultarRolesMenusService.consultarMenusIdentificadoresRolesLista(identificadoresRoles);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * test Para los consultarMenusTodasLista
	 */
	@Test
	public void testConsultarMenusTodasLista() {
		try {
			consultarRolesMenusService.consultarMenusTodasLista();
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
}
