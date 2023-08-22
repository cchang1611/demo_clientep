package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

public class BanderaDatosModificadosReferencias {

	/**
	 * Modificacion curp
	 */
	private boolean isModificacionCurp;
	
	/**
	 * Modificacion nombre
	 */
	private boolean isModificacionNombre;
	
	/**
	 * Modificacion apellido paterno
	 */
	private boolean isModificacionApellidoPaterno;
	
	/**
	 * modificacion apellido materno
	 */
	private boolean isModificacionApellidoMaterno;
	
	/**
	 * Modificacion telefono 
	 */
	private boolean isModificacionTelefono;
	
	/**
	 * Modificacion parentesco
	 */
	private boolean isModificacionParentesco;

	/**
	 * @return the isModificacionCurp
	 */
	public boolean isModificacionCurp() {
		return isModificacionCurp;
	}

	/**
	 * @param isModificacionCurp the isModificacionCurp to set
	 */
	public void setModificacionCurp(boolean isModificacionCurp) {
		this.isModificacionCurp = isModificacionCurp;
	}

	/**
	 * @return the isModificacionNombre
	 */
	public boolean isModificacionNombre() {
		return isModificacionNombre;
	}

	/**
	 * @param isModificacionNombre the isModificacionNombre to set
	 */
	public void setModificacionNombre(boolean isModificacionNombre) {
		this.isModificacionNombre = isModificacionNombre;
	}

	/**
	 * @return the isModificacionApellidoPaterno
	 */
	public boolean isModificacionApellidoPaterno() {
		return isModificacionApellidoPaterno;
	}

	/**
	 * @param isModificacionApellidoPaterno the isModificacionApellidoPaterno to set
	 */
	public void setModificacionApellidoPaterno(boolean isModificacionApellidoPaterno) {
		this.isModificacionApellidoPaterno = isModificacionApellidoPaterno;
	}

	/**
	 * @return the isModificacionApellidoMaterno
	 */
	public boolean isModificacionApellidoMaterno() {
		return isModificacionApellidoMaterno;
	}

	/**
	 * @param isModificacionApellidoMaterno the isModificacionApellidoMaterno to set
	 */
	public void setModificacionApellidoMaterno(boolean isModificacionApellidoMaterno) {
		this.isModificacionApellidoMaterno = isModificacionApellidoMaterno;
	}

	/**
	 * @return the isModificacionTelefono
	 */
	public boolean isModificacionTelefono() {
		return isModificacionTelefono;
	}

	/**
	 * @param isModificacionTelefono the isModificacionTelefono to set
	 */
	public void setModificacionTelefono(boolean isModificacionTelefono) {
		this.isModificacionTelefono = isModificacionTelefono;
	}

	/**
	 * @return the isModificacionParentesco
	 */
	public boolean isModificacionParentesco() {
		return isModificacionParentesco;
	}

	/**
	 * @param isModificacionParentesco the isModificacionParentesco to set
	 */
	public void setModificacionParentesco(boolean isModificacionParentesco) {
		this.isModificacionParentesco = isModificacionParentesco;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BanderaDatosModificadosReferencias [isModificacionCurp=");
		builder.append(isModificacionCurp);
		builder.append(", isModificacionNombre=");
		builder.append(isModificacionNombre);
		builder.append(", isModificacionApellidoPaterno=");
		builder.append(isModificacionApellidoPaterno);
		builder.append(", isModificacionApellidoMaterno=");
		builder.append(isModificacionApellidoMaterno);
		builder.append(", isModificacionTelefono=");
		builder.append(isModificacionTelefono);
		builder.append(", isModificacionParentesco=");
		builder.append(isModificacionParentesco);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
