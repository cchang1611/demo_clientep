package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.util.ReflectionUtils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import com.github.tomakehurst.wiremock.matching.UrlPattern;


/**
 *
 * mock base test
 * 
 * @author jcgarces
 *
 */

public abstract class BaseMockTestCase  {

	/**
	 * Nombre de la variable de la ruta donde estan las propiedades
	 */
	private static final String VARIABLE_RUTA_PROPERTIES_LOG4J = "mx.com.procesar.configuracion.log4j2";

	/**
	 * Nombre del archivo de log4j que se tiene que cargar
	 */
	private static final String NOMBRE_ARCHIVO_LOG4J2 = "/log4j2/log4j2.properties";
	

	/**
	 * Constante File
	 */
	private static final String FILE = "file://";
	
	/**
	 * contenido
	 */
//	static {
//		System.setProperty("mx.com.procesar.configuracion.properties","src/test/resources");
//		System.setProperty("mx.com.procesar.configuracion.log4j2","src/test/resources");
//	}
	
	/**
	 * @throws java.lang.Exception
	 */
	static void setUpBeforeClass(WireMockServer wm) throws Exception {
		if(wm == null) {
			wm = new WireMockServer(options().port(9999));
		}
		if(!wm.isRunning()) {
			wm.start();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	static void tearDownAfterClass(WireMockServer wm) throws Exception {
		if(wm.isRunning()) {
			wm.stop();
		}
	}

	/**
	 * crear el stub 
	 * @param wm
	 * @param recurso
	 * @param codigo
	 * @param respuesta
	 */
	void crearStub(WireMockServer wm, String contexto,  String recurso, int codigo, String respuesta, RequestMethod requestMethod) {
		String urlPathMatching = new StringBuilder().append(contexto).append(recurso).toString();
		crearStub(wm, urlPathMatching, codigo, respuesta, requestMethod);
	}
	
	/**
	 * crear el stub
	 * @param wm
	 * @param contextoRecurso
	 * @param codigo
	 * @param respuesta
	 * @param requestMethod
	 */
	void crearStub(WireMockServer wm, String contextoRecurso, int codigo, String respuesta, RequestMethod requestMethod) {
		crearStub(wm, contextoRecurso, codigo, respuesta, requestMethod, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE);
	}
	
	void crearStubEq(WireMockServer wm, String contextoRecurso, int codigo, String respuesta, RequestMethod requestMethod) {
		crearStubEq(wm, contextoRecurso, codigo, respuesta, requestMethod, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE);
	}
	
	
	void crearStub(WireMockServer wm, String contextoRecurso, int codigo, byte[] respuesta, RequestMethod requestMethod,Hashtable<String,String> header) {
		crearStub(wm, contextoRecurso, codigo, respuesta, requestMethod, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE,header);
	}

	
	

	
	/**
	 * crea stub
	 * @param wm
	 * @param pathPattern
	 * @param codigo
	 * @param respuesta
	 * @param requestMethod
	 * @param requestContentType
	 * @param responseContentType
	 */
	void crearStub(WireMockServer wm, UrlPattern pathPattern, int codigo, String respuesta, RequestMethod requestMethod, String requestContentType, String responseContentType ){
		
		ResponseDefinitionBuilder mockResp;
		MappingBuilder mockReq;
		if(RequestMethod.GET.equals(requestMethod)) {
			mockReq = get(pathPattern);
		} else if(RequestMethod.POST.equals(requestMethod)) {
			mockReq = post(pathPattern);
		} else if(RequestMethod.PUT.equals(requestMethod)) {
			mockReq = put(pathPattern);
		} else if(RequestMethod.DELETE.equals(requestMethod)) {
			mockReq = delete(pathPattern);
		} else {
			throw new NullPointerException("Metodo Request invalido");
		}
		
		mockResp = aResponse().withStatus(codigo).withHeader("Content-Type", responseContentType);
		
		if(!RequestMethod.PUT.equals(requestMethod)) {
			mockResp = mockResp.withBody(respuesta);
		} else {
			mockResp = ResponseDefinitionBuilder.okForEmptyJson().withBody("OK");
		}
		wm.stubFor(mockReq.willReturn(mockResp));
		
	}
	
	
	/**
	 * crea stub
	 * @param wm
	 * @param pathPattern
	 * @param codigo
	 * @param respuesta
	 * @param requestMethod
	 * @param requestContentType
	 * @param responseContentType
	 */
	void crearStub(WireMockServer wm, UrlPattern pathPattern, int codigo, byte[] respuesta, RequestMethod requestMethod, String requestContentType, String responseContentType,Hashtable<String,String> header ){
		
		ResponseDefinitionBuilder mockResp = aResponse();
		MappingBuilder mockReq;
		if(RequestMethod.GET.equals(requestMethod)) {
			mockReq = get(pathPattern);
		} else if(RequestMethod.POST.equals(requestMethod)) {
			mockReq = post(pathPattern);
		} else if(RequestMethod.PUT.equals(requestMethod)) {
			mockReq = put(pathPattern);
		} else if(RequestMethod.DELETE.equals(requestMethod)) {
			mockReq = delete(pathPattern);
		} else {
			throw new NullPointerException("Metodo Request invalido");
		}
		
		//Agrega informacion al encabezado
		mockResp = agregarInfoHeader(mockResp,header);
		
		mockResp.withStatus(codigo).withHeader("Content-Type", responseContentType);
		//mockResp = aResponse().withHeader(ImagenConstants.CODIGO_ERROR, "");
		
		if(!RequestMethod.PUT.equals(requestMethod)) {
			mockResp = mockResp.withBody(respuesta);
		} else {
			mockResp = ResponseDefinitionBuilder.okForEmptyJson().withBody("OK");
		}
		wm.stubFor(mockReq.willReturn(mockResp));
		
	}
	
	private ResponseDefinitionBuilder agregarInfoHeader(ResponseDefinitionBuilder mockResp,Hashtable<String,String> header) {
		Enumeration<String> llaves = header.keys();
		while (llaves.hasMoreElements()) {
			String llave = llaves.nextElement();
			mockResp.withHeader(llave, header.get(llave));
		}
		
		return mockResp;
		
		
	}
	
	/**
	 * crear el stub 
	 * @param wm
	 * @param recurso
	 * @param codigo
	 * @param respuesta
	 */
	void crearStub(WireMockServer wm, String contextoRecurso, int codigo, String respuesta, RequestMethod requestMethod, String requestContentType, String responseContentType) {
		String urlPathMatching = new StringBuilder().append(contextoRecurso).toString();
		logger.info("url expuesta {}", urlPathMatching);
		UrlPattern urlPattern = urlPathMatching(urlPathMatching);
		crearStub(wm, urlPattern, codigo, respuesta, requestMethod, requestContentType, responseContentType);
	}
	
	/**
	 * Stub eq
	 * @param wm
	 * @param contextoRecurso
	 * @param codigo
	 * @param respuesta
	 * @param requestMethod
	 * @param requestContentType
	 * @param responseContentType
	 */
	void crearStubEq(WireMockServer wm, String contextoRecurso, int codigo, String respuesta, RequestMethod requestMethod, String requestContentType, String responseContentType) {
		String urlPathMatching = new StringBuilder().append(contextoRecurso).toString();
		logger.info("url expuesta {}", urlPathMatching);
		UrlPattern urlPattern = urlEqualTo(urlPathMatching);
		crearStub(wm, urlPattern, codigo, respuesta, requestMethod, requestContentType, responseContentType);
	}
	
	
	/**
	 * Stub eq
	 * @param wm
	 * @param contextoRecurso
	 * @param codigo
	 * @param respuesta
	 * @param requestMethod
	 * @param requestContentType
	 * @param responseContentType
	 * @param header
	 */
	void crearStub(WireMockServer wm, String contextoRecurso, int codigo, byte[] respuesta, RequestMethod requestMethod, String requestContentType, String responseContentType,Hashtable<String,String> header) {
		String urlPathMatching = new StringBuilder().append(contextoRecurso).toString();
		logger.info("url expuesta {}", urlPathMatching);
		UrlPattern urlPattern = urlEqualTo(urlPathMatching);
		crearStub(wm, urlPattern, codigo, respuesta, requestMethod, requestContentType, responseContentType, header);
	}

	
	/**
	 * usuario de pruebas
	 */
	public static final String USUARIO_MODIFICADOR = "USUARIO_PRUEBAS"; 
	
	/**
	 * logger
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Ruta donde se encuentra el archivo zip a validar.
	 */
	protected java.lang.String RUTA = new StringBuilder(
			"src/test/resources/nist/").toString();


	
	/**
	 * contexto de spring
	 */
	protected ApplicationContext applicationContext;

	/**
	 * carga el contexto
	 * 
	 * @return
	 */
	protected ApplicationContext cargaContexto() {
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
			applicationContext.register(
					mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest.class,
					mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest.class
					);
			applicationContext.refresh();
		return applicationContext;
	}

	
	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			try{
				applicationContext = cargaContexto();
			}catch(Exception e){
				applicationContext = cargaContexto();
			}
		}
		return applicationContext;
	}

	/**
	 * recupera el bean indicad del contexto
	 * @param nombreBean
	 * @return
	 */
	protected Object obtenerBean(String nombreBean){
		return getApplicationContext().getBean(nombreBean);
	}
	
	/**
	 * cambia el valor de una propiedad
	 * @param nombreAtributo
	 * @param instancia
	 * @param valor
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	protected void cambiaValor(String nombreAtributo, Object instancia, Object valor) {
		Field atributo;
		try {
			try{
				atributo = ReflectionUtils.findField(instancia.getClass(), nombreAtributo);
			} catch (Exception e1){
				atributo = instancia.getClass().getDeclaredField(nombreAtributo);
			}
			
			ReflectionUtils.makeAccessible(atributo);
			ReflectionUtils.setField(atributo, instancia, valor);
		} catch (Exception e) {
			logger.error("no se a podido cambiar el valor ", e);
		}
		
	}
 
	
	/**
	 * obtiene el string base64 del zip
	 * @return
	 * @throws IOException 
	 */
	protected String obtenerArchivoZip(String nombre, String directorio) throws IOException {
		Path path = Paths.get(directorio, nombre);
		path = path.toAbsolutePath();
		byte[] bytes= Files.readAllBytes(path);
		return Base64Utils.encodeToString(bytes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() throws Exception {
		LoggerContext context = (LoggerContext)LogManager.getContext(false);
		StringBuilder rutaPropiedades = new StringBuilder();
		String path = Paths.get(System.getProperty(VARIABLE_RUTA_PROPERTIES_LOG4J)).toAbsolutePath().toFile().getAbsolutePath().replace("\\", "/");
		rutaPropiedades.append(FILE);
		rutaPropiedades.append("/").append(path);
		
		rutaPropiedades.append(NOMBRE_ARCHIVO_LOG4J2);
		context.setConfigLocation(URI.create(rutaPropiedades.toString().replace(" ", "%20")));
		
		logger.info("log4j2 configuration file reconfigured: {}", rutaPropiedades);
		context.reconfigure();

	}


	
	/**
	 * convertir el sip en base64. se usa pen locales solamente
	 */	
	public void testConvierteBase64(String nombre, String directorio) {
		try {
			String base64 = obtenerArchivoZip(nombre, directorio);
			Path path = Paths.get(directorio, nombre.concat(".txt"));
			Files.write(path, base64.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
		} catch (IOException e) {
			logger.error("no se ha podido leer el archivo zip {}", e);
			fail("no se ha podido leer el archivo zip");
		}
	}
	
	

}
