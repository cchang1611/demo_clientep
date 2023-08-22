/**
 * ExpedienteRecertificacion.java
 * Fecha de creación: 21/05/2019, 11:22:33
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Mapeo entidad EXPE_TR_RECERTIFICACION
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 21/05/2019
 */
public class ExpedienteRecertificacion implements Serializable {


	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -904462959561444906L;

	/**
	 * campo Identificador De Recertificacion
	 */
	private Long id;

	/**
	 * campo Usuario de ultima modificacion
	 */
	private String chUsuarioModificador;

	/**
	 * campo Fecha de ultima modificacion
	 */
	private Date fcControl;

	/**
	 * campo Fecha fin de folio
	 */
	private Date fcFinRecertifiaccion;

	/**
	 * campo Fecha de inicio de folio
	 */
	private Date fcInicioRecertificacion;

	/**
	 * campo Fecha de solicitud
	 */
	private Date fcRegistro;

	/**
	 * campo Clave de promotor
	 */
	private Long idProcesarAgente;

	/**
	 * campo Identificador de trabajador
	 */
	private Long idProcesarPersona;

	/**
	 * campo identificador de tipo de contacto
	 */
	private Long idTipoContacto;

	/**
	 * campo Indica la recertificación vigente, 1 recertificacion vigente
	 */
	private Long nuEstatusRecertificacion;

	/**
	 * Identificador único de afore
	 */
	private Long idProcesarAforeSolicitud;

	/**
	 * Clave única del catálogo de lugar de firma
	 */
	private String cvLugarFirma;

	/**
	 * Fecha de vigenciaa de la solicitud del trabajdor.
	 */
	private Date fcVigenciaSolicitudRecertifi;

	/**
	 * Tipo de Trabajador 1 Trabajador IMSS 2 Trabajador Independiente/ISSTE
	 */
	private Integer nuTipoTrabajador;

	/**
	 * Folio de recertificación proporcionado por la administradora.
	 */
	private String chFolioServicio;
	
	/**
	 * curpTrabajador
	 */
	private String curpTrabajador;
	
	/**
	 * Afore
	 */
	private String claveAfore;

	/**
	 * Fecha inicio
	 */
	private String fechaInicio;


	/**
	 * Fecha Fin
	 */
	private String fechaFin;
	/**
	 * Constructor sin argumentos
	 */
	public ExpedienteRecertificacion(){
		/*constructor vacio*/
	}
	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * @return el atributo chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	
	/**
	 * @param chUsuarioModificador parametro chUsuarioModificador a actualizar
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	
	/**
	 * @return el atributo fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	
	/**
	 * @param fcControl parametro fcControl a actualizar
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	
	/**
	 * @return el atributo fcFinRecertifiaccion
	 */
	public Date getFcFinRecertifiaccion() {
		if(null != fcFinRecertifiaccion){
			
		}
		return fcFinRecertifiaccion;
	}

	
	/**
	 * @param fcFinRecertifiaccion parametro fcFinRecertifiaccion a actualizar
	 */
	public void setFcFinRecertifiaccion(Date fcFinRecertifiaccion) {
		this.fcFinRecertifiaccion = fcFinRecertifiaccion;
	}

	
	/**
	 * @return el atributo fcInicioRecertificacion
	 */
	public Date getFcInicioRecertificacion() {
		return fcInicioRecertificacion;
	}

	
	/**
	 * @param fcInicioRecertificacion parametro fcInicioRecertificacion a actualizar
	 */
	public void setFcInicioRecertificacion(Date fcInicioRecertificacion) {
		this.fcInicioRecertificacion = fcInicioRecertificacion;
	}

	
	/**
	 * @return el atributo fcRegistro
	 */
	public Date getFcRegistro() {
		return fcRegistro;
	}

	
	/**
	 * @param fcRegistro parametro fcRegistro a actualizar
	 */
	public void setFcRegistro(Date fcRegistro) {
		this.fcRegistro = fcRegistro;
	}

	
	/**
	 * @return el atributo idProcesarAgente
	 */
	public Long getIdProcesarAgente() {
		return idProcesarAgente;
	}

	
	/**
	 * @param idProcesarAgente parametro idProcesarAgente a actualizar
	 */
	public void setIdProcesarAgente(Long idProcesarAgente) {
		this.idProcesarAgente = idProcesarAgente;
	}

	
	/**
	 * @return el atributo idProcesarPersona
	 */
	public Long getIdProcesarPersona() {
		return idProcesarPersona;
	}
	
	
	/**
	 * @param idProcesarPersona parametro idProcesarPersona a actualizar
	 */
	public void setIdProcesarPersona(Long idProcesarPersona) {
		this.idProcesarPersona = idProcesarPersona;
	}


	/**
	 * @return el atributo idTipoContacto
	 */
	public Long getIdTipoContacto() {
		return idTipoContacto;
	}

	
	/**
	 * @param idTipoContacto parametro idTipoContacto a actualizar
	 */
	public void setIdTipoContacto(Long idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	
	/**
	 * @return el atributo nuEstatusRecertificacion
	 */
	public Long getNuEstatusRecertificacion() {
		return nuEstatusRecertificacion;
	}

	
	/**
	 * @param nuEstatusRecertificacion parametro nuEstatusRecertificacion a actualizar
	 */
	public void setNuEstatusRecertificacion(Long nuEstatusRecertificacion) {
		this.nuEstatusRecertificacion = nuEstatusRecertificacion;
	}

	
	/**
	 * @return el atributo idProcesarAforeSolicitud
	 */
	public Long getIdProcesarAforeSolicitud() {
		return idProcesarAforeSolicitud;
	}

	
	/**
	 * @param idProcesarAforeSolicitud parametro idProcesarAforeSolicitud a actualizar
	 */
	public void setIdProcesarAforeSolicitud(Long idProcesarAforeSolicitud) {
		this.idProcesarAforeSolicitud = idProcesarAforeSolicitud;
	}

	
	/**
	 * @return el atributo cvLugarFirma
	 */
	public String getCvLugarFirma() {
		return cvLugarFirma;
	}

	
	/**
	 * @param cvLugarFirma parametro cvLugarFirma a actualizar
	 */
	public void setCvLugarFirma(String cvLugarFirma) {
		this.cvLugarFirma = cvLugarFirma;
	}

	
	/**
	 * @return el atributo fcVigenciaSolicitudRecertifi
	 */
	public Date getFcVigenciaSolicitudRecertifi() {
		return fcVigenciaSolicitudRecertifi;
	}

	
	/**
	 * @param fcVigenciaSolicitudRecertifi parametro fcVigenciaSolicitudRecertifi a actualizar
	 */
	public void setFcVigenciaSolicitudRecertifi(Date fcVigenciaSolicitudRecertifi) {
		this.fcVigenciaSolicitudRecertifi = fcVigenciaSolicitudRecertifi;
	}

	
	/**
	 * @return el atributo nuTipoTrabajador
	 */
	public Integer getNuTipoTrabajador() {
		return nuTipoTrabajador;
	}

	
	/**
	 * @param nuTipoTrabajador parametro nuTipoTrabajador a actualizar
	 */
	public void setNuTipoTrabajador(Integer nuTipoTrabajador) {
		this.nuTipoTrabajador = nuTipoTrabajador;
	}

	
	/**
	 * @return el atributo chFolioServicio
	 */
	public String getChFolioServicio() {
		return chFolioServicio;
	}

	
	/**
	 * @param chFolioServicio parametro chFolioServicio a actualizar
	 */
	public void setChFolioServicio(String chFolioServicio) {
		this.chFolioServicio = chFolioServicio;
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
	/**
	 * @return el atributo curpTrabajador
	 */
	public String getCurpTrabajador() {
		return this.curpTrabajador;
	}
	/**
	 * @param curpTrabajador
	 *            parametro curpTrabajador a actualizar
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}
	/**
	 * @return el atributo fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio parametro fechaInicio a actualizar
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return el atributo fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin parametro fechaFin a actualizar
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpedienteRecertificacion [id=");
		builder.append(id);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", fcFinRecertifiaccion=");
		builder.append(fcFinRecertifiaccion);
		builder.append(", fcInicioRecertificacion=");
		builder.append(fcInicioRecertificacion);
		builder.append(", fcRegistro=");
		builder.append(fcRegistro);
		builder.append(", idProcesarAgente=");
		builder.append(idProcesarAgente);
		builder.append(", idProcesarPersona=");
		builder.append(idProcesarPersona);
		builder.append(", idTipoContacto=");
		builder.append(idTipoContacto);
		builder.append(", nuEstatusRecertificacion=");
		builder.append(nuEstatusRecertificacion);
		builder.append(", idProcesarAforeSolicitud=");
		builder.append(idProcesarAforeSolicitud);
		builder.append(", cvLugarFirma=");
		builder.append(cvLugarFirma);
		builder.append(", fcVigenciaSolicitudRecertifi=");
		builder.append(fcVigenciaSolicitudRecertifi);
		builder.append(", nuTipoTrabajador=");
		builder.append(nuTipoTrabajador);
		builder.append(", chFolioServicio=");
		builder.append(chFolioServicio);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append("]");
		return builder.toString();
	}

}
