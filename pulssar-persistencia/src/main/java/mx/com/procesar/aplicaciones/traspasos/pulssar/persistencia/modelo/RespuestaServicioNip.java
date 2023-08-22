/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Almacena la respuesta del servicio de generación de NIP
 * @author MALOPEZT
 * @since 2022/02/03
 */
public class RespuestaServicioNip implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -99611027090165815L;

	/** Resutlado de la transacción*/
	private String confirmacionTransaccion;
	
	/** Motivo de rechazo */
	private String motivoRechazo;
	
	/** Descripcion del rechazo en la generación del Nip */
	private String descripcionRechazo;

	/** Sobrecarga */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{'confirmacionTransaccion' : '").append(confirmacionTransaccion).append("' ,");
		sb.append(" 'motivoRechazo' : '").append(motivoRechazo).append("' }");
		return sb.toString();
	}
	
	/**
	 * @return the confirmacionTransaccion
	 */
	public String getConfirmacionTransaccion() {
		return confirmacionTransaccion;
	}

	/**
	 * @param confirmacionTransaccion the confirmacionTransaccion to set
	 */
	public void setConfirmacionTransaccion(String confirmacionTransaccion) {
		this.confirmacionTransaccion = confirmacionTransaccion;
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
	 * @return the descripcionRechazo
	 */
	public String getDescripcionRechazo() {
		return descripcionRechazo;
	}

	/**
	 * @param descripcionRechazo the descripcionRechazo to set
	 */
	public void setDescripcionRechazo(String descripcionRechazo) {
		this.descripcionRechazo = descripcionRechazo;
	}
}
