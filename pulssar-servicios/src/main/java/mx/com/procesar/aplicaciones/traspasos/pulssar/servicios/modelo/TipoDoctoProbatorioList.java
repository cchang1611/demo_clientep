package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Interface para la consulta de catalogos
 * 
 * @author MEDOMING
 *
 */
public class TipoDoctoProbatorioList implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = 5384057045717061991L;
	
	/**
	 * listaTipoDocto
	 */
	private List<TipoDoctoProbatorio> listaTipoDocto;
	
	
	/**
	 * @return listaTipoDocto
	 */
	public List<TipoDoctoProbatorio> getListaTipoDocto() {
		return listaTipoDocto;
	}

	/**
	 * @param listaTipoDocto the listaTipoDocto to set
	 */
	public void setListaTipoDocto(List<TipoDoctoProbatorio> listaTipoDocto) {
		this.listaTipoDocto = listaTipoDocto;
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
		builder.append("TipoDoctoProbatorioList [listaTipoDocto=");
		builder.append(listaTipoDocto);
		builder.append("]");
		return builder.toString();
	}

}
