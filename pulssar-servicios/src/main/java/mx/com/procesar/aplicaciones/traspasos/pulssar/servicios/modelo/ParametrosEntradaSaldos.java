package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * parametros de entrada dpara el servicio de saldos
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class ParametrosEntradaSaldos implements Serializable {
	
	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = 159515971834787930L;
	
	/**
	 * afore
	 */
	private String afore;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * @return the afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore the afore to set
	 */
	public void setAfore(String afore) {
		this.afore = afore;
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

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("ParametrosEntradaSaldos [afore=");
		cadena.append(afore);
		cadena.append(", curp=");
		cadena.append(curp);
		cadena.append(", nss=");
		cadena.append(nss);
		cadena.append("]");
		return cadena.toString();
	}
}
