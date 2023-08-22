package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Objeto de entrada del servicio de generación de sellos virtuales
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 14/10/2019
 */
public class SelloVirtualEntrada implements Serializable {

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = -5941133430335801872L;

	/**
	 * claveAfore
	 */
	private String claveAfore;

	/**
	 * claveServicio
	 */
	private String claveServicio;

	/**
	 * curpEmpleado
	 */
	private String curpEmpleado;

	/**
	 * curpActualTrabajador
	 */
	private String curpActualTrabajador;

	/**
	 * curpNuevaTrabajador
	 */
	private String curpNuevaTrabajador;

	/**
	 * @return el atributo claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore
	 *            parametro claveAfore a actualizar
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return el atributo claveServicio
	 */
	public String getClaveServicio() {
		return claveServicio;
	}

	/**
	 * @param claveServicio
	 *            parametro claveServicio a actualizar
	 */
	public void setClaveServicio(String claveServicio) {
		this.claveServicio = claveServicio;
	}

	/**
	 * @return el atributo curpEmpleado
	 */
	public String getCurpEmpleado() {
		return curpEmpleado;
	}

	/**
	 * @param curpEmpleado
	 *            parametro curpEmpleado a actualizar
	 */
	public void setCurpEmpleado(String curpEmpleado) {
		this.curpEmpleado = curpEmpleado;
	}

	/**
	 * @return el atributo curpActualTrabajador
	 */
	public String getCurpActualTrabajador() {
		return curpActualTrabajador;
	}

	/**
	 * @param curpActualTrabajador
	 *            parametro curpActualTrabajador a actualizar
	 */
	public void setCurpActualTrabajador(String curpActualTrabajador) {
		this.curpActualTrabajador = curpActualTrabajador;
	}

	/**
	 * @return el atributo curpNuevaTrabajador
	 */
	public String getCurpNuevaTrabajador() {
		return curpNuevaTrabajador;
	}

	/**
	 * @param curpNuevaTrabajador
	 *            parametro curpNuevaTrabajador a actualizar
	 */
	public void setCurpNuevaTrabajador(String curpNuevaTrabajador) {
		this.curpNuevaTrabajador = curpNuevaTrabajador;
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
		builder.append("SelloVirtualEntrada [claveAfore=");
		builder.append(claveAfore);
		builder.append(", claveServicio=");
		builder.append(claveServicio);
		builder.append(", curpEmpleado=");
		builder.append(curpEmpleado);
		builder.append(", curpActualTrabajador=");
		builder.append(curpActualTrabajador);
		builder.append(", curpNuevaTrabajador=");
		builder.append(curpNuevaTrabajador);
		builder.append("]");
		return builder.toString();
	}

}
