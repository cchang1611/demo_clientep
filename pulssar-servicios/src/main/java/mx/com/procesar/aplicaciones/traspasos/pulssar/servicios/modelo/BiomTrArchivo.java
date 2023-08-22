package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * BiomTrArchivo
 * @author jmordone
 *
 */
public class BiomTrArchivo implements Serializable  {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = -6559622747354930424L;

	/**
	 * idBitacoraCore
	 */
	private Long idArchivo;

	/**
	 * chAfore
	 */
	private String chNombreArchivo;

	/**
	 * chPeticion
	 */
	private String chAfore;
	
	/**
	 * fcRecepcion
	 */
	private Date fcOperacion;

	/**
	 * chServicio
	 */
	private String chServicio;
	
	/**
	 * chServicio
	 */
	private String chFolioArchivo;
	
	/**
	 * chResultadoOperacion
	 */
	private String chResultadoOperacion;
	
	/**
	 * chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * fcControl
	 */
	private Date fcControl;

	/**
	 * fcRecepcion
	 */
	private Date fcRecepcion;

	/**
	 * @return the idArchivo
	 */
	public Long getIdArchivo() {
		return idArchivo;
	}

	/**
	 * @param idArchivo the idArchivo to set
	 */
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	/**
	 * @return the chNombreArchivo
	 */
	public String getChNombreArchivo() {
		return chNombreArchivo;
	}

	/**
	 * @param chNombreArchivo the chNombreArchivo to set
	 */
	public void setChNombreArchivo(String chNombreArchivo) {
		this.chNombreArchivo = chNombreArchivo;
	}

	/**
	 * @return the chAfore
	 */
	public String getChAfore() {
		return chAfore;
	}

	/**
	 * @param chAfore the chAfore to set
	 */
	public void setChAfore(String chAfore) {
		this.chAfore = chAfore;
	}

	/**
	 * @return the fcOperacion
	 */
	public Date getFcOperacion() {
		return fcOperacion;
	}

	/**
	 * @param fcOperacion the fcOperacion to set
	 */
	public void setFcOperacion(Date fcOperacion) {
		this.fcOperacion = fcOperacion;
	}

	/**
	 * @return the chServicio
	 */
	public String getChServicio() {
		return chServicio;
	}

	/**
	 * @param chServicio the chServicio to set
	 */
	public void setChServicio(String chServicio) {
		this.chServicio = chServicio;
	}

	/**
	 * @return the chFolioArchivo
	 */
	public String getChFolioArchivo() {
		return chFolioArchivo;
	}

	/**
	 * @param chFolioArchivo the chFolioArchivo to set
	 */
	public void setChFolioArchivo(String chFolioArchivo) {
		this.chFolioArchivo = chFolioArchivo;
	}

	/**
	 * @return the chResultadoOperacion
	 */
	public String getChResultadoOperacion() {
		return chResultadoOperacion;
	}

	/**
	 * @param chResultadoOperacion the chResultadoOperacion to set
	 */
	public void setChResultadoOperacion(String chResultadoOperacion) {
		this.chResultadoOperacion = chResultadoOperacion;
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
	 * @return the fcRecepcion
	 */
	public Date getFcRecepcion() {
		return fcRecepcion;
	}

	/**
	 * @param fcRecepcion the fcRecepcion to set
	 */
	public void setFcRecepcion(Date fcRecepcion) {
		this.fcRecepcion = fcRecepcion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BiomTrArchivo [idArchivo=");
		builder.append(idArchivo);
		builder.append(", chNombreArchivo=");
		builder.append(chNombreArchivo);
		builder.append(", chAfore=");
		builder.append(chAfore);
		builder.append(", fcOperacion=");
		builder.append(fcOperacion);
		builder.append(", chServicio=");
		builder.append(chServicio);
		builder.append(", chFolioArchivo=");
		builder.append(chFolioArchivo);
		builder.append(", chResultadoOperacion=");
		builder.append(chResultadoOperacion);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", fcRecepcion=");
		builder.append(fcRecepcion);
		builder.append("]");
		return builder.toString();
	}
	

}