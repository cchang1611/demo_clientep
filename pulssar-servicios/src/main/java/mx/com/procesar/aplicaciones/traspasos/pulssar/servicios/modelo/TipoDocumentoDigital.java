package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Clase de la entidad EXPE_TC_TIPO_DOC_DIGITAL
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 15/05/2019
 */
public class TipoDocumentoDigital implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -8943411333998248123L;

	/**
	 * claveTipoDocumentoDigital
	 */
	private String claveTipoDocumentoDigital;

	/**
	 * descripcionDocumentoDigitla
	 */
	private String descripcionDocumentoDigitla;

	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * control del estatus agente
	 */
	private Date fechaControl;

	/**
	 * @return el atributo claveTipoDocumentoDigital
	 */
	public String getClaveTipoDocumentoDigital() {
		return claveTipoDocumentoDigital;
	}

	/**
	 * @param claveTipoDocumentoDigital
	 *            parametro claveTipoDocumentoDigital a actualizar
	 */
	public void setClaveTipoDocumentoDigital(String claveTipoDocumentoDigital) {
		this.claveTipoDocumentoDigital = claveTipoDocumentoDigital;
	}

	/**
	 * @return el atributo descripcionDocumentoDigitla
	 */
	public String getDescripcionDocumentoDigitla() {
		return descripcionDocumentoDigitla;
	}

	/**
	 * @param descripcionDocumentoDigitla
	 *            parametro descripcionDocumentoDigitla a actualizar
	 */
	public void setDescripcionDocumentoDigitla(String descripcionDocumentoDigitla) {
		this.descripcionDocumentoDigitla = descripcionDocumentoDigitla;
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
		StringBuilder builder = new StringBuilder();
		builder.append("TipoDocumentoDigital [claveTipoDocumentoDigital=");
		builder.append(claveTipoDocumentoDigital);
		builder.append(", descripcionDocumentoDigitla=");
		builder.append(descripcionDocumentoDigitla);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}

}
