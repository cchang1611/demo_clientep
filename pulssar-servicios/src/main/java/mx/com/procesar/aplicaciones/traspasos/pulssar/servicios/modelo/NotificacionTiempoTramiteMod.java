package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Persistencia de la tabla PSER_TB_NOTIF_TIEMPO_TRAMITE.
 * 
 */
public class NotificacionTiempoTramiteMod implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -8968598627551727792L;

	/**
	 * id notificacion tiempo tramite
	 */
	private Long idNotifTiempoTramite;

	/**
	 * Folio procesar
	 */
	private String folioProcesar;

	/**
	 * tiempo atencion
	 */
	private String tiempoAtencion;

	/**
	 * Tiempo espera
	 */
	private String tiempoEspera;

	/**
	 * Tiempo total tramite
	 */
	private String tiempoTotalTramite;
	
	/**
	 * Fecha fin atencion
	 */
	private Date fcFinAtencion;

	/**
	 * Usuario modificador
	 */
	private String chUsuarioModificador;

	/**
	 * Fecha control
	 */
	private Date fcControl;
	
	/**
	 * clave afore
	 */
	private String claveAfore;

	/**
	 * @return the idNotifTiempoTramite
	 */
	public Long getIdNotifTiempoTramite() {
		return idNotifTiempoTramite;
	}

	/**
	 * @param idNotifTiempoTramite the idNotifTiempoTramite to set
	 */
	public void setIdNotifTiempoTramite(Long idNotifTiempoTramite) {
		this.idNotifTiempoTramite = idNotifTiempoTramite;
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
	 * @return the tiempoAtencion
	 */
	public String getTiempoAtencion() {
		return tiempoAtencion;
	}

	/**
	 * @param tiempoAtencion the tiempoAtencion to set
	 */
	public void setTiempoAtencion(String tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	/**
	 * @return the tiempoEspera
	 */
	public String getTiempoEspera() {
		return tiempoEspera;
	}

	/**
	 * @param tiempoEspera the tiempoEspera to set
	 */
	public void setTiempoEspera(String tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	/**
	 * @return the tiempoTotalTramite
	 */
	public String getTiempoTotalTramite() {
		return tiempoTotalTramite;
	}

	/**
	 * @param tiempoTotalTramite the tiempoTotalTramite to set
	 */
	public void setTiempoTotalTramite(String tiempoTotalTramite) {
		this.tiempoTotalTramite = tiempoTotalTramite;
	}

	/**
	 * @return the fcFinAtencion
	 */
	public Date getFcFinAtencion() {
		return fcFinAtencion;
	}

	/**
	 * @param fcFinAtencion the fcFinAtencion to set
	 */
	public void setFcFinAtencion(Date fcFinAtencion) {
		this.fcFinAtencion = fcFinAtencion;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificacionTiempoTramiteMod [idNotifTiempoTramite=");
		builder.append(idNotifTiempoTramite);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", tiempoAtencion=");
		builder.append(tiempoAtencion);
		builder.append(", tiempoEspera=");
		builder.append(tiempoEspera);
		builder.append(", tiempoTotalTramite=");
		builder.append(tiempoTotalTramite);
		builder.append(", fcFinAtencion=");
		builder.append(fcFinAtencion);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append("]");
		return builder.toString();
	}



	
	
}