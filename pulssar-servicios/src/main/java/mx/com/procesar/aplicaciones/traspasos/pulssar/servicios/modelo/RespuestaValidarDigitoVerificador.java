package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase respuesta del servicio de varidar digito verificador tipo BaseRespuesta
 * @author ANOSORIO
 *
 */
public class RespuestaValidarDigitoVerificador implements Serializable
{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6873751253233714298L;

	/**
	 * Diagnostico de recepcion 01 [Exito] - 02 [Error]
	 */
	private String diagnosticoDeRecepcion;

	/**
	 * Resultado de la operacion mensajes de negocio
	 */
	private String resultadoDeLaOperacion;

	/**
	 * @return the diagnosticoDeRecepcion
	 */
	public String getDiagnosticoDeRecepcion() {
		return diagnosticoDeRecepcion;
	}

	/**
	 * @param diagnosticoDeRecepcion the diagnosticoDeRecepcion to set
	 */
	public void setDiagnosticoDeRecepcion(String diagnosticoDeRecepcion) {
		this.diagnosticoDeRecepcion = diagnosticoDeRecepcion;
	}

	/**
	 * @return the resultadoDeLaOperacion
	 */
	public String getResultadoDeLaOperacion() {
		return resultadoDeLaOperacion;
	}

	/**
	 * @param resultadoDeLaOperacion the resultadoDeLaOperacion to set
	 */
	public void setResultadoDeLaOperacion(String resultadoDeLaOperacion) {
		this.resultadoDeLaOperacion = resultadoDeLaOperacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaValidarDigitoVerificador [diagnosticoDeRecepcion=");
		builder.append(diagnosticoDeRecepcion);
		builder.append(", resultadoDeLaOperacion=");
		builder.append(resultadoDeLaOperacion);
		builder.append("]");
		return builder.toString();
	}

		
	
	
	

	
}
