package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;



import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.EstadoSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstadoSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;


/**
 * Clase de prueba para el servicio de estado de solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 12/02/2020, 19:32:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class EstadoSolicitudServiceTestCase  {

	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(EstadoSolicitudServiceTestCase.class);

	/**
	 * Instancia de Servicio de Estado de Solicitud
	 */
	@Autowired
	private EstadoSolicitudService estadoSolicitudService;

	/**
	 * Prueba de consulta de estado catalogado
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:32:40
	 */
	@Test
	public void testRecuperarListaEstadosSolicitud() {
		try {
			List<EstadoSolicitud> estados = estadoSolicitudService.recuperarListaEstadosSolicitud();
			for (EstadoSolicitud estadoSolicitud : estados) {
				logger.info("estado: {}", estadoSolicitud);
			}

		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("error en prueba testRecuperarListaEstadosSolicitud: {}", e);
			fail(" Error en prueba testRecuperarListaEstadosSolicitud");
		}
	}

}
