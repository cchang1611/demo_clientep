/**
 * ObtenerIpUtil.java Fecha de creación: 07/02/2019, 12:50:56 Copyright (c) 2019
 * Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Interfaz de utilería para obtener la información de una petición.
 * 
 * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
 * @version 1.0
 * @since Febrero 2019.
 */
public interface ObtenerIpUtil {

	/**
     * Método que regresa las variables contenidas en la cabecera de la petición.
     * 
     * @param request Peticion http
     * @return Map<String, String> Mapa con la informacion de los encabezados de la peticion
     */
	Map<String, String> obtenerInformacionCabecera(HttpServletRequest request);

	/**
     * Método que regresa la ip del cliente en una petición.
     * 
     * @param request Peticion http
     * @return Caena con la informacion de la ip del usuario que realiza la peticion
     */
	String obtenerDireccionIpCliente(HttpServletRequest request);
}
