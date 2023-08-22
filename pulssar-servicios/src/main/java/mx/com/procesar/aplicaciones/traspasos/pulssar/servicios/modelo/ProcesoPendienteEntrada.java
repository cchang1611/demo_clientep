package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;


/**
 * 
 * @author RARREOLA
 * @param <T>
 *
 */

public class ProcesoPendienteEntrada<T> implements Serializable{
	
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1856769492269305349L;
	
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
	 * Curp nueva
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
	 * Peticion
	 */
	private T peticion;

	/**
	 * idProcesar
	 */
	
	private Long idProcesar;
	
	/**
	 * id folio hijo pulssar origen
	 */
	private Long idFolioPulssarOrigen;
	/**
	 * Estatus
	 */
	private String estatus;
	
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
	 * @param fechaControl the fechaControl to set
	 */
	public T getPeticion() {
		return peticion;
	}


	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setPeticion(T peticion) {
		this.peticion = peticion;
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
	 * @return the idFolioPulssarOrigen
	 */
	public Long getIdFolioPulssarOrigen() {
		return idFolioPulssarOrigen;
	}



	/**
	 * @param idFolioPulssarOrigen the idFolioPulssarOrigen to set
	 */
	public void setIdFolioPulssarOrigen(Long idFolioPulssarOrigen) {
		this.idFolioPulssarOrigen = idFolioPulssarOrigen;
	}



	/**
	 * @return el atributo estatus
	 */
	public String getEstatus() {
		return estatus;
	}



	/**
	 * @param estatus parametro estatus a actualizar
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcesoPendienteEntrada [solicitante=");
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
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", idFolioPulssarOrigen=");
		builder.append(idFolioPulssarOrigen);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append("]");
		return builder.toString();
	}


}
