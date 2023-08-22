package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa una Afore, mapeado a la tabla NSAR_TC_AFORE
 * 
 * @author OJBALBUE
 * 
 */

public class Afore implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -3861947866338064750L;

	/**
	 * Indicador de activo/inactivo
	 */
	private Integer activo;

	/**
	 * Clave de la afore
	 */
	private String claveAfore;

	/**
	 * Descripción
	 */
	private String descripcionAfore;

	/**
	 * Identificador
	 */
	private Long id;

	/**
	 * /** Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * Teléfono de la Afore
	 */
	private String telefonoAfore;

	/**
	 * Tipo de administracion
	 */
	private String tipoAdministracion;

	/**
	 * @return the activo
	 */
	public Integer getActivo() {

		return activo;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {

		return claveAfore;
	}

	/**
	 * @return the descripcionAfore
	 */
	public String getDescripcionAfore() {

		return descripcionAfore;
	}

	/**
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * @return the telefonoAfore
	 */
	public String getTelefonoAfore() {

		return telefonoAfore;
	}

	/**
	 * @param activo
	 *            the activo to set
	 */
	public void setActivo(Integer activo) {

		this.activo = activo;
	}

	/**
	 * @param claveAfore
	 *            the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {

		this.claveAfore = claveAfore;
	}

	/**
	 * @param descripcionAfore
	 *            the descripcionAfore to set
	 */
	public void setDescripcionAfore(String descripcionAfore) {

		this.descripcionAfore = descripcionAfore;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @param telefonoAfore
	 *            the telefonoAfore to set
	 */
	public void setTelefonoAfore(String telefonoAfore) {

		this.telefonoAfore = telefonoAfore;
	}

	/**
	 * Obtiene la fecha de control
	 * 
	 * @return
	 */
	public Date getFechaControl() {

		return fechaControl == null ? null : (Date) fechaControl.clone();
	}

	/**
	 * Establece la fecha de control
	 * 
	 * @param fechaControl
	 */
	public void setFechaControl(Date fechaControl) {

		this.fechaControl = fechaControl == null ? null : (Date) fechaControl.clone();
	}

	/**
	 * Obtiene el usuario modificador
	 * 
	 * @return
	 */
	public String getUsuarioModificador() {

		return usuarioModificador;
	}

	/**
	 * Establece el usuario modificador
	 * 
	 * @param usuarioModificador
	 */
	public void setUsuarioModificador(String usuarioModificador) {

		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo tipoAdministracion
	 */
	public String getTipoAdministracion() {
		return tipoAdministracion;
	}

	/**
	 * @param tipoAdministracion
	 *            parametro tipoAdministracion a actualizar
	 */
	public void setTipoAdministracion(String tipoAdministracion) {
		this.tipoAdministracion = tipoAdministracion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Afore [activo=");
		builder.append(activo);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", descripcionAfore=");
		builder.append(descripcionAfore);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", telefonoAfore=");
		builder.append(telefonoAfore);
		builder.append(", tipoAdministracion=");
		builder.append(tipoAdministracion);
		builder.append("]");
		return builder.toString();
	}
}