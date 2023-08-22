package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class CargaComparadorModificacion implements Serializable{
	
	
	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 8266067970767301398L;

	/**
	 * Entrada modificacion
	 */
	private EntradaModificacion entradaModificacion;
	
	/**
	 * Entrada solicitante
	 */
	private EntradaSolicitante entradaSolicitante;

	/**
	 * @return the entradaModificacion
	 */
	public EntradaModificacion getEntradaModificacion() {
		return entradaModificacion;
	}

	/**
	 * @param entradaModificacion the entradaModificacion to set
	 */
	public void setEntradaModificacion(EntradaModificacion entradaModificacion) {
		this.entradaModificacion = entradaModificacion;
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
		builder.append("CargaComparadorModificacion [entradaModificacion=");
		builder.append(entradaModificacion);
		builder.append(", entradaSolicitante=");
		builder.append(entradaSolicitante);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
