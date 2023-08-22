package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * 
 * @author RARREOLA
 *
 */
public class EntradaMarcasVivienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * idTipo proceso
	 */
	private List<String> idTipoProceso;

	/**
	 * @return the idTipoProceso
	 */
	public List<String> getIdTipoProceso() {
		return idTipoProceso;
	}

	/**
	 * @param idTipoProceso the idTipoProceso to set
	 */
	public void setIdTipoProceso(List<String> idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
