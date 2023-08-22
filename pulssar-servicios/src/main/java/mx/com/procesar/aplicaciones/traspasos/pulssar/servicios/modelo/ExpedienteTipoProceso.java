package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author JMGUTIER
 *
 */

public class ExpedienteTipoProceso implements Serializable{
	/**
	 * serializble
	 */
	private static final long serialVersionUID = 2643481947084982703L;
	
	/**
	 * clave tipo proceso
	 */
	private String claveTipoProceso;
	/**
	 * descripcion proceso
	 */
	private String chDescripcionProceso;
	/**
	 * nuModoBatch
	 */
	private Integer nuModoBatch;
	/**
	 * fecha control
	 */
	private Date fechaControl;
	/**
	 * usuario modificador
	 */
	private String chUsuarioModificador;
	/**
	 * clave grupo tipo proceso
	 */
	private String cvGrupoTipoProceso;
	/**
	 * @return the claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}
	/**
	 * @param claveTipoProceso the claveTipoProceso to set
	 */
	public void setClaveTipoProceso(String claveTipoProceso) {
		this.claveTipoProceso = claveTipoProceso;
	}
	/**
	 * @return the chDescripcionProceso
	 */
	public String getChDescripcionProceso() {
		return chDescripcionProceso;
	}
	/**
	 * @param chDescripcionProceso the chDescripcionProceso to set
	 */
	public void setChDescripcionProceso(String chDescripcionProceso) {
		this.chDescripcionProceso = chDescripcionProceso;
	}
	/**
	 * @return the nuModoBatch
	 */
	public Integer getNuModoBatch() {
		return nuModoBatch;
	}
	/**
	 * @param nuModoBatch the nuModoBatch to set
	 */
	public void setNuModoBatch(Integer nuModoBatch) {
		this.nuModoBatch = nuModoBatch;
	}
	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}
	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}
	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}
	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}
	/**
	 * @return the cvGrupoTipoProceso
	 */
	public String getCvGrupoTipoProceso() {
		return cvGrupoTipoProceso;
	}
	/**
	 * @param cvGrupoTipoProceso the cvGrupoTipoProceso to set
	 */
	public void setCvGrupoTipoProceso(String cvGrupoTipoProceso) {
		this.cvGrupoTipoProceso = cvGrupoTipoProceso;
	}
	
	
	

}
