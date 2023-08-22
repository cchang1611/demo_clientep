package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * Disposicion issste cancelacion
 * @author RARREOLA
 *
 */
public class DisposicionIsssteCancelacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * fecha movimiento
	 */
	private String fechaOperacion;
	
	/**
	 * folio issste
	 */
	private String folioIssste;
	
	/**
	 * secuencia pension
	 */
	private String secuenciaPension;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * cvProceso
	 */
	private String cvProceso;
	
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
	 * @return the cvProceso
	 */
	public String getCvProceso() {
		return cvProceso;
	}






	/**
	 * @param cvProceso the cvProceso to set
	 */
	public void setCvProceso(String cvProceso) {
		this.cvProceso = cvProceso;
	}
	
	/**
	 * @return the fechaOperacion
	 */
	public String getFechaOperacion() {
		return fechaOperacion;
	}






	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}






	/**
	 * @return the folioIssste
	 */
	public String getFolioIssste() {
		return folioIssste;
	}




	/**
	 * @param folioIssste the folioIssste to set
	 */
	public void setFolioIssste(String folioIssste) {
		this.folioIssste = folioIssste;
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




	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
