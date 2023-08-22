package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ProcesoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;


/**
 * Implementacion de metodos de operaciones en catalogo de Proceso
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@Service
public class ProcesoServiceImpl implements ProcesoService {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProcesoServiceImpl.class);

	/**
	 * Instancia de repositorio de Proceso
	 */
	@Autowired
	private ProcesoRepository procesoRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.core.sistema.minerva.servicios.
	 * ProcesoNegocioService# recuperaProcesosPorIdModulo(java.lang.Long)
	 */
	@Override
	public List<ProcesoNegocio> recuperaProcesosPorIdModulo(Long idModulo) throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia servicio -> recuperaProcesosPorIdModulo( {} )", idModulo);
		return procesoRepository.getByIdModuloAndActivo(idModulo, ServiciosConstants.CONST_CATALOGO_ACTIVO);
	}

}
