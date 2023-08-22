package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;


/**
 * Entidad matriz derecho
 * @author REARREOL
 *
 */
public class IretMatrizDerecho implements Serializable{
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -8672447123298341676L;
	
	/**
	 * Id Matriz derecho.
	 */
	private Long idMatrizDerecho;
	
	/**
	 * Clave tipo retiro
	 */
	private String claveTipoRetiro;
	

	/**
	 * Clave tipo regimen
	 */
	private String claveTipoRegimen;
	

	/**
	 * Clave tipo prestacion
	 */
	private String claveTipoPrestacion;
	

	/**
	 * Clave tipo pension
	 */
	private String claveTipoPension;
	

	/**
	 * Clave tipo seguro
	 */
	private String claveTipoSeguro;
	

	/**
	 * Clave pension
	 */
	private String clavePension;
	
	
	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;
	
	/**
	 * Clave movimiento
	 */
	private String claveMovimiento;
	
	/**
	 * Numero activo
	 */
	private Long numeroActivo;
	
	
	/**
	 * Numero generacion
	 */
	private Long numeroGeneracion;
	
	
	

	/**
	 * idMatrizDerecho
	 * @return the idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * idMatrizDerecho
	 * @param idMatrizDerecho  the idMatrizDerecho to set
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	/**
	 * claveTipoRetiro
	 * @return the claveTipoRetiro
	 */
	public String getClaveTipoRetiro() {
		return claveTipoRetiro;
	}

	/**
	 * claveTipoRetiro
	 * @param claveTipoRetiro  the claveTipoRetiro to set
	 */
	public void setClaveTipoRetiro(String claveTipoRetiro) {
		this.claveTipoRetiro = claveTipoRetiro;
	}
	
	/**
	 * claveTipoRegimen
	 * @return the claveTipoRegimen
	 */
	public String getClaveTipoRegimen() {
		return claveTipoRegimen;
	}

	/**
	 * claveTipoRegimen
	 * @param claveTipoRegimen  the claveTipoRegimen to set
	 */
	public void setClaveTipoRegimen(String claveTipoRegimen) {
		this.claveTipoRegimen = claveTipoRegimen;
	}

	/**
	 * claveTipoPrestacion
	 * @return the claveTipoPrestacion
	 */
	public String getClaveTipoPrestacion() {
		return claveTipoPrestacion;
	}

	/**
	 * claveTipoPrestacion
	 * @param claveTipoPrestacion  the claveTipoPrestacion to set
	 */
	public void setClaveTipoPrestacion(String claveTipoPrestacion) {
		this.claveTipoPrestacion = claveTipoPrestacion;
	}

	/**
	 * claveTipoPrestacion
	 * @return the claveTipoPension
	 */
	public String getClaveTipoPension() {
		return claveTipoPension;
	}

	/**
	 * claveTipoPension
	 * @param claveTipoPension  the claveTipoPension to set
	 */
	public void setClaveTipoPension(String claveTipoPension) {
		this.claveTipoPension = claveTipoPension;
	}

	/**
	 * claveTipoSeguro
	 * @return the claveTipoSeguro
	 */
	public String getClaveTipoSeguro() {
		return claveTipoSeguro;
	}

	/**
	 * claveTipoSeguro
	 * @param claveTipoSeguro  the claveTipoSeguro to set
	 */
	public void setClaveTipoSeguro(String claveTipoSeguro) {
		this.claveTipoSeguro = claveTipoSeguro;
	}

	/**
	 * clavePension
	 * @return the clavePension
	 */
	public String getClavePension() {
		return clavePension;
	}
	
	


	/**
	 * usuarioModificador
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * usuarioModificador
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * claveMovimiento
	 * @return the claveMovimiento
	 */
	public String getClaveMovimiento() {
		return claveMovimiento;
	}

	/**
	 * claveMovimiento
	 * @param claveMovimiento the claveMovimiento to set
	 */
	public void setClaveMovimiento(String claveMovimiento) {
		this.claveMovimiento = claveMovimiento;
	}

	/**
	 * numeroActivo
	 * @return the numeroActivo
	 */
	public Long getNumeroActivo() {
		return numeroActivo;
	}

	/**
	 * numeroActivo
	 * @param numeroActivo the numeroActivo to set
	 */
	public void setNumeroActivo(Long numeroActivo) {
		this.numeroActivo = numeroActivo;
	}

	/**
	 * numeroGeneracion
	 * @return the numeroGeneracion
	 */
	public Long getNumeroGeneracion() {
		return numeroGeneracion;
	}

	/**
	 * numeroGeneracion
	 * @param numeroGeneracion the numeroGeneracion to set
	 */
	public void setNumeroGeneracion(Long numeroGeneracion) {
		this.numeroGeneracion = numeroGeneracion;
	}

	/**
	 * clavePension
	 * @param clavePension the clavePension to set
	 */
	public void setClavePension(String clavePension) {
		this.clavePension = clavePension;
	}
	
	

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IretMatrizDerecho [idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", claveTipoRetiro=");
		builder.append(claveTipoRetiro);
		builder.append(", claveTipoRegimen=");
		builder.append(claveTipoRegimen);
		builder.append(", claveTipoPrestacion=");
		builder.append(claveTipoPrestacion);
		builder.append(", claveTipoPension=");
		builder.append(claveTipoPension);
		builder.append(", claveTipoSeguro=");
		builder.append(claveTipoSeguro);
		builder.append(", clavePension=");
		builder.append(clavePension);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", claveMovimiento=");
		builder.append(claveMovimiento);
		builder.append(", numeroActivo=");
		builder.append(numeroActivo);
		builder.append(", numeroGeneracion=");
		builder.append(numeroGeneracion);
		builder.append("]");
		return builder.toString();
	}
}
