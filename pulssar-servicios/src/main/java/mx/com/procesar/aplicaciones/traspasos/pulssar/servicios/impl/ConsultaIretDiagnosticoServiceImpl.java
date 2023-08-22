package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.IretTcDiagnostico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretDiagnosticoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDiagnostico;
/**
  * Clase que implementa la consulta del catalogo diagnostico
  * @author Adrian Nicolas Osorio (ANOSORIO@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 29, 2020
 */
@Service
public class ConsultaIretDiagnosticoServiceImpl implements ConsultaIretDiagnosticoService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaIretDiagnosticoServiceImpl.class);
	
	@Value("${url.consulta.iret.diagnostico}")
	private String urlConsultaDiagnostico;
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretDiagnosticoService#consultarIretDiagnostico(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IretTcDiagnostico consultarIretDiagnostico(String cveProceso, String cveTipoOperacion,
			String codigoDiagnostico, String activo) {
		logger.info("Datos Entrada consultarIretDiagnostico:{},{},{},{}",cveProceso,cveTipoOperacion,codigoDiagnostico,activo);
		String url=urlConsultaDiagnostico;
		url = url.replace("cveProceso",cveProceso);
		url = url.replace("cveTipoOperacion",cveTipoOperacion);
		url = url.replace("codigoDiagnostico",codigoDiagnostico);
		url = url.replace("activo",activo);
		logger.info("url consultarIretDiagnostico:{}",url);
		return restTemplate.getForObject(url,IretTcDiagnostico.class);
		
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaIretDiagnosticoService#consultarDiagnostico(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDiagnostico)
	 */
	@Override
	public DatosDiagnostico consultarDiagnostico(DatosDiagnostico datos) {
		DatosDiagnostico diagnostico=null;
		StringBuilder url = new StringBuilder();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DatosDiagnostico> entity = new HttpEntity<>(datos, headers);
		url.append(uriComunes).append(ExpresionesConstants.DIAGNOSTICO).append(ActivacionConstants.DIAGONAL).append(ExpresionesConstants.CONSULTAR_DIAGNOSTICO).toString();
		  try {
			  ResponseEntity<DatosDiagnostico> respuesta =  restTemplate.exchange(url.toString(),HttpMethod.POST,entity,DatosDiagnostico.class);
			  diagnostico = respuesta.getBody();
		  }catch (Exception e) {
			  logger.error("Ocurrio un error en consultarDiagnostico: {}",e);
		}
		logger.info("Salida Diagnostico:{}",diagnostico);
		return diagnostico;
	}
	
	
	
}
