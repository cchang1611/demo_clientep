package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FolioProcesoEstatus implements Serializable, Comparable<FolioProcesoEstatus> {

	/**
	 * serialVersionUID
	 */
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1093392331114624303L;
	
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
	private String fechaLlegada;
	/**
	 * fechaCierre
	 */
	private String fechaCierre;
	/**
	 * folioDetalles
	 */
	private List<FolioDetalle> folioDetalles;
	/**
	 * idFolioPulssarPadre
	 */
	private Long idFolioPulssarPadre;
	/**
	 * estatusPadre
	 */
	private Long estatusPadre;
	/**
	 * statusProceso
	 */
	private Long statusProceso;
	/**
	 * proceso
	 */
	private Long proceso;
	/**
	 * numPaso
	 */
	private Long numPaso;
	
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
	 *  getFolioDetalles
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public List<FolioDetalle> getFolioDetalles() {
		return folioDetalles;
	}

	/**
	 *  setFolioDetalles
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param folioDetalles
	 */
	public void setFolioDetalles(List<FolioDetalle> folioDetalles) {
		this.folioDetalles = folioDetalles;
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

	/**
	 *  getStatusProceso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getStatusProceso() {
		return statusProceso;
	}

	/**
	 *  setStatusProceso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param statusProceso
	 */
	public void setStatusProceso(Long statusProceso) {
		this.statusProceso = statusProceso;
	}

	/**
	 *  getProceso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getProceso() {
		return proceso;
	}

	/**
	 *  setProceso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param proceso
	 */
	public void setProceso(Long proceso) {
		this.proceso = proceso;
	}

	/**
	 *  getNumPaso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public Long getNumPaso() {
		return numPaso;
	}

	/**
	 *  setNumPaso
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param numPaso
	 */
	public void setNumPaso(Long numPaso) {
		this.numPaso = numPaso;
	}

	/**
	 *  getFechaLlegada
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 *  setFechaLlegada
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaLlegada
	 */
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 *  getFechaCierre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getFechaCierre() {
		return fechaCierre;
	}

	/**
	 *  setFechaCierre
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaCierre
	 */
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(FolioProcesoEstatus fps) {
		if(this.numPaso < fps.getNumPaso()) {
			return -1;
		}else if(this.numPaso == fps.getNumPaso()){
			return 0;
		} else {
			return 1;
		}
	}
	
}
