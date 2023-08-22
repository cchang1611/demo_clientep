/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SolicitudServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipGeneracionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RechazosGeneracionNipEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.CovierteJSONStringEnObjeto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Proceos de Generación de NIPs - Consume Servicio NIP
 * RFC: WB00288
 */
@Service("nipGeneracionService")
public class NipGeneracionServiceImpl implements NipGeneracionService {

	/** Registro */
	private static final Logger logger = LoggerFactory.getLogger(NipGeneracionServiceImpl.class);
			
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/** Constante Plataforma de servicios */
	private static final String CONTANTE_PLATAFORMA_SERVICIOS = "08";
	
	/** Fomateo fecha enviada a servicio */
	public static final String FORMATO_FECHA_SERVICIO = "yyyyMMdd HHmmss";
	
	/** Constante numérica*/
	private static final Integer CONTANTE_UNO = 1;
	
	/** Constante representa uno de los dos resultados posibles para el servicio en: confirmacionTransaccion*/
	private static final String RESPUESTA_ERROR_SERVICIO = "02";
	
	/** Consume servicio de generaciónde NIP */
	@Autowired
	@Qualifier("consumeServicioNipService")
	private ConsumeServicioRestService consumeServicioNipService;
	
	/** Utileria para obtener la fecha */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/** endPoint - Configuración de servicio invocado */
	@Value("${servicio.nip.endPoint}")
	private String endPoint;
	
	/**
	 * Realiza en envio de solicitud al servicio de Generación NIPs 
	 * @param datosEntradaNip
	 * @return RespuestaServicioNip
	 * @throws BusinessException
	 */
	@Override
	public RespuestaServicioNip generarNIP(GeneraNIP datosEntradaNip) throws BusinessException {
		
		logger.info("[generarNIP] - [Servicio Genera NIP] - Armando solicitud de generación de NIP");
		RespuestaServicioNip salida = null;
		String strJsonRespuesta = 
				consumeServicioNipService.enviar(endPoint, (obtenerSolicitudServicioNip(datosEntradaNip)));
		salida = interpretarRespuesta(strJsonRespuesta);

		RechazosGeneracionNipEnum rechazoEnum = 
				RechazosGeneracionNipEnum.obtenerMotivoEnum(salida.getMotivoRechazo());
		if( RESPUESTA_ERROR_SERVICIO.equals(salida.getConfirmacionTransaccion()) && 
				utileriaValidador.validarObjetoNulo(rechazoEnum)) {
			
			salida.setDescripcionRechazo("Motivo de rechazo no registrado");		
		} else if( RESPUESTA_ERROR_SERVICIO.equals(salida.getConfirmacionTransaccion()) && 
				(!utileriaValidador.validarObjetoNulo(rechazoEnum))) {
			
			salida.setDescripcionRechazo(rechazoEnum.getDescripcion());
		}
		logger.info("[generarNIP] - [Servicio Genera NIP] - Respuesta a la solicitud: {}", salida);
		return salida;
	}
	
	/**
	 * Traduce a negocio la respuesta del servicio de generaciónd e NIP
	 * @param strJsonRespuesta
	 * @return RespuestaServicioNip
	 */
	private RespuestaServicioNip interpretarRespuesta(String strJsonRespuesta) {
		RespuestaServicioNip respuestaServicioNip  = null;
		if (! utileriaValidador.validarVacio(strJsonRespuesta)){ // El Json proveniente del servicio no está en blanco
			try {
				respuestaServicioNip = CovierteJSONStringEnObjeto.devulveObjeto(strJsonRespuesta, new RespuestaServicioNip());
			} catch ( Exception e ) { // No fue posible obtener el objeto: RespuestaServicioNip
				logger.error("[generarNIP][interpretarRespuesta] - Error - strJson no esperado: {}", strJsonRespuesta);
				throw new BusinessException("Servicio de generación de NIP con respuesta no esperada");
			}
			if( utileriaValidador.validarVacio(respuestaServicioNip.getConfirmacionTransaccion()) ) { // Respeusta del servicio no puede ser nula
				throw new BusinessException("Servicio de generación de NIP - Confirmación llega vacia.");
			}
		} else {
			logger.error("[generarNIP][interpretarRespuesta] - Error - strJson no esperado: {}", strJsonRespuesta);
			throw new BusinessException("Servicio de generación de NIP con respuesta no esperada");
		}
		return respuestaServicioNip;
	}
	
	/**
	 * Obtiene el Objeto que será enviado al servicio de generación de NIP
	 * @param datosEntrada
	 * @return SolicitudServicioNip
	 */
	private String obtenerSolicitudServicioNip(GeneraNIP datosEntrada) {
		SolicitudServicioNip solicitud = new SolicitudServicioNip();
		solicitud.setCorreoElectronico(datosEntrada.getCorreo());
		solicitud.setCurpAhorrador(datosEntrada.getCurp());
		solicitud.setCveAfore(datosEntrada.getCveAfore());
		solicitud.setFechaSolicitud(utileriaFecha.convertirFechaACadena(new Date(), FORMATO_FECHA_SERVICIO));
		solicitud.setIdOrigen(CONTANTE_PLATAFORMA_SERVICIOS);
		solicitud.setIndicadorGeneracion(String.valueOf(CONTANTE_UNO));
		solicitud.setNss(datosEntrada.getNss());
		solicitud.setTelefonoCelular(datosEntrada.getNumeroCelular());
//		return solicitud;
		JsonUtilsImpl<SolicitudServicioNip> jsonEntrada = new JsonUtilsImpl<>();
		return jsonEntrada.parseObjectToJsonSC(solicitud);
	}
		
}
