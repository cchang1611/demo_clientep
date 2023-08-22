/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.GeneraNIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NotificacionNipRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NotificacionNipServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RespuestaServicioNip;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipReplicaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.CovierteJSONStringEnObjeto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Se encarga de la inserción de los elementos que irán a la replica en BD, en cada afore
 * @author malopezt
 * @since 2022/02/09
 */
@Service("nipReplicaService")
public class NipReplicaServiceImpl implements NipReplicaService {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(NipReplicaServiceImpl.class);

	/** Constante 1 Corto */
	private static final short CONSTANTE_UNO = 1;
	
	/** Consume servicio de generaciónde NIP */
	@Autowired
	@Qualifier("consumeServicioNipService")
	private ConsumeServicioRestService consumeServicioNipService;
	
	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private OrganizacionRepository repositorioOrganizacion;
	
	/** Utileria para obtener la fecha */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/** Utileria de validacion*/
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/** Constante representa uno de los dos resultados posibles para el servicio en: confirmacionTransaccion*/
	private static final String RESPUESTA_EXITO_SERVICIO = "01";

	/** Formato de fecha entrante */
	private static final String FORMATO_FECHA = "yyyyMMddHHmm";
	
	/** endPoint - Configuración de servicio invocado */
	@Value("${servicio.nip.replica.endPoint}")
	private String endPoint;
	
	/**
	 * Persiste el objeto a replicar a la afore correspondiente. 
	 * Lo cual ocurre vía ETL desde un proceso de BD
	 * @param respuestaServicio
	 * @param datosEntradaNip
	 * @param fechahoraSoliciutd
	 * @param usuarioModificador
	 * @param folio
	 * @param sucursal
	 * @throws BusinessException
	 */
	@Override
	public void guardarReplicaNip(RespuestaServicioNip respuestaServicio, GeneraNIP generaNip,
			Date fechahoraSoliciutd, String usuarioModificador, String folio, String sucursal) throws BusinessException {
		
		logger.info("[guardarReplicaNip] - Inicia proceso de replica a BD");
		
		String strJsonRespuesta = 
				consumeServicioNipService.enviarToServicioInterno(endPoint,
						obtenerObjetoPorNotificar(respuestaServicio, generaNip, 
								fechahoraSoliciutd, usuarioModificador, folio, sucursal));
		interpretarRespuesta(strJsonRespuesta);

		logger.info("[guardarReplicaNip] - Respuesta a la solicitud: {}", strJsonRespuesta);
	}
	
	/**
	 * Traduce a negocio la respuesta del servicio de generaciónd e NIP
	 * @param strJsonRespuesta
	 */
	private void interpretarRespuesta(String strJsonRespuesta) {
		NotificacionNipRespuesta salida = null;
		if (! utileriaValidador.validarVacio(strJsonRespuesta)){ // El Json proveniente del servicio no está en blanco
			try {
				salida = CovierteJSONStringEnObjeto.devulveObjeto(strJsonRespuesta, new NotificacionNipRespuesta());
				
			} catch (Exception e) {
				logger.error("[NotificaionReplicaBD][interpretarRespuesta] - Error - strJson no esperado: {}", strJsonRespuesta);
				throw new BusinessException("Servicio de Notificación con respuesta no esperada");
			}
			if(! RESPUESTA_EXITO_SERVICIO.equals(salida.getNotificacionAplicada())) {
				logger.error("[NotificaionReplicaBD][interpretarRespuesta] - Error - Notificación no aplicada: {}", salida);
				throw new BusinessException(salida.getMotivoRechazo());
			}
		} else {
			logger.error("[NotificaionReplicaBD][interpretarRespuesta] - Error - strJson no esperado: {}", strJsonRespuesta);
			throw new BusinessException("Servicio de Notificación con respuesta no esperada");
		}
	}
	
	/**
	 * Devuelve strJson del objeto a ser Notificado
	 * @param respuestaServicio
	 * @param generaNip
	 * @return
	 */
	private String obtenerObjetoPorNotificar(RespuestaServicioNip respuestaServicio, GeneraNIP generaNip,
			Date fechahoraSoliciutd, String usuarioModificador, String folio, String sucursal){
		
		Organizacion orgAfore = repositorioOrganizacion.findOne(generaNip.getCveAfore());
		
		NotificacionNipServicio notificacionNip = new NotificacionNipServicio();
		notificacionNip.setApMaterno(generaNip.getApMaterno());
		notificacionNip.setApPaterno(generaNip.getApPaterno());
		notificacionNip.setAutorizacion(CONSTANTE_UNO);
		notificacionNip.setConfirmacion(respuestaServicio.getConfirmacionTransaccion());
		notificacionNip.setCorreo(generaNip.getCorreo());
		notificacionNip.setCurp(generaNip.getCurp());
		notificacionNip.setCveAfore(generaNip.getCveAfore());
		notificacionNip.setDescripcionRechazo(respuestaServicio.getDescripcionRechazo());
		notificacionNip.setFechaGeneracionNip(
				utileriaFecha.convertirFechaACadena(fechahoraSoliciutd, FORMATO_FECHA));
		notificacionNip.setFolioPulssar(folio);
		notificacionNip.setMotivoRechazo(respuestaServicio.getMotivoRechazo());
		notificacionNip.setNombre(generaNip.getNombre());
		notificacionNip.setNss(generaNip.getNss());
		notificacionNip.setNumeroCelular(generaNip.getNumeroCelular());
		notificacionNip.setUsuarioModificador(usuarioModificador);
		notificacionNip.setCveAgenteServicio(usuarioModificador);
		notificacionNip.setSucursal(sucursal);
		notificacionNip.setNombreAfore(utileriaValidador.isEmpty(orgAfore) ? null : orgAfore.getDescripcionOrganizacion());
		JsonUtilsImpl<NotificacionNipServicio> jsonEntrada = new JsonUtilsImpl<>();
		return jsonEntrada.parseObjectToJsonSC(notificacionNip);
	}
}
