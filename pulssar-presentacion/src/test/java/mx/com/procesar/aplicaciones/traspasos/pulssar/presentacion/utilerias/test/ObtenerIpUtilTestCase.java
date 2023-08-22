/**
 * ObtenerIpUtilTestCase.java
 * Fecha de creaci�n: 19/05/2021, 13:26:03
 *
 * Copyright (c) 2021 Procesar S A de C V.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
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
     * @author Ariatna Lucelly L�pez Eu�n (allopez@inet.procesar.com.mx)
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * M�todo de prueba para la obtenncion de las cabeceras HTTP.
     * @author Oscar Enrique Gonz�lez Garc�a (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerInformacionCabecera() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "192.168.9.41");
        request.addHeader("Accept", "text/plain");
        assertNotNull(obtenerIpUtilImpl.obtenerInformacionCabecera(request));
    }

    /**
     * M�todo de prueba para la obtenncion de las cabeceras HTTP.
     * @author Oscar Enrique Gonz�lez Garc�a (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerDireccionIpCliente_CabeceraNoNula() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("X-Forwarded-For", "192.168.9.41");
        request.addHeader("Accept", "text/plain");
        assertNotNull(obtenerIpUtilImpl.obtenerDireccionIpCliente(request));
    }

    /**
     * M�todo de prueba para obtener la IP del cliente.
     * @author Oscar Enrique Gonz�lez Garc�a (oegonzal@procesar.com.mx)
     */
    @Test
    public void testObtenerDireccionIpCliente() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Assert.assertNotNull(obtenerIpUtilImpl.obtenerDireccionIpCliente(request));
    }

    /**
     * M�todo de prueba cuando ocurre un error al obtener la direcci�n IP del cliente.
     * @author Oscar Enrique Gonz�lez Garc�a (oegonzal@procesar.com.mx)
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
