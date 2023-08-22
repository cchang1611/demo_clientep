/**
 * ObtenerIpUtilImpl.java Fecha de creación: 07/02/2019, 12:54:42 Copyright (c) 2019 Procesar S
 * A de C V. Todos los derechos reservados. Este software es información confidencial,
 * propiedad del Procesar S A de C V. Esta información confidencial no deberá ser divulgada y
 * solo se podrá utilizar de acuerdo a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ObtenerIpUtil;



/**
 * Clase de utilería que obtiene información del cliente a travez de la cabecera de la
 * petición.
 * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
 * @version 1.0
 * @since Febrero 2019.
 */
@Component
public class ObtenerIpUtilImpl implements ObtenerIpUtil {

	/**
	 * Variable para loggeo
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerIpUtilImpl.class);

	/**
	 * Nombre de constante que contiene la IP real del cliente final.
	 */
	public static final String X_FORWARDED_FOR = "X-Forwarded-For";

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ObtenerIpUtil#obtenerInformacionCabecera(javax.servlet.http.HttpServletRequest)
     */
	@Override
	public Map<String, String> obtenerInformacionCabecera(HttpServletRequest request) {
		StringBuilder log = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		Enumeration<?> headerNames = request.getHeaderNames();
		logger.info("-------------HEADER INFO---------------");
		log.append("\r\n");
		while(headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
			log.append(key);
			log.append(": ");
			log.append(value);
			log.append("\r\n");
		}
		logger.info(log.toString());
		return map;
	}

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ObtenerIpUtil#obtenerDireccionIpCliente(javax.servlet.http.HttpServletRequest)
     */
	@Override
	public String obtenerDireccionIpCliente(HttpServletRequest request) {
		String xForwardedForHeader = request.getHeader(X_FORWARDED_FOR);
		StringBuilder log = new StringBuilder();
		if (xForwardedForHeader == null) {
			xForwardedForHeader = request.getRemoteAddr();
		} else {
			xForwardedForHeader = new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
		}
		log.append("IP del cliente: ");
		log.append(xForwardedForHeader);
		logger.info(log.toString());
		return xForwardedForHeader;
	}
}