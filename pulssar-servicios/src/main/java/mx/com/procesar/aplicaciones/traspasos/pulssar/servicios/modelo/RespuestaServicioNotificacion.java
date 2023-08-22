package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * RespuestaServicioNotificacion
 * @author jmordone
 *
 */
public class RespuestaServicioNotificacion implements Serializable {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = -2563389739514701147L;

	/**
	 * mensaje de pop up
	 */
	private String mensaje;
	
	/**
	 * codigo
	 */
	private Integer codigo;
	
	/**
	 * resultado
	 */
	private String resultado;
	
	/**
	 * resultadoOperacion
	 */
	private String resultadoOperacion;
	
	/**
	 * existeResolucion
	 */
    private Boolean existeResolucion;
    
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
	
	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the existeResolucion
	 */
	public Boolean getExisteResolucion() {
		return existeResolucion;
	}

	/**
	 * @param existeResolucion the existeResolucion to set
	 */
	public void setExisteResolucion(Boolean existeResolucion) {
		this.existeResolucion = existeResolucion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaServicio [mensaje=");
		builder.append(mensaje);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", existeResolucion=");
		builder.append(existeResolucion);
		builder.append("]");
		return builder.toString();
	}

	

}