package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ReporteTipoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteTipoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Implementacion de consulta de tipos de reporte
 * 
 * @author EMARTINEZ
 */
@Service
public class ReporteTipoServiceImpl implements ReporteTipoService {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ReporteTipoServiceImpl.class);

    /**
     * Repositorio de tipo de reportes
     */
    @Autowired
    private ReporteTipoRepository reporteTipoRepository;

    /**
     * Referencia para clase de utileria
     */
    @Autowired
    private CadenasUtils cadenasUtils;

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.servicios.core.sistema.minerva.servicios.
     * ReporteSubProcesosService#
     * recuperaSubprocesosPorIdProcesoNegocio(java.lang.Long)
     */
    @Override
    public List<RolReporteTipo> recuperarTipoDeReporteIdSubproceso(String clavesRol, Long idSubProceso)
        throws PlataformaServiciosOperativaServiceException {
        logger.info("Inicia servicio -> recuperaTipoDeReporteIdSubproceso( {} {} )", clavesRol, idSubProceso);
        Set<RolReporteTipo> tipoReporte = new HashSet<>();
        try {
            List<String> idRolesLista = new ArrayList<>();
            String[] strListaRol = clavesRol.split(",");
            for (String claveRol : strListaRol) {
                claveRol = cadenasUtils.eliminarCorchetes(claveRol);
                idRolesLista.add(claveRol);
                logger.info("strListaRol {}", claveRol);
            }
            for (String idRol : idRolesLista) {
                tipoReporte.addAll(reporteTipoRepository.findByIdRolAndSubproceso(idRol, idSubProceso, ServiciosConstants.CONST_CATALOGO_ACTIVO));
                logger.info("reporteTipoRepository {}", tipoReporte);
            }
        } catch(Exception e) {
            logger.error("Error al consultar los subProcesos {}", e);
        }
        logger.info("numero de lista recuperados prueba: {}", tipoReporte.size());
        return new ArrayList<>(tipoReporte);
    }
}