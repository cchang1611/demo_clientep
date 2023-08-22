/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VerificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.VerificacionServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PeticionTomaHuellaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test de la clase Verificacion Service
 * @author dhernand
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, 
		PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class VerificacionServiceTestCase extends TestCase {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(VerificacionServiceTestCase.class);
	
	/**
	 * Servicio a probar
	 */
	@Autowired
	@InjectMocks
	private VerificacionService verificacionService = new VerificacionServiceImpl();
	
	/**
	 * Cliente rest adminisrdo por mockito.
	 */
	@Mock
	private FolioService folioService;
	
	/**
	 * Mock para el tueno del repositorio.
	 */
	@Mock
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {		
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * <p>
	 * Permite probar el happy path de la construcción de la respuesta para
	 * consulta de Administracion de Turnos registrados.
	 * </p>
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	public void testGenerarPeticionUnaHuella() {
		
		UsuarioLogin user = new UsuarioLogin();
		user.setCurpAgente("CURPAGENTE");
		Folio folio = new Folio();
		folio.setChFolio("FOLIO");
		
		PeticionTomaHuellaCoppel peticion = verificacionService.generarPeticionUnaHuella(user,folio);
		
		peticion.setCurp(user.getCurpAgente());
		peticion.setNss("");
		peticion.setFolioProcesar(folio.getChFolio());
		peticion.setTipoPersona(PeticionTomaHuellaCoppel.EMPLEADO);
		peticion.setTipoToma(PeticionTomaHuellaCoppel.UN_DEDO);
		
		assertEquals(user.getCurpAgente(),peticion.getCurp());
		assertEquals("",peticion.getNss());
		assertEquals(folio.getChFolio(),peticion.getFolioProcesar());
		assertEquals(PeticionTomaHuellaCoppel.UN_DEDO,peticion.getTipoToma());
		assertEquals(PeticionTomaHuellaCoppel.EMPLEADO,peticion.getTipoPersona());
	}
	
	/**
	 * Test para obtener el folio
	 */
	@Test
	public void testObtenerFolioHijo() {
		UsuarioLogin user = new UsuarioLogin();
		user.setCurpAgente("CURPAGENTE");
		user.setDatoUsuario(1l);
		
		when(folioService.llenarObjetoFolioEntrada(anyString(),nullable(String.class),anyString(),anyString(),anyString())).thenReturn(new FolioEntrada());
		when(folioService.obtenerFolio(any(FolioEntrada.class), anyLong(),anyString(),anyString(),anyString())).thenReturn(new Folio());
		
		Folio folioHijo = verificacionService.obtenerFolioHijo(user);
		assertNotNull(folioHijo);
	}
	
	
	/**
	 * Test para obtener el folio
	 */
	@Test
	public void testValidaEmpleadoVistaJson() {
		
		Folio folio = new Folio();
		folio.setChFolio("FOLIO");
		UsuarioLogin user = new UsuarioLogin();
		user.setCurpAgente("CURPAGENTE");
		user.setDatoUsuario(1l);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"huellaDactilar\":");
		sb.append("[{ ");
		sb.append("\"idDedo\":\"1\",");
		sb.append("\"huella64\":\"1\",");
		sb.append("\"huellaHash\":\"1\",");
		sb.append("\"resolucionCaptura\":\"1\",");
		sb.append("\"algoritmoCompresion\":\"1\",");
		sb.append("\"unidadesEscala\":\"1\",");
		sb.append("\"calidadHuella\":\"1\",");
		sb.append("\"motivoSinHuella\":\"1\",");
		sb.append("\"codigoFaltaDedo\":\"1\",");
		sb.append("\"idDevice\":\"1304-00458\",");
		sb.append("\"tipoPersona\":\"1\",");
		sb.append("\"fechaCaptura\":\"2020-02-14T16:04:44.585-06:00\",");
		sb.append("\"perfilAdquisicionHuella\":\"45\"");
		sb.append("}]");
		sb.append("}");
		
		Expediente expediente = new Expediente();		
		//expediente.setImagen(sb.toString());
		
		when(servicioArchivos.enviarArchivoRecepcion(any(Folio.class), any(Archivos.class),anyString(),anyString())).thenReturn(new RespuestaServicio());
		
		try {
			RespuestaServicio folioHijo = verificacionService.validaEmpleadoVistaJson(folio,user,expediente);
			assertNotNull(folioHijo);
		} catch (Exception e) {
			logger.error("Error:",e);
			fail();
		}
	}

}
