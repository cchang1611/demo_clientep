package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Oficina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Zona;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.AforeZonaOficinaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogosInternosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CatalogosInternosServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CatalogoInternosServiceTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@InjectMocks
	private CatalogosInternosService servicioIntCatalogos = new CatalogosInternosServiceImpl();
	
	/**
	 * Repositorio afore zona
	 */
	@Mock
	private AforeZonaOficinaRepository repositorioAforeZona;
	
	/**
	 * Utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Utileria cadena
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
	 * test para obtener las zonas de una afore
	 */
	@Test
	public void testObtenerZonas() {
		List<String> zonas = new ArrayList<>();
		zonas.add("01");
				
		Mockito.when(repositorioAforeZona.findByZonasPorAfore(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(zonas);
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(ArgumentMatchers.eq(Boolean.FALSE), ArgumentMatchers.eq("ZONA"), ArgumentMatchers.eq(" "), ArgumentMatchers.eq("01"))).thenReturn("01");
		
		List<Combo> combo = servicioIntCatalogos.obtenerZonas("530");
		Assert.assertNotNull(combo);
		
		Mockito.when(repositorioAforeZona.findByZonasPorAfore(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(Arrays.asList(1)))).thenThrow(new NullPointerException("Prueba"));
		List<Combo> combo1 = servicioIntCatalogos.obtenerZonas("530");
		Assert.assertNull(combo1);
		
		Mockito.when(repositorioAforeZona.findByZonasPorAfore(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(new ArrayList<String>());
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.TRUE);
		List<Combo> combo2 = servicioIntCatalogos.obtenerZonas("530");
		Assert.assertNull(combo2);
	}
	
	/**
	 * test para obtener las zonas de una afore
	 */
	@Test
	public void testObtenerDescripcionesZonas() {
		List<Zona> zonas = new ArrayList<>();
		Zona zona = new Zona();
		zona.setIdZona(1L);
		zona.setDescripcion("OCCIDENTE");
		zonas.add(zona);
				
		Mockito.when(repositorioAforeZona.findByDescripcionZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq("01"), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(zonas);
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.FALSE);
		List<Combo> combo = servicioIntCatalogos.obtenerDescripcionesZonas("530", "01");
		Assert.assertNotNull(combo);
		
		Mockito.when(repositorioAforeZona.findByDescripcionZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq("01"), ArgumentMatchers.eq(Arrays.asList(1)))).thenThrow(new NullPointerException("Prueba"));
		List<Combo> combo1 = servicioIntCatalogos.obtenerDescripcionesZonas("530", "01");
		Assert.assertNull(combo1);
		
		Mockito.when(repositorioAforeZona.findByDescripcionZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq("01"), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(new ArrayList<Zona>());
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.TRUE);
		List<Combo> combo2 = servicioIntCatalogos.obtenerDescripcionesZonas("530", "01");
		Assert.assertNull(combo2);
	}
	
	/**
	 * test para obtener las zonas de una afore
	 */
	@Test
	public void testObtenerOficinas() {
		List<Oficina> oficinas = new ArrayList<>();
		Oficina oficina = new Oficina();
		oficina.setClave("0001");
		oficina.setDescripcion("PERLA NEGRA");
		oficinas.add(oficina);
				
		Mockito.when(repositorioAforeZona.findByOficinasPorAforeyZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(1L), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(oficinas);
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.FALSE);
		List<Combo> combo = servicioIntCatalogos.obtenerOficinas("530", 1L);
		Assert.assertNotNull(combo);
		
		Mockito.when(repositorioAforeZona.findByOficinasPorAforeyZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(1L), ArgumentMatchers.eq(Arrays.asList(1)))).thenThrow(new NullPointerException("Prueba"));
		List<Combo> combo1 = servicioIntCatalogos.obtenerOficinas("530", 1L);
		Assert.assertNull(combo1);
		
		Mockito.when(repositorioAforeZona.findByOficinasPorAforeyZona(ArgumentMatchers.eq("530"), ArgumentMatchers.eq(1L), ArgumentMatchers.eq(Arrays.asList(1)))).thenReturn(new ArrayList<Oficina>());
		Mockito.when(utileriaValidador.validarListaVacia(ArgumentMatchers.anyList())).thenReturn(Boolean.TRUE);
		List<Combo> combo2 = servicioIntCatalogos.obtenerOficinas("530", 1L);
		Assert.assertNull(combo2);
	}
}