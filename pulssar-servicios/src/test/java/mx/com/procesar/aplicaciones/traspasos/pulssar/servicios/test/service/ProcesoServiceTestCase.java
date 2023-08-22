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

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;



/**
 * Casos de prueba de servicio de proceso de negocio
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 10:30:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ProcesoServiceTestCase {

	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProcesoServiceTestCase.class);

	/**
	 * Instancia de servicio de proceso de negocio
	 */
	@Autowired
	private ProcesoService procesoService;

	/**
	 * Prueba de flujo basico de metodo que recupera el total de procesos de negocio
	 * catalogados a partir del modulo
	 * 
	 * @author hjramire void
	 * @since 03/01/2020, 10:33:35
	 */
	@Test
	public void testRecuperaProcesosPorIdModulo() {
		Long idModulo = 4L;

		try {
			List<ProcesoNegocio> listaProcesos = procesoService.recuperaProcesosPorIdModulo(idModulo);
			for (ProcesoNegocio procesoNegocio : listaProcesos) {
				logger.info("proceso: {}", procesoNegocio.getNombreProceso());
			}

		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("error en la prueba: {}", e);
			fail("Error en prueba");
		}

	}

}
