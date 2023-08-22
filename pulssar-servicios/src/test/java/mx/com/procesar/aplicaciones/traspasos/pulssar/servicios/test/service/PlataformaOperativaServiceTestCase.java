package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.PlataformaOperativaServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Clase que contiene las pruebas unitarios de los metodos de consulta de reportes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class PlataformaOperativaServiceTestCase {

    /**
     * Inyeccion de servicio
     */
    @Autowired
    @InjectMocks
    private PlataformaOperativaService servicioPlataformaOperativa = new PlataformaOperativaServiceImpl();

    /**
     * cliente
     */
    @Mock
    private RestTemplate cliente;

    /**
     * Inicializacion de componentes
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test de serviciomconsultar reporte
     */
    @Test
    public void testConsultaReporte() {
        try {
            ResponseEntity<RespuestaJson> respuesta =
                servicioPlataformaOperativa.consultaReporte("adelacru", "1", "09/06/2014", "10/06/2014", "", "", "");

            assertNotNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de serviciomconsultar reporte, flujo de Excepcion
     */
    @Test
    public void testConsultaReporte_Excepcion() {
        try {
            Mockito.when(cliente.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.<HttpEntity<Void>> any(),
                Mockito.eq(RespuestaJson.class))).thenThrow(new RestClientException("Error al invocar el servicio"));
            ResponseEntity<RespuestaJson> respuesta =
                servicioPlataformaOperativa.consultaReporte("adelacru", "1", "09/06/2014", "10/06/2014", "", "", "");

            assertNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta reporte jasper
     */
    @Test
    public void testConsultaReporteJasper() {
        Map<String, String> parametros = new HashMap<>();
        parametros.put("nombreReporte", "5");
        parametros.put("fechaFin", "");
        parametros.put("fechaInicio", "");
        parametros.put("nss", "");
        parametros.put("idProcesar", "");
        parametros.put("curp", "");

        try {
            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaReporteJasper(parametros);

            assertNotNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta reporte jasper, flujo de Excepcion
     */
    @Test
    public void testConsultaReporteJasper_Excepcion() {
        Map<String, String> parametros = new HashMap<>();
        parametros.put("nombreReporte", "5");
        parametros.put("fechaFin", "");
        parametros.put("fechaInicio", "");
        parametros.put("nss", "");
        parametros.put("idProcesar", "");
        parametros.put("curp", "");

        try {
            Mockito.when(cliente.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.<HttpEntity<Void>> any(),
                Mockito.eq(RespuestaJson.class))).thenThrow(new RestClientException("Error al invocar el servicio"));

            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaReporteJasper(parametros);

            assertNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta reporte masivos
     */
    @Test
    public void testConsultaReporteMasivos() {
        String usuarioLogueado = "adelacru";
        DatosConsultaPlataformaServicios datos = new DatosConsultaPlataformaServicios();
        datos.setReporte("9");
        datos.setModulo("4");
        datos.setProceso("573");
        datos.setSubProceso("909");
        datos.setFechaInicial("22/05/2020");
        datos.setFechaFinal("27/05/2020");
        datos.setTipoArchivo("-1");

        try {
            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaMasivos(usuarioLogueado, datos);

            assertNotNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta reporte masivos, flujo de Excepcion
     */
    @Test
    public void testConsultaReporteMasivos_Excepcion() {
        String usuarioLogueado = "adelacru";
        DatosConsultaPlataformaServicios datos = new DatosConsultaPlataformaServicios();
        datos.setReporte("9");
        datos.setModulo("4");
        datos.setProceso("573");
        datos.setSubProceso("909");
        datos.setFechaInicial("22/05/2020");
        datos.setFechaFinal("27/05/2020");
        datos.setTipoArchivo("-1");

        try {

            Mockito
                .when(cliente.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.<HttpEntity<DatosConsultaPlataformaServicios>> any(), Mockito.eq(RespuestaJson.class)))
                .thenThrow(new RestClientException("Error al invocar el servicio"));
            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaMasivos(usuarioLogueado, datos);

            assertNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta solicitud
     */
    @Test
    public void testConsultaSolicitud() {
        String areas = "1,2,3,4,5,6,7,8,9";
        String numSolicitudSel = "159";

        try {
            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaSolicitud(areas, numSolicitudSel, "", "", "");

            assertNotNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta solicitud
     */
    @Test
    public void testConsultaSolicitudOpciones() {
        String areas = "1,2,3,4,5,6,7,8,9";
        String numSolicitudSel = "159";
        String idEstadoSol = "1";

        try {
            ResponseEntity<RespuestaJson> respuesta =
                servicioPlataformaOperativa.consultaSolicitud(areas, numSolicitudSel, idEstadoSol, "23/12/2019", "24/12/2019");

            assertNotNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test de consulta solicitud, flujo de Excpcion
     */
    @Test
    public void testConsultaSolicitud_Excepcion() {
        String areas = "1,2,3,4,5,6,7,8,9";
        String numSolicitudSel = "159";

        try {
            Mockito
                .when(cliente.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
                    Mockito.<HttpEntity<Void>> any(), Mockito.eq(RespuestaJson.class)))
                .thenThrow(new RestClientException("Error al invocar el servicio"));
            ResponseEntity<RespuestaJson> respuesta = servicioPlataformaOperativa.consultaSolicitud(areas, numSolicitudSel, "", "", "");

            assertNull(respuesta.getBody());
        } catch(Exception e) {
            assertNotNull(e);
        }
    }
}
