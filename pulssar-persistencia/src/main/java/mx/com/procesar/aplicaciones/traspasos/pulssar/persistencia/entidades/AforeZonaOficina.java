package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ReadOnly;

/**
* Clase de persistencia para la tabla PSER_TC_AFORE_OFICINA
* 
* @author dbarbosa
* @version 1.0
*/
@Entity
@Table(name = "PSER_TC_AFORE_OFICINA")
@IdClass(AforeZonaOficinaPK.class)
@ReadOnly
public class AforeZonaOficina implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 860276322773778216L;
	
	/**
	 * Clave Afore
	 */
	@Id
	@Column(name = "CV_AFORE")
	private String cveAfore;
	
	/**
	 * Clave Oficina
	 */
	@Id
	@Column(name = "CV_OFICINA")
	private String cveOficina;
	
	/**
	 * Clave Afore
	 */
	@Id
	@Column(name = "ID_ZONA")
	private Long idZona;
	
	/**
	 * Relacion de oficina
	 */
	@OneToOne
	@JoinColumn(name = "CV_OFICINA", insertable = false, updatable = false)
	private Oficina oficina;
	
	/**
	 * Relacion Zona
	 */
	@OneToOne
	@JoinColumn(name = "ID_ZONA", insertable = false, updatable = false)
	private Zona zona;
	
	/**
	 * Bandera de activo inactivo
	 */
	@Column(name = "NU_ACTIVO")
	private Integer nuActivo;
	
	/**
	 * Fecha Control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaControl;
	
	/**
	 * Usuario Modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}

	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}

	/**
	 * @return the cveOficina
	 */
	public String getCveOficina() {
		return cveOficina;
	}

	/**
	 * @param cveOficina the cveOficina to set
	 */
	public void setCveOficina(String cveOficina) {
		this.cveOficina = cveOficina;
	}

	/**
	 * @return the idZona
	 */
	public Long getIdZona() {
		return idZona;
	}

	/**
	 * @param idZona the idZona to set
	 */
	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	/**
	 * @return the oficina
	 */
	public Oficina getOficina() {
		return oficina;
	}

	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	/**
	 * @return the zona
	 */
	public Zona getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(Zona zona) {
		this.zona = zona;
	}

	/**
	 * @return the nuActivo
	 */
	public Integer getNuActivo() {
		return nuActivo;
	}

	/**
	 * @param nuActivo the nuActivo to set
	 */
	public void setNuActivo(Integer nuActivo) {
		this.nuActivo = nuActivo;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AforeZonaOficina [ cveAfore=");
		builder.append(cveAfore);
		builder.append(", oficina=");
		builder.append(oficina.toString());
		builder.append(", zona=");
		builder.append(zona.toString());
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}