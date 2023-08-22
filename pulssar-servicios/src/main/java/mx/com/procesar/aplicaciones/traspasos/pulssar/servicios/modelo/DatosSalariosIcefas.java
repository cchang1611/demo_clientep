package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de saldos
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosSalariosIcefas  implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1987980856269593427L;

	/**
	 * periodo
	 */
	private String periodo;
	
	/**
	 * periodo
	 */
	private String salario;
	
	/**
	 * indicador
	 */
	private Integer indicador;
	
	/**
	 * username
	 */
	private List<String> listaIcefas;
	
	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the salario
	 */
	public String getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(String salario) {
		this.salario = salario;
	}

	/**
	 * @return the indicador
	 */
	public Integer getIndicador() {
		return indicador;
	}

	/**
	 * @param indicador the indicador to set
	 */
	public void setIndicador(Integer indicador) {
		this.indicador = indicador;
	}

	/**
	 * @return the listaIcefas
	 */
	public List<String> getListaIcefas() {
		return listaIcefas;
	}

	/**
	 * @param listaIcefas the listaIcefas to set
	 */
	public void setListaIcefas(List<String> listaIcefas) {
		this.listaIcefas = listaIcefas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSalariosIcefas [periodo=");
		builder.append(periodo);
		builder.append(", salario=");
		builder.append(salario);
		builder.append(", indicador=");
		builder.append(indicador);
		builder.append(", listaIcefas=");
		builder.append(listaIcefas);
		builder.append("]");
		return builder.toString();
	}
}