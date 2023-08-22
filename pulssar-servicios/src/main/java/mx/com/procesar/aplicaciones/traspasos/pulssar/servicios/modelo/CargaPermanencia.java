package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase que contiene objetos de entrada para permanencia
 * @author JMGUTIEG
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CargaPermanencia implements Serializable{

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 7296422808042893545L;
	
	/**
	 * entrada permannecia
	 */
	private EntradaPermanencia entradaPermanencia;
	
	/**
	 * Entrada solicitante
	 */
	private EntradaSolicitante entradaSolicitante;

	/**
	 * @return the entradaPermanencia
	 */
	public EntradaPermanencia getEntradaPermanencia() {
		return entradaPermanencia;
	}

	/**
	 * @param entradaPermanencia the entradaPermanencia to set
	 */
	public void setEntradaPermanencia(EntradaPermanencia entradaPermanencia) {
		this.entradaPermanencia = entradaPermanencia;
	}

	/**
	 * @return the entradaSolicitante
	 */
	public EntradaSolicitante getEntradaSolicitante() {
		return entradaSolicitante;
	}

	/**
	 * @param entradaSolicitante the entradaSolicitante to set
	 */
	public void setEntradaSolicitante(EntradaSolicitante entradaSolicitante) {
		this.entradaSolicitante = entradaSolicitante;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CargaPermanencia [entradaPermanencia=");
		builder.append(entradaPermanencia);
		builder.append(", entradaSolicitante=");
		builder.append(entradaSolicitante);
		builder.append("]");
		return builder.toString();
	}

	
	
}
