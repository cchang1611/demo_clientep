/**
 * PlataformaOperativaJasperUtilTestCase.java
 * Fecha de creación: 19/05/2021, 17:29:01
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

import static org.junit.Assert.fail;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl.PlataformaOperativaJasperUtilImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReporteGenericoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaPdfPlataformaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * Clase que contiene la pruebas unitarias de la utileria de generacion de reportes Jasper
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
public class PlataformaOperativaJasperUtilTestCase {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlataformaOperativaJasperUtilTestCase.class);

    /**
     * Referencia a ObtenerIputilImpl
     */
    @InjectMocks
    private PlataformaOperativaJasperUtilImpl plataformaOperativaJasperUtil;

    /**
     * Mock de servicio de consulta de parametros
     */
    @Mock
    private ParametroReporteService parametroReporteService;

    /**
     * Instancia servicio de reporte generico
     */
    @Mock
    private ReporteGenericoServiceImpl reporteGenericoService;

    /**
     * Utileria de fechas
     */
    @Mock
    private FechaUtils fechaUtils;

    /**
     * Servlet Output Stream
     */
    @Mock
    private ServletOutputStream servletOutputStream;

    /**
     * Init
     * 
     * @author Ariatna Lucelly López Euán (allopez@inet.procesar.com.mx)
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(plataformaOperativaJasperUtil, "rutaArchivoReport", "src/test/resources/");

    }

    /**
     * Flujo Basico de generador de reporte con platilla Jasper
     * 
     * @author hjramire void
     * @since 20/02/2020, 15:37:11
     */
    @Test
    public void testGeneraReporteConPlatilla() {
        ReporteCompleto reporteCompleto = new ReporteCompleto();
        ReporteGenerico reporteGenerico = new ReporteGenerico();
        reporteGenerico.setNombreArchivoJasper("reporteConfirLiquidTransferencias.jasper");
        reporteGenerico.setNombreReporte("REPORTES DE TRANSFERENCIAS IMSS");
        reporteGenerico.setIdReporteGenerico(1L);
        reporteCompleto.setReporte(reporteGenerico);

        List<ReporteGenerico> listaSubreportes = new ArrayList<>();
        ReporteGenerico subReporteGenerico = new ReporteGenerico();
        subReporteGenerico.setNombreReporte("SUBREPORT_DATA_REPORTE_C");
        listaSubreportes.add(subReporteGenerico);
        reporteCompleto.setListaSubreportes(listaSubreportes);
        try {
            Mockito.when(reporteGenericoService.obtenerTipoReportePorClave(1029L)).thenReturn(reporteCompleto);

            Long idReportePadre = 1L;
            String tipoReporte = "JRX";
            List<ParametroReporte> paramertos = new ArrayList<>();
            Mockito.when(parametroReporteService.recuperarListaParametrosPorIdReportePadreTipoReporte(idReportePadre, tipoReporte))
                .thenReturn(paramertos);

        } catch(PlataformaServiciosOperativaServiceException e1) {
            LOG.error("Error al inicializar el Mock", e1);
        }
        MockHttpServletRequest request = new MockHttpServletRequest();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream output = new BufferedOutputStream(baos);
        RespuestaPdfPlataformaOperativa respuestaPdfMinerva = new RespuestaPdfPlataformaOperativa();
        String nombreReporte = "reporteDummy";

        // SIMULACION DE PARAMETROS DE ENTRADAD DE LA PANTALLA
        Map<String, String> paramUsuario = new HashMap<>();
        paramUsuario.put("FECHA_INICIAL", "01/01/2020");

        // SIMULACION DE RESPUESTA DE CONSULTA
        Map<String, String> infoDummy = new HashMap<>();
        infoDummy.put("REPORTES DE TRANSFERENCIAS IMSS",
            "[{\"nuRet97Tra\":\"30000.5\",\"nuCvCuotaEstaTra\":\"85123.65\",\"nuCuotaSoTra\":\"426.41\",\"nuRet92ImssTra\":\"8769.23\",\"nuViv97Tra\":\"13911.6117\",\"nuPartViv97Inf\":\"578.98\",\"nuMontoRetiro97\":\"212.89\",\"nuMontoCv\":\"30000.5\",\"nuMontoCuotaSocial\":\"30000.5\",\"nuMontoRetiro92\":\"30000.5\",\"nuMontoVivienda97\":\"30000.5\",\"nuPartViv97InfMov\":\"30000.5\"}]");
        infoDummy.put("SUBREPORT_DATA_REPORTE_U", "[]");
        infoDummy.put("SUBREPORT_DATA_REPORTE_C",
            "[{\"nuPartViv97Inf\":\"1\",\"nuMontoCuotaSocial\":\"427.41\",\"nuCvCuotaEstaTra\":\"1\",\"nuViv97Tra\":\"123.12\",\"nuRet92ImssTra\":\"0.00\",\"nuMontoCv\":\"213.89\",\"nuMontoRetiro92\":\"0.00\",\"nuRet97Tra\":\"1.23\",\"nuMontoRetiro97\":\"85124.65\",\"nuMontoVivienda97\":\"48555.12\",\"nuPartViv97InfMov\":\"84719.4589272\",\"chAfore\":\"830 - AFORE XXI BANORTE\",\"nuCuotaSoTra\":\"1\"},{\"nuPartViv97Inf\":\"1\",\"nuMontoCuotaSocial\":\"426.41\",\"nuCvCuotaEstaTra\":\"1\",\"nuViv97Tra\":\"0\",\"nuRet92ImssTra\":\"0.00\",\"nuMontoCv\":\"770886.48\",\"nuMontoRetiro92\":\"0.00\",\"nuRet97Tra\":\"1.02\",\"nuMontoRetiro97\":\"85123.65\",\"nuMontoVivienda97\":\"0\",\"nuPartViv97InfMov\":\"0\",\"chAfore\":\"862 - AFORE INVERCAP\",\"nuCuotaSoTra\":\"1\"},{\"nuPartViv97Inf\":\"0\",\"nuMontoCuotaSocial\":\"426.41\",\"nuCvCuotaEstaTra\":\"1\",\"nuViv97Tra\":\"0\",\"nuRet92ImssTra\":\"0.00\",\"nuMontoCv\":\"212.89\",\"nuMontoRetiro92\":\"0.00\",\"nuRet97Tra\":\"1\",\"nuMontoRetiro97\":\"85123.65\",\"nuMontoVivienda97\":\"48555.12\",\"nuPartViv97InfMov\":\"84719.4589272\",\"chAfore\":\"864 - AFORE METLIFE\",\"nuCuotaSoTra\":\"1\"}]");
        infoDummy.put("SUBREPORT_DATA_REPORTE_BRJP",
            "[{\"NUPARTVIV97INF\":\"0.00\",\"NUMONTORETIRO92NUMONTOVIVIENDA97\":\"0.00\",\"NUPARTVIV97INFMOV\":\"785882.01\",\"NUMONTOCUOTASOCIAL\":\"1279.23\",\"NURET97TRA\":\"0.00\",\"NURET92IMSSTRA\":\"0.00\",\"NUCVCUOTAESTATRA\":\"212.89\",\"NUVIV97TRA\":\"13144.63\",\"CHAFORE\":\"552 - AFORE BANAMEX\",\"NUMONTORETIRO97\":\"0.00\",\"NUMONTOCV\":\"340451.57\",\"NUCUOTASOTRA\":\"426.41\"}]");
        infoDummy.put("SUBREPORT_DATA_REPORTE_B",
            "[{\"NUMONTOVIVIENDA97\":\"0.00\",\"NUVIV97TRA\":\"0.00\",\"CHAFORE\":\"544 - AFORE SURA\",\"NUMONTORETIRO97\":\"0.00\",\"NUMONTOCV\":\"null\",\"NUCUOTASOTRA\":\"426.41\",\"NUMONTORETIRO92\":\"0.00\",\"NUPARTVIV97INF\":\"0.00\",\"NUPARTVIV97INFMOV\":\"0.00\",\"NUMONTOCUOTASOCIAL\":\"null\",\"NURET97TRA\":\"0.00\",\"NURET92IMSSTRA\":\"0.00\",\"NUCVCUOTAESTATRA\":\"212.89\"},{\"NUMONTOVIVIENDA97\":\"0.00\",\"NUVIV97TRA\":\"0.00\",\"CHAFORE\":\"578 - PENSIONISSSTE\",\"NUMONTORETIRO97\":\"0.00\",\"NUMONTOCV\":\"null\",\"NUCUOTASOTRA\":\"426.41\",\"NUMONTORETIRO92\":\"0.00\",\"NUPARTVIV97INF\":\"0.00\",\"NUPARTVIV97INFMOV\":\"0.00\",\"NUMONTOCUOTASOCIAL\":\"null\",\"NURET97TRA\":\"0.00\",\"NURET92IMSSTRA\":\"0.00\",\"NUCVCUOTAESTATRA\":\"212.89\"}]");
        infoDummy.put("SUBREPORT_DATA_REPORTE_A",
            "[{\"NUMONTOVIVIENDA97\":\"48555.12\",\"NUVIV97TRA\":\"999.99\",\"CHAFORE\":\"530 - AFORE XXI BANORTE\",\"NUMONTORETIRO97\":\"85123.65\",\"NUMONTOCV\":\"212.89\",\"NUCUOTASOTRA\":\"1\",\"NUMONTORETIRO92\":\"0.00\",\"NUPARTVIV97INF\":\"0.0012\",\"NUPARTVIV97INFMOV\":\"84719.4589272\",\"NUMONTOCUOTASOCIAL\":\"426.41\",\"NURET97TRA\":\"1\",\"NURET92IMSSTRA\":\"0.00\",\"NUCVCUOTAESTATRA\":\"1\"}]");

        // SE DEFINEN PARAMETROS
        ParametroReporte paramSubReporteDir = new ParametroReporte();
        paramSubReporteDir.setNombre("SUBREPORT_DIR");
        paramSubReporteDir.setTipoCampo("STR");
        paramSubReporteDir.setTipoParametro("JRX");

        ParametroReporte paramLogo = new ParametroReporte();
        paramLogo.setNombre("logo");
        paramLogo.setTipoCampo("STR");
        paramLogo.setTipoParametro("JRX");

        ParametroReporte paramFecha = new ParametroReporte();
        paramFecha.setNombre("fecha");
        paramFecha.setTipoCampo("STR");
        paramFecha.setTipoParametro("JRX");

        ParametroReporte paramFechaInicial = new ParametroReporte();
        paramFechaInicial.setNombre("FECHA_INICIAL");
        paramFechaInicial.setTipoCampo("STR");
        paramFechaInicial.setTipoParametro("JRX");

        List<ParametroReporte> listaParams = new ArrayList<>();
        listaParams.add(paramSubReporteDir);
        listaParams.add(paramLogo);
        listaParams.add(paramFecha);
        listaParams.add(paramFechaInicial);

        try {
            Mockito
                .when(parametroReporteService.recuperarListaParametrosPorIdReportePadreTipoReporte(Mockito.anyLong(),
                    Mockito.anyString()))
                .thenReturn(listaParams);

            ReporteCompleto reporte = reporteGenericoService.obtenerTipoReportePorClave(1029L);

            respuestaPdfMinerva.setParametros(paramUsuario);
            respuestaPdfMinerva.setInformacionReporte(infoDummy);
            respuestaPdfMinerva.setReporte(reporte);

            plataformaOperativaJasperUtil.generaReporteConPlatilla(request, output, respuestaPdfMinerva, nombreReporte,
                servletOutputStream);

        } catch(Exception e) {
            LOG.error("Error en prueba testGeneraReporteConPlatilla: {}", e);
            fail("Error en prueba testGeneraReporteConPlatilla");
        }

    }

}
