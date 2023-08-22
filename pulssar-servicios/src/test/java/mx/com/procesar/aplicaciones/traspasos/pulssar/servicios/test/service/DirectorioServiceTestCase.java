package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class DirectorioServiceTestCase {
	
	/**
	 * Inyeccion de directorio
	 */
	@Autowired
	private DirectorioUsuarioService directorioService;
	
//	/**
//	 * test registrar nuevo usuario
//	 */
//	@Test
//	public void testRegistrarUsuario() {
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNumeroAgente("87587689878");
//		datos.setNombre("JESUS");
//		datos.setApellidoPaterno("GONZALEZ");
//		datos.setApellidoMaterno("TORRES");
//		datos.setCelular("24312");
//		datos.setConfirmarCelular("2431241008");
//		datos.setCorreo("iuhuihuihuihui@gmail.com");
//		datos.setConfirmarCorreo("iuhuihuihuihui@gmail.com");
//		datos.setClaveAfore("556");
////		datos.setRoles("04");
//		datos.setPassword("guguyygiu");
//		try{
//			directorioService.registrarUsuario(datos, true);
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
	
	/**
	 * test recuperar contraseña error
	 */
	@Test
	public void testRecuperaContraseniaError(){
		try{
			directorioService.recuperaContrasenia(null, null);
		}catch(GenericException e){
			assertNotNull(e);
		}				
	}
	
	/**
	 * test recuperar contraseña error
	 */
	@Test
	public void testCambioContraseniaBusiness(){
		try{
			DatosRegistro datos = new DatosRegistro();
			datos.setNumeroAgente("1000123456");
			datos.setPasswordActual("guguyygiu");
			datos.setPassword("guguyygiu");
			directorioService.cambioContrasenia(datos, BusinessErrorEnum.ERROR_PASSWORD_INCORRECTO);
		}catch(BusinessException be){
			assertNotNull(be);
		}				
	}
	
	/**
	 * test recuperar contraseña error
	 */
	@Test
	public void testCambioContraseniaGeneric(){
		try{
			DatosRegistro datos = new DatosRegistro();
			datos.setNumeroAgente("1000123456");
			datos.setPasswordActual("guguyygi");
			datos.setPassword("guguyygiu");
			directorioService.cambioContrasenia(datos, BusinessErrorEnum.ERROR_PASSWORD_INCORRECTO);
		}catch(GenericException be){
			assertNotNull(be);
		}				
	}
	
	/**
	 * test actualizar celular correo
	 */
	@Test
	public void testActualizarCelularCorreoFalse(){
		try{
			directorioService.actualizarCelularCorreoPerfil(null, null, null, null, false);
		}catch(Exception be){
			assertNotNull(be);
		}				
	}
	
	/**
	 * test actualizar celular correo Null usuario
	 */
	@Test
	public void testActualizarCelularCorreoNull(){
		try{
			directorioService.actualizarCelularCorreoPerfil("david1919@gmail.com", "david19@gmail.com", "5578987898", null, true);
		}catch(Exception be){
			assertNotNull(be);
		}				
	}
	
	/**
	 * Test para eliminar roles exito
	 */
	@Test
	public void testEliminarRoles(){
		try{
			List<UsuariosEnum> lista = new ArrayList<>();
			lista.add(UsuariosEnum.ADMINISTRADORES);
			directorioService.eliminarRoles("nuevoPulssar", lista);
		}catch(Exception be){
			assertNotNull(be);
		}
	}
	
	/**
	 * Test consultar Roles OID null
	 */
	@Test
	public void testConsultarRolesOIDNull(){
		try{
			directorioService.eliminarRoles("userName", null);
		}catch(Exception be){
			assertNotNull(be);
		}
	}
	
	/**
	 * Testreinicar intentos logueo 
	 */
	@Test
	public void testReinicarIntentos(){
		try{
			directorioService.reiniciarIntentos("0123456789");
		}catch(Exception be){
			assertNotNull(be);
		}
	}
	
	/**
	 * Test reinicar intentos logueo null
	 */
	@Test
	public void testReinicarIntentosNull(){
		try{
			directorioService.reiniciarIntentos("3436543454");
		}catch(Exception be){
			assertNotNull(be);
		}
	}

}