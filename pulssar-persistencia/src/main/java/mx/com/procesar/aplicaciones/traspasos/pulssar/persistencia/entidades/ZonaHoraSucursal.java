/**
 * ZonaHoraSucursal.java
 * Fecha de creación: Sep 3, 2020
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ReadOnly;

/**
 * Clase de persistencia para la tabla PSER_TR_ZONA_HOR_SUCURSAL
 * @author Isidro Hernandez Vega (ihernanv@inet.procesar.com.mx)
 */
@Entity
@Table(name = "PSER_TR_ZONA_HOR_SUCURSAL")
@ReadOnly
public class ZonaHoraSucursal implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -6227066173013127351L;
	
	/**
	 *Identificador único de la tabla.
	 */
	@Id
	@Column(name = "ID_ZONA_HOR_SUCURSAL")
	private Long idZonaHoraSuc;

	/**
	 *Identificador de la Sucursal.
	 */
	@Column(name = "CH_CVE_SUCURSAL")
	private String chCveSuc; 

	/**
	 *Nombre del Care.
	 */
	@Column(name = "CH_NOMBRE_CARE")
	private String chNombreCare;

	/**
	 *Municipio donde se encuentra la Sucursal
	 */
	@Column(name = "CH_CVE_MUNICIPIO")
	private String chCveMunicipio;

	/**
	 *Estado donde se encuentra la Sucursal
	 */
	@Column(name = "CH_ENTIDAD_FEDERATIVA")
	private String chCveEntidadFederativa;

	/**
	 *Zona horaria de la Sucursal
	 */
	@Column(name = "CH_ZONA_HORARIA")
	private String zonaHoraria;

	/**
	 *Diferencia de horas a la Zona Central
	 */
	@Column(name = "NU_DIFERENCIA_HORARIA")
	private Integer nuDiferenciaHoras;

	/**
	 *Fecha inicio ajuste en el horario
	 */
	@Column(name = "FC_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcInicioHorario;

	/**
	 *Fecha fin ajuste en el horario
	 */
	@Column(name = "FC_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcFinHorario; 

	/**
	 *Fecha y Hora de Control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;

	/**
	 *Usuario Modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;

	/**
	 * Obtiene el valor de la propiedad idZonaHoraSuc
	*/
	public Long getIdZonaHoraSuc() {
		return idZonaHoraSuc;
	}

	/**
	 * Establece el valor de la propiedad idZonaHoraSuc
	 * @return idZonaHoraSuc
	*/
	public void setIdZonaHoraSuc(Long idZonaHoraSuc) {
		this.idZonaHoraSuc = idZonaHoraSuc;
	}

	/**
	 * Obtiene el valor de la propiedad chCveSuc
	*/
	public String getChCveSuc() {
		return chCveSuc;
	}

	/**
	 * Establece el valor de la propiedad chCveSuc
	 * @return chCveSuc
	*/
	public void setChCveSuc(String chCveSuc) {
		this.chCveSuc = chCveSuc;
	}

	/**
	 * Obtiene el valor de la propiedad chNombreCare
	*/
	public String getChNombreCare() {
		return chNombreCare;
	}

	/**
	 * Establece el valor de la propiedad chNombreCare
	 * @return chNombreCare
	*/
	public void setChNombreCare(String chNombreCare) {
		this.chNombreCare = chNombreCare;
	}

	/**
	 * Obtiene el valor de la propiedad chCveMunicipio
	*/
	public String getChCveMunicipio() {
		return chCveMunicipio;
	}

	/**
	 * Establece el valor de la propiedad chCveMunicipio
	 * @return chCveMunicipio
	*/
	public void setChCveMunicipio(String chCveMunicipio) {
		this.chCveMunicipio = chCveMunicipio;
	}

	/**
	 * Obtiene el valor de la propiedad chCveEntidadFederativa
	*/
	public String getChCveEntidadFederativa() {
		return chCveEntidadFederativa;
	}

	/**
	 * Establece el valor de la propiedad chCveEntidadFederativa
	 * @return chCveEntidadFederativa
	*/
	public void setChCveEntidadFederativa(String chCveEntidadFederativa) {
		this.chCveEntidadFederativa = chCveEntidadFederativa;
	}

	/**
	 * Obtiene el valor de la propiedad zonaHoraria
	*/
	public String getZonaHoraria() {
		return zonaHoraria;
	}

	/**
	 * Establece el valor de la propiedad zonaHoraria
	 * @return zonaHoraria
	*/
	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	/**
	 * Obtiene el valor de la propiedad nuDiferenciaHoras
	*/
	public Integer getNuDiferenciaHoras() {
		return nuDiferenciaHoras;
	}

	/**
	 * Establece el valor de la propiedad nuDiferenciaHoras
	 * @return nuDiferenciaHoras
	*/
	public void setNuDiferenciaHoras(Integer nuDiferenciaHoras) {
		this.nuDiferenciaHoras = nuDiferenciaHoras;
	}

	/**
	 * Obtiene el valor de la propiedad fcInicioHorario
	*/
	public Date getFcInicioHorario() {
		return fcInicioHorario;
	}

	/**
	 * Establece el valor de la propiedad fcInicioHorario
	 * @return fcInicioHorario
	*/
	public void setFcInicioHorario(Date fcInicioHorario) {
		this.fcInicioHorario = fcInicioHorario;
	}

	/**
	 * Obtiene el valor de la propiedad fcFinHorario
	*/
	public Date getFcFinHorario() {
		return fcFinHorario;
	}

	/**
	 * Establece el valor de la propiedad fcFinHorario
	 * @return fcFinHorario
	*/
	public void setFcFinHorario(Date fcFinHorario) {
		this.fcFinHorario = fcFinHorario;
	}

	/**
	 * Obtiene el valor de la propiedad fcControl
	*/
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * Establece el valor de la propiedad fcControl
	 * @return fcControl
	*/
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * Obtiene el valor de la propiedad chUsuarioModificador
	*/
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * Establece el valor de la propiedad chUsuarioModificador
	 * @return chUsuarioModificador
	*/
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZonaHoraSucursal [idZonaHoraSuc=").append(idZonaHoraSuc).append(", chCveSuc=").append(chCveSuc)
				.append(", chNombreCare=").append(chNombreCare).append(", chCveMunicipio=").append(chCveMunicipio)
				.append(", chCveEntidadFederativa=").append(chCveEntidadFederativa).append(", zonaHoraria=")
				.append(zonaHoraria).append(", nuDiferenciaHoras=").append(nuDiferenciaHoras)
				.append(", fcInicioHorario=").append(fcInicioHorario).append(", fcFinHorario=").append(fcFinHorario)
				.append(", fcControl=").append(fcControl).append(", chUsuarioModificador=").append(chUsuarioModificador)
				.append("]");
		return builder.toString();
	}
}