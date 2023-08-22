package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contiene la información de una registro del turno. 
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class AdministracionTurno extends TurnoBase {
	
	/**
	 * Serialización de la clase.
	 */
	private static final long serialVersionUID = -1709070110161820812L;
	
	/**
	 * Identificador del turno
	 */
	private Long identificadorTurno;

	/**
	 * Clave Única de Servicio.
	 */
	private String cus;
	
	/**
	 * Fecha y hora de la cita.
	 */
	private Date fechaCitaCus;
	
	/**
	 * Fecha y hora de la cita.
	 */
	private String fechaCitaCusTexto;
	
	/**
	 * Numero de Seguridad Social.
	 */
	private String nss;
	
	/**
	 * Clave Única de Registro de Población.
	 */
	private String curp;
	
	/**
	 * Nombre del cliente.
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno del cliente.
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno del cliente.
	 */
	private String apellidoMaterno;
	
	/**
	 * Correo Electronico del cliente.
	 */
	private String correoElectronico;
	
	/**
	 * Numero celular
	 */
	private String numeroCelular;
	
	/**
	 * Clave del servicio solicitado.
	 */
	private String servicioSolicitado;
	
	/**
	 * Tipo de solicitante.
	 */
	private String solicitante;
	
	/**
	 * Folio de atención 
	 */
	private String folioAtencion;	
	
	/**
	 * Folio de atención 
	 */
	private String folioServicio;
	
	/**
	 * Folio de atención 
	 */
	private List<String> listaServicios;	

	/**
	 * Indiador que determina el tipo de Cita.
	 */
	private Integer indicadorTipoCita;
	
	/**
	 * Indicador para cancelar turno.
	 */
	private Integer cancelar;
	
	/**
	 * diferencia de horas en una sucursal
	 */
	private Integer diferenciaHora;
	
	/**
	 * Obtiene el valor de la propiedad identificadorTurno
	*/
	public Long getIdentificadorTurno() {
		return identificadorTurno;
	}

	/**
	 * Establece el valor de la propiedad identificadorTurno
	 * @return identificadorTurno
	*/
	public void setIdentificadorTurno(Long identificadorTurno) {
		this.identificadorTurno = identificadorTurno;
	}

	/**
	 * Obtiene el valor de la propiedad cus
	*/
	public String getCus() {
		return cus;
	}

	/**
	 * Establece el valor de la propiedad cus
	 * @return cus
	*/
	public void setCus(String cus) {
		this.cus = cus;
	}

	/**
	 * Obtiene el valor de la propiedad fechaCitaCus
	*/
	public Date getFechaCitaCus() {
		return fechaCitaCus;
	}

	/**
	 * Establece el valor de la propiedad fechaCitaCus
	 * @return fechaCitaCus
	*/
	public void setFechaCitaCus(Date fechaCitaCus) {
		this.fechaCitaCus = fechaCitaCus;
	}

	/**
	 * Obtiene el valor de la propiedad fechaCitaCusTexto
	*/
	public String getFechaCitaCusTexto() {
		return fechaCitaCusTexto;
	}

	/**
	 * Establece el valor de la propiedad fechaCitaCusTexto
	 * @return fechaCitaCusTexto
	*/
	public void setFechaCitaCusTexto(String fechaCitaCusTexto) {
		this.fechaCitaCusTexto = fechaCitaCusTexto;
	}

	/**
	 * Obtiene el valor de la propiedad nss
	*/
	public String getNss() {
		return nss;
	}

	/**
	 * Establece el valor de la propiedad nss
	 * @return nss
	*/
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * Obtiene el valor de la propiedad curp
	*/
	public String getCurp() {
		return curp;
	}

	/**
	 * Establece el valor de la propiedad curp
	 * @return curp
	*/
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * Obtiene el valor de la propiedad nombre
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el valor de la propiedad nombre
	 * @return nombre
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el valor de la propiedad apellidoPaterno
	*/
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Establece el valor de la propiedad apellidoPaterno
	 * @return apellidoPaterno
	*/
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtiene el valor de la propiedad apellidoMaterno
	*/
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Establece el valor de la propiedad apellidoMaterno
	 * @return apellidoMaterno
	*/
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtiene el valor de la propiedad correoElectronico
	*/
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Establece el valor de la propiedad correoElectronico
	 * @return correoElectronico
	*/
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Obtiene el valor de la propiedad numeroCelular
	*/
	public String getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * Establece el valor de la propiedad numeroCelular
	 * @return numeroCelular
	*/
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	/**
	 * Obtiene el valor de la propiedad servicioSolicitado
	*/
	public String getServicioSolicitado() {
		return servicioSolicitado;
	}

	/**
	 * Establece el valor de la propiedad servicioSolicitado
	 * @return servicioSolicitado
	*/
	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}

	/**
	 * Obtiene el valor de la propiedad solicitante
	*/
	public String getSolicitante() {
		return solicitante;
	}

	/**
	 * Establece el valor de la propiedad solicitante
	 * @return solicitante
	*/
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	/**
	 * Obtiene el valor de la propiedad folioAtencion
	*/
	public String getFolioAtencion() {
		return folioAtencion;
	}

	/**
	 * Establece el valor de la propiedad folioAtencion
	 * @return folioAtencion
	*/
	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}

	/**
	 * Obtiene el valor de la propiedad folioServicio
	*/
	public String getFolioServicio() {
		return folioServicio;
	}

	/**
	 * Establece el valor de la propiedad folioServicio
	 * @return folioServicio
	*/
	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}

	/**
	 * Obtiene el valor de la propiedad listaServicios
	*/
	public List<String> getListaServicios() {
		return listaServicios;
	}

	/**
	 * Establece el valor de la propiedad listaServicios
	 * @return listaServicios
	*/
	public void setListaServicios(List<String> listaServicios) {
		this.listaServicios = listaServicios;
	}

	/**
	 * Obtiene el valor de la propiedad indicadorTipoCita
	*/
	public Integer getIndicadorTipoCita() {
		return indicadorTipoCita;
	}

	/**
	 * Establece el valor de la propiedad indicadorTipoCita
	 * @return indicadorTipoCita
	*/
	public void setIndicadorTipoCita(Integer indicadorTipoCita) {
		this.indicadorTipoCita = indicadorTipoCita;
	}

	/**
	 * Obtiene el valor de la propiedad cancelar
	*/
	public Integer getCancelar() {
		return cancelar;
	}

	/**
	 * Establece el valor de la propiedad cancelar
	 * @return cancelar
	*/
	public void setCancelar(Integer cancelar) {
		this.cancelar = cancelar;
	}

	/**
	 * Obtiene el valor de la propiedad diferenciaHora
	*/
	public Integer getDiferenciaHora() {
		return diferenciaHora;
	}

	/**
	 * Establece el valor de la propiedad diferenciaHora
	 * @return diferenciaHora
	*/
	public void setDiferenciaHora(Integer diferenciaHora) {
		this.diferenciaHora = diferenciaHora;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
