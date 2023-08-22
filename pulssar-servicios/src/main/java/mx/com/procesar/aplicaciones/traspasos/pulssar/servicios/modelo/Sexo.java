package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase que contiene los atributos del genero de una persona
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 16/05/2019
 */
public class Sexo implements Serializable {

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = 812178424805379105L;

	/**
	 * claveGenero
	 */
	private String claveGenero;

	/**
	 * descripcionGenero
	 */
	private String descripcionGenero;

	/**
	 * @return el atributo claveGenero
	 */
	public String getClaveGenero() {
		return claveGenero;
	}

	/**
	 * @param claveGenero
	 *            parametro claveGenero a actualizar
	 */
	public void setClaveGenero(String claveGenero) {
		this.claveGenero = claveGenero;
	}

	/**
	 * @return el atributo descripcionGenero
	 */
	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	/**
	 * @param descripcionGenero
	 *            parametro descripcionGenero a actualizar
	 */
	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sexo [claveGenero=" + claveGenero + ", descripcionGenero=" + descripcionGenero + "]";
	}

}
