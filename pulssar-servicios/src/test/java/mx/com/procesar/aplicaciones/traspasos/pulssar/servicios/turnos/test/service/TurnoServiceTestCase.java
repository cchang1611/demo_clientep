/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Turno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TurnoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AdministracionTurnoService;

/**
 * <p>
 * Clase de prueba para los servicios relacionados con
 * {@link AdministracionTurnoService}.
 * </p>
 * 
 * <p>
 * La presente prueba reinicia el contexto despues de finalizar las pruebas ya
 * que crea el mock de repositorio del turno unicamente para ésta prueba.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class TurnoServiceTestCase extends BaseTestCase {
	
	/**
	 * Servicio a probar
	 */
	@Autowired
	@InjectMocks
	private AdministracionTurnoService turnoService;
	
	/**
	 * Cliente rest adminisrdo por mockito.
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * Mock para el tueno del repositorio.
	 */
	@Mock
	private TurnoRepository turnoRepositoryMock;
	
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
	@Ignore
	@Rollback
	@SuppressWarnings("unchecked")
	public void testConstruirRespuestaTurnosRegistrados() {
		
		// Parametros requeridos para el servicio a probar.
		final String aforeParam          = "552";
		final Long usuarioParam        = 127L;
		final String numeroSucursalParam = "1000000000000001";
		
		// Parametros sumulados a través de un WS Rest.
		List<Parametro> listaParametros = Lists.newArrayList();
		Parametro parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("001");
		parametro.setChValorParametro("20");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("002");
		parametro.setChValorParametro("60");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("003");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("004");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(listaParametros);
		
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);
		
		// Mock para serciorarse que no existe ningun turno en atención.
		when(turnoRepositoryMock.buscarPorIdUsuarioYEstatusYFechaRegistro(anyLong(), anyString(), any(Date.class)))
				.thenReturn(new ArrayList<Turno>());
		
		// Mock para las citas registradas con cita previa.
		TurnoRegistrado turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("60");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FC0001");
		List<TurnoRegistrado> listaTurnosRegistradosConCita = Lists.newArrayList(turnoRegistrado);
		
		// Mock para las citas registradas sin cita previa.
		turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("4");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FS0002");
		List<TurnoRegistrado> listaTurnosRegistradosSinCita = Lists.newArrayList(turnoRegistrado);
		
		doReturn(listaTurnosRegistradosConCita, listaTurnosRegistradosSinCita).when(turnoRepositoryMock)
				.buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(anyString(), any(Date.class), anyString());
		
		Respuesta resultadoTurnos = turnoService.construirRespuestaTurnosRegistrados(aforeParam, usuarioParam,
				numeroSucursalParam);
		
		assertNotNull(resultadoTurnos);
		
		RespuestaAdministracionTurno administracionTurno = (RespuestaAdministracionTurno) resultadoTurnos.getObjetoRespuesta();
		
		assertNotNull(administracionTurno);
		assertEquals("20", administracionTurno.getLimiteEnMinutosDeTurnoConCita());
		assertEquals("60", administracionTurno.getLimiteEnMinutosDeTurnoSinCita());
		assertEquals("5", administracionTurno.getIndicadorEnMinutosPreavisoTurnoConCita());
		assertEquals("5", administracionTurno.getIndicadorEnMinutosPreavisoTurnoSinCita());
		
		assertEquals(1, administracionTurno.getTurnosConCita().size());
		assertEquals(1, administracionTurno.getTurnosSinCita().size());
		
		final TurnoRegistrado turnoConCita = administracionTurno.getTurnosConCita().get(0);
		assertEquals("autorizado", turnoConCita.getAutorizadoCss());
		assertEquals("Text__red", turnoConCita.getEstiloCss());
		assertEquals("Row__1", turnoConCita.getEstiloRegistroCss());
		assertEquals("FC0001", turnoConCita.getFolioServicio());
		assertEquals("60", turnoConCita.getMinutosEspera());
		assertEquals("NEFTALI TORRES ANGEL", turnoConCita.getNombreTrabajador());
		
		final TurnoRegistrado turnoSinCita = administracionTurno.getTurnosSinCita().get(0);
		assertEquals("autorizado", turnoSinCita.getAutorizadoCss());
		assertEquals("Text__black", turnoSinCita.getEstiloCss());
		assertEquals("Row__1", turnoSinCita.getEstiloRegistroCss());
		assertEquals("FS0002", turnoSinCita.getFolioServicio());
		assertEquals("4", turnoSinCita.getMinutosEspera());
		assertEquals("NEFTALI TORRES ANGEL", turnoSinCita.getNombreTrabajador());
	}
	
	/**
	 * <p>
	 * Permite probar el escenario cuando existe un tueno de atensión pendiente.
	 * </p>
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
//	@Test
//	@Rollback
//	@SuppressWarnings("unchecked")
//	public void testConstruirRespuestaTurnosRegistrados_conTurnoDeAtencionPendiente() {
//		
//		// Parametros requeridos para el servicio a probar.
//		final String aforeParam          = "552";
//		final Long usuarioParam        = 127L;
//		final String numeroSucursalParam = "1000000000000001";
//		
//		// Parametros sumulados a través de un WS Rest.
//		List<Parametro> listaParametros = Lists.newArrayList();
//		Parametro parametro = new Parametro();
//		parametro.setCvParametro("T00007");
//		parametro.setChParametro("001");
//		parametro.setChValorParametro("20");
//		listaParametros.add(parametro);
//		
//		parametro = new Parametro();
//		parametro.setCvParametro("T00007");
//		parametro.setChParametro("002");
//		parametro.setChValorParametro("60");
//		listaParametros.add(parametro);
//		
//		parametro = new Parametro();
//		parametro.setCvParametro("T00007");
//		parametro.setChParametro("003");
//		parametro.setChValorParametro("5");
//		listaParametros.add(parametro);
//		
//		parametro = new Parametro();
//		parametro.setCvParametro("T00007");
//		parametro.setChParametro("004");
//		parametro.setChValorParametro("5");
//		listaParametros.add(parametro);
//		
//		ParametroList listaParametro = new ParametroList();
//		listaParametro.setListaParametros(listaParametros);
//		
//		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);
//		
//		// Mock para serciorarse que no existe ningun turno en atención.
//		List<Turno> turnoDeAtencionPendiente = Lists.newArrayList(new Turno());
//		when(turnoRepositoryMock.buscarPorIdUsuarioYEstatusYFechaRegistro(anyLong(), anyString(), any(Date.class)))
//				.thenReturn(turnoDeAtencionPendiente);
//		
//		// Mock para las citas registradas con cita previa.
//		TurnoRegistrado turnoRegistrado = new TurnoRegistrado();
//		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
//		turnoRegistrado.setMinutosEspera("60");
//		turnoRegistrado.setHorasEspera("12:00");
//		turnoRegistrado.setFolioServicio("FC0001");
//		List<TurnoRegistrado> listaTurnosRegistradosConCita = Lists.newArrayList(turnoRegistrado);
//		
//		// Mock para las citas registradas sin cita previa.
//		turnoRegistrado = new TurnoRegistrado();
//		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
//		turnoRegistrado.setMinutosEspera("4");
//		turnoRegistrado.setHorasEspera("12:00");
//		turnoRegistrado.setFolioServicio("FS0002");
//		List<TurnoRegistrado> listaTurnosRegistradosSinCita = Lists.newArrayList(turnoRegistrado);
//		
//		doReturn(listaTurnosRegistradosConCita, listaTurnosRegistradosSinCita).when(turnoRepositoryMock)
//				.buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(anyString(), any(Date.class), anyString());
//		
//		Respuesta resultadoTurnos = turnoService.construirRespuestaTurnosRegistrados(aforeParam, usuarioParam,
//				numeroSucursalParam);
//		
//		assertNotNull(resultadoTurnos);
//		
//		RespuestaAdministracionTurno administracionTurno = (RespuestaAdministracionTurno) resultadoTurnos.getObjetoRespuesta();
//		
//		assertNotNull(administracionTurno);
//		assertEquals("20", administracionTurno.getLimiteEnMinutosDeTurnoConCita());
//		assertEquals("60", administracionTurno.getLimiteEnMinutosDeTurnoSinCita());
//		assertEquals("5", administracionTurno.getIndicadorEnMinutosPreavisoTurnoConCita());
//		assertEquals("5", administracionTurno.getIndicadorEnMinutosPreavisoTurnoSinCita());
//		
//		assertEquals(1, administracionTurno.getTurnosConCita().size());
//		assertEquals(1, administracionTurno.getTurnosSinCita().size());
//		
//		final TurnoRegistrado turnoConCita = administracionTurno.getTurnosConCita().get(0);
//		assertEquals("", turnoConCita.getAutorizadoCss());
//		assertEquals("Text__red", turnoConCita.getEstiloCss());
//		assertEquals("Row__1", turnoConCita.getEstiloRegistroCss());
//		assertEquals("FC0001", turnoConCita.getFolioServicio());
//		assertEquals("60", turnoConCita.getMinutosEspera());
//		assertEquals("NEFTALI TORRES ANGEL", turnoConCita.getNombreTrabajador());
//		
//		final TurnoRegistrado turnoSinCita = administracionTurno.getTurnosSinCita().get(0);
//		assertEquals("", turnoSinCita.getAutorizadoCss());
//		assertEquals("Text__black", turnoSinCita.getEstiloCss());
//		assertEquals("Row__1", turnoSinCita.getEstiloRegistroCss());
//		assertEquals("FS0002", turnoSinCita.getFolioServicio());
//		assertEquals("4", turnoSinCita.getMinutosEspera());
//		assertEquals("NEFTALI TORRES ANGEL", turnoSinCita.getNombreTrabajador());
//	}
	
	/**
	 * <p>
	 * Permite probar el escenario cuando los munutos en espera es menor al
	 * indicador.
	 * </p>
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testConstruirRespuestaTurnosRegistrados_MunutosEnEsperaMenorQueIndicadorRojo1() {
		
		// Parametros requeridos para el servicio a probar.
		final String aforeParam          = "552";
		final Long usuarioParam        = 127L;
		final String numeroSucursalParam = "1000000000000001";
		
		// Parametros sumulados a través de un WS Rest.
		List<Parametro> listaParametros = Lists.newArrayList();
		Parametro parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("001");
		parametro.setChValorParametro("4");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("002");
		parametro.setChValorParametro("60");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("003");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("004");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(listaParametros);
		
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);
		
		// Mock para serciorarse que no existe ningun turno en atención.
		List<Turno> turnoDeAtencionPendiente = Lists.newArrayList(new Turno());
		when(turnoRepositoryMock.buscarPorIdUsuarioYEstatusYFechaRegistro(anyLong(), anyString(), any(Date.class)))
				.thenReturn(turnoDeAtencionPendiente);
		
		// Mock para las citas registradas con cita previa.
		TurnoRegistrado turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("60");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FC0001");
		List<TurnoRegistrado> listaTurnosRegistradosConCita = Lists.newArrayList(turnoRegistrado);
		
		// Mock para las citas registradas sin cita previa.
		turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("4");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FS0002");
		List<TurnoRegistrado> listaTurnosRegistradosSinCita = Lists.newArrayList(turnoRegistrado);
		
		doReturn(listaTurnosRegistradosConCita, listaTurnosRegistradosSinCita).when(turnoRepositoryMock)
				.buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(anyString(), any(Date.class), anyString());
		
		try {
			
			turnoService.construirRespuestaTurnosRegistrados(aforeParam, usuarioParam, numeroSucursalParam);
			fail("Se esperaba una excepcion");
		} catch (IllegalArgumentException e) {
			
			assertNotNull(e);
			assertEquals("Los minutos deben ser mayor al preaviso para los registros con cita", e.getMessage());
		}
		catch (Exception e) {
			fail("Se esperaba otra excepcion");
		}
		
	}
	
	/**
	 * <p>
	 * Permite probar el escenario cuando los munutos en espera es menor al
	 * indicador.
	 * </p>
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testConstruirRespuestaTurnosRegistrados_MunutosEnEsperaMenorQueIndicadorRojo2() {
		
		// Parametros requeridos para el servicio a probar.
		final String aforeParam          = "552";
		final Long usuarioParam        = 127L;
		final String numeroSucursalParam = "1000000000000001";
		
		// Parametros sumulados a través de un WS Rest.
		List<Parametro> listaParametros = Lists.newArrayList();
		Parametro parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("001");
		parametro.setChValorParametro("20");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("002");
		parametro.setChValorParametro("4");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("003");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		parametro = new Parametro();
		parametro.setCvParametro("T00007");
		parametro.setChParametro("004");
		parametro.setChValorParametro("5");
		listaParametros.add(parametro);
		
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(listaParametros);
		
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);
		
		// Mock para serciorarse que no existe ningun turno en atención.
		List<Turno> turnoDeAtencionPendiente = Lists.newArrayList(new Turno());
		when(turnoRepositoryMock.buscarPorIdUsuarioYEstatusYFechaRegistro(anyLong(), anyString(), any(Date.class)))
				.thenReturn(turnoDeAtencionPendiente);
		
		// Mock para las citas registradas con cita previa.
		TurnoRegistrado turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("60");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FC0001");
		List<TurnoRegistrado> listaTurnosRegistradosConCita = Lists.newArrayList(turnoRegistrado);
		
		// Mock para las citas registradas sin cita previa.
		turnoRegistrado = new TurnoRegistrado();
		turnoRegistrado.setNombreTrabajador("NEFTALI TORRES ANGEL");
		turnoRegistrado.setMinutosEspera("4");
		turnoRegistrado.setHorasEspera("12:00");
		turnoRegistrado.setFolioServicio("FS0002");
		List<TurnoRegistrado> listaTurnosRegistradosSinCita = Lists.newArrayList(turnoRegistrado);
		
		doReturn(listaTurnosRegistradosConCita, listaTurnosRegistradosSinCita).when(turnoRepositoryMock)
				.buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(anyString(), any(Date.class), anyString());
		
		try {
			
			turnoService.construirRespuestaTurnosRegistrados(aforeParam, usuarioParam, numeroSucursalParam);
			fail("Se esperaba una excepcion");
		} catch (IllegalArgumentException e) {
			
			assertNotNull(e);
			assertEquals("Los minutos deben ser mayor al preaviso para los registros sin cita", e.getMessage());
		}
		catch (Exception e) {
			fail("Se esperaba otra excepcion");
		}
		
	}
	
	/**
	 * <p>
	 * Permite probar el escenario cuando no encuentran los parametros requeridos.
	 * </p>
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	@Test
	@Rollback
	@SuppressWarnings("unchecked")
	public void testConstruirRespuestaTurnosRegistrados_conParametroInexistente() {
		
		// Parametros requeridos para el servicio a probar.
		final String aforeParam          = "552";
		final Long usuarioParam        = 127L;
		final String numeroSucursalParam = "1000000000000001";
		
		// Parametros sumulados a través de un WS Rest.
		List<Parametro> listaParametros = Lists.newArrayList();
		ParametroList listaParametro = new ParametroList();
		listaParametro.setListaParametros(listaParametros);
		
		when(clienteServicio.getForObject(anyString(), any(Class.class))).thenReturn(listaParametro);
		
		try {
			
			turnoService.construirRespuestaTurnosRegistrados(aforeParam, usuarioParam, numeroSucursalParam);
			fail("Se esperaba una excepcion");
		} catch (GenericException e) {
			
			assertNotNull(e);
			assertEquals("G001", e.getCodigo());
			assertEquals("El parametro con clave T00007 y descripcio 001 inexistente", e.getMessage());
		}
		catch (Exception e) {
			fail("Se esperaba otra excepcion");
		}
		
	}

}
