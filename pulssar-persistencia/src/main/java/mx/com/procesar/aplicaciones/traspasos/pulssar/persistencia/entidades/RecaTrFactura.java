package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Clase de persistencia para la tabla RECA_TR_FACTURA
 * @author ANOSORIO
 *
 */
	@Entity
	@Table(name = "RECA_TR_FACTURA")
	public class RecaTrFactura implements Serializable {

		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = -1094812769340081016L;

		/**
		 * id
		 */
		@EmbeddedId
		private RecaTrFacturaPK id;

		/**
		 * nuJornadaSemanaReducida
		 */
		@Column(name = "NU_JORNADA_SEMANA_REDUCIDA")
		private Integer nuJornadaSemanaReducida;
		/**
		 * nuDiasCotizadosMes
		 */
		@Column(name = "NU_DIAS_COTIZADOS_MES")
		private Integer nuDiasCotizadosMes;
		/**
		 * nuDiasIncapacidadMes
		 */
		@Column(name = "NU_DIAS_INCAPACIDAD_MES")
		private Integer nuDiasIncapacidadMes;
		/**
		 * nuDiasAusentismoMes
		 */
		@Column(name = "NU_DIAS_AUSENTISMO_MES")
		private Integer nuDiasAusentismoMes;
		/**
		 * nuDiasCotizadosBim
		 */
		@Column(name = "NU_DIAS_COTIZADOS_BIM")
		private Integer nuDiasCotizadosBim;
		/**
		 * nuDiasIncapacidadBim
		 */
		@Column(name = "NU_DIAS_INCAPACIDAD_BIM")
		private Integer nuDiasIncapacidadBim;
		/**
		 * nuDiasAusentismoBim
		 */
		@Column(name = "NU_DIAS_AUSENTISMO_BIM")
		private Integer nuDiasAusentismoBim;
		/**
		 * nuCreditoInfonavit
		 */
		@Column(name = "NU_CREDITO_INFONAVIT")
		private Long nuCreditoInfonavit;
		/**
		 * nuUltimoSdiPeriodo
		 */
		@Column(name = "NU_ULTIMO_SDI_PERIODO")
		private Long nuUltimoSdiPeriodo;
		/**
		 * nuTipoTrabajador
		 */
		@Column(name = "NU_TIPO_TRABAJADOR")
		private Integer nuTipoTrabajador;
		/**
		 * chnombreImss
		 */
		@Column(name = "CH_NOMBRE_IMSS")
		private String chnombreImss;
		/**
		 * chRFCTrab
		 */
		@Column(name = "CH_RFC_TRAB")
		private String chRFCTrab;
		/**
		 * fcInicDescuentoInfo
		 */
		@Column(name = "FC_INIC_DESCUENTO_INFO")
		@Temporal(TemporalType.TIMESTAMP)
		private Date fcInicDescuentoInfo;
		/**
		 * nss
		 */
		@Column(name = "NSS")
		private String nss;
		/**
		 * curp
		 */
		@Column(name = "CURP")
		private String curp;
		/**
		 * nuMovimientosPeriodo
		 */
		@Column(name = "NU_MOVIMIENTOS_PERIODO")
		private Integer nuMovimientosPeriodo;
		/**
		 * fcInicioAclaracion
		 */
		@Column(name = "FC_INICIO_ACLARACION")
		@Temporal(TemporalType.TIMESTAMP)
		private Date fcInicioAclaracion;
		/**
		 * fcFinAclaracion
		 */
		@Column(name = "FC_FIN_ACLARACION")
		@Temporal(TemporalType.TIMESTAMP)
		private Date fcFinAclaracion;
		/**
		 * chUsuarioModificador
		 */
		@Column(name = "CH_USUARIO_MODIFICADOR")
		private String chUsuarioModificador;
		/**
		 * fcControl
		 */
		@Column(name = "FC_CONTROL")
		@Temporal(TemporalType.TIMESTAMP)
		private Date fcControl;
		/**
		 * chMunicipio
		 */
		@Column(name = "CH_MUNICIPIO")
		private String chMunicipio;
		/**
		 * fcNotifLqInfo
		 */
		@Column(name = "FC_NOTIF_LQINFO")
		@Temporal(TemporalType.TIMESTAMP)
		private Date fcNotifLqInfo;
		/**
		 * @return el atributo id
		 */
		public RecaTrFacturaPK getId() {
			return id;
		}
		/**
		 * @param id parametro id a actualizar
		 */
		public void setId(RecaTrFacturaPK id) {
			this.id = id;
		}
		/**
		 * @return el atributo nuJornadaSemanaReducida
		 */
		public Integer getNuJornadaSemanaReducida() {
			return nuJornadaSemanaReducida;
		}
		/**
		 * @param nuJornadaSemanaReducida parametro nuJornadaSemanaReducida a actualizar
		 */
		public void setNuJornadaSemanaReducida(Integer nuJornadaSemanaReducida) {
			this.nuJornadaSemanaReducida = nuJornadaSemanaReducida;
		}
		/**
		 * @return el atributo nuDiasCotizadosMes
		 */
		public Integer getNuDiasCotizadosMes() {
			return nuDiasCotizadosMes;
		}
		/**
		 * @param nuDiasCotizadosMes parametro nuDiasCotizadosMes a actualizar
		 */
		public void setNuDiasCotizadosMes(Integer nuDiasCotizadosMes) {
			this.nuDiasCotizadosMes = nuDiasCotizadosMes;
		}
		/**
		 * @return el atributo nuDiasIncapacidadMes
		 */
		public Integer getNuDiasIncapacidadMes() {
			return nuDiasIncapacidadMes;
		}
		/**
		 * @param nuDiasIncapacidadMes parametro nuDiasIncapacidadMes a actualizar
		 */
		public void setNuDiasIncapacidadMes(Integer nuDiasIncapacidadMes) {
			this.nuDiasIncapacidadMes = nuDiasIncapacidadMes;
		}
		/**
		 * @return el atributo nuDiasAusentismoMes
		 */
		public Integer getNuDiasAusentismoMes() {
			return nuDiasAusentismoMes;
		}
		/**
		 * @param nuDiasAusentismoMes parametro nuDiasAusentismoMes a actualizar
		 */
		public void setNuDiasAusentismoMes(Integer nuDiasAusentismoMes) {
			this.nuDiasAusentismoMes = nuDiasAusentismoMes;
		}
		/**
		 * @return el atributo nuDiasCotizadosBim
		 */
		public Integer getNuDiasCotizadosBim() {
			return nuDiasCotizadosBim;
		}
		/**
		 * @param nuDiasCotizadosBim parametro nuDiasCotizadosBim a actualizar
		 */
		public void setNuDiasCotizadosBim(Integer nuDiasCotizadosBim) {
			this.nuDiasCotizadosBim = nuDiasCotizadosBim;
		}
		/**
		 * @return el atributo nuDiasIncapacidadBim
		 */
		public Integer getNuDiasIncapacidadBim() {
			return nuDiasIncapacidadBim;
		}
		/**
		 * @param nuDiasIncapacidadBim parametro nuDiasIncapacidadBim a actualizar
		 */
		public void setNuDiasIncapacidadBim(Integer nuDiasIncapacidadBim) {
			this.nuDiasIncapacidadBim = nuDiasIncapacidadBim;
		}
		/**
		 * @return el atributo nuDiasAusentismoBim
		 */
		public Integer getNuDiasAusentismoBim() {
			return nuDiasAusentismoBim;
		}
		/**
		 * @param nuDiasAusentismoBim parametro nuDiasAusentismoBim a actualizar
		 */
		public void setNuDiasAusentismoBim(Integer nuDiasAusentismoBim) {
			this.nuDiasAusentismoBim = nuDiasAusentismoBim;
		}
		/**
		 * @return el atributo nuCreditoInfonavit
		 */
		public Long getNuCreditoInfonavit() {
			return nuCreditoInfonavit;
		}
		/**
		 * @param nuCreditoInfonavit parametro nuCreditoInfonavit a actualizar
		 */
		public void setNuCreditoInfonavit(Long nuCreditoInfonavit) {
			this.nuCreditoInfonavit = nuCreditoInfonavit;
		}
		/**
		 * @return el atributo nuUltimoSdiPeriodo
		 */
		public Long getNuUltimoSdiPeriodo() {
			return nuUltimoSdiPeriodo;
		}
		/**
		 * @param nuUltimoSdiPeriodo parametro nuUltimoSdiPeriodo a actualizar
		 */
		public void setNuUltimoSdiPeriodo(Long nuUltimoSdiPeriodo) {
			this.nuUltimoSdiPeriodo = nuUltimoSdiPeriodo;
		}
		/**
		 * @return el atributo nuTipoTrabajador
		 */
		public Integer getNuTipoTrabajador() {
			return nuTipoTrabajador;
		}
		/**
		 * @param nuTipoTrabajador parametro nuTipoTrabajador a actualizar
		 */
		public void setNuTipoTrabajador(Integer nuTipoTrabajador) {
			this.nuTipoTrabajador = nuTipoTrabajador;
		}
		/**
		 * @return el atributo chnombreImss
		 */
		public String getChnombreImss() {
			return chnombreImss;
		}
		/**
		 * @param chnombreImss parametro chnombreImss a actualizar
		 */
		public void setChnombreImss(String chnombreImss) {
			this.chnombreImss = chnombreImss;
		}
		/**
		 * @return el atributo chRFCTrab
		 */
		public String getChRFCTrab() {
			return chRFCTrab;
		}
		/**
		 * @param chRFCTrab parametro chRFCTrab a actualizar
		 */
		public void setChRFCTrab(String chRFCTrab) {
			this.chRFCTrab = chRFCTrab;
		}
		/**
		 * @return el atributo fcInicDescuentoInfo
		 */
		public Date getFcInicDescuentoInfo() {
			return fcInicDescuentoInfo;
		}
		/**
		 * @param fcInicDescuentoInfo parametro fcInicDescuentoInfo a actualizar
		 */
		public void setFcInicDescuentoInfo(Date fcInicDescuentoInfo) {
			this.fcInicDescuentoInfo = fcInicDescuentoInfo;
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
		 * @return el atributo curp
		 */
		public String getCurp() {
			return curp;
		}
		/**
		 * @param curp parametro curp a actualizar
		 */
		public void setCurp(String curp) {
			this.curp = curp;
		}
		/**
		 * @return el atributo nuMovimientosPeriodo
		 */
		public Integer getNuMovimientosPeriodo() {
			return nuMovimientosPeriodo;
		}
		/**
		 * @param nuMovimientosPeriodo parametro nuMovimientosPeriodo a actualizar
		 */
		public void setNuMovimientosPeriodo(Integer nuMovimientosPeriodo) {
			this.nuMovimientosPeriodo = nuMovimientosPeriodo;
		}
		/**
		 * @return el atributo fcInicioAclaracion
		 */
		public Date getFcInicioAclaracion() {
			return fcInicioAclaracion;
		}
		/**
		 * @param fcInicioAclaracion parametro fcInicioAclaracion a actualizar
		 */
		public void setFcInicioAclaracion(Date fcInicioAclaracion) {
			this.fcInicioAclaracion = fcInicioAclaracion;
		}
		/**
		 * @return el atributo fcFinAclaracion
		 */
		public Date getFcFinAclaracion() {
			return fcFinAclaracion;
		}
		/**
		 * @param fcFinAclaracion parametro fcFinAclaracion a actualizar
		 */
		public void setFcFinAclaracion(Date fcFinAclaracion) {
			this.fcFinAclaracion = fcFinAclaracion;
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
		 * @return el atributo chMunicipio
		 */
		public String getChMunicipio() {
			return chMunicipio;
		}
		/**
		 * @param chMunicipio parametro chMunicipio a actualizar
		 */
		public void setChMunicipio(String chMunicipio) {
			this.chMunicipio = chMunicipio;
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
		
		/* La documentación de este método se encuentra en la clase o interface que
		 * lo declara  (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
    }

