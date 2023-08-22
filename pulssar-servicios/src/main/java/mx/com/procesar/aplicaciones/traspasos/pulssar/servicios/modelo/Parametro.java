package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa a la Entidad parametro
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class Parametro implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -904462959561444906L;

	/**
	 * idParametro
	 */
	private Long idParametro;

	/**
	 * cvParametro
	 */
	private String cvParametro;

	/**
	 * chParametro
	 */
	private String chParametro;

	/**
	 * chValorParametro
	 */
	private String chValorParametro;

	/**
	 * fechaModificacion
	 */
	private Date fechaModificacion;

	/**
	 * usuarioModificacion
	 */
	private String usuarioModificacion;

	public Parametro() {
	}

	/**
	 * 
	 * @param chParametro
	 */
	public Parametro(String chParametro) {
		super();
		this.chParametro = chParametro;
	}

	/**
	 * @return the idParametro
	 */
	public Long getIdParametro() {
		return idParametro;
	}

	/**
	 * @param idParametro
	 *            the idParametro to set
	 */
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	/**
	 * @return the cvParametro
	 */
	public String getCvParametro() {
		return cvParametro;
	}

	/**
	 * @param cvParametro
	 *            the cvParametro to set
	 */
	public void setCvParametro(String cvParametro) {
		this.cvParametro = cvParametro;
	}

	/**
	 * @return the chParametro
	 */
	public String getChParametro() {
		return chParametro;
	}

	/**
	 * @param chParametro
	 *            the chParametro to set
	 */
	public void setChParametro(String chParametro) {
		this.chParametro = chParametro;
	}

	/**
	 * @return the chValorParametro
	 */
	public String getChValorParametro() {
		return chValorParametro;
	}

	/**
	 * @param chValorParametro
	 *            the chValorParametro to set
	 */
	public void setChValorParametro(String chValorParametro) {
		this.chValorParametro = chValorParametro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chValorParametro == null) ? 0 : chValorParametro.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parametro other = (Parametro) obj;
		if (chValorParametro == null) {
			if (other.chValorParametro != null)
				return false;
		} else if (!chValorParametro.equals(other.chValorParametro))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parametro [idParametro=");
		builder.append(idParametro);
		builder.append(", cvParametro=");
		builder.append(cvParametro);
		builder.append(", chParametro=");
		builder.append(chParametro);
		builder.append(", chValorParametro=");
		builder.append(chValorParametro);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append(", usuarioModificacion=");
		builder.append(usuarioModificacion);
		builder.append("]");
		return builder.toString();
	}
}
