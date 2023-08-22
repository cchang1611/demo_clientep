package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;
/**
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 2, 2021
 */
public class DerechoSubcuenta implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4799020123084340917L;

	private Long idDerechoSubCuenta;

	/**
	 * Atributo idMatrizDerecho
	 */
	private Long idMatrizDerecho;

	/**
	 * Atributo cvSubCuenta
	 */
	private Subcuenta cvSubCuenta;

	/**
	 * Atributo chDestinoRecurso
	 */
	private String chDestinoRecurso;

	/**
	 * Atributo cvEstatusVivienda
	 */
	
	private String cvEstatusVivienda;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * @return el atributo idDerechoSubCuenta
	 */
	public Long getIdDerechoSubCuenta() {
		return idDerechoSubCuenta;
	}

	/**
	 * @param idDerechoSubCuenta parametro idDerechoSubCuenta a actualizar
	 */
	public void setIdDerechoSubCuenta(Long idDerechoSubCuenta) {
		this.idDerechoSubCuenta = idDerechoSubCuenta;
	}

	/**
	 * @return el atributo idMatrizDerecho
	 */
	public Long getIdMatrizDerecho() {
		return idMatrizDerecho;
	}

	/**
	 * @param idMatrizDerecho parametro idMatrizDerecho a actualizar
	 */
	public void setIdMatrizDerecho(Long idMatrizDerecho) {
		this.idMatrizDerecho = idMatrizDerecho;
	}

	
	/**
	 * @return el atributo chDestinoRecurso
	 */
	public String getChDestinoRecurso() {
		return chDestinoRecurso;
	}

	/**
	 * @param chDestinoRecurso parametro chDestinoRecurso a actualizar
	 */
	public void setChDestinoRecurso(String chDestinoRecurso) {
		this.chDestinoRecurso = chDestinoRecurso;
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

	/**
	 * @return el atributo fcControl
	 */
	public Date getFcControl() {
		
		
		return fcControl;
	}

	/**
	 * @param fcControl parametro fcControl a actualizar
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return el atributo chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador parametro chUsuarioModificador a actualizar
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}
	
	/**
	 * @return el atributo cvSubCuenta
	 */
	public Subcuenta getCvSubCuenta() {
		return cvSubCuenta;
	}

	/**
	 * @param cvSubCuenta parametro cvSubCuenta a actualizar
	 */
	public void setCvSubCuenta(Subcuenta cvSubCuenta) {
		this.cvSubCuenta = cvSubCuenta;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DerechoSubcuenta [idDerechoSubCuenta=");
		builder.append(idDerechoSubCuenta);
		builder.append(", idMatrizDerecho=");
		builder.append(idMatrizDerecho);
		builder.append(", cvSubCuenta=");
		builder.append(cvSubCuenta);
		builder.append(", chDestinoRecurso=");
		builder.append(chDestinoRecurso);
		builder.append(", cvEstatusVivienda=");
		builder.append(cvEstatusVivienda);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}

    	
	
}
