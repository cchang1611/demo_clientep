package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase encargada del objeto de entrada para el websocket
 * @author DBARBOSA
 *
 */
public class EstructuraHuellasCoppel implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -4125973445163455935L;

	/**
	 * id Dedo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idDedo;
	
	/**
	 * huella 64
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String huella64;
	
	/**
	 * huella hash
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String huellaHash;
	
	/**
	 * Resolucion captura
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String resolucionCaptura;
	
	/**
	 * algoritmo de compresion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String algoritmoCompresion;
	
	/**
	 * unidades escala
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String unidadesEscala;
	
	/**
	 * calidad huella
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String calidadHuella;
	
	/**
	 * motivo sin huella
	 */
	private String motivoSinHuella;
	
	/**
	 * codigo falta de dedo
	 */
	private String codigoFaltaDedo;

	/**
	 * @return the idDedo
	 */
	public String getIdDedo() {
		return idDedo;
	}

	/**
	 * @param idDedo the idDedo to set
	 */
	public void setIdDedo(String idDedo) {
		this.idDedo = idDedo;
	}

	/**
	 * @return the huella64
	 */
	public String getHuella64() {
		return huella64;
	}

	/**
	 * @param huella64 the huella64 to set
	 */
	public void setHuella64(String huella64) {
		this.huella64 = huella64;
	}

	/**
	 * @return the huellaHash
	 */
	public String getHuellaHash() {
		return huellaHash;
	}

	/**
	 * @param huellaHash the huellaHash to set
	 */
	public void setHuellaHash(String huellaHash) {
		this.huellaHash = huellaHash;
	}

	/**
	 * @return the resolucionCaptura
	 */
	public String getResolucionCaptura() {
		return resolucionCaptura;
	}

	/**
	 * @param resolucionCaptura the resolucionCaptura to set
	 */
	public void setResolucionCaptura(String resolucionCaptura) {
		this.resolucionCaptura = resolucionCaptura;
	}

	/**
	 * @return the algoritmoCompresion
	 */
	public String getAlgoritmoCompresion() {
		return algoritmoCompresion;
	}

	/**
	 * @param algoritmoCompresion the algoritmoCompresion to set
	 */
	public void setAlgoritmoCompresion(String algoritmoCompresion) {
		this.algoritmoCompresion = algoritmoCompresion;
	}

	/**
	 * @return the unidadesEscala
	 */
	public String getUnidadesEscala() {
		return unidadesEscala;
	}

	/**
	 * @param unidadesEscala the unidadesEscala to set
	 */
	public void setUnidadesEscala(String unidadesEscala) {
		this.unidadesEscala = unidadesEscala;
	}

	/**
	 * @return the calidadHuella
	 */
	public String getCalidadHuella() {
		return calidadHuella;
	}

	/**
	 * @param calidadHuella the calidadHuella to set
	 */
	public void setCalidadHuella(String calidadHuella) {
		this.calidadHuella = calidadHuella;
	}

	/**
	 * @return the motivoSinHuella
	 */
	public String getMotivoSinHuella() {
		return motivoSinHuella;
	}

	/**
	 * @param motivoSinHuella the motivoSinHuella to set
	 */
	public void setMotivoSinHuella(String motivoSinHuella) {
		this.motivoSinHuella = motivoSinHuella;
	}

	/**
	 * @return the codigoFaltaDedo
	 */
	public String getCodigoFaltaDedo() {
		return codigoFaltaDedo;
	}

	/**
	 * @param codigoFaltaDedo the codigoFaltaDedo to set
	 */
	public void setCodigoFaltaDedo(String codigoFaltaDedo) {
		this.codigoFaltaDedo = codigoFaltaDedo;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("PeticionHuellasCoppel [");
		cadena.append(" idDedo =");
		cadena.append(idDedo);
//		cadena.append(" huella64 =");
//		cadena.append(huella64);
		cadena.append(" huellaHash =");
		cadena.append(huellaHash);
		cadena.append(" resolucionCaptura =");
		cadena.append(resolucionCaptura);
		cadena.append(" algoritmoCompresion =");
		cadena.append(algoritmoCompresion);
		cadena.append(" unidadesEscala");
		cadena.append(unidadesEscala);
		cadena.append(" motivoSinHuella =");
		cadena.append(motivoSinHuella);
		cadena.append(" codigoFaltaDedo");
		cadena.append(codigoFaltaDedo);
		cadena.append("]");
		
		return cadena.toString();
	}
}