package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * MAtriz derecho proceso
 * @author RARREOLA
 *
 */
public class IretEstatusViviendaMarca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * llave primaria de la tabla
	 */
	
	private IretEstatusViviendaMarcaPK id;
	
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
	 * @return the id
	 */
	public IretEstatusViviendaMarcaPK getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(IretEstatusViviendaMarcaPK id) {
		this.id = id;
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
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}



	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
 

}
