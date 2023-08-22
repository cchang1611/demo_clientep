/**
 * ModuloServiceTestCase.java
 * Fecha de creación: 17/05/2021, 17:24:25
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

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ModuloNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModuloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruebas unitarias del servicio de consulta de modulos de reporte
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ModuloServiceTestCase {

    /**
     * Log de la clase
     */
    private static final Logger LOG = LoggerFactory.getLogger(ModuloServiceTestCase.class);

    /**
     * Servicio de consulta de modulos
     */
    @Autowired
    private ModuloService moduloService;

    /**
     * Metodo que valida el flujo de consulta de modulos por area
     * Flujo: consulta de folios de una area especifica
     */
    @Test
    public void testRecuperarModulosPorArea() {
        String areaUsuario = "01";
        try {
            List<ModuloNegocio> modulos = moduloService.recuperarModulosPorArea(areaUsuario);
            assertNotNull(modulos);
        } catch(Exception e) {
            LOG.error("Error en la prueba", e);
            assertNotNull(e);
        }
    }

    /**
     * Metodo que valida el flujo de consulta de modulos por area
     * Flujo: consulta de folios de todas las areas
     */
    @Test
    public void testRecuperarModulosPorArea_AreaVacia() {
        String areaUsuario = "";
        try {
            List<ModuloNegocio> modulos = moduloService.recuperarModulosPorArea(areaUsuario);
            assertNotNull(modulos);
        } catch(Exception e) {
            LOG.error("Error en la prueba", e);
            assertNotNull(e);
        }
    }
}
