package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosCertificables implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4873020537003789006L;

	/**
	 * Curp del trabajador
	 */
	private String curp;
	
	/**
	 * Nombre del trabajador
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno del trabajador
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno del trabajador
	 */
	private String apellidoMaterno;
	
	/**
	 * Fecha de nacimiento
	 */
	private String fechaNacimiento;

	/**
	 * clave Genero
	 */
	private String claveGenero;
	
	/**
	 * Genero
	 */
	private String genero;

	/**
	 * clave de entidad de Nacimiento
	 */
	private String claveEntidadN;
	
	/**
	 * Entidad de Nacimiento
	 */
	private String entidadNacimiento;
	
	/**
	 * idTipoDoctoProbatorio
	 */
	private Long idTipoDoctoProbatorio;
	
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
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the entidadNacimiento
	 */
	public String getEntidadNacimiento() {
		return entidadNacimiento;
	}

	/**
	 * @param entidadNacimiento the entidadNacimiento to set
	 */
	public void setEntidadNacimiento(String entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	/**
	 * @return the claveEntidadN
	 */
	public String getClaveEntidadN() {
		return claveEntidadN;
	}

	/**
	 * @param claveEntidadN the claveEntidadN to set
	 */
	public void setClaveEntidadN(String claveEntidadN) {
		this.claveEntidadN = claveEntidadN;
	}

	/**
	 * @return the claveGenero
	 */
	public String getClaveGenero() {
		return claveGenero;
	}

	/**
	 * @param claveGenero the claveGenero to set
	 */
	public void setClaveGenero(String claveGenero) {
		this.claveGenero = claveGenero;
	}

	/**
	 * @return the idTipoDoctoProbatorio
	 */
	public Long getIdTipoDoctoProbatorio() {
		return idTipoDoctoProbatorio;
	}

	/**
	 * @param idTipoDoctoProbatorio the idTipoDoctoProbatorio to set
	 */
	public void setIdTipoDoctoProbatorio(Long idTipoDoctoProbatorio) {
		this.idTipoDoctoProbatorio = idTipoDoctoProbatorio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosCertificables [curp=");
		builder.append(curp);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", claveGenero=");
		builder.append(claveGenero);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", claveEntidadN=");
		builder.append(claveEntidadN);
		builder.append(", entidadNacimiento=");
		builder.append(entidadNacimiento);
		builder.append(", idTipoDoctoProbatorio=");
		builder.append(idTipoDoctoProbatorio);
		builder.append("]");
		return builder.toString();
	}

	
}