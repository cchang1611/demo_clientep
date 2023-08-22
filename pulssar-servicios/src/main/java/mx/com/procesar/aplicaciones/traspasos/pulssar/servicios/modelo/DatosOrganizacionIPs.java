package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Representa la entidad de Organizaciones, mapeado a la tabla PSER_TC_ORGANIZACION
 * 
 * @author DBARBOSA
 */

public class DatosOrganizacionIPs implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -928939498394120663L;

	/**
	 * ips registradas
	 */
	private String clave;
	
	/**
	 * ips a registrar
	 */
	private String idPlataforma;
	
	/**
	 * ips registradas
	 */
	private String vipsPlataforma;
	
	/**
	 * ips a registrar
	 */
	private String ipsPlataforma;

	/**
	 * Constructor sin parametros
	 */
	public DatosOrganizacionIPs() {
		super();
		this.vipsPlataforma = "";
	}

	/**
	 * @return the vipsPlataforma
	 */
	public String getVipsPlataforma() {
		return vipsPlataforma;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the idPlataforma
	 */
	public String getIdPlataforma() {
		return idPlataforma;
	}

	/**
	 * @param idPlataforma the idPlataforma to set
	 */
	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	/**
	 * @param vipsPlataforma the vipsPlataforma to set
	 */
	public void setVipsPlataforma(String vipsPlataforma) {
		this.vipsPlataforma = vipsPlataforma;
	}

	/**
	 * @return the ipsPlataforma
	 */
	public String getIpsPlataforma() {
		return ipsPlataforma;
	}

	/**
	 * @param ipsPlataforma the ipsPlataforma to set
	 */
	public void setIpsPlataforma(String ipsPlataforma) {
		this.ipsPlataforma = ipsPlataforma;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosOrganizacionIPs [clave=");
		builder.append(clave);
		builder.append(", idPlataforma=");
		builder.append(idPlataforma);
		builder.append(", vipsPlataforma=");
		builder.append(vipsPlataforma);
		builder.append(", ipsPlataforma=");
		builder.append(ipsPlataforma);
		builder.append("]");
		return builder.toString();
	}
}