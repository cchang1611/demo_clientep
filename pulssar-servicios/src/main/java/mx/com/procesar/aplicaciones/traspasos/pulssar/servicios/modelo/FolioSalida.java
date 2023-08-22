package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase que muestra los datos de salida del Folio
 * @author ANOSORIO
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSalida implements Serializable, Comparable<FolioSalida>{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2560298036504020847L;
	
	/**
	 * Identficador
	 */
	private Long idFolioPulssar;
	
	/**
	 * Id servicio
	 */
	private Long idServicio;
	
	/**
	 * usuario PULSSAR
	 */
	private Long idUsuarioPulssar;
	
	/**
	 * Folio
	 */
	private String chFolio;
	
	/**
	 * Descripcion
	 */
	private String descripcionServicio;
	
	/**
	 * sucursal
	 */
	private String sucursal;
	
	/**
	 * Nss
	 */
	private String nss;
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 * Estatus
	 */
	private Long estatus;
	
	/**
	 * Fecha de generacion
	 */
	private Date fechaGeneracion;
	
	/**
	 * Fecha Control
	 */
	private String fechaControl; 
	
	/**
	 *Usuario modificador 
	 */
	private String usuarioModificador;
	
	/**
	 * Fecha de llegada
	 */
	private String fechaLlegada;
	
	/**
	 * Fecha de cierre
	 */
	private String fechaCierre; 
	
    /**
     * Relacion folio Detalle	
     */
	private List<FolioDetalle> folioDetalles;
	
	/**
	 * idFolioPulssarPadre
	 */
	private Long idFolioPulssarPadre;
	
	/**
	 * Estatus Padre
	 */
	private Long estatusPadre;
	
	/**
	 * descripcionestatusPadre
	 */
	private String descripcionestatusPadre;

	/**
	 * FolioHijo
	 */
	private String folioHijo;
	
	
	/**
	 * @return the idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}




	/**
	 * @param idFolioPulssar the idFolioPulssar to set
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}




	/**
	 * @return the idServicio
	 */
	public Long getIdServicio() {
		return idServicio;
	}




	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}




	/**
	 * @return the idUsuarioPulssar
	 */
	public Long getIdUsuarioPulssar() {
		return idUsuarioPulssar;
	}




	/**
	 * @param idUsuarioPulssar the idUsuarioPulssar to set
	 */
	public void setIdUsuarioPulssar(Long idUsuarioPulssar) {
		this.idUsuarioPulssar = idUsuarioPulssar;
	}




	/**
	 * @return the chFolio
	 */
	public String getChFolio() {
		return chFolio;
	}




	/**
	 * @param chFolio the chFolio to set
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}




	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}




	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}




	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}




	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}




	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}




	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}




	/**
	 * @return the estatus
	 */
	public Long getEstatus() {
		return estatus;
	}




	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}




	/**
	 * @return the fechaGeneracion
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}




	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}








	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}




	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}



	/**
	 * @return the folioDetalles
	 */
	public List<FolioDetalle> getFolioDetalles() {
		return folioDetalles;
	}




	/**
	 * @param folioDetalles the folioDetalles to set
	 */
	public void setFolioDetalles(List<FolioDetalle> folioDetalles) {
		this.folioDetalles = folioDetalles;
	}




	/**
	 * @return the idFolioPulssarPadre
	 */
	public Long getIdFolioPulssarPadre() {
		return idFolioPulssarPadre;
	}




	/**
	 * @param idFolioPulssarPadre the idFolioPulssarPadre to set
	 */
	public void setIdFolioPulssarPadre(Long idFolioPulssarPadre) {
		this.idFolioPulssarPadre = idFolioPulssarPadre;
	}




	/**
	 * @return the estatusPadre
	 */
	public Long getEstatusPadre() {
		return estatusPadre;
	}




	/**
	 * @param estatusPadre the estatusPadre to set
	 */
	public void setEstatusPadre(Long estatusPadre) {
		this.estatusPadre = estatusPadre;
	}

	/**
	 * @return the folioHijo
	 */
	public String getFolioHijo() {
		return folioHijo;
	}




	/**
	 * @param folioHijo the folioHijo to set
	 */
	public void setFolioHijo(String folioHijo) {
		this.folioHijo = folioHijo;
	}




	/**
	 * @return the descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param descripcionServicio the descripcionServicio to set
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	/**
	 * @return the descripcionestatusPadre
	 */
	public String getDescripcionestatusPadre() {
		return descripcionestatusPadre;
	}

	/**
	 * @param descripcionestatusPadre the descripcionestatusPadre to set
	 */
	public void setDescripcionestatusPadre(String descripcionestatusPadre) {
		this.descripcionestatusPadre = descripcionestatusPadre;
	}

	/**
	 *  getFechaControl
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public String getFechaControl() {
		return fechaControl;
	}

	/**
	 *  setFechaControl
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaControl
	 */
	public void setFechaControl(String fechaControl) {
		this.fechaControl = fechaControl;
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




	/**
	 * Constructror
	 */
	public FolioSalida() {
		super();
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolioSalida [idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", idUsuarioPulssar=");
		builder.append(idUsuarioPulssar);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", descripcionServicio=");
		builder.append(descripcionServicio);
		builder.append(", sucursal=");
		builder.append(sucursal);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaGeneracion=");
		builder.append(fechaGeneracion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", fechaLlegada=");
		builder.append(fechaLlegada);
		builder.append(", fechaCierre=");
		builder.append(fechaCierre);
		builder.append(", folioDetalles=");
		builder.append(folioDetalles);
		builder.append(", idFolioPulssarPadre=");
		builder.append(idFolioPulssarPadre);
		builder.append(", estatusPadre=");
		builder.append(estatusPadre);
		builder.append(", descripcionestatusPadre=");
		builder.append(descripcionestatusPadre);
		builder.append(", folioHijo=");
		builder.append(folioHijo);
		builder.append("]");
		return builder.toString();
	}

	public int compareTo(FolioSalida fps) {
		if(fechaLlegada.compareTo(fps.getFechaLlegada()) < 0) {
			return -1;
		}else if(fechaLlegada.compareTo(fps.getFechaLlegada()) == 0){
			return 0;
		} else {
			return 1;
		}
	}
	

}