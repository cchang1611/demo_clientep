package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class RolesServiceTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private RolesService servicioRoles;

	/**
	 * Test para consultar lista de roles
	 */
	@Test
	public void testConsultarRoles() {
		List<RolesCatalogo> resultado = servicioRoles.consultarRoles();
		assertNotNull(resultado);
	}	

	/**
	 * Test para consultar lista de roles
	 */
	@Test
	public void testBuscarRoles() {
		List<RolesCatalogo> resultado = servicioRoles.buscarRoles(Arrays.asList("03"));
		assertNotNull(resultado);
	}

	/**
	 * Test para consultar lista de roles Null
	 */
	@Test
	public void testBuscarRoles_Nulo() {
		List<RolesCatalogo> resultado = servicioRoles.buscarRoles(Arrays.asList("15"));
		assertNull(resultado);
	}

	/**
	 * Test para buscar roles por lista y clave afore
	 */
	@Test
	public void testBuscarRolesPorAfore() {
		List<RolesCatalogo> resultado = servicioRoles.buscarRolesPorAfore(Arrays.asList("03"), "552");
		assertNotNull(resultado);
	}

	/**
	 * Test Nulo para buscar roles por lista y clave afore
	 */
	@Test
	public void testBuscarRolesPorAfore_Nulo() {
		List<RolesCatalogo> resultado = servicioRoles.buscarRolesPorAfore(Arrays.asList("15"), "552");
		assertNull(resultado);
	}

	/**
	 * Test para buscar rol por afore
	 */
	@Test
	public void testBuscarRolPorAfore() {
		List<RolesCatalogo> resultado = servicioRoles.buscarRolPorAfore("552");
		assertNotNull(resultado);
	}

	/**
	 * Test para buscar rol por clave rol y clave afore
	 */
	@Test
	public void testBuscarRolPorRolClaveAfore() {
		RolesCatalogo resultado = servicioRoles.buscarRolPorRolClaveAfore("03","552");
		assertNotNull(resultado);
	}

	/**
	 * Test Nulo para buscar rol por clave rol y clave afore
	 */
	@Test
	public void testBuscarRolPorRolClaveAfore_Nulo() {
		RolesCatalogo resultado = servicioRoles.buscarRolPorRolClaveAfore("15","552");
		assertNull(resultado);
	}

	/**
	 * Test para buscar rol por clave rol y clave afore
	 */
	@Test
	public void testObtenerRolPorRolClaveAfore() {
		Rol resultado = servicioRoles.obtenerRolPorRolClaveAfore("03","552");
		assertNotNull(resultado);
	}

	/**
	 * Test Nulo para buscar rol por clave rol y clave afore
	 */
	@Test
	public void testObtenerRolPorRolClaveAfore_Nulo() {
		Rol resultado = servicioRoles.obtenerRolPorRolClaveAfore("15","552");
		assertNull(resultado);
	}
}
