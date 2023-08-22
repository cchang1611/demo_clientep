package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.DetalleSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.DetalleSolicitudRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DetalleSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;





/**
 * Implementacion de servicio de detalle de solicitudes
 * 
 * @author hjramire
 * @version 1.0
 * @since 10/01/2020, 18:51:43
 */
@Service
public class DetalleSolicitudServiceImpl implements DetalleSolicitudService {

	/**
	 * Instancia de repositorio de Detalle de Solicitud
	 */
	@Autowired
	private DetalleSolicitudRepository detalleRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.servicios.sistema.minerva.servicios.DetalleSolicitudService#
	 * recuperarListaDetalleSolicitudPorParams(java.lang.String, java.lang.Long,
	 * java.lang.Long, java.util.Date, java.util.Date)
	 */
	@Override
	public List<DetalleSolicitud> recuperarListaDetalleSolicitudPorParams(String areaUsuario, Long numSolicitud, Long idEstado,
		Date fechaInicio, Date fechaFin) throws PlataformaServiciosOperativaServiceException {
		List<DetalleSolicitud> listaDetallesSolicitud = new ArrayList<>();
		Long numSolicitudConsulta = numSolicitud.equals(ServiciosConstants.SOLICITUD_ID_NULO) ? null : numSolicitud;

		String[] areas = areaUsuario.split(",");
		for (String idModulo : areas) {
			if (fechaInicio != null && fechaFin != null) {
				listaDetallesSolicitud.addAll(detalleRepository.recuperarDetallesDeSolicitudFechas(numSolicitudConsulta, idEstado,
					fechaInicio, fechaFin, Long.valueOf(idModulo)));
			} else {
				listaDetallesSolicitud
					.addAll(detalleRepository.recuperarDetallesDeSolicitudEstado(numSolicitudConsulta, idEstado, Long.valueOf(idModulo)));
			}
		}
		return listaDetallesSolicitud;
	}

}
