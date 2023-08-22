package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoImmsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrizDerechoProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
/**
 * Servicio que implementa la conuslta Matriz Derecho
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 5, 2021
 */
@Service
public class ConsultarMatrizDerechoImmsServiceImpl implements ConsultarMatrizDerechoImmsService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarMatrizDerechoImmsServiceImpl.class);
	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoImmsService#consultarMatrizDerecho(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public MatrizDerecho consultarMatrizDerecho(String regimen, String retiro, String seguro, String pension,
			String prestacion) {
		StringBuilder url = new StringBuilder();
		url.append(uriComunes).append(ActivacionConstants.MATRIZ_DERECHO).append(ActivacionConstants.DIAGONAL).append(retiro).append(ActivacionConstants.DIAGONAL).append(pension).append(ActivacionConstants.DIAGONAL).append(seguro).append(ActivacionConstants.DIAGONAL).append(regimen).append(ActivacionConstants.DIAGONAL).append(prestacion).toString();
		logger.info("Url consultarMatrizDerecho:{}",url);
		MatrizDerecho respuesta =  clienteServicio.getForObject(url.toString(),MatrizDerecho.class);
		return respuesta;
		
	}
    
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarMatrizDerechoImmsService#consultarMatrizDerechoProceso(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDerechoProceso> consultarMatrizDerechoProceso(Long idMatrizDerechoProceso) {
		StringBuilder url = new StringBuilder();
		url.append(uriComunes).append(ActivacionConstants.MATRIZ_DERECHO).append(ActivacionConstants.DIAGONAL).append(idMatrizDerechoProceso).toString();
		logger.info("Url consultarMatrizDerecho:{}",url);
		List<MatrizDerechoProceso> respuesta =  clienteServicio.getForObject(url.toString(),List.class);
		JsonUtilsImpl<MatrizDerechoProceso> json = new JsonUtilsImpl<>();
		respuesta  = json.parseListObjectToListPojo((List<MatrizDerechoProceso>) respuesta, MatrizDerechoProceso.class);
		
		 if(utileriaValidador.validarObjetoNulo(respuesta)) {
			 logger.error("Ocurrio un error consultarMatrizDerechoProceso");
			  throw new BusinessException("consultarMatrizDerechoProceso");
		  }
		return respuesta;
		
	}
}
