package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos de Entrada del servicio consulta agente
 * promotor
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class AforeAgente implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 7214519080112012084L;

	/**
	 * Clave de la Afore Traspaso
	 */
	private String claveAfore;

	/**
	 * No Agente Promotor
	 */
	private String claveAgente;

	/**
	 * Curp Agente Promotor
	 */
	private String curpAgente;

	/**
	 * Nombre del Agente Promotor
	 */
	private String nombreAgente;

	/**
	 * Apellido Paterno del Agente
	 */
	private String apellidoPaterno;

	/**
	 * Apellido Materno del Agente
	 */
	private String apellidoMaterno;

	/**
	 * Check de agente valido
	 */
	private boolean fotoAgente;

	/**
	 * tipo de agente promotor
	 */
	private String tipoAgente;

	/**
	 * lista de estatus agente promotor
	 */
	private String estatusAgente;
	
	/**
	 * Constructor
	 */
	public AforeAgente() {
		super();
		fotoAgente = false;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore
	 *            the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}

	/**
	 * @param claveAgente
	 *            the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	/**
	 * @return the curpAgente
	 */
	public String getCurpAgente() {
		return curpAgente;
	}

	/**
	 * @param curpAgente
	 *            the curpAgente to set
	 */
	public void setCurpAgente(String curpAgente) {
		this.curpAgente = curpAgente;
	}

	/**
	 * @return the nombreAgente
	 */
	public String getNombreAgente() {
		return nombreAgente;
	}

	/**
	 * @param nombreAgente
	 *            the nombreAgente to set
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the fotoAgente
	 */
	public boolean isFotoAgente() {
		return fotoAgente;
	}

	/**
	 * @param fotoAgente
	 *            the fotoAgente to set
	 */
	public void setFotoAgente(boolean fotoAgente) {
		this.fotoAgente = fotoAgente;
	}

	/**
	 * @return the tipoAgente
	 */
	public String getTipoAgente() {
		return tipoAgente;
	}

	/**
	 * @param tipoAgente
	 *            the tipoAgente to set
	 */
	public void setTipoAgente(String tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	/**
	 * @return the estatusAgente
	 */
	public String getEstatusAgente() {
		return estatusAgente;
	}

	/**
	 * @param estatusAgente
	 *            the estatusAgente to set
	 */
	public void setEstatusAgente(String estatusAgente) {
		this.estatusAgente = estatusAgente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AforeAgente [claveAfore=");
		builder.append(claveAfore);
		builder.append(", claveAgente=");
		builder.append(claveAgente);
		builder.append(", curpAgente=");
		builder.append(curpAgente);
		builder.append(", nombreAgente=");
		builder.append(nombreAgente);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", fotoAgente=");
		builder.append(fotoAgente);
		builder.append(", tipoAgente=");
		builder.append(tipoAgente);
		builder.append(", estatusAgente=");
		builder.append(estatusAgente);
		builder.append("]");
		return builder.toString();
	}
}
