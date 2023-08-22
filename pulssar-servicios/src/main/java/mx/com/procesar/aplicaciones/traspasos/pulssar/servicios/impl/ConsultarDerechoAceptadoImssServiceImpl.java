package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDerechoAceptadoImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;

/**
 * 
 * Consulta Derecho Aceptado
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 17, 2021
 */
@Service
public class ConsultarDerechoAceptadoImssServiceImpl implements ConsultarDerechoAceptadoImssService{

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarDerechoAceptadoImssServiceImpl.class);
	
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
	
	
    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarDerechoAceptadoImssService#consultarDerechoAceptado(mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado)
     */
	@Override
	public SalidaGenerica consultarDerechoAceptado(ProcesoDerechoNoCargado entradaDatos) {
		
		SalidaGenerica respuesta = null;
		StringBuilder url = new StringBuilder();
		logger.info("EntradaDatos:{}",entradaDatos);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ProcesoDerechoNoCargado> entity = new HttpEntity<>(entradaDatos, headers);
		
		url.append(uriComunes).append(ExpresionesConstants.RESOLUCION_PARCIAL).append(ActivacionConstants.DIAGONAL).append(ExpresionesConstants.VALIDAR_DERECHO_ACEPTADO).toString();
		logger.info("url consultarDerechoAceptado :{}",url);
		
		try {
			HttpEntity<SalidaGenerica>	respuestaWs =clienteServicio.exchange(url.toString(),HttpMethod.POST,entity,SalidaGenerica.class);
			respuesta = respuestaWs.getBody();
			
		logger.info("Respuesta derechoAceptadoImss:{}",respuesta);	
			}catch (Exception e) {
			logger.error("Ocurrio un error en consultarDerechoAceptadoImss: {}",e);
		}
		return respuesta;
	}
}
