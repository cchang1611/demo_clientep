package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="IRET_TC_DIAGNOSTICO")
public class IretTcDiagnostico {

	/**
	 * idDiagnostico
	 */
	@Id
	@Column(name ="ID_DIAGNOSTICO")
	private Long idDiagnostico;
	/**
	 * cveProceso
	 */
	@Column(name ="CV_PROCESO")
	private String cveProceso;
	/**
	 * cveTipoOperacion
	 */
	@Column(name ="CV_TIPO_OPERACION")
	private String cveTipoOperacion;
	/**
	 * diagnostico
	 */
	@Column(name ="CH_DIAGNOSTICO")
	private String diagnostico;
	/**
	 * descDiagnostico
	 */
	@Column(name ="CH_DESC_DIAGNOSTICO")
	private String descDiagnostico;
	/**
	 * administradora
	 */
	@Column(name ="NU_ADMINISTRADORA")
	private Long administradora;
	/**
	 * activo
	 */
	@Column(name ="NU_ACTIVO")
	private Long activo;
	/**
	 * usuarioModificador
	 */
	@Column(name ="CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	/**
	 * control
	 */
	@Column(name ="FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date control;
	/**
	 * codigoDiagnostico
	 */
	@Column(name ="CH_CODIGO_DIAGNOSTICO")
	private String codigoDiagnostico;
	/**
	 * @return el atributo idDiagnostico
	 */
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	/**
	 * @param idDiagnostico parametro idDiagnostico a actualizar
	 */
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	/**
	 * @return el atributo cveProceso
	 */
	public String getCveProceso() {
		return cveProceso;
	}
	/**
	 * @param cveProceso parametro cveProceso a actualizar
	 */
	public void setCveProceso(String cveProceso) {
		this.cveProceso = cveProceso;
	}
	/**
	 * @return el atributo cveTipoOperacion
	 */
	public String getCveTipoOperacion() {
		return cveTipoOperacion;
	}
	/**
	 * @param cveTipoOperacion parametro cveTipoOperacion a actualizar
	 */
	public void setCveTipoOperacion(String cveTipoOperacion) {
		this.cveTipoOperacion = cveTipoOperacion;
	}
	/**
	 * @return el atributo diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	/**
	 * @param diagnostico parametro diagnostico a actualizar
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	/**
	 * @return el atributo descDiagnostico
	 */
	public String getDescDiagnostico() {
		return descDiagnostico;
	}
	/**
	 * @param descDiagnostico parametro descDiagnostico a actualizar
	 */
	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}
	/**
	 * @return el atributo administradora
	 */
	public Long getAdministradora() {
		return administradora;
	}
	/**
	 * @param administradora parametro administradora a actualizar
	 */
	public void setAdministradora(Long administradora) {
		this.administradora = administradora;
	}
	/**
	 * @return el atributo activo
	 */
	public Long getActivo() {
		return activo;
	}
	/**
	 * @param activo parametro activo a actualizar
	 */
	public void setActivo(Long activo) {
		this.activo = activo;
	}
	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}
	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}
	/**
	 * @return el atributo control
	 */
	public Date getControl() {
		return control;
	}
	/**
	 * @param control parametro control a actualizar
	 */
	public void setControl(Date control) {
		this.control = control;
	}
	/**
	 * @return el atributo codigoDiagnostico
	 */
	public String getCodigoDiagnostico() {
		return codigoDiagnostico;
	}
	/**
	 * @param codigoDiagnostico parametro codigoDiagnostico a actualizar
	 */
	public void setCodigoDiagnostico(String codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}
	
}
