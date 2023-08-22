package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase Data de Filtro
 * 
 */
public class FiltroData implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre filtro
	 */
	@JsonProperty("nombre-filtro")
	private String nombreFiltro;

	/**
	 * Valor filtro
	 */
	@JsonProperty("valor-filtro")
	private String valorFiltro;

	/**
	 * Constructor por default
	 */
	public FiltroData(){

		super();
	}

	/**
	 * Constructor
	 * 
	 * @param nombreFiltro
	 * @param valorFiltro
	 */
	public FiltroData(String nombreFiltro, String valorFiltro){

		super();
		this.nombreFiltro = nombreFiltro;
		this.valorFiltro = valorFiltro;
	}

	/**
	 * @return the nombreFiltro
	 */
	public String getNombreFiltro() {
		return nombreFiltro;
	}

	/**
	 * @param nombreFiltro the nombreFiltro to set
	 */
	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro;
	}

	/**
	 * @return the valorFiltro
	 */
	public String getValorFiltro() {
		return valorFiltro;
	}

	/**
	 * @param valorFiltro the valorFiltro to set
	 */
	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FiltroData [nombreFiltro=");
		builder.append(nombreFiltro);
		builder.append(", valorFiltro=");
		builder.append(valorFiltro);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
