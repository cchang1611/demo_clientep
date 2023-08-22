/**
 * ExcepcionesEnum.java
 * Fecha de creación: 03/07/2019, 12:39:09
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Enumeración de excepciones
 * @author David Barbosa (dbarbosa)
 * @version 1.0
 * @since 
 */
public enum ExcepcionesEnum {
	
	/**
	 * Clave para indicar que el trabajador no cuenta con manos
	 */
	M001("001", "La persona no tiene ambas manos"),
	
	/**
	 * Clave para indicar que el trabajador no cuenta con la mano derecha
	 */
	M002("002", "La persona no tiene la mano derecha"),
	
	/**
	 * Clave para indicar que el trabajador no cuenta con la mano izquierda
	 */
	M003("003", "La persona no tiene la mano izquierda"),
	
	/**
	 * Clave para indicar que el trabajador tiene lesionadas las manos
	 */
	M004("004", "La Persona tiene lesionadas ambas manos"),
	
	/**
	 * Clave para indicar que el trabajador tiene lesionadas la mano derecha
	 */
	M005("005", "La Persona tiene lesionada la mano derecha"),
	
	/**
	 * Clave para indicar que el trabajador tiene lesionadas la mano izquierda
	 */
	M006("006", "La Persona tiene lesionada la mano izquierda"),
	
	/**
	 * Clave para indicar que el trabajador no puede capturar una huella
	 */
	M007("007", "La huella dactilar no puede ser capturada"),
	
	/**
	 * Clave para indicar que el trabajador no cuenta con el dedo
	 */
	M008("008", "El dedo a ser capturado está amputado"),
	
	/**
	 * Clave para indicar que el trabajador tiene el dedo lesionado
	 */
	M009("009", "El dedo a ser capturado está lesionado"),
	
	/**
	 * Clave para indicar que el trabajador cuenta con huella parcial
	 */
	M010("010", "El dedo a capturar cuenta con una huella parcial"),
	
	/**
	 * Clave para indicar que el empleado se enrolo sin huellas dactilares
	 */
	M011("011", "El Empleado se enroló sin huellas dactilares"),
	
	/**
	 * Clave para indicar que el trabajador se enrolo sin huellas dactilares
	 */
	M012("012", "El Trabajador se enroló sin huellas dactilares"),
	
	/**
	 * Excepcion generica
	 */
	M000("000", "N/A");
	
	/**
	 * Clave de la excepcion
	 */
	private String clave;
	
	/**
	 * Descripcion de la excepcion
	 */
	private String descripcion;

	/**
	 *  Constructor
	 *  @author David Barbosa (dbarbosa)
	 *  @param clave
	 *  @param descripcion
	 */
	
	private ExcepcionesEnum(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
	}
	
	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}
	
	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo para obtener la excepcion
	 * @param clave
	 * @return
	 */
	public static ExcepcionesEnum obtenerMensajeExcepcion(String clave) {
		ExcepcionesEnum regreso = ExcepcionesEnum.M000;
		
		for (ExcepcionesEnum e : ExcepcionesEnum.values()) {
			if (e.getClave().equals(clave)) {
				regreso = e;
			}
		}
		return regreso;
	}
}