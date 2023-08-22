package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NotificacionExpedienteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurpSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioLaboralTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosReferenciasTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DomicilioLaboral;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Test para validar notificacion expediente service
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class NotificacionExpedienteServiceTestCase {
	
	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private NotificacionExpedienteService notificacionService = new NotificacionExpedienteServiceImpl();
	
	@Autowired
	@Mock
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de dependencia validadorUtils
	 */
	@Mock
	private ValidadorUtils validadorUtils;
    
	/**
	 * Inyeccion de servicio catalgoo
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
	 * Test envio notificacion actualiza 
	 */
	@Test
	public void testEnvioNotificacionActualiza() {
		DatosBaseCurpSalida datosBaseSalida = new DatosBaseCurpSalida();
		datosBaseSalida.setDiagnosticoDeRecepcion("G000000000000");
		DatosDomicilioParticularTrabajadorSalida particularsalida = new DatosDomicilioParticularTrabajadorSalida();
		particularsalida.setDiagnosticoDeRecepcion("G000000000000");
		DatosDomicilioLaboralTrabajadorSalida laboralSalida = new DatosDomicilioLaboralTrabajadorSalida();
		laboralSalida.setDiagnosticoDeRecepcion("G000000000000");
		DatosReferenciasTrabajadorSalida referenciaSalida = new DatosReferenciasTrabajadorSalida();
		referenciaSalida.setDiagnosticoDeRecepcion("G000000000000");
		ListaBeneficiariosTrabajadorSalida objetoBeneSalida = new ListaBeneficiariosTrabajadorSalida();
		DatosBeneficiarioTrabajadorSalida beneSalida = new DatosBeneficiarioTrabajadorSalida();
		beneSalida.setDiagnosticoDeRecepcion("G000000000000");
		List<DatosBeneficiarioTrabajadorSalida> listaBeneSalida = new ArrayList<>();
		listaBeneSalida.add(beneSalida);
		objetoBeneSalida.setBeneficiario(listaBeneSalida);
		DatosSalidaModificacion objetoRespuesta = new DatosSalidaModificacion();
		objetoRespuesta.setDatosBaseCurp(datosBaseSalida);
		objetoRespuesta.setDatosDomicilioParticularTrabajador(particularsalida);
		objetoRespuesta.setDatosDomicilioLaboralTrabajador(laboralSalida);
		objetoRespuesta.setDatosReferenciasTrabajador(referenciaSalida);
		objetoRespuesta.setListaBeneficiariosTrabajador(objetoBeneSalida);
		SalidaActualizaDatos salidaActualizaDatos = new SalidaActualizaDatos();
		salidaActualizaDatos.setObjetoRespuesta(objetoRespuesta);
		
		DatosCertificables certificable = new DatosCertificables();
		certificable.setCurp(" ");
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setDatosCertificables(certificable);
		Folio folio = new Folio();
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"fechaNotificacion\":\"2020-12-02T06:00:00.000+0000\",\"motivoRechazo\":\"000\"}" , HttpStatus.ACCEPTED);

		
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		notificacionService.envioNotificacionActualiza(salidaActualizaDatos, datosTrabajador, folio,new FlujoModificacion());
			
		
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		notificacionService.envioNotificacionActualiza(salidaActualizaDatos, datosTrabajador, folio,new FlujoModificacion());
		
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		notificacionService.envioNotificacionActualiza(salidaActualizaDatos, datosTrabajador, folio,new FlujoModificacion());
		
		objetoRespuesta.setDatosDomicilioParticularTrabajador(null);
		objetoRespuesta.setDatosDomicilioLaboralTrabajador(null);
		objetoRespuesta.setDatosReferenciasTrabajador(null);
		objetoRespuesta.setListaBeneficiariosTrabajador(null);
		Mockito.when(validadorUtils.isEmpty(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		notificacionService.envioNotificacionActualiza(salidaActualizaDatos, datosTrabajador, folio,new FlujoModificacion());
	}
	
	/**
	 * test para envio notificacion permanencia
	 */
	@Test
	public void testEnvioNotificacionPermanencia() {
		
		DatosSalidaPermanencia salidaPermanencia = new DatosSalidaPermanencia();
		salidaPermanencia.setDiagnosticoDeRecepcion("G00000000");
		DatosParticulares particulares = new DatosParticulares();
		DomicilioLaboral laboral = new DomicilioLaboral();
		Referencias referencias = new Referencias();
		
		DatosBeneficiarioTrabajador beneficiariosTrabajador = new DatosBeneficiarioTrabajador();
		List<DatosBeneficiarioTrabajador> listaBene = new ArrayList<>();
		listaBene.add(beneficiariosTrabajador);
		Beneficiarios bene = new Beneficiarios();
		bene.setBeneficiario(listaBene);
		EntradaPermanencia entradaPermanencia = new EntradaPermanencia();
		entradaPermanencia.setDatosParticulares(particulares);
		entradaPermanencia.setDomicilioLaboral(laboral);
		entradaPermanencia.setReferencias(referencias);
		entradaPermanencia.setBeneficiarios(bene);
		Folio folio = new Folio();
		Parametro parametro = new Parametro();
		parametro.setChValorParametro("!");
		
		List<Parametro> listaParametro = new ArrayList<>();
		listaParametro.add(parametro);
		
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":\"000\"}" , HttpStatus.ACCEPTED);

		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		notificacionService.envioNotificacionPermanencia(salidaPermanencia, entradaPermanencia, folio,new FlujoModificacion());
	
		entradaPermanencia.setDatosParticulares(null);
		entradaPermanencia.setDomicilioLaboral(null);
		entradaPermanencia.setReferencias(null);
		entradaPermanencia.setBeneficiarios(null);
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		notificacionService.envioNotificacionPermanencia(salidaPermanencia, entradaPermanencia, folio,new FlujoModificacion());
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(null);
		notificacionService.envioNotificacionPermanencia(salidaPermanencia, entradaPermanencia, folio,new FlujoModificacion());
		
		Mockito.when(servicioCatalogo.obtenerParametro(Mockito.anyString(), Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(validadorUtils.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.TRUE);
		Mockito.when(validadorUtils.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(restTemplate.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		notificacionService.envioNotificacionPermanencia(salidaPermanencia, entradaPermanencia, folio,new FlujoModificacion());
	}
	
	/**
	 * Test para eliminar acentos
	 */
	@Test
	public void testEliminarAcentos() {
		notificacionService.eliminarAcentos("Entrada", "!");
		
		notificacionService.eliminarAcentos("Entradá", "!");

	}

}	
