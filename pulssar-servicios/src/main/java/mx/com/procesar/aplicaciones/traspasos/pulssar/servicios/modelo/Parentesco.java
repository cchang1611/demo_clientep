/**
 * Parentesco.java
 * Fecha de creación: Mar 26, 2019, 1:43:45 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * mapeo de la clase EXPE_TC_PARENTESCO
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 26, 2019
 */
public class Parentesco implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 8547747008165948577L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * descripcion
	 */
	private String descripcion;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * clave parentesco
	 */
	private String claveParentesco;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo claveParentesco
	 */
	public String getClaveParentesco() {
		return claveParentesco;
	}

	/**
	 * @param claveParentesco parametro claveParentesco a actualizar
	 */
	public void setClaveParentesco(String claveParentesco) {
		this.claveParentesco = claveParentesco;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("Parentesco [id=");
		cadena.append(id);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", claveParentesco=");
		cadena.append(claveParentesco);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append("]");
		
		return cadena.toString();
	}

	
}
