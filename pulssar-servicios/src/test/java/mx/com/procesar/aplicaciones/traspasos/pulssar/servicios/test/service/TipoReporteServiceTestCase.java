package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.TipoReporteMasivoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;



/**
 * Casos de prueba de servicio de tipo Reporte
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 12:07:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class TipoReporteServiceTestCase  {

	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TipoReporteServiceTestCase.class);

	/**
	 * Instancia de servicio de tipo reporte
	 */
	@Autowired
	private TipoReporteService tipoReporteService;

	/**
	 * prueba de flujo basico de metodo que recupera total de tipos de reporte de
	 * tipo Linea
	 * 
	 * @author hjramire void
	 * @since 03/01/2020, 12:10:58
	 */
	@Test
	public void testObtenerTipoArchivo() {
		int flujoLinea = 0;

		try {
			List<TipoReporte> result = tipoReporteService.recuperarTotalDeTiposReportePorFlujo(flujoLinea);

			for (TipoReporte tipoReporte : result) {
				logger.info("tipo reporte: {}", tipoReporte.getDescripcion());
			}
		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error en prueba: {}", e);
			fail("Error en la prueba");
		}

	}

	/**
	 * prueba de flujo basico de metodo que recupera total de tipos de reporte de
	 * tipo Batch
	 * 
	 * @author hjramire void
	 * @since 03/01/2020, 12:10:58
	 */
	@Test
	public void testObtenerTipoArchivoBatch() {
		int flujoBatch = 1;

		try {
			List<TipoReporte> result = tipoReporteService.recuperarTotalDeTiposReportePorFlujo(flujoBatch);

			for (TipoReporte tipoReporte : result) {
				logger.info("tipo reporte: {}", tipoReporte.getDescripcion());
			}
		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error en prueba: {}", e);
			fail("Error en la prueba");
		}

	}

	/**
	 * Prueba de flujo basico de metodo que recupera el tipo de Archivo
	 * 
	 * @author hjramire void
	 * @since 03/01/2020, 12:10:43
	 */
	@Test
	public void testRecuperarTotalDeTiposReportePorFlujo() {
		TipoReporteMasivoEnum tipo = tipoReporteService.obtenerTipoArchivo("1");

		if (null != tipo) {
			logger.info("tipoRecuperado: {}", tipo);
			assertTrue("Prueba correcta", true);
		} else {
			fail("Prueba incorrecta");
		}
	}

	/**
     * Prueba de flujo basico de metodo que recupera el tipo de Archivo
     * 
     * @author hjramire void
     * @since 03/01/2020, 12:10:43
     */
    @Test
    public void testObtenerTipoArchivo_TipoNulo() {
        String tipoArchivo = null;
        TipoReporteMasivoEnum tipo = tipoReporteService.obtenerTipoArchivo(tipoArchivo);
        if (null != tipo) {
            fail("Prueba incorrecta");
        } else {
            logger.info("tipoRecuperado: {}", tipo);
            assertTrue("Prueba correcta", true);
        }
    }

    /**
     * Prueba de flujo basico de metodo que recupera el tipo de Archivo
     * 
     * @author hjramire void
     * @since 03/01/2020, 12:10:43
     */
    @Test
    public void testObtenerTipoArchivo_TipoVacio() {
        String tipoArchivo = "";
        TipoReporteMasivoEnum tipo = tipoReporteService.obtenerTipoArchivo(tipoArchivo);
        if (null != tipo) {
            fail("Prueba incorrecta");
        } else {
            logger.info("tipoRecuperado: {}", tipo);
            assertTrue("Prueba correcta", true);
        }
    }

    /**
     * Prueba de flujo basico de metodo que recupera el total de tipo de Archivo
     * @author hjramire void
     * @since 24/02/2020, 17:55:36
     */
	@Test
	public void testRecuperarTotalDeTiposReporte() {
		try {
			List<TipoReporte> listaTipoReporte = tipoReporteService.recuperarTotalDeTiposReporte();
			for (TipoReporte tipoReporte : listaTipoReporte) {
				logger.info("tipoReporte: {}", tipoReporte);
			}
		} catch (PlataformaServiciosOperativaServiceException e) {
			logger.error("Error en prueba testRecuperarTotalDeTiposReporte: {}", e);
			fail("Prueba incorrecta");
		}
	}

}
