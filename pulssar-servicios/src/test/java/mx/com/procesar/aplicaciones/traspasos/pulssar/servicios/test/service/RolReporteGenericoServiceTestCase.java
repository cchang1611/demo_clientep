/**
 * RolReporteGenericoServiceTestCase.java
 * Fecha de creación: 18/05/2021, 17:05:11
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
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RolesReporteGenericoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolReporteGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RolReporteGenericoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruebas unitarias del servicio de consulta de roles y reportes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class RolReporteGenericoServiceTestCase {

    /**
     * Servicio de consulta de reportes
     */
    @Autowired
    private RolReporteGenericoService rolReporteGenericoService;

    /**
     * Servicio de consulta de reportes
     */
    @InjectMocks
    private RolReporteGenericoServiceImpl rolReporteGenericoServiceMock;

    /**
     * Repository para recuperar la lista de reportes genericos a partir del idRol
     */
    @Mock
    private RolesReporteGenericoRepository rolesReporteGenericoRepository;

    /**
     * Set up
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Metodo que valida el flujo de consulta de reportes por rol
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperarIdReportePorRol() {
        String idRoles = "04";
        List<RolReporteGenerico> reportes = rolReporteGenericoService.recuperarIdReportePorRol(idRoles);
        assertFalse(reportes.isEmpty());
    }

    /**
     * Metodo que valida el flujo de consulta de reportes por rol - Consulta sin resultados
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testRecuperarIdReportePorRol_SinResultados() {
        String idRoles = "00,000";
        Mockito.when(rolesReporteGenericoRepository.findByIdRol(Mockito.anyListOf(Long.class)))
            .thenThrow(new RuntimeException("Error al accesar a la base de datos"));
        List<RolReporteGenerico> reportes = rolReporteGenericoServiceMock.recuperarIdReportePorRol(idRoles);
        assertNull(reportes);
    }

}
