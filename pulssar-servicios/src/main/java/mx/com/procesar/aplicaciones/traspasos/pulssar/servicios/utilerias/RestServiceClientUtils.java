/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.List;

import org.springframework.http.HttpHeaders;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;

/**
 * utileria para acceder a servicios rest
 * 
 * @author jcgarces
 * @version 1.0
 * @updated 13-mar-2019 05:57:12 p.m.
 */
public interface RestServiceClientUtils {

	/**
	 * ejecuta servicio get
	 * 
	 * @param uri
	 * @return
	 */
	<R> R ejecutarServicioGet(String servidor, String uri, Class<R> clase);

	/**
	 * lista de objetos con get
	 * 
	 * @param uri
	 * @param claseRespuesta
	 *            de la lista
	 * @return
	 */
	<R> List<R> ejecutarServicioGetObjetos(String servidor, String uri, Class<R> claseRespuesta);

	/**
	 * ejecuta servicio post
	 * 
	 * @param uri
	 * @param peticion
	 * @param claseRespuesta
	 * @return
	 */
	<P, R> R ejecutarServicioPost(String servidor, String uri, P peticion, Class<R> claseRespuesta);

	/**
	 * envia servicio post con header parametrizados
	 * 
	 * @param url
	 * @param peticion
	 * @param headers
	 * @param claseRespuesta
	 * @return
	 */
	<P, R> R ejecutarServicioPostwithHeaders(String url, P peticion, HttpHeaders headers, Class<R> claseRespuesta);

	/**
	 * ejecuta servicio post
	 * 
	 * @param uri
	 * @param peticion
	 * @param claseRespuesta
	 * @return
	 */
	<P, R> R ejecutarServicioPost(String url, P peticion, Class<R> claseRespuesta);

	/**
	 * ejecuta servicio post, recibiendo directamente el objeto sin el
	 * Responseentity
	 * 
	 * @param uri
	 * @param peticion
	 * @param claseRespuesta
	 * @return
	 */
	<P, R> List<R> ejecutarServicioPostParaObjetos(String servidor, String uri, P peticion, Class<R> claseRespuesta);

	/**
	 * ejecuta servicio PUT
	 * 
	 * @param servidor
	 * @param uri
	 * @param peticion
	 */
	<P, R> R ejecutarServicioPut(String servidor, String uri, P parametro, Class<R> claseRespuesta);

	/**
	 * ejecuta un servicio delete
	 * 
	 * @param servidor
	 * @param uri
	 */
	void ejecutarServicioDelete(String servidor, String uri);

	/**
	 * llama un servicio rest con un xml
	 * 
	 * @param servidor
	 * @param uri
	 * @param peticion
	 * @param claseRespuesta
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	<P, R> R ejecutarServicePostXml(String servidor, String uri, P peticion, Class<R> claseRespuesta)
			throws GenericException;

	/**
	 * llama un servicio rest con un xml
	 * 
	 * @param url
	 * @param peticion
	 * @param claseRespuesta
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	<P, R> R ejecutarServicePostXml(String url, P peticion, Class<R> claseRespuesta) throws GenericException;

	/**
	 * metodo REst para las listas 
	 * @author Ricardo Alcantara Rmz(ralcanra@procesar.com)
	 * Mar 17, 2021
	 * @param uri
	 * @param claseRespuesta
	 * @return
	 */
	<R> List<R> ejecutarServicioGetObjetosList(String uri, Class<R> claseRespuesta);	

}