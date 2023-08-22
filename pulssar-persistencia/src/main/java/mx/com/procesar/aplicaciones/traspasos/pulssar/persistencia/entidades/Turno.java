package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Entidad que representa al tabla <b>PSER_TR_TURNO</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Entity
@Table(name = "PSER_TR_TURNO")
@SequenceGenerator(name = "SEQ_TURNO", sequenceName = "PSER_SEQ_TURNO", allocationSize = 1)
public class Turno implements Serializable {

	/**
	 * Serializacion de la entidad.
	 */
	private static final long serialVersionUID = 6080581545541788534L;

	/**
	 * Identificador para la Administración de Citas y Filas.
	 */
	@Id
	@Column(name = "ID_TURNO")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_TURNO")
	private Long id;

	/**
	 * Clave Única de Servicio (CUS).
	 */
	@Column(name = "NU_CUS")
	private String cus;

	/**
	 * La clave Única de Registro de Población.
	 */
	@Column(name = "CURP")
	private String curp;

	/**
	 * El Numero de Seguridad Social.
	 */
	@Column(name = "NSS")
	private String nss;

	/**
	 * Fecha y hora de la cita de la CUS.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_CITA_CUS")
	private Date fechaCitaCus;

	/**
	 * Nombre del cliente.
	 */
	@Column(name = "CH_NOMBRE_TRAB")
	private String nombreTrabajador;

	/**
	 * Apellido paterno del cliente.
	 */
	@Column(name = "CH_APELLIDO_PATERNO_TRAB")
	private String apellidoPaternoTrabajador;

	/**
	 * Apellido materno del cliente.
	 */
	@Column(name = "CH_APELLIDO_MATERNO_TRAB")
	private String apellidoMaternoTrabajador;

	/**
	 * Clave del servicio solicitado.
	 */
	@Column(name = "ID_SERVICIO")
	private Long idServicioSolicitado;

	/**
	 * Claves de los servicios realizados separados por coma.
	 */
	@Column(name = "CH_SERVICIOS_REALIZADOS")
	private String claveServiciosRealizados;

	/**
	 * Identificador del ejecutivo que realizo la atensión, corresponde al
	 * identificador del Usuario Pulssar.
	 */
	@JoinColumn(name = "ID_USUARIO_PULSSAR")
	@ManyToOne(fetch = FetchType.EAGER)
	private UsuarioPulssar usuario;
	
	/**
	 * Relación con el folio Pulssar.
	 */
	@JoinColumn(name = "ID_FOLIO_PULSSAR")
	@ManyToOne(fetch = FetchType.EAGER)
	private FolioPulssar folioPulssar;

	/**
	 * Folio de servicio iniciando con CCXXXX para trbajadores con cita y SC
	 * para trabajadore sin cita.
	 */
	@Column(name = "CH_FOLIO_SERVICIO")
	private String folioServicio;
	
	/**
	 * Folio de atención 
	 */
	@Column(name = "CH_FOLIO_ATENCION")
	private String folioAtencion;

	/**
	 * Indicador del cita. CC con cita, SC sin cita.
	 */
	@Column(name = "CH_INDICADOR_CITA")
	private String claveTipoCita;

	/**
	 * Clave para el estatus: 00 Cancelado, 01 Asistido
	 */
	@JoinColumn(name = "CV_TURNO_ESTATUS")
	@ManyToOne(fetch = FetchType.EAGER)
	private TurnoEstatus claveEstatus;

	/**
	 * Hora en la que se registra el cliente en la sucursal.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_REGISTRO")
	private Date fechaRegistro;

	/**
	 * Hora de inicio de atención.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_INICIO_ATENCION")
	private Date fechaInicioAtencion;

	/**
	 * Hora en la que finalizo su atención.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FC_FIN_ATENCION")
	private Date fechaFinAtencion;

	/**
	 * Fecha de ultima modificacion.
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaControl;

	/**
	 * Indicador de activo/inactivo
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * Correo del cliente.
	 */
	@Column(name = "CH_EMAIL")
	private String correo;
	
	/**
	 * Numero celular del cliente.
	 */
	@Column(name = "CH_CELULAR")
	private String celular;
	
	/**
	 * Clave de Afore.
	 */
	@Column(name = "CH_AFORE")
	private String claveAfore;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cus
	 */
	public String getCus() {
		return cus;
	}

	/**
	 * @param cus the cus to set
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the fechaCitaCus
	 */
	public Date getFechaCitaCus() {
		return fechaCitaCus;
	}

	/**
	 * @param fechaCitaCus the fechaCitaCus to set
	 */
	public void setFechaCitaCus(Date fechaCitaCus) {
		this.fechaCitaCus = fechaCitaCus;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the apellidoPaternoTrabajador
	 */
	public String getApellidoPaternoTrabajador() {
		return apellidoPaternoTrabajador;
	}

	/**
	 * @param apellidoPaternoTrabajador the apellidoPaternoTrabajador to set
	 */
	public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
		this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
	}

	/**
	 * @return the apellidoMaternoTrabajador
	 */
	public String getApellidoMaternoTrabajador() {
		return apellidoMaternoTrabajador;
	}

	/**
	 * @param apellidoMaternoTrabajador the apellidoMaternoTrabajador to set
	 */
	public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
		this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
	}

	/**
	 * @return the idServicioSolicitado
	 */
	public Long getIdServicioSolicitado() {
		return idServicioSolicitado;
	}

	/**
	 * @param idServicioSolicitado the idServicioSolicitado to set
	 */
	public void setIdServicioSolicitado(Long idServicioSolicitado) {
		this.idServicioSolicitado = idServicioSolicitado;
	}

	/**
	 * @return the claveServiciosRealizados
	 */
	public String getClaveServiciosRealizados() {
		return claveServiciosRealizados;
	}

	/**
	 * @param claveServiciosRealizados the claveServiciosRealizados to set
	 */
	public void setClaveServiciosRealizados(String claveServiciosRealizados) {
		this.claveServiciosRealizados = claveServiciosRealizados;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioPulssar getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioPulssar usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the folioPulssar
	 */
	public FolioPulssar getFolioPulssar() {
		return folioPulssar;
	}

	/**
	 * @param folioPulssar the folioPulssar to set
	 */
	public void setFolioPulssar(FolioPulssar folioPulssar) {
		this.folioPulssar = folioPulssar;
	}

	/**
	 * @return the folioServicio
	 */
	public String getFolioServicio() {
		return folioServicio;
	}

	/**
	 * @param folioServicio the folioServicio to set
	 */
	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}

	/**
	 * @return the folioAtencion
	 */
	public String getFolioAtencion() {
		return folioAtencion;
	}

	/**
	 * @param folioAtencion the folioAtencion to set
	 */
	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}

	/**
	 * @return the claveTipoCita
	 */
	public String getClaveTipoCita() {
		return claveTipoCita;
	}

	/**
	 * @param claveTipoCita the claveTipoCita to set
	 */
	public void setClaveTipoCita(String claveTipoCita) {
		this.claveTipoCita = claveTipoCita;
	}

	/**
	 * @return the claveEstatus
	 */
	public TurnoEstatus getClaveEstatus() {
		return claveEstatus;
	}

	/**
	 * @param claveEstatus the claveEstatus to set
	 */
	public void setClaveEstatus(TurnoEstatus claveEstatus) {
		this.claveEstatus = claveEstatus;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaInicioAtencion
	 */
	public Date getFechaInicioAtencion() {
		return fechaInicioAtencion;
	}

	/**
	 * @param fechaInicioAtencion the fechaInicioAtencion to set
	 */
	public void setFechaInicioAtencion(Date fechaInicioAtencion) {
		this.fechaInicioAtencion = fechaInicioAtencion;
	}

	/**
	 * @return the fechaFinAtencion
	 */
	public Date getFechaFinAtencion() {
		return fechaFinAtencion;
	}

	/**
	 * @param fechaFinAtencion the fechaFinAtencion to set
	 */
	public void setFechaFinAtencion(Date fechaFinAtencion) {
		this.fechaFinAtencion = fechaFinAtencion;
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

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
