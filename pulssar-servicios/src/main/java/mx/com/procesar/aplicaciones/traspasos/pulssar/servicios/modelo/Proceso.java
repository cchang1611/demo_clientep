/**
 * Proceso.java Fecha de creación: 07/08/2019, 11:42:15 Copyright (c) 2019 Procesar S A de C V.
 * Todos los derechos reservados. Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial no deberá ser divulgada y solo se podrá
 * utilizar de acuerdo a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa el mapeo del catálogo de procesos.
 * @author Oscar Enrique González García (oegonzal@procesar.com.mx)
 * @version 1.0
 * @since 07/08/2019, 11:42:15
 */
public class Proceso implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 477939151347672214L;

	/**
	 * Id Proceso
	 */
	private Long idProceso;

	/**
	 * Id servicio
	 */
	private Long idServicio;

	/**
	 * Clave proceso
	 */
	private String claveProceso;

	/**
	 * Descripcion del proceso
	 */
	private String descripcion;

	/**
	 * Estatus del proceso 1=Activo 0=Inactivo
	 */
	private Long estatus;

	/**
	 * Fecha de modificación.
	 */
	private Date fechaControl;

	/**
	 * Usuario que modificó el catálogo.
	 */
	private String usuarioModificador;

	/**
	 * @return el atributo idProceso
	 */
	public Long getIdProceso() {
		return idProceso;
	}

	/**
	 * @param idProceso parametro idProceso a actualizar
	 */
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}

	/**
	 * @return el atributo idServicio
	 */
	public Long getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio parametro idServicio a actualizar
	 */
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
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
	 * @return el atributo estatus
	 */
	public Long getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus parametro estatus a actualizar
	 */
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
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

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Proceso [idProceso=");
		builder.append(idProceso);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}