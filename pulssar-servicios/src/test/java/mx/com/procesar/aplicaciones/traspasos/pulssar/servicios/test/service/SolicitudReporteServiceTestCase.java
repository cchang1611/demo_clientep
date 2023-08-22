package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase de prueba para servicio de solicitud de reportes
 * @author hjramire
 * @version 1.0
 * @since 12/02/2020, 20:16:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class SolicitudReporteServiceTestCase {
	
	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudReporteServiceTestCase.class);

	/**
	 * Instancia de Servicio de solicitud de Reporte
	 */
	@Autowired
	private SolicitudReporteService solicitudReporteService;

	/**
	 * Instancia de folderTemporal para pruebas de archivos
	 */
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	/**
	 *  Prueba de Flujo Basico de generacion de solicitud de reporte
	 *  @author hjramire void
	 *  @since 12/02/2020, 20:16:48
	 */
	@Test
	public void testGenerarSolicitudReporte() {
		try {
			solicitudReporteService.generarSolicitudReporte(1L, "prueba.txt", folder.toString());
		} catch(Exception e) {
			logger.error("Error en prueba testGenerarSolicitudReporte: {}", e);
			fail("Error en prueba testGenerarSolicitudReporte");
		}
	}

	/**
	 *  Prueba de actualiacion de estado de solicitud de reporte
	 *  @author hjramire void
	 *  @since 12/02/2020, 20:17:18
	 */
	@Test
	public void testActualizarEstatusSolicitud() {
		SolicitudReporte solicitudReporte = new SolicitudReporte();
		solicitudReporte.setIdSolicitud(1L);
		solicitudReporte.setIdEstadoSolicitud(1L);
		solicitudReporte.setNumeroSolicitud("123456789");
		solicitudReporte.setIdReporteGenerico(1L);
		solicitudReporte.setFechaEnvio(new Date());
		solicitudReporte.setFechaControl(new Date());
		solicitudReporte.setUsuarioModificador("Prueba");

		Long estatus = 5L;
		try {
			solicitudReporteService.actualizarEstatusSolicitud(solicitudReporte, estatus);
		} catch(Exception e) {
			logger.error("Error en prueba testActualizarEstatusSolicitud: {}", e);
			fail("Error en prueba testActualizarEstatusSolicitud");
		}
	}

	/**
	 *  Prueba de consulta de solicitudes 
	 *  @author hjramire void
	 *  @since 12/02/2020, 20:18:47
	 */
	@Test
	public void testRecuperarSolicitudes() {
		try {
			List<SolicitudReporte> solicitudes = solicitudReporteService.recuperarSolicitudes("2");

			for (SolicitudReporte solicitudReporte : solicitudes) {
				logger.info("solicitud: {}", solicitudReporte);
			}
		} catch(Exception e) {
			logger.error("Error en prueba testRecuperarSolicitudes: {}", e);
			fail("Error en prueba testRecuperarSolicitudes");
		}
	}

	/**
	 *  Prueba de consulta de solicitudes por ID
	 *  @author hjramire void
	 *  @since 12/02/2020, 20:18:39
	 */
	@Test
	public void testRecuperarSolicitudPorId() {
		try {
			solicitudReporteService.recuperarSolicitudPorId(1L);

		} catch(Exception e) {
			logger.error("Error en prueba testRecuperarSolicitudPorId: {}", e);
			fail("Error en prueba testRecuperarSolicitudPorId");
		}
	}

	/**
	 *  Prueba de Actualizacion de registro de solicitud 
	 *  @author hjramire void
	 *  @since 12/02/2020, 20:18:31
	 */
	@Test
	public void testActualizarRegistroSolicitud() {
		SolicitudReporte solicitudReporte = new SolicitudReporte();
		solicitudReporte.setIdSolicitud(1L);
		solicitudReporte.setIdEstadoSolicitud(1L);
		solicitudReporte.setNumeroSolicitud("123456789");
		solicitudReporte.setIdReporteGenerico(1L);
		solicitudReporte.setFechaEnvio(new Date());
		solicitudReporte.setFechaControl(new Date());
		solicitudReporte.setUsuarioModificador("Prueba");
		
		try {
			solicitudReporteService.actualizarRegistroSolicitud(solicitudReporte);

		} catch(Exception e) {
			logger.error("Error en prueba testActualizarRegistroSolicitud: {}", e);
			fail("Error en prueba testActualizarRegistroSolicitud");
		}
	}

}
