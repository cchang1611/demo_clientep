package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author RARREOLA
 *
 */
public class ProcesoPendiente implements Serializable{
	
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1856769492269305349L;
	
	/**
	 * clave proceso pendiente
	 */
	private Long id;
	
	
	/**
	 * solicitante
	 */
	private String solicitante;
	
	/**
	 * Proceso
	 */
	private String proceso;
	
	/**
	 * flujo
	 */
	private String flujo;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * Curp anterior
	 */
	private String curpNueva;
	
	/**
	 * Afore
	 */
	private String afore;
	
	/**
	 * curp empleado
	 */
	private String curpEmpleado;
	
	/**
	 * id folio pulssar
	 */
	private Long idFolioPulssar;
	
	/**
	 * Estatus proceso
	 */
	private String estatusProceso;
	
	/**
	 * Peticion
	 */
	private String peticion;
	
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	
	
	
	/**
	 * fecha de control
	 */
	private Date fechaControl;

	/**
	 * idProcesar
	 */
	private Long idProcesar;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the solicitante
	 */
	public String getSolicitante() {
		return solicitante;
	}



	/**
	 * @param solicitante the solicitante to set
	 */
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}



	/**
	 * @return the flujo
	 */
	public String getFlujo() {
		return flujo;
	}



	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(String flujo) {
		this.flujo = flujo;
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
	 * @return the curpNueva
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
	 * @return the curpEmpleado
	 */
	public String getCurpEmpleado() {
		return curpEmpleado;
	}



	/**
	 * @param curpEmpleado the curpEmpleado to set
	 */
	public void setCurpEmpleado(String curpEmpleado) {
		this.curpEmpleado = curpEmpleado;
	}



	/**
	 * @return the idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}



	/**
	 * @param idFolioPulssar the idFolioPulssar to set
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}



	/**
	 * @return the estatusProceso
	 */
	public String getEstatusProceso() {
		return estatusProceso;
	}



	/**
	 * @param estatusProceso the estatusProceso to set
	 */
	public void setEstatusProceso(String estatusProceso) {
		this.estatusProceso = estatusProceso;
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



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoPendiente [id=");
		builder.append(id);
		builder.append(", solicitante=");
		builder.append(solicitante);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", flujo=");
		builder.append(flujo);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", curpNueva=");
		builder.append(curpNueva);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", curpEmpleado=");
		builder.append(curpEmpleado);
		builder.append(", idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", estatusProceso=");
		builder.append(estatusProceso);
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append("]");
		return builder.toString();
	}

}
