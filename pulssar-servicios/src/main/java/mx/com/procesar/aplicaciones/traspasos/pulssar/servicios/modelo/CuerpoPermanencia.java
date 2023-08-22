package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase para manejo de peticion a procesos pendientes
 * @author JMGUTIEG
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CuerpoPermanencia {
	
	/**
	 * Folio cliente
	 */
	private String folioCliente;
	
	/**
	 * sello voluntad trabajador
	 */
	private String selloVoluntadTrabajador;
	
	/**
	 * Cuerpo de peticion para permanencia
	 */
	private CargaPermanencia cuerpo;

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
	 * @return the cuerpo
	 */
	public CargaPermanencia getCuerpo() {
		return cuerpo;
	}

	/**
	 * @param cuerpo the cuerpo to set
	 */
	public void setCuerpo(CargaPermanencia cuerpo) {
		this.cuerpo = cuerpo;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CuerpoPermanencia [folioCliente=");
		builder.append(folioCliente);
		builder.append(", selloVoluntadTrabajador=");
		builder.append(selloVoluntadTrabajador);
		builder.append(", cuerpo=");
		builder.append(cuerpo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
