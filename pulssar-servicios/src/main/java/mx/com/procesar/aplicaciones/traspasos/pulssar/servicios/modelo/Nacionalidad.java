package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


public class Nacionalidad implements Serializable{

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 5661830398273169867L;
	
	/**
	 * identificador
	 */
	private Long id;
	
	/**
	 * clave nacionalidad
	 */
	private String cvNacionalidad;
	
	/**
	 * decripcion
	 */
	private String chDescripcion;
	
	/**
	 * valor despliegue
	 */
	private String chValorDespliegue;
	
	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cvNacionalidad
	 */
	public String getCvNacionalidad() {
		return cvNacionalidad;
	}

	/**
	 * @param cvNacionalidad the cvNacionalidad to set
	 */
	public void setCvNacionalidad(String cvNacionalidad) {
		this.cvNacionalidad = cvNacionalidad;
	}

	/**
	 * @return the chDescripcion
	 */
	public String getChDescripcion() {
		return chDescripcion;
	}

	/**
	 * @param chDescripcion the chDescripcion to set
	 */
	public void setChDescripcion(String chDescripcion) {
		this.chDescripcion = chDescripcion;
	}

	/**
	 * @return the chValorDespliegue
	 */
	public String getChValorDespliegue() {
		return chValorDespliegue;
	}

	/**
	 * @param chValorDespliegue the chValorDespliegue to set
	 */
	public void setChValorDespliegue(String chValorDespliegue) {
		this.chValorDespliegue = chValorDespliegue;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nacionalidad [id=");
		builder.append(id);
		builder.append(", cvNacionalidad=");
		builder.append(cvNacionalidad);
		builder.append(", chDescripcion=");
		builder.append(chDescripcion);
		builder.append(", chValorDespliegue=");
		builder.append(chValorDespliegue);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

	
	
}
