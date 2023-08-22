package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase beneficiario
 * @author JMGUTIEG
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Beneficiarios implements Serializable{

    
    /**
	 *Serializacion 
	 */
	private static final long serialVersionUID = -6092271134309142847L;
	
	/**
	 * beneficiario
	 */
	private List<DatosBeneficiarioTrabajador> beneficiario;

	/**
	 * @return the beneficiario
	 */
	public List<DatosBeneficiarioTrabajador> getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(List<DatosBeneficiarioTrabajador> beneficiario) {
		this.beneficiario = beneficiario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beneficiarios [beneficiario=");
		builder.append(beneficiario);
		builder.append("]");
		return builder.toString();
	}

	

}
