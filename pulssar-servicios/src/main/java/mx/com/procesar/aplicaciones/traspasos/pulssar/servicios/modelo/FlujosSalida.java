package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de Salida Flujo
 * 
 * @author Maria Elena Dominguez Dominguez (medoming@procesar.com)
 * @version 1.0
 * @since Mar 8, 2019
 */
public class FlujosSalida implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8158810475991891041L;

	/**
	 * idProcesar
	 */
	private Long idProcesar;
	
	/**
	 * estatusBiometrico
	 */
	private String estatusBiometrico;
	
	/**
	 * estatusIdentificacion
	 */
	private String estatusIdentificacion;
	
	/**
	 * bBiometrico
	 */
	private Integer bBiometrico;
	
	/**
	 * bIdentificacion
	 */
	private Integer bIdentificacion;

	/**
	 * curpNueva
	 */
	private String curpNueva;
	
	/**
	 * flujoValidacion
	 */
	private String flujoValidacion;

	/**
	 * movimiento
	 */
	private String movimiento;	
	
	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;

	/**
	 * @return curpNueva
	 */
	public String getCurpNueva() {
		return curpNueva;
	}

	/**
	 * @param curpNueva the curpNueva to set
	 */
	public void setCurpNueva(String curpNueva) {
		this.curpNueva = curpNueva;
	}

	/**
	 * @return flujoValidacion
	 */
	public String getFlujoValidacion() {
		return flujoValidacion;
	}

	/**
	 * @param flujoValidacion the flujoValidacion to set
	 */
	public void setFlujoValidacion(String flujoValidacion) {
		this.flujoValidacion = flujoValidacion;
	}

	/**
	 * @return curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return idProcesar
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
	 * @return bBiometrico
	 */
	public Integer getbBiometrico() {
		return bBiometrico;
	}

	/**
	 * @param bBiometrico the bBiometrico to set
	 */
	public void setbBiometrico(Integer bBiometrico) {
		this.bBiometrico = bBiometrico;
	}

	/**
	 * @return bIdentificacion
	 */
	public Integer getbIdentificacion() {
		return bIdentificacion;
	}

	/**
	 * @param bIdentificacion the bIdentificacion to set
	 */
	public void setbIdentificacion(Integer bIdentificacion) {
		this.bIdentificacion = bIdentificacion;
	}

	/**
	 * @return estatusBiometrico
	 */
	public String getEstatusBiometrico() {
		return estatusBiometrico;
	}

	/**
	 * @param estatusBiometrico the estatusBiometrico to set
	 */
	public void setEstatusBiometrico(String estatusBiometrico) {
		this.estatusBiometrico = estatusBiometrico;
	}

	/**
	 * @return estatusIdentificacion
	 */
	public String getEstatusIdentificacion() {
		return estatusIdentificacion;
	}

	/**
	 * @param estatusIdentificacion the estatusIdentificacion to set
	 */
	public void setEstatusIdentificacion(String estatusIdentificacion) {
		this.estatusIdentificacion = estatusIdentificacion;
	}
	
	/**
	 * @return movimiento
	 */
	public String getMovimiento() {
		return movimiento;
	}

	/**
	 * @param movimiento the movimiento to set
	 */
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlujosEntrada [idProcesar=");
		builder.append(idProcesar);
		builder.append(", curpNueva=");
		builder.append(curpNueva);
		builder.append(", flujoValidacion=");
		builder.append(flujoValidacion);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", bBiometrico=");
		builder.append(bBiometrico);
		builder.append(", bIdentificacion=");
		builder.append(bIdentificacion);
		builder.append(", estatusBiometrico=");
		builder.append(estatusBiometrico);
		builder.append(", estatusIdentificacion=");
		builder.append(estatusIdentificacion);
		builder.append(", movimiento=");
		builder.append(movimiento);
		builder.append("]");
		return builder.toString();
	}
}
