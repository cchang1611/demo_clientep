package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the PSER_TR_NOTIF_CUS database table.
 * 
 */
public class NotificacionCus implements Serializable {
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 8043562473824693214L;
	/**
	 * idNotifCus
	 */
	private Long idNotifCus;

	/**
	 * folioProcesar
	 */
	private String folioProcesar;

	/**
	 * fechaRecepcionNotificacion
	 */
	private String fechaRecepcionNotificacion;

	/**
	 * cus
	 */
	private String cus;

	/**
	 * fechaGeneracion
	 */
	private String fechaGeneracion;

	/**
	 * fechaVigencia
	 */
	private String fechaVigencia;

	/**
	 * notificado
	 */
	private Long notificado;

	/**
	 * fechaNotificado
	 */
	private Date fechaNotificado;

	/**
	 * fechaControl
	 */
	private Date fechaControl;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;
	
	/**
	 * afore
	 */
	private String afore;

	/**
	 * @return the idNotifCus
	 */
	public Long getIdNotifCus() {
		return idNotifCus;
	}

	/**
	 * @param idNotifCus the idNotifCus to set
	 */
	public void setIdNotifCus(Long idNotifCus) {
		this.idNotifCus = idNotifCus;
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
	 * @return the fechaRecepcionNotificacion
	 */
	public String getFechaRecepcionNotificacion() {
		return fechaRecepcionNotificacion;
	}

	/**
	 * @param fechaRecepcionNotificacion the fechaRecepcionNotificacion to set
	 */
	public void setFechaRecepcionNotificacion(String fechaRecepcionNotificacion) {
		this.fechaRecepcionNotificacion = fechaRecepcionNotificacion;
	}

	/**
	 * @return the cus
	 */
	public String getCus() {
		return cus;
	}

	/**
	 * @param cus the cus to set
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}

	/**
	 * @return the fechaGeneracion
	 */
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	/**
	 * @return the fechaVigencia
	 */
	public String getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * @param fechaVigencia the fechaVigencia to set
	 */
	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * @return the notificado
	 */
	public Long getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(Long notificado) {
		this.notificado = notificado;
	}

	/**
	 * @return the fechaNotificado
	 */
	public Date getFechaNotificado() {
		return fechaNotificado;
	}

	/**
	 * @param fechaNotificado the fechaNotificado to set
	 */
	public void setFechaNotificado(Date fechaNotificado) {
		this.fechaNotificado = fechaNotificado;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionCus [idNotifCus=");
		builder.append(idNotifCus);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", fechaRecepcionNotificacion=");
		builder.append(fechaRecepcionNotificacion);
		builder.append(", cus=");
		builder.append(cus);
		builder.append(", fechaGeneracion=");
		builder.append(fechaGeneracion);
		builder.append(", fechaVigencia=");
		builder.append(fechaVigencia);
		builder.append(", notificado=");
		builder.append(notificado);
		builder.append(", fechaNotificado=");
		builder.append(fechaNotificado);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", afore=");
		builder.append(afore);
		builder.append("]");
		return builder.toString();
	}
	
}