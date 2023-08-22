package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos de Entrada para el guardado cero papel
 * 
 * @author rarreola
 * @version 1.0
 */
public class EntradaCeroPapel implements Serializable {

	/**
	 * Serializacion 
	 */
	private static final long serialVersionUID = -904462959561444906L;

	/**
	 * id cero papel
	 */
    private Long idCeroPapel;
	
	/**
	 * Folio cero papel
	 */
	private String folioCeroPapel;
	
	/**
	 * Id procesar
	 */
	private Long idProcesar;
	
	/**
	 *Afore
	 */
	private String afore;
	
	/**
	 *Correo electronico
	 */
	private String correoElectronico;
	
	/**
	 *Numero estatus cero papel
	 */
	private Integer nuEstatusCeroPapel;
	
	/**
	 * Identificador de usuario.
	 */
	private Long identificadorUsuario;
	
	/**
	 *Nss
	 */
	private String nss;
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 *Nu notificado
	 */
	private Integer nuNotificado;
	
	
	/**
	 * Clave agente
	 */
	private String claveAgente;


	/**
	 * @return the idCeroPapel
	 */
	public Long getIdCeroPapel() {
		return idCeroPapel;
	}

	/**
	 * @param idCeroPapel the idCeroPapel to set
	 */
	public void setIdCeroPapel(Long idCeroPapel) {
		this.idCeroPapel = idCeroPapel;
	}

	/**
	 * @return the folioCeroPapel
	 */
	public String getFolioCeroPapel() {
		return folioCeroPapel;
	}

	/**
	 * @param folioCeroPapel the folioCeroPapel to set
	 */
	public void setFolioCeroPapel(String folioCeroPapel) {
		this.folioCeroPapel = folioCeroPapel;
	}

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

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
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the nuEstatusCeroPapel
	 */
	public Integer getNuEstatusCeroPapel() {
		return nuEstatusCeroPapel;
	}

	/**
	 * @param nuEstatusCeroPapel the nuEstatusCeroPapel to set
	 */
	public void setNuEstatusCeroPapel(Integer nuEstatusCeroPapel) {
		this.nuEstatusCeroPapel = nuEstatusCeroPapel;
	}

	/**
	 * @return the identificadorUsuario
	 */
	public Long getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	/**
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Long identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
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
	 * @return the nuNotificado
	 */
	public Integer getNuNotificado() {
		return nuNotificado;
	}

	/**
	 * @param nuNotificado the nuNotificado to set
	 */
	public void setNuNotificado(Integer nuNotificado) {
		this.nuNotificado = nuNotificado;
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaCeroPapel [idCeroPapel=");
		builder.append(idCeroPapel);
		builder.append(", folioCeroPapel=");
		builder.append(folioCeroPapel);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append(", nuEstatusCeroPapel=");
		builder.append(nuEstatusCeroPapel);
		builder.append(", identificadorUsuario=");
		builder.append(identificadorUsuario);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nuNotificado=");
		builder.append(nuNotificado);
		builder.append(", claveAgente=");
		builder.append(claveAgente);
		builder.append("]");
		return builder.toString();
	}
}

