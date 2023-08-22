package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de entrada EntradaFolioDactilar
 * 
 * @author AJPORTIL
 *
 */
public class EntradaFolioDactilar implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6267721593850475790L;

	/**
	 * idSello
	 */
	private Long idSello;

	/**
	 * curpTrabajador
	 */
	private String curpTrabajador;

	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;

	/**
	 * Constructor
	 */
	public EntradaFolioDactilar() {
		super();
	}

	/**
	 * @return the idSello
	 */
	public Long getIdSello() {
		return idSello;
	}

	/**
	 * @param idSello
	 *            the idSello to set
	 */
	public void setIdSello(Long idSello) {
		this.idSello = idSello;
	}

	/**
	 * @return the curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador
	 *            the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaFolioDactilar [idSello=");
		builder.append(idSello);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
