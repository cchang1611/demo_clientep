/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * tipo de archivo recibido
 * @author jcgarces
 *
 */
public class CatalogoTipoArchivoRecibido implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -7230254041706979717L;
	
	/**
	 * id
	 */
	private String clave;
	
	/**
	 * descrpcion
	 */
	private String descripcion;
	
	/**
	 * fecha de control
	 */
	private List<String> fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the descripcion
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
	 * @return the fechaControl
	 */
	public List<String> getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(List<String> fechaControl) {
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
	 * @return the clave
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogoTipoArchivoRecibido [clave=");
		builder.append(clave);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
