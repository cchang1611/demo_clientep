package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * clase que contiene los atributos para la respuesta de los servicios
 * 
 * @author ANOSORIO
 * version 1.0
 */
public class RespuestaServicioRetiroParcialCalculo implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2897589045277772400L;
	
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaServicio [titulo=");
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append("]");
		return builder.toString();
	}


	
	
}