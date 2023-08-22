package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ListaBeneficiariosTrabajador implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<DatosBeneficiarioTrabajador> beneficiario;

	public List<DatosBeneficiarioTrabajador> getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(List<DatosBeneficiarioTrabajador> beneficiario) {
		this.beneficiario = beneficiario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaBeneficiariosTrabajador [beneficiario=");
		builder.append(beneficiario);
		builder.append("]");
		return builder.toString();
	}

	 
	 
	 

}
