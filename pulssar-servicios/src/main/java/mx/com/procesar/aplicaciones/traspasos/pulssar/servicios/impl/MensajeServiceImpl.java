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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Cuerpo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Idssn;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Mensaje;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Implementacion del envio de mensajes a celulares
 * 
 * @author DBARBOSA
 */
@Service
public class MensajeServiceImpl implements MensajeService {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MensajeServiceImpl.class);
	
	/**
	 * Ruta url servicio sms
	 */
	@Value("${url.sms}")
	private String urlServicioSms;
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enviarMensaje(String mensaje, String celular) {
		
		try {
			Idssn idssn = new Idssn();
			idssn.setIdCliente(ServiciosConstants.ID_CLIENTE);
			idssn.setIdServicio(ServiciosConstants.ID_SERVICIO);
			idssn.setIdEbusiness(ServiciosConstants.ID_EBUSINESS);
			
			Cuerpo cuerpoMensaje = new Cuerpo();
			cuerpoMensaje.setMensaje(mensaje);
			cuerpoMensaje.setTelefono(celular);
			cuerpoMensaje.setPais(ServiciosConstants.PAIS);
			
			Mensaje datos = new Mensaje();
			datos.setIdssn(idssn);
			datos.setCuerpo(cuerpoMensaje);
			logger.error("Envio de mensaje al celular {}", celular);
			
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			JsonUtilsImpl<Mensaje> jsonMensaje = new JsonUtilsImpl<>();
			String jsonRequest = jsonMensaje.parseObjectToJson(datos);
			
			HttpEntity<String> entidadConsulta = new HttpEntity<>(jsonRequest, headerMedia);
			
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicioSms, HttpMethod.POST, entidadConsulta, String.class);
			logger.error("La respuesta al telefono {} {} ", celular, respuesta.getBody());
		} catch (Exception e) {
			logger.error("Se presneto un problema en el servicio de mensajeria url: {}, error: {}", urlServicioSms, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
}