package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
/**
 * Datos entrada mensualidades
 * @author ANOSORIO
 *
 */
public class Mensualidad implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -541053206420138549L;

	/**
	 * Parcialidad
	 */
	private Integer parcialidad;
	
	/**
	 * Monto Parcialidad
	 */
	private Double montoParcialidad;
	
	/**
	 * Fecha Pago
	 */
	private Date fechaPago;
	
	/**
	 * Derecho pago
	 */
	private Integer derechoPago;

	/**
	 * @return the parcialidad
	 */
	public Integer getParcialidad() {
		return parcialidad;
	}

	/**
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(Integer parcialidad) {
		this.parcialidad = parcialidad;
	}

	/**
	 * @return the montoParcialidad
	 */
	public Double getMontoParcialidad() {
		return montoParcialidad;
	}

	/**
	 * @param montoParcialidad the montoParcialidad to set
	 */
	public void setMontoParcialidad(Double montoParcialidad) {
		this.montoParcialidad = montoParcialidad;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the derechoPago
	 */
	public Integer getDerechoPago() {
		return derechoPago;
	}

	/**
	 * @param derechoPago the derechoPago to set
	 */
	public void setDerechoPago(Integer derechoPago) {
		this.derechoPago = derechoPago;
	}

	/**
	 * Constructor
	 */
	public Mensualidad() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mensualidad [parcialidad=");
		builder.append(parcialidad);
		builder.append(", montoParcialidad=");
		builder.append(montoParcialidad);
		builder.append(", fechaPago=");
		builder.append(fechaPago);
		builder.append(", derechoPago=");
		builder.append(derechoPago);
		builder.append("]");
		return builder.toString();
	}
	
	
}
