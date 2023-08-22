package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionReti;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarResolucionRetiService;
/**
 * Clase que implementa la consulta de la Reti Resolucion
 * @author ANICOLAS
 *
 */
@Service
public class ConsultarResolucionRetiServiceImpl implements ConsultarResolucionRetiService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarResolucionRetiServiceImpl.class);
	
	@Value("${uri.consulta.resolucion}")
	private String urlConsultaResolucionReti;
	
	
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;

	/*
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarResolucionRetiService#consultarResolucionReti(java.lang.Long, java.lang.String, java.lang.String)
     */
	@Override
	public ResolucionReti consultarResolucionReti(Long idProcesar, String cvTipoOperacion, String cvProceso) {
		logger.info("Datos Entrada consulta Resolucion:{},{},{}",idProcesar,cvTipoOperacion,cvProceso);
		StringBuilder uri = new StringBuilder(urlConsultaResolucionReti);
		if(!StringUtils.isBlank(idProcesar.toString())) {
			uri.append("idProcesar=").append(idProcesar).append("&");
		}
		if(!StringUtils.isBlank(cvTipoOperacion)) {
			uri.append("claveTipoOperacion=").append(cvTipoOperacion).append("&");
		}
		if(!StringUtils.isBlank(cvProceso)) {
			uri.append("claveProceso=").append(cvProceso);
		}
		logger.info("Url consultarResolucionReti:{}",uri);
		
		ResolucionReti respuestaResolucion =  restTemplate.getForObject(uri.toString(), ResolucionReti.class);
		logger.info("Salida Respuesta resolucion:{}",respuestaResolucion);
		return respuestaResolucion;
		
	}
	
}
