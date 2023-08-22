package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioRolRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class UsuarioRolTestCase {

	@Autowired
	private UsuarioRolRepository rol;
	
	/**
	 * prueba exito 
	 * busqueda de rol
	 */
	@Test
	public void testFindRolesById() {
		List<UsuarioRol> lista = rol.findRolesById(1L, 1);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error 
	 * busqueda de rol
	 */
	@Test
	public void testFindRolesByIdError() {
		List<UsuarioRol> lista = rol.findRolesById(null, 1);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito
	 * busqueda de rol 
	 */
	@Test
	public void testFindRolesByIdAndRol() {
		UsuarioRol lista = rol.findRolesByIdAndRol(1L, "03", 1);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * busqueda de rol 
	 */
	@Test
	public void testFindRolesByIdAndRolError() {
		UsuarioRol lista = rol.findRolesByIdAndRol(null, "03", 1);
		assertNull(lista);
	}
	
	

}
