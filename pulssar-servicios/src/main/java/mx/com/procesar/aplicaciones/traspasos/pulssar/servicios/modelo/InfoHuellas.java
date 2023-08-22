/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Informacion de las Huellas
 * @author DHERNAND
 *
 */
public class InfoHuellas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6727472407487656083L;

	/**
	 * calidadHuellas
	 */
	private List<DatosHuellas> huellasTrabajador;
	
	/**
	 * Excepciones de huellas
	 */
	private String excepcion;
	
	/**
	 * Dispositivo con que se tomo las huellas
	 */
	private String dispositivo;

	/**
	 * Regresar huellasTrabajador
	 * @return huellasTrabajador
	 */
	public List<DatosHuellas> getHuellasTrabajador() {
		return huellasTrabajador;
	}

	/**
	 * Asigna huellasTrabajador
	 * @param  huellasTrabajador
	 */
	public void setHuellasTrabajador(List<DatosHuellas> huellasTrabajador) {
		this.huellasTrabajador = huellasTrabajador;
	}

	/**
	 * Regresar excepcion
	 * @return excepcion
	 */
	public String getExcepcion() {
		return excepcion;
	}

	/**
	 * Asigna excepcion
	 * @param  excepcion
	 */
	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

	/**
	 * Regresar dispositivo
	 * @return dispositivo
	 */
	public String getDispositivo() {
		return dispositivo;
	}

	/**
	 * Asigna dispositivo
	 * @param  dispositivo
	 */
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	/** 
	 * Verificar la interface o clase que lo define
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoHuellas [huellasTrabajador=");
		builder.append(huellasTrabajador);
		builder.append(", excepcion=");
		builder.append(excepcion);
		builder.append(", dispositivo=");
		builder.append(dispositivo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
