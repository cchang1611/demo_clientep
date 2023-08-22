package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Output implements Serializable{
	
	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -5561449502629600814L;

	/**
	 * lista de informacion de catalogo
	 */
	private List<CatalogoCodigoPostal> dataSet;
	
	/**
	 * Numero de pagina
	 */
	@JsonProperty("page-number")
    private String numeroPagina;
	
	/**
	 * Total de paginas
	 */
	@JsonProperty("total-pages")
    private String totalPaginas;
	
	/**
	 * total records
	 */
	@JsonProperty("total-records")
    private String totalRecords;
	
	/**
	 * Contructor
	 */
	public Output(){
		
	}
	
	/**
	 * @return the dataSet
	 */
	public List<CatalogoCodigoPostal> getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet the dataSet to set
	 */
	public void setDataSet(List<CatalogoCodigoPostal> dataSet) {
		this.dataSet = dataSet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Output [dataSet=");
		builder.append(dataSet);
		builder.append("]");
		return builder.toString();
	}
	
	
}
