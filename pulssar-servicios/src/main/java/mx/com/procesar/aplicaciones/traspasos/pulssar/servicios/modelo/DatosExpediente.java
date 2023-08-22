package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;

/**
 * Objeto de Entrada, Datos del Agente para el servicio de  consulta
 * @author dbarbosa
 * @version 1.0
 */
public class DatosExpediente implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1095356588701394889L;

	/**
	 * estatus Expediente Identificacion
	 */
	private String estatusExpedienteIdentificacion;
	
	/**
	 * estatus Expediente Identificacion
	 */
	private String descEstatusExpedienteIdentificacion;
	
	/**
	 * Clave Afore expediente identifiacion
	 */
	private String aforeIdentificacion;
	
	/**
	 * Descripcion estatus expediente identifiacion
	 */
	private String descAforeIdentificacion;
	
	/**
	 * Clave de tipo proceso expe identificacion
	 */
	private String claveTipoProcesoExpIdentificacion;

	/**
	 * tipo IDE
	 */
	private String tipoIDE;

	/**
	 * fecha IDE
	 */
	private String fechaIDE;
	
	/**
	 * fecha IDE
	 */
	private String fechaConformacion;

	/**
	 * expediente Movil
	 */
	private String expedienteMovil;
	
	/**
	 * Clave Afore expediente movil
	 */
	private String aforeMovil;
	
	/**
	 * descripcion afore movil
	 */
	private String descAforeMovil;

	/**
	 * estatus Enrolamiento
	 */
	private String estatusEnrolamiento;
	
	/**
	 * descripcion estatus Enrolamiento
	 */
	private String descEstatusEnrolamiento;

	/**
	 * calidadHuellas
	 */
	private List<DatosHuellas> huellasTrabajador;
	
	/**
	 * fecha Enrolamiento
	 */
	private String fechaEnrolamiento;
	
	/**
	 * Clave Afore expediente enrolamiento
	 */
	private String aforeEnrolamiento;
	
	/**
	 * descripcion expediente enrolamiento
	 */
	private String descAforeEnrolamiento;
	
	/**
	 * estatus expediente identificacion
	 */
	private Integer banderaExpedienteIdentifiacion;
	
	/**
	 * estatus expediente enrolamiento
	 */
	private Integer banderaEnrolamiento;
	
	/**
	 * estatus expediente identificacion
	 */
	private Integer banderaCurpHistorica;
	
	/**
	 * estatus expediente enrolamiento
	 */
	private String curpHistorica;
	
	/**
	 * Imagen de Huellas
	 */
	private String imagenHuellas;
	
	/**
	 * Dedos con mejor calidad
	 */
	private List<String> dedosCalidad;
	
	/**
	 * porcentaje de similitud domicilio
	 */
	private String similitudDomicilio;
	
	/**
	 * porcentaje de similitud rostro
	 */
	private String similitudRostro;
	
	/**
	 * porcentaje de similitud nombre
	 */
	private String similitudNombre;
	
	/**
	 * Bandera para consultar nuevamente el expediente
	 */
	private boolean consultaExpediente;
	
	/**
	 * Bandera para consultar nuevamente el expediente
	 */
	private boolean consultaBiometrico;
	
	/**
	 * Curp Agente
	 */
	private String curpAgente;
	
	/**
	 * Curp trabajador
	 */
	private String curpTrabajador;
	
	/**
	 * Fecha Consulta
	 */
	private String fechaConsulta;
	
	/**
	 * Excepciones de huellas
	 */
	private String excepcion;
	
	/**
	 * Rol de curp
	 */
	private String rol;
	
	/**
	 * Descripcion rol
	 */
	private String descripcionRol;
	
	/**
	 * Dispositivo con que se tomo las huellas
	 */
	private String dispositivo;
	
	/**
	 * @return the estatusExpedienteIdentificacion
	 */
	public String getEstatusExpedienteIdentificacion() {
		return estatusExpedienteIdentificacion;
	}

	/**
	 * @param estatusExpedienteIdentificacion the estatusExpedienteIdentificacion to set
	 */
	public void setEstatusExpedienteIdentificacion(String estatusExpedienteIdentificacion) {
		this.estatusExpedienteIdentificacion = estatusExpedienteIdentificacion;
	}

	/**
	 * @return the descEstatusExpedienteIdentificacion
	 */
	public String getDescEstatusExpedienteIdentificacion() {
		return descEstatusExpedienteIdentificacion;
	}

	/**
	 * @param descEstatusExpedienteIdentificacion the descEstatusExpedienteIdentificacion to set
	 */
	public void setDescEstatusExpedienteIdentificacion(String descEstatusExpedienteIdentificacion) {
		this.descEstatusExpedienteIdentificacion = descEstatusExpedienteIdentificacion;
	}

	/**
	 * @return the aforeIdentificacion
	 */
	public String getAforeIdentificacion() {
		return aforeIdentificacion;
	}

	/**
	 * @param aforeIdentificacion the aforeIdentificacion to set
	 */
	public void setAforeIdentificacion(String aforeIdentificacion) {
		this.aforeIdentificacion = aforeIdentificacion;
	}

	/**
	 * @return the descAforeIdentificacion
	 */
	public String getDescAforeIdentificacion() {
		return descAforeIdentificacion;
	}

	/**
	 * @param descAforeIdentificacion the descAforeIdentificacion to set
	 */
	public void setDescAforeIdentificacion(String descAforeIdentificacion) {
		this.descAforeIdentificacion = descAforeIdentificacion;
	}

	/**
	 * @return the tipoIDE
	 */
	public String getTipoIDE() {
		return tipoIDE;
	}

	/**
	 * @param tipoIDE the tipoIDE to set
	 */
	public void setTipoIDE(String tipoIDE) {
		this.tipoIDE = tipoIDE;
	}

	/**
	 * @return the fechaIDE
	 */
	public String getFechaIDE() {
		return fechaIDE;
	}

	/**
	 * @param fechaIDE the fechaIDE to set
	 */
	public void setFechaIDE(String fechaIDE) {
		this.fechaIDE = fechaIDE;
	}

	/**
	 * @return the fechaConformacion
	 */
	public String getFechaConformacion() {
		return fechaConformacion;
	}

	/**
	 * @param fechaConformacion the fechaConformacion to set
	 */
	public void setFechaConformacion(String fechaConformacion) {
		this.fechaConformacion = fechaConformacion;
	}

	/**
	 * @return the expedienteMovil
	 */
	public String getExpedienteMovil() {
		return expedienteMovil;
	}

	/**
	 * @param expedienteMovil the expedienteMovil to set
	 */
	public void setExpedienteMovil(String expedienteMovil) {
		this.expedienteMovil = expedienteMovil;
	}

	/**
	 * @return the aforeMovil
	 */
	public String getAforeMovil() {
		return aforeMovil;
	}

	/**
	 * @param aforeMovil the aforeMovil to set
	 */
	public void setAforeMovil(String aforeMovil) {
		this.aforeMovil = aforeMovil;
	}

	/**
	 * @return the descAforeMovil
	 */
	public String getDescAforeMovil() {
		return descAforeMovil;
	}

	/**
	 * @param descAforeMovil the descAforeMovil to set
	 */
	public void setDescAforeMovil(String descAforeMovil) {
		this.descAforeMovil = descAforeMovil;
	}

	/**
	 * @return the estatusEnrolamiento
	 */
	public String getEstatusEnrolamiento() {
		return estatusEnrolamiento;
	}

	/**
	 * @param estatusEnrolamiento the estatusEnrolamiento to set
	 */
	public void setEstatusEnrolamiento(String estatusEnrolamiento) {
		this.estatusEnrolamiento = estatusEnrolamiento;
	}

	/**
	 * @return the descEstatusEnrolamiento
	 */
	public String getDescEstatusEnrolamiento() {
		return descEstatusEnrolamiento;
	}

	/**
	 * @param descEstatusEnrolamiento the descEstatusEnrolamiento to set
	 */
	public void setDescEstatusEnrolamiento(String descEstatusEnrolamiento) {
		this.descEstatusEnrolamiento = descEstatusEnrolamiento;
	}
	
	/**
	 * @return the huellasTrabajador
	 */
	public List<DatosHuellas> getHuellasTrabajador() {
		return huellasTrabajador;
	}

	/**
	 * @param huellasTrabajador the huellasTrabajador to set
	 */
	public void setHuellasTrabajador(List<DatosHuellas> huellasTrabajador) {
		this.huellasTrabajador = huellasTrabajador;
	}

	/**
	 * @return the fechaEnrolamiento
	 */
	public String getFechaEnrolamiento() {
		return fechaEnrolamiento;
	}

	/**
	 * @param fechaEnrolamiento the fechaEnrolamiento to set
	 */
	public void setFechaEnrolamiento(String fechaEnrolamiento) {
		this.fechaEnrolamiento = fechaEnrolamiento;
	}

	/**
	 * @return the aforeEnrolamiento
	 */
	public String getAforeEnrolamiento() {
		return aforeEnrolamiento;
	}

	/**
	 * @param aforeEnrolamiento the aforeEnrolamiento to set
	 */
	public void setAforeEnrolamiento(String aforeEnrolamiento) {
		this.aforeEnrolamiento = aforeEnrolamiento;
	}

	/**
	 * @return the descAforeEnrolamiento
	 */
	public String getDescAforeEnrolamiento() {
		return descAforeEnrolamiento;
	}

	/**
	 * @param descAforeEnrolamiento the descAforeEnrolamiento to set
	 */
	public void setDescAforeEnrolamiento(String descAforeEnrolamiento) {
		this.descAforeEnrolamiento = descAforeEnrolamiento;
	}

	/**
	 * @return the banderaExpedienteIdentifiacion
	 */
	public Integer getBanderaExpedienteIdentifiacion() {
		return banderaExpedienteIdentifiacion;
	}

	/**
	 * @param banderaExpedienteIdentifiacion the banderaExpedienteIdentifiacion to set
	 */
	public void setBanderaExpedienteIdentifiacion(Integer banderaExpedienteIdentifiacion) {
		this.banderaExpedienteIdentifiacion = banderaExpedienteIdentifiacion;
	}

	/**
	 * @return the banderaEnrolamiento
	 */
	public Integer getBanderaEnrolamiento() {
		return banderaEnrolamiento;
	}

	/**
	 * @param banderaEnrolamiento the banderaEnrolamiento to set
	 */
	public void setBanderaEnrolamiento(Integer banderaEnrolamiento) {
		this.banderaEnrolamiento = banderaEnrolamiento;
	}

	/**
	 * @return the claveTipoProcesoExpIdentificacion
	 */
	public String getClaveTipoProcesoExpIdentificacion() {
		return claveTipoProcesoExpIdentificacion;
	}

	/**
	 * @param claveTipoProcesoExpIdentificacion the claveTipoProcesoExpIdentificacion to set
	 */
	public void setClaveTipoProcesoExpIdentificacion(String claveTipoProcesoExpIdentificacion) {
		this.claveTipoProcesoExpIdentificacion = claveTipoProcesoExpIdentificacion;
	}
	
	/**
	 * @return the banderaCurpHistorica
	 */
	public Integer getBanderaCurpHistorica() {
		return banderaCurpHistorica;
	}

	/**
	 * @param banderaCurpHistorica the banderaCurpHistorica to set
	 */
	public void setBanderaCurpHistorica(Integer banderaCurpHistorica) {
		this.banderaCurpHistorica = banderaCurpHistorica;
	}

	/**
	 * @return the curpHistorica
	 */
	public String getCurpHistorica() {
		return curpHistorica;
	}

	/**
	 * @param curpHistorica the curpHistorica to set
	 */
	public void setCurpHistorica(String curpHistorica) {
		this.curpHistorica = curpHistorica;
	}

	/**
	 * @return the imagenHuellas
	 */
	public String getImagenHuellas() {
		return imagenHuellas;
	}

	/**
	 * @param imagenHuellas the imagenHuellas to set
	 */
	public void setImagenHuellas(String imagenHuellas) {
		this.imagenHuellas = imagenHuellas;
	}

	/**
	 * @return the dedosCalidad
	 */
	public List<String> getDedosCalidad() {
		return dedosCalidad;
	}

	/**
	 * @param dedosCalidad the dedosCalidad to set
	 */
	public void setDedosCalidad(List<String> dedosCalidad) {
		this.dedosCalidad = dedosCalidad;
	}

	/**
	 * @return the similitudDomicilio
	 */
	public String getSimilitudDomicilio() {
		return similitudDomicilio;
	}

	/**
	 * @param similitudDomicilio the similitudDomicilio to set
	 */
	public void setSimilitudDomicilio(String similitudDomicilio) {
		this.similitudDomicilio = similitudDomicilio;
	}

	/**
	 * @return the similitudRostro
	 */
	public String getSimilitudRostro() {
		return similitudRostro;
	}

	/**
	 * @param similitudRostro the similitudRostro to set
	 */
	public void setSimilitudRostro(String similitudRostro) {
		this.similitudRostro = similitudRostro;
	}

	/**
	 * @return the similitudNombre
	 */
	public String getSimilitudNombre() {
		return similitudNombre;
	}

	/**
	 * @param similitudNombre the similitudNombre to set
	 */
	public void setSimilitudNombre(String similitudNombre) {
		this.similitudNombre = similitudNombre;
	}

	/**
	 * @return the consultaExpediente
	 */
	public boolean isConsultaExpediente() {
		return consultaExpediente;
	}

	/**
	 * @param consultaExpediente the consultaExpediente to set
	 */
	public void setConsultaExpediente(boolean consultaExpediente) {
		this.consultaExpediente = consultaExpediente;
	}

	/**
	 * @return the consultaBiometrico
	 */
	public boolean isConsultaBiometrico() {
		return consultaBiometrico;
	}

	/**
	 * @param consultaBiometrico the consultaBiometrico to set
	 */
	public void setConsultaBiometrico(boolean consultaBiometrico) {
		this.consultaBiometrico = consultaBiometrico;
	}

	/**
	 * @return the curpAgente
	 */
	public String getCurpAgente() {
		return curpAgente;
	}

	/**
	 * @param curpAgente the curpAgente to set
	 */
	public void setCurpAgente(String curpAgente) {
		this.curpAgente = curpAgente;
	}

	/**
	 * @return the curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return the fechaConsulta
	 */
	public String getFechaConsulta() {
		return fechaConsulta;
	}

	/**
	 * @param fechaConsulta the fechaConsulta to set
	 */
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	/**
	 * @return the excepcion
	 */
	public String getExcepcion() {
		return excepcion;
	}

	/**
	 * @param excepcion the excepcion to set
	 */
	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
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
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	/**
	 * @return the dispositivo
	 */
	public String getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosExpediente [estatusExpedienteIdentificacion=");
		builder.append(estatusExpedienteIdentificacion);
		builder.append(", descEstatusExpedienteIdentificacion=");
		builder.append(descEstatusExpedienteIdentificacion);
		builder.append(", aforeIdentificacion=");
		builder.append(aforeIdentificacion);
		builder.append(", descAforeIdentificacion=");
		builder.append(descAforeIdentificacion);
		builder.append(", tipoIDE=");
		builder.append(tipoIDE);
		builder.append(", fechaIDE=");
		builder.append(fechaIDE);
		builder.append(", fechaConformacion=");
		builder.append(fechaConformacion);
		builder.append(", expedienteMovil=");
		builder.append(expedienteMovil);
		builder.append(", aforeMovil=");
		builder.append(aforeMovil);
		builder.append(", descAforeMovil=");
		builder.append(descAforeMovil);
		builder.append(", estatusEnrolamiento=");
		builder.append(estatusEnrolamiento);
		builder.append(", descEstatusEnrolamiento=");
		builder.append(descEstatusEnrolamiento);
		builder.append(", huellasTrabajador=");
		builder.append(huellasTrabajador);
		builder.append(", fechaEnrolamiento=");
		builder.append(fechaEnrolamiento);
		builder.append(", aforeEnrolamiento=");
		builder.append(aforeEnrolamiento);
		builder.append(", descAforeEnrolamiento=");
		builder.append(descAforeEnrolamiento);
		builder.append(", banderaExpedienteIdentifiacion=");
		builder.append(banderaExpedienteIdentifiacion);
		builder.append(", banderaEnrolamiento=");
		builder.append(banderaEnrolamiento);
		builder.append(", banderaCurpHistorica=");
		builder.append(banderaCurpHistorica);
		builder.append(", curpHistorica=");
		builder.append(curpHistorica);
		builder.append(", imagenHuellas=");
		builder.append(imagenHuellas);
		builder.append(", dedosCalidad=");
		builder.append(dedosCalidad);
		builder.append(", similitudDomicilio=");
		builder.append(similitudDomicilio);
		builder.append(", similitudRostro=");
		builder.append(similitudRostro);
		builder.append(", similitudNombre=");
		builder.append(similitudNombre);
		builder.append(", consultaExpediente=");
		builder.append(consultaExpediente);
		builder.append(", consultaBiometrico=");
		builder.append(consultaBiometrico);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", curpAgente=");
		builder.append(curpAgente);
		builder.append(", fechaConsulta=");
		builder.append(fechaConsulta);
		builder.append(", excepcion=");
		builder.append(excepcion);
		builder.append(", rol=");
		builder.append(rol);
		builder.append(", descripcionRol=");
		builder.append(descripcionRol);
		builder.append(", dispositivo=");
		builder.append(dispositivo);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * @return the rolCurp
	 */
	public String getRolCurp() {
		StringBuilder auxiliarBuil = new StringBuilder();
		auxiliarBuil.append(rol);
		auxiliarBuil.append(ExpresionesConstants.ESPACIO);
		auxiliarBuil.append(descripcionRol);
		
		String auxiliar = auxiliarBuil.toString();
		String cadena = "";
		if(auxiliar != null && !auxiliar.trim().equals("")) {
			cadena = auxiliar.trim();
		}
		return cadena;
	}
}