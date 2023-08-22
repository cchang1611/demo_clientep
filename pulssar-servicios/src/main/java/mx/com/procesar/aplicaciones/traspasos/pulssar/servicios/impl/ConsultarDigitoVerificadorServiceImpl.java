package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDigitoVerificadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaValidarDigitoVerificador;

/**
 * Consulta y verifica numero verificador de la cuenta clabe
 * @author ANOSORIO
 *
 */
@Service
public class ConsultarDigitoVerificadorServiceImpl implements ConsultarDigitoVerificadorService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarDigitoVerificadorServiceImpl.class);  
			
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDigitoVerificadorService#validarDigitoVerificador(java.lang.String)
	 */
	@Override
	public RespuestaValidarDigitoVerificador validarDigitoVerificador(String cuentaClabe) {
		StringBuilder url = new StringBuilder();
		
		url.append(uriComunes).append("validacion/digitoVerificador/").append(cuentaClabe) .toString();
		logger.info("url:{}",url);

		RespuestaValidarDigitoVerificador respuesta = null;
		try {
		 respuesta= restTemplate.getForObject(url.toString(),RespuestaValidarDigitoVerificador.class);
		
		}catch (Exception e) {
			logger.error("Ocurrio un error al validar digito verificador: {}",e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		logger.info("Salida respuesta:{}",respuesta);
	return respuesta;
	}

	
}
