package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 
 * Clase para guardar la informacion del reporte para reporteria
 * 
 * @author EHLUNARA
 *
 */
public class ReporteriaInformacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -521332447402458000L;
	
	/**
	 * Fecha 
	 */
	private String fecha;
	
	/**
	 * Curp Cliente
	 */
	private String curpCliente;
	
	/**
	 * Nombre completo del cliente
	 */
	private String nombreCompleto;
	
	/**
	 * Indicador de la cita 
	 */
	private String indicadorCita;
	
	/**
	 * La cus
	 */
	private String cus;
	
	/**
	 * Estatus de la cita
	 */
	private String estatusCita;

	/**
	 * Turno Asignado
	 */
	private String turnoAsignado;
	
	/**
	 * Estatus del turno
	 */
	private String estatusTurno;
	
	/**
	 * Servicio Solicitado
	 */
	private String servicioSolicitado;
	
	/**
	 * Hora de llegada
	 */
	private String horaLlegada;
	
	/**
	 * Hora de incio de atencion
	 */
	private String horaInicioAtencion;
	
	/**
	 * Hora Fin de la  atencion
	 */
	private String horaFinAtencion;
	
	/**
	 * Tiempo de espera  (Hora de atencion- Hora de llegada)
	 */
	private String tiempoEspera;
	
	/**
	 * Tiempo de Atencion ((Hora fin de Atención- Hora llegada))
	 */
	private String tiempoAtencion;
	
	/**
	 * Numero del ejecutivo que atendio
	 */
	private BigDecimal numeroEjecutivo;
	
	/**
	 * Nombre del CARE donde Asisto
	 */
	private String nombreCareAsistio;
	
	/**
	 * Numero del CARE donde asistio
	 */
	private String numeroCare;
	
	/**
	 * Numero de Tramites que realizo
	 */
	private Integer numeroTramites;	
	
	/**
	 * folio de atencion
	 */
	private String folioAtencion;
	
	
	/**
	 * Nombre del Ejecutivo
	 */
	private String nombreUsuario;
	


	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the curpCliente
	 */
	public String getCurpCliente() {
		return curpCliente;
	}

	/**
	 * @param curpCliente the curpClietne to set
	 */
	public void setCurpCliente(String curpCliente) {
		this.curpCliente = curpCliente;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the indicadorCita
	 */
	public String getIndicadorCita() {
		return indicadorCita;
	}

	/**
	 * @param indicadorCita the indicadorCita to set
	 */
	public void setIndicadorCita(String indicadorCita) {
		this.indicadorCita = indicadorCita;
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
	 * @return the estatusCita
	 */
	public String getEstatusCita() {
		return estatusCita;
	}

	/**
	 * @param estatusCita the estatusCita to set
	 */
	public void setEstatusCita(String estatusCita) {
		this.estatusCita = estatusCita;
	}

	/**
	 * @return the turnoAsignado
	 */
	public String getTurnoAsignado() {
		return turnoAsignado;
	}

	/**
	 * @param turnoAsignado the turnoAsignado to set
	 */
	public void setTurnoAsignado(String turnoAsignado) {
		this.turnoAsignado = turnoAsignado;
	}

	/**
	 * @return the estatusTurno
	 */
	public String getEstatusTurno() {
		return estatusTurno;
	}

	/**
	 * @param estatusTurno the estatusTurno to set
	 */
	public void setEstatusTurno(String estatusTurno) {
		this.estatusTurno = estatusTurno;
	}

	/**
	 * @return the servicioSolicitado
	 */
	public String getServicioSolicitado() {
		return servicioSolicitado;
	}

	/**
	 * @param servicioSolicitado the servicioSolicitado to set
	 */
	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}

	/**
	 * @return the horaLlegada
	 */
	public String getHoraLlegada() {
		return horaLlegada;
	}

	/**
	 * @param horaLlegada the horaLlegada to set
	 */
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	/**
	 * @return the horaInicioAtencion
	 */
	public String getHoraInicioAtencion() {
		return horaInicioAtencion;
	}

	/**
	 * @param horaInicioAtencion the horaInicioAtencion to set
	 */
	public void setHoraInicioAtencion(String horaInicioAtencion) {
		this.horaInicioAtencion = horaInicioAtencion;
	}

	/**
	 * @return the horaFinAtencion
	 */
	public String getHoraFinAtencion() {
		return horaFinAtencion;
	}

	/**
	 * @param horaFinAtencion the horaFinAtencion to set
	 */
	public void setHoraFinAtencion(String horaFinAtencion) {
		this.horaFinAtencion = horaFinAtencion;
	}

	/**
	 * @return the tiempoEspera
	 */
	public String getTiempoEspera() {
		return tiempoEspera;
	}

	/**
	 * @param TiempoEspera the tiempoEspera to set
	 */
	public void setTiempoEspera(String tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	/**
	 * @return the tiempoAtencion
	 */
	public String getTiempoAtencion() {
		return tiempoAtencion;
	}

	/**
	 * @param tiempoAtencion the tiempoAtencion to set
	 */
	public void setTiempoAtencion(String tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	/**
	 * @return the numeroEjecutivo
	 */
	public BigDecimal getNumeroEjecutivo() {
		return numeroEjecutivo;
	}

	/**
	 * @param numeroEjecutivo the numeroEjecutivo to set
	 */
	public void setNumeroEjecutivo(BigDecimal numeroEjecutivo) {
		this.numeroEjecutivo = numeroEjecutivo;
	}

	/**
	 * @return the nombreCareAsistio
	 */
	public String getNombreCareAsistio() {
		return nombreCareAsistio;
	}

	/**
	 * @param nombreCareAsistop the nombreCareAsistio to set
	 */
	public void setNombreCareAsistio(String nombreCareAsistio) {
		this.nombreCareAsistio = nombreCareAsistio;
	}

	/**
	 * @return the numeroCare
	 */
	public String getNumeroCare() {
		return numeroCare;
	}

	/**
	 * @param numeroCare the numeroCare to set
	 */
	public void setNumeroCare(String numeroCare) {
		this.numeroCare = numeroCare;
	}

	/**
	 * @return the numeroTramites
	 */
	public Integer getNumeroTramites() {
		return numeroTramites;
	}

	/**
	 * @param numeroTramitres the numeroTramites to set
	 */
	public void setNumeroTramites(Integer numeroTramites) {
		this.numeroTramites = numeroTramites;
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
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
