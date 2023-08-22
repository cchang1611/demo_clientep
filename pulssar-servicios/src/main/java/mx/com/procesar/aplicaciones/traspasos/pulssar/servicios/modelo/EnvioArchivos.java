package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de envio de archivos
 * 
 * @author dbarbosa
 * @version 1.0
 */
public class EnvioArchivos implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1475688210560361141L;
	
	/**
	 * Clave Afore
	 */
	private String claveAfore;
	
	/**
	 * Curp del trabajador
	 */
	private String curpTrabajador;
	
	/**
	 * Curp del empleado
	 */
	private String curpEmpleado;
	
	/**
	 * Folio
	 */
	private String folioIdentificacion;
	
	/**
	 * Folio
	 */
	private String folio;
	
	/**
	 * tipo Archivo
	 */
	private String tipoArchivo;
	
	/**
	 * tipo trabajador
	 */
	private String tipoTrabajador;
	
	/**
	 * proceso
	 */
	private String proceso;
	
	/**
	 * tipoExpediente
	 */
	private String tipoExpediente;
	
	/**
	 * folioProcesar
	 */
	private String folioProcesar;
	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
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
	 * @return the folioIdentificacion
	 */
	public String getFolioIdentificacion() {
		return folioIdentificacion;
	}

	/**
	 * @param folioIdentificacion the folioIdentificacion to set
	 */
	public void setFolioIdentificacion(String folioIdentificacion) {
		this.folioIdentificacion = folioIdentificacion;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the tipoArchivo
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return the tipoTrabajador
	 */
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	/**
	 * @param tipoTrabajador the tipoTrabajador to set
	 */
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
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
	 * @return el atributo tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}

	/**
	 * @param tipoExpediente parametro tipoExpediente a actualizar
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnvioArchivos [claveAfore=");
		builder.append(claveAfore);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", curpEmpleado=");
		builder.append(curpEmpleado);
		builder.append(", folioIdentificacion=");
		builder.append(folioIdentificacion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", tipoArchivo=");
		builder.append(tipoArchivo);
		builder.append(", tipoTrabajador=");
		builder.append(tipoTrabajador);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append("]");
		return builder.toString();
	}
}