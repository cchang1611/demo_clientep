package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades; 

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entidad embebida de la tabla CodigoValidaCitaEsar
 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
 * Oct 30, 2019
 */
@Embeddable
public class CodigoValidaCitaEsarPK implements Serializable {

	/**
	 * Serializacion
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 30, 2019
	 */
	private static final long serialVersionUID = 3860876336252762010L;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * codigo
	 */
	private Integer codigo;

	public CodigoValidaCitaEsarPK(String curp,Integer codigo) {
		this.curp = curp;
		this.codigo = codigo;
	}
	
	public CodigoValidaCitaEsarPK() {
		// contructor
	}
	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
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
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CodigoValidaCitaEsarPK)) {
			return false;
		}
		CodigoValidaCitaEsarPK castOther = (CodigoValidaCitaEsarPK)other;
		return 
			this.curp.equals(castOther.curp)
			&& (this.codigo == castOther.codigo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curp.hashCode();
		hash = hash * prime + (this.codigo ^ (this.codigo >>> 32));
		
		return hash;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodigoValidaCitaEsarPK [curp=");
		builder.append(curp);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append("]");
		return builder.toString();
	}
}