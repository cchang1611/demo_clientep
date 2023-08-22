package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;
/**
 *  Entidada RecaudadoraTV
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 25, 2021
 */
public class RecaudadoraTV implements Serializable{

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 3297615003627959810L;

	/**
	 * Atributo idTv
	 */
	private Long idTv;
	
	/**
	 * Atributo cvEntidadRecaudadora
	 */
	private String cvEntidadRecaudadora;
	
	/**
	 * Atributo fcValorpago
	 */
	
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcValorpago;
	
	/**
	 * Atributo nrp
	 */
	private String nrp;

	/**
	 * Atributo chPeriodoPago
	 */
	private String chPeriodoPago;

	/**
	 * Atributo chRfcPatron
	 */
	private String chRfcPatron;

	/**
	 * Atributo chSucursal
	 */
	private String chSucursal;

	/**
	 * Atributo cvTipoPago
	 */
	private String cvTipoPago;

	/**
	 * Atributo fcRecepcion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcRecepcion;

	/**
	 * Atributo fcValorInstituto
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcValorInstituto;

	/**
	 * Atributo idArchivo
	 */
	private Long idArchivo;

	/**
	 * Atributo cvEstadoTv
	 */
	private String cvEstadoTv;

	/**
	 * Atributo nuMontoPago
	 */
	private BigDecimal nuMontoPago;

	/**
	 * Atributo fcIndividualizacion
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcIndividualizacion;

	/**
	 * Atributo chUsuarioModificador
	 */
	private String chUsuarioModificador;

	/**
	 * Atributo fcControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcControl;

	/**
	 * Atributo chFolio
	 */
	private String chFolio;

	/**
	 * Atributo idTvSipare
	 */
	private Long idTvSipare;

	/**
	 * Atributo nuTipoInformacion
	 */
	private Integer nuTipoInformacion;

	/**
	 * Atributo chCveOperacion
	 */
	private String chCveOperacion;

	/**
	 * Atributo fcNotifLqInfo
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fcNotifLqInfo;

	/**
	 * numeroPlan
	 */
	private String numeroPlan;
	
	/**
	 * cvActuario
	 */
	private String cvActuario;
	
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
	 * @return el atributo cvEntidadRecaudadora
	 */
	public String getCvEntidadRecaudadora() {
		return cvEntidadRecaudadora;
	}

	/**
	 * @param cvEntidadRecaudadora parametro cvEntidadRecaudadora a actualizar
	 */
	public void setCvEntidadRecaudadora(String cvEntidadRecaudadora) {
		this.cvEntidadRecaudadora = cvEntidadRecaudadora;
	}

	/**
	 * @return el atributo fcValorpago
	 */
	public Date getFcValorpago() {
		return fcValorpago;
	}

	/**
	 * @param fcValorpago parametro fcValorpago a actualizar
	 */
	public void setFcValorpago(Date fcValorpago) {
		this.fcValorpago = fcValorpago;
	}

	/**
	 * @return el atributo nrp
	 */
	public String getNrp() {
		return nrp;
	}

	/**
	 * @param nrp parametro nrp a actualizar
	 */
	public void setNrp(String nrp) {
		this.nrp = nrp;
	}

	/**
	 * @return el atributo chPeriodoPago
	 */
	public String getChPeriodoPago() {
		return chPeriodoPago;
	}

	/**
	 * @param chPeriodoPago parametro chPeriodoPago a actualizar
	 */
	public void setChPeriodoPago(String chPeriodoPago) {
		this.chPeriodoPago = chPeriodoPago;
	}

	/**
	 * @return el atributo chRfcPatron
	 */
	public String getChRfcPatron() {
		return chRfcPatron;
	}

	/**
	 * @param chRfcPatron parametro chRfcPatron a actualizar
	 */
	public void setChRfcPatron(String chRfcPatron) {
		this.chRfcPatron = chRfcPatron;
	}

	/**
	 * @return el atributo chSucursal
	 */
	public String getChSucursal() {
		return chSucursal;
	}

	/**
	 * @param chSucursal parametro chSucursal a actualizar
	 */
	public void setChSucursal(String chSucursal) {
		this.chSucursal = chSucursal;
	}

	/**
	 * @return el atributo cvTipoPago
	 */
	public String getCvTipoPago() {
		return cvTipoPago;
	}

	/**
	 * @param cvTipoPago parametro cvTipoPago a actualizar
	 */
	public void setCvTipoPago(String cvTipoPago) {
		this.cvTipoPago = cvTipoPago;
	}

	/**
	 * @return el atributo fcRecepcion
	 */
	public Date getFcRecepcion() {
		return fcRecepcion;
	}

	/**
	 * @param fcRecepcion parametro fcRecepcion a actualizar
	 */
	public void setFcRecepcion(Date fcRecepcion) {
		this.fcRecepcion = fcRecepcion;
	}

	/**
	 * @return el atributo fcValorInstituto
	 */
	public Date getFcValorInstituto() {
		return fcValorInstituto;
	}

	/**
	 * @param fcValorInstituto parametro fcValorInstituto a actualizar
	 */
	public void setFcValorInstituto(Date fcValorInstituto) {
		this.fcValorInstituto = fcValorInstituto;
	}

	/**
	 * @return el atributo idArchivo
	 */
	public Long getIdArchivo() {
		return idArchivo;
	}

	/**
	 * @param idArchivo parametro idArchivo a actualizar
	 */
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	/**
	 * @return el atributo cvEstadoTv
	 */
	public String getCvEstadoTv() {
		return cvEstadoTv;
	}

	/**
	 * @param cvEstadoTv parametro cvEstadoTv a actualizar
	 */
	public void setCvEstadoTv(String cvEstadoTv) {
		this.cvEstadoTv = cvEstadoTv;
	}

	/**
	 * @return el atributo nuMontoPago
	 */
	public BigDecimal getNuMontoPago() {
		return nuMontoPago;
	}

	/**
	 * @param nuMontoPago parametro nuMontoPago a actualizar
	 */
	public void setNuMontoPago(BigDecimal nuMontoPago) {
		this.nuMontoPago = nuMontoPago;
	}

	/**
	 * @return el atributo fcIndividualizacion
	 */
	public Date getFcIndividualizacion() {
		return fcIndividualizacion;
	}

	/**
	 * @param fcIndividualizacion parametro fcIndividualizacion a actualizar
	 */
	public void setFcIndividualizacion(Date fcIndividualizacion) {
		this.fcIndividualizacion = fcIndividualizacion;
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
	 * @return el atributo chFolio
	 */
	public String getChFolio() {
		return chFolio;
	}

	/**
	 * @param chFolio parametro chFolio a actualizar
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}

	/**
	 * @return el atributo idTvSipare
	 */
	public Long getIdTvSipare() {
		return idTvSipare;
	}

	/**
	 * @param idTvSipare parametro idTvSipare a actualizar
	 */
	public void setIdTvSipare(Long idTvSipare) {
		this.idTvSipare = idTvSipare;
	}

	/**
	 * @return el atributo nuTipoInformacion
	 */
	public Integer getNuTipoInformacion() {
		return nuTipoInformacion;
	}

	/**
	 * @param nuTipoInformacion parametro nuTipoInformacion a actualizar
	 */
	public void setNuTipoInformacion(Integer nuTipoInformacion) {
		this.nuTipoInformacion = nuTipoInformacion;
	}

	/**
	 * @return el atributo chCveOperacion
	 */
	public String getChCveOperacion() {
		return chCveOperacion;
	}

	/**
	 * @param chCveOperacion parametro chCveOperacion a actualizar
	 */
	public void setChCveOperacion(String chCveOperacion) {
		this.chCveOperacion = chCveOperacion;
	}

	/**
	 * @return el atributo fcNotifLqInfo
	 */
	public Date getFcNotifLqInfo() {
		return fcNotifLqInfo;
	}

	/**
	 * @param fcNotifLqInfo parametro fcNotifLqInfo a actualizar
	 */
	public void setFcNotifLqInfo(Date fcNotifLqInfo) {
		this.fcNotifLqInfo = fcNotifLqInfo;
	}

	
	

	/**
	 * @return el atributo numeroPlan
	 */
	public String getNumeroPlan() {
		return numeroPlan;
	}

	/**
	 * @param numeroPlan parametro numeroPlan a actualizar
	 */
	public void setNumeroPlan(String numeroPlan) {
		this.numeroPlan = numeroPlan;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecaudadoraTV [idTv=");
		builder.append(idTv);
		builder.append(", cvEntidadRecaudadora=");
		builder.append(cvEntidadRecaudadora);
		builder.append(", fcValorpago=");
		builder.append(fcValorpago);
		builder.append(", nrp=");
		builder.append(nrp);
		builder.append(", chPeriodoPago=");
		builder.append(chPeriodoPago);
		builder.append(", chRfcPatron=");
		builder.append(chRfcPatron);
		builder.append(", chSucursal=");
		builder.append(chSucursal);
		builder.append(", cvTipoPago=");
		builder.append(cvTipoPago);
		builder.append(", fcRecepcion=");
		builder.append(fcRecepcion);
		builder.append(", fcValorInstituto=");
		builder.append(fcValorInstituto);
		builder.append(", idArchivo=");
		builder.append(idArchivo);
		builder.append(", cvEstadoTv=");
		builder.append(cvEstadoTv);
		builder.append(", nuMontoPago=");
		builder.append(nuMontoPago);
		builder.append(", fcIndividualizacion=");
		builder.append(fcIndividualizacion);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", idTvSipare=");
		builder.append(idTvSipare);
		builder.append(", nuTipoInformacion=");
		builder.append(nuTipoInformacion);
		builder.append(", chCveOperacion=");
		builder.append(chCveOperacion);
		builder.append(", fcNotifLqInfo=");
		builder.append(fcNotifLqInfo);
		builder.append(", numeroPlan=");
		builder.append(numeroPlan);
		builder.append(", cvActuario=");
		builder.append(cvActuario);
		builder.append("]");
		return builder.toString();
	}

	
}
