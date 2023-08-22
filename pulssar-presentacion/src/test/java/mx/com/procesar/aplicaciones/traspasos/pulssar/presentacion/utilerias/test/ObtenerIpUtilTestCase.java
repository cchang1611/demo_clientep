/**
 * ObtenerIpUtilTestCase.java
 * Fecha de creación: 19/05/2021, 13:26:03
 *
 * Copyright (c) 2021 Procesar S A de C V.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.test;

import static org.junit.Assert.assertNotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl.ObtenerIpUtilImpl;

/**
 * Clase que contiene los metodos de prueba de la utileria para la obtencion de ip
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
public class ObtenerIpUtilTestCase {

    /**
     * Referencia a ObtenerIputilImpl
     */
    @InjectMocks
    private ObtenerIpUtilImpl obtenerIpUtilImpl;

    /**
     * Init
     * @author Ariatna Lucelly López Euán (allopez@inet.procesar.com.mx)
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * Método de prueba para la obtenncion de las cabeceras HTTP.
     * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerInformacionCabecera() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "192.168.9.41");
        request.addHeader("Accept", "text/plain");
        assertNotNull(obtenerIpUtilImpl.obtenerInformacionCabecera(request));
    }

    /**
     * Método de prueba para la obtenncion de las cabeceras HTTP.
     * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerDireccionIpCliente_CabeceraNoNula() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "192.168.9.41");
        request.addHeader("Accept", "text/plain");
        assertNotNull(obtenerIpUtilImpl.obtenerDireccionIpCliente(request));
    }

    /**
     * Método de prueba para obtener la IP del cliente.
     * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerDireccionIpCliente() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Assert.assertNotNull(obtenerIpUtilImpl.obtenerDireccionIpCliente(request));
    }

    /**
     * Método de prueba cuando ocurre un error al obtener la dirección IP del cliente.
     * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerDireccionIpClienteError() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "");
        try {
            obtenerIpUtilImpl.obtenerDireccionIpCliente(request);
        } catch(Exception e) {
            Assert.assertNotNull(e);
        }
    }

}
