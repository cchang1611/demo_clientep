/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Nace como simple objeto de tralado de información
 * Viaja del negocio al controlador.
 * @author malopezt
 */
public class NipConsultaBUU implements Serializable {

	
	/** Serial ID */
	private static final long serialVersionUID = -3458349917663754500L;
	
	/** Mensaje de salida */
	private String correoElectronico;
	
	/** Teléfono celular*/
	private String telefono;
	
	/** Confirmación de operación de consulta a Servicio de generación Nip */
	private String confirmacionTransaccion;
	
	/** Motivo de rechazo de operación de consulta a Servicio de generación Nip */
	private String motivoRechazo;

	/** Sobrecarga */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{'correo' : '").append(correoElectronico).append("' , ");
		sb.append(" 'confirmacionTransaccion' : ").append(confirmacionTransaccion).append("' ,");
		sb.append(" 'motivoRechazo' : ").append(motivoRechazo).append("'}");
		return sb.toString();
	}

	/**
	 * @return the correo
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correo to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @return the confirmacionTransaccion
	 */
	public String getConfirmacionTransaccion() {
		return confirmacionTransaccion;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @param confirmacionTransaccion the confirmacionTransaccion to set
	 */
	public void setConfirmacionTransaccion(String confirmacionTransaccion) {
		this.confirmacionTransaccion = confirmacionTransaccion;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}


}
