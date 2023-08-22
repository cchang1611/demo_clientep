package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ReporteProcesoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PlataformaOperativaConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PlataformaOperativaUtil;

/**
 * Implementacion de consulta de Procesos
 * @author EMARTINEZ
 */
@Service
public class ReporteProcesoServiceImpl implements ReporteProcesoService {

    /**
     * Log de la clase
     */
    private static final Logger log = LoggerFactory.getLogger(ReporteProcesoServiceImpl.class);

    /**
     * Inyeccion de repositorio procesoRepository
     */
    @Autowired
    private ReporteProcesoRepository reporteProcesoRepository;

    /**
     * Referencia para clase de utileria
     */
    @Autowired
    private CadenasUtils cadenasUtils;

    /**
     * Referencia para clase de utilerias comuunes
     */
    @Autowired
    private PlataformaOperativaUtil plataformaOperativaUtil;

    /**
     * Metodo para obtener los procesos por idReporteGenerico y idModulo
     */
    @Override
    public List<RolReporteProceso> recuperaIdProcesoNegocios(String idRoles, Long idModulo, String modulosAsignados) {
        log.info("****************** entra a recuperaIdReportePorRol *****");
        Set<RolReporteProceso> proceso = new HashSet<>();
        try {
            List<String> listaModulos = plataformaOperativaUtil.convertirCadenaALista(modulosAsignados);
            List<Long> idsModulos = plataformaOperativaUtil.convertirALong(listaModulos);
            List<String> clavesRol = new ArrayList<>();
            String[] strListaRol = idRoles.split(PlataformaOperativaConstants.CARACTER_COMA);
            for (String claveRol : strListaRol) {
                claveRol = cadenasUtils.eliminarCorchetes(claveRol);
                clavesRol.add(claveRol);
                log.info("strListaRol {}", claveRol);
            }
            log.info("idRolesLista {}", clavesRol);
            for (String claveRol : clavesRol) {
                if (idsModulos.contains(idModulo)) {
                    proceso.addAll(reporteProcesoRepository.encontrarProcesoPorIdReporteYIdModulo(claveRol, idModulo,
                        ServiciosConstants.CONST_CATALOGO_ACTIVO));
                }
                log.info("reporteProcesoRepository {}", proceso);
            }
        } catch(Exception e) {
            log.error("Error al consultar los procesos {}", e);
        }
        log.info("numero de lista recuperados prueba: {}", proceso.size());
        return new ArrayList<>(proceso);
    }
}
