package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SubProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;


/**
 * Casos de prueba de servicio de subprocesos
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class SubProcesoServiceTestCase  {

	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SubProcesoServiceTestCase.class);

	/**
	 * Instancia de servicio de subproceso
	 */
	@Autowired
	private SubProcesoService subProcesoNegocioService;

	/**
	 * Prueba flujo basico de servicio de consulta de subproceso por id de proceso
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	@Test
	public void testRecuperaSubprocesosPorIdProcesoNegocio() {
		Long idProceso = 1L;
		try {
			List<SubProcesoNegocio> result = subProcesoNegocioService.recuperaSubprocesosPorIdProceso(idProceso);
			if (result.isEmpty()) {
				fail("Prueba Incorrecta");
			}
			for (SubProcesoNegocio subProcesoNegocio : result) {
				logger.info("Subproceso: {}", subProcesoNegocio.getNombreSubProceso());
			}
		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			fail("Prueba Incorrecta");
		}

	}

}
