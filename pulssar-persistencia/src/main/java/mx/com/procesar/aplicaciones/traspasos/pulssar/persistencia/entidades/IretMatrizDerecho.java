package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;




/**
 * Entidad matriz derecho
 * @author REARREOL
 *
 */
@Entity
@Table(name="IRET_TR_MATRIZ_DERECHO")
public class IretMatrizDerecho implements Serializable{
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -8672447123298341676L;
	
	/**
	 * Id Matriz derecho.
	 */
	@Id
	@Column(name = "ID_MATRIZ_DERECHO")
	private Long idMatrizDerecho;
	
	/**
	 * Clave tipo retiro
	 */
	@Column(name = "CV_TIPO_RETIRO")
	private String claveTipoRetiro;
	

	/**
	 * Clave tipo regimen
	 */
	@Column(name = "CV_TIPO_REGIMEN")
	private String claveTipoRegimen;
	

	/**
	 * Clave tipo prestacion
	 */
	@Column(name = "CV_TIPO_PRESTACION")
	private String claveTipoPrestacion;
	

	/**
	 * Clave tipo pension
	 */
	@Column(name = "CV_TIPO_PENSION")
	private String claveTipoPension;
	

	/**
	 * Clave tipo seguro
	 */
	@Column(name = "CV_TIPO_SEGURO")
	private String claveTipoSeguro;
	

	/**
	 * Clave pension
	 */
	@Column(name = "CV_CLAVE_PENSION")
	private String clavePension;
	
	
	/**
	 * Usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * Clave movimiento
	 */
	@Column(name = "CV_MOVIMIENTO")
	private String claveMovimiento;
	
	/**
	 * Numero activo
	 */
	@Column(name = "NU_ACTIVO")
	private Long numeroActivo;
	
	
	/**
	 * Numero generacion
	 */
	@Column(name = "NU_GENERACION_BONO")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
 

}
