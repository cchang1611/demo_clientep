package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerRecaudadoraPorNrpService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecaudadoraTV;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * Servicio que implementa ObtenerRecaudadoraPorNrp
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
@Service	
public class ObtenerRecaudadoraPorNrpServiceImpl implements ObtenerRecaudadoraPorNrpService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerRecaudadoraPorNrpServiceImpl.class);
	 
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

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerRecaudadoraPorNrpService#ObtenerRecaudadoraPorNrp(java.lang.String)
	 */
	@Override
	public RecaudadoraTV obtenerRecaudadoraPorNrp(String nrp) {
        logger.info("Valor nrp:{}",nrp);
		StringBuilder url = new StringBuilder();
		url.append(uriComunes).append(ActivacionConstants.RECAUDADORATV).append(ActivacionConstants.DIAGONAL).append(ActivacionConstants.OBTENER_RECAUDADORA_NRP).append(ActivacionConstants.DIAGONAL).append(nrp).toString();
		logger.info("Url ObtenerRecaudadoraPorNrp:{}",url); 
		RecaudadoraTV respuestaTV =  restTemplate.getForObject(url.toString(),RecaudadoraTV.class);
		    if(utileriaValidador.validarObjetoNulo(respuestaTV)) {
		    	logger.error("Ocurrio un error obtener RecaudadoraPorNrp");
				  throw new BusinessException("Ocurrio un error obtener RecaudadoraPorNrp");
		    } 
 
		logger.info("Respuesta ObtenerRecaudadoraPorNrp:{}",respuestaTV);
		return respuestaTV;
		
	}
}	