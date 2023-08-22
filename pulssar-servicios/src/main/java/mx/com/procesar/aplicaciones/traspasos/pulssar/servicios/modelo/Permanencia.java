package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Permanencia
 * @author jmordone
 *
 */
public class Permanencia implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -9119569502094630666L;

	/**
	 * folioCliente
	 */
	private String folioCliente;
	
	/**
	 * selloVoluntadTrabajador
	 */
	private String selloVoluntadTrabajador;
	
	/**
	 * cuerpo
	 */
	private PermanenciaCuerpo cuerpo;

	/**
	 * @return the folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente the folioCliente to set
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	/**
	 * @return the selloVoluntadTrabajador
	 */
	public String getSelloVoluntadTrabajador() {
		return selloVoluntadTrabajador;
	}

	/**
	 * @param selloVoluntadTrabajador the selloVoluntadTrabajador to set
	 */
	public void setSelloVoluntadTrabajador(String selloVoluntadTrabajador) {
		this.selloVoluntadTrabajador = selloVoluntadTrabajador;
	}

	/**
	 * @return the cuerpo
	 */
	public PermanenciaCuerpo getCuerpo() {
		return cuerpo;
	}

	/**
	 * @param cuerpo the cuerpo to set
	 */
	public void setCuerpo(PermanenciaCuerpo cuerpo) {
		this.cuerpo = cuerpo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Permanencia [folioCliente=");
		builder.append(folioCliente);
		builder.append(", selloVoluntadTrabajador=");
		builder.append(selloVoluntadTrabajador);
		builder.append(", cuerpo=");
		builder.append(cuerpo);
		builder.append("]");
		return builder.toString();
	}
}
