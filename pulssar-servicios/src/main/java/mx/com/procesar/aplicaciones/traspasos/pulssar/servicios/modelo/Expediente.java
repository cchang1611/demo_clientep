package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase para el manejo de las banderas de expediente biometrico
 * y datos de expediente de identificacion
 * 
 * @author dbarbosa
 *
 */
public class Expediente implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1379388800924042759L;
	
	/**
	 * Bandera de huellas capturadas
	 */
	private boolean huellas;

	/**
	 * Bandera de acuse firmado
	 */
	private boolean acuse;
	
	/**
	 * biometricos
	 */
	private String biometricos;
	
	/**
	 * Clave de excepcion
	 */
	private String claveExcep;
	
	/**
	 * firma agente
	 */
	private String firmaAgen;
	
	/**
	 * firma trabajador
	 */
	private String firmaTrab;
	
	/**
	 * Constructor
	 */
	public Expediente() {
		huellas = false;
		acuse = false;
	}

	/**
	 * @return the huellas
	 */
	public boolean isHuellas() {
		return huellas;
	}

	/**
	 * @param huellas the huellas to set
	 */
	public void setHuellas(boolean huellas) {
		this.huellas = huellas;
	}

	/**
	 * @return the acuse
	 */
	public boolean isAcuse() {
		return acuse;
	}

	/**
	 * @param acuse the acuse to set
	 */
	public void setAcuse(boolean acuse) {
		this.acuse = acuse;
	}
	
	/**
	 * @return the biometricos
	 */
	public String getBiometricos() {
		return biometricos;
	}

	/**
	 * @param biometricos the biometricos to set
	 */
	public void setBiometricos(String biometricos) {
		this.biometricos = biometricos;
	}

	/**
	 * @return the claveExcep
	 */
	public String getClaveExcep() {
		return claveExcep;
	}

	/**
	 * @param claveExcep the claveExcep to set
	 */
	public void setClaveExcep(String claveExcep) {
		this.claveExcep = claveExcep;
	}

	/**
	 * @return the firmaAgen
	 */
	public String getFirmaAgen() {
		return firmaAgen;
	}

	/**
	 * @param firmaAgen the firmaAgen to set
	 */
	public void setFirmaAgen(String firmaAgen) {
		this.firmaAgen = firmaAgen;
	}

	/**
	 * @return the firmaTrab
	 */
	public String getFirmaTrab() {
		return firmaTrab;
	}

	/**
	 * @param firmaTrab the firmaTrab to set
	 */
	public void setFirmaTrab(String firmaTrab) {
		this.firmaTrab = firmaTrab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Expediente [huellas=");
		builder.append(huellas);
		builder.append(", acuse=");
		builder.append(acuse);
		builder.append(", biometricos=");
		builder.append(biometricos);
		builder.append(", claveExcep=");
		builder.append(claveExcep);
		builder.append(", firmaAgen=");
		builder.append(firmaAgen);
		builder.append(", firmaTrab=");
		builder.append(firmaTrab);
		builder.append("]");
		return builder.toString();
	}
}