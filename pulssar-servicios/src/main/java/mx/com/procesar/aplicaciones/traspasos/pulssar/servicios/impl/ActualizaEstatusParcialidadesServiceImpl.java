package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ActualizaEstatusParcialidadesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parcialidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Servicio que consume la actualzacion del estatus  
 * @author ANOSORIO
 *
 */
@Service
public class ActualizaEstatusParcialidadesServiceImpl implements ActualizaEstatusParcialidadesService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ActualizaEstatusParcialidadesServiceImpl.class);

	
	 /**
		 * uri solicitud retiro issste
		 */
		@Value("${uri.actualizar.pagos.parcialidad}")
		private String urlActualizarParcialidad;	
		
		/**
		 * servicio
		 */
		@Autowired
		private RestTemplate rest;
		
		/**
		 * Inyeccion de utileria validador
		 */
		@Autowired
		private ValidadorUtils utileriaValidador;
		
		/**
		 * Inyeccion utileria cadenas
		 */
		@Autowired
		private CadenasUtils utileriaCadenas;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaEstatusServicio actualizarEstatusParcialidad(Parcialidad parcialidad) {
		RespuestaEstatusServicio respuestaEstatus=null;
		try {
			logger.info("Datos Entrada Servicio actualizarPArcialidad:{}",parcialidad);
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,urlActualizarParcialidad);
			logger.info("Url actualizar:{}",urlServicio);
			
			HttpEntity<Parcialidad> entity = new HttpEntity<>(parcialidad, headerMedia);
			ResponseEntity<RespuestaEstatusServicio> response = rest.exchange(urlServicio, HttpMethod.POST, entity, RespuestaEstatusServicio.class);
			logger.info("Respuesta Servicio Actualiza:{}",response);
    		if(utileriaValidador.validarObjetoNulo(response.getBody())){
            	throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
            }			
            respuestaEstatus= response.getBody();
		}catch (Exception e) {
			logger.error("Se presento un problema en la Actualizacion del Estatus {}", urlActualizarParcialidad, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		logger.info("Datos Salida respuesta servicio actualizarPArcialidad:{}",respuestaEstatus);
		return respuestaEstatus;
	}

}
