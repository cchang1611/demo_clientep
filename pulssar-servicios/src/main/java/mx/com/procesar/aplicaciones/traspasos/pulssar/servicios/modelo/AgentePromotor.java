package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos que tendran como respuesta el servicio de
 * agente promotor
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class AgentePromotor implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -8044183613629528043L;
	
	/**
	 * Id de usuario
	 */
	private Long identificador; 
	
	/**
	 * Flujo del mensaje
	 */
	private String codigoOperacion;

	/**
	 * Objeto de respuesta
	 */
	private DatosAgente datosAgente;

	/**
	 * @return the identificador
	 */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	/**
	 * @param codigoOperacion
	 *            the codigoOperacion to set
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	/**
	 * @return the datosAgente
	 */
	public DatosAgente getDatosAgente() {
		return datosAgente;
	}

	/**
	 * @param datosAgente
	 *            the datosAgente to set
	 */
	public void setDatosAgente(DatosAgente datosAgente) {
		this.datosAgente = datosAgente;
	}

	/**
	 * Imprime la cadena del Objeto creado
	 * 
	 * @return strRespuesta
	 */
	@Override
	public String toString() {
		StringBuilder strRespuesta = new StringBuilder();
		strRespuesta.append("Respuesta [");
		strRespuesta.append("identificador=");
		strRespuesta.append(identificador);

		if (codigoOperacion != null) {
			strRespuesta.append("codigoOperacion=");
			strRespuesta.append(codigoOperacion);
		}

		if (datosAgente != null) {
			strRespuesta.append(", ");
			strRespuesta.append("datosAgente=");
			strRespuesta.append(datosAgente);
		}
		strRespuesta.append("]");
		return strRespuesta.toString();
	}
}
