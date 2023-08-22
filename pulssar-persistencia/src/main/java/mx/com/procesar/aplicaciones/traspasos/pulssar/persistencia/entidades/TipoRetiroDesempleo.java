/**
 * TipoRetiroDesempleo.java
 * Fecha de creación: Apr 22, 2019, 5:16:27 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * mapeo de la tabla RETI_TC_TIPO_RETIRO_DESEMPLEO
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 22, 2019
 */
@Entity
@Table(name="RETI_TC_TIPO_RETIRO_DESEMPLEO")
public class TipoRetiroDesempleo implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1662799224575769568L;

	/**
	 * clave
	 */
	@Id
	@Column(name="CV_TIPO_RETIRO_DESEMPLEO")
	private String clave;

	/**
	 * descripcion
	 */
	@Column(name="CH_DESC_TIPO_RETIRO_DESEMPLEO")
	private String descripcion;

	/**
	 * usuario modificador
	 */
	@Column(name="CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * fecha de controls
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="FC_CONTROL")
	private Date fechaControl;

	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave parametro clave a actualizar
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
		cadena.append("TipoRetiroDesempleo [clave=");
		cadena.append(clave);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append("]");
		
		return cadena.toString();
	}

	
}
