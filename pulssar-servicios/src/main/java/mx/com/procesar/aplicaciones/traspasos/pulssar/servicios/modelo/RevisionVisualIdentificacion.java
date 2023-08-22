/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * informacion dela rev
 * @author jcgarces
 *
 */
public class RevisionVisualIdentificacion implements Serializable{
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -4863721361124239604L;

	/**
	 * id- PSER_SEQ_REV_MAN_GEN_EXP
	 */
	private Long id;
	
	/**
	 * clave afore
	 */
	private String claveAfore;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * curp de empelado que autoriza
	 */
	private String curpEmpleadoAutorizador;
	
	/**
	 * curp trabajador
	 */
	private String curpTrabajador;
	
	/**
	 * estatus de la validacion 01, aceptada, 02 rechazada
	 */
	private String resultadoRevision;
	
	/**
	 * folio del cliente
	 */
	private String folioCliente;
	
	/**
	 * archivo recibido
	 */
	private ArchivoRecibido archivoRecibido;
	
	/**
	 * fecha de notificacion
	 */
	private List<String> fechaNotificacion;
	
	/**
	 * motivo de rechazo
	 */
	private String motivoRechazo;
	
	/**
	 * fecha Control
	 */
	private List<String> fechaControl;
	/**
	 * usuario Modificador
	 */
	private String usuarioModificador;
	
	/**
	 * tipo expediente
	 */
	private String tipoExpediente;
	
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
	 * @return the curpEmpleadoAutorizador
	 */
	public String getCurpEmpleadoAutorizador() {
		return curpEmpleadoAutorizador;
	}
	/**
	 * @param curpEmpleadoAutorizador the curpEmpleadoAutorizador to set
	 */
	public void setCurpEmpleadoAutorizador(String curpEmpleadoAutorizador) {
		this.curpEmpleadoAutorizador = curpEmpleadoAutorizador;
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
	 * @return the resultadoRevision
	 */
	public String getResultadoRevision() {
		return resultadoRevision;
	}
	/**
	 * @param resultadoRevision the resultadoRevision to set
	 */
	public void setResultadoRevision(String resultadoRevision) {
		this.resultadoRevision = resultadoRevision;
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
	 * @return the fechaNotificacion
	 */
	public List<String> getFechaNotificacion() {
		return fechaNotificacion;
	}
	/**
	 * @param fechaNotificacion the fechaNotificacion to set
	 */
	public void setFechaNotificacion(List<String> fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}
	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}
	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	/**
	 * @return the fechaControl
	 */
	public List<String> getFechaControl() {
		return fechaControl;
	}
	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(List<String> fechaControl) {
		this.fechaControl = fechaControl;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RevisionVisualIdentificacion [id=");
		builder.append(id);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curpEmpleadoAutorizador=");
		builder.append(curpEmpleadoAutorizador);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", resultadoRevision=");
		builder.append(resultadoRevision);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", fechaNotificacion=");
		builder.append(fechaNotificacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @return the archivoRecibido
	 */
	public ArchivoRecibido getArchivoRecibido() {
		return archivoRecibido;
	}
	/**
	 * @param archivoRecibido the archivoRecibido to set
	 */
	public void setArchivoRecibido(ArchivoRecibido achivoRecibido) {
		this.archivoRecibido = achivoRecibido;
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
	
}
