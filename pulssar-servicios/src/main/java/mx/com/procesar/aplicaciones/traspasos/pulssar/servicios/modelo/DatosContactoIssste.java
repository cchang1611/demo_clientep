/**
 * DatosContactoIssste.java
 * Fecha de creación: Nov 4, 2019, 7:30:48 PM
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

/**
 * datos de contacto para issste
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Nov 4, 2019
 */
public class DatosContactoIssste {
	/**
	 * telefono
	 */
	private String telefono;
	
	/**
	 * lada
	 */
	private String lada;
	
	/**
	 * extension
	 */
	private String extension;
	
	/**
	 * horariode atencion
	 */
	private String horarioAtencion;

	/**
	 * @return el atributo telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono parametro telefono a actualizar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return el atributo lada
	 */
	public String getLada() {
		return lada;
	}

	/**
	 * @param lada parametro lada a actualizar
	 */
	public void setLada(String lada) {
		this.lada = lada;
	}

	/**
	 * @return el atributo extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension parametro extension a actualizar
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return el atributo horarioAtencion
	 */
	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	/**
	 * @param horarioAtencion parametro horarioAtencion a actualizar
	 */
	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosContactoIssste [telefono=");
		builder.append(telefono);
		builder.append(", lada=");
		builder.append(lada);
		builder.append(", extension=");
		builder.append(extension);
		builder.append(", horarioAtencion=");
		builder.append(horarioAtencion);
		builder.append("]");
		return builder.toString();
	}
	
}
