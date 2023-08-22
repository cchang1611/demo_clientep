package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TipoReporteRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.TipoReporteMasivoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Implementacion de metodos de operaciones sobre repositorio de Tipo Reporte
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 11:54:34
 */
@Service
public class TipoReporteServiceImpl implements TipoReporteService {

	/**
	 * Instancia de repositorio de Tipo Reporte
	 */
	@Autowired
	private TipoReporteRepository tipoReporteRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.servicios.core.sistema.minerva.servicios.TipoReporteService#
	 * obtenerTipoArchivo(java.lang.String)
	 */
	public TipoReporteMasivoEnum obtenerTipoArchivo(String tipoArchivo) {
		TipoReporteMasivoEnum tipoReporte = null;
		if (tipoArchivo != null && !tipoArchivo.isEmpty()) {
			TipoReporteMasivoEnum[] roles = TipoReporteMasivoEnum.values();
			for (TipoReporteMasivoEnum tipoReporteEnum : roles) {
				if (tipoReporteEnum.getCvTipoReporte() == Integer.valueOf(tipoArchivo)) {
					tipoReporte = tipoReporteEnum;
					break;
				}
			}
		}
		return tipoReporte;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.sistema.minerva.servicios.TipoReporteService#
	 * recuperarTotalDeTiposReportePorFlujo(int)
	 */
	@Override
	public List<TipoReporte> recuperarTotalDeTiposReportePorFlujo(int flujoBatchLinea)
			throws PlataformaServiciosOperativaServiceException {
		return tipoReporteRepository.getByFlujoBatchAndActivo(flujoBatchLinea,
				ServiciosConstants.CONST_CATALOGO_ACTIVO);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.sistema.minerva.servicios.TipoReporteService#
	 * recuperarTotalDeTiposReporte()
	 */
	@Override
	public List<TipoReporte> recuperarTotalDeTiposReporte() throws PlataformaServiciosOperativaServiceException {
		return tipoReporteRepository.findAll();
	}

}
