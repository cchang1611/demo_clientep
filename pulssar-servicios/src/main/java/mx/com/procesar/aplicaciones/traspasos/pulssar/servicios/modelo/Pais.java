/**
 * Pais.java
 * Fecha de creación: Mar 26, 2019, 4:32:27 PM
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
 * mapeo de la tabla NSAR_TC_PAIS
 * @author Jose Alberto Castillo Moctezuma  (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 26, 2019
 */
public class Pais implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 4729826787766195115L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * nombre del pais
	 */
	private String descripcion;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * clave corta del pais
	 */
	private String clavePais;

	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * @return el atributo idPais
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param idPais parametro idPais a actualizar
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
	 * @return el atributo clavePais
	 */
	public String getClavePais() {
		return clavePais;
	}

	/**
	 * @param clavePais parametro clavePais a actualizar
	 */
	public void setClavePais(String clavePais) {
		this.clavePais = clavePais;
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
		cadena.append("Pais [id=");
		cadena.append(id);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", clavePais=");
		cadena.append(clavePais);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append("]");
		
		return cadena.toString();
	}

	
}
