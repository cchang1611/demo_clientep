package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.SolicitudReporteRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Implementacion de servicio de administracion de solicitudes de reportes
 * masivos
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:54:35
 */
@Service
public class SolicitudReporteServiceImpl implements SolicitudReporteService {

    /**
     * Log de la calse
     */
    private static final Logger logger = LoggerFactory.getLogger(SolicitudReporteServiceImpl.class);

    /**
     * Instancia de repositorio de solicitud de reporte masivo
     */
    @Autowired
    private SolicitudReporteRepository solicitudReporteRepository;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo
     * declara (non-Javadoc)
     * 
     * @see
     * mx.com.procesar.servicios.sistema.minerva.servicios.SolicitudReporteService#
     * generarSolicitudReporte(java.lang.Long, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public SolicitudReporte generarSolicitudReporte(Long idReporteGenerico, String nombreArchivoSolicitud, String rutaArchivoSolicitud)
        throws PlataformaServiciosOperativaServiceException {
        logger.info("Inicia servicio generarSolicitudReporte");
        SolicitudReporte solicitud = new SolicitudReporte();

        TimeZone timeZoneDefault = TimeZone.getDefault();
        Calendar fechaActualCalendar = Calendar.getInstance(timeZoneDefault);
        Date fechaActual = fechaActualCalendar.getTime();
        solicitud.setNumeroSolicitud(generaLlave(idReporteGenerico));
        solicitud.setFechaEnvio(fechaActual);
        solicitud.setFechaProceso(fechaActual);
        solicitud.setIdEstadoSolicitud(ServiciosConstants.SOLICITUD_ESTADO_RECIBIDO);
        solicitud.setIdReporteGenerico(idReporteGenerico);
        solicitud.setNombreArchivoSolicitud(nombreArchivoSolicitud);
        solicitud.setRutaArchivoSolicitud(rutaArchivoSolicitud);
        solicitud.setUsuarioModificador(ServiciosConstants.STR_USUARIO_MODIFICADOR_MASIVOS);
        solicitud.setFechaControl(fechaActual);

        solicitudReporteRepository.saveAndFlush(solicitud);
        logger.info("Termina servicio generarSolicitudReporte");
        return solicitud;
    }

    /**
     * Generador de numero de solicitud
     * 
     * @author hjramire
     * @param idReporte
     * @return String
     * @since 10/01/2020, 18:55:01
     */
    private String generaLlave(Long idReporte) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        TimeZone timeZoneDefault = TimeZone.getDefault();
        Calendar fechaActualCalendar = Calendar.getInstance(timeZoneDefault);
        Date date = fechaActualCalendar.getTime();
        String cadenaTimestamp = sdf.format(date);
        sb.append(idReporte);
        sb.append(cadenaTimestamp);
        return sb.toString();
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo
     * declara (non-Javadoc)
     * 
     * @see
     * mx.com.procesar.servicios.sistema.minerva.servicios.SolicitudReporteService#
     * actualizarEstatusSolicitud(mx.com.procesar.servicios.sistema.minerva.
     * persistencia.entidades.SolicitudReporte, java.lang.Long)
     */
    @Override
    @Transactional
    public void actualizarEstatusSolicitud(SolicitudReporte solicitudReporte, Long idEstatus)
        throws PlataformaServiciosOperativaServiceException {
        solicitudReporte.setIdEstadoSolicitud(idEstatus);
        solicitudReporteRepository.saveAndFlush(solicitudReporte);
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo
     * declara (non-Javadoc)
     * 
     * @see
     * mx.com.procesar.servicios.sistema.minerva.servicios.SolicitudReporteService#
     * recuperarSolicitudes(java.lang.String)
     */
    @Override
    public List<SolicitudReporte> recuperarSolicitudes(String areaUsuario) throws PlataformaServiciosOperativaServiceException {
        List<SolicitudReporte> listaSolicitudes = new ArrayList<>();
        String[] areas = areaUsuario.split(",");
        for (String idModulo : areas) {
            listaSolicitudes.addAll(solicitudReporteRepository.recuperarListaSolicitudReporteLimiteRegistros(idModulo));
        }
        return listaSolicitudes;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo
     * declara (non-Javadoc)
     * 
     * @see
     * mx.com.procesar.servicios.sistema.minerva.servicios.SolicitudReporteService#
     * recuperarSolicitudPorId(java.lang.Long)
     */
    @Override
    public SolicitudReporte recuperarSolicitudPorId(Long id) throws PlataformaServiciosOperativaServiceException {
        return solicitudReporteRepository.getByIdSolicitud(id);
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo
     * declara (non-Javadoc)
     * 
     * @see
     * mx.com.procesar.servicios.sistema.minerva.servicios.SolicitudReporteService#
     * actualizarRegistroSolicitud(mx.com.procesar.servicios.sistema.minerva.
     * persistencia.entidades.SolicitudReporte)
     */
    @Override
    @Transactional
    public SolicitudReporte actualizarRegistroSolicitud(SolicitudReporte solicitudReporte)
        throws PlataformaServiciosOperativaServiceException {
        return solicitudReporteRepository.saveAndFlush(solicitudReporte);
    }

}
