package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto que contiene el objeto para el envio de mensaje
 * 
 * @author DBARBOSA
 */
public class EntradaConsulta implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 862940770179570938L;
	
	/**
	 * Curp del trabajador
	 */
	private String curp;
	
	/**
	 * Curp del trabajador
	 */
	private String nss;
	
	/**
	 * Identifcador de folio
	 */
	private FolioEntrada folioPrevio;
	
	/**
	 * Calve Afore Agente
	 */
	private String claveAfore;
	
	/**
	 * Tiempo
	 */
	private String timerPicker;
	
	/**
	 * clave tipo solicitante
	 */
	private String cvTipoSolicitante;
	
	/**
	 * clave tipo solicitante
	 */
	private String imagen;
	
	/**
	 * idTipoAfiliacion
	 */
	private String idProcesar;
	
	/**
	 * Curp solicitante
	 */
	private String curpSolicitante;
	
	/**
	 * Nombre del tercero
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno tercero
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno tercero
	 */
	private String apellidoMaterno;
	
	/**
	 * ¿Autenticación por INE?
	 */
	private boolean autenticacionIne;
	
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
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the folioPrevio
	 */
	public FolioEntrada getFolioPrevio() {
		return folioPrevio;
	}

	/**
	 * @param folioPrevio the folioPrevio to set
	 */
	public void setFolioPrevio(FolioEntrada folioPrevio) {
		this.folioPrevio = folioPrevio;
	}

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
	 * @return the timerPicker
	 */
	public String getTimerPicker() {
		return timerPicker;
	}

	/**
	 * @param timerPicker the timerPicker to set
	 */
	public void setTimerPicker(String timerPicker) {
		this.timerPicker = timerPicker;
	}

	/**
	 * @return the cvTipoSolicitante
	 */
	public String getCvTipoSolicitante() {
		return cvTipoSolicitante;
	}

	/**
	 * @param cvTipoSolicitante the cvTipoSolicitante to set
	 */
	public void setCvTipoSolicitante(String cvTipoSolicitante) {
		this.cvTipoSolicitante = cvTipoSolicitante;
	}
	
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

	/**
	 *  getIdProcesar
	 *  @return
	 */
	public String getIdProcesar() {
		return idProcesar;
	}

	/**
	 *  setIdProcesar
	 *  @param idProcesar
	 */
	public void setIdProcesar(String idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the curpSolicitante
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtener autenticacionIne
	 */
	public boolean getAutenticacionIne() {
		return autenticacionIne;
	}

	/**
	 * Setear autenticacionIne
	 */
	public void setAutenticacionIne(boolean autenticacionIne) {
		this.autenticacionIne = autenticacionIne;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaConsulta [curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", folioPrevio=");
		builder.append(folioPrevio);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", timerPicker=");
		builder.append(timerPicker);
		builder.append(", cvTipoSolicitante=");
		builder.append(cvTipoSolicitante);
		builder.append(", imagen=");
		builder.append(imagen);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", autenticacionIne=");
		builder.append(autenticacionIne);
		builder.append("]");
		return builder.toString();
	}
	
}