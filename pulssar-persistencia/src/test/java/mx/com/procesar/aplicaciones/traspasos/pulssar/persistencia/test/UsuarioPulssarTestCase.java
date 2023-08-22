package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class UsuarioPulssarTestCase {

	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private UsuarioPulssarRepository usuario;
	
	/**
	 * Prueba exito 
	 * busqueda de usuario
	 */
	@Test
	public void testFindByUsuario() {
		List<UsuarioPulssar> lista = usuario.findByUsuario("0123456789");
		assertNotNull(lista);
	}
	
	/**
	 * Prueba error 
	 * busqueda de usuario
	 */
	@Test
	public void testFindByUsuarioError() {
		List<UsuarioPulssar> lista = usuario.findByUsuario(null);
		assertEquals(0, lista.size());
	}
	
	/**
	 * Prueba exito
	 * obtener usario por estatus
	 */
	@Test
	public void testFindUsuarioActivo() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		
		List<UsuarioPulssar> lista = usuario.findUsuarioActivo("0123456789", estatus);
		assertNotNull(lista);
	}
	
	/**
	 * Prueba error
	 * obtener usario por estatus
	 */
	@Test
	public void testFindUsuarioActivoError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		
		List<UsuarioPulssar> lista = usuario.findUsuarioActivo(null, estatus);
		assertEquals(0, lista.size());
	}
	
//	/**
//	 * prueba exito
//	 */
//	@Test
//	public void testFindUsuarioByUsuarioAndEstatus() {		
//		UsuarioPulssar respuesta = usuario.findUsuarioByUsuarioAndEstatus("0123456789", "01");
//		assertNotNull(respuesta);
//	}
//	
//	/**
//	 * prueba error
//	 */
//	@Test
//	public void testFindUsuarioByUsuarioAndEstatusError() {		
//		UsuarioPulssar respuesta = usuario.findUsuarioByUsuarioAndEstatus("0123456789", null);
//		assertNull(respuesta);
//	}
	
	/**
	 * prueba exito
	 * obtener por organizacion
	 */
	@Test
	public void testFindByOrganizacion() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByOrganizacion("556", estatus);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * obtener por organizacion
	 */
	@Test
	public void testFindByOrganizacionError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByOrganizacion(null, estatus);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exitosa
	 * busqueda de roles de usuario
	 */
	@Test
	public void testFindUsuariosRoles() {
		List<Object[]> lista = usuario.findUsuariosRoles("0123456789");
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * busqueda de roles de usuario
	 */
	@Test
	public void testFindUsuariosRolesError() {
		List<Object[]> lista = usuario.findUsuariosRoles(null);
		assertEquals(0, lista.size());
	}
	
	/**
	 * Prueba exito
	 * busqueda de usuario administrador
	 */
	@Test
	public void testFindUsuariosAdministradores() {
		List<UsuarioPulssar> lista = usuario.findUsuariosAdministradores("999", "01", "03", 1);
		assertNotNull(lista);
	}
	
	/**
	 * Prueba error
	 * busqueda de usuario administrador
	 */
	@Test
	public void testFindUsuariosAdministradoresError() {
		List<UsuarioPulssar> lista = usuario.findUsuariosAdministradores(null, "01", "03", 1);
		assertEquals(0, lista.size());
	}
	
	/**
	 * Prueba exito
	 * buscar usuarios con rol
	 */
	@Test
	public void testFindUsuariosConRol() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<Object[]> lista = usuario.findUsuariosConRol("556", 1, estatus);
		assertNotNull(lista);
	}
	
	/**
	 * Prueba error
	 * buscar usuarios con rol
	 */
	@Test
	public void testFindUsuariosConRolError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<Object[]> lista = usuario.findUsuariosConRol(null, 1, estatus);
		assertEquals(0, lista.size());
	}
	
	/**
	 * Prueba exito
	 * buscar usuarios sin rol
	 */
	@Test
	public void testFindUsuariosSinRol() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<Object[]> lista = usuario.findUsuariosSinRol("556", estatus);
		assertNotNull(lista);
	}
	
	/**
	 * Prueba error
	 * buscar usuarios sin rol
	 */
	@Test
	public void testFindUsuariosSinRolError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<Object[]> lista = usuario.findUsuariosSinRol(null, estatus);
		assertEquals(0, lista.size());
	}
	
//	/**
//	 * Prueba exito
//	 * buscar usuario con estatus
//	 */
//	@Test
//	public void testFindByUsuarioAndEstatus() {
//		List<String> estatus = new ArrayList<>();
//		String objeto = null;
//		objeto = "01";
//		estatus.add(objeto);
//		UsuarioPulssar lista = usuario.findByUsuarioAndEstatus("0123456789", "556", estatus);
//		assertNotNull(lista);
//	}
//	
//	/**
//	 * Prueba error
//	 * buscar usuario con estatus
//	 */
//	@Test
//	public void testFindByUsuarioAndEstatusError() {
//		List<String> estatus = new ArrayList<>();
//		String objeto = null;
//		objeto = "01";
//		estatus.add(objeto);
//		UsuarioPulssar lista = usuario.findByUsuarioAndEstatus(null, "556", estatus);
//		assertNull(lista);
//	}
	
	/**
	 * prueba exito
	 * busqueda de email exixtente
	 */
	@Test
	public void testFindByEmail() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByEmail("davidltol19@gmail.com", estatus);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * busqueda de email exixtente
	 */
	@Test
	public void testFindByEmailError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByEmail(null, estatus);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito
	 * busqueda celular exixstente
	 */
	@Test
	public void testFindByCelular() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByCelular("5586789202", estatus);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * busqueda celular exixstente
	 */
	@Test
	public void testFindByCelularError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		List<UsuarioPulssar> lista = usuario.findByCelular(null, estatus);
		assertNotNull(lista);
	}
	
	/**
	 * prueba exito
	 * obtener usuarios inactivos
	 */
	@Test
	public void testFindUsuariosInactivos() {
		List<UsuarioPulssar> lista = usuario.findUsuariosInactivos("556", "00");
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * obtener usuarios inactivos
	 */
	@Test
	public void testFindUsuariosInactivosError() {
		List<UsuarioPulssar> lista = usuario.findUsuariosInactivos(null, "00");
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito 
	 * obtener usuario por id
	 */
	@Test
	public void testFindByIdAndEstatus() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		UsuarioPulssar lista = usuario.findByIdAndEstatus(1L, estatus);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error 
	 * obtener usuario por id
	 */
	@Test
	public void testFindByIdAndEstatusError() {
		List<String> estatus = new ArrayList<>();
		String objeto = null;
		objeto = "01";
		estatus.add(objeto);
		UsuarioPulssar lista = usuario.findByIdAndEstatus(null, estatus);
		assertNull(lista);
	}
	
	
	
	
	
	
	

}
