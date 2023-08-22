package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Cancelacion entrada
 * @author RARREOLA
 *
 */
public class CancelacionEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * folioSolicitud
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioSolicitud;
	/**
	 * cveAfore
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String cveAfore;
	/**
	 *nss 
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	/**
	 * curp
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	
	/**
	 * secuenciaPension
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String secuenciaPension;
	
	
	
	/**
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}



	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}



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
	 * @return the secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}



	/**
	 * @param secuenciaPension the secuenciaPension to set
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
