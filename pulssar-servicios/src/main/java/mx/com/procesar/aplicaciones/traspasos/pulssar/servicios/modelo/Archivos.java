package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase para la captura de archivos
 * 
 * @author JMGUTIER
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Archivos {
	
	/**
	 * Clave afore
	 */
	private String claveAfore;
	
	/**
	 * Folio Servicio
	 */
	private String folioTramiteProcesar;
	
	/**
	 * Folio Servicio
	 */
	private String folioCliente;
	
	/**
	 * curp empleado
	 */
	private String curpEmpleado;
	
	/**
	 * curp trabajador
	 */
	private String curpTrabajador;
	
	/**
	 * tipo archivos
	 */
	private String tipoArchivos;
	
	/**
	 * contenido archivo
	 */
	private String contenidoArchivo;
	
	/**
	 * tipo expediente
	 */
	private String tipoExpediente;
	
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
	 * @return the folioTramiteProcesar
	 */
	public String getFolioTramiteProcesar() {
		return folioTramiteProcesar;
	}

	/**
	 * @param folioTramiteProcesar the folioTramiteProcesar to set
	 */
	public void setFolioTramiteProcesar(String folioTramiteProcesar) {
		this.folioTramiteProcesar = folioTramiteProcesar;
	}

	/**
	 * @return the folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente the folioCliente to set
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
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
	 * @return the tipoArchivos
	 */
	public String getTipoArchivos() {
		return tipoArchivos;
	}

	/**
	 * @param tipoArchivos the tipoArchivos to set
	 */
	public void setTipoArchivos(String tipoArchivos) {
		this.tipoArchivos = tipoArchivos;
	}

	/**
	 * @return the contenidoArchivo
	 */
	public String getContenidoArchivo() {
		return contenidoArchivo;
	}

	/**
	 * @param contenidoArchivo the contenidoArchivo to set
	 */
	public void setContenidoArchivo(String contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}

	/**
	 * @return the tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}

	/**
	 * @param tipoExpediente the tipoExpediente to set
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Archivos [claveAfore=");
		builder.append(claveAfore);
		builder.append(", folioTramiteProcesar=");
		builder.append(folioTramiteProcesar);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", curpEmpleado=");
		builder.append(curpEmpleado);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", tipoArchivos=");
		builder.append(tipoArchivos);
		builder.append(", contenidoArchivo=");
		builder.append(contenidoArchivo);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append("]");
		return builder.toString();
	}
}