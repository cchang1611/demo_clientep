/**
 * ObtenerIpUtil.java Fecha de creaci�n: 07/02/2019, 12:50:56 Copyright (c) 2019
 * Procesar S A de C V. Todos los derechos reservados. Este software es informaci�n
 * confidencial, propiedad del Procesar S A de C V. Esta informaci�n confidencial no deber� ser
 * divulgada y solo se podr� utilizar de acuerdo a los t�rminos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Interfaz de utiler�a para obtener la informaci�n de una petici�n.
 * 
 * @author Oscar Enrique Gonz�lez Garc�a (oegonzal@procesar.com.mx)
 * @version 1.0
 * @since Febrero 2019.
 */
public interface ObtenerIpUtil {

	/**
     * M�todo que regresa las variables contenidas en la cabecera de la petici�n.
     * 
     * @param request Peticion http
     * @return Map<String, String> Mapa con la informacion de los encabezados de la peticion
     */
	Map<String, String> obtenerInformacionCabecera(HttpServletRequest request);

	/**
     * M�todo que regresa la ip del cliente en una petici�n.
     * 
     * @param request Peticion http
     * @return Caena con la informacion de la ip del usuario que realiza la peticion
     */
	String obtenerDireccionIpCliente(HttpServletRequest request);
}
