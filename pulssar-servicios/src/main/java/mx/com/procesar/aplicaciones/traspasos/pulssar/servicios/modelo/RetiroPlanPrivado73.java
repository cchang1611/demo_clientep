package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 *  Entidad RETI_TR_PLAN_PRIVADO73
 * TODO [Agregar documentacion de la clase]
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
public class RetiroPlanPrivado73 implements Serializable{

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -1408260029329545699L;

	/**
	 * Atributo idPlanPrivado73
	 */
	
	private Long idPlanPrivado73;

	/**
	 * Atributo claveProceso
	 */
	private String nss;

	/**
	 * Atributo chMatricula
	 */
	private String chMatricula;

	/**
	 * Atributo chNumeroExpediente
	 */
	private String chNumeroExpediente;

	/**
	 * Atributo chNombre
	 */
	private String chNombre;

	/**
	 * Atributo chTipoPension
	 */
	private String chTipoPension;

	/**
	 * Atributo chDescTipoPension
	 */
	private String chDescTipoPension;

	/**
	 * Atributo fcInicioPension
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fcInicioPension;

	/**
	 * Atributo fcEnvioLote
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fcEnvioLote;

	/**
	 * Atributo chAfore
	 */
	private String chAfore;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * @return el atributo idPlanPrivado73
	 */
	public Long getIdPlanPrivado73() {
		return idPlanPrivado73;
	}

	/**
	 * @param idPlanPrivado73 parametro idPlanPrivado73 a actualizar
	 */
	public void setIdPlanPrivado73(Long idPlanPrivado73) {
		this.idPlanPrivado73 = idPlanPrivado73;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo chMatricula
	 */
	public String getChMatricula() {
		return chMatricula;
	}

	/**
	 * @param chMatricula parametro chMatricula a actualizar
	 */
	public void setChMatricula(String chMatricula) {
		this.chMatricula = chMatricula;
	}

	/**
	 * @return el atributo chNumeroExpediente
	 */
	public String getChNumeroExpediente() {
		return chNumeroExpediente;
	}

	/**
	 * @param chNumeroExpediente parametro chNumeroExpediente a actualizar
	 */
	public void setChNumeroExpediente(String chNumeroExpediente) {
		this.chNumeroExpediente = chNumeroExpediente;
	}

	/**
	 * @return el atributo chNombre
	 */
	public String getChNombre() {
		return chNombre;
	}

	/**
	 * @param chNombre parametro chNombre a actualizar
	 */
	public void setChNombre(String chNombre) {
		this.chNombre = chNombre;
	}

	/**
	 * @return el atributo chTipoPension
	 */
	public String getChTipoPension() {
		return chTipoPension;
	}

	/**
	 * @param chTipoPension parametro chTipoPension a actualizar
	 */
	public void setChTipoPension(String chTipoPension) {
		this.chTipoPension = chTipoPension;
	}

	/**
	 * @return el atributo chDescTipoPension
	 */
	public String getChDescTipoPension() {
		return chDescTipoPension;
	}

	/**
	 * @param chDescTipoPension parametro chDescTipoPension a actualizar
	 */
	public void setChDescTipoPension(String chDescTipoPension) {
		this.chDescTipoPension = chDescTipoPension;
	}

	/**
	 * @return el atributo fcInicioPension
	 */
	public Date getFcInicioPension() {
		return fcInicioPension;
	}

	/**
	 * @param fcInicioPension parametro fcInicioPension a actualizar
	 */
	public void setFcInicioPension(Date fcInicioPension) {
		this.fcInicioPension = fcInicioPension;
	}

	/**
	 * @return el atributo fcEnvioLote
	 */
	public Date getFcEnvioLote() {
		return fcEnvioLote;
	}

	/**
	 * @param fcEnvioLote parametro fcEnvioLote a actualizar
	 */
	public void setFcEnvioLote(Date fcEnvioLote) {
		this.fcEnvioLote = fcEnvioLote;
	}

	/**
	 * @return el atributo chAfore
	 */
	public String getChAfore() {
		return chAfore;
	}

	/**
	 * @param chAfore parametro chAfore a actualizar
	 */
	public void setChAfore(String chAfore) {
		this.chAfore = chAfore;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroPlanPrivado73 [idPlanPrivado73=");
		builder.append(idPlanPrivado73);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", chMatricula=");
		builder.append(chMatricula);
		builder.append(", chNumeroExpediente=");
		builder.append(chNumeroExpediente);
		builder.append(", chNombre=");
		builder.append(chNombre);
		builder.append(", chTipoPension=");
		builder.append(chTipoPension);
		builder.append(", chDescTipoPension=");
		builder.append(chDescTipoPension);
		builder.append(", fcInicioPension=");
		builder.append(fcInicioPension);
		builder.append(", fcEnvioLote=");
		builder.append(fcEnvioLote);
		builder.append(", chAfore=");
		builder.append(chAfore);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	
}
