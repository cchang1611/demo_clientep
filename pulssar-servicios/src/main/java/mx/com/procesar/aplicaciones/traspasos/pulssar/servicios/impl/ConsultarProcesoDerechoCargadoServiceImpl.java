package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoCargadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
/**
 * 
 * Servicio que implementa ConsultarProcesoDerechoCargado
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 13, 2021
 */
@Service
public class ConsultarProcesoDerechoCargadoServiceImpl implements ConsultarProcesoDerechoCargadoService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarProcesoDerechoCargadoServiceImpl.class);
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoCargadoService#consultarDerechoCargado(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcesoDerechoCargado> consultarDerechoCargado(Long idProcesar) {
		logger.info("Datos Entrada consultarDerechoCargado:{}",idProcesar);
		List<ProcesoDerechoCargado> respuestaDerecho=null;
		StringBuilder url = new StringBuilder();
		ObjectMapper mapeador = new ObjectMapper();
		try{
		url.append(uriComunes).append(ExpresionesConstants.DERECHO_CARGA).append(ActivacionConstants.DIAGONAL).append(idProcesar).toString();
		logger.info("Url urlConsultaDerechoCargado:{}",url);
	    respuestaDerecho =  restTemplate.getForObject(url.toString(), List.class);
	    mapeador.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
	    JsonUtilsImpl<ProcesoDerechoCargado> json = new JsonUtilsImpl<>();
	    respuestaDerecho  = json.parseListObjectToListPojo((List<ProcesoDerechoCargado>) respuestaDerecho, ProcesoDerechoCargado.class);

		}catch (Exception e) {
			logger.error("Ocurrio un error en consultarDerechoCargado: {}",e);
		}
		return respuestaDerecho;
		
	}

}
