/**
 * LoggingRestInterceptor.java
 * Fecha de creación: Jan 6, 2020 5:00:01 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


/**
 * Clase para interceder las peticiones HTTP del RestTemplate
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public class LoggingRestInterceptor implements ClientHttpRequestInterceptor {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger("LoggingRestInterceptor");
	
	/**
	 * Encoding
	 */
	private static final String ENCONDING = "UTF-8";
	
	/**
	 * Linea separador de logger
	 */
	private static final String SEPARADOR = "\t---------------------------------------------------------------------------------";

	/**
	 * Logger para el header
	 */
	private static final String HEADER = "\tHeader ";

	/**
	 * Logger para el Body
	 */
	private static final String CUERPO = "\tBody ";

	/**
	 * Salto de linea
	 */
	public static final String SALTO_DE_LINEA = "\n";

	/**
	 * Estatus
	 */
	private static final String ESTATUS = "\tEstatus ";

	/**
	 * Url
	 */
	private static final String URL = "\tURL ";

	/**
	 * Metodo
	 */
	private static final String METODO = "\tMetodo ";

	/**
	 * Titulo del formato para la respuesta
	 */
	private static final String TITULO_RESPUESTA = "\t\t\t\t>>>> Respuesta <<< ";

	/**
	 * Titulo del formato para la solicitud
	 */
	private static final String TITULO_SOLICITUD = "\t\t\t\t>>>> Request <<< ";

	

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.client.ClientHttpRequestInterceptor#intercept(
	 * org.springframework.http.HttpRequest, byte[],
	 * org.springframework.http.client.ClientHttpRequestExecution)
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest entrada, byte[] cuerpo, ClientHttpRequestExecution ejecucion)
			throws IOException {
		imprimirSolicitud(entrada, cuerpo);
		ClientHttpResponse respuesta = ejecucion.execute(entrada, cuerpo);
		imprimirRespuesta(respuesta);
		return respuesta;
	}

	/**
	 * Imprime logger de la respuesta de los servicios Rest
	 * 
	 * @param response
	 * @throws IOException
	 */
	private void imprimirRespuesta(ClientHttpResponse respuesta) throws IOException {
		StringBuilder construir = new StringBuilder();
		construir.append(SALTO_DE_LINEA).append(SEPARADOR).append(SALTO_DE_LINEA);
		construir.append(TITULO_RESPUESTA);
		construir.append(SALTO_DE_LINEA).append(ESTATUS);
		construir.append(validarNull(respuesta.getStatusCode()));
		construir.append(SALTO_DE_LINEA).append(HEADER);
		construir.append(validarNull(respuesta.getHeaders()));
		construir.append(SALTO_DE_LINEA).append(CUERPO);
		construir.append(convertirInputStreamAString(respuesta.getBody()));
		construir.append(SALTO_DE_LINEA).append(SEPARADOR);
		logger.debug(construir.toString());
	}

	/**
	 * Imprime logger de la solicitud de los servicios Rest
	 * 
	 * @param request
	 * @param body
	 * @throws IOException
	 */
	private void imprimirSolicitud(HttpRequest entrada, byte[] cuerpo) throws IOException {
		StringBuilder construir = new StringBuilder();
		construir.append(SALTO_DE_LINEA).append(SEPARADOR).append(SALTO_DE_LINEA);
		construir.append(TITULO_SOLICITUD);
		construir.append(SALTO_DE_LINEA).append(URL);
		construir.append(validarNull(entrada.getURI()));
		construir.append(SALTO_DE_LINEA).append(METODO);
		construir.append(validarNull(entrada.getMethod()));
		construir.append(SALTO_DE_LINEA).append(HEADER);
		construir.append(validarNull(entrada.getHeaders()));
		construir.append(SALTO_DE_LINEA).append(CUERPO);
		construir.append(convertirByteAString(cuerpo));
		construir.append(SALTO_DE_LINEA).append(SEPARADOR);
		logger.debug(construir.toString());
	}
	
	/**
	 * Valida si es diferente de null y regresa el toString
	 * 
	 * @return
	 */
	private String validarNull(Object entrada) {
		return entrada != null ? entrada.toString() : "";
	}
	
	/**
	 * Convierte un InputStream a String
	 * 
	 * @param entrada
	 * @return
	 * @throws IOException
	 */
	private String convertirInputStreamAString(InputStream entrada) throws IOException {
		StringBuilder salida = new StringBuilder();
		InputStreamReader lector = new InputStreamReader(entrada, ENCONDING);
		BufferedReader lectura = new BufferedReader(lector);
		String line=lectura.readLine();
		while(line != null) {
			salida.append(line);
		    line = lectura.readLine();
		}
		
		return salida.toString();
	}

	/**
	 * Convierte un array de byte a String
	 * 
	 * @param entrada
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String convertirByteAString(byte[] entrada) throws UnsupportedEncodingException {
		return new String(entrada, ENCONDING);
	}


}
