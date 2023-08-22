/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaGeneraNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipGeneracionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipReplicaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipSolicitudService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Proceo completo de solicitud de Generaci�n de NIPs
 * RFC: WB00288
 */
@Service("nipSolicitudService")
public class NipSolicitudServiceImpl implements NipSolicitudService {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(NipSolicitudServiceImpl.class);
	
	/** Constante representa uno de los dos resultados posibles para el servicio en: confirmacionTransaccion*/
	private static final String RESPUESTA_EXITO_SERVICIO = "01";
	
	/** Constante representa uno de los dos resultados posibles para el servicio en: confirmacionTransaccion*/
	private static final String RESPUESTA_ERROR_SERVICIO = "02";
	
	/** Constante num�rica*/
	private static final Integer CONTANTE_UNO = 1;
	
	/** Constante num�rica */
	private static final Integer CONTANTE_CERO = 0;
		
	/** Obtiene el NIP desde el servicio correspondiente */
	@Autowired
	private NipGeneracionService nipGeneracionService;
	
	/** Servicio de replica de informaci�n para afores */
	@Autowired
	private NipReplicaService nipReplicaService;
	
	/**
	 * Proceos completo de solicitud de Generaci�n de NIPs
	 * @param datosEntradaNip
	 * @param usuarioModificador
	 * @param folio
	 * @param sucursar
	 * @return RespuestaGeneraNip
	 * @throws BusinessException
	 */
	@Override
	public RespuestaGeneraNip solicitarNIP(GeneraNIP datosEntradaNip, String usuarioModificador,
			String folio, String sucursal) throws BusinessException {

		logger.info("[solicitarNIP] - Solicitud de generaci�n de NIP: {}", datosEntradaNip);
		RespuestaGeneraNip salida = null;
		try {
			// Obtener Hora de la solicitud:
			Date fechaHoraSolicitud = new Date();
			
			// Generar Nip v�a servicio
			RespuestaServicioNip respuestaServicio =
					nipGeneracionService.generarNIP(datosEntradaNip);
			// Validar respuesta
			salida = obtenerRespuestaDeGeneracionDeNIP(respuestaServicio);
			
			if (CONTANTE_UNO == salida.getFlujo() || 
					(respuestaServicio != null && respuestaServicio.getDescripcionRechazo() != null)) {
				// Servicio de Notificaci�n por Replica de BD
				replicarEnAfore(respuestaServicio, datosEntradaNip, fechaHoraSolicitud, 
						usuarioModificador, folio, sucursal);
			}
		} catch (BusinessException be) {
			logger.error("[solicitarNIP] - [Servicio Genera NIP] - Error: {}", be.getMessage());
			salida = new RespuestaGeneraNip();
			salida.setMensaje(be.getMessage());
			salida.setFlujo(CONTANTE_CERO);
		}
		logger.info("[solicitarNIP] - Salida - Solicitud de generaci�n de NIP: {}", salida);
		return salida;
	}
	
	/**
	 * Replica a BD para las afores la confirmaci�nd egneraci�n de NIP
	 * @param datosReplicaNip
	 * @throws BusinessException
	 */
	private void replicarEnAfore(RespuestaServicioNip respuestaServicio, GeneraNIP datosEntradaNip,
			Date fechahoraSoliciutd, String usuarioModificador, String folio, String sucursal) {
		// NOTA: 29/03/2022. malopezt. Se separa el servicio de r�plica. Es decir, el �xito o fracaso del mimso
		// NO Debe ser considerado en la respuesta que se da generaci�n de Nip.
		// Aunque en principio se solicitaba que se ejecutara todo el flujo antes de dar una respuesta.
		try {
			nipReplicaService.guardarReplicaNip(respuestaServicio, datosEntradaNip,
				fechahoraSoliciutd, usuarioModificador, folio, sucursal);
		} catch (Exception e ) { // Cualquier excepci�n generada solo ser� reportada en log
			// NOTA: 29/03/2022. Palabras de Chelita: Al usuario y al agente no les interesa la informaci�n a enviar al operativo
			// malopezt: A nivel arquitectura y tecnol�gico: Sigue presente el problema de inconsistencia. Podr� darse el caso de que se genere nip
			// pero si el servicio de Notificaci�n no reseulve, no habr� notificaci�n. Generando una inconsistencia
			// en la r�plica enviada, a la afore, pues estar� incompleta. 
			logger.error("[replicarEnAfore] - Error al consumir servicio de notificaci�n de generaci�n de nip", e);
		}
	}
	
	/**
	 * Traduce a negocio la respuesta del servicio de generaci�n de NIP
	 * @param respuestaServicioNip
	 * @return RespuestaServicioNip
	 */
	private RespuestaGeneraNip obtenerRespuestaDeGeneracionDeNIP(RespuestaServicioNip respuestaServicioNip) {
		
		RespuestaGeneraNip salida = new RespuestaGeneraNip();
		try {
			if (RESPUESTA_EXITO_SERVICIO.equals(respuestaServicioNip.getConfirmacionTransaccion())) {
				salida.setMensaje("La solicitud de generaci�n del NIP se concluy� con �xito");
				salida.setFlujo(CONTANTE_UNO);
				logger.info("[obtenerNIP][interpretarRespuesta]- Salida: {}", salida);
			} else if (RESPUESTA_ERROR_SERVICIO.equals(respuestaServicioNip.getConfirmacionTransaccion()))  {
				salida.setMensaje("La solicitud de generaci�n de NIP no se pudo realizar, derivado de lo siguiente: ");
				salida.setMensaje(salida.getMensaje().concat(respuestaServicioNip.getDescripcionRechazo()));
				salida.setFlujo(CONTANTE_CERO);
		    } else {
				salida.setMensaje("Servicio de generaci�n de NIP con respuesta no esperada");
				salida.setFlujo(CONTANTE_CERO);
				logger.error("[obtenerNIP][interpretarRespuesta]- Error - Salida: {}", salida);
			}
		} catch ( Exception e ) { // No fue posible obtener el objeto: RespuestaServicioNip
			salida.setMensaje("Servicio de generaci�n de NIP con respuesta no esperada");
			salida.setFlujo(CONTANTE_CERO);
			logger.error("[obtenerNIP][interpretarRespuesta]- Error - Servicio de generaci�n de NIP con respuesta no esperada.", e);
		}
		return salida;
	}
}
