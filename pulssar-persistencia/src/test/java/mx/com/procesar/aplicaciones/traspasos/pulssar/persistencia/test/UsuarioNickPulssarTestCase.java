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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class UsuarioNickPulssarTestCase {

	@Autowired
	private UsuarioNickPulssarRepository nick;
	
	/**
	 * prueba exito
	 * busqueda de nick
	 */
	@Test
	public void testFindByNickUsuarioAndEstatus() {
		List<UsuarioNickPulssar> lista = nick.findByNickUsuarioAndEstatus("102102", 1);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error
	 * busqueda de nick
	 */
	@Test
	public void testFindByNickUsuarioAndEstatusError() {
		List<UsuarioNickPulssar> lista = nick.findByNickUsuarioAndEstatus(null, 1);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito 
	 * busqueda por usarioPulssar
	 */
	@Test
	public void testFindByNickUsuario() {
		List<Object[]> lista = nick.findByNickUsuario("102102");
		assertNotNull(lista);
	}
	
	/**
	 * prueba error 
	 * busqueda por usarioPulssar
	 */
	@Test
	public void testFindByNickUsuarioError() {
		List<Object[]> lista = nick.findByNickUsuario(null);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito
	 * objeto usuarioNick
	 */
	@Test
	public void testFindByIdUsuarioAndEstatus() {
		UsuarioNickPulssar resultado = nick.findByIdUsuarioAndEstatus("102102", 1);
		assertNotNull(resultado);
	}
	
	/**
	 * prueba error
	 * objeto usuarioNick
	 */
	@Test
	public void testFindByIdUsuarioAndEstatusError() {
		UsuarioNickPulssar resultado = nick.findByIdUsuarioAndEstatus(null, 1);
		assertNull(resultado);
	}
	
//	/**
//	 * prueba exito
//	 * objeto usuarioNick
//	 */
//	@Test
//	public void testFindByNick() {
//		UsuarioNickPulssar resultado = nick.findByNick("102102");
//		assertNotNull(resultado);
//	}
//	
//	/**
//	 * prueba error
//	 * objeto usuarioNick
//	 */
//	@Test
//	public void testFindByNickError() {
//		UsuarioNickPulssar resultado = nick.findByNick(null);
//		assertNull(resultado);
//	}
	
	
	
	

}
