package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase encargada del objeto de entrada para el websocket
 * @author DBARBOSA
 *
 */
public class EntradaBiometricoCoppel implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -500105749688690465L;

	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 * Folio Procesar
	 */
	private String folioProcesar;
	
	/**
	 * Tipo Persona
	 * 1 Enrolador
	 * 2 Empleado
	 * 3 Trabajador
	 */
	private String tipoPersona;
	
	/**
	 * 0: (MD)
	 * 1: (MI)
	 * 2: (Pulgares)
	 * 3:(4-4-2 )
	 * 4: (1 Dedo)
	 */
	private String tipoToma;
	
	/**
	 * id Mano
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String idMano;
	
	/**
	 * Huellas dactilares
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<EstructuraHuellasCoppel> huellasDactilares;

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
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar the folioProcesar to set
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * @return the tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona the tipoPersona to set
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * @return the tipoToma
	 */
	public String getTipoToma() {
		return tipoToma;
	}

	/**
	 * @param tipoToma the tipoToma to set
	 */
	public void setTipoToma(String tipoToma) {
		this.tipoToma = tipoToma;
	}

	/**
	 * @return the idMano
	 */
	public String getIdMano() {
		return idMano;
	}

	/**
	 * @param idMano the idMano to set
	 */
	public void setIdMano(String idMano) {
		this.idMano = idMano;
	}

	/**
	 * @return the huellasDactilares
	 */
	public List<EstructuraHuellasCoppel> getHuellasDactilares() {
		return huellasDactilares;
	}

	/**
	 * @param huellasDactilares the huellasDactilares to set
	 */
	public void setHuellasDactilares(List<EstructuraHuellasCoppel> huellasDactilares) {
		this.huellasDactilares = huellasDactilares;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EntradaBiometricoCoppel [");
		cadena.append(" nss =");
		cadena.append(nss);
		cadena.append(" curp =");
		cadena.append(curp);
		cadena.append(" folioProcesar =");
		cadena.append(folioProcesar);
		cadena.append(" tipoPersona =");
		cadena.append(tipoPersona);
		cadena.append(" tipoToma =");
		cadena.append(tipoToma);
		cadena.append(" idMano =");
		cadena.append(idMano);
		cadena.append(" huellasDactilares =");
		cadena.append(huellasDactilares != null ? huellasDactilares.toString() : null);
		cadena.append("]");
		
		return cadena.toString();
	}
}