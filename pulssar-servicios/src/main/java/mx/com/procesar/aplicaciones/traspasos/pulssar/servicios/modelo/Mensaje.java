package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto que contiene el objeto para el envio de mensaje
 * 
 * @author DBARBOSA
 */
public class Mensaje  implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 6436642216092954748L;

	/**
	 * OBJ Idssn
	 */
	private Idssn idssn;
	
	/**
	 * OBJ cuerpo
	 */
	private Cuerpo cuerpo;
	
	/**
	 * @return the idssn
	 */
	public Idssn getIdssn() {
		return idssn;
	}

	/**
	 * @param idssn the idssn to set
	 */
	public void setIdssn(Idssn idssn) {
		this.idssn = idssn;
	}

	/**
	 * @return the cuerpo
	 */
	public Cuerpo getCuerpo() {
		return cuerpo;
	}

	/**
	 * @param cuerpo the cuerpo to set
	 */
	public void setCuerpo(Cuerpo cuerpo) {
		this.cuerpo = cuerpo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mensaje [idssn=");
		builder.append(idssn);
		builder.append(", cuerpo=");
		builder.append(cuerpo);
		builder.append("]");
		return builder.toString();
	}
}