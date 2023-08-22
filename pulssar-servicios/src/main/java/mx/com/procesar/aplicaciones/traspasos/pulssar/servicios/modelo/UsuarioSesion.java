package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contiene los datos en Sesion. A diferencia de de {@link UsuarioLogin}
 * contiene una descripción del mensaje.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class UsuarioSesion extends UsuarioLogin {

	/**
	 * Serialización dela clase.
	 */
	private static final long serialVersionUID = -6761910459133675442L;
	
	/**
	 * Contiene un mensaje de error en caso de existir.
	 */
	private String mensajeError;

	/**
	 * Constructor publico de la clase. Inicializa el valor de la clave con
	 * valor 1 - Flujo Exitoso.
	 */
	public UsuarioSesion() {
		super();
		super.setFlujo(EXITOSO.getClave());
	}

	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError
	 *            the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		
		this.mensajeError = mensajeError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
