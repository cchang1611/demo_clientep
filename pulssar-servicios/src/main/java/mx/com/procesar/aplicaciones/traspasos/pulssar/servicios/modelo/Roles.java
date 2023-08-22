package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;
/**
 * Representa la entidad de Roles, mapeado a la tabla TRAN_TC_ROL_PULSSAR
 * 
 * @author DBARBOSA
 */

public class Roles{
	
	/**
	 * Serial version
	 */

	/**
	 * Clave del Rol.
	 */
	private String claveRol;
	
	/**
	 * Descripción de ROL.
	 */
	private String descripcionRol;
	
	/**
	 * Fecha de ultima modificación.
	 */
	private String fecha;
	
	/**
	 * Indicador de activo/inactivo
	 */
	private String usuario;
	
	/**
	 * @return the claveRol
	 */
	public String getClaveRol() {
		return claveRol;
	}

	/**
	 * @param claveRol the claveRol to set
	 */
	public void setClaveRol(String claveRol) {
		this.claveRol = claveRol;
	}

	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Roles [claveRol=");
		builder.append(claveRol);
		builder.append(", descripcionRol=");
		builder.append(descripcionRol);
		builder.append("[fecha=");
		builder.append(fecha);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}
}