package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;

/**
 * Utileria para lectura de archivo 
 * @author JMGUTIEG
 *
 */
@Component
public class LectorArchivoUtilsImpl implements LectorArchivoUtils{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(LectorArchivoUtilsImpl.class);

	
	/**
	 * Metodo para leer contenido de archivo 
	 */
	@Override
	public String obtenerContenidoArchivo(String ubicacion){
		logger.info("ubicacion archivo {}",ubicacion);
		String sCadena;
		String resultado = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(ubicacion))){
			while ((sCadena = bf.readLine())!=null) {
				   resultado = sCadena;
				}			
		} catch (IOException e) {
			logger.error("Error en la obtencion del archivo",e);
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}
		

		return resultado;
}
}
