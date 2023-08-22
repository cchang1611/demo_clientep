/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;

/**
 * @author malopezt
 * @since 2022/02/03
 * @version 1.0
 */
public class CovierteJSONStringEnObjeto <T> {

	/** Registro */
	private static final Logger logger = 
			LoggerFactory.getLogger(CovierteJSONStringEnObjeto.class);
	
	/** Constructor privado vacio*/
	private CovierteJSONStringEnObjeto() {
		// Nada por hacer
	}
	
	/**
	 * Devuelve un objeto a partir del Json ingresado desde una cadena de texto.
	 * @param jsonString
	 * @param objeto
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T devulveObjeto(String jsonString, T objeto) 
			throws BusinessException {
		
		T  miVar = null;
		try {
			miVar = (T) new ObjectMapper().readValue(jsonString, objeto.getClass());
		} catch (IOException e) {
			logger.error("[CovierteJSONStringEnObjeto][devulveObjeto] - Error - json entrante: {}", 
					jsonString, e.getMessage());
			throw new BusinessException(
					"Json devuelto no reconocido");
		}
		return miVar;
	}
}
