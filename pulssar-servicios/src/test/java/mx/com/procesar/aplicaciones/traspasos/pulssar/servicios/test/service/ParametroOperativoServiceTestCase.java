/**
 * ParametroOperativoServiceTestCase.java
 * Fecha de creación: 17/05/2021, 18:25:13
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroOperativoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaToken;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruebas unitarias del servicio de Parametros Operativos
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class ParametroOperativoServiceTestCase {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ParametroOperativoServiceTestCase.class);

    /**
     * Servicio de consulta de parametros operativos
     */
    @InjectMocks
    @Autowired
    private ParametroOperativoService parametroOperativoService;

    /**
     * Objeto utilizado para la invocacion del servicio rest de gurdado de datos del Token
     */
    @Mock
    private RestTemplate restTemplate;

    /**
     * Inicializa los elementos para la prueba.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 
     * Prueba de flujo basico de metodo que guarda la informacion de un token de usuario
     * @author hjramire void
     * @since 03/01/2020, 12:10:58
     */
    @Test
    public void testObtenerTipoArchivo() {

        try {
            DatosEntradaToken datosToken = new DatosEntradaToken();
            datosToken.setToken("RESPUESTA_NULA");
            RespuestaJson body = new RespuestaJson();
            body.setDatos("ok");
            ResponseEntity<RespuestaJson> value = new ResponseEntity<>(body, HttpStatus.OK);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class),
                Mockito.eq(RespuestaJson.class))).thenReturn(value);
            RespuestaJson respuesta = parametroOperativoService.guardarTokenUsuario(datosToken);
            assertNotNull(respuesta);

        } catch(Exception e) {
            LOGGER.error("Error en prueba: {}", e);
            fail("Error en la prueba");
        }

    }

    /**
     * 
     * Prueba de flujo basico de metodo que guarda la informacion de un token de usuario
     * @author hjramire void
     * @since 03/01/2020, 12:10:58
     */
    @Test
    public void testObtenerTipoArchivo_RespuestaNula() {

        try {
            DatosEntradaToken datosToken = new DatosEntradaToken();
            datosToken.setToken("RESPUESTA_NULA");
            RespuestaJson body = new RespuestaJson();
            body.setDatos("ok");
            ResponseEntity<RespuestaJson> value = null;
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class),
                Mockito.eq(RespuestaJson.class))).thenReturn(value);
            RespuestaJson respuesta = parametroOperativoService.guardarTokenUsuario(datosToken);
            assertNull(respuesta);

        } catch(Exception e) {
            LOGGER.error("Error en prueba: {}", e);
            fail("Error en la prueba");
        }

    }

    /**
     * 
     * Prueba de flujo basico de metodo que guarda la informacion de un token de usuario
     * @author hjramire void
     * @since 03/01/2020, 12:10:58
     */
    @Test
    public void testObtenerTipoArchivo_ExcepcionServicio() {

        try {
            DatosEntradaToken datosToken = new DatosEntradaToken();
            datosToken.setToken("RESPUESTA_NULA");
            RespuestaJson body = new RespuestaJson();
            body.setDatos("ok");
            ResponseEntity<RespuestaJson> value = null;
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class),
                Mockito.eq(RespuestaJson.class))).thenThrow(new RuntimeException("Error en al servicio"));
            RespuestaJson respuesta = parametroOperativoService.guardarTokenUsuario(datosToken);
            assertNull(respuesta);

        } catch(Exception e) {
            LOGGER.error("Error en prueba: {}", e);
            fail("Error en la prueba");
        }

    }

}
