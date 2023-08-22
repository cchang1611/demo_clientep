/**
 * FolioDetalle.java
 * Fecha de creación: 08/05/2019, 16:38:01
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Mapeo entidad PSER_TB_FOLIO_PULSSAR_DETALLE
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 08/05/2019
 */
public class FolioDetalle implements Serializable {
	/**
	 * Serial Id
	 */
	private static final long serialVersionUID = -8669590904378226726L;
	
	/**
	 * id Folio Pulssar Detalle
	 */
	private Long idFolioPulssarDetalle;
	
	/**
	 * id Folio Pulssar
	 */
	private Long idFolioPulssar;
	
	/**
	 * clave Proceso
	 */
	private Long idProceso;
	
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
	 * Folio
	 */
	@JsonIgnore
	private Folio folio;

	/**
	 * @return el atributo idFolioPulssarDetalle
	 */
	public Long getIdFolioPulssarDetalle() {
		return idFolioPulssarDetalle;
	}

	/**
	 * @param idFolioPulssarDetalle
	 *            parametro idFolioPulssarDetalle a actualizar
	 */
	public void setIdFolioPulssarDetalle(Long idFolioPulssarDetalle) {
		this.idFolioPulssarDetalle = idFolioPulssarDetalle;
	}

	/**
	 * @return el atributo idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}

	/**
	 * @param idFolioPulssar
	 *            parametro idFolioPulssar a actualizar
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}

	/**
	 * @return el atributo idProceso
	 */
	public Long getIdProceso() {
		return idProceso;
	}

	/**
	 * @param idProceso
	 *            parametro idProceso a actualizar
	 */
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
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

	/**
	 * @return el atributo folio
	 */
	public Folio getFolio() {
		return folio;
	}

	/**
	 * @param folio
	 *            parametro folio a actualizar
	 */
	public void setFolio(Folio folio) {
		this.folio = folio;
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
		builder.append("FolioDetalle [idFolioPulssarDetalle=");
		builder.append(idFolioPulssarDetalle);
		builder.append(", idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", idProceso=");
		builder.append(idProceso);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", folio=");
		builder.append(folio);
		builder.append("]");
		return builder.toString();
	}
}
