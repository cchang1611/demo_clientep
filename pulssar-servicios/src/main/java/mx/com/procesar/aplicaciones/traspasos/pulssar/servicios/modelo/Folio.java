package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Representa una Afore, mapeado a la tabla PSER_TR_FOLIO_PULSSAR
 * 
 * @author jmcabrer
 * 
 */
public class Folio implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 9158410388079600432L;

	/**
	 * Identificador
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
	private String descripcion;

	/**
	 * sucursal
	 */
	private String sucursal;

	/**
	 * Nss
	 */
	private String nss;

	/**
	 * CURP
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
	 * Fecha de control
	 */
	private Date fechaControl;

	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * Fecha de llegada
	 */
	private Date fechaLlegada;
	/**
	 * Fecha de llegada
	 */
	private Date fechaCierre;

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
	 *  Constructor default
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param chFolio
	 *  @param nss
	 *  @param curp
	 */
	public Folio() {
	}
	/**
	 *  Constructor findFolioXml
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param chFolio
	 *  @param nss
	 *  @param curp
	 */
	public Folio(Long idFolioPulssar, String chFolio, String nss, String curp) {
		this.idFolioPulssar = idFolioPulssar;
		this.chFolio = chFolio;
		this.nss = nss;
		this.curp = curp;
	}
	/**
	 * @return el atributo idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}

	/**
	 * @param id
	 *            parametro idFolioPulssar a actualizar
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
	 * @return el atributo idUsuarioPulssar
	 */
	public Long getIdUsuarioPulssar() {
		return idUsuarioPulssar;
	}

	/**
	 * @param idUsuarioPulssar
	 *            parametro idUsuarioPulssar a actualizar
	 */
	public void setIdUsuarioPulssar(Long idUsuarioPulssar) {
		this.idUsuarioPulssar = idUsuarioPulssar;
	}

	/**
	 * @return el atributo chFolio
	 */
	public String getChFolio() {
		return chFolio;
	}

	/**
	 * @param chfolio
	 *            parametro chFolio a actualizar
	 */
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal
	 *            parametro sucursal a actualizar
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 *            parametro nss a actualizar
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
	 * @param curp
	 *            parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return el atributo estatus
	 */
	public Long getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 *            parametro estatus a actualizar
	 */
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return el atributo fechaGeneracion
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion
	 *            parametro fechaGeneracion a actualizar
	 */
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	/**
	 * @return el atributo fechaControl
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl
	 *            parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return el atributo folioDetalles
	 */
	public List<FolioDetalle> getFolioDetalles() {
		if (folioDetalles == null) {
			folioDetalles = new ArrayList<>();
		}
		return folioDetalles;
	}

	/**
	 * @return el atributo fechaLlegada
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * @param fechaLlegada parametro fechaLlegada a actualizar
	 */
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * @return el atributo fechaCierre
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	public Date getFechaCierre() {
		return fechaCierre;
	}
	/**
	 * @param fechaCierre parametro fechaCierre a actualizar
	 */
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	/**
	 * @param folioDetalles
	 *            parametro folioDetalles a actualizar
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
	 * Agregar detalle folio
	 *  
	 *  @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
	 *  @param folioDetalle
	 */
	public void addFolioDetalle(FolioDetalle folioDetalle) {
		getFolioDetalles().add(folioDetalle);
		folioDetalle.setFolio(this);
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Folio [idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", idServicio=");
		builder.append(idServicio);
		builder.append(", idUsuarioPulssar=");
		builder.append(idUsuarioPulssar);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", descripcion=");
		builder.append(descripcion);
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
		builder.append("]");
		return builder.toString();
	}

}
