package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaTrabajadorRetirosParcialesIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaTrabajadorRetirosParcialesIssste;

/**
 * @author HUCGARZA
 *
 */
@Service 
public class ConsultaTrabajadorRetirosParcialesIsssteServiceImpl implements ConsultaTrabajadorRetirosParcialesIsssteService{

	
	//@Value("${url.consulta.trabajador.retirosparciales.issste}")
	private String urlConsulta;
	
	/**
	 * 
	 */
	@Autowired
	private RestTemplate restTemplate;

	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaTrabajadorRetirosParcialesIsssteService#consultaTrabajadorRetiroParcialIssste(java.lang.String)
	 */
	@Override
	public ConsultaTrabajadorRetirosParcialesIssste consultaTrabajadorRetiroParcialIssste(String curp) {

		StringBuffer sb = new StringBuffer();
		sb.append(urlConsulta);
		

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("idServicio", "925");
		headers.set("idCliente", "35");
		headers.set("idEbusiness", "53");
		
		HttpEntity<String> httpEntity = new HttpEntity<>("{\"curp\":\""+curp+"\"}", headers);
		
		return  restTemplate.postForObject(urlConsulta, httpEntity, ConsultaTrabajadorRetirosParcialesIssste.class);
	}
	
}
