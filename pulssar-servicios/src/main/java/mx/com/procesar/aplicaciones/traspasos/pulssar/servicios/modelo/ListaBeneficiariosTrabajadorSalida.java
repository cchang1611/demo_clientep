package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;


public class ListaBeneficiariosTrabajadorSalida implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<DatosBeneficiarioTrabajadorSalida> beneficiario;

	public List<DatosBeneficiarioTrabajadorSalida> getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(List<DatosBeneficiarioTrabajadorSalida> beneficiario) {
		this.beneficiario = beneficiario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaBeneficiariosTrabajadorSalida [beneficiario=");
		builder.append(beneficiario);
		builder.append("]");
		return builder.toString();
	}
	
	
	 
	 
	 

}
