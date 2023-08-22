package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionTramitesServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BitacoraEntradaImpresionEnvio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Permanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * ReimpresionTramitesServiceTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionTramitesServiceTestCase {
	
	/**
	 * reimpresionService
	 */
	@InjectMocks
	private ReimpresionTramitesService reimpresionService =new ReimpresionTramitesServiceImpl();

	/**
	 * restServiceClientUtils
	 */
	@Mock
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * dependencia utilidad validador
	 */
	@Mock
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * Dependencia utileria cadena
	 */
	@Mock
	private CadenasUtils cadenasUtils;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(reimpresionService,"urlComunes","http://lbint-devl.procesar.net/comunesPulssar/");
		ReflectionTestUtils.setField(reimpresionService,"urlTransaccional","http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/");
		
	}
	
	/**
	 * testObtenerPdfPorClave
	 * @throws IOException
	 */

	@Test
	public void testObtenerPdfPorClaveEnrolamiento () {	
		DatosArchivos datosArchivos = reimpresionService.obtenerPdfPorClave(salida(), 1);
		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testObtenerPdfPorClaveModificador
	 * @throws IOException
	 */

	@Test
	public void testObtenerPdfPorClaveModificador () {	
		DatosArchivos datosArchivos = reimpresionService.obtenerPdfPorClave(salida2(), 2);
		Assert.assertNotNull(datosArchivos);
	}
	
	
	/**
	 * testObtenerPdfPorClaveModificador
	 * @throws IOException
	 */

	@Test
	public void testGuardarBitacoraImpresionEnvio () {	
		Mockito.when(
				restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(BitacoraEntradaImpresionEnvio.class), Mockito.eq(String.class)))
				   .thenReturn(respuesta());
		reimpresionService.guardarBitacoraImpresionEnvio("ok","ok","1", "121");
	}
	
	/**
	 * testGuardarBitacoraImpresionEnvioNull
	 * @throws IOException
	 */

	@Test
	public void testGuardarBitacoraImpresionEnvioNull () {	
		try {
			Mockito.when(
					restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(BitacoraEntradaImpresionEnvio.class), Mockito.eq(String.class)))
					   .thenThrow(NullPointerException.class);
			reimpresionService.guardarBitacoraImpresionEnvio( "ok","ok","ok", "adas");	
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}		
	}
	
	/**
	 * testGuardarBitacoraImpresionEnvioNull
	 * @throws IOException
	 */

	@Test
	public void testObtenerTipoClaveDocumento () {	
		String salida=reimpresionService.obtenerTipoClaveDocumento(1);	
		Assert.assertNotNull(salida);		
	}

	
	/**
	 * testObtenerTramitesConcluidos
	 * @throws IOException
	 */
	@Test
	public void testObtenerTramitesConcluidos () {	
	
			Mockito.when(
					restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(TramitesConcluidosEntrada.class), Mockito.eq(TramitesConcluidos.class)))
					   .thenReturn(tCocnluidos());
			TramitesConcluidos tramitesConcluidos=reimpresionService.obtenerTramitesConcluidos(tramitesConcluidos());	
			Assert.assertNotNull(tramitesConcluidos);
				
	}
	
	/**
	 * tCocnluidos
	 * @return
	 */
	private TramitesConcluidos tCocnluidos() {
		TramitesConcluidos tramitesConcluidos = new TramitesConcluidos();
		tramitesConcluidos.setIdTramite(1L);
		return tramitesConcluidos;
	}

	/**
	 * testObtenerTramitesConcluidos
	 * @throws IOException
	 */
	@Test
	public void testObtenerTramitesConcluidosNull () {	
		try {
			Mockito.when(
					restServiceClientUtils.ejecutarServicioPost(Mockito.anyString(),Mockito.any(TramitesConcluidosEntrada.class), Mockito.eq(TramitesConcluidos.class)))
					   .thenThrow(NullPointerException.class);
			reimpresionService.obtenerTramitesConcluidos(tramitesConcluidos());	
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}		
	}
	
	/**
	 * testObtenerTramitesConcluidos
	 * @throws IOException
	 */
	@Test
	public void testConvertirJsonObjeto () {	

		Permanencia salida=reimpresionService.convertirJsonObjeto(respuestaJson(),Permanencia.class);	
		Assert.assertNotNull(salida);
	}
	
	/**
	 * testConvertirJsonObjetoNull
	 * @throws IOException
	 */
	@Test
	public void testConvertirJsonObjetoNull () {	

		try{
			reimpresionService.convertirJsonObjeto(respuestaJson2(),Permanencia.class);	
		}catch(Exception e) {
			Assert.assertNotNull(e);
		}
		
	}
	
	/**
	 * testObtenerMensajeSinDatos
	 * @throws IOException
	 */
	@Test
	public void testObtenerMensajeSinDatos () {	
		DatosArchivos datosArchivos=reimpresionService.obtenerMensajeSinDatos();
		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testObtenerMensajeSinRespuestaAfore
	 * @throws IOException
	 */
	@Test
	public void testObtenerMensajeSinRespuestaAfore () {	
		DatosArchivos datosArchivos=reimpresionService.obtenerMensajeSinRespuestaAfore();
		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testConvertirObjetoToJson
	 * @throws IOException
	 */
	@Test
	public void testConvertirObjetoToJson () {	
		String datosArchivos=reimpresionService.convertirObjetoToJson(tramitesConcluidos());
		Assert.assertNotNull(datosArchivos);
	}
	
	/**
	 * testConvertirObjetoToJson
	 * @throws IOException
	 */
	@Test
	public void testConvertirObjetoToJsonNull () {	
		try{
			reimpresionService.convertirObjetoToJson(null);
		}catch(Exception e) {
			Assert.assertNotNull(e);	
		}
		
	}
	
	/**
	 * testConvertirObjetoToJson
	 * @throws IOException
	 */
	@Test
	public void testProcesoConcluidoReinpresion () {	
		
		ResponseEntity<RespuestaReimpresion> response=new ResponseEntity<>(new RespuestaReimpresion(),HttpStatus.OK);
		Mockito.when(
				cadenasUtils.obtenerCadenaConcatenada(Mockito.anyBoolean(),Mockito.anyString(), Mockito.anyString()))
				   .thenReturn("http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/reimpresionDocumentos/guardarTramiteConcluidoReimpresion");
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),Mockito.any(HttpEntity.class),Mockito.eq(RespuestaReimpresion.class)))
				   .thenReturn(response);
		RespuestaReimpresion respuestaReimpresion=reimpresionService.registraProcesoConcluidoReinpresion(tCocnluidos());
		
		Assert.assertNotNull(respuestaReimpresion);
	}
	
	/**
	 * testProcesoConcluidoReinpresionThrow
	 * @throws IOException
	 */
	@Test
	public void testProcesoConcluidoReinpresionThrow () {	
		Mockito.when(
				cadenasUtils.obtenerCadenaConcatenada(Mockito.anyBoolean(),Mockito.anyString(), Mockito.anyString()))
				   .thenReturn("http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/reimpresionDocumentos/guardarTramiteConcluidoReimpresion");
		Mockito.when(
				restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),Mockito.any(HttpEntity.class),Mockito.eq(RespuestaReimpresion.class)))
				   .thenThrow(HttpClientErrorException.class);
		RespuestaReimpresion respuestaReimpresion=reimpresionService.registraProcesoConcluidoReinpresion(tCocnluidos());
		
		Assert.assertNull(respuestaReimpresion);
	}
	
	/**
	 * respuesta
	 * @return
	 */
	private String respuestaJson() {
		return "{\"folioCliente\":\"S0000469202109300005\",\"selloVoluntadTrabajador\":\"767765764654667\",\"cuerpo\":{\"entidadOrigen\":\"568\",\"curpTrabajador\":\"COAJ940708HSLRRR06\",\"nssTrabajador\":\"28169483824\",\"rfc\":\"COAJ940708TI9\",\"apellidoPaterno\":\"CORDERO\",\"apellidoMaterno\":\"ARMENTA\",\"nombreTrabajador\":\"JORDAN ULISES\",\"fechaDeNacimiento\":\"19940708\",\"genero\":1,\"entidadFederativaDeNacimiento\":\"25\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"11\",\"actividadOGiroNegocioTrabajador\":\"05\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"COAJ940708HSLRRR06\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"OTOMIES\",\"numeroExterior\":\"2380\",\"colonia\":\"INDUSTRIAL EL PALMITO\",\"delegacionOMunicipio\":\"CULIACAN\",\"codigoPostal\":\"80160\",\"entidadFederativa\":\"SINALOA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"6731074246\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"0000000000\",\"correoElectronicoDelTrabajador\":\"JCORDERO@aforecoppel.com\",\"claveEntidad\":\"SL\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"ANGULO\",\"apellidoMaternoDeBeneficiario\":\"LEON\",\"nombreDeBeneficiario\":\"SANDRA ISABEL\",\"curpDeBeneficiario\":\"AULS910520MSLNNN07\",\"parentescoORelacion\":\"15\",\"porcentajeDeBeneficiario\":\"50\"},{\"apellidoPaternoDeBeneficiario\":\"DE LUNA\",\"apellidoMaternoDeBeneficiario\":\"PRADO\",\"nombreDeBeneficiario\":\"ELIZABETH GUADALUPE\",\"curpDeBeneficiario\":\"LUPE760702MNLNRL05\",\"parentescoORelacion\":\"20\",\"porcentajeDeBeneficiario\":\"50\"}]}}}";
		
	}
	
	/**
	 * respuesta
	 * @return
	 */
	private String respuestaJson2() {
		return "{\"folioCliente\":\"lloVoluntadTrabajador\":\"767765764654667\",\"cuerpo\":{\"entidadOrigen\":\"568\",\"curpTrabajador\":\"COAJ940708HSLRRR06\",\"nssTrabajador\":\"28169483824\",\"rfc\":\"COAJ940708TI9\",\"apellidoPaterno\":\"CORDERO\",\"apellidoMaterno\":\"ARMENTA\",\"nombreTrabajador\":\"JORDAN ULISES\",\"fechaDeNacimiento\":\"19940708\",\"genero\":1,\"entidadFederativaDeNacimiento\":\"25\",\"nacionalidad\":\"MEX\",\"ocupacionOProfesionTrabajador\":\"11\",\"actividadOGiroNegocioTrabajador\":\"05\",\"nivelDeEstudioTrabajador\":\"03\",\"curpSolicitante\":\"COAJ940708HSLRRR06\",\"tipoSolicitante\":\"01\",\"datosParticulares\":{\"calle\":\"OTOMIES\",\"numeroExterior\":\"2380\",\"colonia\":\"INDUSTRIAL EL PALMITO\",\"delegacionOMunicipio\":\"CULIACAN\",\"codigoPostal\":\"80160\",\"entidadFederativa\":\"SINALOA\",\"pais\":\"MEX\",\"indicadorDeTelefono1\":\"000\",\"telefono1\":\"6731074246\",\"indicadorDeTelefono2\":\"000\",\"telefono2\":\"0000000000\",\"correoElectronicoDelTrabajador\":\"JCORDERO@aforecoppel.com\",\"claveEntidad\":\"SL\"},\"beneficiarios\":{\"beneficiario\":[{\"apellidoPaternoDeBeneficiario\":\"ANGULO\",\"apellidoMaternoDeBeneficiario\":\"LEON\",\"nombreDeBeneficiario\":\"SANDRA ISABEL\",\"curpDeBeneficiario\":\"AULS910520MSLNNN07\",\"parentescoORelacion\":\"15\",\"porcentajeDeBeneficiario\":\"50\"},{\"apellidoPaternoDeBeneficiario\":\"DE LUNA\",\"apellidoMaternoDeBeneficiario\":\"PRADO\",\"nombreDeBeneficiario\":\"ELIZABETH GUADALUPE\",\"curpDeBeneficiario\":\"LUPE760702MNLNRL05\",\"parentescoORelacion\":\"20\",\"porcentajeDeBeneficiario\":\"50\"}]}}}";
		
	}
	
	/**
	 * tramitesConcluidos
	 * @return
	 */
	private TramitesConcluidosEntrada tramitesConcluidos() {
		TramitesConcluidosEntrada tramitesConcluidosEntrada = new TramitesConcluidosEntrada();
		tramitesConcluidosEntrada.setAfore("552");
		tramitesConcluidosEntrada.setCurp("klsklkslkslk");
		return tramitesConcluidosEntrada;
	}

	/**
	 * salida
	 * @return
	 */
	private List<DatosArchivos> salida() {
		List<DatosArchivos> lista= new ArrayList<>();
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setNombreArchivo("DQJHDWJHDKJWHDJWEHDKWDJ662WEJKEWJ");
		datosArchivos.setByteArchivo("prueba3");
		datosArchivos.setFormato("pdf");
		lista.add(datosArchivos);
		return lista;
	}
	
	/**
	 * salida
	 * @return
	 */
	private List<DatosArchivos> salida2() {
		List<DatosArchivos> lista= new ArrayList<>();
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setNombreArchivo("DQJHDWJHDKJWHDJWEHDKWDJ669WEJKEWJ");
		datosArchivos.setByteArchivo("prueba3");
		datosArchivos.setFormato("pdf");
		lista.add(datosArchivos);
		return lista;
	}

	/**
	 * respuesta
	 * @return
	 */
	private String respuesta() {
		return "[{\"chNombreArchivo\":\"consentimiento\"}]";
		
	}
		

}
