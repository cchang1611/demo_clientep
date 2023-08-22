package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Ocupaciones
 * 
 * @author MEDOMING
 *
 */
public class OcupacionList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -6320993899074574006L;
	
	/**
	 * listaOcupaciones
	 */
	private List<Ocupacion> listaOcupaciones;
	
	/**
	 * @return listaOcupaciones
	 */
	public List<Ocupacion> getListaOcupaciones() {
		return listaOcupaciones;
	}

	/**
	 * @param listaOcupaciones the listaOcupaciones to set
	 */
	public void setListaOcupaciones(List<Ocupacion> listaOcupaciones) {
		this.listaOcupaciones = listaOcupaciones;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OcupacionList [listaOcupaciones=");
		builder.append(listaOcupaciones);
		builder.append("]");
		return builder.toString();
	}

}
