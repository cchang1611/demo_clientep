package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DetalleSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;


/**
 * Clase de pruebas de servicios de detalles de solicitudes
 * @author hjramire
 * @version 1.0
 * @since 12/02/2020, 19:31:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class DetalleSolicitudServiceTestCase {
	
	/**
	 * Definicion de Logger
	 */
	private static final Logger logger =
		LoggerFactory.getLogger(DetalleSolicitudServiceTestCase.class);

	/**
	 * Instancia de servicio de detalles de solicitud
	 */
	@Autowired
	private DetalleSolicitudService detalleSolicitudService;


	/**
	 *  Prueba de servicio de Consulta de Detalles por Parametros
	 *  @author hjramire void
	 *  @since 12/02/2020, 19:31:12
	 */
	@Test
	public void testRecuperarListaDetalleSolicitudPorParams() {
		Long numSolicitud = 123456789L;
		Long idEstado = 1L;
		Date fcInicial = null;
		Date fcFinal = null;

		try {

			detalleSolicitudService.recuperarListaDetalleSolicitudPorParams("1,2,3,4,5",numSolicitud, idEstado,
				fcInicial, fcFinal);
		} catch(Exception e) {
			logger.error("error en prueba testRecuperarListaDetalleSolicitudPorParams: {}", e);
			fail(" Error en prueba testRecuperarListaDetalleSolicitudPorParams");
		}
	}
	
	
	/**
	 *  Prueba de servicio de Consulta de Detalles por Parametros
	 *  @author hjramire void
	 *  @since 12/02/2020, 19:31:03
	 */
	@Test
	public void testRecuperaListaDetalleSolicitudPorParamsRangoFechas() {

		Long numSolicitud = -1L;
		Long idEstado = null;
		Date fcInicial = new Date();
		Date fcFinal = new Date();

		try {

			detalleSolicitudService.recuperarListaDetalleSolicitudPorParams("1,2,3,4,5",numSolicitud, idEstado,
				fcInicial, fcFinal);
		} catch(Exception e) {
			logger.error("error en prueba testRecuperaListaDetalleSolicitudPorParamsRangoFechas: {}", e);
			fail(" Error en prueba testRecuperaListaDetalleSolicitudPorParamsRangoFechas");
		}

	}
	

}
