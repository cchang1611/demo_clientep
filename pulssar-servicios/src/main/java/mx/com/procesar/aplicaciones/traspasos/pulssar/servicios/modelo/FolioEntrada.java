package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Objeto de Entrada, Datos request al servicio de folios
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 10/05/2019
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioEntrada implements Serializable {

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	private static final long serialVersionUID = 2613735131576477675L;
	
	/**
	 * Usuario Modificador
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long idUsuario;
	
	/**
	 * Sucursal
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String sucursal;
	
	/**
	 * Folio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folio;
	
	/**
	 * operacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String operacion;
	
	/**
	 * CURP
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	
	/**
	 * NSS
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	
	/**
	 * descripcion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String descripcion;
	
	/**
	 * Servicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String servicio;
	
	/**
	 * Proceso
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String proceso;
	
	/**
	 * identificador del folio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long idFolio;
	
	/**
	 * Estatus del detalle
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long estatus;
	
	/**
	 * resultado de la operacion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String resultado;
	
	/**
	 * Mensaje de salida
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mensaje;
	/**
	 * Tiempo de arribo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String tiempoLlegada;
	
	/**
	 * Constante idFolioPadre
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long idFolioPadre;
	
	/**
	 * Folios a agregar
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> folios;
	/**
	 * folioHijo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folioHijo;
	
	/**
	 * origen
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String origen;	
	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}

	/**
	 * @param idFolio the idFolio to set
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
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
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the tiempoLlegada
	 */
	public String getTiempoLlegada() {
		return tiempoLlegada;
	}

	/**
	 * @param tiempoLlegada the tiempoLlegada to set
	 */
	public void setTiempoLlegada(String tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}

	/**
	 * @return the idFolioPadre
	 */
	public Long getIdFolioPadre() {
		return idFolioPadre;
	}

	/**
	 * @param idFolioPadre the idFolioPadre to set
	 */
	public void setIdFolioPadre(Long idFolioPadre) {
		this.idFolioPadre = idFolioPadre;
	}

	/**
	 * @return the folios
	 */
	public List<String> getFolios() {
		if(null == folios){
			folios = new ArrayList<>();
		}
		return folios;
	}

	/**
	 * @param folios the folios to set
	 */
	public void addFolios(String folios) {
		getFolios().add(folios);
	}

	/**
	 * @return el atributo folioHijo
	 */
	public String getFolioHijo() {
		return folioHijo;
	}

	/**
	 * @param folioHijo parametro folioHijo a actualizar
	 */
	public void setFolioHijo(String folioHijo) {
		this.folioHijo = folioHijo;
	}

	/**
	 * @return el atributo origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen parametro origen a actualizar
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolioEntrada [idUsuario=");
		builder.append(idUsuario);
		builder.append(", sucursal=");
		builder.append(sucursal);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", operacion=");
		builder.append(operacion);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", servicio=");
		builder.append(servicio);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", idFolio=");
		builder.append(idFolio);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", tiempoLlegada=");
		builder.append(tiempoLlegada);
		builder.append(", idFolioPadre=");
		builder.append(idFolioPadre);
		builder.append(", folios=");
		builder.append(folios);
		builder.append(", folioHijo=");
		builder.append(folioHijo);
		builder.append(", origen=");
		builder.append(origen);
		builder.append("]");
		return builder.toString();
	}
	
}