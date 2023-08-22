package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase encargada del objeto de entrada para el websocket
 * @author DBARBOSA
 *
 */
public class EntradaHuella implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -6935849144500048603L;
	
	/**
	 * curp
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curp;
	
	/**
	 * nss
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nss;
	
	/**
	 * Curp empleado
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String curpEmpleado;
	
	/**
	 * tipo
	 */
	private String tipo;
	
	/**
	 * servicio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String servicio;
	
	/**
	 * calidad
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> calidad;
	
	/**
	 * huellas
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String huellas;
	
	/**
	 * uriHuellas
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String uriHuellas;
	
	/**
	 * folio
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String folio;

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
	 * @return the curpEmpleado
	 */
	public String getCurpEmpleado() {
		return curpEmpleado;
	}

	/**
	 * @param curpEmpleado the curpEmpleado to set
	 */
	public void setCurpEmpleado(String curpEmpleado) {
		this.curpEmpleado = curpEmpleado;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * @return the calidad
	 */
	public List<String> getCalidad() {
		return calidad;
	}

	/**
	 * @param calidad the calidad to set
	 */
	public void setCalidad(List<String> calidad) {
		this.calidad = calidad;
	}

	/**
	 * @return the huellas
	 */
	public String getHuellas() {
		return huellas;
	}

	/**
	 * @param huellas the huellas to set
	 */
	public void setHuellas(String huellas) {
		this.huellas = huellas;
	}

	/**
	 * @return the uriHuellas
	 */
	public String getUriHuellas() {
		return uriHuellas;
	}

	/**
	 * @param uriHuellas the uriHuellas to set
	 */
	public void setUriHuellas(String uriHuellas) {
		this.uriHuellas = uriHuellas;
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
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EntradaHuella [");
		cadena.append(" curp =");
		cadena.append(curp);
		cadena.append(" tipo =");
		cadena.append(tipo);
		cadena.append(" servicio =");
		cadena.append(servicio);
		cadena.append(" calidad =");
		cadena.append(calidad);
		cadena.append(" curpEmpleado =");
		cadena.append(curpEmpleado);
		cadena.append(" huellas =");
		cadena.append(huellas);
		cadena.append(" uriHuellas=");
		cadena.append(uriHuellas);
		cadena.append(" folio=");
		cadena.append(folio);
		cadena.append("]");
		
		return cadena.toString();
	}
}