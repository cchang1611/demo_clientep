package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Objeto digitalizacion coppel
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 20/08/2020
 */
public class DigitalizacionCoppel implements Serializable{

	/**
	 * serial id
	 */
	private static final long serialVersionUID = -1669676394658699241L;
	/**
	 * folioProcesar
	 */
	private String folioProcesar;
	/**
	 * proceso
	 */
	private String proceso;
	/**
	 * curpTitular
	 */
	private String curpTitular;
	/**
	 * nssTitular
	 */
	private String nssTitular;
	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;
	/**
	 * tipoSoliciante
	 */
	private String tipoSoliciante;
	/**
	 * idRFCModificado
	 */
	private String idRFCModificado;	
	/**
	 * idSesion
	 */
	private String idSesion;	
	/**
	 * pagoBanco
	 */
	private String pagoBanco;
	
	/**
	 * tipoFlujo
	 */
	private String tipoFlujo;
	/**
	 * @return el atributo folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}
	/**
	 * @param folioProcesar parametro folioProcesar a actualizar
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}
	/**
	 * @return el atributo proceso
	 */
	public String getProceso() {
		return proceso;
	}
	/**
	 * @param proceso parametro proceso a actualizar
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	/**
	 * @return el atributo curpTitular
	 */
	public String getCurpTitular() {
		return curpTitular;
	}
	/**
	 * @param curpTitular parametro curpTitular a actualizar
	 */
	public void setCurpTitular(String curpTitular) {
		this.curpTitular = curpTitular;
	}
	/**
	 * @return el atributo nssTitular
	 */
	public String getNssTitular() {
		return nssTitular;
	}
	/**
	 * @param nssTitular parametro nssTitular a actualizar
	 */
	public void setNssTitular(String nssTitular) {
		this.nssTitular = nssTitular;
	}
	/**
	 * @return el atributo curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}
	/**
	 * @param curpSolicitante parametro curpSolicitante a actualizar
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}
	/**
	 * @return el atributo tipoSoliciante
	 */
	public String getTipoSoliciante() {
		return tipoSoliciante;
	}
	/**
	 * @param tipoSoliciante parametro tipoSoliciante a actualizar
	 */
	public void setTipoSoliciante(String tipoSoliciante) {
		this.tipoSoliciante = tipoSoliciante;
	}
	/**
	 * @return el atributo idRFCModificado
	 */
	public String getIdRFCModificado() {
		return idRFCModificado;
	}
	/**
	 * @param idRFCModificado parametro idRFCModificado a actualizar
	 */
	public void setIdRFCModificado(String idRFCModificado) {
		this.idRFCModificado = idRFCModificado;
	}
	/**
	 * @return the idSesion
	 */
	public String getIdSesion() {
		return idSesion;
	}
	/**
	 * @param idSesion the idSesion to set
	 */
	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}
	/**
	 * @return the pagoBanco
	 */
	public String getPagoBanco() {
		return pagoBanco;
	}
	/**
	 * @param pagoBanco the pagoBanco to set
	 */
	public void setPagoBanco(String pagoBanco) {
		this.pagoBanco = pagoBanco;
	}
	/**
	 * @return the tipoFlujo
	 */
	public String getTipoFlujo() {
		return tipoFlujo;
	}
	/**
	 * @param tipoFlujo the tipoFlujo to set
	 */
	public void setTipoFlujo(String tipoFlujo) {
		this.tipoFlujo = tipoFlujo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DigitalizacionCoppel [folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", curpTitular=");
		builder.append(curpTitular);
		builder.append(", nssTitular=");
		builder.append(nssTitular);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", tipoSoliciante=");
		builder.append(tipoSoliciante);
		builder.append(", idRFCModificado=");
		builder.append(idRFCModificado);
		builder.append(", idSesion=");
		builder.append(idSesion);
		builder.append(", pagoBanco=");
		builder.append(pagoBanco);
		builder.append(", tipoFlujo=");
		builder.append(tipoFlujo);
		builder.append("]");
		return builder.toString();
	}
	

}
