package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase de saldos
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosConsultaSaldos  implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3712832386132941538L;

	/**
	 *
	 * saldo Sar92
	 *
	**/
	private  BigDecimal salario;

	/**
	 *
	 * saldo Retiro97
	 *
	**/
	private  String periodo;

	/**
	 *  Constructor DatosConsultaSaldos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param salario
	 *  @param periodo
	 */
	public DatosConsultaSaldos(BigDecimal salario, String periodo) {
		this.salario = salario;
		this.periodo = periodo;
	}
	/**
	 *  Constructor
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 */
	public DatosConsultaSaldos() {
		//Constructor de fault
	}
	/**
	 * @return el atributo salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	/**
	 * @param salario parametro salario a actualizar
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * @return el atributo periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo parametro periodo a actualizar
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosConsultaSaldos [salario=");
		builder.append(salario);
		builder.append(", periodo=");
		builder.append(periodo);
		builder.append("]");
		return builder.toString();
	}
	
}