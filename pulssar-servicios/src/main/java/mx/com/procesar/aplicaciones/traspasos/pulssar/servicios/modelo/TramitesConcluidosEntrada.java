package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * TramitesConcluidosEntrada
 * @author jmordone
 *
 */
public class TramitesConcluidosEntrada implements Serializable {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5810341754446414872L;

	/**
	 * Afore
	 */
	private String afore;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * cvServicio
	 */
	private String cvServicio;
	
	/**
	 * subTipoSolicitante
	 */
	private String subTipoSolicitante;
	
	/**
	 * tipoSolicitante
	 */
	private  String tipoSolicitante;
	
	/**
	 * folioProcesar
	 */
	private String folioProcesar;

	/**
	 * idServicio
	 */
	private Integer idServicio;
	
	/**
	 * chPeticion
	 */
	private String peticion;

	/**
	 * diagnostico
	 */
	private String diagnostico;
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;
	
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;
	
	/**
	 * fcControl
	 */
	private Date fcControl;

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
	 * @return the cvServicio
	 */
	public String getCvServicio() {
		return cvServicio;
	}

	/**
	 * @param cvServicio the cvServicio to set
	 */
	public void setCvServicio(String cvServicio) {
		this.cvServicio = cvServicio;
	}

	/**
	 * @return the subTipoSolicitante
	 */
	public String getSubTipoSolicitante() {
		return subTipoSolicitante;
	}

	/**
	 * @param subTipoSolicitante the subTipoSolicitante to set
	 */
	public void setSubTipoSolicitante(String subTipoSolicitante) {
		this.subTipoSolicitante = subTipoSolicitante;
	}

	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar the folioProcesar to set
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * @return the idServicio
	 */
	public Integer getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the peticion
	 */
	public String getPeticion() {
		return peticion;
	}

	/**
	 * @param peticion the peticion to set
	 */
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
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

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TramitesConcluidosEntrada [afore=");
		builder.append(afore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", cvServicio=");
		builder.append(cvServicio);
		builder.append(", subTipoSolicitante=");
		builder.append(subTipoSolicitante);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append("]");
		return builder.toString();
	}


	
	
}
