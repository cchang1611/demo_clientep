package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MEDOMING
 * @version 1.0
 */
public class GradoEstudios implements Serializable{

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -4063222546867775708L;
	
	/**
	 * clave
	 */
	private String clave;
	
	/**
	 * fecha control
	 */
	private Date fechaControl;
	
	/**
	 * descripcion
	 */
	private String descripcion;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	
	/**
	 * clave anterior
	 */
	private String claveOld;
	
	/**
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return fechaControl
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
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return usuarioModificador
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
	 * @return claveOld
	 */
	public String getClaveOld() {
		return claveOld;
	}

	/**
	 * @param claveOld the claveOld to set
	 */
	public void setClaveOld(String claveOld) {
		this.claveOld = claveOld;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("GradoEstudios [clave=");
		cadena.append(clave);
		cadena.append(", descripcion=");
		cadena.append(descripcion);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", claveOld=");
		cadena.append(claveOld);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append("]");

		return cadena.toString();
	}

}
