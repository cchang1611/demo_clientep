package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
* Entidad embebida para primary key
* 
* @author dbarbosa
* @version 1.0
*/
@Embeddable
public class AforeZonaOficinaPK implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1687171212730089692L;
	
	/**
	 * Clave Afore
	 */
	private String cveAfore;
	
	/**
	 * Clave Oficina
	 */
	private String cveOficina;
	
	/**
	 * Identificador Zona
	 */
	private Long idZona;

	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}

	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}

	/**
	 * @return the cveOficina
	 */
	public String getCveOficina() {
		return cveOficina;
	}

	/**
	 * @param cveOficina the cveOficina to set
	 */
	public void setCveOficina(String cveOficina) {
		this.cveOficina = cveOficina;
	}

	/**
	 * @return the idZona
	 */
	public Long getIdZona() {
		return idZona;
	}

	/**
	 * @param idZona the idZona to set
	 */
	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AforeZonaOficinaPK [ cveAfore=");
		builder.append(cveAfore);
		builder.append(", cveOficina=");
		builder.append(cveOficina);
		builder.append(", idZona=");
		builder.append(idZona);
		builder.append("]");
		return builder.toString();
	}
}