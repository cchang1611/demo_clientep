package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * BitacoraReimpresion
 * @author jmordone
 *
 */
public class TramitesConcluidos implements Serializable {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5729553113775694364L;

	/**
	 * idTramite
	 */
	private Long idTramite;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * tipoSolicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * subTipoSolicitante
	 */
	private String subTipoSolicitante;
	
	/**
	 * organizacion
	 */
	private String organizacion;
	
	/**
	 * folioProcesar
	 */
	private String folioProcesar;
	
	/**
	 * id Solicitud
	 */
	private Integer idServicio;
	
	/**
	 * id Solicitud
	 */
	private String chPeticion;
	
	/**
	 * id Solicitud
	 */
	private String usuarioModificador;

	/**
	 * Fc control
	 */
	private Date fcControl;

	/**
	 * @return the idTramite
	 */
	public Long getIdTramite() {
		return idTramite;
	}

	/**
	 * @param idTramite the idTramite to set
	 */
	public void setIdTramite(Long idTramite) {
		this.idTramite = idTramite;
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
	 * @return the organizacion
	 */
	public String getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
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
	 * @return the chPeticion
	 */
	public String getChPeticion() {
		return chPeticion;
	}

	/**
	 * @param chPeticion the chPeticion to set
	 */
	public void setChPeticion(String chPeticion) {
		this.chPeticion = chPeticion;
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
		builder.append("TramitesConcluidos [idTramite=");
		builder.append(idTramite);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", subTipoSolicitante=");
		builder.append(subTipoSolicitante);
		builder.append(", organizacion=");
		builder.append(organizacion);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", chPeticion=");
		builder.append(chPeticion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append("]");
		return builder.toString();
	}	
}
