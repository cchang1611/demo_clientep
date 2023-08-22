package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
* Clase de persistencia para la tabla PSER_TH_CERO_PAPEL
* 
* @author rarreola
* @version 1.0
*/
public class CeroPapel implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 860276322773778216L;
	
	/**
	 *id cero papel
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
	 * Usuario Modificador
	 */
	private String usuarioModificador;
	
	
	
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
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}



	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitacoraCeroPapel [ idCeroPapel=");
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
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}