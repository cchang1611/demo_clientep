package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author medoming
 *
 */
public class GiroNegocio implements Serializable {
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 3313639701696981692L;

	/**
	 * clave
	 */
	private String clave;

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
	 * fecha control
	 */
	private Date fechaControl;

	/**
	 * @return el atributo clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            parametro clave a actualizar
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo claveOld
	 */
	public String getClaveOld() {
		return claveOld;
	}

	/**
	 * @param claveOld
	 *            parametro claveOld a actualizar
	 */
	public void setClaveOld(String claveOld) {
		this.claveOld = claveOld;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
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
		cadena.append("GiroNegocio [clave=");
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
