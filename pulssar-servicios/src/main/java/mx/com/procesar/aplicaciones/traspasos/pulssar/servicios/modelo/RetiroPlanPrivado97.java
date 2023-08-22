package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;
/**
 * Datos entrada 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 5, 2021
 */
public class RetiroPlanPrivado97 implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7118105369669137373L;

	private Long idPlanPrivado97;

	/**
	 * Atributo cvActuario
	 */
	private String cvActuario;

	/**
	 * Atributo chNumeroPlan
	 */
	private String chNumeroPlan;

	/**
	 * Atributo fcCargaPlan
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcCargaPlan;

	/**
	 * fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Atributo chNombrePlan
	 */
	private String chNombrePlan;

	/**
	 * Atributo fcFinVigencia
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcFinVigencia;

	/**
	 * Atributo nuActivo
	 */
	private Integer nuActivo;

	/**
	 * @return el atributo idPlanPrivado97
	 */
	public Long getIdPlanPrivado97() {
		return idPlanPrivado97;
	}

	/**
	 * @param idPlanPrivado97 parametro idPlanPrivado97 a actualizar
	 */
	public void setIdPlanPrivado97(Long idPlanPrivado97) {
		this.idPlanPrivado97 = idPlanPrivado97;
	}

	/**
	 * @return el atributo cvActuario
	 */
	public String getCvActuario() {
		return cvActuario;
	}

	/**
	 * @param cvActuario parametro cvActuario a actualizar
	 */
	public void setCvActuario(String cvActuario) {
		this.cvActuario = cvActuario;
	}

	/**
	 * @return el atributo chNumeroPlan
	 */
	public String getChNumeroPlan() {
		return chNumeroPlan;
	}

	/**
	 * @param chNumeroPlan parametro chNumeroPlan a actualizar
	 */
	public void setChNumeroPlan(String chNumeroPlan) {
		this.chNumeroPlan = chNumeroPlan;
	}

	/**
	 * @return el atributo fcCargaPlan
	 */
	public Date getFcCargaPlan() {
		return fcCargaPlan;
	}

	/**
	 * @param fcCargaPlan parametro fcCargaPlan a actualizar
	 */
	public void setFcCargaPlan(Date fcCargaPlan) {
		this.fcCargaPlan = fcCargaPlan;
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
	 * @return el atributo chNombrePlan
	 */
	public String getChNombrePlan() {
		return chNombrePlan;
	}

	/**
	 * @param chNombrePlan parametro chNombrePlan a actualizar
	 */
	public void setChNombrePlan(String chNombrePlan) {
		this.chNombrePlan = chNombrePlan;
	}

	/**
	 * @return el atributo fcFinVigencia
	 */
	public Date getFcFinVigencia() {
		return fcFinVigencia;
	}

	/**
	 * @param fcFinVigencia parametro fcFinVigencia a actualizar
	 */
	public void setFcFinVigencia(Date fcFinVigencia) {
		this.fcFinVigencia = fcFinVigencia;
	}

	/**
	 * @return el atributo nuActivo
	 */
	public Integer getNuActivo() {
		return nuActivo;
	}

	/**
	 * @param nuActivo parametro nuActivo a actualizar
	 */
	public void setNuActivo(Integer nuActivo) {
		this.nuActivo = nuActivo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroPlanPrivado97 [idPlanPrivado97=");
		builder.append(idPlanPrivado97);
		builder.append(", cvActuario=");
		builder.append(cvActuario);
		builder.append(", chNumeroPlan=");
		builder.append(chNumeroPlan);
		builder.append(", fcCargaPlan=");
		builder.append(fcCargaPlan);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", chNombrePlan=");
		builder.append(chNombrePlan);
		builder.append(", fcFinVigencia=");
		builder.append(fcFinVigencia);
		builder.append(", nuActivo=");
		builder.append(nuActivo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
