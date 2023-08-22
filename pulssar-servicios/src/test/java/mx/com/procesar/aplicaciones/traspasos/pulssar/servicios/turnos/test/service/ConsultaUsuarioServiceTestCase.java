package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.ConsultaUsuarioService;

/**
 * Clase de prueba que permite realizar las operaciones de consulta sobre
 * <b>Usuarios</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class ConsultaUsuarioServiceTestCase extends BaseTestCase {

	/**
	 * Servicio a probar.
	 */
	@Autowired
	private ConsultaUsuarioService consultaUsuarioService;
	
	/**
	 * Permite probar el happy path para la cosolta de usuario a trav�s de la
	 * clave de la Organiaci�n y el usuario.
	 */
	@Test
	@Rollback
	public void testBuscarPorOrganizacionYUsuarioSesion() {
		
		// Declaraci�n de los parametros de la consulta.
		final String claveOrganizacionParam = "552";
		final String usuarioParam           = "neftali@outlook.com";
		
		UsuarioPulssar usuario = consultaUsuarioService.buscarPorOrganizacionYUsuarioSesion(claveOrganizacionParam, usuarioParam);
		
		assertNotNull(usuario);
		
		assertEquals(Long.valueOf(44), usuario.getIdentificador());
		assertEquals("neftali@outlook.com", usuario.getUsuario());
		assertEquals("NEFTALI", usuario.getNombre());
		assertEquals("TORRES", usuario.getApellidoPaterno());
		assertEquals("ANGEL", usuario.getApellidoMaterno());
		assertEquals("5567870042", usuario.getCelular());
		assertEquals("552", usuario.getClaveOrganizacion());
	}
	
	
	/**
	 * <p>
	 * Permite probar el happy path para la cosolta de usuario a trav�s de la
	 * clave de la Organiaci�n y el usuario.
	 * </p>
	 * <p>
	 * Esta prueba sirve para la puebas con los paramtros de la clave de la
	 * organizaci�n y el usuario ya que respetan las mismas reglas de validaci�n
	 * </p>
	 */
	@Test
	@Rollback
	public void testBuscarPorOrganizacionYUsuarioSesion_usuarioNulo() {
		
		// Declaraci�n de los parametros de la consulta.
		final String claveOrganizacionParam = "552";
		final String usuarioParam           = null;
		
		try {
			consultaUsuarioService.buscarPorOrganizacionYUsuarioSesion(claveOrganizacionParam, usuarioParam);
			fail("Se esperaba una excepcion");
		}
		catch (GenericException e) {
			
			assertNotNull(e);
			
			assertEquals("G002", e.getCodigo());
			assertEquals("El parametro usuario es requerido. ", e.getMessage());
		}
		catch (Exception e) {
			fail("Excepcion no controlada.");
		}
	}
	
	/**
	 * <p>
	 * Permite probar el happy path para la cosolta de usuario a trav�s de la
	 * clave de la Organiaci�n y el usuario.
	 * </p>
	 * <p>
	 * Esta prueba sirve para la puebas con los paramtros de la clave de la
	 * organizaci�n y el usuario ya que respetan las mismas reglas de validaci�n
	 * </p>
	 */
	@Test
	@Rollback
	public void testBuscarPorOrganizacionYUsuarioSesion_usuarioVacio() {
		
		// Declaraci�n de los parametros de la consulta.
		final String claveOrganizacionParam = "552";
		final String usuarioParam           = "";
		
		try {
			consultaUsuarioService.buscarPorOrganizacionYUsuarioSesion(claveOrganizacionParam, usuarioParam);
			fail("Se esperaba una excepcion");
		}
		catch (GenericException e) {
			
			assertNotNull(e);
			
			assertEquals("G002", e.getCodigo());
			assertEquals("El parametro usuario es requerido. ", e.getMessage());
		}
		catch (Exception e) {
			fail("Excepcion no controlada.");
		}
	}
	
	/**
	 * <p>
	 * Permite probar el escenario d�nde no se encuentra el usuario registrado.
	 * </p>
	 */
	@Test
	@Rollback
	public void testBuscarPorOrganizacionYUsuarioSesion_sinUsuarioRegistrado() {
		
		// Declaraci�n de los parametros de la consulta.
		final String claveOrganizacionParam = "5520";
		final String usuarioParam           = "nefas@outlok.com";
		
		try {
			consultaUsuarioService.buscarPorOrganizacionYUsuarioSesion(claveOrganizacionParam, usuarioParam);
			fail("Se esperaba una excepcion");
		}
		catch (GenericException e) {
			
			assertNotNull(e);
			
			assertEquals("G001", e.getCodigo());
			assertEquals("El usuario nefas@outlook.com con organizacion 552 no se encuentra registrado", e.getMessage());
		}
		catch (Exception e) {
			fail("Excepcion no controlada.");
		}
	}
}
