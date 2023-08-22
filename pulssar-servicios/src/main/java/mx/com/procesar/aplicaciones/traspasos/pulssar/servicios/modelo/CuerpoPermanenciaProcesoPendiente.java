package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CuerpoPermanenciaProcesoPendiente implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -252038721650704582L;
	
	
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
	private EntradaPermanencia cuerpo;

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
	public EntradaPermanencia getCuerpo() {
		return cuerpo;
	}

	/**
	 * @param cuerpo the cuerpo to set
	 */
	public void setCuerpo(EntradaPermanencia cuerpo) {
		this.cuerpo = cuerpo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CargaPermanenciaProcesoPendiente [folioCliente=");
		builder.append(folioCliente);
		builder.append(", selloVoluntadTrabajador=");
		builder.append(selloVoluntadTrabajador);
		builder.append(", cuerpo=");
		builder.append(cuerpo);
		builder.append("]");
		return builder.toString();
	}
	
	
	


}
