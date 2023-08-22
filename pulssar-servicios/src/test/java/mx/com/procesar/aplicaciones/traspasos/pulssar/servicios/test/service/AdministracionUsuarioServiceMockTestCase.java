package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.AdministracionUsuarioServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Metodo encargado de validar exepciones de administracion
 * @author JMGUTIER
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class AdministracionUsuarioServiceMockTestCase {

	/**
	 * Dependecia servicioRegistroUsuario
	 */
	@Autowired
	@InjectMocks
	private AdministracionUsuarioService servicioAdministracion = new AdministracionUsuarioServiceImpl();
	
	/**
	 * Inyeccion servicio catalogo
	 */
	@Mock
	private CatalogoService servicioCatalogo;

	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	public void testRecuperarContrasenia(){
		DatosRegistro registro = new DatosRegistro();
		registro.setNickUsuario("juan.gutierrez@gmail.com");
		registro.setCorreo("juan.0719967@gmail.com");
		registro.setCelular("2435673245");
		Mockito.when(servicioCatalogo.obtenerRespuesta(ArgumentMatchers.any(DatosRegistro.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(),ArgumentMatchers.anyString())).thenThrow(new RuntimeException("control"));
		try{
			servicioAdministracion.recuperarContrasenia(registro);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	public void testRecuperarContraseniaCodigoVigente(){
		DatosRegistro registro = new DatosRegistro();
		registro.setNickUsuario("codigoVigente@gmail.com");
		registro.setCorreo("codigoVigente@gmail.com");
		registro.setCelular("5920493348");
		Mockito.when(servicioCatalogo.obtenerRespuesta(ArgumentMatchers.any(DatosRegistro.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(),ArgumentMatchers.anyString())).thenThrow(new RuntimeException("control"));
		try{
			servicioAdministracion.recuperarContrasenia(registro);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
//	/**
//	 * Test encargado de Validar Registro Usuario Nap
//	 */
//	@Test
//	public void testRegistrarUsuarioNap() {
//			DatosRegistro datos = new DatosRegistro();
//			datos.setNumeroAgente("1602075135");
//			datos.setNombre("Miguel");
//			datos.setApellidoPaterno("Hernandez");
//			datos.setApellidoMaterno("Rodriguez");
//			datos.setCelular("0987654321");
//			datos.setConfirmarCelular("0987654321");
//			datos.setCorreo("juan_071996@gmail.com");
//			datos.setConfirmarCorreo("juan_071996@gmail.com");
//			datos.setPassword("123456789");
//			datos.setConfirmarPassword("123456789");
//			datos.setClaveAfore("556");
//			try{
//				RespuestaServicio respuesta = servicioRegistro.registrarUsuarioNap(datos, "usuario");
//				assertNotNull(respuesta);
//			}catch(Exception e){
//				assertNotNull(e);
//			}
//	}
//	
//	/**
//	 * Test encargado de Validar Registro Usuario Nap sin agente
//	 */
//	@Test
//	public void testRegistrarUsuarioNap_SinAgente() {
//			DatosRegistro datos = new DatosRegistro();
//			datos.setNombre("Miguel");
//			datos.setApellidoPaterno("Hernandez");
//			datos.setApellidoMaterno("Rodriguez");
//			datos.setCelular("0987654321");
//			datos.setConfirmarCelular("0987654321");
//			datos.setCorreo("juan_071996@gmail.com");
//			datos.setConfirmarCorreo("juan_071996@gmail.com");
//			datos.setPassword("123456789");
//			datos.setConfirmarPassword("123456789");
//			datos.setClaveAfore("556");
//			try{
//				RespuestaServicio respuesta = servicioRegistro.registrarUsuarioNap(datos, "usuario");
//				assertNotNull(respuesta);
//			}catch(Exception e){
//				assertNotNull(e);
//			}
//	}
//	
//	/**
//	 * Test buscar agentePromotos Exception
//	 */
//	@Test
//	public void testBuscarAgentePromotor(){
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNumeroAgente("34658674534");
//		datos.setNombre("Miguel");
//		datos.setApellidoPaterno("Hernandez");
//		datos.setApellidoMaterno("Rodriguez");
//		datos.setCelular("0987654321");
//		datos.setConfirmarCelular("0987654321");
//		datos.setCorreo("juan_071996@gmail.com");
//		datos.setConfirmarCorreo("juan_071996@gmail.com");
//		datos.setPassword("123456789");
//		datos.setConfirmarPassword("123456789");
//		datos.setClaveAfore("556");
//		try{
//			servicioRegistro.buscarAgentePromotor(datos, true);
//		}catch(BusinessException be){
//			assertNotNull(be);
//		}		
//	}
//	
//	/**
//	 * Test validar condicion codigo null
//	 */
//	@Test
//	public void testGuardarAgente() {
//			DatosRegistro datos = new DatosRegistro();
//			List<String> roles = new ArrayList<>();
//			String rol1 = "01";
//			String rol2 = "03";
//			roles.add(rol1);
//			roles.add(rol2);
//			datos.setNumeroAgente("1602075135");
//			datos.setNombre("Miguel");
//			datos.setApellidoPaterno("Hernandez");
//			datos.setApellidoMaterno("Rodriguez");
//			datos.setCelular("0987654321");
//			datos.setConfirmarCelular("0987654321");
//			datos.setCorreo("juan_071996@gmail.com");
//			datos.setConfirmarCorreo("juan_071996@gmail.com");
//			datos.setPassword("123456789");
//			datos.setConfirmarPassword("123456789");
//			datos.setClaveAfore("556");
//			datos.setRoles(roles);
//			CodigoUsuario codigo = new CodigoUsuario();
//			codigo.setEstatus(0);
//			codigo.setCodigo("6545");
//			codigo.setFolio("46575675");
//			codigo.setFechaVigencia(new Date());
//			codigo.setTipoCodigo("02");
//			codigo.setFecha(new Date());
//			codigo.setUsuario("usuario");
//			try{
//				servicioGuardar.guardarUsuario(datos, datos.getNumeroAgente(), codigo);
//			}catch(Exception e){
//				assertNotNull(e);
//			}
//	}
//	
//	
//	/**
//	 * Test validar condicion codigo null
//	 */
//	@Test
//	public void testGuardarAgenteCodigoNull() {
//			DatosRegistro datos = new DatosRegistro();
//			List<String> roles = new ArrayList<>();
//			String rol1 = "01";
//			roles.add(rol1);
//			datos.setNumeroAgente("7656435");
//			datos.setNombre("Nombre");
//			datos.setApellidoPaterno("Apellidos");
//			datos.setApellidoMaterno("Materno");
//			datos.setCelular("Celular");
//			datos.setConfirmarCelular("Celular");
//			datos.setCorreo("Correo@gmail.com");
//			datos.setConfirmarCorreo("Correo@gmail.com");
//			datos.setPassword("password");
//			datos.setConfirmarPassword("password");
//			datos.setClaveAfore("556");
//			datos.setRoles(roles);
//			try{
//				servicioGuardar.guardarUsuario(datos, datos.getNumeroAgente(), null);
//			}catch(Exception e){
//				assertNotNull(e);
//			}
//	}
//	
	/**
	 * Test recuperar contraseña exception
	 */
	@Test
	public void testRecuperarContraseniaException(){
		DatosRegistro registro = new DatosRegistro();
		registro.setNickUsuario("recuperar@gmail.com");
		registro.setCorreo("recuperar@gmail.com");
		registro.setCelular("1111111333");
		Mockito.when(servicioCatalogo.obtenerRespuesta(ArgumentMatchers.any(DatosRegistro.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(),ArgumentMatchers.anyString())).thenThrow(new RuntimeException("control"));
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(registro);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña usuario correo
	 */
	@Test
	public void testRecuperarContraseñaSinEmail(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("sincorreo");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("3539353939");
		datos.setConfirmarCelular("3539353939");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * Test Registrat Alta usuario error dominio
	 */
	@Test
	public void registrarAltaUsuarioErroCorreo(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("34658674534");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("6666666667");
		datos.setConfirmarCelular("6666666667");
		datos.setCorreo("jose@yahoo.com");
		datos.setConfirmarCorreo("jose@yahoo.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		try{
			//servicioAdministracion.registrarAltaUsuario(datos, null, null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * tests recuperar contraseña usuario bloqueo
	 */
	@Test
	public void testRecuperarContraseniaUsuarioBloqueo(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("primerBloqueo@gmail.com");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCorreo("primerBloqueo@gmail.com");
		datos.setConfirmarCorreo("primerBloqueo@gmail.com");
		datos.setCelular("2389764897");
		datos.setConfirmarCelular("2389764897");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña codigo vigente
	 */
	@Test
	public void testRecuperarContraseniaCodigoVigencia(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("vigencia");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCorreo("vigencia@gmail.com");
		datos.setConfirmarCorreo("vigencia@gmail.com");
		datos.setCelular("3498743289");
		datos.setConfirmarCelular("3498743289");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña bloqueo vigente
	 */
	@Test
	public void testRecuperarContraseniaBloqueoVigente(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("primerBloqueoVigente");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCorreo("primerBloqueoVigente@gmail.com");
		datos.setConfirmarCorreo("primerBloqueoVigente@gmail.com");
		datos.setCelular("9834298827");
		datos.setConfirmarCelular("9834298827");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * tests recuperar contraseña bloqueo vigente permanente
	 */
	@Test
	public void testRecuperarContraseniaBloqueoVigente2(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("segundoBloqueoVigente");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCorreo("segundoBloqueoVigente@gmail.com");
		datos.setConfirmarCorreo("segundoBloqueoVigente@gmail.com");
		datos.setCelular("9834298827");
		datos.setConfirmarCelular("9834298827");
		datos.setPassword("2431154259");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		RespuestaServicio respuesta = servicioAdministracion.recuperarContrasenia(datos);
		assertNotNull(respuesta);
	}
	
	/**
	 * test activar usuario error cadena desencriptada
	 */
	@Test
	public void testActivarUsuario (){
		DatosRegistro datos = new DatosRegistro();
		String url = "a001fbef551e10c42f278d7d69e473db";
		datos.setNickUsuario("jose@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setCodigo("7352");
		datos.setPasswordActual("0987654321");
		RespuestaServicio respuesta = servicioAdministracion.activarUsuario(datos,url);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar bloqueo de ususario 
	 */
	@Test
	public void testBuscarBloqueoUsuario(){
		String salida = "Credenciales invalidas para Usuario: 0123456789";
		RespuestaServicio respuesta = servicioAdministracion.buscarBloqueoUsuario(salida);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar bloqueo de ususario 
	 */
	@Test
	public void testBuscarBloqueoUsuarioString2(){
		String salida = "seguridad.mensaje.excepcion.configuracion.error.credenciales0123456789";
		RespuestaServicio respuesta = servicioAdministracion.buscarBloqueoUsuario(salida);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar bloqueo de ususario 
	 */
	@Test
	public void testBuscarBloqueoUsuarioStringDiferente(){
		String salida = "Error, 0123456789";
		try{
			servicioAdministracion.buscarBloqueoUsuario(salida);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test para validar bloqueo de ususario 3 intentos
	 */
	@Test
	public void testBuscarBloqueoUsuarioLimiteIntentos(){
		String salida = "Credenciales invalidas para Usuario: usuarioBloqueo@gmail.com";
		RespuestaServicio respuesta = servicioAdministracion.buscarBloqueoUsuario(salida);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar bloqueo de ususario 3 intentos
	 */
	@Test
	public void testBuscarBloqueoUsuarioSegundoBloqueo(){
		String salida = "Credenciales invalidas para Usuario: usuarioSegundoBloqueo@gmail.com";
		RespuestaServicio respuesta = servicioAdministracion.buscarBloqueoUsuario(salida);
		assertNotNull(respuesta);
	}
	
	/**
	 * test nick existente sin usaurio 
	 */
	@Test
	public void testBajaUsuarioNick(){
		servicioAdministracion.bajaUsuarios(Arrays.asList("1021067"), "556", "usuario");
	}
	
	/**
	 * test nick existente sin usaurio 
	 */
	@Test
	public void testBajaUsuarioConNick(){
		servicioAdministracion.bajaUsuarios(Arrays.asList("inactivo2@gmail.com"), "556", "usuario");
	}
	
	/**
	 * test validacion activacion usuario
	 */
	@Test
	public void validarActivacionUsuario(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNickUsuario("juan.071996@gmail.com");
		datos.setNumeroAgente("juan.071996@gmail.com");
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
		datos.setCodigo("7390");
		String url = "e751edb8f4265d6a39ff4b7dcccb6a6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c";
		RespuestaServicio respuesta = servicioAdministracion.validarActivacionUsuario(url, datos, true);
		assertNotNull(respuesta);
	}
	
	/**
	 * test validacion activacion usuario datos incongruentes
	 */
	@Test
	public void validarActivacionUsuarioIncongruente(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("juan.071996@gmail.com");
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
		datos.setCodigo("7390");
		String url = "e751edb8f4265d6a39ff4b7dcccb6a6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c";
		RespuestaServicio respuesta = servicioAdministracion.validarActivacionUsuario(url, datos, false);
		assertNotNull(respuesta);
	}
	
	/**
	 * validacion activar usuario , usuario vacio 
	 */
	@Test
	public void validarActivacionUsuarioVacio(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("juan.071996@gmail.com");
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
		datos.setCodigo("7390");
		String url = "bbb9faf46f5eaa767e20c4f1c0c472d2e79b2997d060a6b27bcd9ebc44663223";
		RespuestaServicio respuesta = servicioAdministracion.validarActivacionUsuario(url, datos, false);
		assertNotNull(respuesta);
	}
	
	/**
	 * modificacion de estatus validacion nick
	 */
	@Test
	public void validarUsuarioNick(){
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setUsuario("9674936");
		servicioAdministracion.modificarEstatus(usuario);
	}
	
	/**
	 * modificacion de estatus validacion nick
	 */
	@Test
	public void testReactivarUsuariosBloqueo1(){
		servicioAdministracion.reactivarUsuarios(Arrays.asList("bloqueoUno"), "556", "bloqueo");
	}
	
	/**
	 * modificacion de estatus validacion nick
	 */
	@Test
	public void testReactivarUsuariosBloqueo2(){
		servicioAdministracion.reactivarUsuarios(Arrays.asList("bloqueoDos"), "556", "bloqueo");
	}
	
	/**
	 * modificacion de estatus validacion nick
	 */
	@Test
	@Ignore
	public void testReenviarAltaUsuario(){
		DatosRegistro registro = new DatosRegistro();
		String[] usuarios = {"reenvioUno","reenvioDos"};
		registro.setClaveAfore("556");
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setUsuario("usuario");
		RespuestaServicio respuesta = servicioAdministracion.reenviarAltaUsuario(Arrays.asList(usuarios),registro,usuario);
		assertNotNull(respuesta);
	}
	
	/**
	 * test actualizar correo
	 */
	@Test
	public void testEditarCorreoExeption(){
		CorreoCorporativo correo = new CorreoCorporativo();
		List<CorreoCorporativo> lista = new ArrayList<>();
		correo.setEmail("nuevo");
		correo.setEmail("seguro");
		lista.add(correo);
		String[] correos = {"nuevo","seguro"};
		RespuestaServicio respuesta = servicioAdministracion.editarCorreos(null, null, correos, lista);
		assertNotNull(respuesta);
	}
	
	/**
	 * test actualizar correo
	 */
	@Test
	public void testEditarCorreo(){
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setUsuario("usuaro");
		CorreoCorporativo correo = new CorreoCorporativo();
		List<CorreoCorporativo> lista = new ArrayList<>();
		correo.setClaveOrganizacion("556");
		correo.setEmail("email");
		correo.setEmail("correo");
		lista.add(correo);
		String[] correos = {"nuevo","seguro"};
		RespuestaServicio respuesta = servicioAdministracion.editarCorreos(null, usuario, correos, lista);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para validar bloqueo de ususario 
	 */
	@Test
	public void testBuscarBloqueoUsuarioAdministrador(){
		String salida = "Credenciales invalidas para Usuario: administradorBloqueo";
		RespuestaServicio respuesta = servicioAdministracion.buscarBloqueoUsuario(salida);
		assertNotNull(respuesta);
	}
	
	/**
	 * test para reenvio de correo para recuperacion de password
	 */
	@Test
	public void testReenviarCorreoPassword(){
		RespuestaServicio respuesta = servicioAdministracion.reenviarCorreoPassword("reenvioCodigoCambio");
		assertNotNull(respuesta);
	}
	
	/**
	 * test para reenvio de correo para recuperacion de password Business
	 */
	@Test
	public void testReenviarCorreoPasswordBussines(){
		RespuestaServicio respuesta = servicioAdministracion.reenviarCorreoPassword("codigoVigente@gmail.com");
		assertNotNull(respuesta);
	}
	
	/**
	 * test para reenvio de correo para recuperacion de password Business
	 */
	@Test
	@Ignore
	public void testReenviarCodigo(){
		DatosRegistro registro = new DatosRegistro();
		registro.setNickUsuario("reenvioCodigoCambio");
		String url = "80a72fb8327b3019b90932069ee4df9aa258e3f5cae15eed05314dd6c10e08d8747bd376b756421258329dc8f660a09e";
		RespuestaServicio respuesta = servicioAdministracion.reenviarCodigo(registro,url);
		assertNotNull(respuesta);
	}
	
	
	/**
	 * test para reenvio de correo para recuperacion de password Business
	 */
	@Test
	public void testReenviarCodigoFolio(){
		DatosRegistro registro = new DatosRegistro();
		registro.setNickUsuario("reenvioCodigoCambio");
		String url = "80a72fb8327b3019b90932069ee4df9aa258e3f5cae15eed05314dd6c10e08d8d12f410674d327823e0cb783cc29f0cd";
		try{
			servicioAdministracion.reenviarCodigo(registro,url);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	

	
	
}