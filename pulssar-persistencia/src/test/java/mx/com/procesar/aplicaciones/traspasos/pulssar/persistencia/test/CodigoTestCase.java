package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CodigoUsuarioRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
 PulssarPersistenceApplicationContextTest.class})
public class CodigoTestCase {
	
	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private CodigoUsuarioRepository codigo;
	
//	/**
//	 * prueba exito 
//	 * obtener codigo de activacion por id de usuario
//	 */
//	@Test
//	@Rollback
//	public void testFindCodigoByUsuario() {
//		List<CodigoUsuario> lista = codigo.findByidUsuario(2L);
//		assertNotNull(lista);
//	}
	
//	/**
//	 * Prueba Error - Datos Incorrectos
//	 * 
//	 * obtener codigo de activacion por id de usuario
//	 */
//	@Test
//	@Rollback
//	public void testFindCodigoByUsuarioError(){
//		List<CodigoUsuario> lista = codigo.findByidUsuario(null);
//		assertEquals(0, lista.size());
//	}
	
	/**
	 * Prueba exito
	 * obtenr codigo por id , codigo y tipo codigo 
	 */
	@Test
	@Rollback
	public void testFindByIdUsuarioAndFolioAndTipo(){
		List<CodigoUsuario> lista = codigo.findByIdUsuarioAndFolioAndTipo(2L, "15491173300591020015", "1");
		assertNotNull(lista);
	}
	
	/**
	 * Prueba Error
	 * obtenr codigo por id , codigo y tipo codigo 
	 */
	@Test
	@Rollback
	public void testFindByIdUsuarioAndFolioAndTipoError(){
		List<CodigoUsuario> lista = codigo.findByIdUsuarioAndFolioAndTipo(2L, null, null);
		assertEquals(0, lista.size());
	}

}
