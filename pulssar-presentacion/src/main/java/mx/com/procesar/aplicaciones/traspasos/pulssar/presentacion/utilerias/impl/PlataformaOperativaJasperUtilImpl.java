package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.PresentacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PlataformaOperativaJasperUtil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaPdfPlataformaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * Implementacion de utilería para la generación de Exceles con Plantillas
 * Jasper
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
@Component("plataformaOperativaJasperUtil")
public class PlataformaOperativaJasperUtilImpl implements PlataformaOperativaJasperUtil {

    /**
     * Log de la clase
     */
    private static final Logger log = LoggerFactory.getLogger(PlataformaOperativaJasperUtilImpl.class);

    /**
     * Instancia de servicio de parametros de Reporte
     */
    @Autowired
    private ParametroReporteService parametroReporteService;

    /**
     * Utileria para el procesamiento de fechas
     */
    @Autowired
    private FechaUtils fechaUtils;

    /**
     * Paquete de entidades a cargar
     */
    @Value("${plataforma.operativa.jasper.path}")
    private String rutaArchivoReport;

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.
     * utilerias. PlataformaOperativaJasperUtil#
     * generaReporteConPlatilla(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.
     * modelo. RespuestaExcelPlataformaOperativa)
     */
    @Override
    public void generaReporteConPlatilla(HttpServletRequest request, BufferedOutputStream output,
        RespuestaPdfPlataformaOperativa respuestaPdfPlataformaOperativa, String nombreReporte, ServletOutputStream outputStream)
        throws JRException {
        Map<String, Object> parametersMap = new HashMap<>();
        JasperReport reporte;
        JasperPrint jasperPrint;

        // Se carga Plantilla de Jasper
        StringBuilder nombreArchivoReport = new StringBuilder().append(rutaArchivoReport)
            .append(respuestaPdfPlataformaOperativa.getReporte().getReporte().getNombreArchivoJasper());
        reporte = (JasperReport) JRLoader.loadObjectFromFile(nombreArchivoReport.toString());
        log.info("El archivo {} se cargo con exito.", nombreReporte);
        // carga parametros de plantilla
        cargarParametrosReportes(parametersMap, respuestaPdfPlataformaOperativa, request);
        // carga reporte padre
        ByteArrayInputStream jsonStreamPadre = new ByteArrayInputStream(respuestaPdfPlataformaOperativa.getInformacionReporte()
            .get(respuestaPdfPlataformaOperativa.getReporte().getReporte().getNombreReporte().trim())
            .getBytes());
        JsonDataSource jsonDataSourcePadre = new JsonDataSource(jsonStreamPadre);

        // carga de subreportes
        for (ReporteGenerico subreporte : respuestaPdfPlataformaOperativa.getReporte().getListaSubreportes()) {

            ByteArrayInputStream jsonStream = new ByteArrayInputStream(
                respuestaPdfPlataformaOperativa.getInformacionReporte().get(subreporte.getNombreReporte().trim()).getBytes());
            JsonDataSource jsonDataSource = new JsonDataSource(jsonStream);
            parametersMap.put(subreporte.getNombreReporte(), jsonDataSource);
        }

        jasperPrint = JasperFillManager.fillReport(reporte, parametersMap, jsonDataSourcePadre);
        JRXlsxExporter exporter = new JRXlsxExporter();
        log.info("Concluyendo la configuracion del reporte...");
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setOnePagePerSheet(true);
        config.setDetectCellType(true);
        config.setCollapseRowSpan(false);
        config.setWhitePageBackground(false);

        exporter.setConfiguration(config);

        exporter.exportReport();
    }

    /**
     * Metodo con logica de negocio que tenermina el valor de los parametros
     * estaticos
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param parametersMap
     * @param respuestaPdfPlataformaOperativa
     * @param request
     * @since 27/07/2020
     */
    private void cargarParametrosReportes(Map<String, Object> parametersMap,
        RespuestaPdfPlataformaOperativa respuestaPdfPlataformaOperativa, HttpServletRequest request) {
        // Se cargan parametros de plantilla
        List<ParametroReporte> parametrosReporte = parametroReporteService.recuperarListaParametrosPorIdReportePadreTipoReporte(
            respuestaPdfPlataformaOperativa.getReporte().getReporte().getIdReporteGenerico(), "JRX");
        for (ParametroReporte parametroReporte : parametrosReporte) {
            switch (parametroReporte.getNombre().toUpperCase()) {
                case "SUBREPORT_DIR":
                    parametersMap.put(parametroReporte.getNombre(), rutaArchivoReport);
                    break;
                case "LOGO":
                    parametersMap.put(parametroReporte.getNombre(),
                        request.getServletContext().getResourceAsStream(PresentacionConstants.RUTA_LOGO));
                    break;
                case "FECHA":
                    String fechaActual = fechaUtils.convertirFechaACadena(new Date(), PresentacionConstants.FORMATO_FECHA_JASPER);
                    parametersMap.put(parametroReporte.getNombre(), fechaActual);
                    break;
                default:
                    parametersMap.put(parametroReporte.getNombre(),
                        respuestaPdfPlataformaOperativa.getParametros().get(parametroReporte.getNombre()));
                    break;
            }

        }
    }

}
