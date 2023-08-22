package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Llave compuesta de la persistencia de la tabla TRAN_TR_REFERENCIA
 * 
 * @author OJBALBUE
 * 
 */
public class ReferenciaTrabajadorPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4631656769999751080L;

	/**
	 * Identificador Procesar
	 */
	private Long idProcesar;

	/**
	 * CURP
	 */
	private String curp;

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar
	 *            the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReferenciaTrabajadorPK [idProcesar=" + idProcesar + ", curp=" + curp + "]";
	}

}
