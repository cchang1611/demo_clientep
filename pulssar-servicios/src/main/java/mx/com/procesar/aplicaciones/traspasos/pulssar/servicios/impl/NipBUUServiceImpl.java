/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipBUUService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.CovierteJSONStringEnObjeto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Permite obtener el complemento de información necesario para la solicitud generación de NIP
 * @author MALOPEZT
 * @since 02/02/2022
 */
@Service("nipBUUService")
public class NipBUUServiceImpl implements NipBUUService {

	/** Registro */
	private static final Logger logger = LoggerFactory.getLogger(NipBUUServiceImpl.class);
	
	/** Utileria de validacion*/
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/** Constante Rechazo*/
	private static final String CONSTANTE_RECHAZO = "02";
	
	/** Prefijo del mensaje Json a enviar */
	private static final String PREFIJO_MENSAJE = "{\"curp\" :\"";
	
	/** Sufijo del mensaje Json a enviar */
	private static final String SUFIJO_MENSAJE = "\"}";
	
	/** Problema de cominicación con la BUU */
	private static final String PROBLEMA_COMUNICACION_BUU = "0000";
	
	/** Consumir servicio Rest */
	@Autowired
	@Qualifier("consumeServicioNipService")
	private ConsumeServicioRestService consumeServicioNipService;
	
	/** endPoint - Configuración de servicio invocado */
	@Value("${servicio.nip.buu.endPoint}")
	private String endPoint;
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipBUUService#consultarDatosBUU(java.lang.String)
	 */
	@Override
	public NipConsultaBUU consultarDatosBUU(String curp) {
		logger.info("[obtenerComplementoBUU] - Recuperando correo, celular, Sin Nip o no activo - Curp: {}", curp);
//		NipRespuestaBUU complemento = new NipRespuestaBUU();
//		complemento.setCorreo("desa@correo.com.mx");
//		complemento.setNumeroCelular("5512345678");
//		return complemento;
		
		NipConsultaBUU salida = null;
		try {
			String strJsonRespuesta = 
					consumeServicioNipService.enviarToServicioInterno(endPoint, obtenerStrJson(curp));
			salida = interpretarRespuesta(strJsonRespuesta);
			
		} catch (BusinessException e) {
			logger.error("[consultarDatosBUU] - [ConsultarBUU] - Error: {}", e.getMessage());
			salida = obtenerRepuestaError();
		}
		logger.info("[consultarDatosBUU] - Recuperando correo, celular, Sin Nip o no activo: {}", salida);
		return salida;
	}

	/**
	 * Deveulve la cadena que sserá enviada como Str Json al servicio de consulta
	 * @param curp
	 * @return
	 */
	private String obtenerStrJson(String curp) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(PREFIJO_MENSAJE).append(curp).append(SUFIJO_MENSAJE);
		return sb.toString();
	}
	
	/**
	 * Traduce a negocio la respuesta del servicio de generaciónd e NIP
	 * @param strJsonRespuesta
	 * @return RespuestaGeneraNip
	 */
	private NipConsultaBUU interpretarRespuesta(String strJsonRespuesta) {
		NipConsultaBUU salida = null;
		if (! utileriaValidador.validarVacio(strJsonRespuesta)){ // El Json proveniente del servicio no está en blanco
			try {
				salida = CovierteJSONStringEnObjeto.devulveObjeto(strJsonRespuesta, new NipConsultaBUU());
			} catch (Exception e) {
				logger.error("[interpretarRespuesta][Error] - No pudo traducir la respuesta del servicio: {}", strJsonRespuesta);
				salida = obtenerRepuestaError();
			}
		} else {
			salida = obtenerRepuestaError();
		}
		return salida;
	}
	
	/**
	 * Obtiene un objeto de rechazo con un mensaje de error genérico. Empleado para indicar que no
	 * se obtuvo respuesta del servicio de validación (generación de Nip)
	 * @return
	 */
	private NipConsultaBUU obtenerRepuestaError() {
		NipConsultaBUU salida = new NipConsultaBUU();
		salida.setConfirmacionTransaccion(CONSTANTE_RECHAZO);
		salida.setMotivoRechazo(PROBLEMA_COMUNICACION_BUU);
		return salida;
	}
}
