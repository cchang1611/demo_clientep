package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarInformacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RegistroUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAltaUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RegistroUsuarioServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * clase de pruebas de la validacion de un registro de usuario
 * 
 * @author dbarbosa
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class RegistroUsuarioServiceTestCase {

	/**
	 * Dependecia servicioRegistroUsuario
	 */
	@InjectMocks
	private RegistroUsuarioService servicioRegistro = new RegistroUsuarioServiceImpl();
	
	/**
	 * Inyeccion utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Mock
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion servicio catalogo 
	 */
	@Mock 
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion Servicio Admin usuarios
	 */
	@Mock
	private ValidarAltaUsuarioService servicioAlta;
	
	/**
	 * Inyeccion de servicio Guardar
	 */
	@Mock
	private GuardarInformacionService servicioGuardar;
	
	/**
	 * Inyeccion de servicio Mensaje
	 */
	@Mock
	private MensajeService servicioMensaje;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Mock
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inicializacion de Mock
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRegistrarUsuarioRest() {
		String datosEntrada = new String();
		datosEntrada = "{\n" + 
				"	\"numeroAgente\":\"1915181609\",\t\n" + 
				"	\"nombre\":\"LILIANA\",\t\n" + 
				"	\"apellidoPaterno\":\"MARTINEZ\",\t\n" + 
				"	\"apellidoMaterno\":\"CUEVAS\",\t\n" + 
				"	\"celular\":\"5520029720\",\t\n" + 
				"	\"claveAfore\":\"556\"\t\n" + 
				"}";
		
		servicioRegistro.registrarUsuarioRest(datosEntrada, true);
	}
	
//	/**
//	 * Test encargado de Validar Registro Usuario
//	 */
//	@Test
//	public void testRegistrarUsuarioNapBussines() {
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
//				servicioRegistro.registrarUsuarioNap(datos, "usuario");
//			}catch(Exception e){
//				assertNotNull(e);
//
//			}
//	}
//	
//	/**
//	 * Test para usuario nap nick
//	 */
//	@Test
//	public void testRegistrarUsuarioNapnick() {
//			DatosRegistro datos = new DatosRegistro();
//			datos.setNumeroAgente("1602075135");
//			datos.setNickUsuario("167890");
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
//			RespuestaServicio respuesta = servicioRegistro.registrarUsuarioNap(datos, "usuario");
//			assertNotNull(respuesta);
//
//	}
//	
//	/**
//	 * Test encargado de Validar Registro Usuario Error correo
//	 */
//	@Test
//	public void testRegistrarUsuarioNapErrorCorreo() {
//		try{
//			DatosRegistro datos = new DatosRegistro();
//			datos.setNumeroAgente("1602075135");
//			datos.setNombre("Miguel");
//			datos.setApellidoPaterno("Hernandez");
//			datos.setApellidoMaterno("Rodriguez");
//			datos.setCelular("0987654321");
//			datos.setConfirmarCelular("0987654321");
//			datos.setCorreo("juan_071996@gmail.coms");
//			datos.setConfirmarCorreo("juan_071996@gmail.com");
//			datos.setPassword("123456789");
//			datos.setConfirmarPassword("123456789");
//			datos.setClaveAfore("556");
//			servicioRegistro.registrarUsuarioNap(datos, "usuario");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	/**
//	 * Test encargado de Validar Registro Usuario Error numero
//	 */
//	@Test
//	public void testRegistrarUsuarioNapErrorNumero() {
//		try{
//			DatosRegistro datos = new DatosRegistro();
//			datos.setNumeroAgente("1602075135");
//			datos.setNombre("Miguel");
//			datos.setApellidoPaterno("Hernandez");
//			datos.setApellidoMaterno("Rodriguez");
//			datos.setCelular("09876543");
//			datos.setConfirmarCelular("0987654321");
//			datos.setCorreo("juan_071996@gmail.coms");
//			datos.setConfirmarCorreo("juan_071996@gmail.com");
//			datos.setPassword("123456789");
//			datos.setConfirmarPassword("123456789");
//			datos.setClaveAfore("556");
//			servicioRegistro.registrarUsuarioNap(datos, "usuario");
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test de Alta usurio exitoso
//	 */
//	@Test
//	public void testRegistrarAltaUsuario(){
//		DatosRegistro datos = new DatosRegistro();
//		String rol1 = "01";
//		String rol2 = "03";
//		List<String> lista = new ArrayList<>();
//		lista.add(rol1);
//		lista.add(rol2);
//		datos.setNombre("JESUS");
//		datos.setApellidoPaterno("GONZALEZ");
//		datos.setApellidoMaterno("TORRES");
//		datos.setCelular("2431241008");
//		datos.setConfirmarCelular("2431241008");
//		datos.setCorreo("jose.gutierrez@gmail.com");
//		datos.setConfirmarCorreo("jose.gutierrez@gmail.com");
//		datos.setClaveAfore("556");
//		datos.setRoles(lista);
//		RespuestaServicio respuesta = servicioRegistro.registrarAltaUsuario(datos, "davidtol19@gmail.com", "556", Arrays.asList(UsuariosEnum.USUARIOS));
//		assertNotNull(respuesta);
//	}
//	
//	/**
//	 * Test de Alta usurio error
//	 */
//	@Test
//	public void testRegistrarAltaUsuarioBussiness(){
//		List<UsuariosEnum> lista = new ArrayList<>();
//		lista.add(UsuariosEnum.USUARIOS);
//
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNombre("JESUS");
//		datos.setApellidoPaterno("GONZALEZ");
//		datos.setApellidoMaterno("TORRES");
//		datos.setCelular("2431241008");
//		datos.setConfirmarCelular("2431241008");
//		datos.setCorreo("jose.gutierrez@gmail.com");
//		datos.setConfirmarCorreo("jose.gutierrez@gmail.com");
//		datos.setClaveAfore("556");
//		try{
//			servicioRegistro.registrarAltaUsuario(datos, "davidtol19@gmail.com", "556", lista);
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
//	
//	/**
//	 * Test de Alta usurio exitoso
//	 */
//	@Test
//	public void testRegistrarAltaUsuarioBussinessGeneric(){
//		List<UsuariosEnum> lista = new ArrayList<>();
//		lista.add(UsuariosEnum.USUARIOS);
//
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNombre("JESUS");
//		datos.setApellidoPaterno("GONZALEZ");
//		datos.setApellidoMaterno("TORRES");
//		datos.setCelular("24312");
//		datos.setConfirmarCelular("2431241008");
//		datos.setCorreo("jose.gutierrez@gmail.com");
//		datos.setConfirmarCorreo("jose.gutierrez@gmail.com");
//		datos.setClaveAfore("556");
//		try{
//			servicioRegistro.registrarAltaUsuario(datos, "davidtol19@gmail.com", "556", lista);
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//	}
	
	/**
	 * Test de Alta rest usurio error
	 */
	@Test
	public void testRegistrarUsuarioRestBussines(){
		DatosUsuario datos = new DatosUsuario();
		datos.setNickUsuario("124235234");
		datos.setNumeroAgente("1602075345");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1324567890");
		datos.setCorreo("ejemplo@gmail.com");
		datos.setClaveAfore("556");
		try{
			JsonUtilsImpl<DatosUsuario> json = new JsonUtilsImpl<>();
			String respuesta = json.parseObjectToJsonSC(datos);
			servicioRegistro.registrarUsuarioRest(respuesta, true);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test de Alta rest usurio error
	 */
//	@Test
//	public void testRegistrarUsuarioRest(){
//		DatosRegistro datos = new DatosRegistro();
//		datos.setNickUsuario("124235234");
//		datos.setNumeroAgente("1602075345");
//		datos.setNombre("Miguel");
//		datos.setApellidoPaterno("Hernandez");
//		datos.setApellidoMaterno("Rodriguez");
//		datos.setCelular("1234567890");
//		datos.setCorreo("ejemplo@gmail.com");
//		datos.setClaveAfore("556");
//		JsonUtilsImpl<DatosUsuario> json = new JsonUtilsImpl<>();
//		String respuesta = json.parseObjectToJsonSC(datos);
//		servicioRegistro.registrarUsuarioRest(respuesta);
//		}
	
	/**
	 * Test de Alta rest usurio error
	 */
	@Test
	public void testRegistrarUsuarioRestError(){
		DatosRegistro datos = new DatosRegistro();
		datos.setNumeroAgente("1602075345");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("0987654321");
		datos.setConfirmarCelular("0987654321");
		datos.setCorreo("juan_071996@gmail.com");
		datos.setConfirmarCorreo("juan_071996@gmail.com");
		datos.setPassword("123456789");
		datos.setConfirmarPassword("123456789");
		datos.setClaveAfore("556");
		try{
			servicioRegistro.registrarUsuarioRest(String.valueOf(datos), true);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test de Alta rest usurio error Exception
	 */
	@Test
	public void testRegistrarUsuarioRestException(){
		DatosUsuario datos = new DatosUsuario();
		datos.setNickUsuario("86785434567");
		datos.setNumeroAgente("9536853476347");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1324567890");
		datos.setCorreo("ejemplo@gmail.com");
		datos.setClaveAfore("556");
		try{
			servicioRegistro.registrarUsuarioRest(String.valueOf(datos), true);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
}