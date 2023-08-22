package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * 
 *Tabla persistencia RETI_TC_SUBCUENTA
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 6, 2021
 */
@Entity
public class Subcuenta implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
   
	/**
	 * clave de la subcuenta
	 */
	private String clave;

	/**
	 * clasificacion
	 */
	private String clasificacion;

	/**
	 * descripcion
	 */
	private String descripcion;

	/**
	 * Clave de la subcuenta para afectación en saldos
	 */
	private String subcuentaSaldo;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * fecha de control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;

	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave parametro clave a actualizar
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return el atributo clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion parametro clasificacion a actualizar
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo subcuentaSaldo
	 */
	public String getSubcuentaSaldo() {
		return subcuentaSaldo;
	}

	/**
	 * @param subcuentaSaldo parametro subcuentaSaldo a actualizar
	 */
	public void setSubcuentaSaldo(String subcuentaSaldo) {
		this.subcuentaSaldo = subcuentaSaldo;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subcuenta [clave=");
		builder.append(clave);
		builder.append(", clasificacion=");
		builder.append(clasificacion);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", subcuentaSaldo=");
		builder.append(subcuentaSaldo);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}
	
	

	
    
	
}
