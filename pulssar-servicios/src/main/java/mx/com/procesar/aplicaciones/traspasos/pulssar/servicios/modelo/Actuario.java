package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;



/**
 *  Mapeado a la tabla  RETI_TR_ACTUARIO
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 8, 2021
 */
public class Actuario implements Serializable{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -1061809857154988202L;
   
	/**
	 * cvActuario
	 */
   private String cvActuario;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * apPaterno
	 */
	private String apPaterno;
	
	/**
	 * apMaterno
	 */
	private String apMaterno;
	
	/**
	 * empresa
	 */
	private String empresa;

    /**
     * estado
     */
	private Integer estado;
	
	/**
	 * fechaInicioVigencia
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaInicioVigencia;
	
	/**
	 * fechaFinVigencia
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaFinVigencia;
	
	/**
	 * fechaControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
		
	/**
	 * usuarioModificacion
	 */
	private String usuarioModificacion;
	
	/**
	 * fechaRegistro
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaRegistro;

	/**
	 * @return el atributo cvActuario
	 */
	public String getCvActuario() {
		return cvActuario;
	}

	/**
	 * @param cvActuario parametro cvActuario a actualizar
	 */
	public void setCvActuario(String cvActuario) {
		this.cvActuario = cvActuario;
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * @param apPaterno parametro apPaterno a actualizar
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @return el atributo apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * @param apMaterno parametro apMaterno a actualizar
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @return el atributo empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa parametro empresa a actualizar
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return el atributo estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado parametro estado a actualizar
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	/**
	 * @return el atributo fechaInicioVigencia
	 */
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * @param fechaInicioVigencia parametro fechaInicioVigencia a actualizar
	 */
	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * @return el atributo fechaFinVigencia
	 */
	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * @param fechaFinVigencia parametro fechaFinVigencia a actualizar
	 */
	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion parametro usuarioModificacion a actualizar
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return el atributo fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro parametro fechaRegistro a actualizar
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actuario [cvActuario=");
		builder.append(cvActuario);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apPaterno=");
		builder.append(apPaterno);
		builder.append(", apMaterno=");
		builder.append(apMaterno);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", fechaInicioVigencia=");
		builder.append(fechaInicioVigencia);
		builder.append(", fechaFinVigencia=");
		builder.append(fechaFinVigencia);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificacion=");
		builder.append(usuarioModificacion);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append("]");
		return builder.toString();
	}
	
	
}
