package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Representa el objeto para la peticion de banorte a su table
 * 
 * @author DBARBOSA
 * 
 */

public class TabletBanorte implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -396667238361172808L;

	/**
	 * Folio padre
	 */
	private String folioPadre;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * clave servicio
	 */
	private String claveServicio;

	/**
	 * tipo parentesco
	 */
	private String tipoParentesco;

	/**
	 * tramite no presencial
	 */
	private String tramitePresencial;
	
	/**
	 * @return the folioPadre
	 */
	public String getFolioPadre() {
		return folioPadre;
	}

	/**
	 * @param folioPadre the folioPadre to set
	 */
	public void setFolioPadre(String folioPadre) {
		this.folioPadre = folioPadre;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the claveServicio
	 */
	public String getClaveServicio() {
		return claveServicio;
	}

	/**
	 * @param claveServicio the claveServicio to set
	 */
	public void setClaveServicio(String claveServicio) {
		this.claveServicio = claveServicio;
	}

	/**
	 * @return the tipoParentesco
	 */
	public String getTipoParentesco() {
		return tipoParentesco;
	}

	/**
	 * @param tipoParentesco the tipoParentesco to set
	 */
	public void setTipoParentesco(String tipoParentesco) {
		this.tipoParentesco = tipoParentesco;
	}

	/**
	 * @return the tramitePresencial
	 */
	public String getTramitePresencial() {
		return tramitePresencial;
	}

	/**
	 * @param tramitePresencial the tramitePresencial to set
	 */
	public void setTramitePresencial(String tramitePresencial) {
		this.tramitePresencial = tramitePresencial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TabletBanorte [folioPadre=");
		builder.append(folioPadre);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", tipoParentesco=");
		builder.append(tipoParentesco);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", tramitePresencial=");
		builder.append(tramitePresencial);
		builder.append("]");
		return builder.toString();
	}
}