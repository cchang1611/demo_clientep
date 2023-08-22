package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Grados de estudio
 * 
 * @author MEDOMING
 *
 */
public class GradoEstudiosList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -3920141833074875696L;
	
	/**
	 * listaGrados
	 */
	private List<GradoEstudios> listaGrados;
	
	/**
	 * @return listaGrados
	 */
	public List<GradoEstudios> getListaGrados() {
		return listaGrados;
	}

	/**
	 * @param listaGrados the listaGrados to set
	 */
	public void setListaGrados(List<GradoEstudios> listaGrados) {
		this.listaGrados = listaGrados;
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
		builder.append("GradoEstudiosList [listaGrados=");
		builder.append(listaGrados);
		builder.append("]");
		return builder.toString();
	}

}

