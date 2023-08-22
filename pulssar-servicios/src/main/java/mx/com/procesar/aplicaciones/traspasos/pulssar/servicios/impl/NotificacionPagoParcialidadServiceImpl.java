package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.NotificacionParcialidadIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificarParcialidadPagoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Servicio para el Consume de la Notificacion Parcialidad
 * @author ANOSORIO
 *
 */
@Service
public class NotificacionPagoParcialidadServiceImpl implements NotificacionPagoParcialidadService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(NotificacionPagoParcialidadServiceImpl.class);
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion de url para urlConsultaReintegroRecursos
	 */
	@Value("${uri.notificacion.parcialidad.imss}")
	private String urlnotificaPagosParcialidad;
	
	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate restService;
		
	
	@Override
	public HttpStatus notificarPagoParcialidad(NotificacionParcialidadIssste notificaEntrada) {
		logger.info("Datos Entrada notificarPagoParcialidad:{}",notificaEntrada);
		HttpStatus httpStatus = null;
	 try {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		headers.add("idCliente","10");
        headers.add("idServicio","788");
        headers.add("idEbusiness","53");

        String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,urlnotificaPagosParcialidad);
		logger.info("urlServicio:{}",urlServicio);
		HttpEntity<NotificacionParcialidadIssste> entity = new HttpEntity<>(notificaEntrada, headers);
		logger.info(" rest Notificacion:{} ",entity.getBody());
		
		ResponseEntity<NotificarParcialidadPagoSalida> response = restService.exchange(urlServicio, HttpMethod.PUT, entity, NotificarParcialidadPagoSalida.class);
		HttpStatus httpStatusCode = response.getStatusCode();
		logger.info("Salida HttpStatus value:{}",httpStatusCode.value());
		
	     if(500 == httpStatusCode.value()) {
	    	 throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
	     }
	     httpStatus = httpStatusCode;
	 }catch (Exception e) {
		 logger.error("Se presento un problema en la Notificacion Parcialidad {}", urlnotificaPagosParcialidad, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
	}
		
		return httpStatus;
	}

}
