package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CorreoCorporativoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class CorreoCorporativoTestCase {

	/**
	 * 
	 */
	@Autowired
	private CorreoCorporativoRepository correo;
	
	/**
	 * Prueba exito 
	 * Obtener correo porrativo 
	 */
	@Test
	public void testFindByClaveOrganizacionAndEmailAndEstatus() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacionAndEmailAndEstatus("556", "@GMAIL.COM", 1);
		assertNotNull(lista);
	}
	
	/**
	 * prueba error 
	 * obtener correo corporativo 
	 */
	@Test
	public void testFindByClaveOrganizacionAndEmailAndEstatusError() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacionAndEmailAndEstatus(null, "@GMAIL.COM", 1);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba error 
	 * obtener correo corporativo por organizacion 
	 */
	@Test
	public void testFindByClaveOrganizacion() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacion("556");
		assertNotNull(lista);
	}
	
	/**
	 * prueba error 
	 * obtener correo corporativo por organizacion 
	 */
	@Test
	public void testFindByClaveOrganizacionError() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacion(null);
		assertEquals(0, lista.size());
	}
	
	/**
	 * prueba exito 
	 * por organizacion y email
	 */
	@Test
	public void testFindByClaveOrganizacionAndEmail() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacionAndEmail("556", "@GMAIL.COM");
		assertNotNull(lista);
	}
	
	/**
	 * prueba exito 
	 * por organizacion y email	
	 */
	@Test
	public void testFindByClaveOrganizacionAndEmailError() {
		List<CorreoCorporativo> lista = correo.findByClaveOrganizacionAndEmail(null, "@GMAIL.COM");
		assertEquals(0, lista.size());
	}
	
	

}
