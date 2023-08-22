package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerPlanPrivadoPorNssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado73;
/**
 *  Servicio que implementa ObtenerPlanPrivadoPorNss
 * TODO [Agregar documentacion de la clase]
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
@Service
public class ObtenerPlanPrivadoPorNssServiceImpl implements ObtenerPlanPrivadoPorNssService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerPlanPrivadoPorNssServiceImpl.class);  
			
	
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
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerPlanPrivadoPorNssService#obtenerPlanPrivadoPorNss(java.lang.String)
	 */
 	@Override
	public RetiroPlanPrivado73 obtenerPlanPrivadoPorNss(String nss) {
		logger.info("Nss:{}",nss);
 		RetiroPlanPrivado73 respuesta = null;
		StringBuilder url = new StringBuilder();
		ObjectMapper mapeador = null;
		url.append(uriComunes).append(ActivacionConstants.RETIRO_PLAN_PRIVADO_73).append(ActivacionConstants.DIAGONAL).append(ActivacionConstants.OBTENER_PLAN_PRIVADO_NSS).append(ActivacionConstants.DIAGONAL).append(nss).toString();
		logger.info("Url obtenerPlanPrivadoPorNss:{}",url);
		try {
			mapeador =new ObjectMapper();
			respuesta = restTemplate.getForObject(url.toString(), RetiroPlanPrivado73.class);
			logger.info("Respuesta x Nss:{}",respuesta);

			mapeador.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		}catch (Exception e) {
			logger.error("Ocurrio un error obtener Plan Privado Por Nss{}",e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuesta;
		
	}
	
		
	
}
