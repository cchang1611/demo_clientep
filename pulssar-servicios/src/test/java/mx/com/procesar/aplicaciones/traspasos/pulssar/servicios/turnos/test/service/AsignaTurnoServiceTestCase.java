package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableList;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AsignaTurnoService;

/**
 * Clase de prueba para comprobar las operaciones para el servicio
 * {@link AsignaTurnoService}.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
public class AsignaTurnoServiceTestCase extends BaseTestCase {

	/**
	 * Servicio a probar.
	 */
	@Autowired
	private AsignaTurnoService asignaTurnoService;
	
	/**
	 * Cliente rest adminisrdo por mockito.
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * Permite probar el happy path para el registro de un trabajador Sin Cita.
	 */
	@Test
	@Ignore

	@Rollback
	@SuppressWarnings("unchecked")
	public void testCrearCita() {

		AdministracionTurno asignaTurno = new AdministracionTurno();

		asignaTurno.setClaveOrganizacion("552");
		asignaTurno.setIdUsuario(127L);
		asignaTurno.setNumeroSucursal("1000000000000000");
		asignaTurno.setIndicadorTipoCita(1);

		asignaTurno.setNombre("ISAIAS NEFTALI");
		asignaTurno.setApellidoPaterno("TORRES");
		asignaTurno.setApellidoMaterno("ANGEL");
		asignaTurno.setCurp("TOAI870410HDFRNS00");
		asignaTurno.setCorreoElectronico("intorres@correo.com");
		asignaTurno.setNumeroCelular("5589090032");
		asignaTurno.setSolicitante("01");
		asignaTurno.setServicioSolicitado("01");

		// Objeto que contiene los datos del mock para crear folio pulssar.
		FolioEntrada folioEntrada = new FolioEntrada();
		folioEntrada.setIdFolio(1L);
		ResponseEntity<FolioEntrada> respuestaGenerarFolio = new ResponseEntity<FolioEntrada>(folioEntrada, HttpStatus.ACCEPTED);
		when(clienteServicio.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(respuestaGenerarFolio);
		
		// Objeto que contiene la cadena del cuerpo del SMS.
		Parametro paramtroSms = new Parametro();
		paramtroSms.setCvParametro("T00007");
		paramtroSms.setChParametro("005");
		paramtroSms.setChValorParametro("Mensaje sms con folio de servicio %s");
		List<Parametro> parametros = ImmutableList.of(paramtroSms);
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(parametros);
		
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);

		Respuesta turno = asignaTurnoService.crearCita(asignaTurno);

		assertNotNull(turno);
		assertEquals("Se genero el folio FC0004", turno.getMensaje());
		assertEquals(Integer.valueOf(10), turno.getFlujo());
		assertNotNull(turno.getObjetoRespuesta());
		
		final String folioGenerado = (String) turno.getObjetoRespuesta();
		assertEquals("FC0004", folioGenerado);
	}
	
	/**
	 * Permite probar la generación del primer folio del día.
	 */
	@Test
	@Ignore
	@Rollback
	@SuppressWarnings("unchecked")
	public void testCrearCita_primerFolioDelDia() {

		AdministracionTurno asignaTurno = new AdministracionTurno();

		asignaTurno.setClaveOrganizacion("552");
		asignaTurno.setIdUsuario(127L);
		asignaTurno.setNumeroSucursal("2000000000000000");
		asignaTurno.setIndicadorTipoCita(1);

		asignaTurno.setNombre("ISAIAS NEFTALI");
		asignaTurno.setApellidoPaterno("TORRES");
		asignaTurno.setApellidoMaterno(null);
		asignaTurno.setCurp("TOAI870410HDFRNS00");
		asignaTurno.setCorreoElectronico("intorres@correo.com");
		asignaTurno.setNumeroCelular(null);
		asignaTurno.setSolicitante("01");
		asignaTurno.setServicioSolicitado("01");

		FolioEntrada folioEntrada = new FolioEntrada();
		folioEntrada.setIdFolio(1L);
		ResponseEntity<FolioEntrada> respuestaGenerarFolio = new ResponseEntity<FolioEntrada>(folioEntrada, HttpStatus.ACCEPTED);
		when(clienteServicio.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(respuestaGenerarFolio);

		Respuesta turno = asignaTurnoService.crearCita(asignaTurno);

		assertNotNull(turno);
		assertEquals("Se genero el folio FC0001", turno.getMensaje());
		assertEquals(Integer.valueOf(10), turno.getFlujo());
		assertNotNull(turno.getObjetoRespuesta());
		
		final String folioGenerado = (String) turno.getObjetoRespuesta();
		assertEquals("FC0001", folioGenerado);
	}
	
	/**
	 * Permite validar la inexistncia de un parametro obligado.
	 */
	@Test
	@Rollback
	public void testCrearCita_parametroObligado() {

		AdministracionTurno asignaTurno = new AdministracionTurno();

		asignaTurno.setClaveOrganizacion("552");
		asignaTurno.setIdUsuario(127L);
		asignaTurno.setNumeroSucursal("1000000000000000");
		asignaTurno.setIndicadorTipoCita(2);

		asignaTurno.setNombre("ISAIAS NEFTALI");
		asignaTurno.setCurp("TOAI870410HDFRNS00");
		asignaTurno.setApellidoPaterno("");
		asignaTurno.setApellidoMaterno("ANGEL");
		asignaTurno.setCorreoElectronico("intorres@correo.com");
		asignaTurno.setNumeroCelular("5589090032");
		asignaTurno.setSolicitante("01");
		asignaTurno.setServicioSolicitado("01");

		try {

			asignaTurnoService.crearCita(asignaTurno);
			fail("Se esperaba excepcion");
		} catch (GenericException e) {
			assertNotNull(e);
			assertEquals("G002", e.getCodigo());
			assertEquals("En registro de la cita el apellido paterno del cliente es requerido", e.getMessage());
		} catch (Exception e) {
			fail("Excepcion no esperada.");
		}
	}
	
	/**
	 * Permite validar la inexistencia del parametro SMS.
	 */
	@SuppressWarnings("unchecked")
	@Test
	@Ignore

	@Rollback
	public void testCrearCita_inexistenciaParametroSMS() {

		AdministracionTurno asignaTurno = new AdministracionTurno();

		asignaTurno.setClaveOrganizacion("552");
		asignaTurno.setIdUsuario(127L);
		asignaTurno.setNumeroSucursal("1000000000000000");
		asignaTurno.setIndicadorTipoCita(1);

		asignaTurno.setNombre("ISAIAS NEFTALI");
		asignaTurno.setApellidoPaterno("TORRES");
		asignaTurno.setApellidoMaterno("ANGEL");
		asignaTurno.setCurp("TOAI870410HDFRNS00");
		asignaTurno.setCorreoElectronico("intorres@correo.com");
		asignaTurno.setNumeroCelular("5589090032");
		asignaTurno.setSolicitante("01");
		asignaTurno.setServicioSolicitado("01");

		// Objeto que contiene los datos del mock para crear folio pulssar.
		FolioEntrada folioEntrada = new FolioEntrada();
		folioEntrada.setIdFolio(1L);
		ResponseEntity<FolioEntrada> respuestaGenerarFolio = new ResponseEntity<FolioEntrada>(folioEntrada, HttpStatus.ACCEPTED);
		when(clienteServicio.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(respuestaGenerarFolio);
		
		// Objeto que contiene la cadena del cuerpo del SMS.
		Parametro paramtroSms = new Parametro();
		paramtroSms.setCvParametro("T00007");
		paramtroSms.setChParametro("004");
		paramtroSms.setChValorParametro("Parametro invalido para esta prueba");
		List<Parametro> parametros = ImmutableList.of(paramtroSms);
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(parametros);
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);

		try {

			asignaTurnoService.crearCita(asignaTurno);
			fail("Se esperaba excepcion");
		} catch (GenericException e) {
			
			assertNotNull(e);
			assertEquals("G001", e.getCodigo());
			assertEquals("El parametro con clave T00007 y descripcio 005 es inexistente", e.getMessage());
		} catch (Exception e) {
			fail("Excepcion no esperada.");
		}
	}
	
	/**
	 * Permite probar el escenario cuando un turno pasa a estatus <b>En atención</b>.
	 */
	@Test
	@Rollback
	@Ignore
	public void testActualizarCitaEnAtencion() {
		
	
		Respuesta respuesta = asignaTurnoService.actualizarCitaEnAtencion(null, "1", 1l, -2);
		
		assertNotNull(respuesta);
		assertEquals(Integer.valueOf(1), respuesta.getFlujo());
	}
	
	/**
	 * Permite probar el escenario cuando no encuentra el registro del turno con
	 * estatus <b>REGISTRADO</b> que se actualizara a estatus en <b>EN
	 * ATENCION</b>.
	 */
	@Test
	@Rollback
	public void testActualizarCitaEnAtencion_noEncontroTurnoParaActualizar() {
		
		AdministracionTurno administracionTurno = new AdministracionTurno();
		administracionTurno.setFolioServicio("FC1002");
		administracionTurno.setClaveOrganizacion("552");
		administracionTurno.setIdUsuario(127L);
		
		try {
			asignaTurnoService.actualizarCitaEnAtencion(null, "1", 1L, 2);
			fail("Se esperaba excepcion");
		}
		catch (GenericException e) {

			assertNotNull(e);
			assertEquals("G001", e.getCodigo());
			assertNull(e.getMessage());
		}
		catch (Exception e) {
			fail("Excepcion no esperada.");
		}
		
	}

}
