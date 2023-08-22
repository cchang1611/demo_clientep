package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Jan 7, 2020
 */
public class FolioActivo {

	/**
	 * idFolioPulssar
	 */
	private Long idFolioPulssar;
	/**
	 * idServicio
	 */
	private Long idServicio;
	/**
	 * idUsuarioPulssar
	 */
	private Long idUsuarioPulssar;
	/**
	 * chFolio
	 */
	private String chFolio;
	/**
	 * descripcion
	 */
	private String descripcion;
	/**
	 * sucursal
	 */
	private String sucursal;
	/**
	 * nss
	 */
	private String nss;
	/**
	 * curp
	 */
	private String curp;
	/**
	 * estatus
	 */
	private Long estatus;
	/**
	 * fechaGeneracion
	 */
	private Date fechaGeneracion;
	/**
	 * fechaControl
	 */
	private Date fechaControl;
	/**
	 * usuarioModificador
	 */
	private String usuarioModificador;
	/**
	 * fechaLlegada
	 */
	private Date fechaLlegada;
	/**
	 * fechaCierre
	 */
	private Date fechaCierre;
	/**
	 * foliosHijo
	 */
	private List<FolioActivoDetalle> foliosHijo;
	/**
	 * idFolioPulssarPadre
	 */
	private Long idFolioPulssarPadre;
	/**
	 * estatusPadre
	 */
	private Long estatusPadre;
	/**
	 *  getIdFolioPulssar
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}
	/**
	 *  setIdFolioPulssar
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idFolioPulssar
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}
	/**
	 *  getIdServicio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getIdServicio() {
		return idServicio;
	}
	/**
	 *  setIdServicio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idServicio
	 */
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	/**
	 *  getIdUsuarioPulssar
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getIdUsuarioPulssar() {
		return idUsuarioPulssar;
	}
	/**
	 *  setIdUsuarioPulssar
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idUsuarioPulssar
	 */
	public void setIdUsuarioPulssar(Long idUsuarioPulssar) {
		this.idUsuarioPulssar = idUsuarioPulssar;
	}
	/**
	 *  getChFolio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getChFolio() {
		return chFolio;
	}
	/**
	 *  setChFolio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param chFolio
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}
	/**
	 *  getDescripcion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 *  setDescripcion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 *  getSucursal
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 *  setSucursal
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param sucursal
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 *  getNss
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getNss() {
		return nss;
	}
	/**
	 *  setNss
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	/**
	 *  getCurp
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 *  setCurp
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 *  getEstatus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getEstatus() {
		return estatus;
	}
	/**
	 *  setEstatus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param estatus
	 */
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}
	/**
	 *  getFechaGeneracion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	/**
	 *  setFechaGeneracion
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaGeneracion
	 */
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	/**
	 *  getFechaControl
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Date getFechaControl() {
		return fechaControl;
	}
	/**
	 *  setFechaControl
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaControl
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}
	/**
	 *  getUsuarioModificador
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}
	/**
	 *  setUsuarioModificador
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param usuarioModificador
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}
	/**
	 *  getFechaLlegada
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	/**
	 *  setFechaLlegada
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaLlegada
	 */
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	/**
	 *  getFechaCierre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Date getFechaCierre() {
		return fechaCierre;
	}
	/**
	 *  setFechaCierre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaCierre
	 */
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	/**
	 *  getFoliosHijo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public List<FolioActivoDetalle> getFoliosHijo() {
		return foliosHijo;
	}
	/**
	 *  setFoliosHijo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param foliosHijo
	 */
	public void setFoliosHijo(List<FolioActivoDetalle> foliosHijo) {
		this.foliosHijo = foliosHijo;
	}
	/**
	 *  getIdFolioPulssarPadre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getIdFolioPulssarPadre() {
		return idFolioPulssarPadre;
	}
	/**
	 *  setIdFolioPulssarPadre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param idFolioPulssarPadre
	 */
	public void setIdFolioPulssarPadre(Long idFolioPulssarPadre) {
		this.idFolioPulssarPadre = idFolioPulssarPadre;
	}
	/**
	 *  getEstatusPadre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getEstatusPadre() {
		return estatusPadre;
	}
	/**
	 *  setEstatusPadre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param estatusPadre
	 */
	public void setEstatusPadre(Long estatusPadre) {
		this.estatusPadre = estatusPadre;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
