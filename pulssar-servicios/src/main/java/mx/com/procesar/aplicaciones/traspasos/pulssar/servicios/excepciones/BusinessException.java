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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;

/**
 * Excepci�n
 * 
 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since
 */
public class BusinessException extends RuntimeException {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 4736358144719900536L;

	/**
	 * Codigo de error
	 */
	private final String codigo;

	/**
	 * Descripcion del error
	 */
	private final String descripcion;
	
	/**
	 * Descripcion del error
	 */
	private final EntradaConsulta datos;

	/**
	 * Serializaci�n
	 */

	/**
	 * Excepci�n generica por mensaje
	 * 
	 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
	 * @param message
	 */
	public BusinessException(final String message) {
		super(message);
		this.codigo = null;
		this.descripcion = null;
		this.datos = null;
	}

	/**
	 * Constructor por mensaje
	 * 
	 * @author dbarbosa
	 * @param message
	 */
	public BusinessException(final BusinessErrorEnum error) {
		this.codigo = error.getClave();
		this.descripcion = null;
		this.datos = null;
	}
	
	/**
	 * Constructor por mensaje
	 * 
	 * @author dbarbosa
	 * @param message
	 */
	public BusinessException(final BusinessErrorEnum error, EntradaConsulta datos) {
		this.codigo = error.getClave();
		this.descripcion = null;
		this.datos = datos;
	}
	
	/**
	 * Constructor por mensaje
	 * 
	 * @author dbarbosa
	 * @param message
	 */
	public BusinessException(final BusinessErrorEnum error, String codigo) {
		this.codigo = codigo;
		this.descripcion = "";
		this.datos = null;
	}

	/**
	 * Excepci�n generica por mensaje y Throwable
	 * 
	 * @author Rodolfo Dami�n Rojas Rodr�guez (rdrojas@inet.procesar.com.mx)
	 * @param message
	 * @param throwable
	 */
	public BusinessException(final String message, final Throwable throwable) {
		super(message, throwable);
		this.codigo = null;
		this.descripcion = null;
		this.datos = null;
	}

	/**
	 * Excepci�n generica por mensaje y codigo
	 * 
	 * @author Jose Eduardo Martinez Diaz (jemartin@procesar.com)
	 * @param message
	 * @param codigo
	 */
	public BusinessException(final String message, final String codigo) {
		super(message);
		this.codigo = codigo;
		this.descripcion = null;
		this.datos = null;
	}

	/**
	 * get del codigo de error
	 * 
	 * @author Jose Eduardo Martinez Diaz (jemartin@procesar.com)
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * get de descrpcion de error
	 * 
	 * @author Jose Eduardo Martinez Diaz (jemartin@procesar.com)
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the datos
	 */
	public EntradaConsulta getDatos() {
		return datos;
	}
}