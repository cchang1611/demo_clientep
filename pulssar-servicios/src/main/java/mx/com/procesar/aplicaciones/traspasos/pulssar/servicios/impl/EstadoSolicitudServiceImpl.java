package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.EstadoSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.EstadoSolicitudRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstadoSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;




/**
 * Implementacion de servicios para estados de solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:52:49
 */
@Service
public class EstadoSolicitudServiceImpl implements EstadoSolicitudService {

	/**
	 * Instancia de repositorio de estados
	 */
	@Autowired
	private EstadoSolicitudRepository estadoRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.servicios.sistema.minerva.servicios.EstadoSolicitudService#
	 * recuperarListaEstadosSolicitud()
	 */
	@Override
	public List<EstadoSolicitud> recuperarListaEstadosSolicitud() throws PlataformaServiciosOperativaServiceException {
		return estadoRepository.findAll();
	}

}
