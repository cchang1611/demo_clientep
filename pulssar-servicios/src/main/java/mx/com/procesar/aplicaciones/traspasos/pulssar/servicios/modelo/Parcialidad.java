package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Datos entrada para las parcialidades
 * @author ANOSORIO
 *
 */
public class Parcialidad implements Serializable{

	/**
	 *Serial 
	 */
	private static final long serialVersionUID = -1100292074917631675L;

	
	/**
	 * idProcesar
	 */
	private Long idProcesar;
	
	/**
	 * numeroParcialidad
	 */
	private Integer numeroParcialidad;
	
	/**
	 * estatus
	 */
	private Integer estatus;

	
	/**
	 * estatusBuscar
	 */
	private Integer estatusBuscar;
	
	
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
	 * @return the numeroParcialidad
	 */
	public Integer getNumeroParcialidad() {
		return numeroParcialidad;
	}

	/**
	 * @param numeroParcialidad the numeroParcialidad to set
	 */
	public void setNumeroParcialidad(Integer numeroParcialidad) {
		this.numeroParcialidad = numeroParcialidad;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	
	
	/**
	 * @return the estatusBuscar
	 */
	public Integer getEstatusBuscar() {
		return estatusBuscar;
	}

	/**
	 * @param estatusBuscar the estatusBuscar to set
	 */
	public void setEstatusBuscar(Integer estatusBuscar) {
		this.estatusBuscar = estatusBuscar;
	}

	/**
	 * Constructor
	 */
	public Parcialidad() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parcialidad [idProcesar=");
		builder.append(idProcesar);
		builder.append(", numeroParcialidad=");
		builder.append(numeroParcialidad);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", estatusBuscar=");
		builder.append(estatusBuscar);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
