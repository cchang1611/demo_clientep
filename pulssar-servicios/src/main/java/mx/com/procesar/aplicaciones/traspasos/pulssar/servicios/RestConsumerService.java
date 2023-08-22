/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

/**
 * @author malopezt
 * @since 2022/02/03
 */
public interface RestConsumerService {

	/**
	 * Consumidor de un servicio Rest - Post
	 * @return ResponseEntity<String>
	 */
	ResponseEntity<String> consumirServicio(String url, HttpEntity<String> entidadHTTP);
	
	/**
	 * Consumidor de un servicio Rest - Get
	 * @return ResponseEntity<String>
	 */
	ResponseEntity<String> consumirServicioConsulta(String url, HttpEntity<String> entidadHTTP);
}
