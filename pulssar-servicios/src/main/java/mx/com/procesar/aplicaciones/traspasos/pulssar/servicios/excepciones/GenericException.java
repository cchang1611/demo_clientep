/**
 * GenericException.java
 * Fecha de creaci�n: 31/03/2016, 11:02:23
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;

/**
 * Excepcion generica
 * 
 * @author OJBALBUE
 * @version 1.0
 * @since 
 */
public class GenericException extends RuntimeException {
	
	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 5582641960634744767L;
	
	/**
	 * Codigo error
	 */
	private String codigo;
	
	/**
	 * Codigo error
	 */
	private int flujo; 
	
	/**
	 * Constructor por mensaje
	 * 
	 * @param message
	 */
	public GenericException(final String message) {
		super(message);
	}

	/**
	 * Excepcion generica por mensaje y Throwable
	 * 
	 * @param message
	 * @param throwable
	 */
	public GenericException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
	
	/**
	 * Constructor por mensaje
	 * 
	 * @param message
	 */
	public GenericException(final GenericErrorEnum error) {
		this.codigo = error.getClave();
	}
	
	/**
	 * Constructor por mensaje
	 * 
	 * @param message
	 */
	public GenericException(final GenericErrorEnum error, String message) {
		super(message);
		this.codigo = error.getClave();
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * @return the flujo
	 */
	public int getFlujo() {
		return flujo;
	}
}
