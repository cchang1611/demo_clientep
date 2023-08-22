package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class DatosBaseFormulario implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 918408432231034247L;
	
	/**
	 * curp de formulario
	 */
	private String curpNueva;
	
	/**
	 * Nombre de formulario
	 */
	private String nombreNuevo;
	
	/**
	 * Apellido paterno de formulario
	 */
	private String apellidoPaternoNuevo;
	
	/**
	 * Apellido materno de formulario
	 */
	private String apellidoMaternoNuevo;
	
	/**
	 * Fecha nacimiento de formulario
	 */
	private String fechaNacimientoNuevo;
	
	/**
	 * genero de formulario
	 */
	private String generoNuevo;
	
	/**
	 * entidad de nacimiento de formulario 
	 */
	private String entidadNacimientoNuevo;

	/**
	 * @return the curpNueva
	 */
	public String getCurpNueva() {
		return curpNueva;
	}

	/**
	 * @param curpNueva the curpNueva to set
	 */
	public void setCurpNueva(String curpNueva) {
		this.curpNueva = curpNueva;
	}

	/**
	 * @return the nombreNuevo
	 */
	public String getNombreNuevo() {
		return nombreNuevo;
	}

	/**
	 * @param nombreNuevo the nombreNuevo to set
	 */
	public void setNombreNuevo(String nombreNuevo) {
		this.nombreNuevo = nombreNuevo;
	}

	/**
	 * @return the apellidoPaternoNuevo
	 */
	public String getApellidoPaternoNuevo() {
		return apellidoPaternoNuevo;
	}

	/**
	 * @param apellidoPaternoNuevo the apellidoPaternoNuevo to set
	 */
	public void setApellidoPaternoNuevo(String apellidoPaternoNuevo) {
		this.apellidoPaternoNuevo = apellidoPaternoNuevo;
	}

	/**
	 * @return the apellidoMaternoNuevo
	 */
	public String getApellidoMaternoNuevo() {
		return apellidoMaternoNuevo;
	}

	/**
	 * @param apellidoMaternoNuevo the apellidoMaternoNuevo to set
	 */
	public void setApellidoMaternoNuevo(String apellidoMaternoNuevo) {
		this.apellidoMaternoNuevo = apellidoMaternoNuevo;
	}

	/**
	 * @return the fechaNacimientoNuevo
	 */
	public String getFechaNacimientoNuevo() {
		return fechaNacimientoNuevo;
	}

	/**
	 * @param fechaNacimientoNuevo the fechaNacimientoNuevo to set
	 */
	public void setFechaNacimientoNuevo(String fechaNacimientoNuevo) {
		this.fechaNacimientoNuevo = fechaNacimientoNuevo;
	}

	/**
	 * @return the generoNuevo
	 */
	public String getGeneroNuevo() {
		return generoNuevo;
	}

	/**
	 * @param generoNuevo the generoNuevo to set
	 */
	public void setGeneroNuevo(String generoNuevo) {
		this.generoNuevo = generoNuevo;
	}

	/**
	 * @return the entidadNacimientoNuevo
	 */
	public String getEntidadNacimientoNuevo() {
		return entidadNacimientoNuevo;
	}

	/**
	 * @param entidadNacimientoNuevo the entidadNacimientoNuevo to set
	 */
	public void setEntidadNacimientoNuevo(String entidadNacimientoNuevo) {
		this.entidadNacimientoNuevo = entidadNacimientoNuevo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBaseFormulario [curpNueva=");
		builder.append(curpNueva);
		builder.append(", nombreNuevo=");
		builder.append(nombreNuevo);
		builder.append(", apellidoPaternoNuevo=");
		builder.append(apellidoPaternoNuevo);
		builder.append(", apellidoMaternoNuevo=");
		builder.append(apellidoMaternoNuevo);
		builder.append(", fechaNacimientoNuevo=");
		builder.append(fechaNacimientoNuevo);
		builder.append(", generoNuevo=");
		builder.append(generoNuevo);
		builder.append(", entidadNacimientoNuevo=");
		builder.append(entidadNacimientoNuevo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
