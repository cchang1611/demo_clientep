package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
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
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruebas unitarias del servicio de consulta de datos de reportes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ReporteGenericoServiceTestCase {

    /**
     * Log de la clase
     */
    private static final Logger logger = LoggerFactory.getLogger(ReporteGenericoServiceTestCase.class);

    /**
     * Constante para cadena de error
     */
    private static final String STR_ERROR = "Error: {}";

    /**
     * instancia de servicio de reporteGenerico
     */
    @Autowired
    private ReporteGenericoService reporteGenericoService;

    /**
     * Metodo de prueba para validar el flujo de consulta de reportes por subproceso y tipo de reporte
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testObtenerListaReportesPorSubprocesoTipoReporte() {

        Long idSubproceso = 489L;
        Long idTipoReporte = 1583L;
        Integer tipoProcesamiento = 0;
        String idRol = "04";

        try {
            List<ReporteCompleto> rsult = reporteGenericoService.obtenerListaReportesPorSubprocesoTipoReporte(idSubproceso,
                idTipoReporte, tipoProcesamiento, idRol);
            for (ReporteCompleto reporteGenerico : rsult) {
                logger.info("reporte: {}", reporteGenerico.getReporte());
            }
        } catch(PlataformaServiciosOperativaServiceException e) {
            logger.error(STR_ERROR, e);
            fail("Error en prueba testObtenerListaReportesPorSubprocesoTipoReporte");
        }

    }

    /**
     * Metodo de prueba para validar el flujo de consulta del total de reportes por subproceso y tipo de reporte
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testObtenerTotalReportesPorSubprocesoTipoReporte() {
        Long idSubproceso = 489L;
        Long idTipoReporte = 1583L;
        try {
            List<ReporteGenerico> reportes =
                reporteGenericoService.obtenerTotalReportesPorSubprocesoTipoReporte(idSubproceso, idTipoReporte);
            assertTrue(!reportes.isEmpty());
        } catch(PlataformaServiciosOperativaServiceException e) {
            logger.error(STR_ERROR, e);
            fail("Error en prueba testObtenerTotalReportesPorSubprocesoTipoReporte");
        }
    }

    /**
     * Metodo de prueba para validar el flujo de consulta del total de reportes por subproceso
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testObtenerTotalReportesPorSubprocesoTipoReporte_TodosReportes() {
        Long idSubproceso = 489L;
        Long idTipoReporte = 0L;
        try {
            List<ReporteGenerico> reportes =
                reporteGenericoService.obtenerTotalReportesPorSubprocesoTipoReporte(idSubproceso, idTipoReporte);
            assertTrue(!reportes.isEmpty());
        } catch(PlataformaServiciosOperativaServiceException e) {
            logger.error(STR_ERROR, e);
            fail("Error en prueba testObtenerTotalReportesPorSubprocesoTipoReporte");
        }
    }

    /**
     * Metodo de prueba para validar el flujo de consulta del total de reportes por subproceso y tipo de reporte
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testObtenerTipoReportePorClave() {
        Long cvTipoReporte = 853L;
        try {
            ReporteCompleto reporte = reporteGenericoService.obtenerTipoReportePorClave(cvTipoReporte);
            assertNotNull(reporte);
        } catch(PlataformaServiciosOperativaServiceException e) {
            logger.error(STR_ERROR, e);
            fail("Error en prueba testObtenerTotalReportesPorSubprocesoTipoReporte");
        }
    }

}
