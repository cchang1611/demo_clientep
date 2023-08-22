package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene lista de Parentescos
 * 
 * @author MEDOMING
 *
 */
public class ParentescoList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -6148718764950507437L;
	
	/**
	 * listaParentesco
	 */
	private List<Parentesco> listaParentesco;
	
	/**
	 * @return listaParentesco
	 */
	public List<Parentesco> getListaParentesco() {
		return listaParentesco;
	}

	/**
	 * @param listaParentesco the listaParentesco to set
	 */
	public void setListaParentesco(List<Parentesco> listaParentesco) {
		this.listaParentesco = listaParentesco;
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
		builder.append("ParentescoList [listaParentesco=");
		builder.append(listaParentesco);
		builder.append("]");
		return builder.toString();
	}

}

