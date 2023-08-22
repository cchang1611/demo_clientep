package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Entrada Filenet
 * @author jmordone
 *
 */
public class EntradaFilenet implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 3763288807453406136L;

	/**
	 * afore
	 */
	private String afore;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * proceso
	 */
	private String proceso;
	
	/**
	 * fechaOperacion
	 */
	private String fechaOperacion;
	
	/**
	 * folioConsecutivo
	 */
	private String folioConsecutivo;
	
	/**
	 * claveDocumento
	 */
	private String claveDocumento;

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
	 * @return the proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
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
	 * @return the folioConsecutivo
	 */
	public String getFolioConsecutivo() {
		return folioConsecutivo;
	}

	/**
	 * @param folioConsecutivo the folioConsecutivo to set
	 */
	public void setFolioConsecutivo(String folioConsecutivo) {
		this.folioConsecutivo = folioConsecutivo;
	}

	/**
	 * @return the claveDocumento
	 */
	public String getClaveDocumento() {
		return claveDocumento;
	}

	/**
	 * @param claveDocumento the claveDocumento to set
	 */
	public void setClaveDocumento(String claveDocumento) {
		this.claveDocumento = claveDocumento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaFilenet [afore=");
		builder.append(afore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", folioConsecutivo=");
		builder.append(folioConsecutivo);
		builder.append(", claveDocumento=");
		builder.append(claveDocumento);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
