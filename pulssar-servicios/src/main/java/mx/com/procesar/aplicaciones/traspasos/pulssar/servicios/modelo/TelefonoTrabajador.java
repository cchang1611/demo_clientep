package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Mapeo de la tabla NSAR_TR_TELEFONO
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class TelefonoTrabajador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892639399670455491L;

	/**
	 * Identificador Telefono
	 */
	private Long idTelefono;

	/**
	 * identificador del tipo telefono
	 */
	private TipoTelefono tipoTelefono;

	/**
	 * identificador del participante
	 */
	private Long idProcesar;

	/**
	 * Numero de Telefono
	 */
	private String numeroTelefono;

	/**
	 * Estatus
	 */
	private Long estatus;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * /** Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Clave extension telefonica
	 */
	private String extensionTelefonica;

	

	/**
	 * @return the idTelefono
	 */
	public Long getIdTelefono() {
		return idTelefono;
	}



	/**
	 * @param idTelefono the idTelefono to set
	 */
	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}



	/**
	 * @return the tipoTelefono
	 */
	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}



	/**
	 * @param tipoTelefono the tipoTelefono to set
	 */
	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
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
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	/**
	 * @param numeroTelefono the numeroTelefono to set
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	/**
	 * @return the estatus
	 */
	public Long getEstatus() {
		return estatus;
	}



	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
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
	 * @return the extensionTelefonica
	 */
	public String getExtensionTelefonica() {
		return extensionTelefonica;
	}



	/**
	 * @param extensionTelefonica the extensionTelefonica to set
	 */
	public void setExtensionTelefonica(String extensionTelefonica) {
		this.extensionTelefonica = extensionTelefonica;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Telefono [idTelefono=");
		builder.append(idTelefono);
		builder.append(", tipoTelefono="); 
		builder.append(tipoTelefono);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", numeroTelefono=");
		builder.append(numeroTelefono);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", extensionTelefonica=");
		builder.append(extensionTelefonica);
		builder.append("]");
		
		return builder.toString();
	}

}