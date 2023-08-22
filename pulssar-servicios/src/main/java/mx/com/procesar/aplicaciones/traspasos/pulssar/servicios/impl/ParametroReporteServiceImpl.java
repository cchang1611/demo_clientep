package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ParametroRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroReporteService;


/**
 * Implementacion de servicios para Parametros de Reporte
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 22/07/2020
 */
@Service
public class ParametroReporteServiceImpl implements ParametroReporteService {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ParametroReporteServiceImpl.class);

	/**
	 * Instancia de repositorio de parametros
	 */
	@Autowired
	private ParametroRepository parametroRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.servicios.ParametroReporteService#
	 * recuperarListaParametrosPorIdReportePadreTipoReporte(java.lang.Long,
	 * java.lang.String)
	 */
	@Override
	public List<ParametroReporte> recuperarListaParametrosPorIdReportePadreTipoReporte(Long idReportePadre,
			String tipoReporte) {
		logger.info("Inicio de recuperarListaParametrosPorIdReportePadreTipoReporte {}, {}", idReportePadre,
				tipoReporte);
		return parametroRepository.getByIdReporteGenericoAndTipoParametro(idReportePadre, "JRX",
				new Sort(Direction.ASC, "secuencia"));
	}

}
