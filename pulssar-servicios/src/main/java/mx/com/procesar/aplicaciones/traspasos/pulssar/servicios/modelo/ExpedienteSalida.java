package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Clase que contiene los atributos de la respuesta del servicio de expedientes
 * 
 * @author OJBALBUE
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ExpedienteSalida implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -8295464403996557996L;

	/**
	 * estatus Expediente Identificacion
	 */
	private String estatusExpedienteIdentificacion;

	/**
	 * Clave Expediente Identificacion
	 */
	private String claveExpedienteIdentificacion;

	/**
	 * tipo IDE
	 */
	private String tipoIDE;

	/**
	 * fecha IDE
	 */
	private XMLGregorianCalendar fechaIDE;

	/**
	 * fechaConformacion
	 */
	private Date fechaConformacion;

	/**
	 * expediente Movil
	 */
	private String expedienteMovil;

	/**
	 * estatus Enrolamiento
	 */
	private String estatusEnrolamiento;

	/**
	 * calidadHuellas
	 */
	private String calidadHuellas;

	/**
	 * fecha Enrolamiento
	 */
	private XMLGregorianCalendar fechaEnrolamiento;

	/**
	 * listaHuellas
	 */
	private List<CalidadHuellas> listaHuellas;

	/**
	 * Clave de la afore
	 */
	private String claveAforeExpBiometrico;

	/**
	 * Clave de la afore
	 */
	private String descAforeExpBiometrico;

	/**
	 * Clave de la afore
	 */
	private String claveAforeExpMovil;

	/**
	 * Clave de la afore
	 */
	private String descAforeExpMovil;

	/**
	 * Clave de la afore
	 */
	private String claveAforeExpIdentificacion;

	/**
	 * Clave de la afore
	 */
	private String descAforeExpIdentificacion;
	
	/**
	 * clave Tipo Proceso Exp Identificacion
	 */
	private String claveTipoProcesoExpIdentificacion;
	
	/**
	 * bandera que indica si la consulta se realizó desde una CURP
	 * historica
	 */
	private boolean curpHistoricaConsultada;

	/**
	 * curp que se uso para hacer la consulta del expediente
	 */
	private String curpConsultada;
	
	/**
	 * Rol
	 */
	private String rol;
	
	/**
	 * Rol Curp
	 */
	private String rolCurp;
	
	/**
	 * @return the estatusExpedienteIdentificacion
	 */
	public String getEstatusExpedienteIdentificacion() {
		return estatusExpedienteIdentificacion;
	}

	/**
	 * @param estatusExpedienteIdentificacion
	 *            the estatusExpedienteIdentificacion to set
	 */
	public void setEstatusExpedienteIdentificacion(String estatusExpedienteIdentificacion) {
		this.estatusExpedienteIdentificacion = estatusExpedienteIdentificacion;
	}

	/**
	 * @return el atributo claveExpedienteIdentificacion
	 */
	public String getClaveExpedienteIdentificacion() {
		return claveExpedienteIdentificacion;
	}

	/**
	 * @param claveExpedienteIdentificacion
	 *            parametro claveExpedienteIdentificacion a actualizar
	 */
	public void setClaveExpedienteIdentificacion(String claveExpedienteIdentificacion) {
		this.claveExpedienteIdentificacion = claveExpedienteIdentificacion;
	}

	/**
	 * @return the tipoIDE
	 */
	public String getTipoIDE() {
		return tipoIDE;
	}

	/**
	 * @param tipoIDE
	 *            the tipoIDE to set
	 */
	public void setTipoIDE(String tipoIDE) {
		this.tipoIDE = tipoIDE;
	}

	/**
	 * @return the fechaIDE
	 */
	public XMLGregorianCalendar getFechaIDE() {
		return fechaIDE;
	}

	/**
	 * @param fechaIDE
	 *            the fechaIDE to set
	 */
	public void setFechaIDE(XMLGregorianCalendar fechaIDE) {
		this.fechaIDE = fechaIDE;
	}

	/**
	 * @return the expedienteMovil
	 */
	public String getExpedienteMovil() {
		return expedienteMovil;
	}

	/**
	 * @param expedienteMovil
	 *            the expedienteMovil to set
	 */
	public void setExpedienteMovil(String expedienteMovil) {
		this.expedienteMovil = expedienteMovil;
	}

	/**
	 * @return the estatusEnrolamiento
	 */
	public String getEstatusEnrolamiento() {
		return estatusEnrolamiento;
	}

	/**
	 * @param estatusEnrolamiento
	 *            the estatusEnrolamiento to set
	 */
	public void setEstatusEnrolamiento(String estatusEnrolamiento) {
		this.estatusEnrolamiento = estatusEnrolamiento;
	}

	/**
	 * @return the fechaEnrolamiento
	 */
	public XMLGregorianCalendar getFechaEnrolamiento() {
		return fechaEnrolamiento;
	}

	/**
	 * @param fechaEnrolamiento
	 *            the fechaEnrolamiento to set
	 */
	public void setFechaEnrolamiento(XMLGregorianCalendar fechaEnrolamiento) {
		this.fechaEnrolamiento = fechaEnrolamiento;
	}

	/**
	 * @return the calidadHuellas
	 */
	public String getCalidadHuellas() {
		return calidadHuellas;
	}

	/**
	 * @param calidadHuellas
	 *            the calidadHuellas to set
	 */
	public void setCalidadHuellas(String calidadHuellas) {
		this.calidadHuellas = calidadHuellas;
	}

	/**
	 * @return el atributo listaHuellas
	 */
	public List<CalidadHuellas> getListaHuellas() {
		if (listaHuellas == null) {
			listaHuellas = new ArrayList<>();
		}
		return listaHuellas;
	}

	/**
	 * @param listaHuellas
	 *            parametro listaHuellas a actualizar
	 */
	public void setListaHuellas(List<CalidadHuellas> listaHuellas) {
		this.listaHuellas = listaHuellas;
	}

	/**
	 * @return el atributo claveAforeExpBiometrico
	 */
	public String getClaveAforeExpBiometrico() {
		return claveAforeExpBiometrico;
	}

	/**
	 * @param claveAforeExpBiometrico
	 *            parametro claveAforeExpBiometrico a actualizar
	 */
	public void setClaveAforeExpBiometrico(String claveAforeExpBiometrico) {
		this.claveAforeExpBiometrico = claveAforeExpBiometrico;
	}

	/**
	 * @return el atributo descAforeExpBiometrico
	 */
	public String getDescAforeExpBiometrico() {
		return descAforeExpBiometrico;
	}

	/**
	 * @param descAforeExpBiometrico
	 *            parametro descAforeExpBiometrico a actualizar
	 */
	public void setDescAforeExpBiometrico(String descAforeExpBiometrico) {
		this.descAforeExpBiometrico = descAforeExpBiometrico;
	}

	/**
	 * @return el atributo claveAforeExpMovil
	 */
	public String getClaveAforeExpMovil() {
		return claveAforeExpMovil;
	}

	/**
	 * @param claveAforeExpMovil
	 *            parametro claveAforeExpMovil a actualizar
	 */
	public void setClaveAforeExpMovil(String claveAforeExpMovil) {
		this.claveAforeExpMovil = claveAforeExpMovil;
	}

	/**
	 * @return el atributo descAforeExpMovil
	 */
	public String getDescAforeExpMovil() {
		return descAforeExpMovil;
	}

	/**
	 * @param descAforeExpMovil
	 *            parametro descAforeExpMovil a actualizar
	 */
	public void setDescAforeExpMovil(String descAforeExpMovil) {
		this.descAforeExpMovil = descAforeExpMovil;
	}

	/**
	 * @return el atributo claveAforeExpIdentificacion
	 */
	public String getClaveAforeExpIdentificacion() {
		return claveAforeExpIdentificacion;
	}

	/**
	 * @param claveAforeExpIdentificacion
	 *            parametro claveAforeExpIdentificacion a actualizar
	 */
	public void setClaveAforeExpIdentificacion(String claveAforeExpIdentificacion) {
		this.claveAforeExpIdentificacion = claveAforeExpIdentificacion;
	}

	/**
	 * @return el atributo descAforeExpIdentificacion
	 */
	public String getDescAforeExpIdentificacion() {
		return descAforeExpIdentificacion;
	}

	/**
	 * @param descAforeExpIdentificacion
	 *            parametro descAforeExpIdentificacion a actualizar
	 */
	public void setDescAforeExpIdentificacion(String descAforeExpIdentificacion) {
		this.descAforeExpIdentificacion = descAforeExpIdentificacion;
	}

	/**
	 * @return el atributo fechaConformacion
	 */
	public Date getFechaConformacion() {
		return fechaConformacion;
	}

	/**
	 * @param fechaConformacion
	 *            parametro fechaConformacion a actualizar
	 */
	public void setFechaConformacion(Date fechaConformacion) {
		this.fechaConformacion = fechaConformacion;
	}

	/**
	 * @return el atributo claveTipoProcesoExpIdentificacion
	 */
	public String getClaveTipoProcesoExpIdentificacion() {
		return claveTipoProcesoExpIdentificacion;
	}

	/**
	 * @param claveTipoProcesoExpIdentificacion parametro claveTipoProcesoExpIdentificacion a actualizar
	 */
	public void setClaveTipoProcesoExpIdentificacion(String claveTipoProcesoExpIdentificacion) {
		this.claveTipoProcesoExpIdentificacion = claveTipoProcesoExpIdentificacion;
	}
	
	/**
	 * @return el atributo curpHistoricaConsultada
	 */
	public boolean isCurpHistoricaConsultada() {
		return curpHistoricaConsultada;
	}

	/**
	 * @param curpHistoricaConsultada parametro curpHistoricaConsultada a actualizar
	 */
	public void setCurpHistoricaConsultada(boolean curpHistoricaConsultada) {
		this.curpHistoricaConsultada = curpHistoricaConsultada;
	}
	
	/**
	 * @return el atributo curpConsultada
	 */
	public String getCurpConsultada() {
		return curpConsultada;
	}

	/**
	 * @param curpConsultada parametro curpConsultada a actualizar
	 */
	public void setCurpConsultada(String curpConsultada) {
		this.curpConsultada = curpConsultada;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the rolCurp
	 */
	public String getRolCurp() {
		return rolCurp;
	}

	/**
	 * @param rolCurp the rolCurp to set
	 */
	public void setRolCurp(String rolCurp) {
		this.rolCurp = rolCurp;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpedienteSalida [estatusExpedienteIdentificacion=");
		builder.append(estatusExpedienteIdentificacion);
		builder.append(", claveExpedienteIdentificacion=");
		builder.append(claveExpedienteIdentificacion);
		builder.append(", tipoIDE=");
		builder.append(tipoIDE);
		builder.append(", fechaIDE=");
		builder.append(fechaIDE);
		builder.append(", fechaConformacion=");
		builder.append(fechaConformacion);
		builder.append(", expedienteMovil=");
		builder.append(expedienteMovil);
		builder.append(", estatusEnrolamiento=");
		builder.append(estatusEnrolamiento);
		builder.append(", calidadHuellas=");
		builder.append(calidadHuellas);
		builder.append(", fechaEnrolamiento=");
		builder.append(fechaEnrolamiento);
		builder.append(", listaHuellas=");
		builder.append(listaHuellas);
		builder.append(", claveAforeExpBiometrico=");
		builder.append(claveAforeExpBiometrico);
		builder.append(", descAforeExpBiometrico=");
		builder.append(descAforeExpBiometrico);
		builder.append(", claveAforeExpMovil=");
		builder.append(claveAforeExpMovil);
		builder.append(", descAforeExpMovil=");
		builder.append(descAforeExpMovil);
		builder.append(", claveAforeExpIdentificacion=");
		builder.append(claveAforeExpIdentificacion);
		builder.append(", descAforeExpIdentificacion=");
		builder.append(descAforeExpIdentificacion);
		builder.append(", claveTipoProcesoExpIdentificacion=");
		builder.append(claveTipoProcesoExpIdentificacion);
		builder.append(", curpHistoricaConsultada=");
		builder.append(curpHistoricaConsultada);
		builder.append(", curpConsultada=");
		builder.append(curpConsultada);
		builder.append(", rol=");
		builder.append(rol);
		builder.append(", rolCurp=");
		builder.append(rolCurp);	
		builder.append("]");
		return builder.toString();
	}

}
