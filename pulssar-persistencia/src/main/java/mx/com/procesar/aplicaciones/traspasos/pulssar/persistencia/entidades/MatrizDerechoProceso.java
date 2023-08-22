/**
 * MatrizDerechoProceso.java
 * Fecha de creación: 10/04/2019, 18:06:07
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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mapeo entidad RETI_TR_MATRIZ_DERECHO_PROCESO
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 10/04/2019
 */
@Entity
@Table(name = "RETI_TR_MATRIZ_DERECHO_PROCESO")
@IdClass(MatrizDerechoProcesoPK.class)
public class MatrizDerechoProceso implements Serializable {

	/**
	 * Serial Id
	 */
	private static final long serialVersionUID = -2086553654986123262L;

	/**
	 * Clave de proceso
	 */
	@Id
	@Column(name = "CV_PROCESO")
	private String claveProceso;

	/**
	 * Matriz de derecho
	 */
	@Id
	@Column(name = "ID_MATRIZ_DERECHO")
	private Long idMatrizDerecho;

	/**
	 * Fecha de control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * Relacion con matriz de derecho proceso
	 */
	@OneToOne
	@JoinColumn(name = "ID_MATRIZ_DERECHO", insertable = false, updatable = false)
	private MatrizDerecho matrizDerecho;

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso
	 *            parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * @return el atributo idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho
	 *            parametro idMatrizDerecho a actualizar
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
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

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatrizDerechoProceso [claveProceso=");
		builder.append(claveProceso);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}
