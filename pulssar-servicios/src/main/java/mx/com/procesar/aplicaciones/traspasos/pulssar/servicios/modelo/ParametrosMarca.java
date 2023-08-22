package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase que agrupa los parametros para el proceso de validacion de marcas
 * 
 * @author David Barbosa Ibarra (dbarbosa)
 * @version 1.0
 * @since 05/03/2019
 */
public class ParametrosMarca implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1290060684871636174L;

	/**
	 * Identificador Trabajador
	 */
	private Long identificador;

	/**
	 * Clave de Proceso(s) entrante(s)
	 */
	private String proceso;

	/**
	 * @return the identificador
	 */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParametrosMarca [identificador=");
		builder.append(identificador);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append("]");
		return builder.toString();
	}
}