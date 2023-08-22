package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;

/**
 * Servicio que expone los metodos de acceso los datos de reportes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@Service
public class PlataformaOperativaServiceImpl implements PlataformaOperativaService {

    /**
     * Log
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlataformaOperativaServiceImpl.class);

    /**
     * Atirbuto utilizado para la ejecucion de servicios rest
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Url para la consulta de reportes en pantalla
     */
    @Value("${url.plataforma.servicios.consulta.reporte}")
    private String urlConsultaReporte;

    /**
     * Url para la consulta de reportes jasper
     */
    @Value("${url.plataforma.servicios.consulta.reporte.jasper}")
    private String urlConsultaReporteJasper;

    /**
     * Url para la consulta de reportes masivos
     */
    @Value("${url.plataforma.servicios.consulta.masivos}")
    private String urlConsultaMasivos;

    /**
     * Url para la consulta de solicitudes
     */
    @Value("${url.plataforma.servicios.consulta.solicitud}")
    private String urlConsultaSolicitud;

    /**
     * Url para la descarga de reportes masivos
     */
    @Value("${url.plataforma.servicios.descarga.reporte.masivo}")
    private String urlDescargaReporteMasivo;

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService#consultaReporte(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public ResponseEntity<RespuestaJson> consultaReporte(String usuarioLogueado, String nombreReporte, String fechaInicio,
        String fechaFin, String nss, String curp, String idProcesar) {
        ResponseEntity<RespuestaJson> response;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(ServiciosConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlConsultaReporte)
                .queryParam(ServiciosConstants.USUARIO_LOGUEADO, usuarioLogueado)
                .queryParam(ServiciosConstants.NOMBRE_REPORTE, nombreReporte)
                .queryParam(ServiciosConstants.FECHA_INICIAL, fechaInicio)
                .queryParam(ServiciosConstants.FECHA_FINAL, fechaFin)
                .queryParam(ServiciosConstants.NSS, nss)
                .queryParam(ServiciosConstants.CURP, curp)
                .queryParam(ServiciosConstants.ID_PROCESAR, idProcesar);
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, RespuestaJson.class);
        } catch(RestClientException ex) {
            response = null;
            LOG.error("Error en consulta reporte ", ex);
        }
        return response;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService#consultaReporteJasper(java.util.Map)
     */
    @Override
    public ResponseEntity<RespuestaJson> consultaReporteJasper(Map<String, String> params) {
        ResponseEntity<RespuestaJson> response;
        try {
            StringBuilder urlParametros = new StringBuilder();
            urlParametros.append(urlConsultaReporteJasper).append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlParametros.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlParametros.deleteCharAt(urlParametros.length() - 1);
            HttpHeaders headers = new HttpHeaders();
            headers.set(ServiciosConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
            response = restTemplate.exchange(urlParametros.toString(), HttpMethod.GET, httpEntity, RespuestaJson.class);
        } catch(RestClientException ex) {
            response = null;
            LOG.error("Error en consulta reporte jasper ", ex);
        }
        return response;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService#consultaMasivos(java.lang.String, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios)
     */
    @Override
    public ResponseEntity<RespuestaJson> consultaMasivos(String usuarioLogueado, DatosConsultaPlataformaServicios datosConsultaMasiva) {
        ResponseEntity<RespuestaJson> response;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(ServiciosConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<DatosConsultaPlataformaServicios> httpEntity = new HttpEntity<>(datosConsultaMasiva, headers);
            UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(urlConsultaMasivos).queryParam(ServiciosConstants.USUARIO_LOGUEADO, usuarioLogueado);
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, httpEntity, RespuestaJson.class);
        } catch(RestClientException ex) {
            response = null;
            LOG.error("Error en consulta masivos ", ex);
        }
        return response;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService#consultaSolicitud(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public ResponseEntity<RespuestaJson> consultaSolicitud(String areas, String numSolicitudSel, String idEstado, String fechaInicio,
        String fechaFin) {
        ResponseEntity<RespuestaJson> responseEntity;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(ServiciosConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlConsultaSolicitud);

            concatenarParametro("areas", areas, builder);
            concatenarParametro("numSolicitudSel", numSolicitudSel, builder);
            concatenarParametro("idEstadoSel", idEstado, builder);
            concatenarParametro("fechaInicio", fechaInicio, builder);
            concatenarParametro("fechaFin", fechaFin, builder);
            responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, RespuestaJson.class);
        } catch(RestClientException ex) {
            responseEntity = null;
            LOG.error("Error en consulta solicitud ", ex);
        }
        return responseEntity;
    }

    /**
     * Metodo que concatena el nombre y valor de un parametro si el valor no es nulo ni vacio
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param nombreParametro Nombre del parametro
     * @param valorParametro Cadena que se desea concatenar
     * @param builder Objeto al que se le agregara la ceda
     */
    private void concatenarParametro(String nombreParametro, String valorParametro, UriComponentsBuilder builder) {
        if (valorParametro != null && valorParametro.length() > 0) {
            builder.queryParam(nombreParametro, valorParametro);
        }
    }
}
