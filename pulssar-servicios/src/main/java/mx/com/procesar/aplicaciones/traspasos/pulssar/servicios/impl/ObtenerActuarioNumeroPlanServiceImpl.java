package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerActuarioNumeroPlanService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroPlanPrivado97;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Serivicio que implementa ObtenerActuarioNumeroPlan
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 5, 2021
 */
@Service
public class ObtenerActuarioNumeroPlanServiceImpl implements ObtenerActuarioNumeroPlanService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerActuarioNumeroPlanServiceImpl.class);
	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	

	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
/*
 * La documentación de este método se encuentra en la clase o interface que
 * lo declara  (non-Javadoc)
 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerActuarioNumeroPlanService#obtenerPlanPrivadoPorActuarioYNumeroPlan(java.lang.String, java.lang.String)
 */
	@Override
	public RetiroPlanPrivado97 obtenerPlanPrivadoPorActuarioYNumeroPlan(String cvActuario, String numeroPlan) {
		StringBuilder url = new StringBuilder();
		url.append(uriComunes).append(ActivacionConstants.RETIRO_PLAN_PRIVADO_97).append(ActivacionConstants.DIAGONAL).append(ActivacionConstants.PLAN_PRIVADO_ACTUARIO_NUM_PLAN).append(ActivacionConstants.DIAGONAL).append(cvActuario).append(ActivacionConstants.DIAGONAL).append(numeroPlan).toString();
		logger.info("Url obtenerPlanPrivadoPorActuarioYNumeroPlan:{}",url);
		  
		RetiroPlanPrivado97 respuesta =  clienteServicio.getForObject(url.toString(),RetiroPlanPrivado97.class);
		 if(utileriaValidador.validarObjetoNulo(respuesta)) {
			 logger.error("Ocurrio un error obtenerPlanPrivadoPorActuario");
			  throw new BusinessException("obtenerPlanPrivadoPorActuario");
		  }
		return respuesta;
		
	}
	
	
	
}
