package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosOrganizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class AdministracionUsuarioServiceTestCase {
	/**
	 * inyeccion de servicio
	 */
	@Autowired
	private AdministracionUsuarioService servicioAdministraion;

	/**
	 * test de consulta de usuarios para baja
	 */
	@Test
	public void consultarUsuarioBajaTest() {
		List<UsuarioPulssar> resultado = servicioAdministraion.consultarBajaUsuario("556",RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
		assertNotNull(resultado);
	}

	/**
	 * Test de consulta de usuarios para baja
	 */
	@Test
	public void consultaBajaTest() {
		List<Usuarios> resultado = servicioAdministraion.consultarUsuarioSinRol("556", "0123456791",RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA,false,false);
		assertNotNull(resultado);
	}

	/**
	 * Test de consulta de usuarios con roles
	 */
	@Test
	public void consultarUsuarioRolesTest() {
		List<UsuariosModificar> resultado = servicioAdministraion.consultarUsuariosRoles("556", "0123456790", 1,RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
		assertNotNull(resultado);
	}
	 /**
	 * Test de baja de usuarios
	 */
	 @Test
	 public void bajaUsuariosTest(){
		 RespuestaServicio respuesta = servicioAdministraion.bajaUsuarios(Arrays.asList("0123456794"), "556", "0123456789");
		 assertNotNull(respuesta);
	 }
	 
	 /**
	 * Test de baja de usuarios por nick
	 */
	 @Test
	 public void bajaUsuariosNickTest(){
		 RespuestaServicio respuesta = servicioAdministraion.bajaUsuarios(Arrays.asList("102102"), "556", "102102");
		 assertNotNull(respuesta);
	 }
	 
	 /**
	 * Test de baja de usuarios rechazo
	 */
	 @Test
	 public void bajaUsuariosErrorTest(){
		 RespuestaServicio respuesta = servicioAdministraion.bajaUsuarios(null, "556", "");
		 assertNotNull(respuesta);
	 }

	/**
	 * Test para obtener rol de usuario
	 */
	@Test
	public void obtenerRolUsuarioTest() {
		UsuarioLogin usuario = servicioAdministraion.obtenerRolUsuario("0123456789");
		assertNotNull(usuario);
	}
	
	/**
	 * Test para obtener rol de usuario ventanilla
	 */
	@Test
	public void obtenerRolUsuarioTestVentanilla() {
		UsuarioLogin usuario = servicioAdministraion.obtenerRolUsuario("rolVentanilla@gmail.com");
		assertNotNull(usuario);
	}
	
	/**
	 * tests obtener rol nick error
	 */
	@Test
	public void obtenerRolNickTestError() {
		try{
			servicioAdministraion.obtenerRolUsuario("102108");
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * tests obtener rol nick exito
	 */
	@Test
	public void obtenerRolNickTest() {
		UsuarioLogin usuario = servicioAdministraion.obtenerRolUsuario("102105");
		assertNotNull(usuario);
	}

	/**
	 * Test para validar Login
	 */
	@Test
	public void validarUsuarioLoginTest() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("0123456789", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test validar usuario bloqueado loguin 
	 */
	@Test
	public void validarUsuarioLoginBloqueadoTest() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("primerBloqueoVigente", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar usuario reactivado
	 */
	@Test
	public void validarUsuarioLoginReactivadoTest() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("reactivado", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test para validar Login Exception
	 */
	@Test
	public void validarUsuarioLoginTestBusinessException() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("102105", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test para validar login  bloqueo sin registro bloqueo
	 */
	@Test
	public void testLoginUsuarioBloqueoSinRegistro() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("sinRegistroBloqueo", null);
		assertNotNull(respuesta);
	}
	
	@Test
	public void testLoginUsuarioInactivo() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("usuarioBaja", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test para validar login sin bloqueo
	 */
	@Test
	public void testObtenerRolUsuarioBloqueo() {
		UsuarioLogin respuesta = servicioAdministraion.obtenerRolUsuario("intentosBloqueo");
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar login primer bloqueo 
	 */
	@Test
	public void testObtenerRolUsuarioBloqueo2() {
		UsuarioLogin respuesta = servicioAdministraion.obtenerRolUsuario("usuarioSegundoBloqueo@gmail.com");
		assertNotNull(respuesta);
	}
	
	/**
	 * Test para validar Login
	 */
	@Test
	public void validarUsuarioNickLoginTest() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("102103", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test para validar Login
	 */
	@Test
	public void validarUsuariokLoginTestError() {
		try{
			servicioAdministraion.validarUsuarioLogin("", null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test para validar Login inactivo
	 */
	@Test
	public void validarUsuarioLoginInactivoTest() {
		RespuestaServicio respuesta = servicioAdministraion.validarUsuarioLogin("inactivo@gmail.com", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * test de asignacion de perfil
	 */
	 @Test
	 public void asignarPerfilTest(){
	 UsuarioPulssar usuario = new UsuarioPulssar();
	 List<UsuarioPulssar> usuarioPulssars = new ArrayList<>();
	 RolesCatalogo roles = new RolesCatalogo();
	 List<RolesCatalogo> rol = new ArrayList<>();
	 List<UsuariosEnum> listaRoles = new ArrayList<>();
	 listaRoles.add(UsuariosEnum.USUARIOS);
	 usuario.setIdentificador(1L);
	 usuario.setUsuario("0123456790");
	 usuarioPulssars.add(usuario);
	 roles.setClaveRol("03");
	 rol.add(roles);
	 RespuestaServicio respuesta = servicioAdministraion.asignarPerfil(Arrays.asList("0123456794"), Arrays.asList("03") ,listaRoles,"556", usuario.getUsuario());
	 assertNotNull(respuesta);
	 }
	 
	/**
	 * test de asignacion de perfil
	*/
	 @Test
	 public void asignarPerfilNickTest(){
	 UsuarioPulssar usuario = new UsuarioPulssar();
	 List<UsuarioPulssar> usuarioPulssars = new ArrayList<>();
	 RolesCatalogo roles = new RolesCatalogo();
	 List<RolesCatalogo> rol = new ArrayList<>();
	 List<UsuariosEnum> listaRoles = new ArrayList<>();
	 listaRoles.add(UsuariosEnum.USUARIOS);
	 usuario.setIdentificador(1L);
	 usuario.setUsuario("0123456790");
	 usuarioPulssars.add(usuario);
	 roles.setClaveRol("03");
	 rol.add(roles);
	 RespuestaServicio respuesta = servicioAdministraion.asignarPerfil(Arrays.asList("102103"), Arrays.asList("03") ,listaRoles,"556", usuario.getUsuario());
	 assertNotNull(respuesta);
	 }
	 
	 /**
	  * test asignar perfil rechazo 
	  */
	 @Test
	 public void asignarPerfilErrorTest(){
		 RespuestaServicio respuesta = servicioAdministraion.asignarPerfil(null, Arrays.asList(""), null, "556", null);
		 assertNotNull(respuesta);
	 }
	
	/**
	 * test de modificacion de usuario
	 */
	@Test
	public void modificarUsuarioTest() {
		RespuestaServicio respuestaEsperada = new RespuestaServicio();
		respuestaEsperada.setTitulo("Modificación del usuario correctamente");
		respuestaEsperada.setMensaje("Los datos del trabajador se modificaron correctamente.");
		respuestaEsperada.setFlujo(NumerosConstants.INT_UNO);
		UsuariosModificar usuarioBD = new UsuariosModificar();
		DatosRegistro usuarioVista = new DatosRegistro();
		String claveAfore = "556";

		usuarioBD.setIdentificadorUsuario(2L);
		usuarioBD.setUsuario("juan_071996@gmail.com");
		usuarioBD.setNombre("prueba2");
		usuarioBD.setApellidoPaterno("prueba2");
		usuarioBD.setApellidoMaterno("prueba2");
		usuarioBD.setEmail("juan_071996@gmail.com");
		usuarioBD.setCelular("2431241008");
		usuarioBD.setClaveOrganizacion("556");
		usuarioBD.setEstatus("01");
		usuarioBD.setClaveRol("05");

		usuarioVista.setNickUsuario("102103");
		usuarioVista.setNombre("prueba4");
		usuarioVista.setApellidoPaterno("prueba2");
		usuarioVista.setApellidoMaterno("prueba2");
		usuarioVista.setCorreo("juan_071996@gmail.com");
		usuarioVista.setCelular("2431154259");
		usuarioVista.setConfirmarCelular("2431154259");
		usuarioVista.setClaveAfore("556");
		String[] roles = new String[1];
		roles[0] = "1";
		RespuestaServicio respuesta = servicioAdministraion.modificarDatosUsuario(usuarioVista, usuarioBD,
				Arrays.asList(usuarioBD.getClaveRol()), claveAfore, usuarioBD.getUsuario(), roles);
		assertNotNull(respuesta);
	}
	
	
	/**
	 * test de modificacion de usuario
	 */
	@Test
	public void modificarUsuarioNumericoTest() {
		RespuestaServicio respuestaEsperada = new RespuestaServicio();
		respuestaEsperada.setTitulo("Modificación del usuario correctamente");
		respuestaEsperada.setMensaje("Los datos del trabajador se modificaron correctamente.");
		respuestaEsperada.setFlujo(NumerosConstants.INT_UNO);
		UsuariosModificar usuarioBD = new UsuariosModificar();
		DatosRegistro usuarioVista = new DatosRegistro();
		String claveAfore = "556";

		usuarioBD.setIdentificadorUsuario(2L);
		usuarioBD.setUsuario("0123456789");
		usuarioBD.setNombre("prueba2");
		usuarioBD.setApellidoPaterno("prueba2");
		usuarioBD.setApellidoMaterno("prueba2");
		usuarioBD.setEmail("juan_0719967@gmail.com");
		usuarioBD.setCelular("2431241008");
		usuarioBD.setClaveOrganizacion("556");
		usuarioBD.setEstatus("01");
		usuarioBD.setClaveRol("05");

		usuarioVista.setNickUsuario("102103");
		usuarioVista.setNombre("prueba4");
		usuarioVista.setApellidoPaterno("prueba2");
		usuarioVista.setApellidoMaterno("prueba2");
		usuarioVista.setCorreo("juan.071996@gmail.com");
		usuarioVista.setCelular("2431154259");
		usuarioVista.setConfirmarCelular("2431154259");
		usuarioVista.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministraion.modificarDatosUsuario(usuarioVista, usuarioBD,
				Arrays.asList(usuarioBD.getClaveRol()), claveAfore, usuarioBD.getUsuario(), null);
		assertNotNull(respuesta);
	}
	
	/**
	 * test de modificacion de usuario
	 */
	@Test
	public void modificarUsuarioNullTest() {
		try{
			servicioAdministraion.modificarDatosUsuario(null, null,
				null, null, null, null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test validar activacion usuario
	 */
	@Test
	public void validarActivacionUsuario(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1234567890");
		datos.setConfirmarCelular("1234567890");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7351");
		String url = "e751edb8f4265d6a39ff4b7dcccb6a6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario error 
	 */
	@Test
	public void validarActivacionUsuarioError(){
		try{
			DatosRegistro datos = new DatosRegistro();
			datos.setNumeroAgente("1602075135");
			datos.setNombre("Miguel");
			datos.setApellidoPaterno("Hernandez");
			datos.setApellidoMaterno("Rodriguez");
			datos.setCelular("1234567890");
			datos.setConfirmarCelular("1234567890");
			datos.setCorreo("juan_071996@gmail.com");
			datos.setConfirmarCorreo("juan_071996@gmail.com");
			datos.setPassword("123456789");
			datos.setConfirmarPassword("123456789");
			datos.setClaveAfore("556");
			String url = null;
			servicioAdministraion.validarActivacionUsuario(url, datos, true);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test Validacion error bussiness
	 */
	@Test
	public void validarActivacionUsuarioErrorBussines(){
		try{
			DatosRegistro datos = new DatosRegistro();
			datos.setNumeroAgente("1602075135");
			datos.setNombre("Miguel");
			datos.setApellidoPaterno("Hernandez");
			datos.setApellidoMaterno("Rodriguez");
			datos.setCelular("1234567890");
			datos.setConfirmarCelular("1234567890");
			datos.setCorreo("juan_071996@gmail.com");
			datos.setConfirmarCorreo("juan_071996@gmail.com");
			datos.setPassword("123456789");
			datos.setConfirmarPassword("123456789");
			datos.setClaveAfore("556");
			String url = "e6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c";
			servicioAdministraion.validarActivacionUsuario(url, datos, true);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test obtener correos corporativos
	 */
	@Test
	public void testObtenerCorreoCorporativo(){
		List<CorreoCorporativo> respuesta = servicioAdministraion.obtenerCorreosCorporativos("556");
		assertNotNull(respuesta);		
	}
	
	/**
	 * test null en lista correos
	 */
	@Test
	public void testObtenerCorreoCorporativoNull(){
		List<CorreoCorporativo> respuesta = servicioAdministraion.obtenerCorreosCorporativos("553");
		assertNull(respuesta);		
	}
	
	/**
	 * Test consultar correo corporativo existente exito
	 */
	@Test
	public void testObtenerCorreosExistente(){
		List<CorreoCorporativo> respuesta = servicioAdministraion.obtenerCorreosExistentes("556", "@GMAIL.COM");
		assertNotNull(respuesta);
	}
	
	/**
	 * Test consultar correo corporativo existente null
	 */
	@Test
	public void testObtenerCorreosExistenteNul(){
		List<CorreoCorporativo> respuesta = servicioAdministraion.obtenerCorreosExistentes("556", "@HOTMAIL.COM");
		assertNull(respuesta);
	}
	
	/**
	 * test guardar correo corporativo exito
	 */
	@Test
	public void testGuardarCorreoCorporativo(){
		UsuarioLogin usuario = new UsuarioLogin();
		DatosOrganizacion organizacion = new DatosOrganizacion();
		organizacion.setEmail("HOTMAIL.com");
		usuario.setUsuario("prueba_registro");
		usuario.setAforeUsuario("556");
		RespuestaServicio respuesta = servicioAdministraion.guardarCorreos(organizacion, usuario, "556");
		assertNotNull(respuesta);
	}
	
	/**
	 * test guardar correo corporativo error
	 */
	@Test
	public void testGuardarCorreoCorporativoError(){
		try{
			UsuarioLogin usuario = new UsuarioLogin();
			DatosOrganizacion organizacion = new DatosOrganizacion();
			organizacion.setEmail("HOTMAIL.com");
			usuario.setUsuario("prueba_registro");
			servicioAdministraion.guardarCorreos(organizacion, usuario, "556");
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test lista correos
	 */
	@Test
	public void testListaCorreos(){
		List<CorreoCorporativo> lista = servicioAdministraion.listaCorreos("556");
		assertNotNull(lista);
	}
	
	/**
	 * test editar correos corporativos exitoso
	 */
	@Test
	public void testEditarCorreos(){
		UsuarioLogin usuario = new UsuarioLogin();
		DatosOrganizacion organizacion = new DatosOrganizacion();
		usuario.setUsuario("prueba_registro");
		usuario.setAforeUsuario("556");
		List<CorreoCorporativo> lista = new ArrayList<>();
		CorreoCorporativo correo = new CorreoCorporativo();
		correo.setClaveOrganizacion("556");
		correo.setEmail("GMAIL.COM");
		lista.add(correo);
		RespuestaServicio respuesta = servicioAdministraion.editarCorreos(organizacion, usuario, null, lista);
		assertNotNull(respuesta);
	}
	
	/**
	 * test editar correos corporativos exitoso
	 */
	@Test
	public void testEditarCorreosDiferente(){
		UsuarioLogin usuario = new UsuarioLogin();
		DatosOrganizacion organizacion = new DatosOrganizacion();
		usuario.setUsuario("prueba_registro");
		usuario.setAforeUsuario("556");
		List<CorreoCorporativo> lista = new ArrayList<>();
		CorreoCorporativo correo = new CorreoCorporativo();
		correo.setClaveOrganizacion("556");
		correo.setEmail("GMAIL.COM");
		lista.add(correo);
		RespuestaServicio respuesta = servicioAdministraion.editarCorreos(organizacion, usuario, null, lista);
		assertNotNull(respuesta);
	}
	
	/**
	 * test editar correos corporativos error
	 */
	@Test
	public void testEditarCorreosError(){
		UsuarioLogin usuario = new UsuarioLogin();
		DatosOrganizacion organizacion = new DatosOrganizacion();
		usuario.setUsuario("prueba_registro");
		usuario.setAforeUsuario("556");
		List<CorreoCorporativo> lista = new ArrayList<>();
		CorreoCorporativo correo = new CorreoCorporativo();
		correo.setEmail("GMAIL.COM");
		lista.add(correo);
		RespuestaServicio respuesta = servicioAdministraion.editarCorreos(organizacion, usuario, null, lista);
		assertNotNull(respuesta);
	}
	
	/**
	 * test consultar usuario nick exito
	 */
	@Test
	public void testConsultarNick(){
		AgentePromotor agente = servicioAdministraion.buscarUsuarioNick("556", "102102");
		assertNotNull(agente);
	}
	
	/**
	 * test consultar usuario nick error
	 */
	@Test
	@Ignore
	public void testConsultarNickError(){
		AgentePromotor agente = servicioAdministraion.buscarUsuarioNick("556", "102104");
		assertNotNull(agente);
	}
	
	/**
	 * tests recuperar contraseña usuario numerico
	 */
	@Test
	public void testRecuperarContraseñaUsuarioNumerico(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("1602075135");
		datos.setNickUsuario("0123456789");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("5586789202");
		datos.setConfirmarCelular("5586789202");
		datos.setCorreo("davidltol19@gmail.com");
		datos.setConfirmarCorreo("davidltol19@gmail.com");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministraion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña usuario correo
	 */
	@Test
	public void testRecuperarContraseñaUsuarioCorreo(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("1602075135");
		datos.setNickUsuario("juan.gutierrez@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("2435678987");
		datos.setConfirmarCelular("2435678987");
		datos.setCorreo("juan.0719967@gmail.com");
		datos.setConfirmarCorreo("juan.0719967@gmail.com");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministraion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña usuario inactivo
	 */
	@Test
	public void testRecuperarContraseñaUsuarioInactivoCorreo(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("saul@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("2435678987");
		datos.setConfirmarCelular("2435678987");
		datos.setCorreo("juan.0719967@gmail.com");
		datos.setConfirmarCorreo("juan.0719967@gmail.com");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		RespuestaServicio respuesta = servicioAdministraion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * test activar usuario exito
	 */
	@Test
	public void testActivarUsuario (){
		DatosRegistro datos = new DatosRegistro();
		String url = "869b6902a3c0d4d25178caa15c5a6c9a6d918adbd5e617e1ac83283dfd50231ec68e601253ce06d0c691a9a370951c9f";
		datos.setNickUsuario("jose@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setCodigo("7352");
		datos.setPasswordActual("0987654321");
		RespuestaServicio respuesta = servicioAdministraion.activarUsuario(datos,url);
		assertNotNull(respuesta);
	}
	
	/**
	 * test activar usuario error
	 */
	@Test
	public void testActivarUsuarioError(){
		DatosRegistro datos = new DatosRegistro();
		String url = "869b6902a3c0d4d25178caa15c5a6c9a6d918adbd5e617e1ac83283dfd50231ec68e601253ce06d0c691a9a370951c9f";
		datos.setNickUsuario("jose@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setCodigo("7352");
		RespuestaServicio respuesta = servicioAdministraion.activarUsuario(datos,url);
		assertNotNull(respuesta);
	}
	
	/**
	 * test activar usuario error password
	 */
	@Test
	public void testActivarUsuarioErrorPassword(){
		DatosRegistro datos = new DatosRegistro();
		String url = "869b6902a3c0d4d25178caa15c5a6c9a6d918adbd5e617e1ac83283dfd50231ec68e601253ce06d0c691a9a370951c9f";
		datos.setNickUsuario("jose@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456785");
		datos.setCodigo("7352");
		RespuestaServicio respuesta = servicioAdministraion.activarUsuario(datos,url);
		assertNotNull(respuesta);
	}
	
	/**
	 * test cambiar contraseña exito
	 */
	@Test
	public void testCambiarContrasenia(){
		DatosRegistro usuario = new DatosRegistro();
		usuario.setNickUsuario("jose@gmail.com");
		usuario.setPasswordActual("1234567890");
		usuario.setPassword("0987654321");
		servicioAdministraion.cambiarContrasenia(usuario);
	}
	
	/**
	 * Test modificar estatus
	 */
	@Test
	public void testModificarEstatus(){
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setUsuario("jose@gmail.com");
		try{
			servicioAdministraion.modificarEstatus(usuario);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
//	/**
//	 * Test alta usuario agente sin administrador
//	 */
//	@Test
//	public void testAltaUsuarioAgenteSinAdministrador(){
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNumeroAgente("sinAdministrador");
//		datos.setNombre("Miguel");
//		datos.setApellidoPaterno("Hernandez");
//		datos.setApellidoMaterno("Rodriguez");
//		datos.setCelular("5555666699");
//		datos.setConfirmarCelular("5555666699");
//		datos.setCorreo("sinAdministrador@gmail.com");
//		datos.setConfirmarCorreo("sinAdministrador@gmail.com");
//		datos.setPassword("123456789");
//		datos.setConfirmarPassword("123456789");
//		datos.setClaveAfore("999");
//		try{
//			servicioAdministraion.registrarAltaUsuarioAgente(datos, true, Arrays.asList(UsuariosEnum.USUARIOS), RegistroUsuarioConstants.USUARIO_ALTA);
//		}catch(BusinessException be){
//			assertNotNull(be);
//		}
//	}
//	
	/**
	 * Test consultar usuarios sin rol
	 */
	@Test
	public void testconsultarUsuarioSinRol(){
		List<Usuarios> lista = servicioAdministraion.consultarUsuarioSinRol("556", "0123456789", RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, true,false);
		assertNotNull(lista);
	}
	
	/**
	 * Test consultar usuarios sin rol
	 */
	@Test
	public void testconsultarUsuarioSinRol2(){
		List<Usuarios> lista = servicioAdministraion.consultarUsuarioSinRol("556", null, RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, true, true);
		assertNotNull(lista);
	}
	
	/**
	 * Test consultar usuarios sin rol null
	 */
	@Test
	@Ignore

	public void testconsultarUsuarioSinRolNull(){
		List<Usuarios> lista = servicioAdministraion.consultarUsuarioSinRol("999", null, RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, false, true);
		assertEquals(0, lista.size());
	}
	
	/**
	 * Test dar de baja usuarios error
	 */
	@Test
	public void testBajaUsuarios(){
		RespuestaServicio respuesta = servicioAdministraion.bajaUsuarios(Arrays.asList("recuperar@gmail.com"), "556", null);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test dar de baja usuarios con rol usuario
	 */
	@Test
	public void testBajaUsuarios2(){
		RespuestaServicio respuesta = servicioAdministraion.bajaUsuarios(Arrays.asList("rolusuario@gmail.com"), "556", "recuperar@gmail.com");
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario Nick Exception
	 */
	@Test
	public void validarActivacionUsuarioNick(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("102106");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("5566889933");
		datos.setConfirmarCelular("5566889933");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7353");
		String url = "4ea3b21cc6ab1943fecc766d45d18cc49d94ae61296d7ef7fb267e5748a2c6fb";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	
	/**
	 * test validar activacion usuario  Exception url incorrecta
	 */
	@Test
	public void validarActivacionUsuarioErrorUrl(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("102106");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("5566889933");
		datos.setConfirmarCelular("5566889933");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7353");
		String url = "4ea3b21cc6ab1943fecc766d45d18cc4f2ac13904194326bad3bdd6f7fe05dbc";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario  Exception url incorrecta
	 */
	@Test
	public void validarActivacionUsuarioSinUsuario(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("102106");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("5566889933");
		datos.setConfirmarCelular("5566889933");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7353");
		String url = "5551eadf1d923e6d2aff4a59a89345da3e88d9f68be1564fa4e035cc3c59af23";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario diferencias Codigo
	 */
	@Test
	public void validarActivacionUsuarioDiferenciasCodigo(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1234567890");
		datos.setConfirmarCelular("1234567890");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7369");
		String url = "e751edb8f4265d6a39ff4b7dcccb6a6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario Exception
	 */
	@Test
	public void validarActivacionUsuarioException(){
		String url = "04b68133c46d936802c13949fe96875f94340acb1646afe49724be27a8f9c408c5ed3f62b65f2869fbe8059861b0d3b1";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, null, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario codigo bloquead
	 */
	@Test
	public void validarActivacionUsuarioCodigoBloqueado(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("activacion@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("0000099991");
		datos.setConfirmarCelular("0000099991");
		datos.setCorreo("activacion@gmail.com");
		datos.setConfirmarCorreo("activacion@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7390");
		String url = "76de24cc26704b8c6c3c8f6c32f25d88d02ebd620d1f48d8dc3a94fe63f0b1d3e3560580f24e52325abb4956b9c6749e";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario codigo usado
	 */
	@Test
	public void validarActivacionUsuarioCodigoUsado(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("usado@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("7788336600");
		datos.setConfirmarCelular("7788336600");
		datos.setCorreo("usado@gmail.com");
		datos.setConfirmarCorreo("usado@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7355");
		String url = "ff0b5511c7213bd6465d5a5057e3f0d70a2c2e4be6bc25885443196961c73efdbdf955476a1a21d33e7fbc2ef0653500";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario codigo vencido
	 */
	@Test
	public void validarActivacionUsuarioCodigoVencido(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("vencido@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("0939295386");
		datos.setConfirmarCelular("0939295386");
		datos.setCorreo("vencido@gmail.com");
		datos.setConfirmarCorreo("vencido@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7356");
		String url = "e3bec81d5692b9c2fae69cc4194905466c8f42c5997422d003083c7479e089b24d80940ebdab655ee8bef3b41f01eaf2";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario codigo bloquead
	 */
	@Test
	public void validarActivacionUsuarioCodigoBloqueado2(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("bloqueado2@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1177220072");
		datos.setConfirmarCelular("1177220072");
		datos.setCorreo("bloqueado2@gmail.com");
		datos.setConfirmarCorreo("bloqueado2@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7357");
		String url = "51eae2e9b79b1495809c352752e20dbe2bc614ebb0e1935670f3a1cfc8975e719ad3a84cd83b9e4729079caac0a02fc1";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validar activacion usuario codigo bloquead
	 */
	@Test
	public void validarActivacionUsuarioCodigoVencido2(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("12345");
		datos.setNumeroAgente("fechaVencido@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("0928404058");
		datos.setConfirmarCelular("0928404058");
		datos.setCorreo("fechaVencido@gmail.com");
		datos.setConfirmarCorreo("fechaVencido@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		datos.setCodigo("7358");
		String url = "dca762c9f3dd2d24182c10daa8258119b6eeb7ed116c50673b92a36816886892f56a0307c2125be01198fe75667a40da";
		RespuestaServicio respuesta = servicioAdministraion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test Consultar usaurios con codigo vencido
	 */
	@Test
	public void consultarUsuariosCodigoVencido(){
		List<Usuarios> respuesta = servicioAdministraion.consultarUsuariosCodigoVencido("556", EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario(), NumerosConstants.INT_CERO, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
		assertNotNull(respuesta);
	}
}
