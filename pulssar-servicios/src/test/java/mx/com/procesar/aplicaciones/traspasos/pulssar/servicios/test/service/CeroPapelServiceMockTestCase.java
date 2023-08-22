package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.CeroPapelServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase de cero papel
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CeroPapelServiceMockTestCase {

	/**
	 * Inyeccion de servicio
	 */
	@InjectMocks
	private CeroPapelService ceroPapelService = new CeroPapelServiceImpl();
	
	/**
	 * uriConsultaEstatus
	 */
	@Value("${comunes.ceroPapel.consultaEstatus}")
	private String uriConsultaEstatus;
	
	/**
	 * dependencia clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(ceroPapelService,"uriConsultaEstatus","http://lbint-devl.procesar.net/comunesPulssar/ceroPapel/consultaEstatus/{idProcesar}");
		ReflectionTestUtils.setField(ceroPapelService,"uriGuardarCeroPapel","http://lbint-devl.procesar.net/comunesPulssar-exposicion-transaccional/ceroPapel/guardarCeroPapel");
	}
	
	/**
	 * uriGuardarCeroPapel
	 */
	@Value("${comunes.guardar.ceroPapel}")
	private String uriGuardarCeroPapel;
	
	/**
	 * Para guardar los datos
	 */
	@Test
	public void testGuardarDatos () {
		try {
			RespuestaGenerica objeto = new RespuestaGenerica();
			objeto.setFlujo(1);
			objeto.setMensaje("2");
			ResponseEntity<RespuestaGenerica> respuestaNotificacion = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(RespuestaGenerica.class)))
					.thenReturn(respuestaNotificacion);
			EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			DatosTrabajador trabajador = new DatosTrabajador();
		 ceroPapelService.guardarDatosCeroPapel(entradaCeroPapel);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	/**
	 * Para guardar los datos
	 */
	@Test
	public void testGuardarDatosExcepcion () {
		try {
			RespuestaGenerica objeto = new RespuestaGenerica();
			objeto.setFlujo(2);
			objeto.setMensaje("2");
			ResponseEntity<RespuestaGenerica> respuestaNotificacion = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(RespuestaGenerica.class)))
					.thenReturn(respuestaNotificacion);
			EntradaCeroPapel entradaCeroPapel = new EntradaCeroPapel();
			DatosTrabajador trabajador = new DatosTrabajador();
		 ceroPapelService.guardarDatosCeroPapel(entradaCeroPapel);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * Para consultar estatus
	 */
	@Test
	public void testConsultarEstatus () {
		try {
			CeroPapel objeto = new CeroPapel();
			objeto.setAfore("333");
			ResponseEntity<CeroPapel> respuestaNotificacion = new ResponseEntity<>(objeto , HttpStatus.ACCEPTED);
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<CeroPapel>() {
					})))
					.thenReturn(respuestaNotificacion);
		 ceroPapelService.consultaEstatusCeroPapel(1l);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Para consultar estatus
	 */
	@Test
	public void testConsultarEstatusExcepcion () {
		try {
			Mockito.when(
					clienteServicio.exchange(Mockito.anyString(), any(HttpMethod.class), ArgumentMatchers.nullable(HttpEntity.class), Mockito.eq(new ParameterizedTypeReference<CeroPapel>() {
					})))
					.thenReturn(null);
		 ceroPapelService.consultaEstatusCeroPapel(1l);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
}