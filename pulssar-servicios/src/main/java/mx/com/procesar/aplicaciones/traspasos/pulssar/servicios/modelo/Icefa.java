package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de obtener la descripcion de la icefa
 * 
 * @author DBARBOSA
 *
 */
public class Icefa implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 7577670949996796110L;

	/**
	 * clave icefa
	 */

	private String claveIcefa;
	
	/**
	 * descripcion
	 */
	private String descripcionIcefa;
	
	/**
	 * fecha de control
	 */
	private Date fechaControl;
	
	/**
	 * ultimo usuario modificador 
	 */
	private String usuarioModificador;
	
	/**
	 * @return the claveIcefa
	 */
	public String getClaveIcefa() {
		return claveIcefa;
	}
	/**
	 * @param claveIcefa the claveIcefa to set
	 */
	public void setClaveIcefa(String claveIcefa) {
		this.claveIcefa = claveIcefa;
	}
	/**
	 * @return the descripcionIcefa
	 */
	public String getDescripcionIcefa() {
		return descripcionIcefa;
	}
	/**
	 * @param descripcionIcefa the descripcionIcefa to set
	 */
	public void setDescripcionIcefa(String descripcionIcefa) {
		this.descripcionIcefa = descripcionIcefa;
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
}