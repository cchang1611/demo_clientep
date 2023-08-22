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
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionTotalService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionTotalIssste;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since May 12, 2020
 */
@Service
public class SolicitudDisposicionTotalServiceImpl implements SolicitudDisposicionTotalService {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudDisposicionTotalServiceImpl.class);
	
	/**
	 * urlSolicitudDispIssste
	 */
	@Value("${url.solicitud.disposicion.issste}")
	private String urlSolicitudDispIssste;
	
	/**
	 * solicitudDispIsssteCredentials
	 */
	@Value("${solicitud.disposicion.issste.credentials}")
	private String solicitudDispIsssteCredentials;
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionTotalService#solicitudIssste(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionTotalIssste)
	 */
	@Override
	public void solicitudIssste(DisposicionTotalIssste sol) {
		
		logger.error("URL solicitud disposicion Issste: {}", urlSolicitudDispIssste);
		
		HttpHeaders headerMedia = new HttpHeaders();
		byte[] creds = solicitudDispIsssteCredentials.getBytes();
		byte[] base64CredBytes = Base64Utils.encode(creds);
		String base64Creds = new String(base64CredBytes);
		
		headerMedia.setContentType(MediaType.APPLICATION_JSON);
		headerMedia.add("idCliente", "35");
		headerMedia.add("idServicio", "822");
		headerMedia.add("idEbusiness", "29");
		headerMedia.add("Authorization", "Basic "+base64Creds);
		
		HttpEntity<String> entity = new HttpEntity<>("", headerMedia);
		
		try{
			restTemplate.exchange(urlSolicitudDispIssste, HttpMethod.POST, entity, String.class);
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de solicitud Issste: {}",e);
		}
		
	}

	
}
