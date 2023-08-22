package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionesTotalesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.DisposicionesTotalesServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizConvivencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProceso;

/**
 * Test para la validacion de marcas
 * 
 * @author ANOSORIO
 *
 */
public class DisposicionesTotalesServiceTestCase {

	/**
	 * Inyeccion service
	 */
	@InjectMocks
	private DisposicionesTotalesService disposicionService = new DisposicionesTotalesServiceImpl();

	/**
	 * restTemplate
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test que valida marcas operativas
	 */
	@Test
	public void testValidarMarcaOperativa() {
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ParametrosSalidaMarca.class)))
				.thenReturn(null);

		DatosExpediente datosExpediente = new DatosExpediente();
		datosExpediente.setBanderaExpedienteIdentifiacion(3);
		datosExpediente.setBanderaEnrolamiento(5);
		ArrayList<String> claves = new ArrayList<>();
		claves.add("1601");
		boolean validaMarca = disposicionService.validarMarcaOperativa(63l, datosExpediente, claves);
		assertNotNull(validaMarca);
	}

	/**
	 * Test que valida marcas operativas con Error
	 */
	@Test
	public void testValidarMarcaOperativaError() {
		DatosExpediente datosExpediente = new DatosExpediente();

		ArrayList<String> claves = new ArrayList<>();
		try {
			boolean validaMarca = disposicionService.validarMarcaOperativa(null, datosExpediente, claves);
			assertNotNull(validaMarca);
		} catch (RestClientException e) {
			assertNull(e);
		}
	}

	/**
	 * Test excepcion marcas
	 */
	@Test
	public void testValidarMarcaOperativaExcepcion() {
		ParametrosSalidaMarca marcas = new ParametrosSalidaMarca();
		marcas.setClaveProceso("R");
		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(ParametrosSalidaMarca.class)))
				.thenReturn(marcas);

		DatosExpediente datosExpediente = new DatosExpediente();
		datosExpediente.setBanderaExpedienteIdentifiacion(6);
		datosExpediente.setBanderaEnrolamiento(4);
		ArrayList<String> claves = new ArrayList<>();
		claves.add("2");
		try {
			boolean validaMarca = disposicionService.validarMarcaOperativa(12l, datosExpediente, claves);
			assertNotNull(validaMarca);
		} catch (RestClientException e) {
			assertNull(e);
		}
	}

	/**
	 * Test que valida marcas operativas
	 */
	@Test
	public void testValidarMarcaOperativaExpediente() {
		List<MatrizConvivencia> body = new ArrayList<>();
		ResponseEntity<List<MatrizConvivencia>> value = new ResponseEntity<List<MatrizConvivencia>>(body,
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.any(RequestEntity.class),
				Mockito.eq(new ParameterizedTypeReference<List<MatrizConvivencia>>() {
				}))).thenReturn(value);

		DatosExpediente datosExpediente = new DatosExpediente();
		datosExpediente.setBanderaExpedienteIdentifiacion(3);
		datosExpediente.setBanderaEnrolamiento(5);
		ArrayList<String> claves = new ArrayList<>();
		claves.add("1601");
		boolean validaMarca = disposicionService.validarMarcaOperativaExpediente(63l, datosExpediente, claves);
		assertNotNull(validaMarca);
	}

	/**
	 * Test que valida marcas operativas
	 */
	@Test(expected = BusinessException.class)
	public void testValidarMarcaOperativaExpedienteError() {

		List<MatrizConvivencia> body = new ArrayList<>();
		MatrizConvivencia e = new MatrizConvivencia();
		TipoProceso tipoProcesoActual = new TipoProceso();
		tipoProcesoActual.setDescripcion("descripcion");
		e.setTipoProcesoActual(tipoProcesoActual);
		body.add(e);
		ResponseEntity<List<MatrizConvivencia>> value = new ResponseEntity<List<MatrizConvivencia>>(body,
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(Mockito.any(RequestEntity.class),
				Mockito.eq(new ParameterizedTypeReference<List<MatrizConvivencia>>() {
				}))).thenReturn(value);
		DatosExpediente datosExpediente = new DatosExpediente();
		datosExpediente.setBanderaExpedienteIdentifiacion(6);
		datosExpediente.setBanderaEnrolamiento(4);
		ArrayList<String> claves = new ArrayList<>();
		claves.add("2");
		boolean validaMarca = disposicionService.validarMarcaOperativaExpediente(63l, datosExpediente, claves);
		assertNotNull(validaMarca);
	}
}
