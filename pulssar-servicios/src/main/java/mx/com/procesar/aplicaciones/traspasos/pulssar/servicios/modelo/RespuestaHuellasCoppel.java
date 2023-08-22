package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase encargada del objeto de entrada para el websocket
 * @author DBARBOSA
 *
 */
public class RespuestaHuellasCoppel implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 8316636453593275021L;

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
	 * resultado
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String resultado;
	
	/**
	 * Fecha captura
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String fechaCaptura;
	
	/**
	 * Identificador de dispositivo
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idDevice;
	
	/**
	 * Perfil de adquisicion
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String perfilAdquisicionHuella;
	
	/**
	 * Huellas dactilares
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private EstructuraRespuestaHuellasCoppel huellasDactilares;
	
	/**
	 * mensaje
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mensaje;
	
	/**
	 * Huellas dactilares
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private EntradaBiometricoCoppel data;

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
	 * @return the fechaCaptura
	 */
	public String getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * @return the idDevice
	 */
	public String getIdDevice() {
		return idDevice;
	}

	/**
	 * @param idDevice the idDevice to set
	 */
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	/**
	 * @return the perfilAdquisicionHuella
	 */
	public String getPerfilAdquisicionHuella() {
		return perfilAdquisicionHuella;
	}

	/**
	 * @param perfilAdquisicionHuella the perfilAdquisicionHuella to set
	 */
	public void setPerfilAdquisicionHuella(String perfilAdquisicionHuella) {
		this.perfilAdquisicionHuella = perfilAdquisicionHuella;
	}

	/**
	 * @return the huellasDactilares
	 */
	public EstructuraRespuestaHuellasCoppel getHuellasDactilares() {
		return huellasDactilares;
	}

	/**
	 * @param huellasDactilares the huellasDactilares to set
	 */
	public void setHuellasDactilares(EstructuraRespuestaHuellasCoppel huellasDactilares) {
		this.huellasDactilares = huellasDactilares;
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
	 * @return the data
	 */
	public EntradaBiometricoCoppel getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(EntradaBiometricoCoppel data) {
		this.data = data;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("RespuestaHuellasCoppel [");
		cadena.append(" nss =");
		cadena.append(nss);
		cadena.append(" curp =");
		cadena.append(curp);
		cadena.append(" folioProcesar =");
		cadena.append(folioProcesar);
		cadena.append(" tipoPersona =");
		cadena.append(tipoPersona);
		cadena.append(" resultado =");
		cadena.append(resultado);
		cadena.append(" fechaCaptura =");
		cadena.append(fechaCaptura);
		cadena.append(" idDevice =");
		cadena.append(idDevice);
		cadena.append(" perfilAdquisicionHuella =");
		cadena.append(perfilAdquisicionHuella);
		cadena.append(" huellasDactilares =");
		cadena.append(huellasDactilares != null ? huellasDactilares.toString() : null);
		cadena.append(" mensaje =");
		cadena.append(mensaje);
		cadena.append(" data =");
		cadena.append(data != null ? data.toString() : null);
		cadena.append("]");
		
		return cadena.toString();
	}
}