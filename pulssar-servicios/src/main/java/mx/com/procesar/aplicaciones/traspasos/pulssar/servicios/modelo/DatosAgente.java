package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Objeto de Entrada, Datos del Agente para el servicio de  consulta
 * @author dbarbosa
 * @version 1.0
 */
public class DatosAgente implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 2685416372549165308L;

	/**
	 * Clave de la Afore
	 */
	private String claveAfore;
	
	/**
	 * Clave Agente
	 */
	private String claveAgente;
	
	/**
	 * Descripcion de agente
	 */
	private String descripcionAfore;
	
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
	private String apePaternoAgente;
	
	/**
	 * Apellido Materno del Agente
	 */
	private String apeMaternoAgente;
	
	/**
	 * Imagen del agente
	 */
	private String fotoAgente;
	
	/**
	 * Lista de tipo Agente
	 */
	private List<String> tipoAgente;
	
	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
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
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	/**
	 * @return the descripcionAfore
	 */
	public String getDescripcionAfore() {
		return descripcionAfore;
	}

	/**
	 * @param descripcionAfore the descripcionAfore to set
	 */
	public void setDescripcionAfore(String descripcionAfore) {
		this.descripcionAfore = descripcionAfore;
	}

	/**
	 * @return the curpAgente
	 */
	public String getCurpAgente() {
		return curpAgente;
	}

	/**
	 * @param curpAgente the curpAgente to set
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
	 * @param nombreAgente the nombreAgente to set
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return the apePaternoAgente
	 */
	public String getApePaternoAgente() {
		return apePaternoAgente;
	}

	/**
	 * @param apePaternoAgente the apePaternoAgente to set
	 */
	public void setApePaternoAgente(String apePaternoAgente) {
		this.apePaternoAgente = apePaternoAgente;
	}

	/**
	 * @return the apeMaternoAgente
	 */
	public String getApeMaternoAgente() {
		return apeMaternoAgente;
	}

	/**
	 * @param apeMaternoAgente the apeMaternoAgente to set
	 */
	public void setApeMaternoAgente(String apeMaternoAgente) {
		this.apeMaternoAgente = apeMaternoAgente;
	}
	
	/**
	 * @return the fotoAgente
	 */
	public String getFotoAgente() {
		return fotoAgente;
	}

	/**
	 * @param fotoAgente the fotoAgente to set
	 */
	public void setFotoAgente(String fotoAgente) {
		this.fotoAgente = fotoAgente;
	}
	
	/**
	 * @return the tipoAgente
	 */
	public List<String> getTipoAgente() {
		return tipoAgente;
	}

	/**
	 * @param tipoAgente the tipoAgente to set
	 */
	public void setTipoAgente(List<String> tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosAgente [claveAfore=");
		builder.append(claveAfore);
		builder.append(", claveAgente=");
		builder.append(claveAgente);
		builder.append(", descripcionAfore=");
		builder.append(descripcionAfore);
		builder.append(", curpAgente=");
		builder.append(curpAgente);
		builder.append(", nombreAgente=");
		builder.append(nombreAgente);
		builder.append(", apePaternoAgente=");
		builder.append(apePaternoAgente);
		builder.append(", apeMaternoAgente=");
		builder.append(apeMaternoAgente);
		builder.append(", fotoAgente=");
		builder.append(fotoAgente);
		builder.append(", tipoAgente=");
		builder.append(tipoAgente);
		builder.append("]");
		return builder.toString();
	}	
}
