/**
 * ReporteSubProcesosServiceTestCase.java
 * Fecha de creación: 18/05/2021, 13:28:42
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ReportesSubprocesosRespository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteSubProcesosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReporteSubProcesosServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruabas unitarias del servicio de consulta de subrprocesos de reportes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ReporteSubProcesosServiceTestCase {

    /**
     * Log de la clase
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReporteSubProcesosServiceTestCase.class);

    /**
     * Servicio de consulta de reportes
     */
    @Autowired
    private ReporteSubProcesosService reporteSubProcesosService;

    /**
     * Servicio Mock de consulta de reportes
     */
    @InjectMocks
    private ReporteSubProcesosServiceImpl reporteSubProcesosServiceMock;

    /**
     * Instancia del repositorio de Subproceso
     */
    @Mock
    private ReportesSubprocesosRespository reporteSubProcesosRepository;

    /**
     * Set up
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Metodo que valida el flujo de consulta de subrocesos
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperarSubprocesosPorIdProceso() {
        String idRoles = "04";
        Long idProceso = 151L;
        try {
            List<RolReporteSubProceso> subprocesos = reporteSubProcesosService.recuperarSubprocesosPorIdProceso(idRoles, idProceso);
            assertFalse(subprocesos.isEmpty());
        } catch(PlataformaServiciosOperativaServiceException e) {
            LOG.error("Error al ejecutar el servicio", e);
        }
    }

    /**
     * Metodo que valida el flujo de consulta de subrocesos - Flujo de Excepcion
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperarSubprocesosPorIdProceso_Excepcion() {
        String idRoles = "04";
        Long idProceso = 151L;
        try {
            Mockito
                .when(reporteSubProcesosRepository.findByIdRolAndProceso(idRoles, idProceso, ServiciosConstants.CONST_CATALOGO_ACTIVO))
                .thenThrow(new RuntimeException("Error al acceder a la base de datos"));
            List<RolReporteSubProceso> subprocesos = reporteSubProcesosService.recuperarSubprocesosPorIdProceso(idRoles, idProceso);
            assertFalse(subprocesos.isEmpty());
        } catch(PlataformaServiciosOperativaServiceException e) {
            LOG.error("Error al ejecutar el servicio", e);
        }
    }
}
