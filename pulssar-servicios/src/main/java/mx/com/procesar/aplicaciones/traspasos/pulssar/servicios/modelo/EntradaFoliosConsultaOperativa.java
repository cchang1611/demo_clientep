package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;
/**
 * Entrada folios consulta operativa
 * @author RARREOLA
 *
 */
public class EntradaFoliosConsultaOperativa implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5060180914689791581L;

	
	/**
	 * fechaInicio
	 */
	private String fechaInicio;
	
	/**
	 * fechaFin
	 */
	private String fechaFin;
	
	/**
	 * Clave organizacion
	 */
	private List<String> claveOrganizacion;
	
	/**
	 * Usuarios
	 */
	private List<String> usuarios;
	
	/**
	 * Usuarios
	 */
	private List<String> folioPulssar;
	
	/**
	 * Resultado operacion
	 */
	private String resultadoOperacion;
	
	
	/**
	 * Claves servicios
	 */
	private String claveServicios;
	
	/**
	 * idUsuariosPulssar
	 */
	private List<Long> idUsuariosPulssar;
	
	/**
	 * identificador Modificacion DD
	 */
	private boolean identificadorMDD;

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



	


	/**
	 * @return the claveOrganizacion
	 */
	public List<String> getClaveOrganizacion() {
		return claveOrganizacion;
	}



	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(List<String> claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}



	/**
	 * @return the usuarios
	 */
	public List<String> getUsuarios() {
		return usuarios;
	}



	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<String> usuarios) {
		this.usuarios = usuarios;
	}



	/**
	 * @return the folioPulssar
	 */
	public List<String> getFolioPulssar() {
		return folioPulssar;
	}



	/**
	 * @param folioPulssar the folioPulssar to set
	 */
	public void setFolioPulssar(List<String> folioPulssar) {
		this.folioPulssar = folioPulssar;
	}



	



	/**
	 * @return the claveServicios
	 */
	public String getClaveServicios() {
		return claveServicios;
	}



	/**
	 * @param claveServicios the claveServicios to set
	 */
	public void setClaveServicios(String claveServicios) {
		this.claveServicios = claveServicios;
	}



	/**
	 * @return the idUsuariosPulssar
	 */
	public List<Long> getIdUsuariosPulssar() {
		return idUsuariosPulssar;
	}



	/**
	 * @param idUsuariosPulssar the idUsuariosPulssar to set
	 */
	public void setIdUsuariosPulssar(List<Long> idUsuariosPulssar) {
		this.idUsuariosPulssar = idUsuariosPulssar;
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
	 * @return the identificadorMDD
	 */
	public boolean isIdentificadorMDD() {
		return identificadorMDD;
	}



	/**
	 * @param identificadorMDD the identificadorMDD to set
	 */
	public void setIdentificadorMDD(boolean identificadorMDD) {
		this.identificadorMDD = identificadorMDD;
	}

	/**
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaFoliosConsultaOperativa [fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append(", claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", usuarios=");
		builder.append(usuarios);
		builder.append(", folioPulssar=");
		builder.append(folioPulssar);
		builder.append(", claveServicios=");
		builder.append(claveServicios);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", idUsuariosPulssar=");
		builder.append(idUsuariosPulssar);
		builder.append(", identificadorMDD=");
		builder.append(identificadorMDD);
		builder.append("]");
		return builder.toString();
	}

}
