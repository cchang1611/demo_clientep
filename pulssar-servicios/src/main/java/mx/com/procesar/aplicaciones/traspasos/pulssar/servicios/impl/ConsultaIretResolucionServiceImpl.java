package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretResolucionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Clase que implementa la consulta de la resolucion (Datamart) 
 * @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 29, 2020
 */
@Service
public class ConsultaIretResolucionServiceImpl implements ConsultaIretResolucionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaIretResolucionServiceImpl.class);
	
	/**
	 * Resolucion
	 */
	@Value("${url.consulta.iret.resolucion}")
	private String urlConsultaIretResolucion;
	
	
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretResolucionService#consultarIretResolucion(java.lang.Long, java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Resolucion> consultarIretResolucion(Long idProcesar, Long idDiagnostico) {
		logger.info("Datos Entrada consultarIretResolucion:{},{}",idProcesar,idDiagnostico);
		StringBuilder url = new StringBuilder(urlConsultaIretResolucion).append("/").append(idProcesar).append("/").append(idDiagnostico);
		logger.info("Url consultarIretResolucion{}",url);
		List<Resolucion> respuestaResolucion =  restTemplate.getForObject(url.toString(), List.class);
		JsonUtilsImpl<Resolucion> json = new JsonUtilsImpl<>();
		List<Resolucion> listaResRespuesta = json.parseListObjectToListPojo((List<Resolucion>) respuestaResolucion, Resolucion.class);

		logger.info("Salida lista Respuesta resolucion:{}",listaResRespuesta);
		return listaResRespuesta;
		
	}


	/**
	 * Metodo para consulta resolucion
	 *  @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
	 *  @param procesar
	 *  @param l
	 */
	@Override
	public List<ResolucionDisposicionIssste> consultarDatosResol(Long procesar) {
		
        StringBuilder url = new StringBuilder();
		
		logger.info("Datos Entrada consultarIretResolucion:{},{}",procesar);
		String uriDos = url.append(uriComunes).append("consultaDisposicionIssste/{idProcesar}").toString();
		String uriNueva = uriDos.replace("{idProcesar}", procesar.toString());
		logger.info("Url consultarIretResolucion{}",uriNueva);
		String var =  restTemplate.getForObject(uriNueva, String.class);
		 JsonUtilsImpl<ResolucionDisposicionIssste> json = new JsonUtilsImpl<>();
		 List<ResolucionDisposicionIssste>   respuestaResolucion  = json.parseJsonToObjectList(var, ResolucionDisposicionIssste.class);
		logger.info("Salida lista Respuesta resolucion:{}",respuestaResolucion);
		return respuestaResolucion;
	}

	
	
	
	
}
