package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * 
 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 21, 2021
 */
public class EstatusViviendaMarcaImssPK implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3781445076445307965L;
	
	/**
	 * idTipoProceso
	 */
	private Long idTipoProceso;
	
	/**
	 * cvEstatusVivienda
	 */
	private String cvEstatusVivienda;

	
	
	
	/**
	 * @return el atributo idTipoProceso
	 */
	public Long getIdTipoProceso() {
		return idTipoProceso;
	}




	/**
	 * @param idTipoProceso parametro idTipoProceso a actualizar
	 */
	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}




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




	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstatusViviendaMarcaImssPK [idTipoProceso=");
		builder.append(idTipoProceso);
		builder.append(", cvEstatusVivienda=");
		builder.append(cvEstatusVivienda);
		builder.append("]");
		return builder.toString();
	}
	
	
}
