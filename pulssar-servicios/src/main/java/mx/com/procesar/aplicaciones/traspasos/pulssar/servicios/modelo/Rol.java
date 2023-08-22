package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad de Rol
 * 
 * @author mahernan
 */
public class Rol implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2410891112108132299L;

	/**
	 * Id de rol
	 */
	private Long idRol;

	/**
	 * Clave del Rol.
	 */
	private String claveRol;

	/**
	 * Clave de la AFORE.
	 */
	private String claveAfore;

	/**
	 * Descripcion de ROL.
	 */
	private String descripcionRol;

	/**
	 * Fecha de ultima modificacion.
	 */
	private Date fecha;

	/**
	 * Indicador de activo/inactivo
	 */
	private String usuario;
	
	/**
	 * @return the idRol
	 */
	public Long getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

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
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
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
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
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
		builder.append("Rol [");
		if (idRol != null) {
			builder.append("idRol=");
			builder.append(idRol);
			builder.append(", ");
		}
		if (claveRol != null) {
			builder.append("claveRol=");
			builder.append(claveRol);
			builder.append(", ");
		}
		if (claveAfore != null) {
			builder.append("claveAfore=");
			builder.append(claveAfore);
			builder.append(", ");
		}
		if (descripcionRol != null) {
			builder.append("descripcionRol=");
			builder.append(descripcionRol);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
			builder.append(", ");
		}
		if (usuario != null) {
			builder.append("usuario=");
			builder.append(usuario);
		}
		builder.append("]");
		return builder.toString();
	}	
}