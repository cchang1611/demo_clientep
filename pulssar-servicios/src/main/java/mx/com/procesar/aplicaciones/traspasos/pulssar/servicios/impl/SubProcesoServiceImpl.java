package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.SubProcesoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SubProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Implementacion de metodos de operacion en repositorio de Subproceso
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 11:38:48
 */
@Service
public class SubProcesoServiceImpl implements SubProcesoService {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(SubProcesoServiceImpl.class);

	/**
	 * Instancia del repositorio de Subproceso
	 */
	@Autowired
	private SubProcesoRepository subprocesoRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.core.sistema.minerva.servicios.
	 * SubProcesoNegocioService#
	 * recuperaSubprocesosPorIdProcesoNegocio(java.lang.Long)
	 */
	@Override
	public List<SubProcesoNegocio> recuperaSubprocesosPorIdProceso(Long idProceso) throws PlataformaServiciosOperativaServiceException{
		logger.info("Inicia servicio -> recuperaSubprocesosPorIdProcesoNegocio( {} )", idProceso);
		return subprocesoRepository.getByIdProcesoNegocioAndActivo(idProceso, ServiciosConstants.CONST_CATALOGO_ACTIVO);
	}

}
