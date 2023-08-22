/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RestConsumerService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Permite realizar operaciones de conulta e inserción necesarias en para el negocio de generación de Nip
 * @author MALOPEZT
 * @since 2022/02/23
 */
@Service("consumeServicioNipService")
public class ConsumeServicioNipServiceImpl implements ConsumeServicioRestService {

	/** Registro */
	private static final Logger logger = LoggerFactory.getLogger(ConsumeServicioNipServiceImpl.class);
			
	/** idServicio - Configuración de servicio invocado */
	@Value("${servicio.nip.idServicio}")
	private String idServicio;
	
	/** idCliente - Configuración de servicio invocado */
	@Value("${servicio.nip.idCliente}")
	private String idCliente;
	
	/** idEbusiness - Configuración de servicio invocado */
	@Value("${servicio.nip.idEbusiness}")
	private String idEbusiness;
	
	
	/** Constante Encabezado Servicio */
	private static final String CLIENTE_NIP = "idCliente";
	/** Constante Encabezado Servicio */
	private static final String SERVICIO_NIP = "idServicio";
	/** Constante Encabezado Servicio */
	private static final String EBUSINESS_NIP = "idEbusiness";
	
	/** Invocación servicio Rest genérico*/
	@Autowired
	private RestConsumerService restConsumerService;
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService#enviar(java.lang.String, java.lang.String)
	 */
	@Override
	public String enviar(String endPoint, String strJson) throws BusinessException {
		HttpEntity<String> entidadHttp = obtenEntidadHttp(strJson);
		ResponseEntity<String> respuestaServicio = null;
		String salida = null;				
		try{
			
			logger.info("SolicitudRest - EndPoint:{} - Encabezados: {} - StrJson:{}", 
					endPoint, entidadHttp.getHeaders().toString(), strJson);
			respuestaServicio = restConsumerService.consumirServicio(endPoint, entidadHttp);

			if(respuestaServicio != null){
				salida = respuestaServicio.getBody();				
			}
		} catch(Exception e){
			logger.error("[enviar][rest] - Se produjo un error desconocido al invocar el servicio de negocio ,el flujo continuara ", e);
			throw new BusinessException("Solicitud de NIP no procesada");
		}
		
		return salida;
	}
	
	/**
	 * Obtiene el el elemento HTTP que será enviado al destinuo URL deseado.
	 * @param strJson
	 * @return HttpEntity<String>
	 */
	private HttpEntity<String> obtenEntidadHttp(String strJson) {
		HttpHeaders encabezados = agregarEncabezados(); 
		return new HttpEntity<>(strJson, encabezados);
	}
	
	/**
	 * Encabezado del servicio de Registro IMSS
	 * @return HttpHeaders
	 */
	private HttpHeaders agregarEncabezados() {
		return devuelveEncabezado();
	}
	
	private HttpHeaders devuelveEncabezado() {
		HttpHeaders encabezados = new HttpHeaders();
		encabezados.setContentType(MediaType.APPLICATION_JSON);
		encabezados.add(CLIENTE_NIP, String.valueOf(idCliente));
		encabezados.add(SERVICIO_NIP, String.valueOf(idServicio));
		encabezados.add(EBUSINESS_NIP, String.valueOf(idEbusiness));
		return encabezados;
	}

	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService#enviarToServicioInterno(java.lang.String, java.lang.String)
	 */
	@Override
	public String enviarToServicioInterno(String endPoint, String strJson) throws BusinessException {
		HttpEntity<String> entidadHttp = obtenEntidadHttpSinHeaders(strJson);
		ResponseEntity<String> respuestaServicio = null;
		String salida = null;				
		try{
			
			logger.info("SolicitudRest - EndPoint:{} - StrJson:{}", endPoint, strJson);
			respuestaServicio = restConsumerService.consumirServicio(endPoint, entidadHttp);

			if(respuestaServicio != null){
				salida = respuestaServicio.getBody();				
			}
		} catch(Exception e){
			logger.error("[enviarToServicioInterno][rest] - Se produjo un error desconocido al invocar el servicio de negocio ,el flujo continuara ", e);
			throw new BusinessException("Consumo de Servicio no completado");
		}
		
		return salida;
	}
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsumeServicioRestService#consultarToServicioInterno(java.lang.String, java.lang.String)
	 */
	@Override
	public String consultarToServicioInterno(String endPoint, String strJson) throws BusinessException {
		HttpEntity<String> entidadHttp = obtenEntidadHttpSinHeaders(strJson);
		ResponseEntity<String> respuestaServicio = null;
		String salida = null;				
		try{
			
			logger.info("SolicitudRest - EndPoint:{} - StrJson:{}", endPoint, strJson);
			respuestaServicio = restConsumerService.consumirServicioConsulta(endPoint, entidadHttp);

			if(respuestaServicio != null){
				salida = respuestaServicio.getBody();				
			}
		} catch(Exception e){
			logger.error("[consultarToServicioInterno][rest] - Se produjo un error desconocido al invocar el servicio de negocio ,el flujo continuara ", e);
			throw new BusinessException("Consulta de Servicio no completada");
		}
		
		return salida;
	}
	
	/**
	 * Obtiene el el elemento HTTP que será enviado al destinuo URL deseado.
	 * @param strJson
	 * @return HttpEntity<String>
	 */
	private HttpEntity<String> obtenEntidadHttpSinHeaders(String strJson) {
		HttpHeaders encabezados = new HttpHeaders(); 
//		encabezados.set("Content-Type", "application/json");
		encabezados.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(strJson, encabezados);
	}
}
