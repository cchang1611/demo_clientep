package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ModuloNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ModuloRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModuloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;



/**
 * Implementacion de servicios de Catalogo de Modulo
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 09:13:42
 */
@Service
public class ModuloServiceImpl implements ModuloService {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ModuloServiceImpl.class);

	/**
	 * Instancia de repositorio de Modulo Negocio
	 */
	@Autowired
	private ModuloRepository moduloRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.sistema.minerva.servicios.ModuloService#
	 * recuperarModulosPorArea(java.lang.String)
	 */
	@Override
	public List<ModuloNegocio> recuperarModulosPorArea(String areaUsuario) throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia Servicio -> recuperarModulosPorArea ({})", areaUsuario);
		List<ModuloNegocio> result;

		if (0 < areaUsuario.length()) {
			logger.info("consulta modulos por areas");
			// RECUPERA LISTA DE AREAS
			List<Long> idModulosLista = new ArrayList<>();
			String[] strListaAreas = areaUsuario.split(",");
			for (String idArea : strListaAreas) {
				idModulosLista.add(Long.valueOf(idArea));
			}
			result = moduloRepository.findByModulosIds(idModulosLista);
		} else {
			logger.info("consulta total de modulos");
			result = moduloRepository.recuperarTotalModulos();
		}
		
		logger.info("numero de modulos recuperados: {}", result.size());
		return result;
	}

}
