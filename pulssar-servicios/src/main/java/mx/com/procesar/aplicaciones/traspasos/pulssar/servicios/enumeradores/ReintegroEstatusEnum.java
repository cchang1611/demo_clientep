/**
 * ReintegroEstatusEnum.java
 * Fecha de creaci�n: May 4, 2020 11:25:10 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Enum para reintegro de los estatus de la solicitud y notificaciones
 *
 * @author Williams Alejandro Mart�nez (WALEJAND)
 * @version 1.0
 */
public enum ReintegroEstatusEnum {
	REGISTRADO("01", "Registrado"),
	ENVIADO("02", "Enviado"),
	ACEPTADO("03", "Aceptado"),
	RECHAZADO("04", "Rechazado");

	private final String clave;
	private final String descripcion;

	private ReintegroEstatusEnum(final String clave, final String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
	}

	/**
	 * Obtener clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Obtener descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	public static String getEstatus(String clave) {
		switch (clave) {
		case "01":
			return REGISTRADO.descripcion;
		case "02":
			return ENVIADO.descripcion;
		case "03":
			return ACEPTADO.descripcion;
		case "04":
			return RECHAZADO.descripcion;
		default:
			return null;
		}
	}
}
