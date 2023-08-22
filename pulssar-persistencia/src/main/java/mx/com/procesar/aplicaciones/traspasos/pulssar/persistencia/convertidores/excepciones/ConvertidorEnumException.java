/**
 * ConvertidorEnumException.java
 * Fecha de creaci�n: 19/01/2017, 10:50:34
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.convertidores.excepciones;


/**
 * Clase de Excepcion para EnumConvertir al realizar conversiones
 * @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com)
 * @version 1.0
 * @since 
 */
public class ConvertidorEnumException extends RuntimeException {

	/**
	 * Serializacion
	 */
	

	/**
	 *  Constructor por Mensaje de Excepcion
	 *  @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
	 *  @param mensaje Mensaje de Excepcion
	 */
	public ConvertidorEnumException(String mensaje) {
		super(mensaje);
	}
	/**
	 *  Constructor por Mensaje de Excepcion y Objeto Throwable
	 *  @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
	 *  @param mensaje Mensaje de Excepcion
	 *  @param causa Causa de la Excepcion
	 */
	public ConvertidorEnumException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
