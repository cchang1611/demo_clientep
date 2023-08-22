package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase DTO para la entidad TramiteComparadorInformacion
 * 
 * @author AKCANALE
 * @version 1.0
 * @param <T>
 */
public class TramiteComparadorInformacionGenerico<T> implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -5072666698961725572L;

	/**
	 * Identificador del Trámite
	 */
	private Long idTramiteCompInf;

	/**
	 * Clave del Tipo Asignación
	 */
	private String claveTipoAsignacion;

	/**
	 * Identificador del Servicio
	 */
	private Long idServicio;

	/**
	 * Clave del Tipo Prioridad
	 */
	private String claveTipoPrioridad;

	/**
	 * Clave Diagnóstico Trámite
	 */
	private String cvDiagnosticoTramite;

	/**
	 * Folio Procesar
	 */
	private String folioProcesar;

	/**
	 * Folio de Servicio Organización (AFORE)
	 */
	private String folioServicio;

	/**
	 * Fecha de Creación
	 */
	private Date fechaCreacion;

	/**
	 * Fecha de Solicitud
	 */
	private Date fechaSolicitud;

	/**
	 * Fecha de Envío de la Solicitud a Dictaminación
	 */
	private Date fechaEnvioSolicitudDictaminacion;

	/**
	 * Curp del Trabajador
	 */
	private String curp;

	/**
	 * Nss del Trabajador
	 */
	private String nss;

	/**
	 * RFC del Trabajador
	 */
	private String rfc;

	/**
	 * Nombre del Trabajador
	 */
	private String nombreTrabajador;

	/**
	 * Apellido Paterno del Trabajador
	 */
	private String apellidoPaterno;

	/**
	 * Apellido Materno delTrabajador
	 */
	private String apellidoMaterno;

	/**
	 * Fecha de Nacimiento del Trabajador
	 */
	private Date fechaNacimiento;

	/**
	 * Clave Nacionalidad del Trabajador
	 */
	private String claveNacionalidad;

	/**
	 * Entidad Federativa del Trabajador
	 */
	private String entidadFederativa;

	/**
	 * Género del Trabajador
	 */
	private String genero;

	/**
	 * Organización
	 */
	private String organizacion;

	/**
	 * Clave Tipo de Trabajador
	 */
	private String tipoTrabajador;

	/**
	 * Calve Tipo de Solicitud
	 */
	private String tipoSolicitud;

	/**
	 * Marca de Voz del Trabajador
	 */
	private String claveIdVoz;

	/**
	 * Marca Video del Trabajador
	 */
	private String claveIdVideo;

	/**
	 * Lugar de Firma del Trabajador
	 */
	private String claveLugarFirma;

	/**
	 * Fecha de Firma del Trabajador
	 */
	private Date fechaFirmaTrabajador;

	/**
	 * Clave Tipo Solicitante
	 */
	private String claveTipoSolicitante;

	/**
	 * Curp del Solicitante
	 */
	private String curpSolicitante;

	/**
	 * Sello de Verificación del Trabajador
	 */
	private String selloVerificacionTrab;

	/**
	 * Clave del Agente
	 */
	private String claveAgentePromotor;

	/**
	 * Curp del Agente
	 */
	private String curpAgentePromotor;

	/**
	 * Clave Ocupación del Trabajador
	 */
	private String claveOcupacion;

	/**
	 * Nivel Estudio del Trabajador
	 */
	private String nivelEstudio;

	/**
	 * Actividad Económica del Trabajador
	 */
	private String actividadEconomica;

	/**
	 * Clave Domicilio
	 */
	private Long claveDomicilio;

	/**
	 * Clave Beneficiario
	 */
	private Long claveBeneficiario;

	/**
	 * Fecha de Control
	 */
	private Date fechaControl;

	/**
	 * Usuario Modificador
	 */
	private String usuarioModificador;
	/**
	 * telefonoMovil
	 */
	private String telefonoMovil;
	/**
	 * telefonoFijo
	 */
	private String telefonoFijo;
	/**
	 * extension
	 */
	private String extension;
	/**
	 *correoElectronico
	 */
	private String correoElectronico;
	

	/**
	 * Estado del Trámite
	 */
	private String estadoTramite;

	/**
	 * Clave Servicicio
	 */
	private String claveServicio;
	
	/**
	 * Peticion solicitud comparador
	 */
	private T peticion;

	/**
	 * @return the idTramiteCompInf
	 */
	public Long getIdTramiteCompInf() {
		return idTramiteCompInf;
	}

	/**
	 * @param idTramiteCompInf
	 *            the idTramiteCompInf to set
	 */
	public void setIdTramiteCompInf(Long idTramiteCompInf) {
		this.idTramiteCompInf = idTramiteCompInf;
	}

	/**
	 * @return the claveTipoAsignacion
	 */
	public String getClaveTipoAsignacion() {
		return claveTipoAsignacion;
	}

	/**
	 * @param claveTipoAsignacion
	 *            the claveTipoAsignacion to set
	 */
	public void setClaveTipoAsignacion(String claveTipoAsignacion) {
		this.claveTipoAsignacion = claveTipoAsignacion;
	}

	/**
	 * @return the idServicio
	 */
	public Long getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio
	 *            the idServicio to set
	 */
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the claveTipoPrioridad
	 */
	public String getClaveTipoPrioridad() {
		return claveTipoPrioridad;
	}

	/**
	 * @param claveTipoPrioridad
	 *            the claveTipoPrioridad to set
	 */
	public void setClaveTipoPrioridad(String claveTipoPrioridad) {
		this.claveTipoPrioridad = claveTipoPrioridad;
	}

	
	public String getCvDiagnosticoTramite() {
		return cvDiagnosticoTramite;
	}

	public void setCvDiagnosticoTramite(String cvDiagnosticoTramite) {
		this.cvDiagnosticoTramite = cvDiagnosticoTramite;
	}

	/**
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar
	 *            the folioProcesar to set
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * @return the folioServicio
	 */
	public String getFolioServicio() {
		return folioServicio;
	}

	/**
	 * @param folioServicio
	 *            the folioServicio to set
	 */
	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud
	 *            the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the fechaEnvioSolicitudDictaminacion
	 */
	public Date getFechaEnvioSolicitudDictaminacion() {
		return fechaEnvioSolicitudDictaminacion;
	}

	/**
	 * @param fechaEnvioSolicitudDictaminacion
	 *            the fechaEnvioSolicitudDictaminacion to set
	 */
	public void setFechaEnvioSolicitudDictaminacion(Date fechaEnvioSolicitudDictaminacion) {
		this.fechaEnvioSolicitudDictaminacion = fechaEnvioSolicitudDictaminacion;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
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
	 * @param nss
	 *            the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador
	 *            the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the claveNacionalidad
	 */
	public String getClaveNacionalidad() {
		return claveNacionalidad;
	}

	/**
	 * @param claveNacionalidad
	 *            the claveNacionalidad to set
	 */
	public void setClaveNacionalidad(String claveNacionalidad) {
		this.claveNacionalidad = claveNacionalidad;
	}

	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa
	 *            the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the organizacion
	 */
	public String getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion
	 *            the organizacion to set
	 */
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	/**
	 * @return the tipoTrabajador
	 */
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	/**
	 * @param tipoTrabajador
	 *            the tipoTrabajador to set
	 */
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	/**
	 * @return the tipoSolicitud
	 */
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	/**
	 * @param tipoSolicitud
	 *            the tipoSolicitud to set
	 */
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	/**
	 * @return the claveIdVoz
	 */
	public String getClaveIdVoz() {
		return claveIdVoz;
	}

	/**
	 * @param claveIdVoz
	 *            the claveIdVoz to set
	 */
	public void setClaveIdVoz(String claveIdVoz) {
		this.claveIdVoz = claveIdVoz;
	}

	/**
	 * @return the claveIdVideo
	 */
	public String getClaveIdVideo() {
		return claveIdVideo;
	}

	/**
	 * @param claveIdVideo
	 *            the claveIdVideo to set
	 */
	public void setClaveIdVideo(String claveIdVideo) {
		this.claveIdVideo = claveIdVideo;
	}

	/**
	 * @return the claveLugarFirma
	 */
	public String getClaveLugarFirma() {
		return claveLugarFirma;
	}

	/**
	 * @param claveLugarFirma
	 *            the claveLugarFirma to set
	 */
	public void setClaveLugarFirma(String claveLugarFirma) {
		this.claveLugarFirma = claveLugarFirma;
	}

	/**
	 * @return the fechaFirmaTrabajador
	 */
	public Date getFechaFirmaTrabajador() {
		return fechaFirmaTrabajador;
	}

	/**
	 * @param fechaFirmaTrabajador
	 *            the fechaFirmaTrabajador to set
	 */
	public void setFechaFirmaTrabajador(Date fechaFirmaTrabajador) {
		this.fechaFirmaTrabajador = fechaFirmaTrabajador;
	}

	/**
	 * @return the claveTipoSolicitante
	 */
	public String getClaveTipoSolicitante() {
		return claveTipoSolicitante;
	}

	/**
	 * @param claveTipoSolicitante
	 *            the claveTipoSolicitante to set
	 */
	public void setClaveTipoSolicitante(String claveTipoSolicitante) {
		this.claveTipoSolicitante = claveTipoSolicitante;
	}

	/**
	 * @return the curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante
	 *            the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return the selloVerificacionTrab
	 */
	public String getSelloVerificacionTrab() {
		return selloVerificacionTrab;
	}

	/**
	 * @param selloVerificacionTrab
	 *            the selloVerificacionTrab to set
	 */
	public void setSelloVerificacionTrab(String selloVerificacionTrab) {
		this.selloVerificacionTrab = selloVerificacionTrab;
	}

	/**
	 * @return the claveAgentePromotor
	 */
	public String getClaveAgentePromotor() {
		return claveAgentePromotor;
	}

	/**
	 * @param claveAgentePromotor
	 *            the claveAgentePromotor to set
	 */
	public void setClaveAgentePromotor(String claveAgentePromotor) {
		this.claveAgentePromotor = claveAgentePromotor;
	}

	/**
	 * @return the curpAgentePromotor
	 */
	public String getCurpAgentePromotor() {
		return curpAgentePromotor;
	}

	/**
	 * @param curpAgentePromotor
	 *            the curpAgentePromotor to set
	 */
	public void setCurpAgentePromotor(String curpAgentePromotor) {
		this.curpAgentePromotor = curpAgentePromotor;
	}

	/**
	 * @return the claveOcupacion
	 */
	public String getClaveOcupacion() {
		return claveOcupacion;
	}

	/**
	 * @param claveOcupacion
	 *            the claveOcupacion to set
	 */
	public void setClaveOcupacion(String claveOcupacion) {
		this.claveOcupacion = claveOcupacion;
	}

	/**
	 * @return the nivelEstudio
	 */
	public String getNivelEstudio() {
		return nivelEstudio;
	}

	/**
	 * @param nivelEstudio
	 *            the nivelEstudio to set
	 */
	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	/**
	 * @return the actividadEconomica
	 */
	public String getActividadEconomica() {
		return actividadEconomica;
	}

	/**
	 * @param actividadEconomica
	 *            the actividadEconomica to set
	 */
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

	/**
	 * @return the claveDomicilio
	 */
	public Long getClaveDomicilio() {
		return claveDomicilio;
	}

	/**
	 * @param claveDomicilio
	 *            the claveDomicilio to set
	 */
	public void setClaveDomicilio(Long claveDomicilio) {
		this.claveDomicilio = claveDomicilio;
	}

	/**
	 * @return the claveBeneficiario
	 */
	public Long getClaveBeneficiario() {
		return claveBeneficiario;
	}

	/**
	 * @param claveBeneficiario
	 *            the claveBeneficiario to set
	 */
	public void setClaveBeneficiario(Long claveBeneficiario) {
		this.claveBeneficiario = claveBeneficiario;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            the fechaControl to set
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
	 * @param usuarioModificador
	 *            the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	/**
	 * 
	 * @param telefonoMovil
	 */
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	/**
	 * 
	 * @param telefonoFijo
	 */
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	/**
	 * 
	 * @return
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * 
	 * @param extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * 
	 * @return
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * 
	 * @param correoElectronico
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the estadoTramite
	 */
	public String getEstadoTramite() {
		return estadoTramite;
	}

	/**
	 * @param estadoTramite
	 *            the estadoTramite to set
	 */
	public void setEstadoTramite(String estadoTramite) {
		this.estadoTramite = estadoTramite;
	}

	/**
	 * @return the peticion
	 */
	public T getPeticion() {
		return peticion;
	}

	/**
	 * @param peticion the peticion to set
	 */
	public void setPeticion(T peticion) {
		this.peticion = peticion;
	}

	/**
	 * @return the claveServicio
	 */
	public String getClaveServicio() {
		return claveServicio;
	}

	/**
	 * @param claveServicio the claveServicio to set
	 */
	public void setClaveServicio(String claveServicio) {
		this.claveServicio = claveServicio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TramiteComparadorInformacionDTO [idTramiteCompInf=");
		builder.append(idTramiteCompInf);
		builder.append(", claveTipoAsignacion=");
		builder.append(claveTipoAsignacion);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", claveTipoPrioridad=");
		builder.append(claveTipoPrioridad);
		builder.append(", cvDiagnosticoTramite=");
		builder.append(cvDiagnosticoTramite);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", folioServicio=");
		builder.append(folioServicio);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", fechaEnvioSolicitudDictaminacion=");
		builder.append(fechaEnvioSolicitudDictaminacion);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", claveNacionalidad=");
		builder.append(claveNacionalidad);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", organizacion=");
		builder.append(organizacion);
		builder.append(", tipoTrabajador=");
		builder.append(tipoTrabajador);
		builder.append(", tipoSolicitud=");
		builder.append(tipoSolicitud);
		builder.append(", claveIdVoz=");
		builder.append(claveIdVoz);
		builder.append(", claveIdVideo=");
		builder.append(claveIdVideo);
		builder.append(", claveLugarFirma=");
		builder.append(claveLugarFirma);
		builder.append(", fechaFirmaTrabajador=");
		builder.append(fechaFirmaTrabajador);
		builder.append(", claveTipoSolicitante=");
		builder.append(claveTipoSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", selloVerificacionTrab=");
		builder.append(selloVerificacionTrab);
		builder.append(", claveAgentePromotor=");
		builder.append(claveAgentePromotor);
		builder.append(", curpAgentePromotor=");
		builder.append(curpAgentePromotor);
		builder.append(", claveOcupacion=");
		builder.append(claveOcupacion);
		builder.append(", nivelEstudio=");
		builder.append(nivelEstudio);
		builder.append(", actividadEconomica=");
		builder.append(actividadEconomica);
		builder.append(", claveDomicilio=");
		builder.append(claveDomicilio);
		builder.append(", claveBeneficiario=");
		builder.append(claveBeneficiario);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", telefonoMovil=");
		builder.append(telefonoMovil);
		builder.append(", telefonoFijo=");
		builder.append(telefonoFijo);
		builder.append(", extension=");
		builder.append(extension);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append(", estadoTramite=");
		builder.append(estadoTramite);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", peticion=");
		builder.append(peticion);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}