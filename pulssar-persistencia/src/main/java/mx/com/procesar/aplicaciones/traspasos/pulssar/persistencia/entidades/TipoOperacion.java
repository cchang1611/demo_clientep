/**
 * TipoOperacion.java
 * Fecha de creación: Apr 1, 2019, 1:30:15 PM
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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * mapeo de la tabla RETI_TC_TIPO_OPERACION
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 1, 2019
 */
@Entity
@Table(name = "RETI_TC_TIPO_OPERACION")
@NamedQuery(name = "TipoOperacion.findAll", query = "SELECT r FROM TipoOperacion r")
public class TipoOperacion implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 8293260814032202300L;

	/**
	 * id
	 */
	@EmbeddedId
	private TipoOperacionPK id;

	/**
	 * descripcion de tipo de operacion
	 */
	@Column(name = "CH_DESC_TIPO_OPERACION")
	private String descripcion;

	/**
	 * usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * fecha de control
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fechaControl;

	/**
	 * @return el atributo id
	 */
	public TipoOperacionPK getId() {
		return id;
	}

	/**
	 * @param id
	 *            parametro id a actualizar
	 */
	public void setId(TipoOperacionPK id) {
		this.id = id;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            parametro descripcion a actualizar
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
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
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
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("TipoOperacion [id=");
		cadena.append(id);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);

		return cadena.toString();
	}

}
