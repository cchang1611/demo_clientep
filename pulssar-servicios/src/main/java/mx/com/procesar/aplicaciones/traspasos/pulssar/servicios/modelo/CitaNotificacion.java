package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Se crea pojo de notificaiconCita
 * 
 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
 * @Date 23/10/2019
 * @version 1.0
 */
public class CitaNotificacion  implements Serializable {
	
	/**
	 * Serialzador
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 30, 2019
	 */
	private static final long serialVersionUID = 5054667806081946511L;


	/**
	 * Identificador único de la cita
	 */
	private Long idCita;	
	
	/**
	 *  Identificador de la cita en sw de Sidesys.
	 */
	private Long idCitaSW;
	
	/**
	 * Código de cita amigable para el usuario
	 */
	private String codigoCita;
	
	/**
	 * Identificador único de sucursal
	 */
	private String identificadorSucursal;
	
	/**
	 * Identificador único de servicio
	 */
	private String identificadorServicio;
	
	/**
	 * Fecha y hora de inicio de la cita en horario local de la sucursal
	 */
	private Date fechaInicio;
	
	/**
	 * Fecha y hora de fin de la cita en horario local de la sucursal
	 */
	private Date fechaFin;
	
	/**
	 * CURP
	 */
	private String curp;
	
	/**
	 * Número de identificación del trabajador.
	 */
	private String numeroIdentificacion;
	
	/**
	 * Estatus del envío (1=Enviado exitoso, 0=Enviado con error)
	 */
	private Long estatusEnvio;
	
	/**
	 * Codigo rechazo
	 */
	private String codigoError;
	
	/**
	 * Motivo rechazo
	 */
	private String detalleError;
	
	/**
	 * fecha control
	 */
	private Date fechaControl;
	
	/**
	 * usuario modificacion
	 */
	private String usuarioModificador;
	
	/**
	 * @return the idCita
	 */
	public Long getIdCita() {
		return idCita;
	}

	/**
	 * @param idCita the idCita to set
	 */
	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	/**
	 * @return the idCitaSW
	 */
	public Long getIdCitaSW() {
		return idCitaSW;
	}

	/**
	 * @param idCitaSW the idCitaSW to set
	 */
	public void setIdCitaSW(Long idCitaSW) {
		this.idCitaSW = idCitaSW;
	}

	/**
	 * @return the codigoCita
	 */
	public String getCodigoCita() {
		return codigoCita;
	}

	/**
	 * @param codigoCita the codigoCita to set
	 */
	public void setCodigoCita(String codigoCita) {
		this.codigoCita = codigoCita;
	}

	/**
	 * @return the identificadorSucursal
	 */
	public String getIdentificadorSucursal() {
		return identificadorSucursal;
	}

	/**
	 * @param identificadorSucursal the identificadorSucursal to set
	 */
	public void setIdentificadorSucursal(String identificadorSucursal) {
		this.identificadorSucursal = identificadorSucursal;
	}

	/**
	 * @return the identificadorServicio
	 */
	public String getIdentificadorServicio() {
		return identificadorServicio;
	}

	/**
	 * @param identificadorServicio the identificadorServicio to set
	 */
	public void setIdentificadorServicio(String identificadorServicio) {
		this.identificadorServicio = identificadorServicio;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * @return the estatusEnvio
	 */
	public Long getEstatusEnvio() {
		return estatusEnvio;
	}

	/**
	 * @param estatusEnvio the estatusEnvio to set
	 */
	public void setEstatusEnvio(Long estatusEnvio) {
		this.estatusEnvio = estatusEnvio;
	}

	/**
	 * @return the codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * @param codigoError the codigoError to set
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * @return the detalleError
	 */
	public String getDetalleError() {
		return detalleError;
	}

	/**
	 * @param detalleError the detalleError to set
	 */
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
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
	 * Imprime la información del objeto
	 * 
	 * @return cadenaEntrada
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EntradaCitasEsar ["); 
		if(idCita != null){
			cadena.append(" idCita=");
			cadena.append(idCita);
		}
		if(idCitaSW != null){
			cadena.append(", idCitaSW="); 
			cadena.append(idCitaSW);
		}
		if(codigoCita != null){
			cadena.append(", codigoCita="); 
			cadena.append(codigoCita);
		}
		if(identificadorSucursal != null){
			cadena.append(", identificadorSucursal="); 
			cadena.append(identificadorSucursal);
		}
		if(identificadorServicio != null){
			cadena.append(", identificadorServicio=");
			cadena.append(identificadorServicio); 
		}
		if(fechaInicio != null){
			cadena.append(", fechaInicio="); 
			cadena.append(fechaInicio); 
		}
		if(fechaFin != null){
			cadena.append(", fechaFin="); 
			cadena.append(fechaFin);
		}
		if(curp != null){
			cadena.append(", curp="); 
			cadena.append(curp);
		}
		if(numeroIdentificacion != null){
			cadena.append(", numeroIdentificacion="); 
			cadena.append(numeroIdentificacion);	
		}		
		cadena.append("]");

		return cadena.toString();
	}
}