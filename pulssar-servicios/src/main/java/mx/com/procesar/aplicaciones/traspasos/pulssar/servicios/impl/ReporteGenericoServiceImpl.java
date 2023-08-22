package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ParametroRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ReporteGenericoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Implementacion de metodos de operaciones en catalogo de reportes genericos
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@Service
public class ReporteGenericoServiceImpl implements ReporteGenericoService {

    /**
     * Log de la clase
     */
    private static final Logger logger = LoggerFactory.getLogger(ReporteGenericoServiceImpl.class);

    /**
     * Instancia al repositorio de reporte generico
     */
    @Autowired
    private ReporteGenericoRepository reporteGenericoRepository;

    /**
     * Instancia para recuperacion de parametros de consulta generica
     */
    @Autowired
    private ParametroRepository parametroRepository;

    /**
     * Referencia para clase de utileria
     */
    @Autowired
    private CadenasUtils cadenasUtils;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.servicios.sistema.minerva.servicios.ReporteGenericoService#
     * obtenerListaReportesPorSubprocesoTipoReporte(java.lang.Long, java.lang.Long,
     * java.lang.Integer)
     */
    @Override
    public List<ReporteCompleto> obtenerListaReportesPorSubprocesoTipoReporte(Long idSubproceso, Long idTipoReporte, Integer tipoProcesamiento, String idRoles)
        throws PlataformaServiciosOperativaServiceException {
        List<ReporteCompleto> listaReport = new ArrayList<>();
        Set<ReporteGenerico> reportes = new HashSet<>();
        List<String> idRolesLista = new ArrayList<>();
        String[] clavesRol = idRoles.split(",");
        for (String idRol : clavesRol) {
            idRol = cadenasUtils.eliminarCorchetes(idRol);
            idRolesLista.add(idRol);
            logger.info("strListaRol {}", idRol);
        }
        for (String idRol : idRolesLista) {
            reportes.addAll(reporteGenericoRepository.obtenerListaReportesPorSubprocesoTipoReporte(idSubproceso, idTipoReporte, tipoProcesamiento, idRol,
                ServiciosConstants.CONST_CATALOGO_ACTIVO));
        }
        for (ReporteGenerico report : reportes) {
            ReporteCompleto reporte = recuperarParametrosSubReportes(report);
            listaReport.add(reporte);
        }
        return listaReport;
    }

    /**
     * Metodo que recupera los parametros y subreportes del reporte principal
     * @author hjramire
     * @param reporteGenerico
     * @return ReporteCompleto
     * @since 15/01/2020, 18:05:45
     */
    private ReporteCompleto recuperarParametrosSubReportes(ReporteGenerico reporteGenerico) {
        ReporteCompleto reporte = new ReporteCompleto();
        reporte.setReporte(reporteGenerico);
        List<ParametroReporte> parametros =
            parametroRepository.getByIdReporteGenericoAndTipoParametro(reporteGenerico.getIdReporteGenerico(), "SQL", new Sort(Direction.ASC, "secuencia"));
        logger.info("numero de parametros: {}", parametros.size());
        logger.info("Paramestros:{}", parametros);
        reporte.setListaParametros(parametros);
        // recuperaSubreportes
        List<ReporteGenerico> listaSubReportes =
            reporteGenericoRepository.findByIdReportePadre(reporteGenerico.getIdReporteGenerico(), new Sort(Direction.ASC, "orden"));
        logger.info("numero de subReportes encontrados: {}", listaSubReportes.size());
        logger.info("subconsultas:{}", listaSubReportes);
        reporte.setListaSubreportes(listaSubReportes);
        return reporte;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.servicios.sistema.minerva.servicios.ReporteGenericoService#
     * obtenerTotalReportesPorSubprocesoTipoReporte(java.lang.Long, java.lang.Long)
     */
    @Override
    public List<ReporteGenerico> obtenerTotalReportesPorSubprocesoTipoReporte(Long idSubproceso, Long idTipoReporte)
        throws PlataformaServiciosOperativaServiceException {
        List<ReporteGenerico> reporteGenerico;
        Long opcionTodos = Long.valueOf(0);

        if (opcionTodos.equals(idTipoReporte)) {
            reporteGenerico = reporteGenericoRepository.getByIdSubproceso(idSubproceso);
        } else {
            reporteGenerico = reporteGenericoRepository.getByIdSubprocesoAndIdTipoReporte(idSubproceso, idTipoReporte);
        }
        return reporteGenerico;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.retiros.cifrascontrol.biometricos.servicios.
     * solicitudreporte. SolicitudReporteService#obtenerTipoReportePorClave(java.lang.String)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager")
    public ReporteCompleto obtenerTipoReportePorClave(Long cvTipoReporte) throws PlataformaServiciosOperativaServiceException {
        logger.info("inicia obtenerTipoReportePorClave:{}", cvTipoReporte);
        ReporteGenerico reporteGenerico = reporteGenericoRepository.getByIdReporteGenerico(cvTipoReporte);
        return recuperarParametrosSubReportes(reporteGenerico);
    }

}
