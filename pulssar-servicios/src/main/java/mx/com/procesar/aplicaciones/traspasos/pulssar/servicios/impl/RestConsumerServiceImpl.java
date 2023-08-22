/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RestConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Consume un servicio Rest
 * @author malopezt
 * @since 2022/02/03
 */
@Service("restConsumerService")
public class RestConsumerServiceImpl implements RestConsumerService {

	/**
	 * Permite el Consumo de un servicio rest. Método Post
	 */
	@Autowired
//	@Qualifier("restTemplateAdmonCta")
	private RestTemplate restTemplate;
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.servicios.admoncuenta.liberapendiente.servicios.RestConsumerService#consumirServicio(java.lang.String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity)
	 */
	@Override
	public ResponseEntity<String> consumirServicio(String url, HttpEntity<String> entidadHTTP) {
		return restTemplate.exchange(url, HttpMethod.POST, entidadHTTP, String.class);
	}

	/* (non-Javadoc)
	 * @see mx.com.procesar.servicios.admoncuenta.liberapendiente.servicios.RestConsumerService#consumirServicioConsulta(java.lang.String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity)
	 */
	@Override
	public ResponseEntity<String> consumirServicioConsulta(String url, HttpEntity<String> entidadHTTP) {
		return restTemplate.exchange(url, HttpMethod.GET, entidadHTTP, String.class);
	}
}
