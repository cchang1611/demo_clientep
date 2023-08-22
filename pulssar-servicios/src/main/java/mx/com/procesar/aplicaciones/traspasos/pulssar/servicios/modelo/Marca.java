package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Datos entrada Marca 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Jun 9, 2021
 */
public class Marca implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 2619372497969358780L;
	
	/**
	 * cvEstatusVivienda
	 */
	private String cvEstatusVivienda;
	
	/**
	 * descripcionProceso
	 */
	private String descripcionProceso;

	/**
	 * @return el atributo cvEstatusVivienda
	 */
	public String getCvEstatusVivienda() {
		return cvEstatusVivienda;
	}

	/**
	 * @param cvEstatusVivienda parametro cvEstatusVivienda a actualizar
	 */
	public void setCvEstatusVivienda(String cvEstatusVivienda) {
		this.cvEstatusVivienda = cvEstatusVivienda;
	}

	/**
	 * @return el atributo descripcionProceso
	 */
	public String getDescripcionProceso() {
		return descripcionProceso;
	}

	/**
	 * @param descripcionProceso parametro descripcionProceso a actualizar
	 */
	public void setDescripcionProceso(String descripcionProceso) {
		this.descripcionProceso = descripcionProceso;
	}

	
	
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param cvEstatusVivienda
	 *  @param descripcionProceso
	 */
	
//	public Marca(String cvEstatusVivienda, String descripcionProceso) {
//	
//		this.cvEstatusVivienda = cvEstatusVivienda;
//		this.descripcionProceso = descripcionProceso;
//	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Marca [cvEstatusVivienda=");
		builder.append(cvEstatusVivienda);
		builder.append(", descripcionProceso=");
		builder.append(descripcionProceso);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
