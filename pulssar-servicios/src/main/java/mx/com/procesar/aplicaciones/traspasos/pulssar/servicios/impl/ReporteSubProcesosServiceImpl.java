package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ReportesSubprocesosRespository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteSubProcesosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Implementacion de metodos de operacion en repositorio de Subproceso
 * 
 * @author DHSANCHEZ
 * @version 1.0
 */
@Service
public class ReporteSubProcesosServiceImpl implements ReporteSubProcesosService {

    /**
     * Log de la clase
     */
    private static final Logger logger = LoggerFactory.getLogger(ReporteSubProcesosServiceImpl.class);

    /**
     * Instancia del repositorio de Subproceso
     */
    @Autowired
    private ReportesSubprocesosRespository reporteSubProcesosRepository;

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
    public List<RolReporteSubProceso> recuperarSubprocesosPorIdProceso(String idRoles, Long idProceso)
        throws PlataformaServiciosOperativaServiceException {
        logger.info("Inicia servicio -> recuperaSubprocesosPorIdProceso( {} {} )", idRoles, idProceso);
        Set<RolReporteSubProceso> subProceso = new HashSet<>();
        try {
            List<String> idRolesLista = new ArrayList<>();
            String[] strListaRol = idRoles.split(",");
            for (String idRol : strListaRol) {
                idRol = cadenasUtils.eliminarCorchetes(idRol);
                idRolesLista.add(idRol);
                logger.info("strListaRol {}", idRol);
            }
            for (String idRol : idRolesLista) {
                subProceso.addAll(reporteSubProcesosRepository.findByIdRolAndProceso(idRol, idProceso, ServiciosConstants.CONST_CATALOGO_ACTIVO));
                logger.info("reporteProcesoRepository {}", subProceso);
            }
        } catch(Exception e) {
            logger.error("Error al consultar los subProcesos {}", e);
        }
        logger.info("numero de lista recuperados prueba: {}", subProceso.size());
        return new ArrayList<>(subProceso);
    }
}
