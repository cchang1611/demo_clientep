/**
 * Servicio.java
 * Fecha de creación: 09/05/2019, 18:18:21
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
 * Mapeo entidad PSER_TC_SERVICIO
 * 
 */
public class Servicio implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 9086661618042246838L;
	
	/**
	 * IdServicio
	 */
	private Long idServicio;
	
	/**
	 * clave Servicio
	 */
	private String claveServicio;
	
	/**
	 * descripcion Servicio
	 */
	private String descripcionServicio;
	
	/**
	 * clave Tipo Servicio
	 */
	private String claveTipoServicio;
	
	/**
	 * estatus
	 */
	private Long estatus;
	
	/**
	 * fecha Control
	 */
	private Date fechaControl;
	
	/**
	 * usuario Modificador
	 */
	private String usuarioModificador;
	
	/**
	 * @return el atributo idServicio
	 */
	public Long getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio
	 *            parametro idServicio a actualizar
	 */
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return el atributo claveServicio
	 */
	public String getClaveServicio() {
		return claveServicio;
	}

	/**
	 * @param claveServicio
	 *            parametro claveServicio a actualizar
	 */
	public void setClaveServicio(String claveServicio) {
		this.claveServicio = claveServicio;
	}

	/**
	 * @return el atributo descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param descripcionServicio
	 *            parametro descripcionServicio a actualizar
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	/**
	 * @return el atributo claveTipoServicio
	 */
	public String getClaveTipoServicio() {
		return claveTipoServicio;
	}

	/**
	 * @param claveTipoServicio
	 *            parametro claveTipoServicio a actualizar
	 */
	public void setClaveTipoServicio(String claveTipoServicio) {
		this.claveTipoServicio = claveTipoServicio;
	}

	/**
	 * @return el atributo estatus
	 */
	public Long getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 *            parametro estatus a actualizar
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
		builder.append("Servicio [idServicio=");
		builder.append(idServicio);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", descripcionServicio=");
		builder.append(descripcionServicio);
		builder.append(", claveTipoServicio=");
		builder.append(claveTipoServicio);
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
