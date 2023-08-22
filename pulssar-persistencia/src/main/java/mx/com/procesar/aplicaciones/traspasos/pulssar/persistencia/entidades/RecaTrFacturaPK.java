package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Entidad embebido
 * @author ANOSORIO
 *
 */
@Embeddable
public class RecaTrFacturaPK implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8754732732305569122L;

	/**
	 * idFactura
	 */
	private Long idFactura;
	
	/**
	 * idTv
	 */
	private Long idTv;
	
	/**
	 * cvEstadoFactura
	 */
	private String cvEstadoFactura;

	/**
	 * @return el atributo idFactura
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura parametro idFactura a actualizar
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * @return el atributo idTv
	 */
	public Long getIdTv() {
		return idTv;
	}

	/**
	 * @param idTv parametro idTv a actualizar
	 */
	public void setIdTv(Long idTv) {
		this.idTv = idTv;
	}

	/**
	 * @return el atributo cvEstadoFactura
	 */
	public String getCvEstadoFactura() {
		return cvEstadoFactura;
	}

	/**
	 * @param cvEstadoFactura parametro cvEstadoFactura a actualizar
	 */
	public void setCvEstadoFactura(String cvEstadoFactura) {
		this.cvEstadoFactura = cvEstadoFactura;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
