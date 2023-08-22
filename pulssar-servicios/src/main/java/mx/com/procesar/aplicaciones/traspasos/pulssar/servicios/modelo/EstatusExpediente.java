package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author JMGUTIER
 *
 */

public class EstatusExpediente implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -1531179210540108432L;
	/**
	 * clave estatus expediente
	 */
	private String  claveEstatusExp;
	/**
	 * descripcion estatus expediente
	 */
	private String chDescripcionExp;
	/**
	 * usuario modificador
	 */
	private String chUsuarioModificador;
	/**
	 * fecha control
	 */
	private Date fechaControl;
	
	/**
	 * @return the claveEstatusExp
	 */
	public String getClaveEstatusExp() {
		return claveEstatusExp;
	}
	/**
	 * @param claveEstatusExp the claveEstatusExp to set
	 */
	public void setClaveEstatusExp(String claveEstatusExp) {
		this.claveEstatusExp = claveEstatusExp;
	}
	/**
	 * @return the chDescripcionExp
	 */
	public String getChDescripcionExp() {
		return chDescripcionExp;
	}
	/**
	 * @param chDescripcionExp the chDescripcionExp to set
	 */
	public void setChDescripcionExp(String chDescripcionExp) {
		this.chDescripcionExp = chDescripcionExp;
	}
	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}
	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
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

	
	
	

}
