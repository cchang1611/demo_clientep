package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Representa un Tipo Proceso, mapeado a la tabla NSAR_TC_TIPO_PROCESO
 * 
 * @author dbarbosa
 */

public class TipoProceso implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7198367137866360565L;

	/**
	 * Atributo idTipoProceso
	 */
	private Long idTipoProceso;
	
	/**
	 * identificador tipo proceso
	 */

	private Long tipoProceso;

	/**
	 * descripción del proceso
	 */

	private String descripcion;

	/**
	 * usuario modificador
	 */

	private String usuario;

	/**
	 * clave del proceso
	 */
	private String claveProceso;


	
	/**
	 * @return the tipoProceso
	 */
	public Long getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(Long tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * @param claveProceso the claveProceso to set
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}


	/**
	 * Obtener idTipoProceso
	 */
	public Long getIdTipoProceso() {
		return idTipoProceso;
	}

	/**
	 * Setear idTipoProceso
	 */
	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}

	/**
	 * Sobrescritura del metodo toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("TipoProcesoDO [tipoProceso=");
		cadena.append(tipoProceso);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuario=");
		cadena.append(usuario);
		cadena.append(", claveProceso=");
		cadena.append(claveProceso);
		cadena.append("]");
		return cadena.toString();
	}
}