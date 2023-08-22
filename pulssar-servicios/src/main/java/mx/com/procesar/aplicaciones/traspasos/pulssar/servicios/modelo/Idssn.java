package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase con el mapeo de idssn servicios internos
 * 
 * @author JMGUTIER
 *
 */
public class Idssn implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 2210270663093141534L;

	/**
	 * id cliente
	 */
	private int idCliente;
	
	/**
	 * id servicio
	 */
	private int idServicio;
	
	/**
	 * id Ebusiness
	 */
	private int idEbusiness;
	
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the idServicio
	 */
	public int getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the idEbusiness
	 */
	public int getIdEbusiness() {
		return idEbusiness;
	}

	/**
	 * @param idEbusiness the idEbusiness to set
	 */
	public void setIdEbusiness(int idEbusiness) {
		this.idEbusiness = idEbusiness;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Idssn [idCliente=");
		builder.append(idCliente);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", idEbusiness=");
		builder.append(idEbusiness);
		builder.append("]");
		return builder.toString();
	}
}