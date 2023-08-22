/**
 * RetirosParcialesMatrizDerecho.java
 * Fecha de creación: Jan 27, 2020 6:10:07 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import org.springframework.core.ParameterizedTypeReference;

/**
 * Modelo base para controlar las respuestas base de los servicios REST con un
 * diagnostico y resultado de la operacion
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 * @param <A>
 */
public class BaseRespuesta<A> {

	/**
	 * Diagnostico de recepcion 01 [Exito] - 02 [Error]
	 */
	private String diagnosticoDeRecepcion;

	/**
	 * Resultado de la operacion mensajes de negocio
	 */
	private String resultadoDeLaOperacion;

	/**
	 * Objecto de respuesta
	 */
	private A objetoRespuesta;

	/**
	 * Constructor vacio
	 */
	public BaseRespuesta() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param diagnosticoDeRecepcion
	 * @param resultadoDeLaOperacion
	 * @param objetoRespuesta
	 */
	public BaseRespuesta(String diagnosticoDeRecepcion, String resultadoDeLaOperacion, A objetoRespuesta) {
		super();
		this.diagnosticoDeRecepcion = diagnosticoDeRecepcion;
		this.resultadoDeLaOperacion = resultadoDeLaOperacion;
		this.objetoRespuesta = objetoRespuesta;
	}

	/**
	 * obtener diagnosticoDeRecepcion
	 */
	public String getDiagnosticoDeRecepcion() {
		return diagnosticoDeRecepcion;
	}

	/**
	 * setear diagnosticoDeRecepcion
	 */
	public void setDiagnosticoDeRecepcion(String diagnosticoDeRecepcion) {
		this.diagnosticoDeRecepcion = diagnosticoDeRecepcion;
	}

	/**
	 * obtener resultadoDeLaOperacion
	 */
	public String getResultadoDeLaOperacion() {
		return resultadoDeLaOperacion;
	}

	/**
	 * setear resultadoDeLaOperacion
	 */
	public void setResultadoDeLaOperacion(String resultadoDeLaOperacion) {
		this.resultadoDeLaOperacion = resultadoDeLaOperacion;
	}

	/**
	 * obtener objetoRespuesta
	 */
	public A getObjetoRespuesta() {
		return objetoRespuesta;
	}

	/**
	 * setear objetoRespuesta
	 */
	public void setObjetoRespuesta(A objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	/**
	 * Se encarga de obtener el tipo de la clase generica
	 * 
	 * @return
	 */
	public ParameterizedTypeReference<BaseRespuesta<A>> getType() {
		return new ParameterizedTypeReference<BaseRespuesta<A>>() {
		};
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseRespuesta [diagnosticoDeRecepcion=");
		builder.append(diagnosticoDeRecepcion);
		builder.append(", resultadoDeLaOperacion=");
		builder.append(resultadoDeLaOperacion);
		builder.append(", objetoRespuesta=");
		builder.append(objetoRespuesta);
		builder.append("]");
		return builder.toString();
	}

}
