package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto que contiene el objeto para la consulta de plataforma servicios
 * 
 * @author rarreola
 */
public class EntradaPlataformaServicios implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 862940770179570938L;
	
	/**
	 * Afore
	 */
	private String[] afore;
	
	/**
	 * usuarios
	 */
	private String usuarios;
	
	/**
	 * folios pulssar
	 */
	private String foliosPulssar;
	
	/**
	 * Resultado operacion
	 */
	private String resultadoOperacion;
	
	/**
	 * fecha inicio
	 */
	private String fechaInicio;
	
	/**
	 * fecha fin
	 */
	private String fechaFin;
	
	
	

	




	/**
	 * @return the afore
	 */
	public String[] getAfore() {
		return afore;
	}




	/**
	 * @param afore the afore to set
	 */
	public void setAfore(String[] afore) {
		this.afore = afore;
	}




	/**
	 * @return the usuarios
	 */
	public String getUsuarios() {
		return usuarios;
	}




	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}




	/**
	 * @return the foliosPulssar
	 */
	public String getFoliosPulssar() {
		return foliosPulssar;
	}




	/**
	 * @param foliosPulssar the foliosPulssar to set
	 */
	public void setFoliosPulssar(String foliosPulssar) {
		this.foliosPulssar = foliosPulssar;
	}




	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}




	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}




	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}




	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}




	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}




	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaPlataformaServicios [afore=");
		builder.append(afore);
		builder.append(", usuarios=");
		builder.append(usuarios);
		builder.append(", foliosPulssar=");
		builder.append(foliosPulssar);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append("]");
		return builder.toString();
	}
}