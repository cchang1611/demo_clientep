/**
 * ReporteProcesoServiceTestCase.java Fecha de creación: 26/05/2021, 13:05:38 Copyright (c)
 * 2021 Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;

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
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase de pruebas del servicio de consulta de reportes por proceso
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ReporteProcesoServiceTestCase {

    /**
     * Definicion de Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReporteProcesoServiceTestCase.class);

    /**
     * Servicio de consulta de reportes
     */
    @Autowired
    private ReporteProcesoService reporteProcesoService;

    /**
     * Metodo que prueba el flujo de consulta de proceso de negocio Escenario: Happy Path
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperaIdProcesoNegocio() {
        try {
            String idRoles = "04";
            Long idModulo = 2L;
            List<RolReporteProceso> reportes = reporteProcesoService.recuperaIdProcesoNegocios(idRoles, idModulo, "2");
            assertNotNull(reportes);
            assertTrue(!reportes.isEmpty());
        } catch(Exception e) {
            LOG.error("Error en la prueba, no se esperaba excepcion", e);
            fail("Error en la prueba");
        }
    }

    /**
     * Metodo que prueba el flujo de consulta de proceso de negocio Escenario: Happy Path
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperaIdProcesoNegocio_ModuloNoAsignado() {
        try {
            String idRoles = "04";
            Long idModulo = 2L;
            List<RolReporteProceso> reportes = reporteProcesoService.recuperaIdProcesoNegocios(idRoles, idModulo, "21");
            assertNotNull(reportes);
            assertTrue(reportes.isEmpty());
        } catch(Exception e) {
            LOG.error("Error en la prueba, no se esperaba excepcion", e);
            fail("Error en la prueba");
        }
    }
}
