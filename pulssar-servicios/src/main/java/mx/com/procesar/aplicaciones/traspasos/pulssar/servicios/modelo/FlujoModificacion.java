package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase para validaciones de flujo MDD
 * @author JMGUTIEG
 *
 */
public class FlujoModificacion implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 8806024741297351823L;
	
	/**
	 * bandera indicador enrolamiento
	 */
	private String banderaEnrolamiento;
	
	/**
	 * bandera respuesta enrolamiento
	 */
	private String banderaRespuestaEnrolamiento;
	
	/**
	 * folio enrolamiento
	 */
	private Folio folioEnrolamiento;
	
	/**
	 * bandera indicador identificacion
	 */
	private String banderaIdentificacion;
	
	/**
	 * bandera respuesta expe identificacion
	 */
	private String banderaRespuestaIdentificacion;
	
	/**
	 * folio enrolamiento
	 */
	private Folio folioIdentificacion;
	
	/**
	 * motivo rechazo
	 */
	private String motivoRechazo;
	
	/**
	 * bandera indicador sello trabajador
	 */
	private String banderaSelloTrabajador;
	
	/**
	 * bandera respuesta sello trabajador
	 */
	private String banderaRespuestaSelloTrabajador;
	
	/**
	 * folio enrolamiento
	 */
	private Folio folioSelloTrabajador;
	
	/**
	 * bandera indicador expe servicio
	 */
	private String banderaExpedienteServicio;
	
	/**
	 * bandera respuesta expe servicio
	 */
	private String banderaRespuestaExpedienteServicio;
	
	/**
	 * redireccion desde enrolamiento
	 */
	private String redireccionEnrolamiento;
	
	/**
	 * redireccion desde expe identificacion
	 */
	private String redireccionIdentificacion;
	
	/**
	 * redireccion desde sello trabajador
	 */
	private String redireccionSelloTrabajador;
	
	/**
	 * redireccion desde expe servicio
	 */
	private String redireccionExpeServicio;
	
	/**
	 * tipo afiliacion trabajador
	 */
	private String tipoAfiliacion;
	
	/**
	 * Bandera para saber existencia de biometrico
	 */
	private Integer banderaExistenciabiometrico;
	
	/**
	 * folio hijo de proceso origen
	 */
	private Long idFolioHijoPulssarOrigen;
	
	/**
	 * folio pulssar de tramite origen
	 */
	private String folioPulssarOrigen;
	
	/**
	 * bandera para representar entrada a expe bioemtrico o existencia
	 */
	private String banderaEntradaCurpBiometrico;
	
	/**
	 * bandera para representar entrada a expe identificaion o existencia
	 */
	private String banderaEntradaCurpIdentificacion;
	
	/**
	 * estatus de expediente de identificacion
	 */
	private String estatusExpeIdentificacion;
	
	/**
	 * clave afore expe identificacion
	 */
	private String cvAforExpeIdentificacion;
	
	/**
	 * estatus de expediente biometrico
	 */
	private String estatusExpeBiometrico;
	
	/**
	 * clave afore expediente biometrico
	 */
	private String cvAforeExpeBiometrico;
	
	/**
	 * respuesta
	 */
	private RespuestaServicio respuesta;

	/**
	 * @return the banderaEnrolamiento
	 */
	public String getBanderaEnrolamiento() {
		return banderaEnrolamiento;
	}

	/**
	 * @param banderaEnrolamiento the banderaEnrolamiento to set
	 */
	public void setBanderaEnrolamiento(String banderaEnrolamiento) {
		this.banderaEnrolamiento = banderaEnrolamiento;
	}

	/**
	 * @return the banderaRespuestaEnrolamiento
	 */
	public String getBanderaRespuestaEnrolamiento() {
		return banderaRespuestaEnrolamiento;
	}

	/**
	 * @param banderaRespuestaEnrolamiento the banderaRespuestaEnrolamiento to set
	 */
	public void setBanderaRespuestaEnrolamiento(String banderaRespuestaEnrolamiento) {
		this.banderaRespuestaEnrolamiento = banderaRespuestaEnrolamiento;
	}

	/**
	 * @return the folioEnrolamiento
	 */
	public Folio getFolioEnrolamiento() {
		return folioEnrolamiento;
	}

	/**
	 * @param folioEnrolamiento the folioEnrolamiento to set
	 */
	public void setFolioEnrolamiento(Folio folioEnrolamiento) {
		this.folioEnrolamiento = folioEnrolamiento;
	}

	/**
	 * @return the banderaIdentificacion
	 */
	public String getBanderaIdentificacion() {
		return banderaIdentificacion;
	}

	/**
	 * @param banderaIdentificacion the banderaIdentificacion to set
	 */
	public void setBanderaIdentificacion(String banderaIdentificacion) {
		this.banderaIdentificacion = banderaIdentificacion;
	}

	/**
	 * @return the banderaRespuestaIdentificacion
	 */
	public String getBanderaRespuestaIdentificacion() {
		return banderaRespuestaIdentificacion;
	}

	/**
	 * @param banderaRespuestaIdentificacion the banderaRespuestaIdentificacion to set
	 */
	public void setBanderaRespuestaIdentificacion(String banderaRespuestaIdentificacion) {
		this.banderaRespuestaIdentificacion = banderaRespuestaIdentificacion;
	}

	/**
	 * @return the folioIdentificacion
	 */
	public Folio getFolioIdentificacion() {
		return folioIdentificacion;
	}

	/**
	 * @param folioIdentificacion the folioIdentificacion to set
	 */
	public void setFolioIdentificacion(Folio folioIdentificacion) {
		this.folioIdentificacion = folioIdentificacion;
	}

	/**
	 * @return the banderaSelloTrabajador
	 */
	public String getBanderaSelloTrabajador() {
		return banderaSelloTrabajador;
	}

	/**
	 * @param banderaSelloTrabajador the banderaSelloTrabajador to set
	 */
	public void setBanderaSelloTrabajador(String banderaSelloTrabajador) {
		this.banderaSelloTrabajador = banderaSelloTrabajador;
	}

	/**
	 * @return the banderaRespuestaSelloTrabajador
	 */
	public String getBanderaRespuestaSelloTrabajador() {
		return banderaRespuestaSelloTrabajador;
	}

	/**
	 * @param banderaRespuestaSelloTrabajador the banderaRespuestaSelloTrabajador to set
	 */
	public void setBanderaRespuestaSelloTrabajador(String banderaRespuestaSelloTrabajador) {
		this.banderaRespuestaSelloTrabajador = banderaRespuestaSelloTrabajador;
	}

	/**
	 * @return the folioSelloTrabajador
	 */
	public Folio getFolioSelloTrabajador() {
		return folioSelloTrabajador;
	}

	/**
	 * @param folioSelloTrabajador the folioSelloTrabajador to set
	 */
	public void setFolioSelloTrabajador(Folio folioSelloTrabajador) {
		this.folioSelloTrabajador = folioSelloTrabajador;
	}

	/**
	 * @return the banderaExpedienteServicio
	 */
	public String getBanderaExpedienteServicio() {
		return banderaExpedienteServicio;
	}

	/**
	 * @param banderaExpedienteServicio the banderaExpedienteServicio to set
	 */
	public void setBanderaExpedienteServicio(String banderaExpedienteServicio) {
		this.banderaExpedienteServicio = banderaExpedienteServicio;
	}

	/**
	 * @return the banderaRespuestaExpedienteServicio
	 */
	public String getBanderaRespuestaExpedienteServicio() {
		return banderaRespuestaExpedienteServicio;
	}

	/**
	 * @param banderaRespuestaExpedienteServicio the banderaRespuestaExpedienteServicio to set
	 */
	public void setBanderaRespuestaExpedienteServicio(String banderaRespuestaExpedienteServicio) {
		this.banderaRespuestaExpedienteServicio = banderaRespuestaExpedienteServicio;
	}

	/**
	 * @return the redireccionEnrolamiento
	 */
	public String getRedireccionEnrolamiento() {
		return redireccionEnrolamiento;
	}

	/**
	 * @param redireccionEnrolamiento the redireccionEnrolamiento to set
	 */
	public void setRedireccionEnrolamiento(String redireccionEnrolamiento) {
		this.redireccionEnrolamiento = redireccionEnrolamiento;
	}

	/**
	 * @return the redireccionIdentificacion
	 */
	public String getRedireccionIdentificacion() {
		return redireccionIdentificacion;
	}

	/**
	 * @param redireccionIdentificacion the redireccionIdentificacion to set
	 */
	public void setRedireccionIdentificacion(String redireccionIdentificacion) {
		this.redireccionIdentificacion = redireccionIdentificacion;
	}

	/**
	 * @return the redireccionSelloTrabajador
	 */
	public String getRedireccionSelloTrabajador() {
		return redireccionSelloTrabajador;
	}

	/**
	 * @param redireccionSelloTrabajador the redireccionSelloTrabajador to set
	 */
	public void setRedireccionSelloTrabajador(String redireccionSelloTrabajador) {
		this.redireccionSelloTrabajador = redireccionSelloTrabajador;
	}

	/**
	 * @return the redireccionExpeServicio
	 */
	public String getRedireccionExpeServicio() {
		return redireccionExpeServicio;
	}

	/**
	 * @param redireccionExpeServicio the redireccionExpeServicio to set
	 */
	public void setRedireccionExpeServicio(String redireccionExpeServicio) {
		this.redireccionExpeServicio = redireccionExpeServicio;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the tipoAfiliacion
	 */
	public String getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	/**
	 * @param tipoAfiliacion the tipoAfiliacion to set
	 */
	public void setTipoAfiliacion(String tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	/**
	 * @return the banderaExistenciabiometrico
	 */
	public Integer getBanderaExistenciabiometrico() {
		return banderaExistenciabiometrico;
	}

	/**
	 * @param banderaExistenciabiometrico the banderaExistenciabiometrico to set
	 */
	public void setBanderaExistenciabiometrico(Integer banderaExistenciabiometrico) {
		this.banderaExistenciabiometrico = banderaExistenciabiometrico;
	}

	/**
	 * @return the idFolioHijoPulssarOrigen
	 */
	public Long getIdFolioHijoPulssarOrigen() {
		return idFolioHijoPulssarOrigen;
	}

	/**
	 * @param idFolioHijoPulssarOrigen the idFolioHijoPulssarOrigen to set
	 */
	public void setIdFolioHijoPulssarOrigen(Long idFolioHijoPulssarOrigen) {
		this.idFolioHijoPulssarOrigen = idFolioHijoPulssarOrigen;
	}

	/**
	 * @return the folioPulssarOrigen
	 */
	public String getFolioPulssarOrigen() {
		return folioPulssarOrigen;
	}

	/**
	 * @param folioPulssarOrigen the folioPulssarOrigen to set
	 */
	public void setFolioPulssarOrigen(String folioPulssarOrigen) {
		this.folioPulssarOrigen = folioPulssarOrigen;
	}

	/**
	 * @return the banderaEntradaCurpBiometrico
	 */
	public String getBanderaEntradaCurpBiometrico() {
		return banderaEntradaCurpBiometrico;
	}

	/**
	 * @param banderaEntradaCurpBiometrico the banderaEntradaCurpBiometrico to set
	 */
	public void setBanderaEntradaCurpBiometrico(String banderaEntradaCurpBiometrico) {
		this.banderaEntradaCurpBiometrico = banderaEntradaCurpBiometrico;
	}

	

	/**
	 * @return the banderaEntradaCurpIdentificacion
	 */
	public String getBanderaEntradaCurpIdentificacion() {
		return banderaEntradaCurpIdentificacion;
	}

	/**
	 * @param banderaEntradaCurpIdentificacion the banderaEntradaCurpIdentificacion to set
	 */
	public void setBanderaEntradaCurpIdentificacion(String banderaEntradaCurpIdentificacion) {
		this.banderaEntradaCurpIdentificacion = banderaEntradaCurpIdentificacion;
	}

	/**
	 * @return the estatusExpeIdentificacion
	 */
	public String getEstatusExpeIdentificacion() {
		return estatusExpeIdentificacion;
	}

	/**
	 * @param estatusExpeIdentificacion the estatusExpeIdentificacion to set
	 */
	public void setEstatusExpeIdentificacion(String estatusExpeIdentificacion) {
		this.estatusExpeIdentificacion = estatusExpeIdentificacion;
	}

	/**
	 * @return the estatusExpeBiometrico
	 */
	public String getEstatusExpeBiometrico() {
		return estatusExpeBiometrico;
	}

	/**
	 * @param estatusExpeBiometrico the estatusExpeBiometrico to set
	 */
	public void setEstatusExpeBiometrico(String estatusExpeBiometrico) {
		this.estatusExpeBiometrico = estatusExpeBiometrico;
	}

	/**
	 * @return the cvAforExpeIdentificacion
	 */
	public String getCvAforExpeIdentificacion() {
		return cvAforExpeIdentificacion;
	}

	/**
	 * @param cvAforExpeIdentificacion the cvAforExpeIdentificacion to set
	 */
	public void setCvAforExpeIdentificacion(String cvAforExpeIdentificacion) {
		this.cvAforExpeIdentificacion = cvAforExpeIdentificacion;
	}

	/**
	 * @return the cvAforeExpeBiometrico
	 */
	public String getCvAforeExpeBiometrico() {
		return cvAforeExpeBiometrico;
	}

	/**
	 * @param cvAforeExpeBiometrico the cvAforeExpeBiometrico to set
	 */
	public void setCvAforeExpeBiometrico(String cvAforeExpeBiometrico) {
		this.cvAforeExpeBiometrico = cvAforeExpeBiometrico;
	}

	/**
	 * @return the respuesta
	 */
	public RespuestaServicio getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(RespuestaServicio respuesta) {
		this.respuesta = respuesta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlujoModificacion [banderaEnrolamiento=");
		builder.append(banderaEnrolamiento);
		builder.append(", banderaRespuestaEnrolamiento=");
		builder.append(banderaRespuestaEnrolamiento);
		builder.append(", folioEnrolamiento=");
		builder.append(folioEnrolamiento);
		builder.append(", banderaIdentificacion=");
		builder.append(banderaIdentificacion);
		builder.append(", banderaRespuestaIdentificacion=");
		builder.append(banderaRespuestaIdentificacion);
		builder.append(", folioIdentificacion=");
		builder.append(folioIdentificacion);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", banderaSelloTrabajador=");
		builder.append(banderaSelloTrabajador);
		builder.append(", banderaRespuestaSelloTrabajador=");
		builder.append(banderaRespuestaSelloTrabajador);
		builder.append(", folioSelloTrabajador=");
		builder.append(folioSelloTrabajador);
		builder.append(", banderaExpedienteServicio=");
		builder.append(banderaExpedienteServicio);
		builder.append(", banderaRespuestaExpedienteServicio=");
		builder.append(banderaRespuestaExpedienteServicio);
		builder.append(", redireccionEnrolamiento=");
		builder.append(redireccionEnrolamiento);
		builder.append(", redireccionIdentificacion=");
		builder.append(redireccionIdentificacion);
		builder.append(", redireccionSelloTrabajador=");
		builder.append(redireccionSelloTrabajador);
		builder.append(", redireccionExpeServicio=");
		builder.append(redireccionExpeServicio);
		builder.append(", tipoAfiliacion=");
		builder.append(tipoAfiliacion);
		builder.append(", banderaExistenciabiometrico=");
		builder.append(banderaExistenciabiometrico);
		builder.append(", idFolioHijoPulssarOrigen=");
		builder.append(idFolioHijoPulssarOrigen);
		builder.append(", folioPulssarOrigen=");
		builder.append(folioPulssarOrigen);
		builder.append(", banderaEntradaCurpBiometrico=");
		builder.append(banderaEntradaCurpBiometrico);
		builder.append(", banderaEntradaCurpIdentificacion=");
		builder.append(banderaEntradaCurpIdentificacion);
		builder.append(", estatusExpeIdentificacion=");
		builder.append(estatusExpeIdentificacion);
		builder.append(", cvAforExpeIdentificacion=");
		builder.append(cvAforExpeIdentificacion);
		builder.append(", estatusExpeBiometrico=");
		builder.append(estatusExpeBiometrico);
		builder.append(", cvAforeExpeBiometrico=");
		builder.append(cvAforeExpeBiometrico);
		builder.append(", respuesta=");
		builder.append(respuesta);
		builder.append("]");
		return builder.toString();
	}
}
