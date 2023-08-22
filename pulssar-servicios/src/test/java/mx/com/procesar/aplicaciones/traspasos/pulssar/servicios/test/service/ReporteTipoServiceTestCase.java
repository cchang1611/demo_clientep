/**
 * ReporteTipoServiceTestCase.java
 * Fecha de creación: 18/05/2021, 16:38:33
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertFalse;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteTipoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * 
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ReporteTipoServiceTestCase {

    /**
     * Log de la clase
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReporteTipoServiceTestCase.class);

    /**
     * Servicio de consulta de reportes
     */
    @Autowired
    private ReporteTipoService reporteTipoService;

    /**
     * Metodo de prueba del flujo de consulta de tipos de reporte
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperarTipoDeReporteIdSubproceso() {
        String clavesRol = "04";
        Long idSubProceso = 489L;
        try {
            List<RolReporteTipo> tipos = reporteTipoService.recuperarTipoDeReporteIdSubproceso(clavesRol, idSubProceso);
            assertFalse(tipos.isEmpty());
        } catch(PlataformaServiciosOperativaServiceException e) {
            LOG.error("Error al ejecutar e ¿l servicio", e);
        }
    }
}
