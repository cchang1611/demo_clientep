/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;

/**
 * Implementacion del servicio de rechazo
 * 
 * @author DBARBOSA
 */
@Service
public class RechazoServiceImpl implements RechazoService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RechazoServiceImpl.class);

	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate rest;	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService#obtenerRechazo(java.lang.String, java.lang.String)
	 */
	@Override
	public RechazoPulssar obtenerRechazo(String codigo, String claveAfore) {
		logger.info("RechazoServiceImpl. ObtenerRechazo codigo: {}, claveAfore {} ", codigo, claveAfore);
		try {
			StringBuilder uri = new StringBuilder(uriComunes);
			uri.append("consultaRechazo/");
			uri.append(codigo);
			uri.append("/");
			uri.append(claveAfore);
			logger.info("peticion: {}", uri);

			RechazoPulssar rechazo = rest.getForObject(uri.toString(), RechazoPulssar.class);
			logger.info("La respuesta del rechazo {} ", rechazo);
			return rechazo;
		} catch (Exception e) {
			logger.error("Generar folios:Se presento un problema en el servicio de rechazos {}", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
}