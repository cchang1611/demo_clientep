package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class Referencia implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4838884287695838273L;

	/**
	 * Curp Referencia
	 */
	private String curp;

	/**
	 * Nombre Referencia
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno Referencia
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno Referencia
	 */
	private String apellidoMaterno;
	
	/**
	 * telefono Referencia
	 */
	private String telefono;
	
	/**
	 * clave parentesco
	 */
	private String claveParentesco;
	
	/**
	 * Parentesco Referencia 
	 */
	private String parentesco;
	
	/**
	 * fechaControl
	 */
	private String fechaControl;
	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the parentesco
	 */
	public String getParentesco() {
		return parentesco;
	}

	/**
	 * @param parentesco the parentesco to set
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	/**
	 * @return the claveParentesco
	 */
	public String getClaveParentesco() {
		return claveParentesco;
	}

	/**
	 * @param claveParentesco the claveParentesco to set
	 */
	public void setClaveParentesco(String claveParentesco) {
		this.claveParentesco = claveParentesco;
	}

	
	/**
	 * @return the fechaControl
	 */
	public String getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(String fechaControl) {
		this.fechaControl = fechaControl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Referencia [curp=");
		builder.append(curp);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", claveParentesco=");
		builder.append(claveParentesco);
		builder.append(", parentesco=");
		builder.append(parentesco);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}

	
}