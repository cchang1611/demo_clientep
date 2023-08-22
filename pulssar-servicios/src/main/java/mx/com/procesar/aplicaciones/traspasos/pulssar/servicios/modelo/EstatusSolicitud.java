package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author JMGUTIER
 *
 */
public class EstatusSolicitud implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 2433733956816761215L;
	
	/**
	 * clave estatus
	 */
	private String claveEstatusSolicitud;
	/**
	 * descripcion
	 */
	private String chDescripcion;
	
	/**
	 * fecha control
	 */
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the claveEstatusSolicitud
	 */
	public String getClaveEstatusSolicitud() {
		return claveEstatusSolicitud;
	}

	/**
	 * @param claveEstatusSolicitud the claveEstatusSolicitud to set
	 */
	public void setClaveEstatusSolicitud(String claveEstatusSolicitud) {
		this.claveEstatusSolicitud = claveEstatusSolicitud;
	}

	/**
	 * @return the chDescripcion
	 */
	public String getChDescripcion() {
		return chDescripcion;
	}

	/**
	 * @param chDescripcion the chDescripcion to set
	 */
	public void setChDescripcion(String chDescripcion) {
		this.chDescripcion = chDescripcion;
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
