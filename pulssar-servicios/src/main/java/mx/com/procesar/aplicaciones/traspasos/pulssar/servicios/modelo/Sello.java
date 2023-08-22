package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class Sello implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1012865273791469951L;

    /**
    * Clave de la AFORE
    */
    private String claveAfore;
    
    /**
    * Clave de entidad Participante.
    */
    private String claveEntidadParticipante;
    
    /**
    * Clave del Servicio asociado al Sello
    */
    private String claveServicio;
    
    /**
    * Clave del estatus del Sello
    */
    private String claveStatusSello;
    
    /**
    * CURP del Empleado
    */
    private String curpEmpleado;
    
    /**
    * CURP del Trabajador
    */
    private String curpTrabajador;
    
    /**
    * Fecha de Creación del Sello
    */
    private String fechaCreacionSello;
    
    /**
    * Fecha de última modificación del registro
    */
    private String fechaUltimaModificacion;
    
    /**
    * Fecha fin vigencia del Sello
    */
    private String fechaVigenciaFin;
    
    /**
    * Fecha inicio vigencia del Sello
    */
    private String fechaVigenciaInicio;
    
    /**
    * Identificador único del sello
    */
    private Long id;
    
    /**
    * Identificador del proceso de depuración
    */
    private String idDepuraSello;
    
    /**
    * entificador del lote, para sello batch
    */
    private String idLote;
    
    /**
    * Identificador de la Solicitud que genera el Sello
    */
    private String idSolicitud;
    
    /**
    * Indicador para conocer si el sello fue generado con una verificación biométrica.
    */
    private String tieneVerificacion;
    
    /**
    * Usuario que hizo la última modificación al registro.
    */
    private String usuarioModificador;

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
    * @return the claveEntidadParticipante
    */
    public String getClaveEntidadParticipante() {
                   return claveEntidadParticipante;
    }

    /**
    * @param claveEntidadParticipante the claveEntidadParticipante to set
    */
    public void setClaveEntidadParticipante(String claveEntidadParticipante) {
                   this.claveEntidadParticipante = claveEntidadParticipante;
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

    /**
    * @return the claveStatusSello
    */
    public String getClaveStatusSello() {
                   return claveStatusSello;
    }

    /**
    * @param claveStatusSello the claveStatusSello to set
    */
    public void setClaveStatusSello(String claveStatusSello) {
                   this.claveStatusSello = claveStatusSello;
    }

    /**
    * @return the curpEmpleado
    */
    public String getCurpEmpleado() {
                   return curpEmpleado;
    }

    /**
    * @param curpEmpleado the curpEmpleado to set
    */
    public void setCurpEmpleado(String curpEmpleado) {
                   this.curpEmpleado = curpEmpleado;
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
    * @return the fechaCreacionSello
    */
    public String getFechaCreacionSello() {
                   return fechaCreacionSello;
    }

    /**
    * @param fechaCreacionSello the fechaCreacionSello to set
    */
    public void setFechaCreacionSello(String fechaCreacionSello) {
                   this.fechaCreacionSello = fechaCreacionSello;
    }

    /**
    * @return the fechaUltimaModificacion
    */
    public String getFechaUltimaModificacion() {
                   return fechaUltimaModificacion;
    }

    /**
    * @param fechaUltimaModificacion the fechaUltimaModificacion to set
    */
    public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
                   this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    /**
    * @return the fechaVigenciaFin
    */
    public String getFechaVigenciaFin() {
                   return fechaVigenciaFin;
    }

    /**
    * @param fechaVigenciaFin the fechaVigenciaFin to set
    */
    public void setFechaVigenciaFin(String fechaVigenciaFin) {
                   this.fechaVigenciaFin = fechaVigenciaFin;
    }

    /**
    * @return the fechaVigenciaInicio
    */
    public String getFechaVigenciaInicio() {
                   return fechaVigenciaInicio;
    }

    /**
    * @param fechaVigenciaInicio the fechaVigenciaInicio to set
    */
    public void setFechaVigenciaInicio(String fechaVigenciaInicio) {
                   this.fechaVigenciaInicio = fechaVigenciaInicio;
    }

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
    * @return the idDepuraSello
    */
    public String getIdDepuraSello() {
                   return idDepuraSello;
    }

    /**
    * @param idDepuraSello the idDepuraSello to set
    */
    public void setIdDepuraSello(String idDepuraSello) {
                   this.idDepuraSello = idDepuraSello;
    }

    /**
    * @return the idLote
    */
    public String getIdLote() {
                   return idLote;
    }

    /**
    * @param idLote the idLote to set
    */
    public void setIdLote(String idLote) {
                   this.idLote = idLote;
    }

    /**
    * @return the idSolicitud
    */
    public String getIdSolicitud() {
                   return idSolicitud;
    }

    /**
    * @param idSolicitud the idSolicitud to set
    */
    public void setIdSolicitud(String idSolicitud) {
                   this.idSolicitud = idSolicitud;
    }

    /**
    * @return the tieneVerificacion
    */
    public String getTieneVerificacion() {
                   return tieneVerificacion;
    }

    /**
    * @param tieneVerificacion the tieneVerificacion to set
    */
    public void setTieneVerificacion(String tieneVerificacion) {
                   this.tieneVerificacion = tieneVerificacion;
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

    /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
                   StringBuilder builder = new StringBuilder();
                   builder.append("SelloSalida [claveAfore=");
                   builder.append(claveAfore);
                   builder.append(", claveEntidadParticipante=");
                   builder.append(claveEntidadParticipante);
                   builder.append(", claveServicio=");
                   builder.append(claveServicio);
                   builder.append(", claveStatusSello=");
                   builder.append(claveStatusSello);
                   builder.append(", curpEmpleado=");
                   builder.append(curpEmpleado);
                   builder.append(", curpTrabajador=");
                   builder.append(curpTrabajador);
                   builder.append(", fechaCreacionSello=");
                   builder.append(fechaCreacionSello);
                   builder.append(", fechaUltimaModificacion=");
                   builder.append(fechaUltimaModificacion);
                   builder.append(", fechaVigenciaFin=");
                   builder.append(fechaVigenciaFin);
                   builder.append(", fechaVigenciaInicio=");
                   builder.append(fechaVigenciaInicio);
                   builder.append(", id=");
                   builder.append(id);
                   builder.append(", idDepuraSello=");
                   builder.append(idDepuraSello);
                   builder.append(", idLote=");
                   builder.append(idLote);
                   builder.append(", idSolicitud=");
                   builder.append(idSolicitud);
                   builder.append(", tieneVerificacion=");
                   builder.append(tieneVerificacion);
                   builder.append(", usuarioModificador=");
                   builder.append(usuarioModificador);
                   builder.append("]");
                   return builder.toString();
    }
}